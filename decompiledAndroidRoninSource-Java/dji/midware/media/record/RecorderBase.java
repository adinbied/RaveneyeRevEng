package dji.midware.media.record;

import dji.midware.media.DJIVideoUtil;
import dji.midware.media.metadata.VideoRecordInfo;
import dji.midware.media.metadata.VideoRecordInfoSetter;

public abstract class RecorderBase
  implements RecorderInterface
{
  protected RecorderStatus currentStatus = RecorderStatus.STANDBY;
  private int droneStartTimeMsec;
  private int lastSynchedFrameIndex;
  private long lastSynchedTime;
  private long localAbsBeginTime;
  protected String mainFileName = "";
  protected int numFrameWritten;
  protected Object recordStatusSwitchSync = new Object();
  protected VideoRecordInfo videoRecordInfo = null;
  protected VideoRecordInfoSetter videoRecordInfoSetter = null;
  
  private boolean checkIsDecoderReady(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  /* Error */
  protected void addToMediaLibrary(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void endRecordVideoInfo()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public RecorderStatus getCurrentStatus()
  {
    return this.currentStatus;
  }
  
  protected String getMainFileName()
  {
    return this.mainFileName;
  }
  
  public String getRecordingFileName()
  {
    return null;
  }
  
  protected abstract String getTAG();
  
  /* Error */
  protected void initPTSSync()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void onEndRecord();
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(RecorderManager.Service_Action arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected abstract void onStartRecord();
  
  protected void setMainFileName()
  {
    this.mainFileName = DJIVideoUtil.getOutputFileNameWithoutSuffix();
  }
  
  /* Error */
  protected void setNewStatus(RecorderStatus arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void startRecordVideoInfo()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void syncPTS()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class EventVideoCacheCompletion
  {
    private final String filePath;
    
    public EventVideoCacheCompletion(String paramString)
    {
      this.filePath = paramString;
    }
    
    public String getFilePath()
    {
      return this.filePath;
    }
  }
  
  public static enum RecorderStatus
  {
    static
    {
      RecorderStatus localRecorderStatus = new RecorderStatus("RECORDING", 1);
      RECORDING = localRecorderStatus;
      $VALUES = new RecorderStatus[] { STANDBY, localRecorderStatus };
    }
    
    private RecorderStatus() {}
  }
  
  private class ServiceEventHandler
    extends Thread
  {
    private RecorderManager.Service_Action event = null;
    
    public ServiceEventHandler(RecorderManager.Service_Action paramService_Action)
    {
      this.event = paramService_Action;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\record\RecorderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */