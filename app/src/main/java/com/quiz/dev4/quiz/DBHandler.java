package com.quiz.dev4.quiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alex on 22-6-2015.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "question.db";
    public static final String TABLE_QUESTIONS = "questions";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_QUESTION = "questionName";
    public static final String COLUMN_GENRE = "questionGenre";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE" + TABLE_QUESTIONS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                COLUMN_QUESTION + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        onCreate(db);
    }

    public void addQuestion(Question question) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION, question.getQuestion());
        values.put(COLUMN_GENRE, question.getQuestion());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_QUESTIONS, null, values);
        db.close();
    }

    public void deleteQuestion(String questionName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_QUESTIONS + " WHERE " + COLUMN_QUESTION + "=\"" + questionName + "\";");
    }

    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_QUESTIONS + " WHERE 1";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while (c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("questionName"))!=null) {
                dbString += c.getString(c.getColumnIndex("questionName"));
                dbString += "\n";
            }
        }
        
        db.close();
        return dbString;
    }
}
