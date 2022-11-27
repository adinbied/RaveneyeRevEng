package com.huawei.appmarket.component.buoycircle.impl.remote;

import java.util.ArrayList;
import java.util.List;

public class SequentialTaskManager
{
  private static final String TAG = SequentialTaskManager.class.getSimpleName();
  private String mData = null;
  private int mResult = 0;
  private List<SequentialTask> mTaskList = new ArrayList();
  
  /* Error */
  public void addTask(SequentialTask arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void run(RunTaskResultHandler arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static abstract interface RunTaskResultHandler
  {
    public abstract void onResult(int paramInt, String paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\impl\remote\SequentialTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */