package dji.midware.media.newframing;

import android.content.Context;
import com.dji.video.framing.DJIVideoDecoderInterface;
import com.dji.video.framing.DJIVideoDecoderInterface.VideoRecordFilSavedListener;
import com.dji.video.framing.DJIVideoHEVCFomatManager.HevcChangeCallback;
import com.dji.video.framing.internal.VideoFrame;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder.VideoDecoderEventListener;
import com.dji.video.framing.internal.decoder.ErrorStatusManager.FrameCheckerCallback;
import com.dji.video.framing.internal.decoder.GdrKeyFrameGenerator.KeyFrameResCallback;
import com.dji.video.framing.internal.decoder.decoderinterface.IReceiveDataCallback;
import com.dji.video.framing.internal.opengl.surface.SurfaceInterface;
import com.dji.video.framing.internal.parser.VideoStreamParseController;
import com.dji.video.framing.internal.parser.VideoStreamParseController.FrameDataOutputCallback;
import com.dji.video.framing.internal.recorder.RecorderManager;
import com.dji.video.framing.internal.recorder.RecorderManager.RecorderManagerCallback;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.media.metadata.VideoRecordInfoBuild;

public class DJIVideoCodecManager
  implements DJIVideoDecoderInterface
{
  private static final String TAG = "DJIVideoCodecManager";
  private Context mContext;
  private DJIVideoDecoder mDJIVideoDecoder;
  private ErrorStatusManager.FrameCheckerCallback mFrameCheckerCallback = new ErrorStatusManager.FrameCheckerCallback()
  {
    public boolean getErrorStatus()
    {
      return true;
    }
    
    public boolean isDemandI()
    {
      return false;
    }
    
    public boolean needCheckFrame()
    {
      return isDemandI();
    }
    
    /* Error */
    public void onErrorStatusChange(boolean arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    public boolean supportHevcTransfer()
    {
      return false;
    }
  };
  private VideoStreamParseController.FrameDataOutputCallback mFrameDataOutputCallback = new VideoStreamParseController.FrameDataOutputCallback()
  {
    public boolean onFrameOutput(VideoFrame paramAnonymousVideoFrame)
    {
      return false;
    }
  };
  private DJIVideoHEVCFomatManager.HevcChangeCallback mHevcChangeCallback = new DJIVideoHEVCFomatManager.HevcChangeCallback()
  {
    /* Error */
    public void onHevcModeChanged(boolean arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onHevcModeUnMatched(boolean arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
  };
  private DJIVideoHevcControl.HevcDisposeStatusListener mHevcDisposeStatusListener = new DJIVideoHevcControl.HevcDisposeStatusListener()
  {
    /* Error */
    public void onHevcControlRelease()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private GdrKeyFrameGenerator.KeyFrameResCallback mKeyFrameResCallback = -..Lambda.DJIVideoCodecManager.phT_chytyHOJdsmRV6OGdZOlSD8.INSTANCE;
  private RecorderManager mRecorderManager;
  private RecorderManager.RecorderManagerCallback mRecorderManagerCallback = new RecorderManager.RecorderManagerCallback()
  {
    /* Error */
    public void onError(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onFileCompleted(String arg1, double arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onFileCreated()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onMuxerStarted()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onMuxerStoped()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSpaceReleaseFinish()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private DJIVideoDecoderInterface.VideoRecordFilSavedListener mVideoRecordFilSavedListener;
  private VideoRecordInfoBuild mVideoRecordInfoSetter;
  private VideoStreamParseController mVideoStreamParseController;
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public DJIVideoDecoder getDJIVideoDecoder()
  {
    return this.mDJIVideoDecoder;
  }
  
  public VideoStreamParseController getParseController()
  {
    return this.mVideoStreamParseController;
  }
  
  public void initDJIVideoDecoder(Context paramContext, SurfaceInterface paramSurfaceInterface)
  {
    initDJIVideoDecoder(paramContext, false, paramSurfaceInterface);
  }
  
  /* Error */
  public void initDJIVideoDecoder(Context arg1, boolean arg2, SurfaceInterface arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void postStartDecodeEvent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setPause(boolean paramBoolean)
  {
    DJIVideoDecoder localDJIVideoDecoder = this.mDJIVideoDecoder;
    if (localDJIVideoDecoder != null) {
      localDJIVideoDecoder.setPause(paramBoolean);
    }
  }
  
  public void setReceiverDataCallback(IReceiveDataCallback paramIReceiveDataCallback)
  {
    DJIVideoDecoder localDJIVideoDecoder = this.mDJIVideoDecoder;
    if (localDJIVideoDecoder != null) {
      localDJIVideoDecoder.setRecvDataCallBack(paramIReceiveDataCallback);
    }
  }
  
  /* Error */
  public void setRecordingCacheSizeLimit(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setSurface(SurfaceInterface arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setVideoDecoderEventListener(DJIVideoDecoder.VideoDecoderEventListener paramVideoDecoderEventListener)
  {
    DJIVideoDecoder localDJIVideoDecoder = this.mDJIVideoDecoder;
    if (localDJIVideoDecoder != null) {
      localDJIVideoDecoder.setmVideoDecoderEventListener(paramVideoDecoderEventListener);
    }
  }
  
  public void setVideoRecordFilSavedListener(DJIVideoDecoderInterface.VideoRecordFilSavedListener paramVideoRecordFilSavedListener)
  {
    this.mVideoRecordFilSavedListener = paramVideoRecordFilSavedListener;
  }
  
  /* Error */
  public void startVideoRecording(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void stopVideoRecording()
  {
    this.mRecorderManager.stop();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\newframing\DJIVideoCodecManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */