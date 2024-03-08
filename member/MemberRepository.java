package member;

import enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    Connection conn;
    private static MemberRepository instance;

    static {
        try {
            instance = new MemberRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private MemberRepository() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing",
                "password");

    }

    public static MemberRepository getInstance() {
        return instance;
    }

    public String test() {
        return "MemberRepository 연결";
    }

    public List<?> findMembers() throws SQLException {
        List<Member> ls = new ArrayList<>();
        String sql = "select * from members";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            do {
                ls.add(Member.builder()
                        .id(rs.getLong("id"))
                        .memberName(rs.getString("member_name"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .phoneNumber(rs.getString("phone_number"))
                        .job(rs.getString("job"))
                        .height(rs.getString("height"))
                        .weight(rs.getString("weight"))
                        .build());
            } while (rs.next());
        } else {
            System.out.println("No Data");
        }

        rs.close();
        pstmt.close();
        conn.close();

        return ls;
    }

    public String createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS members (\n" +
                "                       id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "                       member_name VARCHAR(20) NOT NULL,\n" +
                "                       password VARCHAR(20) NOT NULL,\n" +
                "                       name VARCHAR(20),\n" +
                "                       phone_number VARCHAR(20),\n" +
                "                       job VARCHAR(20),\n" +
                "                       height VARCHAR(20),\n" +
                "                       weight VARCHAR(20)\n" +
                ")";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        int ex = pstmt.executeUpdate();
        System.out.println("쿼리의 반환값은 :" + ex);// CREATE / DROP 관련 구문에서는 0 을 반환합니다.
        String msg = "";
        if (ex == 0) {
            msg = "회원테이블 생성성공";
        } else {
            msg = "회원테이블 생성실패";
        }


        return msg;
    }

    public String deleteTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS members";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        int de = pstmt.executeUpdate();
        System.out.println("쿼리의 반환값은 :" + de);
        String msg = "";
        if (de == 0) {

            msg = "테이블 삭제 성공";
        } else {
            msg = "테이블 삭제 실패";
        }

        return msg;
    }

    public Messenger saveMembers(Member member) throws SQLException {
        String sql = "insert into Members(member_name, password, name" +
                ", phone_number, job, height,weight)" +
                "values (?,?,?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, member.getMemberName());
        pstmt.setString(2, member.getPassword());
        pstmt.setString(3, member.getName());
        pstmt.setString(4, member.getPhoneNumber());
        pstmt.setString(5, member.getJob());
        pstmt.setString(6, member.getHeight());
        pstmt.setString(7, member.getWeight());

        pstmt.executeUpdate();
        pstmt.close();
        return Messenger.SUCCESS;
    }
}
