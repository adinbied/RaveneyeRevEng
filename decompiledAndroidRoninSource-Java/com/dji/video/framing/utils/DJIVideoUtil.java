package com.dji.video.framing.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder;
import java.io.BufferedOutputStream;
import java.io.Closeable;
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
  public static byte[][] AUD_ARR;
  public static final int EXTRA_PARSING_MEM_SIZE = 1024;
  public static final int FPS = 30;
  private static final double FPS_MEASURE_THRESHOLD = 20.0D;
  private static final long FRAME_INDEX_MAX = 16777215L;
  private static final long FRAME_NUM_MAX = 63L;
  private static final long FRAME_NUM_MAX_MUX = 63L;
  private static final long FRAME_PTS_MAX = 16777215L;
  public static final int H264FrameCapacity = 138240;
  private static final int H264FrameCapacity_1080 = 1048576;
  public static final int IFRAME_DURATION_MASK = 31;
  public static final int IFRAME_DURATION_MASK_LARGE = 151;
  public static final String KEY_ASSIST_FEATURE = "key_assist_feature";
  public static final String KEY_ASSIST_FEATURE_LUT = "key_assist_feature_lut";
  public static final String KEY_ASSIST_FEATURE_LUT_RENDER_ENABLE = "key_assist_feature_lut_render_enable";
  public static final String KEY_ASSIST_FEATURE_LUT_RENDER_IS_SYSTEM = "key_assist_feature_lut_render_is_system";
  public static final String KEY_ASSIST_FEATURE_LUT_RENDER_LAST_IS_SYSTEM = "key_assist_feature_lut_render_last_is_system";
  public static final String KEY_ASSIST_FEATURE_LUT_RENDER_LAST_SELECTED_NAME = "key_assist_feature_lut_render_last_selected_name";
  public static final String KEY_ASSIST_FEATURE_LUT_RENDER_SELECTED_NAME = "key_assist_feature_lut_render_selected_name";
  public static final String KEY_ASSIST_FEATURE_MONOCHROME = "key_assist_feature_monochrome";
  public static final String KEY_ASSIST_FEATURE_PEAKING_FOCUS = "key_assist_feature_peaking_focus";
  public static final String KEY_ASSIST_FEATURE_PSEUDO_COLOR = "key_assist_feature_pseudo_color";
  public static final String KEY_ASSIST_FEATURE_ZEBRA = "key_assist_feature_zebra";
  private static final String KEY_CROP_BOTTOM = "crop-bottom";
  private static final String KEY_CROP_LEFT = "crop-left";
  private static final String KEY_CROP_RIGHT = "crop-right";
  private static final String KEY_CROP_TOP = "crop-top";
  public static final String KEY_GUIDELINE_ASSIST_LINE = "key_guideline_assist_line";
  public static final String KEY_GUIDELINE_CENTER_MARK = "key_guideline_center_mark";
  public static final String KEY_GUIDELINE_LINE_WIDTH = "key_guideline_line_width";
  public static final String KEY_GUIDELINE_MARK_COLOR = "key_guideline_mark_color";
  public static final String KEY_GUIDELINE_RATIO_MARK = "key_guideline_ratio_mark";
  public static final String KEY_GUIDELINE_SAFETY_MARK = "key_guideline_safety_mark";
  public static final String KEY_HISTOGRAM_KEY = "key_histogram_key";
  public static final int KEY_I_FRAME_INTERVAL = 1;
  public static final String KEY_OVER_EXPOSURE_KEY = "key_over_exposure_enable";
  public static final String KEY_PEAKING_FOCUS_THRESHOLD = "key_peaking_focus_threshold";
  public static final String KEY_RECORDING_CACHE_MODE = "key_recording_cache_mode";
  public static final String KEY_RECORDING_CACHE_MODE_BEFORE_SHUTTER_DISCONNECT = "key_recording_cache_mode_before_shutter_disconnect";
  public static final String KEY_RECORDING_CACHING_KEY = "key_recording_caching_key";
  public static final String KEY_RECORDING_CACHING_SIZE_KEY = "key_recording_caching_size_key";
  public static final String KEY_SHUTTER_NEVER_CONNECTED = "key_shutter_never_connected";
  public static final String KEY_SUB_LINE_CENTER_KEY = "key_sub_line_center_key";
  public static final String KEY_SUB_LINE_DIAGONAL_KEY = "key_sub_line_diagonal_key";
  public static final String KEY_SUB_LINE_GRID_KEY = "key_sub_line_grid_key";
  public static final String KEY_SWITCH_TO_CACHE_ONLY_MODE_REASON = "key_switch_to_cache_only_reason";
  public static final int MIN_FRAME_RECORD = 150;
  public static int MP4_BIT_RATE = 0;
  public static int Midea_Signal_Delay_MSec = 0;
  public static final int NUM_FRAME_JUMPED = 120;
  public static final int RECORD_VIDEO_HEIGHT = 720;
  public static final int RECORD_VIDEO_WIDTH = 1280;
  public static final int STREAM_MAX_HEIGHT = 720;
  public static final int STREAM_MAX_WIDTH = 1280;
  private static String TAG = "DJIVideoUtil";
  public static final String[] VIDEO_ENCODING_FORMAT = { "video/avc", "video/hevc" };
  public static final int YUVFrameCapacity = 11059200;
  private static Context context;
  public static long conversionTimes = 0L;
  public static long durationSum = 0L;
  private static ArrayList<byte[]> extraBufList = new ArrayList(ExtraMemInvokePoint.values().length);
  private static DecimalFormat fileDecimalFormat;
  private static DecimalFormat fileIntegerFormat;
  static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private static final int[] fpsCommonValues;
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
    byte[] arrayOfByte1 = { 0, 0, 0, 0, 0, 1, 9, 16 };
    byte[] arrayOfByte2 = { 0, 0, 0, 0, 0, 0, 0, 1, 9, 16 };
    byte[] arrayOfByte3 = { 0, 0, 0, 1, 12, 0, 0, 0, 1, 9, 16 };
    AUD_ARR = new byte[][] { { 0, 0, 0, 1, 9, 16 }, arrayOfByte1, arrayOfByte2, arrayOfByte3, { 0, 0, 0, 1, 9, 16, 0, 0, 0, 1, 9, 16 } };
    fpsCommonValues = new int[] { 24, 30, 60 };
    durationSum = 0L;
    conversionTimes = 0L;
    fileIntegerFormat = new DecimalFormat("#0");
    fileDecimalFormat = new DecimalFormat("#0.#");
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
        break label79;
      }
      i = paramInt2 + paramInt3 * paramInt4 + 20480;
    }
    else
    {
      i = paramInt2 + paramInt3 * paramInt4;
    }
    int j = i + 1;
    label79:
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
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return paramString.mkdirs();
    }
    return true;
  }
  
  public static void closeSafely(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static String dataToString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > paramInt1))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      int i = paramInt1;
      while ((i < paramInt1 + paramInt2) && (i < paramArrayOfByte.length))
      {
        if (i != paramInt1) {
          localStringBuffer.append(", ");
        }
        localStringBuffer.append("0x");
        localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xFF));
        i += 1;
      }
      return localStringBuffer.toString();
    }
    return null;
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
    int i = 19;
    if (Arrays.binarySearch((int[])localObject, 19) < 0) {
      if (Arrays.binarySearch((int[])localObject, 21) >= 0) {
        i = 21;
      } else {
        i = localObject[0];
      }
    }
    localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMediaCodec.getName());
    localStringBuilder.append("'s best color is: ");
    localStringBuilder.append(i);
    Log.i((String)localObject, localStringBuilder.toString());
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
    Log.i(str, localStringBuilder.toString());
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
    Log.i(str, localStringBuilder.toString());
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
    Log.i(paramMediaCodec1, paramMediaCodec2.toString());
    return i;
  }
  
  public static int findFrameHead(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    for (;;)
    {
      i = findNextNal(paramArrayOfByte, i, paramInt2 - i + paramInt1);
      if (i <= 0) {
        break;
      }
      int j = i + 3;
      if (j < paramArrayOfByte.length)
      {
        j = paramArrayOfByte[j] & 0x1F;
        if ((j == NalType.Sps.value()) || (j == NalType.Pps.value()) || (j == NalType.Slice.value()) || (j == NalType.IdrSlice.value())) {
          return i;
        }
      }
      i += 4;
    }
    return -1;
  }
  
  public static int findHevcFrameHead(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    for (;;)
    {
      i = findNextNal(paramArrayOfByte, i, paramInt2 - i + paramInt1);
      if (i <= 0) {
        break;
      }
      int j = i + 3;
      if (j < paramArrayOfByte.length)
      {
        j = paramArrayOfByte[j] >> 1 & 0x3F;
        if ((j == HEVCNalType.NAL_SPS.value()) || (j == HEVCNalType.NAL_PPS.value()) || (j == HEVCNalType.NAL_TRAIL_R.value()) || (j == HEVCNalType.NAL_TRAIL_N.value())) {
          return i;
        }
      }
      i += 4;
    }
    return -1;
  }
  
  public static int findNextNal(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte != null) && (paramInt1 >= 0) && (paramInt2 > 0))
    {
      int j = paramInt2 + paramInt1;
      if (j > paramArrayOfByte.length) {
        return -1;
      }
      int i = 0;
      paramInt2 = paramInt1;
      while (paramInt2 < j)
      {
        paramInt1 = paramArrayOfByte[paramInt2] & 0xFF;
        if (paramInt1 != 0)
        {
          if (paramInt1 != 1) {}
          while (i != 2)
          {
            paramInt1 = 0;
            break;
          }
          return paramInt2 - 2;
        }
        paramInt1 = i;
        if (i < 2) {
          paramInt1 = i + 1;
        }
        paramInt2 += 1;
        i = paramInt1;
      }
    }
    return -1;
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
    if (paramLong2 > 16777215L) {
      l1 = 16777215L;
    }
    long l2 = start_time;
    paramLong2 = paramLong3;
    if (paramLong3 > 63L) {
      paramLong2 = 63L;
    }
    return ((l1 << 24) + (paramLong1 - l2 & 0xFFFFFF) << 6) + paramLong2;
  }
  
  public static Context getContext()
  {
    return context;
  }
  
  public static String getCurrentStack()
  {
    return getCurrentStack(2, 100);
  }
  
  static String getCurrentStack(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    if ((paramInt1 < arrayOfStackTraceElement.length) && (paramInt1 >= 0) && (paramInt2 > 0))
    {
      int i = Math.min(paramInt2, arrayOfStackTraceElement.length - paramInt1);
      localStringBuilder.append("┌─────────────────────────────────────────────────────────────────────────────────────────────────\n");
      paramInt2 = paramInt1;
      while (paramInt2 < arrayOfStackTraceElement.length)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[paramInt2];
        localStringBuilder.append("│ ");
        localStringBuilder.append(localStackTraceElement.toString());
        localStringBuilder.append("\n");
        if (paramInt2 - paramInt1 + 1 >= i) {
          break;
        }
        paramInt2 += 1;
      }
      localStringBuilder.append("└─────────────────────────────────────────────────────────────────────────────────────────────────");
      return localStringBuilder.toString();
    }
    return "empty stack!!!";
  }
  
  public static double getDurationPerFrame(DJIVideoDecoder paramDJIVideoDecoder)
  {
    return 1000.0D / getFPS(paramDJIVideoDecoder);
  }
  
  public static long getDurationPerFrameUs(DJIVideoDecoder paramDJIVideoDecoder)
  {
    return 1000000 / paramDJIVideoDecoder.getFps();
  }
  
  public static int getFPS(DJIVideoDecoder paramDJIVideoDecoder)
  {
    double d1 = getRealFPS(paramDJIVideoDecoder);
    int j;
    for (int i = 0;; i = j)
    {
      paramDJIVideoDecoder = fpsCommonValues;
      if (i >= paramDJIVideoDecoder.length - 1) {
        break;
      }
      double d2 = paramDJIVideoDecoder[i];
      j = i + 1;
      if (d1 < d2 + (paramDJIVideoDecoder[j] - paramDJIVideoDecoder[i]) / 100.0D * 20.0D) {
        return paramDJIVideoDecoder[i];
      }
    }
    return paramDJIVideoDecoder[(paramDJIVideoDecoder.length - 1)];
  }
  
  public static int getFrameIndex(long paramLong)
  {
    return (int)(paramLong >>> 30 & 0xFFFFFF);
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
  
  public static long getPresentationTimeUs(DJIVideoDecoder paramDJIVideoDecoder, int paramInt)
  {
    return getDurationPerFrameUs(paramDJIVideoDecoder) * paramInt;
  }
  
  public static long getPtsMs(long paramLong)
  {
    return start_time + (paramLong >>> 6 & 0xFFFFFF);
  }
  
  public static double getRealFPS(DJIVideoDecoder paramDJIVideoDecoder)
  {
    if (paramDJIVideoDecoder == null) {
      return 30.0D;
    }
    double d = 1000.0D / paramDJIVideoDecoder.getFrameQueueinIntervalAvgValue();
    if (d < 0.0D) {
      return 30.0D;
    }
    return d;
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
  
  public static String getStringDate()
  {
    Date localDate = new Date();
    return formatter.format(localDate);
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
    if (localContext != null) {
      return (localContext.getApplicationInfo().flags & 0x2) != 0;
    }
    if (isAllDebugClose) {
      return false;
    }
    if (isAllDebugOpen) {
      return true;
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
    context = paramContext;
  }
  
  public static void writeBufferToFile(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, String paramString)
  {
    Object localObject = new byte[paramInt2];
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localFileOutputStream);
      paramByteBuffer.position(paramInt1);
      paramByteBuffer.limit(paramInt1 + paramInt2);
      paramByteBuffer.get((byte[])localObject, 0, paramInt2);
      paramByteBuffer.clear();
      localBufferedOutputStream.write((byte[])localObject, 0, paramInt2);
      localBufferedOutputStream.flush();
      localBufferedOutputStream.close();
      localFileOutputStream.close();
    }
    catch (IOException paramByteBuffer)
    {
      paramByteBuffer.printStackTrace();
    }
    paramByteBuffer = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" saved done");
    Log.i(paramByteBuffer, ((StringBuilder)localObject).toString());
  }
  
  public static Bitmap zoomImg(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 / i;
    float f2 = paramInt2 / j;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
  }
  
  public static enum AssistFeatureType
  {
    private final int value;
    
    static
    {
      AssistFeatureType localAssistFeatureType = new AssistFeatureType("ASSIST_FEATURE_ON", 1, 1);
      ASSIST_FEATURE_ON = localAssistFeatureType;
      $VALUES = new AssistFeatureType[] { ASSIST_FEATURE_OFF, localAssistFeatureType };
    }
    
    private AssistFeatureType(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum AssistLineType
  {
    private final int value;
    
    static
    {
      ASSIST_LINE_3_3 = new AssistLineType("ASSIST_LINE_3_3", 1, 1);
      ASSIST_LINE_6_4 = new AssistLineType("ASSIST_LINE_6_4", 2, 2);
      AssistLineType localAssistLineType = new AssistLineType("ASSIST_LINE_GOLD", 3, 3);
      ASSIST_LINE_GOLD = localAssistLineType;
      $VALUES = new AssistLineType[] { ASSIST_LINE_OFF, ASSIST_LINE_3_3, ASSIST_LINE_6_4, localAssistLineType };
    }
    
    private AssistLineType(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum CacheMode
  {
    private final int value;
    
    static
    {
      CACHE_AND_RECORD = new CacheMode("CACHE_AND_RECORD", 1, 1);
      CacheMode localCacheMode = new CacheMode("RECORD_ONLY", 2, 2);
      RECORD_ONLY = localCacheMode;
      $VALUES = new CacheMode[] { CACHE_TO_PHONE_ONLY, CACHE_AND_RECORD, localCacheMode };
    }
    
    private CacheMode(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum CacheOnlyModeReason
  {
    private final int value;
    
    static
    {
      CacheOnlyModeReason localCacheOnlyModeReason = new CacheOnlyModeReason("USER_SET", 2, 2);
      USER_SET = localCacheOnlyModeReason;
      $VALUES = new CacheOnlyModeReason[] { DEFAULT, SHUTTER_DISCONNECT, localCacheOnlyModeReason };
    }
    
    private CacheOnlyModeReason(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum CenterMarkType
  {
    private final int value;
    
    static
    {
      CENTER_MARK_GRID = new CenterMarkType("CENTER_MARK_GRID", 1, 1);
      CENTER_MARK_CROSS = new CenterMarkType("CENTER_MARK_CROSS", 2, 2);
      CenterMarkType localCenterMarkType = new CenterMarkType("CENTER_MARK_GRID_CROSS", 3, 3);
      CENTER_MARK_GRID_CROSS = localCenterMarkType;
      $VALUES = new CenterMarkType[] { CENTER_MARK_OFF, CENTER_MARK_GRID, CENTER_MARK_CROSS, localCenterMarkType };
    }
    
    private CenterMarkType(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
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
  
  public static enum FocusThreshold
  {
    private final float value;
    
    static
    {
      FocusThreshold localFocusThreshold = new FocusThreshold("THRESHOLD_DEFAULT", 0, 22.0F);
      THRESHOLD_DEFAULT = localFocusThreshold;
      $VALUES = new FocusThreshold[] { localFocusThreshold };
    }
    
    private FocusThreshold(float paramFloat)
    {
      this.value = paramFloat;
    }
    
    public float value()
    {
      return this.value;
    }
  }
  
  public static enum HEVCNalType
  {
    private int value;
    
    static
    {
      NAL_SPS = new HEVCNalType("NAL_SPS", 3, 33);
      NAL_PPS = new HEVCNalType("NAL_PPS", 4, 34);
      NAL_AUD = new HEVCNalType("NAL_AUD", 5, 35);
      NAL_EOS_NUT = new HEVCNalType("NAL_EOS_NUT", 6, 36);
      NAL_EOB_NUT = new HEVCNalType("NAL_EOB_NUT", 7, 37);
      NAL_FD_NUT = new HEVCNalType("NAL_FD_NUT", 8, 38);
      NAL_SEI_PREFIX = new HEVCNalType("NAL_SEI_PREFIX", 9, 39);
      HEVCNalType localHEVCNalType = new HEVCNalType("NAL_SEI_SUFFIX", 10, 40);
      NAL_SEI_SUFFIX = localHEVCNalType;
      $VALUES = new HEVCNalType[] { NAL_TRAIL_N, NAL_TRAIL_R, NAL_VPS, NAL_SPS, NAL_PPS, NAL_AUD, NAL_EOS_NUT, NAL_EOB_NUT, NAL_FD_NUT, NAL_SEI_PREFIX, localHEVCNalType };
    }
    
    private HEVCNalType(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum LineWidth
  {
    private final float value;
    
    static
    {
      LineWidth localLineWidth = new LineWidth("WIDTH_THICKEST", 2, 4.0F);
      WIDTH_THICKEST = localLineWidth;
      $VALUES = new LineWidth[] { WIDTH_NORMAL, WIDTH_THICKER, localLineWidth };
    }
    
    private LineWidth(float paramFloat)
    {
      this.value = paramFloat;
    }
    
    public float value()
    {
      return this.value;
    }
  }
  
  public static enum MarkColor
  {
    private final int value;
    
    static
    {
      COLOR_RED = new MarkColor("COLOR_RED", 2, 2);
      COLOR_GREEN = new MarkColor("COLOR_GREEN", 3, 3);
      MarkColor localMarkColor = new MarkColor("COLOR_BLUE", 4, 4);
      COLOR_BLUE = localMarkColor;
      $VALUES = new MarkColor[] { COLOR_BLACK, COLOR_WHITE, COLOR_RED, COLOR_GREEN, localMarkColor };
    }
    
    private MarkColor(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum MonoChromeType
  {
    private final int value;
    
    static
    {
      MONOCHROME_GREEN = new MonoChromeType("MONOCHROME_GREEN", 2, 2);
      MONOCHROME_BLUE = new MonoChromeType("MONOCHROME_BLUE", 3, 3);
      MonoChromeType localMonoChromeType = new MonoChromeType("MONOCHROME_GRAY", 4, 4);
      MONOCHROME_GRAY = localMonoChromeType;
      $VALUES = new MonoChromeType[] { MONOCHROME_OFF, MONOCHROME_RED, MONOCHROME_GREEN, MONOCHROME_BLUE, localMonoChromeType };
    }
    
    private MonoChromeType(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static MonoChromeType find(int paramInt)
    {
      MonoChromeType[] arrayOfMonoChromeType = values();
      MonoChromeType localMonoChromeType = MONOCHROME_OFF;
      int i = 0;
      while (i < arrayOfMonoChromeType.length)
      {
        if (arrayOfMonoChromeType[i]._equals(paramInt)) {
          return arrayOfMonoChromeType[i];
        }
        i += 1;
      }
      return localMonoChromeType;
    }
    
    public MonoChromeType next()
    {
      MonoChromeType[] arrayOfMonoChromeType = values();
      return arrayOfMonoChromeType[((ordinal() + 1) % arrayOfMonoChromeType.length)];
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum NalType
  {
    private int value;
    
    static
    {
      Dpa = new NalType("Dpa", 1, 2);
      Dpb = new NalType("Dpb", 2, 3);
      Dpc = new NalType("Dpc", 3, 4);
      IdrSlice = new NalType("IdrSlice", 4, 5);
      Sei = new NalType("Sei", 5, 6);
      Sps = new NalType("Sps", 6, 7);
      Pps = new NalType("Pps", 7, 8);
      Aud = new NalType("Aud", 8, 9);
      EndSequence = new NalType("EndSequence", 9, 10);
      EndStream = new NalType("EndStream", 10, 11);
      FillerData = new NalType("FillerData", 11, 12);
      SpsExt = new NalType("SpsExt", 12, 13);
      AuxiliarySlice = new NalType("AuxiliarySlice", 13, 19);
      NalType localNalType = new NalType("FfIgnore", 14, 267448321);
      FfIgnore = localNalType;
      $VALUES = new NalType[] { Slice, Dpa, Dpb, Dpc, IdrSlice, Sei, Sps, Pps, Aud, EndSequence, EndStream, FillerData, SpsExt, AuxiliarySlice, localNalType };
    }
    
    private NalType(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum RatioMarkType
  {
    private final int value;
    
    static
    {
      RATIO_235_1 = new RatioMarkType("RATIO_235_1", 1, 1);
      RATIO_182_1 = new RatioMarkType("RATIO_182_1", 2, 2);
      RATIO_16_9 = new RatioMarkType("RATIO_16_9", 3, 3);
      RATIO_9_16 = new RatioMarkType("RATIO_9_16", 4, 4);
      RatioMarkType localRatioMarkType = new RatioMarkType("RATIO_4_3", 5, 5);
      RATIO_4_3 = localRatioMarkType;
      $VALUES = new RatioMarkType[] { RATIO_OFF, RATIO_235_1, RATIO_182_1, RATIO_16_9, RATIO_9_16, localRatioMarkType };
    }
    
    private RatioMarkType(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static class Resolution
  {
    public int height;
    public int width;
  }
  
  public static enum SafetyMarkType
  {
    private final int value;
    
    static
    {
      SAFETY_MARK_96 = new SafetyMarkType("SAFETY_MARK_96", 1, 96);
      SAFETY_MARK_93 = new SafetyMarkType("SAFETY_MARK_93", 2, 93);
      SAFETY_MARK_90 = new SafetyMarkType("SAFETY_MARK_90", 3, 90);
      SAFETY_MARK_88 = new SafetyMarkType("SAFETY_MARK_88", 4, 88);
      SAFETY_MARK_85 = new SafetyMarkType("SAFETY_MARK_85", 5, 85);
      SafetyMarkType localSafetyMarkType = new SafetyMarkType("SAFETY_MARK_80", 6, 80);
      SAFETY_MARK_80 = localSafetyMarkType;
      $VALUES = new SafetyMarkType[] { SAFETY_MARK_OFF, SAFETY_MARK_96, SAFETY_MARK_93, SAFETY_MARK_90, SAFETY_MARK_88, SAFETY_MARK_85, localSafetyMarkType };
    }
    
    private SafetyMarkType(int paramInt)
    {
      this.value = paramInt;
    }
    
    public int value()
    {
      return this.value;
    }
  }
  
  public static enum VideoCachingSize
  {
    private final int value;
    
    static
    {
      GB_1 = new VideoCachingSize("GB_1", 1, 1);
      GB_2 = new VideoCachingSize("GB_2", 2, 2);
      GB_4 = new VideoCachingSize("GB_4", 3, 4);
      GB_8 = new VideoCachingSize("GB_8", 4, 8);
      VideoCachingSize localVideoCachingSize = new VideoCachingSize("GB_16", 5, 16);
      GB_16 = localVideoCachingSize;
      $VALUES = new VideoCachingSize[] { GB_AUTO, GB_1, GB_2, GB_4, GB_8, localVideoCachingSize };
    }
    
    private VideoCachingSize(int paramInt)
    {
      this.value = paramInt;
    }
    
    private boolean _equals(int paramInt)
    {
      return this.value == paramInt;
    }
    
    public static VideoCachingSize find(int paramInt)
    {
      VideoCachingSize localVideoCachingSize = GB_AUTO;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localVideoCachingSize;
    }
    
    public VideoCachingSize next()
    {
      VideoCachingSize[] arrayOfVideoCachingSize = values();
      return arrayOfVideoCachingSize[((ordinal() + 1) % arrayOfVideoCachingSize.length)];
    }
    
    public int value()
    {
      return this.value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\DJIVideoUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */