package com.khagendra.finomenagame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class firstpage extends Activity implements View.OnClickListener {
    EditText player1,player2,nvalue;
    Button Startgame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        Startgame = (Button) findViewById(R.id.button);
        player1 = (EditText) findViewById(R.id.editText);
        player2 = (EditText) findViewById(R.id.editText2);
        nvalue = (EditText) findViewById(R.id.editText3);
        player1.setText("khogen");
        player2.setText("Khagendra");
        nvalue.setText("3");
        Startgame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            Intent i = new Intent(this, gamepage.class);
            Bundle myBundle = new Bundle();
            myBundle.putString("p1",player1.getText().toString());
            myBundle.putString("p2",player2.getText().toString());
            myBundle.putInt("n",Integer.parseInt(nvalue.getText().toString()));
            i.putExtras(myBundle);
            startActivity(i);
            finish();


        }
    }
}
