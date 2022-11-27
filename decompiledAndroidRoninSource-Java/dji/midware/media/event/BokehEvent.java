package dji.midware.media.event;

import android.graphics.Bitmap;

public class BokehEvent
{
  public static final int RESULT_DOWNLOAD_FAIL = -2;
  public Bitmap bokeh = null;
  public Bitmap depth = null;
  public Bitmap org = null;
  public String path;
  public int progress = 0;
  public int result = -2;
  public long time = 0L;
  public BokehType type = BokehType.Other;
  
  public static enum BokehType
  {
    static
    {
      Finish = new BokehType("Finish", 1);
      Failure = new BokehType("Failure", 2);
      PreprocessStart = new BokehType("PreprocessStart", 3);
      PreprocessOver = new BokehType("PreprocessOver", 4);
      PreprocessTimeout = new BokehType("PreprocessTimeout", 5);
      Refresh = new BokehType("Refresh", 6);
      Progress = new BokehType("Progress", 7);
      DownloadStart = new BokehType("DownloadStart", 8);
      DownloadFailure = new BokehType("DownloadFailure", 9);
      DownloadSuccess = new BokehType("DownloadSuccess", 10);
      BokehType localBokehType = new BokehType("Other", 11);
      Other = localBokehType;
      $VALUES = new BokehType[] { Start, Finish, Failure, PreprocessStart, PreprocessOver, PreprocessTimeout, Refresh, Progress, DownloadStart, DownloadFailure, DownloadSuccess, localBokehType };
    }
    
    private BokehType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\event\BokehEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */