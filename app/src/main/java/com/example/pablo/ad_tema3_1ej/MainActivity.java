package com.example.pablo.ad_tema3_1ej;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button mostrar;
    Button fichero;
    EditText etxt;
    TextView txtV;
    String txt;
    String txt2;
    OutputStreamWriter escritor=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mostrar = (Button) findViewById(R.id.btn2);
        fichero = (Button) findViewById(R.id.btn1);
        etxt = (EditText) findViewById(R.id.etxt);
        txt = "file.txt";
        txtV = (TextView) findViewById(R.id.txt);



        fichero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    FileOutputStream fos = openFileOutput("file_prueba.txt", Context.MODE_PRIVATE);
                    String cadenaOutput = new String(etxt.getText().toString()+"\n");
                    DataOutputStream dos = new DataOutputStream(fos);
                    dos.writeBytes(cadenaOutput);
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Resources myResources = getResources();
                    InputStream myFile = myResources.openRawResource(R.raw.file);

                    byte[] buff = new byte[1000];
                    myFile.read(buff);
                    txtV.setText("He leído: " + new String(buff));
                    myFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });



    }
}
