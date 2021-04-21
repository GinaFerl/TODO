package com.gferl.todoapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.gferl.todoapplication.adapter.ToDoAdapter;
import com.gferl.todoapplication.model.ToDo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<ToDo> list = new ArrayList<ToDo>();
    ToDoAdapter toDoAdapter;
    DatabaseHelper myDb;
    RecyclerView rvTodo;
    EditText edt_search;
    ImageButton search;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        myDb = new DatabaseHelper(getContext());
        list.addAll(myDb.getAllData());
        rvTodo = v.findViewById(R.id.rv_todo);
        rvTodo.setLayoutManager(new LinearLayoutManager(getContext()));
        toDoAdapter = new ToDoAdapter(getContext(), list);
        toDoAdapter.notifyDataSetChanged();
        rvTodo.setAdapter(toDoAdapter);

        edt_search = v.findViewById(R.id.etSearch);
        search = v.findViewById(R.id.btSearch);

        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (edt_search.length() != 0) {
                    List<ToDo> list = myDb.searchData(edt_search.getText().toString().trim());
                    if (list != null) {
                        rvTodo.setAdapter(new ToDoAdapter(getActivity(), list));
                    }
                } else {
                    List<ToDo> list = myDb.getAllData();
                    if (list != null) {
                        rvTodo.setAdapter(new ToDoAdapter(getActivity(), list));
                    }
                }
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt_search.length() != 0) {
                    List<ToDo> list = myDb.searchData(edt_search.getText().toString().trim());
                    if (list != null) {
                        rvTodo.setAdapter(new ToDoAdapter(getActivity(), list));
                    }
                } else {
                    List<ToDo> list = myDb.getAllData();
                    if (list != null) {
                        rvTodo.setAdapter(new ToDoAdapter(getActivity(), list));
                    }
                }
            }
        });

        // Inflate the layout for this fragment
        return v;
    }
}