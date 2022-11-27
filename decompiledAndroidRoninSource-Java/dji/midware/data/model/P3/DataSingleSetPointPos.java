package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSingleSetPointPos
  extends DataBase
  implements DJIDataSyncListener
{
  private float mPosX = 0.0F;
  private float mPosY = 0.0F;
  private short mSessionId = 0;
  private TapMode mTapMode = TapMode.POSITIVE_FLY;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataSingleSetPointPos setPosXY(float paramFloat1, float paramFloat2)
  {
    this.mPosX = paramFloat1;
    this.mPosY = paramFloat2;
    return this;
  }
  
  public DataSingleSetPointPos setSessionId(short paramShort)
  {
    this.mSessionId = paramShort;
    return this;
  }
  
  public DataSingleSetPointPos setTapMode(TapMode paramTapMode)
  {
    this.mTapMode = paramTapMode;
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
  
  public static enum TapMode
  {
    private final int data;
    
    static
    {
      HEADLESS_CIRCLE = new TapMode("HEADLESS_CIRCLE", 2, 2);
      HEADLESS_PARALLEL = new TapMode("HEADLESS_PARALLEL", 3, 3);
      POSITION_FLY = new TapMode("POSITION_FLY", 4, 7);
      TapMode localTapMode = new TapMode("OTHER", 5, 100);
      OTHER = localTapMode;
      $VALUES = new TapMode[] { POSITIVE_FLY, REVERSE_FLY, HEADLESS_CIRCLE, HEADLESS_PARALLEL, POSITION_FLY, localTapMode };
    }
    
    private TapMode(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static TapMode find(int paramInt)
    {
      TapMode localTapMode1 = POSITIVE_FLY;
      TapMode[] arrayOfTapMode = values();
      int j = arrayOfTapMode.length;
      int i = 0;
      while (i < j)
      {
        TapMode localTapMode2 = arrayOfTapMode[i];
        if (localTapMode2._equals(paramInt)) {
          return localTapMode2;
        }
        i += 1;
      }
      return localTapMode1;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSingleSetPointPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */