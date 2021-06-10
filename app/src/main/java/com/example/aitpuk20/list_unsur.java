package com.example.aitpuk20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class list_unsur extends AppCompatActivity {
    //deklrasi
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String gol;
    String names;
    String definisi, nomassa, elektronsel, konfelektron;
    int images;

    ArrayList<ClassNames> arraylist = new ArrayList<ClassNames>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_unsur);
        //String.valueOf((Html.fromHtml("1s<sup><small>1</small></sup>")))


        //memasukkan data ke list unsur
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


    }

}
