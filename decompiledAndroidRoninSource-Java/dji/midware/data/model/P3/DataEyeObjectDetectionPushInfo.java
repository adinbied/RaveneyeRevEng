package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import java.util.List;

public class DataEyeObjectDetectionPushInfo
  extends DataBase
{
  private static DataEyeObjectDetectionPushInfo instance;
  
  public static DataEyeObjectDetectionPushInfo getInstance()
  {
    if (instance == null) {
      instance = new DataEyeObjectDetectionPushInfo();
    }
    return instance;
  }
  
  protected void doPack() {}
  
  public int getArrorNum()
  {
    return 0;
  }
  
  public List<ArrowInfo> getArrowInfoList()
  {
    return null;
  }
  
  public int getVersion()
  {
    return 0;
  }
  
  public boolean isLastArrowObstacle()
  {
    return false;
  }
  
  public static class ArrowInfo
  {
    public int alpha;
    public float[] orientation;
    public int type;
    
    public ArrowInfo(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
    {
      this.orientation = paramArrayOfFloat;
      this.type = paramInt1;
      this.alpha = paramInt2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeObjectDetectionPushInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */