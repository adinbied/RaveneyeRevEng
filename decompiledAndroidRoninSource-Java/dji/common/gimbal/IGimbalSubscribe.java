package dji.common.gimbal;

import android.util.Pair;
import dji.midware.component.DJIComponentManager.GimbalComponentType;
import java.util.Set;

public abstract interface IGimbalSubscribe
{
  public abstract void callGetValue(String paramString);
  
  public abstract boolean contains(String paramString);
  
  public abstract void destroy();
  
  public abstract Pair<Integer, Integer> get(String paramString);
  
  public abstract DJIComponentManager.GimbalComponentType getComponent();
  
  public abstract Set<String> getSubscribeKeys();
  
  public abstract void put(String paramString, int paramInt1, int paramInt2);
  
  public abstract void registerPushValue(String paramString);
  
  public abstract void unregisterPushValue(String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\gimbal\IGimbalSubscribe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */