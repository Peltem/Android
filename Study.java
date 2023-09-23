package com.nlp.tic_tac_poe;

public class Study {
    private String name; // название
    private int chas;


    public Study(String name, int chas){

        this.name=name;
        this.chas=chas;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChas() {
        return this.chas;
    }

    public void setChas(int chas) {
        this.chas = chas;
    }
}


