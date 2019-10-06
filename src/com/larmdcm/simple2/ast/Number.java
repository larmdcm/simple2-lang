package com.larmdcm.simple2.ast;

import com.larmdcm.simple2.Token;

public class Number extends AST {

    private Token token;

    public Number(Token token) {
        // 数字符号
        this.token = token;
    }

    public Token getToken() {
        return token;
    }
}
