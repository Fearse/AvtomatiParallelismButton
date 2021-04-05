package com.example.avtomatiparallelism;

import java.util.Vector;

public class Avtomat {
    int sum=0,buyer;
    int[] persons= new int[20];
    private int index=0;
    String name,status;
    Product[] products=new Product[6];
    Avtomat(String name)
    {
        this.name=name;
        for(int i=0;i<20;i++)
            persons[i]=-1;
    }
    void AddProduct(String name,int price,int kol)
    {
        products[index]=new Product(name,price,kol);
        index++;
    }
    int getperson()
    {
        for (int i=0;i<20;i++)
            if (persons[i]!=-1)
            return i;
          return -1;
    }
    void deleteperson()
    {
        for(int i=0;i<20;i++)
            if(persons[i]!=-1)
            {
                persons[i]=-1;
                break;
            }
    }
    void makePurchase(int z){
        products[z].kol--;
        sum+=products[z].price;
    }
}
