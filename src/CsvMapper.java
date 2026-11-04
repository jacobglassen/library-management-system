import java.time.LocalDate;

public class CsvMapper {

    private final Library library;
    private final String delimiter = ",";

    public CsvMapper() {
        this.library = null;
    }
    public CsvMapper(Library library) {
        this.library = library;
    }

    public Member fromCsv(String line) {
        String[] tokens = line.split(delimiter, -1);

        return new Member(
                tokens[0],
                Integer.parseInt(tokens[1]));
    }

    public Loan loanFromCsv(String line) {

        String[] tokens = line.split(delimiter, -1);

        int resourceId = Integer.parseInt(tokens[0]);
        int memberId = Integer.parseInt(tokens[1]);

        Resource resource = library.getResource(resourceId);
        Member member = library.getMemberId(memberId);

        return new Loan(
                resource,
                member,
                LocalDate.parse(tokens[2]),
                LocalDate.parse(tokens[3]));
    }
    public Book bookFromCsv(String line) {

        String[] tokens = line.split(delimiter, -1);

        return new Book(
                Integer.parseInt(tokens[0]),
                tokens[1],
                tokens[2],
                Integer.parseInt(tokens[3]));
    }

    public Movie movieFromCsv(String line) {

        String[] tokens = line.split(delimiter, -1);

        return new Movie(
                Integer.parseInt(tokens[0]),
                tokens[1],
                tokens[2],
                tokens[3],
                Double.parseDouble(tokens[4]));
    }

    public VideoGame videoGameFromCsv(String line) {

        String[] tokens = line.split(delimiter, -1);

        return new VideoGame(
                Integer.parseInt(tokens[0]),
                tokens[1],
                tokens[2],
                tokens[3]);
    }

    public AudioBook audioBookFromCsv(String line) {

        String[] tokens = line.split(delimiter, -1);

        return new AudioBook(
                Integer.parseInt(tokens[0]),
                tokens[1],
                Integer.parseInt(tokens[3]),
                tokens[2]);
    }
    public String toCsv(Member member) {
        return member.name()
                + delimiter
                + member.memberId();
    }

    public String toCsv(Loan loan) {
        return loan.getResource().getIdentifier()
                + delimiter
                + loan.getMember().memberId()
                + delimiter
                + loan.getBorrowedDate()
                + delimiter
                + loan.getDueDate();
    }

    public String toCsv(Book book) {
        return book.getIdentifier()
                + delimiter
                + book.getTitle()
                + delimiter
                + book.getCreator()
                + delimiter
                + book.getPages();
    }

    public String toCsv(Movie movie) {
        return movie.getIdentifier()
                + delimiter
                + movie.getTitle()
                + delimiter
                + movie.getCreator()
                + delimiter
                + movie.getDirector()
                + delimiter
                + movie.getLength();
    }

    public String toCsv(VideoGame videoGame) {
        return videoGame.getIdentifier()
                + delimiter
                + videoGame.getTitle()
                + delimiter
                + videoGame.getCreator()
                + delimiter
                + videoGame.getPlatform();
    }

    public String toCsv(AudioBook audioBook) {
        return audioBook.getIdentifier()
                + delimiter
                + audioBook.getTitle()
                + delimiter
                + audioBook.getCreator()
                + delimiter
                + audioBook.getDuration();
    }
}