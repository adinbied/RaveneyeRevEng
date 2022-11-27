package dji.midware.natives;

import dji.log.RoninLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class FPVController
{
  static
  {
    try
    {
      RoninLog.d("FPVController", "try to load libdjivideo.so", new Object[0]);
      System.loadLibrary("djivideo");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;) {}
    }
    RoninLog.e("FPVController", "Couldn't load lib", new Object[0]);
  }
  
  public static native int jni_audio_filters_frame_in(long paramLong1, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, long paramLong2);
  
  public static native int jni_audio_filters_frame_out(long paramLong, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  public static native long jni_audio_filters_init(String paramString, int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int jni_audio_filters_release(long paramLong);
  
  public static native HashMap<String, String> jni_demuxer_getMetadata(String paramString);
  
  public static native int jni_demuxer_getTrackCount(long paramLong);
  
  public static native int jni_demuxer_getTrackFormat(long paramLong, int paramInt, ByteBuffer paramByteBuffer);
  
  public static native long jni_demuxer_init(String paramString);
  
  public static native boolean jni_demuxer_readSample(long paramLong, Object paramObject1, Object paramObject2, boolean paramBoolean);
  
  public static native void jni_demuxer_release(long paramLong);
  
  public static native boolean jni_demuxer_seekTo(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean);
  
  public static native int jni_image_convert_I420ToRGB565(Object paramObject1, int paramInt1, int paramInt2, int paramInt3, Object paramObject2, int paramInt4, int paramInt5);
  
  public static native int jni_image_convert_NV21ToRGB565(Object paramObject1, int paramInt1, int paramInt2, Object paramObject2, int paramInt3, int paramInt4);
  
  public static void loadLibrary() {}
  
  public static native int native_clear();
  
  public static native long native_getDJIAVPaserHeaderMagic();
  
  public static native boolean native_getIsLiveStreamAudioMute();
  
  public static native int native_getLiveStreamAudioBitRate();
  
  public static native int native_getLiveStreamVideoBitRate();
  
  public static native int native_getLiveStreamVideoBufSize();
  
  public static native float native_getLiveStreamVideoFps();
  
  public static native int native_getQueueSize();
  
  public static native short[] native_getStreamParams();
  
  public static native int native_h264ParseSliceHeader(byte[] paramArrayOfByte, int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int paramInt2);
  
  public static native int native_init(Object paramObject);
  
  public static native int native_initStreaming(String paramString, int paramInt);
  
  public static boolean native_isStarted()
  {
    return native_isStarted(0);
  }
  
  public static native boolean native_isStarted(int paramInt);
  
  public static native int native_mp4MuxerAddAudioTrack(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, byte[] paramArrayOfByte, int paramInt5);
  
  public static native int native_mp4MuxerAddVideoTrack(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4, long paramLong);
  
  public static native int native_mp4MuxerInit(int paramInt);
  
  public static native void native_mp4MuxerSetIsRotated(int paramInt);
  
  public static native int native_mp4MuxerStart(String paramString);
  
  public static native int native_mp4MuxerStop();
  
  public static native int native_mp4MuxerWrite(int paramInt1, Object paramObject, int paramInt2, int paramInt3, long paramLong1, long paramLong2);
  
  public static native int native_pauseParseThread(boolean paramBoolean);
  
  public static native int native_pauseRecvThread(boolean paramBoolean);
  
  public static native int native_putAudioData(short[] paramArrayOfShort, int paramInt);
  
  public static native int native_putAudioDataLiveStream(short[] paramArrayOfShort, int paramInt);
  
  public static native int native_putVideoStreamData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int native_reqCtrlInfo(byte[] paramArrayOfByte);
  
  public static native int native_sendCtrlInfo(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int native_setCallObject(Object paramObject);
  
  public static native int native_setDataMode(boolean paramBoolean);
  
  public static native int native_setDecodeMode(boolean paramBoolean);
  
  public static native int native_setDecoderType(int paramInt);
  
  public static native int native_setFrameRate(int paramInt);
  
  public static native int native_setIsFixRate(boolean paramBoolean);
  
  public static native int native_setIsLiveStreamAudioMute(boolean paramBoolean);
  
  public static native int native_setIsNeedPacked(boolean paramBoolean);
  
  public static native int native_setIsNeedRawData(boolean paramBoolean);
  
  public static native int native_setIsNewRate(boolean paramBoolean);
  
  public static native int native_setMSCChannel(int paramInt1, int paramInt2, int paramInt3);
  
  public static native int native_setOnStreamCB(Object paramObject, String paramString);
  
  public static native int native_setRGBBuffer(byte[] paramArrayOfByte, int paramInt);
  
  public static native int native_setVideoDataRecver(Object paramObject);
  
  public static native int native_setVideoPackObject(Object paramObject);
  
  public static native int native_startParseThread();
  
  public static native int native_startRecvThread();
  
  public static native int native_startStream(boolean paramBoolean);
  
  public static native int native_stopParseThread();
  
  public static native int native_stopRecvThread();
  
  public static native int native_stopStream();
  
  public static native int native_transSerialData(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int native_transcodeX264Deinit();
  
  public static native int native_transcodeX264Encode(Object paramObject1, int paramInt, Object paramObject2);
  
  public static native int native_transcodeX264Init(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native int native_transcodeX264Start();
  
  public static native int native_transcodeX264Stop();
  
  public static native int native_transcodeYUVConvert(Object paramObject1, Object paramObject2, int paramInt1, int paramInt2, int paramInt3);
  
  public static native int native_transferAudioData(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3);
  
  public static int native_transferAudioData(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    return native_transferAudioData(paramArrayOfByte1, 0, paramInt1, paramArrayOfByte2, paramInt2);
  }
  
  public static int native_transferVideoData(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramInt = native_transferVideoData(paramArrayOfByte, paramInt, null, 0, 0);
      return paramInt;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public static int native_transferVideoData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = native_transferVideoData(paramArrayOfByte, paramInt1, null, 0, paramInt2);
      return paramInt1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public static int native_transferVideoData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramInt1 = native_transferVideoData(paramArrayOfByte, paramInt1, null, paramInt2, paramInt3);
      return paramInt1;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public static native int native_transferVideoData(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3);
  
  public static native int native_transferVideoDataDirect(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3);
  
  public static int native_transferVideoDataDirect(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    return native_transferVideoDataDirect(paramArrayOfByte1, 0, paramInt1, paramArrayOfByte2, paramInt2);
  }
  
  public static native int native_unInit();
  
  public static native int native_unInitStreaming();
  
  public static enum ColorPlanar
  {
    private int value;
    
    static
    {
      ColorPlanar localColorPlanar = new ColorPlanar("NV12", 1, 1);
      NV12 = localColorPlanar;
      $VALUES = new ColorPlanar[] { YUV420P, localColorPlanar };
    }
    
    private ColorPlanar(int paramInt)
    {
      this.value = paramInt;
    }
    
    int getValue()
    {
      return this.value;
    }
  }
  
  public static enum TranscodeResult
  {
    private int value;
    
    static
    {
      ERR_INVALID_PARAM = new TranscodeResult("ERR_INVALID_PARAM", 1, -1);
      ERR_NODATA = new TranscodeResult("ERR_NODATA", 2, -2);
      TranscodeResult localTranscodeResult = new TranscodeResult("OTHER", 3, -100);
      OTHER = localTranscodeResult;
      $VALUES = new TranscodeResult[] { SUCCESS, ERR_INVALID_PARAM, ERR_NODATA, localTranscodeResult };
    }
    
    private TranscodeResult(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static TranscodeResult find(int paramInt)
    {
      TranscodeResult localTranscodeResult = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localTranscodeResult;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public int getValue()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\natives\FPVController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */