package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;

public class DataEyeSetQuickMovieParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static final int REASON_STRUCTURE_SIZE = 2;
  private static DataEyeSetQuickMovieParams instance;
  private ArrayList<ActionParam> actionParams;
  
  public static DataEyeSetQuickMovieParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeSetQuickMovieParams();
      }
      DataEyeSetQuickMovieParams localDataEyeSetQuickMovieParams = instance;
      return localDataEyeSetQuickMovieParams;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ArrayList<FailedReasonStruct> getFailedReasons()
  {
    return null;
  }
  
  public DataEyeSetQuickMovieParams setActionParams(ArrayList<ActionParam> paramArrayList)
  {
    this.actionParams = paramArrayList;
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
  
  public static class ActionParam
  {
    public Number data;
    public DataEyeSetQuickMovieParams.ActionParamIndex index;
    
    public ActionParam(DataEyeSetQuickMovieParams.ActionParamIndex paramActionParamIndex)
    {
      this.index = DataEyeSetQuickMovieParams.ActionParamIndex.END_OF_PARAMS;
      this.data = Integer.valueOf(1);
    }
    
    public ActionParam(DataEyeSetQuickMovieParams.ActionParamIndex paramActionParamIndex, Number paramNumber)
    {
      this.index = paramActionParamIndex;
      this.data = paramNumber;
    }
  }
  
  public static enum ActionParamIndex
  {
    private int size;
    private int value;
    
    static
    {
      DISTANCE = new ActionParamIndex("DISTANCE", 5, 5, 4);
      TIME = new ActionParamIndex("TIME", 6, 6, 4);
      PROGRESS = new ActionParamIndex("PROGRESS", 7, 7, 1);
      ActionParamIndex localActionParamIndex = new ActionParamIndex("END_OF_PARAMS", 8, 255, 1);
      END_OF_PARAMS = localActionParamIndex;
      $VALUES = new ActionParamIndex[] { ACTION_TYPE, IS_START, VELOCITY_X, VELOCITY_Y, VELOCITY_Z, DISTANCE, TIME, PROGRESS, localActionParamIndex };
    }
    
    private ActionParamIndex(int paramInt1, int paramInt2)
    {
      this.value = paramInt1;
      this.size = paramInt2;
    }
    
    public static ActionParamIndex find(int paramInt)
    {
      ActionParamIndex[] arrayOfActionParamIndex = values();
      int j = arrayOfActionParamIndex.length;
      int i = 0;
      while (i < j)
      {
        ActionParamIndex localActionParamIndex = arrayOfActionParamIndex[i];
        if (localActionParamIndex.getValue() == paramInt) {
          return localActionParamIndex;
        }
        i += 1;
      }
      return END_OF_PARAMS;
    }
    
    public static int getTotalPackageSize()
    {
      ActionParamIndex[] arrayOfActionParamIndex = values();
      int k = arrayOfActionParamIndex.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        j = j + 1 + 1 + arrayOfActionParamIndex[i].getSize();
        i += 1;
      }
      return j;
    }
    
    public int getSize()
    {
      return this.size;
    }
    
    public int getValue()
    {
      return this.value;
    }
  }
  
  public static abstract interface ActionType
  {
    public static final int CIRCLE = 1;
    public static final int DIAGONAL = 2;
    public static final int NONE = 0;
    public static final int ROCKY = 4;
    public static final int SPIRAL = 3;
  }
  
  public static abstract interface FailedReason
  {
    public static final int FAILED = 1;
    public static final int NONE = 0;
    public static final int UNKNOWN = 255;
  }
  
  public static class FailedReasonStruct
  {
    public int index;
    public int reason;
    
    public FailedReasonStruct() {}
    
    public FailedReasonStruct(int paramInt1, int paramInt2)
    {
      this.index = paramInt1;
      this.reason = paramInt2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeSetQuickMovieParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */