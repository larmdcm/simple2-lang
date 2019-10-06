package com.larmdcm.simple2.token;

import com.larmdcm.simple2.Token;

public class OperatorToken extends Token {
    public OperatorToken(Object value) {
        super(value);
    }

    @Override
    public boolean isOperator() {
        return true;
    }

    @Override
    public String getOperator() {
        return getValue().toString();
    }
}
