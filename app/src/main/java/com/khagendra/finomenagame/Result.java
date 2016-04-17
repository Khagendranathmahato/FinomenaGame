package com.khagendra.finomenagame;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by khagendra on 17-04-2016.
 */
public class Result extends Activity{

    TextView won;
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.result_one);
        won = (TextView) findViewById(R.id.textView4);
        Bundle bundle = getIntent().getExtras();
        temp = bundle.getString("namee");
        won.setText(temp+" is the winner !!!");
        showdialog();

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public  void showdialog(){
        //FragmentManager myfragmentmanager = getFragmentManager();
        //MyDialog mydial = new MyDialog();
        //mydial.show(myfragmentmanager,"keymydial");

        AlertDialog.Builder a_builer = new AlertDialog.Builder(Result.this);
        a_builer.setMessage("Do you want to play again?").setCancelable(false).setPositiveButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                finish();///chageng text here for dialog
            }
        }).setNegativeButton("Yes",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();//change
                Intent iota = new Intent(Result.this,firstpage.class);
                startActivity(iota);
                finish();


            }
        });
        AlertDialog alert = a_builer.create();
        alert.setTitle(temp+" is the winner !!!");
        alert.show();



    }
}
