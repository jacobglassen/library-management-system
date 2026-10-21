    public class Resource {
    int Identifier;
    String title;
    String creator;

    public Resource(int identifier, String title, String creator) {
        this.Identifier = identifier;
        this.title = title;
        this.creator = creator;
    }
    // Getters
    public int getIdentifier() {
        return Identifier;
    }

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }
    // Setters

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
