package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.LongSupplier;

import org.apache.commons.collections4.IterableUtils;
import org.eclipse.tags.shaded.org.apache.bcel.generic.NEW;
import org.hibernate.query.criteria.JpaSubQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDetail;
import com.example.demo.dto.ProductDetailFeedBack;
import com.example.demo.dto.ProductFilter;
import com.example.demo.dto.ProductSearchItem;
import com.example.demo.dto.ProductView;
import com.example.demo.dto.ProductViewItem;
import com.example.demo.dto.ProductViewMode;
import com.example.demo.dto.PromotionSimple;
import com.example.demo.model.ProductCatalog;
import com.example.demo.model.ProductType;
import com.example.demo.model.Promotion;
import com.example.demo.model.QFeedback;
import com.example.demo.model.QProductCatalog;
import com.example.demo.model.QProductCategory;
import com.example.demo.model.QPromotion;
import com.example.demo.model.QStockDetails;
import com.example.demo.model.StockDetails;
import com.example.demo.repository.FeedbackRepo;
import com.example.demo.repository.ProductCatalogRepo;
import com.example.demo.repository.ProductCategoryRepo;
import com.example.demo.repository.ProductTypeRepo;
import com.example.demo.repository.PromotionRepo;
import com.example.demo.repository.StockDetailsRepo;
import com.google.common.collect.Iterables;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.SubQueryExpression;
import com.querydsl.core.types.SubQueryExpressionImpl;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ProductsViewServiceImpl implements ProductsViewService {
	@Autowired
	JPAQueryFactory jpaQueryFactory;

	@Autowired
	ProductCatalogRepo productCatalogRepo;

	@Autowired
	ProductCategoryRepo productCategoryRepo;

	@Autowired
	ProductTypeRepo productTypeRepo;

	@Autowired
	PromotionRepo promotionRepo;
	
	@Autowired
	FeedbackRepo feedbackRepo;
	
	@Autowired
	StockDetailsRepo stockDetailsRepo;
	
	@Override
	public Optional<Promotion> findCurrentPromotion() {
		QPromotion qPromotion = QPromotion.promotion;
		return promotionRepo
				.findOne((qPromotion.startTime.loe(LocalDate.now())).and(qPromotion.endTime.goe(LocalDate.now())));
	}

	@Override
	public Page<ProductViewItem> findFilteredProduct(ProductFilter productFilter, Pageable pageable) {
		QProductCatalog qProductCatalog = QProductCatalog.productCatalog;
		Optional<Promotion> promotion = findCurrentPromotion();

		BooleanExpression predicate = qProductCatalog.productCategory.isNotEmpty();

		if (productFilter.getColors() != null && productFilter.getColors().size() > 0) {
			predicate = predicate.and(qProductCatalog.productCategory.any().color.in(productFilter.getColors()));
		}
		if (productFilter.getBrands() != null && productFilter.getBrands().size() > 0) {
			predicate = predicate.and(qProductCatalog.brand.in(productFilter.getBrands()));
		}
		if (productFilter.getProductTypes() != null && productFilter.getProductTypes().size() > 0) {
			predicate = predicate.and(qProductCatalog.productType.in(productFilter.getProductTypes().stream()
					.map(i -> ProductType.builder().productTypeId(i).build()).toList()));
		}
		if (productFilter.getMinPrice() != null && productFilter.getMinPrice().isPresent()) {
			predicate = predicate
					.and(qProductCatalog.productCategory.any().price.goe(productFilter.getMinPrice().get()));
		}
		if (productFilter.getMaxPrice() != null && productFilter.getMaxPrice().isPresent()) {
			predicate = predicate
					.and(qProductCatalog.productCategory.any().price.loe(productFilter.getMaxPrice().get()));
		}

		return getFiltered(predicate, pageable)
				.map(i -> promotion.isPresent() ? new ProductViewItem(i, promotion.get()) : new ProductViewItem(i));
	}

	@Override
	public List<com.example.demo.dto.ProductType> productTypes() {
		return productTypeRepo.findAll().stream().map(i -> new com.example.demo.dto.ProductType(i)).toList();
	}

	@Override
	public List<String> colors() {
		return productCategoryRepo.findDistinctColor();
	}

	@Override
	public List<String> brands() {
		return productCatalogRepo.findDistinctBrand();
	}

	private Page<ProductCatalog> getFiltered(Predicate predicate, Pageable pageable) {
		QProductCatalog qProductCatalog = QProductCatalog.productCatalog;

		QProductCategory qProductCategory = QProductCategory.productCategory;
		NumberPath<BigDecimal> min = Expressions.numberPath(BigDecimal.class, "min(pc.price)");

		JPAQuery<ProductCatalog> query = jpaQueryFactory.selectFrom(qProductCatalog).innerJoin(qProductCategory)
				.on(qProductCatalog.productId.eq(qProductCategory.productCatalog.productId)).groupBy(qProductCatalog)
				.where(predicate);

		if (pageable != null) {
			query.offset(pageable.getOffset());
			query.limit(pageable.getPageSize());
			for (Sort.Order o : pageable.getSort()) {
				PathBuilder<Object> orderByExpression = new PathBuilder<Object>(Object.class, "productCatalog");
				Expression expression;
				if (o.getProperty().equals("price"))
					expression = qProductCategory.price.min();
				else
					expression = Expressions.path(Object.class, o.getProperty());

				qProductCategory.price.min();
				query.orderBy(new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC, expression));
			}
		}

		long countQuery = jpaQueryFactory.from(qProductCatalog).where(predicate)
				.select(qProductCatalog.productId.count().as("long")).fetchFirst();

		return PageableExecutionUtils.getPage(query.fetch(), pageable, new LongSupplier() {

			@Override
			public long getAsLong() {
				return countQuery;
			}
		});
	}

	@Override
	public List<ProductSearchItem> findItemBySearch(String searchValue) {
		Optional<Promotion> promotion = findCurrentPromotion();
		QProductCatalog qProductCatalog = QProductCatalog.productCatalog;
		BooleanExpression predicate = (qProductCatalog.productCategory.isNotEmpty())
				.and(qProductCatalog.productName.contains(searchValue));

		return jpaQueryFactory.selectFrom(qProductCatalog).where(predicate).limit(4).fetch().stream()
				.map(i -> promotion.isPresent() ? new ProductSearchItem(i, promotion.get()) : new ProductSearchItem(i))
				.toList();
	}

	@Override
	public List<ProductView> getProductViewMode(ProductViewMode mode) {
		Optional<Promotion> promotion = findCurrentPromotion();
		QProductCatalog qProductCatalog = QProductCatalog.productCatalog;
		List<ProductView> result = new ArrayList<>();
		productTypes().forEach(i -> {
			JPAQuery<ProductCatalog> query = jpaQueryFactory.selectFrom(qProductCatalog);
			ProductView view = new ProductView();
			BooleanExpression predicate = qProductCatalog.productType.productTypeId.eq(i.getProductTypeId()).and(qProductCatalog.productCategory.isNotEmpty());;
			OrderSpecifier orderSpecifier = null;

			view.setProductType(i);
			switch (mode) {
			case BESTSELLER:
				orderSpecifier = new OrderSpecifier<Integer>(Order.DESC, qProductCatalog.purchaseCount);
				break;
			case SALE:
				if (promotion.isPresent()) {
					predicate = predicate.and(qProductCatalog.productId.in(promotion.get().getPromotionDetail().stream()
							.map(p -> p.getPromotionDetailId().getProductCatalog().getProductId()).toList()));
				} else
					throw new IllegalArgumentException("Promotion is not found !!!");
				break;
			case NEWLYRELEASED:
				orderSpecifier = new OrderSpecifier<LocalDate>(Order.DESC, qProductCatalog.releaseDate);
				break;
			default:
				throw new IllegalStateException("Unknown argument value !!!");
			}
			query.where(predicate);
			if (orderSpecifier != null)
				query.orderBy(orderSpecifier);
			query.limit(4);
			view.setProductViewItems(query.fetch().stream().map(
					pi -> promotion.isPresent() ? new ProductViewItem(pi, promotion.get()) : new ProductViewItem(pi))
					.toList());
			result.add(view);
		});

		return result;
	}

	@Override
	public ProductDetail getProductDetailInfo(short productId) {
		Optional<Promotion> promotion = findCurrentPromotion();
		return productCatalogRepo
				.findOne((QProductCatalog.productCatalog.productId.eq(productId))
						.and(QProductCatalog.productCatalog.productCategory.isNotEmpty()))
				.map(i -> new ProductDetail(i, promotion))
				.orElseThrow(() -> new NotFoundException("Product not found !!!"));
	}

	@Override
	public Optional<PromotionSimple> findCurrentPromotionSimple() {
		Optional<Promotion> promotion = findCurrentPromotion();

		if (promotion.isEmpty())
			return Optional.empty();
		return Optional.of(new PromotionSimple(promotion.get()));
	}

	@Override
	public List<ProductView> findSaleProductViews() {
		Optional<Promotion> promotion = findCurrentPromotion();
		QProductCatalog qProductCatalog = QProductCatalog.productCatalog;
		List<ProductView> result = new ArrayList<>();
		productTypes().forEach(i -> {
			JPAQuery<ProductCatalog> query = jpaQueryFactory.selectFrom(qProductCatalog);
			ProductView view = new ProductView();
			BooleanExpression predicate = qProductCatalog.productType.productTypeId.eq(i.getProductTypeId()).and(qProductCatalog.productCategory.isNotEmpty());
			OrderSpecifier orderSpecifier = null;

			view.setProductType(i);
			if (promotion.isPresent()) {
				predicate = predicate.and(qProductCatalog.productId.in(promotion.get().getPromotionDetail().stream()
						.map(p -> p.getPromotionDetailId().getProductCatalog().getProductId()).toList()));
			} else
				throw new IllegalArgumentException("Promotion is not found !!!");

			query.where(predicate);
			if (orderSpecifier != null)
				query.orderBy(orderSpecifier);
			view.setProductViewItems(query.fetch().stream().map(
					pi -> promotion.isPresent() ? new ProductViewItem(pi, promotion.get()) : new ProductViewItem(pi))
					.toList());
			result.add(view);
		});

		return result;
	}

	@Override
	public List<ProductDetailFeedBack> findFeedback(short productId) {
		return IterableUtils.toList(feedbackRepo
				.findAll(QFeedback.feedback.feedbackId.stockDetails
						.in(IterableUtils.toList(stockDetailsRepo.findAll(QStockDetails.stockDetails.productCategory
								.in(IterableUtils.toList(productCategoryRepo.findAll(QProductCategory.productCategory.productCatalog.productId.eq(productId)))))))))
				.stream().map(ProductDetailFeedBack::new).toList();
	}
}
