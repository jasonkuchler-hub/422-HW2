package assignment2;

public class GameConfiguration {
    private int numGuesses;
    private int numPegs;
    private char[] colors;
    GameConfiguration(){
        numGuesses = 12;
        numPegs = 4;
        colors = new char[]{'B', 'G', 'O', 'P', 'R', 'Y'};
    }
    GameConfiguration(int numGuesses, int numPegs, char[] colors){
        this.numGuesses = numGuesses;
        this.numPegs = numPegs;
        this.colors = colors.clone();
    }
    public int getNumGuesses(){
        return numGuesses;
    }
    public int getNumPegs(){
        return numPegs;
    }
    public char[] getColors() {
        return colors.clone();
    }
}
