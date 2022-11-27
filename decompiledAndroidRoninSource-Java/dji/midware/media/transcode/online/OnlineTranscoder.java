package dji.midware.media.transcode.online;

import android.media.MediaCodec.BufferInfo;
import dji.log.RoninLog;
import dji.midware.data.config.P3.ProductType;
import dji.midware.link.DJILinkDaemonService;
import dji.midware.media.MediaLogger;
import dji.midware.media.record.H264FrameListener;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;

public class OnlineTranscoder
  implements Runnable, H264FrameListener, DecoderListener
{
  public static boolean DEBUG = false;
  private static boolean DEBUG_WRITE_TRANSCODED_STREAM = false;
  private static boolean DEBUG_WRITE_YUV_IMAGE = false;
  public static String TAG_Decoder = "Transcoder_Decoder";
  public static String TAG_H264 = "Transcoder_H264";
  public static String TAG_Internal = "Transcoder_Internal";
  public static String TAG_Output = "Transcoder_Output";
  private static OnlineTranscoder instance;
  private BufferedOutputStream h264BufferedOutputStream = null;
  private OutputStream h264OutputStream = null;
  boolean hasDumpYUV = false;
  private IFrameMaker iframeMaker = new IFrameMaker();
  private MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
  private long lastIFrame;
  DJILinkDaemonService linkDaemonService = null;
  private LinkedList<OnlineTranscoderListener> listenerList = new LinkedList();
  private Object listenerSync = new Object();
  private ProductType mCurrentProduct;
  int numFrameJumped = 0;
  private int numFrameWritten;
  private FrameBuffer originBuffer;
  private int preFrameHeight;
  private int preFrameWidth;
  private FrameBuffer replaceBuffer;
  private boolean running = false;
  private OnlineTranscoderStatus status = OnlineTranscoderStatus.STANDBY;
  private Thread threadTranscoder;
  boolean toSkipHead = false;
  Object waitForReplace = new Object();
  
  private Frame _getFrame()
  {
    return null;
  }
  
  private Frame getFrame()
  {
    return null;
  }
  
  public static OnlineTranscoder getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new OnlineTranscoder();
      }
      OnlineTranscoder localOnlineTranscoder = instance;
      return localOnlineTranscoder;
    }
    finally {}
  }
  
  /* Error */
  private void h264FileClose()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void h264FileCreate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void h264FileWrite(ByteBuffer arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean isGDR()
  {
    return false;
  }
  
  private boolean makeIFrame(Frame paramFrame)
  {
    return false;
  }
  
  private boolean needWaitIFrame(long paramLong)
  {
    return false;
  }
  
  /* Error */
  private void releaseFrame(Frame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void startService()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void stopService()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void writeYUVToFile(ByteBuffer arg1, MediaCodec.BufferInfo arg2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addListener(OnlineTranscoderListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void attachListenerToUpstream()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void destroy()
  {
    this.iframeMaker.deinit();
  }
  
  /* Error */
  public void detachListenerToUpstream()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void feedRawFrame(Frame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Frame getRawFrameContainer()
  {
    return this.replaceBuffer.getFrame();
  }
  
  public boolean needMakeIFrame(long paramLong)
  {
    return false;
  }
  
  public void onColorFormatChanged(int paramInt) {}
  
  /* Error */
  public void onH264FrameInput(byte[] arg1, int arg2, long arg3, boolean arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void onSpsPpsChanged(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, int paramInt3)
  {
    RoninLog.i(TAG_Internal, "onSpsPpschange", new Object[0]);
    MediaLogger.show(TAG_Internal, "onSpsPpschange");
  }
  
  public void onWidthHeightChanged(int paramInt1, int paramInt2) {}
  
  /* Error */
  public void removeListener(OnlineTranscoderListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static abstract interface OnlineTranscoderListener
  {
    public abstract void onFrameInput(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, int paramInt3);
  }
  
  protected static enum OnlineTranscoderStatus
  {
    static
    {
      OnlineTranscoderStatus localOnlineTranscoderStatus = new OnlineTranscoderStatus("TRANSCODING", 1);
      TRANSCODING = localOnlineTranscoderStatus;
      $VALUES = new OnlineTranscoderStatus[] { STANDBY, localOnlineTranscoderStatus };
    }
    
    private OnlineTranscoderStatus() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\online\OnlineTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */