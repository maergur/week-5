import java.util.TreeSet;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        sortBooks();
    }
public static void sortBooks(){
    Book harryPotter = new Book("Harry Potter", "JK Rowling", 1997,223);
    Book charlieChocolate = new Book ("Charlie and the Chocolate Factory", "Roald Dahl", 1964, 192);
    Book hobbit = new Book ("Hobbit", "JRR Tolkien", 1937, 426);
    Book dune = new Book ("Dune", "Frank Herbert", 1965, 896);
    Book annaKarenina = new Book ("Anna Karenina", "Lev Tolstoy", 1878, 864);

    // İsim ile sıralamak için TreeSet oluşuturuyoruz.

    TreeSet<Book> nameComparator = new TreeSet<>(new OrderBookNameComparable());
    nameComparator.add(harryPotter);
    nameComparator.add(charlieChocolate);
    nameComparator.add(hobbit);
    nameComparator.add(dune);
    nameComparator.add(annaKarenina);

    System.out.println("İsme Göre Kitap Sıralaması:");
    System.out.println("---------------------------");


    for (Book books : nameComparator) {
        System.out.println(books.getBookName());
    }

    // Sayfa sayısı ile sıralamak için TreeSet oluşuturuyoruz.

// İsim ile sıralamak için TreeSet oluşuturuyoruz.

    TreeSet<Book> pageComparator = new TreeSet<>(new OrderPageNumberComparable());
    pageComparator.add(harryPotter);
    pageComparator.add(charlieChocolate);
    pageComparator.add(hobbit);
    pageComparator.add(dune);
    pageComparator.add(annaKarenina);

    System.out.println("---------------------------");
    System.out.println("Sayfaya Göre Kitap Sıralaması:");
    System.out.println("---------------------------");




    for (Book books : pageComparator) {
        System.out.println(books.getBookName() + ": " + books.getPageNum());
    }
}

}