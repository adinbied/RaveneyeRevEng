package dji.midware.media.HD;

import dji.logic.album.manager.litchis.DJIFileType;
import java.util.Date;

public class DJIClipInfo
{
  public int clipNo;
  public int commitID;
  private Date downloadTime = null;
  public int endTimeMSec;
  public DJIFileType fileType;
  public long source_uuid;
  public int startTimeMSec;
  public String targetPath;
  public TranscodeState transcodeState;
  
  private String getExt()
  {
    return null;
  }
  
  public Date getDownloadTime()
  {
    return null;
  }
  
  public String getNameKey()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static enum TranscodeState
  {
    private int data;
    
    static
    {
      INVALID_PARAM = new TranscodeState("INVALID_PARAM", 2, 2);
      ERR_INCOMPLETE = new TranscodeState("ERR_INCOMPLETE", 3, 3);
      ERR_UNSPECIFIED = new TranscodeState("ERR_UNSPECIFIED", 4, 4);
      TranscodeState localTranscodeState = new TranscodeState("UNKNOWN", 5, -1);
      UNKNOWN = localTranscodeState;
      $VALUES = new TranscodeState[] { SUECCESS, UNDO, INVALID_PARAM, ERR_INCOMPLETE, ERR_UNSPECIFIED, localTranscodeState };
    }
    
    private TranscodeState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TranscodeState find(int paramInt)
    {
      TranscodeState localTranscodeState = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTranscodeState;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\HD\DJIClipInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */