package com.idlefish.flutterboost;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.alibaba.fastjson.JSON;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Utils
{
  public static String assembleUrl(String paramString, Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      if (!localStringBuilder.toString().contains("?")) {
        localStringBuilder.append("?");
      }
      Iterator localIterator1 = paramMap.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        paramString = (Map.Entry)localIterator1.next();
        if ((paramString.getValue() instanceof Map))
        {
          Iterator localIterator2 = ((Map)paramString.getValue()).entrySet().iterator();
          while (localIterator2.hasNext())
          {
            paramMap = (Map.Entry)localIterator2.next();
            String str = (String)paramMap.getKey();
            boolean bool = paramMap.getValue() instanceof Map;
            paramString = null;
            if ((!bool) && (!(paramMap.getValue() instanceof List)))
            {
              if (paramMap.getValue() != null) {
                paramString = URLEncoder.encode(String.valueOf(paramMap.getValue()));
              }
            }
            else {
              try
              {
                paramMap = URLEncoder.encode(JSON.toJSONString(paramMap.getValue()), "UTF-8");
                paramString = paramMap;
              }
              catch (UnsupportedEncodingException paramMap)
              {
                paramMap.printStackTrace();
              }
            }
            if (paramString != null) {
              if (localStringBuilder.toString().endsWith("?"))
              {
                localStringBuilder.append(str);
                localStringBuilder.append("=");
                localStringBuilder.append(paramString);
              }
              else
              {
                localStringBuilder.append("&");
                localStringBuilder.append(str);
                localStringBuilder.append("=");
                localStringBuilder.append(paramString);
              }
            }
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void assertCallOnMainThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      Debuger.exception("must call method on main thread");
    }
  }
  
  public static boolean checkImageValid(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return false;
    }
    int m = paramBitmap.getWidth();
    int n = paramBitmap.getHeight();
    Object localObject = new int[m * n];
    paramBitmap.getPixels((int[])localObject, 0, m, 0, 0, m, n);
    paramBitmap = new int[18];
    int j = 0;
    while (j < 5)
    {
      int i1 = 4 - j % 2;
      for (i = 0; i < i1; i = k)
      {
        int i2 = j + 1;
        int i3 = i2 / 2;
        int i4 = n / 6;
        k = i + 1;
        paramBitmap[(j * 3 + i + i3)] = localObject[(i2 * i4 * m + m / (i1 + 1) * k)];
      }
      j += 1;
    }
    localObject = (float[][])Array.newInstance(Float.TYPE, new int[] { 18, 3 });
    int i = 0;
    while (i < 18)
    {
      j = paramBitmap[i];
      Color.RGBToHSV((0xFF0000 & j) >> 16, (0xFF00 & j) >> 8, j & 0xFF, localObject[i]);
      i += 1;
    }
    i = 0;
    int k = 0;
    while (i < 18)
    {
      j = i + 1;
      m = j;
      while (m < 18)
      {
        n = k;
        if (Math.sqrt(Math.pow(localObject[i][0] - localObject[m][0], 2.0D) + Math.pow(localObject[i][1] - localObject[m][1], 2.0D) + Math.pow(localObject[i][2] - localObject[m][2], 2.0D)) >= 1.0D) {
          n = k + 1;
        }
        m += 1;
        k = n;
      }
      i = j;
    }
    return k > 10;
  }
  
  public static void fixInputMethodManagerLeak(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    int i = 0;
    while (i < 3)
    {
      Object localObject1 = new String[] { "mLastSrvView", "mServedView", "mNextServedView" }[i];
      try
      {
        localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
        if (!((Field)localObject1).isAccessible()) {
          ((Field)localObject1).setAccessible(true);
        }
        Object localObject3 = ((Field)localObject1).get(localInputMethodManager);
        if ((localObject3 != null) && ((localObject3 instanceof View)))
        {
          if (((View)localObject3).getContext() != paramContext) {
            break;
          }
          ((Field)localObject1).set(localInputMethodManager, null);
        }
      }
      finally
      {
        for (;;) {}
      }
      i += 1;
    }
  }
  
  /* Error */
  public static String getMIUISystemVersion()
  {
    // Byte code:
    //   0: new 224	java/io/BufferedReader
    //   3: dup
    //   4: new 226	java/io/InputStreamReader
    //   7: dup
    //   8: invokestatic 232	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   11: ldc -22
    //   13: invokevirtual 238	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   16: invokevirtual 244	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   19: invokespecial 247	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: sipush 1024
    //   25: invokespecial 250	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokevirtual 253	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_1
    //   34: aload_0
    //   35: invokevirtual 256	java/io/BufferedReader:close	()V
    //   38: aload_0
    //   39: invokevirtual 256	java/io/BufferedReader:close	()V
    //   42: aload_1
    //   43: areturn
    //   44: astore_1
    //   45: goto +9 -> 54
    //   48: goto +18 -> 66
    //   51: astore_1
    //   52: aconst_null
    //   53: astore_0
    //   54: aload_0
    //   55: ifnull +7 -> 62
    //   58: aload_0
    //   59: invokevirtual 256	java/io/BufferedReader:close	()V
    //   62: aload_1
    //   63: athrow
    //   64: aconst_null
    //   65: astore_0
    //   66: aload_0
    //   67: ifnull +7 -> 74
    //   70: aload_0
    //   71: invokevirtual 256	java/io/BufferedReader:close	()V
    //   74: aconst_null
    //   75: areturn
    //   76: astore_0
    //   77: goto -13 -> 64
    //   80: astore_1
    //   81: goto -33 -> 48
    //   84: astore_0
    //   85: aload_1
    //   86: areturn
    //   87: astore_0
    //   88: goto -26 -> 62
    //   91: astore_0
    //   92: aconst_null
    //   93: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   28	43	0	localBufferedReader	java.io.BufferedReader
    //   76	1	0	localIOException1	java.io.IOException
    //   84	1	0	localIOException2	java.io.IOException
    //   87	1	0	localIOException3	java.io.IOException
    //   91	1	0	localIOException4	java.io.IOException
    //   33	10	1	str	String
    //   44	1	1	localObject1	Object
    //   51	12	1	localObject2	Object
    //   80	6	1	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   29	38	44	finally
    //   0	29	51	finally
    //   0	29	76	java/io/IOException
    //   29	38	80	java/io/IOException
    //   38	42	84	java/io/IOException
    //   58	62	87	java/io/IOException
    //   70	74	91	java/io/IOException
  }
  
  public static int getMetricsHeight(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
      if (localWindowManager != null)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        if ((localDisplayMetrics.widthPixels > 0) && (localDisplayMetrics.heightPixels > 0)) {
          return localDisplayMetrics.heightPixels;
        }
      }
    }
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getMetricsWidth(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
      if (localWindowManager != null)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
        if ((localDisplayMetrics.widthPixels > 0) && (localDisplayMetrics.heightPixels > 0)) {
          return localDisplayMetrics.widthPixels;
        }
      }
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return paramContext.getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static boolean isCurrentMIUIVersionBiggerAndEqual(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    int j = Integer.parseInt(paramString.substring(1));
    paramString = getMIUISystemVersion();
    int i;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() > 1)) {
      i = Integer.parseInt(paramString.substring(1));
    } else {
      i = 0;
    }
    bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0)
      {
        bool1 = bool2;
        if (i >= j) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void saveBitmap(Bitmap paramBitmap, File paramFile, String paramString)
  {
    try
    {
      paramString = new File(paramFile, paramString);
      if (!paramFile.exists()) {
        if (paramFile.mkdirs())
        {
          if (!paramString.createNewFile()) {
            throw new Exception("createNewFile except");
          }
        }
        else {
          throw new Exception("mkdir except");
        }
      }
      paramFile = new FileOutputStream(paramString);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, paramFile);
      paramFile.flush();
      paramFile.close();
      paramBitmap = new StringBuilder();
      paramBitmap.append("saved bitmap:");
      paramBitmap.append(paramString.getAbsolutePath());
      Debuger.exception(paramBitmap.toString());
      return;
    }
    finally {}
  }
  
  private static void setMIUISetStatusBarLightMode(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      boolean bool = isCurrentMIUIVersionBiggerAndEqual("V9");
      if ((bool) && (Build.VERSION.SDK_INT >= 23))
      {
        Log.e("ImmerseTheme", "setMIUISetStatusBarLightMode MIUI > 9");
        if (paramBoolean)
        {
          paramActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
          return;
        }
        paramActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
        return;
      }
      if (paramActivity.getWindow() != null)
      {
        Log.e("ImmerseTheme", "setMIUISetStatusBarLightMode MIUI < 9");
        paramActivity = paramActivity.getWindow();
        Object localObject = paramActivity.getClass();
        Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        int i = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
        localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
        if (paramBoolean)
        {
          ((Method)localObject).invoke(paramActivity, new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
          return;
        }
        ((Method)localObject).invoke(paramActivity, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
        return;
      }
    }
    catch (Exception paramActivity)
    {
      Debuger.exception(paramActivity);
    }
  }
  
  public static void setStatusBarLightMode(Activity paramActivity, boolean paramBoolean)
  {
    try
    {
      Object localObject2 = Build.MANUFACTURER;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "unknow";
      }
      localObject1 = ((String)localObject1).toLowerCase();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("current MANUFACTURER=");
      ((StringBuilder)localObject2).append((String)localObject1);
      Log.e("ImmerseTheme", ((StringBuilder)localObject2).toString());
      if ((!((String)localObject1).contains("xiaomi")) && (!((String)localObject1).contains("redmi")))
      {
        if (((String)localObject1).contains("meizu"))
        {
          StatusbarColorUtils.setStatusBarDarkIcon(paramActivity, true);
          return;
        }
        if (Build.VERSION.SDK_INT >= 23)
        {
          Log.e("ImmerseTheme", "setStatusBarLightMode");
          if (paramBoolean)
          {
            paramActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
            return;
          }
          paramActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
        }
      }
      else
      {
        setMIUISetStatusBarLightMode(paramActivity, paramBoolean);
        return;
      }
    }
    finally
    {
      paramActivity.printStackTrace();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */