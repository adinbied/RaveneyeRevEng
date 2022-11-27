package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;

class CrashlyticsAnalyticsListener
  implements AnalyticsConnector.AnalyticsConnectorListener
{
  static final String CRASHLYTICS_ORIGIN = "clx";
  static final String EVENT_NAME_KEY = "name";
  static final String EVENT_ORIGIN_KEY = "_o";
  static final String EVENT_PARAMS_KEY = "params";
  private AnalyticsEventReceiver breadcrumbEventReceiver;
  private AnalyticsEventReceiver crashlyticsOriginEventReceiver;
  
  private static void notifyEventReceiver(AnalyticsEventReceiver paramAnalyticsEventReceiver, String paramString, Bundle paramBundle)
  {
    if (paramAnalyticsEventReceiver == null) {
      return;
    }
    paramAnalyticsEventReceiver.onEvent(paramString, paramBundle);
  }
  
  private void notifyEventReceivers(String paramString, Bundle paramBundle)
  {
    AnalyticsEventReceiver localAnalyticsEventReceiver;
    if ("clx".equals(paramBundle.getString("_o"))) {
      localAnalyticsEventReceiver = this.crashlyticsOriginEventReceiver;
    } else {
      localAnalyticsEventReceiver = this.breadcrumbEventReceiver;
    }
    notifyEventReceiver(localAnalyticsEventReceiver, paramString, paramBundle);
  }
  
  public void onMessageTriggered(int paramInt, Bundle paramBundle)
  {
    Object localObject1 = Logger.getLogger();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Received Analytics message: ");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(paramBundle);
    ((Logger)localObject1).d(((StringBuilder)localObject2).toString());
    if (paramBundle == null) {
      return;
    }
    localObject2 = paramBundle.getString("name");
    if (localObject2 != null)
    {
      localObject1 = paramBundle.getBundle("params");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = new Bundle();
      }
      notifyEventReceivers((String)localObject2, paramBundle);
    }
  }
  
  public void setBreadcrumbEventReceiver(AnalyticsEventReceiver paramAnalyticsEventReceiver)
  {
    this.breadcrumbEventReceiver = paramAnalyticsEventReceiver;
  }
  
  public void setCrashlyticsOriginEventReceiver(AnalyticsEventReceiver paramAnalyticsEventReceiver)
  {
    this.crashlyticsOriginEventReceiver = paramAnalyticsEventReceiver;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\CrashlyticsAnalyticsListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */