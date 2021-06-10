package com.example.aitpuk20;

public class ClassNames {
    private String gol;
    private String names;
    private String definisi;
    private String nomassa;
    private String url;
    private String elektronsel;
    private String konfelektron;
    private int images;

    public ClassNames(String gol, String names, int images, String s1, String s, String s2, String s3, String s4){
        this.gol=gol;
        this.names=names;
        this.images=images;
        this.definisi=s1;
        this.nomassa=s;
        this.url=s2;
        this.elektronsel=s3;
        this.konfelektron=s4;
    }

    public String getGol(){
        return this.gol;
    }

    public String getNames(){
        return this.names;
    }

    public int getImages(){
        return this.images;
    }

    public String  getDefinisi() {return this.definisi;}

    public String getNomassa() {return this.nomassa;}

    public String getUrl() {return this.url;}

    public String getElektronsel() {return this.elektronsel;}

    public String getKonfelektron() {return this.konfelektron;}
}
