package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QImageProduct is a Querydsl query type for ImageProduct
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QImageProduct extends EntityPathBase<ImageProduct> {

    private static final long serialVersionUID = -1423761709L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QImageProduct imageProduct = new QImageProduct("imageProduct");

    public final StringPath image = createString("image");

    public final NumberPath<Integer> imageId = createNumber("imageId", Integer.class);

    public final QProductCategory productCategory;

    public QImageProduct(String variable) {
        this(ImageProduct.class, forVariable(variable), INITS);
    }

    public QImageProduct(Path<? extends ImageProduct> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QImageProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QImageProduct(PathMetadata metadata, PathInits inits) {
        this(ImageProduct.class, metadata, inits);
    }

    public QImageProduct(Class<? extends ImageProduct> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productCategory = inits.isInitialized("productCategory") ? new QProductCategory(forProperty("productCategory"), inits.get("productCategory")) : null;
    }

}

