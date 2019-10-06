package com.larmdcm.simple2;

import com.larmdcm.simple2.token.*;
import com.sun.deploy.util.StringUtils;
import com.larmdcm.simple2.token.*;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private String text;

    private int position = 0;

    private char currentChar;

    private boolean isEOF = false;

    public Lexer (String text) {
        this.text = text;
        if (text.isEmpty()) {
            Util.error("input text content is empty");
        }
        currentChar = text.charAt(0);
    }

    public Token getNextToken () {
       while (!isEOF) {
            char c = currentChar;
            if (Character.isSpaceChar(c)) {
                skipWihtespace();
                continue;
            }
            if (Character.isDigit(c)) {
                return getNumber();
            }
            if (c == '+'  || c == '-' || c == '*' || c == '/') {
               advance();
               return new OperatorToken(c);
            }
            if (c == '(') {
                advance();
                return new LparemToken(c);
            }
           if (c == ')') {
               advance();
               return new RparemToken(c);
           }
            Util.error(c + " token parse error");
       }
       return new EofToken();
    }

    private Token getNumber () {
        List<String> numbers = new ArrayList<String>();
        String sk;
        while (Character.isDigit(currentChar) && !isEOF) {
            sk = String.valueOf(currentChar);
            numbers.add(sk);
            advance();
            if (currentChar == '.') {
                sk = String.valueOf(currentChar);
                numbers.add(sk);
                advance();
                while (Character.isDigit(currentChar) && !isEOF) {
                    sk = String.valueOf(currentChar);
                    numbers.add(sk);
                    advance();
                }
                return new DecimalToken(StringUtils.join(numbers,""));
            }
        }
        return new IntegerToken(StringUtils.join(numbers,""));
    }

    private void advance () {
        position++;
        if (position >= text.length()) {
            isEOF = true;
        } else {
            currentChar = text.charAt(position);
        }
    }

    private void skipWihtespace () {
        while (!isEOF && Character.isSpaceChar(currentChar)) {
            advance();
        }
    }
    public boolean isEOF() {
        return isEOF;
    }

    public int getPosition() {
        return position;
    }
}
