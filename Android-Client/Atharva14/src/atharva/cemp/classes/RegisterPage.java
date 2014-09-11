package atharva.cemp.classes;




import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


import tech.cemp.atharva14.R;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import atharva.cemp.resource.Connector;
import atharva.cemp.worker.PostMan;

public class RegisterPage extends Activity{
	
	public EditText name,email,college,phn,pwd;
	public Button sign,upload;
	public Spinner gender;
	public static int isupload=0;
	SQLiteDatabase db = null;
	public String mName,mEmail,mCollege,mPhn,mGender,mPassword,mProf;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_page);
		
		final JSONObject mJson = new JSONObject();
		final Connector connector=new Connector();
		
		db = openOrCreateDatabase("Atharva.db", MODE_PRIVATE, null);

		
		name=(EditText)findViewById(R.id.name);
		email=(EditText)findViewById(R.id.email);
		college=(EditText)findViewById(R.id.clg);
		phn=(EditText)findViewById(R.id.phn);
		pwd=(EditText)findViewById(R.id.password);
		gender=(Spinner)findViewById(R.id.gndr);
		sign=(Button)findViewById(R.id.button1);
		List<String> list = new ArrayList<String>();
		list.add("M");
		list.add("F");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		gender.setAdapter(dataAdapter);

		sign.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mGender=gender.getSelectedItem().toString();
				mName=name.getText().toString();
				mEmail=email.getText().toString();
				mPhn=phn.getText().toString();
				mCollege=college.getText().toString();
				mPassword=pwd.getText().toString();
				
				try {

					mJson.put("Name", mName);
					mJson.put("College",mCollege);
					mJson.put("Email",mEmail);
					mJson.put("Phn",mPhn);
					mJson.put("Gender",mGender);
					mJson.put("Password", mPassword);

					String json_string=mJson.toString();
					PostMan mSender=new PostMan();
					String resp=mSender.post(json_string,connector.register);
					if(resp.contains("Success")){
						Toast.makeText(getBaseContext(),"Registered Succesfully", Toast.LENGTH_LONG).show();
						
					}
					else
						Toast.makeText(getBaseContext(),"Failed", Toast.LENGTH_LONG).show();
					
					//}
					//Toast.makeText(getBaseContext(),mJson.toString(), Toast.LENGTH_LONG).show();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Toast.makeText(getBaseContext(),mGender, Toast.LENGTH_SHORT).show();
			}
		});
		
	}

}
