package dji.midware.media;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import dji.midware.media.record.H264FrameListener;
import dji.midware.media.record.MainFrameDataListener;
import dji.midware.natives.FPVController;

public class DJIVideoDataRecver
{
  private static boolean DEBUG = false;
  private static String TAG = "DJIVideoDataRecver";
  private static DJIVideoDataRecver instance;
  long[] frameIndex = { -1L, -1L };
  int[] frameNum = { 0, 0 };
  private boolean isNeedPacked = true;
  private boolean isNeedRawData = false;
  long jpeg_frame_index = 0L;
  long lastT1 = 0L;
  private long last_video_frame_coming_time = -1L;
  private H264FrameListener listener;
  private DJIVideoDataListener listenerForFPVTrans;
  private DJIVideoDataListener listenerForTrans;
  private Object listenerSync = new Object();
  private FrameRecv mFrameRecv = new FrameRecv();
  private MainFrameDataListener mainFrameDataListener;
  long maxTime = 0L;
  int maxsize = 0;
  private boolean needFrameData = false;
  long time = 0L;
  private DJIDecoderType type = DJIDecoderType.None;
  
  /* Error */
  private void addDelayForLoadingStreamFromFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static DJIVideoDataRecver getInstance()
  {
    if (instance == null) {
      instance = new DJIVideoDataRecver();
    }
    return instance;
  }
  
  public static boolean isTablet(Context paramContext)
  {
    return (paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 3;
  }
  
  public DJIDecoderType getDecoderType()
  {
    return this.type;
  }
  
  public boolean isNeedFrameData()
  {
    return this.needFrameData;
  }
  
  public boolean isNeedRawData()
  {
    return this.isNeedRawData;
  }
  
  public void onAudioRecv(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong)
  {
    if (this.isNeedPacked) {
      putAudioBufferToDecoder(paramArrayOfByte, paramInt1, paramInt2, paramLong);
    }
  }
  
  public void onAudioRecv(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    if (this.isNeedPacked) {
      putAudioBufferToDecoder(paramArrayOfByte, paramInt, paramLong);
    }
  }
  
  public void onCmdDataRecv(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  /* Error */
  public void onJpegFrameRecv(byte[] arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onVideoRecv(byte[] arg1, int arg2, int arg3, int arg4, boolean arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, boolean arg12)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onVideoRecv(byte[] arg1, int arg2, int arg3, int arg4, boolean arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, boolean arg12, int arg13)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void onVideoRecv(byte[] arg1, int arg2, int arg3, boolean arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onVideoRecv(byte[] arg1, int arg2, int arg3, boolean arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, boolean arg11)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onVideoRecv(byte[] arg1, int arg2, int arg3, boolean arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, boolean arg11, int arg12)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onVideoRecv(byte[] arg1, int arg2, boolean arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onVideoRecv(byte[] arg1, int arg2, boolean arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void putAudioBufferToDecoder(byte[] arg1, int arg2, int arg3, long arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void putAudioBufferToDecoder(byte[] arg1, int arg2, long arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void putBufferToDecoder(byte[] arg1, int arg2, long arg3, int arg5, boolean arg6, long arg7, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, dji.midware.usb.P3.UsbAccessoryService.VideoStreamSource arg15)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DJIVideoDataRecver setDecoderType(DJIDecoderType paramDJIDecoderType)
  {
    return null;
  }
  
  public DJIVideoDataRecver setFPVVideoDataListener(boolean paramBoolean, DJIVideoDataListener paramDJIVideoDataListener)
  {
    this.isNeedPacked = paramBoolean;
    this.listenerForFPVTrans = paramDJIVideoDataListener;
    FPVController.native_setIsNeedPacked(paramBoolean);
    return this;
  }
  
  public DJIVideoDataRecver setH264FrameListener(boolean paramBoolean, H264FrameListener paramH264FrameListener)
  {
    synchronized (this.listenerSync)
    {
      this.listener = paramH264FrameListener;
      return this;
    }
  }
  
  public DJIVideoDataRecver setMainFrameDataListener(MainFrameDataListener paramMainFrameDataListener)
  {
    return null;
  }
  
  public DJIVideoDataRecver setNeedRawVideoData(boolean paramBoolean)
  {
    return null;
  }
  
  public DJIVideoDataRecver setNeedVideoDataPacked(boolean paramBoolean)
  {
    return null;
  }
  
  public DJIVideoDataRecver setVideoDataListener(boolean paramBoolean, DJIVideoDataListener paramDJIVideoDataListener)
  {
    this.isNeedPacked = paramBoolean;
    this.listenerForTrans = paramDJIVideoDataListener;
    FPVController.native_setIsNeedPacked(paramBoolean);
    return this;
  }
  
  public static enum DJIDecoderType
  {
    private int data;
    
    static
    {
      DJIDecoderType localDJIDecoderType = new DJIDecoderType("None", 2, 2);
      None = localDJIDecoderType;
      $VALUES = new DJIDecoderType[] { Hardware, Software, localDJIDecoderType };
    }
    
    private DJIDecoderType(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static DJIDecoderType find(int paramInt)
    {
      DJIDecoderType localDJIDecoderType = None;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localDJIDecoderType;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static abstract interface DJIVideoDataListener
  {
    public abstract void onVideoRecv(byte[] paramArrayOfByte, int paramInt);
  }
  
  public static class FrameRecv
  {
    public int frameNum;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\DJIVideoDataRecver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */