package com.ssd.cy.androidhw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedInputStream;

public class ListActivity extends AppCompatActivity {

    TextView dataTextView;
    ArrayList<String> dataArray = new ArrayList<String>();
    ArrayList<String> newDataArray = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        dataTextView = (TextView) findViewById(R.id.dataTextView);

        //read from INTERNAL storage
        try
        {
            FileInputStream fin = openFileInput("textfile.txt");
            int c;
            String data="";
            String temp = "";
            while( (c = fin.read()) != -1 ){
                data = Character.toString((char)c);
                dataArray.add(data);
            }
            fin.close();

            for(int i = 0; i < dataArray.size(); i++) {
                temp = temp + dataArray.get(i);
            }

            String[] myData = temp.split("\\|");

            for(int i = 0; i < myData.length; i++) {
                String[] myData2 = myData[i].split(",");
                dataTextView.append("Brand: " + myData2[0] + "\n" +
                                    "Model: " + myData2[1] + "\n" +
                                    "Reference: " + myData2[2] + "\n" +
                                    "Movement: " + myData2[3] + "\n" +
                                    "Complication: " + myData2[4] + "\n" +
                                    "Materials: " + myData2[5] + "\n" +
                                    "Diameter: " + myData2[6] + "\n\n");
            }


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
    }
}
