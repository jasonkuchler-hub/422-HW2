package assignment2;

public class GuessRecord {
    private final Code guess;
    private final Feedback result;

    public GuessRecord(Code guess, Feedback result){
        this.guess = guess;
        this.result = result;
    }

    public Code getGuess(){
        return guess;
    }

    public Feedback getResult(){
        return result;
    }
}
