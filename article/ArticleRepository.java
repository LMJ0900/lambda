package article;

import java.sql.*;
import java.util.List;

public class ArticleRepository {

    Connection connection;
    private static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArticleRepository() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing",
                "password");
    }

    public static ArticleRepository getInstance() {
        return instance;
    }


    public List<?> articleList() throws SQLException {
        String sql = "select * from articles";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while ((rs.next())) {
            System.out.printf("ID: %d\t Title : %s\t content: %s\t Writer: %s\n",
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
        }
        rs.close();
        pstmt.close();
        connection.close();

        return null;
    }
}
