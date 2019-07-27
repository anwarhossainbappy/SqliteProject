package com.example.shomitiapp.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseConfiguration extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="shomiti.db";
    private static final String TABLE_NAME ="monthly_fee";
    private static final String ID ="id";
    private static final String NAME ="member_name";
    private static final String MONTH_NAME ="month_name";
    private static final String MONTHLY_FEE ="monthly_fee";
    private static final String FINE ="fine";
    private static final String DATE ="date";
    private static final int VERSION_NUMBER =1;
    private static final String CREATE_TABLE =("CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255),"+MONTH_NAME+" VARCHAR(255),"+MONTHLY_FEE+" INTEGER,"+FINE+" INTEGER,"+DATE+" VARCHAR(255))");
    private static final String SELECT_ALL ="SELECT * FROM "+TABLE_NAME;
    private Context context;

    public DatabaseConfiguration( Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Toast.makeText(context, "Database Created", Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);

        }catch (Exception e)
        {
            Toast.makeText(context, "Exception "+e, Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public long insertData(String name, String month,String fee,String fine,String date)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,name);
        values.put(MONTH_NAME,month);
        values.put(MONTHLY_FEE,fee);
        values.put(FINE,fine);
        values.put(DATE,date);
        long rowId= sqLiteDatabase.insert(TABLE_NAME,null,values);
        return rowId;
    }
    public Cursor displayData()
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;
    }
    public boolean UpdateData(String id,String name, String fee, String fine)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(NAME,name);
        contentValues.put(MONTHLY_FEE,fee);
        contentValues.put(FINE,fine);

        sqLiteDatabase.update(TABLE_NAME,contentValues,ID+" = ?",new String[]{id});
        return true;
    }
    public Integer deleteData(String id)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,ID+" = ?",new String[]{ id });
    }
}
