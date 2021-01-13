package cetvrti;

import java.util.Scanner;

//Napisati rekurzivnu funkciju koja određuje da li je zbir cifara nekog celog broja paran.

public class Cetvrti {

    private static Cetvrti instance;

    private int number;

    public static Cetvrti getInstance() {
        if(instance == null){
            instance = new Cetvrti();
        }
        return instance;
    }

    public void cetvrti(){
        getNumber();
        if(isSumOfDigitsEven(number, 0)){
            System.out.println("Zbir cifara unijetog broja je paran broj");
        }else{
            System.out.println("Zbir cifara unijetog broja je neparan broj");
        }
    }

    private boolean isSumOfDigitsEven(int number, int sum) {
        int suma = sum + number;
        if (number <= 0) {
            if (suma % 2 == 0) {
                return true;
            } else {
                return false;
            }
        }
        return isSumOfDigitsEven(number / 10, suma);
    }


    private void getNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Unesite broj : ");
        number = input.nextInt();
    }

}
