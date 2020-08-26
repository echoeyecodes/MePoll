package com.yata.echonotes.Factory;

import com.yata.echonotes.Factory.AdapterFactory.NoteAdapterFactory;

public class AdapterFactoryGenerator {

    public static AdapterAbstractFactory getAdapterFactory(NoteAdapterTypes types){
        switch (types){
            case NOTE:
                return new NoteAdapterFactory();

            default:
                return null;
        }
    }
}
