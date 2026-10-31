public class VideoGame extends Resource{
    String platform;
    public VideoGame(int identifier, String title, String creator, String platform) {
        super(identifier, title, creator);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    @Override
    public String toString(){
        return String.format("""
                %s - %s, %s; %d""", title, creator, platform, Identifier);
    }
}
