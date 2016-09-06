package com.zachlittle.android.aca.comicbooks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText mEditTitle;
    EditText mEditIssueNumber;
    EditText mEditCondition;
    EditText mEditBasePrice;
    TextView mTextView;
    String inputTitle;
    String inputIssueNumber;
    String inputCondition;
    float inputBasePrice;
    HashMap quality = new HashMap();
    int i =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
        mEditTitle = (EditText) findViewById(R.id.editTitle);
        mEditIssueNumber = (EditText) findViewById(R.id.editIssueNumber);
        mEditCondition = (EditText) findViewById(R.id.editCondition);
        mEditBasePrice = (EditText) findViewById(R.id.editBasePrice);
        mTextView = (TextView) findViewById(R.id.textView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputTitle = mEditTitle.getText().toString();
                inputIssueNumber = mEditIssueNumber.getText().toString();
                inputCondition = mEditCondition.getText().toString();
                inputBasePrice = Float.parseFloat(mEditBasePrice.getText().toString());

                // set up hashmap

                float price1 = 3.0F;
                quality.put("mint", price1);
                float price2 = 2.00F;
                quality.put("near mint", price2);
                float price3 = 1.50F;
                quality.put("very fine", price3);
                float price4 = 1.00F;
                quality.put("fine", price4);
                float price5 = .50F;
                quality.put("good", price5);
                float price6 = .00F;
                quality.put("poor", price6);

                //setup a collection
                Comic[] comix = new Comic[3+i]; // setup a comic array that will hold 3 comics
                //add comics to the collection
                comix[0] = new Comic("Amazing Spider-Man", "1A", "very fine", 12_000.00F);
                comix[0].setPrice((Float) quality.get(comix[0].condition));
                comix[1] = new Comic("Incredible Hulk", "181", "near mint", 680.00F);
                comix[1].setPrice((Float) quality.get(comix[1].condition));
                comix[2] = new Comic("Cerebus", "1A", "good", 190.00F);
                comix[2].setPrice((Float) quality.get(comix[2].condition));
                comix[2+i] = new Comic (inputTitle, inputIssueNumber, inputCondition, inputBasePrice);
                comix[2+i].setPrice((Float) quality.get(comix[2+i].condition));


                for (int j = 0; j < (3+i); j++) {
                    mTextView.append("\nTitle: " + comix[j].title);
                    mTextView.append("\nIssue: " + comix[j].issueNumber);
                    mTextView.append("\nCondition: " + comix[j].condition);
                    mTextView.append("\nPrice: " + comix[j].price);
                }
                i++;




       // for (int i = 0; i < comix.length; i++) {
        //    System.out.println("Title: " + comix[i].title);
        //    System.out.println("Issue: " + comix[i].issueNumber);
        //    System.out.println("Condition: " + comix[i].condition);
        //    System.out.println("Price: $" + comix[i].price + "\n");
       // }
    }
});
    }
    class Comic {
        String title;
        String issueNumber;
        String condition;
        float basePrice;
        float price;
        Comic (String inTitle, String inIssueNumber, String inCondition, float inBasePrice) {
            title = inTitle;
            issueNumber = inIssueNumber;
            condition = inCondition;
            basePrice = inBasePrice;
        }
        void setPrice(float factor) {
            price = basePrice * factor;
        }
    }
}
