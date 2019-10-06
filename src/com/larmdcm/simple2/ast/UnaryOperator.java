package com.larmdcm.simple2.ast;

import com.larmdcm.simple2.Token;

public class UnaryOperator extends AST {
    private Token token;

    private Token operator;

    private AST expr;

    public UnaryOperator(Token operator,AST expr) {
        this.token = this.operator = operator;
        this.expr = expr;
    }

    public Token getToken() {
        return token;
    }

    public Token getOperator() {
        return operator;
    }

    public AST getExpr() {
        return expr;
    }
}
