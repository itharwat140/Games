package com.company;
import java.util.Scanner;
//Islam Mohamed

/** Method used to creat the game and start it
 * @author Islam Mohamed
 * @since 2020-10-27
 * @version 1.0
 */
public class GuessingGame {
    public static void GuessTheNumber() {
        Scanner sc = new Scanner(System.in);
        int num = 1 + (int)(100 * Math.random());
        int tries = 10;
        int i;
        int guess;
        System.out.println("Hello, What is your name?");
        String name = sc.nextLine();
        System.out.println("Welcome aboard! " + name + " I am thinking of a number between 1 and 100\n" +
                "You have 10 tries to guess it, use them wisely");
        for (i = 0; i < tries; i++) {
            System.out.println(name + " Can you guess the number?");
            guess = sc.nextInt();
        if (num == guess) {
            System.out.println("Bravo! " + name + " you guessed the number");
            break;
            }
        else if (num < guess && i != tries - 1) {
            System.out.println(name + " Your Guess is too high!");
        }
        else if (num > guess && i != tries - 1) {
            System.out.println(name + " Your Guess is too low!");
        }
        }
        if (i == tries) {
            System.out.println("Better luck next time! " + name + " you did not guess the number.");
            System.out.println("The number was " + num);
        }
    }
    public static void main(String[] args){
        GuessTheNumber();
    }
}
