package com.turing.api;

import com.turing.api.account.AccountView;
import com.turing.api.article.ArticleView;
import com.turing.api.board.BoardView;
import com.turing.api.crawler.CrawlerView;
import com.turing.api.enums.Navigation;
import com.turing.api.member.MemberView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Supplier;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        Scanner sc = new Scanner(System.in);

        while (Navigation.selectmain(sc)) {

        }
    }



}







