package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductLot is a Querydsl query type for ProductLot
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductLot extends EntityPathBase<ProductLot> {

    private static final long serialVersionUID = -747112607L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductLot productLot = new QProductLot("productLot");

    public final QAdmin admin;

    public final DatePath<java.time.LocalDate> importDate = createDate("importDate", java.time.LocalDate.class);

    public final NumberPath<Integer> lotId = createNumber("lotId", Integer.class);

    public final SetPath<ProductLotDetails, QProductLotDetails> productLotDetails = this.<ProductLotDetails, QProductLotDetails>createSet("productLotDetails", ProductLotDetails.class, QProductLotDetails.class, PathInits.DIRECT2);

    public QProductLot(String variable) {
        this(ProductLot.class, forVariable(variable), INITS);
    }

    public QProductLot(Path<? extends ProductLot> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductLot(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductLot(PathMetadata metadata, PathInits inits) {
        this(ProductLot.class, metadata, inits);
    }

    public QProductLot(Class<? extends ProductLot> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.admin = inits.isInitialized("admin") ? new QAdmin(forProperty("admin")) : null;
    }

}

