package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductCatalog is a Querydsl query type for ProductCatalog
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductCatalog extends EntityPathBase<ProductCatalog> {

    private static final long serialVersionUID = -366138327L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductCatalog productCatalog = new QProductCatalog("productCatalog");

    public final StringPath brand = createString("brand");

    public final StringPath description = createString("description");

    public final StringPath origin = createString("origin");

    public final SetPath<ProductCategory, QProductCategory> productCategory = this.<ProductCategory, QProductCategory>createSet("productCategory", ProductCategory.class, QProductCategory.class, PathInits.DIRECT2);

    public final NumberPath<Short> productId = createNumber("productId", Short.class);

    public final StringPath productName = createString("productName");

    public final QProductType productType;

    public final SetPath<PromotionDetail, QPromotionDetail> promotionDetail = this.<PromotionDetail, QPromotionDetail>createSet("promotionDetail", PromotionDetail.class, QPromotionDetail.class, PathInits.DIRECT2);

    public final NumberPath<Integer> purchaseCount = createNumber("purchaseCount", Integer.class);

    public final DatePath<java.time.LocalDate> releaseDate = createDate("releaseDate", java.time.LocalDate.class);

    public QProductCatalog(String variable) {
        this(ProductCatalog.class, forVariable(variable), INITS);
    }

    public QProductCatalog(Path<? extends ProductCatalog> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductCatalog(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductCatalog(PathMetadata metadata, PathInits inits) {
        this(ProductCatalog.class, metadata, inits);
    }

    public QProductCatalog(Class<? extends ProductCatalog> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productType = inits.isInitialized("productType") ? new QProductType(forProperty("productType")) : null;
    }

}

