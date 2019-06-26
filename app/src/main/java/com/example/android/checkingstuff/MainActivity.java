package com.example.android.checkingstuff;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private static int num1 = 0;
    private String[] otherducks = {"Unicorn", "Pirate", "Dr.Who", "Nerd", "Original"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //onClick for Add 1 button
    public void onClickAddOne(View view)
    {
        num1++;
        TextView tallyTextView = (TextView) findViewById(R.id.tally);
        tallyTextView.setText("Count to " + num1);
//        Toast.makeText(this, tallySays + num1, Toast.LENGTH_SHORT).show();
    }//end method addOne

    //onClick for Subtract 1 button
    public void onClickSubOne(View view)
    {
        num1--;
        updateTallyTV();
    }//end method subOne

    public void OnclickReset(View view)
    {
//        DialogFragment resetObject = new ResetCount();
//        resetObject.show(getSupportFragmentManager(),"what?");
        updateTallyTV();
    }

    public void updateTallyTV()
    {
        TextView tallyTextView = (TextView) findViewById(R.id.tally);
        tallyTextView.setText("Count to " + num1);
    }//end update method.

    public void openCancel(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirm reset count");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "yeppers", Toast.LENGTH_LONG).show();
                num1 = 0;
                updateTallyTV();
            }//end onClick overridden method
        });//end set positive button

        builder.setNegativeButton("Nopers", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                finish();
            }//end onclick
        });//end set negative button

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        }// end method to open dialog

//    public void openChooseDucks(View View)
//    {
//        AlertDialog.Builder builder = new DialogInterface.onClickListener();
//        builder.setMessage("Choose some ducks");
//
//    }//end opener for Choose Ducks Dialog



}// end class MainActivity
