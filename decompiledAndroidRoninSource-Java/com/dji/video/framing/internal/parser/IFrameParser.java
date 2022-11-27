package com.dji.video.framing.internal.parser;

import android.os.Environment;
import java.io.File;

public abstract interface IFrameParser
{
  public static final String MOCK_DJI_VIDEO_FILE_1080P;
  public static final String MOCK_DJI_VIDEO_FILE_720P;
  public static final String MOCK_MAVIC_VIDEO_FILE;
  public static final String MOCK_YUV_STREAM_FILE_1080P;
  public static final String MOCK_YUV_STREAM_FILE_720P;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("mavic_pro.video");
    MOCK_MAVIC_VIDEO_FILE = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("dji_videostream_720.h264");
    MOCK_DJI_VIDEO_FILE_720P = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("dji_videostream1080.h264");
    MOCK_DJI_VIDEO_FILE_1080P = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("dji_videostream_720.yuv");
    MOCK_YUV_STREAM_FILE_720P = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("dji_videostream1080.yuv");
    MOCK_YUV_STREAM_FILE_1080P = localStringBuilder.toString();
  }
  
  public abstract void feedData(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void resetCheckStatus();
  
  public abstract void setFrameParserListener(OnFrameParserListener paramOnFrameParserListener);
  
  public abstract void stop();
  
  public static class CREATOR
  {
    public static IFrameParser create(boolean paramBoolean)
    {
      return new VideoFrameParser(paramBoolean);
    }
  }
  
  public static abstract interface OnFrameParserListener
  {
    public abstract void onRecvData(byte[] paramArrayOfByte, int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\parser\IFrameParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */