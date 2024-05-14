package com.pushwoosh.sample;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.pushwoosh.Pushwoosh;

public class MainActivity extends AppCompatActivity {

@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Pushwoosh.getInstance().registerForPushNotifications();

	// Button getPushToken
	Button getpushtoken = (Button) findViewById(R.id.getpushtoken);
	getpushtoken.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			Pushwoosh.getInstance().getPushToken();
			showAlertDialog();
		}

		private void showAlertDialog() {
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			builder.setTitle("Your Token");
			builder.setMessage(Pushwoosh.getInstance().getPushToken());
			builder.create().show();
		}
	});
	// Button getHWID
	Button gethwid = (Button) findViewById(R.id.gethwid);
	gethwid.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			Pushwoosh.getInstance().getHwid();
			showAlertDialog();
		}

		private void showAlertDialog() {
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			builder.setTitle("Your HWID");
			builder.setMessage(Pushwoosh.getInstance().getHwid());
			builder.create().show();
		}
	});

	// Button setUserId
		Button setUserIdButton = findViewById(R.id.setuseridbtn);
		EditText userIdEditText = findViewById(R.id.setuseridtext);

		setUserIdButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Get the text from the EditText
				String userId = userIdEditText.getText().toString();

				// Call setUserId method with the retrieved text
				Pushwoosh.getInstance().setUserId(userId);
			}
		});

	// Button postEvent
	/*
	Button postEventButton = findViewById(R.id.posteventbtn);
	EditText postEventEditText = findViewById(R.id.posteventtext);

	postEventButton.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// Get the text from the EditText
			String event = postEventEditText.getText().toString();

			// Call postEvent method with the retrieved text
			Pushwoosh.getInstance().postEvent(event);
		}
	});
	*/

	// Button getTags
	/*
	Button gettags = (Button) findViewById(R.id.gettags);
	gettags.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			Pushwoosh.getInstance().getTags();
			showAlertDialog();
		}

		private void showAlertDialog() {
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			builder.setTitle("Your Tags:");
			builder.setMessage(Pushwoosh.getInstance().getTags());
			builder.create().show();
		}
	});
	*/

	}
}
