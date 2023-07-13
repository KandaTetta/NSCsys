package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.Course;

public class CourseDAO {
 // 研修コース全件検索
    public List<Course> findAllCourse() throws Exception{
        List<Course> courseList = null;   // 研修コースリスト（検索結果）
        DataSource source = null;
        InitialContext c = null;
        Connection con = null;
        PreparedStatement st = null;

        try{
            // ネーミングサービスへ接続
            c = new InitialContext();

            // DataSourceオブジェクトを取得
            source = (DataSource) c.lookup("java:comp/env/jdbc/TestWebDB");

            // PreparedStatementからConnectionオブジェクト取得
            con = source.getConnection();

            // PreparedStatement取得
            st = con.prepareStatement("SELECT * FROM course");

            // SQL文の発行
            ResultSet rs = st.executeQuery();

            // ArrayList初期化
            courseList = new ArrayList<Course>();

            // 検索結果1件ずつ取得しProductオブジェクトを生成し、リストへ追加
            while(rs.next()){
                String no = rs.getString("course_no");
                String name = rs.getString("course_name");
                int term = rs.getInt("term");

                Course course = new Course(no,name,term);
                courseList.add(course);
            }
        }finally{
            // リソースの解放
            if (c != null){
                c.close();
            }

            if (st != null) {
                st.close();
            }

            if (con != null) {
                con.close();
            }
        }
        // 検索結果を返却
        return courseList;
    }

 // 研修コース番号検索
    public Course findCourseByCourseNo(String courseNo) throws Exception{
        Course course = null;   // 研修コースリスト（検索結果）
        DataSource source = null;
        InitialContext c = null;
        Connection con = null;
        PreparedStatement st = null;

        try{
            // ネーミングサービスへ接続
            c = new InitialContext();

            // DataSourceオブジェクトを取得
            source = (DataSource) c.lookup("java:comp/env/jdbc/TestWebDB");

            // PreparedStatementからConnectionオブジェクト取得
            con = source.getConnection();

            // PreparedStatement取得
            st = con.prepareStatement("SELECT * FROM course WHERE course_no = ?");

            // プレースホルダ設定
            st.setString(1, courseNo);

            // SQL文の発行
            ResultSet rs = st.executeQuery();

            // 検索結果1件ずつ取得しProductオブジェクトを生成し、リストへ追加
            if(rs.next()){
                String no = rs.getString("course_no");
                String name = rs.getString("course_name");
                int term = rs.getInt("term");

                course = new Course(no,name,term);
            }
        }finally{
            // リソースの解放
            if (c != null){
                c.close();
            }

            if (st != null) {
                st.close();
            }

            if (con != null) {
                con.close();
            }
        }
        // 検索結果を返却
        return course;
    }
}