package sedmi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sedmi {
    private static Sedmi instance;
    private CircularlyLinkedList<String> gosti;

    public static Sedmi getInstance() {
        if(instance == null){
            instance = new Sedmi();
        }
        return instance;
    }

    public void sedmi(){
        getArray();
    }

    private void getArray() {
        Scanner input = new Scanner(System.in);

        System.out.print("Unesite broj gostiju za stolom : ");
        int arraySize = input.nextInt();
        gosti = new CircularlyLinkedList<>();

        for(int i = 0 ; i < arraySize ; i++) {
            System.out.print("Unesite element na poziciji " + (i+1) + " : ");
            gosti.add(input.next());
        }


        doLogic();
    }

    private void doLogic(){
        System.out.print("Unesite broj za izbacivanje brojanjem : ");
        Scanner input = new Scanner(System.in);
        int broj = input.nextInt();
        gosti.removeEveryNextAtPositionUntilEmpty(broj);
//        for (int i = 0 ; i < gosti.size()*2 ; i++) {
//            System.out.println(gosti.getAt(i));
//        }
    }
}
