package calculator;

import java.util.HashSet;
import java.util.Set;

public class ExpressionChecker {

    private Set<String> arabicNumbers = new HashSet<>();
    private Set<String> romeNumbers = new HashSet<>();
    private Set<Character> actions = new HashSet<>();
    private String expression;


    public Set<String> getArabicNumbers() {
        return arabicNumbers;
    }


    public ExpressionChecker(String expression){
        this.expression = expression;

        //initializing sets of valid input data

        for (int i = 1; i<11; i++){
            arabicNumbers.add(i+"");
        }
        romeNumbers.add("I");
        romeNumbers.add("II");
        romeNumbers.add("III");
        romeNumbers.add("IV");
        romeNumbers.add("V");
        romeNumbers.add("VI");
        romeNumbers.add("VIII");
        romeNumbers.add("IX");
        romeNumbers.add("X");

        actions.add('+');
        actions.add('-');
        actions.add('/');
        actions.add('*');



    }



    public boolean isValid(){

        //is expression empty?
        if (expression.equals("")) return false;

        //is there one action character?
        int count = 0;
        for (char c : expression.toCharArray()) {
            if (actions.contains(c)){
                count++;
            }
        }
        if (count!=1) return false;

        //is action in between other symbols?
        if (actions.contains(expression.charAt(0))) return false;
        if (actions.contains(expression.charAt(expression.length()-1))) return false;


        //are numbers of valid type?
        String[] operands = expression.split("[-+*/]");
        if (!((arabicNumbers.contains(operands[0]) && arabicNumbers.contains(operands[1])) || (romeNumbers.contains(operands[0]) && romeNumbers.contains(operands[1])))){
            return false;
        }

        return true;
    }


    public boolean isArabicNumbers(){
        String[] operands = expression.split("[-+*/]");
        if (arabicNumbers.contains(operands[0]) && arabicNumbers.contains(operands[1])){
            return true;
        }

        return false;

    }

    public char getOperationType(){

        for (char c : expression.toCharArray()) {
            if (actions.contains(c)){
                return c;

            }
        }
        return 'c';
    }

    public String[] getNumbers(){
        return expression.split("[-+*/]");
    }
}
