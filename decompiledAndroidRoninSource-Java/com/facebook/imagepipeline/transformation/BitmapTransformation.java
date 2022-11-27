package com.facebook.imagepipeline.transformation;

import android.graphics.Bitmap;

public abstract interface BitmapTransformation
{
  public abstract boolean modifiesTransparency();
  
  public abstract void transform(Bitmap paramBitmap);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\transformation\BitmapTransformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */