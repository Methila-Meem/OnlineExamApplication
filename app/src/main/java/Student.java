public class Student {


    private String Roll;
    private String Course_no;
    private String date;

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String roll) {
        Roll = roll;
    }

    public String getCourse_no() {
        return Course_no;
    }

    public void setCourse_no(String course_no) {
        Course_no = course_no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Student(String roll, String course_no, String date) {
        Roll = roll;
        Course_no = course_no;
        this.date = date;
    }
}
