package com.gferl.todoapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gferl.todoapplication.EditTodo;
import com.gferl.todoapplication.R;
import com.gferl.todoapplication.model.ToDo;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {
    Context context;
    List<ToDo> todo;

    public ToDoAdapter(Context context, List<ToDo> todo) {
        this.context = context;
        this.todo = todo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.todo_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.nametodo.setText(todo.get(position).getName_todo());
        if (todo.get(position).getStatus_todo().equals("0")){
            holder.statustodo.setText("Belum selesai");
        } else {
            holder.statustodo.setText("Selesai");
        }

        String getNameTodo =todo.get(position).getName_todo();
        String getStatusTodo = todo.get(position).getStatus_todo();
        String getIdTodo = todo.get(position).getId_todo();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, EditTodo.class);
                i.putExtra("nametodo", getNameTodo);
                i.putExtra("statustodo", getStatusTodo);
                i.putExtra("idtodo", getIdTodo);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return todo.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nametodo, statustodo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nametodo = (TextView) itemView.findViewById(R.id.tv_name);
            statustodo = (TextView) itemView.findViewById(R.id.tv_status);
        }
    }
}
