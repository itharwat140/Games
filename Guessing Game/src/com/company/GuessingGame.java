package com.company;
//Islam Mohamed
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * This class contains the Game code and running from it
 * @author Islam Mohamed
 * @version 1.0
 */
public class GuessingGame {
    public static final int NUM_RANGE_BTM = 0;
    public static final int NUM_RANGE_TOP = 100;

    private Random randGenerator;
    private int goalNum;
    private Scanner inputReader;

    public static void main(String[] args) {
        GuessingGame playGame = new GuessingGame();
        playGame.setup();
        playGame.play();
    }

    public void setup() {
        randGenerator = new Random();
        inputReader = new Scanner(System.in);
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, What is your name?");
        String name = sc.nextLine();
        System.out.println("Welcome aboard! " + name + " I am thinking of a number between 1 and 100");
        System.out.println(name + " Can you guess the number?");
        boolean gameOver = false;
        startGame();

        while (!gameOver) {
            int guess = getPlayerGuess();

            if (guess > 0) {
                System.out.println(name + " Your Guess is too high!");
                System.out.println();
            } else if (guess < 0) {
                System.out.println(name + " Your Guess is too low!");
                System.out.println();
            } else {
                System.out.println("Bravo! " + name + " you guessed the number");
                gameOver = true;
            }
        }
    }

    public void startGame() {
        goalNum = getRandomNum(NUM_RANGE_BTM, NUM_RANGE_TOP);
    }

    public void shutdown() {
        randGenerator = null;

        inputReader.close();
        inputReader = null;
    }

    public int getPlayerGuess() {
        int playerGuess;

        while (true) {
            try {
                System.out.println("Enter a guess between " + NUM_RANGE_BTM + " and " + NUM_RANGE_TOP);
                System.out.print(">");
                playerGuess = inputReader.nextInt();

                return playerGuess;
            } catch (InputMismatchException e) {
                System.out.println("You must enter a valid number");
                System.out.println();
                continue;
            }
        }
    }
     public int checkGuess(int playerGuess) {
        if (playerGuess > goalNum) {
            return 1;
        } else if (playerGuess < goalNum) {
            return -1;
        } else {
            return 0;
        }
    }
     public int getRandomNum(int lowValue, int highValue) {
        int numRange = highValue - lowValue;
        int randNum;
        randNum = randGenerator.nextInt(numRange + 1) + lowValue;
        return randNum;
    }
}