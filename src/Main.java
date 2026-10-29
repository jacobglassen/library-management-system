void main() {
    LoanPolicy policy = new StandardLoanPolicy();
    Library library = new Library(policy);
    ConsoleUI consoleUI = new ConsoleUI(library);

    consoleUI.run();




    }