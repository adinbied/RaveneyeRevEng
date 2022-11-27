package dji.thirdparty.ciphersql.database;

import android.util.Log;

public abstract class SQLiteProgram
  extends SQLiteClosable
{
  private static final String TAG = "SQLiteProgram";
  boolean mClosed = false;
  private SQLiteCompiledSql mCompiledSql;
  @Deprecated
  protected SQLiteDatabase mDatabase;
  final String mSql;
  @Deprecated
  protected long nHandle = 0L;
  @Deprecated
  protected long nStatement = 0L;
  
  SQLiteProgram(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    this.mDatabase = paramSQLiteDatabase;
    this.mSql = paramString.trim();
    paramSQLiteDatabase.acquireReference();
    paramSQLiteDatabase.addSQLiteClosable(this);
    this.nHandle = paramSQLiteDatabase.mNativeHandle;
    if (this.mSql.length() >= 6) {
      localObject = this.mSql.substring(0, 6);
    } else {
      localObject = this.mSql;
    }
    if ((!((String)localObject).equalsIgnoreCase("INSERT")) && (!((String)localObject).equalsIgnoreCase("UPDATE")) && (!((String)localObject).equalsIgnoreCase("REPLAC")) && (!((String)localObject).equalsIgnoreCase("DELETE")) && (!((String)localObject).equalsIgnoreCase("SELECT")))
    {
      paramSQLiteDatabase = new SQLiteCompiledSql(paramSQLiteDatabase, paramString);
      this.mCompiledSql = paramSQLiteDatabase;
      this.nStatement = paramSQLiteDatabase.nStatement;
      return;
    }
    Object localObject = paramSQLiteDatabase.getCompiledStatementForSql(paramString);
    this.mCompiledSql = ((SQLiteCompiledSql)localObject);
    if (localObject == null)
    {
      localObject = new SQLiteCompiledSql(paramSQLiteDatabase, paramString);
      this.mCompiledSql = ((SQLiteCompiledSql)localObject);
      ((SQLiteCompiledSql)localObject).acquire();
      paramSQLiteDatabase.addToCompiledQueries(paramString, this.mCompiledSql);
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        paramSQLiteDatabase = new StringBuilder();
        paramSQLiteDatabase.append("Created DbObj (id#");
        paramSQLiteDatabase.append(this.mCompiledSql.nStatement);
        paramSQLiteDatabase.append(") for sql: ");
        paramSQLiteDatabase.append(paramString);
        Log.v("SQLiteProgram", paramSQLiteDatabase.toString());
      }
    }
    else if (!((SQLiteCompiledSql)localObject).acquire())
    {
      long l = this.mCompiledSql.nStatement;
      this.mCompiledSql = new SQLiteCompiledSql(paramSQLiteDatabase, paramString);
      if (SQLiteDebug.DEBUG_ACTIVE_CURSOR_FINALIZATION)
      {
        paramSQLiteDatabase = new StringBuilder();
        paramSQLiteDatabase.append("** possible bug ** Created NEW DbObj (id#");
        paramSQLiteDatabase.append(this.mCompiledSql.nStatement);
        paramSQLiteDatabase.append(") because the previously created DbObj (id#");
        paramSQLiteDatabase.append(l);
        paramSQLiteDatabase.append(") was not released for sql:");
        paramSQLiteDatabase.append(paramString);
        Log.v("SQLiteProgram", paramSQLiteDatabase.toString());
      }
    }
    this.nStatement = this.mCompiledSql.nStatement;
  }
  
  private final native void native_clear_bindings();
  
  /* Error */
  private void releaseCompiledSqlIfNotInCache()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void bindBlob(int arg1, byte[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void bindDouble(int arg1, double arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: return
  }
  
  /* Error */
  public void bindLong(int arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: return
  }
  
  /* Error */
  public void bindNull(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void bindString(int arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void clearBindings()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  @Deprecated
  protected void compile(String paramString, boolean paramBoolean) {}
  
  String getSqlString()
  {
    return this.mSql;
  }
  
  public final long getUniqueId()
  {
    return this.nStatement;
  }
  
  protected final native void native_bind_blob(int paramInt, byte[] paramArrayOfByte);
  
  protected final native void native_bind_double(int paramInt, double paramDouble);
  
  protected final native void native_bind_long(int paramInt, long paramLong);
  
  protected final native void native_bind_null(int paramInt);
  
  protected final native void native_bind_string(int paramInt, String paramString);
  
  @Deprecated
  protected final native void native_compile(String paramString);
  
  @Deprecated
  protected final native void native_finalize();
  
  /* Error */
  protected void onAllReferencesReleased()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onAllReferencesReleasedFromContainer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\SQLiteProgram.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */