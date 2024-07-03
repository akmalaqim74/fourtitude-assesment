package asia.fourtitude.interviewq.jumble.core;

import java.io.*;
import java.util.*;

public class JumbleEngine {

    /**
     * From the input `word`, produces/generates a copy which has the same
     * letters, but in different ordering.
     *
     * Example: from "elephant" to "aeehlnpt".
     *
     * Evaluation/Grading:
     * a) pass unit test: JumbleEngineTest#scramble()
     * b) scrambled letters/output must not be the same as input
     *
     * param word  The input word to scramble the letters.
     * @return  The scrambled output/letters.
     */
    public String scramble(String tempWord) {
        /*
         * Refer to the method's Javadoc (above) and implement accordingly.
         * Must pass the corresponding unit tests.
         */
        List<Character> tempChar = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        do {
            for (char c : tempWord.toCharArray()) {
                tempChar.add(c);
            }
            Collections.shuffle(tempChar);
            for (char c : tempChar) {
                word.append(c);
            }
        }while (tempWord.equals(word.toString()));

        return word.toString();
    }

    /**
     * Retrieves the palindrome words from the internal
     * word list/dictionary ("src/main/resources/words.txt").
     *
     * Word of single letter is not considered as valid palindrome word.
     *
     * Examples: "eye", "deed", "level".
     *
     * Evaluation/Grading:
     * a) able to access/use resource from classpath
     * b) using inbuilt Collections
     * c) using "try-with-resources" functionality/statement
     * d) pass unit test: JumbleEngineTest#palindrome()
     *
     * @return  The list of palindrome words found in system/engine.
     * see https://www.google.com/search?q=palindrome+meaning
     */
    public Collection<String> retrievePalindromeWords() {
        /*
         * Refer to the method's Javadoc (above) and implement accordingly.
         * Must pass the corresponding unit tests.
         */
        Collection<String> palindromeWords = new ArrayList<>();
        InputStream inputStream = JumbleEngine.class.getClassLoader().getResourceAsStream("words.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        try {
            //StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                if(line.equals(new StringBuilder(line).reverse().toString()) && line.length() > 1){
                    palindromeWords.add(line);
                }
                line = br.readLine();

            }


        }catch (FileNotFoundException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                br.close();
            }catch (IOException e) {
                System.err.println("An IOException was caught: " + e.getMessage());
                e.printStackTrace();
            }

        }


       return palindromeWords;
    }

    /**
     * Picks one word randomly from internal word list.
     *
     * Evaluation/Grading:
     * a) pass unit test: JumbleEngineTest#randomWord()
     * b) provide a good enough implementation, if not able to provide a fast lookup
     * c) bonus points, if able to implement a fast lookup/scheme
     *
     * @param length  The word picked, must of length.
     * @return  One of the word (randomly) from word list.
     *          Or null if none matching.
     */
    public String pickOneRandomWord(Integer length) {
        /*
         * Refer to the method's Javadoc (above) and implement accordingly.
         * Must pass the corresponding unit tests.
         */
        if (length == null){
            return "length=null";
        }
        InputStream inputStream = JumbleEngine.class.getClassLoader().getResourceAsStream("words.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        try {
            //StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                if(line.length() == length){
                   return line;
                }
                line = br.readLine();

            }
        }catch (FileNotFoundException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                br.close();
            }catch (IOException e) {
                System.err.println("An IOException was caught: " + e.getMessage());
                e.printStackTrace();
            }

        }
        return null;
    }

    /**
     * Checks if the `word` exists in internal word list.
     * Matching is case insensitive.
     *
     * Evaluation/Grading:
     * a) pass related unit tests in "JumbleEngineTest"
     * b) provide a good enough implementation, if not able to provide a fast lookup
     * c) bonus points, if able to implement a fast lookup/scheme
     *
     * @param word  The input word to check.
     * @return  true if `word` exists in internal word list.
     */
    public boolean exists(String word) {
        /*
         * Refer to the method's Javadoc (above) and implement accordingly.
         * Must pass the corresponding unit tests.
         */
        boolean tempBool = false;
        InputStream inputStream = JumbleEngine.class.getClassLoader().getResourceAsStream("words.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        try {
            //StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                if(line.equalsIgnoreCase(word)){
                    tempBool = true;
                    break;
                }
                line = br.readLine();

            }
        }catch (FileNotFoundException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                br.close();
            }catch (IOException e) {
                System.err.println("An IOException was caught: " + e.getMessage());
                e.printStackTrace();
            }

        }
        return tempBool;
    }

    /**
     * Finds all the words from internal word list which begins with the
     * input `prefix`.
     * Matching is case insensitive.
     *
     * Invalid `prefix` (null, empty string, blank string, non letter) will
     * return empty list.
     *
     * Evaluation/Grading:
     * a) pass related unit tests in "JumbleEngineTest"
     * b) provide a good enough implementation, if not able to provide a fast lookup
     * c) bonus points, if able to implement a fast lookup/scheme
     *
     * @param prefix  The prefix to match.
     * @return  The list of words matching the prefix.
     */
    public Collection<String> wordsMatchingPrefix(String prefix) {
        /*
         * Refer to the method's Javadoc (above) and implement accordingly.
         * Must pass the corresponding unit tests.
         */
        Collection<String> prefixString = new ArrayList<>();
        if (prefix == null || prefix.equalsIgnoreCase("")|| prefix.equals(" ") || prefix.equals("!")){
            //prefixString.add( "prefix=null");
            return prefixString;
        }
        InputStream inputStream = JumbleEngine.class.getClassLoader().getResourceAsStream("words.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        try {
            //StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                if (line.length() >= prefix.length()){
                    String tempLine = line.substring(0,prefix.length());
                    if(tempLine.equalsIgnoreCase(prefix)){
                        prefixString.add(line);
                    }
                }


                line = br.readLine();
            }
        }catch (FileNotFoundException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                br.close();
            }catch (IOException e) {
                System.err.println("An IOException was caught: " + e.getMessage());
                e.printStackTrace();
            }

        }
        return prefixString;
    }

    /**
     * Finds all the words from internal word list that is matching
     * the searching criteria.
     *
     * `startChar` and `endChar` must be 'a' to 'z' only. And case insensitive.
     * `length`, if have value, must be positive integer (>= 1).
     *
     * Words are filtered using `startChar` and `endChar` first.
     * Then apply `length` on the result, to produce the final output.
     *
     * Must have at least one valid value out of 3 inputs
     * (`startChar`, `endChar`, `length`) to proceed with searching.
     * Otherwise, return empty list.
     *
     * Evaluation/Grading:
     * a) pass related unit tests in "JumbleEngineTest"
     * b) provide a good enough implementation, if not able to provide a fast lookup
     * c) bonus points, if able to implement a fast lookup/scheme
     *
     * @param startChar  The first character of the word to search for.
     * @param endChar    The last character of the word to match with.
     * @param length     The length of the word to match.
     * @return  The list of words matching the searching criteria.
     */
    public Collection<String> searchWords(Character startChar, Character endChar, Integer length) {
        /*
         * Refer to the method's Javadoc (above) and implement accordingly.
         * Must pass the corresponding unit tests.
         */
        Collection<String> searchWords = new ArrayList<>();
        InputStream inputStream = JumbleEngine.class.getClassLoader().getResourceAsStream("words.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        if (length == null && startChar == null && endChar == null ){
            return searchWords;
        }
        try {
            //StringBuilder sb = new StringBuilder();
            String line = br.readLine();


            while (line != null) {
                int lastIndex = line.length() - 1;
                char startCharLower = (startChar != null) ? Character.toLowerCase(startChar) : '\0';
                char endCharLower = (endChar != null) ? Character.toLowerCase(endChar) : '\0';

                boolean matchesStartChar = (startChar == null || Character.toLowerCase(line.charAt(0)) == startCharLower);
                boolean matchesEndChar = (endChar == null || Character.toLowerCase(line.charAt(lastIndex)) == endCharLower);
                boolean matchesLength = (length == null || line.length() == length);

                if (matchesStartChar && matchesEndChar && matchesLength) {
                    searchWords.add(line);
                }
                line = br.readLine();
                }
        }catch (FileNotFoundException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                br.close();
            }catch (IOException e) {
                System.err.println("An IOException was caught: " + e.getMessage());
                e.printStackTrace();
            }
        }



        return searchWords;
    }

    /**
     * Generates all possible combinations of smaller/sub words using the
     * letters from input word.
     *
     * The `minLength` set the minimum length of sub word that is considered
     * as acceptable word.
     *
     * If length of input `word` is less than `minLength`, then return empty list.
     *
     * Example: From "yellow" and `minLength` = 3, the output sub words:
     *     low, lowly, lye, ole, owe, owl, well, welly, woe, yell, yeow, yew, yowl
     *
     * Evaluation/Grading:
     * a) pass related unit tests in "JumbleEngineTest"
     * b) provide a good enough implementation, if not able to provide a fast lookup
     * c) bonus points, if able to implement a fast lookup/scheme
     *
     * @param word       The input word to use as base/seed.
     * @param minLength  The minimum length (inclusive) of sub words.
     *                   Expects positive integer.
     *                   Default is 3.
     * @return  The list of sub words constructed from input `word`.
     */
    public Collection<String> generateSubWords(String word, Integer minLength) {
        /*
         * Refer to the method's Javadoc (above) and implement accordingly.
         * Must pass the corresponding unit tests.
         */
        Collection<String> subWords = new ArrayList<>();
        Set<String> dictionary = new HashSet<>();
        InputStream inputStream = JumbleEngine.class.getClassLoader().getResourceAsStream("words.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        if (minLength == null) {
            minLength = 3;
        }
        if (word == null || word.trim().isEmpty() ||   word.length() < minLength || minLength < 1) {
            return new ArrayList<>();
        }

        try {
            //StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                dictionary.add(line.trim().toLowerCase());
            }

        }catch (FileNotFoundException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                br.close();
            }catch (IOException e) {
                System.err.println("An IOException was caught: " + e.getMessage());
                e.printStackTrace();
            }
        }
        // increment the alphabet in word, example banana = [3, 1, 0, 0, ..., 2, 0, 0] 3 a, 1 b, 2 n
        int[] wordLetterCount = new int[26]; // 26 letters in the alphabet
        for (char c : word.toCharArray()) {
            wordLetterCount[c - 'a']++;
        }
        for (String dictWord : dictionary) {
            if (dictWord.length() >= minLength && dictWord.length() < word.length()) {
                // increment the alphabet in word, example banana = [3, 1, 0, 0, ..., 2, 0, 0] 3 a, 1 b, 2 n
                int[] letterCount = new int[26]; // 26 letters in the alphabet
                for (char c : dictWord.toCharArray()) {
                    letterCount[c - 'a']++;
                }
                boolean isSubAnagram = true;
                for (int i = 0; i < 26; i++) {
                    if (letterCount[i] > wordLetterCount[i]) {
                        isSubAnagram = false;
                        break;
                    }
                }
                if (isSubAnagram && dictWord.length() >= minLength) {
                    subWords.add(dictWord);
                }
            }

        }
        return subWords;
    }

    /**
     * Creates a game state with word to guess, scrambled letters, and
     * possible combinations of words.
     *
     * Word is of length 6 characters.
     * The minimum length of sub words is of length 3 characters.
     *
     * @param length     The length of selected word.
     *                   Expects >= 3.
     * @param minLength  The minimum length (inclusive) of sub words.
     *                   Expects positive integer.
     *                   Default is 3.
     * @return  The game state.
     */
    public GameState createGameState(Integer length, Integer minLength) {
        Objects.requireNonNull(length, "length must not be null");
        if (minLength == null) {
            minLength = 3;
        } else if (minLength <= 0) {
            throw new IllegalArgumentException("Invalid minLength=[" + minLength + "], expect positive integer");
        }
        if (length < 3) {
            throw new IllegalArgumentException("Invalid length=[" + length + "], expect greater than or equals 3");
        }
        if (minLength > length) {
            throw new IllegalArgumentException("Expect minLength=[" + minLength + "] greater than length=[" + length + "]");
        }
        String original = this.pickOneRandomWord(length);
        if (original == null) {
            throw new IllegalArgumentException("Cannot find valid word to create game state");
        }
        String scramble = this.scramble(original);
        Map<String, Boolean> subWords = new TreeMap<>();
        for (String subWord : this.generateSubWords(original, minLength)) {
            subWords.put(subWord, Boolean.FALSE);
        }
        return new GameState(original, scramble, subWords);
    }

}
