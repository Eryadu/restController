package io.pragra.restcontroller.entity;

import java.util.Comparator;

public class NameComparator implements Comparator<StudentRc> {
    @Override
    public int compare(StudentRc o1, StudentRc o2) {
        return o1.getStudentName().compareTo(o2.getStudentName());
    }
}
