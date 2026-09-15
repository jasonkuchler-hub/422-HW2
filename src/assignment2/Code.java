package assignment2;

public class Code {
    private int length;
    private char[] code;
    Code(char[] code){
        this.code = code.clone();
        length = code.length;
    }

    public boolean compare(Code c){
        if (this.getLength()==c.getLength()){
            for(int i = 0; i < this.getLength(); i++){
                if (this.getChar(i) == c.getChar(i)){
                }
                else{
                    return false;
                }
            }
            return true;
        }
        return false;
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
