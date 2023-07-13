package beans;

public class Course {
    private String courseNo;    // コース番号
    private String courseName;  // コース名
    private int term;           // 学習期間

    // コンストラクタ
    public Course() {
    }

    public Course(String courseNo, String courseName, int term) {
        this.courseNo = courseNo;
        this.courseName = courseName;
        this.term = term;
    }

    // setter および getter
    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }
}
