package assignment2;

import java.util.Random;

public class RandomSecretGenerator implements SecretGenerator {
    private Random random;

    public RandomSecretGenerator() {
        random = new Random();
    }

    @Override
    public Code generate(GameConfiguration config) {
        char[] colors = config.getColors();
        char[] secret = new char[config.getNumPegs()];

        for(int i = 0; i < secret.length; i++){
            int colorIndex = random.nextInt(colors.length);
            secret[i] = colors[colorIndex];
        }
        return new Code(secret);
    }
}