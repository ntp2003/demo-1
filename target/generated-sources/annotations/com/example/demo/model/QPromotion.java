package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPromotion is a Querydsl query type for Promotion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPromotion extends EntityPathBase<Promotion> {

    private static final long serialVersionUID = 1752538436L;

    public static final QPromotion promotion = new QPromotion("promotion");

    public final StringPath banner = createString("banner");

    public final DatePath<java.time.LocalDate> endTime = createDate("endTime", java.time.LocalDate.class);

    public final SetPath<PromotionDetail, QPromotionDetail> promotionDetail = this.<PromotionDetail, QPromotionDetail>createSet("promotionDetail", PromotionDetail.class, QPromotionDetail.class, PathInits.DIRECT2);

    public final NumberPath<Integer> promotionId = createNumber("promotionId", Integer.class);

    public final StringPath promotionName = createString("promotionName");

    public final DatePath<java.time.LocalDate> startTime = createDate("startTime", java.time.LocalDate.class);

    public QPromotion(String variable) {
        super(Promotion.class, forVariable(variable));
    }

    public QPromotion(Path<? extends Promotion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPromotion(PathMetadata metadata) {
        super(Promotion.class, metadata);
    }

}

