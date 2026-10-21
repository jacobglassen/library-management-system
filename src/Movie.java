public class Movie extends Resource{
String director;
double length;
    public Movie(int Identifier, String title, String creator, String director, double length){
        super(Identifier, title, creator);
        this.director = director;
        this.length = length;
    }
    @Override
    public String toString(){
        return String.format("""
                %s - %s, %s; %s
                Runtime: %f.2 minutes""", title, director, creator, Identifier, length);
    }
}
