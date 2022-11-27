package dji.pilot.usercenter;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.dji.api.AccountCenterHttpApi;
import com.dji.frame.util.V_AppUtils;
import com.dji.ronin.publics.util.HmacEncryptUtil;
import dji.log.RoninLog;
import dji.pilot.usercenter.mode.AccountCenterSmsType;
import dji.thirdparty.afinal.FinalHttp;
import dji.thirdparty.afinal.http.AjaxCallBack;
import dji.thirdparty.afinal.http.AjaxParams;
import java.util.Locale;
import java.util.UUID;

public class MemberProtocolBox
  implements IMemberProtocol
{
  private static final boolean DEBUG = true;
  
  public static void accountCenterCheckPw(String paramString, IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterPasswordWeakCheck();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("password", paramString);
    log("accountCenterCheckPw start param=%s", new Object[] { localAjaxParams.toString() });
    getFinalHttp().post(str, localAjaxParams, new AjaxCallBack()
    {
      /* Error */
      public void onFailure(Throwable arg1, int arg2, String arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static void accountCenterCheckSms(String paramString1, String paramString2, String paramString3, AccountCenterSmsType paramAccountCenterSmsType, IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterPhoneCheckCode();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("areaCode", paramString1);
    localAjaxParams.put("phone", paramString2);
    paramString1 = new StringBuilder();
    paramString1.append(paramAccountCenterSmsType.id);
    paramString1.append("");
    localAjaxParams.put("smsType", paramString1.toString());
    localAjaxParams.put("smsCode", paramString3);
    log("accountCenterCheckSms start param=%s", new Object[] { localAjaxParams.toString() });
    getFinalHttp().post(str, localAjaxParams, new AjaxCallBack()
    {
      /* Error */
      public void onFailure(Throwable arg1, int arg2, String arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static void accountCenterCheckToken(String paramString, IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterCheckToken();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("token", paramString);
    log("accountCenterCheckToken start param=%s", new Object[] { localAjaxParams.toString() });
    getFinalHttp().post(str, localAjaxParams, new AjaxCallBack()
    {
      /* Error */
      public void onFailure(Throwable arg1, int arg2, String arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static void accountCenterDeletePhoneTest(String paramString1, String paramString2, IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterDeletePhone();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("areaCode", paramString1);
    localAjaxParams.put("phone", paramString2);
    log("accountCenterDeletePhoneTest start param=%s", new Object[] { localAjaxParams.toString() });
    getFinalHttp().post(str, localAjaxParams, new AjaxCallBack()
    {
      /* Error */
      public void onFailure(Throwable arg1, int arg2, String arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static void accountCenterEmailRegister(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, final IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterEmailRegister();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("email", paramString1);
    localAjaxParams.put("password", paramString2);
    if (!TextUtils.isEmpty(paramString3)) {
      localAjaxParams.put("confirmPassword", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localAjaxParams.put("verificationCode", paramString4);
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localAjaxParams.put("srandom", paramString5);
    }
    localAjaxParams.put("subscription", Boolean.toString(paramBoolean));
    log("accountCenterEmailRegister start param=%s", new Object[] { localAjaxParams.toString() });
    getFinalHttp().post(str, localAjaxParams, new AjaxCallBack()
    {
      /* Error */
      public void onFailure(Throwable arg1, int arg2, String arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static void accountCenterLoginByEmail(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, final IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterEmailLogin();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("email", paramString1);
    localAjaxParams.put("password", paramString2);
    localAjaxParams.put("verificationCode", paramString3);
    localAjaxParams.put("srandom", paramString4);
    log("accountCenterLoginByEmail start param=%s", new Object[] { localAjaxParams.toString() });
    getFinalHttp().post(str, localAjaxParams, new AjaxCallBack()
    {
      /* Error */
      public void onFailure(Throwable arg1, int arg2, String arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static void accountCenterLoginByPhone(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, final IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterPhoneLogin();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("areaCode", paramString1);
    localAjaxParams.put("phone", paramString2);
    localAjaxParams.put("password", paramString3);
    localAjaxParams.put("verificationCode", paramString4);
    localAjaxParams.put("srandom", paramString5);
    log("accountCenterLoginByPhone start param=%s", new Object[] { localAjaxParams.toString() });
    getFinalHttp().post(str, localAjaxParams, new AjaxCallBack()
    {
      /* Error */
      public void onFailure(Throwable arg1, int arg2, String arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static void accountCenterLogout(String paramString1, String paramString2, IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterUserLogout();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("user_id", paramString2);
    localAjaxParams.put("token", paramString1);
    getFinalHttp().post(str, localAjaxParams, new AjaxCallBack()
    {
      public void onFailure(Throwable paramAnonymousThrowable, int paramAnonymousInt, String paramAnonymousString)
      {
        this.val$callback.onFail(0, paramAnonymousInt, 0, paramAnonymousString);
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static void accountCenterPhoneRegister(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterPhoneRegister();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("areaCode", paramString1);
    localAjaxParams.put("phone", paramString2);
    localAjaxParams.put("password", paramString3);
    localAjaxParams.put("confirmPassword", paramString4);
    localAjaxParams.put("smsCode", paramString5);
    log("accountCenterEmailRegister start param=%s", new Object[] { localAjaxParams.toString() });
    getFinalHttp().post(str, localAjaxParams, new AjaxCallBack()
    {
      /* Error */
      public void onFailure(Throwable arg1, int arg2, String arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static void accountCenterPhoneReset(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterPhoneReset();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("areaCode", paramString1);
    localAjaxParams.put("phone", paramString2);
    localAjaxParams.put("password", paramString3);
    localAjaxParams.put("confirmPassword", paramString4);
    localAjaxParams.put("smsCode", paramString5);
    log("accountCenterPhoneRegister start param=%s", new Object[] { localAjaxParams.toString() });
    getFinalHttp().post(str, localAjaxParams, new AjaxCallBack()
    {
      /* Error */
      public void onFailure(Throwable arg1, int arg2, String arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static void accountCenterSendSms(String paramString1, String paramString2, AccountCenterSmsType paramAccountCenterSmsType, IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterPhoneSendCode();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("areaCode", paramString1);
    localAjaxParams.put("phone", paramString2);
    paramString1 = new StringBuilder();
    paramString1.append(paramAccountCenterSmsType.id);
    paramString1.append("");
    localAjaxParams.put("smsType", paramString1.toString());
    localAjaxParams.put("lang", Locale.getDefault().getCountry());
    log("accountCenterSendSms start param=%s", new Object[] { localAjaxParams.toString() });
    getFinalHttp().post(str, localAjaxParams, new AjaxCallBack()
    {
      /* Error */
      public void onFailure(Throwable arg1, int arg2, String arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static void checkEmailValid(Context paramContext, String paramString1, String paramString2, String paramString3, IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterEmailCheck();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("email", paramString1);
    localAjaxParams.put("_rucaptcha", paramString2);
    localAjaxParams.put("key", paramString3);
    V_AppUtils.getFinalHttp(paramContext).post(str, localAjaxParams, new AjaxCallBack()
    {
      /* Error */
      public void onFailure(Throwable arg1, int arg2, String arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  @Deprecated
  public static void forgotPassword(Context paramContext, String paramString, IProtocol.OnDataResultListener paramOnDataResultListener)
  {
    String str = AccountCenterHttpApi.getAccountCenterForgetPassword();
    AjaxParams localAjaxParams = new AjaxParams();
    localAjaxParams.put("email", paramString);
    V_AppUtils.getFinalHttp(paramContext).post(str, localAjaxParams, new AjaxCallBack()
    {
      /* Error */
      public void onFailure(Throwable arg1, int arg2, String arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public void onLoading(long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public void onStart(boolean paramAnonymousBoolean) {}
      
      /* Error */
      public void onSuccess(String arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    });
  }
  
  public static String getAccountCenterKey()
  {
    return AccountCenterHttpApi.getAccountCenterKey();
  }
  
  private static FinalHttp getFinalHttp()
  {
    FinalHttp localFinalHttp = new FinalHttp();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("android-");
    ((StringBuilder)localObject1).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject1).append("-");
    ((StringBuilder)localObject1).append("1.4.10");
    localObject1 = ((StringBuilder)localObject1).toString();
    localFinalHttp.addHeader("ClientName-Mc", (String)localObject1);
    log("header -> %s: %s", new Object[] { "ClientName-Mc", localObject1 });
    String str1 = UUID.randomUUID().toString();
    localFinalHttp.addHeader("DeviceId-Mc", str1);
    log("header -> %s: %s", new Object[] { "DeviceId-Mc", str1 });
    localFinalHttp.addHeader("AppId-Mc", "djironin");
    log("header -> %s: %s", new Object[] { "AppId-Mc", "djironin" });
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    localFinalHttp.addHeader("Timestamp-Mc", (String)localObject2);
    log("header -> %s: %s", new Object[] { "Timestamp-Mc", localObject2 });
    String str2 = UUID.randomUUID().toString();
    localFinalHttp.addHeader("InvokeId-Mc", str2);
    log("header -> %s: %s", new Object[] { "InvokeId-Mc", str2 });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppId-Mc");
    localStringBuilder.append("djironin");
    localStringBuilder.append("ClientName-Mc");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append("DeviceId-Mc");
    localStringBuilder.append(str1);
    localStringBuilder.append("InvokeId-Mc");
    localStringBuilder.append(str2);
    localStringBuilder.append("Timestamp-Mc");
    localStringBuilder.append((String)localObject2);
    localObject1 = HmacEncryptUtil.HmacSHA1EncryptBase64(localStringBuilder.toString(), getAccountCenterKey());
    localFinalHttp.addHeader("Sign-Mc", (String)localObject1);
    log("header -> %s: %s", new Object[] { "Sign-Mc", localObject1 });
    return localFinalHttp;
  }
  
  public static void log(String paramString, Object... paramVarArgs)
  {
    RoninLog.logWriteE("AccountCenter", paramString, "AccountCenter", paramVarArgs);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\MemberProtocolBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */