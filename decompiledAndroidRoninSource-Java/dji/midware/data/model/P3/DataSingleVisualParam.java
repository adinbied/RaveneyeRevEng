package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import dji.midware.util.BytesUtil;

public class DataSingleVisualParam
  extends DataBase
  implements DJIDataSyncListener
{
  private boolean bGet = false;
  private short dataLoadLength = 0;
  private float mBackWard = 0.0F;
  private float mCircleY = 0.0F;
  private byte[] mCustomData = null;
  private int mCustomValue = 0;
  private float mFollowGain = 0.5F;
  private ParamCmdId mParamCmdId = ParamCmdId.OTHER;
  private float mSettingSpeed = 0.0F;
  private TrackingMode mTrackMode = TrackingMode.HEADLESS_FOLLOW;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public float getBackWardGain()
  {
    return 0.0F;
  }
  
  public float getCircleY()
  {
    return 0.0F;
  }
  
  public DrawHeading getDrawHeading()
  {
    return null;
  }
  
  public DrawMode getDrawMode()
  {
    return null;
  }
  
  public float getDrawSpeed()
  {
    return 0.0F;
  }
  
  public float getFollowGain()
  {
    return 0.0F;
  }
  
  public boolean getGpsTracking()
  {
    return false;
  }
  
  public int getHomingMonoSenseOn()
  {
    return 0;
  }
  
  public int getParallelGo()
  {
    return 0;
  }
  
  public int getTerrainFollow()
  {
    return 0;
  }
  
  public boolean getTrackAss()
  {
    return false;
  }
  
  public TrackHeading getTrackHeading()
  {
    return null;
  }
  
  public boolean getTrackIntelligent()
  {
    return false;
  }
  
  public TrackingMode getTrackMode()
  {
    return null;
  }
  
  public float getUserSpeed()
  {
    return 0.0F;
  }
  
  public int getYawResponse()
  {
    return 0;
  }
  
  public boolean isHorizontalObstacleBypassEnabled()
  {
    return false;
  }
  
  public boolean isRcGimbalCtrlEnable()
  {
    return false;
  }
  
  public DataSingleVisualParam setBackWardGain(float paramFloat)
  {
    this.mBackWard = paramFloat;
    return this;
  }
  
  public DataSingleVisualParam setCircleY(float paramFloat)
  {
    this.mCircleY = paramFloat;
    return this;
  }
  
  public DataSingleVisualParam setDrawHeading(DrawHeading paramDrawHeading)
  {
    return null;
  }
  
  public DataSingleVisualParam setDrawMode(DrawMode paramDrawMode)
  {
    return null;
  }
  
  public DataSingleVisualParam setDrawSpeed(float paramFloat)
  {
    this.mCustomData = BytesUtil.getBytes(paramFloat);
    return this;
  }
  
  public DataSingleVisualParam setFollowGain(float paramFloat)
  {
    this.mFollowGain = paramFloat;
    return this;
  }
  
  public DataSingleVisualParam setFollowSpeed(FollowSpeed paramFollowSpeed)
  {
    this.mCustomValue = paramFollowSpeed.mData;
    return this;
  }
  
  public DataSingleVisualParam setGet(boolean paramBoolean)
  {
    this.bGet = paramBoolean;
    return this;
  }
  
  public DataSingleVisualParam setGpsTracking(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public DataSingleVisualParam setHomingMonoSenseOn(int paramInt)
  {
    this.mCustomValue = paramInt;
    return this;
  }
  
  public DataSingleVisualParam setParallelGo(int paramInt)
  {
    this.mCustomValue = paramInt;
    return this;
  }
  
  public DataSingleVisualParam setParamCmdId(ParamCmdId paramParamCmdId)
  {
    this.mParamCmdId = paramParamCmdId;
    return this;
  }
  
  public DataSingleVisualParam setRcGimbalCtrl(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public DataSingleVisualParam setTerrainFollow(int paramInt)
  {
    this.mCustomValue = paramInt;
    return this;
  }
  
  public DataSingleVisualParam setTrackAss(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public DataSingleVisualParam setTrackHeading(TrackHeading paramTrackHeading)
  {
    this.mCustomValue = paramTrackHeading.value();
    return this;
  }
  
  public DataSingleVisualParam setTrackIntelligent(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public DataSingleVisualParam setTrackMode(TrackingMode paramTrackingMode)
  {
    this.mTrackMode = paramTrackingMode;
    return this;
  }
  
  public DataSingleVisualParam setTrackingMaximumSpeed(int paramInt)
  {
    this.mCustomValue = paramInt;
    return this;
  }
  
  public DataSingleVisualParam setUserSpeed(float paramFloat)
  {
    this.mSettingSpeed = paramFloat;
    return this;
  }
  
  public DataSingleVisualParam setYawResponse(int paramInt)
  {
    this.mCustomValue = paramInt;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum DrawHeading
  {
    private final int data;
    
    static
    {
      FORWARD = new DrawHeading("FORWARD", 1, 1);
      DrawHeading localDrawHeading = new DrawHeading("OTHER", 2, 100);
      OTHER = localDrawHeading;
      $VALUES = new DrawHeading[] { FREE, FORWARD, localDrawHeading };
    }
    
    private DrawHeading(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DrawHeading find(int paramInt)
    {
      DrawHeading localDrawHeading1 = FREE;
      DrawHeading[] arrayOfDrawHeading = values();
      int j = arrayOfDrawHeading.length;
      int i = 0;
      while (i < j)
      {
        DrawHeading localDrawHeading2 = arrayOfDrawHeading[i];
        if (localDrawHeading2._equals(paramInt)) {
          return localDrawHeading2;
        }
        i += 1;
      }
      return localDrawHeading1;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum DrawMode
  {
    private final int data;
    
    static
    {
      DrawMode localDrawMode = new DrawMode("OTHER", 2, 100);
      OTHER = localDrawMode;
      $VALUES = new DrawMode[] { AUTO, MANUAL, localDrawMode };
    }
    
    private DrawMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DrawMode find(int paramInt)
    {
      DrawMode localDrawMode1 = AUTO;
      DrawMode[] arrayOfDrawMode = values();
      int j = arrayOfDrawMode.length;
      int i = 0;
      while (i < j)
      {
        DrawMode localDrawMode2 = arrayOfDrawMode[i];
        if (localDrawMode2._equals(paramInt)) {
          return localDrawMode2;
        }
        i += 1;
      }
      return localDrawMode1;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum FollowSpeed
  {
    private final int mData;
    
    static
    {
      FollowSpeed localFollowSpeed = new FollowSpeed("FASTEST", 2, 255);
      FASTEST = localFollowSpeed;
      $VALUES = new FollowSpeed[] { LOWEST, MIDDLE, localFollowSpeed };
    }
    
    private FollowSpeed(int paramInt)
    {
      this.mData = paramInt;
    }
    
    public static FollowSpeed find(int paramInt)
    {
      FollowSpeed localFollowSpeed1 = LOWEST;
      FollowSpeed[] arrayOfFollowSpeed = values();
      int j = arrayOfFollowSpeed.length;
      int i = 0;
      while (i < j)
      {
        FollowSpeed localFollowSpeed2 = arrayOfFollowSpeed[i];
        if (localFollowSpeed2._equals(paramInt)) {
          return localFollowSpeed2;
        }
        i += 1;
      }
      return localFollowSpeed1;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.mData == paramInt;
    }
    
    public int value()
    {
      return this.mData;
    }
  }
  
  public static enum ParamCmdId
  {
    private int data;
    
    static
    {
      TRACK_FOLLOW_GAIN = new ParamCmdId("TRACK_FOLLOW_GAIN", 2, 3);
      TRACK_BACKWARD = new ParamCmdId("TRACK_BACKWARD", 3, 6);
      TRACK_PROFILE_HEAD = new ParamCmdId("TRACK_PROFILE_HEAD", 4, 7);
      TRACK_ASS = new ParamCmdId("TRACK_ASS", 5, 12);
      TRACK_CIRCLE_Z = new ParamCmdId("TRACK_CIRCLE_Z", 6, 14);
      TRACK_CIRCLE_X = new ParamCmdId("TRACK_CIRCLE_X", 7, 15);
      TRACK_CIRCLE_Y = new ParamCmdId("TRACK_CIRCLE_Y", 8, 26);
      TRACK_MAXIMUM_SPEED = new ParamCmdId("TRACK_MAXIMUM_SPEED", 9, 27);
      TRACK_GPS = new ParamCmdId("TRACK_GPS", 10, 31);
      TRACK_INTELLIGENT = new ParamCmdId("TRACK_INTELLIGENT", 11, 41);
      FLY_USER_SPEED = new ParamCmdId("FLY_USER_SPEED", 12, 32);
      FLY_PARALLEL_GO = new ParamCmdId("FLY_PARALLEL_GO", 13, 33);
      FLY_YAW_RESPONE = new ParamCmdId("FLY_YAW_RESPONE", 14, 34);
      DRAW_SPEED = new ParamCmdId("DRAW_SPEED", 15, 35);
      DRAW_HEADING = new ParamCmdId("DRAW_HEADING", 16, 36);
      DRAW_MODE = new ParamCmdId("DRAW_MODE", 17, 37);
      FLY_RC_GIMBAL_CTRL = new ParamCmdId("FLY_RC_GIMBAL_CTRL", 18, 38);
      HOMING_MONO_SENSE_ON = new ParamCmdId("HOMING_MONO_SENSE_ON", 19, 50);
      FOLLOW_SPEED = new ParamCmdId("FOLLOW_SPEED", 20, 100);
      ParamCmdId localParamCmdId = new ParamCmdId("OTHER", 21, 255);
      OTHER = localParamCmdId;
      $VALUES = new ParamCmdId[] { TRACK_MODE, TRACK_TERRAIN_FOLLOW, TRACK_FOLLOW_GAIN, TRACK_BACKWARD, TRACK_PROFILE_HEAD, TRACK_ASS, TRACK_CIRCLE_Z, TRACK_CIRCLE_X, TRACK_CIRCLE_Y, TRACK_MAXIMUM_SPEED, TRACK_GPS, TRACK_INTELLIGENT, FLY_USER_SPEED, FLY_PARALLEL_GO, FLY_YAW_RESPONE, DRAW_SPEED, DRAW_HEADING, DRAW_MODE, FLY_RC_GIMBAL_CTRL, HOMING_MONO_SENSE_ON, FOLLOW_SPEED, localParamCmdId };
    }
    
    private ParamCmdId(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ParamCmdId find(int paramInt)
    {
      ParamCmdId localParamCmdId = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localParamCmdId;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum TrackHeading
  {
    private final int data;
    
    static
    {
      TrackHeading localTrackHeading = new TrackHeading("OTHER", 2, 100);
      OTHER = localTrackHeading;
      $VALUES = new TrackHeading[] { FOLLOW, FORWARD, localTrackHeading };
    }
    
    private TrackHeading(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TrackHeading find(int paramInt)
    {
      TrackHeading localTrackHeading1 = FOLLOW;
      TrackHeading[] arrayOfTrackHeading = values();
      int j = arrayOfTrackHeading.length;
      int i = 0;
      while (i < j)
      {
        TrackHeading localTrackHeading2 = arrayOfTrackHeading[i];
        if (localTrackHeading2._equals(paramInt)) {
          return localTrackHeading2;
        }
        i += 1;
      }
      return localTrackHeading1;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum TrackingMode
  {
    private int data;
    
    static
    {
      FIXED_ANGLE = new TrackingMode("FIXED_ANGLE", 2, 2);
      WATCH_TARGET = new TrackingMode("WATCH_TARGET", 3, 3);
      HEAD_LOCK = new TrackingMode("HEAD_LOCK", 4, 4);
      WAYPOINT = new TrackingMode("WAYPOINT", 5, 5);
      QUICK_MOVIE = new TrackingMode("QUICK_MOVIE", 6, 6);
      TrackingMode localTrackingMode = new TrackingMode("OTHER", 7, 255);
      OTHER = localTrackingMode;
      $VALUES = new TrackingMode[] { HEADLESS_FOLLOW, PARALLEL_FOLLOW, FIXED_ANGLE, WATCH_TARGET, HEAD_LOCK, WAYPOINT, QUICK_MOVIE, localTrackingMode };
    }
    
    private TrackingMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TrackingMode find(int paramInt)
    {
      TrackingMode localTrackingMode = HEADLESS_FOLLOW;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTrackingMode;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSingleVisualParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */