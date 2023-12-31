package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShoppingCart is a Querydsl query type for ShoppingCart
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShoppingCart extends EntityPathBase<ShoppingCart> {

    private static final long serialVersionUID = 1004371047L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShoppingCart shoppingCart = new QShoppingCart("shoppingCart");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final com.example.demo.model.IdClass.QShoppingCartId shoppingCartId;

    public QShoppingCart(String variable) {
        this(ShoppingCart.class, forVariable(variable), INITS);
    }

    public QShoppingCart(Path<? extends ShoppingCart> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShoppingCart(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShoppingCart(PathMetadata metadata, PathInits inits) {
        this(ShoppingCart.class, metadata, inits);
    }

    public QShoppingCart(Class<? extends ShoppingCart> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shoppingCartId = inits.isInitialized("shoppingCartId") ? new com.example.demo.model.IdClass.QShoppingCartId(forProperty("shoppingCartId"), inits.get("shoppingCartId")) : null;
    }

}

