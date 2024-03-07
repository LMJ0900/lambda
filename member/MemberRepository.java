package member;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    Connection connection;
    private static MemberRepository instance;

    static {
        try {
            instance = new MemberRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private MemberRepository() throws SQLException {
       connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing",
                "password");

    }
    public static MemberRepository getInstance() {
        return instance;
    }

    public String test(){
        return "MemberRepository 연결";
    }

    public List<?> findMembers() throws SQLException {

        String sql = "select * from articles";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while ((rs.next())){
            System.out.printf("ID: %d\t Title : %s\t content: %s\t Writer: %s\n",
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));
        }

       /* rs.next();
        String name = rs.getString("name");
        System.out.println(name);*/

        rs.close();
        pstmt.close();
        connection.close();

        return null;
    }
}
