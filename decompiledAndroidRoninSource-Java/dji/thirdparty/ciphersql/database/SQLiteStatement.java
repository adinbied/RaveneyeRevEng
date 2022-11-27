package dji.thirdparty.ciphersql.database;

public class SQLiteStatement
  extends SQLiteProgram
{
  SQLiteStatement(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    super(paramSQLiteDatabase, paramString);
  }
  
  private final native long native_1x1_long();
  
  private final native String native_1x1_string();
  
  private final native void native_execute();
  
  /* Error */
  public void execute()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public long executeInsert()
  {
    return 277961263L;
  }
  
  public int executeUpdateDelete()
  {
    return 0;
  }
  
  public long simpleQueryForLong()
  {
    return 277961297L;
  }
  
  public String simpleQueryForString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\SQLiteStatement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */