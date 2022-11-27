package com.google.firebase.crashlytics.internal.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import javax.crypto.Cipher;

public class CommonUtils
{
  static final int BYTES_IN_A_GIGABYTE = 1073741824;
  static final int BYTES_IN_A_KILOBYTE = 1024;
  static final int BYTES_IN_A_MEGABYTE = 1048576;
  private static final boolean CLS_TRACE_DEFAULT = false;
  private static final String CLS_TRACE_PREFERENCE_NAME = "com.crashlytics.Trace";
  public static final int DEVICE_STATE_BETAOS = 8;
  public static final int DEVICE_STATE_COMPROMISEDLIBRARIES = 32;
  public static final int DEVICE_STATE_DEBUGGERATTACHED = 4;
  public static final int DEVICE_STATE_ISSIMULATOR = 1;
  public static final int DEVICE_STATE_JAILBROKEN = 2;
  public static final int DEVICE_STATE_VENDORINTERNAL = 16;
  public static final Comparator<File> FILE_MODIFIED_COMPARATOR = new Comparator()
  {
    public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
    {
      return (int)(paramAnonymousFile1.lastModified() - paramAnonymousFile2.lastModified());
    }
  };
  private static final String GOOGLE_SDK = "google_sdk";
  private static final char[] HEX_VALUES = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  static final String LEGACY_MAPPING_FILE_ID_RESOURCE_NAME = "com.crashlytics.android.build_id";
  public static final String LEGACY_SHARED_PREFS_NAME = "com.crashlytics.prefs";
  private static final String LOG_PRIORITY_NAME_ASSERT = "A";
  private static final String LOG_PRIORITY_NAME_DEBUG = "D";
  private static final String LOG_PRIORITY_NAME_ERROR = "E";
  private static final String LOG_PRIORITY_NAME_INFO = "I";
  private static final String LOG_PRIORITY_NAME_UNKNOWN = "?";
  private static final String LOG_PRIORITY_NAME_VERBOSE = "V";
  private static final String LOG_PRIORITY_NAME_WARN = "W";
  static final String MAPPING_FILE_ID_RESOURCE_NAME = "com.google.firebase.crashlytics.mapping_file_id";
  private static final String SDK = "sdk";
  private static final String SHA1_INSTANCE = "SHA-1";
  private static final String SHA256_INSTANCE = "SHA-256";
  public static final String SHARED_PREFS_NAME = "com.google.firebase.crashlytics";
  private static final long UNCALCULATED_TOTAL_RAM = -1L;
  private static final String UNITY_EDITOR_VERSION = "com.google.firebase.crashlytics.unity_version";
  private static Boolean clsTrace;
  private static long totalRamInBytes = -1L;
  
  public static long calculateFreeRamInBytes(Context paramContext)
  {
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)paramContext.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem;
  }
  
  public static long calculateUsedDiskSpaceInBytes(String paramString)
  {
    paramString = new StatFs(paramString);
    long l = paramString.getBlockSize();
    return paramString.getBlockCount() * l - l * paramString.getAvailableBlocks();
  }
  
  public static boolean canTryConnection(Context paramContext)
  {
    boolean bool2 = checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE");
    boolean bool1 = true;
    if (bool2)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnectedOrConnecting())) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean checkPermission(Context paramContext, String paramString)
  {
    return paramContext.checkCallingOrSelfPermission(paramString) == 0;
  }
  
  public static void closeOrLog(Closeable paramCloseable, String paramString)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        Logger.getLogger().e(paramString, paramCloseable);
      }
    }
  }
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  static long convertMemInfoToBytes(String paramString1, String paramString2, int paramInt)
  {
    return Long.parseLong(paramString1.split(paramString2)[0].trim()) * paramInt;
  }
  
  public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    for (;;)
    {
      int i = paramInputStream.read(paramArrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
  }
  
  @Deprecated
  public static Cipher createCipher(int paramInt, String paramString)
    throws InvalidKeyException
  {
    throw new InvalidKeyException("This method is deprecated");
  }
  
  public static String createInstanceIdFrom(String... paramVarArgs)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length == 0) {
        return null;
      }
      localObject1 = new ArrayList();
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        if (str != null) {
          ((List)localObject1).add(str.replace("-", "").toLowerCase(Locale.US));
        }
        i += 1;
      }
      Collections.sort((List)localObject1);
      paramVarArgs = new StringBuilder();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramVarArgs.append((String)((Iterator)localObject1).next());
      }
      paramVarArgs = paramVarArgs.toString();
      localObject1 = localObject2;
      if (paramVarArgs.length() > 0) {
        localObject1 = sha1(paramVarArgs);
      }
    }
    return (String)localObject1;
  }
  
  public static byte[] dehexify(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    return arrayOfByte;
  }
  
  /* Error */
  public static String extractFieldFromSystemFile(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 338	java/io/File:exists	()Z
    //   4: istore_2
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore 6
    //   11: iload_2
    //   12: ifeq +198 -> 210
    //   15: new 340	java/io/BufferedReader
    //   18: dup
    //   19: new 342	java/io/FileReader
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 345	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   27: sipush 1024
    //   30: invokespecial 348	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: astore_3
    //   34: aload_3
    //   35: astore 4
    //   37: aload_3
    //   38: invokevirtual 351	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore 7
    //   43: aload_3
    //   44: astore 4
    //   46: aload 6
    //   48: astore 5
    //   50: aload 7
    //   52: ifnull +53 -> 105
    //   55: aload_3
    //   56: astore 4
    //   58: ldc_w 353
    //   61: invokestatic 359	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   64: aload 7
    //   66: iconst_2
    //   67: invokevirtual 362	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;I)[Ljava/lang/String;
    //   70: astore 5
    //   72: aload_3
    //   73: astore 4
    //   75: aload 5
    //   77: arraylength
    //   78: iconst_1
    //   79: if_icmple -45 -> 34
    //   82: aload_3
    //   83: astore 4
    //   85: aload 5
    //   87: iconst_0
    //   88: aaload
    //   89: aload_1
    //   90: invokevirtual 365	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq -59 -> 34
    //   96: aload 5
    //   98: iconst_1
    //   99: aaload
    //   100: astore 5
    //   102: aload_3
    //   103: astore 4
    //   105: aload 4
    //   107: ldc_w 367
    //   110: invokestatic 369	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   113: aload 5
    //   115: areturn
    //   116: astore 4
    //   118: aload_3
    //   119: astore_1
    //   120: aload 4
    //   122: astore_3
    //   123: goto +10 -> 133
    //   126: astore_0
    //   127: goto +73 -> 200
    //   130: astore_3
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_1
    //   134: astore 4
    //   136: invokestatic 203	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   139: astore 5
    //   141: aload_1
    //   142: astore 4
    //   144: new 291	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   151: astore 7
    //   153: aload_1
    //   154: astore 4
    //   156: aload 7
    //   158: ldc_w 371
    //   161: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: astore 4
    //   168: aload 7
    //   170: aload_0
    //   171: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_1
    //   176: astore 4
    //   178: aload 5
    //   180: aload 7
    //   182: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: aload_3
    //   186: invokevirtual 207	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   189: aload_1
    //   190: astore 4
    //   192: aload 6
    //   194: astore 5
    //   196: goto -91 -> 105
    //   199: astore_0
    //   200: aload 4
    //   202: ldc_w 367
    //   205: invokestatic 369	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   208: aload_0
    //   209: athrow
    //   210: aconst_null
    //   211: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	paramFile	File
    //   0	212	1	paramString	String
    //   4	8	2	bool	boolean
    //   33	90	3	localObject1	Object
    //   130	56	3	localException1	Exception
    //   6	100	4	localObject2	Object
    //   116	5	4	localException2	Exception
    //   134	67	4	str	String
    //   48	147	5	localObject3	Object
    //   9	184	6	localObject4	Object
    //   41	140	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   37	43	116	java/lang/Exception
    //   58	72	116	java/lang/Exception
    //   75	82	116	java/lang/Exception
    //   85	96	116	java/lang/Exception
    //   15	34	126	finally
    //   15	34	130	java/lang/Exception
    //   37	43	199	finally
    //   58	72	199	finally
    //   75	82	199	finally
    //   85	96	199	finally
    //   136	141	199	finally
    //   144	153	199	finally
    //   156	165	199	finally
    //   168	175	199	finally
    //   178	189	199	finally
  }
  
  public static void finishAffinity(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.finishAffinity();
      return;
    }
    paramActivity.setResult(paramInt);
    paramActivity.finish();
  }
  
  public static void finishAffinity(Context paramContext, int paramInt)
  {
    if ((paramContext instanceof Activity)) {
      finishAffinity((Activity)paramContext, paramInt);
    }
  }
  
  public static void flushOrLog(Flushable paramFlushable, String paramString)
  {
    if (paramFlushable != null) {
      try
      {
        paramFlushable.flush();
        return;
      }
      catch (IOException paramFlushable)
      {
        Logger.getLogger().e(paramString, paramFlushable);
      }
    }
  }
  
  /* Error */
  public static String getAppIconHashOrNull(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 408	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6: aload_0
    //   7: invokestatic 412	com/google/firebase/crashlytics/internal/common/CommonUtils:getAppIconResourceId	(Landroid/content/Context;)I
    //   10: invokevirtual 418	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   13: astore_2
    //   14: aload_2
    //   15: astore_0
    //   16: aload_2
    //   17: invokestatic 421	com/google/firebase/crashlytics/internal/common/CommonUtils:sha1	(Ljava/io/InputStream;)Ljava/lang/String;
    //   20: astore 4
    //   22: aload_2
    //   23: astore_0
    //   24: aload 4
    //   26: invokestatic 425	com/google/firebase/crashlytics/internal/common/CommonUtils:isNullOrEmpty	(Ljava/lang/String;)Z
    //   29: istore_1
    //   30: iload_1
    //   31: ifeq +8 -> 39
    //   34: aload_3
    //   35: astore_0
    //   36: goto +6 -> 42
    //   39: aload 4
    //   41: astore_0
    //   42: aload_2
    //   43: ldc_w 427
    //   46: invokestatic 369	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   49: aload_0
    //   50: areturn
    //   51: astore_3
    //   52: goto +12 -> 64
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_2
    //   58: goto +73 -> 131
    //   61: astore_3
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_2
    //   65: astore_0
    //   66: invokestatic 203	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   69: astore 4
    //   71: aload_2
    //   72: astore_0
    //   73: new 291	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 292	java/lang/StringBuilder:<init>	()V
    //   80: astore 5
    //   82: aload_2
    //   83: astore_0
    //   84: aload 5
    //   86: ldc_w 429
    //   89: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_2
    //   94: astore_0
    //   95: aload 5
    //   97: aload_3
    //   98: invokevirtual 432	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_2
    //   106: astore_0
    //   107: aload 4
    //   109: aload 5
    //   111: invokevirtual 312	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokevirtual 435	com/google/firebase/crashlytics/internal/Logger:w	(Ljava/lang/String;)V
    //   117: aload_2
    //   118: ldc_w 427
    //   121: invokestatic 369	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   124: aconst_null
    //   125: areturn
    //   126: astore_3
    //   127: aload_0
    //   128: astore_2
    //   129: aload_3
    //   130: astore_0
    //   131: aload_2
    //   132: ldc_w 427
    //   135: invokestatic 369	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   138: aload_0
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramContext	Context
    //   29	2	1	bool	boolean
    //   13	119	2	localObject1	Object
    //   1	34	3	localObject2	Object
    //   51	1	3	localException1	Exception
    //   61	37	3	localException2	Exception
    //   126	4	3	localObject3	Object
    //   20	88	4	localObject4	Object
    //   80	30	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   16	22	51	java/lang/Exception
    //   24	30	51	java/lang/Exception
    //   2	14	55	finally
    //   2	14	61	java/lang/Exception
    //   16	22	126	finally
    //   24	30	126	finally
    //   66	71	126	finally
    //   73	82	126	finally
    //   84	93	126	finally
    //   95	105	126	finally
    //   107	117	126	finally
  }
  
  public static int getAppIconResourceId(Context paramContext)
  {
    return paramContext.getApplicationContext().getApplicationInfo().icon;
  }
  
  public static ActivityManager.RunningAppProcessInfo getAppProcessInfo(String paramString, Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.processName.equals(paramString)) {
          return localRunningAppProcessInfo;
        }
      }
    }
    return null;
  }
  
  public static boolean getBooleanResourceValue(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      Resources localResources = paramContext.getResources();
      if (localResources != null)
      {
        int i = getResourcesIdentifier(paramContext, paramString, "bool");
        if (i > 0) {
          return localResources.getBoolean(i);
        }
        i = getResourcesIdentifier(paramContext, paramString, "string");
        if (i > 0) {
          return Boolean.parseBoolean(paramContext.getString(i));
        }
      }
    }
    return paramBoolean;
  }
  
  public static int getCpuArchitectureInt()
  {
    return Architecture.getValue().ordinal();
  }
  
  public static int getDeviceState(Context paramContext)
  {
    if (isEmulator(paramContext)) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (isRooted(paramContext)) {
      i = j | 0x2;
    }
    int j = i;
    if (isDebuggerAttached()) {
      j = i | 0x4;
    }
    return j;
  }
  
  public static SharedPreferences getLegacySharedPrefs(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.crashlytics.prefs", 0);
  }
  
  public static String getMappingFileId(Context paramContext)
  {
    int j = getResourcesIdentifier(paramContext, "com.google.firebase.crashlytics.mapping_file_id", "string");
    int i = j;
    if (j == 0) {
      i = getResourcesIdentifier(paramContext, "com.crashlytics.android.build_id", "string");
    }
    if (i != 0) {
      return paramContext.getResources().getString(i);
    }
    return null;
  }
  
  public static boolean getProximitySensorEnabled(Context paramContext)
  {
    boolean bool2 = isEmulator(paramContext);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (((SensorManager)paramContext.getSystemService("sensor")).getDefaultSensor(8) != null) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static String getResourcePackageName(Context paramContext)
  {
    int i = paramContext.getApplicationContext().getApplicationInfo().icon;
    if (i > 0) {}
    try
    {
      String str2 = paramContext.getResources().getResourcePackageName(i);
      str1 = str2;
      if (!"android".equals(str2)) {
        break label53;
      }
      str1 = paramContext.getPackageName();
      return str1;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      String str1;
      label53:
      for (;;) {}
    }
    return paramContext.getPackageName();
    str1 = paramContext.getPackageName();
    return str1;
  }
  
  public static int getResourcesIdentifier(Context paramContext, String paramString1, String paramString2)
  {
    return paramContext.getResources().getIdentifier(paramString1, paramString2, getResourcePackageName(paramContext));
  }
  
  public static SharedPreferences getSharedPrefs(Context paramContext)
  {
    return paramContext.getSharedPreferences("com.google.firebase.crashlytics", 0);
  }
  
  public static String getStringsFileValue(Context paramContext, String paramString)
  {
    int i = getResourcesIdentifier(paramContext, paramString, "string");
    if (i > 0) {
      return paramContext.getString(i);
    }
    return "";
  }
  
  public static long getTotalRamInBytes()
  {
    try
    {
      if (totalRamInBytes == -1L)
      {
        long l2 = 0L;
        String str = extractFieldFromSystemFile(new File("/proc/meminfo"), "MemTotal");
        l1 = l2;
        if (!TextUtils.isEmpty(str))
        {
          str = str.toUpperCase(Locale.US);
          try
          {
            if (str.endsWith("KB"))
            {
              l1 = convertMemInfoToBytes(str, "KB", 1024);
            }
            else if (str.endsWith("MB"))
            {
              l1 = convertMemInfoToBytes(str, "MB", 1048576);
            }
            else if (str.endsWith("GB"))
            {
              l1 = convertMemInfoToBytes(str, "GB", 1073741824);
            }
            else
            {
              Logger localLogger = Logger.getLogger();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("Unexpected meminfo format while computing RAM: ");
              ((StringBuilder)localObject2).append(str);
              localLogger.d(((StringBuilder)localObject2).toString());
              l1 = l2;
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            Object localObject2 = Logger.getLogger();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unexpected meminfo format while computing RAM: ");
            localStringBuilder.append(str);
            ((Logger)localObject2).e(localStringBuilder.toString(), localNumberFormatException);
            l1 = l2;
          }
        }
        totalRamInBytes = l1;
      }
      long l1 = totalRamInBytes;
      return l1;
    }
    finally {}
  }
  
  private static String hash(InputStream paramInputStream, String paramString)
  {
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramString.update(arrayOfByte, 0, i);
      }
      paramInputStream = hexify(paramString.digest());
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      Logger.getLogger().e("Could not calculate hash for app icon.", paramInputStream);
    }
    return "";
  }
  
  private static String hash(String paramString1, String paramString2)
  {
    return hash(paramString1.getBytes(), paramString2);
  }
  
  private static String hash(byte[] paramArrayOfByte, String paramString)
  {
    try
    {
      localObject = MessageDigest.getInstance(paramString);
      ((MessageDigest)localObject).update(paramArrayOfByte);
      return hexify(((MessageDigest)localObject).digest());
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      Object localObject = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not create hashing algorithm: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", returning empty string.");
      ((Logger)localObject).e(localStringBuilder.toString(), paramArrayOfByte);
    }
    return "";
  }
  
  public static String hexify(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      char[] arrayOfChar2 = HEX_VALUES;
      arrayOfChar1[k] = arrayOfChar2[(j >>> 4)];
      arrayOfChar1[(k + 1)] = arrayOfChar2[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar1);
  }
  
  public static void hideKeyboard(Context paramContext, View paramView)
  {
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if (paramContext != null) {
      paramContext.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
  }
  
  public static boolean isAppDebuggable(Context paramContext)
  {
    return (paramContext.getApplicationInfo().flags & 0x2) != 0;
  }
  
  public static boolean isClsTrace(Context paramContext)
  {
    if (clsTrace == null) {
      clsTrace = Boolean.valueOf(getBooleanResourceValue(paramContext, "com.crashlytics.Trace", false));
    }
    return clsTrace.booleanValue();
  }
  
  public static boolean isDebuggerAttached()
  {
    return (Debug.isDebuggerConnected()) || (Debug.waitingForDebugger());
  }
  
  public static boolean isEmulator(Context paramContext)
  {
    paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    return ("sdk".equals(Build.PRODUCT)) || ("google_sdk".equals(Build.PRODUCT)) || (paramContext == null);
  }
  
  @Deprecated
  public static boolean isLoggingEnabled(Context paramContext)
  {
    return false;
  }
  
  public static boolean isNullOrEmpty(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
  
  public static boolean isRooted(Context paramContext)
  {
    boolean bool = isEmulator(paramContext);
    paramContext = Build.TAGS;
    if ((!bool) && (paramContext != null) && (paramContext.contains("test-keys"))) {
      return true;
    }
    if (new File("/system/app/Superuser.apk").exists()) {
      return true;
    }
    paramContext = new File("/system/xbin/su");
    return (!bool) && (paramContext.exists());
  }
  
  public static void logControlled(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    if (isClsTrace(paramContext)) {
      Logger.getLogger().log(paramInt, paramString2);
    }
  }
  
  public static void logControlled(Context paramContext, String paramString)
  {
    if (isClsTrace(paramContext)) {
      Logger.getLogger().d(paramString);
    }
  }
  
  public static void logControlledError(Context paramContext, String paramString, Throwable paramThrowable)
  {
    if (isClsTrace(paramContext)) {
      Logger.getLogger().e(paramString);
    }
  }
  
  public static String logPriorityToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "?";
    case 7: 
      return "A";
    case 6: 
      return "E";
    case 5: 
      return "W";
    case 4: 
      return "I";
    case 3: 
      return "D";
    }
    return "V";
  }
  
  public static void openKeyboard(Context paramContext, View paramView)
  {
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    if (paramContext != null) {
      paramContext.showSoftInputFromInputMethod(paramView.getWindowToken(), 0);
    }
  }
  
  public static String padWithZerosToMaxIntWidth(int paramInt)
  {
    if (paramInt >= 0) {
      return String.format(Locale.US, "%1$10s", new Object[] { Integer.valueOf(paramInt) }).replace(' ', '0');
    }
    throw new IllegalArgumentException("value must be zero or greater");
  }
  
  public static String resolveUnityEditorVersion(Context paramContext)
  {
    int i = getResourcesIdentifier(paramContext, "com.google.firebase.crashlytics.unity_version", "string");
    if (i != 0)
    {
      paramContext = paramContext.getResources().getString(i);
      Logger localLogger = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unity Editor version is: ");
      localStringBuilder.append(paramContext);
      localLogger.d(localStringBuilder.toString());
      return paramContext;
    }
    return null;
  }
  
  public static String sha1(InputStream paramInputStream)
  {
    return hash(paramInputStream, "SHA-1");
  }
  
  public static String sha1(String paramString)
  {
    return hash(paramString, "SHA-1");
  }
  
  public static String sha256(String paramString)
  {
    return hash(paramString, "SHA-256");
  }
  
  public static String streamToString(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new Scanner(paramInputStream).useDelimiter("\\A");
    if (paramInputStream.hasNext()) {
      return paramInputStream.next();
    }
    return "";
  }
  
  public static boolean stringsEqualIncludingNull(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if (paramString1 != null) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  static enum Architecture
  {
    private static final Map<String, Architecture> matcher;
    
    static
    {
      ARM_UNKNOWN = new Architecture("ARM_UNKNOWN", 2);
      PPC = new Architecture("PPC", 3);
      PPC64 = new Architecture("PPC64", 4);
      ARMV6 = new Architecture("ARMV6", 5);
      ARMV7 = new Architecture("ARMV7", 6);
      UNKNOWN = new Architecture("UNKNOWN", 7);
      ARMV7S = new Architecture("ARMV7S", 8);
      Object localObject = new Architecture("ARM64", 9);
      ARM64 = (Architecture)localObject;
      $VALUES = new Architecture[] { X86_32, X86_64, ARM_UNKNOWN, PPC, PPC64, ARMV6, ARMV7, UNKNOWN, ARMV7S, localObject };
      localObject = new HashMap(4);
      matcher = (Map)localObject;
      ((Map)localObject).put("armeabi-v7a", ARMV7);
      matcher.put("armeabi", ARMV6);
      matcher.put("arm64-v8a", ARM64);
      matcher.put("x86", X86_32);
    }
    
    private Architecture() {}
    
    static Architecture getValue()
    {
      Object localObject = Build.CPU_ABI;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        Logger.getLogger().d("Architecture#getValue()::Build.CPU_ABI returned null or empty");
        return UNKNOWN;
      }
      localObject = ((String)localObject).toLowerCase(Locale.US);
      Architecture localArchitecture = (Architecture)matcher.get(localObject);
      localObject = localArchitecture;
      if (localArchitecture == null) {
        localObject = UNKNOWN;
      }
      return (Architecture)localObject;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\CommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */