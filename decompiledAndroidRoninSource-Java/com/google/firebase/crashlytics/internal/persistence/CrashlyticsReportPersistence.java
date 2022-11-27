package com.google.firebase.crashlytics.internal.persistence;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class CrashlyticsReportPersistence
{
  private static final String EVENT_COUNTER_FORMAT = "%010d";
  private static final int EVENT_COUNTER_WIDTH = 10;
  private static final FilenameFilter EVENT_FILE_FILTER = CrashlyticsReportPersistence..Lambda.6.lambdaFactory$();
  private static final String EVENT_FILE_NAME_PREFIX = "event";
  private static final int EVENT_NAME_LENGTH;
  private static final Comparator<? super File> LATEST_SESSION_ID_FIRST_COMPARATOR;
  private static final int MAX_OPEN_SESSIONS = 8;
  private static final String NATIVE_REPORTS_DIRECTORY = "native-reports";
  private static final String NORMAL_EVENT_SUFFIX = "";
  private static final String OPEN_SESSIONS_DIRECTORY_NAME = "sessions";
  private static final String PRIORITY_EVENT_SUFFIX = "_";
  private static final String PRIORITY_REPORTS_DIRECTORY = "priority-reports";
  private static final String REPORTS_DIRECTORY = "reports";
  private static final String REPORT_FILE_NAME = "report";
  private static final CrashlyticsReportJsonTransform TRANSFORM;
  private static final String USER_FILE_NAME = "user";
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private static final String WORKING_DIRECTORY_NAME = "report-persistence";
  private final AtomicInteger eventCounter = new AtomicInteger(0);
  private final File nativeReportsDirectory;
  private final File openSessionsDirectory;
  private final File priorityReportsDirectory;
  private final File reportsDirectory;
  private final SettingsDataProvider settingsDataProvider;
  
  static
  {
    EVENT_NAME_LENGTH = 15;
    TRANSFORM = new CrashlyticsReportJsonTransform();
    LATEST_SESSION_ID_FIRST_COMPARATOR = CrashlyticsReportPersistence..Lambda.5.lambdaFactory$();
  }
  
  public CrashlyticsReportPersistence(File paramFile, SettingsDataProvider paramSettingsDataProvider)
  {
    paramFile = new File(paramFile, "report-persistence");
    this.openSessionsDirectory = new File(paramFile, "sessions");
    this.priorityReportsDirectory = new File(paramFile, "priority-reports");
    this.reportsDirectory = new File(paramFile, "reports");
    this.nativeReportsDirectory = new File(paramFile, "native-reports");
    this.settingsDataProvider = paramSettingsDataProvider;
  }
  
  private List<File> capAndGetOpenSessions(String paramString)
  {
    paramString = CrashlyticsReportPersistence..Lambda.2.lambdaFactory$(paramString);
    paramString = getFilesInDirectory(this.openSessionsDirectory, paramString);
    Collections.sort(paramString, LATEST_SESSION_ID_FIRST_COMPARATOR);
    if (paramString.size() <= 8) {
      return paramString;
    }
    Iterator localIterator = paramString.subList(8, paramString.size()).iterator();
    while (localIterator.hasNext()) {
      recursiveDelete((File)localIterator.next());
    }
    return paramString.subList(0, 8);
  }
  
  private static int capFilesCount(List<File> paramList, int paramInt)
  {
    int i = paramList.size();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      File localFile = (File)paramList.next();
      if (i <= paramInt) {
        return i;
      }
      recursiveDelete(localFile);
      i -= 1;
    }
    return i;
  }
  
  private void capFinalizedReports()
  {
    int i = this.settingsDataProvider.getSettings().getSessionData().maxCompleteSessionsCount;
    Object localObject = getAllFinalizedReportFiles();
    int j = ((List)localObject).size();
    if (j <= i) {
      return;
    }
    localObject = ((List)localObject).subList(i, j).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((File)((Iterator)localObject).next()).delete();
    }
  }
  
  private static List<File> combineReportFiles(List<File>... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int m = paramVarArgs.length;
    int k = 0;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += paramVarArgs[i].size();
      i += 1;
    }
    localArrayList.ensureCapacity(j);
    j = paramVarArgs.length;
    i = k;
    while (i < j)
    {
      localArrayList.addAll(paramVarArgs[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  private static String generateEventFilename(int paramInt, boolean paramBoolean)
  {
    String str2 = String.format(Locale.US, "%010d", new Object[] { Integer.valueOf(paramInt) });
    String str1;
    if (paramBoolean) {
      str1 = "_";
    } else {
      str1 = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("event");
    localStringBuilder.append(str2);
    localStringBuilder.append(str1);
    return localStringBuilder.toString();
  }
  
  private static List<File> getAllFilesInDirectory(File paramFile)
  {
    return getFilesInDirectory(paramFile, (FileFilter)null);
  }
  
  private List<File> getAllFinalizedReportFiles()
  {
    return sortAndCombineReportFiles(new List[] { combineReportFiles(new List[] { getAllFilesInDirectory(this.priorityReportsDirectory), getAllFilesInDirectory(this.nativeReportsDirectory) }), getAllFilesInDirectory(this.reportsDirectory) });
  }
  
  private static String getEventNameWithoutPriority(String paramString)
  {
    return paramString.substring(0, EVENT_NAME_LENGTH);
  }
  
  private static List<File> getFilesInDirectory(File paramFile, FileFilter paramFileFilter)
  {
    if (!paramFile.isDirectory()) {
      return Collections.emptyList();
    }
    if (paramFileFilter == null) {
      paramFile = paramFile.listFiles();
    } else {
      paramFile = paramFile.listFiles(paramFileFilter);
    }
    if (paramFile != null) {
      return Arrays.asList(paramFile);
    }
    return Collections.emptyList();
  }
  
  private static List<File> getFilesInDirectory(File paramFile, FilenameFilter paramFilenameFilter)
  {
    if (!paramFile.isDirectory()) {
      return Collections.emptyList();
    }
    if (paramFilenameFilter == null) {
      paramFile = paramFile.listFiles();
    } else {
      paramFile = paramFile.listFiles(paramFilenameFilter);
    }
    if (paramFile != null) {
      return Arrays.asList(paramFile);
    }
    return Collections.emptyList();
  }
  
  private File getSessionDirectoryById(String paramString)
  {
    return new File(this.openSessionsDirectory, paramString);
  }
  
  private static boolean isHighPriorityEventFile(String paramString)
  {
    return (paramString.startsWith("event")) && (paramString.endsWith("_"));
  }
  
  private static boolean isNormalPriorityEventFile(File paramFile, String paramString)
  {
    return (paramString.startsWith("event")) && (!paramString.endsWith("_"));
  }
  
  private static boolean makeDirectory(File paramFile)
  {
    return (paramFile.exists()) || (paramFile.mkdirs());
  }
  
  private static int oldestEventFileFirst(File paramFile1, File paramFile2)
  {
    return getEventNameWithoutPriority(paramFile1.getName()).compareTo(getEventNameWithoutPriority(paramFile2.getName()));
  }
  
  private static File prepareDirectory(File paramFile)
    throws IOException
  {
    if (makeDirectory(paramFile)) {
      return paramFile;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Could not create directory ");
    localStringBuilder.append(paramFile);
    throw new IOException(localStringBuilder.toString());
  }
  
  private static String readTextFile(File paramFile)
    throws IOException
  {
    Object localObject1 = new byte[' '];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramFile = new FileInputStream(paramFile);
    try
    {
      for (;;)
      {
        int i = paramFile.read((byte[])localObject1);
        if (i <= 0) {
          break;
        }
        localByteArrayOutputStream.write((byte[])localObject1, 0, i);
      }
      localObject1 = new String(localByteArrayOutputStream.toByteArray(), UTF_8);
      paramFile.close();
      return (String)localObject1;
    }
    finally {}
    try
    {
      paramFile.close();
      throw ((Throwable)localObject2);
    }
    finally {}
  }
  
  private static void recursiveDelete(File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        recursiveDelete(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  private static List<File> sortAndCombineReportFiles(List<File>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Collections.sort(paramVarArgs[i], LATEST_SESSION_ID_FIRST_COMPARATOR);
      i += 1;
    }
    return combineReportFiles(paramVarArgs);
  }
  
  private static void synthesizeNativeReportFile(File paramFile1, File paramFile2, CrashlyticsReport.FilesPayload paramFilesPayload, String paramString)
  {
    try
    {
      paramFilesPayload = TRANSFORM.reportFromJson(readTextFile(paramFile1)).withNdkPayload(paramFilesPayload);
      writeTextFile(new File(prepareDirectory(paramFile2), paramString), TRANSFORM.reportToJson(paramFilesPayload));
      return;
    }
    catch (IOException paramFile2)
    {
      paramFilesPayload = Logger.getLogger();
      paramString = new StringBuilder();
      paramString.append("Could not synthesize final native report file for ");
      paramString.append(paramFile1);
      paramFilesPayload.d(paramString.toString(), paramFile2);
    }
  }
  
  private void synthesizeReport(File paramFile, long paramLong)
  {
    Object localObject1 = getFilesInDirectory(paramFile, EVENT_FILE_FILTER);
    if (((List)localObject1).isEmpty())
    {
      localObject1 = Logger.getLogger();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("Session ");
      ((StringBuilder)localObject3).append(paramFile.getName());
      ((StringBuilder)localObject3).append(" has no events.");
      ((Logger)localObject1).d(((StringBuilder)localObject3).toString());
      return;
    }
    Collections.sort((List)localObject1);
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    boolean bool1 = false;
    Object localObject5;
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label213;
      }
      localObject3 = (File)((Iterator)localObject1).next();
      try
      {
        localArrayList.add(TRANSFORM.eventFromJson(readTextFile((File)localObject3)));
        if (!bool1)
        {
          boolean bool2 = isHighPriorityEventFile(((File)localObject3).getName());
          if (!bool2) {
            break;
          }
        }
        bool1 = true;
      }
      catch (IOException localIOException2)
      {
        localObject5 = Logger.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not add event to report for ");
        localStringBuilder.append(localObject3);
        ((Logger)localObject5).d(localStringBuilder.toString(), localIOException2);
      }
    }
    label213:
    Object localObject3 = null;
    Object localObject4 = new File(paramFile, "user");
    localObject1 = localObject3;
    Object localObject2;
    if (((File)localObject4).isFile()) {
      try
      {
        localObject1 = readTextFile((File)localObject4);
      }
      catch (IOException localIOException1)
      {
        localObject4 = Logger.getLogger();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("Could not read user ID file in ");
        ((StringBuilder)localObject5).append(paramFile.getName());
        ((Logger)localObject4).d(((StringBuilder)localObject5).toString(), localIOException1);
        localObject2 = localObject3;
      }
    }
    localObject3 = new File(paramFile, "report");
    if (bool1) {
      paramFile = this.priorityReportsDirectory;
    } else {
      paramFile = this.reportsDirectory;
    }
    synthesizeReportFile((File)localObject3, paramFile, localArrayList, paramLong, bool1, (String)localObject2);
  }
  
  private static void synthesizeReportFile(File paramFile1, File paramFile2, List<CrashlyticsReport.Session.Event> paramList, long paramLong, boolean paramBoolean, String paramString)
  {
    try
    {
      paramList = TRANSFORM.reportFromJson(readTextFile(paramFile1)).withSessionEndFields(paramLong, paramBoolean, paramString).withEvents(ImmutableList.from(paramList));
      paramString = paramList.getSession();
      if (paramString == null) {
        return;
      }
      writeTextFile(new File(prepareDirectory(paramFile2), paramString.getIdentifier()), TRANSFORM.reportToJson(paramList));
      return;
    }
    catch (IOException paramFile2)
    {
      paramList = Logger.getLogger();
      paramString = new StringBuilder();
      paramString.append("Could not synthesize final report file for ");
      paramString.append(paramFile1);
      paramList.d(paramString.toString(), paramFile2);
    }
  }
  
  private static int trimEvents(File paramFile, int paramInt)
  {
    paramFile = getFilesInDirectory(paramFile, CrashlyticsReportPersistence..Lambda.3.lambdaFactory$());
    Collections.sort(paramFile, CrashlyticsReportPersistence..Lambda.4.lambdaFactory$());
    return capFilesCount(paramFile, paramInt);
  }
  
  private static void writeTextFile(File paramFile, String paramString)
    throws IOException
  {
    paramFile = new OutputStreamWriter(new FileOutputStream(paramFile), UTF_8);
    try
    {
      paramFile.write(paramString);
      paramFile.close();
      return;
    }
    finally {}
    try
    {
      paramFile.close();
      throw paramString;
    }
    finally {}
  }
  
  public void deleteAllReports()
  {
    Iterator localIterator = getAllFinalizedReportFiles().iterator();
    while (localIterator.hasNext()) {
      ((File)localIterator.next()).delete();
    }
  }
  
  public void deleteFinalizedReport(String paramString)
  {
    paramString = CrashlyticsReportPersistence..Lambda.1.lambdaFactory$(paramString);
    paramString = combineReportFiles(new List[] { getFilesInDirectory(this.priorityReportsDirectory, paramString), getFilesInDirectory(this.nativeReportsDirectory, paramString), getFilesInDirectory(this.reportsDirectory, paramString) }).iterator();
    while (paramString.hasNext()) {
      ((File)paramString.next()).delete();
    }
  }
  
  public void finalizeReports(String paramString, long paramLong)
  {
    paramString = capAndGetOpenSessions(paramString).iterator();
    while (paramString.hasNext())
    {
      File localFile = (File)paramString.next();
      Logger localLogger = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Finalizing report for session ");
      localStringBuilder.append(localFile.getName());
      localLogger.d(localStringBuilder.toString());
      synthesizeReport(localFile, paramLong);
      recursiveDelete(localFile);
    }
    capFinalizedReports();
  }
  
  public void finalizeSessionWithNativeEvent(String paramString, CrashlyticsReport.FilesPayload paramFilesPayload)
  {
    synthesizeNativeReportFile(new File(getSessionDirectoryById(paramString), "report"), this.nativeReportsDirectory, paramFilesPayload, paramString);
  }
  
  public List<CrashlyticsReportWithSessionId> loadFinalizedReports()
  {
    Object localObject = getAllFinalizedReportFiles();
    ArrayList localArrayList = new ArrayList();
    localArrayList.ensureCapacity(((List)localObject).size());
    localObject = getAllFinalizedReportFiles().iterator();
    while (((Iterator)localObject).hasNext())
    {
      File localFile = (File)((Iterator)localObject).next();
      try
      {
        localArrayList.add(CrashlyticsReportWithSessionId.create(TRANSFORM.reportFromJson(readTextFile(localFile)), localFile.getName()));
      }
      catch (IOException localIOException)
      {
        Logger localLogger = Logger.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Could not load report file ");
        localStringBuilder.append(localFile);
        localStringBuilder.append("; deleting");
        localLogger.d(localStringBuilder.toString(), localIOException);
        localFile.delete();
      }
    }
    return localArrayList;
  }
  
  public void persistEvent(CrashlyticsReport.Session.Event paramEvent, String paramString)
  {
    persistEvent(paramEvent, paramString, false);
  }
  
  public void persistEvent(CrashlyticsReport.Session.Event paramEvent, String paramString, boolean paramBoolean)
  {
    int i = this.settingsDataProvider.getSettings().getSessionData().maxCustomExceptionEvents;
    File localFile = getSessionDirectoryById(paramString);
    paramEvent = TRANSFORM.eventToJson(paramEvent);
    Object localObject = generateEventFilename(this.eventCounter.getAndIncrement(), paramBoolean);
    try
    {
      writeTextFile(new File(localFile, (String)localObject), paramEvent);
    }
    catch (IOException paramEvent)
    {
      localObject = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not persist event for session ");
      localStringBuilder.append(paramString);
      ((Logger)localObject).d(localStringBuilder.toString(), paramEvent);
    }
    trimEvents(localFile, i);
  }
  
  public void persistReport(CrashlyticsReport paramCrashlyticsReport)
  {
    Object localObject1 = paramCrashlyticsReport.getSession();
    if (localObject1 == null)
    {
      Logger.getLogger().d("Could not get session for report");
      return;
    }
    localObject1 = ((CrashlyticsReport.Session)localObject1).getIdentifier();
    try
    {
      localObject2 = prepareDirectory(getSessionDirectoryById((String)localObject1));
      paramCrashlyticsReport = TRANSFORM.reportToJson(paramCrashlyticsReport);
      writeTextFile(new File((File)localObject2, "report"), paramCrashlyticsReport);
      return;
    }
    catch (IOException paramCrashlyticsReport)
    {
      Object localObject2 = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not persist report for session ");
      localStringBuilder.append((String)localObject1);
      ((Logger)localObject2).d(localStringBuilder.toString(), paramCrashlyticsReport);
    }
  }
  
  public void persistUserIdForSession(String paramString1, String paramString2)
  {
    Object localObject = getSessionDirectoryById(paramString2);
    try
    {
      writeTextFile(new File((File)localObject, "user"), paramString1);
      return;
    }
    catch (IOException paramString1)
    {
      localObject = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not persist user ID for session ");
      localStringBuilder.append(paramString2);
      ((Logger)localObject).d(localStringBuilder.toString(), paramString1);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\persistence\CrashlyticsReportPersistence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */