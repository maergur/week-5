public  class Book {
    private String bookName;
    private String authorName;
    private int publishDate;
    public Book(String bookName, String authorName, int publishDate, int pageNum) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.publishDate = publishDate;
        this.pageNum = pageNum;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    private int pageNum;



}
