package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;

public class DataSmartGetTrackPush
  extends DataBase
{
  private static final String TAG = "DataSmartGetTrackPush";
  private static DataSmartGetTrackPush instance;
  
  private DataSmartGetTrackPush()
  {
    this.isNeedPushLosed = true;
    this.delayPushLoseTime = 500;
  }
  
  public DataSmartGetTrackPush(boolean paramBoolean)
  {
    super(paramBoolean);
  }
  
  public static DataSmartGetTrackPush getInstance()
  {
    try
    {
      if (instance == null)
      {
        localDataSmartGetTrackPush = new DataSmartGetTrackPush();
        instance = localDataSmartGetTrackPush;
        localDataSmartGetTrackPush.isRemoteModel = true;
      }
      DataSmartGetTrackPush localDataSmartGetTrackPush = instance;
      return localDataSmartGetTrackPush;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public TrackRect getTrackRect()
  {
    return null;
  }
  
  public TrackState getType()
  {
    return null;
  }
  
  protected void setPushLose()
  {
    super.setPushLose();
    clear();
    post();
  }
  
  /* Error */
  public void setRecData(byte[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class TrackRect
  {
    private float mCenterX;
    private float mCenterY;
    private float mHeight;
    private float mWidth;
    
    public TrackRect() {}
    
    public TrackRect(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mCenterX = paramFloat1;
      this.mCenterY = paramFloat2;
      this.mWidth = paramFloat3;
      this.mHeight = paramFloat4;
    }
    
    public float getCenterX()
    {
      return this.mCenterX;
    }
    
    public float getCenterY()
    {
      return this.mCenterY;
    }
    
    public float getHeight()
    {
      return this.mHeight;
    }
    
    public float getWidth()
    {
      return this.mWidth;
    }
    
    public void setCenterX(float paramFloat)
    {
      this.mCenterX = paramFloat;
    }
    
    public void setCenterY(float paramFloat)
    {
      this.mCenterY = paramFloat;
    }
    
    public void setHeight(float paramFloat)
    {
      this.mHeight = paramFloat;
    }
    
    public void setWidth(float paramFloat)
    {
      this.mWidth = paramFloat;
    }
    
    public String toString()
    {
      return null;
    }
  }
  
  public static enum TrackState
  {
    private int data;
    
    static
    {
      DJI_ML_TK_MODE_NOT_CONFIDENT = new TrackState("DJI_ML_TK_MODE_NOT_CONFIDENT", 2, 2);
      DJI_ML_TK_MODE_REDETECTED = new TrackState("DJI_ML_TK_MODE_REDETECTED", 3, 3);
      DJI_ML_TK_MODE_CONTINUE_LOST = new TrackState("DJI_ML_TK_MODE_CONTINUE_LOST", 4, 5);
      DJI_ML_TK_MODE_INVALID = new TrackState("DJI_ML_TK_MODE_INVALID", 5, 255);
      TrackState localTrackState = new TrackState("DJI_ML_TK_MODE_UNINIT", 6, -1);
      DJI_ML_TK_MODE_UNINIT = localTrackState;
      $VALUES = new TrackState[] { DJI_ML_TK_MODE_LOST, DJI_ML_TK_MODE_TRACKED, DJI_ML_TK_MODE_NOT_CONFIDENT, DJI_ML_TK_MODE_REDETECTED, DJI_ML_TK_MODE_CONTINUE_LOST, DJI_ML_TK_MODE_INVALID, localTrackState };
    }
    
    private TrackState(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TrackState find(int paramInt)
    {
      TrackState localTrackState = DJI_ML_TK_MODE_UNINIT;
      TrackState[] arrayOfTrackState = values();
      int i = 0;
      while (i < arrayOfTrackState.length)
      {
        if (arrayOfTrackState[i]._equals(paramInt)) {
          return arrayOfTrackState[i];
        }
        i += 1;
      }
      return localTrackState;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSmartGetTrackPush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */