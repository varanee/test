package com.example.macpro.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //myDBClass myDb = new myDBClass(this);
        //myDb.getWritableDatabase(); // First method
        final myDBClass myDb = new myDBClass(this);
        // Button1 (Insert)
        final Button btn1 = (Button) findViewById(R.id.button1);
// Perform action on click

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// Statement 1
                long flg1 = myDb.InsertData("1", "Weerachai", "0819876107");
                if (flg1 > 0) {
                    Toast.makeText(MainActivity.this, "Insert(1) Data Successfully",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Insert(1) Data Failed.",
                            Toast.LENGTH_LONG).show();
                }
// Statement 2
                long flg2 = myDb.InsertData("2", "Win", "021978032");
                if (flg2 > 0) {
                    Toast.makeText(MainActivity.this, "Insert(2) Data Successfully",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Insert(2) Data Failed.", Toast.LENGTH_LONG).show();
                }
            }
        });

        //final myDBClass myDb = new myDBClass(this);

        final Button btn2 = (Button) findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String arrData[] = myDb.SelectData("1");
                if (arrData == null) {
                    Toast.makeText(MainActivity.this, "Not found Data!", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(MainActivity.this, "MemberID = " + arrData[0] + "," + arrData[1] + "," + arrData[2], Toast.LENGTH_LONG).show();

                }
            }
        });

        //final myDBClass myDb = new myDBClass(this);

        final Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                List<myDBClass.sMembers> MebmerList = myDb.SelectAllData();
                if (MebmerList == null) {
                    Toast.makeText(MainActivity.this, "Not found Data!", Toast.LENGTH_LONG).show();

                } else {
                    for (myDBClass.sMembers mem : MebmerList) {
                        Toast.makeText(MainActivity.this, "MemberID = " + mem.gMemberID() + "," + mem.gName() + "," + mem.gTel(), Toast.LENGTH_LONG).show();

                    }

                }


            }


        });

        //final myDBClass myDb = new myDBClass(this);

        final Button btn4 = (Button) findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                long flg = myDb.UpdateData("2", "Win Win", "021978032");
                if (flg > 0) {
                    Toast.makeText(MainActivity.this, "Update Data Successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Update Data Failed.", Toast.LENGTH_LONG).show();

                }
            }
        });

        //final myDBClass myDb = new myDBClass(this);
        final Button btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                long flg = myDb.DeleteData("2");
                if (flg > 0) {
                    Toast.makeText(MainActivity.this, "Delete Data Successfully", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(MainActivity.this, "Delete Data Failed.", Toast.LENGTH_LONG).show();

                }
            }
        });


    }


}


