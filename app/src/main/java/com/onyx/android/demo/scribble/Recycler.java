package com.onyx.android.demo.scribble;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.onyx.android.demo.R;
import com.onyx.android.demo.utils.StudentAdapter;
import com.onyx.android.demo.utils.StudentData;
import com.onyx.android.demo.utils.Students;

import java.util.ArrayList;

public class Recycler extends AppCompatActivity {

    ArrayList<Students> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.my_recycler_view);

        // Initialize contacts
        students = StudentData.createStudentList(20);
        // Create adapter passing in the sample user data
        StudentAdapter adapter = new StudentAdapter(students);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }
}