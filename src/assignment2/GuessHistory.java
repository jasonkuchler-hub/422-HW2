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
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Guess --> Result").append(System.lineSeparator());
        for (int i = 0; i < records.size(); i++) {
            GuessRecord record = records.get(i);
            result.append(record.getGuess());
            result.append(" --> ");
            result.append(record.getResult());
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}
