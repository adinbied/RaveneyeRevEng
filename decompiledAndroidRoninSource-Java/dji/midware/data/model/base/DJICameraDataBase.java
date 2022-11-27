package dji.midware.data.model.base;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.data.manager.P3.DataCameraEvent;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class DJICameraDataBase
  extends DataBase
{
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataCameraEvent paramDataCameraEvent)
  {
    if (paramDataCameraEvent == DataCameraEvent.ConnectLose) {
      clear();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\base\DJICameraDataBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */