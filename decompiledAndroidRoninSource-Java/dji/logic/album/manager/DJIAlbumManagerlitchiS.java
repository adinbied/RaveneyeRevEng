package dji.logic.album.manager;

import dji.logic.album.manager.litchis.DJIFileListLoader;
import dji.logic.album.manager.litchis.DJIFileLoader;
import dji.logic.album.manager.litchis.DJIFileNailLoader;
import dji.logic.album.model.DJIAlbumDirInfo;
import dji.logic.album.model.DJIAlbumFile;
import dji.logic.album.model.DJIAlbumFileInfo;
import java.util.ArrayList;

class DJIAlbumManagerlitchiS
  extends DJIAlbumManager
{
  DJIFileListLoader fileListLoader;
  DJIFileLoader fileLoader;
  DJIFileNailLoader nailLoader;
  
  /* Error */
  private void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void Destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void cancelTask()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void clearDir() {}
  
  public void clearFile() {}
  
  /* Error */
  public void downBokeh(DJIAlbumFileInfo arg1, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void downBokehScreenNail(DJIAlbumFileInfo arg1, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void downBokehThumbNail(DJIAlbumFileInfo arg1, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void downExif(DJIAlbumFileInfo arg1, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void downFileList(ArrayList<DJIAlbumFileInfo> paramArrayList, DJIAlbumInterface.DJIAlbumPullListener<ArrayList<DJIAlbumFile>> paramDJIAlbumPullListener) {}
  
  /* Error */
  public void downFileOne(DJIAlbumFileInfo arg1, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void downPanoSubimgOne(DJIAlbumFileInfo arg1, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void downPanoSubimgScreennail(DJIAlbumFileInfo arg1, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void downPanoSubimgThumbnail(DJIAlbumFileInfo arg1, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void downPanorama(DJIAlbumFileInfo arg1, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void downScreennail(DJIAlbumFileInfo arg1, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void downThumbnail(DJIAlbumFileInfo arg1, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void downTimelapsePreviewImage(DJIAlbumFileInfo arg1, DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumFile> arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void getDirInfo(DJIAlbumDirInfo paramDJIAlbumDirInfo) {}
  
  /* Error */
  public void getDirectoryInfo(DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumDirInfo> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void getDirectoryInfoIncrementally(DJIAlbumInterface.DJIAlbumPullListener<DJIAlbumDirInfo> arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void getFile(DJIAlbumFileInfo paramDJIAlbumFileInfo) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\DJIAlbumManagerlitchiS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */