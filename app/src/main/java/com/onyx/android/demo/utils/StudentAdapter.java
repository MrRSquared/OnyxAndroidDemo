package com.onyx.android.demo.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.onyx.android.demo.R;

import java.util.List;
//This is also referred to as a viewHolder.
// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class StudentAdapter extends
        RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
    // Store a member variable for the contacts
    private List<Students> mStudents;

    // Pass in the contact array into the constructor
    public StudentAdapter(List<Students> students) {
        mStudents = students;
    }
    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.student_list_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Students students = mStudents.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        textView.setText(students.getName());
        Button button = holder.messageButton;
        button.setText(students.isOnline() ? "Message" : "Offline");
        button.setEnabled(students.isOnline());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mStudents.size();
    }
}