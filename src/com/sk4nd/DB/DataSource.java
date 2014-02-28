package com.sk4nd.DB;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataSource {
	private static final String SCHEMA_NAME="lol";
	private MyOpenHelper oh;
	
	public DataSource(MyOpenHelper o) {
		oh=o;
	}

	
	/*INSERIMENTO DATI*/
	
	//dragon 11221 i primi due team 1 ecc, torri primo team, torri secondo team, valutazione 1 a 10 lane e jungla,
	public void inserisciScout(int id, String nome, int data, int red_or_blu, String ban11, String ban21, String ban12, String ban22,
			String ban13, String ban23, String pick1, String pick2, int fb_team, int fb_time, int dragon, int baron, int torri1, 
			int torri2, int time, int t_gold, double t_kda, int laning_phase, String mvp, int vision, int val_team_comp, int val_esec, 
			int comunicazione) {
		SQLiteDatabase db=oh.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put("id", id);
		values.put("nome", nome);
		values.put("data", data);
		values.put("red_or_blu", red_or_blu);
		values.put("ban11", ban11);
		values.put("ban21", ban21);
		values.put("ban12", ban12);
		values.put("ban22", ban22);
		values.put("ban13", ban23);
		values.put("pick1", pick1);
		values.put("pick2", pick2);
		values.put("fb_team", fb_team);
		values.put("fb_time", fb_time);
		values.put("dragon", dragon);
		values.put("baron", baron);
		values.put("torri1", torri2);
		values.put("time", time);
		values.put("t_gold", t_gold);
		values.put("t_kda", t_kda);
		values.put("laning_phase", laning_phase);
		values.put("mvp", mvp);
		values.put("vision", vision);
		values.put("val_team_comp", val_team_comp);
		values.put("val_esec", val_esec);
		values.put("comunicazione", comunicazione);
		db.insert(SCHEMA_NAME+".lists", null, values);
	}
	
	public void inserisciPerMemeberStat(String nome, String ruolo, String champion, int kill, int death, int assist, int gold, double gpm) {
		SQLiteDatabase db=oh.getWritableDatabase();
		String create="CREATE TABLE "+SCHEMA_NAME+"."+nome+"(ruolo TEXT, champion TEXT, kill INT, death INT, assist INT, gold INT, " +
				"gpm REAL);";
		db.execSQL(create);
		
		ContentValues values=new ContentValues();
		values.put("ruolo", ruolo);
		values.put("champion", champion);
		values.put("kill", kill);
		values.put("death", death);
		values.put("assist", assist);
		values.put("gold", gold);
		values.put("gpm", gpm);
		db.insert(SCHEMA_NAME+"."+nome, null, values);
	}
	
	
	/*QUERY*/
	
	public Cursor lista() {
		SQLiteDatabase db=oh.getReadableDatabase();
		Cursor cu;
		cu=(db.query(SCHEMA_NAME+".lists", null, null, null, null, null, null, null));
		return cu;
	}
}
