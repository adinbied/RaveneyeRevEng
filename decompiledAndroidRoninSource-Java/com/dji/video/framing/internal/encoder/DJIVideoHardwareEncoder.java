package com.dji.video.framing.internal.encoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class DJIVideoHardwareEncoder
{
  private static final boolean DEBUG = false;
  private static final String MIME = "video/avc";
  private static final int MSG_QUEUE_FRAME_INTO_ENCODER = 0;
  private static final int MSG_RELEASE_ENCODER = 1;
  private static final int MSG_RESTART_ENCODER = 2;
  private static final String TAG = "DJIVideoHardwareEncoder";
  private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
  private MediaCodec encoder;
  private Handler encoderHandler;
  private HandlerThread encoderHandlerThread;
  private Object encoderLock = new Object();
  public int height = 8;
  private ByteBuffer[] inputBuffers;
  private boolean isEncoderInited = false;
  private List<VideoHardwareEncoderListener> listenerList = new LinkedList();
  private List<VideoHardwareEncoderListener> listenersWaiting = new LinkedList();
  private Surface mInputSurface;
  private boolean mKeyFrameHasSpsPps = false;
  private int originBitRate = 10485760;
  private int originKeyframeRate = 30;
  private ByteBuffer[] outputBuffers;
  private MediaFormat outputFormat;
  public byte[] pps;
  public byte[] sps;
  public int width = 16;
  
  public static byte[] byteArrAdd(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 == null) {
      return paramArrayOfByte2;
    }
    if (paramArrayOfByte2 == null) {
      return paramArrayOfByte1;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  /* Error */
  private void dequeueDataFromEncoder()
    throws java.lang.IllegalStateException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private static int findPpsHeadIndex(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 3) {
      return -1;
    }
    int i = 0;
    while (i < paramArrayOfByte.length - 3)
    {
      if ((paramArrayOfByte[i] == 0) && (paramArrayOfByte[(i + 1)] == 0))
      {
        int j = i + 2;
        if (paramArrayOfByte[j] == 0)
        {
          if ((paramArrayOfByte[(i + 3)] == 1) && ((paramArrayOfByte[(i + 4)] & 0x1F) == 8)) {
            return i;
          }
        }
        else if ((paramArrayOfByte[j] == 1) && ((paramArrayOfByte[(i + 4)] & 0x1F) == 8)) {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  /* Error */
  private void invokeOnEncodeData(ByteBuffer arg1, MediaCodec.BufferInfo arg2, int arg3, int arg4, boolean arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void invokeOnEncodeData(byte[] arg1, MediaCodec.BufferInfo arg2, int arg3, int arg4, boolean arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void onOutputBufferChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void onOutputFormatChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void onOutputFrame(ByteBuffer arg1, MediaCodec.BufferInfo arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void releaseEncoder()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void startEncodingHandler()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void stopEncodingHandler()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addListener(VideoHardwareEncoderListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Surface getInputSurface()
  {
    return this.mInputSurface;
  }
  
  public MediaFormat getOutputFormat()
  {
    return null;
  }
  
  public boolean isEncoding()
  {
    return false;
  }
  
  public boolean isListenerListEmpty()
  {
    return this.listenerList.isEmpty();
  }
  
  public void pause()
  {
    stopEncodingHandler();
  }
  
  /* Error */
  public void removeListener(VideoHardwareEncoderListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void resume()
  {
    startEncodingHandler();
  }
  
  public void start(int paramInt1, int paramInt2)
  {
    start(paramInt1, paramInt2, this.originKeyframeRate, this.originBitRate);
  }
  
  public void start(int paramInt1, int paramInt2, int paramInt3)
  {
    start(paramInt1, paramInt2, paramInt3, this.originBitRate);
  }
  
  /* Error */
  public void start(int arg1, int arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: goto +7 -> 7
    //   3: return
    //   4: astore 5
    //   6: return
    //   7: goto -4 -> 3
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class RawFrame
  {
    private byte[] data;
    private long updateTime;
    
    public RawFrame(byte[] paramArrayOfByte)
    {
      this.data = paramArrayOfByte;
      this.updateTime = System.currentTimeMillis();
    }
    
    public byte[] getData()
    {
      return this.data;
    }
    
    public long getUpdateTime()
    {
      return this.updateTime;
    }
  }
  
  public static abstract interface VideoHardwareEncoderListener
  {
    public abstract void onEncodeData(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, boolean paramBoolean);
    
    public abstract void onEncodeData(byte[] paramArrayOfByte, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\encoder\DJIVideoHardwareEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */