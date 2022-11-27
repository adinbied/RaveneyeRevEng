package com.dji.video.framing;

import com.dji.video.framing.internal.decoder.ExtraImageReaderManager.ExtraImageReaderCallback;
import com.dji.video.framing.internal.decoder.decoderinterface.IDecoderStateListener;

public class DJIVideoCodecInnerManager
{
  private static final String TAG = "DJIVideoCodecInnerManager";
  private DJIVideoDecodeInnerListener mDJIVideoDecodeInnerListener;
  private DJIVideoDecoderInterface mDJIVideoDecoderInterface;
  private IDecoderStateListener mIDecoderStateListener = new IDecoderStateListener()
  {
    /* Error */
    public void onStateChange(com.dji.video.framing.internal.decoder.DJIVideoDecoder.VideoDecoderState arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  
  public static DJIVideoCodecInnerManager getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  public void addDJIVideoDecodeInnerListener(DJIVideoDecodeInnerListener paramDJIVideoDecodeInnerListener)
  {
    this.mDJIVideoDecodeInnerListener = paramDJIVideoDecodeInnerListener;
  }
  
  public DJIVideoDecoderInterface getDJIVideoDecoderInterface()
  {
    return this.mDJIVideoDecoderInterface;
  }
  
  public void releaseDJIVideoDecodeInnerListener()
  {
    this.mDJIVideoDecodeInnerListener = null;
  }
  
  /* Error */
  public void setDJIVideoDecoderInterface(DJIVideoDecoderInterface arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean startQuickShotImageGet(ExtraImageReaderManager.ExtraImageReaderCallback paramExtraImageReaderCallback)
  {
    return false;
  }
  
  /* Error */
  public void stopQuickShotImageGet()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static abstract interface DJIVideoDecodeInnerListener
  {
    public abstract void onDecoderInit(boolean paramBoolean);
  }
  
  private static class SingletonHolder
  {
    private static final DJIVideoCodecInnerManager INSTANCE = new DJIVideoCodecInnerManager();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\DJIVideoCodecInnerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */