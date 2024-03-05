import account.AccountView;
import board.BoardView;
import crawler.CrawlerView;
import member.MemberView;

import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "0-종료 1-회원관리 2-성적표 3-게시판 4-Crawler 5-사용자관리(맵) 6-은행계좌");
            switch (sc.next()) {
                case "0":
                    System.out.println("종료");
                    return ;
                case "1":
                case "2":
                case "3": BoardView.main(); break;
                case "4":
                    CrawlerView.main(sc); break;;
                case "5": MemberView.main(sc); break;
                case "6": AccountView.main(sc); break;
            }
        }
    }
}







