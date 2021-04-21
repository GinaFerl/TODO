package com.gferl.todoapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gferl.todoapplication.model.ToDo;

public class AddFragment extends Fragment {
    EditText edtNameTodo;
    Button btn_Add, btn_Cancel;
    DatabaseHelper myDb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add, container, false);

        edtNameTodo = view.findViewById(R.id.nametodo);
        btn_Add = view.findViewById(R.id.btn_add);
        btn_Cancel = view.findViewById(R.id.btn_cancel);

        myDb = new DatabaseHelper(getContext());

        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtNameTodo.getText().toString();

                if (name.equals("")){
                    edtNameTodo.setError("Nama kegiatan wajib diisi");
                } else {
                    boolean isInserted = myDb.insertData(name, 0);
                    if (isInserted) {
                        Toast.makeText(view.getContext(), "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(view.getContext(), "Data gagal ditambahkan", Toast.LENGTH_SHORT).show();
                    }
                    startActivity(new Intent(getContext(), MainActivity.class));
                    getActivity().finish();
                }

            }
        });

        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}