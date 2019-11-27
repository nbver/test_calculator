package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomCalculator {



    public static void main(String[] args) throws WrongExpressionFormatException {

        //reading expression from cmd
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String expression="";
        try {
            expression = bf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //checking expression
        ExpressionChecker expressionChecker = new ExpressionChecker(expression);
        if (!expressionChecker.isValid()) throw new WrongExpressionFormatException();

        //calculations
        if (expressionChecker.isArabicNumbers()) {
            System.out.println((int) Math.round(doArabicCalculations(expressionChecker.getNumbers(), expressionChecker.getOperationType())));
        } else {
            int d =(int) Math.round(doRomanCalculations(expressionChecker.getNumbers(), expressionChecker.getOperationType()));
            if (d<0) {
                int positiveRomeNumber = d*(-1);
                System.out.print("-" + convertArabicNumbersToRoman(positiveRomeNumber));
            } else if (d==0){
                System.out.println(d);
            } else {
                System.out.println(convertArabicNumbersToRoman(d));
            }
        }
    }

    private static double doArabicCalculations(String[] numbers, char operationType){
        int firstOperand = Integer.parseInt(numbers[0]);
        int secondOperand = Integer.parseInt(numbers[1]);
        switch(operationType) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '/':
                return firstOperand / secondOperand;
            case '*':
                return firstOperand * secondOperand;
            }
        return 1;
    }

    private static double doRomanCalculations(String[] numbers, char operationType){
        int firstOperand = convertRomeNumbersToArabic(numbers[0]);
        int secondOperand = convertRomeNumbersToArabic(numbers[1]);
        switch(operationType) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '/':
                return firstOperand / secondOperand;
            case '*':
                return firstOperand * secondOperand;
        }

        return 1;
    }

    private static int convertRomeNumbersToArabic(String roman){
        if (roman.equals("I")) return 1;
        if (roman.equals("II")) return 2;
        if (roman.equals("III")) return 3;
        if (roman.equals("IV")) return 4;
        if (roman.equals("V")) return 5;
        if (roman.equals("VI")) return 6;
        if (roman.equals("VII")) return 7;
        if (roman.equals("VIII")) return 8;
        if (roman.equals("IX")) return 9;
        if (roman.equals("X")) return 10;
        return 1;
    }

    public static String convertArabicNumbersToRoman(int input) {
        String s = "";
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }

}
