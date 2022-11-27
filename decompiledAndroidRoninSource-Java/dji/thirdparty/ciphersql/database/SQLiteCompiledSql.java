package dji.thirdparty.ciphersql.database;

class SQLiteCompiledSql
{
  private static final String TAG = "SQLiteCompiledSql";
  SQLiteDatabase mDatabase;
  private boolean mInUse = false;
  private String mSqlStmt = null;
  private Throwable mStackTrace = null;
  long nHandle = 0L;
  long nStatement = 0L;
  
  SQLiteCompiledSql(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    if (paramSQLiteDatabase.isOpen())
    {
      this.mDatabase = paramSQLiteDatabase;
      this.mSqlStmt = paramString;
      this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
      this.nHandle = paramSQLiteDatabase.mNativeHandle;
      compile(paramString, true);
      return;
    }
    paramString = new StringBuilder();
    paramString.append("database ");
    paramString.append(paramSQLiteDatabase.getPath());
    paramString.append(" already closed");
    throw new IllegalStateException(paramString.toString());
  }
  
  /* Error */
  private void compile(String arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private final native void native_compile(String paramString);
  
  private final native void native_finalize();
  
  boolean acquire()
  {
    return false;
  }
  
  /* Error */
  protected void finalize()
    throws Throwable
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void releaseSqlStatement()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\SQLiteCompiledSql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */