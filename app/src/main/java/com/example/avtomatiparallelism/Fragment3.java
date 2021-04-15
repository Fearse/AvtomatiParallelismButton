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

public class Fragment3 extends Fragment {
    private LinearLayout hr;
    private LinearLayout lr;
    private LinearLayout l1;
    private LinearLayout l2;
    private LinearLayout l3;
    private LinearLayout l4;
    private Button Button3small;
    private Button Button3full;
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
    private Avtomat[] avtomats = new Avtomat[4];
    Fragment3(Avtomat[] avtomats){
        this.avtomats=avtomats;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment3view = inflater.inflate(R.layout.fragment3, container, false);
        Context context = getActivity().getApplicationContext();
        Button3full=(Button)fragment3view.findViewById(R.id.Button3f);
        Button3full.setOnClickListener(Clickf);
        Button3small=(Button)fragment3view.findViewById(R.id.Button3s);
        Button3small.setOnClickListener(Clicks);
        l1=(LinearLayout)getActivity().findViewById(R.id.table1);
        l2=(LinearLayout)getActivity().findViewById(R.id.table2);
        l3=(LinearLayout)getActivity().findViewById(R.id.table3);
        l4=(LinearLayout)getActivity().findViewById(R.id.table4);
        hr=(LinearLayout)getActivity().findViewById(R.id.highrow);
        lr=(LinearLayout)getActivity().findViewById(R.id.lowrow);
        product31=(TextView)fragment3view.findViewById(R.id.product31);
        product32=(TextView)fragment3view.findViewById(R.id.product32);
        product33=(TextView)fragment3view.findViewById(R.id.product33);
        product34=(TextView)fragment3view.findViewById(R.id.product34);
        product35=(TextView)fragment3view.findViewById(R.id.product35);
        product36=(TextView)fragment3view.findViewById(R.id.product36);
        productkol31=(TextView)fragment3view.findViewById(R.id.productkol31);
        productkol32=(TextView)fragment3view.findViewById(R.id.productkol32);
        productkol33=(TextView)fragment3view.findViewById(R.id.productkol33);
        productkol34=(TextView)fragment3view.findViewById(R.id.productkol34);
        productkol35=(TextView)fragment3view.findViewById(R.id.productkol35);
        productkol36=(TextView)fragment3view.findViewById(R.id.productkol36);
        status31=(TextView)fragment3view.findViewById(R.id.status31);
        number31=(TextView)fragment3view.findViewById(R.id.number31);
        sum31=(TextView)fragment3view.findViewById(R.id.sum31);
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
        Thread buy3 = new Thread(new RBuy3(avtomats));
        buy3.start();
        return fragment3view;
    }
    View.OnClickListener Clickf=(v)-> {
        l1.setVisibility(View.GONE);
        l2.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);
        Button3full.setVisibility(View.GONE);
        Button3small.setVisibility(View.VISIBLE);
        hr.setVisibility(View.GONE);
    };
    View.OnClickListener Clicks=(v)-> {
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.VISIBLE);
        l4.setVisibility(View.VISIBLE);
        Button3full.setVisibility(View.VISIBLE);
        Button3small.setVisibility(View.GONE);
        hr.setVisibility(View.VISIBLE);
    };
    class RBuy3 implements Runnable {
        Avtomat[] avtomats;

        RBuy3(Avtomat[] avtomats) {
            this.avtomats = avtomats;
        }

        void ChoosingStatus(Avtomat[] avtomat, int i) {
            avtomat[i].status = "Choosing";
            status31.setText(avtomat[i].status);
            int z = (int) (Math.random() * 3);
            while (avtomat[i].products[z].kol == 0)
                z = (int) (Math.random() * 3);
            avtomat[i].makePurchase(z);
            switch (z) {
                case 0:
                    productkol31.setText(avtomat[i].products[z].kol + "");
                    break;
                case 1:
                    productkol32.setText(avtomat[i].products[z].kol + "");
                    break;
                case 2:
                    productkol33.setText(avtomat[i].products[z].kol + "");
                    break;
            }
            sum31.setText("Сумма:" + avtomat[i].products[z].price);
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
                    productkol31.setText(avtomat[i].products[z].kol + "");
                    break;
                case 4:
                    productkol32.setText(avtomat[i].products[z].kol + "");
                    break;
                case 5:
                    productkol33.setText(avtomat[i].products[z].kol + "");
                    break;
            }
            sum31.setText("Сумма:" + avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PaymentStatus(avtomat, i);
        }

        void FreeStatus(Avtomat[] avtomat, int i) {
            avtomat[i].status = "Free";
            status31.setText(avtomat[i].status);
            number31.setText("" + -1);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (avtomat[i].getperson() != -1) {
                avtomat[i].buyer = avtomat[i].getperson();
                number31.setText("№" + (avtomat[i].buyer + 1));
                ChoosingStatus(avtomat, i);
            }
        }

        void PaymentStatus(Avtomat[] avtomat, int i) {
            avtomat[i].status = "Payment";
            status31.setText(avtomat[i].status);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            avtomat[i].sum = 0;
            avtomat[i].deleteperson();
            sum31.setText("Сумма:" + avtomat[i].sum);
            avtomat[i].buyer = -1;
            FreeStatus(avtomat, i);
        }

        @Override
        public void run() {
            int i = 2;
            FreeStatus(avtomats, i);
        }
    }
}
