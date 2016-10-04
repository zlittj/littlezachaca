package com.zachlittle.android.aca.canvasdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ourFrame = (ImageView) findViewById(R.id.imageView);
        Bitmap ourBitmap = Bitmap.createBitmap(750, 1500, Bitmap.Config.ARGB_8888);
        Canvas ourCanvas = new Canvas(ourBitmap);
        Paint paint = new Paint();
        ourCanvas.drawColor(Color.BLACK);
        paint.setColor(Color.argb(255,255,255,255));

        Random random = new Random();
        for (int i = 0; i<15000; i++){
            int x = random.nextInt(750);
            int y = random.nextInt(1500);
            ourCanvas.drawPoint(x, y, paint);
        }

        ourCanvas.drawLine(0,0,750,1500, paint);
        paint.setColor(Color.argb(255, 0, 255, 0));
        paint.setTextSize(120f);
        ourCanvas.drawText("Hello Canvas", 10, 750, paint);
        ourCanvas.drawCircle(500,500,100,paint);

        paint.setColor(Color.argb(255,0,0,255));

        ourCanvas.drawRect(500, 10, 200, 200, paint);


        ourFrame.setImageBitmap(ourBitmap);


    }
}
