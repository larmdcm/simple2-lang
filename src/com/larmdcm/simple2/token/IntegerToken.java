package com.larmdcm.simple2.token;

import com.larmdcm.simple2.Token;

public class IntegerToken extends Token {
    public IntegerToken(Object value) {
        super(value);
    }

    @Override
    public boolean isInteger () {
        return true;
    }

    @Override
    public int getInt () {
        return Integer.valueOf(getValue().toString());
    }

}
