void main() {
    Library library = new Library();
    ConsoleUI consoleUI = new ConsoleUI(library);
//    Book book1 = new Book("George Orwell", "1984", "9780140817744", 1);
//    Book book2 = new Book("Homer", "The Odyssey", "9780060904791", 2);
//    Book book3 = new Book("Kurt Vonnegut", "Slaughterhouse Five", "9780224618014", 3);

    Book book1 = new Book(9780, "Slaughterhouse Five", "Kurt Vonnegut", 475);
    Movie movie1 = new Movie(20, "Human Centipede", "MF Studios", "Mads Frahm", 120.20);
    Member member1 = new Member("Donald Trump", 1);
    Member member2 = new Member("Jørgen Leth", 2);
    Member member3 = new Member("Pelle Dragsted", 3);

    library.addResource(book1);
    library.addResource(movie1);

    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);

    consoleUI.run();




    }