package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataSingleMoveTrackSelect
  extends DataBase
  implements DJIDataSyncListener
{
  private float mCenterX = 0.0F;
  private float mCenterY = 0.0F;
  private MoveCtrlType mCtrlType = MoveCtrlType.CONCERN;
  private float mHeight = 0.0F;
  private float mWidth = 0.0F;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataSingleMoveTrackSelect setCenterXY(float paramFloat1, float paramFloat2)
  {
    this.mCenterX = paramFloat1;
    this.mCenterY = paramFloat2;
    return this;
  }
  
  public DataSingleMoveTrackSelect setCtrlType(MoveCtrlType paramMoveCtrlType)
  {
    this.mCtrlType = paramMoveCtrlType;
    return this;
  }
  
  public DataSingleMoveTrackSelect setWH(float paramFloat1, float paramFloat2)
  {
    this.mWidth = paramFloat1;
    this.mHeight = paramFloat2;
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
  
  public static enum MoveCtrlType
  {
    private int data;
    
    static
    {
      MoveCtrlType localMoveCtrlType = new MoveCtrlType("OTHER", 2, 8);
      OTHER = localMoveCtrlType;
      $VALUES = new MoveCtrlType[] { CONCERN, MODIFY, localMoveCtrlType };
    }
    
    private MoveCtrlType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static MoveCtrlType find(int paramInt)
    {
      MoveCtrlType localMoveCtrlType = CONCERN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localMoveCtrlType;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataSingleMoveTrackSelect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */