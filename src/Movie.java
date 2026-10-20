public class Movie extends Resource{
String director;
double length;
    public Movie(int Identifier, String title, String creator, String director, double length){
        super(Identifier, title, creator);
        this.director = director;
        this.length = length;
    }
}
