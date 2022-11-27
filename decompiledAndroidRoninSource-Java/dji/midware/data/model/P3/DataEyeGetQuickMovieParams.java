package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;
import java.util.ArrayList;

public class DataEyeGetQuickMovieParams
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataEyeGetQuickMovieParams instance;
  private ArrayList<Integer> requestedIndexs;
  
  public static DataEyeGetQuickMovieParams getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataEyeGetQuickMovieParams();
      }
      DataEyeGetQuickMovieParams localDataEyeGetQuickMovieParams = instance;
      return localDataEyeGetQuickMovieParams;
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
  
  public ArrayList<DataEyeSetQuickMovieParams.ActionParam> getQuickMovieParams()
  {
    return null;
  }
  
  public DataEyeGetQuickMovieParams setRequestedIndex(ArrayList<Integer> paramArrayList)
  {
    this.requestedIndexs = paramArrayList;
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeGetQuickMovieParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */