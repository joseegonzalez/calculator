package nyc.c4q.helenchan.hw_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
    private Button equalsButton;
    private Button deleteButton;
    private Button negPosButton;
    private Button percentButton;
    private EditText result;
    private EditText newNumber;
    private TextView displayOperation;

    /* variables to hold operands and type of calculations
       using the class instance Double so the value can be set to null to indicate that there
       isn't a value yet
     */
    private Double operand1 = null;
    private Double operand2 = null;
    private String pendingOperation = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //operations
        additionButton = (Button) findViewById(R.id.addition);
        substractionButton = (Button) findViewById(R.id.minus);
        multiplyButton = (Button) findViewById(R.id.multiply);
        divisionButton = (Button) findViewById(R.id.division_button);
        equalsButton = (Button) findViewById(R.id.equals);
        deleteButton = (Button) findViewById(R.id.delete_button);
        negPosButton = (Button) findViewById(R.id.pos_negative_button);
        percentButton = (Button) findViewById(R.id.percent);

        // input and answer fields
        newNumber = (EditText) findViewById(R.id.new_number);
        result = (EditText) findViewById(R.id.result);
        displayOperation = (TextView) findViewById(R.id.operation);

        // This listener will be assigned to buttons so it's called when each one is clicked
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                newNumber.append(b.getText().toString());
            }
        };


        // TODO store buttons in an array and loop through to assign to listener
        num0Button.setOnClickListener(listener);
        num1Button.setOnClickListener(listener);
        num2Button.setOnClickListener(listener);
        num3Button.setOnClickListener(listener);
        num4Button.setOnClickListener(listener);
        num5Button.setOnClickListener(listener);
        num6Button.setOnClickListener(listener);
        num7Button.setOnClickListener(listener);
        num8Button.setOnClickListener(listener);
        num9Button.setOnClickListener(listener);
        decimalButton.setOnClickListener(listener);

        //On Click listener for the operation buttons
        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String op = b.getText().toString();
                String value = newNumber.getText().toString();
                if (value.length() != 0) {
                    performOperation(value, op);
                }
                pendingOperation = op;
                displayOperation.setText(pendingOperation);
            }
        };

        equalsButton.setOnClickListener(opListener);
        divisionButton.setOnClickListener(opListener);
        multiplyButton.setOnClickListener(opListener);
        substractionButton.setOnClickListener(opListener);
        additionButton.setOnClickListener(opListener);
    }

    private void performOperation(String value, String operation) {
        if (null == operand1) {
            operand1 = Double.valueOf(value);
        }
        else {
            operand2 = Double.valueOf(value);

            if (pendingOperation.equals("=")) {
                pendingOperation = operation;
            }

            switch (pendingOperation) {
                case "=":
                    operand1 = operand2;
                    break;

                case "/":
      /*TODO display error for division by zero. Change result field to text instead of only number??
                     */
                    if (operand2 == 0) {
                        operand1 = 0.0;
                    } else {
                        operand1 /= operand2;
                    }
                    break;

                case "x":
                    operand1 *= operand2;
                    break;

                case "-":
                    operand1 -= operand2;
                    break;

                case "+":
                    operand1 += operand2;
                    break;
            }
        }

        result.setText(operand1.toString());
        newNumber.setText("");  //clears the input widget
    }
}


// TODO add a clear button to clear results field