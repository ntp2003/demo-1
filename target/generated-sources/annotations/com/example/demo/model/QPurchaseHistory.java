package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPurchaseHistory is a Querydsl query type for PurchaseHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPurchaseHistory extends EntityPathBase<PurchaseHistory> {

    private static final long serialVersionUID = 1209854004L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPurchaseHistory purchaseHistory = new QPurchaseHistory("purchaseHistory");

    public final QCustomerAccount customerAccount;

    public final SetPath<Feedback, QFeedback> feedback = this.<Feedback, QFeedback>createSet("feedback", Feedback.class, QFeedback.class, PathInits.DIRECT2);

    public final NumberPath<Integer> purchaseId = createNumber("purchaseId", Integer.class);

    public final QPurchaseInvoice purchaseInvoice;

    public final StringPath status = createString("status");

    public QPurchaseHistory(String variable) {
        this(PurchaseHistory.class, forVariable(variable), INITS);
    }

    public QPurchaseHistory(Path<? extends PurchaseHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPurchaseHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPurchaseHistory(PathMetadata metadata, PathInits inits) {
        this(PurchaseHistory.class, metadata, inits);
    }

    public QPurchaseHistory(Class<? extends PurchaseHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customerAccount = inits.isInitialized("customerAccount") ? new QCustomerAccount(forProperty("customerAccount"), inits.get("customerAccount")) : null;
        this.purchaseInvoice = inits.isInitialized("purchaseInvoice") ? new QPurchaseInvoice(forProperty("purchaseInvoice"), inits.get("purchaseInvoice")) : null;
    }

}

