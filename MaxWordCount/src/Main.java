import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.print("Lütfen bir cümle giriniz: ");
        String str = inp.nextLine();

        // Cümleyi boşluklarla ayırıyoruz ( " " ) ve her bir kelimeyi bir dizide tutuyoruz.

        String[] splitStr = str.split(" ");

       LinkedHashMap<String, Integer> wordMap = new LinkedHashMap<>();


        for(String word : splitStr) {
            if (wordMap.containsKey(word)){
                wordMap.put(word, wordMap.get(word) + 1);
            }
            else { wordMap.put(word, 1);
        }

        }

        System.out.println("Yazıdaki en çok geçen kelime: " +
                Collections.max(wordMap.entrySet(), Map.Entry.comparingByValue()).getKey() + "\nKullanım sayısı: " +
                Collections.max(wordMap.entrySet(), Map.Entry.comparingByValue()).getValue());

    }
}