public class Member {
    final String name;
    final String memberID;

    public Member(String name, String memberID){
        this.name = name;
        this.memberID = memberID;
    }
    public String toString(){
        return String.format("""
                %s (%s)""", name, memberID);
    }

}

