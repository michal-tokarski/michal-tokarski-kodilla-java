package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {

        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();
        double a = 3;
        double b = 0;
        String finalMessage = "N/A";

        try {
            System.out.println("Try.........: " + "Operation = " + a + "/" + b );
            double result = firstChallenge.divide(a, b);
            finalMessage = String.valueOf(result);
        } catch (ArithmeticException e) {
            System.out.println("Catch.......: " + "Exception = Division by 0 is not allowed : " + e);
        } finally {
            //System.out.println("FINALLY.....: This line is always shown.");
            System.out.println("Finally.....: " + "Result = " + finalMessage);
        }
    }
}
