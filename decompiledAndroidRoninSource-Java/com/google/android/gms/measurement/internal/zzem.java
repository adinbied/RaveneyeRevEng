package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;

final class zzem
  extends SQLiteOpenHelper
{
  zzem(zzen paramzzen, Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 1);
  }
  
  public final SQLiteDatabase getWritableDatabase()
    throws SQLiteException
  {
    try
    {
      localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteDatabaseLockedException localSQLiteDatabaseLockedException)
    {
      SQLiteDatabase localSQLiteDatabase;
      throw localSQLiteDatabaseLockedException;
    }
    catch (SQLiteException localSQLiteException2)
    {
      for (;;) {}
    }
    this.zza.zzq().zze().zza("Opening the local database failed, dropping and recreating it");
    if (!this.zza.zzm().getDatabasePath("google_app_measurement_local.db").delete()) {
      this.zza.zzq().zze().zza("Failed to delete corrupted local db file", "google_app_measurement_local.db");
    }
    try
    {
      localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException1)
    {
      this.zza.zzq().zze().zza("Failed to open local database. Events will bypass local storage", localSQLiteException1);
      return null;
    }
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    zzag.zza(this.zza.zzq(), paramSQLiteDatabase);
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    zzag.zza(this.zza.zzq(), paramSQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */