package dji.thirdparty.ciphersql.database;

import android.content.Context;
import dji.thirdparty.ciphersql.DatabaseErrorHandler;
import dji.thirdparty.ciphersql.DefaultDatabaseErrorHandler;

public abstract class SQLiteOpenHelper
{
  private static final String TAG = SQLiteOpenHelper.class.getSimpleName();
  private final Context mContext;
  private SQLiteDatabase mDatabase = null;
  private final DatabaseErrorHandler mErrorHandler;
  private final SQLiteDatabase.CursorFactory mFactory;
  private final SQLiteDatabaseHook mHook;
  private boolean mIsInitializing = false;
  private final String mName;
  private final int mNewVersion;
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, null, new DefaultDatabaseErrorHandler());
  }
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    this(paramContext, paramString, paramCursorFactory, paramInt, paramSQLiteDatabaseHook, new DefaultDatabaseErrorHandler());
  }
  
  public SQLiteOpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramInt >= 1)
    {
      if (paramDatabaseErrorHandler != null)
      {
        this.mContext = paramContext;
        this.mName = paramString;
        this.mFactory = paramCursorFactory;
        this.mNewVersion = paramInt;
        this.mHook = paramSQLiteDatabaseHook;
        this.mErrorHandler = paramDatabaseErrorHandler;
        return;
      }
      throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
    }
    paramContext = new StringBuilder();
    paramContext.append("Version must be >= 1, was ");
    paramContext.append(paramInt);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public SQLiteDatabase getReadableDatabase(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    try
    {
      paramString = paramString.toCharArray();
      paramString = getReadableDatabase(paramString);
      return paramString;
    }
    finally {}
  }
  
  public SQLiteDatabase getReadableDatabase(char[] paramArrayOfChar)
  {
    return null;
  }
  
  public SQLiteDatabase getWritableDatabase(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    try
    {
      paramString = paramString.toCharArray();
      paramString = getWritableDatabase(paramString);
      return paramString;
    }
    finally {}
  }
  
  public SQLiteDatabase getWritableDatabase(char[] paramArrayOfChar)
  {
    return null;
  }
  
  public abstract void onCreate(SQLiteDatabase paramSQLiteDatabase);
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase) {}
  
  public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\SQLiteOpenHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */