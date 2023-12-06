package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductType is a Querydsl query type for ProductType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductType extends EntityPathBase<ProductType> {

    private static final long serialVersionUID = -1685406422L;

    public static final QProductType productType = new QProductType("productType");

    public final SetPath<ProductCatalog, QProductCatalog> productCatalog = this.<ProductCatalog, QProductCatalog>createSet("productCatalog", ProductCatalog.class, QProductCatalog.class, PathInits.DIRECT2);

    public final NumberPath<Short> productTypeId = createNumber("productTypeId", Short.class);

    public final SetPath<Size, QSize> size = this.<Size, QSize>createSet("size", Size.class, QSize.class, PathInits.DIRECT2);

    public final StringPath typeName = createString("typeName");

    public QProductType(String variable) {
        super(ProductType.class, forVariable(variable));
    }

    public QProductType(Path<? extends ProductType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductType(PathMetadata metadata) {
        super(ProductType.class, metadata);
    }

}

