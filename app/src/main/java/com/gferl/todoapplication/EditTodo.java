package com.gferl.todoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class EditTodo extends AppCompatActivity {
    EditText edt_name;
    CheckBox cb;
    Button btn_Update, btn_Delete;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_todo);

        edt_name = findViewById(R.id.nameTodo);
        cb = findViewById(R.id.cb_done);
        btn_Update = findViewById(R.id.btn_update);
        btn_Delete = findViewById(R.id.btn_delete);

        myDb = new DatabaseHelper(this);

        edt_name.setText(getIntent().getStringExtra("nametodo"));

//        Toast.makeText(this, getIntent().getStringExtra("statustodo"), Toast.LENGTH_SHORT).show();

        if (getIntent().getStringExtra("statustodo").equals("1")) {
            cb.setChecked(true);
        } else {
            cb.setChecked(false);
        }

        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edt_name.getText().toString();
                String id = getIntent().getStringExtra("idtodo");
                String status = "";

                if (cb.isChecked()){
                   status = "1";
                } else {
                   status = "0";
                }

                if (name.equals("")){
                    edt_name.setError("Nama kegiatan wajib diisi");
                } else {
                    boolean isUpdate =myDb.updateDta(name, status, id);

                    if (isUpdate) {
                        Toast.makeText(EditTodo.this, "Data berhasil diubah", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(EditTodo.this, "Data berhasil diubah", Toast.LENGTH_LONG).show();
                    }

                    startActivity(new Intent(EditTodo.this, MainActivity.class));
                    finish();
                }
            }
        });

        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = getIntent().getStringExtra("idtodo");
                Integer deletedRows = myDb.deleteData(id);

                if (deletedRows > 0) {
                    Toast.makeText(EditTodo.this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EditTodo.this, "Data gagal dihapus", Toast.LENGTH_SHORT).show();
                }

                startActivity(new Intent(EditTodo.this, MainActivity.class));
                finish();
            }
        });
    }
}