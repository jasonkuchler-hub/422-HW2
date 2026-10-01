package assignment2;

public class WordleFeedback implements Feedback {
    private final PositionMatcher.MatchType[] results;

    public WordleFeedback(PositionMatcher.MatchType[] results) {
        this.results = results;
    }

    @Override
    public boolean isWinning() {
        for(int i = 0; i < results.length; i++){
            if(!(results[i]==PositionMatcher.MatchType.EXACT)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String describe() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < results.length; i++){
            if (results[i]==PositionMatcher.MatchType.EXACT){
                result.append("C ");
            }
            else if (results[i]==PositionMatcher.MatchType.PARTIAL){
                result.append("P ");
            }
            else{
                result.append("A ");
            }
        }
        return result.toString().trim();
    }

    @Override
    public String toString() {
        return describe();
    }
}