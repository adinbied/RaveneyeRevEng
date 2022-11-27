package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport.WebViewInterface;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

public class H5JavaScriptInterface
{
  private static HashSet<Integer> a = new HashSet();
  private String b = null;
  private Thread c = null;
  private String d = null;
  private Map<String, String> e = null;
  
  private static a a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return null;
      }
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = new a();
        paramString.a = ((JSONObject)localObject).getString("projectRoot");
        if (paramString.a == null) {
          return null;
        }
        paramString.b = ((JSONObject)localObject).getString("context");
        if (paramString.b == null) {
          return null;
        }
        paramString.c = ((JSONObject)localObject).getString("url");
        if (paramString.c == null) {
          return null;
        }
        paramString.d = ((JSONObject)localObject).getString("userAgent");
        if (paramString.d == null) {
          return null;
        }
        paramString.e = ((JSONObject)localObject).getString("language");
        if (paramString.e == null) {
          return null;
        }
        paramString.f = ((JSONObject)localObject).getString("name");
        if (paramString.f != null)
        {
          if (paramString.f.equals("null")) {
            return null;
          }
          String str = ((JSONObject)localObject).getString("stacktrace");
          if (str == null) {
            return null;
          }
          int i = str.indexOf("\n");
          if (i < 0)
          {
            x.d("H5 crash stack's format is wrong!", new Object[0]);
            return null;
          }
          paramString.h = str.substring(i + 1);
          paramString.g = str.substring(0, i);
          i = paramString.g.indexOf(":");
          if (i > 0) {
            paramString.g = paramString.g.substring(i + 1);
          }
          paramString.i = ((JSONObject)localObject).getString("file");
          if (paramString.f == null) {
            return null;
          }
          paramString.j = ((JSONObject)localObject).getLong("lineNumber");
          if (paramString.j < 0L) {
            return null;
          }
          paramString.k = ((JSONObject)localObject).getLong("columnNumber");
          if (paramString.k < 0L) {
            return null;
          }
          x.a("H5 crash information is following: ", new Object[0]);
          localObject = new StringBuilder("[projectRoot]: ");
          ((StringBuilder)localObject).append(paramString.a);
          x.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[context]: ");
          ((StringBuilder)localObject).append(paramString.b);
          x.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[url]: ");
          ((StringBuilder)localObject).append(paramString.c);
          x.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[userAgent]: ");
          ((StringBuilder)localObject).append(paramString.d);
          x.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[language]: ");
          ((StringBuilder)localObject).append(paramString.e);
          x.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[name]: ");
          ((StringBuilder)localObject).append(paramString.f);
          x.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[message]: ");
          ((StringBuilder)localObject).append(paramString.g);
          x.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[stacktrace]: \n");
          ((StringBuilder)localObject).append(paramString.h);
          x.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[file]: ");
          ((StringBuilder)localObject).append(paramString.i);
          x.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[lineNumber]: ");
          ((StringBuilder)localObject).append(paramString.j);
          x.a(((StringBuilder)localObject).toString(), new Object[0]);
          localObject = new StringBuilder("[columnNumber]: ");
          ((StringBuilder)localObject).append(paramString.k);
          x.a(((StringBuilder)localObject).toString(), new Object[0]);
          return paramString;
        }
        return null;
      }
      finally
      {
        if (!x.a(paramString)) {
          paramString.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static H5JavaScriptInterface getInstance(CrashReport.WebViewInterface paramWebViewInterface)
  {
    Object localObject1 = null;
    if (paramWebViewInterface != null)
    {
      if (a.contains(Integer.valueOf(paramWebViewInterface.hashCode()))) {
        return null;
      }
      H5JavaScriptInterface localH5JavaScriptInterface = new H5JavaScriptInterface();
      a.add(Integer.valueOf(paramWebViewInterface.hashCode()));
      Object localObject2 = Thread.currentThread();
      localH5JavaScriptInterface.c = ((Thread)localObject2);
      if (localObject2 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("\n");
        int i = 2;
        while (i < ((Thread)localObject2).getStackTrace().length)
        {
          StackTraceElement localStackTraceElement = localObject2.getStackTrace()[i];
          if (!localStackTraceElement.toString().contains("crashreport"))
          {
            ((StringBuilder)localObject1).append(localStackTraceElement.toString());
            ((StringBuilder)localObject1).append("\n");
          }
          i += 1;
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localH5JavaScriptInterface.d = ((String)localObject1);
      localObject1 = new HashMap();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramWebViewInterface.getContentDescription());
      ((Map)localObject1).put("[WebView] ContentDescription", ((StringBuilder)localObject2).toString());
      localH5JavaScriptInterface.e = ((Map)localObject1);
      return localH5JavaScriptInterface;
    }
    return null;
  }
  
  @JavascriptInterface
  public void printLog(String paramString)
  {
    x.d("Log from js: %s", new Object[] { paramString });
  }
  
  @JavascriptInterface
  public void reportJSException(String paramString)
  {
    if (paramString == null)
    {
      x.d("Payload from JS is null.", new Object[0]);
      return;
    }
    Object localObject1 = z.a(paramString.getBytes());
    Object localObject2 = this.b;
    if ((localObject2 != null) && (((String)localObject2).equals(localObject1)))
    {
      x.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
      return;
    }
    this.b = ((String)localObject1);
    x.d("Handling JS exception ...", new Object[0]);
    paramString = a(paramString);
    if (paramString == null)
    {
      x.d("Failed to parse payload.", new Object[0]);
      return;
    }
    localObject1 = new LinkedHashMap();
    localObject2 = new LinkedHashMap();
    if (paramString.a != null) {
      ((Map)localObject2).put("[JS] projectRoot", paramString.a);
    }
    if (paramString.b != null) {
      ((Map)localObject2).put("[JS] context", paramString.b);
    }
    if (paramString.c != null) {
      ((Map)localObject2).put("[JS] url", paramString.c);
    }
    if (paramString.d != null) {
      ((Map)localObject2).put("[JS] userAgent", paramString.d);
    }
    if (paramString.i != null) {
      ((Map)localObject2).put("[JS] file", paramString.i);
    }
    if (paramString.j != 0L) {
      ((Map)localObject2).put("[JS] lineNumber", Long.toString(paramString.j));
    }
    ((Map)localObject1).putAll((Map)localObject2);
    ((Map)localObject1).putAll(this.e);
    ((Map)localObject1).put("Java Stack", this.d);
    localObject2 = this.c;
    if (paramString != null) {
      InnerApi.postH5CrashAsync((Thread)localObject2, paramString.f, paramString.g, paramString.h, (Map)localObject1);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\crash\h5\H5JavaScriptInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */