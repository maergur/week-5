import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Notebook extends Electronics implements Operation {
    private static ArrayList<Notebook> notebookList = new ArrayList<>();
    private static int id = 1;
    Scanner scanner = new Scanner(System.in);
    boolean isRunning = true;
    public Notebook(String name, double price, int discountRate, int stock, String brandName, String screenSize, int ram, int memory) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, memory);
    }
    public Notebook() {

    }

    @Override
    public void runMenu() {
        while(isRunning) {
            System.out.println("---------------------------");
            System.out.println("Notebook Yönetim Paneli");
            System.out.println("---------------------------");
            System.out.println("1- Notebook Ekleme \n" +
                    "2- Notebook Silme \n" +
                    "3- ID'ye Göre Filtreleme \n" +
                    "4- Markaya Göre Filtreleme \n" +
                    "5- Notebook Listeleme \n" +
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
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                "NOTEBOOK ID", "MARKA", "MODEL", "FİYAT", "İNDİRİM %", "STOK ADEDİ", "EKRAN BOYUTU", "RAM", "HAFIZA");
        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
        for(Notebook notebook: notebookList){
            System.out.printf("| %-11d | %-10s | %-10s | %-10.2f | %-10d | %-10d | %-12s | %-10s | %-10s |%n",
                    notebook.getId(), notebook.getBrandName(),notebook.getName(),notebook.getPrice(), notebook.getDiscountRate() ,notebook.getStock(), notebook.getScreenSize(),
                    notebook.getRam() + " GB", notebook.getMemory() + " GB");
            System.out.println();
        }
    }

    @Override
    public void addProduct() {
        boolean isListed = true;
        Notebook notebook = new Notebook();

        if (notebook.getId() == 1) {
            notebook.setId(1);
        }
        else {
            notebook.setId(id++);
        }

    System.out.print("Ürün ismini giriniz: ");
    notebook.setName(scanner.nextLine());

    System.out.print("Ürün fiyatını giriniz: ");
    notebook.setPrice(scanner.nextDouble());

    System.out.print("Ürün indirim oranı giriniz: ");
    notebook.setDiscountRate(scanner.nextInt());

    System.out.print("Ürün stok adedini giriniz: ");
    notebook.setStock(scanner.nextInt()); // Consume nextInt()
    scanner.nextLine();

    while(isListed) {
        System.out.print("Ürünün markasını yazınız: ");

        // Markalarla eşleşip eşleşmediğini sorguluyoruz.

        Brand brands = new Brand();
        String brandNameInput = scanner.nextLine();

        if (brands.searchBrand(brandNameInput)) {
            notebook.setBrandName(brandNameInput);
            isListed = false;
        }
    }

    System.out.print("Ürünün ekran boyutunu giriniz: ");
    notebook.setScreenSize(scanner.nextLine());

    System.out.print("Ürünün ram boyutunu giriniz: ");
    notebook.setRam(scanner.nextInt());
    scanner.nextLine(); // Consume nextInt()

    System.out.print("Ürünün depolama boyutunu giriniz: ");
    notebook.setMemory(scanner.nextInt());

    // Üst üste next komutu yollayınca bug oluşuyordu o yüzden araya bir tane daha boş nextLine() ekledim.

    notebookList.add(notebook);
    System.out.println("Girmiş olduğunuz ürün başarıyla eklendi!");
    }

    @Override
    public void deleteProduct() {
        boolean isDeleted = false;
        while(!isDeleted){
        System.out.print("Lütfen silmek istediğiniz ürünün ID numarasını giriniz: ");
        int removeNotebook = scanner.nextInt();

            if(notebookDelete(removeNotebook)) {
            isDeleted = true;
            }
        }
    }
    public boolean notebookDelete(int notebookID) {
        Iterator<Notebook> it = notebookList.iterator();
        while(it.hasNext()) {
            Notebook notebook = it.next();
            if (notebookID == notebook.getId()) {
                it.remove();
                System.out.println(notebook.getName()+" başarıyla kaldırıldı!");
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

            if(notebookList.isEmpty()) {
                System.out.println("*** Eşleşme bulunumadı! ***");
                isListed = false;
            }

            // ArrayList boş olma kontrolü

            for (Notebook notebook : notebookList) {
                if(notebook.getId() != IdInput){
                    System.out.println("*** Eşleşme bulunumadı! ***");
                    isListed = false;
                }
                else if (notebook.getId() == IdInput) {
                    System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
                    System.out.printf("| %-10s | %-10s | %-15s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                            "NOTEBOOK ID", "MARKA", "MODEL", "FİYAT", "İNDİRİM %", "STOK ADEDİ", "EKRAN BOYUTU", "RAM", "HAFIZA");
                    System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
                    System.out.printf("| %-11d | %-10s | %-15s | %-10.2f | %-10d | %-10d | %-12s | %-10s | %-10s |%n",
                            notebook.getId(), notebook.getBrandName(), notebook.getName(), notebook.getPrice(), notebook.getDiscountRate(), notebook.getStock(), notebook.getScreenSize(),
                            notebook.getRam() + " GB", notebook.getMemory() + " GB");
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

            if(!brand.searchBrand(brandNameInput)){
                isListed = false;
            }
            else if (brand.searchBrand(brandNameInput)) {
                for (Notebook notebook : notebookList) {
                    if (notebook.getBrandName().equals(brandNameInput)) {
                        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
                        System.out.printf("| %-10s | %-10s | %-15s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |%n",
                                "NOTEBOOK ID", "MARKA", "MODEL", "FİYAT", "İNDİRİM %", "STOK ADEDİ", "EKRAN BOYUTU", "RAM", "HAFIZA");
                        System.out.printf("-------------------------------------------------------------------------------------------------------------------------%n");
                        System.out.printf("| %-11d | %-10s | %-15s | %-10.2f | %-10d | %-10d | %-12s | %-10s | %-10s |%n",
                                notebook.getId(), notebook.getBrandName(), notebook.getName(), notebook.getPrice(), notebook.getDiscountRate(), notebook.getStock(), notebook.getScreenSize(),
                                notebook.getRam() + " GB", notebook.getMemory() + " GB");
                        System.out.println();
                        isListed = false;
                    }
                }

            }
            }

        }

    }


