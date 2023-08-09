package managers;

import tasks.Epic;
import tasks.Subtask;
import tasks.Task;

import java.util.List;

public interface TaskManager {
    int createTask(Task task);
    void updateTask(Task task);
    void deleteTasks();
    void deleteTask(int id);

    void deleteSpecificTask(int id);

    Task getTaskById(int id);
    List<Task> getTasks();
    int createEpic(Epic epic);
    void updateEpic(Epic epic);
    void deleteEpics();
    void deleteEpic(int id);

    void deleteSpecificEpic(int id);

    Epic getEpicById(int id);
    List<Epic> getEpics();
    int createSubtask(Subtask subtask);
    void updateSubtask(Subtask subtask);
    void deleteSubtasks();
    void deleteSubtaskById(int id);
    Subtask getSubtaskById(int id);
    List<Subtask> getSubtasks();
    List<Subtask> getEpicSubtasks(int epicId);
    List<Task> getHistory();

    List<Subtask> getSubtask();

    List<Subtask> getEpicsSubtask(int epicId);

    void updateEpicStatus(int epicId);
}
