package assignment2;

public class WordleValidator implements GuessValidator {
    private WordList wordList;

    public WordleValidator(WordList wordList){
        this.wordList = wordList;
    }
    @Override
    public boolean isValid(String input, GameConfiguration config){
        if (input.length() != config.getNumPegs()){
            return false;
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                return false;
            }
        }
        if (!wordList.contains(input)) {
            return false;
        }
        return true;

    }
}
