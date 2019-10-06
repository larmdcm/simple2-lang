package com.larmdcm.simple2.token;

import com.larmdcm.simple2.Token;

public class StringToken extends Token {
    public StringToken(Object value) {
        super(value);
    }

    @Override
    public boolean isString() {
        return true;
    }

    @Override
    public String getStr() {
        return getValue().toString();
    }
}
