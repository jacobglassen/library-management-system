public record Book(String author, String title, String isbn, int id) {
    @Override
    public String toString() {
        return String.format("""
                        %s: %s; ISBN %s (%d)""",
                author, title, isbn, id);
    }
}
