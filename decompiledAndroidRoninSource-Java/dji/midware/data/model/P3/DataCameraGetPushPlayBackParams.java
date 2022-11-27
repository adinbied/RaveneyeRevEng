package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataCameraGetPushPlayBackParams
  extends DataBase
{
  private static DataCameraGetPushPlayBackParams instance;
  
  public static DataCameraGetPushPlayBackParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCameraGetPushPlayBackParams();
      }
      DataCameraGetPushPlayBackParams localDataCameraGetPushPlayBackParams = instance;
      return localDataCameraGetPushPlayBackParams;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public int getCenterX()
  {
    return 0;
  }
  
  public int getCenterY()
  {
    return 0;
  }
  
  public int getCurrent()
  {
    return 0;
  }
  
  public int getCurrentForKumquat()
  {
    return 0;
  }
  
  public DelFileStatus getDelFileStatus()
  {
    return null;
  }
  
  public int getDeleteChioceNum()
  {
    return 0;
  }
  
  public String getFileName()
  {
    return "";
  }
  
  public int getFileNum()
  {
    return 0;
  }
  
  public FileType getFileType()
  {
    return null;
  }
  
  public FileType[] getFileTypes(int paramInt)
  {
    return null;
  }
  
  public int getIndex()
  {
    return 0;
  }
  
  public int getIndexForKumquat()
  {
    return 0;
  }
  
  public MODE getMode(int... paramVarArgs)
  {
    return null;
  }
  
  public int getPhotoHeight()
  {
    return 0;
  }
  
  public int getPhotoWidth()
  {
    return 0;
  }
  
  public int getProgress()
  {
    return 0;
  }
  
  public int getTotalNum()
  {
    return 0;
  }
  
  public int getTotalPhotoNum()
  {
    return 0;
  }
  
  public int getTotalTime()
  {
    return 0;
  }
  
  public int getTotalTimeForKumquat()
  {
    return 0;
  }
  
  public int getTotalVideoNum()
  {
    return 0;
  }
  
  public float getZoomSize()
  {
    return 0.0F;
  }
  
  public boolean isCurPageSelected()
  {
    return false;
  }
  
  public boolean isSelectFileValid()
  {
    return false;
  }
  
  public boolean isSingleDownloaded()
  {
    return false;
  }
  
  public static enum DelFileStatus
  {
    private int data;
    
    static
    {
      DELETING = new DelFileStatus("DELETING", 1, 2);
      DelFileStatus localDelFileStatus = new DelFileStatus("COMPLETED", 2, 3);
      COMPLETED = localDelFileStatus;
      $VALUES = new DelFileStatus[] { NORMAL, DELETING, localDelFileStatus };
    }
    
    private DelFileStatus(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DelFileStatus find(int paramInt)
    {
      DelFileStatus localDelFileStatus1 = NORMAL;
      DelFileStatus[] arrayOfDelFileStatus = values();
      int j = arrayOfDelFileStatus.length;
      int i = 0;
      while (i < j)
      {
        DelFileStatus localDelFileStatus2 = arrayOfDelFileStatus[i];
        if (localDelFileStatus2._equals(paramInt)) {
          return localDelFileStatus2;
        }
        i += 1;
      }
      return localDelFileStatus1;
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
  
  public static enum FileType
  {
    private int data;
    
    static
    {
      DNG = new FileType("DNG", 1, 1);
      VIDEO = new FileType("VIDEO", 2, 2);
      FileType localFileType = new FileType("OTHER", 3, 100);
      OTHER = localFileType;
      $VALUES = new FileType[] { JPEG, DNG, VIDEO, localFileType };
    }
    
    private FileType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static FileType find(int paramInt)
    {
      FileType localFileType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFileType;
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
  
  public static enum MODE
  {
    private int data;
    
    static
    {
      SinglePause = new MODE("SinglePause", 3, 3);
      MultipleDel = new MODE("MultipleDel", 4, 4);
      Multiple = new MODE("Multiple", 5, 5);
      Download = new MODE("Download", 6, 6);
      SingleOver = new MODE("SingleOver", 7, 7);
      MODE localMODE = new MODE("OTHER", 8, 100);
      OTHER = localMODE;
      $VALUES = new MODE[] { Single, SingleLarge, SinglePlay, SinglePause, MultipleDel, Multiple, Download, SingleOver, localMODE };
    }
    
    private MODE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static MODE find(int paramInt)
    {
      MODE localMODE = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localMODE;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraGetPushPlayBackParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */