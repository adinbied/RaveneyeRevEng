package dji.thirdparty.afinal.bitmap.core;

import android.graphics.Bitmap;
import android.view.animation.Animation;

public class BitmapDisplayConfig
{
  private Animation animation;
  private int animationType;
  private int bitmapHeight;
  private int bitmapWidth;
  private Bitmap loadfailBitmap;
  private Bitmap loadingBitmap;
  
  public Animation getAnimation()
  {
    return this.animation;
  }
  
  public int getAnimationType()
  {
    return this.animationType;
  }
  
  public int getBitmapHeight()
  {
    return this.bitmapHeight;
  }
  
  public int getBitmapWidth()
  {
    return this.bitmapWidth;
  }
  
  public Bitmap getLoadfailBitmap()
  {
    return this.loadfailBitmap;
  }
  
  public Bitmap getLoadingBitmap()
  {
    return this.loadingBitmap;
  }
  
  public void setAnimation(Animation paramAnimation)
  {
    this.animation = paramAnimation;
  }
  
  public void setAnimationType(int paramInt)
  {
    this.animationType = paramInt;
  }
  
  public void setBitmapHeight(int paramInt)
  {
    this.bitmapHeight = paramInt;
  }
  
  public void setBitmapWidth(int paramInt)
  {
    this.bitmapWidth = paramInt;
  }
  
  public void setLoadfailBitmap(Bitmap paramBitmap)
  {
    this.loadfailBitmap = paramBitmap;
  }
  
  public void setLoadingBitmap(Bitmap paramBitmap)
  {
    this.loadingBitmap = paramBitmap;
  }
  
  public class AnimationType
  {
    public static final int fadeIn = 1;
    public static final int userDefined = 0;
    
    public AnimationType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\bitmap\core\BitmapDisplayConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */