package com.bsu.calculator;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System. in);
        while (true)
        {
            System.out.println("Введите выражение: ");
            String input = scanner.nextLine();
            System.out.println(Calculator.Calculate(input));
        }
    }
}
