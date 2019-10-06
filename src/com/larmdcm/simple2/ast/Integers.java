package com.larmdcm.simple2.ast;

import com.larmdcm.simple2.Token;

public class Integers extends Number {

    public Integers(Token token) {
        super(token);
    }

    public int getValue () {
        return getToken().getInt();
    }
}
