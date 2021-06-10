package com.example.aitpuk20;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.Html;
import android.text.Layout;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.uncopt.android.widget.text.justify.JustifiedTextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //deklrasi
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    Dialog myDialog;

    ArrayList<ClassNames> arraylist = new ArrayList<ClassNames>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myDialog = new Dialog(this);

        //memasukkan data
        final String[] definisi = {
                "Hidrogen (bahasa Latin: hydrogenium, dari bahasa Yunani: hydro: air, genes: membentuk) " +
                        "adalah unsur kimia pada tabel periodik yang memiliki simbol H dan nomor atom 1. Pada suhu " +
                        "dan tekanan standar, hidrogen tidak berwarna, tidak berbau, bersifat non-logam, bervalensi " +
                        "tunggal, dan merupakan gas diatomik yang sangat mudah terbakar.","Litium adalah suatu unsur" +
                " kimia dalam tabel periodik yang memiliki lambang Li dan nomor atom 3. Istilah tersebut " +
                "berasal dari bahasa Yunani: λίθος lithos, yang berarti \"batu\". Ini adalah logam alkali " +
                "lunak berwarna putih keperakan. Ini adalah logam alkali lunak berwarna putih keperakan.",
                "Natrium adalah suatu unsur kimia dalam tabel periodik yang memiliki lambang Na dan nomor " +
                        "atom 11. Ini adalah logam lunak, putih keperakan, dan sangat reaktif.","IA","IA","IA","IA","IIA","IIA","IIA","IIA","IIA","IIA","IIIB","IIIB",
                "IVB","IVB","IVB","IVB","VB","VB","VB","VB","VIB","VIB","VIB","VIB","VIIB","VIIB","VIIB","VIIB",
                "VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB",
                "IB","IB","IB","IB","IIB","IIB","IIB","IIB","IIIA","IIIA","IIIA","IIIA","IIIA","IIIA","IVA","IVA",
                "IVA","IVA","IVA","IVA","VA","VA","VA","VA","VA","VA","VIA","VIA","VIA","VIA","VIA","VIA","VIIA",
                "VIIA","VIIA","VIIA","VIIA","VIIA", "VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","IIIB",
                "IIIB","IIIB","IIIB","IIIB","IIIB", "IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB",
                "IIIB","IIIB","IIIB","IIIB","IIIB", "IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB",
                "IIIB"};

        final String[] nomassa = {"1.008","IA","IA","IA","IA","IA","IA","IIA","IIA","IIA","IIA","IIA","IIA","IIIB","IIIB",
                "IVB","IVB","IVB","IVB","VB","VB","VB","VB","VIB","VIB","VIB","VIB","VIIB","VIIB","VIIB","VIIB",
                "VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB",
                "IB","IB","IB","IB","IIB","IIB","IIB","IIB","IIIA","IIIA","IIIA","IIIA","IIIA","IIIA","IVA","IVA",
                "IVA","IVA","IVA","IVA","VA","VA","VA","VA","VA","VA","VIA","VIA","VIA","VIA","VIA","VIA","VIIA",
                "VIIA","VIIA","VIIA","VIIA","VIIA", "VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","IIIB",
                "IIIB","IIIB","IIIB","IIIB","IIIB", "IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB",
                "IIIB","IIIB","IIIB","IIIB","IIIB", "IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB",
                "IIIB"};

        String[] elektronsel = {"1","IA","IA","IA","IA","IA","IA","IIA","IIA","IIA","IIA","IIA","IIA","IIIB","IIIB",
                "IVB","IVB","IVB","IVB","VB","VB","VB","VB","VIB","VIB","VIB","VIB","VIIB","VIIB","VIIB","VIIB",
                "VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB",
                "IB","IB","IB","IB","IIB","IIB","IIB","IIB","IIIA","IIIA","IIIA","IIIA","IIIA","IIIA","IVA","IVA",
                "IVA","IVA","IVA","IVA","VA","VA","VA","VA","VA","VA","VIA","VIA","VIA","VIA","VIA","VIA","VIIA",
                "VIIA","VIIA","VIIA","VIIA","VIIA", "VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","IIIB",
                "IIIB","IIIB","IIIB","IIIB","IIIB", "IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB",
                "IIIB","IIIB","IIIB","IIIB","IIIB", "IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB",
                "IIIB"};

        String[] konfelektron = {String.valueOf((Html.fromHtml("1s<sup><small>1</small></sup>"))),"IA","IA","IA","IA","IA","IA","IIA","IIA","IIA","IIA","IIA","IIA","IIIB","IIIB",
                "IVB","IVB","IVB","IVB","VB","VB","VB","VB","VIB","VIB","VIB","VIB","VIIB","VIIB","VIIB","VIIB",
                "VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB",
                "IB","IB","IB","IB","IIB","IIB","IIB","IIB","IIIA","IIIA","IIIA","IIIA","IIIA","IIIA","IVA","IVA",
                "IVA","IVA","IVA","IVA","VA","VA","VA","VA","VA","VA","VIA","VIA","VIA","VIA","VIA","VIA","VIIA",
                "VIIA","VIIA","VIIA","VIIA","VIIA", "VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","IIIB",
                "IIIB","IIIB","IIIB","IIIB","IIIB", "IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB",
                "IIIB","IIIB","IIIB","IIIB","IIIB", "IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB",
                "IIIB"};

        String[] url = {"https://id.wikipedia.org/wiki/Hidrogen","https://www.youtube.com","IA","IA","IA","IA","IA","IIA","IIA","IIA","IIA","IIA","IIA","IIIB","IIIB",
                "IVB","IVB","IVB","IVB","VB","VB","VB","VB","VIB","VIB","VIB","VIB","VIIB","VIIB","VIIB","VIIB",
                "VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB",
                "IB","IB","IB","IB","IIB","IIB","IIB","IIB","IIIA","IIIA","IIIA","IIIA","IIIA","IIIA","IVA","IVA",
                "IVA","IVA","IVA","IVA","VA","VA","VA","VA","VA","VA","VIA","VIA","VIA","VIA","VIA","VIA","VIIA",
                "VIIA","VIIA","VIIA","VIIA","VIIA", "VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","IIIB",
                "IIIB","IIIB","IIIB","IIIB","IIIB", "IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB",
                "IIIB","IIIB","IIIB","IIIB","IIIB", "IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB",
                "IIIB"};

        String[] gol = {"IA","IA","IA","IA","IA","IA","IA","IIA","IIA","IIA","IIA","IIA","IIA","IIIB","IIIB",
                "IVB","IVB","IVB","IVB","VB","VB","VB","VB","VIB","VIB","VIB","VIB","VIIB","VIIB","VIIB","VIIB",
                "VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB","VIIIB",
                "IB","IB","IB","IB","IIB","IIB","IIB","IIB","IIIA","IIIA","IIIA","IIIA","IIIA","IIIA","IVA","IVA",
                "IVA","IVA","IVA","IVA","VA","VA","VA","VA","VA","VA","VIA","VIA","VIA","VIA","VIA","VIA","VIIA",
                "VIIA","VIIA","VIIA","VIIA","VIIA", "VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","VIIIA","IIIB",
                "IIIB","IIIB","IIIB","IIIB","IIIB", "IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB",
                "IIIB","IIIB","IIIB","IIIB","IIIB", "IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB","IIIB",
                "IIIB"};
        final String[] names = {"Hidrogen", "Lithium", "Natrium", "Kalium", "Rubidium","Sesium", "Fransium", "Berillium",
                "Magnesium", "Kalsium", "Strontium", "Barium", "Radium", "Skandium", "Itrium", "Titanium", "Zirkonium",
                "Hafnium", "Rutherfordium", "Vanadium", "Niobium", "Tantalum", "Dubnium", "Krom", "Molibden", "Wolfram",
                "Seaborgium", "Mangan", "Teknetium", "Renium", "Bohrium", "Ferrum", "Rutenium", "Osmium","Hassium",
                "Kobalt", "Rodium", "Iridium", "Meitnerium", "Nikel", "Paladium", "Platina", "Darmstadtium", "Cuprum",
                "Argentum", "Aurum", "Roentgenium", "Zinc", "Kadmium", "Hydrargyrum", "Kopernisium", "Boron", "Aluminium",
                "Galium", "Indium", "Talium", "Nihonium", "Karbon", "Silikon", "Germanium", "Stannum", "Plumbum",
                "Flerovium", "Nitrogen", "Fosfor", "Arsenik", "Stibium", "Bismut", "Moscovium", "Oksigen", "Sulfur",
                "Selenium", "Telurium", "Polonium", "Livermorium", "Fluor", "Klor", "Brom", "Yodium", "Astatin",
                "Tennessine", "Helium", "Neon", "Argon", "Kripton", "Xenon", "Radon", "Oganesson", "Lantanum", "Serium",
                "Praseodimium", "Neodimium", "Prometium", "Samarium", "Europium", "Gadolinium", "Terbium", "Disprosium",
                "Holmium", "Erbium", "Tulium", "Iterbeium", "Lutetium", "Aktinium", "Torium", "Protaktinium", "Uranium",
                "Neptunium", "Plutonium", "Amerisium", "Kurium", "Berkelium", "Kalifornium", "Einsteinium", "Fermium",
                "Mendelevium", "Nobelium", "Lawrensium"};
        final int[] images = {R.drawable.hidrogen6, R.drawable.lithium6, R.drawable.sodium, R.drawable.kalium,
                R.drawable.rubidium, R.drawable.cesium, R.drawable.francium, R.drawable.berrylium, R.drawable.magnesium,
                R.drawable.calcium, R.drawable.strontium, R.drawable.barium, R.drawable.radium, R.drawable.scandium,
                R.drawable.yttrium, R.drawable.titanium, R.drawable.zirconium, R.drawable.hafnium, R.drawable.rutherfordium,
                R.drawable.vanadium, R.drawable.niobium, R.drawable.tantalum, R.drawable.dubnium, R.drawable.chromium,
                R.drawable.molybdenum, R.drawable.tungsten, R.drawable.seaborgium, R.drawable.manganese, R.drawable.technetium,
                R.drawable.rhenium, R.drawable.bohrium, R.drawable.iron, R.drawable.ruthenium, R.drawable.osmium,
                R.drawable.hassium, R.drawable.cobalt, R.drawable.rhodium, R.drawable.iridium, R.drawable.meitnerium,
                R.drawable.nickel, R.drawable.palladium, R.drawable.platinum, R.drawable.darmstadtium, R.drawable.copper,
                R.drawable.silver, R.drawable.gold, R.drawable.roentgenium, R.drawable.zinc, R.drawable.cadmium,
                R.drawable.mercury, R.drawable.copernicium, R.drawable.boron, R.drawable.aluminum, R.drawable.gallium,
                R.drawable.indium, R.drawable.thallium, R.drawable.nihonium, R.drawable.carbon, R.drawable.silicon,
                R.drawable.germanium, R.drawable.tin, R.drawable.lead, R.drawable.flerovium, R.drawable.nitrogen,
                R.drawable.phosphorus, R.drawable.arsenic, R.drawable.antimony, R.drawable.bismuth, R.drawable.moscovium,
                R.drawable.oxygen, R.drawable.sulfur, R.drawable.selenium, R.drawable.tellurium, R.drawable.polonium,
                R.drawable.livermorium, R.drawable.fluorine, R.drawable.chlorine, R.drawable.bromine, R.drawable.iodine,
                R.drawable.astatine, R.drawable.tennessine, R.drawable.helium, R.drawable.neon, R.drawable.argon,
                R.drawable.krypton, R.drawable.xenon, R.drawable.radon, R.drawable.oganesson, R.drawable.lanthanum,
                R.drawable.cerium, R.drawable.praseodymium, R.drawable.neodymium, R.drawable.promethium, R.drawable.samarium,
                R.drawable.europium, R.drawable.gadolinium, R.drawable.terbium, R.drawable.dysprosium, R.drawable.holmium,
                R.drawable.erbium, R.drawable.thulium, R.drawable.ytterbium, R.drawable.lutetium, R.drawable.actinium,
                R.drawable.thorium, R.drawable.protactinium, R.drawable.uranium, R.drawable.neptunium, R.drawable.plutonium,
                R.drawable.americium, R.drawable.curium, R.drawable.berkelium, R.drawable.californium, R.drawable.einsteinium,
                R.drawable.fermium, R.drawable.mendelevium, R.drawable.nobelium, R.drawable.lawrencium};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        for (int i=0; i<gol.length;i++){

            ClassNames cn = new ClassNames(gol[i], names[i], images[i], definisi[i], nomassa[i],
                    url[i], elektronsel[i], konfelektron[i]);
            // Binds all strings into an array
            arraylist.add(cn);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.searchFilter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.test.ImportBlend");
                startActivity(intent);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void TampilkanPenjelasanNoMassaHorizontal(View view){
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


    public void TampilkanPenjelasanNoMassa(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.nomor_massa_layout, (ViewGroup) findViewById(R.id.custom_toast_layout));
        TextView textView = (TextView) layout.findViewById(R.id.txtvw);
        textView.setText("Nomor massa adalah jumlah total proton dan neutron dalam inti atom");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void TampilkanPenjelasanKulElektron(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.kulit_elektron_layout, (ViewGroup) findViewById(R.id.custom_toast_layout));
        TextView textView = (TextView) layout.findViewById(R.id.txtvw);
        textView.setText("Kulit elektron adalah orbit yang diikuti elektron di sekitar inti atom");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void TampilkanPenjelasanKonfElektron(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.konfigurasi_elektron_layout, (ViewGroup) findViewById(R.id.custom_toast_layout));
        TextView textView = (TextView) layout.findViewById(R.id.txtvw);
        textView.setText("Konfigurasi elektron adalah susunan elektron-elektron pada sebuah atom, molekul, " +
                "atau struktur fisik lainnya");
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    /*@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void TampilkanPenjelasanNoMassa (View view){

        for (int i=0; i < 2; i++)
        {
            final Toast toast = Toast.makeText(getBaseContext(), "Nomor massa adalah jumlah total " +
                    "proton dan neutron dalam inti atom", Toast.LENGTH_LONG);
            View toastview = toast.getView();
            toastview.setRotation(90);
            toastview.setElevation(200);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        }

    }*/

    public void tampilkanEI (View view){
        JustifiedTextView justifiedTextView;
        TextView txtclose,text_penjelasan_ei;
        myDialog.setContentView(R.layout.popup_energi_ionisasi);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseEI);
        txtclose.setText("X");
        text_penjelasan_ei = (TextView) myDialog.findViewById(R.id.text_penjelasan_ei);
        text_penjelasan_ei.setMovementMethod(new ScrollingMovementMethod());
        text_penjelasan_ei.setText(Html.fromHtml("Energi ionisasi pertama adalah energi yang " +
                "diserap untuk melepas satu elektron dari sebuah atom. Energi ionisasi kedua adalah " +
                "energi yang diserap untuk melepas elektron kedua dari sebuah atom, dan seterusnya. " +
                "Untuk sebuah atom, energi ionisasi yang berurutan meningkat sesuai dengan kenaikan " +
                "derajat ionisasi. Magnesium, misalnya, memiliki energi ionisasi pertama 738 kJ/mol " +
                "dan yang kedua sebesar 1.450 kj/mol. Elektron pad orbital yang lebih dekat mengalami " +
                "gaya tarik elektrostatik yang lebih besar, sehingga untuk melepaskannya diperlukan " +
                "energi yang lebih banyak. Energi ionisasi meningkat dari bawah ke atas (dalam satu " +
                "golongan) dan dari kiri ke kanan (dalam satu periode) tabel periodik."));
        justifiedTextView = (JustifiedTextView) view.findViewById(R.id.text_penjelasan_ei);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void tampilkanAE (View view){
        JustifiedTextView justifiedTextView;
        TextView txtclose,text_penjelasan_ae;
        myDialog.setContentView(R.layout.popup_afinitas_elektron);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseAE);
        txtclose.setText("X");
        text_penjelasan_ae = (TextView) myDialog.findViewById(R.id.text_penjelasan_ae);
        text_penjelasan_ae.setMovementMethod(new ScrollingMovementMethod());
        text_penjelasan_ae.setText(Html.fromHtml("Afinitas elektron suatu atom adalah jumlah " +
                "energi yang dilepaskan ketika sebuah elektron ditambahkan ke dalam atom netral untuk " +
                "membentuk ion negatif. Meskipun afinitas elektron sangat bervariasi, tetapi ada pola " +
                "yang dapat ditarik. Secara umum, nonlogam memiliki nilai afinitas elektron yang lebih " +
                "positif daripada logam. Klorin adalah yang paling kuat dalam menarik elektron. Afinitas " +
                "elektron gas mulia belum sepenuhnya terukur, oleh karenanya mungkin memiliki nilai yang " +
                "sedikit negatif"));
        justifiedTextView = (JustifiedTextView) view.findViewById(R.id.text_penjelasan_ae);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

    public void tampilkanKL (View view){
        JustifiedTextView justifiedTextView;
        TextView txtclose,text_penjelasan_kl;
        myDialog.setContentView(R.layout.popup_karakter_logam);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseKL);
        txtclose.setText("X");
        text_penjelasan_kl = (TextView) myDialog.findViewById(R.id.text_penjelasan_kl);
        text_penjelasan_kl.setMovementMethod(new ScrollingMovementMethod());
        text_penjelasan_kl.setText(Html.fromHtml("Semakin kecil energi ionisasi, elektronegativitas, " +
                "dan afinitas elektron, semakin kuat karakter logam yang dimiliki suatu unsur. Sebaliknya, " +
                "karakter nonlogam meningkat sebanding dengan peningkatan sifat-sifat di atas. Sesuai " +
                "dengan tren periodik ketiga sifat ini, karakter logam cenderung menurun untuk unsur-unsur " +
                "dalam periode (atau baris) yang sama dan, dengan beberapa penyimpangan (sebagian besar) " +
                "akibat adanya efek relativistik, cenderung meningkat dari atas ke bawah untuk unsur-unsur " +
                "dalam golongan (atau kolom) yang sama." +
                "\n\nSebagian besar unsur logam (seperti sesium dan fransium) berada pada bagian kiri bawah " +
                "tabel periodik tradisional dan sebagian besar unsur nonlogam (oksigen, fluor, klorin) di " +
                "bagian kanan atas. Kombinasi tren horizontal dan vertikal pada karakter logam menjelaskan " +
                "garis pembatas seperti anak tangga untuk memisahkan antara logam dan non logam yang dapat " +
                "dijumpai pada beberapa tabel periodik. Beberapa praktisi mengelompokkan unsur-unsur yang " +
                "ada di sekitar garis batas tersebut sebagai metaloid."));
        justifiedTextView = (JustifiedTextView) view.findViewById(R.id.text_penjelasan_kl);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

    public void tampilkanJA (View view){
        JustifiedTextView justifiedTextView;
        TextView txtclose,text_penjelasan_ja;
        myDialog.setContentView(R.layout.popup_jarijari_atom);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseJA);
        txtclose.setText("X");
        text_penjelasan_ja = (TextView) myDialog.findViewById(R.id.text_penjelasan_ja);
        text_penjelasan_ja.setMovementMethod(new ScrollingMovementMethod());
        text_penjelasan_ja.setText(Html.fromHtml("Jari-jari atom dalam tabel periodik bervariasi " +
                "dalam cara yang dapat diperkirakan dan dijelaskan. Misalnya, jari-jari atom menurun " +
                "untuk unsur-unsur yang terdapat dalam satu periode, dari logam alkali hingga gas mulia; " +
                "dan jari-jari atom naik untuk unsur-unsur dalam satu golongan dari atas ke bawah. Jari-jari " +
                "atom naik tajam antara gas mulia di akhir periode dan logam alkali di awal periode berikutnya. " +
                "Kecenderungan jari-jari atom ini (dan berbagai sifat fisika dan kimia unsur-unsur lainnya) " +
                "dapat dijelaskan menggunakan teori kulit elektron atom. Teori tersebut menyajikan bukti-bukti " +
                "penting untuk pengembangan dan penegasan teori kuantum."));
        justifiedTextView = (JustifiedTextView) view.findViewById(R.id.text_penjelasan_ja);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }

    public void ShowPopupHidrogen (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_hidrogen);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseH);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronH);
        txtkonf.setText(Html.fromHtml("1s<sup><small>1" +
                "</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaH);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Hidrogen");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.setCancelable(false);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

    }
    public void ShowPopupLithium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_litium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseLi);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronLi);
        txtkonf.setText(Html.fromHtml("1s<sup><small>2</small></sup> 2s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaLi);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Litium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void ShowPopupNatrium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_natrium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseNa);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronNa);
        txtkonf.setText(Html.fromHtml("[Ne] 3s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaNa);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Natrium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupKalium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_kalium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseK);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronK);
        txtkonf.setText(Html.fromHtml("[Ar] 4s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaK);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Kalium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupRubidium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_rubidium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseRb);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronRb);
        txtkonf.setText(Html.fromHtml("[Kr] 5s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaRb);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Rubidium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupSesium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_sesium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseCs);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronCs);
        txtkonf.setText(Html.fromHtml("[Xe] 6s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaCs);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Rubidium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupFransium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_fransium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseFr);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronFr);
        txtkonf.setText(Html.fromHtml("[Rn] 7s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaFr);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Fransium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupBerilium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_berilium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseBe);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronBe);
        txtkonf.setText(Html.fromHtml("1s<sup><small>2</small></sup> 2s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaBe);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Berilium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupMagnesium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_magnesium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseMg);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronMg);
        txtkonf.setText(Html.fromHtml("[Ne] 3s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaMg);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Magnesium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupKalsium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_kalsium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseCa);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronCa);
        txtkonf.setText(Html.fromHtml("[Ar] 4s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaCa);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Kalsium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupStrontium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_stronsium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseSr);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronSr);
        txtkonf.setText(Html.fromHtml("[Kr] 5s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaSr);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Stronsium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupBarium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_barium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseBa);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronBa);
        txtkonf.setText(Html.fromHtml("[Xe] 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaBa);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Barium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupRadium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_radium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseRa);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronRa);
        txtkonf.setText(Html.fromHtml("[Rn] 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaRa);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Radium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupSkandium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_scandium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseSc);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronSc);
        txtkonf.setText(Html.fromHtml("[Ar] 7s<sup><small>2</small></sup> 3d<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaSc);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Skandium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupItrium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_ytrium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseY);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronY);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>1</small></sup> 5s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaY);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Itrium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupTitanium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_titanium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseTi);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronTi);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>2</small></sup> 4s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaTi);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Titanium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupZirkonium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_zirconium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseZr);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronZr);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>2</small></sup> 5s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaZr);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Zirkonium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupHafnium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_hafnium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseHf);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronHf);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>2</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaHf);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Hafnium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupRutherfordium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_rutherfordium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseRf);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronRf);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 6d<sup><small>2</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaRf);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Ruterfordium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupVanadium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_vanadium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseV);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronV);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>3</small></sup> 4s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaV);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Vanadium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupNiobium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_niobium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseNb);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronNb);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>4</small></sup> 5s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaNb);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Niobium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupTantalum (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_tantalum);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseTa);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronTa);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>3</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaTa);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Tantalum");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupDubnium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_dubnium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseDb);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronDb);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 6d<sup><small>3</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaDb);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Dubnium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupKromium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_chromium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseCr);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronCr);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>5</small></sup> 4s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaCr);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Kromium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupMolibdenum (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_molybdenum);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseMo);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronMo);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>5</small></sup> 5s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaMo);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Molibdenum");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupWolfram (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_tungsten);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseW);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronW);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>4</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaW);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Wolfram");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupSeaborgium (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_seaborgium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseSg);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronSg);
        txtkonf.setText(Html.fromHtml("[Rn] 7s<sup><small>2</small></sup> 5f<sup><small>14</small></sup> 6d<sup><small>4</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaSg);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Seaborgium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupMangan (View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_mangan);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseMn);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronMn);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>5</small></sup> 4s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaMn);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Mangan");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupTeknesium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_technetium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseTc);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronTc);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>5</small></sup> 5s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaTc);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Teknesium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupRenium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_rhenium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseRe);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronRe);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>5</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaRe);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Renium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupBohrium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_bohrium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseBh);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronBh);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 6d<sup><small>5</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaBh);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Bohrium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupBesi(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_iron);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseFe);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronFe);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>6</small></sup> 4s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaFe);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Besi");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupRuthenium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_ruthenium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseRu);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronRu);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>7</small></sup> 5s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaRu);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Rutenium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupOsmium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_osmium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseOs);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronOs);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>6</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaOs);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Osmium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupHassium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_hassium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseHs);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronHs);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 6d<sup><small>6</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaHs);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Hasium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupKobalt(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_cobalt);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseCo);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronCo);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>7</small></sup> 4s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaCo);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Kobalt");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupRodium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_rhodium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseRh);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronRh);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>8</small></sup> 5s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaRh);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Rodium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupIridium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_iridium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseIr);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronIr);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>7</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaIr);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Iridium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupMeitnerium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_meitnerium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseMt);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronMt);
        txtkonf.setText(Html.fromHtml("[Rn] 7s<sup><small>2</small></sup> 5f<sup><small>14</small></sup> 6d<sup><small>7</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaMt);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Meitnerium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupNikel(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_nickel);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseNi);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronNi);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>8</small></sup> 4s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaNi);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Nikel");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupPaladium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_palladium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclosePd);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronPd);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>10</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaPd);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Paladium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupPlatina(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_platinum);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclosePt);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronPt);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>9</small></sup> 6s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaPt);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Platina");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupDarmstadtium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_darmstadtium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseDs);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronDs);
        txtkonf.setText(Html.fromHtml("[Rn] 7s<sup><small>2</small></sup> 5f<sup><small>14</small></sup> 6d<sup><small>8</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaDs);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Darmstadtium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupTembaga(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_copper);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseCu);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronCu);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>10</small></sup> 4s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaCu);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Tembaga");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupPerak(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_silver);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseAg);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronAg);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>10</small></sup> 5s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaAg);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Perak");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupEmas(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_gold);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseAu);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronAu);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>10</small></sup> 6s<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaAu);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Emas");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupRoentgenium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_roentgenium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseRg);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronRg);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 6d<sup><small>9</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaRg);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Roentgenium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupSeng(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_zinc);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseZn);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronZn);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>10</small></sup> 4s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaRg);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Seng");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupKadmium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_cadmium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseCd);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronCd);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>10</small></sup> 5s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaCd);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Kadmium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupRaksa(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_mercury);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseHg);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronHg);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>10</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaHg);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Raksa");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupKopernisium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_copernicium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseCn);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronCn);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 6d<sup><small>10</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaCn);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Kopernisium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupBoron(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_boron);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseB);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronB);
        txtkonf.setText(Html.fromHtml("1s<sup><small>2</small></sup> 2s<sup><small>2</small></sup> 2p<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaB);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Boron");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupAluminium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_aluminum);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseAl);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronAl);
        txtkonf.setText(Html.fromHtml("[Ne] 3s<sup><small>2</small></sup> 3p<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaAl);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Aluminium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupGalium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_gallium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseGa);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronGa);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>10</small></sup> 4s<sup><small>2</small></sup> 4p<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaGa);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Galium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupIndium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_indium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseIn);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronIn);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>10</small></sup> 5s<sup><small>2</small></sup> 5p<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaIn);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Indium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupTalium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_thalium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseTl);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronTl);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>10</small></sup> 6s<sup><small>2</small></sup> 6p<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaTl);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Talium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupNihonium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_nihonium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseNh);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronNh);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 6d<sup><small>10</small></sup> 7s<sup><small>2</small></sup> 7p<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaNh);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Nihonium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupKarbon(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_carbon);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseC);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronC);
        txtkonf.setText(Html.fromHtml("1s<sup><small>2</small></sup> 2s<sup><small>2</small></sup> 2p<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaC);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Karbon");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupSilikon(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_silicon);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseSi);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronSi);
        txtkonf.setText(Html.fromHtml("[Ne] 3s<sup><small>2</small></sup> 3p<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaSi);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Silikon");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupGermanium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_germanium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseGe);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronGe);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>10</small></sup> 4s<sup><small>2</small></sup> 4p<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaGe);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Germanium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupTimah(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_tin);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseSn);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronSn);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>10</small></sup> 5s<sup><small>2</small></sup> 5p<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaSn);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Timah");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupTimbal(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_lead);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclosePb);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronPb);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>10</small></sup> 6s<sup><small>2</small></sup> 6p<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaPb);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Timbal");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupFlerovium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_flerovium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseFl);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronFl);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 6d<sup><small>10</small></sup> 7s<sup><small>2</small></sup> 7p<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaFl);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Flerovium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupNitrogen(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_nitrogen);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseN);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronN);
        txtkonf.setText(Html.fromHtml("1s<sup><small>2</small></sup> 2s<sup><small>2</small></sup> 2p<sup><small>3</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaN);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Nitrogen");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupFosfor(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_phosphorus);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseP);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronP);
        txtkonf.setText(Html.fromHtml("[Ne] 3s<sup><small>2</small></sup> 3p<sup><small>3</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaP);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Nitrogen");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupArsen(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_arsenic);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseAs);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronAs);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>10</small></sup> 4s<sup><small>2</small></sup> 4p<sup><small>3</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaAs);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Arsen");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupAntimon(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_antimony);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseSb);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronSb);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>10</small></sup> 5s<sup><small>2</small></sup> 5p<sup><small>3</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaSb);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Antimon");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupBismut(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_bismuth);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseBi);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronBi);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>10</small></sup> 6s<sup><small>2</small></sup> 6p<sup><small>3</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaBi);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Bismut");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupMoskovium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_moscovium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseMc);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronMc);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 6d<sup><small>10</small></sup> 7s<sup><small>2</small></sup> 7p<sup><small>3</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaMc);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Moskovium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupOksigen(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_oxygen);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseO);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronO);
        txtkonf.setText(Html.fromHtml("1s<sup><small>2</small></sup> 2s<sup><small>2</small></sup> 2p<sup><small>4</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaO);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Oksigen");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupBelerang(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_sulfur);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseS);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronS);
        txtkonf.setText(Html.fromHtml("[Ne] 3s<sup><small>2</small></sup> 3p<sup><small>4</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaS);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Belerang");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupSelenium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_selenium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseSe);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronSe);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>10</small></sup> 4s<sup><small>2</small></sup> 4p<sup><small>4</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaSe);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Selenium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupTelurium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_tellurium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseTe);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronTe);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>10</small></sup> 5s<sup><small>2</small></sup> 5p<sup><small>4</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaTe);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Telurium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupPolonium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_polonium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclosePo);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronPo);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>10</small></sup> 6s<sup><small>2</small></sup> 6p<sup><small>4</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaPo);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Polonium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupLivermorium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_livermorium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseLv);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronLv);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 6d<sup><small>10</small></sup> 7s<sup><small>2</small></sup> 7p<sup><small>4</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaLv);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Livermorium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupFluor(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_fluorine);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseF);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronF);
        txtkonf.setText(Html.fromHtml("1s<sup><small>2</small></sup> 2s<sup><small>2</small></sup> 2p<sup><small>5</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaF);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Fluor");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupKlorin(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_chlorine);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseCl);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronCl);
        txtkonf.setText(Html.fromHtml("[Ne] 3s<sup><small>2</small></sup> 3p<sup><small>5</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaCl);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Klor");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupBromin(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_bromine);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseBr);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronBr);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>10</small></sup> 4s<sup><small>2</small></sup> 4p<sup><small>5</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaBr);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Bromin");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupIodin(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_iodine);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseI);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronI);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>10</small></sup> 5s<sup><small>2</small></sup> 5p<sup><small>5</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaI);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Iodin");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupAstatin(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_astatine);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseAt);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronAt);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>10</small></sup> 6s<sup><small>2</small></sup> 6p<sup><small>5</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaAt);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Astatin");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupTenesin(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_tennessine);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseTs);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronTs);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 6d<sup><small>10</small></sup> 7s<sup><small>2</small></sup> 7p<sup><small>5</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaTs);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Tenesin");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupHelium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_helium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseHe);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronHe);
        txtkonf.setText(Html.fromHtml("1s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaHe);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Helium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupNeon(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_neon);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseNe);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronNe);
        txtkonf.setText(Html.fromHtml("1s<sup><small>2</small></sup> 2s<sup><small>2</small></sup> 2p<sup><small>6</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaNe);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Neon");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupArgon(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_argon);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseAr);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronAr);
        txtkonf.setText(Html.fromHtml("[Ne] 3s<sup><small>2</small></sup> 3p<sup><small>6</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaAr);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Argon");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupKripton(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_krypton);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseKr);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronKr);
        txtkonf.setText(Html.fromHtml("[Ar] 3d<sup><small>10</small></sup> 4s<sup><small>2</small></sup> 4p<sup><small>6</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaKr);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Kripton");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupXenon(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_xenon);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseXe);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronXe);
        txtkonf.setText(Html.fromHtml("[Kr] 4d<sup><small>10</small></sup> 5s<sup><small>2</small></sup> 5p<sup><small>6</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaXe);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Xenon");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupRadon(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_radon);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseRn);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronRn);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>10</small></sup> 6s<sup><small>2</small></sup> 6p<sup><small>6</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaRn);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Radon");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupOganeson(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_oganesson);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseOg);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronOg);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 6d<sup><small>10</small></sup> 7s<sup><small>2</small></sup> 7p<sup><small>6</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaOg);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Oganeson");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupLantanum(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_lanthanum);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseLa);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronLa);
        txtkonf.setText(Html.fromHtml("[Xe] 5d<sup><small>1</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaLa);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Lantanum");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupAktinium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_actinium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseAc);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronAc);
        txtkonf.setText(Html.fromHtml("[Rn] 6d<sup><small>1</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaAc);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Aktinium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupSerium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_cerium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseCe);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronCe);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>1</small></sup> 5d<sup><small>1</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaCe);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Serium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupTorium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_thorium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseTh);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronTh);
        txtkonf.setText(Html.fromHtml("[Rn] 6d<sup><small>2</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaTh);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Torium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupPraseodimium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_praseodymium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclosePr);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronPr);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>3</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaPr);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Praseodimium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupProtaktinium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_protactinium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclosePa);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronPa);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>2</small></sup> 6d<sup><small>1</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaPa);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Protaktinium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    public void ShowPopupNeodimium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_neodymium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseNd);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronNd);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>4</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaNd);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Neodimium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupUranium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_uranium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseU);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronU);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>3</small></sup> 6d<sup><small>1</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaU);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Uranium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupPrometium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_promethium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclosePm);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronPm);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>5</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaPm);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Prometium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupNeptunium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_neptunium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseNp);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronNp);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>4</small></sup> 6d<sup><small>1</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaNp);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Neptunium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupSamarium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_samarium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseSm);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronSm);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>6</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaSm);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Samarium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupPlutonium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_plutonium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclosePu);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronPu);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>6</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaPu);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Plutonium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupEuropium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_europium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseEu);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronEu);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>7</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaEu);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Europium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupAmericium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_americium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseAm);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronAm);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>7</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaAm);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Amerisium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupGadolinium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_gadolinium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseGd);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronGd);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>7</small></sup> 5d<sup><small>1</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaGd);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Gadolinium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupCurium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_curium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseCm);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronCm);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>7</small></sup> 6d<sup><small>1</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaCm);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Kurium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupTerbium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_terbium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseTb);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronTb);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>9</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaTb);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Terbium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupBerkelium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_berkelium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseBk);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronBk);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>9</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaBk);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Berkelium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupDisprosium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_dysprosium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseDy);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronDy);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>10</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaDy);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Disprosium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupKalifornium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_californium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseCf);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronCf);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>10</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaCf);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Kalifornium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupHolmium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_holmium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseHo);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronHo);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>11</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaHo);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Holmium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupEinsteinium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_einsteinium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseEs);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronEs);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>11</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaEs);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Einsteinium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupErbium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_erbium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseEr);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronEr);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>12</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaEr);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Erbium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupFermium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_fermium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseFm);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronFm);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>12</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaFm);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Fermium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupTulium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_thulium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseTm);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronTm);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>13</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaTm);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Tulium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupMendelevium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_mendelevium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseMd);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronMd);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>13</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaMd);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Mendelevium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupIterbium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_ytterbium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseYb);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronYb);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaYb);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Iterbium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupNobelium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_nobelium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseNo);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronNo);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 7s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaNo);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Nobelium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupLutesium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_lutesium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseLu);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronLu);
        txtkonf.setText(Html.fromHtml("[Xe] 4f<sup><small>14</small></sup> 5d<sup><small>1</small></sup> 6s<sup><small>2</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaLu);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Lutesium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopupLawrensium(View view){
        TextView txtclose,txtkonf;
        Button btnWikipedia;
        myDialog.setContentView(R.layout.popup_lawrencium);
        txtclose = (TextView) myDialog.findViewById(R.id.txtcloseLr);
        txtclose.setText("X");
        txtkonf = (TextView) myDialog.findViewById(R.id.kelektronLr);
        txtkonf.setText(Html.fromHtml("[Rn] 5f<sup><small>14</small></sup> 7s<sup><small>2</small></sup> 7p<sup><small>1</small></sup>"));
        btnWikipedia =(Button) myDialog.findViewById(R.id.btnwikipediaLr);
        btnWikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                Uri uri = Uri.parse("https://id.wikipedia.org/wiki/Lawrensium");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_panduan) {
            Intent intent = new Intent(MainActivity.this, Panduan.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
