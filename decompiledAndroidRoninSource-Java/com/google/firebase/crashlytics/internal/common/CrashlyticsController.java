package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.log.LogFileManager.DirectoryProvider;
import com.google.firebase.crashlytics.internal.ndk.NativeFileUtils;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.proto.ClsFileOutputStream;
import com.google.firebase.crashlytics.internal.proto.CodedOutputStream;
import com.google.firebase.crashlytics.internal.proto.SessionProtobufHelper;
import com.google.firebase.crashlytics.internal.report.ReportManager;
import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.report.ReportUploader.HandlingExceptionCheck;
import com.google.firebase.crashlytics.internal.report.ReportUploader.Provider;
import com.google.firebase.crashlytics.internal.report.ReportUploader.ReportFilesProvider;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.model.Report.Type;
import com.google.firebase.crashlytics.internal.report.model.SessionReport;
import com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.DefaultCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.NativeCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CrashlyticsController
{
  private static final int ANALYZER_VERSION = 1;
  static final FilenameFilter APP_EXCEPTION_MARKER_FILTER;
  static final String APP_EXCEPTION_MARKER_PREFIX = ".ae";
  private static final String COLLECT_CUSTOM_KEYS = "com.crashlytics.CollectCustomKeys";
  private static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
  private static final String EVENT_TYPE_CRASH = "crash";
  private static final String EVENT_TYPE_LOGGED = "error";
  static final String FATAL_SESSION_DIR = "fatal-sessions";
  static final String FIREBASE_APPLICATION_EXCEPTION = "_ae";
  static final String FIREBASE_CRASH_TYPE = "fatal";
  static final int FIREBASE_CRASH_TYPE_FATAL = 1;
  static final String FIREBASE_TIMESTAMP = "timestamp";
  private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
  private static final String[] INITIAL_SESSION_PART_TAGS = { "SessionUser", "SessionApp", "SessionOS", "SessionDevice" };
  static final Comparator<File> LARGEST_FILE_NAME_FIRST;
  private static final int MAX_CHAINED_EXCEPTION_DEPTH = 8;
  private static final int MAX_LOCAL_LOGGED_EXCEPTIONS = 64;
  static final int MAX_OPEN_SESSIONS = 8;
  static final int MAX_STACK_SIZE = 1024;
  static final String NATIVE_SESSION_DIR = "native-sessions";
  static final String NONFATAL_SESSION_DIR = "nonfatal-sessions";
  static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
  private static final Map<String, String> SEND_AT_CRASHTIME_HEADER;
  static final String SESSION_APP_TAG = "SessionApp";
  static final FilenameFilter SESSION_BEGIN_FILE_FILTER = new FileNameContainsFilter("BeginSession")
  {
    public boolean accept(File paramAnonymousFile, String paramAnonymousString)
    {
      return (super.accept(paramAnonymousFile, paramAnonymousString)) && (paramAnonymousString.endsWith(".cls"));
    }
  };
  static final String SESSION_BEGIN_TAG = "BeginSession";
  static final String SESSION_DEVICE_TAG = "SessionDevice";
  static final String SESSION_EVENT_MISSING_BINARY_IMGS_TAG = "SessionMissingBinaryImages";
  static final String SESSION_FATAL_TAG = "SessionCrash";
  static final FilenameFilter SESSION_FILE_FILTER;
  private static final Pattern SESSION_FILE_PATTERN;
  private static final int SESSION_ID_LENGTH = 35;
  static final String SESSION_NON_FATAL_TAG = "SessionEvent";
  static final String SESSION_OS_TAG = "SessionOS";
  static final String SESSION_USER_TAG = "SessionUser";
  static final Comparator<File> SMALLEST_FILE_NAME_FIRST;
  private final AnalyticsEventLogger analyticsEventLogger;
  private final AppData appData;
  private final CrashlyticsBackgroundWorker backgroundWorker;
  AtomicBoolean checkForUnsentReportsCalled = new AtomicBoolean(false);
  private final Context context;
  private CrashlyticsUncaughtExceptionHandler crashHandler;
  private final CrashlyticsFileMarker crashMarker;
  private final DataCollectionArbiter dataCollectionArbiter;
  private final AtomicInteger eventCounter = new AtomicInteger(0);
  private final FileStore fileStore;
  private final ReportUploader.HandlingExceptionCheck handlingExceptionCheck;
  private final HttpRequestFactory httpRequestFactory;
  private final IdManager idManager;
  private final LogFileDirectoryProvider logFileDirectoryProvider;
  private final LogFileManager logFileManager;
  private final CrashlyticsNativeComponent nativeComponent;
  TaskCompletionSource<Boolean> reportActionProvided = new TaskCompletionSource();
  private final ReportManager reportManager;
  private final ReportUploader.Provider reportUploaderProvider;
  private final SessionReportingCoordinator reportingCoordinator;
  private final StackTraceTrimmingStrategy stackTraceTrimmingStrategy;
  private final String unityVersion;
  TaskCompletionSource<Boolean> unsentReportsAvailable = new TaskCompletionSource();
  TaskCompletionSource<Void> unsentReportsHandled = new TaskCompletionSource();
  private final UserMetadata userMetadata;
  
  static
  {
    APP_EXCEPTION_MARKER_FILTER = CrashlyticsController..Lambda.1.lambdaFactory$();
    SESSION_FILE_FILTER = new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return (paramAnonymousString.length() == 39) && (paramAnonymousString.endsWith(".cls"));
      }
    };
    LARGEST_FILE_NAME_FIRST = new Comparator()
    {
      public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        return paramAnonymousFile2.getName().compareTo(paramAnonymousFile1.getName());
      }
    };
    SMALLEST_FILE_NAME_FIRST = new Comparator()
    {
      public int compare(File paramAnonymousFile1, File paramAnonymousFile2)
      {
        return paramAnonymousFile1.getName().compareTo(paramAnonymousFile2.getName());
      }
    };
    SESSION_FILE_PATTERN = Pattern.compile("([\\d|A-Z|a-z]{12}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{4}\\-[\\d|A-Z|a-z]{12}).+");
    SEND_AT_CRASHTIME_HEADER = Collections.singletonMap("X-CRASHLYTICS-SEND-FLAGS", "1");
  }
  
  CrashlyticsController(Context paramContext, CrashlyticsBackgroundWorker paramCrashlyticsBackgroundWorker, HttpRequestFactory paramHttpRequestFactory, IdManager paramIdManager, DataCollectionArbiter paramDataCollectionArbiter, FileStore paramFileStore, CrashlyticsFileMarker paramCrashlyticsFileMarker, AppData paramAppData, ReportManager paramReportManager, ReportUploader.Provider paramProvider, CrashlyticsNativeComponent paramCrashlyticsNativeComponent, UnityVersionProvider paramUnityVersionProvider, AnalyticsEventLogger paramAnalyticsEventLogger, SettingsDataProvider paramSettingsDataProvider)
  {
    this.context = paramContext;
    this.backgroundWorker = paramCrashlyticsBackgroundWorker;
    this.httpRequestFactory = paramHttpRequestFactory;
    this.idManager = paramIdManager;
    this.dataCollectionArbiter = paramDataCollectionArbiter;
    this.fileStore = paramFileStore;
    this.crashMarker = paramCrashlyticsFileMarker;
    this.appData = paramAppData;
    if (paramProvider != null) {
      this.reportUploaderProvider = paramProvider;
    } else {
      this.reportUploaderProvider = defaultReportUploader();
    }
    this.nativeComponent = paramCrashlyticsNativeComponent;
    this.unityVersion = paramUnityVersionProvider.getUnityVersion();
    this.analyticsEventLogger = paramAnalyticsEventLogger;
    this.userMetadata = new UserMetadata();
    paramCrashlyticsBackgroundWorker = new LogFileDirectoryProvider(paramFileStore);
    this.logFileDirectoryProvider = paramCrashlyticsBackgroundWorker;
    this.logFileManager = new LogFileManager(paramContext, paramCrashlyticsBackgroundWorker);
    if (paramReportManager == null) {
      paramReportManager = new ReportManager(new ReportUploaderFilesProvider(null));
    }
    this.reportManager = paramReportManager;
    this.handlingExceptionCheck = new ReportUploaderHandlingExceptionCheck(null);
    paramCrashlyticsBackgroundWorker = new MiddleOutFallbackStrategy(1024, new StackTraceTrimmingStrategy[] { new RemoveRepeatsStrategy(10) });
    this.stackTraceTrimmingStrategy = paramCrashlyticsBackgroundWorker;
    this.reportingCoordinator = SessionReportingCoordinator.create(paramContext, paramIdManager, paramFileStore, paramAppData, this.logFileManager, this.userMetadata, paramCrashlyticsBackgroundWorker, paramSettingsDataProvider);
  }
  
  private static void appendOrganizationIdToSessionFile(String paramString, File paramFile)
    throws Exception
  {
    if (paramString == null) {
      return;
    }
    appendToProtoFile(paramFile, new CodedOutputStreamWriteAction()
    {
      public void writeTo(CodedOutputStream paramAnonymousCodedOutputStream)
        throws Exception
      {
        SessionProtobufHelper.writeSessionAppClsId(paramAnonymousCodedOutputStream, CrashlyticsController.this);
      }
    });
  }
  
  /* Error */
  private static void appendToProtoFile(File paramFile, CodedOutputStreamWriteAction paramCodedOutputStreamWriteAction)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 488	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: iconst_1
    //   10: invokespecial 491	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   13: astore 4
    //   15: aload 4
    //   17: invokestatic 497	com/google/firebase/crashlytics/internal/proto/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/google/firebase/crashlytics/internal/proto/CodedOutputStream;
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: aload_1
    //   24: aload_3
    //   25: invokeinterface 501 2 0
    //   30: new 503	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   37: astore_1
    //   38: aload_1
    //   39: ldc_w 506
    //   42: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: aload_0
    //   48: invokevirtual 515	java/io/File:getPath	()Ljava/lang/String;
    //   51: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: aload_1
    //   57: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 524	com/google/firebase/crashlytics/internal/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   63: new 503	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   70: astore_1
    //   71: aload_1
    //   72: ldc_w 526
    //   75: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_1
    //   80: aload_0
    //   81: invokevirtual 515	java/io/File:getPath	()Ljava/lang/String;
    //   84: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 4
    //   90: aload_1
    //   91: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 530	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   97: return
    //   98: astore 5
    //   100: aload_2
    //   101: astore_3
    //   102: aload 4
    //   104: astore_1
    //   105: aload 5
    //   107: astore_2
    //   108: goto +6 -> 114
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_1
    //   114: new 503	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   121: astore 4
    //   123: aload 4
    //   125: ldc_w 506
    //   128: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 4
    //   134: aload_0
    //   135: invokevirtual 515	java/io/File:getPath	()Ljava/lang/String;
    //   138: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_3
    //   143: aload 4
    //   145: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 524	com/google/firebase/crashlytics/internal/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   151: new 503	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   158: astore_3
    //   159: aload_3
    //   160: ldc_w 526
    //   163: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_3
    //   168: aload_0
    //   169: invokevirtual 515	java/io/File:getPath	()Ljava/lang/String;
    //   172: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_1
    //   177: aload_3
    //   178: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 530	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   184: aload_2
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramFile	File
    //   0	186	1	paramCodedOutputStreamWriteAction	CodedOutputStreamWriteAction
    //   3	105	2	localObject1	Object
    //   111	74	2	localObject2	Object
    //   1	177	3	localObject3	Object
    //   13	131	4	localObject4	Object
    //   98	8	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   15	21	98	finally
    //   23	30	98	finally
    //   4	15	111	finally
  }
  
  private void cacheKeyData(final Map<String, String> paramMap)
  {
    this.backgroundWorker.submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        String str = CrashlyticsController.this.getCurrentSessionId();
        new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeKeyData(str, paramMap);
        return null;
      }
    });
  }
  
  private void cacheUserData(final UserMetadata paramUserMetadata)
  {
    this.backgroundWorker.submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        String str = CrashlyticsController.this.getCurrentSessionId();
        if (str == null)
        {
          Logger.getLogger().d("Tried to cache user data while no session was open.");
          return null;
        }
        CrashlyticsController.this.reportingCoordinator.persistUserId(CrashlyticsController.makeFirebaseSessionIdentifier(str));
        new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeUserData(str, paramUserMetadata);
        return null;
      }
    });
  }
  
  private void closeOpenSessions(File[] paramArrayOfFile, int paramInt1, int paramInt2)
  {
    Logger.getLogger().d("Closing open sessions.");
    while (paramInt1 < paramArrayOfFile.length)
    {
      File localFile = paramArrayOfFile[paramInt1];
      String str = getSessionIdFromSessionFile(localFile);
      Logger localLogger = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Closing session: ");
      localStringBuilder.append(str);
      localLogger.d(localStringBuilder.toString());
      writeSessionPartsToSessionFile(localFile, str, paramInt2);
      paramInt1 += 1;
    }
  }
  
  private void closeWithoutRenamingOrLog(ClsFileOutputStream paramClsFileOutputStream)
  {
    if (paramClsFileOutputStream == null) {
      return;
    }
    try
    {
      paramClsFileOutputStream.closeInProgressStream();
      return;
    }
    catch (IOException paramClsFileOutputStream)
    {
      Logger.getLogger().e("Error closing session file stream in the presence of an exception", paramClsFileOutputStream);
    }
  }
  
  private static void copyToCodedOutputStream(InputStream paramInputStream, CodedOutputStream paramCodedOutputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j < 0) {
        break;
      }
      i += j;
    }
    paramCodedOutputStream.writeRawBytes(arrayOfByte);
  }
  
  private ReportUploader.Provider defaultReportUploader()
  {
    new ReportUploader.Provider()
    {
      public ReportUploader createReportUploader(AppSettingsData paramAnonymousAppSettingsData)
      {
        Object localObject = paramAnonymousAppSettingsData.reportsUrl;
        String str2 = paramAnonymousAppSettingsData.ndkReportsUrl;
        String str1 = paramAnonymousAppSettingsData.organizationId;
        localObject = CrashlyticsController.this.getCreateReportSpiCall((String)localObject, str2);
        return new ReportUploader(str1, CrashlyticsController.this.appData.googleAppId, DataTransportState.getState(paramAnonymousAppSettingsData), CrashlyticsController.this.reportManager, (CreateReportSpiCall)localObject, CrashlyticsController.this.handlingExceptionCheck);
      }
    };
  }
  
  private static void deleteFiles(File[] paramArrayOfFile)
  {
    if (paramArrayOfFile == null) {
      return;
    }
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      paramArrayOfFile[i].delete();
      i += 1;
    }
  }
  
  private void doCloseSessions(int paramInt, boolean paramBoolean)
    throws Exception
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void doOpenSession()
    throws Exception
  {
    long l = getCurrentTimestampSeconds();
    String str = new CLSUUID(this.idManager).toString();
    Logger localLogger = Logger.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Opening a new session with ID ");
    localStringBuilder.append(str);
    localLogger.d(localStringBuilder.toString());
    this.nativeComponent.openSession(str);
    writeBeginSession(str, l);
    writeSessionApp(str);
    writeSessionOS(str);
    writeSessionDevice(str);
    this.logFileManager.setCurrentSession(str);
    this.reportingCoordinator.onBeginSession(makeFirebaseSessionIdentifier(str), l);
  }
  
  private void doWriteAppExceptionMarker(long paramLong)
  {
    try
    {
      File localFile = getFilesDir();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(".ae");
      localStringBuilder.append(paramLong);
      new File(localFile, localStringBuilder.toString()).createNewFile();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    Logger.getLogger().d("Could not write app exception marker.");
  }
  
  /* Error */
  private void doWriteFatal(Thread paramThread, Throwable paramThrowable, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 10
    //   12: aload_0
    //   13: invokevirtual 654	com/google/firebase/crashlytics/internal/common/CrashlyticsController:getFilesDir	()Ljava/io/File;
    //   16: astore 6
    //   18: new 503	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   25: astore 11
    //   27: aload 11
    //   29: aload_3
    //   30: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 11
    //   36: ldc -97
    //   38: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: new 577	com/google/firebase/crashlytics/internal/proto/ClsFileOutputStream
    //   45: dup
    //   46: aload 6
    //   48: aload 11
    //   50: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 666	com/google/firebase/crashlytics/internal/proto/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   56: astore 6
    //   58: aload 10
    //   60: astore 8
    //   62: aload 9
    //   64: astore_3
    //   65: aload 6
    //   67: astore 7
    //   69: aload 6
    //   71: invokestatic 497	com/google/firebase/crashlytics/internal/proto/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/google/firebase/crashlytics/internal/proto/CodedOutputStream;
    //   74: astore 9
    //   76: aload 9
    //   78: astore 8
    //   80: aload 9
    //   82: astore_3
    //   83: aload 6
    //   85: astore 7
    //   87: aload_0
    //   88: aload 9
    //   90: aload_1
    //   91: aload_2
    //   92: lload 4
    //   94: ldc 101
    //   96: iconst_1
    //   97: invokespecial 670	com/google/firebase/crashlytics/internal/common/CrashlyticsController:writeSessionEvent	(Lcom/google/firebase/crashlytics/internal/proto/CodedOutputStream;Ljava/lang/Thread;Ljava/lang/Throwable;JLjava/lang/String;Z)V
    //   100: aload 9
    //   102: astore_1
    //   103: aload 6
    //   105: astore_2
    //   106: goto +47 -> 153
    //   109: astore 9
    //   111: aload 8
    //   113: astore_1
    //   114: aload 6
    //   116: astore_2
    //   117: goto +20 -> 137
    //   120: astore_1
    //   121: aconst_null
    //   122: astore 7
    //   124: aload 8
    //   126: astore_3
    //   127: goto +42 -> 169
    //   130: astore 9
    //   132: aconst_null
    //   133: astore_2
    //   134: aload 7
    //   136: astore_1
    //   137: aload_1
    //   138: astore_3
    //   139: aload_2
    //   140: astore 7
    //   142: invokestatic 556	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   145: ldc_w 672
    //   148: aload 9
    //   150: invokevirtual 586	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_1
    //   154: ldc_w 674
    //   157: invokestatic 524	com/google/firebase/crashlytics/internal/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   160: aload_2
    //   161: ldc_w 676
    //   164: invokestatic 530	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   167: return
    //   168: astore_1
    //   169: aload_3
    //   170: ldc_w 674
    //   173: invokestatic 524	com/google/firebase/crashlytics/internal/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   176: aload 7
    //   178: ldc_w 676
    //   181: invokestatic 530	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   184: aload_1
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	CrashlyticsController
    //   0	186	1	paramThread	Thread
    //   0	186	2	paramThrowable	Throwable
    //   0	186	3	paramString	String
    //   0	186	4	paramLong	long
    //   16	99	6	localObject1	Object
    //   1	176	7	localObject2	Object
    //   7	118	8	localObject3	Object
    //   4	97	9	localCodedOutputStream	CodedOutputStream
    //   109	1	9	localException1	Exception
    //   130	19	9	localException2	Exception
    //   10	49	10	localObject4	Object
    //   25	24	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   69	76	109	java/lang/Exception
    //   87	100	109	java/lang/Exception
    //   12	58	120	finally
    //   12	58	130	java/lang/Exception
    //   69	76	168	finally
    //   87	100	168	finally
    //   142	153	168	finally
  }
  
  /* Error */
  private void doWriteNonFatal(Thread paramThread, Throwable paramThrowable, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 10
    //   9: invokestatic 556	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   12: astore 6
    //   14: new 503	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   21: astore 9
    //   23: aload 9
    //   25: ldc_w 678
    //   28: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 9
    //   34: aload_2
    //   35: invokevirtual 681	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 9
    //   41: ldc_w 683
    //   44: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 9
    //   50: aload_1
    //   51: invokevirtual 688	java/lang/Thread:getName	()Ljava/lang/String;
    //   54: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 6
    //   60: aload 9
    //   62: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokevirtual 561	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 285	com/google/firebase/crashlytics/internal/common/CrashlyticsController:eventCounter	Ljava/util/concurrent/atomic/AtomicInteger;
    //   72: invokevirtual 692	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   75: invokestatic 696	com/google/firebase/crashlytics/internal/common/CommonUtils:padWithZerosToMaxIntWidth	(I)Ljava/lang/String;
    //   78: astore 6
    //   80: new 503	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   87: astore 9
    //   89: aload 9
    //   91: aload_3
    //   92: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 9
    //   98: ldc -89
    //   100: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 9
    //   106: aload 6
    //   108: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload 9
    //   114: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: astore 6
    //   119: new 577	com/google/firebase/crashlytics/internal/proto/ClsFileOutputStream
    //   122: dup
    //   123: aload_0
    //   124: invokevirtual 654	com/google/firebase/crashlytics/internal/common/CrashlyticsController:getFilesDir	()Ljava/io/File;
    //   127: aload 6
    //   129: invokespecial 666	com/google/firebase/crashlytics/internal/proto/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   132: astore 6
    //   134: aload 8
    //   136: astore 7
    //   138: aload 6
    //   140: astore 8
    //   142: aload 6
    //   144: invokestatic 497	com/google/firebase/crashlytics/internal/proto/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/google/firebase/crashlytics/internal/proto/CodedOutputStream;
    //   147: astore 9
    //   149: aload_0
    //   150: aload 9
    //   152: aload_1
    //   153: aload_2
    //   154: lload 4
    //   156: ldc 104
    //   158: iconst_0
    //   159: invokespecial 670	com/google/firebase/crashlytics/internal/common/CrashlyticsController:writeSessionEvent	(Lcom/google/firebase/crashlytics/internal/proto/CodedOutputStream;Ljava/lang/Thread;Ljava/lang/Throwable;JLjava/lang/String;Z)V
    //   162: aload 9
    //   164: ldc_w 698
    //   167: invokestatic 524	com/google/firebase/crashlytics/internal/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   170: goto +63 -> 233
    //   173: astore_1
    //   174: aload 9
    //   176: astore 7
    //   178: goto +88 -> 266
    //   181: astore_1
    //   182: aload 9
    //   184: astore_2
    //   185: goto +24 -> 209
    //   188: astore_1
    //   189: aload 10
    //   191: astore_2
    //   192: goto +17 -> 209
    //   195: astore_1
    //   196: aconst_null
    //   197: astore 6
    //   199: goto +67 -> 266
    //   202: astore_1
    //   203: aconst_null
    //   204: astore 6
    //   206: aload 10
    //   208: astore_2
    //   209: aload_2
    //   210: astore 7
    //   212: aload 6
    //   214: astore 8
    //   216: invokestatic 556	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   219: ldc_w 700
    //   222: aload_1
    //   223: invokevirtual 586	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   226: aload_2
    //   227: ldc_w 698
    //   230: invokestatic 524	com/google/firebase/crashlytics/internal/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   233: aload 6
    //   235: ldc_w 702
    //   238: invokestatic 530	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   241: aload_0
    //   242: aload_3
    //   243: bipush 64
    //   245: invokespecial 706	com/google/firebase/crashlytics/internal/common/CrashlyticsController:trimSessionEventFiles	(Ljava/lang/String;I)V
    //   248: return
    //   249: astore_1
    //   250: invokestatic 556	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   253: ldc_w 708
    //   256: aload_1
    //   257: invokevirtual 586	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: return
    //   261: astore_1
    //   262: aload 8
    //   264: astore 6
    //   266: aload 7
    //   268: ldc_w 698
    //   271: invokestatic 524	com/google/firebase/crashlytics/internal/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   274: aload 6
    //   276: ldc_w 702
    //   279: invokestatic 530	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   282: aload_1
    //   283: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	this	CrashlyticsController
    //   0	284	1	paramThread	Thread
    //   0	284	2	paramThrowable	Throwable
    //   0	284	3	paramString	String
    //   0	284	4	paramLong	long
    //   12	263	6	localObject1	Object
    //   4	263	7	localObject2	Object
    //   1	262	8	localObject3	Object
    //   21	162	9	localObject4	Object
    //   7	200	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   149	162	173	finally
    //   149	162	181	java/lang/Exception
    //   142	149	188	java/lang/Exception
    //   9	134	195	finally
    //   9	134	202	java/lang/Exception
    //   241	248	249	java/lang/Exception
    //   142	149	261	finally
    //   216	226	261	finally
  }
  
  private static File[] ensureFileArrayNotNull(File[] paramArrayOfFile)
  {
    File[] arrayOfFile = paramArrayOfFile;
    if (paramArrayOfFile == null) {
      arrayOfFile = new File[0];
    }
    return arrayOfFile;
  }
  
  private void finalizePreviousNativeSession(String paramString)
  {
    Object localObject1 = Logger.getLogger();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Finalizing native report for session ");
    ((StringBuilder)localObject2).append(paramString);
    ((Logger)localObject1).d(((StringBuilder)localObject2).toString());
    localObject1 = this.nativeComponent.getSessionFileProvider(paramString);
    localObject2 = ((NativeSessionFileProvider)localObject1).getMinidumpFile();
    if ((localObject2 != null) && (((File)localObject2).exists()))
    {
      long l = ((File)localObject2).lastModified();
      localObject2 = new LogFileManager(this.context, this.logFileDirectoryProvider, paramString);
      File localFile = new File(getNativeSessionFilesDir(), paramString);
      if (!localFile.mkdirs())
      {
        Logger.getLogger().d("Couldn't create native sessions directory");
        return;
      }
      doWriteAppExceptionMarker(l);
      localObject1 = getNativeSessionFiles((NativeSessionFileProvider)localObject1, paramString, getContext(), getFilesDir(), ((LogFileManager)localObject2).getBytesForLog());
      NativeSessionFileGzipper.processNativeSessions(localFile, (List)localObject1);
      this.reportingCoordinator.finalizeSessionWithNativeEvent(makeFirebaseSessionIdentifier(paramString), (List)localObject1);
      ((LogFileManager)localObject2).clearLog();
      return;
    }
    localObject1 = Logger.getLogger();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("No minidump data found for session ");
    ((StringBuilder)localObject2).append(paramString);
    ((Logger)localObject1).w(((StringBuilder)localObject2).toString());
  }
  
  private static boolean firebaseCrashExists()
  {
    try
    {
      Class.forName("com.google.firebase.crash.FirebaseCrash");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    return false;
  }
  
  private Context getContext()
  {
    return this.context;
  }
  
  private CreateReportSpiCall getCreateReportSpiCall(String paramString1, String paramString2)
  {
    String str = CommonUtils.getStringsFileValue(getContext(), "com.crashlytics.ApiEndpoint");
    return new CompositeCreateReportSpiCall(new DefaultCreateReportSpiCall(str, paramString1, this.httpRequestFactory, CrashlyticsCore.getVersion()), new NativeCreateReportSpiCall(str, paramString2, this.httpRequestFactory, CrashlyticsCore.getVersion()));
  }
  
  private String getCurrentSessionId()
  {
    File[] arrayOfFile = listSortedSessionBeginFiles();
    if (arrayOfFile.length > 0) {
      return getSessionIdFromSessionFile(arrayOfFile[0]);
    }
    return null;
  }
  
  private static long getCurrentTimestampSeconds()
  {
    return getTimestampSeconds(new Date());
  }
  
  static List<NativeSessionFile> getNativeSessionFiles(NativeSessionFileProvider paramNativeSessionFileProvider, String paramString, Context paramContext, File paramFile, byte[] paramArrayOfByte)
  {
    Object localObject = new MetaDataStore(paramFile);
    paramFile = ((MetaDataStore)localObject).getUserDataFileForSession(paramString);
    localObject = ((MetaDataStore)localObject).getKeysFileForSession(paramString);
    try
    {
      paramString = NativeFileUtils.binaryImagesJsonFromMapsFile(paramNativeSessionFileProvider.getBinaryImagesFile(), paramContext);
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    paramString = null;
    paramContext = new ArrayList();
    paramContext.add(new BytesBackedNativeSessionFile("logs_file", "logs", paramArrayOfByte));
    paramContext.add(new BytesBackedNativeSessionFile("binary_images_file", "binaryImages", paramString));
    paramContext.add(new FileBackedNativeSessionFile("crash_meta_file", "metadata", paramNativeSessionFileProvider.getMetadataFile()));
    paramContext.add(new FileBackedNativeSessionFile("session_meta_file", "session", paramNativeSessionFileProvider.getSessionFile()));
    paramContext.add(new FileBackedNativeSessionFile("app_meta_file", "app", paramNativeSessionFileProvider.getAppFile()));
    paramContext.add(new FileBackedNativeSessionFile("device_meta_file", "device", paramNativeSessionFileProvider.getDeviceFile()));
    paramContext.add(new FileBackedNativeSessionFile("os_meta_file", "os", paramNativeSessionFileProvider.getOsFile()));
    paramContext.add(new FileBackedNativeSessionFile("minidump_file", "minidump", paramNativeSessionFileProvider.getMinidumpFile()));
    paramContext.add(new FileBackedNativeSessionFile("user_meta_file", "user", paramFile));
    paramContext.add(new FileBackedNativeSessionFile("keys_file", "keys", (File)localObject));
    return paramContext;
  }
  
  static String getSessionIdFromSessionFile(File paramFile)
  {
    return paramFile.getName().substring(0, 35);
  }
  
  private static long getTimestampSeconds(Date paramDate)
  {
    return paramDate.getTime() / 1000L;
  }
  
  private File[] getTrimmedNonFatalFiles(String paramString, File[] paramArrayOfFile, int paramInt)
  {
    File[] arrayOfFile = paramArrayOfFile;
    if (paramArrayOfFile.length > paramInt)
    {
      Logger.getLogger().d(String.format(Locale.US, "Trimming down to %d logged exceptions.", new Object[] { Integer.valueOf(paramInt) }));
      trimSessionEventFiles(paramString, paramInt);
      paramArrayOfFile = new StringBuilder();
      paramArrayOfFile.append(paramString);
      paramArrayOfFile.append("SessionEvent");
      arrayOfFile = listFilesMatching(new FileNameContainsFilter(paramArrayOfFile.toString()));
    }
    return arrayOfFile;
  }
  
  private UserMetadata getUserMetadata(String paramString)
  {
    if (isHandlingException()) {
      return this.userMetadata;
    }
    return new MetaDataStore(getFilesDir()).readUserData(paramString);
  }
  
  private static File[] listFilesMatching(File paramFile, FilenameFilter paramFilenameFilter)
  {
    return ensureFileArrayNotNull(paramFile.listFiles(paramFilenameFilter));
  }
  
  private File[] listFilesMatching(FilenameFilter paramFilenameFilter)
  {
    return listFilesMatching(getFilesDir(), paramFilenameFilter);
  }
  
  private File[] listSessionPartFilesFor(String paramString)
  {
    return listFilesMatching(new SessionPartFileFilter(paramString));
  }
  
  private File[] listSortedSessionBeginFiles()
  {
    File[] arrayOfFile = listSessionBeginFiles();
    Arrays.sort(arrayOfFile, LARGEST_FILE_NAME_FIRST);
    return arrayOfFile;
  }
  
  private Task<Void> logAnalyticsAppExceptionEvent(final long paramLong)
  {
    if (firebaseCrashExists())
    {
      Logger.getLogger().d("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
      return Tasks.forResult(null);
    }
    Tasks.call(new ScheduledThreadPoolExecutor(1), new Callable()
    {
      public Void call()
        throws Exception
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("fatal", 1);
        localBundle.putLong("timestamp", paramLong);
        CrashlyticsController.this.analyticsEventLogger.logEvent("_ae", localBundle);
        return null;
      }
    });
  }
  
  private Task<Void> logAnalyticsAppExceptionEvents()
  {
    ArrayList localArrayList = new ArrayList();
    File[] arrayOfFile = listAppExceptionMarkerFiles();
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      try
      {
        localArrayList.add(logAnalyticsAppExceptionEvent(Long.parseLong(localFile.getName().substring(3))));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Logger localLogger;
        StringBuilder localStringBuilder;
        for (;;) {}
      }
      localLogger = Logger.getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not parse timestamp from file ");
      localStringBuilder.append(localFile.getName());
      localLogger.d(localStringBuilder.toString());
      localFile.delete();
      i += 1;
    }
    return Tasks.whenAll(localArrayList);
  }
  
  private static String makeFirebaseSessionIdentifier(String paramString)
  {
    return paramString.replaceAll("-", "");
  }
  
  private void retainSessions(File[] paramArrayOfFile, Set<String> paramSet)
  {
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramArrayOfFile[i];
      String str = localFile.getName();
      Object localObject = SESSION_FILE_PATTERN.matcher(str);
      StringBuilder localStringBuilder;
      if (!((Matcher)localObject).matches())
      {
        localObject = Logger.getLogger();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Deleting unknown file: ");
        localStringBuilder.append(str);
        ((Logger)localObject).d(localStringBuilder.toString());
        localFile.delete();
      }
      else if (!paramSet.contains(((Matcher)localObject).group(1)))
      {
        localObject = Logger.getLogger();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Trimming session file: ");
        localStringBuilder.append(str);
        ((Logger)localObject).d(localStringBuilder.toString());
        localFile.delete();
      }
      i += 1;
    }
  }
  
  private void sendSessionReports(AppSettingsData paramAppSettingsData, boolean paramBoolean)
    throws Exception
  {
    Context localContext = getContext();
    ReportUploader localReportUploader = this.reportUploaderProvider.createReportUploader(paramAppSettingsData);
    File[] arrayOfFile = listCompleteSessionFiles();
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfFile[i];
      appendOrganizationIdToSessionFile(paramAppSettingsData.organizationId, (File)localObject);
      localObject = new SessionReport((File)localObject, SEND_AT_CRASHTIME_HEADER);
      this.backgroundWorker.submit(new SendReportRunnable(localContext, (Report)localObject, localReportUploader, paramBoolean));
      i += 1;
    }
  }
  
  /* Error */
  private void synthesizeSessionFile(File paramFile1, String paramString, File[] paramArrayOfFile, File paramFile2)
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnull +9 -> 11
    //   5: iconst_1
    //   6: istore 5
    //   8: goto +6 -> 14
    //   11: iconst_0
    //   12: istore 5
    //   14: iload 5
    //   16: ifeq +12 -> 28
    //   19: aload_0
    //   20: invokevirtual 1075	com/google/firebase/crashlytics/internal/common/CrashlyticsController:getFatalSessionFilesDir	()Ljava/io/File;
    //   23: astore 6
    //   25: goto +9 -> 34
    //   28: aload_0
    //   29: invokevirtual 1078	com/google/firebase/crashlytics/internal/common/CrashlyticsController:getNonFatalSessionFilesDir	()Ljava/io/File;
    //   32: astore 6
    //   34: aload 6
    //   36: invokevirtual 725	java/io/File:exists	()Z
    //   39: ifne +9 -> 48
    //   42: aload 6
    //   44: invokevirtual 737	java/io/File:mkdirs	()Z
    //   47: pop
    //   48: aconst_null
    //   49: astore 8
    //   51: aconst_null
    //   52: astore 10
    //   54: aconst_null
    //   55: astore 7
    //   57: aconst_null
    //   58: astore 11
    //   60: new 577	com/google/firebase/crashlytics/internal/proto/ClsFileOutputStream
    //   63: dup
    //   64: aload 6
    //   66: aload_2
    //   67: invokespecial 666	com/google/firebase/crashlytics/internal/proto/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   70: astore 9
    //   72: aload 11
    //   74: astore 8
    //   76: aload 10
    //   78: astore 6
    //   80: aload 9
    //   82: astore 7
    //   84: aload 9
    //   86: invokestatic 497	com/google/firebase/crashlytics/internal/proto/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/google/firebase/crashlytics/internal/proto/CodedOutputStream;
    //   89: astore 10
    //   91: aload 10
    //   93: astore 8
    //   95: aload 10
    //   97: astore 6
    //   99: aload 9
    //   101: astore 7
    //   103: invokestatic 556	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   106: astore 11
    //   108: aload 10
    //   110: astore 8
    //   112: aload 10
    //   114: astore 6
    //   116: aload 9
    //   118: astore 7
    //   120: new 503	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   127: astore 12
    //   129: aload 10
    //   131: astore 8
    //   133: aload 10
    //   135: astore 6
    //   137: aload 9
    //   139: astore 7
    //   141: aload 12
    //   143: ldc_w 1080
    //   146: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 10
    //   152: astore 8
    //   154: aload 10
    //   156: astore 6
    //   158: aload 9
    //   160: astore 7
    //   162: aload 12
    //   164: aload_2
    //   165: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 10
    //   171: astore 8
    //   173: aload 10
    //   175: astore 6
    //   177: aload 9
    //   179: astore 7
    //   181: aload 11
    //   183: aload 12
    //   185: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokevirtual 561	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   191: aload 10
    //   193: astore 8
    //   195: aload 10
    //   197: astore 6
    //   199: aload 9
    //   201: astore 7
    //   203: aload 10
    //   205: aload_1
    //   206: invokestatic 1084	com/google/firebase/crashlytics/internal/common/CrashlyticsController:writeToCosFromFile	(Lcom/google/firebase/crashlytics/internal/proto/CodedOutputStream;Ljava/io/File;)V
    //   209: aload 10
    //   211: astore 8
    //   213: aload 10
    //   215: astore 6
    //   217: aload 9
    //   219: astore 7
    //   221: aload 10
    //   223: iconst_4
    //   224: invokestatic 617	com/google/firebase/crashlytics/internal/common/CrashlyticsController:getCurrentTimestampSeconds	()J
    //   227: invokevirtual 1088	com/google/firebase/crashlytics/internal/proto/CodedOutputStream:writeUInt64	(IJ)V
    //   230: aload 10
    //   232: astore 8
    //   234: aload 10
    //   236: astore 6
    //   238: aload 9
    //   240: astore 7
    //   242: aload 10
    //   244: iconst_5
    //   245: iload 5
    //   247: invokevirtual 1091	com/google/firebase/crashlytics/internal/proto/CodedOutputStream:writeBool	(IZ)V
    //   250: aload 10
    //   252: astore 8
    //   254: aload 10
    //   256: astore 6
    //   258: aload 9
    //   260: astore 7
    //   262: aload 10
    //   264: bipush 11
    //   266: iconst_1
    //   267: invokevirtual 1095	com/google/firebase/crashlytics/internal/proto/CodedOutputStream:writeUInt32	(II)V
    //   270: aload 10
    //   272: astore 8
    //   274: aload 10
    //   276: astore 6
    //   278: aload 9
    //   280: astore 7
    //   282: aload 10
    //   284: bipush 12
    //   286: iconst_3
    //   287: invokevirtual 1098	com/google/firebase/crashlytics/internal/proto/CodedOutputStream:writeEnum	(II)V
    //   290: aload 10
    //   292: astore 8
    //   294: aload 10
    //   296: astore 6
    //   298: aload 9
    //   300: astore 7
    //   302: aload_0
    //   303: aload 10
    //   305: aload_2
    //   306: invokespecial 1102	com/google/firebase/crashlytics/internal/common/CrashlyticsController:writeInitialPartsTo	(Lcom/google/firebase/crashlytics/internal/proto/CodedOutputStream;Ljava/lang/String;)V
    //   309: aload 10
    //   311: astore 8
    //   313: aload 10
    //   315: astore 6
    //   317: aload 9
    //   319: astore 7
    //   321: aload 10
    //   323: aload_3
    //   324: aload_2
    //   325: invokestatic 1106	com/google/firebase/crashlytics/internal/common/CrashlyticsController:writeNonFatalEventsTo	(Lcom/google/firebase/crashlytics/internal/proto/CodedOutputStream;[Ljava/io/File;Ljava/lang/String;)V
    //   328: iload 5
    //   330: ifeq +22 -> 352
    //   333: aload 10
    //   335: astore 8
    //   337: aload 10
    //   339: astore 6
    //   341: aload 9
    //   343: astore 7
    //   345: aload 10
    //   347: aload 4
    //   349: invokestatic 1084	com/google/firebase/crashlytics/internal/common/CrashlyticsController:writeToCosFromFile	(Lcom/google/firebase/crashlytics/internal/proto/CodedOutputStream;Ljava/io/File;)V
    //   352: aload 10
    //   354: ldc_w 1108
    //   357: invokestatic 524	com/google/firebase/crashlytics/internal/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   360: aload 9
    //   362: ldc_w 1110
    //   365: invokestatic 530	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   368: return
    //   369: astore_3
    //   370: aload 9
    //   372: astore_1
    //   373: goto +19 -> 392
    //   376: astore_1
    //   377: aconst_null
    //   378: astore_2
    //   379: aload 7
    //   381: astore 6
    //   383: aload_2
    //   384: astore 7
    //   386: goto +97 -> 483
    //   389: astore_3
    //   390: aconst_null
    //   391: astore_1
    //   392: aload 8
    //   394: astore 6
    //   396: aload_1
    //   397: astore 7
    //   399: invokestatic 556	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   402: astore 4
    //   404: aload 8
    //   406: astore 6
    //   408: aload_1
    //   409: astore 7
    //   411: new 503	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   418: astore 9
    //   420: aload 8
    //   422: astore 6
    //   424: aload_1
    //   425: astore 7
    //   427: aload 9
    //   429: ldc_w 1112
    //   432: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload 8
    //   438: astore 6
    //   440: aload_1
    //   441: astore 7
    //   443: aload 9
    //   445: aload_2
    //   446: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: aload 8
    //   452: astore 6
    //   454: aload_1
    //   455: astore 7
    //   457: aload 4
    //   459: aload 9
    //   461: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: aload_3
    //   465: invokevirtual 586	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   468: aload 8
    //   470: ldc_w 1108
    //   473: invokestatic 524	com/google/firebase/crashlytics/internal/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   476: aload_0
    //   477: aload_1
    //   478: invokespecial 1114	com/google/firebase/crashlytics/internal/common/CrashlyticsController:closeWithoutRenamingOrLog	(Lcom/google/firebase/crashlytics/internal/proto/ClsFileOutputStream;)V
    //   481: return
    //   482: astore_1
    //   483: aload 6
    //   485: ldc_w 1108
    //   488: invokestatic 524	com/google/firebase/crashlytics/internal/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   491: aload 7
    //   493: ldc_w 1110
    //   496: invokestatic 530	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   499: aload_1
    //   500: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	this	CrashlyticsController
    //   0	501	1	paramFile1	File
    //   0	501	2	paramString	String
    //   0	501	3	paramArrayOfFile	File[]
    //   0	501	4	paramFile2	File
    //   6	323	5	bool	boolean
    //   23	461	6	localObject1	Object
    //   55	437	7	localObject2	Object
    //   49	420	8	localObject3	Object
    //   70	390	9	localObject4	Object
    //   52	301	10	localCodedOutputStream	CodedOutputStream
    //   58	124	11	localLogger	Logger
    //   127	57	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   84	91	369	java/lang/Exception
    //   103	108	369	java/lang/Exception
    //   120	129	369	java/lang/Exception
    //   141	150	369	java/lang/Exception
    //   162	169	369	java/lang/Exception
    //   181	191	369	java/lang/Exception
    //   203	209	369	java/lang/Exception
    //   221	230	369	java/lang/Exception
    //   242	250	369	java/lang/Exception
    //   262	270	369	java/lang/Exception
    //   282	290	369	java/lang/Exception
    //   302	309	369	java/lang/Exception
    //   321	328	369	java/lang/Exception
    //   345	352	369	java/lang/Exception
    //   60	72	376	finally
    //   60	72	389	java/lang/Exception
    //   84	91	482	finally
    //   103	108	482	finally
    //   120	129	482	finally
    //   141	150	482	finally
    //   162	169	482	finally
    //   181	191	482	finally
    //   203	209	482	finally
    //   221	230	482	finally
    //   242	250	482	finally
    //   262	270	482	finally
    //   282	290	482	finally
    //   302	309	482	finally
    //   321	328	482	finally
    //   345	352	482	finally
    //   399	404	482	finally
    //   411	420	482	finally
    //   427	436	482	finally
    //   443	450	482	finally
    //   457	468	482	finally
  }
  
  private void trimOpenSessions(int paramInt)
  {
    HashSet localHashSet = new HashSet();
    File[] arrayOfFile = listSortedSessionBeginFiles();
    int i = Math.min(paramInt, arrayOfFile.length);
    paramInt = 0;
    while (paramInt < i)
    {
      localHashSet.add(getSessionIdFromSessionFile(arrayOfFile[paramInt]));
      paramInt += 1;
    }
    this.logFileManager.discardOldLogFiles(localHashSet);
    retainSessions(listFilesMatching(new AnySessionPartFileFilter(null)), localHashSet);
  }
  
  private void trimSessionEventFiles(String paramString, int paramInt)
  {
    File localFile = getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("SessionEvent");
    Utils.capFileCount(localFile, new FileNameContainsFilter(localStringBuilder.toString()), paramInt, SMALLEST_FILE_NAME_FIRST);
  }
  
  private Task<Boolean> waitForReportAction()
  {
    boolean bool = this.dataCollectionArbiter.isAutomaticDataCollectionEnabled();
    Object localObject = Boolean.valueOf(true);
    if (bool)
    {
      Logger.getLogger().d("Automatic data collection is enabled. Allowing upload.");
      this.unsentReportsAvailable.trySetResult(Boolean.valueOf(false));
      return Tasks.forResult(localObject);
    }
    Logger.getLogger().d("Automatic data collection is disabled.");
    Logger.getLogger().d("Notifying that unsent reports are available.");
    this.unsentReportsAvailable.trySetResult(localObject);
    localObject = this.dataCollectionArbiter.waitForAutomaticDataCollectionEnabled().onSuccessTask(new SuccessContinuation()
    {
      public Task<Boolean> then(Void paramAnonymousVoid)
        throws Exception
      {
        return Tasks.forResult(Boolean.valueOf(true));
      }
    });
    Logger.getLogger().d("Waiting for send/deleteUnsentReports to be called.");
    return Utils.race((Task)localObject, this.reportActionProvided.getTask());
  }
  
  private void writeBeginSession(final String paramString, final long paramLong)
    throws Exception
  {
    final String str = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[] { CrashlyticsCore.getVersion() });
    writeSessionPartFile(paramString, "BeginSession", new CodedOutputStreamWriteAction()
    {
      public void writeTo(CodedOutputStream paramAnonymousCodedOutputStream)
        throws Exception
      {
        SessionProtobufHelper.writeBeginSession(paramAnonymousCodedOutputStream, paramString, str, paramLong);
      }
    });
    this.nativeComponent.writeBeginSession(paramString, str, paramLong);
  }
  
  private void writeInitialPartsTo(CodedOutputStream paramCodedOutputStream, String paramString)
    throws IOException
  {
    String[] arrayOfString = INITIAL_SESSION_PART_TAGS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(".cls");
      localObject1 = listFilesMatching(new FileNameContainsFilter(((StringBuilder)localObject1).toString()));
      Object localObject2;
      if (localObject1.length == 0)
      {
        localObject1 = Logger.getLogger();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Can't find ");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(" data for session ID ");
        ((StringBuilder)localObject2).append(paramString);
        ((Logger)localObject1).d(((StringBuilder)localObject2).toString());
      }
      else
      {
        localObject2 = Logger.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Collecting ");
        localStringBuilder.append(str);
        localStringBuilder.append(" data for session ID ");
        localStringBuilder.append(paramString);
        ((Logger)localObject2).d(localStringBuilder.toString());
        writeToCosFromFile(paramCodedOutputStream, localObject1[0]);
      }
      i += 1;
    }
  }
  
  private static void writeNonFatalEventsTo(CodedOutputStream paramCodedOutputStream, File[] paramArrayOfFile, String paramString)
  {
    Arrays.sort(paramArrayOfFile, CommonUtils.FILE_MODIFIED_COMPARATOR);
    int j = paramArrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramArrayOfFile[i];
      try
      {
        Logger.getLogger().d(String.format(Locale.US, "Found Non Fatal for session ID %s in %s ", new Object[] { paramString, localFile.getName() }));
        writeToCosFromFile(paramCodedOutputStream, localFile);
      }
      catch (Exception localException)
      {
        Logger.getLogger().e("Error writting non-fatal to session.", localException);
      }
      i += 1;
    }
  }
  
  private void writeSessionApp(String paramString)
    throws Exception
  {
    final String str1 = this.idManager.getAppIdentifier();
    final String str2 = this.appData.versionCode;
    final String str3 = this.appData.versionName;
    final String str4 = this.idManager.getCrashlyticsInstallId();
    final int i = DeliveryMechanism.determineFrom(this.appData.installerPackageName).getId();
    writeSessionPartFile(paramString, "SessionApp", new CodedOutputStreamWriteAction()
    {
      public void writeTo(CodedOutputStream paramAnonymousCodedOutputStream)
        throws Exception
      {
        SessionProtobufHelper.writeSessionApp(paramAnonymousCodedOutputStream, str1, str2, str3, str4, i, CrashlyticsController.this.unityVersion);
      }
    });
    this.nativeComponent.writeSessionApp(paramString, str1, str2, str3, str4, i, this.unityVersion);
  }
  
  private void writeSessionDevice(String paramString)
    throws Exception
  {
    final Object localObject1 = getContext();
    final Object localObject2 = new StatFs(Environment.getDataDirectory().getPath());
    final int i = CommonUtils.getCpuArchitectureInt();
    final String str = Build.MODEL;
    final int j = Runtime.getRuntime().availableProcessors();
    final long l1 = CommonUtils.getTotalRamInBytes();
    long l2 = ((StatFs)localObject2).getBlockCount() * ((StatFs)localObject2).getBlockSize();
    final boolean bool = CommonUtils.isEmulator((Context)localObject1);
    int k = CommonUtils.getDeviceState((Context)localObject1);
    localObject1 = Build.MANUFACTURER;
    localObject2 = Build.PRODUCT;
    writeSessionPartFile(paramString, "SessionDevice", new CodedOutputStreamWriteAction()
    {
      public void writeTo(CodedOutputStream paramAnonymousCodedOutputStream)
        throws Exception
      {
        SessionProtobufHelper.writeSessionDevice(paramAnonymousCodedOutputStream, i, str, j, l1, bool, localObject1, localObject2, this.val$manufacturer, this.val$modelClass);
      }
    });
    this.nativeComponent.writeSessionDevice(paramString, i, str, j, l1, l2, bool, k, (String)localObject1, (String)localObject2);
  }
  
  private void writeSessionEvent(CodedOutputStream paramCodedOutputStream, Thread paramThread, Throwable paramThrowable, long paramLong, String paramString, boolean paramBoolean)
    throws Exception
  {
    TrimmedThrowableData localTrimmedThrowableData = new TrimmedThrowableData(paramThrowable, this.stackTraceTrimmingStrategy);
    paramThrowable = getContext();
    Object localObject1 = BatteryState.get(paramThrowable);
    Float localFloat = ((BatteryState)localObject1).getBatteryLevel();
    int j = ((BatteryState)localObject1).getBatteryVelocity();
    boolean bool = CommonUtils.getProximitySensorEnabled(paramThrowable);
    int k = paramThrowable.getResources().getConfiguration().orientation;
    long l1 = CommonUtils.getTotalRamInBytes();
    long l2 = CommonUtils.calculateFreeRamInBytes(paramThrowable);
    long l3 = CommonUtils.calculateUsedDiskSpaceInBytes(Environment.getDataDirectory().getPath());
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = CommonUtils.getAppProcessInfo(paramThrowable.getPackageName(), paramThrowable);
    LinkedList localLinkedList = new LinkedList();
    StackTraceElement[] arrayOfStackTraceElement = localTrimmedThrowableData.stacktrace;
    String str1 = this.appData.buildId;
    String str2 = this.idManager.getAppIdentifier();
    int i = 0;
    Object localObject2;
    if (paramBoolean)
    {
      localObject2 = Thread.getAllStackTraces();
      localObject1 = new Thread[((Map)localObject2).size()];
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        localObject1[i] = ((Thread)localEntry.getKey());
        localLinkedList.add(this.stackTraceTrimmingStrategy.getTrimmedStackTrace((StackTraceElement[])localEntry.getValue()));
        i += 1;
      }
    }
    else
    {
      localObject1 = new Thread[0];
    }
    if (!CommonUtils.getBooleanResourceValue(paramThrowable, "com.crashlytics.CollectCustomKeys", true))
    {
      paramThrowable = new TreeMap();
    }
    else
    {
      localObject2 = this.userMetadata.getCustomKeys();
      paramThrowable = (Throwable)localObject2;
      if (localObject2 != null)
      {
        paramThrowable = (Throwable)localObject2;
        if (((Map)localObject2).size() > 1) {
          paramThrowable = new TreeMap((Map)localObject2);
        }
      }
    }
    SessionProtobufHelper.writeSessionEvent(paramCodedOutputStream, paramLong, paramString, localTrimmedThrowableData, paramThread, arrayOfStackTraceElement, (Thread[])localObject1, localLinkedList, 8, paramThrowable, this.logFileManager.getBytesForLog(), localRunningAppProcessInfo, k, str2, str1, localFloat, j, bool, l1 - l2, l3);
    this.logFileManager.clearLog();
  }
  
  private void writeSessionOS(String paramString)
    throws Exception
  {
    final String str1 = Build.VERSION.RELEASE;
    final String str2 = Build.VERSION.CODENAME;
    final boolean bool = CommonUtils.isRooted(getContext());
    writeSessionPartFile(paramString, "SessionOS", new CodedOutputStreamWriteAction()
    {
      public void writeTo(CodedOutputStream paramAnonymousCodedOutputStream)
        throws Exception
      {
        SessionProtobufHelper.writeSessionOS(paramAnonymousCodedOutputStream, str1, str2, bool);
      }
    });
    this.nativeComponent.writeSessionOs(paramString, str1, str2, bool);
  }
  
  /* Error */
  private void writeSessionPartFile(String paramString1, String paramString2, CodedOutputStreamWriteAction paramCodedOutputStreamWriteAction)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: invokevirtual 654	com/google/firebase/crashlytics/internal/common/CrashlyticsController:getFilesDir	()Ljava/io/File;
    //   10: astore 5
    //   12: new 503	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   19: astore 7
    //   21: aload 7
    //   23: aload_1
    //   24: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 7
    //   30: aload_2
    //   31: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: new 577	com/google/firebase/crashlytics/internal/proto/ClsFileOutputStream
    //   38: dup
    //   39: aload 5
    //   41: aload 7
    //   43: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 666	com/google/firebase/crashlytics/internal/proto/ClsFileOutputStream:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore 5
    //   51: aload 6
    //   53: astore_1
    //   54: aload 5
    //   56: invokestatic 497	com/google/firebase/crashlytics/internal/proto/CodedOutputStream:newInstance	(Ljava/io/OutputStream;)Lcom/google/firebase/crashlytics/internal/proto/CodedOutputStream;
    //   59: astore 4
    //   61: aload 4
    //   63: astore_1
    //   64: aload_3
    //   65: aload 4
    //   67: invokeinterface 501 2 0
    //   72: new 503	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   79: astore_1
    //   80: aload_1
    //   81: ldc_w 1429
    //   84: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_1
    //   89: aload_2
    //   90: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_1
    //   95: ldc_w 1431
    //   98: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 4
    //   104: aload_1
    //   105: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 524	com/google/firebase/crashlytics/internal/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   111: new 503	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   118: astore_1
    //   119: aload_1
    //   120: ldc_w 1433
    //   123: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_1
    //   128: aload_2
    //   129: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: ldc_w 1431
    //   137: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 5
    //   143: aload_1
    //   144: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 530	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   150: return
    //   151: astore_3
    //   152: aload_1
    //   153: astore 4
    //   155: aload 5
    //   157: astore_1
    //   158: goto +6 -> 164
    //   161: astore_3
    //   162: aconst_null
    //   163: astore_1
    //   164: new 503	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   171: astore 5
    //   173: aload 5
    //   175: ldc_w 1429
    //   178: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 5
    //   184: aload_2
    //   185: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 5
    //   191: ldc_w 1431
    //   194: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 4
    //   200: aload 5
    //   202: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 524	com/google/firebase/crashlytics/internal/common/CommonUtils:flushOrLog	(Ljava/io/Flushable;Ljava/lang/String;)V
    //   208: new 503	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   215: astore 4
    //   217: aload 4
    //   219: ldc_w 1433
    //   222: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 4
    //   228: aload_2
    //   229: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 4
    //   235: ldc_w 1431
    //   238: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_1
    //   243: aload 4
    //   245: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 530	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   251: aload_3
    //   252: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	CrashlyticsController
    //   0	253	1	paramString1	String
    //   0	253	2	paramString2	String
    //   0	253	3	paramCodedOutputStreamWriteAction	CodedOutputStreamWriteAction
    //   1	243	4	localObject1	Object
    //   10	191	5	localObject2	Object
    //   4	48	6	localObject3	Object
    //   19	23	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   54	61	151	finally
    //   64	72	151	finally
    //   6	51	161	finally
  }
  
  private void writeSessionPartsToSessionFile(File paramFile, String paramString, int paramInt)
  {
    Object localObject1 = Logger.getLogger();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Collecting session parts for ID ");
    ((StringBuilder)localObject2).append(paramString);
    ((Logger)localObject1).d(((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("SessionCrash");
    localObject1 = listFilesMatching(new FileNameContainsFilter(((StringBuilder)localObject1).toString()));
    boolean bool1;
    if ((localObject1 != null) && (localObject1.length > 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Logger.getLogger().d(String.format(Locale.US, "Session %s has fatal exception: %s", new Object[] { paramString, Boolean.valueOf(bool1) }));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("SessionEvent");
    localObject2 = listFilesMatching(new FileNameContainsFilter(((StringBuilder)localObject2).toString()));
    boolean bool2;
    if ((localObject2 != null) && (localObject2.length > 0)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Logger.getLogger().d(String.format(Locale.US, "Session %s has non-fatal exceptions: %s", new Object[] { paramString, Boolean.valueOf(bool2) }));
    if ((!bool1) && (!bool2))
    {
      paramFile = Logger.getLogger();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("No events present for session ID ");
      ((StringBuilder)localObject1).append(paramString);
      paramFile.d(((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject2 = getTrimmedNonFatalFiles(paramString, (File[])localObject2, paramInt);
      if (bool1) {
        localObject1 = localObject1[0];
      } else {
        localObject1 = null;
      }
      synthesizeSessionFile(paramFile, paramString, (File[])localObject2, (File)localObject1);
    }
    paramFile = Logger.getLogger();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Removing session part files for ID ");
    ((StringBuilder)localObject1).append(paramString);
    paramFile.d(((StringBuilder)localObject1).toString());
    deleteFiles(listSessionPartFilesFor(paramString));
  }
  
  private void writeSessionUser(String paramString)
    throws Exception
  {
    writeSessionPartFile(paramString, "SessionUser", new CodedOutputStreamWriteAction()
    {
      public void writeTo(CodedOutputStream paramAnonymousCodedOutputStream)
        throws Exception
      {
        SessionProtobufHelper.writeSessionUser(paramAnonymousCodedOutputStream, this.val$metadata.getUserId(), null, null);
      }
    });
  }
  
  /* Error */
  private static void writeToCosFromFile(CodedOutputStream paramCodedOutputStream, File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 725	java/io/File:exists	()Z
    //   4: ifne +41 -> 45
    //   7: invokestatic 556	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   10: astore_0
    //   11: new 503	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   18: astore_2
    //   19: aload_2
    //   20: ldc_w 1455
    //   23: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload_2
    //   28: aload_1
    //   29: invokevirtual 906	java/io/File:getName	()Ljava/lang/String;
    //   32: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_0
    //   37: aload_2
    //   38: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokevirtual 1457	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;)V
    //   44: return
    //   45: aconst_null
    //   46: astore_2
    //   47: new 1459	java/io/FileInputStream
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 1460	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: astore_3
    //   56: aload_3
    //   57: aload_0
    //   58: aload_1
    //   59: invokevirtual 1463	java/io/File:length	()J
    //   62: l2i
    //   63: invokestatic 1465	com/google/firebase/crashlytics/internal/common/CrashlyticsController:copyToCodedOutputStream	(Ljava/io/InputStream;Lcom/google/firebase/crashlytics/internal/proto/CodedOutputStream;I)V
    //   66: aload_3
    //   67: ldc_w 1467
    //   70: invokestatic 530	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   73: return
    //   74: astore_1
    //   75: aload_3
    //   76: astore_0
    //   77: goto +6 -> 83
    //   80: astore_1
    //   81: aload_2
    //   82: astore_0
    //   83: aload_0
    //   84: ldc_w 1467
    //   87: invokestatic 530	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramCodedOutputStream	CodedOutputStream
    //   0	92	1	paramFile	File
    //   18	64	2	localStringBuilder	StringBuilder
    //   55	21	3	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   56	66	74	finally
    //   47	56	80	finally
  }
  
  Task<Boolean> checkForUnsentReports()
  {
    if (!this.checkForUnsentReportsCalled.compareAndSet(false, true))
    {
      Logger.getLogger().d("checkForUnsentReports should only be called once per execution.");
      return Tasks.forResult(Boolean.valueOf(false));
    }
    return this.unsentReportsAvailable.getTask();
  }
  
  void cleanInvalidTempFiles()
  {
    this.backgroundWorker.submit(new Runnable()
    {
      public void run()
      {
        CrashlyticsController localCrashlyticsController = CrashlyticsController.this;
        localCrashlyticsController.doCleanInvalidTempFiles(localCrashlyticsController.listFilesMatching(new CrashlyticsController.InvalidPartFileFilter()));
      }
    });
  }
  
  Task<Void> deleteUnsentReports()
  {
    this.reportActionProvided.trySetResult(Boolean.valueOf(false));
    return this.unsentReportsHandled.getTask();
  }
  
  boolean didCrashOnPreviousExecution()
  {
    if (!this.crashMarker.isPresent())
    {
      String str = getCurrentSessionId();
      return (str != null) && (this.nativeComponent.hasCrashDataForSession(str));
    }
    Logger.getLogger().d("Found previous crash marker.");
    this.crashMarker.remove();
    return Boolean.TRUE.booleanValue();
  }
  
  void doCleanInvalidTempFiles(File[] paramArrayOfFile)
  {
    final Object localObject1 = new HashSet();
    int k = paramArrayOfFile.length;
    int j = 0;
    int i = 0;
    Object localObject2;
    Object localObject3;
    while (i < k)
    {
      localObject2 = paramArrayOfFile[i];
      localObject3 = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Found invalid session part file: ");
      localStringBuilder.append(localObject2);
      ((Logger)localObject3).d(localStringBuilder.toString());
      ((Set)localObject1).add(getSessionIdFromSessionFile((File)localObject2));
      i += 1;
    }
    if (((Set)localObject1).isEmpty()) {
      return;
    }
    paramArrayOfFile = listFilesMatching(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        if (paramAnonymousString.length() < 35) {
          return false;
        }
        return localObject1.contains(paramAnonymousString.substring(0, 35));
      }
    });
    k = paramArrayOfFile.length;
    i = j;
    while (i < k)
    {
      localObject1 = paramArrayOfFile[i];
      localObject2 = Logger.getLogger();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Deleting invalid session file: ");
      ((StringBuilder)localObject3).append(localObject1);
      ((Logger)localObject2).d(((StringBuilder)localObject3).toString());
      ((File)localObject1).delete();
      i += 1;
    }
  }
  
  void doCloseSessions(int paramInt)
    throws Exception
  {
    doCloseSessions(paramInt, false);
  }
  
  void enableExceptionHandling(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, SettingsDataProvider paramSettingsDataProvider)
  {
    openSession();
    paramUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener()
    {
      public void onUncaughtException(SettingsDataProvider paramAnonymousSettingsDataProvider, Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        CrashlyticsController.this.handleUncaughtException(paramAnonymousSettingsDataProvider, paramAnonymousThread, paramAnonymousThrowable);
      }
    }, paramSettingsDataProvider, paramUncaughtExceptionHandler);
    this.crashHandler = paramUncaughtExceptionHandler;
    Thread.setDefaultUncaughtExceptionHandler(paramUncaughtExceptionHandler);
  }
  
  boolean finalizeSessions(int paramInt)
  {
    this.backgroundWorker.checkRunningOnThread();
    if (isHandlingException())
    {
      Logger.getLogger().d("Skipping session finalization because a crash has already occurred.");
      return Boolean.FALSE.booleanValue();
    }
    Logger.getLogger().d("Finalizing previously open sessions.");
    try
    {
      doCloseSessions(paramInt, true);
      Logger.getLogger().d("Closed all previously open sessions");
      return true;
    }
    catch (Exception localException)
    {
      Logger.getLogger().e("Unable to finalize previously open sessions.", localException);
    }
    return false;
  }
  
  File getFatalSessionFilesDir()
  {
    return new File(getFilesDir(), "fatal-sessions");
  }
  
  File getFilesDir()
  {
    return this.fileStore.getFilesDir();
  }
  
  File getNativeSessionFilesDir()
  {
    return new File(getFilesDir(), "native-sessions");
  }
  
  File getNonFatalSessionFilesDir()
  {
    return new File(getFilesDir(), "nonfatal-sessions");
  }
  
  UserMetadata getUserMetadata()
  {
    return this.userMetadata;
  }
  
  /* Error */
  void handleUncaughtException(final SettingsDataProvider paramSettingsDataProvider, final Thread paramThread, final Throwable paramThrowable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 556	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   5: astore 4
    //   7: new 503	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 504	java/lang/StringBuilder:<init>	()V
    //   14: astore 5
    //   16: aload 5
    //   18: ldc_w 1551
    //   21: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 5
    //   27: aload_3
    //   28: invokevirtual 681	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 5
    //   34: ldc_w 683
    //   37: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 5
    //   43: aload_2
    //   44: invokevirtual 688	java/lang/Thread:getName	()Ljava/lang/String;
    //   47: invokevirtual 510	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 4
    //   53: aload 5
    //   55: invokevirtual 518	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokevirtual 561	com/google/firebase/crashlytics/internal/Logger:d	(Ljava/lang/String;)V
    //   61: new 808	java/util/Date
    //   64: dup
    //   65: invokespecial 809	java/util/Date:<init>	()V
    //   68: astore 4
    //   70: aload_0
    //   71: getfield 305	com/google/firebase/crashlytics/internal/common/CrashlyticsController:backgroundWorker	Lcom/google/firebase/crashlytics/internal/common/CrashlyticsBackgroundWorker;
    //   74: new 44	com/google/firebase/crashlytics/internal/common/CrashlyticsController$6
    //   77: dup
    //   78: aload_0
    //   79: aload 4
    //   81: aload_3
    //   82: aload_2
    //   83: aload_1
    //   84: invokespecial 1554	com/google/firebase/crashlytics/internal/common/CrashlyticsController$6:<init>	(Lcom/google/firebase/crashlytics/internal/common/CrashlyticsController;Ljava/util/Date;Ljava/lang/Throwable;Ljava/lang/Thread;Lcom/google/firebase/crashlytics/internal/settings/SettingsDataProvider;)V
    //   87: invokevirtual 1557	com/google/firebase/crashlytics/internal/common/CrashlyticsBackgroundWorker:submitTask	(Ljava/util/concurrent/Callable;)Lcom/google/android/gms/tasks/Task;
    //   90: astore_1
    //   91: aload_1
    //   92: invokestatic 1561	com/google/firebase/crashlytics/internal/common/Utils:awaitEvenIfOnMainThread	(Lcom/google/android/gms/tasks/Task;)Ljava/lang/Object;
    //   95: pop
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    //   104: astore_1
    //   105: goto -9 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	CrashlyticsController
    //   0	108	1	paramSettingsDataProvider	SettingsDataProvider
    //   0	108	2	paramThread	Thread
    //   0	108	3	paramThrowable	Throwable
    //   5	75	4	localObject	Object
    //   14	40	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	91	99	finally
    //   91	96	99	finally
    //   91	96	104	java/lang/Exception
  }
  
  boolean hasOpenSession()
  {
    return listSessionBeginFiles().length > 0;
  }
  
  boolean isHandlingException()
  {
    CrashlyticsUncaughtExceptionHandler localCrashlyticsUncaughtExceptionHandler = this.crashHandler;
    return (localCrashlyticsUncaughtExceptionHandler != null) && (localCrashlyticsUncaughtExceptionHandler.isHandlingException());
  }
  
  File[] listAppExceptionMarkerFiles()
  {
    return listFilesMatching(APP_EXCEPTION_MARKER_FILTER);
  }
  
  File[] listCompleteSessionFiles()
  {
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, listFilesMatching(getFatalSessionFilesDir(), SESSION_FILE_FILTER));
    Collections.addAll(localLinkedList, listFilesMatching(getNonFatalSessionFilesDir(), SESSION_FILE_FILTER));
    Collections.addAll(localLinkedList, listFilesMatching(getFilesDir(), SESSION_FILE_FILTER));
    return (File[])localLinkedList.toArray(new File[localLinkedList.size()]);
  }
  
  File[] listNativeSessionFileDirectories()
  {
    return ensureFileArrayNotNull(getNativeSessionFilesDir().listFiles());
  }
  
  File[] listSessionBeginFiles()
  {
    return listFilesMatching(SESSION_BEGIN_FILE_FILTER);
  }
  
  void openSession()
  {
    this.backgroundWorker.submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        CrashlyticsController.this.doOpenSession();
        return null;
      }
    });
  }
  
  Task<Void> sendUnsentReports()
  {
    this.reportActionProvided.trySetResult(Boolean.valueOf(true));
    return this.unsentReportsHandled.getTask();
  }
  
  void setCustomKey(String paramString1, String paramString2)
  {
    try
    {
      this.userMetadata.setCustomKey(paramString1, paramString2);
      cacheKeyData(this.userMetadata.getCustomKeys());
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString2 = this.context;
      if ((paramString2 != null) && (CommonUtils.isAppDebuggable(paramString2))) {
        throw paramString1;
      }
      Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
    }
  }
  
  void setUserId(String paramString)
  {
    this.userMetadata.setUserId(paramString);
    cacheUserData(this.userMetadata);
  }
  
  Task<Void> submitAllReports(final float paramFloat, final Task<AppSettingsData> paramTask)
  {
    if (!this.reportManager.areReportsAvailable())
    {
      Logger.getLogger().d("No reports are available.");
      this.unsentReportsAvailable.trySetResult(Boolean.valueOf(false));
      return Tasks.forResult(null);
    }
    Logger.getLogger().d("Unsent reports are available.");
    waitForReportAction().onSuccessTask(new SuccessContinuation()
    {
      public Task<Void> then(final Boolean paramAnonymousBoolean)
        throws Exception
      {
        CrashlyticsController.this.backgroundWorker.submitTask(new Callable()
        {
          public Task<Void> call()
            throws Exception
          {
            final List localList = CrashlyticsController.this.reportManager.findReports();
            if (!paramAnonymousBoolean.booleanValue())
            {
              Logger.getLogger().d("Reports are being deleted.");
              CrashlyticsController.deleteFiles(CrashlyticsController.this.listAppExceptionMarkerFiles());
              CrashlyticsController.this.reportManager.deleteReports(localList);
              CrashlyticsController.this.reportingCoordinator.removeAllReports();
              CrashlyticsController.this.unsentReportsHandled.trySetResult(null);
              return Tasks.forResult(null);
            }
            Logger.getLogger().d("Reports are being sent.");
            final boolean bool = paramAnonymousBoolean.booleanValue();
            CrashlyticsController.this.dataCollectionArbiter.grantDataCollectionPermission(bool);
            final Executor localExecutor = CrashlyticsController.this.backgroundWorker.getExecutor();
            CrashlyticsController.8.this.val$appSettingsDataTask.onSuccessTask(localExecutor, new SuccessContinuation()
            {
              public Task<Void> then(AppSettingsData paramAnonymous3AppSettingsData)
                throws Exception
              {
                if (paramAnonymous3AppSettingsData == null)
                {
                  Logger.getLogger().w("Received null app settings, cannot send reports during app startup.");
                  return Tasks.forResult(null);
                }
                Iterator localIterator = localList.iterator();
                while (localIterator.hasNext())
                {
                  Report localReport = (Report)localIterator.next();
                  if (localReport.getType() == Report.Type.JAVA) {
                    CrashlyticsController.appendOrganizationIdToSessionFile(paramAnonymous3AppSettingsData.organizationId, localReport.getFile());
                  }
                }
                CrashlyticsController.this.logAnalyticsAppExceptionEvents();
                CrashlyticsController.this.reportUploaderProvider.createReportUploader(paramAnonymous3AppSettingsData).uploadReportsAsync(localList, bool, CrashlyticsController.8.this.val$delay);
                CrashlyticsController.this.reportingCoordinator.sendReports(localExecutor, DataTransportState.getState(paramAnonymous3AppSettingsData));
                CrashlyticsController.this.unsentReportsHandled.trySetResult(null);
                return Tasks.forResult(null);
              }
            });
          }
        });
      }
    });
  }
  
  void trimSessionFiles(int paramInt)
  {
    paramInt -= Utils.capSessionCount(getNativeSessionFilesDir(), getFatalSessionFilesDir(), paramInt, SMALLEST_FILE_NAME_FIRST);
    int i = Utils.capFileCount(getNonFatalSessionFilesDir(), paramInt, SMALLEST_FILE_NAME_FIRST);
    Utils.capFileCount(getFilesDir(), SESSION_FILE_FILTER, paramInt - i, SMALLEST_FILE_NAME_FIRST);
  }
  
  void writeNonFatalException(final Thread paramThread, final Throwable paramThrowable)
  {
    final Date localDate = new Date();
    this.backgroundWorker.submit(new Runnable()
    {
      public void run()
      {
        if (!CrashlyticsController.this.isHandlingException())
        {
          long l = CrashlyticsController.getTimestampSeconds(localDate);
          String str = CrashlyticsController.this.getCurrentSessionId();
          if (str == null)
          {
            Logger.getLogger().d("Tried to write a non-fatal exception while no session was open.");
            return;
          }
          CrashlyticsController.this.reportingCoordinator.persistNonFatalEvent(paramThrowable, paramThread, CrashlyticsController.makeFirebaseSessionIdentifier(str), l);
          CrashlyticsController.this.doWriteNonFatal(paramThread, paramThrowable, str, l);
        }
      }
    });
  }
  
  void writeToLog(final long paramLong, String paramString)
  {
    this.backgroundWorker.submit(new Callable()
    {
      public Void call()
        throws Exception
      {
        if (!CrashlyticsController.this.isHandlingException()) {
          CrashlyticsController.this.logFileManager.writeToLog(paramLong, this.val$msg);
        }
        return null;
      }
    });
  }
  
  private static class AnySessionPartFileFilter
    implements FilenameFilter
  {
    public boolean accept(File paramFile, String paramString)
    {
      return (!CrashlyticsController.SESSION_FILE_FILTER.accept(paramFile, paramString)) && (CrashlyticsController.SESSION_FILE_PATTERN.matcher(paramString).matches());
    }
  }
  
  private static abstract interface CodedOutputStreamWriteAction
  {
    public abstract void writeTo(CodedOutputStream paramCodedOutputStream)
      throws Exception;
  }
  
  static class FileNameContainsFilter
    implements FilenameFilter
  {
    private final String string;
    
    public FileNameContainsFilter(String paramString)
    {
      this.string = paramString;
    }
    
    public boolean accept(File paramFile, String paramString)
    {
      return (paramString.contains(this.string)) && (!paramString.endsWith(".cls_temp"));
    }
  }
  
  static class InvalidPartFileFilter
    implements FilenameFilter
  {
    public boolean accept(File paramFile, String paramString)
    {
      return (ClsFileOutputStream.TEMP_FILENAME_FILTER.accept(paramFile, paramString)) || (paramString.contains("SessionMissingBinaryImages"));
    }
  }
  
  private static final class LogFileDirectoryProvider
    implements LogFileManager.DirectoryProvider
  {
    private static final String LOG_FILES_DIR = "log-files";
    private final FileStore rootFileStore;
    
    public LogFileDirectoryProvider(FileStore paramFileStore)
    {
      this.rootFileStore = paramFileStore;
    }
    
    public File getLogFileDir()
    {
      File localFile = new File(this.rootFileStore.getFilesDir(), "log-files");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return localFile;
    }
  }
  
  private final class ReportUploaderFilesProvider
    implements ReportUploader.ReportFilesProvider
  {
    private ReportUploaderFilesProvider() {}
    
    public File[] getCompleteSessionFiles()
    {
      return CrashlyticsController.this.listCompleteSessionFiles();
    }
    
    public File[] getNativeReportFiles()
    {
      return CrashlyticsController.this.listNativeSessionFileDirectories();
    }
  }
  
  private final class ReportUploaderHandlingExceptionCheck
    implements ReportUploader.HandlingExceptionCheck
  {
    private ReportUploaderHandlingExceptionCheck() {}
    
    public boolean isHandlingException()
    {
      return CrashlyticsController.this.isHandlingException();
    }
  }
  
  private static final class SendReportRunnable
    implements Runnable
  {
    private final Context context;
    private final boolean dataCollectionToken;
    private final Report report;
    private final ReportUploader reportUploader;
    
    public SendReportRunnable(Context paramContext, Report paramReport, ReportUploader paramReportUploader, boolean paramBoolean)
    {
      this.context = paramContext;
      this.report = paramReport;
      this.reportUploader = paramReportUploader;
      this.dataCollectionToken = paramBoolean;
    }
    
    public void run()
    {
      if (!CommonUtils.canTryConnection(this.context)) {
        return;
      }
      Logger.getLogger().d("Attempting to send crash report at time of crash...");
      this.reportUploader.uploadReport(this.report, this.dataCollectionToken);
    }
  }
  
  static class SessionPartFileFilter
    implements FilenameFilter
  {
    private final String sessionId;
    
    public SessionPartFileFilter(String paramString)
    {
      this.sessionId = paramString;
    }
    
    public boolean accept(File paramFile, String paramString)
    {
      paramFile = new StringBuilder();
      paramFile.append(this.sessionId);
      paramFile.append(".cls");
      boolean bool1 = paramString.equals(paramFile.toString());
      boolean bool2 = false;
      if (bool1) {
        return false;
      }
      bool1 = bool2;
      if (paramString.contains(this.sessionId))
      {
        bool1 = bool2;
        if (!paramString.endsWith(".cls_temp")) {
          bool1 = true;
        }
      }
      return bool1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\CrashlyticsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */