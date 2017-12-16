import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCount {

    // private ArrayList<String> words; //ArrayList won't work here
    private Map<String, Integer> wordCounts;
    private int numwords;


    public WordCount(String fileName) throws FileNotFoundException {
        // words = new ArrayList<String>(3);
        // words.add("happy");
        // words.add("halloween");
        // words.add("candy");
        // numwords = 3;
        this.wordCounts = new HashMap<String, Integer>();
        Scanner fileScanner = new Scanner(new File(fileName));
        int currentWordCount;
        String word;
        while (fileScanner.hasNext()) {
            numwords++;
            word = fileScanner.next().toLowerCase().replaceAll("[^a-z]", "");
            if (wordCounts.get(word)==null) {
                wordCounts.put(word,1);
            } else {
                currentWordCount = wordCounts.get(word);
                wordCounts.put(word, currentWordCount+1);
            }
        }
    }

    public Collection<String> getWords() {
        return wordCounts.keySet();
    }

    public int getCount(String word) {
        return wordCounts.get(word);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];
        WordCount wc = new WordCount(fileName);
        for (String word: wc.getWords()) {
            System.out.printf("%s: %d \n",word,wc.getCount(word));
        }
    }
}
