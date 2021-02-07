package zadatak3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Zadatak3 {
    private static Zadatak3 instance;


    public static Zadatak3 getInstance() {
        if (instance == null) {
            instance = new Zadatak3();
        }
        return instance;
    }

    public void zadatak3() {
        start();
    }

    private void start() {
        String rijeci[] = {"ja", "sad", "asda", "aaaa", "a", "asd", "asdadasda", "asdsd"};
        selectionSort(rijeci);
    }

    private void selectionSort(String[] list){
        for (int i = 0; i < list.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < list.length; j++){
                if (list[j].length() < list[index].length()){
                    index = j;//searching for lowest index
                }
            }
            String smallerNumber = list[index];
            list[index] = list[i];
            list[i] = smallerNumber;
        }

        writeToFile(list);
    }

    private void writeToFile(String[] list) {
        try {
            FileWriter myWriter = new FileWriter("izlaz.txt");
            for (String s : list) {
                myWriter.write(s + "\n");
            }
            myWriter.close();

            String zaRegex = "//cao/*jeste*?";
            zaRegex = zaRegex.replaceAll("/\\*(.|\\n)*?\\*/", "");
//            System.out.print(zaRegex.replaceAll("/\*(.|\n)*?\*/", ""));
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
