package dji.thirdparty.ciphersql;

public abstract class AbstractWindowedCursor
  extends AbstractCursor
{
  protected CursorWindow mWindow;
  
  /* Error */
  protected void checkPosition()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void copyStringToBuffer(int arg1, android.database.CharArrayBuffer arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public byte[] getBlob(int paramInt)
  {
    return null;
  }
  
  public double getDouble(int paramInt)
  {
    return 1.373308313E-315D;
  }
  
  public float getFloat(int paramInt)
  {
    return 0.0F;
  }
  
  public int getInt(int paramInt)
  {
    return 0;
  }
  
  public long getLong(int paramInt)
  {
    return 277960734L;
  }
  
  public short getShort(int paramInt)
  {
    return 0;
  }
  
  public String getString(int paramInt)
  {
    return null;
  }
  
  public int getType(int paramInt)
  {
    return 0;
  }
  
  public CursorWindow getWindow()
  {
    return this.mWindow;
  }
  
  public boolean hasWindow()
  {
    return this.mWindow != null;
  }
  
  public boolean isBlob(int paramInt)
  {
    return false;
  }
  
  public boolean isFloat(int paramInt)
  {
    return false;
  }
  
  public boolean isLong(int paramInt)
  {
    return false;
  }
  
  public boolean isNull(int paramInt)
  {
    return false;
  }
  
  public boolean isString(int paramInt)
  {
    return false;
  }
  
  /* Error */
  public void setWindow(CursorWindow arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\AbstractWindowedCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */