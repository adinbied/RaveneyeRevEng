package lecho.lib.hellocharts.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;

public abstract class ChartUtils
{
  public static final int[] COLORS;
  public static final int COLOR_BLUE;
  public static final int COLOR_GREEN;
  private static int COLOR_INDEX = 0;
  public static final int COLOR_ORANGE;
  public static final int COLOR_RED;
  public static final int COLOR_VIOLET;
  private static final float DARKEN_INTENSITY = 0.9F;
  private static final float DARKEN_SATURATION = 1.1F;
  public static final int DEFAULT_COLOR = Color.parseColor("#DFDFDF");
  public static final int DEFAULT_DARKEN_COLOR = Color.parseColor("#DDDDDD");
  
  static
  {
    COLOR_BLUE = Color.parseColor("#33B5E5");
    COLOR_VIOLET = Color.parseColor("#AA66CC");
    COLOR_GREEN = Color.parseColor("#99CC00");
    COLOR_ORANGE = Color.parseColor("#FFBB33");
    int i = Color.parseColor("#FF4444");
    COLOR_RED = i;
    COLORS = new int[] { COLOR_BLUE, COLOR_VIOLET, COLOR_GREEN, COLOR_ORANGE, i };
  }
  
  public static int darkenColor(int paramInt)
  {
    float[] arrayOfFloat = new float[3];
    int i = Color.alpha(paramInt);
    Color.colorToHSV(paramInt, arrayOfFloat);
    arrayOfFloat[1] = Math.min(arrayOfFloat[1] * 1.1F, 1.0F);
    arrayOfFloat[2] *= 0.9F;
    paramInt = Color.HSVToColor(arrayOfFloat);
    return Color.argb(i, Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
  }
  
  public static int dp2px(float paramFloat, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return (int)(paramInt * paramFloat + 0.5F);
  }
  
  public static int mm2px(Context paramContext, int paramInt)
  {
    return (int)(TypedValue.applyDimension(5, paramInt, paramContext.getResources().getDisplayMetrics()) + 0.5F);
  }
  
  public static final int nextColor()
  {
    if (COLOR_INDEX >= COLORS.length) {
      COLOR_INDEX = 0;
    }
    int[] arrayOfInt = COLORS;
    int i = COLOR_INDEX;
    COLOR_INDEX = i + 1;
    return arrayOfInt[i];
  }
  
  public static final int pickColor()
  {
    return COLORS[((int)Math.round(Math.random() * (COLORS.length - 1)))];
  }
  
  public static int px2dp(float paramFloat, int paramInt)
  {
    return (int)Math.ceil(paramInt / paramFloat);
  }
  
  public static int px2sp(float paramFloat, int paramInt)
  {
    return (int)Math.ceil(paramInt / paramFloat);
  }
  
  public static int sp2px(float paramFloat, int paramInt)
  {
    if (paramInt == 0) {
      return 0;
    }
    return (int)(paramInt * paramFloat + 0.5F);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellochart\\util\ChartUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */