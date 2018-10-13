package model;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;

public class AlphabetSoup {

    private final static ArrayList<Integer> BASIC = new ArrayList<>();
    private final static ArrayList<Integer> INTERMEDIUM = new ArrayList<>();
    private final static ArrayList<Integer> ADVANCED = new ArrayList<>();
    private ArrayList<String> partialSolutions = new ArrayList<>();
    private ArrayList<ArrayList<String>> alphabetSoup = new ArrayList<ArrayList<String>>();
    private String difficulty;
    private Random random = new Random();
    private File type;
    private ArrayList<String> dictionary = new ArrayList<>();
    private ArrayList<String> letters = new ArrayList<>();

    public AlphabetSoup(int mode, int type) {

        if (mode == 1) {
            this.difficulty = "BASIC";
        } else if (mode == 2) {
            this.difficulty = "INTERMEDIUM";
        } else if (mode == 3) {
            this.difficulty = "ADVANCED";
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

    public int getSize() {

        if (this.difficulty.equals("BASIC")) {
            return BASIC.get(1);
        } else if (this.difficulty.equals("INTERMEDIUM")) {
            return INTERMEDIUM.get(1);
        } else if (this.difficulty.equals("ADVANCED")) {
            return ADVANCED.get(1);
        } else {
            return 0;
        }

    }

    public int getRequiredWords() {

        if (this.difficulty.equals("BASIC")) {
            return BASIC.get(0);
        } else if (this.difficulty.equals("INTERMEDIUM")) {
            return INTERMEDIUM.get(0);
        } else if (this.difficulty.equals("ADVANCED")) {
            return ADVANCED.get(0);
        } else {
            return 0;
        }

    }

    public void init() {

        BASIC.add(5);
        BASIC.add(10);
        INTERMEDIUM.add(10);
        INTERMEDIUM.add(15);
        ADVANCED.add(20);
        ADVANCED.add(20);

        while (alphabetSoup.size() < getSize()) {
            alphabetSoup.add(new ArrayList<String>());
        }
        for (ArrayList<String> v : alphabetSoup) {
            while (v.size() < getSize()) {
                v.add(" ");
            }
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(type));
            BufferedReader br2 = new BufferedReader(new FileReader("resources/abc.txt"));
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
        }
    }

    public void drawAlphabetSoup() {

        int l = 0;
        int w = 0;
        System.out.print("\n");
        System.out.print("||  ");
        while (l < getSize()) { System.out.print(alphabetSoup.get(l).get(w) + "  ");
            w++;
            if (w % getSize() == 0) {
                l++;
                w = 0;
                System.out.print("||");
                System.out.print("\n");
                if (l < 10){
                    System.out.print("||  ");
                }
            }
        }
    }

    public void setWords() {

        int limitx;
        int limity;
        int row;
        int col;
        int ward = 0;
        int randomchoice;

        try {
            while (partialSolutions.size() < getRequiredWords()) {

                row = random.nextInt(alphabetSoup.size());
                col = random.nextInt(alphabetSoup.get(0).size());

                randomchoice = random.nextInt(8) + 1;

                if (randomchoice == 1) { // horizontal to the right

                    int r = random.nextInt(dictionary.size());
                    String word = dictionary.get(r);
                    limitx = col + word.length();

                    if (limitx <= alphabetSoup.get(0).size()) {
                        ArrayList<Character> realword = new ArrayList<Character>();
                        for (int i = 0; i < word.length(); i++) {
                            realword.add(word.charAt(i));
                        }
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                col++;
                                ward++;
                            }
                            if (ward == word.length()) {
                                partialSolutions.add(word);
                                dictionary.remove(word);
                            }
                        }
                    }
                    setWords();
                } else if (randomchoice == 2) { // horizontal to the left

                    int r = random.nextInt(dictionary.size());
                    String word = dictionary.get(r);
                    limitx = col - word.length();

                    if (limitx >= 0) {
                        ArrayList<Character> realword = new ArrayList<Character>();
                        for (int i = 0; i < word.length(); i++) {
                            realword.add(word.charAt(i));
                        }
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                col--;
                                ward++;
                            }
                            if (ward == word.length()) {
                                partialSolutions.add(word);
                                dictionary.remove(word);
                            }
                        }
                    }
                    setWords();
                } else if (randomchoice == 3) { // vertical down

                    int r = random.nextInt(dictionary.size());
                    String word = dictionary.get(r);
                    limity = word.length() + row;


                    if (limity <= alphabetSoup.size()) {
                        ArrayList<Character> realword = new ArrayList<Character>();
                        for (int i = 0; i < word.length(); i++) {
                            realword.add(word.charAt(i));
                        }
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                row++;
                                ward++;
                            }
                            if (ward == word.length()) {
                                partialSolutions.add(word);
                                dictionary.remove(word);
                            }
                        }
                    }
                    setWords();
                } else if (randomchoice == 4) { // vertical up

                    int r = random.nextInt(dictionary.size());
                    String word = dictionary.get(r);
                    limity = row - word.length();


                    if (limity >= 0) {
                        ArrayList<Character> realword = new ArrayList<Character>();
                        for (int i = 0; i < word.length(); i++) {
                            realword.add(word.charAt(i));
                        }
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                row--;
                                ward++;
                            }
                            if (ward == word.length()) {
                                partialSolutions.add(word);
                                dictionary.remove(word);
                            }
                        }
                    }
                    setWords();
                } else if (randomchoice == 5) { // diag right up

                    int r = random.nextInt(dictionary.size());
                    String word = dictionary.get(r);
                    limity = row - word.length();
                    limitx = col + word.length();

                    if ((limity >= 0 && limitx < alphabetSoup.get(0).size())) {
                        ArrayList<Character> realword = new ArrayList<Character>();
                        for (int i = 0; i < word.length(); i++) {
                            realword.add(word.charAt(i));
                        }
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                row--;
                                col++;
                                ward++;
                            }
                            if (ward == word.length()) {
                                partialSolutions.add(word);
                                dictionary.remove(word);
                            }
                        }
                    }
                    setWords();
                } else if (randomchoice == 6) { // diag left up

                    int r = random.nextInt(dictionary.size());
                    String word = dictionary.get(r);
                    limity = row - word.length();
                    limitx = col - word.length();


                    if (limity >= 0  && limitx >= 0) {
                        ArrayList<Character> realword = new ArrayList<Character>();
                        for (int i = 0; i < word.length(); i++) {
                            realword.add(word.charAt(i));
                        }
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                row--;
                                col--;
                                ward++;
                            }
                            if (ward == word.length()) {
                                partialSolutions.add(word);
                                dictionary.remove(word);
                            }
                        }
                    }
                    setWords();
                } else if (randomchoice == 7) { // diag down right

                    int r = random.nextInt(dictionary.size());
                    String word = dictionary.get(r);
                    limity = word.length() + row;
                    limitx = col + word.length();


                    if ((limity <= alphabetSoup.size() && limitx <= alphabetSoup.get(0).size())) {
                        ArrayList<Character> realword = new ArrayList<Character>();
                        for (int i = 0; i < word.length(); i++) {
                            realword.add(word.charAt(i));
                        }
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                row++;
                                col++;
                                ward++;
                            }
                            if (ward == word.length()) {
                                partialSolutions.add(word);
                                dictionary.remove(word);
                            }
                        }
                    }
                    setWords();
                } else if (randomchoice == 8) { // diag down left

                    int r = random.nextInt(dictionary.size());
                    String word = dictionary.get(r);
                    limity = word.length() + row;
                    limitx = col - word.length();


                    if ((limity <= alphabetSoup.size() && limitx >= 0)) {
                        ArrayList<Character> realword = new ArrayList<Character>();
                        for (int i = 0; i < word.length(); i++) {
                            realword.add(word.charAt(i));
                        }
                        for (char c : realword) {
                            if (alphabetSoup.get(row).get(col).equals(" ") || alphabetSoup.get(row).get(col).equals(String.valueOf(c))) {
                                alphabetSoup.get(row).set(col, String.valueOf(c));
                                row++;
                                col--;
                                ward++;
                            }
                            if (ward == word.length()) {
                                partialSolutions.add(word);
                                dictionary.remove(word);
                            }
                        }
                    }
                    setWords();
                }
            }
        } catch (Exception e) {
            setWords();
        }
    }

        public void setRandomLetters(){

            int l = 0;
            int w = 0;

            while (l < getSize()) {
                int r = random.nextInt(letters.size());
                if (alphabetSoup.get(l).get(w).equals(" ")) {
                    alphabetSoup.get(l).set(w, letters.get(r));
                }
                w++;
                if (w % getSize() == 0) {
                    l++;
                    w = 0;
                }
            }
        }

        public ArrayList getPartialSolutions(){
            return partialSolutions;
        }

    }

