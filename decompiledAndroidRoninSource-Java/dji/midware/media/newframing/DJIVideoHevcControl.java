package dji.midware.media.newframing;

import dji.midware.data.config.P3.Ccode;
import dji.midware.data.model.P3.DataCameraGetMode.MODE;
import dji.midware.data.model.P3.DataCameraGetVideoEncode;
import dji.midware.interfaces.DJIDataCallBack;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class DJIVideoHevcControl
{
  private static final int HEVC_SEND_DURATION = 500;
  private static final int HEVC_SEND_RETRY_COUNT = 3;
  private static final String TAG = "DJIVideoHevcControl";
  private Disposable mDisposable;
  private HevcDisposeStatusListener mHevcDisposeStatusListener;
  private DataCameraGetMode.MODE mLastCameraMode = null;
  private Subject<Object> mSendSubject = BehaviorSubject.create().toSerialized();
  
  /* Error */
  private void checkPlayBackStatus(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void dealHevcResponse(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static DJIVideoHevcControl getInstance()
  {
    return SingletonHolder.INSTANCE;
  }
  
  private Observable<Object> transferVideoEncodeFormatObservable()
  {
    return null;
  }
  
  /* Error */
  public void changeVideoEncodeFormat()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void initHevcControl()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.model.P3.DataCameraGetPushStateInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void releaseHevcControl()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setHevcDisposeStatusListener(HevcDisposeStatusListener paramHevcDisposeStatusListener)
  {
    this.mHevcDisposeStatusListener = paramHevcDisposeStatusListener;
  }
  
  static abstract interface HevcDisposeStatusListener
  {
    public abstract void onHevcControlRelease();
  }
  
  private static class SingletonHolder
  {
    private static final DJIVideoHevcControl INSTANCE = new DJIVideoHevcControl();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\newframing\DJIVideoHevcControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */