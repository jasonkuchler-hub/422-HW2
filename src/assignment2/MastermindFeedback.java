package assignment2;

public class MastermindFeedback implements Feedback {
    private final int blackCount;
    private final int whiteCount;
    private final int codeLength;

    public MastermindFeedback(int blackCount, int whiteCount, int codeLength) {
        this.blackCount = blackCount;
        this.whiteCount = whiteCount;
        this.codeLength = codeLength;
    }

    public int getBlackCount() {
        return blackCount;
    }

    public int getWhiteCount() {
        return whiteCount;
    }

    @Override
    public boolean isWinning() {
        return blackCount == codeLength;
    }

    @Override
    public String describe() {
        return blackCount + "B_" + whiteCount + "W";
    }

    @Override
    public String toString() {
        return describe();
    }
}