package dji.midware.sockets.pub;

public class SysRcvBufferBean
{
  private static SysRcvBufferBean instance;
  private byte[] fullBuffer = new byte[0];
  
  public static SysRcvBufferBean getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new SysRcvBufferBean();
      }
      SysRcvBufferBean localSysRcvBufferBean = instance;
      return localSysRcvBufferBean;
    }
    finally {}
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public byte[] get()
  {
    try
    {
      byte[] arrayOfByte = this.fullBuffer;
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void put(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void remove(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\sockets\pub\SysRcvBufferBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */