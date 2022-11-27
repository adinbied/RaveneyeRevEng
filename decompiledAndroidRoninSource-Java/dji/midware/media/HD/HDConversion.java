package dji.midware.media.HD;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import dji.logic.album.manager.DJIAlbumInterface.DJIAlbumPullListener;
import dji.midware.data.model.P3.DataCameraControlTransCode;
import dji.midware.data.model.P3.DataCameraGetFileParams;
import dji.midware.data.model.P3.DataCameraGetMode.MODE;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.media.MediaLogger;
import dji.midware.media.metadata.VideoRecordInfo;
import java.util.Vector;

public class HDConversion
{
  private static final boolean DEBUG = true;
  private static final long DOWNLOAD_TIME_OUT = 5000L;
  private static final String TAG = "HDConversion";
  private static HDConversion instance;
  CallBackGetHD callback;
  DJIClipFile clipFile;
  DJIClipFileLoader clipFileLoader = new DJIClipFileLoader();
  DJIClipInfoListLoader clipListLoader = new DJIClipInfoListLoader();
  DJIClipInfoList clipListState;
  int commitID;
  private Controller controller;
  DataCameraControlTransCode ctrTransCode = DataCameraControlTransCode.getInstance();
  DataCameraGetFileParams dcGetFileParams = DataCameraGetFileParams.getInstance();
  int downloadingSegmentIndex;
  long lastbyteRecievedTime;
  int numFinishedDownload;
  int numFinishedError;
  int numPendingTranscodeResult;
  DataCameraGetMode.MODE originMode;
  int querySourceFileID;
  private long[] segmentReceivedBytes;
  private SegmentStatus[] segmentStatus;
  private long[] segmentTotalBytes;
  private State state = State.Uninitialized;
  String targetDirectory;
  private HandlerThread thread = new HandlerThread("HDConversionThread");
  Vector<VideoRecordInfo> vecSegmentMix;
  
  public HDConversion()
  {
    this.thread.start();
    MediaLogger.i("HDConversion", "thread started");
    this.controller = new Controller(this.thread.getLooper());
  }
  
  /* Error */
  private void doAnalyzeTranscodeStatus()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void doGetFileParams()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void doGetOriginalMode()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void doOnError(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void doOnSuccess()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void doQueryTranscodeStatus()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void doRequestTranscoding()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void doRestoreToOriginalMode()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void doStart()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void doSwitchToTranscode()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void doWaitForDownloading()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void downloadFile(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private boolean downloadNext()
  {
    return false;
  }
  
  public static HDConversion getInstance()
  {
    if (instance == null) {
      instance = new HDConversion();
    }
    return instance;
  }
  
  /* Error */
  private void updateProgress()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void getHDSegments(Vector<VideoRecordInfo> arg1, String arg2, CallBackGetHD arg3)
    throws Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static class Action
  {
    public final long param;
    public final Object param2;
    public final int type;
    
    public Action(int paramInt, long paramLong)
    {
      this.type = paramInt;
      this.param = paramLong;
      this.param2 = null;
    }
    
    public Action(int paramInt, long paramLong, Object paramObject)
    {
      this.type = paramInt;
      this.param = paramLong;
      this.param2 = paramObject;
    }
    
    public int what()
    {
      return this.type;
    }
  }
  
  public static abstract interface CallBackGetHD
  {
    public abstract void onFail(Exception paramException);
    
    public abstract void onProgress(int paramInt);
    
    public abstract void onStart();
    
    public abstract void onSuccess();
  }
  
  private class Controller
    extends Handler
  {
    private HDConversion.Action act = null;
    private boolean processed = true;
    
    public Controller(Looper paramLooper)
    {
      super();
    }
    
    /* Error */
    private void asyncCommand(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    private void asyncCommand(int arg1, long arg2, Object arg4)
    {
      // Byte code:
      //   0: return
      //   1: astore 4
      //   3: goto -3 -> 0
    }
    
    /* Error */
    private void asyncCommandDelayed(int arg1, long arg2, long arg4, Object arg6)
    {
      // Byte code:
      //   0: return
      //   1: astore 6
      //   3: goto -3 -> 0
    }
    
    /* Error */
    private void asyncCommandDelayedAbsolute(int arg1, long arg2, long arg4, Object arg6)
    {
      // Byte code:
      //   0: return
      //   1: astore 6
      //   3: goto -3 -> 0
    }
    
    /* Error */
    private void notifyCaller(HDConversion.Action arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void release()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static enum ErrorType
  {
    static
    {
      Disconnected = new ErrorType("Disconnected", 1);
      INVALID_PARAM_OR_ERR_UNSPECIFIED = new ErrorType("INVALID_PARAM_OR_ERR_UNSPECIFIED", 2);
      ErrorType localErrorType = new ErrorType("DownloadTimeOut", 3);
      DownloadTimeOut = localErrorType;
      $VALUES = new ErrorType[] { TimeOut, Disconnected, INVALID_PARAM_OR_ERR_UNSPECIFIED, localErrorType };
    }
    
    private ErrorType() {}
  }
  
  public static class EventType
  {
    static final int AnalyzeTranscodeStatus = 6;
    static final int GetFileParams = 3;
    static final int GetOriginalMode = 1;
    static final int NUM_ACTIONTYPE = 11;
    static final int OnError = 8;
    static final int OnSuccess = 10;
    static final int QueryTranscodeStatus = 5;
    static final int RequestTranscoding = 4;
    static final int RestoreToOriginalMode = 7;
    static final int Start = 0;
    static final int SwitchToTranscode = 2;
    static final int WaitForDownloading = 9;
    
    public static String getName(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "Unrecognised";
      case 10: 
        return "OnSuccess";
      case 9: 
        return "WaitForDownloading";
      case 8: 
        return "OnError";
      case 7: 
        return "RestoreToOriginalMode";
      case 6: 
        return "AnalyzeTranscodeStatus";
      case 5: 
        return "QueryTranscodingStatus";
      case 4: 
        return "RequestTranscoding";
      case 3: 
        return "GetFileParams";
      case 2: 
        return "SwitchToTranscoding";
      case 1: 
        return "GetOriginalMode";
      }
      return "Start";
    }
  }
  
  public static class HDSegment
  {
    private final int end;
    private final int start;
    
    public HDSegment(int paramInt1, int paramInt2)
    {
      this.start = paramInt1;
      this.end = paramInt2;
    }
    
    public int getEndTime()
    {
      return this.end;
    }
    
    public int getStartTime()
    {
      return this.start;
    }
  }
  
  private static enum SegmentStatus
  {
    static
    {
      HasDownloaded = new SegmentStatus("HasDownloaded", 2);
      SegmentStatus localSegmentStatus = new SegmentStatus("Failure", 3);
      Failure = localSegmentStatus;
      $VALUES = new SegmentStatus[] { PendingTranscodeResult, ToDownload, HasDownloaded, localSegmentStatus };
    }
    
    private SegmentStatus() {}
  }
  
  public static enum State
  {
    static
    {
      Started = new State("Started", 1);
      SentGetOriginalMode = new State("SentGetOriginalMode", 2);
      SentSwithToTranscode = new State("SentSwithToTranscode", 3);
      SentGetFileParams = new State("SentGetFileParams", 4);
      SentRequestTranscoding = new State("SentRequestTranscoding", 5);
      SentQueryTranscodeStatus = new State("SentQueryTranscodeStatus", 6);
      WaitForDownloading = new State("WaitForDownloading", 7);
      AllFileDownloaded = new State("AllFileDownloaded", 8);
      SentSwitchBack = new State("SentSwitchBack", 9);
      Success = new State("Success", 10);
      State localState = new State("Error", 11);
      Error = localState;
      $VALUES = new State[] { Uninitialized, Started, SentGetOriginalMode, SentSwithToTranscode, SentGetFileParams, SentRequestTranscoding, SentQueryTranscodeStatus, WaitForDownloading, AllFileDownloaded, SentSwitchBack, Success, localState };
    }
    
    private State() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\HD\HDConversion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */