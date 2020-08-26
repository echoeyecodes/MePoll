package com.yata.echonotes.utils;

import android.content.res.Resources;
import android.util.TypedValue;

public class IntToDpConverter {

    public static int intToDp(int value){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, Float.parseFloat(String.valueOf(value)), Resources.getSystem().getDisplayMetrics());
    }
}
