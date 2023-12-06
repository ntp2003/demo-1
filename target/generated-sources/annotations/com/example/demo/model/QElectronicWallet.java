package com.example.demo.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QElectronicWallet is a Querydsl query type for ElectronicWallet
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QElectronicWallet extends EntityPathBase<ElectronicWallet> {

    private static final long serialVersionUID = 64216532L;

    public static final QElectronicWallet electronicWallet = new QElectronicWallet("electronicWallet");

    public final NumberPath<java.math.BigDecimal> balance = createNumber("balance", java.math.BigDecimal.class);

    public final SetPath<CustomerAccount, QCustomerAccount> customerAccount = this.<CustomerAccount, QCustomerAccount>createSet("customerAccount", CustomerAccount.class, QCustomerAccount.class, PathInits.DIRECT2);

    public final StringPath verificationCodes = createString("verificationCodes");

    public final NumberPath<Integer> walletId = createNumber("walletId", Integer.class);

    public QElectronicWallet(String variable) {
        super(ElectronicWallet.class, forVariable(variable));
    }

    public QElectronicWallet(Path<? extends ElectronicWallet> path) {
        super(path.getType(), path.getMetadata());
    }

    public QElectronicWallet(PathMetadata metadata) {
        super(ElectronicWallet.class, metadata);
    }

}

