package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPurchaseInvoice is a Querydsl query type for PurchaseInvoice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPurchaseInvoice extends EntityPathBase<PurchaseInvoice> {

    private static final long serialVersionUID = -2051848499L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPurchaseInvoice purchaseInvoice = new QPurchaseInvoice("purchaseInvoice");

    public final StringPath address = createString("address");

    public final DateTimePath<java.time.LocalDateTime> completedTime = createDateTime("completedTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> createdTime = createDateTime("createdTime", java.time.LocalDateTime.class);

    public final NumberPath<java.math.BigDecimal> discount = createNumber("discount", java.math.BigDecimal.class);

    public final SetPath<InvoiceDetail, QInvoiceDetail> invoiceDetail = this.<InvoiceDetail, QInvoiceDetail>createSet("invoiceDetail", InvoiceDetail.class, QInvoiceDetail.class, PathInits.DIRECT2);

    public final NumberPath<Integer> invoiceId = createNumber("invoiceId", Integer.class);

    public final NumberPath<java.math.BigDecimal> originalPrice = createNumber("originalPrice", java.math.BigDecimal.class);

    public final QPayment payment;

    public final StringPath phoneNumber = createString("phoneNumber");

    public final SetPath<PurchaseHistory, QPurchaseHistory> purchaseHistory = this.<PurchaseHistory, QPurchaseHistory>createSet("purchaseHistory", PurchaseHistory.class, QPurchaseHistory.class, PathInits.DIRECT2);

    public final NumberPath<java.math.BigDecimal> shippingFee = createNumber("shippingFee", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public QPurchaseInvoice(String variable) {
        this(PurchaseInvoice.class, forVariable(variable), INITS);
    }

    public QPurchaseInvoice(Path<? extends PurchaseInvoice> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPurchaseInvoice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPurchaseInvoice(PathMetadata metadata, PathInits inits) {
        this(PurchaseInvoice.class, metadata, inits);
    }

    public QPurchaseInvoice(Class<? extends PurchaseInvoice> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.payment = inits.isInitialized("payment") ? new QPayment(forProperty("payment")) : null;
    }

}

