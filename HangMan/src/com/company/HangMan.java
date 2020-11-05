package com.company;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
//Islam Mohamed
public class HangMan {

    Player player;
    Words gameWord;
    private final Scanner scanner;
    List<String> alreadyChosen;

    public HangMan()  {
        gameWord = new Words();
        player = new Player();
        scanner = new Scanner(System.in);
        alreadyChosen = new ArrayList<>();
    }

    /**
     * startGame is a method that Initiate the game
     * @author Islam Mohamed
     * @Since 2020/10/27
     * @version 1.0
     */
    public void startGame() {
        System.out.println("*********\n" +
                "  +---+\n" +
                "  |   |\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " / \\  |\n" +
                "      |\n" +
                "*********");
        System.out.println("Welcome to HangMan!" + " Please Enter Your Name?");
        String name = JOptionPane.showInputDialog("Your Name");
        System.out.println("Welcome aboard " + name + ". Please read the Game Rules first\n" +
                "          ****Game Rules****\n" +
                "**You can enter one letter at a time**\n" +
                "**You can enter the whole word if you know it**\n" +
                "**If you try to guess the whole word and fail you will lose**\n" +
                "**You will have 10 tries, use them wisely**\n" +
                "**Now lets have some fun and learn new words**");
        String input = "";
        player.setStartingLives();
        player.setLosses(0);
        player.displayLives(player);
        System.out.println();
        while (true) {
            System.out.println(name + " Do you want to play? Press y to play or n to quit");
            input = scanner.next().toLowerCase();
            if (input.equals("n")) {
                System.out.println("**Ending the game**");
                break;
            }
            else if (input.equals("y")) {
                player.setStartingLives();
                gameWord.setRemaining(1);
                alreadyChosen.clear();
                gameWord.setGameWord(gameWord.getRandomWord());
                System.out.println(name + " Your word is: ");
                gameWord.hideWord();
                System.out.println();
                while (gameWord.getRemaining() > 0 && player.remainingLives() > 0) {
                    System.out.println(name + " Please type a letter, or guess the whole word.");
                    alreadyChosen.add(input);
                    input = scanner.next().toLowerCase();
                    gameWord.setChoiceInWord((gameWord.getGameWord().indexOf(input)) != -1);
                    if (alreadyChosen.contains(input)) {
                        System.out.println(name + " Please type a letter.");
                        System.out.println(gameWord.getSb().toString());
                    }
                    else if (input.length() > 1 && input.equals(gameWord.getGameWord())) {
                        System.out.println("Bravo!" + name + " You guessed the word correctly. You win!");
                        player.setScore(player.getScore() + 1);
                        System.out.println(name + " You have now won " + player.getScore() + " game(s) so far, and you have lost " + player.getLosses() + " game(s) so far.");
                        break;
                    } else if (input.length() > 1) {
                        System.out.println(name + " You guessed the word incorrectly!");
                        player.setLives(0);
                    } else if (gameWord.isChoiceInWord()) {
                        char letter = input.charAt(0);
                        int position;
                        for (position = 0; position < gameWord.getWordLength(gameWord.getGameWord()); position++) {
                            if (gameWord.getGameWord().charAt(position) == letter) {
                                gameWord.getSb().replace(position, position + 1, input);
                                gameWord.setRemaining(gameWord.getRemaining() - 1);
                            }
                        }
                        System.out.println(gameWord.getSb().toString());
                    } else {
                        player.setLives(player.remainingLives() - 1);
                        System.out.print(name + " Unfortunately Your answer was wrong, you lost a life.");
                        System.out.println();
                        System.out.println(gameWord.getSb().toString());
                        player.displayLives(player);
                    }
                    if (player.remainingLives() == 0) {
                        player.setLosses(player.getLosses() + 1);
                        System.out.println(name + " You ran of out lives, you lost!");
                        System.out.println(name + " You have now won " + player.getScore() + " game(s), and you have lost " + player.getLosses() + " game(s).");
                    }
                    if (gameWord.getRemaining() == 0) {
                        player.setScore(player.getScore() + 1);
                        System.out.println(name  + " You guessed all the letters, good job!");
                        System.out.println(name + " You have now won " + player.getScore() + " game(s), and you have lost " + player.getLosses() + " game(s).");
                    }

                }
            } else if (!input.equals("y") || !input.equals("n")) {
                System.out.println(name + " Incorrect input, please follow the instructions given.");
            }
        }
    }
    public static void main(String[] args)
    {
        HangMan newGame = new HangMan();
        newGame.startGame();
    }
}