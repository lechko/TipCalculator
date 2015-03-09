package il.ac.huji.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import il.ac.huji.tipcalculator.R;


public class TipCalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnCalculate_onClick(View v)
    {
        EditText input = (EditText)findViewById(R.id.edtBillAmount);
        String inputText = input.getText().toString();
        TextView txtTip = (TextView)findViewById(R.id.txtTipResult);
        if (inputText.isEmpty())
        {
            txtTip.setText("Please insert a bill amount");
            return;
        }
        double billAmount = Double.parseDouble(inputText);
        double tipResult = Double.valueOf(billAmount * 0.12);
        CheckBox chkRound =(CheckBox)findViewById(R.id.chkRound);
        if (chkRound.isChecked())
        {
            txtTip.setText("Tip: " + String.valueOf(Math.round(tipResult)));
        }
        else
        {
            txtTip.setText("Tip: " + String.valueOf(tipResult));
        }
    }
}
