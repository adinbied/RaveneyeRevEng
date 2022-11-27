package com.google.firebase.crashlytics.internal.unity;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;

public class ResourceUnityVersionProvider
  implements UnityVersionProvider
{
  private final Context context;
  private boolean hasRead = false;
  private String unityVersion;
  
  public ResourceUnityVersionProvider(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public String getUnityVersion()
  {
    if (!this.hasRead)
    {
      this.unityVersion = CommonUtils.resolveUnityEditorVersion(this.context);
      this.hasRead = true;
    }
    String str = this.unityVersion;
    if (str != null) {
      return str;
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\interna\\unity\ResourceUnityVersionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */