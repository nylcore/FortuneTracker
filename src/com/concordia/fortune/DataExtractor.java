package com.concordia.fortune;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataExtractor
{
    private ArrayList<String> dataArrayBuffer = new ArrayList<>();
    private ArrayList<Transaction> data = new ArrayList<>();
    private String inputFilename = null;

    ArrayList<Transaction> getData()
    {
        return data;
    }

    DataExtractor(String inputFilename)
    {
        this.inputFilename = inputFilename;

        extractData();
    }

    private void extractData()
    {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilename)))
        {
            String extractBuffer = br.readLine();
            while(extractBuffer != null)
            {
                dataArrayBuffer.add(extractBuffer);
                extractBuffer = br.readLine();
            }

            formatData();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void formatData()
    {
        String[] buffer;

        for(String s: dataArrayBuffer)
        {
            buffer = s.split(",",5);

            if(buffer[2].isEmpty())
                data.add(new Transaction(buffer[0], buffer[1], Float.parseFloat(buffer[3]), true));
            else
                data.add(new Transaction(buffer[0], buffer[1], Float.parseFloat(buffer[2]), false));
        }

    }

    @Override
    public String toString()
    {
        for(String s: dataArrayBuffer)
        {
            System.out.println(s);
        }

        return super.toString();
    }
}
