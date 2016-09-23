package com.zachlittle.android.aca.codekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText mEditText;
    TextView mTextView;
    String inputCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
        mEditText = (EditText) findViewById(R.id.editText);
        mTextView = (TextView) findViewById(R.id.textView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView.setText("");
                String[] userStrings = {"omega \n", "beta \n", "omicron \n"};
                inputCode =mEditText.getText().toString();
                CodeKeeper keeper = new CodeKeeper(userStrings);
                keeper.addCode(inputCode);
                keeper.textIterator();
            }
        });
    }
    public class CodeKeeper {
        ArrayList list;
        String[] codes = {"alpha \n", "lambda \n", "gamma \n", "delta \n", "zeta \n"};

        public CodeKeeper(String[] userCodes) {
            list = new ArrayList();
            // load built in codes
            for (int i = 0; i < codes.length; i++) {
                addCode(codes[i]);
            }
            //load user codes
            for (int j = 0; j < userCodes.length; j++) {
                addCode(userCodes[j]);
            }
        }
        private void addCode(String code) {
            if (!list.contains(code)) {
                list.add(code);
            }
        }
        //method for dsiplaying codes
        private void textIterator(){
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                String output = (String) iterator.next();
                mTextView.append(output);
            }
        }
    }
}
