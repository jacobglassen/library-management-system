public class VideoGame extends Resource{
    String platform;
    public VideoGame(int identifier, String title, String creator, String platform) {
        super(identifier, title, creator);
        this.platform = platform;
    }
}
