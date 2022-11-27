package dji.midware.media.mp4;

public class MP4Box
{
  public static final String TAG = MP4Box.class.getName();
  public byte[] box_data;
  public int box_size;
  public String box_type;
  public int length = 0;
  public int start_offset;
  public MP4BoxType type = MP4BoxType.OTHER;
  
  public MP4Box() {}
  
  public MP4Box(MP4BoxType paramMP4BoxType, int paramInt)
  {
    this.type = paramMP4BoxType;
    this.length = paramInt;
  }
  
  public boolean parseData(byte[] paramArrayOfByte, int paramInt)
  {
    this.start_offset = paramInt;
    this.box_size = MP4BytesUtil.getInt(paramArrayOfByte, 0);
    paramArrayOfByte = MP4BytesUtil.getStringUTF8(paramArrayOfByte, 4, 4);
    this.box_type = paramArrayOfByte;
    this.type = MP4BoxType.find(paramArrayOfByte);
    this.length = this.box_size;
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\mp4\MP4Box.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */