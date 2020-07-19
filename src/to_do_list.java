import java.util.ArrayList;

public class to_do_list {
    private ArrayList<task> TO_DO = new ArrayList<>();

    private boolean check_repeated(String name){    // check if a task has the same name
        for (task T : TO_DO) {
            if (T.name.equals(name))
                return true;
        }
        return false;
    }

    public boolean add_task(String task_name){    // adds a task if its name is unique

        if (!check_repeated(task_name)){
            TO_DO.add(new task(task_name));
            return true;
        }
        return false;
    }

    public boolean update_task(String name){       // makes the task done if pending, or vice-versa
        for (task T : TO_DO){
            if (T.name.equals(name)) {
                T.done_status = !T.done_status;
                return true;
            }
        }
        return false;
    }

    public boolean delete_task(String name){    // removes task from list if the task exists
        for (task T : TO_DO){
            if (T.name.equals(name)) {
                TO_DO.remove(T);
                return true;
            }
        }
        return false;
    }

    public void print_list(){
        System.out.println("------  tarefas a fazer ------");

        for (task T : TO_DO){
            if (!T.done_status){
                System.out.println("[ ] "+ T.name);
            }
        }
        System.out.println("\n------  tarefas feitas -------");
        for (task T : TO_DO){
            if (T.done_status){
                System.out.print("[✓] "+ T.name);
            }
        }

        System.out.println("\n------------------------------");
    }

    }


class task{
    String name;
    boolean done_status = false;

    public task(String name) {
        this.name = name;
    }

}