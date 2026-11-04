public static void main(String[] args) {

    LoanPolicy policy = new StandardLoanPolicy();
    Library library = new Library(policy);

    CsvMapper mapper = new CsvMapper(library);

    LibraryLoader loader = new LibraryLoader(mapper, library);
    LibrarySaver saver = new LibrarySaver(mapper);

    loader.loadAll();

    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();

    saver.saveAll(library);
}