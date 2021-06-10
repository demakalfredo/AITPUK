package com.example.aitpuk20;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class popup_listunsur extends AppCompatActivity {

    // Declare Variables
    TextView txtnomassa,txtdefinisi,txtelektronsel,txtkonfelektron;
    ImageView imgimages;
    Button txturl, wikipedia;
    String gol,definisi,names,nomassa,url,elektronsel,konfelektron;


    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_listunsur);
        TextView txtclose;


        txtclose = (TextView) findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txtnomassa = (TextView)findViewById(R.id.nomassa);
        txtnomassa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.nomor_massa_layout_horizontal, (ViewGroup) findViewById(R.id.custom_toast_layout_horiontal));
                TextView textView = (TextView) layout.findViewById(R.id.txtvwhorizontal);
                textView.setText("Nomor massa adalah jumlah total proton dan neutron dalam inti atom");
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER, 0, 100);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });
        txtnomassa = (TextView)findViewById(R.id.txtnomassa);
        txtnomassa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.nomor_massa_layout_horizontal, (ViewGroup) findViewById(R.id.custom_toast_layout_horiontal));
                TextView textView = (TextView) layout.findViewById(R.id.txtvwhorizontal);
                textView.setText("Nomor massa adalah jumlah total proton dan neutron dalam inti atom");
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER, 0, 100);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });


        wikipedia = (Button)findViewById(R.id.btnwikipedia);
        wikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse(url = i.getStringExtra("url"));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        // Get the intent from ListViewAdapter
        Intent i = getIntent();
        //mengambil hasil dari array konfelektron
        konfelektron = i.getStringExtra("konfelektron");
        //mengambil hasil dari array elektronsel
        elektronsel = i.getStringExtra("elektronsel");
        //mengambil hasil dari array definisi
        definisi = i.getStringExtra("definisi");
        //mengambil hasil dari array nomassa
        nomassa = i.getStringExtra("nomassa");
        // Get the results of rank
        gol = i.getStringExtra("gol");
        // Get the results of population
        //names = i.getStringExtra("names");
        // Get the results of flag
        images = i.getIntExtra("images", images);

        // Menetapkan TextViews pada singleitemview.xml
        txtdefinisi = (TextView) findViewById(R.id.definisi);
        txtelektronsel = (TextView) findViewById(R.id.elektronsel);
        txtnomassa = (TextView) findViewById(R.id.nomassa);
        txtkonfelektron = (TextView) findViewById(R.id.konfelektron);

        // Menetapkan ImageView pada singleitemview.xml
        imgimages = (ImageView) findViewById(R.id.gambarunsur);

        // Memuat hasil ke TextViews
        //txtgol.setText(gol);
        txtdefinisi.setText(definisi);
        txtnomassa.setText(nomassa);
        txtelektronsel.setText(elektronsel);
        txtkonfelektron.setText(konfelektron);


        //txtnames.setText(names);

        // Memuat gambar ke ImageView
        imgimages.setImageResource(images);
    }
}
