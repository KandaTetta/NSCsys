package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.Product;

public class ProductDAO {
    // 番号を指定して製品情報を検索
    public Product findByProductNo(int no) throws SQLException {
        // 検索結果の製品オブジェクト(初期値はnull）
        Product product = null;
        Connection con = null;
        PreparedStatement st = null;
        try {
            // データベースへの接続



            // PreparedStatementの取得


            // プレースホルダに値を設定


            // SQL文を発行


            // 結果を参照






        } finally {
            // リソースの解放






        }
        // Productオブジェクトを返却

    }

    // 商品情報を更新
    public int updateProduct(Product product) throws SQLException{
        int result = 0; // 更新結果
        Connection con = null;
        PreparedStatement st = null;

        try{
            // データベースへ接続


            // PreparedStatementの取得
            st = con.prepareStatement(
                    "UPDATE products SET name = ?, price = ? WHERE no=?");

            // プレースホルダに値を設定


            // SQL文を発行


        }finally{
         // リソースの解放


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


            // DataSourceオブジェクトを取得


            // PreparedStatementからConnectionオブジェクト取得


            // PreparedStatement取得


            // SQL文の発行


            // 検索結果1件ずつ取得しProductオブジェクトを生成後、リストへ追加




        }finally{
            // リソースの解放


        }
        // 検索結果を返却
        return productList;
    }
}