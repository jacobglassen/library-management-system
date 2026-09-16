void main() {
    Library library = new Library();
    ConsoleUI consoleUI = new ConsoleUI(library);
    Book book1 = new Book("George Orwell", "1984", "9780140817744", 1);
    Book book2 = new Book("Homer", "The Odyssey", "9780060904791", 2);
    Book book3 = new Book("Kurt Vonnegut", "Slaughterhouse Five", "9780224618014", 3);

    Member member1 = new Member("Donald Trump", 54353);
    Member member2 = new Member("Jørgen Leth", 54354);
    Member member3 = new Member("Pelle Dragsted", 54355);

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);
    consoleUI.run();




    }