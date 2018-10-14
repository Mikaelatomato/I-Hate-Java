package model;

import java.io.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class AlphabetSoup {

    private final static ArrayList<Integer> BASIC = new ArrayList<>(Arrays.asList(5, 10));
    private final static ArrayList<Integer> INTERMEDIUM = new ArrayList<>(Arrays.asList(10, 15));
    private final static ArrayList<Integer> ADVANCED = new ArrayList<>(Arrays.asList(20,20));
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
                if (br != null){
                    br.close();
                }
                if (br2 != null){
                    br.close();
                }
            } catch (IOException io){
                io.printStackTrace();
            }
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
                if (l < getSize()){
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
                                            if (flag){
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
                                            if (flag){
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
                                boolean flag = false;
                                if (!alphabetSoup.get(row).get(col).equals(" ")) {
                                    for (ArrayList<Integer> v : samepos) {
                                        if (v.get(0) == row && v.get(1) == col) {
                                            flag = true;
                                            if (flag){
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
                                            if (flag){
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
                                            if (flag){
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
                                            if (flag){
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
                        } else { while (wardremove != 0) {
                            row--;
                            col--;
                            boolean flag = false;
                            if (!alphabetSoup.get(row).get(col).equals(" ")) {
                                for (ArrayList<Integer> v : samepos) {
                                    if (v.get(0) == row && v.get(1) == col) {
                                        flag = true;
                                        if (flag){
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
                                            if (flag){
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
                }
                setWords();
            }
        } catch (StackOverflowError e) {
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

