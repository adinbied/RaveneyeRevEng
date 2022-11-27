package com.tencent.bugly.crashreport;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.BuglyStrategy.a;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.net.InetAddress;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CrashReport
{
  private static Context a;
  
  public static void closeBugly()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not close bugly because bugly is disable.");
      return;
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.w(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    }
    if (a == null) {
      return;
    }
    Object localObject = BuglyBroadcastReceiver.getInstance();
    if (localObject != null) {
      ((BuglyBroadcastReceiver)localObject).unregister(a);
    }
    closeCrashReport();
    com.tencent.bugly.crashreport.biz.b.a(a);
    localObject = w.a();
    if (localObject != null) {
      ((w)localObject).b();
    }
  }
  
  public static void closeCrashReport()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not close crash report because bugly is disable.");
      return;
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.w(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    }
    c.a().d();
  }
  
  public static void closeNativeReport()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not close native report because bugly is disable.");
      return;
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    }
    c.a().g();
  }
  
  public static void enableBugly(boolean paramBoolean)
  {
    com.tencent.bugly.b.a = paramBoolean;
  }
  
  public static void enableObtainId(Context paramContext, boolean paramBoolean)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set DB name because bugly is disable.");
      return;
    }
    if (paramContext == null)
    {
      Log.w(x.a, "enableObtainId args context should not be null");
      return;
    }
    String str = x.a;
    StringBuilder localStringBuilder = new StringBuilder("Enable identification obtaining? ");
    localStringBuilder.append(paramBoolean);
    Log.i(str, localStringBuilder.toString());
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).b(paramBoolean);
  }
  
  public static Set<String> getAllUserDataKeys(Context paramContext)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not get all keys of user data because bugly is disable.");
      return new HashSet();
    }
    if (paramContext == null)
    {
      Log.e(x.a, "getAllUserDataKeys args context should not be null");
      return new HashSet();
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).x();
  }
  
  public static String getAppChannel()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not get App channel because bugly is disable.");
      return "unknown";
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return "unknown";
    }
    return com.tencent.bugly.crashreport.common.info.a.a(a).l;
  }
  
  public static String getAppID()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not get App ID because bugly is disable.");
      return "unknown";
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return "unknown";
    }
    return com.tencent.bugly.crashreport.common.info.a.a(a).f();
  }
  
  public static String getAppVer()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not get app version because bugly is disable.");
      return "unknown";
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return "unknown";
    }
    return com.tencent.bugly.crashreport.common.info.a.a(a).j;
  }
  
  public static String getBuglyVersion(Context paramContext)
  {
    if (paramContext == null)
    {
      x.d("Please call with context.", new Object[0]);
      return "unknown";
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).c();
  }
  
  public static String getDeviceID(Context paramContext)
  {
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).h();
  }
  
  public static Proxy getHttpProxy()
  {
    return com.tencent.bugly.proguard.a.b();
  }
  
  public static Map<String, String> getSdkExtraData()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not get SDK extra data because bugly is disable.");
      return new HashMap();
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return null;
    }
    return com.tencent.bugly.crashreport.common.info.a.a(a).B;
  }
  
  public static Map<String, String> getSdkExtraData(Context paramContext)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not get SDK extra data because bugly is disable.");
      return new HashMap();
    }
    if (paramContext == null)
    {
      x.d("Context should not be null.", new Object[0]);
      return null;
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).B;
  }
  
  public static String getUserData(Context paramContext, String paramString)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not get user data because bugly is disable.");
      return "unknown";
    }
    if (paramContext == null)
    {
      Log.e(x.a, "getUserDataValue args context should not be null");
      return "unknown";
    }
    if (z.a(paramString)) {
      return null;
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).h(paramString);
  }
  
  public static int getUserDatasSize(Context paramContext)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not get size of user data because bugly is disable.");
      return -1;
    }
    if (paramContext == null)
    {
      Log.e(x.a, "getUserDatasSize args context should not be null");
      return -1;
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).w();
  }
  
  public static String getUserId()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not get user ID because bugly is disable.");
      return "unknown";
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return "unknown";
    }
    return com.tencent.bugly.crashreport.common.info.a.a(a).g();
  }
  
  public static int getUserSceneTagId(Context paramContext)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not get user scene tag because bugly is disable.");
      return -1;
    }
    if (paramContext == null)
    {
      Log.e(x.a, "getUserSceneTagId args context should not be null");
      return -1;
    }
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).A();
  }
  
  public static void initCrashReport(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    a = paramContext;
    com.tencent.bugly.b.a(CrashModule.getInstance());
    com.tencent.bugly.b.a(paramContext);
  }
  
  public static void initCrashReport(Context paramContext, UserStrategy paramUserStrategy)
  {
    if (paramContext == null) {
      return;
    }
    a = paramContext;
    com.tencent.bugly.b.a(CrashModule.getInstance());
    com.tencent.bugly.b.a(paramContext, paramUserStrategy);
  }
  
  public static void initCrashReport(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      a = paramContext;
      com.tencent.bugly.b.a(CrashModule.getInstance());
      com.tencent.bugly.b.a(paramContext, paramString, paramBoolean, null);
    }
  }
  
  public static void initCrashReport(Context paramContext, String paramString, boolean paramBoolean, UserStrategy paramUserStrategy)
  {
    if (paramContext == null) {
      return;
    }
    a = paramContext;
    com.tencent.bugly.b.a(CrashModule.getInstance());
    com.tencent.bugly.b.a(paramContext, paramString, paramBoolean, paramUserStrategy);
  }
  
  public static boolean isLastSessionCrash()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "The info 'isLastSessionCrash' is not accurate because bugly is disable.");
      return false;
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return false;
    }
    return c.a().b();
  }
  
  public static void postCatchedException(Throwable paramThrowable)
  {
    postCatchedException(paramThrowable, Thread.currentThread(), false);
  }
  
  public static void postCatchedException(Throwable paramThrowable, Thread paramThread)
  {
    postCatchedException(paramThrowable, paramThread, false);
  }
  
  public static void postCatchedException(Throwable paramThrowable, Thread paramThread, boolean paramBoolean)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not post crash caught because bugly is disable.");
      return;
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    }
    if (paramThrowable == null)
    {
      x.d("throwable is null, just return", new Object[0]);
      return;
    }
    Thread localThread = paramThread;
    if (paramThread == null) {
      localThread = Thread.currentThread();
    }
    c.a().a(localThread, paramThrowable, false, null, null, paramBoolean);
  }
  
  public static void postException(int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    postException(Thread.currentThread(), paramInt, paramString1, paramString2, paramString3, paramMap);
  }
  
  public static void postException(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not post crash caught because bugly is disable.");
      return;
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    }
    d.a(paramThread, paramInt, paramString1, paramString2, paramString3, paramMap);
  }
  
  private static void putSdkData(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext != null) && (!z.a(paramString1)))
    {
      if (z.a(paramString2)) {
        return;
      }
      String str = paramString1.replace("[a-zA-Z[0-9]]+", "");
      paramString1 = str;
      if (str.length() > 100)
      {
        Log.w(x.a, String.format("putSdkData key length over limit %d, will be cutted.", new Object[] { Integer.valueOf(50) }));
        paramString1 = str.substring(0, 50);
      }
      str = paramString2;
      if (paramString2.length() > 500)
      {
        Log.w(x.a, String.format("putSdkData value length over limit %d, will be cutted!", new Object[] { Integer.valueOf(200) }));
        str = paramString2.substring(0, 200);
      }
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).c(paramString1, str);
      x.b(String.format("[param] putSdkData data: %s - %s", new Object[] { paramString1, str }), new Object[0]);
    }
  }
  
  public static void putUserData(Context paramContext, String paramString1, String paramString2)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not put user data because bugly is disable.");
      return;
    }
    if (paramContext == null)
    {
      Log.w(x.a, "putUserData args context should not be null");
      return;
    }
    if (paramString1 == null)
    {
      x.d("putUserData args key should not be null or empty", new Object[0]);
      return;
    }
    if (paramString2 == null)
    {
      x.d("putUserData args value should not be null", new Object[0]);
      return;
    }
    String str = paramString2;
    if (paramString2.length() > 200)
    {
      x.d("user data value length over limit %d, it will be cutted!", new Object[] { Integer.valueOf(200) });
      str = paramString2.substring(0, 200);
    }
    paramString2 = com.tencent.bugly.crashreport.common.info.a.a(paramContext);
    if (paramString2.x().contains(paramString1))
    {
      paramString2 = NativeCrashHandler.getInstance();
      if (paramString2 != null) {
        paramString2.putKeyValueToNative(paramString1, str);
      }
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).b(paramString1, str);
      x.c("replace KV %s %s", new Object[] { paramString1, str });
      return;
    }
    if (paramString2.w() >= 50)
    {
      x.d("user data size is over limit %d, it will be cutted!", new Object[] { Integer.valueOf(50) });
      return;
    }
    paramString2 = paramString1;
    if (paramString1.length() > 50)
    {
      x.d("user data key length over limit %d , will drop this new key %s", new Object[] { Integer.valueOf(50), paramString1 });
      paramString2 = paramString1.substring(0, 50);
    }
    paramString1 = NativeCrashHandler.getInstance();
    if (paramString1 != null) {
      paramString1.putKeyValueToNative(paramString2, str);
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).b(paramString2, str);
    x.b("[param] set user data: %s - %s", new Object[] { paramString2, str });
  }
  
  public static String removeUserData(Context paramContext, String paramString)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not remove user data because bugly is disable.");
      return "unknown";
    }
    if (paramContext == null)
    {
      Log.e(x.a, "removeUserData args context should not be null");
      return "unknown";
    }
    if (z.a(paramString)) {
      return null;
    }
    x.b("[param] remove user data: %s", new Object[] { paramString });
    return com.tencent.bugly.crashreport.common.info.a.a(paramContext).g(paramString);
  }
  
  public static void setAppChannel(Context paramContext, String paramString)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set App channel because Bugly is disable.");
      return;
    }
    if (paramContext == null)
    {
      Log.w(x.a, "setAppChannel args context should not be null");
      return;
    }
    if (paramString == null)
    {
      Log.w(x.a, "App channel is null, will not set");
      return;
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).l = paramString;
    paramContext = NativeCrashHandler.getInstance();
    if (paramContext != null) {
      paramContext.setNativeAppChannel(paramString);
    }
  }
  
  public static void setAppPackage(Context paramContext, String paramString)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      return;
    }
    if (paramContext == null)
    {
      Log.w(x.a, "setAppPackage args context should not be null");
      return;
    }
    if (paramString == null)
    {
      Log.w(x.a, "App package is null, will not set");
      return;
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).c = paramString;
    paramContext = NativeCrashHandler.getInstance();
    if (paramContext != null) {
      paramContext.setNativeAppPackage(paramString);
    }
  }
  
  public static void setAppVersion(Context paramContext, String paramString)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set App version because bugly is disable.");
      return;
    }
    if (paramContext == null)
    {
      Log.w(x.a, "setAppVersion args context should not be null");
      return;
    }
    if (paramString == null)
    {
      Log.w(x.a, "App version is null, will not set");
      return;
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).j = paramString;
    paramContext = NativeCrashHandler.getInstance();
    if (paramContext != null) {
      paramContext.setNativeAppVersion(paramString);
    }
  }
  
  public static void setBuglyDbName(String paramString)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set DB name because bugly is disable.");
      return;
    }
    String str = x.a;
    StringBuilder localStringBuilder = new StringBuilder("Set Bugly DB name: ");
    localStringBuilder.append(paramString);
    Log.i(str, localStringBuilder.toString());
    com.tencent.bugly.proguard.q.a = paramString;
  }
  
  public static void setContext(Context paramContext)
  {
    a = paramContext;
  }
  
  public static void setCrashFilter(String paramString)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      return;
    }
    String str = x.a;
    StringBuilder localStringBuilder = new StringBuilder("Set crash stack filter: ");
    localStringBuilder.append(paramString);
    Log.i(str, localStringBuilder.toString());
    c.n = paramString;
  }
  
  public static void setCrashRegularFilter(String paramString)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      return;
    }
    String str = x.a;
    StringBuilder localStringBuilder = new StringBuilder("Set crash stack filter: ");
    localStringBuilder.append(paramString);
    Log.i(str, localStringBuilder.toString());
    c.o = paramString;
  }
  
  public static void setDeviceId(Context paramContext, String paramString)
  {
    if (paramString != null) {
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).c(paramString);
    }
  }
  
  public static void setDeviceModel(Context paramContext, String paramString)
  {
    if (paramString != null) {
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).d(paramString);
    }
  }
  
  public static void setHandleNativeCrashInJava(boolean paramBoolean)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set App package because bugly is disable.");
      return;
    }
    String str = x.a;
    StringBuilder localStringBuilder = new StringBuilder("Should handle native crash in Java profile after handled in native profile: ");
    localStringBuilder.append(paramBoolean);
    Log.i(str, localStringBuilder.toString());
    NativeCrashHandler.setShouldHandleInJava(paramBoolean);
  }
  
  public static void setHttpProxy(String paramString, int paramInt)
  {
    com.tencent.bugly.proguard.a.a(paramString, paramInt);
  }
  
  public static void setHttpProxy(InetAddress paramInetAddress, int paramInt)
  {
    com.tencent.bugly.proguard.a.a(paramInetAddress, paramInt);
  }
  
  public static void setIsAppForeground(Context paramContext, boolean paramBoolean)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set 'isAppForeground' because bugly is disable.");
      return;
    }
    if (paramContext == null)
    {
      x.d("Context should not be null.", new Object[0]);
      return;
    }
    if (paramBoolean) {
      x.c("App is in foreground.", new Object[0]);
    } else {
      x.c("App is in background.", new Object[0]);
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramBoolean);
  }
  
  public static void setIsDevelopmentDevice(Context paramContext, boolean paramBoolean)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set 'isDevelopmentDevice' because bugly is disable.");
      return;
    }
    if (paramContext == null)
    {
      x.d("Context should not be null.", new Object[0]);
      return;
    }
    if (paramBoolean) {
      x.c("This is a development device.", new Object[0]);
    } else {
      x.c("This is not a development device.", new Object[0]);
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).z = paramBoolean;
  }
  
  public static boolean setJavascriptMonitor(WebView paramWebView, boolean paramBoolean)
  {
    return setJavascriptMonitor(paramWebView, paramBoolean, false);
  }
  
  public static boolean setJavascriptMonitor(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramWebView == null)
    {
      Log.w(x.a, "WebView is null.");
      return false;
    }
    paramWebView.getSettings().setSavePassword(false);
    paramWebView.getSettings().setAllowFileAccess(false);
    setJavascriptMonitor(new WebViewInterface()
    {
      public final void addJavascriptInterface(H5JavaScriptInterface paramAnonymousH5JavaScriptInterface, String paramAnonymousString)
      {
        this.a.addJavascriptInterface(paramAnonymousH5JavaScriptInterface, paramAnonymousString);
      }
      
      public final CharSequence getContentDescription()
      {
        return this.a.getContentDescription();
      }
      
      public final String getUrl()
      {
        return this.a.getUrl();
      }
      
      public final void loadUrl(String paramAnonymousString)
      {
        this.a.loadUrl(paramAnonymousString);
      }
      
      public final void setJavaScriptEnabled(boolean paramAnonymousBoolean)
      {
        WebSettings localWebSettings = this.a.getSettings();
        if (!localWebSettings.getJavaScriptEnabled()) {
          localWebSettings.setJavaScriptEnabled(true);
        }
      }
    }, paramBoolean1, paramBoolean2);
  }
  
  public static boolean setJavascriptMonitor(WebViewInterface paramWebViewInterface, boolean paramBoolean)
  {
    return setJavascriptMonitor(paramWebViewInterface, paramBoolean, false);
  }
  
  public static boolean setJavascriptMonitor(WebViewInterface paramWebViewInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramWebViewInterface == null)
    {
      Log.w(x.a, "WebViewInterface is null.");
      return false;
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      x.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
      return false;
    }
    x.a("Set Javascript exception monitor of webview.", new Object[0]);
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set JavaScript monitor because bugly is disable.");
      return false;
    }
    x.c("URL of webview is %s", new Object[] { paramWebViewInterface.getUrl() });
    if ((!paramBoolean2) && (Build.VERSION.SDK_INT < 19))
    {
      x.e("This interface is only available for Android 4.4 or later.", new Object[0]);
      return false;
    }
    x.a("Enable the javascript needed by webview monitor.", new Object[0]);
    paramWebViewInterface.setJavaScriptEnabled(true);
    Object localObject = H5JavaScriptInterface.getInstance(paramWebViewInterface);
    if (localObject != null)
    {
      x.a("Add a secure javascript interface to the webview.", new Object[0]);
      paramWebViewInterface.addJavascriptInterface((H5JavaScriptInterface)localObject, "exceptionUploader");
    }
    if (paramBoolean1)
    {
      x.a("Inject bugly.js(v%s) to the webview.", new Object[] { com.tencent.bugly.crashreport.crash.h5.b.b() });
      localObject = com.tencent.bugly.crashreport.crash.h5.b.a();
      if (localObject == null)
      {
        x.e("Failed to inject Bugly.js.", new Object[] { com.tencent.bugly.crashreport.crash.h5.b.b() });
        return false;
      }
      StringBuilder localStringBuilder = new StringBuilder("javascript:");
      localStringBuilder.append((String)localObject);
      paramWebViewInterface.loadUrl(localStringBuilder.toString());
    }
    return true;
  }
  
  public static void setSdkExtraData(Context paramContext, String paramString1, String paramString2)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not put SDK extra data because bugly is disable.");
      return;
    }
    if ((paramContext != null) && (!z.a(paramString1)))
    {
      if (z.a(paramString2)) {
        return;
      }
      com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramString1, paramString2);
    }
  }
  
  public static void setServerUrl(String paramString)
  {
    if ((!z.a(paramString)) && (z.c(paramString)))
    {
      com.tencent.bugly.crashreport.common.strategy.a.a(paramString);
      com.tencent.bugly.crashreport.common.strategy.StrategyBean.a = paramString;
      com.tencent.bugly.crashreport.common.strategy.StrategyBean.b = paramString;
      return;
    }
    Log.i(x.a, "URL is invalid.");
  }
  
  public static void setSessionIntervalMills(long paramLong)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set 'SessionIntervalMills' because bugly is disable.");
      return;
    }
    com.tencent.bugly.crashreport.biz.b.a(paramLong);
  }
  
  public static void setUserId(Context paramContext, String paramString)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set user ID because bugly is disable.");
      return;
    }
    if (paramContext == null)
    {
      Log.e(x.a, "Context should not be null when bugly has not been initialed!");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      x.d("userId should not be null", new Object[0]);
      return;
    }
    String str = paramString;
    if (paramString.length() > 100)
    {
      str = paramString.substring(0, 100);
      x.d("userId %s length is over limit %d substring to %s", new Object[] { paramString, Integer.valueOf(100), str });
    }
    if (str.equals(com.tencent.bugly.crashreport.common.info.a.a(paramContext).g())) {
      return;
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).b(str);
    x.b("[user] set userId : %s", new Object[] { str });
    paramContext = NativeCrashHandler.getInstance();
    if (paramContext != null) {
      paramContext.setNativeUserId(str);
    }
    if (CrashModule.getInstance().hasInitialized()) {
      com.tencent.bugly.crashreport.biz.b.a();
    }
  }
  
  public static void setUserId(String paramString)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set user ID because bugly is disable.");
      return;
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    }
    setUserId(a, paramString);
  }
  
  public static void setUserSceneTag(Context paramContext, int paramInt)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not set tag caught because bugly is disable.");
      return;
    }
    if (paramContext == null)
    {
      Log.e(x.a, "setTag args context should not be null");
      return;
    }
    if (paramInt <= 0) {
      x.d("setTag args tagId should > 0", new Object[0]);
    }
    com.tencent.bugly.crashreport.common.info.a.a(paramContext).a(paramInt);
    x.b("[param] set user scene tag: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void startCrashReport()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not start crash report because bugly is disable.");
      return;
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.w(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    }
    c.a().c();
  }
  
  public static void testANRCrash()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not test ANR crash because bugly is disable.");
      return;
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    }
    x.a("start to create a anr crash for test!", new Object[0]);
    c.a().l();
  }
  
  public static void testJavaCrash()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not test Java crash because bugly is disable.");
      return;
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    }
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
    if (locala != null) {
      locala.b(24096);
    }
    throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
  }
  
  public static void testNativeCrash()
  {
    testNativeCrash(false, false, false);
  }
  
  public static void testNativeCrash(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not test native crash because bugly is disable.");
      return;
    }
    if (!CrashModule.getInstance().hasInitialized())
    {
      Log.e(x.a, "CrashReport has not been initialed! pls to call method 'initCrashReport' first!");
      return;
    }
    x.a("start to create a native crash for test!", new Object[0]);
    c.a().a(paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public static void uploadUserInfo()
  {
    if (!com.tencent.bugly.b.a)
    {
      Log.w(x.a, "Can not upload user info because bugly is disable.");
      return;
    }
    if (com.tencent.bugly.crashreport.biz.b.a == null)
    {
      Log.w(x.a, "Can not upload user info because bugly is not init.");
      return;
    }
    com.tencent.bugly.crashreport.biz.b.a.b();
  }
  
  public static class CrashHandleCallback
    extends BuglyStrategy.a
  {}
  
  public static class UserStrategy
    extends BuglyStrategy
  {
    private CrashReport.CrashHandleCallback c;
    
    public UserStrategy(Context paramContext) {}
    
    public int getCallBackType()
    {
      try
      {
        int i = this.a;
        return i;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public boolean getCloseErrorCallback()
    {
      try
      {
        boolean bool = this.b;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public CrashReport.CrashHandleCallback getCrashHandleCallback()
    {
      try
      {
        CrashReport.CrashHandleCallback localCrashHandleCallback = this.c;
        return localCrashHandleCallback;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void setCallBackType(int paramInt)
    {
      try
      {
        this.a = paramInt;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void setCloseErrorCallback(boolean paramBoolean)
    {
      try
      {
        this.b = paramBoolean;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void setCrashHandleCallback(CrashReport.CrashHandleCallback paramCrashHandleCallback)
    {
      try
      {
        this.c = paramCrashHandleCallback;
        return;
      }
      finally
      {
        paramCrashHandleCallback = finally;
        throw paramCrashHandleCallback;
      }
    }
  }
  
  public static abstract interface WebViewInterface
  {
    public abstract void addJavascriptInterface(H5JavaScriptInterface paramH5JavaScriptInterface, String paramString);
    
    public abstract CharSequence getContentDescription();
    
    public abstract String getUrl();
    
    public abstract void loadUrl(String paramString);
    
    public abstract void setJavaScriptEnabled(boolean paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\CrashReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */