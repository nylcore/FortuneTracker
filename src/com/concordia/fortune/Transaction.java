package com.concordia.fortune;

public class Transaction
{
    private String date = null;
    private String name = null;
    private float amount = 0.0f;
    private boolean isIncome = true;

    private String getDate()
    {
        return date;
    }

    private String getName()
    {
        return name;
    }

    private float getAmount()
    {
        return amount;
    }

    private boolean isIncome()
    {
        return isIncome;
    }

    public Transaction(String date, String name, float amount, boolean isIncome)
    {
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.isIncome = isIncome;
    }

    @Override
    public String toString()
    {
        System.out.println("Date: " + getDate());
        System.out.println("Name: " + getName());

        if(isIncome())
            System.out.println("Type: Deposit");
        else
            System.out.println("Type: Withdrawal");

        System.out.print("Amount Transferred: $");
        System.out.println(String.format("%.2f", getAmount()));

        return null;
    }
}
