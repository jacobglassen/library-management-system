import java.util.ArrayList;

public class ConsoleUI {
    private final Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void run() {
//        library.createMembers();
//        library.createResource();
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("Indtast hvilken menu, du vil tilgå: "));
            switch (choice) {
                case 1 -> borrowResource();
                case 2 -> returnResource();
                case 3 -> showLoans();
                case 4 -> createMember();
                case 5 -> createBook();
                case 6 -> sortLibrary();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg. Prøv igen");
            }
        }
    }

    private void showMenu() {
        IO.println();
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis alle lån");
        IO.println("4. Opret medlem");
        IO.println("5. Opret bog");
        IO.println("6. Sorter lister");
        IO.println("0. Afslut");
        IO.println();
    }

    private void borrowResource() {
        int id = Integer.parseInt(IO.readln("Angiv materialets ID: "));
        int memberId = Integer.parseInt(IO.readln("Angiv dit medlemsnummer: "));
        LoanResult isLoaned = library.loanResource(id, memberId);

        switch (isLoaned) {
            case SUCCESS -> IO.println("Lån registreret");
            case ALREADY_LOANED -> IO.println("Materialet er allerede udlånt");
            case MATERIAL_NOT_FOUND -> IO.println("Dette materiale findes ikke");
            case MEMBER_NOT_FOUND -> IO.println("Medlem findes ikke");
            case NOT_ALLOWED -> IO.println("Dette materiale kan desværre ikke udlånes");
        }
    }

    private void returnResource() {
        int id = Integer.parseInt(
                IO.readln("Angiv materialets ID: ")
        );

        int memberId = Integer.parseInt(
                IO.readln("Angiv dit medlemsnummer: ")
        );

        boolean canReturn = library.returnBook(id, memberId);

        if (canReturn) {
            IO.println("Aflevering registreret");
        } else {
            IO.println("Der er sket en fejl");
        }
    }

    private void showLoans() {
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));
        ArrayList<Loan> loans = library.findLoansByMemberId(memberId);

        if (loans.isEmpty()) {
            IO.println("Ingen lån fundet for dette medlem");
        } else {
            IO.println("Lån for medlem " + memberId + ":");
            IO.println("-------------");
            for (Loan loan : loans) {
                IO.println(loan);
            }
        }
    }
    public void createMember(){
        String name = (IO.readln("Angiv navn: "));
        int memberId = Integer.parseInt(IO.readln("Angiv medlemsnummer: "));
        if (library.doesMemberIdExist(memberId)){
            IO.println("Medlemsnummer findes allerede. Prøv igen");
        }
        else {
            library.createMemberInConsole(name, memberId);
            IO.println("Medlem oprettet");
        }
    }
    public void createBook(){
        String title = IO.readln("Angiv bogens titel: ");
        String creator = IO.readln("Angiv bogens forfatter: ");
        int bookId = Integer.parseInt(IO.readln("Angiv bogens ISBN: "));
        int pages = Integer.parseInt(IO.readln("Angiv bogens sidetal: "));
        if (library.doesResourceIdExist(bookId)){
            IO.println("ISBN findes allerede. Prøv igen");
        }
        else {
            library.createBookInConsole(bookId, title, creator, pages);
            IO.println("Bog oprettet");
        }
    }
    public void sortLibrary(){
        showMenuForSorting();
        int choice = Integer.parseInt(IO.readln("Angiv venligst dit valg: "));
        switch (choice){
            case 1 -> library.sortMembersById();
            case 2 -> library.sortResourcesByCreator();
            case 3 -> library.sortResourcesByTitle();
            case 4 -> library.sortLoansByLoanDate();
            case 0 -> {
                return;
            }
            default -> IO.println("Angiv et gyldigt input");

        }
    }
    public void showMenuForSorting(){
        IO.println();
        IO.println("1. Sorter medlemmer efter ID");
        IO.println("2. Sorter materialer efter forfatter");
        IO.println("3. Sorter materialer efter titel");
        IO.println("4. Sorter lån efter lånedato");
        IO.println("0. Gå tilbage");
        IO.println();
    }
}

