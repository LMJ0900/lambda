import account.AccountView;
import article.ArticleView;
import board.BoardView;
import crawler.CrawlerView;
import member.MemberView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "0-종료 1-회원관리 2-Article 3-게시판 4-Crawler 5-사용자관리(맵) 6-은행계좌");
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return ;
                case "1": MemberView.main(sc); break;
                case "2":
                    ArticleView.main(sc); break;
                case "3": BoardView.main(); break;
                case "4":
                    CrawlerView.main(sc); break;
                case "5":
                case "6": AccountView.main(sc); break;
            }
        }
    }
}







