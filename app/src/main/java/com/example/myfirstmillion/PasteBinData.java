package com.example.myfirstmillion;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Brainacad4 on 26.03.2019.
 */

public class PasteBinData {
    List<Integer> array;
    @SerializedName("boolean") boolean booleanData;
    String color;
    @SerializedName("null") String nullable;
    int number;
    String string;
    InnerClass object;

    public class InnerClass {
        String a;
        String c;
        String e;
    }
}
