package assignment2;

public class PositionMatcher {

    public enum MatchType {
        EXACT, PARTIAL, NONE
    }

    public static MatchType[] match(Code secret, Code guess) {
        int length = secret.getLength();
        MatchType[] results = new MatchType[length];
        boolean[] secretUsed = new boolean[length];
        boolean[] guessUsed = new boolean[length];

        // Pass 1: exact matches
        for (int i = 0; i < length; i++) {
            if (secret.getChar(i) == guess.getChar(i)) {
                results[i] = MatchType.EXACT;
                secretUsed[i] = true;
                guessUsed[i] = true;
            }
        }

        // Pass 2: partial matches
        for (int i = 0; i < length; i++) {
            if (guessUsed[i]) continue;
            boolean found = false;
            for (int j = 0; j < length; j++) {
                if (!secretUsed[j] && secret.getChar(j) == guess.getChar(i)) {
                    secretUsed[j] = true;
                    found = true;
                    break;
                }
            }
            results[i] = found ? MatchType.PARTIAL : MatchType.NONE;
        }

        return results;
    }
}