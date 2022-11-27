package dji.midware.media.transcode.offline;

public abstract interface TranscoderListener
{
  public abstract void onFailure(Exception paramException);
  
  public abstract void onProgress(int paramInt);
  
  public abstract void onStart();
  
  public abstract void onSuccess();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\offline\TranscoderListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */