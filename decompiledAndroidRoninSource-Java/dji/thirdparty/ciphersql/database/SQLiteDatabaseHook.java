package dji.thirdparty.ciphersql.database;

public abstract interface SQLiteDatabaseHook
{
  public abstract void postKey(SQLiteDatabase paramSQLiteDatabase);
  
  public abstract void preKey(SQLiteDatabase paramSQLiteDatabase);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\SQLiteDatabaseHook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */