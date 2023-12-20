package com.example.demo.model.IdClass;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInvoiceDetailId is a Querydsl query type for InvoiceDetailId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QInvoiceDetailId extends BeanPath<InvoiceDetailId> {

    private static final long serialVersionUID = 1889226633L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInvoiceDetailId invoiceDetailId = new QInvoiceDetailId("invoiceDetailId");

    public final com.example.demo.model.QPurchaseInvoice purchaseInvoice;

    public final com.example.demo.model.QStockDetails stockDetails;

    public QInvoiceDetailId(String variable) {
        this(InvoiceDetailId.class, forVariable(variable), INITS);
    }

    public QInvoiceDetailId(Path<? extends InvoiceDetailId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInvoiceDetailId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInvoiceDetailId(PathMetadata metadata, PathInits inits) {
        this(InvoiceDetailId.class, metadata, inits);
    }

    public QInvoiceDetailId(Class<? extends InvoiceDetailId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.purchaseInvoice = inits.isInitialized("purchaseInvoice") ? new com.example.demo.model.QPurchaseInvoice(forProperty("purchaseInvoice"), inits.get("purchaseInvoice")) : null;
        this.stockDetails = inits.isInitialized("stockDetails") ? new com.example.demo.model.QStockDetails(forProperty("stockDetails"), inits.get("stockDetails")) : null;
    }

}

