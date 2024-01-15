import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class Main {
    public static void returnArray(int i){
        int [] inputArray = {1,5,10,25,35,45,50,100,200,12345};
        for (int element : inputArray) {
            if (inputArray[i] == element) {
                System.out.println(element);
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Lütfen 10 elemanlı dizide erişmek istediğiniz sırayı giriniz: ");
        int selectedArrayIndex = inp.nextInt();

        try {
            returnArray(selectedArrayIndex);
        }
        catch (Exception e){
            System.out.println("Lütfen 0 ve 9 sayıları arasında bir seçim yapınız! ");
        }

    }
}