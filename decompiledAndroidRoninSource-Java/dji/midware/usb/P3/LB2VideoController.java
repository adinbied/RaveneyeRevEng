package dji.midware.usb.P3;

import dji.midware.data.config.P3.Ccode;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.manager.P3.DataEvent;
import dji.midware.data.model.P3.DataDm368GetParams;
import dji.midware.data.model.P3.DataDm368GetPushStatus;
import dji.midware.data.model.extension.DataOsdConfigEx;
import dji.midware.interfaces.DJIDataCallBack;
import java.util.TimerTask;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class LB2VideoController
{
  private static final String TAG = "LB2VideoController";
  private static LB2VideoController lb2VideoController;
  private DualType curDualType;
  private SingleType curSingleType;
  private int dualBandwidth = -1;
  private EncodeMode encodeMode;
  DataDm368GetParams mDataDm386GetParams = new DataDm368GetParams();
  private int singleBandwidth = -1;
  
  private LB2VideoController()
  {
    init();
  }
  
  public static LB2VideoController getInstance()
  {
    if (lb2VideoController == null) {
      lb2VideoController = new LB2VideoController();
    }
    return lb2VideoController;
  }
  
  /* Error */
  private void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isDualType()
  {
    return false;
  }
  
  private boolean isSingleType()
  {
    return false;
  }
  
  public static void log(String paramString) {}
  
  /* Error */
  private void updateDualType()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateSingleType()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateValue()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DualType getCurDualType()
  {
    return this.curDualType;
  }
  
  public SingleType getCurSingleType()
  {
    return this.curSingleType;
  }
  
  public int getDualBandWidth()
  {
    return 0;
  }
  
  public EncodeMode getEncodeMode()
  {
    return this.encodeMode;
  }
  
  public int getSingleBandWidth()
  {
    return 0;
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(ProductType paramProductType)
  {
    updateValue();
    updateDualBandWidth();
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.data.manager.P3.DataCameraEvent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataEvent paramDataEvent)
  {
    updateValue();
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataDm368GetPushStatus paramDataDm368GetPushStatus)
  {
    updateValue();
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DataOsdConfigEx paramDataOsdConfigEx)
  {
    updateValue();
  }
  
  /* Error */
  public void setCurDualType(DualType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setCurSingleType(SingleType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void updateDualBandWidth()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum DualType
  {
    static
    {
      DualType localDualType = new DualType("AV", 1);
      AV = localDualType;
      $VALUES = new DualType[] { HDMI, localDualType };
    }
    
    private DualType() {}
  }
  
  public static enum EncodeMode
  {
    static
    {
      DUAL = new EncodeMode("DUAL", 2);
      EncodeMode localEncodeMode = new EncodeMode("NONE", 3);
      NONE = localEncodeMode;
      $VALUES = new EncodeMode[] { DEFAULT, SINGLE, DUAL, localEncodeMode };
    }
    
    private EncodeMode() {}
  }
  
  public static enum SingleType
  {
    static
    {
      SingleType localSingleType = new SingleType("EXT", 1);
      EXT = localSingleType;
      $VALUES = new SingleType[] { LB, localSingleType };
    }
    
    private SingleType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\usb\P3\LB2VideoController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */