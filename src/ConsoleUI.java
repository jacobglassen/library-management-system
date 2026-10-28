import java.util.ArrayList;

public class ConsoleUI {
    private final Library library;

    public ConsoleUI(Library library){
        this.library = library;
    }
    public void run(){
        library.createMembers();
        library.createResource();
        boolean running = true;
        while (running){
            showMenu();
            int choice = Integer.parseInt(IO.readln("Indtast hvilken menu, du vil tilgå: "));
            switch (choice){
                case 1 -> borrowResource();
                case 2 -> returnResource();
                case 3 -> showLoans();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg. Prøv igen");
            }
        }
    }
    private void showMenu(){
        IO.println();
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis alle lån");
        IO.println("0. Afslut");
        IO.println();
    }
    private void borrowResource(){
        int id = Integer.parseInt(IO.readln("Angiv materialets ID: "));
        int memberId = Integer.parseInt(IO.readln("Angiv dit medlemsnummer: "));
        LoanResult isLoaned = library.loanResource(id, memberId);

        switch (isLoaned){
            case SUCCESS -> IO.println("Lån registreret");
            case ALREADY_LOANED -> IO.println("Materialet er allerede udlånt");
            case MATERIAL_NOT_FOUND -> IO.println("Dette materiale findes ikke");
            case MEMBER_NOT_FOUND -> IO.println("Medlem findes ikke");
            case NOT_ALLOWED -> IO.println("Dette materiale kan desværre ikke udlånes");
        }
    }
    private void returnResource(){
        int id = Integer.parseInt(
                IO.readln("Angiv materialets ID: ")
        );

        int memberId = Integer.parseInt(
                IO.readln("Angiv dit medlemsnummer: ")
        );

        boolean canReturn = library.returnBook(id, memberId);

        if (canReturn){
            IO.println("Aflevering registreret");
        } else {
            IO.println("Der er sket en fejl");
        }
    }
    private void showLoans(){
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));
        ArrayList<Loan> loans = library.findLoansByMemberId(memberId);

        if (loans.isEmpty()){
            IO.println("Ingen lån fundet for dette medlem");
        } else {
            IO.println("Lån for medlem " + memberId + ":");
            IO.println("-------------");
            for (Loan loan : loans){
                IO.println(loan);
            }
        }
        }
    }

