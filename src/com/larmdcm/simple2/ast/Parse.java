package com.larmdcm.simple2.ast;

import com.larmdcm.simple2.Lexer;
import com.larmdcm.simple2.Util;
import com.larmdcm.simple2.Token;
import com.larmdcm.simple2.TypeValue;

public class Parse {

    private Lexer lexer;

    private Token currentToken;

    public Parse(String text) {
        this.lexer = new Lexer(text);
         currentToken = lexer.getNextToken();
    }

    private void eat (String type) {
        if (currentToken.getType().equals(type)) {
            currentToken = lexer.getNextToken();
        } else {
            Util.error("类型匹配错误 期望类型:" + type + "@" + lexer.getPosition());
        }
    }

    public AST parse () {
        return expr();
    }

    private AST factor () {
        Token token = currentToken;
        if (token.getType().equals(TypeValue.OPERATOR)) {
            eat(TypeValue.OPERATOR);
            return new UnaryOperator(token,factor());
        } else if (token.getType().equals(TypeValue.INTEGER)) {
            eat(TypeValue.INTEGER);
            return new Integers(token);
        } else if (token.getType().equals(TypeValue.DECIMAL)) {
            eat(TypeValue.DECIMAL);
            return new Decimal(token);
        } else if (token.getType().equals(TypeValue.LPAREM)) {
            eat(TypeValue.LPAREM);
            AST node = expr();
            eat(TypeValue.RPAREM);
            return node;
        }
        return null;
    }

    private AST term () {
        AST node = factor();
        if (currentToken.getType().equals(TypeValue.OPERATOR)) {
            String[] opts = {"*","/"};
            while (Util.inArray(opts,currentToken.getOperator())) {
                Token token = currentToken;
                eat(TypeValue.OPERATOR);
                node = new BinaryOperator(node,token,factor());
            }
        }
        return node;
    }

    public AST expr () {
        AST node = term();
        if (currentToken.getType().equals(TypeValue.OPERATOR)) {
            String[] opts = {"+","-"};

            while (Util.inArray(opts,currentToken.getOperator())) {
                Token token = currentToken;
                eat(TypeValue.OPERATOR);
                node = new BinaryOperator(node,token,term());
            }
        }
        return node;
    }
}
