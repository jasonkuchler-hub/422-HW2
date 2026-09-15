package assignment2;

import java.util.List;
import java.util.ArrayList;

public class GuessHistory {
    private List<GuessRecord> records;
    public GuessHistory(){
        records = new ArrayList<>();
    }
    public void addRecord(Code guess, Feedback result){
        records.add(new GuessRecord(guess, result));
    }
    public List<GuessRecord> getRecords(){
        return new ArrayList<>(records);
    }
}
