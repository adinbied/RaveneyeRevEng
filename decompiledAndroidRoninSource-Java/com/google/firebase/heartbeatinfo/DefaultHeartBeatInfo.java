package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.Dependency;

public class DefaultHeartBeatInfo
  implements HeartBeatInfo
{
  private HeartBeatInfoStorage storage;
  
  private DefaultHeartBeatInfo(Context paramContext)
  {
    this.storage = HeartBeatInfoStorage.getInstance(paramContext);
  }
  
  DefaultHeartBeatInfo(HeartBeatInfoStorage paramHeartBeatInfoStorage)
  {
    this.storage = paramHeartBeatInfoStorage;
  }
  
  public static Component<HeartBeatInfo> component()
  {
    return Component.builder(HeartBeatInfo.class).add(Dependency.required(Context.class)).factory(DefaultHeartBeatInfo..Lambda.1.lambdaFactory$()).build();
  }
  
  public HeartBeatInfo.HeartBeat getHeartBeatCode(String paramString)
  {
    long l = System.currentTimeMillis();
    boolean bool1 = this.storage.shouldSendSdkHeartBeat(paramString, l);
    boolean bool2 = this.storage.shouldSendGlobalHeartBeat(l);
    if ((bool1) && (bool2)) {
      return HeartBeatInfo.HeartBeat.COMBINED;
    }
    if (bool2) {
      return HeartBeatInfo.HeartBeat.GLOBAL;
    }
    if (bool1) {
      return HeartBeatInfo.HeartBeat.SDK;
    }
    return HeartBeatInfo.HeartBeat.NONE;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\heartbeatinfo\DefaultHeartBeatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */