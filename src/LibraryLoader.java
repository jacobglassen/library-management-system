import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibraryLoader {
    private final CsvMapper csvMapper;

    public LibraryLoader(CsvMapper csvMapper){
        this.csvMapper = csvMapper;
    }
    public void loadAll(){

    }

    public List<Member> loadMembers(String filename) throws IOException{
        Path path = Path.of(filename);
        List<Member> members = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while ((line = reader.readLine()) != null){
                Member member = csvMapper.fromCsv(line);
                members.add(member);
            }
        }
        return members;
    }
    public List<Loan> loadLoans(String filename) throws IOException{
        Path path = Path.of(filename);
        List<Loan> loans = new ArrayList<>();
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while ((line = reader.readLine()) != null){
                Loan loan = csvMapper.loanFromCsv(line);
                loans.add(loan);
            }
        }
        return loans;
    }
}
