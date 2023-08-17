package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Epic extends Task {
    protected ArrayList<Integer> subtaskId = new ArrayList<>();

   public Epic(String name, String description, Status status) {
        super(name, description, status);
    }

    public void addSubtask(int id) {
        if (id > 0) {
            subtaskId.add(id);
        }
    }

    public void cleanSubtaskId() {
        this.subtaskId.clear();
    }

    public List<Integer> getSubtaskId() {
        return subtaskId;
    }

    public void removeSubtask(int subtaskIds) {
        for (int i = 0; i < this.subtaskId.size(); i++) {
            if (subtaskId.get(i) == subtaskIds) {
                subtaskId.remove(i);
                return;
            }

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return Objects.equals(name, epic.name) &&
                Objects.equals(description, epic.description) &&
                Objects.equals(status, epic.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subtaskId);
    }

    @Override
    public String toString() {
        return "tasks.Epic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", id=" + id +
                '}';
    }

}
