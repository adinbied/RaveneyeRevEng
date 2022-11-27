package dji.midware.media.transcode.online;

import dji.midware.media.datacontainer.DynamicByteBuffer;

public class Frame
{
  private final DynamicByteBuffer data;
  private long frameIndex;
  int height;
  private boolean isKeyFrame = false;
  public final FrameType type;
  int width;
  
  public Frame(FrameType paramFrameType, int paramInt)
  {
    this.type = paramFrameType;
    int i = 1.$SwitchMap$dji$midware$media$transcode$online$Frame$FrameType[paramFrameType.ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        this.data = new DynamicByteBuffer(paramInt, true);
        return;
      }
      this.data = null;
      throw new RuntimeException("unknown frame type");
    }
    this.data = new DynamicByteBuffer(paramInt, false);
  }
  
  /* Error */
  protected void convertRGBAtoYUVFullSwing(byte[] arg1, byte[] arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public DynamicByteBuffer getBuffer()
  {
    return this.data;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public long getIndex()
  {
    return this.frameIndex;
  }
  
  public int getSize()
  {
    return this.data.size();
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public boolean isKeyFrame()
  {
    return this.isKeyFrame;
  }
  
  public void setIndex(long paramLong)
  {
    this.frameIndex = paramLong;
  }
  
  public void setIsKeyFrame(boolean paramBoolean)
  {
    this.isKeyFrame = paramBoolean;
  }
  
  public void setResolution(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public static enum FrameType
  {
    static
    {
      FrameType localFrameType = new FrameType("H264", 1);
      H264 = localFrameType;
      $VALUES = new FrameType[] { YUV, localFrameType };
    }
    
    private FrameType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\online\Frame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */