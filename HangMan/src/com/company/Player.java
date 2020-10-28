package com.company;
public class Player {

    private int lives;
    private int score;
    private char guessedLetter;
    private int losses;

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int remainingLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public char getGuessedLetter() {
        return guessedLetter;
    }

    public void setGuessedLetter(char guessedLetter) {
        this.guessedLetter = guessedLetter;
    }

    public void setStartingLives() {
        this.setLives(10);
    }

    public void displayLives(Player player) {
        System.out.println("You have " + this.remainingLives() + " lives remaining.");
    }
}