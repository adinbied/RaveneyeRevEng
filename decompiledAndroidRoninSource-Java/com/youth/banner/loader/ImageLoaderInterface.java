package com.youth.banner.loader;

import android.content.Context;
import android.view.View;
import java.io.Serializable;

public abstract interface ImageLoaderInterface<T extends View>
  extends Serializable
{
  public abstract T createImageView(Context paramContext);
  
  public abstract void displayImage(Context paramContext, Object paramObject, T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\youth\banner\loader\ImageLoaderInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */