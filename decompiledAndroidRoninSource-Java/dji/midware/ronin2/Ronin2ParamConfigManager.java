package dji.midware.ronin2;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.dji.frame.util.V_FileUtil;
import com.dji.frame.util.V_JsonUtil;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import dji.midware.R.string;
import dji.midware.data.config.P3.Ccode;
import dji.midware.data.manager.P3.DJIGimbalParamInfoManager;
import dji.midware.data.params.P3.ParamInfo;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.BackgroundLooper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ronin2ParamConfigManager
{
  private static final String CONFIG_FILE_NAME = "config_param.json";
  private static final String CONFIG_PATH = "/config/";
  private static final int DELAY_WRITE_JSON = 3000;
  private static final int MSG_WRITE_JSON = 1;
  private static Ronin2ParamConfigManager instance;
  private Context mContext;
  private List<CustomConfiguration> mCustomConfigurations;
  private Handler mHandler;
  
  private Ronin2ParamConfigManager(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new Handler(BackgroundLooper.getLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        return false;
      }
    });
    File localFile = this.mContext.getExternalFilesDir("/config/");
    if (localFile == null) {
      return;
    }
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = this.mContext.getExternalFilesDir("/config/config_param.json");
    if (localFile == null) {
      return;
    }
    if (localFile.exists())
    {
      String str = V_FileUtil.fileGetContent(localFile);
      try
      {
        this.mCustomConfigurations = V_JsonUtil.getList(str, new TypeToken() {});
      }
      catch (JsonSyntaxException localJsonSyntaxException)
      {
        localJsonSyntaxException.printStackTrace();
      }
      if (this.mCustomConfigurations == null) {
        localFile.delete();
      }
    }
    if ((!localFile.exists()) || (this.mCustomConfigurations == null))
    {
      ArrayList localArrayList = new ArrayList();
      this.mCustomConfigurations = localArrayList;
      localArrayList.add(new CustomConfiguration(paramContext.getResources().getString(R.string.ronin2_config_default), ConfigurableParam.defaultUserConfig(), false));
      this.mCustomConfigurations.add(new CustomConfiguration(paramContext.getResources().getString(R.string.ronin2_config_user_1), ConfigurableParam.defaultUserConfig(), false));
      this.mCustomConfigurations.add(new CustomConfiguration(paramContext.getResources().getString(R.string.ronin2_config_user_2), ConfigurableParam.defaultUserConfig(), false));
      this.mCustomConfigurations.add(new CustomConfiguration(paramContext.getResources().getString(R.string.ronin2_config_user_3), ConfigurableParam.defaultUserConfig(), false));
      this.mCustomConfigurations.add(new CustomConfiguration(paramContext.getResources().getString(R.string.ronin2_config_user_4), ConfigurableParam.defaultUserConfig(), false));
      V_FileUtil.fileWrite(localFile, V_JsonUtil.toJson(this.mCustomConfigurations));
    }
  }
  
  public static Ronin2ParamConfigManager getInstance()
  {
    try
    {
      Ronin2ParamConfigManager localRonin2ParamConfigManager = instance;
      return localRonin2ParamConfigManager;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void init(Context paramContext)
  {
    instance = new Ronin2ParamConfigManager(paramContext);
  }
  
  /* Error */
  private void writeJsonFile()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int findConfigMatched(ConfigurableParam paramConfigurableParam)
  {
    return 0;
  }
  
  public List<CustomConfiguration> getCustomConfigurations()
  {
    return this.mCustomConfigurations;
  }
  
  /* Error */
  public void onConfigurationAdded(CustomConfiguration arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onConfigurationChanged(CustomConfiguration arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onConfigurationDeleted(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onConfigurationNameEdited(String arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class ConfigurableParam
  {
    public static final int DEFAULT_CONFIG_COUNT = 5;
    public int mControlPan;
    public int mControlRoll;
    public int mControlTilt;
    public int mFilterPan;
    public int mFilterRoll;
    public int mFilterTilt;
    public int mStiffnessPan;
    public int mStiffnessRoll;
    public int mStiffnessTilt;
    public int mStrengthPan;
    public int mStrengthRoll;
    public int mStrengthTilt;
    
    public static ConfigurableParam defaultUserConfig()
    {
      ConfigurableParam localConfigurableParam = new ConfigurableParam();
      localConfigurableParam.mStiffnessPan = 6;
      localConfigurableParam.mStiffnessTilt = 5;
      localConfigurableParam.mStiffnessRoll = 6;
      localConfigurableParam.mStrengthPan = 10;
      localConfigurableParam.mStrengthTilt = 10;
      localConfigurableParam.mStrengthRoll = 10;
      localConfigurableParam.mControlPan = 26;
      localConfigurableParam.mControlTilt = 28;
      localConfigurableParam.mControlRoll = 28;
      return localConfigurableParam;
    }
    
    public static ConfigurableParam generateCurConfigParam()
    {
      ConfigurableParam localConfigurableParam = new ConfigurableParam();
      localConfigurableParam.mStiffnessPan = DJIGimbalParamInfoManager.read(Ronin2GimbalParamsManager.BaseCommand.STIFFNESS_YAW.getKeyNameStr()).value.intValue();
      localConfigurableParam.mStiffnessTilt = DJIGimbalParamInfoManager.read(Ronin2GimbalParamsManager.BaseCommand.STIFFNESS_PITCH.getKeyNameStr()).value.intValue();
      localConfigurableParam.mStiffnessRoll = DJIGimbalParamInfoManager.read(Ronin2GimbalParamsManager.BaseCommand.STIFFNESS_ROLL.getKeyNameStr()).value.intValue();
      localConfigurableParam.mStrengthPan = DJIGimbalParamInfoManager.read(Ronin2GimbalParamsManager.BaseCommand.STRENGTH_YAW.getKeyNameStr()).value.intValue();
      localConfigurableParam.mStrengthTilt = DJIGimbalParamInfoManager.read(Ronin2GimbalParamsManager.BaseCommand.STRENGTH_PITCH.getKeyNameStr()).value.intValue();
      localConfigurableParam.mStrengthRoll = DJIGimbalParamInfoManager.read(Ronin2GimbalParamsManager.BaseCommand.STRENGTH_ROLL.getKeyNameStr()).value.intValue();
      localConfigurableParam.mFilterPan = DJIGimbalParamInfoManager.read(Ronin2GimbalParamsManager.BaseCommand.FILTERING_YAW.getKeyNameStr()).value.intValue();
      localConfigurableParam.mFilterTilt = DJIGimbalParamInfoManager.read(Ronin2GimbalParamsManager.BaseCommand.FILTERING_PITCH.getKeyNameStr()).value.intValue();
      localConfigurableParam.mFilterRoll = DJIGimbalParamInfoManager.read(Ronin2GimbalParamsManager.BaseCommand.FILTERING_ROLL.getKeyNameStr()).value.intValue();
      localConfigurableParam.mControlPan = DJIGimbalParamInfoManager.read(Ronin2GimbalParamsManager.BaseCommand.PRECONTROL_YAW.getKeyNameStr()).value.intValue();
      localConfigurableParam.mControlTilt = DJIGimbalParamInfoManager.read(Ronin2GimbalParamsManager.BaseCommand.PRECONTROL_PITCH.getKeyNameStr()).value.intValue();
      localConfigurableParam.mControlRoll = DJIGimbalParamInfoManager.read(Ronin2GimbalParamsManager.BaseCommand.PRECONTROL_ROLL.getKeyNameStr()).value.intValue();
      return localConfigurableParam;
    }
    
    public boolean equals(Object paramObject)
    {
      return false;
    }
    
    public int hashCode()
    {
      return 0;
    }
    
    /* Error */
    public void setCurConfigToRemote()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static class CustomConfiguration
  {
    public boolean isDefaultConfig = true;
    public String mConfigName;
    public Ronin2ParamConfigManager.ConfigurableParam mConfigurableParam;
    
    public CustomConfiguration(String paramString, Ronin2ParamConfigManager.ConfigurableParam paramConfigurableParam)
    {
      this.mConfigName = paramString;
      this.mConfigurableParam = paramConfigurableParam;
    }
    
    public CustomConfiguration(String paramString, Ronin2ParamConfigManager.ConfigurableParam paramConfigurableParam, boolean paramBoolean)
    {
      this.mConfigName = paramString;
      this.mConfigurableParam = paramConfigurableParam;
      this.isDefaultConfig = paramBoolean;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\ronin2\Ronin2ParamConfigManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */