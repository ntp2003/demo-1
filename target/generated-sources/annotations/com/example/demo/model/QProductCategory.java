package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductCategory is a Querydsl query type for ProductCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductCategory extends EntityPathBase<ProductCategory> {

    private static final long serialVersionUID = 1538159342L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductCategory productCategory = new QProductCategory("productCategory");

    public final StringPath color = createString("color");

    public final SetPath<ImageProduct, QImageProduct> imageProduct = this.<ImageProduct, QImageProduct>createSet("imageProduct", ImageProduct.class, QImageProduct.class, PathInits.DIRECT2);

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final QProductCatalog productCatalog;

    public final NumberPath<Integer> productCategoryId = createNumber("productCategoryId", Integer.class);

    public final SetPath<StockDetails, QStockDetails> stockDetails = this.<StockDetails, QStockDetails>createSet("stockDetails", StockDetails.class, QStockDetails.class, PathInits.DIRECT2);

    public QProductCategory(String variable) {
        this(ProductCategory.class, forVariable(variable), INITS);
    }

    public QProductCategory(Path<? extends ProductCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductCategory(PathMetadata metadata, PathInits inits) {
        this(ProductCategory.class, metadata, inits);
    }

    public QProductCategory(Class<? extends ProductCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productCatalog = inits.isInitialized("productCatalog") ? new QProductCatalog(forProperty("productCatalog"), inits.get("productCatalog")) : null;
    }

}

