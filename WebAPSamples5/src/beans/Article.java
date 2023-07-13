package beans;

// 記事の情報を管理するクラス
public class Article {
    private int articleId; // 記事ID
    private String content; // 記事内容
    private int memberId; // 投稿者ID

    // コンストラクタ
    public Article() {
    }

    public Article(int articleId, String content, int memberId) {
        this.articleId = articleId;
        this.content = content;
        this.memberId = memberId;
    }

    // メソッド
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getArticleId() {
        return this.articleId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}