package dji.midware.media.record;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract interface RecorderInterface
{
  public abstract String getRecordingFileName();
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public abstract void onEvent3BackgroundThread(RecorderManager.Service_Action paramService_Action);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\record\RecorderInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */