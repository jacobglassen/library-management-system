public record Member(String name, int memberId) implements Comparable<Member>{
    @Override
    public String toString(){
        return String.format("""
                    %s
                    Medlemsnummer: %d""", name, memberId);
    }

    @Override
    public int compareTo(Member o) {
        return Integer.compare(this.memberId, o.memberId);
    }
}

