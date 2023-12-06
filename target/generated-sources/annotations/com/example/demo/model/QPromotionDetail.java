package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPromotionDetail is a Querydsl query type for PromotionDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPromotionDetail extends EntityPathBase<PromotionDetail> {

    private static final long serialVersionUID = 906141365L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPromotionDetail promotionDetail = new QPromotionDetail("promotionDetail");

    public final NumberPath<java.math.BigDecimal> discountRate = createNumber("discountRate", java.math.BigDecimal.class);

    public final QProductCatalog productCatalog;

    public final QPromotion promotion;

    public QPromotionDetail(String variable) {
        this(PromotionDetail.class, forVariable(variable), INITS);
    }

    public QPromotionDetail(Path<? extends PromotionDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPromotionDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPromotionDetail(PathMetadata metadata, PathInits inits) {
        this(PromotionDetail.class, metadata, inits);
    }

    public QPromotionDetail(Class<? extends PromotionDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productCatalog = inits.isInitialized("productCatalog") ? new QProductCatalog(forProperty("productCatalog"), inits.get("productCatalog")) : null;
        this.promotion = inits.isInitialized("promotion") ? new QPromotion(forProperty("promotion")) : null;
    }

}

