package com.dji.video.framing.internal;

import androidx.core.util.Pools.SynchronizedPool;
import com.dji.video.framing.internal.decoder.common.FrameFovType;

public class VideoFrame
{
  public static final int POOL_SIZE = 120;
  private static final String TAG = "VideoFrame";
  private static final Pools.SynchronizedPool<VideoFrame> sPool = new Pools.SynchronizedPool(120);
  public long checkFrameCrc = -1L;
  public int checkFrameLen = -1;
  public int checkIndex = -1;
  public boolean checkIsKeyFrame = false;
  public long codecOutputTime;
  public byte[] data;
  public long fedIntoCodecTime;
  public FrameFovType fovType = FrameFovType.Unknown;
  public int fps;
  public long frameIndex = -1L;
  public int frameNum = -1;
  public int height;
  public long incomingTimeMs;
  public boolean isHevcFrame;
  public boolean isKeyFrame;
  public int ppsLen;
  public int ppsPos = -1;
  public long pts;
  public int size;
  public int spsLen;
  public int spsPos = -1;
  public long timeStamp = -1L;
  public int width;
  public int zoomIndex = -1;
  
  private VideoFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean2)
  {
    update(paramArrayOfByte, paramInt1, paramLong1, paramBoolean1, paramInt2, paramInt3, paramInt4, paramLong2, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramBoolean2);
  }
  
  public static VideoFrame obtain(byte[] paramArrayOfByte, int paramInt1, long paramLong1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean2)
  {
    VideoFrame localVideoFrame = (VideoFrame)sPool.acquire();
    if (localVideoFrame == null) {
      return new VideoFrame(paramArrayOfByte, paramInt1, paramLong1, paramBoolean1, paramInt2, paramInt3, paramInt4, paramLong2, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramBoolean2);
    }
    localVideoFrame.update(paramArrayOfByte, paramInt1, paramLong1, paramBoolean1, paramInt2, paramInt3, paramInt4, paramLong2, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramBoolean2);
    return localVideoFrame;
  }
  
  /* Error */
  private void update(byte[] arg1, int arg2, long arg3, boolean arg5, int arg6, int arg7, int arg8, long arg9, int arg11, int arg12, int arg13, int arg14, int arg15, boolean arg16)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void recycle()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\VideoFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */