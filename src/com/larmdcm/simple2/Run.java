package com.larmdcm.simple2;

import java.util.Scanner;

public class Run {
    public static void main (String args[]) {
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");

        while (true) {
            System.out.print("simple2>>>");
            String text = scan.next();
            if (text.equals("exit")) {
                break;
            }
            try {
                Interpreter interpreter = new Interpreter(text);
                System.out.println(interpreter.interpret());
            } catch (Exception e) {
                System.out.println("ScriptRunError throw errormsg:" + e.getMessage());
                continue;
            }
        }
    }
}
