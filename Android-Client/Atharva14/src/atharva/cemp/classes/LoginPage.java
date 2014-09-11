package atharva.cemp.classes;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tech.cemp.atharva14.R;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import atharva.cemp.resource.Connector;
import atharva.cemp.worker.PostMan;

public class LoginPage extends Activity implements OnClickListener {

	private Button reg, login, exit;
	private EditText mail, pwd;
	private SQLiteDatabase db = null;
	private ImageView img;
	public static String response = "";
	private final String SAMPLE_DB_NAME = "Atharva.db";
	private ProgressDialog progress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_page);

		reg = (Button) findViewById(R.id.button2);
		login = (Button) findViewById(R.id.button1);
		mail = (EditText) findViewById(R.id.editText1);
		pwd = (EditText) findViewById(R.id.editText2);
		img = (ImageView) findViewById(R.id.imageView1);

		db = openOrCreateDatabase(SAMPLE_DB_NAME, MODE_PRIVATE, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS PROFILE(NAME VARCHAR(50),COLLEGE VARCHAR(75),EMAIL VARCHAR(30),PHONE VARCHAR(15),GENDER VARCHAR(2),PASSWORD VARCHAR(15),PRIMARY KEY(EMAIL))");
		db.execSQL("delete from PROFILE");

		login.setOnClickListener(this);
		reg.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		// determine which button was pressed:
		switch (v.getId()) {
		case R.id.button1:

			new AttemptLogin().execute();
			break;

		case R.id.button2:

			Intent i = new Intent(this, RegisterPage.class);
			startActivity(i);
			break;

		default:
			break;

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.login_page, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.exit:
			System.exit(0);
		}
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			AlertDialog.Builder alert;
			final Intent in = new Intent(this, LoginPage.class);
			alert = new AlertDialog.Builder(this);
			alert.setTitle("Warning!!");
			alert.setMessage("Exit atharva ?");
			alert.setPositiveButton("Exit",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {

							System.exit(0);
						}
					});

			alert.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {

						}
					});

			alert.show();

		}
		return super.onKeyDown(keyCode, event);
	}

	/****************************** ASYNCTASK ***************************************************/

	class AttemptLogin extends AsyncTask<String, String, String> {

		final Connector connector = new Connector();
		final JSONObject mJson = new JSONObject();

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progress = new ProgressDialog(LoginPage.this);
			progress.setTitle("Loading");
			progress.setMessage("Wait while loading...");
			progress.setIndeterminate(false);
			progress.setCancelable(true);
			progress.show();
		}

		@Override
		protected String doInBackground(String... args) {

			runOnUiThread(new Runnable() {

				@Override
				public void run() {

					String mEmail = mail.getText().toString();
					String mPwd = pwd.getText().toString();
					if (mail.getText().toString().matches("")
							|| pwd.getText().toString().matches("")) {
						Toast.makeText(getBaseContext(), "Fill Data",
								Toast.LENGTH_LONG).show();
					} else {

						try {
							mJson.put("email", mEmail);
							mJson.put("pwd", mPwd);

							final String json_string = mJson.toString();

							PostMan mSender = new PostMan();

							Thread thread = new Thread(new Runnable() {
								@Override
								public void run() {
									try {
										// Your code goes here
										PostMan mSender = new PostMan();
										response = mSender.post(json_string,
												connector.login);

										if (!response.contains("Failed")) {

											try {

												JSONObject object = (JSONObject) new JSONTokener(
														response).nextValue();
												String mName = object
														.getString("name");
												String mCollege = object
														.getString("college");
												String mEmail1 = object
														.getString("email");
												String mPhn = object
														.getString("phone");
												String mGender = object
														.getString("gender");
												String mPassword = object
														.getString("password");

												mName = DatabaseUtils
														.sqlEscapeString(mName);
												mCollege = DatabaseUtils
														.sqlEscapeString(mCollege);
												mEmail1 = DatabaseUtils
														.sqlEscapeString(mEmail1);
												mPhn = DatabaseUtils
														.sqlEscapeString(mPhn);
												mGender = DatabaseUtils
														.sqlEscapeString(mGender);
												mPassword = DatabaseUtils
														.sqlEscapeString(mPassword);

												db.execSQL("INSERT INTO PROFILE VALUES("
														+ mName
														+ ","
														+ mCollege
														+ ","
														+ mEmail1
														+ ","
														+ mPhn
														+ ","
														+ mGender
														+ ","
														+ mPassword + ")");
												Intent intent1 = new Intent(
														LoginPage.this,
														MainActivity.class);
												startActivity(intent1);
												finish();

											} catch (Exception e) {
												Toast.makeText(
														getBaseContext(),
														"Check Internet Availability",
														Toast.LENGTH_SHORT)
														.show();
											}

										} else {
											Toast.makeText(getBaseContext(),
													"Login Failed",
													Toast.LENGTH_LONG).show();
											mail.setText("");
											pwd.setText("");
										}
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});

							thread.start();

						} catch (JSONException e) {
							e.printStackTrace();
						}
					}

				}
			});
			return null;

		}

		protected void onPostExecute(String file_url) {
			progress.dismiss();
		}

	}
}
