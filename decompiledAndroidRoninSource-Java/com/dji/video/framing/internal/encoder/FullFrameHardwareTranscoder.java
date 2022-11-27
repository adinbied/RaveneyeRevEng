package com.dji.video.framing.internal.encoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder;
import com.dji.video.framing.internal.decoder.decoderinterface.IDecoderStateListener;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class FullFrameHardwareTranscoder
  implements DJIVideoHardwareEncoder.VideoHardwareEncoderListener, IDecoderStateListener
{
  private static final String ENCODER_SURFACE_NAME = "full_frame_hardware_transcoder_surface_name";
  public static final String RESOLUTION_MODE_KEY = "resolution_mode_key";
  private static final String TAG = "FullFrameHardwareTranscoder";
  private static volatile FullFrameHardwareTranscoder instance;
  private int bitRate = 2097152;
  private FullFrameTransCodeCameraIndex cameraIndex = FullFrameTransCodeCameraIndex.Primary;
  private DJIVideoDecoder currentDecoder;
  private Object encoderLock = new Object();
  private int frameIntervalCache = 1;
  private DJIVideoHardwareEncoder hardwareEncoder;
  public int keyFrameRate = 30;
  private List<FullFrameTranscoderListener> listenerList = new LinkedList();
  private FullFrameTranscodeState transcodeState = FullFrameTranscodeState.Standby;
  
  private DJIVideoDecoder getDecoder()
  {
    return this.currentDecoder;
  }
  
  public static FullFrameHardwareTranscoder getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new FullFrameHardwareTranscoder();
        }
      }
      finally {}
    }
    return instance;
  }
  
  /* Error */
  private void invokeListeners(ByteBuffer arg1, MediaCodec.BufferInfo arg2, int arg3, int arg4, boolean arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void invokeListeners(byte[] arg1, MediaCodec.BufferInfo arg2, int arg3, int arg4, boolean arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean isDecoderOK()
  {
    return false;
  }
  
  /* Error */
  private void restartEncode()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private boolean startEncode()
  {
    return false;
  }
  
  /* Error */
  private void stopEncode()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addListener(FullFrameTranscoderListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public int getBitRate()
  {
    return this.bitRate;
  }
  
  public FullFrameTransCodeCameraIndex getCurrentCameraIndex()
  {
    return this.cameraIndex;
  }
  
  public ResolutionMode getDefaultResolutionMode()
  {
    return null;
  }
  
  public int getEncodeFps(DJIVideoDecoder paramDJIVideoDecoder)
  {
    if (paramDJIVideoDecoder == null) {
      return 0;
    }
    return paramDJIVideoDecoder.getFps();
  }
  
  public int[] getEncodeWidthHeight(DJIVideoDecoder paramDJIVideoDecoder)
  {
    return null;
  }
  
  public int getFrameInterval()
  {
    isDecoderOK();
    return this.frameIntervalCache;
  }
  
  public int getKeyFrameRate()
  {
    return this.keyFrameRate;
  }
  
  public MediaFormat getOutputFormat()
  {
    return null;
  }
  
  public byte[] getPps()
  {
    return null;
  }
  
  public ResolutionMode getResolutionMode()
  {
    return null;
  }
  
  public byte[] getSps()
  {
    return null;
  }
  
  public FullFrameTranscodeState getTranscodeState()
  {
    return this.transcodeState;
  }
  
  public void onEncodeData(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    invokeListeners(paramByteBuffer, paramBufferInfo, paramInt1, paramInt2, paramBoolean);
  }
  
  public void onEncodeData(byte[] paramArrayOfByte, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    invokeListeners(paramArrayOfByte, paramBufferInfo, paramInt1, paramInt2, paramBoolean);
  }
  
  /* Error */
  public void onStateChange(com.dji.video.framing.internal.decoder.DJIVideoDecoder.VideoDecoderState arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void removeListener(FullFrameTranscoderListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void setBitRate(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setCurrentCameraIndex(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setDecoder(DJIVideoDecoder arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setFrameInterval(int paramInt)
  {
    isDecoderOK();
    this.frameIntervalCache = paramInt;
  }
  
  /* Error */
  public void setKeyFrameRate(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setResolutionMode(ResolutionMode arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setTranscodeState(FullFrameTranscodeState paramFullFrameTranscodeState)
  {
    this.transcodeState = paramFullFrameTranscodeState;
  }
  
  public static enum FullFrameTransCodeCameraIndex
  {
    private final int value;
    
    static
    {
      FPV = new FullFrameTransCodeCameraIndex("FPV", 2, 2);
      FullFrameTransCodeCameraIndex localFullFrameTransCodeCameraIndex = new FullFrameTransCodeCameraIndex("UNKNOWN", 3, 255);
      UNKNOWN = localFullFrameTransCodeCameraIndex;
      $VALUES = new FullFrameTransCodeCameraIndex[] { Primary, Secondary, FPV, localFullFrameTransCodeCameraIndex };
    }
    
    private FullFrameTransCodeCameraIndex(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static FullFrameTransCodeCameraIndex find(int paramInt)
    {
      FullFrameTransCodeCameraIndex localFullFrameTransCodeCameraIndex = UNKNOWN;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localFullFrameTransCodeCameraIndex;
    }
    
    public int getValue()
    {
      return this.value;
    }
  }
  
  public static enum FullFrameTranscodeState
  {
    static
    {
      FullFrameTranscodeState localFullFrameTranscodeState = new FullFrameTranscodeState("Encoding", 2);
      Encoding = localFullFrameTranscodeState;
      $VALUES = new FullFrameTranscodeState[] { Standby, WaitForInput, localFullFrameTranscodeState };
    }
    
    private FullFrameTranscodeState() {}
  }
  
  public static abstract interface FullFrameTranscoderListener
  {
    public abstract void onFrameInput(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, boolean paramBoolean);
    
    public abstract void onFrameInput(byte[] paramArrayOfByte, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, boolean paramBoolean);
  }
  
  public static enum ResolutionMode
  {
    private int value;
    
    static
    {
      ResolutionMode localResolutionMode = new ResolutionMode("Fix720p", 1, 1);
      Fix720p = localResolutionMode;
      $VALUES = new ResolutionMode[] { SameWithDecoder, localResolutionMode };
    }
    
    private ResolutionMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static ResolutionMode find(int paramInt)
    {
      ResolutionMode localResolutionMode = SameWithDecoder;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i].getValue() == paramInt) {
          return values()[i];
        }
        i += 1;
      }
      return localResolutionMode;
    }
    
    public int getValue()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\encoder\FullFrameHardwareTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */