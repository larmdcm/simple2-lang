package com.larmdcm.simple2;

public class Util {

    public static String getType (Object object) {
        String typeName=object.getClass().getName();
        int length= typeName.lastIndexOf(".");
        String type =typeName.substring(length + 1);
        return type;
    }

    public static void error (String message) {
        throw new ScriptException(message);
    }

    public static void error () {
        throw new ScriptException("script parse error");
    }

    public static boolean inArray (char[] items,char c) {
        for (char item : items) {
            if (item == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean inArray (String[] items,String s) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(s)) {
                return true;
            }
        }
        return false;
    }
}
