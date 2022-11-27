package dji.logic.album.manager;

import dji.logic.album.model.DJIAlbumDirInfo;

public abstract class DJIAlbumManager
  implements DJIAlbumInterface, DJIAlbumCacheInterface
{
  protected DJIAlbumDirInfo dirinfo;
  protected boolean isSupportMultiThread = false;
  protected int receiverIdInProtocol = -1;
  
  public abstract void Destroy();
  
  public DJIAlbumManager setReceiverIdInProtocol(int paramInt)
  {
    this.receiverIdInProtocol = paramInt;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\DJIAlbumManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */