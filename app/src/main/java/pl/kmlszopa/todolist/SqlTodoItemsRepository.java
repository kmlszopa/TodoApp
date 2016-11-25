package pl.kmlszopa.todolist;

import android.content.Context;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by kmlsz on 25.11.2016.
 */

public class SqlTodoItemsRepository implements TodoItemRepository{
    private Dao<TodoTask, Integer> mTaskDao;

    public SqlTodoItemsRepository(Context context) {
        try {
            TodoDbOpenHelper sqlOpenHelper = new TodoDbOpenHelper(context);
            ConnectionSource cs = new AndroidConnectionSource(sqlOpenHelper);
            mTaskDao = DaoManager.createDao(cs,TodoTask.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TodoTask> getTodoList() {
        try {
            return mTaskDao.queryBuilder().orderBy("created",false).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
