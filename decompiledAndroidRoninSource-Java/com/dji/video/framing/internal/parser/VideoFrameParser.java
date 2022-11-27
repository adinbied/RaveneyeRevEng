package com.dji.video.framing.internal.parser;

import com.dji.video.framing.VideoLog;

public class VideoFrameParser
  implements IFrameParser
{
  private static final byte BYTE_00;
  private static final byte BYTE_01;
  private static final byte BYTE_264_1 = (byte)Integer.parseInt("09", 16);
  private static final byte BYTE_264_2 = (byte)Integer.parseInt("10", 16);
  private static final byte BYTE_265_1 = (byte)Integer.parseInt("46", 16);
  private static final byte BYTE_265_2 = (byte)Integer.parseInt("01", 16);
  private static final String TAG = "VideoFrameParser";
  private IFrameParser.OnFrameParserListener listener;
  private int mCheckIndex = 0;
  private boolean mIsFirstBlock;
  private final boolean mIsHevcParser;
  private boolean mIsWrongFormat = true;
  private byte[] mTimeStamp = new byte[8];
  private long nativePtr;
  private long startTime;
  
  static
  {
    BYTE_00 = (byte)Integer.parseInt("00", 16);
    BYTE_01 = (byte)Integer.parseInt("01", 16);
    System.loadLibrary("video-framing");
  }
  
  public VideoFrameParser(boolean paramBoolean)
  {
    this.mIsHevcParser = paramBoolean;
    this.nativePtr = native_init(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoFrameParser() ptr=");
    localStringBuilder.append(this.nativePtr);
    localStringBuilder.append(" isHevcMode:");
    localStringBuilder.append(paramBoolean);
    VideoLog.w("VideoFrameParser", localStringBuilder.toString(), new Object[0]);
  }
  
  /* Error */
  public void JniDataRecvCallBack(byte[] arg1, int arg2, boolean arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void feedData(byte[] arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public native void native_feed(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void native_finish(long paramLong);
  
  public native long native_init(boolean paramBoolean);
  
  /* Error */
  public void resetCheckStatus()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setFrameParserListener(IFrameParser.OnFrameParserListener paramOnFrameParserListener)
  {
    this.listener = paramOnFrameParserListener;
  }
  
  public void stop()
  {
    native_finish(this.nativePtr);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\parser\VideoFrameParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */