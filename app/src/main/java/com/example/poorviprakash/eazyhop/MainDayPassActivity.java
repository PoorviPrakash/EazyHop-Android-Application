package com.example.poorviprakash.eazyhop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class MainDayPassActivity extends AppCompatActivity {

    String barcodeResult="KA-05-F-1186";
    String busType="1";
    String pass="day";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_day_pass);
        Intent i=getIntent();
        pass=i.getStringExtra("Pass");
    }
            public void onButtonVajra(View view)
            {
                busType="1";
                    Intent intent=new Intent(this,MainBuyPassActivity.class);
                    intent.putExtra("busNumber", barcodeResult);
                    intent.putExtra("busType", busType);
                    intent.putExtra("Pass", pass);
                    startActivity(intent);
                /*Intent intent = new Intent(getActivity(), QrCodeScanner.class);
                startActivityForResult(intent, 0 );*/

            }
            public void onButtonNonAC(View view) {
                busType = "2";
                    Intent intent = new Intent(this, MainBuyPassActivity.class);
                    intent.putExtra("busNumber", barcodeResult);
                    intent.putExtra("busType", busType);
                    intent.putExtra("Pass", pass);
                    startActivity(intent);
                /*Intent intent = new Intent(getActivity(), QrCodeScanner.class);
                startActivityForResult(intent, 0 );*/
            }

              @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra("barcode");
                    barcodeResult= barcode.displayValue;

                    if(barcodeResult!=null){
                        Intent intent=new Intent(MainDayPassActivity.this, MainBuyPassActivity.class);
                        intent.putExtra("busNumber",barcodeResult);
                        intent.putExtra("busType",busType);
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(this,"No Barcode found", Toast.LENGTH_SHORT).show();
                   // barcodeResult.setText("No barcode found");
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    }

