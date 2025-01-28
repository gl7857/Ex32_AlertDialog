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

/**
 * MainActivity is the main screen of the app.
 * It provides five different buttons that each trigger an AlertDialog with different options.
 *
 * @author Gali Lavi </gl7857@bs.amalnet.k12.il>
 * @version 1.0
 * @since 27/01/2025
 * * short description:
 *          This activity contains 5 buttons, each triggering a different type of AlertDialog.
 *          The dialogs demonstrate various features such as displaying a simple message,
 *          showing an icon, handling one or more buttons, and changing the background color.
 *
 *
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The AlertDialog builder used to create different dialogs.
     */
    AlertDialog.Builder adb;

    /**
     * The LinearLayout where the background color changes.
     */
    LinearLayout linLayout;

    /**
     * The random number generator for generating random colors.
     */
    Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linLayout = findViewById(R.id.linlayout);
    }

    /**
     * Displays a simple message dialog.
     *
     * @param view The view that triggered the dialog.
     */
    public void messageOnly(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Message Only");
        adb.setMessage("This is a simple message dialog.");
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Displays a message dialog with an icon.
     *
     * @param view The view that triggered the dialog.
     */
    public void messagewithIcon(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Message with Icon");
        adb.setMessage("This is a message dialog with an icon.");
        adb.setIcon(R.drawable.icon1);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Displays a message dialog with one button to close the dialog.
     *
     * @param view The view that triggered the dialog.
     */
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

    /**
     * Displays a message dialog with two buttons: one to change the background color,
     * and another to cancel.
     *
     * @param view The view that triggered the dialog.
     */
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

    /**
     * Displays a message dialog with three buttons: one to change the background color,
     * another to reset the background color to white, and a cancel button.
     *
     * @param view The view that triggered the dialog.
     */
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
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * Creates the options menu on the screen.
     *
     * @param menu The menu to create.
     * @return true to indicate that the menu was created successfully.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Handles item selection from the options menu.
     *
     * @param item The selected menu item.
     * @return true if the item is handled.
     */
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
