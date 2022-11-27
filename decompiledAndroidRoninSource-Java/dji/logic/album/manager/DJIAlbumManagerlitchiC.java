package dji.logic.album.manager;

import dji.logic.album.model.DJIAlbumDirInfo;
import dji.logic.album.model.DJIAlbumFile;
import dji.logic.album.model.DJIAlbumFileInfo;
import java.util.ArrayList;

class DJIAlbumManagerlitchiC
  extends DJIAlbumManager
{
  public DJIAlbumManagerlitchiC()
  {
    this.isSupportMultiThread = true;
  }
  
  public void Destroy() {}
  
  public void cancelTask() {}
  
  public void clearDir() {}
  
  public void clearFile() {}
  
  public void downBokeh(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener) {}
  
  public void downBokehScreenNail(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener) {}
  
  public void downBokehThumbNail(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener) {}
  
  public void downExif(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener) {}
  
  public void downFileList(ArrayList<DJIAlbumFileInfo> paramArrayList, DJIAlbumInterface.DJIAlbumPullListener<ArrayList<DJIAlbumFile>> paramDJIAlbumPullListener) {}
  
  public void downFileOne(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener) {}
  
  public void downPanoSubimgOne(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener) {}
  
  public void downPanoSubimgScreennail(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener) {}
  
  public void downPanoSubimgThumbnail(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener) {}
  
  public void downPanorama(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener) {}
  
  public void downScreennail(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener) {}
  
  public void downThumbnail(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener) {}
  
  public void downTimelapsePreviewImage(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener) {}
  
  public void getDirInfo(DJIAlbumDirInfo paramDJIAlbumDirInfo) {}
  
  public void getDirectoryInfo(DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumDirInfo> paramDJIAlbumPullListener) {}
  
  public void getDirectoryInfoIncrementally(DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumDirInfo> paramDJIAlbumPullListener, int paramInt) {}
  
  public void getFile(DJIAlbumFileInfo paramDJIAlbumFileInfo) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\DJIAlbumManagerlitchiC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */