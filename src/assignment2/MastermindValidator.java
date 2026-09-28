package assignment2;

public class MastermindValidator implements GuessValidator {
    @Override
    public boolean isValid(String input, GameConfiguration config) {
        if (input.length() != config.getNumPegs()){
            return false;
        }
        char[] colors = config.getColors();
        for (int i = 0; i < input.length(); i++) {
            boolean found = false;
            for (char color : colors) {
                if (input.charAt(i) == color) {
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