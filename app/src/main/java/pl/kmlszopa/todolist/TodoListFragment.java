package pl.kmlszopa.todolist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kmlsz on 25.11.2016.
 */

public class TodoListFragment extends Fragment{
    @BindView(R.id.todo_list)
    protected RecyclerView mTodoList;

    private TodoItemAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todolist,container,false);
        ButterKnife.bind(this,view);
        setHasOptionsMenu(true);

        mTodoList.setLayoutManager(new LinearLayoutManager(getContext()));

        TodoItemRepository itemsRepository = new SqlTodoItemsRepository(getContext());

        mAdapter = new TodoItemAdapter();
        mAdapter.setData(itemsRepository.getTodoList());
        mTodoList.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_list,menu);
    }
}
