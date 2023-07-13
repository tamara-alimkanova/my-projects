import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager {
    protected int genId;
    protected HashMap<Integer, Task> task = new HashMap<>();
    protected HashMap<Integer, Subtask> subtask = new HashMap<>();
    protected HashMap<Integer, Epic> epic = new HashMap<>();

    public int createTask(Task task) {
        task.setId(genId++);
        task.setStatus("NEW");
        this.task.put(task.getId(), task);
        return task.getId();
    }

    public void updateTask(Task task) {
        if (this.task.containsKey(task.getId())) {
            this.task.put(task.getId(), task);
        }
    }

    public void deleteTask() {
        this.task.clear();
    }

    public void deleteTaskById(int id) {
        this.task.remove(id);
    }

    public Task getTaskById(int id) {
        return this.task.get(id);
    }

    public List<Task> getTasks() {
        return new ArrayList<>(this.task.values());
    }

    public int createEpic(Epic epic) {
        epic.setId(genId);
        epic.setStatus("NEW");
        this.epic.put(epic.getId(), epic);
        return epic.getId();
    }
}
