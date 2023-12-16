package com.example.demo.model.IdClass;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductLotDetailsId is a Querydsl query type for ProductLotDetailsId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QProductLotDetailsId extends BeanPath<ProductLotDetailsId> {

    private static final long serialVersionUID = 2075765035L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductLotDetailsId productLotDetailsId = new QProductLotDetailsId("productLotDetailsId");

    public final com.example.demo.model.QProductLot productLot;

    public final com.example.demo.model.QStockDetails stockDetails;

    public QProductLotDetailsId(String variable) {
        this(ProductLotDetailsId.class, forVariable(variable), INITS);
    }

    public QProductLotDetailsId(Path<? extends ProductLotDetailsId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductLotDetailsId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductLotDetailsId(PathMetadata metadata, PathInits inits) {
        this(ProductLotDetailsId.class, metadata, inits);
    }

    public QProductLotDetailsId(Class<? extends ProductLotDetailsId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productLot = inits.isInitialized("productLot") ? new com.example.demo.model.QProductLot(forProperty("productLot"), inits.get("productLot")) : null;
        this.stockDetails = inits.isInitialized("stockDetails") ? new com.example.demo.model.QStockDetails(forProperty("stockDetails"), inits.get("stockDetails")) : null;
    }

}

