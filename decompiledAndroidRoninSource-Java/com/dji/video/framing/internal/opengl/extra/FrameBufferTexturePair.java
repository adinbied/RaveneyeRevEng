package com.dji.video.framing.internal.opengl.extra;

public class FrameBufferTexturePair
{
  public static final int GLCOLORFORMAT = 6408;
  public static final String TAG = "FrameBufferTexturePair";
  public int frameBuffer = -1;
  public int texture = -1;
  
  public FrameBufferTexturePair() {}
  
  public FrameBufferTexturePair(int paramInt1, int paramInt2)
  {
    create(paramInt1, paramInt2);
  }
  
  /* Error */
  public void create(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\opengl\extra\FrameBufferTexturePair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */