package dji.thirdparty.ciphersql.database;

public abstract interface SQLiteCursorDriver
{
  public abstract void cursorClosed();
  
  public abstract void cursorDeactivated();
  
  public abstract void cursorRequeried(android.database.Cursor paramCursor);
  
  public abstract dji.thirdparty.ciphersql.Cursor query(SQLiteDatabase.CursorFactory paramCursorFactory, String[] paramArrayOfString);
  
  public abstract void setBindArguments(String[] paramArrayOfString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\SQLiteCursorDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */