package org.example;

import java.util.Scanner;

import static java.lang.System.out;

/**
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 ivan pavlov
 */
public class App
{
    Scanner in = new Scanner(System.in);
    public static void main( String[] args )
    {
        App ask = new App();
        App math = new App();
        int gender = ask.gend();
        int alc = ask.drinks();
        int weight = ask.weight();
        int lastdrink = ask.last();

        String legality = math.drive(gender,lastdrink,alc,weight);
        out.println( legality );
    }

    private int gend(){
        out.print("Enter a 1 is you are male or a 2 if you are female: ");
        return in.nextInt();
    }
    private int drinks(){
        out.print("How many ounces of alcohol did you have? ");
        return in.nextInt();
    }
    private int weight(){
        out.print("What is your weight, in pounds? ");
        return in.nextInt();
    }
    private int last(){
        out.print("How many hours has it been since your last drink? ");
        return in.nextInt();
    }
    private String  drive(int gender,int lastdrink,int alc,int weight){
        double x=0;
        if(gender == 1)x=.73;
        else if (gender == 2)x=.66;
        double bac = (alc *5.14 / weight*x)- .015 *lastdrink;
        if (bac<.08)return String.format("Your BAC is %f\n It is legal for you to drive. ",bac);
        else return String.format("Your BAC is %f\n It is not legal for you to drive",bac);
    }
}
