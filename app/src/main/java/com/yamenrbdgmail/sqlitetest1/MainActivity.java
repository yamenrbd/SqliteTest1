package com.yamenrbdgmail.sqlitetest1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SQLiteDatabase sqLiteDatabase = getBaseContext().openOrCreateDatabase("sqlite-test-1.db",MODE_PRIVATE,null);
          sqLiteDatabase.execSQL("CREATE TABLE contacts2 (name TEXT ,phone INTEGER , email TEXT)");
        sqLiteDatabase.execSQL("insert into contacts  VALUES('yamen',0507895146,'yamenrbd@hotmail');");
        sqLiteDatabase.execSQL("insert into contacts VALUES ('magd',0500816000,'magd@hotmail');");
        Cursor query = sqLiteDatabase.rawQuery("select * from contacts",null);
        if(query.moveToFirst()){
            //cyrcle all the record
            String name = query.getString(0);
            int phone = query.getInt(1);
            String email = query.getString(2);
           Toast.makeText(getBaseContext(),"name ="+name+ " phone ="+phone+" email ="+email,Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getBaseContext(),"error retreving data from database",Toast.LENGTH_LONG).show();
        }
        sqLiteDatabase.close();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
