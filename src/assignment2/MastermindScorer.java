package assignment2;

public class MastermindScorer implements FeedbackScorer {
    public Feedback score(Code secret, Code guess) {
        if (secret.getLength() != guess.getLength()) {
            throw new IllegalArgumentException("secret and guess must be the same length");
        }

        PositionMatcher.MatchType[] results = PositionMatcher.match(secret, guess);

        int blackPegCount = 0;
        int whitePegCount = 0;

        for (PositionMatcher.MatchType result : results) {
            if (result == PositionMatcher.MatchType.EXACT) {
                blackPegCount++;
            } else if (result == PositionMatcher.MatchType.PARTIAL) {
                whitePegCount++;
            }
        }

        return new MastermindFeedback(blackPegCount, whitePegCount, guess.getLength());
    }
}