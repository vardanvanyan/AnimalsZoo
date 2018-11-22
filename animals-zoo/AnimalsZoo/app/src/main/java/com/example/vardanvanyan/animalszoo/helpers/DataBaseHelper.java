package com.example.vardanvanyan.animalszoo.helpers;


import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static String DB_NAME = "animals_zoo_db";

    private final String path;

    private static DataBaseHelper mInstance = null;

    private SQLiteDatabase database;

    private final Context context;

    private DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
        final String dbFolder = "/databases/";
        path = context.getFilesDir().getAbsolutePath() + dbFolder + DB_NAME;
    }

    public static void initInstance(Context ctx) {
        if (mInstance == null) {
            mInstance = new DataBaseHelper(ctx.getApplicationContext());
        }
    }

    public static DataBaseHelper getInstance(Context ctx) {
        return mInstance;
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if(!dbExist){
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try{
            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){
            //database does't exist yet.
        }
        if(checkDB != null){
            checkDB.close();
        }
        return checkDB != null;
    }

    private void copyDataBase() throws IOException{
        //Open your local db as the input stream
        InputStream myInput = context.getAssets().open(DB_NAME);
        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(path);
        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase() throws SQLException {
        //Open the database
        database = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
    }

    @Override
    public synchronized void close() {
        if(database != null) {
            database.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // TODO --- add access methods
    // Add your public helper methods to access and get content from the database.
    // You could return cursors by doing "return database.query(....)" so it'd be easy
    // to you to create adapters for your views.
}
