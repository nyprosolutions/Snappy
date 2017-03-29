package com.appcypher.bad.snappy;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.Spinner;

public class SnappyActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Spinners
		Spinner languageSpinner = (Spinner) findViewById(R.id.language_spinner);
		Spinner dateFormatSpinner = (Spinner) findViewById(R.id.date_format_spinner);
		Spinner timeFormatSpinner = (Spinner) findViewById(R.id.time_format_spinner);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.language_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		languageSpinner.setAdapter(adapter);

		adapter = ArrayAdapter.createFromResource(this,
				R.array.date_format_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		dateFormatSpinner.setAdapter(adapter);

		adapter = ArrayAdapter.createFromResource(this,
				R.array.time_format_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		timeFormatSpinner.setAdapter(adapter);

		// OnClicks
		ImageView mock = (ImageView) findViewById(R.id.digital_mock);
		mock.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mockClicked(view);
			}
		});

		mock = (ImageView) findViewById(R.id.regular_mock);
		mock.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mockClicked(view);
			}
		});

		mock = (ImageView) findViewById(R.id.classic_mock);
		mock.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mockClicked(view);
			}
		});

		mock = (ImageView) findViewById(R.id.goofy_mock);
		mock.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mockClicked(view);
			}
		});
	}

	public void mockClicked(View view){
		RemoteViews remoteViews;
		ComponentName comp = new ComponentName(this, SnappyClock.class);

		Intent configIntent = new Intent(this, SnappyActivity.class);
		PendingIntent configPendingIntent = PendingIntent.getActivity(this, 0, configIntent, 0);

		AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.getApplicationContext());
		switch(view.getId()) {
			case R.id.digital_mock:
				remoteViews = new RemoteViews
					(this.getApplicationContext().getPackageName(), R.layout.digital_clock_layout);
				remoteViews.setOnClickPendingIntent(R.id.digital_clock, configPendingIntent);
				appWidgetManager.updateAppWidget(comp, remoteViews);
				break;

			case R.id.regular_mock:
				remoteViews = new RemoteViews
						(this.getApplicationContext().getPackageName(), R.layout.regular_clock_layout);
				remoteViews.setOnClickPendingIntent(R.id.digital_clock, configPendingIntent);
				appWidgetManager.updateAppWidget(comp, remoteViews);
				break;

			case R.id.classic_mock:
				remoteViews = new RemoteViews
						(this.getApplicationContext().getPackageName(), R.layout.classic_clock_layout);
				remoteViews.setOnClickPendingIntent(R.id.digital_clock, configPendingIntent);
				appWidgetManager.updateAppWidget(comp, remoteViews);
				break;

			case R.id.goofy_mock:
				break;
		}
	}
}
