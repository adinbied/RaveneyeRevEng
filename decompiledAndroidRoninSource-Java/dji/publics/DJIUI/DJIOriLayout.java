package dji.publics.DJIUI;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import dji.frame.widget.R.styleable;

public class DJIOriLayout
  extends DJIRelativeLayout
{
  private static boolean isAllowSetTypeByLayout = true;
  private static DJIDeviceType mdeviceType = DJIDeviceType.Phone;
  
  public DJIOriLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {
      return;
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DJIDeviceType);
    int i = paramContext.getInt(R.styleable.DJIDeviceType_djiDeviceType, 0);
    paramContext.recycle();
    if (!isAllowSetTypeByLayout) {
      return;
    }
    if (i == 0)
    {
      mdeviceType = DJIDeviceType.Phone;
      return;
    }
    mdeviceType = DJIDeviceType.Pad;
  }
  
  public static DJIDeviceType getDeviceType()
  {
    return mdeviceType;
  }
  
  public static void setDeviceType(DJIDeviceType paramDJIDeviceType)
  {
    mdeviceType = paramDJIDeviceType;
    isAllowSetTypeByLayout = false;
  }
  
  public static void setOrientation(Activity paramActivity, int paramInt)
  {
    if (paramActivity.getRequestedOrientation() != paramInt) {
      paramActivity.setRequestedOrientation(paramInt);
    }
  }
  
  public static void setOrientationByDevice(Activity paramActivity)
  {
    int i;
    if (mdeviceType == DJIDeviceType.Phone) {
      i = 7;
    } else {
      i = 6;
    }
    if (paramActivity.getRequestedOrientation() != i) {
      paramActivity.setRequestedOrientation(i);
    }
  }
  
  public static enum DJIDeviceType
  {
    static
    {
      Pad = new DJIDeviceType("Pad", 1);
      DJIDeviceType localDJIDeviceType = new DJIDeviceType("DJI5_5", 2);
      DJI5_5 = localDJIDeviceType;
      $VALUES = new DJIDeviceType[] { Phone, Pad, localDJIDeviceType };
    }
    
    private DJIDeviceType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIUI\DJIOriLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */