import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibraryLoader {

    private final CsvMapper csvMapper;
    private final Library library;
    private final Path libraryPath;

    public LibraryLoader(CsvMapper csvMapper,
                         Library library,
                         Path libraryPath) {
        this.csvMapper = csvMapper;
        this.library = library;
        this.libraryPath = libraryPath;
    }

    public void loadAll() {

        try {
            for (Member member : loadMembers("members.csv")) {
                library.addMember(member);
            }
        } catch (IOException e) {
            System.out.println("members.csv not found");
        }

        try {
            for (Book book : loadBooks("books.csv")) {
                library.addResource(book);
            }
        } catch (IOException e) {
            System.out.println("books.csv not found");
        }

        try {
            for (Movie movie : loadMovies("movies.csv")) {
                library.addResource(movie);
            }
        } catch (IOException e) {
            System.out.println("movies.csv not found");
        }

        try {
            for (AudioBook audioBook : loadAudiobooks("audiobooks.csv")) {
                library.addResource(audioBook);
            }
        } catch (IOException e) {
            System.out.println("audiobooks.csv not found");
        }

        try {
            for (VideoGame videoGame : loadVideoGames("videogames.csv")) {
                library.addResource(videoGame);
            }
        } catch (IOException e) {
            System.out.println("videogames.csv not found");
        }

        try {
            for (Loan loan : loadLoans("loans.csv")) {
                library.addLoan(loan);
            }
        } catch (IOException e) {
            System.out.println("loans.csv not found");
        }
    }

    public List<Member> loadMembers(String filename)
            throws IOException {

        Path path = libraryPath.resolve(filename);
        List<Member> members = new ArrayList<>();

        try (BufferedReader reader =
                     Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                members.add(csvMapper.fromCsv(line));
            }
        }

        return members;
    }

    public List<Loan> loadLoans(String filename)
            throws IOException {

        Path path = libraryPath.resolve(filename);
        List<Loan> loans = new ArrayList<>();

        try (BufferedReader reader =
                     Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                loans.add(csvMapper.loanFromCsv(line));
            }
        }

        return loans;
    }

    public List<Book> loadBooks(String filename) throws IOException {

        Path path = libraryPath.resolve(filename);
        List<Book> books = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                books.add(csvMapper.bookFromCsv(line));
            }
        }

        return books;
    }
    public List<Movie> loadMovies(String filename) throws IOException {

        Path path = libraryPath.resolve(filename);
        List<Movie> movies = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                movies.add(csvMapper.movieFromCsv(line));
            }
        }

        return movies;
    }
    public List<AudioBook> loadAudiobooks(String filename) throws IOException {

        Path path = libraryPath.resolve(filename);
        List<AudioBook> audioBooks = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                audioBooks.add(csvMapper.audioBookFromCsv(line));
            }
        }

        return audioBooks;
    }
    public List<VideoGame> loadVideoGames(String filename) throws IOException {

        Path path = libraryPath.resolve(filename);
        List<VideoGame> videoGames = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {

            String line;

            while ((line = reader.readLine()) != null) {
                videoGames.add(csvMapper.videoGameFromCsv(line));
            }
        }

        return videoGames;
    }
}