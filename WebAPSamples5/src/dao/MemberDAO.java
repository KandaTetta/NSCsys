package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Member;

public class MemberDAO {
    // ログインデータからメンバを検索する
    public Member selectMemberByLoginData(String id, String pass)
                                            throws SQLException {
        Member member = null;

        // データベースの登録情報を検索する
        Connection con = null;
        PreparedStatement st = null;

        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaweb_db", "duke", "system5");

            // PreparedStatementの取得
            st = con.prepareStatement(
                    "SELECT * FROM member WHERE login_id = ? and password = ?");

            // プレースフォルダの設定
            st.setString(1, id);
            st.setString(2, pass);

            // SQL文の発行
            ResultSet rs = st.executeQuery();

            // 登録情報あり
            if (rs.next()) {
                // ログイン者の情報を取得
                int memberId = rs.getInt("member_id");
                String userName = rs.getString("user_name");
                int birthYear = rs.getInt("birth_year");

                member = new Member(memberId, userName, id, pass, birthYear);
            }
        } finally {
            // クローズ処理
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return member;
    }

    // 新規会員登録
    public int registerMember(Member m) throws SQLException {
        int result = 0; // 登録結果

        // 会員情報をデータベースへ登録する
        Connection con = null;
        PreparedStatement st = null;

        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaweb_db", "duke", "system5");

            // PreparedStatementの取得
            st = con.prepareStatement("INSERT INTO member VALUES(null,?,?,?,?)");

            // プレースフォルダの設定
            st.setString(1, m.getLoginId());
            st.setString(2, m.getLoginPass());
            st.setString(3, m.getUserName());
            st.setInt(4, m.getBirthYear());

            // SQL文の発行
            result = st.executeUpdate();
        } finally {
            // クローズ処理
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}