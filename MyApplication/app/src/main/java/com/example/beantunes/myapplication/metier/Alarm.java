package com.example.beantunes.myapplication.metier;

import java.util.Date;

/**
 * Created by beantunes on 01/03/17.
 */
public class Alarm {

    private Date dateStart;

    private Date dateEnd;

    private String nom;

    private int nbRep;

    public Alarm (Date dateStart, Date dateEnd, String nom, int nbrep){

        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.nom = nom;
        this.nbRep = nbrep;
    }

    public Date getDateStart (){
        return dateStart;
    }

    public Date getDateEnd () { return dateEnd; }

    public String getNom(){
        return nom;
    }

    public int getNbRep(){
        return nbRep;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                //"dateStart=" + dateStart +
                //", dateEnd=" + dateEnd +
                ", nom='" + nom + '\'' +
                ", nbRep=" + nbRep +
                '}';
    }
}
