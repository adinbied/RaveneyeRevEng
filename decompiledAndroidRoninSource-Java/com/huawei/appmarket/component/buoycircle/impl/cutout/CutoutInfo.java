package com.huawei.appmarket.component.buoycircle.impl.cutout;

import android.graphics.Rect;
import com.huawei.appmarket.component.buoycircle.impl.log.BuoyLog;
import org.json.JSONException;
import org.json.JSONObject;

public class CutoutInfo
{
  private static final int NO_CUTOUT = 0;
  private static final String TAG = "CutoutInfo";
  private int height;
  private int orientation;
  private Rect rect;
  
  public CutoutInfo(int paramInt1, int paramInt2, Rect paramRect)
  {
    this.height = paramInt1;
    this.orientation = paramInt2;
    this.rect = paramRect;
  }
  
  public static CutoutInfo fromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      int i = paramString.getInt("orientation");
      int j = paramString.getInt("height");
      Rect localRect = new Rect();
      localRect.left = paramString.getInt("left");
      localRect.top = paramString.getInt("top");
      localRect.right = paramString.getInt("right");
      localRect.bottom = paramString.getInt("bottom");
      paramString = new CutoutInfo(j, i, localRect);
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
    BuoyLog.e("CutoutInfo", "cutout info fromJson meet exception");
    return null;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getOrientation()
  {
    return this.orientation;
  }
  
  public Rect getRect()
  {
    return this.rect;
  }
  
  public boolean isCutoutScreen()
  {
    return this.height != 0;
  }
  
  public void setOrientation(int paramInt)
  {
    this.orientation = paramInt;
  }
  
  public JSONObject toJson()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\cutout\CutoutInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */