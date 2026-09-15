package assignment2;

public interface FeedbackScorer {
    Feedback score(Code secret, Code guess);
}