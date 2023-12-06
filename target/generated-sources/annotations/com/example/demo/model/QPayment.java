package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPayment is a Querydsl query type for Payment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPayment extends EntityPathBase<Payment> {

    private static final long serialVersionUID = 1450608359L;

    public static final QPayment payment = new QPayment("payment");

    public final StringPath description = createString("description");

    public final NumberPath<Short> paymentMethod = createNumber("paymentMethod", Short.class);

    public final SetPath<PurchaseInvoice, QPurchaseInvoice> purchaseInvoice = this.<PurchaseInvoice, QPurchaseInvoice>createSet("purchaseInvoice", PurchaseInvoice.class, QPurchaseInvoice.class, PathInits.DIRECT2);

    public QPayment(String variable) {
        super(Payment.class, forVariable(variable));
    }

    public QPayment(Path<? extends Payment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPayment(PathMetadata metadata) {
        super(Payment.class, metadata);
    }

}

