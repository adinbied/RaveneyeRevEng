package dji.midware.media.metadata;

import dji.midware.data.config.P3.Ccode;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.model.P3.DataCameraGetPushShotParams;
import dji.midware.data.model.P3.DataCameraGetPushStateInfo;
import dji.midware.data.model.P3.DataCameraGetVideoParams;
import dji.midware.data.model.P3.DataOsdGetPushCommon;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.media.DJIVideoUtil;
import dji.midware.media.MediaLogger;
import java.util.Date;
import org.greenrobot.eventbus.EventBus;

public class VideoRecordInfoSetter
{
  private static final String TAG = "VideoRecordInfoSetter";
  private String fileMainName;
  private VideoRecordInfo flightInfo = null;
  private boolean hasCameraGetPushShotParams = false;
  private boolean hasCameraGetPushStateInfo = false;
  private boolean hasCameraGetVideoParams = false;
  private boolean hasOsdGetPushCommon = false;
  private boolean hasProductType = false;
  private boolean hasRcGetPushGpsInfo = false;
  
  public VideoRecordInfoSetter(VideoRecordInfo paramVideoRecordInfo, Date paramDate, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    this.fileMainName = paramString1;
    this.flightInfo = paramVideoRecordInfo;
    paramVideoRecordInfo.setCaptureDate(paramDate);
    this.flightInfo.setImageDescription("");
    this.flightInfo.setDeviceMaker("DJI");
    this.flightInfo.setLocationString("");
    this.flightInfo.setStartTimeMsec(0);
    this.flightInfo.setEndTimeMsec(-1);
    this.flightInfo.setPixelXDimension_app(paramInt1);
    this.flightInfo.setPixelYDimension_app(paramInt2);
    this.flightInfo.setFPS_local(DJIVideoUtil.getFPS());
    this.flightInfo.setFrameJumpped(0);
    this.flightInfo.setSourceFilePath(paramString2);
    this.flightInfo.setFileSourceType(Integer.valueOf(1));
    paramVideoRecordInfo.setLocalFileName(paramString1);
    if (DataCameraGetPushStateInfo.getInstance().isGetted()) {
      onEvent3BackgroundThread(DataCameraGetPushStateInfo.getInstance());
    }
    if (DataOsdGetPushCommon.getInstance().isGetted()) {
      onEvent3BackgroundThread(DataOsdGetPushCommon.getInstance());
    }
    if (DataCameraGetPushShotParams.getInstance().isGetted()) {
      onEvent3BackgroundThread(DataCameraGetPushShotParams.getInstance());
    }
    onEvent3BackgroundThread(DJIProductManager.getInstance().getType());
    DataCameraGetVideoParams.getInstance().start(new DJIDataCallBack()
    {
      public void onFailure(Ccode paramAnonymousCcode) {}
      
      public void onSuccess(Object paramAnonymousObject)
      {
        VideoRecordInfoSetter.this.onEvent3BackgroundThread((DataCameraGetVideoParams)paramAnonymousObject);
      }
    });
    EventBus.getDefault().register(this);
    saveFile();
    MediaLogger.i("VideoRecordInfoSetter", "initilized");
  }
  
  /* Error */
  public void addSyncPoint(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void onDestroy()
  {
    EventBus.getDefault().unregister(this);
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.config.P3.ProductType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraGetPushShotParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraGetPushStateInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraGetVideoParams arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataOsdGetPushCommon arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void saveFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void setEndTimeMsec(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setQuickMovieType(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\metadata\VideoRecordInfoSetter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */