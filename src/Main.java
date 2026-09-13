void main() {
    Book book1 = new Book("George Orwell", "1984", "9780140817744", 1);
    Book book2 = new Book("Homer", "The Odyssey", "9780060904791", 2);
    Book book3 = new Book("Kurt Vonnegut", "Slaughterhouse Five", "9780224618014", 3);

    Member member1 = new Member("Donald Trump", "54353");

    book1.loanBook(member1);
    IO.println(book1);
    book1.returnBook();
    IO.println(book1);
}