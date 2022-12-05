package survey.model;

public class Member {
    public int id;
    public String fullName;
    public String emailAddress;
    public boolean isActive;

    public Member(int id, String fullName, String emailAddress, boolean isActive) {
        this.id = id;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
