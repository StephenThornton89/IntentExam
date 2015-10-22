package com.example.IntentExam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;

/**
 * Created by G00287018 on 22/10/2015.
 */
public class oneActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        int numArray[] = new int[5];

        numArray[0] = bundle. getInt("1");
        numArray[1]= bundle. getInt("2");
        numArray[2] = bundle. getInt("3");
        numArray[3]= bundle. getInt("4");
        numArray[4] = bundle. getInt("5");
        Arrays.sort(numArray);

        int max = numArray[4];
        int min = numArray[0];
        int sum = numArray[0] + numArray[1] + numArray[2] + numArray[3] + numArray[4];

        bundle.putInt("max",max);
        bundle.putInt("min",min);
        bundle.putInt("sum",sum);

        TextView txt = (TextView)findViewById(R.id.oneActivitytxt);
        txt.setText("Max Num = "+ max + " Min Num = "+min+" Sum = "+sum);
        i.putExtras(bundle);
        setResult(Activity.RESULT_OK,i);
    }

    public void return1(View ButtonClicked){
        finish();
    }

}