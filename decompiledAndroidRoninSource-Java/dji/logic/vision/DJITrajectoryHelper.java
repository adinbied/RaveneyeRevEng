package dji.logic.vision;

import dji.midware.data.manager.P3.DataCameraEvent;
import dji.midware.data.model.P3.DataEyeGetPushTrajectory.PolynomialTrajectory;
import java.util.TreeSet;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DJITrajectoryHelper
{
  private final TreeSet<TrajectoryInfo> mTrajectoryInfoSet = new TreeSet();
  
  private DJITrajectoryHelper()
  {
    EventBus.getDefault().register(this);
  }
  
  public static DJITrajectoryHelper getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  /* Error */
  public void checkNotifyDataFinished()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void clearAllDatas()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public TreeSet<TrajectoryInfo> getTrajectoryInfoSet()
  {
    return this.mTrajectoryInfoSet;
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraEvent paramDataCameraEvent)
  {
    if (DataCameraEvent.ConnectLose == paramDataCameraEvent) {
      clearAllDatas();
    }
  }
  
  /* Error */
  public void updateTrajectory(dji.midware.data.model.P3.DataEyeGetPushTrajectory arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static final class SingletonHolder
  {
    private static final DJITrajectoryHelper mInstance = new DJITrajectoryHelper(null);
  }
  
  public static enum TrajectoryEvent
  {
    static
    {
      TrajectoryEvent localTrajectoryEvent = new TrajectoryEvent("TRAJECTORY_FINISHED", 0);
      TRAJECTORY_FINISHED = localTrajectoryEvent;
      $VALUES = new TrajectoryEvent[] { localTrajectoryEvent };
    }
    
    private TrajectoryEvent() {}
  }
  
  public static final class TrajectoryInfo
    implements Comparable<TrajectoryInfo>
  {
    public int mCount = 0;
    public int mFragmentIndex = 0;
    public DataEyeGetPushTrajectory.PolynomialTrajectory[] mPolynomialTrajectories = null;
    public int mSessionId = 0;
    public boolean mbLastFragment = false;
    
    public TrajectoryInfo(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, DataEyeGetPushTrajectory.PolynomialTrajectory[] paramArrayOfPolynomialTrajectory)
    {
      this.mFragmentIndex = paramInt1;
      this.mbLastFragment = paramBoolean;
      this.mSessionId = paramInt2;
      this.mCount = paramInt3;
      this.mPolynomialTrajectories = paramArrayOfPolynomialTrajectory;
    }
    
    public int compareTo(TrajectoryInfo paramTrajectoryInfo)
    {
      return this.mFragmentIndex - paramTrajectoryInfo.mFragmentIndex;
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    public String toString()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\vision\DJITrajectoryHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */