package assignment2;

public class WordleScorer implements FeedbackScorer {
    public Feedback score(Code secret, Code guess) {
        if (secret.getLength() != guess.getLength()) {
            throw new IllegalArgumentException("secret and guess must be the same length");
        }

        PositionMatcher.MatchType[] results = PositionMatcher.match(secret, guess);

        return (new WordleFeedback(results));
    }
}