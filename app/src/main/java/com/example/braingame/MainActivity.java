package com.example.braingame;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn6;
    int correctLocation;
    TextView resulttextview;
    int score;
    int numberOfquestion;
    TextView secoreView;
    TextView textView3;
    TextView textView;
    ConstraintLayout gamelayout;

    // for 4 button
    ArrayList<Integer> answer=new ArrayList<Integer>();// array for 4 btn adding random number

    public void go(View view){

        btn=(Button) findViewById(R.id.button);
        btn.setVisibility(View.INVISIBLE);// invisble when we click the btn
        gamelayout.setVisibility(View.VISIBLE);// visble the gamelayout
        PLAYAGAIN(findViewById(R.id.textView));// GIVING ANY VIEW IT IS NOT EFFECT ANY THING AND WE CALL THE FUNCTION HERE
    }
    public void chooseanswer(View view){
        Log.i("tag",view.getTag().toString());// for tag number
        if(Integer.toString(correctLocation).equals(view.getTag().toString())){ // comapre two string correctloaction and tag
            resulttextview.setText("Correct");
            score++;
        }else{
            resulttextview.setText("Wrong");
        }
        numberOfquestion++;
        secoreView.setText(Integer.toString(score)+" / "+Integer.toString(numberOfquestion));
        newQuestion();
    }
            public void newQuestion(){
                Random rand=new Random();
                int a=rand.nextInt(21);
                int b=rand.nextInt(21);
                textView3.setText(Integer.toString(a)+" + "+Integer.toString(b));
//        int c=rand.nextInt(30);
//        int d =rand.nextInt(21);
//        int e=rand.nextInt(25);
//        int f=rand.nextInt(40);
//        btn1.setText(Integer.toString(c));
//        btn2.setText(Integer.toString(d));
//        btn3.setText(Integer.toString(e));
//        btn4.setText(Integer.toString(f));f
                correctLocation=rand.nextInt(4);//we are setting the in for correct location
                answer.clear();// we are using this because newanswer will also update 4 numeric value
                for (int i=0;i<4;i++){
                    if (i==correctLocation) {
                        answer.add(a+b);// we are adding the 1,2,3,in array list
                    }
                    else{
                        int wronganswer=rand.nextInt(41);// setting the random number for wrong answer
                        while (wronganswer==a+b){// now we are applying loop if wronganser=a+b number then we will put another random number
                            wronganswer=rand.nextInt(41);
                        }
                        answer.add(wronganswer);// setting 20 bound of the a and 20 bound of b
                    }
                }
                btn1.setText(Integer.toString(answer.get(0)));
                btn2.setText(Integer.toString(answer.get(1)));
                btn3.setText(Integer.toString(answer.get(2)));
                btn4.setText(Integer.toString(answer.get(3)));

            }
            public void PLAYAGAIN(View view){
                score=0;
                 numberOfquestion=0;
                 textView.setText("30s");
                secoreView.setText(Integer.toString(score)+" / "+Integer.toString(numberOfquestion));//FOR SETTING THE VALUE AGAIN
                btn1.setEnabled(true);// for enable the button is true means we can clcik btn
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                   newQuestion();
                btn6.setVisibility(View.INVISIBLE);// invisible when play again
                new CountDownTimer(30000,1000){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        textView.setText(String.valueOf(millisUntilFinished/1000)+"s");
                        //  String set=Long.toString(millisUntilFinished/1000);

                    }

                    @Override
                    public void onFinish() {
                        resulttextview.setText("Done");
                        btn6.setVisibility(View.VISIBLE);// visible when time is over
                        btn1.setEnabled(false);// for enable the button we can not click btn
                        btn2.setEnabled(false);
                        btn3.setEnabled(false);
                        btn4.setEnabled(false);
                    }
                }.start();
            }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView3=findViewById(R.id.textView3);
        textView=findViewById(R.id.textView);
        // this is my logic to print random number in for nutton
         btn1=findViewById(R.id.button2);//this is we are setting all other for button
         btn2=findViewById(R.id.button3);
         btn3=findViewById(R.id.button4);
         btn4=findViewById(R.id.button5);
        resulttextview=findViewById(R.id.textView4);
        secoreView=findViewById(R.id.textView2);
        gamelayout=findViewById(R.id.gamelayout);// seeting the 2 constraints id in which we using all the functionality
        btn6=findViewById(R.id.button6);
      //  View view = inflater.inflate(R.layout.hifragment_main, container, false);
  //     btn.setVisibility(View.VISIBLE);// visible the button on starting
        gamelayout.setVisibility(View.INVISIBLE);//making the layout in visble



    }
}
