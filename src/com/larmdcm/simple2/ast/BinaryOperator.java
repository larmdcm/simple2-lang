package com.larmdcm.simple2.ast;

import com.larmdcm.simple2.Token;

public class BinaryOperator extends AST {

    private AST left;

    private Token operator;

    private AST right;

    public BinaryOperator(AST left, Token operator, AST right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public AST getLeft() {
        return left;
    }

    public Token getOperator() {
        return operator;
    }

    public AST getRight() {
        return right;
    }
}
