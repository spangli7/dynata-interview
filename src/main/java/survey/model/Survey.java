package survey.model;

public class Survey {
    public int id;
    public String name;
    public int expectedCompleted;
    public int completionPoints;
    public int filteredPoints;

    public Survey(int id, String name, int expectedCompleted, int completionPoints, int filteredPoints) {
        this.id = id;
        this.name = name;
        this.expectedCompleted = expectedCompleted;
        this.completionPoints = completionPoints;
        this.filteredPoints = filteredPoints;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", expectedCompleted=" + expectedCompleted +
                ", completionPoints=" + completionPoints +
                ", filteredPoints=" + filteredPoints +
                '}';
    }
}
