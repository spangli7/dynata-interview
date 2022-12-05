package survey.model;

public class AllPointsByMember {
    public int completionPoints;
    public int filteredPoints;


    public AllPointsByMember(int completionPoints, int filteredPoints) {
        this.completionPoints = completionPoints;
        this.filteredPoints = filteredPoints;
    }

    @Override
    public String toString() {
        return "AllPointsByMember{" +
                "completionPoints=" + completionPoints +
                ", filteredPoints=" + filteredPoints +
                '}';
    }
}
