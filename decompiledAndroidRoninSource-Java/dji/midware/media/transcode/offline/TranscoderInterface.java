package dji.midware.media.transcode.offline;

public abstract interface TranscoderInterface
{
  public abstract int getCurProgress();
  
  public abstract String getInputFileName();
  
  public abstract boolean isTranscoding();
  
  public abstract void onDestroy();
  
  public abstract void rebindListener(TranscoderListener paramTranscoderListener);
  
  public abstract void start(String paramString1, String paramString2, TranscoderListener paramTranscoderListener);
  
  public abstract void stop();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\offline\TranscoderInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */