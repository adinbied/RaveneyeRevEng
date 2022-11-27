package dji.logic.album.manager;

import android.content.Context;
import dji.midware.data.config.P3.ProductType;

public class DJIAlbumManagerFactory
{
  public static DJIAlbumManager buildAlbumManager(Context paramContext, ProductType paramProductType, String paramString)
  {
    DJIAlbumCacheManager.getInstance(paramContext).setRenameTo(paramString);
    int i = 1.$SwitchMap$dji$midware$data$config$P3$ProductType[paramProductType.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return new DJIAlbumManagerlitchiS();
      }
      return new DJIAlbumManagerlitchiS();
    }
    return new DJIAlbumManagerlitchiS();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\album\manager\DJIAlbumManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */