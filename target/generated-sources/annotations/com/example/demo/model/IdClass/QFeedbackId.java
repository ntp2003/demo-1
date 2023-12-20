package com.example.demo.model.IdClass;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFeedbackId is a Querydsl query type for FeedbackId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QFeedbackId extends BeanPath<FeedbackId> {

    private static final long serialVersionUID = 757046672L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFeedbackId feedbackId = new QFeedbackId("feedbackId");

    public final com.example.demo.model.QPurchaseHistory purchaseHistory;

    public final com.example.demo.model.QStockDetails stockDetails;

    public QFeedbackId(String variable) {
        this(FeedbackId.class, forVariable(variable), INITS);
    }

    public QFeedbackId(Path<? extends FeedbackId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFeedbackId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFeedbackId(PathMetadata metadata, PathInits inits) {
        this(FeedbackId.class, metadata, inits);
    }

    public QFeedbackId(Class<? extends FeedbackId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.purchaseHistory = inits.isInitialized("purchaseHistory") ? new com.example.demo.model.QPurchaseHistory(forProperty("purchaseHistory"), inits.get("purchaseHistory")) : null;
        this.stockDetails = inits.isInitialized("stockDetails") ? new com.example.demo.model.QStockDetails(forProperty("stockDetails"), inits.get("stockDetails")) : null;
    }

}

