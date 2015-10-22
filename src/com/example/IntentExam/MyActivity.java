package com.example.IntentExam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/**
 * Created by G00287018 on 22/10/2015.
 */
public class MyActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void button1(View ButtonClicked){

        Intent i =new Intent (MyActivity.this,
                oneActivity.class);
        Bundle bundle = new Bundle();

        bundle.putInt("1",1);
        bundle.putInt("2",7);
        bundle.putInt("3",10);
        bundle.putInt("4",12);
        bundle.putInt("5",20);

        i.putExtras(bundle);
        startActivityForResult(i,101);
    }

    public void button2(View ButtonClicked){

        EditText txt1 = (EditText)findViewById(R.id.editText2);
        String s = txt1.getText().toString();
        String[] a = s.split(" ");
        int[] a2 = new int[a.length];
        Intent i = new Intent(MyActivity.this,twoActivity.class);
        Bundle bundle = new Bundle();

        for(int ii= 0; ii<a.length; ii++)
            a2[ii] = Integer.parseInt(a[ii]);

        bundle.putIntArray("array",a2);
        i.putExtras(bundle);
        startActivityForResult(i,102);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            if((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
                Bundle result = data.getExtras();
                int sum = result.getInt("sum");
                int max = result.getInt("max");
                int min = result.getInt("min");

                TextView txt = (TextView)findViewById(R.id.results);
                txt.setText("Max = "+ max + " \nMin = "+min+"\n Sum = "+sum);
            }
            else if((requestCode == 102 ) && (resultCode == Activity.RESULT_OK)){
                Bundle result = data.getExtras();
                int sum = result.getInt("sum");
                int max = result.getInt("max");
                int min = result.getInt("min");

                TextView txt = (TextView)findViewById(R.id.textView2);
                txt.setText("Max = "+ max + "\n Min = "+min+" \nSum = "+sum);
            }

        }catch (Exception e){
        }
    }


}