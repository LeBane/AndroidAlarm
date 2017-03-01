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



    List<Alarm> l = new ArrayList<>();

    public ListAlarm (){
        l.add(new Alarm(new Date(2017,03,01,14,10),"alarmo",5));
        l.add(new Alarm(new Date(2017,03,01,14,10),"alarmi",5));
        l.add(new Alarm(new Date(2017,03,01,14,10),"alarma",5));
        l.add(new Alarm(new Date(2017,03,01,14,10),"alarmu",5));
        l.add(new Alarm(new Date(2017,03,01,14,10),"alarmy",5));
    }

    public List<Alarm> getList(){
        return l;
    }

}
