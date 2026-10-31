public class Movie extends Resource{
String director;
double length;
    public Movie(int Identifier, String title, String creator, String director, double length){
        super(Identifier, title, creator);
        this.director = director;
        this.length = length;
    }
    public String getDirector(){
        return director;
    }
    public double getLength(){
        return length;
    }
    @Override
    public String toString(){
        return String.format("""
                %s - %s, %s; %s
                Runtime: %.2f minutes""", title, director, creator, Identifier, length);
    }
}
