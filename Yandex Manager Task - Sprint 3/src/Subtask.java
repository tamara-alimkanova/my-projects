public class Subtask extends Task{
    Subtask(String name, String description, String status) {
        super(name, description, status);
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "id=" + id +
                '}';
    }
}
