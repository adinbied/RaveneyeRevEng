package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CrashlyticsReportDataCapture
{
  private static final Map<String, Integer> ARCHITECTURES_BY_NAME;
  private static final String GENERATOR = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[] { "17.2.2" });
  private static final int GENERATOR_TYPE = 3;
  private static final int REPORT_ANDROID_PLATFORM = 4;
  private static final int SESSION_ANDROID_PLATFORM = 3;
  private static final String SIGNAL_DEFAULT = "0";
  private final AppData appData;
  private final Context context;
  private final IdManager idManager;
  private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;
  
  static
  {
    HashMap localHashMap = new HashMap();
    ARCHITECTURES_BY_NAME = localHashMap;
    localHashMap.put("armeabi", Integer.valueOf(5));
    ARCHITECTURES_BY_NAME.put("armeabi-v7a", Integer.valueOf(6));
    ARCHITECTURES_BY_NAME.put("arm64-v8a", Integer.valueOf(9));
    ARCHITECTURES_BY_NAME.put("x86", Integer.valueOf(0));
    ARCHITECTURES_BY_NAME.put("x86_64", Integer.valueOf(1));
  }
  
  public CrashlyticsReportDataCapture(Context paramContext, IdManager paramIdManager, AppData paramAppData, StackTraceTrimmingStrategy paramStackTraceTrimmingStrategy)
  {
    this.context = paramContext;
    this.idManager = paramIdManager;
    this.appData = paramAppData;
    this.stackTraceTrimmingStrategy = paramStackTraceTrimmingStrategy;
  }
  
  private CrashlyticsReport.Builder buildReportData()
  {
    return CrashlyticsReport.builder().setSdkVersion("17.2.2").setGmpAppId(this.appData.googleAppId).setInstallationUuid(this.idManager.getCrashlyticsInstallId()).setBuildVersion(this.appData.versionCode).setDisplayVersion(this.appData.versionName).setPlatform(4);
  }
  
  private static int getDeviceArchitecture()
  {
    Object localObject = Build.CPU_ABI;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return 7;
    }
    localObject = (Integer)ARCHITECTURES_BY_NAME.get(((String)localObject).toLowerCase(Locale.US));
    if (localObject == null) {
      return 7;
    }
    return ((Integer)localObject).intValue();
  }
  
  private CrashlyticsReport.Session.Event.Application.Execution.BinaryImage populateBinaryImageData()
  {
    return CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder().setBaseAddress(0L).setSize(0L).setName(this.appData.packageName).setUuid(this.appData.buildId).build();
  }
  
  private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> populateBinaryImagesList()
  {
    return ImmutableList.from(new CrashlyticsReport.Session.Event.Application.Execution.BinaryImage[] { populateBinaryImageData() });
  }
  
  private CrashlyticsReport.Session.Event.Application populateEventApplicationData(int paramInt1, TrimmedThrowableData paramTrimmedThrowableData, Thread paramThread, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject = CommonUtils.getAppProcessInfo(this.appData.packageName, this.context);
    if (localObject != null)
    {
      boolean bool;
      if (((ActivityManager.RunningAppProcessInfo)localObject).importance != 100) {
        bool = true;
      } else {
        bool = false;
      }
      localObject = Boolean.valueOf(bool);
    }
    else
    {
      localObject = null;
    }
    return CrashlyticsReport.Session.Event.Application.builder().setBackground((Boolean)localObject).setUiOrientation(paramInt1).setExecution(populateExecutionData(paramTrimmedThrowableData, paramThread, paramInt2, paramInt3, paramBoolean)).build();
  }
  
  private CrashlyticsReport.Session.Event.Device populateEventDeviceData(int paramInt)
  {
    BatteryState localBatteryState = BatteryState.get(this.context);
    Object localObject = localBatteryState.getBatteryLevel();
    if (localObject != null) {
      localObject = Double.valueOf(((Float)localObject).doubleValue());
    } else {
      localObject = null;
    }
    int i = localBatteryState.getBatteryVelocity();
    boolean bool = CommonUtils.getProximitySensorEnabled(this.context);
    long l1 = CommonUtils.getTotalRamInBytes();
    long l2 = CommonUtils.calculateFreeRamInBytes(this.context);
    long l3 = CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath());
    return CrashlyticsReport.Session.Event.Device.builder().setBatteryLevel((Double)localObject).setBatteryVelocity(i).setProximityOn(bool).setOrientation(paramInt).setRamUsed(l1 - l2).setDiskUsed(l3).build();
  }
  
  private CrashlyticsReport.Session.Event.Application.Execution.Exception populateExceptionData(TrimmedThrowableData paramTrimmedThrowableData, int paramInt1, int paramInt2)
  {
    return populateExceptionData(paramTrimmedThrowableData, paramInt1, paramInt2, 0);
  }
  
  private CrashlyticsReport.Session.Event.Application.Execution.Exception populateExceptionData(TrimmedThrowableData paramTrimmedThrowableData, int paramInt1, int paramInt2, int paramInt3)
  {
    String str1 = paramTrimmedThrowableData.className;
    String str2 = paramTrimmedThrowableData.localizedMessage;
    StackTraceElement[] arrayOfStackTraceElement = paramTrimmedThrowableData.stacktrace;
    int j = 0;
    int i = 0;
    if (arrayOfStackTraceElement != null) {
      arrayOfStackTraceElement = paramTrimmedThrowableData.stacktrace;
    } else {
      arrayOfStackTraceElement = new StackTraceElement[0];
    }
    TrimmedThrowableData localTrimmedThrowableData = paramTrimmedThrowableData.cause;
    if (paramInt3 >= paramInt2)
    {
      paramTrimmedThrowableData = localTrimmedThrowableData;
      for (;;)
      {
        j = i;
        if (paramTrimmedThrowableData == null) {
          break;
        }
        paramTrimmedThrowableData = paramTrimmedThrowableData.cause;
        i += 1;
      }
    }
    paramTrimmedThrowableData = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder().setType(str1).setReason(str2).setFrames(ImmutableList.from(populateFramesList(arrayOfStackTraceElement, paramInt1))).setOverflowCount(j);
    if ((localTrimmedThrowableData != null) && (j == 0)) {
      paramTrimmedThrowableData.setCausedBy(populateExceptionData(localTrimmedThrowableData, paramInt1, paramInt2, paramInt3 + 1));
    }
    return paramTrimmedThrowableData.build();
  }
  
  private CrashlyticsReport.Session.Event.Application.Execution populateExecutionData(TrimmedThrowableData paramTrimmedThrowableData, Thread paramThread, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return CrashlyticsReport.Session.Event.Application.Execution.builder().setThreads(populateThreadsList(paramTrimmedThrowableData, paramThread, paramInt1, paramBoolean)).setException(populateExceptionData(paramTrimmedThrowableData, paramInt1, paramInt2)).setSignal(populateSignalData()).setBinaries(populateBinaryImagesList()).build();
  }
  
  private CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame populateFrameData(StackTraceElement paramStackTraceElement, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder paramBuilder)
  {
    boolean bool = paramStackTraceElement.isNativeMethod();
    long l3 = 0L;
    long l1;
    if (bool) {
      l1 = Math.max(paramStackTraceElement.getLineNumber(), 0L);
    } else {
      l1 = 0L;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramStackTraceElement.getClassName());
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(paramStackTraceElement.getMethodName());
    localObject = ((StringBuilder)localObject).toString();
    String str = paramStackTraceElement.getFileName();
    long l2 = l3;
    if (!paramStackTraceElement.isNativeMethod())
    {
      l2 = l3;
      if (paramStackTraceElement.getLineNumber() > 0) {
        l2 = paramStackTraceElement.getLineNumber();
      }
    }
    return paramBuilder.setPc(l1).setSymbol((String)localObject).setFile(str).setOffset(l2).build();
  }
  
  private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> populateFramesList(StackTraceElement[] paramArrayOfStackTraceElement, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(populateFrameData(paramArrayOfStackTraceElement[i], CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder().setImportance(paramInt)));
      i += 1;
    }
    return ImmutableList.from(localArrayList);
  }
  
  private CrashlyticsReport.Session.Application populateSessionApplicationData()
  {
    return CrashlyticsReport.Session.Application.builder().setIdentifier(this.idManager.getAppIdentifier()).setVersion(this.appData.versionCode).setDisplayVersion(this.appData.versionName).setInstallationUuid(this.idManager.getCrashlyticsInstallId()).build();
  }
  
  private CrashlyticsReport.Session populateSessionData(String paramString, long paramLong)
  {
    return CrashlyticsReport.Session.builder().setStartedAt(paramLong).setIdentifier(paramString).setGenerator(GENERATOR).setApp(populateSessionApplicationData()).setOs(populateSessionOperatingSystemData()).setDevice(populateSessionDeviceData()).setGeneratorType(3).build();
  }
  
  private CrashlyticsReport.Session.Device populateSessionDeviceData()
  {
    Object localObject = new StatFs(Environment.getDataDirectory().getPath());
    int i = getDeviceArchitecture();
    int j = Runtime.getRuntime().availableProcessors();
    long l1 = CommonUtils.getTotalRamInBytes();
    long l2 = ((StatFs)localObject).getBlockCount();
    long l3 = ((StatFs)localObject).getBlockSize();
    boolean bool = CommonUtils.isEmulator(this.context);
    int k = CommonUtils.getDeviceState(this.context);
    localObject = Build.MANUFACTURER;
    String str = Build.PRODUCT;
    return CrashlyticsReport.Session.Device.builder().setArch(i).setModel(Build.MODEL).setCores(j).setRam(l1).setDiskSpace(l2 * l3).setSimulator(bool).setState(k).setManufacturer((String)localObject).setModelClass(str).build();
  }
  
  private CrashlyticsReport.Session.OperatingSystem populateSessionOperatingSystemData()
  {
    return CrashlyticsReport.Session.OperatingSystem.builder().setPlatform(3).setVersion(Build.VERSION.RELEASE).setBuildVersion(Build.VERSION.CODENAME).setJailbroken(CommonUtils.isRooted(this.context)).build();
  }
  
  private CrashlyticsReport.Session.Event.Application.Execution.Signal populateSignalData()
  {
    return CrashlyticsReport.Session.Event.Application.Execution.Signal.builder().setName("0").setCode("0").setAddress(0L).build();
  }
  
  private CrashlyticsReport.Session.Event.Application.Execution.Thread populateThreadData(Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement)
  {
    return populateThreadData(paramThread, paramArrayOfStackTraceElement, 0);
  }
  
  private CrashlyticsReport.Session.Event.Application.Execution.Thread populateThreadData(Thread paramThread, StackTraceElement[] paramArrayOfStackTraceElement, int paramInt)
  {
    return CrashlyticsReport.Session.Event.Application.Execution.Thread.builder().setName(paramThread.getName()).setImportance(paramInt).setFrames(ImmutableList.from(populateFramesList(paramArrayOfStackTraceElement, paramInt))).build();
  }
  
  private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> populateThreadsList(TrimmedThrowableData paramTrimmedThrowableData, Thread paramThread, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(populateThreadData(paramThread, paramTrimmedThrowableData.stacktrace, paramInt));
    if (paramBoolean)
    {
      paramTrimmedThrowableData = Thread.getAllStackTraces().entrySet().iterator();
      while (paramTrimmedThrowableData.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramTrimmedThrowableData.next();
        Thread localThread = (Thread)localEntry.getKey();
        if (!localThread.equals(paramThread)) {
          localArrayList.add(populateThreadData(localThread, this.stackTraceTrimmingStrategy.getTrimmedStackTrace((StackTraceElement[])localEntry.getValue())));
        }
      }
    }
    return ImmutableList.from(localArrayList);
  }
  
  public CrashlyticsReport.Session.Event captureEventData(Throwable paramThrowable, Thread paramThread, String paramString, long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = this.context.getResources().getConfiguration().orientation;
    paramThrowable = new TrimmedThrowableData(paramThrowable, this.stackTraceTrimmingStrategy);
    return CrashlyticsReport.Session.Event.builder().setType(paramString).setTimestamp(paramLong).setApp(populateEventApplicationData(i, paramThrowable, paramThread, paramInt1, paramInt2, paramBoolean)).setDevice(populateEventDeviceData(i)).build();
  }
  
  public CrashlyticsReport captureReportData()
  {
    return buildReportData().build();
  }
  
  public CrashlyticsReport captureReportData(String paramString, long paramLong)
  {
    return buildReportData().setSession(populateSessionData(paramString, paramLong)).build();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsReportDataCapture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */