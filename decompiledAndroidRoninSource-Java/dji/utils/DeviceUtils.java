package dji.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import java.util.Locale;
import java.util.UUID;

public class DeviceUtils
{
  private static final String KEY_EMUI_VERSION_CODE = "ro.build.version.emui";
  public static final String KEY_MANUFACTOR_HUAWEI = "HUAWEI";
  private static final String KEY_MANUFACTOR_OPPO = "oppo";
  private static final String KEY_MANUFACTOR_SAMSUNG = "samsung";
  private static final String KEY_MANUFACTOR_SMARTISAN = "smartisan";
  private static final String KEY_MANUFACTOR_VIVO = "vivo";
  private static final String KEY_MANUFACTOR_XIAOMI = "xiaomi";
  private static final String KEY_MIUI_VERSION_CODE = "ro.miui.version.code_time";
  
  public static String getAndroidID(Context paramContext)
  {
    try
    {
      paramContext = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    finally
    {
      for (;;) {}
    }
    return "";
  }
  
  public static int getBattery(Context paramContext)
  {
    return ((BatteryManager)paramContext.getSystemService("batterymanager")).getIntProperty(4);
  }
  
  public static String getCountry(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 24) {
      paramContext = paramContext.getResources().getConfiguration().getLocales().get(0);
    } else {
      paramContext = paramContext.getResources().getConfiguration().locale;
    }
    return paramContext.getCountry();
  }
  
  public static int getEmuiVersion()
  {
    if ("HUAWEI".equals(getManufacture())) {
      return Integer.valueOf(String.valueOf(getSystemProperty("ro.build.version.emui").charAt(10))).intValue();
    }
    return -1;
  }
  
  public static String getMCC(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSimOperator();
    if ((paramContext != null) && (paramContext.length() >= 3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext, 0, 3);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String getManufacture()
  {
    return Build.MANUFACTURER.toLowerCase();
  }
  
  public static int getMiuiVersion()
  {
    if ("xiaomi".equals(getManufacture())) {
      return Integer.valueOf(getSystemProperty("ro.miui.version.code_time").charAt(0)).intValue();
    }
    return -1;
  }
  
  public static String getModel()
  {
    return Build.MODEL.toLowerCase();
  }
  
  /* Error */
  public static String getSystemProperty(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 180	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: astore_1
    //   6: new 148	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc -74
    //   17: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: new 187	java/io/BufferedReader
    //   30: dup
    //   31: new 189	java/io/InputStreamReader
    //   34: dup
    //   35: aload_1
    //   36: aload_3
    //   37: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 193	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   43: invokevirtual 199	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   46: invokespecial 202	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   49: sipush 1024
    //   52: invokespecial 205	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   55: astore_1
    //   56: aload_1
    //   57: astore_0
    //   58: aload_1
    //   59: invokevirtual 208	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   62: astore_2
    //   63: aload_1
    //   64: astore_0
    //   65: aload_1
    //   66: invokevirtual 211	java/io/BufferedReader:close	()V
    //   69: aload_1
    //   70: invokevirtual 211	java/io/BufferedReader:close	()V
    //   73: aload_2
    //   74: areturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   80: aload_2
    //   81: areturn
    //   82: astore_2
    //   83: goto +12 -> 95
    //   86: astore_0
    //   87: aload_2
    //   88: astore_1
    //   89: goto +34 -> 123
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: astore_0
    //   97: aload_2
    //   98: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   101: aload_1
    //   102: ifnull +14 -> 116
    //   105: aload_1
    //   106: invokevirtual 211	java/io/BufferedReader:close	()V
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_2
    //   119: aload_0
    //   120: astore_1
    //   121: aload_2
    //   122: astore_0
    //   123: aload_1
    //   124: ifnull +15 -> 139
    //   127: aload_1
    //   128: invokevirtual 211	java/io/BufferedReader:close	()V
    //   131: goto +8 -> 139
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   139: aload_0
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramString	String
    //   5	123	1	localObject1	Object
    //   134	2	1	localIOException1	java.io.IOException
    //   1	80	2	str	String
    //   82	6	2	localIOException2	java.io.IOException
    //   92	6	2	localIOException3	java.io.IOException
    //   118	4	2	localObject2	Object
    //   13	24	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	73	75	java/io/IOException
    //   58	63	82	java/io/IOException
    //   65	69	82	java/io/IOException
    //   2	56	86	finally
    //   2	56	92	java/io/IOException
    //   105	109	111	java/io/IOException
    //   58	63	118	finally
    //   65	69	118	finally
    //   97	101	118	finally
    //   127	131	134	java/io/IOException
  }
  
  public static String getUUID(Context paramContext)
  {
    return UUID.randomUUID().toString();
  }
  
  public static boolean isMIUI()
  {
    return getMiuiVersion() != -1;
  }
  
  public static boolean isSamSung()
  {
    return "samsung".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  public static boolean isSmartisan()
  {
    return "smartisan".equals(getManufacture());
  }
  
  public static boolean isTablet(Context paramContext)
  {
    return (paramContext.getApplicationContext().getResources().getConfiguration().screenLayout & 0xF) >= 3;
  }
  
  public static boolean supportArm64ABI()
  {
    if (Build.SUPPORTED_64_BIT_ABIS.length > 0)
    {
      String[] arrayOfString = Build.SUPPORTED_64_BIT_ABIS;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((str != null) && (str.equals("arm64-v8a"))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\DeviceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */