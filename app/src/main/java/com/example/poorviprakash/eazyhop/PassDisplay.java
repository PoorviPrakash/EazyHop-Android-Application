package com.example.poorviprakash.eazyhop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class PassDisplay extends AppCompatActivity {

    String b=" ";
    String t=new String();
    String[] idtypes={"Driving License","Aadhar Card","Pan Card","BMTC ID"};
    TextView nameText,dateText,dayText,timeText,validDateText,idTypeText,idNumberText,genderText,totaltext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_display);

        Toast.makeText(PassDisplay.this,"Pass Purchased",Toast.LENGTH_LONG).show();

        nameText=(TextView)findViewById(R.id.nameText);
        dateText=(TextView)findViewById(R.id.dateText);
        dayText=(TextView)findViewById(R.id.dayText);
        timeText=(TextView)findViewById(R.id.timeText);
        validDateText=(TextView)findViewById(R.id.validDateText);
        idTypeText=(TextView)findViewById(R.id.idTypeText);
        idNumberText=(TextView)findViewById(R.id.idNumberText);
        genderText=(TextView)findViewById(R.id.genderText);
        totaltext=(TextView)findViewById(R.id.totalText);

        try {
            FileInputStream fis=openFileInput("currentDayPass.txt");
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
       // Toast.makeText(PassDisplay.this, "Length"+String.valueOf(len),Toast.LENGTH_LONG).show();
        //nameText.setText(b);
        //Log.d("ticket", "onCreate: "+ arr);
        i=Integer.parseInt(arr[13]);
        //j=Integer.parseInt(arr[13]);*/
        nameText.setText(arr[1]);//+" "+arr[2]);/*+" "+arr[3]+" "+ arr[4]);
        dateText.setText(arr[2]+arr[3]+arr[4]+arr[5]+arr[6]);
        dayText.setText(arr[8]);
        timeText.setText(arr[9]);
        validDateText.setText(arr[10]+" "+arr[11]);
        idTypeText.setText(idtypes[i]);
        idNumberText.setText(arr[14]);
        genderText.setText(arr[15]);
        totaltext.setText("Rs." + arr[16]+arr[17]);

    }
}
