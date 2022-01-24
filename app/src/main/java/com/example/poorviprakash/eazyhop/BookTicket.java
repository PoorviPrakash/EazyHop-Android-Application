package com.example.poorviprakash.eazyhop;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

public class BookTicket extends Fragment {
    String barcodeResult="KA-05-F-1186";
    String busType;
    int i;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.book_ticket, container, false);
        Button bookbtn1=(Button) rootView.findViewById(R.id.vayuVajrabutton);
        bookbtn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                busType="1";
                i=1;
                Intent intent = new Intent(getActivity(), QrCodeScanner.class);
                startActivityForResult(intent, 0 );
               /* Intent ticketintent=new Intent(getActivity(), MainAirportBusActivity.class);
                ticketintent.putExtra("busNumber",barcodeResult);
                ticketintent.putExtra("busType",busType);
                startActivity(ticketintent);*/

            }
        });
        Button bookbtn2=(Button) rootView.findViewById(R.id.vajraButton);
        bookbtn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                busType="2";
                i=2;
                Intent intent = new Intent(getActivity(), QrCodeScanner.class);
                startActivityForResult(intent, 0 );
                /*Intent ticketintent=new Intent(getActivity(), MainTicketActivity.class);
               ticketintent.putExtra("busNumber",barcodeResult);
               ticketintent.putExtra("busType",busType);
                startActivity(ticketintent);*/


            }
        });
        Button bookbtn3=(Button) rootView.findViewById(R.id.nonAcbutton8);
        bookbtn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                busType="3";
                i=3;
               Intent intent = new Intent(getActivity(), QrCodeScanner.class);
                startActivityForResult(intent, 0 );
                /*Intent ticketintent=new Intent(getActivity(), MainTicketActivity.class);
                 ticketintent.putExtra("busNumber",barcodeResult);
               ticketintent.putExtra("busType",busType);
                startActivity(ticketintent);*/

            }
        });
        return rootView;
    }

  @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    Barcode barcode = data.getParcelableExtra("barcode");
                    barcodeResult= barcode.displayValue;

                    if(barcodeResult!=null){
                        if(i==1)
                        {
                            busType="1";
                            Intent ticketintent=new Intent(getActivity(), MainAirportBusActivity.class);
                            ticketintent.putExtra("busNumber",barcodeResult);
                            ticketintent.putExtra("busType",busType);
                            startActivity(ticketintent);
                        }
                        else if(i==2) {
                            busType = "2";
                            Intent ticketintent = new Intent(getActivity(), MainTicketActivity.class);
                            ticketintent.putExtra("busNumber", barcodeResult);
                            ticketintent.putExtra("busType", busType);
                            startActivity(ticketintent);
                        }
                        else if(i==3){
                            busType="3";
                            Intent ticketintent=new Intent(getActivity(), MainTicketActivity.class);
                            ticketintent.putExtra("busNumber",barcodeResult);
                            ticketintent.putExtra("busType",busType);
                            startActivity(ticketintent);
                        }
                    }
                } else {
                    Toast.makeText(getContext(),"No Barcode found", Toast.LENGTH_SHORT).show();
                   // barcodeResult.setText("No barcode found");
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
