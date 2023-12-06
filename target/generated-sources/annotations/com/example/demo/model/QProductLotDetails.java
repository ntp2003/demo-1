package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductLotDetails is a Querydsl query type for ProductLotDetails
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProductLotDetails extends EntityPathBase<ProductLotDetails> {

    private static final long serialVersionUID = 123188129L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductLotDetails productLotDetails = new QProductLotDetails("productLotDetails");

    public final QProductLot productLot;

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final QStockDetails stockDetails;

    public QProductLotDetails(String variable) {
        this(ProductLotDetails.class, forVariable(variable), INITS);
    }

    public QProductLotDetails(Path<? extends ProductLotDetails> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductLotDetails(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductLotDetails(PathMetadata metadata, PathInits inits) {
        this(ProductLotDetails.class, metadata, inits);
    }

    public QProductLotDetails(Class<? extends ProductLotDetails> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productLot = inits.isInitialized("productLot") ? new QProductLot(forProperty("productLot"), inits.get("productLot")) : null;
        this.stockDetails = inits.isInitialized("stockDetails") ? new QStockDetails(forProperty("stockDetails"), inits.get("stockDetails")) : null;
    }

}

