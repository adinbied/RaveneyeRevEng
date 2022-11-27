package dji.midware.data.packages.litchis;

import dji.midware.util.BytesUtil;

public class FileSendPack
  extends FilePack
{
  /* Error */
  public void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void doPackFixSession()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return BytesUtil.byte2hex(this.buffer);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\packages\litchis\FileSendPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */