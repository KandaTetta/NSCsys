package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.EntryData;

public class EntryDAO {
    // 申込情報登録
    public int insertEntryData(String courseNo,EntryData entryData) throws Exception{
        int result = 0; // 登録結果

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
            st = con.prepareStatement("INSERT INTO entry VALUES(null,?,?,?,?,?,?)");;

            // プレースホルダ設定
            st.setString(1, entryData.getSei());
            st.setString(2, entryData.getMei());
            st.setString(3, entryData.getGender());
            st.setString(4, entryData.getZip());
            st.setString(5, entryData.getAddress());
            st.setString(6, courseNo);

            // SQL文の発行
            result = st.executeUpdate();
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
        // 登録結果を返却
        return result;
    }
}