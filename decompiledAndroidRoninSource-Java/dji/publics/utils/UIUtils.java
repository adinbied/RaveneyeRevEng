package dji.publics.utils;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class UIUtils
{
  private static long lastClickTime;
  
  public static void addMergeView(ViewGroup paramViewGroup, int paramInt)
  {
    LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup);
  }
  
  public static void addView(ViewGroup paramViewGroup, int paramInt)
  {
    LayoutInflater.from(paramViewGroup.getContext()).inflate(paramInt, paramViewGroup);
  }
  
  public static void addView(ViewGroup paramViewGroup, int paramInt, Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(paramInt, paramViewGroup);
  }
  
  public static boolean isFastDoubleClick()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - lastClickTime;
    if ((0L < l2) && (l2 < 1200L))
    {
      Log.d("isFastDoubleClick", "true");
      return true;
    }
    lastClickTime = l1;
    Log.d("isFastDoubleClick", "false");
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\public\\utils\UIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */