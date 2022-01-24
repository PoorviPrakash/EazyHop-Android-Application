package com.example.poorviprakash.eazyhop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicketDisplay extends AppCompatActivity {

    String b=" ";
    String t=new String();
    TextView busText,dateText,timeText,boardText,destText,passText,totaltext;
    String[] locations={"Hebbala Bridge","Manyatha Tech Park","Kalyananagara Bus Stand","Ramamurthy Nagara","K R Puram","EMC2","Marathahalli Bridge","New Horizon College of Engineering","Bellanduru","Sarjapura Cross","Central Silk Board","Kempegowda International Airport"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_display);
        busText=(TextView)findViewById(R.id.busText);
        dateText=(TextView)findViewById(R.id.dateText);
        timeText=(TextView)findViewById(R.id.timeText);
        boardText=(TextView)findViewById(R.id.boardText);
        destText=(TextView)findViewById(R.id.destText);
        passText=(TextView)findViewById(R.id.passText);
        totaltext=(TextView)findViewById(R.id.totalText);

        Toast.makeText(TicketDisplay.this,"Ticket Purchased",Toast.LENGTH_LONG).show();

        try {
            FileInputStream fis=openFileInput("currentTicket.txt");
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);

            while((t=br.readLine())!=null)
            {
                b=b+t;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Integer i,j;
        String[] arr=b.split(" ");
        int len=arr.length;
       // Toast.makeText(TicketDisplay.this, "Length"+String.valueOf(len),Toast.LENGTH_LONG).show();
        //busText.setText(b);
        //Log.d("ticket", "onCreate: "+ arr);
        i=Integer.parseInt(arr[12]);
        j=Integer.parseInt(arr[13]);
        busText.setText(arr[1]+" "+arr[2]+" "+arr[3]+" "+ arr[4]);
        dateText.setText(arr[5]+arr[6]+arr[7]+arr[8]+arr[9]);
        timeText.setText(arr[10]+arr[11]);
        boardText.setText(locations[i]);
        destText.setText(locations[j]);
        passText.setText(arr[14]);
        totaltext.setText("Rs." + arr[15]);

    }
}
