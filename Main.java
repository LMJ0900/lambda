package com.turing.api;

import com.turing.api.account.AccountView;
import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.crawler.CrawlerView;
import com.turing.api.member.MemberView;

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
                    "x-exit m-Member a-Article b-Board ac-Account c-Crawler l-ls");
            switch (sc.next()) {
                case "x":
                    System.out.println("종료");
                    return ;
                case "m": MemberView.main(sc); break;
                case "a":
                    ArticleView.main(sc); break;
                case "b": BoardView.main(); break;
                case "c":
                    CrawlerView.main(sc); break;
                case "5":
                case "6": AccountView.main(sc); break;
            }
        }
    }
}







