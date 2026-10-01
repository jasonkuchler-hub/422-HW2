package assignment2;

public class WordleSecretGenerator implements SecretGenerator {
    private WordList wordList;

    public WordleSecretGenerator(WordList wordList) {
        this.wordList = wordList;
    }

    @Override
    public Code generate(GameConfiguration config) {
        String word = wordList.randomWord();
        return new Code(word.toCharArray());
    }
}