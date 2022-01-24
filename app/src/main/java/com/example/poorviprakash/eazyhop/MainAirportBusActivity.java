package com.example.poorviprakash.eazyhop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainAirportBusActivity extends AppCompatActivity {


    TextView busNumberText;
    TextView currentDate;
    TextView currentTime;
    String curTime,busNumber,formattedDate;
    TextView fareText;
    TextView totalFareText;
    TextView gstText;
    int startIndex,lastIndex,index,i;
    int[] array=new int[3];
    Spinner spinnerOfSource,spinnerOfDestination;
    Spinner numberAdults,numberChild,numberSrC;
    Button calButton,buyButton;
    int numAdults,numChild, numSrC,fare,gst,totalFare;
    BusAirDataBaseHelper airHelper = new BusAirDataBaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_airport_bus);

        busNumberText=(TextView)findViewById(R.id.textView8);
        currentDate=(TextView)findViewById(R.id.textView14);
        currentTime=(TextView)findViewById(R.id.textView16);
        fareText=(TextView)findViewById(R.id.textView26);
        totalFareText=(TextView)findViewById(R.id.textView30);
        gstText=(TextView)findViewById(R.id.textView28);

        Intent intent=getIntent();
        busNumber=intent.getStringExtra("busNumber");
        String busType=intent.getStringExtra("busType");
        busNumberText.setText(busNumber);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
        formattedDate = mdformat.format(calendar.getTime());
        if(formattedDate!=null)
        currentDate.setText(formattedDate);

        Calendar d = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        curTime = sdf.format(d.getTime());
        if(curTime!=null)
        currentTime.setText(curTime);

        spinnerOfSource=(Spinner)findViewById(R.id.spinnerSource);
        numberAdults=(Spinner)findViewById(R.id.spinnerAdult);
        numberChild=(Spinner)findViewById(R.id.spinnerChild);
        numberSrC=(Spinner)findViewById(R.id.spinnerSrCitizen);

        calButton=(Button)findViewById(R.id.calculateButton);
        buyButton=(Button)findViewById(R.id.buttonBuy);

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                index =spinnerOfSource.getSelectedItemPosition();

                numAdults=Integer.parseInt(numberAdults.getSelectedItem().toString());
                numChild=Integer.parseInt(numberChild.getSelectedItem().toString());
                numSrC=Integer.parseInt(numberSrC.getSelectedItem().toString());

                airHelper.insertRows();

                Log.d("index", "onClick: "+index);

                i=airHelper.searchRows(index);

                fare=numAdults*i + numChild*i+ numSrC*i;
                gst = (numAdults+numChild+numSrC) * 3;
                totalFare=fare+gst;
                fareText.setText(String.valueOf(fare));
                gstText.setText(String.valueOf(gst));
                totalFareText.setText(String.valueOf(totalFare));
            }
        });
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainAirportBusActivity.this,"Ticket Purchased",Toast.LENGTH_LONG).show();

                String s=" ";
                String bp=String.valueOf(spinnerOfSource.getSelectedItemPosition());
                String dp="11";
                int nop=numAdults+numSrC+numChild;

                FileOutputStream fos= null;
                try {
                    fos = openFileOutput("currentTicket.txt",MODE_PRIVATE);
                    fos.write(busNumber.getBytes());
                    fos.write(s.getBytes());
                    fos.write(formattedDate.getBytes());
                    fos.write(s.getBytes());
                    fos.write(curTime.getBytes());
                    fos.write(s.getBytes());
                    fos.write(bp.getBytes());
                    fos.write(s.getBytes());
                    fos.write(dp.getBytes());
                    fos.write(s.getBytes());
                    fos.write(String.valueOf(nop).getBytes());
                    fos.write(s.getBytes());
                    fos.write(String.valueOf(totalFare).getBytes());
                    fos.write(s.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent i=new Intent(MainAirportBusActivity.this, TicketDisplay.class );
                startActivity(i);
            }
        });
    }
}
