package dji.thirdparty.ciphersql.database;

public class SQLiteDirectCursorDriver
  implements SQLiteCursorDriver
{
  private dji.thirdparty.ciphersql.Cursor mCursor;
  private SQLiteDatabase mDatabase;
  private String mEditTable;
  private SQLiteQuery mQuery;
  private String mSql;
  
  public SQLiteDirectCursorDriver(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mEditTable = paramString2;
    this.mSql = paramString1;
  }
  
  public void cursorClosed()
  {
    this.mCursor = null;
  }
  
  public void cursorDeactivated() {}
  
  public void cursorRequeried(android.database.Cursor paramCursor) {}
  
  public dji.thirdparty.ciphersql.Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, Object[] paramArrayOfObject)
  {
    return null;
  }
  
  public dji.thirdparty.ciphersql.Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, String[] paramArrayOfString)
  {
    return null;
  }
  
  /* Error */
  public void setBindArguments(String[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\SQLiteDirectCursorDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */