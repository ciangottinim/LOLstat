package com.sk4nd.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {
	private static final String SCHEMA_NAME="lol";
	private static final String DATABASE_NAME="db_lol";
	private static final int DATABASE_VERSION=1;
	
	
	public MyOpenHelper(Context c) {
		super(c,DATABASE_NAME,null,DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {		//red_or_blu: 1 blu, 2 red | dragon 1121 1 team 2 altro team
		String create="CREATE TABLE "+SCHEMA_NAME+".lists(id INT, nome TEXT, data INT, red_or_blu TEXT, ban11 TEXT, ban21 TEXT, " +
				"ban12 TEXT, ban22 TEXT, ban13 TEXT, ban23 TEXT, pick1 TEXT, pick2 TEXT, fb_team INT, fb_time INT, dragon INT, baron INT, " +
				"torri1 INT, torri2 INT, time INT, t_gold INT, t_kda REAL" +
				"laning_phase INT, mvp TEXT, vision INT, val_team_comp INT, val_esec INT, comunicazione INT);";
		db.execSQL(create);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS EVENTI");
		onCreate(db);
	}
}