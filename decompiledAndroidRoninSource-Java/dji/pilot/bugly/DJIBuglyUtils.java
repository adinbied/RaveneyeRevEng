package dji.pilot.bugly;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import com.dji.frame.util.V_ActivityUtil;
import com.dji.ronin.RoninApplication;
import com.dji.ronin.publics.util.FileUtil;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.CrashReport.CrashHandleCallback;
import com.tencent.bugly.crashreport.CrashReport.UserStrategy;
import dji.utils.storage.DJIFolder;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class DJIBuglyUtils
{
  private static String concatErrorInfo(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Model：");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("\n");
    localStringBuilder.append("OS-Version：");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("\n");
    localStringBuilder.append("APP-Version：");
    localStringBuilder.append(getAppVersionForBugly());
    localStringBuilder.append("\n");
    localStringBuilder.append("\n");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\n");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\n");
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static CrashReport.UserStrategy getAppChannel(Context paramContext)
  {
    paramContext = new CrashReport.UserStrategy(paramContext);
    paramContext.setAppChannel("official");
    return paramContext;
  }
  
  public static String getAppVersionForBugly()
  {
    String str = getBuildNumber(RoninApplication.getAppContext());
    if (TextUtils.isEmpty(str))
    {
      str = "official";
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("-official");
      str = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("1.4.10-");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static String getBuildNumber(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 99	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   4: ldc 101
    //   6: invokevirtual 107	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore_3
    //   10: goto +10 -> 20
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   18: aconst_null
    //   19: astore_3
    //   20: aload_3
    //   21: ifnonnull +6 -> 27
    //   24: ldc 112
    //   26: areturn
    //   27: new 114	java/io/InputStreamReader
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 117	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   35: astore 5
    //   37: new 119	java/io/BufferedReader
    //   40: dup
    //   41: aload 5
    //   43: invokespecial 122	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore 6
    //   48: aload 6
    //   50: invokevirtual 125	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 4
    //   55: aload 4
    //   57: astore_0
    //   58: aload 4
    //   60: ifnull +46 -> 106
    //   63: aload 4
    //   65: invokevirtual 131	java/lang/String:length	()I
    //   68: istore_1
    //   69: aload 4
    //   71: astore_0
    //   72: iload_1
    //   73: ifle +33 -> 106
    //   76: iload_1
    //   77: iconst_1
    //   78: isub
    //   79: istore_2
    //   80: aload 4
    //   82: astore_0
    //   83: aload 4
    //   85: iload_2
    //   86: iload_1
    //   87: invokevirtual 135	java/lang/String:substring	(II)Ljava/lang/String;
    //   90: ldc -119
    //   92: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifeq +11 -> 106
    //   98: aload 4
    //   100: iconst_0
    //   101: iload_2
    //   102: invokevirtual 135	java/lang/String:substring	(II)Ljava/lang/String;
    //   105: astore_0
    //   106: aload_0
    //   107: astore 4
    //   109: aload_0
    //   110: ldc -113
    //   112: invokevirtual 146	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   115: ifeq +13 -> 128
    //   118: aload_0
    //   119: ldc -113
    //   121: invokevirtual 150	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   124: iconst_1
    //   125: aaload
    //   126: astore 4
    //   128: aload_3
    //   129: ifnull +7 -> 136
    //   132: aload_3
    //   133: invokevirtual 155	java/io/InputStream:close	()V
    //   136: aload 5
    //   138: invokevirtual 156	java/io/InputStreamReader:close	()V
    //   141: aload 6
    //   143: invokevirtual 157	java/io/BufferedReader:close	()V
    //   146: aload 4
    //   148: areturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   154: aload 4
    //   156: areturn
    //   157: astore_0
    //   158: aload_3
    //   159: ifnull +7 -> 166
    //   162: aload_3
    //   163: invokevirtual 155	java/io/InputStream:close	()V
    //   166: aload 5
    //   168: invokevirtual 156	java/io/InputStreamReader:close	()V
    //   171: aload 6
    //   173: invokevirtual 157	java/io/BufferedReader:close	()V
    //   176: goto +8 -> 184
    //   179: astore_3
    //   180: aload_3
    //   181: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   184: aload_0
    //   185: athrow
    //   186: aload_3
    //   187: ifnull +7 -> 194
    //   190: aload_3
    //   191: invokevirtual 155	java/io/InputStream:close	()V
    //   194: aload 5
    //   196: invokevirtual 156	java/io/InputStreamReader:close	()V
    //   199: aload 6
    //   201: invokevirtual 157	java/io/BufferedReader:close	()V
    //   204: ldc 112
    //   206: areturn
    //   207: astore_0
    //   208: aload_0
    //   209: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   212: ldc 112
    //   214: areturn
    //   215: astore_0
    //   216: goto -30 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramContext	Context
    //   68	19	1	i	int
    //   79	23	2	j	int
    //   9	154	3	localInputStream	java.io.InputStream
    //   179	12	3	localIOException	IOException
    //   53	102	4	localObject	Object
    //   35	160	5	localInputStreamReader	java.io.InputStreamReader
    //   46	154	6	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   0	10	13	java/io/IOException
    //   132	136	149	java/io/IOException
    //   136	146	149	java/io/IOException
    //   48	55	157	finally
    //   63	69	157	finally
    //   83	106	157	finally
    //   109	128	157	finally
    //   162	166	179	java/io/IOException
    //   166	176	179	java/io/IOException
    //   190	194	207	java/io/IOException
    //   194	204	207	java/io/IOException
    //   48	55	215	java/lang/Exception
    //   63	69	215	java/lang/Exception
    //   83	106	215	java/lang/Exception
    //   109	128	215	java/lang/Exception
  }
  
  public static void initBuglyReport(Context paramContext)
  {
    CrashReport.setIsDevelopmentDevice(paramContext, V_ActivityUtil.isApkDebugable(paramContext));
    CrashReport.UserStrategy localUserStrategy = new CrashReport.UserStrategy(paramContext);
    localUserStrategy.setUploadProcess(true);
    localUserStrategy.setAppVersion(getAppVersionForBugly());
    localUserStrategy.setCrashHandleCallback(new CrashReport.CrashHandleCallback()
    {
      public Map<String, String> onCrashHandleStart(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        return null;
      }
      
      public byte[] onCrashHandleStart2GetExtraDatas(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        try
        {
          paramAnonymousString1 = super.onCrashHandleStart2GetExtraDatas(paramAnonymousInt, paramAnonymousString1, paramAnonymousString2, paramAnonymousString3);
          return paramAnonymousString1;
        }
        finally
        {
          paramAnonymousString1 = finally;
          throw paramAnonymousString1;
        }
      }
    });
    CrashReport.initCrashReport(paramContext, "6c08116b44", V_ActivityUtil.isApkDebugable(paramContext), localUserStrategy);
  }
  
  private static void saveNativeErrorInfoToFile(Context paramContext, String paramString)
  {
    paramContext = DJIFolder.BUGLY.absolutePath();
    String str = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINA).format(new Date());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("crash-native-");
    localStringBuilder.append(str);
    localStringBuilder.append(".txt");
    paramContext = FileUtil.concatPath(new String[] { paramContext, localStringBuilder.toString() });
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      paramContext = new File(paramContext);
      try
      {
        FileUtil.writeStringToFile(paramContext, paramString, "UTF-8");
        return;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void setUserKeyMap(Context paramContext, String paramString)
  {
    if (paramString != null) {
      CrashReport.setUserId(paramString);
    }
    if (paramString != null) {
      CrashReport.putUserData(paramContext, "uid", paramString);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\bugly\DJIBuglyUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */