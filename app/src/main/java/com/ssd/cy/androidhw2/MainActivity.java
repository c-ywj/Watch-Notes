package com.ssd.cy.androidhw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText brandTextBox;
    private EditText modelTextBox;
    private EditText refTextBox;
    private EditText movementTextBox;
    private EditText complicationsTextBox;
    private EditText materialTextBox;
    private EditText diameterTextBox;

    private Button libraryBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brandTextBox         = (EditText) findViewById(R.id.brandTextBox);
        modelTextBox         = (EditText) findViewById(R.id.modelTextBox);
        refTextBox           = (EditText) findViewById(R.id.refTextBox);
        movementTextBox      = (EditText) findViewById(R.id.movementTextBox);
        complicationsTextBox = (EditText) findViewById(R.id.complicationsTextBox);
        materialTextBox      = (EditText) findViewById(R.id.materialTextBox);
        diameterTextBox      = (EditText) findViewById(R.id.diameterTextBox);

        libraryBtn           = (Button) findViewById(R.id.libraryBtn);


        libraryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });
    }

    public void onClickSave(View view) {

        // write to INTERNAL storage
        String brandData = brandTextBox.getText().toString();
        String modelData = modelTextBox.getText().toString();
        String refData   = refTextBox.getText().toString();
        String movementData = movementTextBox.getText().toString();
        String complicationsData = complicationsTextBox.getText().toString();
        String materialData = materialTextBox.getText().toString();
        String diameterData = diameterTextBox.getText().toString();

        String allData =
                         brandData + "," +
                         modelData + "," +
                         refData + "," +
                         movementData + "," +
                         complicationsData + "," +
                         materialData + "," +
                         diameterData +
                         "|";
        try
        {
            FileOutputStream fOut = openFileOutput("textfile.txt", MODE_APPEND);
            fOut.write(allData.getBytes());
            fOut.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
        brandTextBox.setText("");
        modelTextBox.setText("");
        refTextBox.setText("");
        movementTextBox.setText("");
        complicationsTextBox.setText("");
        materialTextBox.setText("");
        diameterTextBox.setText("");

    }

    public void clearFields (View view) {

        brandTextBox.setText("");
        modelTextBox.setText("");
        refTextBox.setText("");
        movementTextBox.setText("");
        complicationsTextBox.setText("");
        materialTextBox.setText("");
        diameterTextBox.setText("");
    }



}
