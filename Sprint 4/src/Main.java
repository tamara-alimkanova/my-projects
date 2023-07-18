import java.util.List;

public class Main {
    public static void main(String[] args) {
        InMemoryTaskManager manager = new InMemoryTaskManager();
        Task task1 = new Task("task1", "hello", "NEW");
        int taskId1 = manager.createTask(task1);
        //Создание Epic
        Epic epic1 = new Epic("Epic 1", "Epic 1 description", "NEW");
        int epicId1 = manager.createEpic(epic1);

        //Создание Subtask
        Subtask subtask1 = new Subtask("Subtask 1", "Subtask 1 description", "NEW", epicId1);
        int subtaskId1 = manager.createSubtask(subtask1);

        //Обновление Task
        Task taskToUpdate = manager.getTaskById(taskId1);
        taskToUpdate.setName("Task 1 - Updated");
        manager.updateTask(taskToUpdate);

        //Обновление Epic
        Epic epicToUpdate = manager.getEpicById(epicId1);
        epicToUpdate.setDescription("Epic 1 - Updated");
        manager.updateEpic(epicToUpdate);

        //Обновление Subtask
        Subtask subtaskToUpdate = manager.getSubtaskById(subtaskId1);
        subtaskToUpdate.setName("Subtask 1 - Updated");
        manager.updateSubtask(subtaskToUpdate);

        //Получение Tasks
        List<Task> tasks = manager.getTasks();
        for (Task task : tasks) {
            System.out.println("Task: " + task.getName());
        }

        //Получение Epics
        List<Epic> epics = manager.getEpics();
        for (Epic epic : epics) {
            System.out.println("Epic: " + epic.getName());
        }

        //Получение Subtasks
        List<Subtask> subtasks = manager.getSubtask();
        for (Subtask subtask : subtasks) {
            System.out.println("Subtask: " + subtask.getName());
        }

        //Получение Epic Subtasks
        List<Subtask> epicSubtasks = manager.getEpicsSubtask(epicId1);
        for (Subtask subtask : epicSubtasks) {
            System.out.println("Epic Subtask: " + subtask.getName());
        }

        //Удаление Task
        manager.deleteSpecificTask(taskId1);

        //Удаление Epic
        manager.deleteSpecificEpic(epicId1);

        //Удаление Subtasks
        manager.deleteSubtasks();
    }
}
