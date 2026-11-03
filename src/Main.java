void main(String[] args) {
    String libraryPath = args[0];
    LoanPolicy policy = new StandardLoanPolicy();
    Library library = new Library(policy);
    ConsoleUI consoleUI = new ConsoleUI(library);

    consoleUI.run();




    }