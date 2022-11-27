package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

final class SchemaManager
  extends SQLiteOpenHelper
{
  private static final String CREATE_CONTEXTS_SQL_V1 = "CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)";
  private static final String CREATE_CONTEXT_BACKEND_PRIORITY_INDEX_V1 = "CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)";
  private static final String CREATE_EVENTS_SQL_V1 = "CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)";
  private static final String CREATE_EVENT_BACKEND_INDEX_V1 = "CREATE INDEX events_backend_id on events(context_id)";
  private static final String CREATE_EVENT_METADATA_SQL_V1 = "CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)";
  private static final String CREATE_PAYLOADS_TABLE_V4 = "CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))";
  static final String DB_NAME = "com.google.android.datatransport.events";
  private static final String DROP_CONTEXTS_SQL = "DROP TABLE transport_contexts";
  private static final String DROP_EVENTS_SQL = "DROP TABLE events";
  private static final String DROP_EVENT_METADATA_SQL = "DROP TABLE event_metadata";
  private static final String DROP_PAYLOADS_SQL = "DROP TABLE IF EXISTS event_payloads";
  private static final List<Migration> INCREMENTAL_MIGRATIONS;
  private static final Migration MIGRATE_TO_V1 = ;
  private static final Migration MIGRATE_TO_V2 = SchemaManager..Lambda.2.lambdaFactory$();
  private static final Migration MIGRATE_TO_V3 = SchemaManager..Lambda.3.lambdaFactory$();
  private static final Migration MIGRATE_TO_V4;
  static int SCHEMA_VERSION = 4;
  private boolean configured = false;
  private final int schemaVersion;
  
  static
  {
    Migration localMigration = SchemaManager..Lambda.4.lambdaFactory$();
    MIGRATE_TO_V4 = localMigration;
    INCREMENTAL_MIGRATIONS = Arrays.asList(new Migration[] { MIGRATE_TO_V1, MIGRATE_TO_V2, MIGRATE_TO_V3, localMigration });
  }
  
  @Inject
  SchemaManager(Context paramContext, @Named("SQLITE_DB_NAME") String paramString, @Named("SCHEMA_VERSION") int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
    this.schemaVersion = paramInt;
  }
  
  private void ensureConfigured(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!this.configured) {
      onConfigure(paramSQLiteDatabase);
    }
  }
  
  private void onCreate(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    ensureConfigured(paramSQLiteDatabase);
    upgrade(paramSQLiteDatabase, 0, paramInt);
  }
  
  private void upgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= INCREMENTAL_MIGRATIONS.size())
    {
      while (paramInt1 < paramInt2)
      {
        ((Migration)INCREMENTAL_MIGRATIONS.get(paramInt1)).upgrade(paramSQLiteDatabase);
        paramInt1 += 1;
      }
      return;
    }
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append("Migration from ");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append(" to ");
    paramSQLiteDatabase.append(paramInt2);
    paramSQLiteDatabase.append(" was requested, but cannot be performed. Only ");
    paramSQLiteDatabase.append(INCREMENTAL_MIGRATIONS.size());
    paramSQLiteDatabase.append(" migrations are provided");
    throw new IllegalArgumentException(paramSQLiteDatabase.toString());
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    this.configured = true;
    paramSQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
    if (Build.VERSION.SDK_INT >= 16) {
      paramSQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    onCreate(paramSQLiteDatabase, this.schemaVersion);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE events");
    paramSQLiteDatabase.execSQL("DROP TABLE event_metadata");
    paramSQLiteDatabase.execSQL("DROP TABLE transport_contexts");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
    onCreate(paramSQLiteDatabase, paramInt2);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    ensureConfigured(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    ensureConfigured(paramSQLiteDatabase);
    upgrade(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public static abstract interface Migration
  {
    public abstract void upgrade(SQLiteDatabase paramSQLiteDatabase);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\scheduling\persistence\SchemaManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */