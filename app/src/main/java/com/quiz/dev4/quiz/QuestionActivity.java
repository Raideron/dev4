package com.quiz.dev4.quiz;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class QuestionActivity extends ActionBarActivity {

    TextView textview;
    DBHandler myDbHelper;

    private String question;
    private boolean awnser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

//        DBHandler myDbHelper = new DBHandler();
        TestAdapter mDbHelper = new TestAdapter(this);
        mDbHelper.createDatabase();
        mDbHelper.open();

        Cursor testdata = mDbHelper.getTestData();

        mDbHelper.close();

    }

    public void trueButtonClicked() {

    }

    public void falseButtonClicked() {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startResults(View v) {
        Log.d("test1", "button is clicked");
        Intent myIntent = new Intent(QuestionActivity.this, Result.class);
        //myIntent.putExtra("key", value); //Optional parameters
        QuestionActivity.this.startActivity(myIntent);
    }
}
