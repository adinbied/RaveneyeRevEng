package dji.midware.data.packages.P3;

import dji.midware.data.config.P3.CmdSet;
import dji.midware.util.BytesUtil;

public class RecvPack
  extends Pack
{
  public CmdSet cmdSetObj;
  byte[] crcByte = new byte[4];
  public boolean isNeedCcode = true;
  private byte[] seqByte = new byte[4];
  
  public RecvPack(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < 13) {
        return;
      }
      this.buffer = paramArrayOfByte;
      this.sof = paramArrayOfByte[0];
      int i = BytesUtil.getShort(paramArrayOfByte, 1);
      this.version = (i >> 10);
      this.length = (i & 0x3FF);
      this.crc8 = paramArrayOfByte[3];
      this.senderId = (getInt(4) >> 5);
      this.senderType = (getInt(4) & 0x1F);
      this.receiverId = (getInt(5) >> 5);
      this.receiverType = (getInt(5) & 0x1F);
      byte[] arrayOfByte = this.seqByte;
      arrayOfByte[0] = paramArrayOfByte[6];
      arrayOfByte[1] = paramArrayOfByte[7];
      this.seq = BytesUtil.getInt(arrayOfByte);
      this.cmdType = (getInt(8) >> 7);
      this.isNeedAck = (0x3 & getInt(8) >> 5);
      this.encryptType = (0x7 & getInt(8));
      this.cmdSet = getInt(9);
      this.cmdId = getInt(10);
      int j = 11;
      isNeedCcode();
      i = j;
      if (this.cmdType == 1)
      {
        i = j;
        if (this.isNeedCcode)
        {
          this.ccode = getInt(11);
          i = 12;
        }
      }
      j = paramArrayOfByte.length - i - 2;
      if (j > 0)
      {
        this.data = new byte[j];
        System.arraycopy(paramArrayOfByte, i, this.data, 0, j);
      }
      arrayOfByte = this.crcByte;
      arrayOfByte[0] = paramArrayOfByte[(paramArrayOfByte.length - 2)];
      arrayOfByte[1] = paramArrayOfByte[(paramArrayOfByte.length - 1)];
      this.crc16 = BytesUtil.getInt(this.seqByte);
    }
  }
  
  private int getInt(int paramInt)
  {
    return 0;
  }
  
  /* Error */
  private void isNeedCcode()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\packages\P3\RecvPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */