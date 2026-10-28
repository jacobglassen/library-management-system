void main() {
    Library library = new Library(new StandardLoanPolicy());
    ConsoleUI consoleUI = new ConsoleUI(library);

    consoleUI.run();




    }