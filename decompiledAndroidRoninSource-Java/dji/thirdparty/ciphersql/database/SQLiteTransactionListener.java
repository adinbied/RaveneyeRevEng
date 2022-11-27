package dji.thirdparty.ciphersql.database;

public abstract interface SQLiteTransactionListener
{
  public abstract void onBegin();
  
  public abstract void onCommit();
  
  public abstract void onRollback();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\SQLiteTransactionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */