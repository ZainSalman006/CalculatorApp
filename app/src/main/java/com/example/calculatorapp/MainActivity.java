package com.example.calculatorapp;


import androidx.appcompat.app.AppCompatActivity;

//import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mozilla.javascript.Scriptable;

import com.faendir.rhino_android.RhinoAndroidHelper;

import org.mozilla.javascript.Context;

import org.mozilla.javascript.ast.Scope;



class Data {
    private static String sign="";
    private static String f_num="";
    private static String s_num="";
    private static int dot_counter=0;
    private static boolean flag=false;
    private static boolean isSignPressed=false;
    private static boolean isResultCalculated=false;

    public static boolean getIsResultCalculated() {
        return Data.isResultCalculated;
    }

    public static void setIsResultCalculated(boolean isResultCalculated) {
        Data.isResultCalculated = isResultCalculated;
    }

    public static boolean getFlag()
    {
        return Data.flag;
    }

    public static void setIsSignPressed(boolean isSignPressed) {
        Data.isSignPressed = isSignPressed;
    }

    public static boolean getIsSignPressed()
    {
        return Data.isSignPressed;
    }

    public static String getSign() {
         return Data.sign;
     }

    public static String getF_num() {
        return Data.f_num;
    }

    public static String getS_num() {
        return Data.s_num;
    }

    public static int getDot_counter() {
        return Data.dot_counter;
    }

    public static void setDot_counter(int dot_counter1) {
        Data.dot_counter = dot_counter1;
    }

    public static void setF_num(String f_num1) {
        Data.f_num = f_num1;
    }

    public static void setS_num(String s_num1) {
        Data.s_num = s_num1;
    }

    public static void setSign(String sign1) {
        Data.sign = sign1;
    }

    public static void setFlag(boolean flag) {
        Data.flag = flag;
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clearResult(View view) {
        TextView txtView=findViewById(R.id.textView);
        txtView.setText("");
        performNull();
    }

    void performNull(){
        Data.setIsResultCalculated(false);
        Data.setIsSignPressed(false);
        Data.setFlag(false);
        Data.setF_num("");
        Data.setS_num("");
        Data.setDot_counter(0);
    }

    public void ninePressed(View view) {
        TextView txtView=findViewById(R.id.textView);
        if(Data.getIsResultCalculated()==true)
            txtView.setText("");
            Data.setIsSignPressed(false);
        txtView.setText(txtView.getText()+"9");
    }

    public void eightPressed(View view) {
        TextView txtView=findViewById(R.id.textView);
        if(Data.getIsResultCalculated()==true)
            txtView.setText("");
        txtView.setText(txtView.getText()+"8");
        Data.setIsSignPressed(false);
    }

    public void sevenPressed(View view) {
        TextView txtView=findViewById(R.id.textView);
        if(Data.getIsResultCalculated()==true)
            txtView.setText("");
        Data.setIsSignPressed(false);
        txtView.setText(txtView.getText()+"7");
    }

    public void sixPressed(View view) {
        TextView txtView=findViewById(R.id.textView);
        if(Data.getIsResultCalculated()==true)
            txtView.setText("");
        Data.setIsSignPressed(false);
        txtView.setText(txtView.getText()+"6");
    }

    public void fivePressed(View view) {
        TextView txtView=findViewById(R.id.textView);
        if(Data.getIsResultCalculated()==true)
            txtView.setText("");
        Data.setIsSignPressed(false);
        txtView.setText(txtView.getText()+"5");
    }

    public void fourPressed(View view) {
        TextView txtView=findViewById(R.id.textView);
        if(Data.getIsResultCalculated()==true)
            txtView.setText("");
        Data.setIsSignPressed(false);
        txtView.setText(txtView.getText()+"4");
    }

    public void threePressed(View view) {
        TextView txtView=findViewById(R.id.textView);
        if(Data.getIsResultCalculated()==true)
            txtView.setText("");
        Data.setIsSignPressed(false);
        txtView.setText(txtView.getText()+"3");
    }

    public void twoPressed(View view) {
        TextView txtView=findViewById(R.id.textView);
        if(Data.getIsResultCalculated()==true)
            txtView.setText("");
        Data.setIsSignPressed(false);
        txtView.setText(txtView.getText()+"2");
    }

    public void onePressed(View view) {
        TextView txtView=findViewById(R.id.textView);
        if(Data.getIsResultCalculated()==true)
            txtView.setText("");
        Data.setIsSignPressed(false);
        txtView.setText(txtView.getText()+"1");
    }

    public void zeroPressed(View view) {
        TextView txtView=findViewById(R.id.textView);
        if(Data.getIsResultCalculated()==true)
            txtView.setText("");
        txtView.setText(txtView.getText()+"0");
        Data.setIsSignPressed(false);
    }

    public void doubleZeroPressed(View view) {
        TextView txtView=findViewById(R.id.textView);
        if(Data.getIsResultCalculated()==true)
            txtView.setText("");
        txtView.setText(txtView.getText()+"00");
        Data.setIsSignPressed(false);

    }

    public void dotPressed(View view) {
        if(Data.getDot_counter()==0) {
            TextView txtView = findViewById(R.id.textView);
            if(Data.getIsResultCalculated()==true)
                txtView.setText("");
            txtView.setText(txtView.getText() + ".");
            Data.setIsSignPressed(false);
            Data.setDot_counter(1);
        }
    }

    public void plusPressed(View view) {
        TextView txtView = findViewById(R.id.textView);

        if(!Data.getIsSignPressed()) {
            String txt=txtView.getText().toString();
            if(txt!="") {
                txtView.setText(txt+"+");
            }
            Data.setIsSignPressed(true);
            Data.setDot_counter(0);
        }
    }

    public void minusPressed(View view) {
        TextView txtView = findViewById(R.id.textView);

        if(!Data.getIsSignPressed()) {
            String txt=txtView.getText().toString();
            if(txt!="") {
                txtView.setText(txt+"-");
            }
            Data.setIsSignPressed(true);
            Data.setDot_counter(0);
        }
    }

    public void multiplyPressed(View view) {
        TextView txtView = findViewById(R.id.textView);

        if(!Data.getIsSignPressed()) {
            String txt=txtView.getText().toString();
            if(txt!="") {
                txtView.setText(txt+"*");
            }
            Data.setIsSignPressed(true);
            Data.setDot_counter(0);
        }
    }

    public void divisionPressed(View view) {
        TextView txtView = findViewById(R.id.textView);

        if(!Data.getIsSignPressed()) {
            String txt=txtView.getText().toString();
            if(txt!="") {
                txtView.setText(txt+"/");
            }
            Data.setIsSignPressed(true);
            Data.setDot_counter(0);
        }
    }

    public void modulusPressed(View view) {
        TextView txtView = findViewById(R.id.textView);

        if(!Data.getIsSignPressed()) {
            String txt=txtView.getText().toString();
            if(txt!="") {
                txtView.setText(txt+"/100");
            }
            Data.setIsSignPressed(true);
            Data.setDot_counter(0);
        }
    }

    public void delPressed(View view) {
        TextView txtView = findViewById(R.id.textView);
        if(!(txtView.getText()=="")) {
            String txt = txtView.getText().toString();
            String txt1 = txt.substring(0, txt.length() - 1);
            txtView.setText(txt1);
        }
    }

    public void equalPressed(View view) {
        TextView txtView = findViewById(R.id.textView);

        String expression = txtView.getText().toString();


        Context rhino = Context.enter();

        rhino.setOptimizationLevel(-1);

        String finalResult = "";
        if(!expression.isEmpty()){


            try {
                Scriptable scriptable = rhino.initStandardObjects();
                finalResult = rhino.evaluateString(scriptable, expression, "javascript", 1, null).toString();
            } catch (Exception e) {
                finalResult = "Error";
                txtView.setText("");
            }
            txtView.setText(finalResult);
        }
        else{
            txtView.setText("");
        }
        //Data.setIsSignPressed(true);
        //performNull();
        Data.setIsResultCalculated(false);

    }



}