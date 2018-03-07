package com.example.macpro.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class myDBClass extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mydatabase";
    private static final String TABLE_MEMBER = "members";


    public myDBClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
// TODO Auto-generated constructor stub

    }

    public myDBClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE members " +
                "(MemberID INTEGER PRIMARY KEY," +
                " Name TEXT(100)," +
                " Tel TEXT(100));");
        Log.d("CREATE TABLE", "Create Table Successfully.");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // Insert Data
    public long InsertData(String strMemberID, String strName, String strTel) {
// TODO Auto-generated method stub
        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data
            ContentValues Val = new ContentValues();
            Val.put("MemberID", strMemberID);
            Val.put("Name", strName);
            Val.put("Tel", strTel);
            long rows = db.insert(TABLE_MEMBER, null, Val);
            db.close();
            return rows; // return rows inserted.
        } catch (Exception e) {

            return -1;

        }

    }

    // Select Data
    public String[] SelectData(String strMemberID) {
// TODO Auto-generated method stub
        try {
            String arrData[] = null;
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data
            Cursor cursor = db.query(TABLE_MEMBER, new String[]{"*"},
                    "MemberID=?",
                    new String[]{String.valueOf(strMemberID)}, null, null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    arrData = new String[cursor.getColumnCount()];


                    arrData[0] = cursor.getString(0);

                    arrData[1] = cursor.getString(1);

                    arrData[2] = cursor.getString(2);

                }

            }

            cursor.close();

            db.close();

            return arrData;

        } catch (Exception e) {

            return null;

        }

    }


    //Select All Data
    public class sMembers {
        String _MemberID, _Name, _Tel;

        // Set Value
        public void sMemberID(String vMemberID) {
            this._MemberID = vMemberID;
        }

        public void sName(String vName) {
            this._Name = vName;
        }

        public void sTel(String vTel) {
            this._Tel = vTel;
        }

        // Get Value
        public String gMemberID() {
            return _MemberID;
        }

        public String gName() {
            return _Name;
        }

        public String gTel() {
            return _Tel;
        }
    }

    public List<sMembers> SelectAllData() {
// TODO Auto-generated method stub
        try {
            List<sMembers> MemberList = new ArrayList<sMembers>();
            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data
            String strSQL = "SELECT  * FROM " + TABLE_MEMBER;
            Cursor cursor = db.rawQuery(strSQL, null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        sMembers cMember = new sMembers();
                        cMember.sMemberID(cursor.getString(0));
                        cMember.sName(cursor.getString(1));
                        cMember.sTel(cursor.getString(2));
                        MemberList.add(cMember);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MemberList;

        } catch (Exception e) {
            return null;
        }

    }

    // Update Data
    public long UpdateData(String strMemberID,String strName,String strTel) {
// TODO Auto-generated method stub
        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data


            ContentValues Val = new ContentValues();
            Val.put("Name", strName);
            Val.put("Tel", strTel);
            long rows = db.update(TABLE_MEMBER, Val, " MemberID = ?",
            new String[] { String.valueOf(strMemberID) });
            db.close();
            return rows; // return rows updated.
        } catch (Exception e) {
            return -1;
        }
    }


    // Delete Data
    public long DeleteData(String strMemberID) {

// TODO Auto-generated method stub

        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); // Write Data


            long rows =  db.delete(TABLE_MEMBER, "MemberID = ?",

            new String[] { String.valueOf(strMemberID) });
            db.close();
            return rows; // return rows delete.
        } catch (Exception e) {
            return -1;
        }
    }

}
