public class AudioBook extends Resource {
    int duration;
    public AudioBook(int identifier, String title, int duration, String creator) {
        super(identifier, title, creator);
        this.duration = duration;
    }
    @Override
    public String toString(){
        return String.format("""
                %s - %s, %d; %d""", title, creator, duration, Identifier);
        }
}
