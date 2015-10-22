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
public class twoActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        TextView txt = (TextView)findViewById(R.id.twoActivitytxt);
        int[] array = bundle.getIntArray("array");
        int max = array[array.length-1];
        int min = array[0];
        int sum = 0;
        Arrays.sort(array);

        for(int d=0; d<array.length; d++) {
            sum  = sum+ array[d];
        }
        bundle.putInt("max",max);
        bundle.putInt("min",min);
        bundle.putInt("sum",sum);
        txt.setText("Max = "+ max + " Min = "+min+" Sum = "+sum);
        i.putExtras(bundle);
        setResult(Activity.RESULT_OK,i);
    }

    public void return2(View ClickedButton){
        finish();
    }

}