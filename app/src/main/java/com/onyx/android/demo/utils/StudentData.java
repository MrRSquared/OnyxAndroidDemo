package com.onyx.android.demo.utils;


import java.util.ArrayList;

public class StudentData {
    private String mName;
    private boolean mOnline;

    public StudentData(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Students> createStudentList(int numStudents) {
        ArrayList<Students> contacts = new ArrayList<Students>();

        for (int i = 1; i <= numStudents; i++) {
            contacts.add(new Students("Person " + ++lastContactId, i <= numStudents / 2));
        }

        return contacts;
    }
}