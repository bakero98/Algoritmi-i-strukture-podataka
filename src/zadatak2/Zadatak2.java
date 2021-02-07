package zadatak2;

public class Zadatak2 {
    private static Zadatak2 instance;

    public static Zadatak2 getInstance() {
        if (instance == null) {
            instance = new Zadatak2();
        }
        return instance;
    }

    public void zadatak2() {
        start();
    }

    private void start() {
        String rijeci[] = {"ja", "sam", "balsa", "sam", "mugosa", "ja"};

        rijeci = removeDuplicates(rijeci);
        for (String s : rijeci) {
            System.out.print(s + ", ");
        }
    }

    public static String[] removeDuplicates(String[] words) {
        int end = words.length;

        for (int i = 0; i < end; i++) {
            for (int j = i + 1; j < end; j++) {
                if (words[i].equals(words[j])) {
                    words[j] = words[end - 1];
                    end--;
                    j--;
                }
            }
        }

        String[] toReturn = new String[end];
        System.arraycopy(words, 0, toReturn, 0, end);
        return toReturn;
    }
}
