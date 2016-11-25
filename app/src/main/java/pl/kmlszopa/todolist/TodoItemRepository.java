package pl.kmlszopa.todolist;

import java.util.List;

/**
 * Created by kmlsz on 25.11.2016.
 */

public interface TodoItemRepository {
    List<TodoTask> getTodoList();
}
