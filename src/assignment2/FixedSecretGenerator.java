package assignment2;

public class FixedSecretGenerator implements SecretGenerator{
    private Code code;
    public FixedSecretGenerator(Code code){
        this.code = code;
    }
    @Override
    public Code generate(GameConfiguration config) {
        return code;
    }
}
