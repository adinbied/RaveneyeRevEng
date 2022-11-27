package dji.thirdparty.afinal.bitmap.display;

import android.graphics.Bitmap;
import android.view.View;
import dji.thirdparty.afinal.bitmap.core.BitmapDisplayConfig;

public abstract interface Displayer
{
  public abstract void loadCompletedisplay(View paramView, Bitmap paramBitmap, BitmapDisplayConfig paramBitmapDisplayConfig);
  
  public abstract void loadFailDisplay(View paramView, Bitmap paramBitmap);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\bitmap\display\Displayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */