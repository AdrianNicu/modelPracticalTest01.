package practicaltest01.eim.systems.cs.pub.ro.modelpracticaltest01;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ModelPracticalTest01MainActivity extends AppCompatActivity {

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    public static final String tv1Key = "tv1k";
    public static final String tv2Key = "tv2k";
    private static final int ACT_REQUEST_CODE = 2018;

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            TextView tv1 = (TextView) findViewById(R.id.tv1);
            TextView tv2 = (TextView) findViewById(R.id.tv2);
            if (((Button)view).getId() == R.id.btn_1) {
                int nr = Integer.parseInt(tv1.getText().toString());
                tv1.setText((nr+1)+"");
            }
            if (((Button)view).getId() == R.id.btn_2) {
                int nr = Integer.parseInt(tv2.getText().toString());
                tv2.setText((nr+1)+"");
            }
            if (((Button)view).getId() == R.id.btn_3) {
                Intent intent = new Intent("practicaltest01.eim.systems.cs.pub.ro.modelpracticaltest01.ModelPracticalTest01SecondaryActivity");
                intent.putExtra("key1", tv1.getText().toString() + tv2.getText().toString() );

                startActivityForResult(intent, ACT_REQUEST_CODE);

            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_practical_test01_main);
        Button btn1 = (Button)findViewById(R.id.btn_1);
        Button btn2 = (Button)findViewById(R.id.btn_2);
        btn1.setOnClickListener(buttonClickListener);
        btn2.setOnClickListener(buttonClickListener);

        Button btn3 = (Button)findViewById(R.id.btn_3);
        btn3.setOnClickListener(buttonClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        savedInstanceState.putString(tv1Key, tv1.getText().toString());
        savedInstanceState.putString(tv2Key, tv2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        String auxStr = savedInstanceState.getString(tv1Key);
        if ( auxStr != null) {
            tv1.setText(auxStr);
        }
        auxStr = savedInstanceState.getString(tv2Key);
        if ( auxStr != null) {
            tv2.setText(auxStr);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Log.d("CVA", "OnActResult Called");
        switch(requestCode) {
            case ACT_REQUEST_CODE:
                Toast.makeText(ModelPracticalTest01MainActivity.this, resultCode+"", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
