package com.example.ex32_alertdialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder adb;
    LinearLayout linLayout;
    Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linLayout = findViewById(R.id.linlayout);
    }

    public void messageOnly(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Message Only");
        adb.setMessage("This is a simple message dialog.");
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void messagewithIcon(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Message with Icon");
        adb.setMessage("This is a message dialog with an icon.");
        adb.setIcon(R.drawable.icon1);
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void messageWithBtn(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Message with Button");
        adb.setMessage("This is a message dialog with one button.");
        adb.setIcon(R.drawable.icon1);
        adb.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void messageTwoBtn(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Two Buttons");
        adb.setMessage("Choose an option:");
        adb.setIcon(R.drawable.icon1);
        adb.setPositiveButton("Change Background", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                linLayout.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    public void messageThreeBtn(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Three Buttons");
        adb.setMessage("Choose an option:");
        adb.setIcon(R.drawable.icon1);
        adb.setPositiveButton("Random Background", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                linLayout.setBackgroundColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            }
        });
        adb.setNeutralButton("Reset Background", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                linLayout.setBackgroundColor(Color.WHITE);
            }
        });
        adb.setNeutralButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                linLayout.setBackgroundColor(Color.WHITE);
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog ad=adb.create();
        ad.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@Nullable MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menuCredits) {
            Intent si = new Intent(this, Activity2credits.class);
            startActivity(si);
        }
        return true;
    }
}

