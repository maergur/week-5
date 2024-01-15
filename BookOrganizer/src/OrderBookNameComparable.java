import java.util.Comparator;

public class OrderBookNameComparable implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getBookName().compareTo(o2.getBookName());

    }
}
