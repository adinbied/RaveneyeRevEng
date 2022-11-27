package dji.logic.album.manager;

import dji.logic.album.model.DJIAlbumDirInfo;
import dji.logic.album.model.DJIAlbumFile;
import dji.logic.album.model.DJIAlbumFileInfo;
import dji.logic.album.model.DJIAlbumPullErrorType;
import java.util.ArrayList;

public abstract interface DJIAlbumInterface
{
  public abstract void cancelTask();
  
  public abstract void downBokeh(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener);
  
  public abstract void downBokehScreenNail(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener);
  
  public abstract void downBokehThumbNail(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener);
  
  public abstract void downExif(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener);
  
  public abstract void downFileList(ArrayList<DJIAlbumFileInfo> paramArrayList, DJIAlbumPullListener<ArrayList<DJIAlbumFile>> paramDJIAlbumPullListener);
  
  public abstract void downFileOne(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener);
  
  public abstract void downPanoSubimgOne(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener);
  
  public abstract void downPanoSubimgScreennail(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener);
  
  public abstract void downPanoSubimgThumbnail(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener);
  
  public abstract void downPanorama(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener);
  
  public abstract void downScreennail(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener);
  
  public abstract void downThumbnail(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener);
  
  public abstract void downTimelapsePreviewImage(DJIAlbumFileInfo paramDJIAlbumFileInfo, DJIAlbumPullListener<DJIAlbumFile> paramDJIAlbumPullListener);
  
  public abstract void getDirectoryInfo(DJIAlbumPullListener<DJIAlbumDirInfo> paramDJIAlbumPullListener);
  
  public abstract void getDirectoryInfoIncrementally(DJIAlbumPullListener<DJIAlbumDirInfo> paramDJIAlbumPullListener, int paramInt);
  
  public static abstract interface DJIAlbumPullListener<E>
  {
    public abstract void onFailure(DJIAlbumPullErrorType paramDJIAlbumPullErrorType);
    
    public abstract void onProgress(long paramLong1, long paramLong2);
    
    public abstract void onRateUpdate(long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void onStart();
    
    public abstract void onSuccess(E paramE);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\DJIAlbumInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */