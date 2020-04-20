package com.example.androidshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class AnalisLayot extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference take = databaseReference.child("Icons");

    ImageView img;

    GraphView graph,costs,quater;
    LineGraphSeries<DataPoint> series;
    BarGraphSeries<DataPoint> series1;

    private Bitmap bmp;
    private Canvas canvas;
    private Paint paint;

    private int bg = Color.rgb(255,  255, 255);
    private int activeColor = Color.rgb(255, 0, 0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analis_layot);

        img = (ImageView)findViewById(R.id.back);

        imgClick();
        loadImg( "https://firebasestorage.googleapis.com/v0/b/androidshopvlad.appspot.com/o/add%20card%2Fnext%201.png?alt=media&token=aa148684-f093-4241-a5ba-ca67249a653b",img);

        //create liner graphic
        graph = findViewById(R.id.graph);
        costs = findViewById(R.id.costs);
        quater = findViewById(R.id.quater);


        series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        series1 = new BarGraphSeries<>(new DataPoint[] {
                new DataPoint(0, -2),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);
        costs.addSeries(series);
        quater.addSeries(series1);




    }



    public void loadImg(String url, ImageView img){
        Glide.with(getApplicationContext()).load(url).into(img);
    }

    public void imgClick(){
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnalisLayot.this,DrawerLayoutActivity.class);
                startActivity(intent);
            }
        });
    }
}