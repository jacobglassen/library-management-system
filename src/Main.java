public static void main(String[] args) {

    if(args.length == 0) {
        IO.println(/*Sti til mappen*/);
        return;
    }

    Path libraryPath = Path.of(args[0]);

    if(!Files.isDirectory(libraryPath)){
        IO.println("Datamappen findes ikke: " + libraryPath);
    }

    LoanPolicy policy = new StandardLoanPolicy();
    Library library = new Library(policy);

    CsvMapper mapper = new CsvMapper(library);

    LibraryLoader loader = new LibraryLoader(mapper, library, libraryPath);
    LibrarySaver saver = new LibrarySaver(mapper, libraryPath);

    loader.loadAll();

    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();

    saver.saveAll(library);
}