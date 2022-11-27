package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public abstract class DataCameraTauParamer
  extends DataBase
  implements DJIDataSyncListener
{
  protected ParamCmd mParamCmd = ParamCmd.OTHER;
  protected byte[] mParams = null;
  protected boolean mbGet = false;
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DataCameraTauParamer setOpt(boolean paramBoolean)
  {
    this.mbGet = paramBoolean;
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
  
  public static enum ParamCmd
  {
    private int data;
    
    static
    {
      INTEREST_REGION = new ParamCmd("INTEREST_REGION", 1, 2);
      DIGITAL_INC = new ParamCmd("DIGITAL_INC", 2, 3);
      SCENE_CONTRAST = new ParamCmd("SCENE_CONTRAST", 3, 4);
      SCENE_OPTIMIZATE = new ParamCmd("SCENE_OPTIMIZATE", 4, 5);
      AGC = new ParamCmd("AGC", 5, 6);
      REGION_THERMOMETRIC = new ParamCmd("REGION_THERMOMETRIC", 6, 7);
      BRIGHTNESS = new ParamCmd("BRIGHTNESS", 7, 8);
      ISOTHERM_ENABLE = new ParamCmd("ISOTHERM_ENABLE", 8, 9);
      ISOTHERM_UNIT = new ParamCmd("ISOTHERM_UNIT", 9, 10);
      ISOTHERM_LOWER = new ParamCmd("ISOTHERM_LOWER", 10, 11);
      ISOTHERM_MIDDLE = new ParamCmd("ISOTHERM_MIDDLE", 11, 12);
      ISOTHERM_UPPER = new ParamCmd("ISOTHERM_UPPER", 12, 13);
      THERMOMETRIC_TYPE = new ParamCmd("THERMOMETRIC_TYPE", 13, 14);
      GAIN_MODE = new ParamCmd("GAIN_MODE", 14, 15);
      FFC_MODE = new ParamCmd("FFC_MODE", 15, 17);
      TRIGGER_FFC = new ParamCmd("TRIGGER_FFC", 16, 18);
      EXTER_PARAM_TYPE = new ParamCmd("EXTER_PARAM_TYPE", 17, 21);
      EXTER_PARAMS = new ParamCmd("EXTER_PARAMS", 18, 22);
      AREA_AXIS = new ParamCmd("AREA_AXIS", 19, 23);
      ParamCmd localParamCmd = new ParamCmd("OTHER", 20, 100);
      OTHER = localParamCmd;
      $VALUES = new ParamCmd[] { PICTURE_ROTATE, INTEREST_REGION, DIGITAL_INC, SCENE_CONTRAST, SCENE_OPTIMIZATE, AGC, REGION_THERMOMETRIC, BRIGHTNESS, ISOTHERM_ENABLE, ISOTHERM_UNIT, ISOTHERM_LOWER, ISOTHERM_MIDDLE, ISOTHERM_UPPER, THERMOMETRIC_TYPE, GAIN_MODE, FFC_MODE, TRIGGER_FFC, EXTER_PARAM_TYPE, EXTER_PARAMS, AREA_AXIS, localParamCmd };
    }
    
    private ParamCmd(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static ParamCmd find(int paramInt)
    {
      ParamCmd localParamCmd = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localParamCmd;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCameraTauParamer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */