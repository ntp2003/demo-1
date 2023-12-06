package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSize is a Querydsl query type for Size
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSize extends EntityPathBase<Size> {

    private static final long serialVersionUID = -609116480L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSize size = new QSize("size1");

    public final QProductType productType;

    public final NumberPath<Short> sizeId = createNumber("sizeId", Short.class);

    public final StringPath sizeName = createString("sizeName");

    public final SetPath<StockDetails, QStockDetails> stockDetails = this.<StockDetails, QStockDetails>createSet("stockDetails", StockDetails.class, QStockDetails.class, PathInits.DIRECT2);

    public QSize(String variable) {
        this(Size.class, forVariable(variable), INITS);
    }

    public QSize(Path<? extends Size> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSize(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSize(PathMetadata metadata, PathInits inits) {
        this(Size.class, metadata, inits);
    }

    public QSize(Class<? extends Size> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productType = inits.isInitialized("productType") ? new QProductType(forProperty("productType")) : null;
    }

}

