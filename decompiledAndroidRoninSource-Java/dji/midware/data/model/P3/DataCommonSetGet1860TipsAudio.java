package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import dji.midware.interfaces.DJIDataSyncListener;

public class DataCommonSetGet1860TipsAudio
  extends DataBase
  implements DJIDataSyncListener
{
  private static DataCommonSetGet1860TipsAudio instance;
  private AudioSubCmd mAudioSubCmd = AudioSubCmd.OTHER;
  
  public static DataCommonSetGet1860TipsAudio getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataCommonSetGet1860TipsAudio();
      }
      DataCommonSetGet1860TipsAudio localDataCommonSetGet1860TipsAudio = instance;
      return localDataCommonSetGet1860TipsAudio;
    }
    finally {}
  }
  
  /* Error */
  protected void doPack()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isTipsAudioOpened()
  {
    return false;
  }
  
  public DataCommonSetGet1860TipsAudio setAudioSubCmd(AudioSubCmd paramAudioSubCmd)
  {
    this.mAudioSubCmd = paramAudioSubCmd;
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
  
  public static enum AudioSubCmd
  {
    private int mValue;
    
    static
    {
      AudioSubCmd localAudioSubCmd = new AudioSubCmd("OTHER", 3, -1);
      OTHER = localAudioSubCmd;
      $VALUES = new AudioSubCmd[] { DISABLE_SOUND, ENABLE_SOUND, GET_SOUND, localAudioSubCmd };
    }
    
    private AudioSubCmd(int paramInt)
    {
      this.mValue = paramInt;
    }
    
    public static AudioSubCmd find(int paramInt)
    {
      AudioSubCmd localAudioSubCmd = OTHER;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localAudioSubCmd;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.mValue == paramInt;
    }
    
    public int value()
    {
      return this.mValue;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataCommonSetGet1860TipsAudio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */