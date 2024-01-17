import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Phone extends Electronics implements Operation{
    private static ArrayList<Phone> phoneList = new ArrayList<>();
    private int camera;
    private int batteryCapacity;
    private String color;
    private static int id = 1;
    boolean isRunning = true;
    Scanner scanner = new Scanner(System.in);

    public Phone(String name, double price, int discountRate, int stock, String brandName, String screenSize, int ram, int memory,
                 int camera, int batteryCapacity, String color) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, memory);
        this.camera = camera;
        this.batteryCapacity = batteryCapacity;
        this.color = color;
    }
    public Phone() {

    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void runMenu() {
        while(isRunning) {
            System.out.println("---------------------------");
            System.out.println("Cep Telefonu Yönetim Paneli");
            System.out.println("---------------------------");
            System.out.println("1- Cep Telefonu Ekleme \n" +
                    "2- Cep Telefonu Silme \n" +
                    "3- ID'ye Göre Filtreleme \n" +
                    "4- Markaya Göre Filtreleme \n" +
                    "5- Telefon Listeleme \n" +
                    "0- Çıkış Yap");
            System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");
            int selectOption = scanner.nextInt();

            // Üst üste next komutu yollayınca bug oluşuyordu o yüzden araya bir tane daha boş nextLine() ekledim.

            scanner.nextLine();
            switch (selectOption) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    filterByProductId();
                    break;
                case 4:
                    fiterbyProductBrand();
                    break;
                case 5:
                    showProductList();
                    break;
                case 0:
                    System.out.println("Çıkış yaptınız!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız. Lütfen tekrar giriş yapınız!");
            }
        }
    }

    @Override
    public void showProductList() {
        System.out.printf("----------------------------------------------------------------------------------------------------------------------" +
                "---------------------------------------------%n");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                "TELEFON ID", "MARKA", "MODEL", "FİYAT", "İNDİRİM %", "STOK ADEDİ", "EKRAN BOYUTU", "RAM", "HAFIZA", "KAMERA", "PİL KAPASİTESİ", "RENK");
        System.out.printf("--------------------------------------------------------------------------------------------------------" +
                "-----------------------------------------------------------%n");
        for(Phone phone: phoneList){
            System.out.printf("| %-10d | %-10s | %-10s | %-10.2s | %-10d | %-10d | %-12s | %-10s | %-10s | %-10s | %-14s | %-10s |%n",
                    phone.getId(), phone.getBrandName(),phone.getName(),phone.getPrice() + " TL", phone.getDiscountRate() ,phone.getStock(), phone.getScreenSize(),
                    phone.getRam() + " GB", phone.getMemory() + " GB", phone.camera + " MP", phone.batteryCapacity + " mAh" , phone.color);
            System.out.println();
        }
    }

    @Override
    public void addProduct() {
        boolean isListed = true;
        Phone phone = new Phone();

        if (phone.getId() == 1) {
            phone.setId(1);
        }
        else {
            phone.setId(id++);
        }

        System.out.print("Ürün ismini giriniz: ");
        phone.setName(scanner.nextLine());

        System.out.print("Ürün fiyatını giriniz: ");
        phone.setPrice(scanner.nextDouble());

        System.out.print("Ürün indirim oranı giriniz: ");
        phone.setDiscountRate(scanner.nextInt());

        System.out.print("Ürün stok adedini giriniz: ");
        phone.setStock(scanner.nextInt()); // Consume nextInt()
        scanner.nextLine();

        while(isListed) {
            System.out.print("Ürünün markasını yazınız: ");

            // Markalarla eşleşip eşleşmediğini sorguluyoruz.

            Brand brands = new Brand();
            String brandNameInput = scanner.nextLine();

            if (brands.searchBrand(brandNameInput)) {
                phone.setBrandName(brandNameInput);
                isListed = false;
            }
        }

        System.out.print("Ürünün ekran boyutunu giriniz: ");
        phone.setScreenSize(scanner.nextLine());

        System.out.print("Ürünün ram boyutunu giriniz: ");
        phone.setRam(scanner.nextInt());
        scanner.nextLine(); // Consume nextInt()

        System.out.print("Ürünün depolama boyutunu giriniz: ");
        phone.setMemory(scanner.nextInt());
        scanner.nextLine(); // Consume nextInt()

        System.out.print("Ürünün kamera çözünürlüğünü giriniz: ");
        phone.setCamera(scanner.nextInt());
        scanner.nextLine(); // Consume nextInt()

        System.out.print("Ürünün pil kapasitesini giriniz: ");
        phone.setBatteryCapacity(scanner.nextInt());
        scanner.nextLine(); // Consume nextInt()

        System.out.print("Ürünün rengini giriniz: ");
        phone.setColor(scanner.nextLine());

        phoneList.add(phone);
        System.out.println("Girmiş olduğunuz ürün başarıyla eklendi!");
    }

    @Override
    public void deleteProduct() {
        boolean isDeleted = false;
        while(!isDeleted){
            System.out.print("Lütfen silmek istediğiniz ürünün ID numarasını giriniz: ");
            int removePhone = scanner.nextInt();

            if(notebookDelete(removePhone)) {
                isDeleted = true;
            }
        }
    }
    public boolean notebookDelete(int phoneID) {
        Iterator<Phone> it = phoneList.iterator();
        while(it.hasNext()) {
            Phone phone = it.next();
            if (phoneID == phone.getId()) {
                it.remove();
                System.out.println(phone.getName()+" başarıyla kaldırıldı!");
                return true;
            }
        }
        System.out.println("*** Eşleşme bulunumadı! Lütfen doğru bir ID numarası giriniz! ***");
        return false;
    }

    @Override
    public void filterByProductId() {
        boolean isListed = true;

        while(isListed) {
            System.out.print("Lütfen filtrelemek istediğiniz ID numarasını giriniz: ");

            // ID'lerle eşleşip eşleşmediğini sorguluyoruz.

                int IdInput = scanner.nextInt();
            if(phoneList.isEmpty()) {
                System.out.println("*** Eşleşme bulunumadı! ***");
                isListed = false;
            }

                // ArrayList boş olma kontrolü

                for (Phone phone : phoneList) {
                    if(phone.getId() != IdInput){
                        System.out.println("*** Eşleşme bulunumadı! ***");
                        isListed = false;
                    }
                    else if (phone.getId() == IdInput) {
                        System.out.printf("---------------------------------------------------------------------------------------------------------------------------" +
                                "---------------------------------------------%n");
                        System.out.printf("| %-10s | %-10s | %-15s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                                "TELEFON ID", "MARKA", "MODEL", "FİYAT", "İNDİRİM %", "STOK ADEDİ", "EKRAN BOYUTU", "RAM", "HAFIZA", "KAMERA", "PİL KAPASİTESİ", "RENK");
                        System.out.printf("-------------------------------------------------------------------------------------------------------------" +
                                "-----------------------------------------------------------%n");
                        System.out.printf("| %-10d | %-10s | %-15s | %-10.2f | %-10d | %-10d | %-12s | %-10s | %-10s | %-10s | %-14s | %-10s |%n",
                                phone.getId(), phone.getBrandName(), phone.getName(), phone.getPrice(), phone.getDiscountRate(), phone.getStock(), phone.getScreenSize(),
                                phone.getRam() + " GB", phone.getMemory() + " GB", phone.camera, phone.batteryCapacity + " mAh", phone.color);
                        System.out.println();
                        isListed = false;
                    }

            }
        }
    }

    @Override
    public void fiterbyProductBrand() {
        boolean isListed = true;

        while(isListed) {
            System.out.print("Lütfen filtrelemek istediğiniz markayı giriniz: ");

            // Markalarla eşleşip eşleşmediğini sorguluyoruz.

            Brand brand = new Brand();
            String brandNameInput = scanner.nextLine();

            if (brand.searchBrand(brandNameInput)) {

            for (Phone phone : phoneList) {
                if (phone.getBrandName().equals(brandNameInput)) {
                    System.out.printf("---------------------------------------------------------------------------------------------------------------------------" +
                            "---------------------------------------------%n");
                    System.out.printf("| %-10s | %-10s | %-15s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                            "TELEFON ID", "MARKA", "MODEL", "FİYAT", "İNDİRİM %", "STOK ADEDİ", "EKRAN BOYUTU", "RAM", "HAFIZA", "KAMERA", "PİL KAPASİTESİ", "RENK");
                    System.out.printf("-------------------------------------------------------------------------------------------------------------" +
                            "-----------------------------------------------------------%n");
                    System.out.printf("| %-10d | %-10s | %-15s | %-10.2f | %-10d | %-10d | %-12s | %-10s | %-10s | %-10s | %-14s | %-10s |%n",
                            phone.getId(), phone.getBrandName(), phone.getName(), phone.getPrice(), phone.getDiscountRate(), phone.getStock(), phone.getScreenSize(),
                            phone.getRam() + " GB", phone.getMemory() + " GB", phone.camera, phone.batteryCapacity + " mAh", phone.color);
                    System.out.println();
                }
            }
                isListed = false;
            }
        }
    }
}




