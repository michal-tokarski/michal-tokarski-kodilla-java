package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();
        double x = 1.5;
        double y = 1.5;
        String finalMessage = "Not passed";

        try {
            System.out.println("Try.........: " + "Either arg x " + "(" + x + ")" + " is >= 2 Or is <1 "
                    + "Or arg y " + "(" + y + ")" + " is = 1.5" );
            String result = secondChallenge.probablyIWillThrowException(x,y);
            finalMessage = result;
        } catch (Exception e) {
            System.out.println("Catch.......: " + "Exception thrown : " + e);
        } finally {
            //System.out.println("FINALLY.....: This line is always shown.");
            System.out.println("Finally.....: " + "Result = " + finalMessage);
        }
    }
}
