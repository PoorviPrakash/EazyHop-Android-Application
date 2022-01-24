package com.example.poorviprakash.eazyhop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookPass extends Fragment {

    int date=1;
    //String pass="day";
    String busType;
    RadioButton radioDay,radioMonth;
    RadioGroup r;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.book_pass, container, false);
        Button bookbtn2 = (Button) rootView.findViewById(R.id.button2);
        Button bookbtn1 = (Button) rootView.findViewById(R.id.button1);
        Calendar calendar = Calendar.getInstance();
       // SimpleDateFormat mdformat = new SimpleDateFormat(" dd ");
        date=calendar.get(Calendar.DATE);
       /*String formattedDate = mdformat.format(calendar.getTime());
        date = Integer.parseInt(formattedDate);*/
       r=(RadioGroup)rootView.findViewById(R.id.radioGroup);
       radioDay=(RadioButton)rootView.findViewById(R.id.radioDay);
        radioMonth=(RadioButton)rootView.findViewById(R.id.radioMonth);

            if (date > 10)
                radioMonth.setEnabled(false);

        bookbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioDay.isChecked() == true) {
                    busType="1";
                    Intent intent = new Intent(getActivity(), MainBuyPassActivity.class);
                    //pass = "day";
                    intent.putExtra("busType",busType);
                    //intent.putExtra("Pass", pass);
                    startActivity(intent);
                }
                else if(radioMonth.isChecked()==true && radioMonth.isEnabled()==true){
                    busType="1";
                    Intent intent1=new Intent(getActivity(),MainMonthPassActivity.class);
                    //intent1.putExtra("busNumber",busNumber);
                    intent1.putExtra("busType",busType);
                   // intent1.putExtra("Pass",pass);
                    startActivity(intent1);
                }
            }
        });

        bookbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioDay.isChecked() == true) {
                    busType="2";
                    Intent intent = new Intent(getActivity(), MainBuyPassActivity.class);
                   // pass = "monthly";
                    //intent.putExtra("Pass", pass);
                    intent.putExtra("busType",busType);
                    startActivity(intent);
                }
                else if(radioMonth.isChecked()==true && radioMonth.isEnabled()==true){
                    busType="2";
                    Intent intent1=new Intent(getActivity(),MainMonthPassActivity.class);
                    //intent1.putExtra("busNumber",busNumber);
                    intent1.putExtra("busType",busType);
                    // intent1.putExtra("Pass",pass);
                    startActivity(intent1);
                }
            }
        });

        return rootView;
    }
}
