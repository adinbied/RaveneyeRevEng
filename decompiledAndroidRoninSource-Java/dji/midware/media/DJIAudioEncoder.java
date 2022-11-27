package dji.midware.media;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

public class DJIAudioEncoder
  implements DJIAudioRecordWrapper.DJIAudioRecordListenter
{
  public static final int FRAMES_PER_BUFFER = 25;
  private static final String MIME_TYPE = "audio/mp4a-latm";
  public static final int SAMPLES_PER_FRAME = 1024;
  private static final String TAG = "DJIAudioEncoder";
  protected static final int TIMEOUT_USEC = 10000;
  private static DJIAudioEncoder instance;
  private MediaCodec audioEncoder;
  private boolean isExit = false;
  private boolean isInited = false;
  private DJIAudioEncoderListener listener;
  private MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
  private long prevOutputPTSUs = 0L;
  
  /* Error */
  private void addADTStoPacket(byte[] arg1, int arg2, int arg3, int arg4, int arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static DJIAudioEncoder getInstance()
  {
    if (instance == null) {
      instance = new DJIAudioEncoder();
    }
    return instance;
  }
  
  private long getPTSUs()
  {
    return 277834007L;
  }
  
  private void invokeOnDataEncoded(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    DJIAudioEncoderListener localDJIAudioEncoderListener = this.listener;
    if (localDJIAudioEncoderListener != null) {
      localDJIAudioEncoderListener.onDataEncoded(paramByteBuffer, paramBufferInfo, paramLong);
    }
  }
  
  private void invokeOnEncoderInit(MediaFormat paramMediaFormat)
  {
    DJIAudioEncoderListener localDJIAudioEncoderListener = this.listener;
    if (localDJIAudioEncoderListener != null) {
      localDJIAudioEncoderListener.onEncoderInit(paramMediaFormat);
    }
  }
  
  private void invokeOnFormatChanged(MediaFormat paramMediaFormat)
  {
    DJIAudioEncoderListener localDJIAudioEncoderListener = this.listener;
    if (localDJIAudioEncoderListener != null) {
      localDJIAudioEncoderListener.onFormatChanged(paramMediaFormat);
    }
  }
  
  private static final MediaCodecInfo selectAudioCodec(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder())
      {
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public void destroy()
  {
    release();
    instance = null;
  }
  
  public boolean encode(ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    return false;
  }
  
  /* Error */
  public void onAudioDataRead(ByteBuffer arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onVolumeRefresh(double paramDouble) {}
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setListener(DJIAudioEncoderListener paramDJIAudioEncoderListener)
  {
    this.listener = paramDJIAudioEncoderListener;
  }
  
  /* Error */
  public void startAudioEncoder()
    throws java.io.IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface DJIAudioEncoderListener
  {
    public abstract void onDataEncoded(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo, long paramLong);
    
    public abstract void onEncoderInit(MediaFormat paramMediaFormat);
    
    public abstract void onFormatChanged(MediaFormat paramMediaFormat);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\DJIAudioEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */