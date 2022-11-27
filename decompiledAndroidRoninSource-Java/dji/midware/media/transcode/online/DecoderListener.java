package dji.midware.media.transcode.online;

public abstract interface DecoderListener
{
  public abstract void feedRawFrame(Frame paramFrame);
  
  public abstract Frame getRawFrameContainer();
  
  public abstract boolean needMakeIFrame(long paramLong);
  
  public abstract void onColorFormatChanged(int paramInt);
  
  public abstract void onSpsPpsChanged(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, int paramInt3);
  
  public abstract void onWidthHeightChanged(int paramInt1, int paramInt2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\online\DecoderListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */