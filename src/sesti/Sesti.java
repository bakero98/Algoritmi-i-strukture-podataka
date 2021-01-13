package sesti;

import java.util.*;

//        Za dati niz dužine n ispitati da li u njemu postoji element koji se javlja vise od n/2 puta.
//        Ulaz                          Izlaz
//        n = 9                          Da, broj je 5
//        5 7 1 1 5 5 2 5 5
public class Sesti {
    private static Sesti instance;

    public static Sesti getInstance() {
        if(instance == null){
            instance = new Sesti();
        }
        return instance;
    }

    public void sesti(){
        getArray();
    }

    private void getArray() {
        Scanner input = new Scanner(System.in);

        System.out.print("Unesite velicinu niza : ");
        int arraySize = input.nextInt();
        int[] array = new int[arraySize];

        for(int i = 0 ; i < arraySize ; i++) {
            System.out.print("Unesite element na poziciji " + (i+1) + " : ");
            array[i] = input.nextInt();
        }
        doLogic(array);
    }

    private void doLogic(int[] array){
        int x = array.length/2;
        HashMap<Integer, Integer> mapa = new HashMap<>();

        for( int i = 0 ; i < array.length ; i++ ) {
            if(!mapa.containsKey(array[i])){
                mapa.put(array[i], 1);
            }else{
                mapa.put(array[i], mapa.get(array[i]) + 1);
            }
        }

        for (Map.Entry broj : mapa.entrySet() ) {
            Integer temp = (Integer) broj.getValue();
            if (temp > x ) {
                System.out.println("Da, broj je " + broj.getKey());
                break;
            }
        }
    }

}
