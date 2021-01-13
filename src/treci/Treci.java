package treci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Treci {

    private static Treci instance;

    private int m;
    private int n;

    public static Treci getInstance() {
        if(instance == null){
            instance = new Treci();
        }
        return instance;
    }

    public void treci(){
        getGCD();
    }

    private void getGCD() {
        userInputNumbers();
        int gcd = findGCD(m, n);
        System.out.println("NZD je " + gcd);
    }

    private int findGCD(int m, int n) {
        if (m % n == 0) {
            return n;
        }else {
            return findGCD(n, m % n);
        }
    }

    private void userInputNumbers(){
        Scanner input = new Scanner(System.in);

        System.out.print("Unesite prvi broj : ");
        m = input.nextInt();
        System.out.print("Unesite drugi broj : ");
        n = input.nextInt();
    }
}
