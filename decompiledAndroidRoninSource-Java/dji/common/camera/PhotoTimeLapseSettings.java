package dji.common.camera;

public class PhotoTimeLapseSettings
{
  private int duration;
  private SettingsDefinitions.PhotoTimeLapseFileFormat fileFormat = SettingsDefinitions.PhotoTimeLapseFileFormat.UNKNOWN;
  private int interval;
  
  public PhotoTimeLapseSettings(int paramInt1, int paramInt2, SettingsDefinitions.PhotoTimeLapseFileFormat paramPhotoTimeLapseFileFormat)
  {
    this.interval = paramInt1;
    this.duration = paramInt2;
    this.fileFormat = paramPhotoTimeLapseFileFormat;
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  public SettingsDefinitions.PhotoTimeLapseFileFormat getFileFormat()
  {
    return this.fileFormat;
  }
  
  public int getInterval()
  {
    return this.interval;
  }
  
  public void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public void setFileFormat(SettingsDefinitions.PhotoTimeLapseFileFormat paramPhotoTimeLapseFileFormat)
  {
    this.fileFormat = paramPhotoTimeLapseFileFormat;
  }
  
  public void setInterval(int paramInt)
  {
    this.interval = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\camera\PhotoTimeLapseSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */