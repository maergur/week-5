import java.util.TreeSet;
public class Brand implements Comparable<Brand> {
    private int id;
    private String name;
    private static int idCounter = 1;
    private final static TreeSet<Brand> brandList = new TreeSet<>();

    public Brand(String name) {
        this.id = idCounter++;
        this.name = name;
    }

    public Brand(){
    }

    static {
        brandList.add(new Brand("Samsung"));
        brandList.add(new Brand("Lenovo"));
        brandList.add(new Brand("Apple"));
        brandList.add(new Brand("Huawei"));
        brandList.add(new Brand("Casper"));
        brandList.add(new Brand("Asus"));
        brandList.add(new Brand("HP"));
        brandList.add(new Brand("Xiaomi"));
        brandList.add(new Brand("Monster"));
    }
    public void printBrand(){
        for(Brand brand : brandList) {
            System.out.println(" - " + brand.getName());
        }
    }

    // Marka ismini brandList içerisinde tarıyoruz.

    public boolean searchBrand(String name){
        for(Brand brand : brandList) {
            if (name.equals(brand.name)){
                return true;
            }
        }
        System.out.println("*** Eşleşme bulunumadı! ***");
        return false;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Brand o) {
        return this.name.compareTo(o.getName());
    }
}
