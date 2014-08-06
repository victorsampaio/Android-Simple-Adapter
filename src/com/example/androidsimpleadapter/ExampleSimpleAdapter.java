package com.example.androidsimpleadapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.R.animator;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


public class ExampleSimpleAdapter extends ListActivity {

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        //setContentView(R.layout.activity_example_simple_adapter);
        
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
        
        for (int i =0; i <10 ; i++){
        	HashMap<String, String> item = new HashMap<String, String>();
        	item.put("name", "Name " +i);
        	item.put("fone", "Fone " +i);
        	list.add(item);    	
        }
        
        String[] from  = new String[]{"name","fone"};
        
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};
        int layoutNative = android.R.layout.two_line_list_item;
        setListAdapter(new SimpleAdapter(this, list, layoutNative, from, to));
        
    }
    
    protected void onListItemClick (ListView l, View v, int position, long id){
    	super.onListItemClick(l, v, position, id);
    	
    	Object obj = this.getListAdapter().getItem(position);
    	String item = obj.toString();
    	
    	Toast.makeText(this, "You Select: " + item, Toast.LENGTH_SHORT).show();
    	
    	
    }
    
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.example_simple_adapter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
