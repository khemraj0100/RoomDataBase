package com.example.roomdata.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdata.R;
import com.example.roomdata.UpdateTaskActivity;
import com.example.roomdata.model.PersonData;

import java.io.Serializable;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private Context mCtx;
    private List<PersonData> taskList;

    public PersonAdapter(Context mCtx, List<PersonData> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.adapter_task, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        PersonData t = taskList.get(position);
        holder.textViewTask.setText(t.getName());

    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        TextView  textViewTask;

        public PersonViewHolder(View itemView) {
            super(itemView);


            textViewTask = itemView.findViewById(R.id.textViewTask);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            PersonData task = taskList.get(getAdapterPosition());

            Intent intent = new Intent(mCtx, UpdateTaskActivity.class);
           intent.putExtra("task", task);

            mCtx.startActivity(intent);
        }
    }
}
