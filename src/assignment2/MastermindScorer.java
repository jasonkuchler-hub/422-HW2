package assignment2;

public class MastermindScorer implements FeedbackScorer {
    public Feedback score(Code secret, Code guess) {
        if (secret.getLength() != guess.getLength()) {
            throw new IllegalArgumentException("secret and guess must be the same length");
        }
        int blackPegCount = 0;
        int whitePegCount = 0;
        boolean[] secretBool = new boolean[secret.getLength()];
        boolean[] guessBool = new boolean[guess.getLength()];
        for(int i= 0; i < secret.getLength(); i ++){
            if(secret.getChar(i)==guess.getChar(i)){
                blackPegCount++;
                secretBool[i] = true;
                guessBool[i] = true;
            }
        }
        for(int i = 0; i < guess.getLength(); i++){
            if(!guessBool[i]){
                for(int j = 0; j < secret.getLength(); j++){
                    if((!secretBool[j]) &&(guess.getChar(i) == secret.getChar(j)) ){
                        whitePegCount++;
                        secretBool[j] = true;
                        break;
                    }
                }
            }
        }
        return new MastermindFeedback(blackPegCount, whitePegCount, guess.getLength());
    }
}
