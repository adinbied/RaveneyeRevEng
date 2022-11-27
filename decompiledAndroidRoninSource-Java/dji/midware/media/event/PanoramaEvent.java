package dji.midware.media.event;

public class PanoramaEvent
{
  public String path;
  public int progress;
  public PanoramaType type;
  
  public static enum PanoramaType
  {
    static
    {
      Finish = new PanoramaType("Finish", 1);
      Failure = new PanoramaType("Failure", 2);
      Progress = new PanoramaType("Progress", 3);
      DownloadSuccess = new PanoramaType("DownloadSuccess", 4);
      DownloadStart = new PanoramaType("DownloadStart", 5);
      DownloadFailure = new PanoramaType("DownloadFailure", 6);
      PanoramaType localPanoramaType = new PanoramaType("Other", 7);
      Other = localPanoramaType;
      $VALUES = new PanoramaType[] { Start, Finish, Failure, Progress, DownloadSuccess, DownloadStart, DownloadFailure, localPanoramaType };
    }
    
    private PanoramaType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\event\PanoramaEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */