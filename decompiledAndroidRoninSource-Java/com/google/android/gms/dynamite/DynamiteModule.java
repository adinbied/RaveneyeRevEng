package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule
{
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzd();
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();
  public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzf();
  public static final VersionPolicy PREFER_LOCAL;
  public static final VersionPolicy PREFER_REMOTE;
  private static Boolean zzif;
  private static zzi zzig;
  private static zzk zzih;
  private static String zzii;
  private static int zzij = -1;
  private static final ThreadLocal<zza> zzik = new ThreadLocal();
  private static final DynamiteModule.VersionPolicy.zza zzil = new zza();
  private static final VersionPolicy zzim = new zzg();
  private final Context zzin;
  
  static
  {
    PREFER_REMOTE = new zzb();
    PREFER_LOCAL = new zzc();
  }
  
  private DynamiteModule(Context paramContext)
  {
    this.zzin = ((Context)Preconditions.checkNotNull(paramContext));
  }
  
  public static int getLocalVersion(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getApplicationContext().getClassLoader();
      Object localObject = new StringBuilder(String.valueOf(paramString).length() + 61);
      ((StringBuilder)localObject).append("com.google.android.gms.dynamite.descriptors.");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(".ModuleDescriptor");
      localObject = paramContext.loadClass(((StringBuilder)localObject).toString());
      paramContext = ((Class)localObject).getDeclaredField("MODULE_ID");
      localObject = ((Class)localObject).getDeclaredField("MODULE_VERSION");
      if (!paramContext.get(null).equals(paramString))
      {
        paramContext = String.valueOf(paramContext.get(null));
        localObject = new StringBuilder(String.valueOf(paramContext).length() + 51 + String.valueOf(paramString).length());
        ((StringBuilder)localObject).append("Module descriptor id '");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("' didn't match expected id '");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("'");
        Log.e("DynamiteModule", ((StringBuilder)localObject).toString());
        return 0;
      }
      int i = ((Field)localObject).getInt(null);
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() != 0) {
        paramContext = "Failed to load module descriptor class: ".concat(paramContext);
      } else {
        paramContext = new String("Failed to load module descriptor class: ");
      }
      Log.e("DynamiteModule", paramContext);
      return 0;
      paramContext = new StringBuilder(String.valueOf(paramString).length() + 45);
      paramContext.append("Local module descriptor class for ");
      paramContext.append(paramString);
      paramContext.append(" not found.");
      Log.w("DynamiteModule", paramContext.toString());
      return 0;
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;) {}
    }
  }
  
  public static int getRemoteVersion(Context paramContext, String paramString)
  {
    return zza(paramContext, paramString, false);
  }
  
  public static DynamiteModule load(Context paramContext, VersionPolicy paramVersionPolicy, String paramString)
    throws DynamiteModule.LoadingException
  {
    zza localzza1 = (zza)zzik.get();
    zza localzza2 = new zza(null);
    zzik.set(localzza2);
    try
    {
      DynamiteModule.VersionPolicy.zzb localzzb = paramVersionPolicy.zza(paramContext, paramString, zzil);
      int i = localzzb.zzir;
      int j = localzzb.zzis;
      Object localObject = new StringBuilder(String.valueOf(paramString).length() + 68 + String.valueOf(paramString).length());
      ((StringBuilder)localObject).append("Considering local module ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" and remote module ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(j);
      Log.i("DynamiteModule", ((StringBuilder)localObject).toString());
      if ((localzzb.zzit != 0) && ((localzzb.zzit != -1) || (localzzb.zzir != 0)) && ((localzzb.zzit != 1) || (localzzb.zzis != 0)))
      {
        if (localzzb.zzit == -1)
        {
          paramContext = zze(paramContext, paramString);
          return paramContext;
        }
        i = localzzb.zzit;
        if (i == 1) {
          try
          {
            localObject = zza(paramContext, paramString, localzzb.zzis);
            return (DynamiteModule)localObject;
          }
          catch (LoadingException localLoadingException)
          {
            localObject = String.valueOf(localLoadingException.getMessage());
            if (((String)localObject).length() != 0) {
              localObject = "Failed to load remote module: ".concat((String)localObject);
            } else {
              localObject = new String("Failed to load remote module: ");
            }
            Log.w("DynamiteModule", (String)localObject);
            if ((localzzb.zzir != 0) && (paramVersionPolicy.zza(paramContext, paramString, new zzb(localzzb.zzir, 0)).zzit == -1))
            {
              paramContext = zze(paramContext, paramString);
              return paramContext;
            }
            throw new LoadingException("Remote load failed. No local fallback found.", localLoadingException, null);
          }
        }
        i = localzzb.zzit;
        paramContext = new StringBuilder(47);
        paramContext.append("VersionPolicy returned invalid code:");
        paramContext.append(i);
        throw new LoadingException(paramContext.toString(), null);
      }
      i = localzzb.zzir;
      j = localzzb.zzis;
      paramContext = new StringBuilder(91);
      paramContext.append("No acceptable module found. Local version is ");
      paramContext.append(i);
      paramContext.append(" and remote version is ");
      paramContext.append(j);
      paramContext.append(".");
      throw new LoadingException(paramContext.toString(), null);
    }
    finally
    {
      if (localzza2.zzio != null) {
        localzza2.zzio.close();
      }
      zzik.set(localzza1);
    }
  }
  
  /* Error */
  public static int zza(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 293	com/google/android/gms/dynamite/DynamiteModule:zzif	Ljava/lang/Boolean;
    //   6: astore 6
    //   8: aload 6
    //   10: astore 5
    //   12: aload 6
    //   14: ifnonnull +291 -> 305
    //   17: aload_0
    //   18: invokevirtual 115	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   21: invokevirtual 119	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   24: ldc 6
    //   26: invokevirtual 296	java/lang/Class:getName	()Ljava/lang/String;
    //   29: invokevirtual 152	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   32: astore 6
    //   34: aload 6
    //   36: ldc_w 298
    //   39: invokevirtual 160	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   42: astore 5
    //   44: aload 6
    //   46: monitorenter
    //   47: aload 5
    //   49: aconst_null
    //   50: invokevirtual 167	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   53: checkcast 148	java/lang/ClassLoader
    //   56: astore 7
    //   58: aload 7
    //   60: ifnull +32 -> 92
    //   63: aload 7
    //   65: invokestatic 301	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   68: if_acmpne +11 -> 79
    //   71: getstatic 306	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   74: astore 5
    //   76: goto +138 -> 214
    //   79: aload 7
    //   81: invokestatic 309	com/google/android/gms/dynamite/DynamiteModule:zza	(Ljava/lang/ClassLoader;)V
    //   84: getstatic 312	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   87: astore 5
    //   89: goto +125 -> 214
    //   92: ldc_w 314
    //   95: aload_0
    //   96: invokevirtual 115	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   99: invokevirtual 317	android/content/Context:getPackageName	()Ljava/lang/String;
    //   102: invokevirtual 318	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: ifeq +20 -> 125
    //   108: aload 5
    //   110: aconst_null
    //   111: invokestatic 301	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   114: invokevirtual 321	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   117: getstatic 306	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   120: astore 5
    //   122: goto +92 -> 214
    //   125: aload_0
    //   126: aload_1
    //   127: iload_2
    //   128: invokestatic 324	com/google/android/gms/dynamite/DynamiteModule:zzc	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   131: istore_3
    //   132: getstatic 326	com/google/android/gms/dynamite/DynamiteModule:zzii	Ljava/lang/String;
    //   135: ifnull +57 -> 192
    //   138: getstatic 326	com/google/android/gms/dynamite/DynamiteModule:zzii	Ljava/lang/String;
    //   141: invokevirtual 330	java/lang/String:isEmpty	()Z
    //   144: ifeq +6 -> 150
    //   147: goto +45 -> 192
    //   150: new 332	com/google/android/gms/dynamite/zzh
    //   153: dup
    //   154: getstatic 326	com/google/android/gms/dynamite/DynamiteModule:zzii	Ljava/lang/String;
    //   157: invokestatic 301	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   160: invokespecial 335	com/google/android/gms/dynamite/zzh:<init>	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   163: astore 7
    //   165: aload 7
    //   167: invokestatic 309	com/google/android/gms/dynamite/DynamiteModule:zza	(Ljava/lang/ClassLoader;)V
    //   170: aload 5
    //   172: aconst_null
    //   173: aload 7
    //   175: invokevirtual 321	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   178: getstatic 312	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   181: putstatic 293	com/google/android/gms/dynamite/DynamiteModule:zzif	Ljava/lang/Boolean;
    //   184: aload 6
    //   186: monitorexit
    //   187: ldc 2
    //   189: monitorexit
    //   190: iload_3
    //   191: ireturn
    //   192: aload 6
    //   194: monitorexit
    //   195: ldc 2
    //   197: monitorexit
    //   198: iload_3
    //   199: ireturn
    //   200: aload 5
    //   202: aconst_null
    //   203: invokestatic 301	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   206: invokevirtual 321	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   209: getstatic 306	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   212: astore 5
    //   214: aload 6
    //   216: monitorexit
    //   217: goto +83 -> 300
    //   220: astore 5
    //   222: aload 6
    //   224: monitorexit
    //   225: aload 5
    //   227: athrow
    //   228: astore 5
    //   230: goto +10 -> 240
    //   233: astore 5
    //   235: goto +5 -> 240
    //   238: astore 5
    //   240: aload 5
    //   242: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   245: astore 5
    //   247: new 121	java/lang/StringBuilder
    //   250: dup
    //   251: aload 5
    //   253: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   256: invokevirtual 131	java/lang/String:length	()I
    //   259: bipush 30
    //   261: iadd
    //   262: invokespecial 134	java/lang/StringBuilder:<init>	(I)V
    //   265: astore 6
    //   267: aload 6
    //   269: ldc_w 337
    //   272: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload 6
    //   278: aload 5
    //   280: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: ldc -77
    //   286: aload 6
    //   288: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 208	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   294: pop
    //   295: getstatic 306	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   298: astore 5
    //   300: aload 5
    //   302: putstatic 293	com/google/android/gms/dynamite/DynamiteModule:zzif	Ljava/lang/Boolean;
    //   305: ldc 2
    //   307: monitorexit
    //   308: aload 5
    //   310: invokevirtual 340	java/lang/Boolean:booleanValue	()Z
    //   313: istore 4
    //   315: iload 4
    //   317: ifeq +59 -> 376
    //   320: aload_0
    //   321: aload_1
    //   322: iload_2
    //   323: invokestatic 324	com/google/android/gms/dynamite/DynamiteModule:zzc	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   326: istore_3
    //   327: iload_3
    //   328: ireturn
    //   329: astore_1
    //   330: aload_1
    //   331: invokevirtual 265	com/google/android/gms/dynamite/DynamiteModule$LoadingException:getMessage	()Ljava/lang/String;
    //   334: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   337: astore_1
    //   338: aload_1
    //   339: invokevirtual 131	java/lang/String:length	()I
    //   342: ifeq +14 -> 356
    //   345: ldc_w 342
    //   348: aload_1
    //   349: invokevirtual 198	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   352: astore_1
    //   353: goto +14 -> 367
    //   356: new 123	java/lang/String
    //   359: dup
    //   360: ldc_w 342
    //   363: invokespecial 201	java/lang/String:<init>	(Ljava/lang/String;)V
    //   366: astore_1
    //   367: ldc -77
    //   369: aload_1
    //   370: invokestatic 208	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   373: pop
    //   374: iconst_0
    //   375: ireturn
    //   376: aload_0
    //   377: aload_1
    //   378: iload_2
    //   379: invokestatic 344	com/google/android/gms/dynamite/DynamiteModule:zzb	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   382: istore_3
    //   383: iload_3
    //   384: ireturn
    //   385: astore_1
    //   386: ldc 2
    //   388: monitorexit
    //   389: aload_1
    //   390: athrow
    //   391: astore_1
    //   392: aload_0
    //   393: aload_1
    //   394: invokestatic 350	com/google/android/gms/common/util/CrashUtils:addDynamiteErrorToDropBox	(Landroid/content/Context;Ljava/lang/Throwable;)Z
    //   397: pop
    //   398: aload_1
    //   399: athrow
    //   400: astore 5
    //   402: goto -318 -> 84
    //   405: astore 7
    //   407: goto -207 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	paramContext	Context
    //   0	410	1	paramString	String
    //   0	410	2	paramBoolean	boolean
    //   131	253	3	i	int
    //   313	3	4	bool	boolean
    //   10	203	5	localObject1	Object
    //   220	6	5	localObject2	Object
    //   228	1	5	localNoSuchFieldException	NoSuchFieldException
    //   233	1	5	localIllegalAccessException	IllegalAccessException
    //   238	3	5	localClassNotFoundException	ClassNotFoundException
    //   245	64	5	localObject3	Object
    //   400	1	5	localLoadingException1	LoadingException
    //   6	281	6	localObject4	Object
    //   56	118	7	localObject5	Object
    //   405	1	7	localLoadingException2	LoadingException
    // Exception table:
    //   from	to	target	type
    //   47	58	220	finally
    //   63	76	220	finally
    //   79	84	220	finally
    //   84	89	220	finally
    //   92	122	220	finally
    //   125	147	220	finally
    //   150	184	220	finally
    //   184	187	220	finally
    //   192	195	220	finally
    //   200	214	220	finally
    //   214	217	220	finally
    //   222	225	220	finally
    //   17	47	228	java/lang/NoSuchFieldException
    //   225	228	228	java/lang/NoSuchFieldException
    //   17	47	233	java/lang/IllegalAccessException
    //   225	228	233	java/lang/IllegalAccessException
    //   17	47	238	java/lang/ClassNotFoundException
    //   225	228	238	java/lang/ClassNotFoundException
    //   320	327	329	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   3	8	385	finally
    //   17	47	385	finally
    //   187	190	385	finally
    //   195	198	385	finally
    //   225	228	385	finally
    //   240	300	385	finally
    //   300	305	385	finally
    //   305	308	385	finally
    //   386	389	385	finally
    //   0	3	391	finally
    //   308	315	391	finally
    //   320	327	391	finally
    //   330	353	391	finally
    //   356	367	391	finally
    //   367	374	391	finally
    //   376	383	391	finally
    //   389	391	391	finally
    //   79	84	400	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   125	147	405	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   150	184	405	com/google/android/gms/dynamite/DynamiteModule$LoadingException
  }
  
  /* Error */
  private static DynamiteModule zza(Context paramContext, String paramString, int paramInt)
    throws DynamiteModule.LoadingException
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 293	com/google/android/gms/dynamite/DynamiteModule:zzif	Ljava/lang/Boolean;
    //   6: astore_3
    //   7: ldc 2
    //   9: monitorexit
    //   10: aload_3
    //   11: ifnull +176 -> 187
    //   14: aload_3
    //   15: invokevirtual 340	java/lang/Boolean:booleanValue	()Z
    //   18: ifeq +10 -> 28
    //   21: aload_0
    //   22: aload_1
    //   23: iload_2
    //   24: invokestatic 354	com/google/android/gms/dynamite/DynamiteModule:zzb	(Landroid/content/Context;Ljava/lang/String;I)Lcom/google/android/gms/dynamite/DynamiteModule;
    //   27: areturn
    //   28: new 121	java/lang/StringBuilder
    //   31: dup
    //   32: aload_1
    //   33: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokevirtual 131	java/lang/String:length	()I
    //   39: bipush 51
    //   41: iadd
    //   42: invokespecial 134	java/lang/StringBuilder:<init>	(I)V
    //   45: astore_3
    //   46: aload_3
    //   47: ldc_w 356
    //   50: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: aload_1
    //   56: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_3
    //   61: ldc_w 358
    //   64: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_3
    //   69: iload_2
    //   70: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: ldc -77
    //   76: aload_3
    //   77: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 245	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   83: pop
    //   84: aload_0
    //   85: invokestatic 362	com/google/android/gms/dynamite/DynamiteModule:zzj	(Landroid/content/Context;)Lcom/google/android/gms/dynamite/zzi;
    //   88: astore_3
    //   89: aload_3
    //   90: ifnull +85 -> 175
    //   93: aload_3
    //   94: invokeinterface 367 1 0
    //   99: iconst_2
    //   100: if_icmplt +19 -> 119
    //   103: aload_3
    //   104: aload_0
    //   105: invokestatic 373	com/google/android/gms/dynamic/ObjectWrapper:wrap	(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   108: aload_1
    //   109: iload_2
    //   110: invokeinterface 376 4 0
    //   115: astore_1
    //   116: goto +25 -> 141
    //   119: ldc -77
    //   121: ldc_w 378
    //   124: invokestatic 208	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   127: pop
    //   128: aload_3
    //   129: aload_0
    //   130: invokestatic 373	com/google/android/gms/dynamic/ObjectWrapper:wrap	(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   133: aload_1
    //   134: iload_2
    //   135: invokeinterface 380 4 0
    //   140: astore_1
    //   141: aload_1
    //   142: invokestatic 384	com/google/android/gms/dynamic/ObjectWrapper:unwrap	(Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   145: ifnull +18 -> 163
    //   148: new 2	com/google/android/gms/dynamite/DynamiteModule
    //   151: dup
    //   152: aload_1
    //   153: invokestatic 384	com/google/android/gms/dynamic/ObjectWrapper:unwrap	(Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   156: checkcast 103	android/content/Context
    //   159: invokespecial 386	com/google/android/gms/dynamite/DynamiteModule:<init>	(Landroid/content/Context;)V
    //   162: areturn
    //   163: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   166: dup
    //   167: ldc_w 388
    //   170: aconst_null
    //   171: invokespecial 280	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   174: athrow
    //   175: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   178: dup
    //   179: ldc_w 390
    //   182: aconst_null
    //   183: invokespecial 280	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   186: athrow
    //   187: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   190: dup
    //   191: ldc_w 392
    //   194: aconst_null
    //   195: invokespecial 280	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   198: athrow
    //   199: astore_1
    //   200: ldc 2
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload_0
    //   207: aload_1
    //   208: invokestatic 350	com/google/android/gms/common/util/CrashUtils:addDynamiteErrorToDropBox	(Landroid/content/Context;Ljava/lang/Throwable;)Z
    //   211: pop
    //   212: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   215: dup
    //   216: ldc_w 388
    //   219: aload_1
    //   220: aconst_null
    //   221: invokespecial 275	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
    //   224: athrow
    //   225: astore_0
    //   226: aload_0
    //   227: athrow
    //   228: astore_0
    //   229: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   232: dup
    //   233: ldc_w 388
    //   236: aload_0
    //   237: aconst_null
    //   238: invokespecial 275	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramContext	Context
    //   0	242	1	paramString	String
    //   0	242	2	paramInt	int
    //   6	123	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	10	199	finally
    //   200	203	199	finally
    //   0	3	205	finally
    //   14	28	205	finally
    //   28	89	205	finally
    //   93	116	205	finally
    //   119	141	205	finally
    //   141	163	205	finally
    //   163	175	205	finally
    //   175	187	205	finally
    //   187	199	205	finally
    //   203	205	205	finally
    //   0	3	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   14	28	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   28	89	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   93	116	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   119	141	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   141	163	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   163	175	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   175	187	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   187	199	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   203	205	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   0	3	228	android/os/RemoteException
    //   14	28	228	android/os/RemoteException
    //   28	89	228	android/os/RemoteException
    //   93	116	228	android/os/RemoteException
    //   119	141	228	android/os/RemoteException
    //   141	163	228	android/os/RemoteException
    //   163	175	228	android/os/RemoteException
    //   175	187	228	android/os/RemoteException
    //   187	199	228	android/os/RemoteException
    //   203	205	228	android/os/RemoteException
  }
  
  private static void zza(ClassLoader paramClassLoader)
    throws DynamiteModule.LoadingException
  {
    try
    {
      paramClassLoader = (IBinder)paramClassLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
      if (paramClassLoader == null)
      {
        paramClassLoader = null;
      }
      else
      {
        IInterface localIInterface = paramClassLoader.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        if ((localIInterface instanceof zzk)) {
          paramClassLoader = (zzk)localIInterface;
        } else {
          paramClassLoader = new zzl(paramClassLoader);
        }
      }
      zzih = paramClassLoader;
      return;
    }
    catch (NoSuchMethodException paramClassLoader) {}catch (InvocationTargetException paramClassLoader) {}catch (InstantiationException paramClassLoader) {}catch (IllegalAccessException paramClassLoader) {}catch (ClassNotFoundException paramClassLoader) {}
    throw new LoadingException("Failed to instantiate dynamite loader", paramClassLoader, null);
  }
  
  private static Boolean zzaj()
  {
    for (;;)
    {
      try
      {
        if (zzij >= 2)
        {
          bool = true;
          return Boolean.valueOf(bool);
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  private static int zzb(Context paramContext, String paramString, boolean paramBoolean)
  {
    zzi localzzi = zzj(paramContext);
    if (localzzi == null) {
      return 0;
    }
    try
    {
      if (localzzi.zzak() >= 2) {
        return localzzi.zzb(ObjectWrapper.wrap(paramContext), paramString, paramBoolean);
      }
      Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
      int i = localzzi.zza(ObjectWrapper.wrap(paramContext), paramString, paramBoolean);
      return i;
    }
    catch (RemoteException paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() != 0) {
        paramContext = "Failed to retrieve remote module version: ".concat(paramContext);
      } else {
        paramContext = new String("Failed to retrieve remote module version: ");
      }
      Log.w("DynamiteModule", paramContext);
    }
    return 0;
  }
  
  private static DynamiteModule zzb(Context paramContext, String paramString, int paramInt)
    throws DynamiteModule.LoadingException, RemoteException
  {
    Object localObject1 = new StringBuilder(String.valueOf(paramString).length() + 51);
    ((StringBuilder)localObject1).append("Selected remote version of ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(", version >= ");
    ((StringBuilder)localObject1).append(paramInt);
    Log.i("DynamiteModule", ((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = zzih;
      if (localObject1 != null)
      {
        Object localObject2 = (zza)zzik.get();
        if ((localObject2 != null) && (((zza)localObject2).zzio != null))
        {
          paramContext = paramContext.getApplicationContext();
          localObject2 = ((zza)localObject2).zzio;
          ObjectWrapper.wrap(null);
          if (zzaj().booleanValue())
          {
            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
            paramContext = ((zzk)localObject1).zzb(ObjectWrapper.wrap(paramContext), paramString, paramInt, ObjectWrapper.wrap(localObject2));
          }
          else
          {
            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
            paramContext = ((zzk)localObject1).zza(ObjectWrapper.wrap(paramContext), paramString, paramInt, ObjectWrapper.wrap(localObject2));
          }
          paramContext = (Context)ObjectWrapper.unwrap(paramContext);
          if (paramContext != null) {
            return new DynamiteModule(paramContext);
          }
          throw new LoadingException("Failed to get module context", null);
        }
        throw new LoadingException("No result cursor", null);
      }
      throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
    }
    finally {}
  }
  
  /* Error */
  private static int zzc(Context paramContext, String paramString, boolean paramBoolean)
    throws DynamiteModule.LoadingException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 468	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 7
    //   12: iload_2
    //   13: ifeq +276 -> 289
    //   16: ldc_w 470
    //   19: astore_0
    //   20: goto +3 -> 23
    //   23: new 121	java/lang/StringBuilder
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 131	java/lang/String:length	()I
    //   31: bipush 42
    //   33: iadd
    //   34: aload_1
    //   35: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   38: invokevirtual 131	java/lang/String:length	()I
    //   41: iadd
    //   42: invokespecial 134	java/lang/StringBuilder:<init>	(I)V
    //   45: astore 8
    //   47: aload 8
    //   49: ldc_w 472
    //   52: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 8
    //   58: aload_0
    //   59: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 8
    //   65: ldc_w 474
    //   68: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 8
    //   74: aload_1
    //   75: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 7
    //   81: aload 8
    //   83: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 480	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   89: aconst_null
    //   90: aconst_null
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 486	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   96: astore_0
    //   97: aload_0
    //   98: ifnull +117 -> 215
    //   101: aload_0
    //   102: invokeinterface 489 1 0
    //   107: ifeq +108 -> 215
    //   110: aload_0
    //   111: iconst_0
    //   112: invokeinterface 492 2 0
    //   117: istore_3
    //   118: iload_3
    //   119: ifle +84 -> 203
    //   122: ldc 2
    //   124: monitorenter
    //   125: aload_0
    //   126: iconst_2
    //   127: invokeinterface 496 2 0
    //   132: putstatic 326	com/google/android/gms/dynamite/DynamiteModule:zzii	Ljava/lang/String;
    //   135: aload_0
    //   136: ldc_w 498
    //   139: invokeinterface 502 2 0
    //   144: istore 4
    //   146: iload 4
    //   148: iflt +14 -> 162
    //   151: aload_0
    //   152: iload 4
    //   154: invokeinterface 492 2 0
    //   159: putstatic 433	com/google/android/gms/dynamite/DynamiteModule:zzij	I
    //   162: ldc 2
    //   164: monitorexit
    //   165: getstatic 57	com/google/android/gms/dynamite/DynamiteModule:zzik	Ljava/lang/ThreadLocal;
    //   168: invokevirtual 217	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   171: checkcast 21	com/google/android/gms/dynamite/DynamiteModule$zza
    //   174: astore_1
    //   175: aload_1
    //   176: ifnull +27 -> 203
    //   179: aload_1
    //   180: getfield 256	com/google/android/gms/dynamite/DynamiteModule$zza:zzio	Landroid/database/Cursor;
    //   183: ifnonnull +20 -> 203
    //   186: aload_1
    //   187: aload_0
    //   188: putfield 256	com/google/android/gms/dynamite/DynamiteModule$zza:zzio	Landroid/database/Cursor;
    //   191: aload 5
    //   193: astore_0
    //   194: goto +9 -> 203
    //   197: astore_1
    //   198: ldc 2
    //   200: monitorexit
    //   201: aload_1
    //   202: athrow
    //   203: aload_0
    //   204: ifnull +9 -> 213
    //   207: aload_0
    //   208: invokeinterface 261 1 0
    //   213: iload_3
    //   214: ireturn
    //   215: ldc -77
    //   217: ldc_w 504
    //   220: invokestatic 208	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   223: pop
    //   224: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   227: dup
    //   228: ldc_w 506
    //   231: aconst_null
    //   232: invokespecial 280	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   235: athrow
    //   236: astore_1
    //   237: goto +40 -> 277
    //   240: astore_1
    //   241: goto +13 -> 254
    //   244: astore_1
    //   245: aload 6
    //   247: astore_0
    //   248: goto +29 -> 277
    //   251: astore_1
    //   252: aconst_null
    //   253: astore_0
    //   254: aload_1
    //   255: instanceof 9
    //   258: ifeq +5 -> 263
    //   261: aload_1
    //   262: athrow
    //   263: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   266: dup
    //   267: ldc_w 508
    //   270: aload_1
    //   271: aconst_null
    //   272: invokespecial 275	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
    //   275: athrow
    //   276: astore_1
    //   277: aload_0
    //   278: ifnull +9 -> 287
    //   281: aload_0
    //   282: invokeinterface 261 1 0
    //   287: aload_1
    //   288: athrow
    //   289: ldc_w 510
    //   292: astore_0
    //   293: goto -270 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramContext	Context
    //   0	296	1	paramString	String
    //   0	296	2	paramBoolean	boolean
    //   117	97	3	i	int
    //   144	9	4	j	int
    //   4	188	5	localObject1	Object
    //   1	245	6	localObject2	Object
    //   10	70	7	localContentResolver	android.content.ContentResolver
    //   45	37	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   125	146	197	finally
    //   151	162	197	finally
    //   162	165	197	finally
    //   198	201	197	finally
    //   101	118	236	finally
    //   122	125	236	finally
    //   165	175	236	finally
    //   179	191	236	finally
    //   201	203	236	finally
    //   215	236	236	finally
    //   101	118	240	java/lang/Exception
    //   122	125	240	java/lang/Exception
    //   165	175	240	java/lang/Exception
    //   179	191	240	java/lang/Exception
    //   201	203	240	java/lang/Exception
    //   215	236	240	java/lang/Exception
    //   6	12	244	finally
    //   23	97	244	finally
    //   6	12	251	java/lang/Exception
    //   23	97	251	java/lang/Exception
    //   254	263	276	finally
    //   263	276	276	finally
  }
  
  private static DynamiteModule zze(Context paramContext, String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Selected local version of ".concat(paramString);
    } else {
      paramString = new String("Selected local version of ");
    }
    Log.i("DynamiteModule", paramString);
    return new DynamiteModule(paramContext.getApplicationContext());
  }
  
  /* Error */
  private static zzi zzj(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 514	com/google/android/gms/dynamite/DynamiteModule:zzig	Lcom/google/android/gms/dynamite/zzi;
    //   6: ifnull +12 -> 18
    //   9: getstatic 514	com/google/android/gms/dynamite/DynamiteModule:zzig	Lcom/google/android/gms/dynamite/zzi;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: invokestatic 520	com/google/android/gms/common/GoogleApiAvailabilityLight:getInstance	()Lcom/google/android/gms/common/GoogleApiAvailabilityLight;
    //   21: aload_0
    //   22: invokevirtual 524	com/google/android/gms/common/GoogleApiAvailabilityLight:isGooglePlayServicesAvailable	(Landroid/content/Context;)I
    //   25: ifeq +8 -> 33
    //   28: ldc 2
    //   30: monitorexit
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: ldc_w 314
    //   37: iconst_3
    //   38: invokevirtual 528	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   41: invokevirtual 119	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   44: ldc_w 530
    //   47: invokevirtual 152	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   50: invokevirtual 532	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   53: checkcast 412	android/os/IBinder
    //   56: astore_0
    //   57: aload_0
    //   58: ifnonnull +8 -> 66
    //   61: aconst_null
    //   62: astore_0
    //   63: goto +37 -> 100
    //   66: aload_0
    //   67: ldc_w 534
    //   70: invokeinterface 418 2 0
    //   75: astore_1
    //   76: aload_1
    //   77: instanceof 364
    //   80: ifeq +11 -> 91
    //   83: aload_1
    //   84: checkcast 364	com/google/android/gms/dynamite/zzi
    //   87: astore_0
    //   88: goto +12 -> 100
    //   91: new 536	com/google/android/gms/dynamite/zzj
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 537	com/google/android/gms/dynamite/zzj:<init>	(Landroid/os/IBinder;)V
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull +57 -> 158
    //   104: aload_0
    //   105: putstatic 514	com/google/android/gms/dynamite/DynamiteModule:zzig	Lcom/google/android/gms/dynamite/zzi;
    //   108: ldc 2
    //   110: monitorexit
    //   111: aload_0
    //   112: areturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 192	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: invokestatic 127	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 131	java/lang/String:length	()I
    //   126: ifeq +14 -> 140
    //   129: ldc_w 539
    //   132: aload_0
    //   133: invokevirtual 198	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore_0
    //   137: goto +14 -> 151
    //   140: new 123	java/lang/String
    //   143: dup
    //   144: ldc_w 539
    //   147: invokespecial 201	java/lang/String:<init>	(Ljava/lang/String;)V
    //   150: astore_0
    //   151: ldc -77
    //   153: aload_0
    //   154: invokestatic 185	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: ldc 2
    //   160: monitorexit
    //   161: aconst_null
    //   162: areturn
    //   163: astore_0
    //   164: ldc 2
    //   166: monitorexit
    //   167: aload_0
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramContext	Context
    //   75	9	1	localIInterface	IInterface
    // Exception table:
    //   from	to	target	type
    //   33	57	113	java/lang/Exception
    //   66	88	113	java/lang/Exception
    //   91	100	113	java/lang/Exception
    //   104	108	113	java/lang/Exception
    //   3	16	163	finally
    //   18	31	163	finally
    //   33	57	163	finally
    //   66	88	163	finally
    //   91	100	163	finally
    //   104	108	163	finally
    //   108	111	163	finally
    //   114	137	163	finally
    //   140	151	163	finally
    //   151	158	163	finally
    //   158	161	163	finally
    //   164	167	163	finally
  }
  
  public final Context getModuleContext()
  {
    return this.zzin;
  }
  
  public final IBinder instantiate(String paramString)
    throws DynamiteModule.LoadingException
  {
    try
    {
      IBinder localIBinder = (IBinder)this.zzin.getClassLoader().loadClass(paramString).newInstance();
      return localIBinder;
    }
    catch (IllegalAccessException localIllegalAccessException) {}catch (InstantiationException localInstantiationException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Failed to instantiate module class: ".concat(paramString);
    } else {
      paramString = new String("Failed to instantiate module class: ");
    }
    throw new LoadingException(paramString, localClassNotFoundException, null);
  }
  
  public static class DynamiteLoaderClassLoader
  {
    public static ClassLoader sClassLoader;
  }
  
  public static class LoadingException
    extends Exception
  {
    private LoadingException(String paramString)
    {
      super();
    }
    
    private LoadingException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  public static abstract interface VersionPolicy
  {
    public abstract zzb zza(Context paramContext, String paramString, zza paramzza)
      throws DynamiteModule.LoadingException;
    
    public static abstract interface zza
    {
      public abstract int getLocalVersion(Context paramContext, String paramString);
      
      public abstract int zza(Context paramContext, String paramString, boolean paramBoolean)
        throws DynamiteModule.LoadingException;
    }
    
    public static final class zzb
    {
      public int zzir = 0;
      public int zzis = 0;
      public int zzit = 0;
    }
  }
  
  private static final class zza
  {
    public Cursor zzio;
  }
  
  private static final class zzb
    implements DynamiteModule.VersionPolicy.zza
  {
    private final int zzip;
    private final int zziq;
    
    public zzb(int paramInt1, int paramInt2)
    {
      this.zzip = paramInt1;
      this.zziq = 0;
    }
    
    public final int getLocalVersion(Context paramContext, String paramString)
    {
      return this.zzip;
    }
    
    public final int zza(Context paramContext, String paramString, boolean paramBoolean)
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\dynamite\DynamiteModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */