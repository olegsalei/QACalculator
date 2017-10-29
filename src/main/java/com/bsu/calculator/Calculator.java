package com.bsu.calculator;

import java.io.IOException;
import java.util.Stack;

public class Calculator {

    static private boolean IsDelimeter(Character c) {
        if ((" =".indexOf(c) != -1))
            return true;
        return false;
    }

    static private boolean IsOperator(Character с) {
        if (("+-/*()".indexOf(с) != -1))
            return true;
        return false;
    }

    static private byte GetPriority(Character s) {
        switch (s) {
            case '(':
                return 0;
            case ')':
                return 1;
            case '+':
                return 2;
            case '-':
                return 3;
            case '*':
                return 4;
            case '/':
                return 4;
            default:
                return 5;
        }
    }

    static private String GetExpression(String input){
        String output = "";
        Stack<Character> operStack = new Stack<Character>();

        for (int i = 0; i < input.length(); i++) {
            if (IsDelimeter(input.charAt(i)))
                continue;

            if (Character.isDigit(input.charAt(i))) {
                while (!IsDelimeter(input.charAt(i)) && !IsOperator(input.charAt(i))) {
                    output += input.charAt(i);
                    i++;
                    if (i == input.length()) break;
                }
                output += " ";
                i--;
            }

            if (IsOperator(input.charAt(i))) {

                if (input.charAt(i) == '(') {
                    operStack.push(input.charAt(i));
                }
                else if (input.charAt(i) == ')') {
                    Character s = operStack.pop();
                    while (s != '(') {
                        output += s.toString() + ' ';
                        s = operStack.pop();
                    }
                } else
                {
                    if (operStack.size() > 0)
                        if (GetPriority(input.charAt(i)) <= GetPriority(operStack.peek())) {
                            output += operStack.pop().toString() + " ";
                        }
                    operStack.push((Character) input.charAt(i));
                }
            }
            if (!Character.isDigit(input.charAt(i)) && !IsOperator(input.charAt(i)) && !IsDelimeter(input.charAt(i))) throw new IllegalArgumentException("Input contains illegal symbols");
        }

        while (operStack.size() > 0)
            output += operStack.pop() + " ";

        return output;
    }

    static private double Counting(String input) {
        double result = 0;
        Stack<Double> temp = new Stack<Double>();

        for (int i = 0; i < input.length(); i++)
        {
            if (Character.isDigit(input.charAt(i))) {
                String a = "";

                while (!IsDelimeter(input.charAt(i)) && !IsOperator(input.charAt(i)))
                {
                    a += input.charAt(i);
                    i++;
                    if (i == input.length()) break;
                }
                temp.push(Double.parseDouble(a));
                i--;
            } else if (IsOperator(input.charAt(i)))
            {
                Double a = temp.pop();
                Double b = temp.pop();

                switch (input.charAt(i))
                {
                    case '+':
                        result = b + a;
                        break;
                    case '-':
                        result = b - a;
                        break;
                    case '*':
                        result = b * a;
                        break;
                    case '/':
                        if(a!=0) result = b / a;
                        else throw new IllegalArgumentException("Zero Division Exception");;
                        break;
                }
                temp.push(result);
            }
        }
        return temp.peek();
    }


    static public double Calculate(String input) {
        String output = GetExpression(input);
        double result = Counting(output);
        return result;
    }

}
