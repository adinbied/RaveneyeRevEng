package dji.midware.media.transcode.fullframe;

import android.media.MediaCodec.BufferInfo;
import dji.midware.media.DJIVideoHardwareEncoder;
import dji.midware.media.DJIVideoHardwareEncoder.VideoHardwareEncoderListener;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class FullFrameHardwareTranscoder
  implements DJIVideoHardwareEncoder.VideoHardwareEncoderListener
{
  private static final String ENCODER_SURFACE_NAME = "full_frame_hardware_transcoder_surface_name";
  private static FullFrameHardwareTranscoder instance;
  private int frameIntervalCache = -1;
  private DJIVideoHardwareEncoder hardwareEncoder;
  public int keyFrameRate = 5;
  private List<FullFrameTranscoderListener> listenerList = new LinkedList();
  private FullFrameTranscodeState transcodeState = FullFrameTranscodeState.Standby;
  
  public static FullFrameHardwareTranscoder getInstance()
  {
    if (instance == null)
    {
      instance = new FullFrameHardwareTranscoder();
      EventBus.getDefault().register(instance);
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
  
  private void restartEncode()
  {
    stopEncode();
    startEncode();
  }
  
  /* Error */
  private void startEncode()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  
  public int getFrameInterval()
  {
    return 0;
  }
  
  public int getKeyFrameRate()
  {
    return this.keyFrameRate;
  }
  
  public byte[] getPps()
  {
    return null;
  }
  
  public byte[] getSps()
  {
    return null;
  }
  
  public void onEncodeData(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    invokeListeners(paramByteBuffer, paramBufferInfo, paramInt1, paramInt2, paramBoolean);
  }
  
  public void onEncodeData(byte[] paramArrayOfByte, MediaCodec.BufferInfo paramBufferInfo, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DJIVideoEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  public void setFrameInterval(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setKeyFrameRate(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setTranscodeState(FullFrameTranscodeState paramFullFrameTranscodeState)
  {
    this.transcodeState = paramFullFrameTranscodeState;
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
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\fullframe\FullFrameHardwareTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */