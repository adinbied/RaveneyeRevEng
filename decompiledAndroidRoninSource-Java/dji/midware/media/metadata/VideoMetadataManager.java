package dji.midware.media.metadata;

import com.dji.frame.util.V_DiskUtil;
import dji.log.RoninLog;
import dji.logic.utils.DJIProductSupportUtil;
import dji.midware.data.manager.P3.ServiceManager;
import dji.midware.media.DJIVideoUtil;
import dji.midware.media.MediaLogger;
import java.io.File;
import java.util.Locale;

public class VideoMetadataManager
{
  private static String TAG = "BufferedVideoDatabase";
  
  public static VideoRecordInfo createMomentInfo(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("create a moment info: momentName=");
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("; sourceFile=");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append(" startTime=");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(" endTime=");
    ((StringBuilder)localObject2).append(paramInt2);
    RoninLog.i((String)localObject1, ((StringBuilder)localObject2).toString(), new Object[0]);
    localObject1 = new VideoRecordInfo();
    if (paramString2 == null) {
      return (VideoRecordInfo)localObject1;
    }
    localObject2 = getInfoPathFromVideoPath(paramString2);
    if (new File((String)localObject2).exists()) {}
    try
    {
      ((VideoRecordInfo)localObject1).load((String)localObject2);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (loadMetadataFromOriginalVideo((VideoRecordInfo)localObject1, paramString2)) {
      ((VideoRecordInfo)localObject1).setFileSourceType(Integer.valueOf(2));
    }
    ((VideoRecordInfo)localObject1).setStartTimeMsec(paramInt1);
    ((VideoRecordInfo)localObject1).setEndTimeMsec(paramInt2);
    ((VideoRecordInfo)localObject1).setLocalFileName(paramString1);
    ((VideoRecordInfo)localObject1).setSourceFilePath(paramString2);
    ((VideoRecordInfo)localObject1).store(getMomentInfoPathFromMomentName(paramString1));
    return (VideoRecordInfo)localObject1;
  }
  
  public static void deleteMoment(String paramString)
  {
    new File(getMomentInfoPathFromMomentName(paramString)).delete();
  }
  
  public static void deleteMomentInfo(String paramString)
  {
    paramString = getMomentInfoPathFromMomentPath(paramString);
    if (paramString != null)
    {
      paramString = new File(paramString);
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Delete ");
      localStringBuilder.append(paramString.getAbsolutePath());
      MediaLogger.i(str, localStringBuilder.toString());
      paramString.delete();
    }
  }
  
  public static boolean existsMoment(String paramString)
  {
    return new File(getMomentInfoPathFromMomentName(paramString)).exists();
  }
  
  public static boolean existsSource(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSourceVideoDirectory());
    localStringBuilder.append(paramString);
    localStringBuilder.append(".info");
    return new File(localStringBuilder.toString()).exists();
  }
  
  private static String getInfoPathFromVideoPath(String paramString)
  {
    if ((paramString != null) && (paramString.length() >= 4))
    {
      String str = paramString.toLowerCase(Locale.US);
      if ((!str.endsWith(".mp4")) && (!str.endsWith(".mov")))
      {
        MediaLogger.e(TAG, "unrecognised video file path");
        return paramString;
      }
      paramString = new StringBuilder();
      paramString.append(str.substring(0, str.length() - 4));
      paramString.append(".info");
      return paramString.toString();
    }
    MediaLogger.e(TAG, "unrecognised video file path");
    return paramString;
  }
  
  public static VideoRecordInfo getMomentInfo(String paramString)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request a moment info with name ");
    localStringBuilder.append(paramString);
    RoninLog.i((String)localObject, localStringBuilder.toString(), new Object[0]);
    localObject = new VideoRecordInfo();
    paramString = getMomentInfoPathFromMomentName(paramString);
    if (new File(paramString).exists()) {}
    try
    {
      ((VideoRecordInfo)localObject).load(paramString);
      if ((((VideoRecordInfo)localObject).getProductType() == null) && (loadMetadataFromOriginalVideo((VideoRecordInfo)localObject, ((VideoRecordInfo)localObject).getSourceFilePath()))) {
        ((VideoRecordInfo)localObject).store(paramString);
      }
      return (VideoRecordInfo)localObject;
    }
    catch (Exception paramString) {}
    if (loadMetadataFromOriginalVideo((VideoRecordInfo)localObject, ((VideoRecordInfo)localObject).getSourceFilePath())) {
      ((VideoRecordInfo)localObject).store(paramString);
    }
    return (VideoRecordInfo)localObject;
    return (VideoRecordInfo)localObject;
  }
  
  public static String getMomentInfoDirectory()
  {
    ServiceManager.getInstance();
    String str = V_DiskUtil.getExternalCacheDirPath(ServiceManager.getContext(), "VideoDatabase/MomentInfo/");
    DJIVideoUtil.checkAndCreateDirectory(str);
    return str;
  }
  
  private static String getMomentInfoPathFromMomentName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getMomentInfoDirectory());
    localStringBuilder.append("moment_");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".info");
    return localStringBuilder.toString();
  }
  
  private static String getMomentInfoPathFromMomentPath(String paramString)
  {
    paramString = new File(paramString).getName();
    if ((paramString != null) && (paramString.length() >= 4) && (paramString.toLowerCase(Locale.US).endsWith(".mp4"))) {
      return getMomentInfoPathFromMomentName(paramString.substring(0, paramString.length() - 4));
    }
    return null;
  }
  
  public static VideoRecordInfo getSourceInfo(String paramString)
  {
    VideoRecordInfo localVideoRecordInfo = new VideoRecordInfo();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSourceVideoDirectory());
    localStringBuilder.append(paramString);
    localStringBuilder.append(".info");
    paramString = localStringBuilder.toString();
    if (new File(paramString).exists()) {}
    try
    {
      localVideoRecordInfo.load(paramString);
      return localVideoRecordInfo;
    }
    catch (Exception paramString) {}
    return null;
    return null;
  }
  
  public static String getSourceVideoDirectory()
  {
    ServiceManager.getInstance();
    String str = V_DiskUtil.getExternalCacheDirPath(ServiceManager.getContext(), "DJI_RECORD/");
    DJIVideoUtil.checkAndCreateDirectory(str);
    return str;
  }
  
  private static boolean loadMetadataFromOriginalVideo(VideoRecordInfo paramVideoRecordInfo, String paramString)
  {
    if (!new File(paramString).exists()) {
      return false;
    }
    Object localObject = new OriginalVideoMetadataRetriever();
    try
    {
      ((OriginalVideoMetadataRetriever)localObject).setDataSource(paramString);
      ((OriginalVideoMetadataRetriever)localObject).extract();
      paramString = ((OriginalVideoMetadataRetriever)localObject).getGPS();
      if ((paramString[0] != 0.0D) && (paramString[1] != 0.0D))
      {
        paramVideoRecordInfo.setPositionGPSLng(paramString[0]);
        paramVideoRecordInfo.setPositionGPSLat(paramString[1]);
      }
      paramVideoRecordInfo.setProductType(DJIProductSupportUtil.getProductTypeFormExfMap(((OriginalVideoMetadataRetriever)localObject).getMap()));
      paramVideoRecordInfo.setCaptureDate(((OriginalVideoMetadataRetriever)localObject).getCaptureDate());
      paramString = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("From drone. CaptureDate = ");
      ((StringBuilder)localObject).append(paramVideoRecordInfo.getCaptureDate());
      MediaLogger.i(paramString, ((StringBuilder)localObject).toString());
      return true;
    }
    catch (Exception paramVideoRecordInfo) {}
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\metadata\VideoMetadataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */