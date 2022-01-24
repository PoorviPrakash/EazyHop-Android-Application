package com.example.poorviprakash.eazyhop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainBuyPassActivity extends AppCompatActivity {

    //TextView busNumberText;
    TextView currentDate;
    TextView currentTime;
    TextView dayText;
    TextView nextDate;
    TextView fareText;
    TextView totalFareText;
    TextView gstText;
    String curTime,day,nextDay,pass;
    Spinner numberAdults,numberChild,numberSrC,idType;
    Button calButton,buyButton;
    int numAdults,numChild, numSrC,fare,gst,totalFare;
    String busNumber;
    String busType,formattedDate;
    EditText nameText,idText;
    RadioButton female,male;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_buy_pass);

        //busNumberText=(TextView)findViewById(R.id.textView8);
        currentDate=(TextView)findViewById(R.id.textView14);
        currentTime=(TextView)findViewById(R.id.textView16);
        fareText=(TextView)findViewById(R.id.textView26);
        totalFareText=(TextView)findViewById(R.id.textView30);
        dayText=(TextView)findViewById(R.id.Daytext);
        nextDate=(TextView)findViewById(R.id.textValidDay);
        calButton=(Button)findViewById(R.id.calculateButton);
        gstText=(TextView)findViewById(R.id.textView28);
        nameText=(EditText)findViewById(R.id.editName);
        idType=(Spinner)findViewById(R.id.spinnerId);
        idText=(EditText)findViewById(R.id.textIDno);
        female=(RadioButton)findViewById(R.id.radioButtonFemale);
        male=(RadioButton)findViewById(R.id.radioButtonMale);

        Intent intent=getIntent();
       // busNumber=intent.getStringExtra("busNumber");
        busType=intent.getStringExtra("busType");
        //pass=intent.getStringExtra("Pass");

        /*if(pass.equals("monthly")){
            Intent intent1=new Intent(this,MainMonthPassActivity.class);
            intent1.putExtra("busNumber",busNumber);
            intent1.putExtra("busType",busType);
            intent1.putExtra("Pass",pass);
            startActivity(intent1);
        }*/

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

       int i = d.get(Calendar.DAY_OF_WEEK);
        String daysArray[] = {"Sunday","Monday","Tuesday", "Wednesday","Thursday","Friday", "Saturday"};
        day=daysArray[i-1];
        if(day!=null)
            dayText.setText(day);

        if(day.equals("Saturday"))
            nextDay=daysArray[0] + " 00:00:00 ";
        else
            nextDay=daysArray[i] + " 00:00:00 ";
        if(nextDay!=null)
            nextDate.setText(nextDay);
        buyButton=(Button)findViewById(R.id.buttonBuyPass);

        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(busType.equals("1")){
                    fare = 140;
                    gst = 7;
                    totalFare = fare + gst;
                    fareText.setText(String.valueOf(fare));
                    gstText.setText(String.valueOf(gst));
                    totalFareText.setText(String.valueOf(totalFare));
                }
                else if(busType.equals("2")){
                    fare =80;
                    gst = 5;
                    totalFare = fare + gst;
                    fareText.setText(String.valueOf(fare));
                    gstText.setText(String.valueOf(gst));
                    totalFareText.setText(String.valueOf(totalFare));
                }
            }
        });

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=" ";
                String bp=String.valueOf(idType.getSelectedItemPosition());
                String gender="male";
                //int nop=numAdults+numSrC+numChild;

                FileOutputStream fos= null;
                try {
                    fos = openFileOutput("currentDayPass.txt",MODE_PRIVATE);
                    fos.write(nameText.getText().toString().getBytes());
                    fos.write(s.getBytes());
                    fos.write(formattedDate.getBytes());
                    fos.write(s.getBytes());
                    fos.write(day.getBytes());
                    fos.write(s.getBytes());
                    fos.write(curTime.getBytes());
                    fos.write(s.getBytes());
                    fos.write(nextDay.getBytes());
                    fos.write(s.getBytes());
                    fos.write(bp.getBytes());
                    fos.write(s.getBytes());
                    fos.write(idText.getText().toString().getBytes());
                    fos.write(s.getBytes());
                    if(female.isChecked())
                        gender="Female";
                    else if(male.isChecked())
                        gender="Male";
                    fos.write(gender.getBytes());
                    fos.write(s.getBytes());
                    fos.write(s.getBytes());
                    fos.write(String.valueOf(totalFare).getBytes());
                    fos.write(s.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent i=new Intent(MainBuyPassActivity.this, PassDisplay.class );
                startActivity(i);


            }
        });
    }
}
