package com.larmdcm.simple2;

import com.larmdcm.simple2.ast.*;
import com.larmdcm.simple2.ast.*;

public class Interpreter extends NodeVisitor {

    private Parse parse;

    public Interpreter(String text) {
        parse = new Parse(text);
        // TODO
    }

    public Object visitBinaryOperator (AST astNode) {
        BinaryOperator node = (BinaryOperator)astNode;

        Object leftVal  = visit(node.getLeft());
        Object rightVal = visit(node.getRight());

        if (leftVal != null && rightVal != null) {
            if (node.getOperator().getOperator().equals("+")) {
                double result = Double.parseDouble(leftVal.toString()) + Double.parseDouble(rightVal.toString());
                return transformValue(result);
            } else if (node.getOperator().getOperator().equals("-")) {
                double result = Double.parseDouble(leftVal.toString()) - Double.parseDouble(rightVal.toString());
                return transformValue(result);
            } else if (node.getOperator().getOperator().equals("*")) {
                double result = Double.parseDouble(leftVal.toString()) * Double.parseDouble(rightVal.toString());
                return transformValue(result);
            } else if (node.getOperator().getOperator().equals("/")) {
                double result = Double.parseDouble(leftVal.toString()) / Double.parseDouble(rightVal.toString());
                return transformValue(result);
            }
        }
        return null;
    }

    private String transformValue (double d) {
        String s = String.valueOf(d);

        if (s.indexOf(".") == -1) {
            return s;
        }
        String[] ss = s.split("\\.");
        String st = ss[1];

        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(0) != '0') {
                return s;
            }
        }
        return ss[0];
    }

    public Object visitUnaryOperator (AST astNode) {
        UnaryOperator node = (UnaryOperator)astNode;
        Object value = visit(node.getExpr());
        if (node.getOperator().getOperator().equals("+")) {
            if (value != null) {
                if (value.toString().indexOf(".") != -1) {
                    return +(double)value;
                }
                return +(int)value;
            }
        } else if (node.getOperator().getOperator().equals("-")) {
            if (value != null) {
                if (value.toString().indexOf(".") != -1) {
                    return -(double)value;
                }
                return -(int)value;
            }
        }
        return null;
    }

    public int visitIntegers (AST astNode) {
        Integers node = (Integers)astNode;
        return node.getValue();
    }

    public double visitDecimal (AST astNode) {
       Decimal node = (Decimal)astNode;
       return node.getValue();
    }

    public Object interpret () {
        return visit(parse.parse());
    }
}
