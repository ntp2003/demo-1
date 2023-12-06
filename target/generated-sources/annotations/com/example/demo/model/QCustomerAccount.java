package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCustomerAccount is a Querydsl query type for CustomerAccount
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCustomerAccount extends EntityPathBase<CustomerAccount> {

    private static final long serialVersionUID = 1547604048L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCustomerAccount customerAccount = new QCustomerAccount("customerAccount");

    public final NumberPath<Integer> accountId = createNumber("accountId", Integer.class);

    public final StringPath address = createString("address");

    public final StringPath avatar = createString("avatar");

    public final DatePath<java.time.LocalDate> birthDate = createDate("birthDate", java.time.LocalDate.class);

    public final StringPath customerName = createString("customerName");

    public final QElectronicWallet electronicWallet;

    public final StringPath email = createString("email");

    public final SetPath<LoginHistory, QLoginHistory> loginHistory = this.<LoginHistory, QLoginHistory>createSet("loginHistory", LoginHistory.class, QLoginHistory.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final SetPath<PurchaseHistory, QPurchaseHistory> purchaseHistory = this.<PurchaseHistory, QPurchaseHistory>createSet("purchaseHistory", PurchaseHistory.class, QPurchaseHistory.class, PathInits.DIRECT2);

    public final SetPath<ShoppingCart, QShoppingCart> shoppingCart = this.<ShoppingCart, QShoppingCart>createSet("shoppingCart", ShoppingCart.class, QShoppingCart.class, PathInits.DIRECT2);

    public QCustomerAccount(String variable) {
        this(CustomerAccount.class, forVariable(variable), INITS);
    }

    public QCustomerAccount(Path<? extends CustomerAccount> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCustomerAccount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCustomerAccount(PathMetadata metadata, PathInits inits) {
        this(CustomerAccount.class, metadata, inits);
    }

    public QCustomerAccount(Class<? extends CustomerAccount> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.electronicWallet = inits.isInitialized("electronicWallet") ? new QElectronicWallet(forProperty("electronicWallet")) : null;
    }

}

