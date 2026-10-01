package assignment2;

public class GameEngine {
    private final GameConfiguration config;
    private final SecretGenerator secretGenerator;
    private final FeedbackScorer scorer;
    private GuessHistory history;
    private final GuessValidator validator;
    private Code secret;
    private final boolean testMode;
    private boolean playing;
    java.util.Scanner scanner = new java.util.Scanner(System.in);

    public GameEngine(GameConfiguration config, SecretGenerator secretGenerator,
                      FeedbackScorer scorer, boolean testMode, GuessValidator validator) {
        this.config = config;
        this.secretGenerator = secretGenerator;
        this.scorer = scorer;
        this.testMode = testMode;
        this.validator = validator;
        playing = true;
    }

    public void playGame(){
        secret = secretGenerator.generate(config);
        history = new GuessHistory();
        if(testMode){
            System.out.println("The secret code is " + secret);
        }
        while(true){
            System.out.print("Please enter your  guess: ");
            String input = scanner.nextLine();
            input = input.toUpperCase();
            if(input.equals("HISTORY")){
                System.out.println(history);
                continue;
            }
            else if(!validator.isValid(input, config)){
                System.out.println("Your guess is invalid.");
                continue;
            }
            else{
                Code guessCode = new Code(input.toCharArray());
                Feedback feedback = scorer.score(secret, guessCode);
                history.addRecord(guessCode,feedback);
                System.out.println(feedback);
                if (feedback.isWinning()){
                    System.out.println("Congrats!! You guess correctly and won!");
                    break;
                }
                else if (history.getRecords().size() >= config.getNumGuesses()){
                    System.out.println("Unfortunately you are out of guesses. The correct answer was: " + secret);
                    break;
                }
            }
        }
    }

    public void run(){
        while(playing){
            playGame();
            System.out.println("Would you like to play again? Y/N");
            if(scanner.nextLine().equalsIgnoreCase("N")){
                playing = false;
            }
        }
    }
}