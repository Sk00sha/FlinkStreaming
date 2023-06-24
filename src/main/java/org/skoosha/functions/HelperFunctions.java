package org.skoosha.functions;

/**
 * Basically a bunch of nonsense
 */
public class HelperFunctions {

    public static String evenOddDecider(int number){
        return decideNumberdivision(number) ? "Even: "+number : "Odd: "+number;
    }

    private static boolean decideNumberdivision(int number){
        return number % 2 == 0;
    }

}
