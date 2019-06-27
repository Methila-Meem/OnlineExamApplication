package com.example.appbasedonexam;

public class student {
    private String Roll;
    private String course_no;
    private String date;



    public student(String roll, String course_no, String date) {
        Roll = roll;
        this.course_no = course_no;
        this.date = date;
    }
    public String getRoll() {
        return Roll;
    }

    public void setRoll(String roll) {
        Roll = roll;
    }

    public String getCourse_no() {
        return course_no;
    }

    public void setCourse_no(String course_no) {
        this.course_no = course_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
