package dji.thirdparty.ciphersql.database;

public class DatabaseObjectNotClosedException
  extends RuntimeException
{
  private static final String s = "Application did not close the cursor or database object that was opened here";
  
  public DatabaseObjectNotClosedException()
  {
    super("Application did not close the cursor or database object that was opened here");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\DatabaseObjectNotClosedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */