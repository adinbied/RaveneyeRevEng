package dji.logic.vision;

import dji.logic.utils.DJIPublicUtils;

public abstract interface IVisionResDefine
{
  public static abstract interface SupportVersion
  {
    public static final long VERSION_VISION_KUMAUATX_FIXWING_GIMBALCTRL;
    public static final long VERSION_VISION_KUMQUATX_FIXWING;
    public static final long VERSION_VISION_KUMQUAT_AR;
    public static final long VERSION_VISION_KUMQUAT_SELFIE;
    public static final long VERSION_VISION_KUMQUAT_TRACKSPEED;
    public static final long VERSION_VISION_PAMATO_DRAWMODE = DJIPublicUtils.formatVersion("1.1.0.90");
    public static final long VERSION_VISION_POMATO_AR;
    public static final long VERSION_VISION_POMATO_DRAW;
    public static final long VERSION_VISION_TOMATO_NEW_NAVIGATION;
    public static final long VERSION_VISION_TOMATO_TRACKING_AVOID = DJIPublicUtils.formatVersion("1.0.4.0");
    
    static
    {
      VERSION_VISION_TOMATO_NEW_NAVIGATION = DJIPublicUtils.formatVersion("1.1.0.61");
      VERSION_VISION_KUMQUAT_AR = DJIPublicUtils.formatVersion("1.1.0.54");
      VERSION_VISION_KUMQUAT_SELFIE = DJIPublicUtils.formatVersion("1.1.0.21");
      VERSION_VISION_KUMQUAT_TRACKSPEED = DJIPublicUtils.formatVersion("1.1.0.70");
      VERSION_VISION_KUMQUATX_FIXWING = DJIPublicUtils.formatVersion("1.1.0.84");
      VERSION_VISION_KUMAUATX_FIXWING_GIMBALCTRL = DJIPublicUtils.formatVersion("1.1.0.91");
      VERSION_VISION_POMATO_AR = DJIPublicUtils.formatVersion("1.1.0.35");
      VERSION_VISION_POMATO_DRAW = DJIPublicUtils.formatVersion("1.1.0.60");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\vision\IVisionResDefine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */