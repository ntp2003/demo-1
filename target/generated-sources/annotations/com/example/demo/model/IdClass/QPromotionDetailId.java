package com.example.demo.model.IdClass;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPromotionDetailId is a Querydsl query type for PromotionDetailId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPromotionDetailId extends BeanPath<PromotionDetailId> {

    private static final long serialVersionUID = 1358886655L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPromotionDetailId promotionDetailId = new QPromotionDetailId("promotionDetailId");

    public final com.example.demo.model.QProductCatalog productCatalog;

    public final com.example.demo.model.QPromotion promotion;

    public QPromotionDetailId(String variable) {
        this(PromotionDetailId.class, forVariable(variable), INITS);
    }

    public QPromotionDetailId(Path<? extends PromotionDetailId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPromotionDetailId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPromotionDetailId(PathMetadata metadata, PathInits inits) {
        this(PromotionDetailId.class, metadata, inits);
    }

    public QPromotionDetailId(Class<? extends PromotionDetailId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productCatalog = inits.isInitialized("productCatalog") ? new com.example.demo.model.QProductCatalog(forProperty("productCatalog"), inits.get("productCatalog")) : null;
        this.promotion = inits.isInitialized("promotion") ? new com.example.demo.model.QPromotion(forProperty("promotion")) : null;
    }

}

