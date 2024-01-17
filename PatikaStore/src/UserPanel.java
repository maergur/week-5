import java.util.Scanner;

public class UserPanel {
    Scanner scanner = new Scanner(System.in);
    boolean isRunning = true;

    public void run (){
        while (isRunning) {
            System.out.println("---------------------------");
            System.out.println("Patika Store Yönetim Paneli");
            System.out.println("---------------------------");
            System.out.println("1- Notebook İşlemleri \n" +
                    "2- Cep Telefonu İşlemleri \n" +
                    "3- Marka İşmeleri \n" +
                    "0- Çıkış Yap");
            System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");
            int selectOption = scanner.nextInt();
            switch (selectOption) {
                case 1:
                    Notebook notebook = new Notebook();
                    notebook.runMenu();
                    break;
                case 2:
                    Phone phone = new Phone();
                    phone.runMenu();
                    break;
                case 3:
                    System.out.println("Markalarımız");
                    System.out.println("--------------");
                    Brand brand = new Brand();
                    brand.printBrand();
                    break;
                case 0:
                    System.out.println("Çıkış yaptınız!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("*** Hatalı giriş yaptınız. Lütfen tekrar giriş yapınız! ***");

            }

        }

    }
}
