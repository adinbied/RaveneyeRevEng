package com.jfeinstein.jazzyviewpager;

import android.content.res.Resources;
import android.util.TypedValue;

public class Util
{
  public static int dpToPx(Resources paramResources, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramResources.getDisplayMetrics());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jfeinstein\jazzyviewpager\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */