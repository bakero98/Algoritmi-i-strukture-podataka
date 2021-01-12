package drugi;

//        Na žurci je došlo n momaka i m devojaka. Momak i devojka mogu plesati samo ukoliko je ime
//        devojka anagram momkovog imena. Koliki je maksimalni broj parava koji mogu igrati u jednom
//        trenutku?

//        Ulaz                          Izlaz
//        n=3 m=2                       1
//        marko ivaan nikola
//        ivana marija

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Drugi {
    private static Drugi instance;

    private int numberOfMales;
    private int numberOfFemales;
    private ArrayList<String> maleNames;
    private ArrayList<String> femaleNames;
    private int numberOfAnagrams = 0;

    public static Drugi getInstance() {
        if(instance == null){
            instance = new Drugi();
        }
        return instance;
    }

    public void drugi(){
        getNumberOfGuest();
    }

    private void getNumberOfGuest() {
        Scanner input = new Scanner(System.in);

        System.out.print("Koliko dolazi momaka na zurku : ");
        numberOfMales = input.nextInt();
        System.out.print("Koliko dolazi djevojaka na zurku : ");
        numberOfFemales = input.nextInt();

        initializeArrayLists();
        fillArrayLists();
        findAnagrams();
    }

    private void findAnagrams(){

        for(int i = 0 ; i < femaleNames.size() ; i++) {
            for( int y = 0 ; y < maleNames.size() ; y++) {
                if(isAnagram(femaleNames.get(i), maleNames.get(y))){
                    numberOfAnagrams++;
                    femaleNames.remove(i);
                    maleNames.remove(y);
                }
            }
        }
        System.out.println("Number of anagrams = " + numberOfAnagrams);
    }

    private boolean isAnagram(String str1, String str2) {
        boolean status = true;

        str1 = str1.replaceAll("\\s", "");
        str2 = str2.replaceAll("\\s", "");

        if(str1.length() != str2.length()) {
            status = false;
        } else {
          char[] aS1 = str1.toLowerCase().toCharArray();
          char[] aS2 = str2.toLowerCase().toCharArray();
            Arrays.sort(aS1);
            Arrays.sort(aS2);
            status = Arrays.equals(aS1, aS2);
        }

        return status;
    }

    private void fillArrayLists(){
        Scanner input = new Scanner(System.in);

        for(int i = 0 ; i < numberOfMales ; i++) {
            System.out.print("Unesite ime " + (i+1) + " momka : ");
            String name = input.nextLine();
            maleNames.add(name);
        }
        for(int i = 0 ; i < numberOfFemales ; i++) {
            System.out.print("Unesite ime " + (i+1) + " djevojke : ");
            String name = input.nextLine();
            femaleNames.add(name);
        }
    }

    private void initializeArrayLists(){
        maleNames = new ArrayList<>(numberOfMales);
        femaleNames = new ArrayList<>(numberOfFemales);
    }
}
