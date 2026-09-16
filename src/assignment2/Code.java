package assignment2;

public class Code {
    private int length;
    private char[] code;
    Code(char[] code){
        this.code = code.clone();
        length = code.length;
    }

    public int getLength(){
        return length;
    }
    public char getChar(int index){
        return code[index];
    }
    @Override
    public String toString() {
        return new String(code);
    }
}
