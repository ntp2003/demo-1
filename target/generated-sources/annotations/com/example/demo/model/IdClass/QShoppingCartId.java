package com.example.demo.model.IdClass;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShoppingCartId is a Querydsl query type for ShoppingCartId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QShoppingCartId extends BeanPath<ShoppingCartId> {

    private static final long serialVersionUID = 1416976883L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShoppingCartId shoppingCartId = new QShoppingCartId("shoppingCartId");

    public final com.example.demo.model.QCustomerAccount customerAccount;

    public final com.example.demo.model.QStockDetails stockDetails;

    public QShoppingCartId(String variable) {
        this(ShoppingCartId.class, forVariable(variable), INITS);
    }

    public QShoppingCartId(Path<? extends ShoppingCartId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShoppingCartId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShoppingCartId(PathMetadata metadata, PathInits inits) {
        this(ShoppingCartId.class, metadata, inits);
    }

    public QShoppingCartId(Class<? extends ShoppingCartId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customerAccount = inits.isInitialized("customerAccount") ? new com.example.demo.model.QCustomerAccount(forProperty("customerAccount"), inits.get("customerAccount")) : null;
        this.stockDetails = inits.isInitialized("stockDetails") ? new com.example.demo.model.QStockDetails(forProperty("stockDetails"), inits.get("stockDetails")) : null;
    }

}

