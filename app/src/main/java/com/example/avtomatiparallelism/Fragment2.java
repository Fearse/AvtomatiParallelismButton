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

public class Fragment2 extends Fragment {
    private LinearLayout hr;
    private LinearLayout lr;
    private LinearLayout l1;
    private LinearLayout l2;
    private LinearLayout l3;
    private LinearLayout l4;
    private Button Button2small;
    private Button Button2full;
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
    private Avtomat[] avtomats = new Avtomat[4];
    Fragment2(Avtomat[] avtomats){
        this.avtomats=avtomats;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragment2view = inflater.inflate(R.layout.fragment2, container, false);
        Context context = getActivity().getApplicationContext();
        Button2full=(Button)fragment2view.findViewById(R.id.Button2f);
        Button2full.setOnClickListener(Clickf);
        Button2small=(Button)fragment2view.findViewById(R.id.Button2s);
        Button2small.setOnClickListener(Clicks);
        l1=(LinearLayout)getActivity().findViewById(R.id.table1);
        l2=(LinearLayout)getActivity().findViewById(R.id.table2);
        l3=(LinearLayout)getActivity().findViewById(R.id.table3);
        l4=(LinearLayout)getActivity().findViewById(R.id.table4);
        hr=(LinearLayout)getActivity().findViewById(R.id.highrow);
        lr=(LinearLayout)getActivity().findViewById(R.id.lowrow);
        product21=(TextView)fragment2view.findViewById(R.id.product21);
        product22=(TextView)fragment2view.findViewById(R.id.product22);
        product23=(TextView)fragment2view.findViewById(R.id.product23);
        product24=(TextView)fragment2view.findViewById(R.id.product24);
        product25=(TextView)fragment2view.findViewById(R.id.product25);
        product26=(TextView)fragment2view.findViewById(R.id.product26);
        productkol21=(TextView)fragment2view.findViewById(R.id.productkol21);
        productkol22=(TextView)fragment2view.findViewById(R.id.productkol22);
        productkol23=(TextView)fragment2view.findViewById(R.id.productkol23);
        productkol24=(TextView)fragment2view.findViewById(R.id.productkol24);
        productkol25=(TextView)fragment2view.findViewById(R.id.productkol25);
        productkol26=(TextView)fragment2view.findViewById(R.id.productkol26);
        status21=(TextView)fragment2view.findViewById(R.id.status21);
        number21=(TextView)fragment2view.findViewById(R.id.number21);
        sum21=(TextView)fragment2view.findViewById(R.id.sum21);
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

        Thread buy2 = new Thread(new RBuy2(avtomats));
        buy2.start();
        return fragment2view;
    }
    View.OnClickListener Clickf=(v)-> {
        l1.setVisibility(View.GONE);
        l3.setVisibility(View.GONE);
        l4.setVisibility(View.GONE);
        Button2full.setVisibility(View.GONE);
        Button2small.setVisibility(View.VISIBLE);
        lr.setVisibility(View.GONE);
    };
    View.OnClickListener Clicks=(v)-> {
        l1.setVisibility(View.VISIBLE);
        l3.setVisibility(View.VISIBLE);
        l4.setVisibility(View.VISIBLE);
        Button2full.setVisibility(View.VISIBLE);
        Button2small.setVisibility(View.GONE);
        lr.setVisibility(View.VISIBLE);
    };
    class RBuy2 implements Runnable {
        Avtomat[] avtomats;

        RBuy2(Avtomat[] avtomats) {
            this.avtomats = avtomats;
        }

        void ChoosingStatus(Avtomat[] avtomat, int i) {
            avtomat[i].status = "Choosing";
            status21.setText(avtomat[i].status);
            int z = (int) (Math.random() * 3);
            while (avtomat[i].products[z].kol == 0)
                z = (int) (Math.random() * 3);
            avtomat[i].makePurchase(z);
            switch (z) {
                case 0:
                    productkol21.setText(avtomat[i].products[z].kol + "");
                    break;
                case 1:
                    productkol22.setText(avtomat[i].products[z].kol + "");
                    break;
                case 2:
                    productkol23.setText(avtomat[i].products[z].kol + "");
                    break;
            }
            sum21.setText("Сумма:" + avtomat[i].products[z].price);
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
                    productkol21.setText(avtomat[i].products[z].kol + "");
                    break;
                case 4:
                    productkol22.setText(avtomat[i].products[z].kol + "");
                    break;
                case 5:
                    productkol23.setText(avtomat[i].products[z].kol + "");
                    break;
            }
            sum21.setText("Сумма:" + avtomat[i].products[z].price);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PaymentStatus(avtomat, i);
        }

        void FreeStatus(Avtomat[] avtomat, int i) {
            avtomat[i].status = "Free";
            status21.setText(avtomat[i].status);
            number21.setText("" + -1);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (avtomat[i].getperson() != -1) {
                avtomat[i].buyer = avtomat[i].getperson();
                number21.setText("№" + (avtomat[i].buyer + 1));
                ChoosingStatus(avtomat, i);
            }
        }

        void PaymentStatus(Avtomat[] avtomat, int i) {
            avtomat[i].status = "Payment";
            status21.setText(avtomat[i].status);
            try {
                TimeUnit.SECONDS.sleep((long) (Math.random() * 3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            avtomat[i].sum = 0;
            avtomat[i].deleteperson();
            sum21.setText("Сумма:" + avtomat[i].sum);
            avtomat[i].buyer = -1;
            FreeStatus(avtomat, i);
        }

        @Override
        public void run() {
            int i = 1;
            FreeStatus(avtomats, i);
        }
    }
}
