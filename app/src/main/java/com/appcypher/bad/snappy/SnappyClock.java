package com.appcypher.bad.snappy;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by Nypro on 24-Mar-17.
 */

public class SnappyClock extends AppWidgetProvider {
	RemoteViews views;
	Context context;
	AppWidgetManager appWidgetManager;
	int[] appWidgetIds;

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		this.context = context;
		this.appWidgetManager = appWidgetManager;
		this.appWidgetIds = appWidgetIds;

		views = new RemoteViews(context.getPackageName(), R.layout.regular_clock_layout);

		Intent configIntent = new Intent(context, SnappyActivity.class);
		PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);

		views.setOnClickPendingIntent(R.id.digital_clock, configPendingIntent);
		appWidgetManager.updateAppWidget(appWidgetIds, views);
	}
}
