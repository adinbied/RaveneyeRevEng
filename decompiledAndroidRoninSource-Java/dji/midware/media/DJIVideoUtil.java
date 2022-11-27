package dji.midware.media;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.dji.frame.util.V_ActivityUtil;
import com.dji.frame.util.V_DiskUtil;
import dji.log.RoninLog;
import dji.midware.data.manager.P3.ServiceManager;
import dji.midware.media.metadata.VideoMetadataManager;
import dji.midware.natives.FPVController;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

public class DJIVideoUtil
{
  public static final int ANDROID_MP4_ENCODER_INPUTSURFACE_MIN_SDK = 18;
  public static final int ANDROID_MP4_MUXER_MIN_SDK = 18;
  public static final String[] AUDIO_ENCODING_FORMAT;
  public static final int EXTRA_PARSING_MEM_SIZE = 1024;
  public static final int FPS = 30;
  private static final long FRAME_INDEX_MAX = 1048575L;
  private static final long FRAME_NUM_MAX = 60L;
  private static final long FRAME_NUM_MAX_MUX = 63L;
  private static final long FRAME_PTS_MAX = 16777215L;
  public static final int H264FrameCapacity = 138240;
  private static final int H264FrameCapacity_1080 = 1048576;
  public static final int IFRAME_DURATION_MASK = 31;
  public static final int IFRAME_DURATION_MASK_LARGE = 151;
  private static final String KEY_CROP_BOTTOM = "crop-bottom";
  private static final String KEY_CROP_LEFT = "crop-left";
  private static final String KEY_CROP_RIGHT = "crop-right";
  private static final String KEY_CROP_TOP = "crop-top";
  public static final int KEY_I_FRAME_INTERVAL = 1;
  public static final int MIN_FRAME_RECORD = 150;
  public static int MP4_BIT_RATE = 0;
  public static int Midea_Signal_Delay_MSec = 0;
  public static final int NUM_FRAME_JUMPED = 120;
  public static final int RECORD_VIDEO_HEIGHT = 720;
  public static final int RECORD_VIDEO_WIDTH = 1280;
  public static final int STREAM_MAX_HEIGHT = 720;
  public static final int STREAM_MAX_WIDTH = 1280;
  private static String TAG = "DJIVideoUtil";
  public static final String[] VIDEO_ENCODING_FORMAT = { "video/avc", "video/mp4v-es" };
  public static final int YUVFrameCapacity = 8294400;
  private static Context context;
  public static long conversionTimes = 0L;
  public static long durationSum = 0L;
  private static ArrayList<byte[]> extraBufList = new ArrayList(ExtraMemInvokePoint.values().length);
  private static DecimalFormat fileDecimalFormat;
  private static DecimalFormat fileIntegerFormat;
  public static boolean isAllDebugClose = false;
  public static boolean isAllDebugOpen = false;
  public static boolean isRender = false;
  public static boolean isTranscodeOnline = false;
  private static final int position = 6;
  private static final long start_time;
  public static boolean test;
  public static boolean useFFMpegForLowSDK;
  
  static
  {
    AUDIO_ENCODING_FORMAT = new String[] { "audio/mp4a-latm", "audio/aac", "audio/mpeg" };
    isRender = true;
    isTranscodeOnline = false;
    isAllDebugClose = false;
    isAllDebugOpen = false;
    MP4_BIT_RATE = 10485760;
    Midea_Signal_Delay_MSec = 1000;
    start_time = System.currentTimeMillis();
    durationSum = 0L;
    conversionTimes = 0L;
    fileIntegerFormat = new DecimalFormat("#0");
    fileDecimalFormat = new DecimalFormat("#0.#");
  }
  
  public static void YUVFormatConvert(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    FPVController.native_transcodeYUVConvert(paramByteBuffer1, paramByteBuffer2, paramInt1, paramInt2, paramInt3);
    durationSum += System.currentTimeMillis() - l;
    conversionTimes += 1L;
  }
  
