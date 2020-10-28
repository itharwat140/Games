package com.company;

import java.util.Random;

public class Words {

    private String[] wordBank ={"ability", "able", "basically", "bank", "candidate", "capacity", "defensive", "democracy", "elite", "else", "favorite", "feel", "gifted", "global", "height", "hello", "illegal", "ignore",
            "job", "join", "key", "kick", "language", "lap", "machine", "mad", "native", "natural", "occasionally", "occupation", "painting", "pair", "quality", "quarter", "race", "range", "salt", "same", "tactic", "table",
            "unusual", "up", "upon", "upper", "urban", "volunteer", "vote", "voter", "vulnerable", "woman", "wonder", "wonderful", "wood", "word", "young", "your", "yours", "yourself", "youth" , "wrap", "write", "writer",
            "writing", "wrong"};
    private String gameWord;
    private int length;
    private int remaining;
    private int position;
    private boolean choiceInWord;
    private int numberOfGuessedLetters;
    private String hiddenWord;
    private StringBuilder sb;

    public StringBuilder getSb() {
        return sb;
    }

    public void setSb(StringBuilder sb) {
        this.sb = sb;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public int getNumberOfGuessedLetters() {
        return numberOfGuessedLetters;
    }

    public void setNumberOfGuessedLetters(int numberOfGuessedLetters) {
        this.numberOfGuessedLetters = numberOfGuessedLetters;
    }

    public String[] getWordBank() {
        return wordBank;
    }

    public void setWordBank(String[] wordBank) {
        this.wordBank = wordBank;
    }

    public String getGameWord() {
        return gameWord;
    }

    public void setGameWord(String gameWord) {
        this.gameWord = gameWord;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isChoiceInWord() {
        return choiceInWord;
    }

    public void setChoiceInWord(boolean choiceInWord) {
        this.choiceInWord = choiceInWord;
    }

    public int getWordLength(String word) {
        length = gameWord.length();
        return length;
    }

    public void hideWord() {
        length = getWordLength(gameWord);
        this.setRemaining(getWordLength(gameWord));
        this.setHiddenWord("");
        for (position = 0; position < length; position++) {
            this.setHiddenWord(this.getHiddenWord() + "-");

        }
        System.out.print(this.getHiddenWord());
        sb = new StringBuilder(this.getHiddenWord());

    }

    public String getRandomWord() {
        int r = new Random().nextInt(wordBank.length);
        String random = (wordBank[r]);
        return random;
    }
}