package com.zachlittle.android.aca.variables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class VariableTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable_test);

        byte byteVar;
        short shortVar;
        int intVar;
        long longVar;
        float floatVar;
        double doubleVar;
        char charVar;
        boolean booleanVar;



        byteVar = 1;
        shortVar = 20;
        intVar = 300;
        longVar = 4000;
        floatVar = (float) 1.1;
        doubleVar = 2.22;
        charVar = 'v';
        booleanVar = true;

        System.out.println("Byte: " + byteVar);
        System.out.println("Short: " + shortVar);
        System.out.println("Int: " + intVar);
        System.out.println("Long: " + longVar);
        System.out.println("Float: " + floatVar);
        System.out.println("Double: " + doubleVar);
        System.out.println("Char: " + charVar);
        System.out.println("Boolean: " + booleanVar);





    }
}
