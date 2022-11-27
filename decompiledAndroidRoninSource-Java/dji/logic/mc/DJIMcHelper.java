package dji.logic.mc;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DataCameraEvent;
import dji.midware.data.manager.P3.ServiceManager;
import dji.midware.data.model.P3.DataFlycGetParams;
import dji.midware.data.model.P3.DataOsdGetPushCommon;
import dji.midware.data.model.P3.DataOsdGetPushCommon.RcModeChannel;
import dji.midware.data.params.P3.ParamCfgName;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.BackgroundLooper;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DJIMcHelper
  implements ParamCfgName
{
  private static final String[] CFG_CTRLMODES = { "g_config.control.control_mode[0]_0", "g_config.control.control_mode[1]_0", "g_config.control.control_mode[2]_0" };
  private static final int CODE_FAIL = 1;
  private static final int CODE_SUCCESS = 0;
  private static final DataOsdGetPushCommon.RcModeChannel[] DEFAULT_RCMODECHLS = { DataOsdGetPushCommon.RcModeChannel.CHANNEL_F, DataOsdGetPushCommon.RcModeChannel.CHANNEL_A, DataOsdGetPushCommon.RcModeChannel.CHANNEL_P };
  private static final DataOsdGetPushCommon.RcModeChannel[] DEFAULT_RCMODECHLS_SPORT = { DataOsdGetPushCommon.RcModeChannel.CHANNEL_A, DataOsdGetPushCommon.RcModeChannel.CHANNEL_S, DataOsdGetPushCommon.RcModeChannel.CHANNEL_P };
  private static final int MSG_ID_GET_RCMODECHLS = 4096;
  private static final int MSG_ID_REGET_RCMODECHLS = 4097;
  private static final String TAG = DJIMcHelper.class.getSimpleName();
  private volatile int mFlycVersion;
  private volatile boolean mGetted;
  private final Handler mHandler;
  private final ReentrantReadWriteLock.ReadLock mRLocker;
  private final ReentrantReadWriteLock mRWLocker;
  private final DataOsdGetPushCommon.RcModeChannel[] mRcModeChannels = { DataOsdGetPushCommon.RcModeChannel.CHANNEL_F, DataOsdGetPushCommon.RcModeChannel.CHANNEL_A, DataOsdGetPushCommon.RcModeChannel.CHANNEL_P };
  private final DataOsdGetPushCommon.RcModeChannel[] mTmpRcModeChls = { DataOsdGetPushCommon.RcModeChannel.CHANNEL_F, DataOsdGetPushCommon.RcModeChannel.CHANNEL_A, DataOsdGetPushCommon.RcModeChannel.CHANNEL_P };
  private final ReentrantReadWriteLock.WriteLock mWLocker;
  final DataFlycGetParams setter;
  
  private DJIMcHelper()
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock(false);
    this.mRWLocker = localReentrantReadWriteLock;
    this.mRLocker = localReentrantReadWriteLock.readLock();
    this.mWLocker = this.mRWLocker.writeLock();
    this.mFlycVersion = Integer.MIN_VALUE;
    this.mGetted = false;
    this.mHandler = new Handler(BackgroundLooper.getLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        return false;
      }
    });
    this.setter = new DataFlycGetParams();
    EventBus.getDefault().register(this);
    resetRcModeChannels();
    if (DataOsdGetPushCommon.getInstance().isGetted()) {
      onEvent3BackgroundThread(DataOsdGetPushCommon.getInstance());
    }
    if (ServiceManager.getInstance().isRemoteOK()) {
      onEvent3BackgroundThread(DataCameraEvent.ConnectOK);
    }
  }
  
  public static DJIMcHelper getInstance()
  {
    return SingletonHolder.mInstance;
  }
  
  /* Error */
  private void getRcModeChannelByParam()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void regetRcModeChannel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void resetRcModeChannels()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public DataOsdGetPushCommon.RcModeChannel getRcModeChannel(int paramInt)
  {
    return null;
  }
  
  public boolean isGetted()
  {
    return this.mGetted;
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(ProductType paramProductType)
  {
    if (!this.mGetted) {
      resetRcModeChannels();
    }
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DataEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.ASYNC)
  public void onEvent3BackgroundThread(DataOsdGetPushCommon arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static final class SingletonHolder
  {
    private static final DJIMcHelper mInstance = new DJIMcHelper(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\mc\DJIMcHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */