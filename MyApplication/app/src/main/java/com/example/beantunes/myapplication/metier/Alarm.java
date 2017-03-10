package com.example.beantunes.myapplication.metier;

import java.util.Date;

/**
 * Created by beantunes on 01/03/17.
 */
public class Alarm  {

    private Date date;

    private String nom;

    private int nbRep;

    public Alarm (Date date, String nom, int nbrep){

        this.date = date;
        this.nom = nom;
        this.nbRep = nbrep;
    }

    public Date getDate (){
        return date;
    }

    public String getNom(){
        return nom;
    }

    public int getNbRep(){
        return nbRep;
    }
}
