public record Member(String name, int memberId) {
    @Override
    public String toString(){
        return String.format("""
                    %s (%d)""", name, memberId);
    }
}

