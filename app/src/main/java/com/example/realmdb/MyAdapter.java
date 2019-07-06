package com.example.realmdb;


import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {

    private final String TAG="example";
    private RealmResults<Student> mPersonRealmResults;
    private int count =0;
    private Context mContext;


    public MyAdapter(RealmResults<Student> students, Context context){
        mPersonRealmResults = students;
        mContext = context;
        count = 0;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        Student student = mPersonRealmResults.get(position);
        holder.name.setText(student.getName());
        holder.dept.setText(student.getDept());
        holder.roll.setText("Roll No. : "+ String.valueOf(student.getRollno()));
        holder.phone.setText(String.valueOf(student.getPhn()));
        holder.gender.setText(student.getGender());




    }

    @Override
    public int getItemCount() {
        return mPersonRealmResults.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
            private RelativeLayout r1;
            private TextView name;
            private TextView dept;
            private TextView phone;
            private TextView roll;
            private TextView gender;
         public MyViewholder(@NonNull View itemView) {
                super(itemView);
                count++;
                int s = count%3;
                Log.i( TAG, "MyViewHolder: Number of Active ViewHolders:" + count);
                name = itemView.findViewById(R.id.name);
                dept = itemView.findViewById(R.id.dept);
                roll = itemView.findViewById(R.id.roll);
                phone = itemView.findViewById(R.id.phn);
                gender = itemView.findViewById(R.id.gender);
                r1 = itemView.findViewById(R.id.category_image);
                if(s==0)
                    r1.setBackgroundColor(Color.BLUE);
                else if (s==1)
                    r1.setBackgroundColor(Color.RED);
                else
                    r1.setBackgroundColor(Color.MAGENTA);


            }
        }
    }

