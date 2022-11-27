package com.huawei.android.hms.agent;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;
import com.huawei.android.hms.agent.common.ActivityMgr;
import com.huawei.android.hms.agent.common.ApiClientMgr;
import com.huawei.android.hms.agent.common.CheckUpdateApi;
import com.huawei.android.hms.agent.common.HMSAgentLog;
import com.huawei.android.hms.agent.common.IClientConnectCallback;
import com.huawei.android.hms.agent.common.INoProguard;
import com.huawei.android.hms.agent.common.handler.CheckUpdateHandler;
import com.huawei.android.hms.agent.common.handler.ConnectHandler;
import com.huawei.android.hms.agent.push.DeleteTokenApi;
import com.huawei.android.hms.agent.push.EnableReceiveNormalMsgApi;
import com.huawei.android.hms.agent.push.EnableReceiveNotifyMsgApi;
import com.huawei.android.hms.agent.push.GetPushStateApi;
import com.huawei.android.hms.agent.push.GetTokenApi;
import com.huawei.android.hms.agent.push.QueryAgreementApi;
import com.huawei.android.hms.agent.push.handler.DeleteTokenHandler;
import com.huawei.android.hms.agent.push.handler.EnableReceiveNormalMsgHandler;
import com.huawei.android.hms.agent.push.handler.EnableReceiveNotifyMsgHandler;
import com.huawei.android.hms.agent.push.handler.GetPushStateHandler;
import com.huawei.android.hms.agent.push.handler.GetTokenHandler;
import com.huawei.android.hms.agent.push.handler.QueryAgreementHandler;

public final class HMSAgent
  implements INoProguard
{
  public static final String CURVER = "020603300";
  private static final String VER_020503001 = "020503001";
  private static final String VER_020600001 = "020600001";
  private static final String VER_020600200 = "020600200";
  private static final String VER_020601002 = "020601002";
  private static final String VER_020601302 = "020601302";
  private static final String VER_020603300 = "020603300";
  
  private static boolean checkSDKVersion(Context paramContext)
  {
    long l = Long.parseLong("020603300") / 1000L;
    if (20603L != l)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("error: HMSAgent major version code (");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(") does not match HMSSDK major version code (");
      ((StringBuilder)localObject).append(20603L);
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      HMSAgentLog.e((String)localObject);
      Toast.makeText(paramContext, (CharSequence)localObject, 1).show();
      return false;
    }
    return true;
  }
  
  public static void checkUpdate(Activity paramActivity, CheckUpdateHandler paramCheckUpdateHandler)
  {
    new CheckUpdateApi().checkUpdate(paramActivity, paramCheckUpdateHandler);
  }
  
  public static void connect(Activity paramActivity, ConnectHandler paramConnectHandler)
  {
    HMSAgentLog.i("start connect");
    ApiClientMgr.INST.connect(new IClientConnectCallback()
    {
      /* Error */
      public void onConnect(int arg1, com.huawei.hms.api.HuaweiApiClient arg2)
      {
        // Byte code:
        //   0: return
        //   1: astore_2
        //   2: goto -2 -> 0
      }
    }, true);
  }
  
  public static void destroy()
  {
    HMSAgentLog.i("destroy HMSAgent");
    ActivityMgr.INST.release();
    ApiClientMgr.INST.release();
  }
  
  public static boolean init(Activity paramActivity)
  {
    return init(null, paramActivity);
  }
  
  public static boolean init(Application paramApplication)
  {
    return init(paramApplication, null);
  }
  
  public static boolean init(Application paramApplication, Activity paramActivity)
  {
    if ((paramApplication == null) && (paramActivity == null))
    {
      HMSAgentLog.e("the param of method HMSAgent.init can not be null !!!");
      return false;
    }
    Application localApplication = paramApplication;
    if (paramApplication == null) {
      localApplication = paramActivity.getApplication();
    }
    if (localApplication == null)
    {
      HMSAgentLog.e("the param of method HMSAgent.init app can not be null !!!");
      return false;
    }
    paramApplication = paramActivity;
    if (paramActivity != null)
    {
      paramApplication = paramActivity;
      if (paramActivity.isFinishing()) {
        paramApplication = null;
      }
    }
    if (!checkSDKVersion(localApplication)) {
      return false;
    }
    HMSAgentLog.i("init HMSAgent 020603300 with hmssdkver 20603301");
    ActivityMgr.INST.init(localApplication, paramApplication);
    ApiClientMgr.INST.init(localApplication);
    return true;
  }
  
  public static final class AgentResultCode
  {
    public static final int APICLIENT_TIMEOUT = -1007;
    public static final int CALL_EXCEPTION = -1008;
    public static final int EMPTY_PARAM = -1009;
    public static final int HMSAGENT_NO_INIT = -1000;
    public static final int HMSAGENT_SUCCESS = 0;
    public static final int NO_ACTIVITY_FOR_USE = -1001;
    public static final int ON_ACTIVITY_RESULT_ERROR = -1005;
    public static final int REQUEST_REPEATED = -1006;
    public static final int RESULT_IS_NULL = -1002;
    public static final int START_ACTIVITY_ERROR = -1004;
    public static final int STATUS_IS_NULL = -1003;
  }
  
  public static final class Push
  {
    public static void deleteToken(String paramString, DeleteTokenHandler paramDeleteTokenHandler)
    {
      new DeleteTokenApi().deleteToken(paramString, paramDeleteTokenHandler);
    }
    
    public static void enableReceiveNormalMsg(boolean paramBoolean, EnableReceiveNormalMsgHandler paramEnableReceiveNormalMsgHandler)
    {
      new EnableReceiveNormalMsgApi().enableReceiveNormalMsg(paramBoolean, paramEnableReceiveNormalMsgHandler);
    }
    
    public static void enableReceiveNotifyMsg(boolean paramBoolean, EnableReceiveNotifyMsgHandler paramEnableReceiveNotifyMsgHandler)
    {
      new EnableReceiveNotifyMsgApi().enableReceiveNotifyMsg(paramBoolean, paramEnableReceiveNotifyMsgHandler);
    }
    
    public static void getPushState(GetPushStateHandler paramGetPushStateHandler)
    {
      new GetPushStateApi().getPushState(paramGetPushStateHandler);
    }
    
    public static void getToken(GetTokenHandler paramGetTokenHandler)
    {
      new GetTokenApi().getToken(paramGetTokenHandler);
    }
    
    public static void queryAgreement(QueryAgreementHandler paramQueryAgreementHandler)
    {
      new QueryAgreementApi().queryAgreement(paramQueryAgreementHandler);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\HMSAgent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */