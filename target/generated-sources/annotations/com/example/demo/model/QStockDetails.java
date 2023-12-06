package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStockDetails is a Querydsl query type for StockDetails
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStockDetails extends EntityPathBase<StockDetails> {

    private static final long serialVersionUID = -203874805L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStockDetails stockDetails = new QStockDetails("stockDetails");

    public final SetPath<Feedback, QFeedback> feedback = this.<Feedback, QFeedback>createSet("feedback", Feedback.class, QFeedback.class, PathInits.DIRECT2);

    public final SetPath<InvoiceDetail, QInvoiceDetail> invoiceDetail = this.<InvoiceDetail, QInvoiceDetail>createSet("invoiceDetail", InvoiceDetail.class, QInvoiceDetail.class, PathInits.DIRECT2);

    public final QProductCategory productCategory;

    public final SetPath<ProductLotDetails, QProductLotDetails> productLotDetails = this.<ProductLotDetails, QProductLotDetails>createSet("productLotDetails", ProductLotDetails.class, QProductLotDetails.class, PathInits.DIRECT2);

    public final SetPath<ShoppingCart, QShoppingCart> shoppingCart = this.<ShoppingCart, QShoppingCart>createSet("shoppingCart", ShoppingCart.class, QShoppingCart.class, PathInits.DIRECT2);

    public final QSize size;

    public final NumberPath<Integer> stock = createNumber("stock", Integer.class);

    public final NumberPath<Integer> stockInventoryId = createNumber("stockInventoryId", Integer.class);

    public QStockDetails(String variable) {
        this(StockDetails.class, forVariable(variable), INITS);
    }

    public QStockDetails(Path<? extends StockDetails> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStockDetails(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStockDetails(PathMetadata metadata, PathInits inits) {
        this(StockDetails.class, metadata, inits);
    }

    public QStockDetails(Class<? extends StockDetails> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productCategory = inits.isInitialized("productCategory") ? new QProductCategory(forProperty("productCategory"), inits.get("productCategory")) : null;
        this.size = inits.isInitialized("size") ? new QSize(forProperty("size"), inits.get("size")) : null;
    }

}

