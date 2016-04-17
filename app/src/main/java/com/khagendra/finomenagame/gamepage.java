package com.khagendra.finomenagame;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by khagendra on 14-04-2016.
 */
public class gamepage extends Activity {

    thesurface mysurface;
    //float points=0;
    float numberOfTaps =0;
    float putx,puty;
    int x,y,n,edgelength,indexx,indexy,tempo;
    Random random;
    boolean gameon,onetime;
    String p1name,p2name,winner;
    ArrayList<Integer> myListx,myListy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mysurface = new thesurface(this);

        setContentView(mysurface);
        Bundle bundle = getIntent().getExtras();
        p1name = bundle.getString("p1");
        p2name = bundle.getString("p2");  //try and catch
        n = bundle.getInt("n");
        x=y=0;
        random = new Random();
        x = random.nextInt(n);  //CHANGE THIS TO SCREEN SIZE
        y = random.nextInt(n);
        gameon = true;
         onetime = true;
        myListx = new ArrayList<Integer>();
        myListy  = new ArrayList<Integer>();;
        numberOfTaps = 0;
        tempo=0;
    }

    @TargetApi(Build.VERSION_CODES.FROYO)
    @Override
    public boolean onTouchEvent(MotionEvent event) {


        int pointerIndex = event.getActionIndex();
        int pointerId = event.getPointerId(pointerIndex);
        int maskedIndex= event.getActionMasked();



        switch (maskedIndex){

            case MotionEvent.ACTION_DOWN :
                putx = event.getX();
                puty = event.getY();  //chage if eerror occurs
                tempo++;

                if(putx<x*edgelength || putx>(x+1)*edgelength || puty<y*edgelength || puty>(y+1)*edgelength){
                    gameon =false;
                    if(numberOfTaps%2==0) winner = p2name;
                    else winner = p1name;
                    Toast.makeText(this,"first 1 tap ",Toast.LENGTH_SHORT).show();

                    showdialogg();
                }

                x = random.nextInt(n);  //CHANGE THIS TO SCREEN SIZE
                y = random.nextInt(n);
                numberOfTaps++;
                myListx.add((int)event.getX());
                myListy.add((int)event.getY());
                //Toast.makeText(this,"total taps = "+numberOfTaps,Toast.LENGTH_SHORT).show();
                // points + tap increase

                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                putx = event.getX(tempo);
                puty = event.getY(tempo);  //chage if eerror occurs
                tempo++;

                if(putx<x*edgelength || putx>(x+1)*edgelength || puty<y*edgelength || puty>(y+1)*edgelength){
                    gameon =false;
                    if(numberOfTaps%2==0) winner = p2name;
                    else winner = p1name;
                    Toast.makeText(this,"first tap ",Toast.LENGTH_SHORT).show();

                    showdialogg();
                }
                x = random.nextInt(n);  //CHANGE THIS TO SCREEN SIZE
                y = random.nextInt(n);
                putx= event.getX();
                puty = event.getY();
                numberOfTaps++;
                myListx.add((int)event.getX(tempo-1));
                myListy.add((int)event.getY(tempo-1));

                //Toast.makeText(this,"total taps = "+numberOfTaps,Toast.LENGTH_SHORT).show();
                // points + tap increase

                break;
            case MotionEvent.ACTION_UP:
                gameon =false;
                if(numberOfTaps%2==0)
                    winner = p2name;
                else winner = p1name;

                showdialogg();

                 //dialog box open
                //new activity
                break;
            case MotionEvent.ACTION_POINTER_UP:

                gameon=false;
                if(numberOfTaps%2==0)
                    winner = p2name;
                 else winner = p1name;

                showdialogg();

                break;
            case MotionEvent.ACTION_MOVE:
                //winning case would change

                      final int historysize = event.getHistorySize();
                      if (historysize > 1) {
                          final int pointercount = event.getPointerCount();

                          if (pointercount % 2 == 0)
                              winner = p2name;
                          else
                              winner = p1name;  //assuming error only while placing finger

                          gameon = false;
                          showdialogg();

                          /*
                          if (pointercount > 1) {
                              for (int h = 0; h < historysize; h++) {
                                  System.out.printf("At time %d:", event.getHistoricalEventTime(h));
                                  for (int p = 0; p < pointercount; p++) {



                                      if(onetime == true) {
                                          int temp = myListx.get(p);
                                          int temp2 = myListy.get(p);
                                          indexx = event.getPointerId(p);
                                          indexy = event.getPointerId(p);

                                          if ((((temp-(edgelength/2)) > (int) event.getHistoricalX(p, h)) || (temp+(edgelength/2)) < (int) (event.getHistoricalX(p, h) + edgelength)) || (temp2-(edgelength/2)) > (int) event.getHistoricalY(p, h) || (temp2+(edgelength/2)) < (int) (event.getHistoricalY(p, h) + edgelength)) {
                                              if (event.getPointerId(p) % 2 == 0)
                                                  Toast.makeText(this, "player1 loses pcount="+pointercount+" hsize="+historysize+" indexx="+event.getPointerId(p), Toast.LENGTH_SHORT).show();
                                              else
                                                  Toast.makeText(this, "player 2 loses p="+event.getPointerId(p), Toast.LENGTH_SHORT).show();
                                              gameon = false;
                                              onetime = false;
                                          }
                                      }

                                      // Toast.makeText(this,"x="+event.getHistoricalX(0, h),Toast.LENGTH_SHORT).show();
                                      // System.out.printf("  pointer %d: (%f,%f)",
                                       // event.getPointerId(p), event.getHistoricalX(p, h), event.getHistoricalY(p, h));
                                  }
                              }


                              System.out.printf("At time %d:", event.getEventTime());
                              for (int p = 0; p < pointercount; p++) {
                                  System.out.printf("  pointer %d: (%f,%f)",
                                          event.getPointerId(p), event.getX(p), event.getY(p));
                              }
                          } */
                      }


      /*
                if((event.getX()<(x*edgelength) || event.getX()>(x*edgelength+edgelength)) && (event.getY()<(y*edgelength) || event.getY()>(y*edgelength+edgelength))){
                    gameon = false;
                    if(numberOfTaps%2==0)
                        Toast.makeText(this,p2name+" wins by sliding & taps= "+numberOfTaps,Toast.LENGTH_SHORT).show();
                    else Toast.makeText(this,p1name+" wins by sliding & taps= "+numberOfTaps,Toast.LENGTH_SHORT).show();
                }

                      */

               /* gameon=false;
                if(numberOfTaps%2==0)
                    Toast.makeText(this,"Player 2 wins",Toast.LENGTH_SHORT).show();
                else Toast.makeText(this,"Player 1 wins",Toast.LENGTH_SHORT).show();
                  */
                break;

        }

        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mysurface.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mysurface.resume();
    }

    public class thesurface extends SurfaceView implements Runnable{

        SurfaceHolder myHolder;
        Thread myThread=null;
        boolean isRunning =true; //change for resume and pause

        public thesurface(Context context){
            super(context);
            myHolder = getHolder();

        }

        @Override
        public void run() {
            while(isRunning){
                if(!myHolder.getSurface().isValid())
                    continue;

                Canvas mycanvas = myHolder.lockCanvas();
                edgelength = mycanvas.getWidth()/n;
                mycanvas.drawRGB(02,02,150);
                if(gameon==true){
                    Rect myRect = new Rect(); //gloabl varialbe

                    myRect.set((x*(mycanvas.getWidth()/n)),(y*(mycanvas.getWidth()/n)),(x*(mycanvas.getWidth()/n))+edgelength,(y*(mycanvas.getWidth()/n))+edgelength); //here instead of height width is used.
                    Paint myPaint = new Paint();
                    myPaint.setColor(Color.RED);
                    myPaint.setStyle(Paint.Style.FILL);
                    mycanvas.drawRect(myRect,myPaint);

                }
                myHolder.unlockCanvasAndPost(mycanvas);
            }

        }
        public void pause(){
            isRunning = false;
            while(true){
                try {
                    myThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            myThread = null;
            finish();
        }
        public void resume(){
            isRunning = true;
            myThread = new Thread(this);
            myThread.start();

        }
    }

    public void showdialogg(){

        Intent i = new Intent(this, Result.class);
        Bundle myBundle = new Bundle();
        myBundle.putString("namee",winner);
        i.putExtras(myBundle);
        startActivity(i);
        finish();
    }

}
