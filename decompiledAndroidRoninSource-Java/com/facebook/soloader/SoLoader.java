package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.soloader.nativeloader.NativeLoader;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import javax.annotation.Nullable;

public class SoLoader
{
  static final boolean DEBUG = false;
  public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
  public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
  public static final int SOLOADER_DONT_TREAT_AS_SYSTEMAPP = 32;
  public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
  public static final int SOLOADER_LOOK_IN_ZIP = 4;
  public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
  private static final String SO_STORE_NAME_MAIN = "lib-main";
  private static final String SO_STORE_NAME_SPLIT = "lib-";
  static final boolean SYSTRACE_LIBRARY_LOADING;
  static final String TAG = "SoLoader";
  private static boolean isSystemApp;
  @Nullable
  private static ApplicationSoSource sApplicationSoSource;
  @Nullable
  private static UnpackingSoSource[] sBackupSoSources;
  private static int sFlags;
  private static final Set<String> sLoadedAndMergedLibraries;
  private static final HashSet<String> sLoadedLibraries;
  private static final Map<String, Object> sLoadingLibraries;
  @Nullable
  static SoFileLoader sSoFileLoader;
  @Nullable
  private static SoSource[] sSoSources;
  private static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
  private static volatile int sSoSourcesVersion;
  @Nullable
  private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper;
  
