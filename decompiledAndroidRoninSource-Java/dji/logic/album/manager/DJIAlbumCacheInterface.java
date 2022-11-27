package dji.logic.album.manager;

import dji.logic.album.model.DJIAlbumDirInfo;
import dji.logic.album.model.DJIAlbumFileInfo;

public abstract interface DJIAlbumCacheInterface
{
  public abstract void clearDir();
  
  public abstract void clearFile();
  
  public abstract void getDirInfo(DJIAlbumDirInfo paramDJIAlbumDirInfo);
  
  public abstract void getFile(DJIAlbumFileInfo paramDJIAlbumFileInfo);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\DJIAlbumCacheInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */