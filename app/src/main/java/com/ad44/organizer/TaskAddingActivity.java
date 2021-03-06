package com.ad44.organizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import static com.ad44.organizer.MainActivity.myDb;

public class TaskAddingActivity extends AppCompatActivity {



    EditText taskInput;
    RadioButton complexitySwitch1, complexitySwitch2, complexitySwitch3;
    RadioButton volumeSwitch1, volumeSwitch2, volumeSwitch3;
    RadioButton urgencySwitch1, urgencySwitch2, urgencySwitch3;
    SwitchCompat enjoymentSwitch1;


    int volume,complexity,urgency,enjoyment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_adding);



        taskInput = findViewById(R.id.taskImput);
        Button addToDb = findViewById(R.id.addToDb);


        complexitySwitch1=findViewById(R.id.complexitySwitch1);
        complexitySwitch2=findViewById(R.id.complexitySwitch2);
        complexitySwitch3=findViewById(R.id.complexitySwitch3);

        volumeSwitch1 = findViewById(R.id.volumeSwitch1);
        volumeSwitch2 = findViewById(R.id.volumeSwitch2);
        volumeSwitch3 = findViewById(R.id.volumeSwitch3);

        urgencySwitch1=findViewById(R.id.urgencySwitch1);
        urgencySwitch2=findViewById(R.id.urgencySwitch2);
        urgencySwitch3=findViewById(R.id.urgencySwitch3);

        enjoymentSwitch1=findViewById(R.id.enjoymentSwitch1);




        addToDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(complexitySwitch1.isChecked()){
                    complexity=1;
                }
                if(complexitySwitch2.isChecked()){
                    complexity=2;
                }
                if(complexitySwitch3.isChecked()){
                    complexity=3;
                }




                if(volumeSwitch1.isChecked()){
                    volume=1;
                }
                if(volumeSwitch2.isChecked()){
                    volume=2;
                }
                if(volumeSwitch3.isChecked()){
                    volume=3;
                }



                if(urgencySwitch1.isChecked()){
                    urgency=1;
                }
                if(urgencySwitch2.isChecked()){
                    urgency=2;
                }
                if(urgencySwitch3.isChecked()){
                    urgency=3;
                }


                if(enjoymentSwitch1.isChecked()){
                    enjoyment=1;
                }
                else{
                    enjoyment=0;
                }


                boolean isInserted = myDb.addTask(taskInput.getText().toString(),complexity,volume,urgency, enjoyment);

                if(isInserted)
                    Toast.makeText(getApplicationContext(),getString(R.string.done), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),getString(R.string.no_data_found), Toast.LENGTH_SHORT).show();

                finish();

            }
        });



    }
}