  static
  {
    sSoSources = null;
    boolean bool = false;
    sSoSourcesVersion = 0;
    sLoadedLibraries = new HashSet();
    sLoadingLibraries = new HashMap();
    sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    sSystemLoadLibraryWrapper = null;
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 18) {
        bool = true;
      }
    }
    catch (NoClassDefFoundError|UnsatisfiedLinkError localNoClassDefFoundError)
    {
      for (;;) {}
    }
    SYSTRACE_LIBRARY_LOADING = bool;
  }
  
  public static boolean areSoSourcesAbisSupported()
  {
    sSoSourcesLock.readLock().lock();
    for (;;)
    {
      String[] arrayOfString;
      int n;
      int j;
      int k;
      boolean bool;
      try
      {
        SoSource[] arrayOfSoSource1 = sSoSources;
        if (arrayOfSoSource1 == null) {
          return false;
        }
        Object localObject3 = SysUtil.getSupportedAbis();
        SoSource[] arrayOfSoSource2 = sSoSources;
        int m = arrayOfSoSource2.length;
        int i = 0;
        if (i < m)
        {
          arrayOfString = arrayOfSoSource2[i].getSoSourceAbis();
          n = arrayOfString.length;
          j = 0;
          break label183;
          if ((k < localObject3.length) && (!bool))
          {
            bool = arrayOfSoSource1.equals(localObject3[k]);
            k += 1;
            continue;
          }
          if (!bool)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("abi not supported: ");
            ((StringBuilder)localObject3).append(arrayOfSoSource1);
            Log.e("SoLoader", ((StringBuilder)localObject3).toString());
            continue;
          }
          j += 1;
          break label183;
          i += 1;
          continue;
        }
        else
        {
          return true;
        }
      }
      finally
      {
        sSoSourcesLock.readLock().unlock();
      }
      label183:
      if (j < n)
      {
        Object localObject2 = arrayOfString[j];
        k = 0;
        bool = false;
      }
    }
  }
  
  private static void assertInitialized()
  {
    if (isInitialized()) {
      return;
    }
    throw new RuntimeException("SoLoader.init() not yet called");
  }
  
  private static boolean checkIfSystemApp(Context paramContext, int paramInt)
  {
    boolean bool2 = false;
    if ((paramInt & 0x20) != 0) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if ((paramContext.getApplicationInfo().flags & 0x81) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void deinitForTest()
  {
    TestOnlyUtils.setSoSources(null);
  }
  
  private static void doLoadLibraryBySoName(String paramString, int paramInt, @Nullable StrictMode.ThreadPolicy paramThreadPolicy)
    throws UnsatisfiedLinkError
  {
    sSoSourcesLock.readLock().lock();
    try
    {
      Object localObject1 = sSoSources;
      if (localObject1 != null)
      {
        sSoSourcesLock.readLock().unlock();
        int i = 0;
        int i1 = 0;
        int m;
        if (paramThreadPolicy == null)
        {
          paramThreadPolicy = StrictMode.allowThreadDiskReads();
          m = 1;
        }
        else
        {
          m = 0;
        }
        if (SYSTRACE_LIBRARY_LOADING) {
          Api18TraceUtils.beginTraceSection("SoLoader.loadLibrary[", paramString, "]");
        }
        try
        {
          sSoSourcesLock.readLock().lock();
          int j = 0;
          int n = 0;
          for (;;)
          {
            i = j;
            if (j == 0)
            {
              int k = j;
              i = j;
              try
              {
                if (n < sSoSources.length)
                {
                  k = j;
                  j = sSoSources[n].loadLibrary(paramString, paramInt, paramThreadPolicy);
                  if (j == 3)
                  {
                    k = j;
                    if (sBackupSoSources != null)
                    {
                      k = j;
                      localObject1 = new StringBuilder();
                      k = j;
                      ((StringBuilder)localObject1).append("Trying backup SoSource for ");
                      k = j;
                      ((StringBuilder)localObject1).append(paramString);
                      k = j;
                      Log.d("SoLoader", ((StringBuilder)localObject1).toString());
                      k = j;
                      localObject1 = sBackupSoSources;
                      k = j;
                      int i2 = localObject1.length;
                      n = 0;
                      for (;;)
                      {
                        i = j;
                        if (n >= i2) {
                          break;
                        }
                        localStringBuilder = localObject1[n];
                        k = j;
                        localStringBuilder.prepare(paramString);
                        k = j;
                        i = localStringBuilder.loadLibrary(paramString, paramInt, paramThreadPolicy);
                        if (i == 1) {
                          break;
                        }
                        n += 1;
                      }
                    }
                  }
                  n += 1;
                }
              }
              finally
              {
                i = k;
                sSoSourcesLock.readLock().unlock();
                i = k;
              }
            }
          }
          try
          {
            sSoSourcesLock.readLock().unlock();
            if (SYSTRACE_LIBRARY_LOADING) {
              Api18TraceUtils.endSection();
            }
            if (m != 0) {
              StrictMode.setThreadPolicy(paramThreadPolicy);
            }
            if ((i != 0) && (i != 3)) {
              break label535;
            }
            paramThreadPolicy = new StringBuilder();
            paramThreadPolicy.append("couldn't find DSO to load: ");
            paramThreadPolicy.append(paramString);
            sSoSourcesLock.readLock().lock();
            paramInt = i1;
            while (paramInt < sSoSources.length)
            {
              paramThreadPolicy.append("\n\tSoSource ");
              paramThreadPolicy.append(paramInt);
              paramThreadPolicy.append(": ");
              paramThreadPolicy.append(sSoSources[paramInt].toString());
              paramInt += 1;
            }
            paramString = sApplicationSoSource;
            if (paramString != null)
            {
              paramString = ApplicationSoSource.getNativeLibDirFromContext(paramString.getUpdatedContext());
              paramThreadPolicy.append("\n\tNative lib dir: ");
              paramThreadPolicy.append(paramString.getAbsolutePath());
              paramThreadPolicy.append("\n");
            }
            sSoSourcesLock.readLock().unlock();
            paramThreadPolicy.append(" result: ");
            paramThreadPolicy.append(i);
            paramString = paramThreadPolicy.toString();
            Log.e("SoLoader", paramString);
            throw new UnsatisfiedLinkError(paramString);
          }
          finally {}
          if (!SYSTRACE_LIBRARY_LOADING) {
            break label514;
          }
        }
        finally {}
        Api18TraceUtils.endSection();
        label514:
        if (m != 0) {
          StrictMode.setThreadPolicy(paramThreadPolicy);
        }
        if ((i != 0) && (i != 3)) {
          label535:
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("couldn't find DSO to load: ");
        localStringBuilder.append(paramString);
        paramThreadPolicy = ((Throwable)localObject4).getMessage();
        paramString = paramThreadPolicy;
        if (paramThreadPolicy == null) {
          paramString = ((Throwable)localObject4).toString();
        }
        localStringBuilder.append(" caused by: ");
        localStringBuilder.append(paramString);
        ((Throwable)localObject4).printStackTrace();
        localStringBuilder.append(" result: ");
        localStringBuilder.append(i);
        paramString = localStringBuilder.toString();
        Log.e("SoLoader", paramString);
        throw new UnsatisfiedLinkError(paramString);
      }
      paramThreadPolicy = new StringBuilder();
      paramThreadPolicy.append("Could not load: ");
      paramThreadPolicy.append(paramString);
      paramThreadPolicy.append(" because no SO source exists");
      Log.e("SoLoader", paramThreadPolicy.toString());
      paramThreadPolicy = new StringBuilder();
      paramThreadPolicy.append("couldn't find DSO to load: ");
      paramThreadPolicy.append(paramString);
      throw new UnsatisfiedLinkError(paramThreadPolicy.toString());
    }
    finally
    {
      sSoSourcesLock.readLock().unlock();
    }
  }
  
  @Nullable
  public static String[] getLibraryDependencies(String paramString)
    throws IOException
  {
    sSoSourcesLock.readLock().lock();
    try
    {
      SoSource[] arrayOfSoSource = sSoSources;
      Object localObject = null;
      String[] arrayOfString = null;
      if (arrayOfSoSource != null)
      {
        int i = 0;
        for (;;)
        {
          localObject = arrayOfString;
          if (arrayOfString != null) {
            break;
          }
          localObject = arrayOfString;
          if (i >= sSoSources.length) {
            break;
          }
          arrayOfString = sSoSources[i].getLibraryDependencies(paramString);
          i += 1;
        }
      }
      return (String[])localObject;
    }
    finally
    {
      sSoSourcesLock.readLock().unlock();
    }
  }
  
  @Nullable
  public static String getLibraryPath(String paramString)
    throws IOException
  {
    sSoSourcesLock.readLock().lock();
    try
    {
      SoSource[] arrayOfSoSource = sSoSources;
      Object localObject = null;
      String str = null;
      if (arrayOfSoSource != null)
      {
        int i = 0;
        for (;;)
        {
          localObject = str;
          if (str != null) {
            break;
          }
          localObject = str;
          if (i >= sSoSources.length) {
            break;
          }
          str = sSoSources[i].getLibraryPath(paramString);
          i += 1;
        }
      }
      return (String)localObject;
    }
    finally
    {
      sSoSourcesLock.readLock().unlock();
    }
  }
  
  @Nullable
  private static Method getNativeLoadRuntimeMethod()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (Build.VERSION.SDK_INT > 27) {
        return null;
      }
      try
      {
        Method localMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[] { String.class, ClassLoader.class, String.class });
        localMethod.setAccessible(true);
        return localMethod;
      }
      catch (SecurityException localSecurityException) {}catch (NoSuchMethodException localNoSuchMethodException) {}
      Log.w("SoLoader", "Cannot get nativeLoad method", localNoSuchMethodException);
    }
    return null;
  }
  
  public static int getSoSourcesVersion()
  {
    return sSoSourcesVersion;
  }
  
  public static void init(Context paramContext, int paramInt)
    throws IOException
  {
    init(paramContext, paramInt, null);
  }
  
  public static void init(Context paramContext, int paramInt, @Nullable SoFileLoader paramSoFileLoader)
    throws IOException
  {
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskWrites();
    try
    {
      isSystemApp = checkIfSystemApp(paramContext, paramInt);
      initSoLoader(paramSoFileLoader);
      initSoSources(paramContext, paramInt, paramSoFileLoader);
      if (!NativeLoader.isInitialized()) {
        NativeLoader.init(new NativeLoaderToSoLoaderDelegate());
      }
      return;
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
  }
  
  public static void init(Context paramContext, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 0;
    }
    try
    {
      init(paramContext, i);
      return;
    }
    catch (IOException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
  }
  
  private static void initSoLoader(@Nullable final SoFileLoader paramSoFileLoader)
  {
    if (paramSoFileLoader != null) {}
    try
    {
      sSoFileLoader = paramSoFileLoader;
      return;
    }
    finally {}
    final Runtime localRuntime = Runtime.getRuntime();
    final Method localMethod = getNativeLoadRuntimeMethod();
    boolean bool;
    if (localMethod != null)
    {
      bool = true;
      if (!bool) {
        break label76;
      }
      paramSoFileLoader = Api14Utils.getClassLoaderLdLoadLibrary();
    }
    for (;;)
    {
      sSoFileLoader = new SoFileLoader()
      {
        /* Error */
        private String getLibHash(String paramAnonymousString)
        {
          // Byte code:
          //   0: new 46	java/io/File
          //   3: dup
          //   4: aload_1
          //   5: invokespecial 49	java/io/File:<init>	(Ljava/lang/String;)V
          //   8: astore_1
          //   9: ldc 51
          //   11: invokestatic 57	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
          //   14: astore_3
          //   15: new 59	java/io/FileInputStream
          //   18: dup
          //   19: aload_1
          //   20: invokespecial 62	java/io/FileInputStream:<init>	(Ljava/io/File;)V
          //   23: astore_1
          //   24: sipush 4096
          //   27: newarray <illegal type>
          //   29: astore 4
          //   31: aload_1
          //   32: aload 4
          //   34: invokevirtual 68	java/io/InputStream:read	([B)I
          //   37: istore_2
          //   38: iload_2
          //   39: ifle +14 -> 53
          //   42: aload_3
          //   43: aload 4
          //   45: iconst_0
          //   46: iload_2
          //   47: invokevirtual 72	java/security/MessageDigest:update	([BII)V
          //   50: goto -19 -> 31
          //   53: ldc 74
          //   55: iconst_1
          //   56: anewarray 4	java/lang/Object
          //   59: dup
          //   60: iconst_0
          //   61: new 76	java/math/BigInteger
          //   64: dup
          //   65: iconst_1
          //   66: aload_3
          //   67: invokevirtual 80	java/security/MessageDigest:digest	()[B
          //   70: invokespecial 83	java/math/BigInteger:<init>	(I[B)V
          //   73: aastore
          //   74: invokestatic 89	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
          //   77: astore_3
          //   78: aload_1
          //   79: invokevirtual 92	java/io/InputStream:close	()V
          //   82: aload_3
          //   83: areturn
          //   84: astore_3
          //   85: aload_3
          //   86: athrow
          //   87: astore 4
          //   89: aload_1
          //   90: invokevirtual 92	java/io/InputStream:close	()V
          //   93: goto +9 -> 102
          //   96: astore_1
          //   97: aload_3
          //   98: aload_1
          //   99: invokevirtual 98	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
          //   102: aload 4
          //   104: athrow
          //   105: astore_1
          //   106: aload_1
          //   107: invokevirtual 102	java/security/NoSuchAlgorithmException:toString	()Ljava/lang/String;
          //   110: areturn
          //   111: astore_1
          //   112: aload_1
          //   113: invokevirtual 103	java/lang/SecurityException:toString	()Ljava/lang/String;
          //   116: areturn
          //   117: astore_1
          //   118: aload_1
          //   119: invokevirtual 104	java/io/IOException:toString	()Ljava/lang/String;
          //   122: areturn
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	123	0	this	1
          //   0	123	1	paramAnonymousString	String
          //   37	10	2	i	int
          //   14	69	3	localObject1	Object
          //   84	14	3	localObject2	Object
          //   29	15	4	arrayOfByte	byte[]
          //   87	16	4	localObject3	Object
          // Exception table:
          //   from	to	target	type
          //   24	31	84	finally
          //   31	38	84	finally
          //   42	50	84	finally
          //   53	78	84	finally
          //   85	87	87	finally
          //   89	93	96	finally
          //   0	24	105	java/security/NoSuchAlgorithmException
          //   78	82	105	java/security/NoSuchAlgorithmException
          //   97	102	105	java/security/NoSuchAlgorithmException
          //   102	105	105	java/security/NoSuchAlgorithmException
          //   0	24	111	java/lang/SecurityException
          //   78	82	111	java/lang/SecurityException
          //   97	102	111	java/lang/SecurityException
          //   102	105	111	java/lang/SecurityException
          //   0	24	117	java/io/IOException
          //   78	82	117	java/io/IOException
          //   97	102	117	java/io/IOException
          //   102	105	117	java/io/IOException
        }
        
        /* Error */
        public void load(String paramAnonymousString, int paramAnonymousInt)
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 24	com/facebook/soloader/SoLoader$1:val$hasNativeLoadMethod	Z
          //   4: ifeq +426 -> 430
          //   7: iload_2
          //   8: iconst_4
          //   9: iand
          //   10: iconst_4
          //   11: if_icmpne +8 -> 19
          //   14: iconst_1
          //   15: istore_2
          //   16: goto +5 -> 21
          //   19: iconst_0
          //   20: istore_2
          //   21: iload_2
          //   22: ifeq +11 -> 33
          //   25: aload_0
          //   26: getfield 26	com/facebook/soloader/SoLoader$1:val$localLdLibraryPath	Ljava/lang/String;
          //   29: astore_3
          //   30: goto +8 -> 38
          //   33: aload_0
          //   34: getfield 28	com/facebook/soloader/SoLoader$1:val$localLdLibraryPathNoZips	Ljava/lang/String;
          //   37: astore_3
          //   38: aload_0
          //   39: getfield 30	com/facebook/soloader/SoLoader$1:val$runtime	Ljava/lang/Runtime;
          //   42: astore 8
          //   44: aload 8
          //   46: monitorenter
          //   47: aload_0
          //   48: getfield 32	com/facebook/soloader/SoLoader$1:val$nativeLoadRuntimeMethod	Ljava/lang/reflect/Method;
          //   51: aload_0
          //   52: getfield 30	com/facebook/soloader/SoLoader$1:val$runtime	Ljava/lang/Runtime;
          //   55: iconst_3
          //   56: anewarray 4	java/lang/Object
          //   59: dup
          //   60: iconst_0
          //   61: aload_1
          //   62: aastore
          //   63: dup
          //   64: iconst_1
          //   65: ldc 8
          //   67: invokevirtual 118	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
          //   70: aastore
          //   71: dup
          //   72: iconst_2
          //   73: aload_3
          //   74: aastore
          //   75: invokevirtual 124	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
          //   78: checkcast 85	java/lang/String
          //   81: astore 4
          //   83: aload 4
          //   85: ifnonnull +89 -> 174
          //   88: aload 4
          //   90: astore 5
          //   92: aload_3
          //   93: astore 7
          //   95: aload 8
          //   97: monitorexit
          //   98: aload 4
          //   100: ifnull +334 -> 434
          //   103: new 126	java/lang/StringBuilder
          //   106: dup
          //   107: invokespecial 127	java/lang/StringBuilder:<init>	()V
          //   110: astore 5
          //   112: aload 5
          //   114: ldc -127
          //   116: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   119: pop
          //   120: aload 5
          //   122: aload 4
          //   124: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   127: pop
          //   128: aload 5
          //   130: ldc -121
          //   132: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   135: pop
          //   136: aload 5
          //   138: aload_0
          //   139: aload_1
          //   140: invokespecial 137	com/facebook/soloader/SoLoader$1:getLibHash	(Ljava/lang/String;)Ljava/lang/String;
          //   143: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   146: pop
          //   147: aload 5
          //   149: ldc -117
          //   151: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   154: pop
          //   155: aload 5
          //   157: aload_3
          //   158: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   161: pop
          //   162: ldc -115
          //   164: aload 5
          //   166: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   169: invokestatic 148	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
          //   172: pop
          //   173: return
          //   174: aload 4
          //   176: astore 5
          //   178: aload_3
          //   179: astore 7
          //   181: new 150	java/lang/UnsatisfiedLinkError
          //   184: dup
          //   185: aload 4
          //   187: invokespecial 151	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
          //   190: athrow
          //   191: aload 4
          //   193: astore 5
          //   195: aload_3
          //   196: astore 7
          //   198: aload 8
          //   200: monitorexit
          //   201: aload 4
          //   203: astore 5
          //   205: aload_3
          //   206: astore 7
          //   208: aload 6
          //   210: athrow
          //   211: astore 6
          //   213: goto +56 -> 269
          //   216: astore 6
          //   218: goto +51 -> 269
          //   221: astore 6
          //   223: goto +46 -> 269
          //   226: astore 6
          //   228: aload 5
          //   230: astore 4
          //   232: aload 7
          //   234: astore_3
          //   235: goto -44 -> 191
          //   238: astore 4
          //   240: aconst_null
          //   241: astore 5
          //   243: goto +109 -> 352
          //   246: astore 4
          //   248: goto +10 -> 258
          //   251: astore 4
          //   253: goto +5 -> 258
          //   256: astore 4
          //   258: aconst_null
          //   259: astore 5
          //   261: aload 4
          //   263: astore 6
          //   265: aload 5
          //   267: astore 4
          //   269: aload 4
          //   271: astore 5
          //   273: aload_3
          //   274: astore 7
          //   276: new 126	java/lang/StringBuilder
          //   279: dup
          //   280: invokespecial 127	java/lang/StringBuilder:<init>	()V
          //   283: astore 8
          //   285: aload 4
          //   287: astore 5
          //   289: aload_3
          //   290: astore 7
          //   292: aload 8
          //   294: ldc -103
          //   296: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   299: pop
          //   300: aload 4
          //   302: astore 5
          //   304: aload_3
          //   305: astore 7
          //   307: aload 8
          //   309: aload_1
          //   310: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   313: pop
          //   314: aload 4
          //   316: astore 5
          //   318: aload_3
          //   319: astore 7
          //   321: aload 8
          //   323: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   326: astore 4
          //   328: aload 4
          //   330: astore 5
          //   332: aload_3
          //   333: astore 7
          //   335: new 155	java/lang/RuntimeException
          //   338: dup
          //   339: aload 4
          //   341: aload 6
          //   343: invokespecial 158	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
          //   346: athrow
          //   347: astore 4
          //   349: aload 7
          //   351: astore_3
          //   352: aload 5
          //   354: ifnull +73 -> 427
          //   357: new 126	java/lang/StringBuilder
          //   360: dup
          //   361: invokespecial 127	java/lang/StringBuilder:<init>	()V
          //   364: astore 6
          //   366: aload 6
          //   368: ldc -127
          //   370: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   373: pop
          //   374: aload 6
          //   376: aload 5
          //   378: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   381: pop
          //   382: aload 6
          //   384: ldc -121
          //   386: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   389: pop
          //   390: aload 6
          //   392: aload_0
          //   393: aload_1
          //   394: invokespecial 137	com/facebook/soloader/SoLoader$1:getLibHash	(Ljava/lang/String;)Ljava/lang/String;
          //   397: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   400: pop
          //   401: aload 6
          //   403: ldc -117
          //   405: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   408: pop
          //   409: aload 6
          //   411: aload_3
          //   412: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   415: pop
          //   416: ldc -115
          //   418: aload 6
          //   420: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   423: invokestatic 148	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
          //   426: pop
          //   427: aload 4
          //   429: athrow
          //   430: aload_1
          //   431: invokestatic 162	java/lang/System:load	(Ljava/lang/String;)V
          //   434: return
          //   435: astore 6
          //   437: aconst_null
          //   438: astore 4
          //   440: goto -249 -> 191
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	443	0	this	1
          //   0	443	1	paramAnonymousString	String
          //   0	443	2	paramAnonymousInt	int
          //   29	383	3	localObject1	Object
          //   81	150	4	localObject2	Object
          //   238	1	4	localObject3	Object
          //   246	1	4	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
          //   251	1	4	localIllegalArgumentException1	IllegalArgumentException
          //   256	6	4	localIllegalAccessException1	IllegalAccessException
          //   267	73	4	localObject4	Object
          //   347	81	4	localObject5	Object
          //   438	1	4	localObject6	Object
          //   90	287	5	localObject7	Object
          //   208	1	6	localObject8	Object
          //   211	1	6	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
          //   216	1	6	localIllegalArgumentException2	IllegalArgumentException
          //   221	1	6	localIllegalAccessException2	IllegalAccessException
          //   226	1	6	localObject9	Object
          //   263	156	6	localObject10	Object
          //   435	1	6	localObject11	Object
          //   93	257	7	localObject12	Object
          //   42	280	8	localObject13	Object
          // Exception table:
          //   from	to	target	type
          //   208	211	211	java/lang/reflect/InvocationTargetException
          //   208	211	216	java/lang/IllegalArgumentException
          //   208	211	221	java/lang/IllegalAccessException
          //   95	98	226	finally
          //   181	191	226	finally
          //   198	201	226	finally
          //   38	47	238	finally
          //   38	47	246	java/lang/reflect/InvocationTargetException
          //   38	47	251	java/lang/IllegalArgumentException
          //   38	47	256	java/lang/IllegalAccessException
          //   208	211	347	finally
          //   276	285	347	finally
          //   292	300	347	finally
          //   307	314	347	finally
          //   321	328	347	finally
          //   335	347	347	finally
          //   47	83	435	finally
        }
      };
      return;
      bool = false;
      break;
      label76:
      paramSoFileLoader = null;
    }
  }
  
  private static void initSoSources(Context paramContext, int paramInt, @Nullable SoFileLoader paramSoFileLoader)
    throws IOException
  {
    sSoSourcesLock.writeLock().lock();
    for (;;)
    {
      try
      {
        if (sSoSources == null)
        {
          Log.d("SoLoader", "init start");
          sFlags = paramInt;
          ArrayList localArrayList = new ArrayList();
          Object localObject1 = System.getenv("LD_LIBRARY_PATH");
          paramSoFileLoader = (SoFileLoader)localObject1;
          if (localObject1 == null)
          {
            if (!SysUtil.is64Bit()) {
              break label755;
            }
            paramSoFileLoader = "/vendor/lib64:/system/lib64";
          }
          paramSoFileLoader = paramSoFileLoader.split(":");
          int j = paramSoFileLoader.length;
          int i = 0;
          Object localObject2;
          if (i < j)
          {
            localObject1 = paramSoFileLoader[i];
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("adding system library source: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            Log.d("SoLoader", ((StringBuilder)localObject2).toString());
            localArrayList.add(new DirectorySoSource(new File((String)localObject1), 2));
            i += 1;
            continue;
          }
          if (paramContext != null) {
            if ((paramInt & 0x1) != 0)
            {
              sBackupSoSources = null;
              Log.d("SoLoader", "adding exo package source: lib-main");
              localArrayList.add(0, new ExoSoSource(paramContext, "lib-main"));
            }
            else
            {
              if (isSystemApp)
              {
                paramInt = 0;
              }
              else
              {
                if (Build.VERSION.SDK_INT > 17) {
                  break label762;
                }
                paramInt = 1;
                sApplicationSoSource = new ApplicationSoSource(paramContext, paramInt);
                paramSoFileLoader = new StringBuilder();
                paramSoFileLoader.append("adding application source: ");
                paramSoFileLoader.append(sApplicationSoSource.toString());
                Log.d("SoLoader", paramSoFileLoader.toString());
                localArrayList.add(0, sApplicationSoSource);
                paramInt = 1;
              }
              if ((sFlags & 0x8) != 0)
              {
                sBackupSoSources = null;
              }
              else
              {
                localObject1 = new File(paramContext.getApplicationInfo().sourceDir);
                paramSoFileLoader = new ArrayList();
                localObject1 = new ApkSoSource(paramContext, (File)localObject1, "lib-main", paramInt);
                paramSoFileLoader.add(localObject1);
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("adding backup source from : ");
                ((StringBuilder)localObject2).append(((ApkSoSource)localObject1).toString());
                Log.d("SoLoader", ((StringBuilder)localObject2).toString());
                if ((Build.VERSION.SDK_INT >= 21) && (paramContext.getApplicationInfo().splitSourceDirs != null))
                {
                  Log.d("SoLoader", "adding backup sources from split apks");
                  localObject1 = paramContext.getApplicationInfo().splitSourceDirs;
                  int k = localObject1.length;
                  j = 0;
                  i = 0;
                  if (j < k)
                  {
                    localObject2 = new File(localObject1[j]);
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("lib-");
                    localStringBuilder.append(i);
                    localObject2 = new ApkSoSource(paramContext, (File)localObject2, localStringBuilder.toString(), paramInt);
                    localStringBuilder = new StringBuilder();
                    localStringBuilder.append("adding backup source: ");
                    localStringBuilder.append(((ApkSoSource)localObject2).toString());
                    Log.d("SoLoader", localStringBuilder.toString());
                    paramSoFileLoader.add(localObject2);
                    j += 1;
                    i += 1;
                    continue;
                  }
                }
                sBackupSoSources = (UnpackingSoSource[])paramSoFileLoader.toArray(new UnpackingSoSource[paramSoFileLoader.size()]);
                localArrayList.addAll(0, paramSoFileLoader);
              }
            }
          }
          paramContext = (SoSource[])localArrayList.toArray(new SoSource[localArrayList.size()]);
          j = makePrepareFlags();
          paramInt = paramContext.length;
          i = paramInt - 1;
          if (paramInt > 0)
          {
            paramSoFileLoader = new StringBuilder();
            paramSoFileLoader.append("Preparing SO source: ");
            paramSoFileLoader.append(paramContext[i]);
            Log.d("SoLoader", paramSoFileLoader.toString());
            paramContext[i].prepare(j);
            paramInt = i;
            continue;
          }
          sSoSources = paramContext;
          sSoSourcesVersion += 1;
          paramContext = new StringBuilder();
          paramContext.append("init finish: ");
          paramContext.append(sSoSources.length);
          paramContext.append(" SO sources prepared");
          Log.d("SoLoader", paramContext.toString());
        }
        else
        {
          return;
        }
      }
      finally
      {
        Log.d("SoLoader", "init exiting");
        sSoSourcesLock.writeLock().unlock();
      }
      label755:
      paramSoFileLoader = "/vendor/lib:/system/lib";
      continue;
      label762:
      paramInt = 0;
    }
  }
  
  public static boolean isInitialized()
  {
    sSoSourcesLock.readLock().lock();
    try
    {
      SoSource[] arrayOfSoSource = sSoSources;
      boolean bool;
      if (arrayOfSoSource != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      sSoSourcesLock.readLock().unlock();
    }
  }
  
  public static boolean loadLibrary(String paramString)
  {
    return loadLibrary(paramString, 0);
  }
  
  public static boolean loadLibrary(String paramString, int paramInt)
    throws UnsatisfiedLinkError
  {
    sSoSourcesLock.readLock().lock();
    try
    {
      if (sSoSources == null) {
        if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
          assertInitialized();
        } else {
          try
          {
            boolean bool = sLoadedLibraries.contains(paramString) ^ true;
            if (bool) {
              if (sSystemLoadLibraryWrapper != null) {
                sSystemLoadLibraryWrapper.loadLibrary(paramString);
              } else {
                System.loadLibrary(paramString);
              }
            }
            return bool;
          }
          finally {}
        }
      }
      sSoSourcesLock.readLock().unlock();
      Object localObject;
      if (isSystemApp)
      {
        localObject = sSystemLoadLibraryWrapper;
        if (localObject != null)
        {
          ((SystemLoadLibraryWrapper)localObject).loadLibrary(paramString);
          return true;
        }
      }
      String str = MergedSoMapping.mapLibName(paramString);
      if (str != null) {
        localObject = str;
      } else {
        localObject = paramString;
      }
      return loadLibraryBySoName(System.mapLibraryName((String)localObject), paramString, str, paramInt, null);
    }
    finally
    {
      sSoSourcesLock.readLock().unlock();
    }
  }
  
  static void loadLibraryBySoName(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    loadLibraryBySoNameImpl(paramString, null, null, paramInt, paramThreadPolicy);
  }
  
  /* Error */
  private static boolean loadLibraryBySoName(String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt, @Nullable StrictMode.ThreadPolicy paramThreadPolicy)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_0
    //   4: aload_1
    //   5: aload_2
    //   6: iload_3
    //   7: aload 4
    //   9: invokestatic 536	com/facebook/soloader/SoLoader:loadLibraryBySoNameImpl	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/os/StrictMode$ThreadPolicy;)Z
    //   12: istore 8
    //   14: iconst_0
    //   15: istore 5
    //   17: goto +121 -> 138
    //   20: astore 9
    //   22: getstatic 84	com/facebook/soloader/SoLoader:sSoSourcesVersion	I
    //   25: istore 6
    //   27: getstatic 80	com/facebook/soloader/SoLoader:sSoSourcesLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   30: invokevirtual 395	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   33: invokevirtual 398	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   36: getstatic 259	com/facebook/soloader/SoLoader:sApplicationSoSource	Lcom/facebook/soloader/ApplicationSoSource;
    //   39: astore 10
    //   41: iconst_1
    //   42: istore 5
    //   44: aload 10
    //   46: ifnull +68 -> 114
    //   49: getstatic 259	com/facebook/soloader/SoLoader:sApplicationSoSource	Lcom/facebook/soloader/ApplicationSoSource;
    //   52: invokevirtual 539	com/facebook/soloader/ApplicationSoSource:checkAndMaybeUpdate	()Z
    //   55: ifeq +59 -> 114
    //   58: new 159	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   65: astore 10
    //   67: aload 10
    //   69: ldc_w 541
    //   72: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 10
    //   78: aload_0
    //   79: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 10
    //   85: ldc_w 543
    //   88: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: ldc 42
    //   94: aload 10
    //   96: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 545	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   102: pop
    //   103: getstatic 84	com/facebook/soloader/SoLoader:sSoSourcesVersion	I
    //   106: iconst_1
    //   107: iadd
    //   108: putstatic 84	com/facebook/soloader/SoLoader:sSoSourcesVersion	I
    //   111: goto +6 -> 117
    //   114: iconst_0
    //   115: istore 5
    //   117: getstatic 80	com/facebook/soloader/SoLoader:sSoSourcesLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   120: invokevirtual 395	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   123: invokevirtual 498	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   126: getstatic 84	com/facebook/soloader/SoLoader:sSoSourcesVersion	I
    //   129: iload 6
    //   131: if_icmpeq +19 -> 150
    //   134: iload 7
    //   136: istore 8
    //   138: iload 8
    //   140: istore 7
    //   142: iload 5
    //   144: ifne -141 -> 3
    //   147: iload 8
    //   149: ireturn
    //   150: aload 9
    //   152: athrow
    //   153: astore_0
    //   154: goto +13 -> 167
    //   157: astore_0
    //   158: new 182	java/lang/RuntimeException
    //   161: dup
    //   162: aload_0
    //   163: invokespecial 374	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   166: athrow
    //   167: getstatic 80	com/facebook/soloader/SoLoader:sSoSourcesLock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   170: invokevirtual 395	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   173: invokevirtual 498	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   176: aload_0
    //   177: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramString1	String
    //   0	178	1	paramString2	String
    //   0	178	2	paramString3	String
    //   0	178	3	paramInt	int
    //   0	178	4	paramThreadPolicy	StrictMode.ThreadPolicy
    //   15	128	5	i	int
    //   25	107	6	j	int
    //   1	140	7	bool1	boolean
    //   12	136	8	bool2	boolean
    //   20	131	9	localUnsatisfiedLinkError	UnsatisfiedLinkError
    //   39	56	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	14	20	java/lang/UnsatisfiedLinkError
    //   36	41	153	finally
    //   49	111	153	finally
    //   158	167	153	finally
    //   36	41	157	java/io/IOException
    //   49	111	157	java/io/IOException
  }
  
  /* Error */
  private static boolean loadLibraryBySoNameImpl(String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt, @Nullable StrictMode.ThreadPolicy paramThreadPolicy)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 551	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 7
    //   9: iload 8
    //   11: ifne +17 -> 28
    //   14: getstatic 105	com/facebook/soloader/SoLoader:sLoadedAndMergedLibraries	Ljava/util/Set;
    //   17: aload_1
    //   18: invokeinterface 554 2 0
    //   23: ifeq +5 -> 28
    //   26: iconst_0
    //   27: ireturn
    //   28: ldc 2
    //   30: monitorenter
    //   31: getstatic 89	com/facebook/soloader/SoLoader:sLoadedLibraries	Ljava/util/HashSet;
    //   34: aload_0
    //   35: invokevirtual 516	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   38: ifeq +503 -> 541
    //   41: aload_2
    //   42: ifnonnull +493 -> 535
    //   45: ldc 2
    //   47: monitorexit
    //   48: iconst_0
    //   49: ireturn
    //   50: getstatic 94	com/facebook/soloader/SoLoader:sLoadingLibraries	Ljava/util/Map;
    //   53: aload_0
    //   54: invokeinterface 559 2 0
    //   59: ifeq +17 -> 76
    //   62: getstatic 94	com/facebook/soloader/SoLoader:sLoadingLibraries	Ljava/util/Map;
    //   65: aload_0
    //   66: invokeinterface 563 2 0
    //   71: astore 9
    //   73: goto +24 -> 97
    //   76: new 4	java/lang/Object
    //   79: dup
    //   80: invokespecial 116	java/lang/Object:<init>	()V
    //   83: astore 9
    //   85: getstatic 94	com/facebook/soloader/SoLoader:sLoadingLibraries	Ljava/util/Map;
    //   88: aload_0
    //   89: aload 9
    //   91: invokeinterface 567 3 0
    //   96: pop
    //   97: ldc 2
    //   99: monitorexit
    //   100: aload 9
    //   102: monitorenter
    //   103: iload 5
    //   105: istore 6
    //   107: iload 5
    //   109: ifne +197 -> 306
    //   112: ldc 2
    //   114: monitorenter
    //   115: getstatic 89	com/facebook/soloader/SoLoader:sLoadedLibraries	Ljava/util/HashSet;
    //   118: aload_0
    //   119: invokevirtual 516	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   122: ifeq +18 -> 140
    //   125: aload_2
    //   126: ifnonnull +11 -> 137
    //   129: ldc 2
    //   131: monitorexit
    //   132: aload 9
    //   134: monitorexit
    //   135: iconst_0
    //   136: ireturn
    //   137: iconst_1
    //   138: istore 5
    //   140: ldc 2
    //   142: monitorexit
    //   143: iload 5
    //   145: istore 6
    //   147: iload 5
    //   149: ifne +157 -> 306
    //   152: new 159	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   159: astore 10
    //   161: aload 10
    //   163: ldc_w 569
    //   166: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 10
    //   172: aload_0
    //   173: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc 42
    //   179: aload 10
    //   181: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 234	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   187: pop
    //   188: aload_0
    //   189: iload_3
    //   190: aload 4
    //   192: invokestatic 571	com/facebook/soloader/SoLoader:doLoadLibraryBySoName	(Ljava/lang/String;ILandroid/os/StrictMode$ThreadPolicy;)V
    //   195: ldc 2
    //   197: monitorenter
    //   198: new 159	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   205: astore 4
    //   207: aload 4
    //   209: ldc_w 573
    //   212: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 4
    //   218: aload_0
    //   219: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: ldc 42
    //   225: aload 4
    //   227: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 234	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   233: pop
    //   234: getstatic 89	com/facebook/soloader/SoLoader:sLoadedLibraries	Ljava/util/HashSet;
    //   237: aload_0
    //   238: invokevirtual 574	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   241: pop
    //   242: ldc 2
    //   244: monitorexit
    //   245: iload 5
    //   247: istore 6
    //   249: goto +57 -> 306
    //   252: astore_0
    //   253: ldc 2
    //   255: monitorexit
    //   256: aload_0
    //   257: athrow
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 575	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   263: astore_1
    //   264: aload_1
    //   265: ifnull +33 -> 298
    //   268: aload_1
    //   269: ldc_w 577
    //   272: invokevirtual 579	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   275: ifeq +23 -> 298
    //   278: new 14	com/facebook/soloader/SoLoader$WrongAbiError
    //   281: dup
    //   282: aload_0
    //   283: aload_1
    //   284: aload_1
    //   285: ldc_w 577
    //   288: invokevirtual 583	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   291: invokevirtual 587	java/lang/String:substring	(I)Ljava/lang/String;
    //   294: invokespecial 590	com/facebook/soloader/SoLoader$WrongAbiError:<init>	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   297: athrow
    //   298: aload_0
    //   299: athrow
    //   300: astore_0
    //   301: ldc 2
    //   303: monitorexit
    //   304: aload_0
    //   305: athrow
    //   306: iload_3
    //   307: bipush 16
    //   309: iand
    //   310: ifne +205 -> 515
    //   313: iload 7
    //   315: istore_3
    //   316: aload_1
    //   317: invokestatic 551	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   320: ifne +20 -> 340
    //   323: iload 7
    //   325: istore_3
    //   326: getstatic 105	com/facebook/soloader/SoLoader:sLoadedAndMergedLibraries	Ljava/util/Set;
    //   329: aload_1
    //   330: invokeinterface 554 2 0
    //   335: ifeq +5 -> 340
    //   338: iconst_1
    //   339: istore_3
    //   340: aload_2
    //   341: ifnull +174 -> 515
    //   344: iload_3
    //   345: ifne +170 -> 515
    //   348: getstatic 114	com/facebook/soloader/SoLoader:SYSTRACE_LIBRARY_LOADING	Z
    //   351: ifeq +12 -> 363
    //   354: ldc_w 592
    //   357: aload_1
    //   358: ldc -39
    //   360: invokestatic 223	com/facebook/soloader/Api18TraceUtils:beginTraceSection	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   363: new 159	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   370: astore_2
    //   371: aload_2
    //   372: ldc_w 594
    //   375: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_2
    //   380: aload_1
    //   381: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_2
    //   386: ldc_w 596
    //   389: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload_2
    //   394: aload_0
    //   395: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: ldc 42
    //   401: aload_2
    //   402: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 234	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   408: pop
    //   409: aload_1
    //   410: invokestatic 599	com/facebook/soloader/MergedSoMapping:invokeJniOnload	(Ljava/lang/String;)V
    //   413: getstatic 105	com/facebook/soloader/SoLoader:sLoadedAndMergedLibraries	Ljava/util/Set;
    //   416: aload_1
    //   417: invokeinterface 600 2 0
    //   422: pop
    //   423: getstatic 114	com/facebook/soloader/SoLoader:SYSTRACE_LIBRARY_LOADING	Z
    //   426: ifeq +89 -> 515
    //   429: invokestatic 243	com/facebook/soloader/Api18TraceUtils:endSection	()V
    //   432: goto +83 -> 515
    //   435: astore_0
    //   436: goto +68 -> 504
    //   439: astore_2
    //   440: new 159	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   447: astore 4
    //   449: aload 4
    //   451: ldc_w 602
    //   454: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload 4
    //   460: aload_1
    //   461: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: aload 4
    //   467: ldc_w 604
    //   470: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload 4
    //   476: aload_0
    //   477: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 4
    //   483: ldc_w 606
    //   486: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: new 182	java/lang/RuntimeException
    //   493: dup
    //   494: aload 4
    //   496: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: aload_2
    //   500: invokespecial 609	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   503: athrow
    //   504: getstatic 114	com/facebook/soloader/SoLoader:SYSTRACE_LIBRARY_LOADING	Z
    //   507: ifeq +6 -> 513
    //   510: invokestatic 243	com/facebook/soloader/Api18TraceUtils:endSection	()V
    //   513: aload_0
    //   514: athrow
    //   515: aload 9
    //   517: monitorexit
    //   518: iload 6
    //   520: iconst_1
    //   521: ixor
    //   522: ireturn
    //   523: astore_0
    //   524: aload 9
    //   526: monitorexit
    //   527: aload_0
    //   528: athrow
    //   529: astore_0
    //   530: ldc 2
    //   532: monitorexit
    //   533: aload_0
    //   534: athrow
    //   535: iconst_1
    //   536: istore 5
    //   538: goto -488 -> 50
    //   541: iconst_0
    //   542: istore 5
    //   544: goto -494 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	547	0	paramString1	String
    //   0	547	1	paramString2	String
    //   0	547	2	paramString3	String
    //   0	547	3	paramInt	int
    //   0	547	4	paramThreadPolicy	StrictMode.ThreadPolicy
    //   103	440	5	i	int
    //   105	417	6	j	int
    //   7	317	7	k	int
    //   4	6	8	bool	boolean
    //   71	454	9	localObject	Object
    //   159	21	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   198	245	252	finally
    //   253	256	252	finally
    //   152	195	258	java/lang/UnsatisfiedLinkError
    //   115	125	300	finally
    //   129	132	300	finally
    //   140	143	300	finally
    //   301	304	300	finally
    //   363	423	435	finally
    //   440	504	435	finally
    //   363	423	439	java/lang/UnsatisfiedLinkError
    //   112	115	523	finally
    //   132	135	523	finally
    //   152	195	523	finally
    //   195	198	523	finally
    //   256	258	523	finally
    //   259	264	523	finally
    //   268	298	523	finally
    //   298	300	523	finally
    //   304	306	523	finally
    //   316	323	523	finally
    //   326	338	523	finally
    //   348	363	523	finally
    //   423	432	523	finally
    //   504	513	523	finally
    //   513	515	523	finally
    //   515	518	523	finally
    //   524	527	523	finally
    //   31	41	529	finally
    //   45	48	529	finally
    //   50	73	529	finally
    //   76	97	529	finally
    //   97	100	529	finally
    //   530	533	529	finally
  }
  
  public static String makeLdLibraryPath()
  {
    sSoSourcesLock.readLock().lock();
    try
    {
      assertInitialized();
      Log.d("SoLoader", "makeLdLibraryPath");
      Object localObject1 = new ArrayList();
      Object localObject3 = sSoSources;
      if (localObject3 != null)
      {
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          localObject3[i].addToLdLibraryPath((Collection)localObject1);
          i += 1;
        }
      }
      localObject1 = TextUtils.join(":", (Iterable)localObject1);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("makeLdLibraryPath final path: ");
      ((StringBuilder)localObject3).append((String)localObject1);
      Log.d("SoLoader", ((StringBuilder)localObject3).toString());
      return (String)localObject1;
    }
    finally
    {
      sSoSourcesLock.readLock().unlock();
    }
  }
  
  @Nullable
  public static String makeNonZipPath(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split(":");
    ArrayList localArrayList = new ArrayList(paramString.length);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramString[i];
      if (!((String)localObject).contains("!")) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    return TextUtils.join(":", localArrayList);
  }
  
  private static int makePrepareFlags()
  {
    sSoSourcesLock.writeLock().lock();
    try
    {
      int i = sFlags;
      if ((i & 0x2) != 0) {
        i = 1;
      } else {
        i = 0;
      }
      return i;
    }
    finally
    {
      sSoSourcesLock.writeLock().unlock();
    }
  }
  
  public static void prependSoSource(SoSource paramSoSource)
    throws IOException
  {
    sSoSourcesLock.writeLock().lock();
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Prepending to SO sources: ");
      ((StringBuilder)localObject).append(paramSoSource);
      Log.d("SoLoader", ((StringBuilder)localObject).toString());
      assertInitialized();
      paramSoSource.prepare(makePrepareFlags());
      localObject = new SoSource[sSoSources.length + 1];
      localObject[0] = paramSoSource;
      System.arraycopy(sSoSources, 0, localObject, 1, sSoSources.length);
      sSoSources = (SoSource[])localObject;
      sSoSourcesVersion += 1;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Prepended to SO sources: ");
      ((StringBuilder)localObject).append(paramSoSource);
      Log.d("SoLoader", ((StringBuilder)localObject).toString());
      return;
    }
    finally
    {
      sSoSourcesLock.writeLock().unlock();
    }
  }
  
  public static void setInTestMode()
  {
    TestOnlyUtils.setSoSources(new SoSource[] { new NoopSoSource() });
  }
  
  public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper paramSystemLoadLibraryWrapper)
  {
    sSystemLoadLibraryWrapper = paramSystemLoadLibraryWrapper;
  }
  
  public static File unpackLibraryAndDependencies(String paramString)
    throws UnsatisfiedLinkError
  {
    
    try
    {
      paramString = unpackLibraryBySoName(System.mapLibraryName(paramString));
      return paramString;
    }
    catch (IOException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  static File unpackLibraryBySoName(String paramString)
    throws IOException
  {
    sSoSourcesLock.readLock().lock();
    try
    {
      SoSource[] arrayOfSoSource = sSoSources;
      int j = arrayOfSoSource.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfSoSource[i].unpackLibrary(paramString);
        if (localFile != null) {
          return localFile;
        }
        i += 1;
      }
      throw new FileNotFoundException(paramString);
    }
    finally
    {
      sSoSourcesLock.readLock().unlock();
    }
  }
  
  private static class Api14Utils
  {
    public static String getClassLoaderLdLoadLibrary()
    {
      Object localObject = SoLoader.class.getClassLoader();
      if ((localObject != null) && (!(localObject instanceof BaseDexClassLoader)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ClassLoader ");
        localStringBuilder.append(localObject.getClass().getName());
        localStringBuilder.append(" should be of type BaseDexClassLoader");
        throw new IllegalStateException(localStringBuilder.toString());
      }
      try
      {
        localObject = (BaseDexClassLoader)localObject;
        localObject = (String)BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke(localObject, new Object[0]);
        return (String)localObject;
      }
      catch (Exception localException)
      {
        throw new RuntimeException("Cannot call getLdLibraryPath", localException);
      }
    }
  }
  
  static class TestOnlyUtils
  {
    static void resetStatus()
    {
      try
      {
        SoLoader.sLoadedLibraries.clear();
        SoLoader.sLoadingLibraries.clear();
        SoLoader.sSoFileLoader = null;
        setSoSources(null);
        return;
      }
      finally {}
    }
    
    static void setSoFileLoader(SoFileLoader paramSoFileLoader)
    {
      SoLoader.sSoFileLoader = paramSoFileLoader;
    }
    
    static void setSoSources(SoSource[] paramArrayOfSoSource)
    {
      SoLoader.sSoSourcesLock.writeLock().lock();
      try
      {
        SoLoader.access$102(paramArrayOfSoSource);
        SoLoader.access$208();
        return;
      }
      finally
      {
        SoLoader.sSoSourcesLock.writeLock().unlock();
      }
    }
  }
  
  public static final class WrongAbiError
    extends UnsatisfiedLinkError
  {
    WrongAbiError(Throwable paramThrowable, String paramString)
    {
      super();
      initCause(paramThrowable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\SoLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */