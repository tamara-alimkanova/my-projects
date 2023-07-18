import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

interface TaskManager {


    public default int createTask(Task task) {

        return 0;
    }

    public default void updateTask(Task task) {
    }

    public default void deleteTasks() {
    }

    public default void deleteSpecificTask(int id) {
    }

    public default Task getTaskById(int id) {
        return null;
    }

    public default List<Task> getTasks() {

        return null;
    }

    public default int createEpic(Epic epic) {

        return 0;
    }

    public default void updateEpic(Epic epic) {

    }

    public default void deleteEpics() {

    }

    public default void deleteSpecificEpic(int id) {

    }

    public default Epic getEpicById(int id) {

        return null;
    }

    public default List<Epic> getEpics() {

        return null;
    }

    public default int createSubtask(Subtask subtask) {

        return 0;
    }

    public default void updateSubtask(Subtask subtaskToUpdate) {
    }

    public default void deleteSubtaskById(int id) {

    }

    public default void deleteSubtasks() {

    }

    public default Subtask getSubtaskById(int id) {

        return null;
    }

    public default List<Subtask> getSubtask() {

        return null;
    }

    public default List<Subtask> getEpicsSubtask(int epicId) {

        return null;
    }

    public default void updateEpicStatus(int epicId) {
    }


}
