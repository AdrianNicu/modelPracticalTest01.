package practicaltest01.eim.systems.cs.pub.ro.modelpracticaltest01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ModelPracticalTest01SecondaryActivity extends AppCompatActivity {

    private ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();

    private class ButtonClickListener2 implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            if (((Button)view).getId() == R.id.ok) {
                setResult(Activity.RESULT_OK, getIntent());
                finish();
            }
            if (((Button)view).getId() == R.id.cancel) {
                setResult(Activity.RESULT_CANCELED, getIntent());
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_practical_test01_secondary);

        Log.d("NewACt", "NewAct started");
        Intent intent = getIntent();
        String nrStr = intent.getStringExtra("key1");
        TextView tv = (TextView) findViewById(R.id.tv3);
        tv.setText(nrStr);
        Button b = (Button) findViewById(R.id.ok);
        b.setOnClickListener(buttonClickListener2);


        b = (Button) findViewById(R.id.cancel);
        b.setOnClickListener(buttonClickListener2);


    }


}
