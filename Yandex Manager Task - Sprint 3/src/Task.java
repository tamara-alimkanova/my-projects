public class Task {
    protected String name;
    protected String description;
    protected String status;
   protected int id;
    Task(String name, String description, String status){
        this.name = name;
        this.description = description;
        this.status = status;
    }
    public String getName(){
        return name;
     }
     public String getDescription(){
        return description;
     }


    public String getStatus(){
        return status;
     }
     public int getId(){
        return id;
     }
    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", id=" + id +
                '}';
    }
}
