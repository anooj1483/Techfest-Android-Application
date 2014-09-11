package atharva.cemp.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import tech.cemp.atharva14.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

public class DashBoard extends Activity {
	SQLiteDatabase db = null;
	String name, college, mail, phn, gndr, pwd;
	TextView mNmae, mCollege, mMail, mPhn, mGndr, mPwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dash);

		mNmae = (TextView) findViewById(R.id.name);
		mCollege = (TextView) findViewById(R.id.clg);

		mMail = (TextView) findViewById(R.id.email);

		mPhn = (TextView) findViewById(R.id.phn);

		mGndr = (TextView) findViewById(R.id.gender);
		// mPwd=(TextView)findViewById(R.id.password);*/

		db = openOrCreateDatabase("Atharva.db", MODE_PRIVATE, null);
		Cursor c = db.rawQuery("SELECT * FROM PROFILE", null);
		if (c != null) {
			if (c.moveToFirst()) {

				name = c.getString(c.getColumnIndex("NAME"));

				college = c.getString(c.getColumnIndex("COLLEGE"));
				mail = c.getString(c.getColumnIndex("EMAIL"));
				phn = c.getString(c.getColumnIndex("PHONE"));
				gndr = c.getString(c.getColumnIndex("GENDER"));
				pwd = c.getString(c.getColumnIndex("PASSWORD"));
				System.out.println("NAMEE:  " + name + mail + phn + gndr + pwd);

			}
			mNmae.setText(name);
			mCollege.setText(college);
			mMail.setText(mail);
			mPhn.setText(phn);

			// mPwd.setText(pwd);
			if (gndr.contains("M")) {
				mGndr.setText("Male");
			} else
				mGndr.setText("Female");
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			AlertDialog.Builder alert;
			final Intent in = new Intent(this, LoginPage.class);
			alert = new AlertDialog.Builder(this);
			alert.setTitle("Warning!!");
			alert.setMessage("Logout ?");
			alert.setPositiveButton("Logout",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							db.execSQL("delete from PROFILE");
							startActivity(in);
							finish();
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
}
