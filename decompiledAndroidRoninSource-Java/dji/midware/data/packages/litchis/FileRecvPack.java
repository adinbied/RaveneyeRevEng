package dji.midware.data.packages.litchis;

import dji.midware.util.BytesUtil;

public class FileRecvPack
  extends FilePack
{
  public int dataLen;
  
  public FileRecvPack(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < 10) {
        return;
      }
      this.buffer = paramArrayOfByte;
      this.version = (paramArrayOfByte[0] >> 6);
      this.length = (paramArrayOfByte[0] & 0x3F);
      this.cmdId = (paramArrayOfByte[1] >> 5);
      this.cmdType = (paramArrayOfByte[1] & 0x1F);
      int i = BytesUtil.getShort(paramArrayOfByte, 2);
      this.isLastFlag = (i >> 12);
      this.totalLength = (i & 0xFFF);
      this.sessionId = BytesUtil.getUShort(paramArrayOfByte, 4);
      this.seq = BytesUtil.getInt(paramArrayOfByte, 6);
      i = paramArrayOfByte.length - this.length;
      this.dataLen = i;
      if (i > 0)
      {
        this.data = new byte[i];
        System.arraycopy(paramArrayOfByte, this.length, this.data, 0, this.dataLen);
      }
    }
  }
  
  public String toString()
  {
    return BytesUtil.byte2hex(this.buffer);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\packages\litchis\FileRecvPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */