package nyc.c4q.helenchan.hw_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button num1Button;
    private Button num2Button;
    private Button num3Button;
    private Button num4Button;
    private Button num5Button;
    private Button num6Button;
    private Button num7Button;
    private Button num8Button;
    private Button num9Button;
    private Button num0Button;
    private Button decimalButton;
    private Button additionButton;
    private Button substractionButton;
    private Button multiplyButton;
    private Button divisionButton;
    private Button enterButton;
    private Button deleteButton;
    private Button negPosButton;
    private Button percentButton;
    private TextView displayTextViewEntered;
    private EditText displayAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize(){
        num0Button = (Button) findViewById(R.id.num0);
        num1Button = (Button) findViewById(R.id.num1);
        num2Button = (Button) findViewById(R.id.num2);
        num3Button = (Button) findViewById(R.id.num3);
        num4Button = (Button) findViewById(R.id.num4);
        num5Button = (Button) findViewById(R.id.num5);
        num6Button = (Button) findViewById(R.id.num6);
        num7Button = (Button) findViewById(R.id.num7);
        num8Button = (Button) findViewById(R.id.num8);
        num9Button = (Button) findViewById(R.id.num9);
        decimalButton = (Button) findViewById(R.id.period);
        additionButton = (Button) findViewById(R.id.addition);
        substractionButton = (Button) findViewById(R.id.minus);
        multiplyButton = (Button) findViewById(R.id.multiply);
        divisionButton = (Button) findViewById(R.id.division_button);
        enterButton = (Button) findViewById(R.id.equals);
        deleteButton = (Button) findViewById(R.id.delete_button);
        negPosButton = (Button) findViewById(R.id.pos_negative_button);
        percentButton = (Button) findViewById(R.id.percent);
        displayTextViewEntered = (TextView) findViewById(R.id.entered_number);
        displayAnswer = (EditText) findViewById(R.id.answer_edittext);
    }


}
