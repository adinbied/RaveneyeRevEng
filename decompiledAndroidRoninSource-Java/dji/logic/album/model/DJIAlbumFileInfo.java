package dji.logic.album.model;

import dji.logic.album.manager.litchis.DJIFileResolution;
import dji.logic.album.manager.litchis.DJIFileType;
import dji.midware.data.model.P3.DataCameraSetPhoto.TYPE;
import java.io.Serializable;

public class DJIAlbumFileInfo
  implements Serializable
{
  private static final long serialVersionUID = 8999516028984791868L;
  public DataCameraSetPhoto.TYPE captureType;
  public long createTime;
  public long createTimeOrg;
  public int duration;
  public int encodeType = 0;
  public long fileGuid;
  public DJIFileType fileType;
  public int frameRate;
  public int frameRateScale = 0;
  public int groupNum = 3;
  public GroupType groupType;
  public boolean hasEXT;
  public int index;
  public long length;
  public int pathLength;
  public String pathStr;
  public int photoGroupId;
  public DJIFileResolution resolution;
  public int rotation;
  public boolean starTag;
  public int subIndex;
  public int subVideoType = 0;
  public int videoTpye = 0;
  
  public static DJIAlbumFileInfo copy(DJIAlbumFileInfo paramDJIAlbumFileInfo)
  {
    DJIAlbumFileInfo localDJIAlbumFileInfo = new DJIAlbumFileInfo();
    localDJIAlbumFileInfo.length = paramDJIAlbumFileInfo.length;
    localDJIAlbumFileInfo.createTime = paramDJIAlbumFileInfo.createTime;
    localDJIAlbumFileInfo.createTimeOrg = paramDJIAlbumFileInfo.createTimeOrg;
    localDJIAlbumFileInfo.fileType = paramDJIAlbumFileInfo.fileType;
    localDJIAlbumFileInfo.index = paramDJIAlbumFileInfo.index;
    localDJIAlbumFileInfo.pathLength = paramDJIAlbumFileInfo.pathLength;
    localDJIAlbumFileInfo.pathStr = paramDJIAlbumFileInfo.pathStr;
    localDJIAlbumFileInfo.groupType = paramDJIAlbumFileInfo.groupType;
    localDJIAlbumFileInfo.groupNum = paramDJIAlbumFileInfo.groupNum;
    return localDJIAlbumFileInfo;
  }
  
  private String getExt()
  {
    return null;
  }
  
  private String getTime()
  {
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public String getBokehGroupNameKey()
  {
    return null;
  }
  
  public String getBokehNameKey()
  {
    return null;
  }
  
  public String getExifNameKey()
  {
    return null;
  }
  
  public String getFullPanoNameKey()
  {
    return null;
  }
  
  public String getMP4StreamKey()
  {
    return null;
  }
  
  public String getMd5()
  {
    return null;
  }
  
  public String getNameKey()
  {
    return null;
  }
  
  public String getPanoNameKey()
  {
    return null;
  }
  
  public String getPanoThumbNameKey()
  {
    return null;
  }
  
  public String getPanoramaGroupNameKey()
  {
    return null;
  }
  
  public String getPanoramaNameKey()
  {
    return null;
  }
  
  public String getQuickMovieNameKey()
  {
    return null;
  }
  
  public String getScreenNameKey()
  {
    return getScreenNameKey(0);
  }
  
  public String getScreenNameKey(int paramInt)
  {
    return null;
  }
  
  public String getStreamKey()
  {
    return null;
  }
  
  public String getThumbNameKey()
  {
    return null;
  }
  
  public boolean isQuickMoive()
  {
    return false;
  }
  
  /* Error */
  public void parseTime(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  /* Error */
  public void readFromProperty(java.io.File arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public String toString()
  {
    return null;
  }
  
  /* Error */
  public void writeToProperty(java.io.File arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static enum EXT_TYPE
  {
    private int data;
    
    static
    {
      PhotoInfo = new EXT_TYPE("PhotoInfo", 1, 2);
      FileTag = new EXT_TYPE("FileTag", 2, 3);
      VideoInfo = new EXT_TYPE("VideoInfo", 3, 4);
      GroupParam = new EXT_TYPE("GroupParam", 4, 5);
      EXT_TYPE localEXT_TYPE = new EXT_TYPE("OTHER", 5, 0);
      OTHER = localEXT_TYPE;
      $VALUES = new EXT_TYPE[] { VideoGUID, PhotoInfo, FileTag, VideoInfo, GroupParam, localEXT_TYPE };
    }
    
    private EXT_TYPE(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static EXT_TYPE find(int paramInt)
    {
      EXT_TYPE localEXT_TYPE = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localEXT_TYPE;
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
  
  public static enum GroupType
  {
    private int data;
    
    static
    {
      GroupType localGroupType = new GroupType("OTHER", 2, 15);
      OTHER = localGroupType;
      $VALUES = new GroupType[] { Pano_1x3, Pano_3x3, localGroupType };
    }
    
    private GroupType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static GroupType find(int paramInt)
    {
      GroupType localGroupType = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localGroupType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\model\DJIAlbumFileInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */