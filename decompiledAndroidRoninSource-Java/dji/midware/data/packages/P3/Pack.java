package dji.midware.data.packages.P3;

public abstract class Pack
{
  protected String TAG = getClass().getSimpleName();
  public byte[] buffer;
  public int ccode;
  public int cmdId;
  public int cmdSet;
  public int cmdType;
  protected int crc16;
  protected int crc8;
  public byte[] data;
  public int encryptType;
  public int isNeedAck;
  protected int length;
  public int receiverId;
  public int receiverType;
  public int senderId;
  public int senderType;
  public int seq;
  protected byte sof = 85;
  public int version = 1;
  
  public int getLength()
  {
    return this.length;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\packages\P3\Pack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */