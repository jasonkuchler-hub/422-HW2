package assignment2;

public class GameEngine {
    private GameConfiguration config;
    private SecretGenerator secretGenerator;
    private FeedbackScorer scorer;
    private GuessHistory history;
    private Code secret;
    private boolean testMode;
    private boolean playing;
    java.util.Scanner scanner = new java.util.Scanner(System.in);

    public GameEngine(GameConfiguration config, SecretGenerator secretGenerator,
                      FeedbackScorer scorer, boolean testMode) {
        this.config = config;
        this.secretGenerator = secretGenerator;
        this.scorer = scorer;
        this.testMode = testMode;
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
            if(input.equals("HISTORY")){
                System.out.println(history);
                continue;
            }
            else if(input.length() != config.getNumPegs()){
                System.out.println("Your guess does not match the required length.");
                continue;
            }
            else if(!isValidColors(input)){
                System.out.println("Your guess contains invalid colors.");
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

    private boolean isValidColors(String input) {
        char[] colors = config.getColors();
        for (int i = 0; i < input.length(); i++) {
            boolean found = false;
            for(int j = 0; j < colors.length; j++){
                if (input.charAt(i) == colors[j]){
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}