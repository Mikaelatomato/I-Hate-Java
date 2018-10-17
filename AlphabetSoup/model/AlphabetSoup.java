package model;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is the only class that you'll see here ma boi. I didn't know that i had to use different classes to do this, and that i had to do it
 * as the lab4 guide said. That's kind of boring and i don't feel good doing some stuff that's almost done, i like it when i have to think it by myself.
 * So, i could have done this on the main class, (but then i wouldn't be able to do the documentation) and that's why you have this class right here.
 * This could have been done on the procedural way, and i wanted to do it like that using python, but i'm pushed to this.
 *
 * do i need to explain the attributes? i think i don't, this isn't hard to understand or figure out.
 *
 */

public class AlphabetSoup {

    private final static ArrayList<Integer> BASIC = new ArrayList<>(Arrays.asList(5, 10));
    private final static ArrayList<Integer> INTERMEDIUM = new ArrayList<>(Arrays.asList(10, 15));
    private final static ArrayList<Integer> ADVANCED = new ArrayList<>(Arrays.asList(20, 20));
    private final static String BASICD = "BASIC";
    private final static String INTERMEDIUMD = "INTERMEDIUM";
    private final static String ADVANCEDD = "ADVANCED";
    private ArrayList<String> partialSolutions = new ArrayList<>();
    private ArrayList<ArrayList<String>> alphabetSoup = new ArrayList<ArrayList<String>>();
    private String difficulty;
    private Random random = new Random();
    private File type;
    private ArrayList<String> dictionary = new ArrayList<>();
    private ArrayList<String> letters = new ArrayList<>();

    /**
     * This method returns the amount of words for an alphabet soup.
     *
     * @param mode large and width, ex: 10x10 15x15 20x20
     * @param type kind of dict that's going to be used, ex: animals, plants, sports.
     *
     * pos: defines the attributes difficulty and type
     *
     */

    public AlphabetSoup(int mode, int type) {
        if (mode == 1) {
            this.difficulty = BASICD;
        } else if (mode == 2) {
            this.difficulty = INTERMEDIUMD;
        } else if (mode == 3) {
            this.difficulty = ADVANCEDD;
        }
        if (type == 1) {
            this.type = new File("resources/animals.txt");
        } else if (type == 2) {
            this.type = new File("resources/plants.txt");
        } else if (type == 3) {
            this.type = new File("resources/culture.txt");
        } else if (type == 4) {
            this.type = new File("resources/sports.txt");
        } else if (type == 5) {
            this.type = new File("resources/books.txt");
        }
    }

    /**
     * This method returns the size for an alphabet soup depending on its difficulty.
     *
     * pre: the attribute difficulty must had been set.
     *
     * @return an int that refers to the size that an alphabet soup of 'x' difficult should have.
     */

    public int getSize() {
        if (this.difficulty.equals(BASICD)) {
            return BASIC.get(1);
        } else if (this.difficulty.equals(INTERMEDIUMD)) {
            return INTERMEDIUM.get(1);
        } else if (this.difficulty.equals(ADVANCEDD)) {
            return ADVANCED.get(1);
        } else {
            return 0;
        }

    }

    /**
     * This method returns the amount of words for an alphabet soup.
     *
     * pre: the attribute difficulty must had been set.
     *
     * @return an int that refers to the amount of words that a alphabet soup of 'x' difficult should have
     */

    public int getRequiredWords() {
        if (this.difficulty.equals(BASICD)) {
            return BASIC.get(0);
        } else if (this.difficulty.equals(INTERMEDIUMD)) {
            return INTERMEDIUM.get(0);
        } else if (this.difficulty.equals(ADVANCEDD)) {
            return ADVANCED.get(0);
        } else {
            return 0;
        }

    }

    /**
     * The init method.
     *
     * pre: -the files.txt must had been placed in the right place.
     *      -difficulty and type are defined
     *
     * pos: -creates the alphabet soup and fills it with " ", and it's size is based on the difficulty.
     *      -reads the files that contains the letters and words for this soup and saves them on two different arrays.
     */
    public void init() {
        while (alphabetSoup.size() < getSize()) {
            alphabetSoup.add(new ArrayList<>());
        }
        for (ArrayList<String> v : alphabetSoup) {
            while (v.size() < getSize()) {
                v.add(" ");
            }
        }
        BufferedReader br = null;
        BufferedReader br2 = null;
        try {
            br = new BufferedReader(new FileReader(type));
            br2 = new BufferedReader(new FileReader("resources/abc.txt"));
            String line;
            String line2;
            while ((line = br.readLine()) != null) {
                dictionary.add(line);
            }
            while ((line2 = br2.readLine()) != null) {
                letters.add(line2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (br2 != null) {
                    br.close();
                }
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
    }

    /**
     * Prints out the alphabet soup.
     *
     * pre: -Words had been set, and the soup was filled with random letters if it had spaces.
     *      -difficulty was set (so its size is defined)
     *
     * pos: Just prints.
     *
     */
    public void drawAlphabetSoup() {
        int l = 0;
        int w = 0;
        System.out.print("\n" + "       ");
        for (int i = 0; i < getSize(); i++) {
            if (i < 9) {
                System.out.print((i + 1) + "  ");
            } else {
                System.out.print((i + 1) + " ");

            }
        }
        System.out.print("\n\n");
        System.out.print(1 + "  ||  ");
        while (l < getSize()) {
            System.out.print(alphabetSoup.get(l).get(w) + "  ");
            w++;
            if (w % getSize() == 0) {
                l++;
                w = 0;
                System.out.print("||");
                System.out.print("\n");
                if (l < getSize()) {
                    if (l < 9) {
                        System.out.print((l + 1) + "  ||  ");
                    } else {
                        System.out.print((l + 1) + " ||  ");
                    }
                }
            }
        }
    }

    /**
     * The exciting method.
     *
     * pre: -difficulty and type were defined.
     *      -init was ran (so the dicts aren't empty)
     *
     * pos: i'll go really fast.
     *
     *      -creates some variables that are reused everytime it tries to put a new word.
     *      -limitx and limity will decide if the word can be used "that way"
     *      -row and col are pretty obvious.
     *      -wardremove is to know how many chars need to be removed after being put if the word wasn't put completely.
     *      -the word is descomposed into chars to be put in the soup.
     *      -samepos will keep track of the chars that are on the soup and are shared with other words, so they don't get removed.
     *
     *      -All this does is take a word, take a random possibility to be put in the soup, decide if it can be put or try with another one,
     *      then checks takes every char and put its on a " " on a way that depends on the possibility that was taken and available for this word,
     *      if the word is putted completely and successfully, it gets added to the partialSolutions array, removed from the dictionary and tries to set a new word
     *      till the required amount of words gets reached.
     *
     *      -if a word isn't putted completely, then it goes backwards and removes every char that was put but takes care of the chars that are being used
     *      by other words.
     *
     *      -that's all, i guess.
     *
     */
    public void setWords() {
        int limitx;
        int limity;
        int row;
        int col;
        ArrayList<ArrayList<Integer>> samepos = new ArrayList<>();
        int wardremove = 0;
        String ward = new String();
        int randomchoice;
        String word = dictionary.get(random.nextInt(dictionary.size()));
        ArrayList<Character> realword = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            realword.add(word.charAt(i));
        }
        try {
            while (partialSolutions.size() < getRequiredWords()) {
                row = random.nextInt(alphabetSoup.size());
                col = random.nextInt(alphabetSoup.get(0).size());
                randomchoice = random.nextInt(8) + 1;
                if (randomchoice == 1) { // horizontal to the right
                    limitx = col + word.length();
                    if (limitx <= alphabetSoup.get(0).size()) {
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                if (alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                    samepos.add(new ArrayList<>());
                                    samepos.get(samepos.size() - 1).add(row);
                                    samepos.get(samepos.size() - 1).add(col);
                                }
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                col++;
                                ward += String.valueOf(c);
                                wardremove++;
                            }
                        }
                        if (word.equals(ward) && !partialSolutions.contains(word)) {
                            partialSolutions.add(word);
                            dictionary.remove(word);
                            setWords();
                        } else {
                            while (wardremove != 0) {
                                col--;
                                boolean flag = false;
                                if (!alphabetSoup.get(row).get(col).equals(" ")) {
                                    for (ArrayList<Integer> v : samepos) {
                                        if (v.get(0) == row && v.get(1) == col) {
                                            flag = true;
                                            if (flag) {
                                                break;
                                            }
                                        }
                                    } if (!flag) {
                                        alphabetSoup.get(row).set(col, " ");
                                    } wardremove--;
                                }
                            }
                            setWords();
                        }
                    } else {
                        setWords();
                    }
                } else if (randomchoice == 2) { // horizontal to the left
                    limitx = col - word.length();
                    if (limitx >= 0) {
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                if (alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                    samepos.add(new ArrayList<>());
                                    samepos.get(samepos.size() - 1).add(row);
                                    samepos.get(samepos.size() - 1).add(col);
                                }
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                col--;
                                ward += String.valueOf(c);
                                wardremove++;
                            }
                        }
                        if (word.equals(ward) && !partialSolutions.contains(word)) {
                            partialSolutions.add(word);
                            dictionary.remove(word);
                            setWords();
                        } else {
                            while (wardremove != 0) {
                                col++;
                                boolean flag = false;
                                if (!alphabetSoup.get(row).get(col).equals(" ")) {
                                    for (ArrayList<Integer> v : samepos) {
                                        if (v.get(0) == row && v.get(1) == col) {
                                            flag = true;
                                            if (flag) {
                                                break;
                                            }
                                        }
                                    }
                                    if (!flag) {
                                        alphabetSoup.get(row).set(col, " ");
                                    }
                                    wardremove--;
                                }
                            }
                            setWords();
                        }
                    } else {
                        setWords();
                    }
                } else if (randomchoice == 3) { // vertical down
                    limity = word.length() + row;
                    if (limity <= alphabetSoup.size()) {
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                if (alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                    samepos.add(new ArrayList<>());
                                    samepos.get(samepos.size() - 1).add(row);
                                    samepos.get(samepos.size() - 1).add(col);
                                }
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                row++;
                                ward += String.valueOf(c);
                            }
                        }
                        if (word.equals(ward) && !partialSolutions.contains(word)) {
                            partialSolutions.add(word);
                            dictionary.remove(word);
                            setWords();
                        } else {
                            while (wardremove != 0) {
                                row--;
                                boolean flag = false;
                                if (!alphabetSoup.get(row).get(col).equals(" ")) {
                                    for (ArrayList<Integer> v : samepos) {
                                        if (v.get(0) == row && v.get(1) == col) {
                                            flag = true;
                                            if (flag) {
                                                break;
                                            }
                                        }
                                    }
                                    if (!flag) {
                                        alphabetSoup.get(row).set(col, " ");
                                    }
                                    wardremove--;
                                }
                            }
                            setWords();
                        }
                    } else {
                        setWords();
                    }
                } else if (randomchoice == 4) { // vertical up
                    limity = row - word.length();
                    if (limity >= 0) {
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                if (alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                    samepos.add(new ArrayList<>());
                                    samepos.get(samepos.size() - 1).add(row);
                                    samepos.get(samepos.size() - 1).add(col);
                                }
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                row--;
                                ward += String.valueOf(c);
                                wardremove++;
                            }
                        }
                        if (word.equals(ward) && !partialSolutions.contains(word)) {
                            partialSolutions.add(word);
                            dictionary.remove(word);
                            setWords();
                        } else {
                            while (wardremove != 0) {
                                row++;
                                boolean flag = false;
                                if (!alphabetSoup.get(row).get(col).equals(" ")) {
                                    for (ArrayList<Integer> v : samepos) {
                                        if (v.get(0) == row && v.get(1) == col) {
                                            flag = true;
                                            if (flag) {
                                                break;
                                            }
                                        }
                                    }
                                    if (!flag) {
                                        alphabetSoup.get(row).set(col, " ");
                                    }
                                    wardremove--;
                                }
                            }
                            setWords();
                        }
                    }
                } else if (randomchoice == 5) { // diag right up
                    limity = row - word.length();
                    limitx = col + word.length();
                    if ((limity >= 0 && limitx < alphabetSoup.get(0).size())) {
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                if (alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                    samepos.add(new ArrayList<>());
                                    samepos.get(samepos.size() - 1).add(row);
                                    samepos.get(samepos.size() - 1).add(col);
                                }
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                row--;
                                col++;
                                ward += String.valueOf(c);
                                wardremove++;
                            }
                        }
                        if (word.equals(ward) && !partialSolutions.contains(word)) {
                            partialSolutions.add(word);
                            dictionary.remove(word);
                            setWords();
                        } else {
                            while (wardremove != 0) {
                                row++;
                                col--;
                                boolean flag = false;
                                if (!alphabetSoup.get(row).get(col).equals(" ")) {
                                    for (ArrayList<Integer> v : samepos) {
                                        if (v.get(0) == row && v.get(1) == col) {
                                            flag = true;
                                            if (flag) {
                                                break;
                                            }
                                        }
                                    }
                                    if (!flag) {
                                        alphabetSoup.get(row).set(col, " ");
                                    }
                                    wardremove--;
                                }
                            }
                            setWords();
                        }
                    } else {
                        setWords();
                    }
                } else if (randomchoice == 6) { // diag left up
                    limity = row - word.length();
                    limitx = col - word.length();
                    if (limity >= 0 && limitx >= 0) {
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                if (alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                    samepos.add(new ArrayList<>());
                                    samepos.get(samepos.size() - 1).add(row);
                                    samepos.get(samepos.size() - 1).add(col);
                                }
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                row--;
                                col--;
                                ward += String.valueOf(c);
                                wardremove++;
                            }
                        }
                        if (word.equals(ward) && !partialSolutions.contains(word)) {
                            partialSolutions.add(word);
                            dictionary.remove(word);
                            setWords();
                        } else {
                            while (wardremove != 0) {
                                row++;
                                col++;
                                boolean flag = false;
                                if (!alphabetSoup.get(row).get(col).equals(" ")) {
                                    for (ArrayList<Integer> v : samepos) {
                                        if (v.get(0) == row && v.get(1) == col) {
                                            flag = true;
                                            if (flag) {
                                                break;
                                            }
                                        }
                                    }
                                    if (!flag) {
                                        alphabetSoup.get(row).set(col, " ");
                                    }
                                    wardremove--;
                                }
                            }
                            setWords();
                        }
                    } else {
                        setWords();
                    }
                } else if (randomchoice == 7) { // diag down right
                    limity = word.length() + row;
                    limitx = col + word.length();
                    if ((limity <= alphabetSoup.size() && limitx <= alphabetSoup.get(0).size())) {
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                if (alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                    samepos.add(new ArrayList<>());
                                    samepos.get(samepos.size() - 1).add(row);
                                    samepos.get(samepos.size() - 1).add(col);
                                }
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                row++;
                                col++;
                                ward += String.valueOf(c);
                                wardremove++;
                            }
                        }
                        if (word.equals(ward) && !partialSolutions.contains(word)) {
                            partialSolutions.add(word);
                            dictionary.remove(word);
                            setWords();
                        } else {
                            while (wardremove != 0) {
                                row--;
                                col--;
                                boolean flag = false;
                                if (!alphabetSoup.get(row).get(col).equals(" ")) {
                                    for (ArrayList<Integer> v : samepos) {
                                        if (v.get(0) == row && v.get(1) == col) {
                                            flag = true;
                                            if (flag) {
                                                break;
                                            }
                                        }
                                    }
                                    if (!flag) {
                                        alphabetSoup.get(row).set(col, " ");
                                    }
                                    wardremove--;
                                }
                            }
                            setWords();
                        }
                    } else {
                        setWords();
                    }
                } else if (randomchoice == 8) { // diag down left
                    limity = word.length() + row;
                    limitx = col - word.length();
                    if ((limity <= alphabetSoup.size() && limitx >= 0)) {
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                if (alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                    samepos.add(new ArrayList<>());
                                    samepos.get(samepos.size() - 1).add(row);
                                    samepos.get(samepos.size() - 1).add(col);
                                }
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                row++;
                                col--;
                                ward += String.valueOf(c);
                                wardremove++;
                            }
                        }
                        if (word.equals(ward) && !partialSolutions.contains(word)) {
                            partialSolutions.add(word);
                            dictionary.remove(word);
                            setWords();
                        } else {
                            while (wardremove != 0) {
                                row--;
                                col++;
                                boolean flag = false;
                                if (!alphabetSoup.get(row).get(col).equals(" ")) {
                                    for (ArrayList<Integer> v : samepos) {
                                        if (v.get(0) == row && v.get(1) == col) {
                                            flag = true;
                                            if (flag) {
                                                break;
                                            }
                                        }
                                    }
                                    if (!flag) {
                                        alphabetSoup.get(row).set(col, " ");
                                    }
                                    wardremove--;
                                }
                            }
                            setWords();
                        }
                    } else {
                        setWords();
                    }
                }
                setWords();
            }
        } catch (StackOverflowError e) {
            System.out.print("Oops, looks like something went wrong, try running the program again :)");
        }
    }

    /**
     * So, this method completes the " " spaces in the arrays with random letters.
     *
     * pre: -The array "letters" must not be empty.
     *      -The array "alphabetsoup" must have been filled with " "
     *      -The array "alphabetsoup" must have been filled with words before running this.
     *
     * pos: we use "l" to refer to length and "w" to width.
     *      l is the number of rows, w is the number of colums
     *      we call the method "get size" to know how much big is the alphabet soup.
     *      then we get a random letter from the "letters" array and put it on a " ".
     *
     */

    public void setRandomLetters() {
        int l = 0;
        int w = 0;
        while (l < getSize()) {
            if (alphabetSoup.get(l).get(w).equals(" ")) {
                alphabetSoup.get(l).set(w, letters.get(random.nextInt(letters.size())));
            }
            w++;
            if (w % getSize() == 0) {
                l++;
                w = 0;
            }
        }
    }

    /**
     * This method gives the solutions (words) that are in the alphabet soup.
     *
     * @return an array that contains all the word in the soup.
     */

    public ArrayList getPartialSolutions() {
        return partialSolutions;
    }

}

