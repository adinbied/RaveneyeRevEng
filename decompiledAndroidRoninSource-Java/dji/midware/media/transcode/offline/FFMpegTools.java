package dji.midware.media.transcode.offline;

public abstract interface FFMpegTools
{
  public abstract double h264ToMp4ConvertorGetProgress();
  
  public abstract void h264ToMp4ConvertorInit();
  
  public abstract int h264ToMp4ConvertorStart(String paramString1, String paramString2, int paramInt);
  
  public abstract void h264ToMp4ConvertorStop();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\offline\FFMpegTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */