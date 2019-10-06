package com.larmdcm.simple2;

public abstract class Token {

    private Object value;

    public Token(Object value) {
        this.value = value;
    }

    public boolean isInteger () {
        return false;
    }

    public boolean isDecimal () {
        return false;
    }

    public boolean isString () {
        return false;
    }

    public String getType () {
        String type = Util.getType(this);
        return type.substring(0,type.length() - 5);
    }

    public String getStr (){
        return "";
    }

    public int getInt () {
        return -1;
    }

    public boolean isOperator () {
        return false;
    }

    public String getOperator () {
        return "";
    }

    public double getDecimal () {
        return -1;
    }

    public Object getValue() {
        return value;
    }

    public Token setValue(Object value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "Token{" +
                "value=" + value +
                "type=" + getType() +
                '}';
    }
}
