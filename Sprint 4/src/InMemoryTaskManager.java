import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager {
    protected int genId;
    protected HashMap<Integer, Task> task = new HashMap<>();
    protected HashMap<Integer, Subtask> subtask = new HashMap<>();
    protected HashMap<Integer, Epic> epic = new HashMap<>();

    @Override
    public int createTask(Task task) {
        task.setId(genId);
        genId++;
        task.setStatus("NEW");
        this.task.put(task.getId(), task);
        return task.getId();
    }

    @Override
    public void updateTask(Task task) {
        if (this.task.containsKey(task.getId())) {
            this.task.put(task.getId(), task);
        }
    }

    @Override
    public void deleteTasks() {
        this.task.clear();
    }

    @Override
    public void deleteSpecificTask(int id) {
        this.task.remove(id);
    }

    @Override
    public Task getTaskById(int id) {
        return this.task.get(id);
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(this.task.values());
    }


    @Override
    public int createEpic(Epic epic) {
        epic.setId(genId);
        genId++;
        epic.setStatus("NEW");
        this.epic.put(epic.getId(), epic);
        return epic.getId();
    }

    @Override
    public void updateEpic(Epic epic) {
        if (this.epic.containsKey(epic.getId())) {
            Epic tempEpic = this.epic.get(epic.getId());
            if (!tempEpic.getName().equals(epic.getName())) {
                tempEpic.setName(epic.getName());
            }
            if (!tempEpic.getDescription().equals(epic.getDescription())) {
                tempEpic.setDescription(epic.getDescription());
            }
        }
    }

    @Override
    public void deleteEpics() {
        epic.clear();
        subtask.clear();
    }

    @Override
    public void deleteSpecificEpic(int id) {
        if (epic.containsKey(id)) {
            Epic tempEpic = epic.get(id);
            List<Integer> tempSubtaskId = tempEpic.getSubtaskId();
            for (Integer subtaskId : tempSubtaskId) {
                subtask.remove(subtaskId);
            }
            epic.remove(id);
        }
    }

    @Override
    public Epic getEpicById(int id) {
        return epic.get(id);
    }

    @Override
    public List<Epic> getEpics() {
        return new ArrayList<>(epic.values());
    }

    @Override
    public int createSubtask(Subtask subtask) {
        Epic tempEpic = epic.get(subtask.epicId);
        if (tempEpic != null) {
            subtask.setId(genId++);
            subtask.setStatus("NEW");
            tempEpic.addSubtask(subtask.getId());
            this.subtask.put(subtask.getId(), subtask);
            updateEpicStatus(tempEpic.getId());
            return subtask.getId();
        } else {
            System.out.println("Error: There is no Epic with such ID.");
            return 0;
        }
    }

    @Override
    public void updateSubtask(Subtask subtaskToUpdate) {
        Epic epic1 = epic.get(subtaskToUpdate.getId());
        if (epic1 != null) {
            if (subtask.containsKey(subtaskToUpdate.getId())) {
                subtask.put(subtaskToUpdate.getId(), subtaskToUpdate);
                updateEpicStatus(epic1.getId());
            }
        }
    }

    @Override
    public void deleteSubtaskById(int id) {
        if (subtask.containsKey(id)) {
            Subtask subtask1 = subtask.get(id);
            subtask.remove(id);
            Epic epic1 = epic.get(subtask1.getEpicId());
            if (epic1 != null) {
                epic1.removeSubtask(id);
                updateEpicStatus(id);

            }
        }
    }

    @Override
    public void deleteSubtasks() {
        subtask.clear();
        for (Epic epic1 : epic.values()) {
            epic1.cleanSubtaskId();
            updateEpicStatus(epic1.getId());
        }
    }

    @Override
    public Subtask getSubtaskById(int id) {
        return subtask.get(id);
    }

    @Override
    public List<Subtask> getSubtask() {
        return new ArrayList<>(subtask.values());
    }

    @Override
    public List<Subtask> getEpicsSubtask(int epicId) {
        Epic epic1 = epic.get(epicId);
        if (epic1 == null) {
            return new ArrayList<>();
        }
        List<Integer> subtaskIds = epic1.getSubtaskId();
        ArrayList<Subtask> epicsSubtask = new ArrayList<>();
        for (Integer tempSubtask : subtaskIds) {
            Subtask subtask1 = subtask.get(tempSubtask);
            if (subtask1 != null) {
                epicsSubtask.add(subtask1);
            }
        }
        return epicsSubtask;
    }

    @Override
    public void updateEpicStatus(int epicId) {
        Epic epic1 = epic.get(epicId);
        boolean isDone = true;
        boolean isInProgress = false;
        for (Integer subtaskId : epic1.getSubtaskId()) {
            Subtask subtask1 = subtask.get(subtaskId);
            if (!subtask1.getStatus().equals("DONE")) {
                isDone = false;
            }
            if (subtask1.getStatus().equals("IN_PROGRESS")) {
                isInProgress = true;
            }
        }
        if (isDone && epic1.getSubtaskId().isEmpty()) {
            epic1.setStatus("DONE");
            epic.put(epicId, epic1);
        } else if (isInProgress) {
            epic1.setStatus("IN_PROGRESS");
            epic.put(epicId, epic1);
        } else {
            epic1.setStatus("NEW");
            epic.put(epicId, epic1);
        }
    }


}
