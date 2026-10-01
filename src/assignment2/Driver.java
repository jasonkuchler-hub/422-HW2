package assignment2;

public class Driver {
    public static void main(String[] args) {
        // args[0] should be "mastermind" or "wordle"
        // args[1], if present, test

        String gameName = args[0];
        boolean testMode = args.length > 1 && args[1].equalsIgnoreCase("test");

        if (gameName.equalsIgnoreCase("mastermind")) {
            GameConfiguration config = new GameConfiguration();
            MastermindScorer scorer = new MastermindScorer();
            RandomSecretGenerator secretGenerator = new RandomSecretGenerator();
            MastermindValidator validator = new MastermindValidator();
            GameEngine engine = new GameEngine(config, secretGenerator, scorer, testMode, validator);
            engine.run();
        }
        else if (gameName.equalsIgnoreCase("wordle")) {
            char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
                    'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
            GameConfiguration config = new GameConfiguration(6, 5, alphabet);
            WordList wordList = new WordList("data/wordlist.txt");
            WordleScorer scorer = new WordleScorer();
            WordleSecretGenerator secretGenerator = new WordleSecretGenerator(wordList);
            WordleValidator validator = new WordleValidator(wordList);
            GameEngine engine = new GameEngine(config, secretGenerator, scorer, testMode, validator);
            engine.run();
        }
        else {
            System.out.println("Unknown game: " + gameName);
        }
    }
}