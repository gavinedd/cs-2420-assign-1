import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class LadderGame {

    ArrayList<ArrayList<String>> listOfWords = new ArrayList<ArrayList<String>>();


    public LadderGame(String dictionaryFile) {
        readDictionary(dictionaryFile);
    }

    public void play(String start, String end) {
        // TODO: Write some good stuff here
//        System.out.println(listOfWords.get(2));
        System.out.println(oneAway("aa",true));
    }

    public ArrayList<String> oneAway(String word, boolean withRemoval) {
        ArrayList<String> oneAwayWords = new ArrayList<>();

        // TODO: Write some good stuff here
        for(String potentialWord: listOfWords.get(word.length())){
            int away = 0;
            for (int i = 0; i < word.length(); i++) {
                if (potentialWord.charAt(i) != word.charAt(i)){
                away++;}
            }
                if (away == 1) {
                    oneAwayWords.add(potentialWord);
                }
        }
        for(String wordToRemove: oneAwayWords){
            listOfWords.get(word.length()).remove(wordToRemove);
        }
        return oneAwayWords;
    }

    public void listWords(int length, int howMany) {
        // TODO: Write some good stuff here
    }

    /*
        Reads a list of words from a file, putting all words of the same length into the same array.
     */
    private void readDictionary(String dictionaryFile) {
        File file = new File("Dictionary.txt");
        ArrayList<String> allWords = new ArrayList<>();

        // Track the longest word, because that tells us how big to make the array.
        int longestWord = 0;
        try (Scanner input = new Scanner(file)) {
            //
            // Start by reading all the words into memory.
            while (input.hasNextLine()) {
                String word = input.nextLine().toLowerCase();
                allWords.add(word);
                longestWord = Math.max(longestWord, word.length());
            }

            for (int i = 0; i <= longestWord; i++) {
                listOfWords.add(new ArrayList<String>());
            }

            for (String word : allWords) {
                listOfWords.get(word.length()).add(word);
            }


        } catch (java.io.IOException ex) {
            System.out.println("An error occurred trying to read the dictionary: " + ex);
        }
    }
}

