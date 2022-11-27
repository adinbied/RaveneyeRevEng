package com.huawei.appmarket.component.buoycircle.impl.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public abstract class ResourceLoaderUtil
{
  private static final String ANIM = "anim";
  private static final String COLOR = "color";
  private static final String DRAWABLE = "drawable";
  private static final String ID = "id";
  private static final String LAYOUT = "layout";
  private static final String STRING = "string";
  private static final String STYLE = "style";
  private static Context mContext;
  private static String mPackageName;
  
  public static int getAnimId(String paramString)
  {
    return mContext.getResources().getIdentifier(paramString, "anim", mPackageName);
  }
  
  public static int getColorId(String paramString)
  {
    return mContext.getResources().getIdentifier(paramString, "color", mPackageName);
  }
  
  public static Drawable getDrawable(String paramString)
  {
    return mContext.getResources().getDrawable(getDrawableId(paramString));
  }
  
  public static int getDrawableId(String paramString)
  {
    return mContext.getResources().getIdentifier(paramString, "drawable", mPackageName);
  }
  
  public static int getIdId(String paramString)
  {
    return mContext.getResources().getIdentifier(paramString, "id", mPackageName);
  }
  
  public static int getLayoutId(String paramString)
  {
    return mContext.getResources().getIdentifier(paramString, "layout", mPackageName);
  }
  
  public static String getString(String paramString)
  {
    String str = mContext.getResources().getString(getStringId(paramString));
    paramString = str;
    if (str == null) {
      paramString = "";
    }
    return paramString;
  }
  
  public static String getString(String paramString, Object... paramVarArgs)
  {
    paramVarArgs = mContext.getResources().getString(getStringId(paramString), paramVarArgs);
    paramString = paramVarArgs;
    if (paramVarArgs == null) {
      paramString = "";
    }
    return paramString;
  }
  
  public static int getStringId(String paramString)
  {
    return mContext.getResources().getIdentifier(paramString, "string", mPackageName);
  }
  
  public static int getStyleId(String paramString)
  {
    return mContext.getResources().getIdentifier(paramString, "style", mPackageName);
  }
  
  public static Context getmContext()
  {
    return mContext;
  }
  
  public static void setContext(Context paramContext)
  {
    mContext = paramContext;
    mPackageName = paramContext.getPackageName();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\utils\ResourceLoaderUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */