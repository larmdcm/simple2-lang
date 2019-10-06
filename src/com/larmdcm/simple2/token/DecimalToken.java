package com.larmdcm.simple2.token;

import com.larmdcm.simple2.Token;

public class DecimalToken extends Token {
    public DecimalToken(Object value) {
        super(value);
    }

    @Override
    public boolean isDecimal() {
        return true;
    }

    @Override
    public double getDecimal() {
        return Double.parseDouble(getValue().toString());
    }
}
