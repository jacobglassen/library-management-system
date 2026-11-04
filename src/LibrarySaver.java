import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibrarySaver {

    private final CsvMapper csvMapper;
    private final Path libraryPath;

    public LibrarySaver(CsvMapper csvMapper,
                        Path libraryPath){
        this.csvMapper = csvMapper;
        this.libraryPath = libraryPath;
    }
    public LibrarySaver(CsvMapper csvMapper) {
        this(csvMapper, Path.of("."));
    }

    public void saveAll(Library library) {

        try {

            saveMembers(
                    library.getMembers(),
                    "members.csv");

            saveLoans(
                    library.getLoans(),
                    "loans.csv");

            saveBooks(
                    library.getBooks(),
                    "books.csv");

            saveAudiobooks(
                    library.getAudiobooks(),
                    "audiobooks.csv");

            saveMovies(
                    library.getMovies(),
                    "movies.csv");

            saveVideoGames(
                    library.getVideoGames(),
                    "videogames.csv");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveMembers(List<Member> members, String filename) throws IOException{
        Path path = libraryPath.resolve(filename);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for (Member member : members){
                writer.write(csvMapper.toCsv(member));
                writer.newLine();
            }
        }
    }
    public void saveLoans(List<Loan> loans, String filename) throws IOException{
        Path path = libraryPath.resolve(filename);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for (Loan loan : loans){
                writer.write(csvMapper.toCsv(loan));
                writer.newLine();
            }
        }
    }
    public void saveBooks(List<Book> books, String filename) throws IOException{
        Path path = libraryPath.resolve(filename);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for (Book book : books){
                writer.write(csvMapper.toCsv(book));
                writer.newLine();
            }
        }
    }
    public void saveMovies(List<Movie> movies, String filename) throws IOException{
        Path path = libraryPath.resolve(filename);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for (Movie movie : movies){
                writer.write(csvMapper.toCsv(movie));
                writer.newLine();
            }
        }
    }
    public void saveAudiobooks(List<AudioBook> audioBooks, String filename) throws IOException{
        Path path = libraryPath.resolve(filename);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for (AudioBook audioBook : audioBooks){
                writer.write(csvMapper.toCsv(audioBook));
                writer.newLine();
            }
        }
    }
    public void saveVideoGames(List<VideoGame> videoGames, String filename) throws IOException{
        Path path = libraryPath.resolve(filename);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for (VideoGame videoGame : videoGames){
                writer.write(csvMapper.toCsv(videoGame));
                writer.newLine();
            }
        }
    }
}
