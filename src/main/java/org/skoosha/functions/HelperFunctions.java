package org.skoosha.functions;

public class HelperFunctions {

    public static String evenOddDecider(int number){
        return decideNumberdivision(number) ? "Even: "+number : "Odd: "+number;
    }

    private static boolean decideNumberdivision(int number){
        return number % 2 == 0;
    }

}
