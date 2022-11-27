package dji.pilot.usercenter.region;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class DJIRegionDecoder
{
  private static final long DELAY_ID_DECODE_REGION = 500L;
  private static final String DIR_REGION = "RegionCode/";
  private static final char LEVEL_SEPERATOR = '_';
  private static final int MSG_ID_COPY_REGIONFILE = 4097;
  private static final int MSG_ID_DECODE_REGION = 4096;
  private static final String PREFIX_FILE = "regioncode";
  private static final char REGION_SEPERATOR = '|';
  private static final int STATUS_COPY = 1;
  private static final int STATUS_COPY_FAIL = 2;
  private static final int STATUS_READY = 0;
  private static final String SUFFIX_FILE = ".txt";
  private Context mAppCxt = null;
  private final ArrayList<Region> mCountry = new ArrayList();
  private DecodeHandler mDecodeHandler = null;
  private String mDecodeLocale = null;
  private volatile int mDecodeStatus = 0;
  private DecodeThread mDecodeThread = null;
  private String mFileName = null;
  private volatile boolean mInit = false;
  private volatile int mInitializeTimes = 0;
  private String mRegionDir = null;
  private ResultHandler mResultHandler = null;
  
  private boolean canDo()
  {
    return this.mInit;
  }
  
  /* Error */
  private void copyRegionFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void decodeCountry(TmpData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void decodeDistrict(TmpData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void decodeRegion(TmpData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static DJIRegionDecoder getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  /* Error */
  private void initAndCheckRegionFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void clearCountry()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean finalizeDecoder()
  {
    return false;
  }
  
  public String getDecodeLocale()
  {
    return this.mDecodeLocale;
  }
  
  public List<Region> getRegion(Region paramRegion, OnResultListener paramOnResultListener)
  {
    return null;
  }
  
  public boolean initializeDecoder(Context paramContext)
  {
    return false;
  }
  
  private static final class DecodeHandler
    extends Handler
  {
    private final WeakReference<DJIRegionDecoder> mOutCls;
    
    public DecodeHandler(Looper paramLooper, DJIRegionDecoder paramDJIRegionDecoder)
    {
      super();
      this.mOutCls = new WeakReference(paramDJIRegionDecoder);
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static final class DecodeThread
    extends HandlerThread
  {
    public DecodeThread(String paramString)
    {
      this(paramString, 1);
    }
    
    public DecodeThread(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static abstract interface OnResultListener
  {
    public abstract void onResult(List<Region> paramList, Region paramRegion);
  }
  
  private static final class ResultHandler
    extends Handler
  {
    private final WeakReference<DJIRegionDecoder> mOutCls;
    
    public ResultHandler(Looper paramLooper, DJIRegionDecoder paramDJIRegionDecoder)
    {
      super();
      this.mOutCls = new WeakReference(paramDJIRegionDecoder);
    }
    
    /* Error */
    public void handleMessage(android.os.Message arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static final class SingletonHolder
  {
    public static DJIRegionDecoder mInstance = new DJIRegionDecoder();
  }
  
  private static final class TmpData
  {
    public WeakReference<DJIRegionDecoder.OnResultListener> mListener = null;
    public Region mRegion = null;
    List<Region> mResult = null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\region\DJIRegionDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */