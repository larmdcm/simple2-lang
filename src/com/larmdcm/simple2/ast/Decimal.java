package com.larmdcm.simple2.ast;

import com.larmdcm.simple2.Token;

public class Decimal extends Number {

    public Decimal(Token token) {
        super(token);
    }

    public Double getValue () {
        return getToken().getDecimal();
    }
}
