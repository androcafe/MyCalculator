package visitindia.androcafe.mycalculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //Shared Perference to save values display on textview even after app is closed
    SharedPreferences sharedPref;

    //Editor to edit shared preference
    SharedPreferences.Editor editor;

    //Declaration of all UI components
    Button btnOne,btnTwo,btnThree,btnFour;
    Button btnFive,btnSix,btnSeven,btnEight;
    Button btnNine,btnZero,btnClear,btnEqual;
    Button btnAdd,btnMin,btnMul,btnDiv;
    Button btnDot,btnPlusMin,btnAC,btnPer;

    TextView tvCalculator;

    //this string is to handle +/- button
    String pos_neg_sign="";

    //this string to store all clicked operation
    String operation="";

    //this variavle is used to store result
    double res=0.0;

    //this variable  to check whether string displayed on textview consist of dot(.) or not
    //if yes it will not accept more than one dot on dot(.) in single no.
    boolean isDotted=false;

    //this flag is used to check whether no. button is clicked after any operation button clicked or not
    //flag=0 for no. button is clicked
    //flag=1 for no. button is clicked after any of operator (+,-,*,/) button
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize all UI component
        findViewByIds();

        //Set ClickeListener to all components
        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnMin.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnPlusMin.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnPer.setOnClickListener(this);

        //If value stored in shared pereference is not null
        if(sharedPref.getString("res",null)!=null)
        {
            tvCalculator.setText(sharedPref.getString("res",null));
        }

    }

    private void findViewByIds() {

        //Initialize shared preference with name MyCalPref and mode is private
        sharedPref=getSharedPreferences("MyCalPref",MODE_PRIVATE);
        //Initialize editor of shared preference
        editor=sharedPref.edit();

        //Initialize all UI componenets on calculator
        btnAdd=findViewById(R.id.btn_add);
        btnClear=findViewById(R.id.btn_clear);
        btnEqual=findViewById(R.id.btn_equal);
        btnDot=findViewById(R.id.btn_dot);
        btnMin=findViewById(R.id.btn_min);
        btnMul=findViewById(R.id.btn_mul);
        btnPlusMin=findViewById(R.id.btn_plus_min);
        btnDiv=findViewById(R.id.btn_div);
        btnAC=findViewById(R.id.btn_clearall);
        btnEight=findViewById(R.id.btn_eight);
        btnFive=findViewById(R.id.btn_five);
        btnSix=findViewById(R.id.btn_six);
        btnOne=findViewById(R.id.btn_one);
        btnTwo=findViewById(R.id.btn_two);
        btnThree=findViewById(R.id.btn_three);
        btnFour=findViewById(R.id.btn_four);
        btnSeven=findViewById(R.id.btn_seven);
        btnNine=findViewById(R.id.btn_nine);
        btnZero=findViewById(R.id.btn_zero);
        btnPer=findViewById(R.id.btn_per);
        tvCalculator=findViewById(R.id.tvCalculator);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_one)
        {
            if(flag==1)
            {
                tvCalculator.setText("1");
                flag=0;
            }
            else
                tvCalculator.setText(tvCalculator.getText().toString()+"1");
        }
        if(v.getId()==R.id.btn_two)
        {
            if(flag==1)
            {
                tvCalculator.setText("2");
                flag=0;
            }
            else
                tvCalculator.setText(tvCalculator.getText().toString()+"2");
        }
        if(v.getId()==R.id.btn_three)
        {
            if(flag==1)
            {
                tvCalculator.setText("3");
                flag=0;
            }
            else
                tvCalculator.setText(tvCalculator.getText().toString()+"3");
        }
        if(v.getId()==R.id.btn_four)
        {
            if(flag==1)
            {
                tvCalculator.setText("4");
                flag=0;
            }
            else
                tvCalculator.setText(tvCalculator.getText().toString()+"4");
        }
        if(v.getId()==R.id.btn_five)
        {
            if(flag==1)
            {
                tvCalculator.setText("5");
                flag=0;
            }
            else
                tvCalculator.setText(tvCalculator.getText().toString()+"5");
        }if(v.getId()==R.id.btn_six)
        {
            if(flag==1)
            {
                tvCalculator.setText("6");
                flag=0;
            }
            else
                tvCalculator.setText(tvCalculator.getText().toString()+"6");
        }
        if(v.getId()==R.id.btn_seven)
        {
            if(flag==1)
            {
                tvCalculator.setText("7");
                flag=0;
            }
            else
                tvCalculator.setText(tvCalculator.getText().toString()+"7");
        }
        if(v.getId()==R.id.btn_eight)
        {
            if(flag==1)
            {
                tvCalculator.setText("8");
                flag=0;
            }
            else
                tvCalculator.setText(tvCalculator.getText().toString()+"8");
        }
        if(v.getId()==R.id.btn_nine)
        {
            if(flag==1)
            {
                tvCalculator.setText("9");
                flag=0;
            }
            else
                tvCalculator.setText(tvCalculator.getText().toString()+"9");
        }
        if(v.getId()==R.id.btn_zero)
        {
            if(flag==1)
            {
                tvCalculator.setText("0");
                flag=0;
            }
            else
                tvCalculator.setText(tvCalculator.getText().toString()+"0");
        }
        if(v.getId()==R.id.btn_add)
        {
            //Change color of button and text on button which is clicked
            btnAdd.setBackgroundResource(R.drawable.btn_layout_white);
            btnAdd.setTextColor(getResources().getColor(R.color.colorBlack));

            //set all other button background to orange
            btnMin.setBackgroundResource(R.drawable.btn_layout_orange);
            btnMul.setBackgroundResource(R.drawable.btn_layout_orange);
            btnDiv.setBackgroundResource(R.drawable.btn_layout_orange);
            btnPer.setBackgroundResource(R.drawable.btn_layout_orange);

            //set all button text to white
            btnMin.setTextColor(getResources().getColor(R.color.colorWhite));
            btnMul.setTextColor(getResources().getColor(R.color.colorWhite));
            btnDiv.setTextColor(getResources().getColor(R.color.colorWhite));
            btnPer.setTextColor(getResources().getColor(R.color.colorWhite));


            checkForPrevSavedOperation("+");
        }
        if(v.getId()==R.id.btn_div)
        {
            //Change color of button and text on button which is clicked
            btnDiv.setBackgroundResource(R.drawable.btn_layout_white);
            btnDiv.setTextColor(getResources().getColor(R.color.colorBlack));

            //set all other button background to orange
            btnMin.setBackgroundResource(R.drawable.btn_layout_orange);
            btnMul.setBackgroundResource(R.drawable.btn_layout_orange);
            btnAdd.setBackgroundResource(R.drawable.btn_layout_orange);
            btnPer.setBackgroundResource(R.drawable.btn_layout_orange);

            //set all button text to white
            btnMin.setTextColor(getResources().getColor(R.color.colorWhite));
            btnMul.setTextColor(getResources().getColor(R.color.colorWhite));
            btnPer.setTextColor(getResources().getColor(R.color.colorWhite));
            btnAdd.setTextColor(getResources().getColor(R.color.colorWhite));


            checkForPrevSavedOperation("/");

        }
        if(v.getId()==R.id.btn_min)
        {
            //Change color of button and text on button which is clicked
            btnMin.setBackgroundResource(R.drawable.btn_layout_white);
            btnMin.setTextColor(getResources().getColor(R.color.colorBlack));

            //set all other button background to orange
            btnAdd.setBackgroundResource(R.drawable.btn_layout_orange);
            btnMul.setBackgroundResource(R.drawable.btn_layout_orange);
            btnDiv.setBackgroundResource(R.drawable.btn_layout_orange);
            btnPer.setBackgroundResource(R.drawable.btn_layout_orange);

            //set all button text to white
            btnPer.setTextColor(getResources().getColor(R.color.colorWhite));
            btnMul.setTextColor(getResources().getColor(R.color.colorWhite));
            btnDiv.setTextColor(getResources().getColor(R.color.colorWhite));
            btnAdd.setTextColor(getResources().getColor(R.color.colorWhite));

            checkForPrevSavedOperation("-");
        }
        if(v.getId()==R.id.btn_mul)
        {
            //Change color of button and text on button which is clicked
            btnMul.setBackgroundResource(R.drawable.btn_layout_white);
            btnMul.setTextColor(getResources().getColor(R.color.colorBlack));

            //set all other button background to orange
            btnMin.setBackgroundResource(R.drawable.btn_layout_orange);
            btnAdd.setBackgroundResource(R.drawable.btn_layout_orange);
            btnDiv.setBackgroundResource(R.drawable.btn_layout_orange);
            btnPer.setBackgroundResource(R.drawable.btn_layout_orange);

            //set all button text to white
            btnMin.setTextColor(getResources().getColor(R.color.colorWhite));
            btnPer.setTextColor(getResources().getColor(R.color.colorWhite));
            btnDiv.setTextColor(getResources().getColor(R.color.colorWhite));
            btnAdd.setTextColor(getResources().getColor(R.color.colorWhite));

            checkForPrevSavedOperation("*");
        }
        if(v.getId()==R.id.btn_per)
        {
            //Change color of button and text on button which is clicked
            btnPer.setBackgroundResource(R.drawable.btn_layout_white);
            btnPer.setTextColor(getResources().getColor(R.color.colorBlack));

            //set all other button background to orange
            btnMin.setBackgroundResource(R.drawable.btn_layout_orange);
            btnMul.setBackgroundResource(R.drawable.btn_layout_orange);
            btnDiv.setBackgroundResource(R.drawable.btn_layout_orange);
            btnAdd.setBackgroundResource(R.drawable.btn_layout_orange);

            //set all button text to white
            btnMin.setTextColor(getResources().getColor(R.color.colorWhite));
            btnMul.setTextColor(getResources().getColor(R.color.colorWhite));
            btnDiv.setTextColor(getResources().getColor(R.color.colorWhite));
            btnAdd.setTextColor(getResources().getColor(R.color.colorWhite));

            res = Double.parseDouble(tvCalculator.getText().toString())*(0.01);
            setValueToTextview(res);
        }
        if(v.getId()==R.id.btn_equal)
        {
            //reset all operator button color to orange
            resetOpButtomColor();

            if(operation.equals("+"))
            {
                res = res + Double.parseDouble(tvCalculator.getText().toString());
                setValueToTextview(res);
                operation="";
                isDotted=false;
            }
            if(operation.equals("-"))
            {
                res = res - Double.parseDouble(tvCalculator.getText().toString());
                setValueToTextview(res);
                operation="";
                isDotted=false;
            }
            if(operation.equals("*"))
            {
                res = res * Double.parseDouble(tvCalculator.getText().toString());
                setValueToTextview(res);
                operation="";
                isDotted=false;
            }
            if(operation.equals("/"))
            {
                res = res / Double.parseDouble(tvCalculator.getText().toString());
                setValueToTextview(res);
                operation="";
                isDotted=false;
            }

        }
        if(v.getId()==R.id.btn_clearall)
        {
            resetOpButtomColor();
            tvCalculator.setText("");
            res=0.0;
            flag=0;
            operation="";
            pos_neg_sign="";
            isDotted=false;
        }

        if(v.getId()==R.id.btn_dot)
        {
            resetOpButtomColor();
            if(isDotted)
            {

            }
            else {
                tvCalculator.setText(tvCalculator.getText().toString() + ".");
                isDotted=true;
            }

        }

        if(v.getId()==R.id.btn_plus_min)
        {
            resetOpButtomColor();
            if(pos_neg_sign.equals("")) {
                pos_neg_sign = "-";
                tvCalculator.setText(pos_neg_sign+tvCalculator.getText().toString());
            }
            else {
                pos_neg_sign = "";
                tvCalculator.setText(tvCalculator.getText().subSequence(1,tvCalculator.getText().length()));
            }
        }
        if(v.getId()==R.id.btn_clear)
        {
            resetOpButtomColor();
            if(tvCalculator.getText().toString().length()>0) {
                if(tvCalculator.getText().toString().substring(tvCalculator.getText().toString().length()-1).equals("."))
                {
                    isDotted=false;
                }
                String value = tvCalculator.getText().toString().substring(0, tvCalculator.getText().toString().length() - 1);

                tvCalculator.setText("" + value);
            }
        }
    }

    private void resetOpButtomColor() {
        //set all other button background to orange
        btnMin.setBackgroundResource(R.drawable.btn_layout_orange);
        btnMul.setBackgroundResource(R.drawable.btn_layout_orange);
        btnDiv.setBackgroundResource(R.drawable.btn_layout_orange);
        btnAdd.setBackgroundResource(R.drawable.btn_layout_orange);
        btnPer.setBackgroundResource(R.drawable.btn_layout_orange);

        //set all button text to white
        btnMin.setTextColor(getResources().getColor(R.color.colorWhite));
        btnMul.setTextColor(getResources().getColor(R.color.colorWhite));
        btnDiv.setTextColor(getResources().getColor(R.color.colorWhite));
        btnAdd.setTextColor(getResources().getColor(R.color.colorWhite));
        btnPer.setTextColor(getResources().getColor(R.color.colorWhite));
    }

    private void checkForPrevSavedOperation(String op) {
            //this f variable is used to tell that one of the following if-else condition is already perform
            //and prevent program to enter into next if function
            //f=0 i.e. neither any operation is performed
            //f=1 i.e program is already executed one of function
            int f=0;

            //if flag=1 i.e it is a new no.
            if(flag==1)
            {
                operation=op;
                flag=1;
                f=1;
            }
            if(operation.equals("")&&f!=1)
            {
                //convert textview value into double
                res = Double.parseDouble(tvCalculator.getText().toString());
                //new operation to preveously saved operation
                operation=op;
                //flag=1 i.e. if any numeric button is clicked after this will be consider as new number
                flag=1;

                f=1;
                //set obtained value to textview
                setValueToTextview(res);
                //set isDoted to false so new no. will also include (.) if they want
                isDotted=false;
            }

            if(operation.equals("+")&&f!=1)
            {
                //convert textview value into double
                res = res + Double.parseDouble(tvCalculator.getText().toString());
                flag=1;
                //new operation to preveously saved operation
                operation=op;
                //flag=1 i.e. if any numeric button is clicked after this will be consider as new number
                f=1;
                //set obtained value to textview
                setValueToTextview(res);
                //set isDoted to false so new no. will also include (.) if they want
                isDotted=false;
            }

            if(operation.equals("-")&&f!=1)
            {
                //convert textview value into double
                res = res - Double.parseDouble(tvCalculator.getText().toString());
                flag=1;
                //new operation to preveously saved operation
                operation=op;
                //flag=1 i.e. if any numeric button is clicked after this will be consider as new number
                f=1;
                //set obtained value to textview
                setValueToTextview(res);
                //set isDoted to false so new no. will also include (.) if they want
                isDotted=false;
            }

            if(operation.equals("/")&&f!=1)
            {
                //convert textview value into double
                res = res / Double.parseDouble(tvCalculator.getText().toString());
                //flag=1 i.e. if any numeric button is clicked after this will be consider as new number
                flag=1;
                //new operation to preveously saved operation
                operation=op;
                f=1;
                //set obtained value to textview
                setValueToTextview(res);
                //set isDoted to false so new no. will also include (.) if they want
                isDotted=false;
            }

            if(operation.equals("*")&&f!=1)
            {
                //convert textview value into double
                res = res * Double.parseDouble(tvCalculator.getText().toString());
                //flag=1 i.e. if any numeric button is clicked after this will be consider as new number
                flag=1;
                //new operation to preveously saved operation
                operation=op;
                f=1;
                //set obtained value to textview
                setValueToTextview(res);
                //set isDoted to false so new no. will also include (.) if they want
                isDotted=false;
            }
            if(operation.equals("%")&&f!=1)
            {
                //convert textview value into double
                res = Double.parseDouble(tvCalculator.getText().toString())%100;
                flag=1;
                //new operation to preveously saved operation
                operation=op;
                f=1;
                //set obtained value to textview
                setValueToTextview(res);
                //set isDoted to false so new no. will also include (.) if they want
                isDotted=false;
            }
    }

    //setting value to textview
    private void setValueToTextview(double res)
    {
        //convert result value to String for comparison
        String result=String.valueOf(res);

        //if condition to check whether point is required on not
        //if not point is rmved
        if(result.substring(result.length()-2,result.length()).contains(".0"))
        {
            result=result.substring(0,result.length()-2);
        }
        //finally set value to textview
        tvCalculator.setText(result);
    }

    //if back button is pressed then application will be close
    //and values will be store in shared preference if the value is there in textview
    //so even after you reopen project value will be there in textview
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        editor.putString("res",tvCalculator.getText().toString());
        editor.commit();
        finish();
    }
}
