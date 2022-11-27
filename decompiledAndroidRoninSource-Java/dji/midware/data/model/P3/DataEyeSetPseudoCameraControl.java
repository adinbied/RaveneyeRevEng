package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataEyeSetPseudoCameraControl
  extends DataBase
  implements DJIDataSyncListener
{
  private PseudoCameraCmd pseudoCameraCmd = PseudoCameraCmd.PSEUDO_CAMERA_CMD_RELEASE;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public PseudoCameraCmdResult getPseudoCameraCmdResult()
  {
    return null;
  }
  
  public DataEyeSetPseudoCameraControl setPseudoCameraCmd(PseudoCameraCmd paramPseudoCameraCmd)
  {
    this.pseudoCameraCmd = paramPseudoCameraCmd;
    return this;
  }
  
  /* Error */
  public void start(dji.midware.interfaces.DJIDataCallBack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static enum PseudoCameraCmd
  {
    private int data;
    
    static
    {
      PSEUDO_CAMERA_CMD_SET_MODE_BOKEH = new PseudoCameraCmd("PSEUDO_CAMERA_CMD_SET_MODE_BOKEH", 4, DataEyeGetPushPseudoCameraParams.PseudoCameraMode.PSEUDO_CAMERA_MODE_BOKEH.value());
      PSEUDO_CAMERA_CMD_SET_MODE_GESTURE = new PseudoCameraCmd("PSEUDO_CAMERA_CMD_SET_MODE_GESTURE", 5, DataEyeGetPushPseudoCameraParams.PseudoCameraMode.PSEUDO_CAMERA_MODE_GESTURE.value());
      PSEUDO_CAMERA_CMD_SET_MODE_PANO_3x1 = new PseudoCameraCmd("PSEUDO_CAMERA_CMD_SET_MODE_PANO_3x1", 6, DataEyeGetPushPseudoCameraParams.PseudoCameraMode.PSEUDO_CAMERA_MODE_PANO_3x1.value());
      PSEUDO_CAMERA_CMD_SET_MODE_PANO_3x3 = new PseudoCameraCmd("PSEUDO_CAMERA_CMD_SET_MODE_PANO_3x3", 7, DataEyeGetPushPseudoCameraParams.PseudoCameraMode.PSEUDO_CAMERA_MODE_PANO_3x3.value());
      PseudoCameraCmd localPseudoCameraCmd = new PseudoCameraCmd("OTHER", 8, 255);
      OTHER = localPseudoCameraCmd;
      $VALUES = new PseudoCameraCmd[] { PSEUDO_CAMERA_CMD_ABORT, PSEUDO_CAMERA_CMD_CAPTURE, PSEUDO_CAMERA_CMD_RELEASE, PSEUDO_CAMERA_CMD_SET_MODE_PANO_1x3, PSEUDO_CAMERA_CMD_SET_MODE_BOKEH, PSEUDO_CAMERA_CMD_SET_MODE_GESTURE, PSEUDO_CAMERA_CMD_SET_MODE_PANO_3x1, PSEUDO_CAMERA_CMD_SET_MODE_PANO_3x3, localPseudoCameraCmd };
    }
    
    private PseudoCameraCmd(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static PseudoCameraCmd find(int paramInt)
    {
      PseudoCameraCmd localPseudoCameraCmd = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPseudoCameraCmd;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public byte value()
    {
      return (byte)this.data;
    }
  }
  
  public static enum PseudoCameraCmdResult
  {
    private int data;
    
    static
    {
      PSEUDO_CAMERA_ACK_FAIL = new PseudoCameraCmdResult("PSEUDO_CAMERA_ACK_FAIL", 1, 1);
      PSEUDO_CAMERA_ACK_FAIL_ABORT = new PseudoCameraCmdResult("PSEUDO_CAMERA_ACK_FAIL_ABORT", 2, 2);
      PSEUDO_CAMERA_ACK_FAIL_NOT_SUPPORTED = new PseudoCameraCmdResult("PSEUDO_CAMERA_ACK_FAIL_NOT_SUPPORTED", 3, 3);
      PSEUDO_CAMERA_ACK_FAIL_BUSY = new PseudoCameraCmdResult("PSEUDO_CAMERA_ACK_FAIL_BUSY", 4, 4);
      PSEUDO_CAMERA_ACK_FAIL_INVALID_REQUEST = new PseudoCameraCmdResult("PSEUDO_CAMERA_ACK_FAIL_INVALID_REQUEST", 5, 5);
      PSEUDO_CAMERA_ACK_FAIL_ON_GROUND = new PseudoCameraCmdResult("PSEUDO_CAMERA_ACK_FAIL_ON_GROUND", 6, 6);
      PSEUDO_CAMERA_ACK_FAIL_CANT_TAKE_CONTROL = new PseudoCameraCmdResult("PSEUDO_CAMERA_ACK_FAIL_CANT_TAKE_CONTROL", 7, 7);
      PSEUDO_CAMERA_ACK_FAIL_CAMERA_ERROR = new PseudoCameraCmdResult("PSEUDO_CAMERA_ACK_FAIL_CAMERA_ERROR", 8, 8);
      PSEUDO_CAMERA_ACK_FAIL_TIMEOUT = new PseudoCameraCmdResult("PSEUDO_CAMERA_ACK_FAIL_TIMEOUT", 9, 9);
      PSEUDO_CAMERA_ACK_FAIL_FORBID = new PseudoCameraCmdResult("PSEUDO_CAMERA_ACK_FAIL_FORBID", 10, 10);
      PseudoCameraCmdResult localPseudoCameraCmdResult = new PseudoCameraCmdResult("OTHER", 11, 255);
      OTHER = localPseudoCameraCmdResult;
      $VALUES = new PseudoCameraCmdResult[] { PSEUDO_CAMERA_ACK_SUCCESS, PSEUDO_CAMERA_ACK_FAIL, PSEUDO_CAMERA_ACK_FAIL_ABORT, PSEUDO_CAMERA_ACK_FAIL_NOT_SUPPORTED, PSEUDO_CAMERA_ACK_FAIL_BUSY, PSEUDO_CAMERA_ACK_FAIL_INVALID_REQUEST, PSEUDO_CAMERA_ACK_FAIL_ON_GROUND, PSEUDO_CAMERA_ACK_FAIL_CANT_TAKE_CONTROL, PSEUDO_CAMERA_ACK_FAIL_CAMERA_ERROR, PSEUDO_CAMERA_ACK_FAIL_TIMEOUT, PSEUDO_CAMERA_ACK_FAIL_FORBID, localPseudoCameraCmdResult };
    }
    
    private PseudoCameraCmdResult(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static PseudoCameraCmdResult find(int paramInt)
    {
      PseudoCameraCmdResult localPseudoCameraCmdResult = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localPseudoCameraCmdResult;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public byte value()
    {
      return (byte)this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataEyeSetPseudoCameraControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */