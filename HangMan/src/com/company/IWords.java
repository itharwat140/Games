package com.company;

public interface IWords {
    public void setRemaining(int remaining);

    public int getRemaining();

    public String getGameWord();

    public void setGameWord(String gameWord);

    public String getRandomWord();

    public void hideWord();

    public void setChoiceInWord(boolean choiceInWord);

    public StringBuilder getSb();

    public boolean isChoiceInWord();

    public int getWordLength(String word);
}
