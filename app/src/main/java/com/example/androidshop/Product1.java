package com.example.androidshop;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Product1 extends AppCompatActivity {
    ImageView img, img1;
    TextView text1, text2;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference first = databaseReference.child("AdminLayouts");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product1);

        img1=(ImageView)findViewById(R.id.imageView016);
        text1=(TextView)findViewById(R.id.textView0016);
        img=(ImageView)findViewById(R.id.imageView21);
        text2=(TextView)findViewById(R.id.textView65);

        String url = "https://firebasestorage.googleapis.com/v0/b/androidshop-6672b.appspot.com/o/admin_img%2Fproduct1.png?alt=media&token=e713db8e-e3d8-4ec9-9d1e-c9ec0bc9d5e6";
        String url1 = "https://firebasestorage.googleapis.com/v0/b/androidshop-6672b.appspot.com/o/admin_img%2FVector.png?alt=media&token=5a33a36d-1ab2-4861-9760-e943b322b412";

        Glide.with(getApplicationContext()).load(url).into(img);
        Glide.with(getApplicationContext()).load(url1).into(img1);

        imageClick1();
        imageClick2();
    }

    public void imageClick1 () {
        img1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Product1.this, Products.class);
                        startActivity(intent);
                    }
                }
        );
    }

    public void imageClick2 () {
        text1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Product1.this, Products.class);
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        first.addValueEventListener (new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for ( DataSnapshot Subsnapshot : dataSnapshot.getChildren()) {
                    AdminLayouts adminLayouts = Subsnapshot.getValue(AdminLayouts.class);
                    String ShowData1 = adminLayouts.getProduct1Name();
                    text2.setText(ShowData1);


                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                /*Intent intent3 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent3);*/
            }
        });

    }

}
