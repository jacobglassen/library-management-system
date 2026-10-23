public class Book extends Resource{
    int pages;
    public Book(int identifier, String title, String creator, int pages) {
        super(identifier, title, creator);
        this.pages = pages;
    }
    public int getPages(){
        return pages;
    }
    @Override
    public String toString(){
        return String.format("""
                %s - %s; %d""", creator, title, Identifier, pages);
    }
}
