package dji.midware.media.metadata;

import com.dji.video.framing.DJIVideoDecoderInterface.IVideoRecordInfo;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo.CameraType;
import dji.midware.data.model.P3.DataCameraSetExposureMode.ExposureMode;
import dji.midware.media.record.DroneVideoSegment;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

public class VideoRecordInfo
  implements DJIVideoDecoderInterface.IVideoRecordInfo
{
  private static final boolean DEBUG = false;
  private static final String SupportedVersion = "1.0";
  private static final String TAG = "VideoRecordInfo";
  private static final double UNDEFINED_DOUBLE = -100.0D;
  public static final int UNDEFINED_INT = -100;
  private static final long UNDEFINED_LONG = -100L;
  private static final String UNDEFINED_STR = "__UNDEFINED__";
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US);
  @Mapper(key="ApertureSize")
  public Integer apertureSize;
  @Mapper(key="CameraType")
  public DataCameraGetPushStateInfo.CameraType cameraType;
  @Mapper(key="CaptureDate")
  public Date captureDate;
  @Mapper(key="DeviceMaker")
  public String deviceMaker;
  @Mapper(key="EndTimeMsec")
  public Integer endTimeMsec;
  @Mapper(key="ExposureMode")
  public DataCameraSetExposureMode.ExposureMode exposureMode;
  @Mapper(key="FileID_Drone")
  public Integer fileId_drone;
  @Mapper(key="File_Source_Type")
  public Integer fileSourceType;
  @Mapper(key="FolderID_Drone")
  public Integer folderID_drone;
  @Mapper(key="FPS_Drone")
  public Integer fps_drone;
  @Mapper(key="FPS_local")
  public Integer fps_local;
  @Mapper(key="FrameJumpped")
  public Integer frameJumpped;
  @Mapper(key="ISO")
  public Integer iSO;
  @Mapper(key="ImageDescription")
  public String imageDescription;
  @Mapper(key="Is_HD")
  public Boolean isHD;
  @Mapper(key="LocalFileName")
  public String localFileName;
  @Mapper(key="LocationString")
  public String locationString;
  @Mapper(key="PixelXDimension_Local")
  public Integer pixelXDimension_app;
  @Mapper(key="PixelXDimension_Drone")
  public Integer pixelXDimension_drone;
  @Mapper(key="PixelYDimension_Local")
  public Integer pixelYDimension_app;
  @Mapper(key="PixelYDimension_Drone")
  public Integer pixelYDimension_drone;
  @Mapper(key="PositionGPSAlt")
  public Double positionGPSAlt;
  @Mapper(key="PositionGPSLat")
  public Double positionGPSLat;
  @Mapper(key="PositionGPSLng")
  public Double positionGPSLng;
  @Mapper(key="PositionRelativeAlt")
  public Double positionRelativeAlt;
  @Mapper(key="ProductType")
  public ProductType productType;
  @Mapper(key="ShutterSpeed")
  public String shutterSpeed;
  @Mapper(key="Source_File_Path")
  public String sourceFilePath;
  @Mapper(key="StartTimeMsec")
  public Integer startTimeMsec;
  @Mapper(key="Sync_Drone_Time")
  @Type(elementType=Integer.class)
  public Vector<Integer> syncDroneTime;
  @Mapper(key="Sync_Local_Time")
  @Type(elementType=Integer.class)
  public Vector<Integer> syncLocalTime;
  @Mapper(key="UUID_Drone")
  public Long uuid_drone;
  @Mapper(key="Version")
  public final String version = "1.0";
  @Mapper(key="Video_Type")
  public Integer videoType;
  @Mapper(key="Video_Resolution_Enum_Drone")
  public Integer video_Resolution_Enum_Drone;
  @Mapper(key="WhiteBalance")
  public Integer whiteBalance;
  
  public VideoRecordInfo()
  {
    Integer localInteger = Integer.valueOf(-100);
    this.apertureSize = localInteger;
    this.shutterSpeed = "__UNDEFINED__";
    this.whiteBalance = localInteger;
    this.iSO = localInteger;
    this.imageDescription = "__UNDEFINED__";
    this.deviceMaker = "__UNDEFINED__";
    this.pixelXDimension_app = localInteger;
    this.pixelYDimension_app = localInteger;
    this.captureDate = new Date(0L);
    this.fps_local = localInteger;
    Double localDouble = Double.valueOf(-100.0D);
    this.positionGPSLng = localDouble;
    this.positionGPSLat = localDouble;
    this.positionGPSAlt = localDouble;
    this.positionRelativeAlt = localDouble;
    this.locationString = "__UNDEFINED__";
    this.localFileName = "__UNDEFINED__";
    this.pixelXDimension_drone = localInteger;
    this.pixelYDimension_drone = localInteger;
    this.video_Resolution_Enum_Drone = localInteger;
    this.fps_drone = localInteger;
    this.uuid_drone = Long.valueOf(-100L);
    this.fileId_drone = localInteger;
    this.folderID_drone = localInteger;
    this.startTimeMsec = localInteger;
    this.endTimeMsec = localInteger;
    this.frameJumpped = localInteger;
    this.syncLocalTime = null;
    this.syncDroneTime = null;
    this.isHD = Boolean.valueOf(false);
    this.sourceFilePath = "";
    this.fileSourceType = localInteger;
    this.videoType = Integer.valueOf(0);
  }
  
  /* Error */
  public void addSyncDroneTime(Integer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addSyncLocalTime(Integer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int getApertureSize()
  {
    return this.apertureSize.intValue();
  }
  
  public DataCameraGetPushStateInfo.CameraType getCameraType()
  {
    return this.cameraType;
  }
  
  public Date getCaptureDate()
  {
    return this.captureDate;
  }
  
  public String getDeviceMaker()
  {
    return this.deviceMaker;
  }
  
  public DroneVideoSegment getDroneDuration(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public Vector<DroneVideoSegment> getDroneSegments(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public int getEndTimeMsec()
  {
    return this.endTimeMsec.intValue();
  }
  
  public DataCameraSetExposureMode.ExposureMode getExposureMode()
  {
    return this.exposureMode;
  }
  
  public int getFPS_local()
  {
    return this.fps_local.intValue();
  }
  
  public int getFileId_drone()
  {
    return this.fileId_drone.intValue();
  }
  
  public Integer getFileSourceType()
  {
    return this.fileSourceType;
  }
  
  public int getFolderID_drone()
  {
    return this.folderID_drone.intValue();
  }
  
  public int getFps_drone()
  {
    return this.fps_drone.intValue();
  }
  
  public int getFrameJumpped()
  {
    return this.frameJumpped.intValue();
  }
  
  public String getImageDescription()
  {
    return this.imageDescription;
  }
  
  public Boolean getIsHD()
  {
    return this.isHD;
  }
  
  public String getLocalFileName()
  {
    return this.localFileName;
  }
  
  public String getLocationString()
  {
    return this.locationString;
  }
  
  public int getPixelXDimension_Drone()
  {
    return this.pixelXDimension_drone.intValue();
  }
  
  public int getPixelXDimension_app()
  {
    return this.pixelXDimension_app.intValue();
  }
  
  public int getPixelYDimension_Drone()
  {
    return this.pixelYDimension_drone.intValue();
  }
  
  public int getPixelYDimension_app()
  {
    return this.pixelYDimension_app.intValue();
  }
  
  public double getPositionGPSAlt()
  {
    return this.positionGPSAlt.doubleValue();
  }
  
  public double getPositionGPSLat()
  {
    return this.positionGPSLat.doubleValue();
  }
  
  public double getPositionRelativeAlt()
  {
    return this.positionRelativeAlt.doubleValue();
  }
  
  public double getPositonGPSLng()
  {
    return this.positionGPSLng.doubleValue();
  }
  
  public ProductType getProductType()
  {
    return this.productType;
  }
  
  public String getShutterSpeed()
  {
    return this.shutterSpeed;
  }
  
  public String getSourceFilePath()
  {
    return this.sourceFilePath;
  }
  
  public int getStartTimeMsec()
  {
    return this.startTimeMsec.intValue();
  }
  
  public Vector<Integer> getSyncDroneTime()
  {
    return this.syncDroneTime;
  }
  
  public Vector<Integer> getSyncLocalTime()
  {
    return this.syncLocalTime;
  }
  
  public long getUuid_drone()
  {
    return this.uuid_drone.longValue();
  }
  
  public String getVersion()
  {
    return "1.0";
  }
  
  public int getVideoType()
  {
    return this.videoType.intValue();
  }
  
  public int getVideo_Resolution_Enum_Drone()
  {
    return this.video_Resolution_Enum_Drone.intValue();
  }
  
  public int getWhiteBalance()
  {
    return this.whiteBalance.intValue();
  }
  
  public int getiSO()
  {
    return this.iSO.intValue();
  }
  
  /* Error */
  public void load(String arg1)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public int mapLocalToDroneWithoutRectification(int paramInt)
  {
    return 0;
  }
  
  public void setApertureSize(int paramInt)
  {
    this.apertureSize = Integer.valueOf(paramInt);
  }
  
  public void setCameraType(DataCameraGetPushStateInfo.CameraType paramCameraType)
  {
    this.cameraType = paramCameraType;
  }
  
  public void setCaptureDate(Date paramDate)
  {
    this.captureDate = paramDate;
  }
  
  public void setDeviceMaker(String paramString)
  {
    this.deviceMaker = paramString;
  }
  
  public void setEndTimeMsec(int paramInt)
  {
    this.endTimeMsec = Integer.valueOf(paramInt);
  }
  
  public void setExposureMode(DataCameraSetExposureMode.ExposureMode paramExposureMode)
  {
    this.exposureMode = paramExposureMode;
  }
  
  public void setFPS_local(int paramInt)
  {
    this.fps_local = Integer.valueOf(paramInt);
  }
  
  public void setFileId_drone(int paramInt)
  {
    this.fileId_drone = Integer.valueOf(paramInt);
  }
  
  public void setFileSourceType(Integer paramInteger)
  {
    this.fileSourceType = paramInteger;
  }
  
  public void setFolderID_drone(int paramInt)
  {
    this.folderID_drone = Integer.valueOf(paramInt);
  }
  
  public void setFps_drone(int paramInt)
  {
    this.fps_drone = Integer.valueOf(paramInt);
  }
  
  public void setFrameJumpped(int paramInt)
  {
    this.frameJumpped = Integer.valueOf(paramInt);
  }
  
  public void setImageDescription(String paramString)
  {
    this.imageDescription = paramString;
  }
  
  public void setIsHD(Boolean paramBoolean)
  {
    this.isHD = paramBoolean;
  }
  
  public void setLocalFileName(String paramString)
  {
    this.localFileName = paramString;
  }
  
  public void setLocationString(String paramString)
  {
    this.locationString = paramString;
  }
  
  public void setPixelXDimension_Drone(int paramInt)
  {
    this.pixelXDimension_drone = Integer.valueOf(paramInt);
  }
  
  public void setPixelXDimension_app(int paramInt)
  {
    this.pixelXDimension_app = Integer.valueOf(paramInt);
  }
  
  public void setPixelYDimension_Drone(int paramInt)
  {
    this.pixelYDimension_drone = Integer.valueOf(paramInt);
  }
  
  public void setPixelYDimension_app(int paramInt)
  {
    this.pixelYDimension_app = Integer.valueOf(paramInt);
  }
  
  public void setPositionGPSAlt(double paramDouble)
  {
    this.positionGPSAlt = Double.valueOf(paramDouble);
  }
  
  public void setPositionGPSLat(double paramDouble)
  {
    this.positionGPSLat = Double.valueOf(paramDouble);
  }
  
  public void setPositionGPSLng(double paramDouble)
  {
    this.positionGPSLng = Double.valueOf(paramDouble);
  }
  
  public void setPositionRelativeAlt(double paramDouble)
  {
    this.positionRelativeAlt = Double.valueOf(paramDouble);
  }
  
  public void setProductType(ProductType paramProductType)
  {
    this.productType = paramProductType;
  }
  
  public void setShutterSpeed(String paramString)
  {
    this.shutterSpeed = paramString;
  }
  
  public void setSourceFilePath(String paramString)
  {
    this.sourceFilePath = paramString;
  }
  
  public void setStartTimeMsec(int paramInt)
  {
    this.startTimeMsec = Integer.valueOf(paramInt);
  }
  
  public void setSyncDroneTime(Vector<Integer> paramVector)
  {
    this.syncDroneTime = paramVector;
  }
  
  public void setSyncLocalTime(Vector<Integer> paramVector)
  {
    this.syncLocalTime = paramVector;
  }
  
  public void setUuid_drone(long paramLong)
  {
    this.uuid_drone = Long.valueOf(paramLong);
  }
  
  public void setVideoType(int paramInt)
  {
    this.videoType = Integer.valueOf(paramInt);
  }
  
  public void setVideo_Resolution_Enum_Drone(int paramInt)
  {
    this.video_Resolution_Enum_Drone = Integer.valueOf(paramInt);
  }
  
  public void setWhiteBalance(int paramInt)
  {
    this.whiteBalance = Integer.valueOf(paramInt);
  }
  
  public void setiSO(int paramInt)
  {
    this.iSO = Integer.valueOf(paramInt);
  }
  
  /* Error */
  public void store(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public String toString()
  {
    return null;
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface Mapper
  {
    String key();
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  public static @interface Type
  {
    Class<?> elementType();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\metadata\VideoRecordInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */