package com.example.appbasedonexam;

import android.widget.EditText;
import android.widget.TextView;

public class student {
    private String Roll;
    private String course_no;
    private String year;
    private String semester;
    private String date;
    private String answer,ques;

    public student(String roll, String course_no, String year, String semester, String date, String answer, String ques) {
        Roll = roll;
        this.course_no = course_no;
        this.year = year;
        this.semester = semester;
        this.date = date;
        this.answer = answer;
        this.ques = ques;
    }

    public student(){}

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public void setText(String ques) {
    }
}
