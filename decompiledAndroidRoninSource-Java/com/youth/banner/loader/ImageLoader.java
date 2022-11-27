package com.youth.banner.loader;

import android.content.Context;
import android.widget.ImageView;

public abstract class ImageLoader
  implements ImageLoaderInterface<ImageView>
{
  public ImageView createImageView(Context paramContext)
  {
    return new ImageView(paramContext);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\youth\banner\loader\ImageLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */