package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInvoiceDetail is a Querydsl query type for InvoiceDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInvoiceDetail extends EntityPathBase<InvoiceDetail> {

    private static final long serialVersionUID = -1480271361L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInvoiceDetail invoiceDetail = new QInvoiceDetail("invoiceDetail");

    public final NumberPath<java.math.BigDecimal> discount = createNumber("discount", java.math.BigDecimal.class);

    public final com.example.demo.model.IdClass.QInvoiceDetailId invoiceDetailId;

    public final NumberPath<java.math.BigDecimal> originalPrice = createNumber("originalPrice", java.math.BigDecimal.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public QInvoiceDetail(String variable) {
        this(InvoiceDetail.class, forVariable(variable), INITS);
    }

    public QInvoiceDetail(Path<? extends InvoiceDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInvoiceDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInvoiceDetail(PathMetadata metadata, PathInits inits) {
        this(InvoiceDetail.class, metadata, inits);
    }

    public QInvoiceDetail(Class<? extends InvoiceDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.invoiceDetailId = inits.isInitialized("invoiceDetailId") ? new com.example.demo.model.IdClass.QInvoiceDetailId(forProperty("invoiceDetailId"), inits.get("invoiceDetailId")) : null;
    }

}

