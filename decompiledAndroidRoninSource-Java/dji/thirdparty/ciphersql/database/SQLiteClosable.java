package dji.thirdparty.ciphersql.database;

public abstract class SQLiteClosable
{
  private Object mLock = new Object();
  private int mReferenceCount = 1;
  
  private String getObjInfo()
  {
    return null;
  }
  
  /* Error */
  public void acquireReference()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected abstract void onAllReferencesReleased();
  
  protected void onAllReferencesReleasedFromContainer() {}
  
  /* Error */
  public void releaseReference()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void releaseReferenceFromContainer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\SQLiteClosable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */