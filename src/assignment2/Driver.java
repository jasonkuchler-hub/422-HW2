package assignment2;

public class Driver {
    public static void main(String[] args) {
        // args[0] should be "mastermind" (the game name);
        // args[1], if present, test
        boolean testMode = args.length > 1 && args[1].equalsIgnoreCase("test");
        GameConfiguration config = new GameConfiguration();
        MastermindScorer scorer = new MastermindScorer();
        RandomSecretGenerator secretGenerator = new RandomSecretGenerator();
        MastermindValidator validator = new MastermindValidator();
        GameEngine engine = new GameEngine(config, secretGenerator, scorer, testMode, validator);
        engine.run();
    }
}