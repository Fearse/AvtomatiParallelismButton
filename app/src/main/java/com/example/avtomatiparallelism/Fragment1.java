package com.example.avtomatiparallelism;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.w3c.dom.Text;

import java.util.concurrent.TimeUnit;

public class Fragment1 extends Fragment {
    private LinearLayout hr;
    private LinearLayout lr;
    private LinearLayout l1;
    private LinearLayout l2;
    private LinearLayout l3;
    private LinearLayout l4;
    private Button Button1small;
    private Button Button1full;
    public TextView product1;
    public TextView product2;
    public TextView product3;
    public TextView product4;
    public TextView product5;
    public TextView product6;
    public TextView status1;
    public TextView sum1;
    public TextView number1;
    public TextView productkol1;
    public TextView productkol2;
    public TextView productkol3;
    public TextView productkol4;
    public TextView productkol5;
    public TextView productkol6;
    private Avtomat[] avtomats = new Avtomat[4];
    Fragment1(Avtomat[] avtomats){
        this.avtomats=avtomats;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View fragment1view = inflater.inflate(R.layout.fragment1,container,false);
        Context context = getActivity().getApplicationContext();
            Button1full=(Button)fragment1view.findViewById(R.id.Button1f);
            Button1full.setOnClickListener(Clickf);
            Button1small=(Button)fragment1view.findViewById(R.id.Button1s);
            Button1small.setOnClickListener(Clicks);
            l1=(LinearLayout)getActivity().findViewById(R.id.table1);
            l2=(LinearLayout)getActivity().findViewById(R.id.table2);
            l3=(LinearLayout)getActivity().findViewById(R.id.table3);
            l4=(LinearLayout)getActivity().findViewById(R.id.table4);
            hr=(LinearLayout)getActivity().findViewById(R.id.highrow);
            lr=(LinearLayout)getActivity().findViewById(R.id.lowrow);
            product1=(TextView)fragment1view.findViewById(R.id.product1);
            product2=(TextView)fragment1view.findViewById(R.id.product2);
            product3=(TextView)fragment1view.findViewById(R.id.product3);
            product4=(TextView)fragment1view.findViewById(R.id.product4);
            product5=(TextView)fragment1view.findViewById(R.id.product5);
            product6=(TextView)fragment1view.findViewById(R.id.product6);
            status1=(TextView)fragment1view.findViewById(R.id.status1);
            number1=(TextView)fragment1view.findViewById(R.id.number1);
            sum1=(TextView)fragment1view.findViewById(R.id.sum1);
        productkol1=(TextView)fragment1view.findViewById(R.id.productkol1);
        productkol2=(TextView)fragment1view.findViewById(R.id.productkol2);
        productkol3=(TextView)fragment1view.findViewById(R.id.productkol3);
        productkol4=(TextView)fragment1view.findViewById(R.id.productkol4);
        productkol5=(TextView)fragment1view.findViewById(R.id.productkol5);
        productkol6=(TextView)fragment1view.findViewById(R.id.productkol6);
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
        Thread buy1 = new Thread(new RBuy1(avtomats));
        buy1.start();
        /*LinearLayout layout = new LinearLayout(context);
        layout.setBackgroundColor(Color.BLUE);
        TextView text = new TextView(context);
        text.setText("fragment");
        layout.addView(text);
        */

        return fragment1view;
    }
View.OnClickListener Clickf=(v)-> {
    l2.setVisibility(View.GONE);
    l3.setVisibility(View.GONE);
    l4.setVisibility(View.GONE);
    Button1full.setVisibility(View.GONE);
    Button1small.setVisibility(View.VISIBLE);
    lr.setVisibility(View.GONE);
};
    View.OnClickListener Clicks=(v)-> {
        l2.setVisibility(View.VISIBLE);
        l3.setVisibility(View.VISIBLE);
        l4.setVisibility(View.VISIBLE);
        Button1full.setVisibility(View.VISIBLE);
        Button1small.setVisibility(View.GONE);
        lr.setVisibility(View.VISIBLE);
    };
    class RBuy1 implements Runnable {
        Avtomat[] avtomats;

        RBuy1(Avtomat[] avtomats) {
            this.avtomats = avtomats;
        }

        void ChoosingStatus(Avtomat[] avtomat, int i) {
            avtomat[i].status = "Choosing";
            status1.setText(avtomat[i].status);
            int z = (int) (Math.random() * 3);
            while (avtomat[i].products[z].kol == 0)
                z = (int) (Math.random() * 3);
            avtomat[i].makePurchase(z);
            switch (z) {
                case 0:
                    productkol1.setText(avtomat[i].products[z].kol + "");
                    break;
                case 1:
                    productkol2.setText(avtomat[i].products[z].kol + "");
                    break;
                case 2:
                    productkol3.setText(avtomat[i].products[z].kol + "");
                    break;
            }
            sum1.setText("Сумма:" + avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            z = 3 + (int) (Math.random() * 3);
            while (avtomat[i].products[z].kol == 0)
                z = 3 + (int) (Math.random() * 3);
            avtomat[i].makePurchase(z);
            switch (z) {
                case 3:
                    productkol1.setText(avtomat[i].products[z].kol + "");
                    break;
                case 4:
                    productkol2.setText(avtomat[i].products[z].kol + "");
                    break;
                case 5:
                    productkol3.setText(avtomat[i].products[z].kol + "");
                    break;
            }
            sum1.setText("Сумма:" + avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PaymentStatus(avtomat, i);
        }

        void FreeStatus(Avtomat[] avtomat, int i) {
            avtomat[i].status = "Free";
            status1.setText(avtomat[i].status);
            number1.setText("" + -1);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (avtomat[i].getperson() != -1) {
                avtomat[i].buyer = avtomat[i].getperson();
                number1.setText("№" + (avtomat[i].buyer + 1));
                ChoosingStatus(avtomat, i);
            }
        }

        void PaymentStatus(Avtomat[] avtomat, int i) {
            avtomat[i].status = "Payment";
            status1.setText(avtomat[i].status);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 4));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            avtomat[i].sum = 0;
            avtomat[i].deleteperson();
            sum1.setText("Сумма:" + avtomat[i].sum);
            avtomat[i].buyer = -1;
            FreeStatus(avtomat, i);
        }

        @Override
        public void run() {
            int i = 0;
            FreeStatus(avtomats, i);
        }
    }
}
