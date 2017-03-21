package com.example.beantunes.myapplication.metier;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by beantunes on 01/03/17.
 */
public class ListAlarm {



    private int nbTotalHeures;

    private List<Alarm> l = new ArrayList<>();

    public ListAlarm (){
        l.add(new Alarm(new Date(2017,03,21,8,00),new Date(2017,03,21,9,30),"Repos principal",5));
        l.add(new Alarm(new Date(2017,03,21,14,00),new Date(2017,03,21,14,30),"Sieste",5));
        l.add(new Alarm(new Date(2017,03,21,20,00),new Date(2017,03,21,20,30),"Sieste",5));
        l.add(new Alarm(new Date(2017,03,21,2,00),new Date(2017,03,21,2,30),"Sieste",5));
    }

    private int nbTotalNaps;

    public List<Alarm> getList(){

        nbTotalNaps =  l.size();
        return l;
    }

    public int getNbTotalHeures() {
        return nbTotalHeures;
    }

    public int getNbTotalNaps() {
        return nbTotalNaps;
    }


}
