package com.huawei.hms.support.api.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.api.entity.game.GameGetPhoneInfoResp;
import com.huawei.hms.support.api.entity.game.GameIsShowBuoyResp;
import com.huawei.hms.support.api.entity.game.GameLoginInfo;
import com.huawei.hms.support.api.entity.game.GameLoginResp;
import com.huawei.hms.support.api.entity.game.GameNoticeResp;
import com.huawei.hms.support.api.entity.game.GamePlayerInfo;
import com.huawei.hms.support.api.entity.game.GameUserData;
import com.huawei.hms.support.api.entity.game.GetPlayerCertificationInfoResp;
import com.huawei.hms.support.api.entity.game.GetPlayerCertificationIntentResp;
import com.huawei.hms.support.api.entity.game.RegisterGameResp;
import com.huawei.hms.support.api.entity.game.internal.AddPlayerInfoResp;
import com.huawei.hms.support.api.game.c.a.d;
import com.huawei.hms.support.api.game.c.b;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

class a
  implements HuaweiGameApi
{
  private int a;
  private AtomicReference<GameLoginHandler> b = new AtomicReference();
  private String c;
  private WeakReference<Activity> d = null;
  private Context e = null;
  private HuaweiApiClient f = null;
  private String g;
  private String h;
  private long i = 0L;
  private long j = 0L;
  private int k = 0;
  private long l = 0L;
  private boolean m = false;
  private boolean n = false;
  private long o = -1L;
  private int p = 0;
  private int q = 0;
  private int r = 20;
  private String s = "";
  private d t = new c(this);
  
  private GameUserData a(GameLoginInfo paramGameLoginInfo)
  {
    return null;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(int arg1, GameUserData arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    if (paramActivity != null)
    {
      if (paramActivity.isFinishing()) {
        return;
      }
      Intent localIntent = BridgeActivity.getIntentStartBridgeActivity(paramActivity, com.huawei.hms.support.api.game.c.c.class.getName());
      localIntent.putExtra("intent.extra.intent", paramIntent);
      localIntent.putExtra("intent.extra.protocol.type", paramInt);
      paramActivity.startActivity(localIntent);
    }
  }
  
  /* Error */
  private void a(Context arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(HuaweiApiClient arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(GameIsShowBuoyResp arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(GameLoginResp arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(GameUserData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean a(GameInfo paramGameInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    return false;
  }
  
  private PendingResult<GameLoginResult> b()
  {
    return null;
  }
  
  private static void b(Activity paramActivity, Intent paramIntent)
  {
    if (paramActivity != null)
    {
      if (paramActivity.isFinishing()) {
        return;
      }
      Intent localIntent = BridgeActivity.getIntentStartBridgeActivity(paramActivity, com.huawei.hms.support.api.game.c.a.class.getName());
      localIntent.putExtra("intent.extra.intent", paramIntent);
      paramActivity.startActivity(localIntent);
    }
  }
  
  /* Error */
  private void b(GameLoginResp arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean b(GameInfo paramGameInfo, JSONObject paramJSONObject)
    throws JSONException
  {
    return false;
  }
  
  private PendingResult<GameLoginResult> c()
  {
    return null;
  }
  
  private GameUserData c(GameLoginResp paramGameLoginResp)
  {
    return null;
  }
  
  private static void c(Activity paramActivity, Intent paramIntent)
  {
    Intent localIntent = BridgeActivity.getIntentStartBridgeActivity(paramActivity, b.class.getName());
    localIntent.putExtra("intent.extra.intent", paramIntent);
    paramActivity.startActivity(localIntent);
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void d(GameLoginResp arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void e(GameLoginResp arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void f(GameLoginResp arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean f()
  {
    return false;
  }
  
  public PendingResult<PlayerCertificationInfo> getPlayerCertificationInfo(HuaweiApiClient paramHuaweiApiClient)
  {
    return null;
  }
  
  public PendingResult<CertificateIntentResult> getPlayerCertificationIntent(HuaweiApiClient paramHuaweiApiClient)
  {
    return null;
  }
  
  public PendingResult<TemperatureResult> getTemperature(HuaweiApiClient paramHuaweiApiClient)
  {
    return null;
  }
  
  public void hideFloatWindow(HuaweiApiClient paramHuaweiApiClient, Activity paramActivity)
  {
    com.huawei.hms.support.log.a.b("HuaweiGameApiImpl", "Enter hideFloatWindow");
    com.huawei.hms.support.api.game.a.a.a().d();
  }
  
  public PendingResult<GameLoginResult> login(HuaweiApiClient paramHuaweiApiClient, Activity paramActivity, int paramInt, GameLoginHandler paramGameLoginHandler)
  {
    return null;
  }
  
  public PendingResult<HardwareCapabilityResult> registerHardwareCapability(HuaweiApiClient paramHuaweiApiClient)
  {
    return null;
  }
  
  public PendingResult<SavePlayerInfoResult> savePlayerInfo(HuaweiApiClient paramHuaweiApiClient, GamePlayerInfo paramGamePlayerInfo)
  {
    return null;
  }
  
  public PendingResult<ShowFloatWindowResult> showFloatWindow(HuaweiApiClient paramHuaweiApiClient, Activity paramActivity)
  {
    return null;
  }
  
  public long updateGameInfo(HuaweiApiClient paramHuaweiApiClient, GameInfo paramGameInfo)
  {
    return 211324419L;
  }
  
  private static class a
    implements ResultCallback<GameLoginResult>
  {
    public void a(GameLoginResult paramGameLoginResult) {}
  }
  
  private class b
    extends com.huawei.hms.support.api.c<GameLoginResult, GameLoginResp>
  {
    private b(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    protected GameLoginResult a(int paramInt)
    {
      return null;
    }
    
    public GameLoginResult a(GameLoginResp paramGameLoginResp)
    {
      return null;
    }
  }
  
  private class c
    extends com.huawei.hms.support.api.c<GameLoginResult, GameLoginResp>
  {
    private c(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    protected GameLoginResult a(int paramInt)
    {
      return null;
    }
    
    public GameLoginResult a(GameLoginResp paramGameLoginResp)
    {
      return null;
    }
  }
  
  private class d
    extends com.huawei.hms.support.api.c<GameNoticeResult, GameNoticeResp>
  {
    private d(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public GameNoticeResult a(GameNoticeResp paramGameNoticeResp)
    {
      return null;
    }
  }
  
  private static class e
    implements ResultCallback<GameNoticeResult>
  {
    public void a(GameNoticeResult paramGameNoticeResult) {}
  }
  
  private class f
    implements ResultCallback<ResolveResult<JosGetNoticeResp>>
  {
    private f() {}
    
    /* Error */
    public void a(ResolveResult<JosGetNoticeResp> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static class g
    extends com.huawei.hms.support.api.c<PlayerCertificationInfo, GetPlayerCertificationInfoResp>
  {
    private g(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public PlayerCertificationInfo a(GetPlayerCertificationInfoResp paramGetPlayerCertificationInfoResp)
    {
      return null;
    }
  }
  
  private static class h
    extends com.huawei.hms.support.api.c<CertificateIntentResult, GetPlayerCertificationIntentResp>
  {
    private h(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public CertificateIntentResult a(GetPlayerCertificationIntentResp paramGetPlayerCertificationIntentResp)
    {
      return null;
    }
  }
  
  private static class i
    extends com.huawei.hms.support.api.a<TemperatureResult>
  {
    public i(int paramInt)
    {
      super();
    }
  }
  
  private static class j
    extends com.huawei.hms.support.api.c<TemperatureResult, GameGetPhoneInfoResp>
  {
    private j(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public TemperatureResult a(GameGetPhoneInfoResp paramGameGetPhoneInfoResp)
    {
      return null;
    }
  }
  
  private class k
    extends com.huawei.hms.support.api.c<HardwareCapabilityResult, RegisterGameResp>
  {
    private k(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public HardwareCapabilityResult a(RegisterGameResp paramRegisterGameResp)
    {
      return null;
    }
  }
  
  private class l
    extends com.huawei.hms.support.api.c<ShowFloatWindowResult, GameIsShowBuoyResp>
  {
    private l(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public ShowFloatWindowResult a(GameIsShowBuoyResp paramGameIsShowBuoyResp)
    {
      return null;
    }
  }
  
  private static class m
    extends com.huawei.hms.support.api.a<GameLoginResult>
  {
    public m(int paramInt)
    {
      super();
    }
  }
  
  private static class n
    extends com.huawei.hms.support.api.a<HardwareCapabilityResult>
  {
    public n(int paramInt)
    {
      super();
    }
  }
  
  private static class o
    extends com.huawei.hms.support.api.a<SavePlayerInfoResult>
  {
    public o(int paramInt)
    {
      super();
    }
  }
  
  private static class p
    extends com.huawei.hms.support.api.c<SavePlayerInfoResult, AddPlayerInfoResp>
  {
    private p(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public SavePlayerInfoResult a(AddPlayerInfoResp paramAddPlayerInfoResp)
    {
      return null;
    }
  }
  
  private static class q
    extends com.huawei.hms.support.api.a<ShowFloatWindowResult>
  {
    public q(int paramInt)
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\game\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */