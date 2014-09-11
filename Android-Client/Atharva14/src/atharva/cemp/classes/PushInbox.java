package atharva.cemp.classes;



import tech.cemp.atharva14.R;
import android.app.ListActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;

public class PushInbox extends ListActivity {
	
	
	private SQLiteDatabase db = null;
	private final String SAMPLE_DB_NAME = "Atharva.db";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		db = openOrCreateDatabase(SAMPLE_DB_NAME, MODE_PRIVATE, null);
		
		
	}

}
