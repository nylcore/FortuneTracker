package com.concordia.fortune;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Welcome to FortuneTracker.");

        ArrayList<Transaction> transactions = new ArrayList<>();

        DataExtractor extractor = new DataExtractor("testdata.csv");
        transactions = extractor.getData();

        int count = 0;
        for(Transaction t: transactions)
        {
            System.out.println("Transaction #" + ++count);
            t.toString();
            System.out.println();
        }
    }
}
