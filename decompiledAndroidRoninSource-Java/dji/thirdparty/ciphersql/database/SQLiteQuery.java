package dji.thirdparty.ciphersql.database;

import dji.thirdparty.ciphersql.CursorWindow;

public class SQLiteQuery
  extends SQLiteProgram
{
  private static final String TAG = "Cursor";
  private String[] mBindArgs;
  private Object[] mObjectBindArgs;
  private int mOffsetIndex;
  
  SQLiteQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    super(paramSQLiteDatabase, paramString);
    this.mOffsetIndex = paramInt;
    this.mObjectBindArgs = paramArrayOfObject;
    if (paramArrayOfObject != null) {
      paramInt = paramArrayOfObject.length;
    } else {
      paramInt = 0;
    }
    this.mBindArgs = new String[paramInt];
  }
  
  SQLiteQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt, String[] paramArrayOfString)
  {
    super(paramSQLiteDatabase, paramString);
    this.mOffsetIndex = paramInt;
    this.mBindArgs = paramArrayOfString;
  }
  
  private final native int native_column_count();
  
  private final native String native_column_name(int paramInt);
  
  private final native int native_fill_window(CursorWindow paramCursorWindow, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  /* Error */
  public void bindArguments(Object[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void bindDouble(int arg1, double arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void bindLong(int arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void bindNull(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void bindString(int arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  int columnCountLocked()
  {
    return 0;
  }
  
  String columnNameLocked(int paramInt)
  {
    acquireReference();
    try
    {
      String str = native_column_name(paramInt);
      return str;
    }
    finally
    {
      releaseReference();
    }
  }
  
  int fillWindow(CursorWindow paramCursorWindow, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  /* Error */
  void requery()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\SQLiteQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */