package com.larmdcm.simple2.ast;

import com.larmdcm.simple2.Util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NodeVisitor {
    public Object visit (AST node) {
        try {
            Class<?> cls = Class.forName(this.getClass().getName());
            Method method = cls.getMethod("visit" + Util.getType(node),AST.class);
            Object object = method.invoke(this,node);
            return object;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
