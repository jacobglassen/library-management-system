public class Member {
    final String name;
    final int memberID;

    public Member(String name, int memberID){
        this.name = name;
        this.memberID = memberID;
    }
    public int getId(){
        return memberID;
    }
    public String toString(){
        return String.format("""
                %s (%s)""", name, memberID);
    }

}

