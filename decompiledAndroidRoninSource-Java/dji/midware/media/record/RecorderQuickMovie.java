package dji.midware.media.record;

import android.media.MediaCodec.BufferInfo;
import dji.log.RoninLog;
import dji.midware.data.manager.P3.ServiceManager;
import dji.midware.media.DJIVideoDecoder;
import dji.midware.media.DJIVideoHardwareEncoder;
import dji.midware.media.DJIVideoHardwareEncoder.VideoHardwareEncoderListener;
import dji.midware.media.MediaLogger;
import dji.midware.media.muxer.DJIMuxerInterface;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.greenrobot.eventbus.EventBus;

public class RecorderQuickMovie
  extends RecorderBase
  implements RecorderInterface
{
  private static final boolean DEBUG = false;
  private static final String NORMAL_ENCOCER_SURFACE_NAME = "recorder_quick_movie_normal_encoder_surface_name";
  private static final int NORMAL_KEY_FRAME_INTERVAL = 30;
  private static final String QUICK_ENCOCER_SURFACE_NAME = "recorder_quick_movie_quick_encoder_surface_name";
  private static final int QUICK_MOVIE_DRAW_INTERVAL = 5;
  private static final int QUICK_MOVIE_END_DURATION_IN_SEC = 3;
  private static final int QUICK_MOVIE_KEY_FRAME_INTERVAL = 5;
  private static final int QUICK_MOVIE_START_DURATION_IN_SEC = 3;
  public static String TAG = "RecorderQuickMovie";
  private static RecorderQuickMovie instance;
  private QuickMovieRecorderState curQuickMovieState;
  private long initial_original_pts = -1L;
  private long last_original_pts = -1L;
  private long last_written_pts = -1L;
  private DJIMuxerInterface muxer = null;
  private boolean muxerInitialized = false;
  private DJIVideoHardwareEncoder normalEncoder;
  private DJIVideoHardwareEncoder.VideoHardwareEncoderListener normalEncoderListener = new DJIVideoHardwareEncoder.VideoHardwareEncoderListener()
  {
    public void onEncodeData(ByteBuffer paramAnonymousByteBuffer, MediaCodec.BufferInfo paramAnonymousBufferInfo, int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean) {}
    
    /* Error */
    public void onEncodeData(byte[] arg1, MediaCodec.BufferInfo arg2, int arg3, int arg4, boolean arg5)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private BlockingQueue<QuickMovieFrameInfo> normalFramesQueue = new ArrayBlockingQueue(120);
  private DJIVideoHardwareEncoder quickEncoder;
  private BlockingQueue<QuickMovieFrameInfo> quickFramesQueue = new ArrayBlockingQueue(30);
  private DJIVideoHardwareEncoder.VideoHardwareEncoderListener quickMovieEncoderListener = new DJIVideoHardwareEncoder.VideoHardwareEncoderListener()
  {
    public void onEncodeData(ByteBuffer paramAnonymousByteBuffer, MediaCodec.BufferInfo paramAnonymousBufferInfo, int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean) {}
    
    /* Error */
    public void onEncodeData(byte[] arg1, MediaCodec.BufferInfo arg2, int arg3, int arg4, boolean arg5)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private ServiceManager serviceMangaer;
  private long startTime = 0L;
  
  private RecorderQuickMovie()
  {
    MediaLogger.i(TAG, "An instance is created");
  }
  
  /* Error */
  private void closeOrDeleteFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void createFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static void destroy()
  {
    try
    {
      MediaLogger.show("RecorderFullFrame will be destroyed asynchronously");
      if (instance != null)
      {
        instance.onDestroy();
        instance = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static RecorderQuickMovie getInstance()
  {
    try
    {
      if (instance == null)
      {
        instance = new RecorderQuickMovie();
        EventBus.getDefault().register(instance);
      }
      RecorderQuickMovie localRecorderQuickMovie = instance;
      return localRecorderQuickMovie;
    }
    finally {}
  }
  
  /* Error */
  private void initMuxer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void removeGop(BlockingQueue<QuickMovieFrameInfo> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void stopEncoders()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void writeFrameToMuxer(QuickMovieFrameInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void writeFrameToMuxer(BlockingQueue<QuickMovieFrameInfo> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected String getTAG()
  {
    return TAG;
  }
  
  /* Error */
  protected void onEndRecord()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onStartRecord()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setCurQuickMovieState(QuickMovieRecorderState paramQuickMovieRecorderState)
  {
    try
    {
      this.curQuickMovieState = paramQuickMovieRecorderState;
      return;
    }
    finally
    {
      paramQuickMovieRecorderState = finally;
      throw paramQuickMovieRecorderState;
    }
  }
  
  /* Error */
  public void setQuickMovieType(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  public void writeFrameToMuxer(ByteBuffer arg1, MediaCodec.BufferInfo arg2, int arg3, int arg4, boolean arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static class QuickMovieFrameInfo
  {
    public long createTime;
    public byte[] data;
    public long decoderLatestPts;
    public int flags;
    public int height;
    public boolean isKeyFrame;
    public long lastExtraDrawTime;
    public long originPts;
    public int width;
    
    public QuickMovieFrameInfo(byte[] paramArrayOfByte, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
    {
      long l = -1L;
      this.lastExtraDrawTime = -1L;
      this.data = paramArrayOfByte;
      this.flags = paramBufferInfo.flags;
      this.isKeyFrame = paramBoolean;
      this.width = paramInt1;
      this.height = paramInt2;
      this.originPts = paramBufferInfo.presentationTimeUs;
      if ((paramString != null) && (!"".equals(paramString)) && (ServiceManager.getInstance().getDecoder() != null)) {
        this.lastExtraDrawTime = ServiceManager.getInstance().getDecoder().getLastExtraDrawTime(paramString);
      }
      if (ServiceManager.getInstance().getDecoder() != null) {
        l = ServiceManager.getInstance().getDecoder().latestPTS;
      }
      this.decoderLatestPts = l;
      this.createTime = System.currentTimeMillis();
      paramArrayOfByte = RecorderQuickMovie.TAG;
      paramBufferInfo = new StringBuilder();
      paramBufferInfo.append("QuickMovieFrameInfo: input surface key: ");
      paramBufferInfo.append(paramString);
      paramBufferInfo.append(", last draw time: ");
      paramBufferInfo.append(this.lastExtraDrawTime);
      RoninLog.d(paramArrayOfByte, paramBufferInfo.toString(), new Object[0]);
    }
    
    /* Error */
    public void writeToMuxer(DJIMuxerInterface arg1, long arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static enum QuickMovieRecorderState
  {
    static
    {
      RecordingStart = new QuickMovieRecorderState("RecordingStart", 1);
      RecordingTransition = new QuickMovieRecorderState("RecordingTransition", 2);
      RecordingQuickMovie = new QuickMovieRecorderState("RecordingQuickMovie", 3);
      QuickMovieRecorderState localQuickMovieRecorderState = new QuickMovieRecorderState("RecordingEnd", 4);
      RecordingEnd = localQuickMovieRecorderState;
      $VALUES = new QuickMovieRecorderState[] { Standby, RecordingStart, RecordingTransition, RecordingQuickMovie, localQuickMovieRecorderState };
    }
    
    private QuickMovieRecorderState() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\record\RecorderQuickMovie.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */