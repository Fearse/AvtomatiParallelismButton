package com.example.avtomatiparallelism;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.PrecomputedText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import javax.xml.transform.Result;

import static java.lang.Math.random;

public class MainActivity extends AppCompatActivity {
    public TextView product1;
    public TextView product2;
    public TextView product3;
    public TextView product4;
    public TextView product5;
    public TextView product6;
    public TextView productkol1;
    public TextView productkol2;
    public TextView productkol3;
    public TextView productkol4;
    public TextView productkol5;
    public TextView productkol6;
    public TextView status1;
    public TextView sum1;
    public TextView number1;
    public TextView product21;
    public TextView product22;
    public TextView product23;
    public TextView product24;
    public TextView product25;
    public TextView product26;
    public TextView productkol21;
    public TextView productkol22;
    public TextView productkol23;
    public TextView productkol24;
    public TextView productkol25;
    public TextView productkol26;
    public TextView status21;
    public TextView sum21;
    public TextView number21;
    public TextView product31;
    public TextView product32;
    public TextView product33;
    public TextView product34;
    public TextView product35;
    public TextView product36;
    public TextView productkol31;
    public TextView productkol32;
    public TextView productkol33;
    public TextView productkol34;
    public TextView productkol35;
    public TextView productkol36;
    public TextView status31;
    public TextView sum31;
    public TextView number31;
    public TextView product41;
    public TextView product42;
    public TextView product43;
    public TextView product44;
    public TextView product45;
    public TextView product46;
    public TextView productkol41;
    public TextView productkol42;
    public TextView productkol43;
    public TextView productkol44;
    public TextView productkol45;
    public TextView productkol46;
    public TextView status41;
    public TextView sum41;
    public TextView number41;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextViewConnect();
        Avtomat[] avtomats=new Avtomat[4];
        avtomats[0]=new Avtomat("1");
        avtomats[1]=new Avtomat("2");
        avtomats[2]=new Avtomat("3");
        avtomats[3]=new Avtomat("4");
       for (int i=0;i<4;i++)
        {
            avtomats[i].AddProduct("Snikers",35,5+(int)(Math.random()*25));
            avtomats[i].AddProduct("Mars",25,5+(int)(Math.random()*25));
            avtomats[i].AddProduct("Bounty",15,5+(int)(Math.random()*25));
            avtomats[i].AddProduct("Pepsi",40,5+(int)(Math.random()*25));
            avtomats[i].AddProduct("7up",30,5+(int)(Math.random()*25));
            avtomats[i].AddProduct("Water",20,5+(int)(Math.random()*25));
        }
      productConnect(avtomats);
        for (int i=0;i<20;i++) {
           avtomats[(int)(Math.random()*4)].persons[i]=i;
        }
        new Buy4().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, avtomats);
        new Buy3().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, avtomats);
        new Buy2().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, avtomats);
        new Buy1().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, avtomats);
    }
    private class Buy1 extends AsyncTask<Avtomat,Avtomat,Void>{


        @Override
        protected Void doInBackground(Avtomat... avtomats) {
            int i=0;
            FreeStatus(avtomats,i);
            return null;
        }
        void ChoosingStatus(Avtomat[] avtomat,int i)
        {
            avtomat[i].status="Choosing";
            status1.setText(avtomat[i].status);
            int z=(int)(Math.random()*3);
            while (avtomat[i].products[z].kol==0)
                z=(int)(Math.random()*3);
            avtomat[i].makePurchase(z);
            switch (z){
                case 0:
                    productkol1.setText(avtomat[i].products[z].kol+"");
                    break;
                case 1:
                    productkol2.setText(avtomat[i].products[z].kol+"");
                    break;
                case 2:
                    productkol3.setText(avtomat[i].products[z].kol+"");
                    break;
            }
            sum1.setText("Сумма:"+avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            z=3+(int)(Math.random()*3);
            while (avtomat[i].products[z].kol==0)
                z=3+(int)(Math.random()*3);
            avtomat[i].makePurchase(z);
            switch (z){
                case 3:
                    productkol1.setText(avtomat[i].products[z].kol+"");
                    break;
                case 4:
                    productkol2.setText(avtomat[i].products[z].kol+"");
                    break;
                case 5:
                    productkol3.setText(avtomat[i].products[z].kol+"");
                    break;
            }
            sum1.setText("Сумма:"+avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PaymentStatus(avtomat,i);
        }
        void FreeStatus(Avtomat[] avtomat,int i)
        {
            avtomat[i].status="Free";
            status1.setText(avtomat[i].status);
            number1.setText(""+-1);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(avtomat[i].getperson()!= -1)
            {
                avtomat[i].buyer=avtomat[i].getperson();
                number1.setText("№"+(avtomat[i].buyer+1));
                ChoosingStatus(avtomat,i);
            }
        }
        void PaymentStatus(Avtomat[] avtomat,int i)
        {
            avtomat[i].status="Payment";
            status1.setText(avtomat[i].status);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*4));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            avtomat[i].sum=0;
            avtomat[i].deleteperson();
            sum1.setText("Сумма:"+avtomat[i].sum);
            avtomat[i].buyer=-1;
            FreeStatus(avtomat, i);
        }
    }
    private class Buy2 extends AsyncTask<Avtomat,Avtomat,Void>{


        @Override
        protected Void doInBackground(Avtomat... avtomats) {
            int i=1;
            FreeStatus(avtomats,i);
            return null;
        }
        void ChoosingStatus(Avtomat[] avtomat,int i)
        {
            avtomat[i].status="Choosing";
            status21.setText(avtomat[i].status);
            int z=(int)(Math.random()*3);
            while (avtomat[i].products[z].kol==0)
                z=(int)(Math.random()*3);
            avtomat[i].makePurchase(z);
            switch (z){
                case 0:
                    productkol21.setText(avtomat[i].products[z].kol+"");
                    break;
                case 1:
                    productkol22.setText(avtomat[i].products[z].kol+"");
                    break;
                case 2:
                    productkol23.setText(avtomat[i].products[z].kol+"");
                    break;
            }
            sum21.setText("Сумма:"+avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            z=3+(int)(Math.random()*3);
            while (avtomat[i].products[z].kol==0)
                z=3+(int)(Math.random()*3);
            avtomat[i].makePurchase(z);
            switch (z){
                case 3:
                    productkol21.setText(avtomat[i].products[z].kol+"");
                    break;
                case 4:
                    productkol22.setText(avtomat[i].products[z].kol+"");
                    break;
                case 5:
                    productkol23.setText(avtomat[i].products[z].kol+"");
                    break;
            }
            sum21.setText("Сумма:"+avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PaymentStatus(avtomat,i);
        }
        void FreeStatus(Avtomat[] avtomat,int i)
        {
            avtomat[i].status="Free";
            status21.setText(avtomat[i].status);
            number21.setText(""+-1);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(avtomat[i].getperson()!= -1)
            {
                avtomat[i].buyer=avtomat[i].getperson();
                number21.setText("№"+(avtomat[i].buyer+1));
                ChoosingStatus(avtomat,i);
            }
        }
        void PaymentStatus(Avtomat[] avtomat,int i)
        {
            avtomat[i].status="Payment";
            status21.setText(avtomat[i].status);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            avtomat[i].sum=0;
            avtomat[i].deleteperson();
            sum21.setText("Сумма:"+avtomat[i].sum);
            avtomat[i].buyer=-1;
            FreeStatus(avtomat, i);
        }
    }
    private class Buy3 extends AsyncTask<Avtomat,Avtomat,Void>{


        @Override
        protected Void doInBackground(Avtomat... avtomats) {
            int i=2;
            FreeStatus(avtomats,i);
            return null;
        }
        void ChoosingStatus(Avtomat[] avtomat,int i)
        {
            avtomat[i].status="Choosing";
            status31.setText(avtomat[i].status);
            int z=(int)(Math.random()*3);
            while (avtomat[i].products[z].kol==0)
                z=(int)(Math.random()*3);
            avtomat[i].makePurchase(z);
            switch (z){
                case 0:
                    productkol31.setText(avtomat[i].products[z].kol+"");
                    break;
                case 1:
                    productkol32.setText(avtomat[i].products[z].kol+"");
                    break;
                case 2:
                    productkol33.setText(avtomat[i].products[z].kol+"");
                    break;
            }
            sum31.setText("Сумма:"+avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            z=3+(int)(Math.random()*3);
            while (avtomat[i].products[z].kol==0)
                z=3+(int)(Math.random()*3);
            avtomat[i].makePurchase(z);
            switch (z){
                case 3:
                    productkol31.setText(avtomat[i].products[z].kol+"");
                    break;
                case 4:
                    productkol32.setText(avtomat[i].products[z].kol+"");
                    break;
                case 5:
                    productkol33.setText(avtomat[i].products[z].kol+"");
                    break;
            }
            sum31.setText("Сумма:"+avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PaymentStatus(avtomat,i);
        }
        void FreeStatus(Avtomat[] avtomat,int i)
        {
            avtomat[i].status="Free";
            status31.setText(avtomat[i].status);
            number31.setText(""+-1);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(avtomat[i].getperson()!= -1)
            {
                avtomat[i].buyer=avtomat[i].getperson();
                number31.setText("№"+(avtomat[i].buyer+1));
                ChoosingStatus(avtomat,i);
            }
        }
        void PaymentStatus(Avtomat[] avtomat,int i)
        {
            avtomat[i].status="Payment";
            status31.setText(avtomat[i].status);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            avtomat[i].sum=0;
            avtomat[i].deleteperson();
            sum31.setText("Сумма:"+avtomat[i].sum);
            avtomat[i].buyer=-1;
            FreeStatus(avtomat, i);
        }
    }
    private class Buy4 extends AsyncTask<Avtomat,Avtomat,Void>{


        @Override
        protected Void doInBackground(Avtomat... avtomats) {
            int i=3;
            FreeStatus(avtomats,i);
            return null;
        }
        void ChoosingStatus(Avtomat[] avtomat,int i)
        {
            avtomat[i].status="Choosing";
            status41.setText(avtomat[i].status);
            int z=(int)(Math.random()*3);
            while (avtomat[i].products[z].kol==0)
                z=(int)(Math.random()*3);
            avtomat[i].makePurchase(z);
            switch (z){
                case 0:
                    productkol41.setText(avtomat[i].products[z].kol+"");
                    break;
                case 1:
                    productkol42.setText(avtomat[i].products[z].kol+"");
                    break;
                case 2:
                    productkol43.setText(avtomat[i].products[z].kol+"");
                    break;
            }
            sum41.setText("Сумма:"+avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            z=3+(int)(Math.random()*3);
            while (avtomat[i].products[z].kol==0)
                z=3+(int)(Math.random()*3);
            avtomat[i].makePurchase(z);
            switch (z){
                case 3:
                    productkol41.setText(avtomat[i].products[z].kol+"");
                    break;
                case 4:
                    productkol42.setText(avtomat[i].products[z].kol+"");
                    break;
                case 5:
                    productkol43.setText(avtomat[i].products[z].kol+"");
                    break;
            }
            sum41.setText("Сумма:"+avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PaymentStatus(avtomat,i);
        }
        void FreeStatus(Avtomat[] avtomat,int i)
        {
            avtomat[i].status="Free";
            status41.setText(avtomat[i].status);
            number41.setText(""+-1);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(avtomat[i].getperson()!= -1)
            {
                avtomat[i].buyer=avtomat[i].getperson();
                number41.setText("№"+(avtomat[i].buyer+1));
                ChoosingStatus(avtomat,i);
            }
        }
        void PaymentStatus(Avtomat[] avtomat,int i)
        {
            avtomat[i].status="Payment";
            status41.setText(avtomat[i].status);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random()*3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            avtomat[i].sum=0;
            avtomat[i].deleteperson();
            sum41.setText("Сумма:"+avtomat[i].sum);
            avtomat[i].buyer=-1;
            FreeStatus(avtomat, i);
        }
    }
    public void TextViewConnect()
    {
        product1=(TextView)findViewById(R.id.product1);
        product2=(TextView)findViewById(R.id.product2);
        product3=(TextView)findViewById(R.id.product3);
        product4=(TextView)findViewById(R.id.product4);
        product5=(TextView)findViewById(R.id.product5);
        product6=(TextView)findViewById(R.id.product6);
        productkol1=(TextView)findViewById(R.id.productkol1);
        productkol2=(TextView)findViewById(R.id.productkol2);
        productkol3=(TextView)findViewById(R.id.productkol3);
        productkol4=(TextView)findViewById(R.id.productkol4);
        productkol5=(TextView)findViewById(R.id.productkol5);
        productkol6=(TextView)findViewById(R.id.productkol6);
        status1=(TextView)findViewById(R.id.status1);
        number1=(TextView)findViewById(R.id.number1);
        sum1=(TextView)findViewById(R.id.sum1);
        product21=(TextView)findViewById(R.id.product21);
        product22=(TextView)findViewById(R.id.product22);
        product23=(TextView)findViewById(R.id.product23);
        product24=(TextView)findViewById(R.id.product24);
        product25=(TextView)findViewById(R.id.product25);
        product26=(TextView)findViewById(R.id.product26);
        productkol21=(TextView)findViewById(R.id.productkol21);
        productkol22=(TextView)findViewById(R.id.productkol22);
        productkol23=(TextView)findViewById(R.id.productkol23);
        productkol24=(TextView)findViewById(R.id.productkol24);
        productkol25=(TextView)findViewById(R.id.productkol25);
        productkol26=(TextView)findViewById(R.id.productkol26);
        status21=(TextView)findViewById(R.id.status21);
        number21=(TextView)findViewById(R.id.number21);
        sum21=(TextView)findViewById(R.id.sum21);
        product31=(TextView)findViewById(R.id.product31);
        product32=(TextView)findViewById(R.id.product32);
        product33=(TextView)findViewById(R.id.product33);
        product34=(TextView)findViewById(R.id.product34);
        product35=(TextView)findViewById(R.id.product35);
        product36=(TextView)findViewById(R.id.product36);
        productkol31=(TextView)findViewById(R.id.productkol31);
        productkol32=(TextView)findViewById(R.id.productkol32);
        productkol33=(TextView)findViewById(R.id.productkol33);
        productkol34=(TextView)findViewById(R.id.productkol34);
        productkol35=(TextView)findViewById(R.id.productkol35);
        productkol36=(TextView)findViewById(R.id.productkol36);
        status31=(TextView)findViewById(R.id.status31);
        number31=(TextView)findViewById(R.id.number31);
        sum31=(TextView)findViewById(R.id.sum31);
        product41=(TextView)findViewById(R.id.product41);
        product42=(TextView)findViewById(R.id.product42);
        product43=(TextView)findViewById(R.id.product43);
        product44=(TextView)findViewById(R.id.product44);
        product45=(TextView)findViewById(R.id.product45);
        product46=(TextView)findViewById(R.id.product46);
        productkol41=(TextView)findViewById(R.id.productkol41);
        productkol42=(TextView)findViewById(R.id.productkol42);
        productkol43=(TextView)findViewById(R.id.productkol43);
        productkol44=(TextView)findViewById(R.id.productkol44);
        productkol45=(TextView)findViewById(R.id.productkol45);
        productkol46=(TextView)findViewById(R.id.productkol46);
        status41=(TextView)findViewById(R.id.status41);
        number41=(TextView)findViewById(R.id.number41);
        sum41=(TextView)findViewById(R.id.sum41);
    }
    public void productConnect(Avtomat[] avtomats)
    {
        product1.setText("Snikers");
        productkol1.setText(avtomats[0].products[0].kol+"");
        product2.setText("Mars");
        productkol2.setText(avtomats[0].products[1].kol+"");
        product3.setText("Bounty");
        productkol3.setText(avtomats[0].products[2].kol+"");
        product4.setText("Pepsi");
        productkol4.setText(avtomats[0].products[3].kol+"");
        product5.setText("7up");
        productkol5.setText(avtomats[0].products[4].kol+"");
        product6.setText("Water");
        productkol6.setText(avtomats[0].products[5].kol+"");

        product21.setText("Snikers");
        productkol21.setText(avtomats[1].products[0].kol+"");
        product22.setText("Mars");
        productkol22.setText(avtomats[1].products[1].kol+"");
        product23.setText("Bounty");
        productkol23.setText(avtomats[1].products[2].kol+"");
        product24.setText("Pepsi");
        productkol24.setText(avtomats[1].products[3].kol+"");
        product25.setText("7up");
        productkol25.setText(avtomats[1].products[4].kol+"");
        product26.setText("Water");
        productkol26.setText(avtomats[1].products[5].kol+"");

        product31.setText("Snikers");
        productkol31.setText(avtomats[2].products[0].kol+"");
        product32.setText("Mars");
        productkol32.setText(avtomats[2].products[1].kol+"");
        product33.setText("Bounty");
        productkol33.setText(avtomats[2].products[2].kol+"");
        product34.setText("Pepsi");
        productkol34.setText(avtomats[2].products[3].kol+"");
        product35.setText("7up");
        productkol35.setText(avtomats[2].products[4].kol+"");
        product36.setText("Water");
        productkol36.setText(avtomats[2].products[5].kol+"");

        product41.setText("Snikers");
        productkol41.setText(avtomats[3].products[0].kol+"");
        product42.setText("Mars");
        productkol42.setText(avtomats[3].products[1].kol+"");
        product43.setText("Bounty");
        productkol43.setText(avtomats[3].products[2].kol+"");
        product44.setText("Pepsi");
        productkol44.setText(avtomats[3].products[3].kol+"");
        product45.setText("7up");
        productkol45.setText(avtomats[3].products[4].kol+"");
        product46.setText("Water");
        productkol46.setText(avtomats[3].products[5].kol+"");
    }
}