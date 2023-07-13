package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.Product;

public class ProductDAO {
    // 番号を指定して製品情報を検索
    public Product findByProductNo(int no) throws SQLException {
        // 検索結果の製品オブジェクト
        Product product = null;
        Connection con = null;
        PreparedStatement st = null;
        try {
            // データベースへの接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaweb_db", "duke", "system5");

            // PreparedStatementの取得
            st = con.prepareStatement("SELECT * FROM products WHERE no=?");

            // プレースホルダに値を設定
            st.setInt(1, no);

            // SQL文を発行
            ResultSet rs = st.executeQuery();

            // 結果を参照
            if (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");

                product = new Product(no, name, price);
            }
        } finally {
            // リソースの解放
            if (st != null) {
                st.close();
            }

            if (con != null) {
                con.close();
            }
        }
        // Productオブジェクトを返却
        return product;
    }

    // 商品情報を更新
    public int updateProduct(Product product) throws SQLException{
        int result = 0; // 更新結果
        Connection con = null;
        PreparedStatement st = null;

        try{
            // データベースへ接続
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaweb_db", "duke", "system5");

            // PreparedStatementの取得
            st = con.prepareStatement(
                    "UPDATE products SET name = ?, price = ? WHERE no=?");

            // プレースホルダに値を設定
            st.setString(1, product.getName());
            st.setInt(2, product.getPrice());
            st.setInt(3, product.getNo());

            // SQL文を発行
            result = st.executeUpdate();
        }finally{
         // リソースの解放
            if (st != null) {
                st.close();
            }

            if (con != null) {
                con.close();
            }
        }
        // 更新件数を返却
        return result;
    }

    // 商品全件検索
    public List<Product> findAllProducts() throws Exception{
        List<Product> productList = null;   // 商品リスト（検索結果）
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
            st = con.prepareStatement("SELECT * FROM products");

            // SQL文の発行
            ResultSet rs = st.executeQuery();

            // ArrayList初期化
            productList = new ArrayList<Product>();

         // 検索結果1件ずつ取得しProductオブジェクトを生成後、リストへ追加
            while(rs.next()){
                int no = rs.getInt("no");
                String name = rs.getString("name");
                int price = rs.getInt("price");

                Product product = new Product(no,name,price);
                productList.add(product);
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
        return productList;
    }
}