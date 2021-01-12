package prvi;

import java.util.Scanner;

//        Napisati funkciju koja pronalazi sve brojeve od 100 do 100 000 koji imaju tu osobinu da su deljivi
//        brojem koji nastane rotacijom tog broja za jednu cifru. Primer: Neka je naš broj 142857, nakon
//        rotacije dobijeni broj je 714285. 142857 je delilac novonastalog broja. 714285=5×142857
public class Prvi {

    private static Prvi instance = null;

    public static Prvi getInstance() {
        if(instance == null) {
            instance = new Prvi();
        }
        return instance;
    }


    public static void prvi(){
        System.out.print("Unesite broj : ");
        Scanner input = new Scanner(System.in);
        int broj = input.nextInt();
        int reversed = getReversedInteger(broj);
        System.out.println("Vas broj je : " + broj);
        System.out.println("Okrenut je : " + reversed);
        findDivisors(reversed);
    }

    private static int getReversedInteger( int x ) {
        int reversed = 0;
        while( x != 0 ) {
            reversed = reversed * 10;
            reversed = reversed + x % 10;
            x = x/10;
        }
        return reversed;
    }

    private static void findDivisors( int x ){
        if(x > 100000){
            return;
        }
        int start = x;
        while ( start < 100){
            start += x;
        }

        for(int i = start; i <= 100000 ; i += x ) {
            if(i % x == 0) {
                System.out.print(i + ", ");
            }
        }
    }
}
