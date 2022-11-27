package com.tencent.mmkv;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MMKV
  implements SharedPreferences, SharedPreferences.Editor
{
  private static final int ASHMEM_MODE = 8;
  private static final int CONTEXT_MODE_MULTI_PROCESS = 4;
  public static final int MULTI_PROCESS_MODE = 2;
  public static final int SINGLE_PROCESS_MODE = 1;
  private static MMKVHandler gCallbackHandler;
  private static MMKVContentChangeNotification gContentChangeNotify;
  private static boolean gWantLogReDirecting = false;
  private static MMKVLogLevel[] index2LogLevel;
  private static EnumMap<MMKVLogLevel, Integer> logLevel2Index;
  private static final HashMap<String, Parcelable.Creator<?>> mCreators;
  private static EnumMap<MMKVRecoverStrategic, Integer> recoverIndex;
  private static String rootDir;
  private long nativeHandle;
  
  static
  {
    Object localObject1 = new EnumMap(MMKVRecoverStrategic.class);
    recoverIndex = (EnumMap)localObject1;
    Object localObject2 = MMKVRecoverStrategic.OnErrorDiscard;
    Integer localInteger = Integer.valueOf(0);
    ((EnumMap)localObject1).put((Enum)localObject2, localInteger);
    localObject2 = recoverIndex;
    MMKVRecoverStrategic localMMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorRecover;
    localObject1 = Integer.valueOf(1);
    ((EnumMap)localObject2).put(localMMKVRecoverStrategic, localObject1);
    localObject2 = new EnumMap(MMKVLogLevel.class);
    logLevel2Index = (EnumMap)localObject2;
    ((EnumMap)localObject2).put(MMKVLogLevel.LevelDebug, localInteger);
    logLevel2Index.put(MMKVLogLevel.LevelInfo, localObject1);
    logLevel2Index.put(MMKVLogLevel.LevelWarning, Integer.valueOf(2));
    logLevel2Index.put(MMKVLogLevel.LevelError, Integer.valueOf(3));
    logLevel2Index.put(MMKVLogLevel.LevelNone, Integer.valueOf(4));
    index2LogLevel = new MMKVLogLevel[] { MMKVLogLevel.LevelDebug, MMKVLogLevel.LevelInfo, MMKVLogLevel.LevelWarning, MMKVLogLevel.LevelError, MMKVLogLevel.LevelNone };
    rootDir = null;
    mCreators = new HashMap();
  }
  
  private MMKV(long paramLong)
  {
    this.nativeHandle = paramLong;
  }
  
  private native boolean containsKey(long paramLong, String paramString);
  
  private native long count(long paramLong);
  
  private static native long createNB(int paramInt);
  
  public static NativeBuffer createNativeBuffer(int paramInt)
  {
    long l = createNB(paramInt);
    if (l <= 0L) {
      return null;
    }
    return new NativeBuffer(l, paramInt);
  }
  
  private native boolean decodeBool(long paramLong, String paramString, boolean paramBoolean);
  
  private native byte[] decodeBytes(long paramLong, String paramString);
  
  private native double decodeDouble(long paramLong, String paramString, double paramDouble);
  
  private native float decodeFloat(long paramLong, String paramString, float paramFloat);
  
  private native int decodeInt(long paramLong, String paramString, int paramInt);
  
  private native long decodeLong(long paramLong1, String paramString, long paramLong2);
  
  private native String decodeString(long paramLong, String paramString1, String paramString2);
  
  private native String[] decodeStringSet(long paramLong, String paramString);
  
  public static MMKV defaultMMKV()
  {
    if (rootDir != null) {
      return new MMKV(getDefaultMMKV(1, null));
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  public static MMKV defaultMMKV(int paramInt, String paramString)
  {
    if (rootDir != null) {
      return new MMKV(getDefaultMMKV(paramInt, paramString));
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  private static native void destroyNB(long paramLong, int paramInt);
  
  public static void destroyNativeBuffer(NativeBuffer paramNativeBuffer)
  {
    destroyNB(paramNativeBuffer.pointer, paramNativeBuffer.size);
  }
  
  private native boolean encodeBool(long paramLong, String paramString, boolean paramBoolean);
  
  private native boolean encodeBytes(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  private native boolean encodeDouble(long paramLong, String paramString, double paramDouble);
  
  private native boolean encodeFloat(long paramLong, String paramString, float paramFloat);
  
  private native boolean encodeInt(long paramLong, String paramString, int paramInt);
  
  private native boolean encodeLong(long paramLong1, String paramString, long paramLong2);
  
  private native boolean encodeSet(long paramLong, String paramString, String[] paramArrayOfString);
  
  private native boolean encodeString(long paramLong, String paramString1, String paramString2);
  
  private static native long getDefaultMMKV(int paramInt, String paramString);
  
  private static native long getMMKVWithAshmemFD(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  private static native long getMMKVWithID(String paramString1, int paramInt, String paramString2, String paramString3);
  
  private static native long getMMKVWithIDAndSize(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public static String getRootDir()
  {
    return rootDir;
  }
  
  public static String initialize(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append("/mmkv");
    return initialize(localStringBuilder.toString(), null, MMKVLogLevel.LevelInfo);
  }
  
  public static String initialize(Context paramContext, MMKVLogLevel paramMMKVLogLevel)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append("/mmkv");
    return initialize(localStringBuilder.toString(), null, paramMMKVLogLevel);
  }
  
  public static String initialize(String paramString)
  {
    return initialize(paramString, null, MMKVLogLevel.LevelInfo);
  }
  
  public static String initialize(String paramString, LibLoader paramLibLoader)
  {
    return initialize(paramString, paramLibLoader, MMKVLogLevel.LevelInfo);
  }
  
  public static String initialize(String paramString, LibLoader paramLibLoader, MMKVLogLevel paramMMKVLogLevel)
  {
    if (paramLibLoader != null)
    {
      paramLibLoader.loadLibrary("c++_shared");
      paramLibLoader.loadLibrary("mmkv");
    }
    else
    {
      System.loadLibrary("c++_shared");
      System.loadLibrary("mmkv");
    }
    rootDir = paramString;
    jniInitialize(paramString, logLevel2Int(paramMMKVLogLevel));
    return paramString;
  }
  
  public static String initialize(String paramString, MMKVLogLevel paramMMKVLogLevel)
  {
    return initialize(paramString, null, paramMMKVLogLevel);
  }
  
  public static native boolean isFileValid(String paramString);
  
  private static native void jniInitialize(String paramString, int paramInt);
  
  private static int logLevel2Int(MMKVLogLevel paramMMKVLogLevel)
  {
    int j = 1.$SwitchMap$com$tencent$mmkv$MMKVLogLevel[paramMMKVLogLevel.ordinal()];
    int i = 4;
    if (j != 1)
    {
      if (j != 2) {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j == 5) {
              return i;
            }
          }
          else {
            return 3;
          }
        }
        else {
          return 2;
        }
      }
      return 1;
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  private static void mmkvLogImp(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    MMKVHandler localMMKVHandler = gCallbackHandler;
    if ((localMMKVHandler != null) && (gWantLogReDirecting))
    {
      localMMKVHandler.mmkvLog(index2LogLevel[paramInt1], paramString1, paramInt2, paramString2, paramString3);
      return;
    }
    paramInt1 = 1.$SwitchMap$com$tencent$mmkv$MMKVLogLevel[index2LogLevel[paramInt1].ordinal()];
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4) {
            return;
          }
          Log.e("MMKV", paramString3);
          return;
        }
        Log.w("MMKV", paramString3);
        return;
      }
      Log.i("MMKV", paramString3);
      return;
    }
    Log.d("MMKV", paramString3);
  }
  
  public static MMKV mmkvWithAshmemFD(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return new MMKV(getMMKVWithAshmemFD(paramString1, paramInt1, paramInt2, paramString2));
  }
  
  public static MMKV mmkvWithAshmemID(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (rootDir != null)
    {
      Object localObject1 = MMKVContentProvider.getProcessNameByPID(paramContext, Process.myPid());
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        if (((String)localObject1).contains(":"))
        {
          localObject1 = MMKVContentProvider.contentUri(paramContext);
          if (localObject1 == null)
          {
            simpleLog(MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
            return null;
          }
          Object localObject2 = MMKVLogLevel.LevelInfo;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getting parcelable mmkv in process, Uri = ");
          localStringBuilder.append(localObject1);
          simpleLog((MMKVLogLevel)localObject2, localStringBuilder.toString());
          localObject2 = new Bundle();
          ((Bundle)localObject2).putInt("KEY_SIZE", paramInt1);
          ((Bundle)localObject2).putInt("KEY_MODE", paramInt2);
          if (paramString2 != null) {
            ((Bundle)localObject2).putString("KEY_CRYPT", paramString2);
          }
          paramContext = paramContext.getContentResolver().call((Uri)localObject1, "mmkvFromAshmemID", paramString1, (Bundle)localObject2);
          if (paramContext != null)
          {
            paramContext.setClassLoader(ParcelableMMKV.class.getClassLoader());
            paramContext = (ParcelableMMKV)paramContext.getParcelable("KEY");
            if (paramContext != null)
            {
              paramContext = paramContext.toMMKV();
              if (paramContext != null)
              {
                paramString1 = MMKVLogLevel.LevelInfo;
                paramString2 = new StringBuilder();
                paramString2.append(paramContext.mmapID());
                paramString2.append(" fd = ");
                paramString2.append(paramContext.ashmemFD());
                paramString2.append(", meta fd = ");
                paramString2.append(paramContext.ashmemMetaFD());
                simpleLog(paramString1, paramString2.toString());
              }
              return paramContext;
            }
          }
          return null;
        }
        simpleLog(MMKVLogLevel.LevelInfo, "getting mmkv in main process");
        return new MMKV(getMMKVWithIDAndSize(paramString1, paramInt1, paramInt2 | 0x8, paramString2));
      }
      simpleLog(MMKVLogLevel.LevelError, "process name detect fail, try again later");
      return null;
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  public static MMKV mmkvWithID(String paramString)
  {
    if (rootDir != null) {
      return new MMKV(getMMKVWithID(paramString, 1, null, null));
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  public static MMKV mmkvWithID(String paramString, int paramInt)
  {
    if (rootDir != null) {
      return new MMKV(getMMKVWithID(paramString, paramInt, null, null));
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  public static MMKV mmkvWithID(String paramString1, int paramInt, String paramString2)
  {
    if (rootDir != null) {
      return new MMKV(getMMKVWithID(paramString1, paramInt, paramString2, null));
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  public static MMKV mmkvWithID(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    if (rootDir != null)
    {
      long l = getMMKVWithID(paramString1, paramInt, paramString2, paramString3);
      if (l == 0L) {
        return null;
      }
      return new MMKV(l);
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  public static MMKV mmkvWithID(String paramString1, String paramString2)
  {
    if (rootDir != null)
    {
      long l = getMMKVWithID(paramString1, 1, null, paramString2);
      if (l == 0L) {
        return null;
      }
      return new MMKV(l);
    }
    throw new IllegalStateException("You should Call MMKV.initialize() first.");
  }
  
  private static void onContentChangedByOuterProcess(String paramString)
  {
    MMKVContentChangeNotification localMMKVContentChangeNotification = gContentChangeNotify;
    if (localMMKVContentChangeNotification != null) {
      localMMKVContentChangeNotification.onContentChangedByOuterProcess(paramString);
    }
  }
  
  public static native void onExit();
  
  private static int onMMKVCRCCheckFail(String paramString)
  {
    MMKVRecoverStrategic localMMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
    Object localObject = gCallbackHandler;
    if (localObject != null) {
      localMMKVRecoverStrategic = ((MMKVHandler)localObject).onMMKVCRCCheckFail(paramString);
    }
    localObject = MMKVLogLevel.LevelInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Recover strategic for ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is ");
    localStringBuilder.append(localMMKVRecoverStrategic);
    simpleLog((MMKVLogLevel)localObject, localStringBuilder.toString());
    paramString = (Integer)recoverIndex.get(localMMKVRecoverStrategic);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  private static int onMMKVFileLengthError(String paramString)
  {
    MMKVRecoverStrategic localMMKVRecoverStrategic = MMKVRecoverStrategic.OnErrorDiscard;
    Object localObject = gCallbackHandler;
    if (localObject != null) {
      localMMKVRecoverStrategic = ((MMKVHandler)localObject).onMMKVFileLengthError(paramString);
    }
    localObject = MMKVLogLevel.LevelInfo;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Recover strategic for ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is ");
    localStringBuilder.append(localMMKVRecoverStrategic);
    simpleLog((MMKVLogLevel)localObject, localStringBuilder.toString());
    paramString = (Integer)recoverIndex.get(localMMKVRecoverStrategic);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public static native int pageSize();
  
  public static void registerContentChangeNotify(MMKVContentChangeNotification paramMMKVContentChangeNotification)
  {
    gContentChangeNotify = paramMMKVContentChangeNotification;
    boolean bool;
    if (paramMMKVContentChangeNotification != null) {
      bool = true;
    } else {
      bool = false;
    }
    setWantsContentChangeNotify(bool);
  }
  
  public static void registerHandler(MMKVHandler paramMMKVHandler)
  {
    gCallbackHandler = paramMMKVHandler;
    if (paramMMKVHandler.wantLogRedirecting())
    {
      setLogReDirecting(true);
      gWantLogReDirecting = true;
      return;
    }
    setLogReDirecting(false);
    gWantLogReDirecting = false;
  }
  
  private native void removeValueForKey(long paramLong, String paramString);
  
  private static native void setLogLevel(int paramInt);
  
  public static void setLogLevel(MMKVLogLevel paramMMKVLogLevel)
  {
    setLogLevel(logLevel2Int(paramMMKVLogLevel));
  }
  
  private static native void setLogReDirecting(boolean paramBoolean);
  
  private static native void setWantsContentChangeNotify(boolean paramBoolean);
  
  private static void simpleLog(MMKVLogLevel paramMMKVLogLevel, String paramString)
  {
    Object localObject = Thread.currentThread().getStackTrace();
    localObject = localObject[(localObject.length - 1)];
    paramMMKVLogLevel = (Integer)logLevel2Index.get(paramMMKVLogLevel);
    int i;
    if (paramMMKVLogLevel == null) {
      i = 0;
    } else {
      i = paramMMKVLogLevel.intValue();
    }
    mmkvLogImp(i, ((StackTraceElement)localObject).getFileName(), ((StackTraceElement)localObject).getLineNumber(), ((StackTraceElement)localObject).getMethodName(), paramString);
  }
  
  private native void sync(boolean paramBoolean);
  
  private native long totalSize(long paramLong);
  
  public static void unregisterContentChangeNotify()
  {
    gContentChangeNotify = null;
    setWantsContentChangeNotify(false);
  }
  
  public static void unregisterHandler()
  {
    gCallbackHandler = null;
    setLogReDirecting(false);
    gWantLogReDirecting = false;
  }
  
  private native int valueSize(long paramLong, String paramString, boolean paramBoolean);
  
  private native int writeValueToNB(long paramLong1, String paramString, long paramLong2, int paramInt);
  
  public native String[] allKeys();
  
  public void apply()
  {
    sync(false);
  }
  
  public native int ashmemFD();
  
  public native int ashmemMetaFD();
  
  public void async()
  {
    sync(false);
  }
  
  public native void checkContentChangedByOuterProcess();
  
  public native void checkReSetCryptKey(String paramString);
  
  public SharedPreferences.Editor clear()
  {
    clearAll();
    return this;
  }
  
  public native void clearAll();
  
  public native void clearMemoryCache();
  
  public native void close();
  
  public boolean commit()
  {
    sync(true);
    return true;
  }
  
  public boolean contains(String paramString)
  {
    return containsKey(paramString);
  }
  
  public boolean containsKey(String paramString)
  {
    return containsKey(this.nativeHandle, paramString);
  }
  
  public long count()
  {
    return count(this.nativeHandle);
  }
  
  public native String cryptKey();
  
  public boolean decodeBool(String paramString)
  {
    return decodeBool(this.nativeHandle, paramString, false);
  }
  
  public boolean decodeBool(String paramString, boolean paramBoolean)
  {
    return decodeBool(this.nativeHandle, paramString, paramBoolean);
  }
  
  public byte[] decodeBytes(String paramString)
  {
    return decodeBytes(paramString, null);
  }
  
  public byte[] decodeBytes(String paramString, byte[] paramArrayOfByte)
  {
    paramString = decodeBytes(this.nativeHandle, paramString);
    if (paramString != null) {
      paramArrayOfByte = paramString;
    }
    return paramArrayOfByte;
  }
  
  public double decodeDouble(String paramString)
  {
    return decodeDouble(this.nativeHandle, paramString, 0.0D);
  }
  
  public double decodeDouble(String paramString, double paramDouble)
  {
    return decodeDouble(this.nativeHandle, paramString, paramDouble);
  }
  
  public float decodeFloat(String paramString)
  {
    return decodeFloat(this.nativeHandle, paramString, 0.0F);
  }
  
  public float decodeFloat(String paramString, float paramFloat)
  {
    return decodeFloat(this.nativeHandle, paramString, paramFloat);
  }
  
  public int decodeInt(String paramString)
  {
    return decodeInt(this.nativeHandle, paramString, 0);
  }
  
  public int decodeInt(String paramString, int paramInt)
  {
    return decodeInt(this.nativeHandle, paramString, paramInt);
  }
  
  public long decodeLong(String paramString)
  {
    return decodeLong(this.nativeHandle, paramString, 0L);
  }
  
  public long decodeLong(String paramString, long paramLong)
  {
    return decodeLong(this.nativeHandle, paramString, paramLong);
  }
  
  public <T extends Parcelable> T decodeParcelable(String paramString, Class<T> paramClass)
  {
    return decodeParcelable(paramString, paramClass, null);
  }
  
  /* Error */
  public <T extends Parcelable> T decodeParcelable(String paramString, Class<T> paramClass, T paramT)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aload_3
    //   5: areturn
    //   6: aload_0
    //   7: aload_0
    //   8: getfield 108	com/tencent/mmkv/MMKV:nativeHandle	J
    //   11: aload_1
    //   12: invokespecial 511	com/tencent/mmkv/MMKV:decodeBytes	(JLjava/lang/String;)[B
    //   15: astore_1
    //   16: aload_1
    //   17: ifnonnull +5 -> 22
    //   20: aload_3
    //   21: areturn
    //   22: invokestatic 541	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   25: astore 5
    //   27: aload 5
    //   29: aload_1
    //   30: iconst_0
    //   31: aload_1
    //   32: arraylength
    //   33: invokevirtual 545	android/os/Parcel:unmarshall	([BII)V
    //   36: aload 5
    //   38: iconst_0
    //   39: invokevirtual 548	android/os/Parcel:setDataPosition	(I)V
    //   42: aload_2
    //   43: invokevirtual 549	java/lang/Class:toString	()Ljava/lang/String;
    //   46: astore 6
    //   48: getstatic 101	com/tencent/mmkv/MMKV:mCreators	Ljava/util/HashMap;
    //   51: astore 7
    //   53: aload 7
    //   55: monitorenter
    //   56: getstatic 101	com/tencent/mmkv/MMKV:mCreators	Ljava/util/HashMap;
    //   59: aload 6
    //   61: invokevirtual 550	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   64: checkcast 552	android/os/Parcelable$Creator
    //   67: astore 4
    //   69: aload 4
    //   71: astore_1
    //   72: aload 4
    //   74: ifnonnull +36 -> 110
    //   77: aload_2
    //   78: ldc_w 554
    //   81: invokevirtual 558	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   84: aconst_null
    //   85: invokevirtual 561	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: checkcast 552	android/os/Parcelable$Creator
    //   91: astore_2
    //   92: aload_2
    //   93: astore_1
    //   94: aload_2
    //   95: ifnull +15 -> 110
    //   98: getstatic 101	com/tencent/mmkv/MMKV:mCreators	Ljava/util/HashMap;
    //   101: aload 6
    //   103: aload_2
    //   104: invokevirtual 564	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: aload_2
    //   109: astore_1
    //   110: aload 7
    //   112: monitorexit
    //   113: aload_1
    //   114: ifnull +22 -> 136
    //   117: aload_1
    //   118: aload 5
    //   120: invokeinterface 568 2 0
    //   125: checkcast 570	android/os/Parcelable
    //   128: astore_1
    //   129: aload 5
    //   131: invokevirtual 573	android/os/Parcel:recycle	()V
    //   134: aload_1
    //   135: areturn
    //   136: new 192	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   143: astore_1
    //   144: aload_1
    //   145: ldc_w 575
    //   148: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload_1
    //   153: aload 6
    //   155: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: new 535	java/lang/Exception
    //   162: dup
    //   163: aload_1
    //   164: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokespecial 576	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   170: athrow
    //   171: astore_1
    //   172: aload 7
    //   174: monitorexit
    //   175: aload_1
    //   176: athrow
    //   177: astore_1
    //   178: goto +21 -> 199
    //   181: astore_1
    //   182: getstatic 88	com/tencent/mmkv/MMKVLogLevel:LevelError	Lcom/tencent/mmkv/MMKVLogLevel;
    //   185: aload_1
    //   186: invokevirtual 577	java/lang/Exception:toString	()Ljava/lang/String;
    //   189: invokestatic 313	com/tencent/mmkv/MMKV:simpleLog	(Lcom/tencent/mmkv/MMKVLogLevel;Ljava/lang/String;)V
    //   192: aload 5
    //   194: invokevirtual 573	android/os/Parcel:recycle	()V
    //   197: aload_3
    //   198: areturn
    //   199: aload 5
    //   201: invokevirtual 573	android/os/Parcel:recycle	()V
    //   204: aload_1
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	MMKV
    //   0	206	1	paramString	String
    //   0	206	2	paramClass	Class<T>
    //   0	206	3	paramT	T
    //   67	6	4	localCreator	Parcelable.Creator
    //   25	175	5	localParcel	Parcel
    //   46	108	6	str	String
    // Exception table:
    //   from	to	target	type
    //   56	69	171	finally
    //   77	92	171	finally
    //   98	108	171	finally
    //   110	113	171	finally
    //   172	175	171	finally
    //   42	56	177	finally
    //   117	129	177	finally
    //   136	171	177	finally
    //   175	177	177	finally
    //   182	192	177	finally
    //   42	56	181	java/lang/Exception
    //   117	129	181	java/lang/Exception
    //   136	171	181	java/lang/Exception
    //   175	177	181	java/lang/Exception
  }
  
  public String decodeString(String paramString)
  {
    return decodeString(this.nativeHandle, paramString, null);
  }
  
  public String decodeString(String paramString1, String paramString2)
  {
    return decodeString(this.nativeHandle, paramString1, paramString2);
  }
  
  public Set<String> decodeStringSet(String paramString)
  {
    return decodeStringSet(paramString, null);
  }
  
  public Set<String> decodeStringSet(String paramString, Set<String> paramSet)
  {
    return decodeStringSet(paramString, paramSet, HashSet.class);
  }
  
  public Set<String> decodeStringSet(String paramString, Set<String> paramSet, Class<? extends Set> paramClass)
  {
    paramString = decodeStringSet(this.nativeHandle, paramString);
    if (paramString == null) {
      return paramSet;
    }
    try
    {
      paramClass = (Set)paramClass.newInstance();
      paramClass.addAll(Arrays.asList(paramString));
      return paramClass;
    }
    catch (IllegalAccessException|InstantiationException paramString) {}
    return paramSet;
  }
  
  public SharedPreferences.Editor edit()
  {
    return this;
  }
  
  public boolean encode(String paramString, double paramDouble)
  {
    return encodeDouble(this.nativeHandle, paramString, paramDouble);
  }
  
  public boolean encode(String paramString, float paramFloat)
  {
    return encodeFloat(this.nativeHandle, paramString, paramFloat);
  }
  
  public boolean encode(String paramString, int paramInt)
  {
    return encodeInt(this.nativeHandle, paramString, paramInt);
  }
  
  public boolean encode(String paramString, long paramLong)
  {
    return encodeLong(this.nativeHandle, paramString, paramLong);
  }
  
  public boolean encode(String paramString, Parcelable paramParcelable)
  {
    Parcel localParcel = Parcel.obtain();
    paramParcelable.writeToParcel(localParcel, paramParcelable.describeContents());
    paramParcelable = localParcel.marshall();
    localParcel.recycle();
    return encodeBytes(this.nativeHandle, paramString, paramParcelable);
  }
  
  public boolean encode(String paramString1, String paramString2)
  {
    return encodeString(this.nativeHandle, paramString1, paramString2);
  }
  
  public boolean encode(String paramString, Set<String> paramSet)
  {
    return encodeSet(this.nativeHandle, paramString, (String[])paramSet.toArray(new String[0]));
  }
  
  public boolean encode(String paramString, boolean paramBoolean)
  {
    return encodeBool(this.nativeHandle, paramString, paramBoolean);
  }
  
  public boolean encode(String paramString, byte[] paramArrayOfByte)
  {
    return encodeBytes(this.nativeHandle, paramString, paramArrayOfByte);
  }
  
  public Map<String, ?> getAll()
  {
    throw new UnsupportedOperationException("use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return decodeBool(this.nativeHandle, paramString, paramBoolean);
  }
  
  public byte[] getBytes(String paramString, byte[] paramArrayOfByte)
  {
    return decodeBytes(paramString, paramArrayOfByte);
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    return decodeFloat(this.nativeHandle, paramString, paramFloat);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return decodeInt(this.nativeHandle, paramString, paramInt);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return decodeLong(this.nativeHandle, paramString, paramLong);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    return decodeString(this.nativeHandle, paramString1, paramString2);
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    return decodeStringSet(paramString, paramSet);
  }
  
  public int getValueActualSize(String paramString)
  {
    return valueSize(this.nativeHandle, paramString, true);
  }
  
  public int getValueSize(String paramString)
  {
    return valueSize(this.nativeHandle, paramString, false);
  }
  
  public int importFromSharedPreferences(SharedPreferences paramSharedPreferences)
  {
    paramSharedPreferences = paramSharedPreferences.getAll();
    if ((paramSharedPreferences != null) && (paramSharedPreferences.size() > 0))
    {
      Iterator localIterator = paramSharedPreferences.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = ((Map.Entry)localObject1).getValue();
        if ((localObject2 != null) && (localObject1 != null)) {
          if ((localObject1 instanceof Boolean))
          {
            encodeBool(this.nativeHandle, (String)localObject2, ((Boolean)localObject1).booleanValue());
          }
          else if ((localObject1 instanceof Integer))
          {
            encodeInt(this.nativeHandle, (String)localObject2, ((Integer)localObject1).intValue());
          }
          else if ((localObject1 instanceof Long))
          {
            encodeLong(this.nativeHandle, (String)localObject2, ((Long)localObject1).longValue());
          }
          else if ((localObject1 instanceof Float))
          {
            encodeFloat(this.nativeHandle, (String)localObject2, ((Float)localObject1).floatValue());
          }
          else if ((localObject1 instanceof Double))
          {
            encodeDouble(this.nativeHandle, (String)localObject2, ((Double)localObject1).doubleValue());
          }
          else if ((localObject1 instanceof String))
          {
            encodeString(this.nativeHandle, (String)localObject2, (String)localObject1);
          }
          else if ((localObject1 instanceof Set))
          {
            encode((String)localObject2, (Set)localObject1);
          }
          else
          {
            localObject2 = MMKVLogLevel.LevelError;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("unknown type: ");
            localStringBuilder.append(localObject1.getClass());
            simpleLog((MMKVLogLevel)localObject2, localStringBuilder.toString());
          }
        }
      }
      return paramSharedPreferences.size();
    }
    return 0;
  }
  
  public native void lock();
  
  public native String mmapID();
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    encodeBool(this.nativeHandle, paramString, paramBoolean);
    return this;
  }
  
  public SharedPreferences.Editor putBytes(String paramString, byte[] paramArrayOfByte)
  {
    encode(paramString, paramArrayOfByte);
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    encodeFloat(this.nativeHandle, paramString, paramFloat);
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    encodeInt(this.nativeHandle, paramString, paramInt);
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    encodeLong(this.nativeHandle, paramString, paramLong);
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    encodeString(this.nativeHandle, paramString1, paramString2);
    return this;
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    encode(paramString, paramSet);
    return this;
  }
  
  public native boolean reKey(String paramString);
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    throw new UnsupportedOperationException("Not implement in MMKV");
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    removeValueForKey(paramString);
    return this;
  }
  
  public void removeValueForKey(String paramString)
  {
    removeValueForKey(this.nativeHandle, paramString);
  }
  
  public native void removeValuesForKeys(String[] paramArrayOfString);
  
  public void sync()
  {
    sync(true);
  }
  
  public long totalSize()
  {
    return totalSize(this.nativeHandle);
  }
  
  public native void trim();
  
  public native boolean tryLock();
  
  public native void unlock();
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    throw new UnsupportedOperationException("Not implement in MMKV");
  }
  
  public int writeValueToNativeBuffer(String paramString, NativeBuffer paramNativeBuffer)
  {
    return writeValueToNB(this.nativeHandle, paramString, paramNativeBuffer.pointer, paramNativeBuffer.size);
  }
  
  public static abstract interface LibLoader
  {
    public abstract void loadLibrary(String paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\mmkv\MMKV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */