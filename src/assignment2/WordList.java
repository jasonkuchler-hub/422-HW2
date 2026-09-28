package assignment2;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordList {
    private final List<String> words;
    private final Random random;

    public WordList(String filePath) {
        words = new ArrayList<>();
        random = new Random();
        try {
            Scanner fileScanner = new Scanner(new File(filePath));
            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine().trim().toUpperCase();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not find word list file: " + filePath, e);
        }
    }

    public boolean contains(String word) {
        return words.contains(word.toUpperCase());
    }

    public String randomWord() {
        int index = random.nextInt(words.size());
        return words.get(index);
    }
}