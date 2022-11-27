package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataEyePushVisionTip
  extends DataBase
{
  private static DataEyePushVisionTip mInstance;
  
  public static DataEyePushVisionTip getInstance()
  {
    if (mInstance == null) {
      mInstance = new DataEyePushVisionTip();
    }
    return mInstance;
  }
  
  protected void doPack() {}
  
  public int getQuickMovieProgress()
  {
    return 0;
  }
  
  public int getRemaingSecondsToCapture()
  {
    return 0;
  }
  
  public TrackingTipType getTrackingTipType()
  {
    return null;
  }
  
  public int getType()
  {
    return 0;
  }
  
  public int isConfirmTracking()
  {
    return 0;
  }
  
  public int isTakePhotoCountdown()
  {
    return 0;
  }
  
  public static enum TrackingTipType
  {
    private final int data;
    
    static
    {
      ConfirmGesture = new TrackingTipType("ConfirmGesture", 1, 1);
      TakePhotoGesture = new TrackingTipType("TakePhotoGesture", 2, 2);
      RockerCircle = new TrackingTipType("RockerCircle", 3, 3);
      AutoCircle = new TrackingTipType("AutoCircle", 4, 4);
      MinDistance = new TrackingTipType("MinDistance", 5, 5);
      MaxDistance = new TrackingTipType("MaxDistance", 6, 6);
      QuickMovieEndInNormalState = new TrackingTipType("QuickMovieEndInNormalState", 7, 7);
      QuickMovieApproachingDistanceLimitation = new TrackingTipType("QuickMovieApproachingDistanceLimitation", 8, 8);
      TrackingTipType localTrackingTipType = new TrackingTipType("OTHER", 9, Integer.MAX_VALUE);
      OTHER = localTrackingTipType;
      $VALUES = new TrackingTipType[] { None, ConfirmGesture, TakePhotoGesture, RockerCircle, AutoCircle, MinDistance, MaxDistance, QuickMovieEndInNormalState, QuickMovieApproachingDistanceLimitation, localTrackingTipType };
    }
    
    private TrackingTipType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TrackingTipType find(int paramInt)
    {
      TrackingTipType localTrackingTipType1 = None;
      TrackingTipType[] arrayOfTrackingTipType = values();
      int j = arrayOfTrackingTipType.length;
      int i = 0;
      while (i < j)
      {
        TrackingTipType localTrackingTipType2 = arrayOfTrackingTipType[i];
        if (localTrackingTipType2._equals(paramInt)) {
          return localTrackingTipType2;
        }
        i += 1;
      }
      return localTrackingTipType1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyePushVisionTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */