package dji.midware.media.player;

public abstract interface DJIMediaPlayerInterface
{
  public abstract int getCurrentPosition();
  
  public abstract int getDuration();
  
  public abstract boolean isPaused();
  
  public abstract boolean isPlaying();
  
  public abstract void pause();
  
  public abstract void prepare();
  
  public abstract void release();
  
  public abstract void reset();
  
  public abstract void seekTo(long paramLong);
  
  public abstract void setAudioStreamType(int paramInt);
  
  public abstract void setDataSource(String paramString);
  
  public abstract void setDisplay(Object paramObject);
  
  public abstract void setOnCompletionListener(OnCompletionListener paramOnCompletionListener);
  
  public abstract void setOnSeekCompleteListener(OnSeekCompleteListener paramOnSeekCompleteListener);
  
  public abstract void start();
  
  public abstract void stop();
  
  public static abstract interface OnCompletionListener
  {
    public abstract void onCompletion(DJIMediaPlayerInterface paramDJIMediaPlayerInterface);
  }
  
  public static abstract interface OnSeekCompleteListener
  {
    public abstract void onSeekComplete(DJIMediaPlayerInterface paramDJIMediaPlayerInterface);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\player\DJIMediaPlayerInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */