package atharva.cemp.classes;


import java.util.ArrayList;

import tech.cemp.atharva14.R;
import android.app.Activity;
import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import atharva.cemp.resource.Connector;
import atharva.cemp.worker.PostMan;

public class NewsFeed extends ListActivity {

public final ArrayList<String> pass = new ArrayList<String>();
String response="";
PostMan postman=new PostMan();
Connector con=new Connector();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
				super.onCreate(savedInstanceState);
				//setContentView(android.R.layout.simple_list_item_1);
				response=postman.post("atharva", con.newsfeed);
				System.out.println(response);
				pass.add(response);
				this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,pass));
				ListView listview=getListView();
				
	}
}
	
	
