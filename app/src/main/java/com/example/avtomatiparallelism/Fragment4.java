package com.example.avtomatiparallelism;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.concurrent.TimeUnit;

public class Fragment4 extends Fragment {
    private LinearLayout hr;
    private LinearLayout lr;
    private LinearLayout l1;
    private LinearLayout l2;
    private LinearLayout l3;
    private LinearLayout l4;
    private Button Button4small;
    private Button Button4full;
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
    private Avtomat[] avtomats = new Avtomat[4];
    Fragment4(Avtomat[] avtomats){
        this.avtomats=avtomats;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment4view = inflater.inflate(R.layout.fragment4, container, false);
        Context context = getActivity().getApplicationContext();
        Button4full=(Button)fragment4view.findViewById(R.id.Button4f);
        Button4full.setOnClickListener(Clickf);
        Button4small=(Button)fragment4view.findViewById(R.id.Button4s);
        Button4small.setOnClickListener(Clicks);
        l1=(LinearLayout)getActivity().findViewById(R.id.table1);
        l2=(LinearLayout)getActivity().findViewById(R.id.table2);
        l3=(LinearLayout)getActivity().findViewById(R.id.table3);
        l4=(LinearLayout)getActivity().findViewById(R.id.table4);
        hr=(LinearLayout)getActivity().findViewById(R.id.highrow);
        lr=(LinearLayout)getActivity().findViewById(R.id.lowrow);
        product41=(TextView)fragment4view.findViewById(R.id.product41);
        product42=(TextView)fragment4view.findViewById(R.id.product42);
        product43=(TextView)fragment4view.findViewById(R.id.product43);
        product44=(TextView)fragment4view.findViewById(R.id.product44);
        product45=(TextView)fragment4view.findViewById(R.id.product45);
        product46=(TextView)fragment4view.findViewById(R.id.product46);
        productkol41=(TextView)fragment4view.findViewById(R.id.productkol41);
        productkol42=(TextView)fragment4view.findViewById(R.id.productkol42);
        productkol43=(TextView)fragment4view.findViewById(R.id.productkol43);
        productkol44=(TextView)fragment4view.findViewById(R.id.productkol44);
        productkol45=(TextView)fragment4view.findViewById(R.id.productkol45);
        productkol46=(TextView)fragment4view.findViewById(R.id.productkol46);
        status41=(TextView)fragment4view.findViewById(R.id.status41);
        number41=(TextView)fragment4view.findViewById(R.id.number41);
        sum41=(TextView)fragment4view.findViewById(R.id.sum41);
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
        Thread buy4 = new Thread(new RBuy4(avtomats));
        buy4.start();
        return fragment4view;
    }
    View.OnClickListener Clickf=(v)-> {
        l1.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        Button4full.setVisibility(View.GONE);
        Button4small.setVisibility(View.VISIBLE);
        hr.setVisibility(View.GONE);
    };
    View.OnClickListener Clicks=(v)-> {
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.VISIBLE);
        l3.setVisibility(View.VISIBLE);
        Button4full.setVisibility(View.VISIBLE);
        Button4small.setVisibility(View.GONE);
        hr.setVisibility(View.VISIBLE);
    };
    class RBuy4 implements Runnable {
        Avtomat[] avtomats;

        RBuy4(Avtomat[] avtomats) {
            this.avtomats = avtomats;
        }

        void ChoosingStatus(Avtomat[] avtomat, int i) {
            avtomat[i].status = "Choosing";
            status41.setText(avtomat[i].status);
            int z = (int) (Math.random() * 3);
            while (avtomat[i].products[z].kol == 0)
                z = (int) (Math.random() * 3);
            avtomat[i].makePurchase(z);
            switch (z) {
                case 0:
                    productkol41.setText(avtomat[i].products[z].kol + "");
                    break;
                case 1:
                    productkol42.setText(avtomat[i].products[z].kol + "");
                    break;
                case 2:
                    productkol43.setText(avtomat[i].products[z].kol + "");
                    break;
            }
            sum41.setText("Сумма:" + avtomat[i].products[z].price);
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
                    productkol41.setText(avtomat[i].products[z].kol + "");
                    break;
                case 4:
                    productkol42.setText(avtomat[i].products[z].kol + "");
                    break;
                case 5:
                    productkol43.setText(avtomat[i].products[z].kol + "");
                    break;
            }
            sum41.setText("Сумма:" + avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PaymentStatus(avtomat, i);
        }

        void FreeStatus(Avtomat[] avtomat, int i) {
            avtomat[i].status = "Free";
            status41.setText(avtomat[i].status);
            number41.setText("" + -1);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (avtomat[i].getperson() != -1) {
                avtomat[i].buyer = avtomat[i].getperson();
                number41.setText("№" + (avtomat[i].buyer + 1));
                ChoosingStatus(avtomat, i);
            }
        }

        void PaymentStatus(Avtomat[] avtomat, int i) {
            avtomat[i].status = "Payment";
            status41.setText(avtomat[i].status);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            avtomat[i].sum = 0;
            avtomat[i].deleteperson();
            sum41.setText("Сумма:" + avtomat[i].sum);
            avtomat[i].buyer = -1;
            FreeStatus(avtomat, i);
        }

        @Override
        public void run() {
            int i = 3;
            FreeStatus(avtomats, i);
        }
    }
}