  public static void YUVFormatConvert(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 != 21)
    {
      if ((paramInt5 != 2141391872) && (paramInt5 != 2141391876))
      {
        j = paramInt3 * paramInt4;
        i = paramInt2 + j;
        j = j / 4 + i;
        break label77;
      }
      i = paramInt2 + paramInt3 * paramInt4 + 20480;
    }
    else
    {
      i = paramInt2 + paramInt3 * paramInt4;
    }
    int j = i + 1;
    label77:
    int m = i;
    int i = 0;
    int k = paramInt2;
    paramInt2 = j;
    while (i < paramInt4)
    {
      j = 0;
      while (j < paramInt3)
      {
        int n = paramInt1 + 1;
        paramArrayOfByte2[k] = paramArrayOfByte1[paramInt1];
        if ((i % 2 == 0) && (j % 2 == 0))
        {
          if ((paramInt5 != 21) && (paramInt5 != 2141391872) && (paramInt5 != 2141391876))
          {
            paramInt1 = n + 1;
            paramArrayOfByte2[m] = paramArrayOfByte1[n];
            n = paramInt1 + 1;
            paramArrayOfByte2[paramInt2] = paramArrayOfByte1[paramInt1];
            paramInt2 += 1;
            paramInt1 = m + 1;
            m = n;
          }
          else
          {
            int i1 = n + 1;
            paramArrayOfByte2[m] = paramArrayOfByte1[n];
            paramInt1 = m + 2;
            m = i1 + 1;
            paramArrayOfByte2[paramInt2] = paramArrayOfByte1[i1];
            paramInt2 += 2;
          }
          n = m + 1;
          m = paramInt1;
          paramInt1 = n;
        }
        else
        {
          paramInt1 = n + 3;
        }
        j += 1;
        k += 1;
      }
      i += 1;
    }
  }
  
  public static void YUVFormatConvert(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    YUVFormatConvert(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramInt1, paramInt2, 19);
  }
  
  public static boolean checkAndCreateDirectory(String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      boolean bool = ((File)localObject).mkdirs();
      if (!bool)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("can't create the directory ");
        ((StringBuilder)localObject).append(paramString);
        MediaLogger.show(((StringBuilder)localObject).toString());
      }
      return bool;
    }
    return true;
  }
  
  public static boolean externalMemoryAvailable()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static byte[] extraMemForParsing(ExtraMemInvokePoint paramExtraMemInvokePoint, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (extraBufList.size() == 0)
    {
      i = 0;
      while (i < ExtraMemInvokePoint.values().length)
      {
        extraBufList.add(null);
        i += 1;
      }
    }
    byte[] arrayOfByte = (byte[])extraBufList.get(paramExtraMemInvokePoint.ordinal());
    int i = paramInt2 - paramInt1 + 1024;
    if ((arrayOfByte != null) && (arrayOfByte.length >= i))
    {
      Arrays.fill(arrayOfByte, (byte)0);
      paramExtraMemInvokePoint = arrayOfByte;
    }
    else
    {
      arrayOfByte = new byte[i];
      extraBufList.set(paramExtraMemInvokePoint.ordinal(), arrayOfByte);
      paramExtraMemInvokePoint = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, paramInt1, paramExtraMemInvokePoint, 0, paramInt2);
    return paramExtraMemInvokePoint;
  }
  
  public static int findBestColorFormat(MediaCodec paramMediaCodec)
  {
    Object localObject = paramMediaCodec.getCodecInfo().getCapabilitiesForType(VIDEO_ENCODING_FORMAT[0]).colorFormats;
    Arrays.sort((int[])localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMediaCodec.getName());
    localStringBuilder.append(" supports the colors: ");
    localStringBuilder.append(Arrays.toString((int[])localObject));
    MediaLogger.show(localStringBuilder.toString());
    int i = 19;
    if (Arrays.binarySearch((int[])localObject, 19) < 0) {
      if (Arrays.binarySearch((int[])localObject, 21) >= 0) {
        i = 21;
      } else {
        i = localObject[0];
      }
    }
    localObject = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMediaCodec.getName());
    localStringBuilder.append("'s best color is: ");
    localStringBuilder.append(i);
    RoninLog.i((String)localObject, localStringBuilder.toString(), new Object[0]);
    return i;
  }
  
  public static int findBestColorFormat(MediaCodec paramMediaCodec1, MediaCodec paramMediaCodec2)
  {
    int[] arrayOfInt = paramMediaCodec1.getCodecInfo().getCapabilitiesForType(VIDEO_ENCODING_FORMAT[0]).colorFormats;
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMediaCodec1.getName());
    localStringBuilder.append(" supports the colors: ");
    localStringBuilder.append(Arrays.toString(arrayOfInt));
    RoninLog.i(str, localStringBuilder.toString(), new Object[0]);
    paramMediaCodec1 = new HashSet();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramMediaCodec1.add(Integer.valueOf(arrayOfInt[i]));
      i += 1;
    }
    arrayOfInt = paramMediaCodec2.getCodecInfo().getCapabilitiesForType(VIDEO_ENCODING_FORMAT[0]).colorFormats;
    str = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMediaCodec2.getName());
    localStringBuilder.append(" supports the colors: ");
    localStringBuilder.append(Arrays.toString(arrayOfInt));
    RoninLog.i(str, localStringBuilder.toString(), new Object[0]);
    paramMediaCodec2 = new HashSet();
    j = arrayOfInt.length;
    i = 0;
    while (i < j)
    {
      paramMediaCodec2.add(Integer.valueOf(arrayOfInt[i]));
      i += 1;
    }
    i = -1;
    if ((paramMediaCodec1.contains(Integer.valueOf(21))) && (paramMediaCodec2.contains(Integer.valueOf(21))))
    {
      i = 21;
    }
    else if ((paramMediaCodec1.contains(Integer.valueOf(19))) && (paramMediaCodec2.contains(Integer.valueOf(19))))
    {
      i = 19;
    }
    else
    {
      paramMediaCodec1.retainAll(paramMediaCodec2);
      if (!paramMediaCodec1.isEmpty()) {
        i = ((Integer)paramMediaCodec1.toArray()[0]).intValue();
      }
    }
    paramMediaCodec1 = TAG;
    paramMediaCodec2 = new StringBuilder();
    paramMediaCodec2.append("Found common color: ");
    paramMediaCodec2.append(i);
    RoninLog.i(paramMediaCodec1, paramMediaCodec2.toString(), new Object[0]);
    return i;
  }
  
  public static String formatStorage(long paramLong, boolean paramBoolean)
  {
    DecimalFormat localDecimalFormat;
    if (paramBoolean) {
      localDecimalFormat = fileIntegerFormat;
    } else {
      localDecimalFormat = fileDecimalFormat;
    }
    if ((paramLong < 1024L) && (paramLong > 0L))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localDecimalFormat.format(paramLong));
      localStringBuilder.append("B");
      return localStringBuilder.toString();
    }
    if (paramLong < 1048576L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localDecimalFormat.format(paramLong / 1024.0D));
      localStringBuilder.append("KB");
      return localStringBuilder.toString();
    }
    if (paramLong < 1073741824L)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localDecimalFormat.format(paramLong / 1048576.0D));
      localStringBuilder.append("MB");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localDecimalFormat.format(paramLong / 1.073741824E9D));
    localStringBuilder.append("GB");
    return localStringBuilder.toString();
  }
  
  public static long getAvailableExternalMemorySize()
  {
    if (externalMemoryAvailable())
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      return localStatFs.getAvailableBlocks() * l;
    }
    return -1L;
  }
  
  public static long getComprehensivePts(long paramLong1, long paramLong2, long paramLong3)
  {
    long l1 = paramLong2;
    if (paramLong2 > 1048575L) {
      l1 = 1048575L;
    }
    long l2 = start_time;
    paramLong2 = paramLong3;
    if (paramLong3 > 60L) {
      paramLong2 = 60L;
    }
    return ((l1 << 24) + (paramLong1 - l2 & 0xFFFFFF) << 6) + paramLong2;
  }
  
  public static Context getContext()
  {
    ServiceManager.getInstance();
    Context localContext = ServiceManager.getContext();
    if (localContext != null) {
      return localContext;
    }
    return context;
  }
  
  public static String getDirPackgetPath(String paramString)
  {
    if (getContext() == null) {
      return null;
    }
    return V_DiskUtil.getExternalCacheDirPath(getContext(), paramString);
  }
  
  public static double getDurationPerFrame()
  {
    return 33.33333D;
  }
  
  public static long getDurationPerFrameUs()
  {
    return 33333L;
  }
  
  public static int getFPS()
  {
    return 30;
  }
  
  public static int getFrameIndex(long paramLong)
  {
    return (int)((paramLong & 0xFFFFF0000000) >>> 30);
  }
  
  public static int getFrameNum(long paramLong)
  {
    return (int)(paramLong & 0x3F);
  }
  
  public static int getH264FrameMaxSize(int paramInt1, int paramInt2, int paramInt3)
  {
    return 1258300;
  }
  
  public static String getOutputFileNameWithoutSuffix()
  {
    return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
  }
  
  public static long getPresentationTimeUs(int paramInt)
  {
    return getDurationPerFrameUs() * paramInt;
  }
  
  public static long getPtsMs(long paramLong)
  {
    return start_time + ((paramLong & 0xFFFFFF0) >>> 6);
  }
  
  public static Resolution getResolutionReliably(MediaFormat paramMediaFormat)
  {
    Resolution localResolution = new Resolution();
    int i;
    if ((paramMediaFormat.containsKey("crop-right")) && (paramMediaFormat.containsKey("crop-left")) && (paramMediaFormat.containsKey("crop-bottom")) && (paramMediaFormat.containsKey("crop-top"))) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (i != 0) {
      j = paramMediaFormat.getInteger("crop-right") - paramMediaFormat.getInteger("crop-left") + 1;
    } else {
      j = paramMediaFormat.getInteger("width");
    }
    localResolution.width = j;
    if (i != 0) {
      i = paramMediaFormat.getInteger("crop-bottom") - paramMediaFormat.getInteger("crop-top") + 1;
    } else {
      i = paramMediaFormat.getInteger("height");
    }
    localResolution.height = i;
    return localResolution;
  }
  
  public static int getSDKVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static long getTotalExternalMemorySize()
  {
    if (externalMemoryAvailable())
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      return localStatFs.getBlockCount() * l;
    }
    return -1L;
  }
  
  public static int[] getYUVSupportColors()
  {
    return new int[] { 19, 21, 2141391876, 2141391872 };
  }
  
  public static boolean isDebug()
  {
    return isDebug(true);
  }
  
  public static boolean isDebug(boolean paramBoolean)
  {
    Context localContext = getContext();
    if ((localContext != null) && (!V_ActivityUtil.isApkDebugable(localContext))) {
      return false;
    }
    if (isAllDebugClose) {
      return false;
    }
    if (isAllDebugOpen) {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public static boolean isVideoFromDroneSD(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString).getName();
    if (paramString != null)
    {
      paramString = paramString.toLowerCase(Locale.US);
      if ((paramString.startsWith("org_")) || (paramString.startsWith("dji_"))) {
        return true;
      }
    }
    return false;
  }
  
  public static void setContext(Context paramContext)
  {
    if (ServiceManager.getInstance() != null) {
      return;
    }
    context = paramContext;
  }
  
  public static void writeBufferToFile(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject1 = new byte[paramInt2];
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(VideoMetadataManager.getSourceVideoDirectory());
      ((StringBuilder)localObject2).append(paramString);
      localObject2 = new FileOutputStream(((StringBuilder)localObject2).toString());
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream((OutputStream)localObject2);
      paramByteBuffer.position(paramInt1);
      paramByteBuffer.limit(paramInt1 + paramInt2);
      paramByteBuffer.get((byte[])localObject1, 0, paramInt2);
      paramByteBuffer.clear();
      localBufferedOutputStream.write((byte[])localObject1, 0, paramInt2);
      localBufferedOutputStream.flush();
      localBufferedOutputStream.close();
      ((OutputStream)localObject2).close();
    }
    catch (IOException paramByteBuffer)
    {
      paramByteBuffer.printStackTrace();
    }
    paramByteBuffer = TAG;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" saved done");
    RoninLog.i(paramByteBuffer, ((StringBuilder)localObject1).toString(), new Object[0]);
  }
  
  public static enum ExtraMemInvokePoint
  {
    static
    {
      P3CLiveStreamService = new ExtraMemInvokePoint("P3CLiveStreamService", 5);
      UsbHostServiceLBChanneParser = new ExtraMemInvokePoint("UsbHostServiceLBChanneParser", 6);
      UsbHostRC = new ExtraMemInvokePoint("UsbHostRC", 7);
      ExtraMemInvokePoint localExtraMemInvokePoint = new ExtraMemInvokePoint("Other", 8);
      Other = localExtraMemInvokePoint;
      $VALUES = new ExtraMemInvokePoint[] { DJIMediaPlayer, DJIMediaPlayerLitchix, H264FileLoader, MammothStreamService, SwUdpService, P3CLiveStreamService, UsbHostServiceLBChanneParser, UsbHostRC, localExtraMemInvokePoint };
    }
    
    private ExtraMemInvokePoint() {}
  }
  
  public static class Resolution
  {
    public int height;
    public int width;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\DJIVideoUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */