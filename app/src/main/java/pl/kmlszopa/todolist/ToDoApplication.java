package pl.kmlszopa.todolist;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by kmlsz on 25.11.2016.
 */

public class ToDoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
