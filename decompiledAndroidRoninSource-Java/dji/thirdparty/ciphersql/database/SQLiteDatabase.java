package dji.thirdparty.ciphersql.database;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import dji.thirdparty.ciphersql.Cursor;
import dji.thirdparty.ciphersql.DatabaseErrorHandler;
import dji.thirdparty.ciphersql.DefaultDatabaseErrorHandler;
import dji.thirdparty.ciphersql.SQLException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

public class SQLiteDatabase
  extends SQLiteClosable
{
  private static final String COMMIT_SQL = "COMMIT;";
  public static final int CONFLICT_ABORT = 2;
  public static final int CONFLICT_FAIL = 3;
  public static final int CONFLICT_IGNORE = 4;
  public static final int CONFLICT_NONE = 0;
  public static final int CONFLICT_REPLACE = 5;
  public static final int CONFLICT_ROLLBACK = 1;
  private static final String[] CONFLICT_VALUES = { "", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE " };
  public static final int CREATE_IF_NECESSARY = 268435456;
  private static final Pattern EMAIL_IN_DB_PATTERN = Pattern.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
  private static final int EVENT_DB_CORRUPT = 75004;
  private static final int EVENT_DB_OPERATION = 52000;
  static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
  private static final String KEY_ENCODING = "UTF-8";
  private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
  private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
  private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
  private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
  private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
  public static final int MAX_SQL_CACHE_SIZE = 250;
  private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
  public static final String MEMORY = ":memory:";
  public static final int NO_LOCALIZED_COLLATORS = 16;
  public static final int OPEN_READONLY = 1;
  public static final int OPEN_READWRITE = 0;
  private static final int OPEN_READ_MASK = 1;
  private static final int QUERY_LOG_SQL_LENGTH = 64;
  private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
  public static final String SQLCIPHER_ANDROID_VERSION = "3.5.7";
  public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
  private static final String TAG = "Database";
  private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap();
  private static int sQueryLogTimeInMillis = 0;
  private int mCacheFullWarnings;
  Map<String, SQLiteCompiledSql> mCompiledQueries = new HashMap();
  private final DatabaseErrorHandler mErrorHandler;
  private CursorFactory mFactory;
  private int mFlags;
  private boolean mInnerTransactionIsSuccessful;
  private long mLastLockMessageTime = 0L;
  private String mLastSqlStatement = null;
  private final ReentrantLock mLock = new ReentrantLock(true);
  private long mLockAcquiredThreadTime = 0L;
  private long mLockAcquiredWallTime = 0L;
  private boolean mLockingEnabled = true;
  private int mMaxSqlCacheSize = 250;
  long mNativeHandle = 0L;
  private int mNumCacheHits;
  private int mNumCacheMisses;
  private String mPath;
  private String mPathForLogs = null;
  private WeakHashMap<SQLiteClosable, Object> mPrograms;
  private final int mSlowQueryThreshold;
  private Throwable mStackTrace = null;
  private final Map<String, SyncUpdateInfo> mSyncUpdateInfo = new HashMap();
  int mTempTableSequence = 0;
  private String mTimeClosed = null;
  private String mTimeOpened = null;
  private boolean mTransactionIsSuccessful;
  private SQLiteTransactionListener mTransactionListener;
  
  private SQLiteDatabase(String paramString, CursorFactory paramCursorFactory, int paramInt, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramString != null)
    {
      this.mFlags = paramInt;
      this.mPath = paramString;
      this.mSlowQueryThreshold = -1;
      this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
      this.mFactory = paramCursorFactory;
      this.mPrograms = new WeakHashMap();
      this.mErrorHandler = paramDatabaseErrorHandler;
      return;
    }
    throw new IllegalArgumentException("path should not be null");
  }
  
  public SQLiteDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, int paramInt)
  {
    this(paramString, paramCursorFactory, paramInt, null);
    openDatabaseInternal(paramArrayOfChar, null);
  }
  
  public SQLiteDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    this(paramString, paramCursorFactory, paramInt, null);
    openDatabaseInternal(paramArrayOfChar, paramSQLiteDatabaseHook);
  }
  
  /* Error */
  private void checkLockHoldTime()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void closeClosable()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean containsNull(char[] paramArrayOfChar)
  {
    return false;
  }
  
  public static SQLiteDatabase create(CursorFactory paramCursorFactory, String paramString)
  {
    if (paramString == null) {
      paramString = null;
    } else {
      paramString = paramString.toCharArray();
    }
    return openDatabase(":memory:", paramString, paramCursorFactory, 268435456);
  }
  
  public static SQLiteDatabase create(CursorFactory paramCursorFactory, char[] paramArrayOfChar)
  {
    return openDatabase(":memory:", paramArrayOfChar, paramCursorFactory, 268435456);
  }
  
  private native void dbclose();
  
  private native void dbopen(String paramString, int paramInt);
  
  /* Error */
  private void deallocCachedSqlStatements()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private native void enableSqlProfiling(String paramString);
  
  private native void enableSqlTracing(String paramString);
  
  public static String findEditTable(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf(' ');
      int j = paramString.indexOf(',');
      if ((i > 0) && ((i < j) || (j < 0))) {
        return paramString.substring(0, i);
      }
      String str = paramString;
      if (j > 0) {
        if (j >= i)
        {
          str = paramString;
          if (i >= 0) {}
        }
        else
        {
          str = paramString.substring(0, j);
        }
      }
      return str;
    }
    throw new IllegalStateException("Invalid tables");
  }
  
  private static ArrayList<SQLiteDatabase> getActiveDatabases()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (sActiveDatabases)
    {
      localArrayList.addAll(sActiveDatabases.keySet());
      return localArrayList;
    }
  }
  
  private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!paramSQLiteDatabase.isOpen()) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("pragma database_list;", null);
    while (paramSQLiteDatabase.moveToNext()) {
      localArrayList.add(new Pair(paramSQLiteDatabase.getString(1), paramSQLiteDatabase.getString(2)));
    }
    paramSQLiteDatabase.close();
    return localArrayList;
  }
  
  private byte[] getBytes(char[] paramArrayOfChar)
  {
    return null;
  }
  
  static ArrayList<SQLiteDebug.DbStats> getDbStats()
  {
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = getActiveDatabases().iterator();
    while (localIterator.hasNext())
    {
      SQLiteDatabase localSQLiteDatabase = (SQLiteDatabase)localIterator.next();
      if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen()))
      {
        int j = localSQLiteDatabase.native_getDbLookaside();
        Object localObject = localSQLiteDatabase.getPath();
        int i = ((String)localObject).lastIndexOf("/");
        if (i != -1) {
          i += 1;
        } else {
          i = 0;
        }
        String str1 = ((String)localObject).substring(i);
        ArrayList localArrayList2 = getAttachedDbs(localSQLiteDatabase);
        if (localArrayList2 != null)
        {
          i = 0;
          while (i < localArrayList2.size())
          {
            Pair localPair = (Pair)localArrayList2.get(i);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append((String)localPair.first);
            ((StringBuilder)localObject).append(".page_count;");
            long l = getPragmaVal(localSQLiteDatabase, ((StringBuilder)localObject).toString());
            if (i == 0)
            {
              localObject = str1;
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("  (attached) ");
              ((StringBuilder)localObject).append((String)localPair.first);
              String str2 = ((StringBuilder)localObject).toString();
              localObject = str2;
              if (((String)localPair.second).trim().length() > 0)
              {
                j = ((String)localPair.second).lastIndexOf("/");
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(str2);
                ((StringBuilder)localObject).append(" : ");
                str2 = (String)localPair.second;
                if (j != -1) {
                  j += 1;
                } else {
                  j = 0;
                }
                ((StringBuilder)localObject).append(str2.substring(j));
                localObject = ((StringBuilder)localObject).toString();
              }
              j = 0;
            }
            if (l > 0L) {
              localArrayList1.add(new SQLiteDebug.DbStats((String)localObject, l, localSQLiteDatabase.getPageSize(), j));
            }
            i += 1;
          }
        }
      }
    }
    return localArrayList1;
  }
  
  private String getPathForLogs()
  {
    return null;
  }
  
  /* Error */
  private static long getPragmaVal(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 318	dji/thirdparty/ciphersql/database/SQLiteDatabase:isOpen	()Z
    //   4: ifne +5 -> 9
    //   7: lconst_0
    //   8: lreturn
    //   9: aconst_null
    //   10: astore 4
    //   12: new 391	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   19: astore 5
    //   21: aload 5
    //   23: ldc_w 435
    //   26: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 5
    //   32: aload_1
    //   33: invokevirtual 400	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: new 437	dji/thirdparty/ciphersql/database/SQLiteStatement
    //   40: dup
    //   41: aload_0
    //   42: aload 5
    //   44: invokevirtual 405	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 440	dji/thirdparty/ciphersql/database/SQLiteStatement:<init>	(Ldji/thirdparty/ciphersql/database/SQLiteDatabase;Ljava/lang/String;)V
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 443	dji/thirdparty/ciphersql/database/SQLiteStatement:simpleQueryForLong	()J
    //   55: lstore_2
    //   56: aload_0
    //   57: invokevirtual 444	dji/thirdparty/ciphersql/database/SQLiteStatement:close	()V
    //   60: lload_2
    //   61: lreturn
    //   62: astore_1
    //   63: goto +7 -> 70
    //   66: astore_1
    //   67: aload 4
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull +7 -> 78
    //   74: aload_0
    //   75: invokevirtual 444	dji/thirdparty/ciphersql/database/SQLiteStatement:close	()V
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	80	1	paramString	String
    //   55	6	2	l	long
    //   10	58	4	localObject	Object
    //   19	24	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	56	62	finally
    //   12	51	66	finally
  }
  
  private String getTime()
  {
    return null;
  }
  
  private native void key(byte[] paramArrayOfByte)
    throws SQLException;
  
  /* Error */
  private void keyDatabase(SQLiteDatabaseHook arg1, Runnable arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private native void key_mutf8(char[] paramArrayOfChar)
    throws SQLException;
  
  /* Error */
  private static void loadICUData(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: new 455	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: ldc_w 457
    //   8: invokespecial 460	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   11: astore 5
    //   13: new 455	java/io/File
    //   16: dup
    //   17: aload 5
    //   19: ldc_w 462
    //   22: invokespecial 460	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   25: astore 7
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore_1
    //   32: aconst_null
    //   33: astore_3
    //   34: aconst_null
    //   35: astore 4
    //   37: aload 5
    //   39: invokevirtual 465	java/io/File:exists	()Z
    //   42: ifne +9 -> 51
    //   45: aload 5
    //   47: invokevirtual 468	java/io/File:mkdirs	()Z
    //   50: pop
    //   51: aload 7
    //   53: invokevirtual 465	java/io/File:exists	()Z
    //   56: ifne +98 -> 154
    //   59: new 470	java/util/zip/ZipInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokevirtual 476	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   67: ldc_w 478
    //   70: invokevirtual 484	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   73: invokespecial 487	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: astore_0
    //   77: aload_0
    //   78: astore_3
    //   79: aload_1
    //   80: astore 4
    //   82: aload_0
    //   83: invokevirtual 491	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   86: pop
    //   87: aload_0
    //   88: astore_3
    //   89: aload_1
    //   90: astore 4
    //   92: new 493	java/io/FileOutputStream
    //   95: dup
    //   96: aload 7
    //   98: invokespecial 496	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   101: astore_1
    //   102: sipush 1024
    //   105: newarray <illegal type>
    //   107: astore_3
    //   108: aload_0
    //   109: aload_3
    //   110: invokevirtual 500	java/util/zip/ZipInputStream:read	([B)I
    //   113: istore_2
    //   114: iload_2
    //   115: ifle +13 -> 128
    //   118: aload_1
    //   119: aload_3
    //   120: iconst_0
    //   121: iload_2
    //   122: invokevirtual 506	java/io/OutputStream:write	([BII)V
    //   125: goto -17 -> 108
    //   128: goto +31 -> 159
    //   131: astore 4
    //   133: aload_1
    //   134: astore_3
    //   135: aload 4
    //   137: astore_1
    //   138: goto +145 -> 283
    //   141: astore 5
    //   143: goto +79 -> 222
    //   146: astore 5
    //   148: aload 6
    //   150: astore_1
    //   151: goto +71 -> 222
    //   154: aconst_null
    //   155: astore_1
    //   156: aload 4
    //   158: astore_0
    //   159: aload_0
    //   160: ifnull +10 -> 170
    //   163: aload_0
    //   164: invokevirtual 507	java/util/zip/ZipInputStream:close	()V
    //   167: goto +3 -> 170
    //   170: aload_1
    //   171: ifnull +31 -> 202
    //   174: aload_1
    //   175: invokevirtual 510	java/io/OutputStream:flush	()V
    //   178: aload_1
    //   179: invokevirtual 511	java/io/OutputStream:close	()V
    //   182: return
    //   183: ldc 86
    //   185: ldc_w 513
    //   188: aload_0
    //   189: invokestatic 519	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   192: pop
    //   193: new 521	java/lang/RuntimeException
    //   196: dup
    //   197: aload_0
    //   198: invokespecial 524	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   201: athrow
    //   202: return
    //   203: astore_1
    //   204: aconst_null
    //   205: astore 4
    //   207: aload_3
    //   208: astore_0
    //   209: aload 4
    //   211: astore_3
    //   212: goto +71 -> 283
    //   215: astore 5
    //   217: aconst_null
    //   218: astore_0
    //   219: aload 6
    //   221: astore_1
    //   222: aload_0
    //   223: astore_3
    //   224: aload_1
    //   225: astore 4
    //   227: ldc 86
    //   229: ldc_w 526
    //   232: aload 5
    //   234: invokestatic 519	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   237: pop
    //   238: aload_0
    //   239: astore_3
    //   240: aload_1
    //   241: astore 4
    //   243: aload 7
    //   245: invokevirtual 465	java/io/File:exists	()Z
    //   248: ifeq +14 -> 262
    //   251: aload_0
    //   252: astore_3
    //   253: aload_1
    //   254: astore 4
    //   256: aload 7
    //   258: invokevirtual 529	java/io/File:delete	()Z
    //   261: pop
    //   262: aload_0
    //   263: astore_3
    //   264: aload_1
    //   265: astore 4
    //   267: new 521	java/lang/RuntimeException
    //   270: dup
    //   271: aload 5
    //   273: invokespecial 524	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   276: athrow
    //   277: astore_1
    //   278: aload_3
    //   279: astore_0
    //   280: aload 4
    //   282: astore_3
    //   283: aload_0
    //   284: ifnull +10 -> 294
    //   287: aload_0
    //   288: invokevirtual 507	java/util/zip/ZipInputStream:close	()V
    //   291: goto +3 -> 294
    //   294: aload_3
    //   295: ifnull +33 -> 328
    //   298: aload_3
    //   299: invokevirtual 510	java/io/OutputStream:flush	()V
    //   302: aload_3
    //   303: invokevirtual 511	java/io/OutputStream:close	()V
    //   306: goto +22 -> 328
    //   309: ldc 86
    //   311: ldc_w 513
    //   314: aload_0
    //   315: invokestatic 519	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   318: pop
    //   319: new 521	java/lang/RuntimeException
    //   322: dup
    //   323: aload_0
    //   324: invokespecial 524	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   327: athrow
    //   328: aload_1
    //   329: athrow
    //   330: astore_0
    //   331: goto -148 -> 183
    //   334: astore_0
    //   335: goto -26 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	338	0	paramContext	Context
    //   0	338	1	paramFile	File
    //   113	9	2	i	int
    //   33	270	3	localObject1	Object
    //   35	56	4	localFile1	File
    //   131	26	4	localObject2	Object
    //   205	76	4	localFile2	File
    //   11	35	5	localFile3	File
    //   141	1	5	localException1	Exception
    //   146	1	5	localException2	Exception
    //   215	57	5	localException3	Exception
    //   28	192	6	localObject3	Object
    //   25	232	7	localFile4	File
    // Exception table:
    //   from	to	target	type
    //   102	108	131	finally
    //   108	114	131	finally
    //   118	125	131	finally
    //   102	108	141	java/lang/Exception
    //   108	114	141	java/lang/Exception
    //   118	125	141	java/lang/Exception
    //   82	87	146	java/lang/Exception
    //   92	102	146	java/lang/Exception
    //   37	51	203	finally
    //   51	77	203	finally
    //   37	51	215	java/lang/Exception
    //   51	77	215	java/lang/Exception
    //   82	87	277	finally
    //   92	102	277	finally
    //   227	238	277	finally
    //   243	251	277	finally
    //   256	262	277	finally
    //   267	277	277	finally
    //   163	167	330	java/io/IOException
    //   174	182	330	java/io/IOException
    //   287	291	334	java/io/IOException
    //   298	306	334	java/io/IOException
  }
  
  public static void loadLibs(Context paramContext)
  {
    try
    {
      loadLibs(paramContext, paramContext.getFilesDir());
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void loadLibs(Context paramContext, LibraryLoader paramLibraryLoader)
  {
    try
    {
      loadLibs(paramContext, paramContext.getFilesDir(), paramLibraryLoader);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void loadLibs(Context paramContext, File paramFile)
  {
    try
    {
      loadLibs(paramContext, paramFile, new LibraryLoader()
      {
        /* Error */
        public void loadLibraries(String... arg1)
        {
          // Byte code:
          //   0: return
          //   1: astore_1
          //   2: goto -2 -> 0
        }
      });
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void loadLibs(Context paramContext, File paramFile, LibraryLoader paramLibraryLoader)
  {
    try
    {
      paramLibraryLoader.loadLibraries(new String[] { "djisqlcipher" });
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  private void lockForced()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void markTableSyncable(String arg1, String arg2, String arg3, String arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private native int native_getDbLookaside();
  
  private native void native_key(char[] paramArrayOfChar)
    throws SQLException;
  
  private native void native_rawExecSQL(String paramString);
  
  private native void native_rekey(String paramString)
    throws SQLException;
  
  private native int native_status(int paramInt, boolean paramBoolean);
  
  public static SQLiteDatabase openDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString1, paramString2, paramCursorFactory, paramInt, null);
  }
  
  public static SQLiteDatabase openDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openDatabase(paramString1, paramString2, paramCursorFactory, paramInt, paramSQLiteDatabaseHook, null);
  }
  
  public static SQLiteDatabase openDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramString2 == null) {
      paramString2 = null;
    } else {
      paramString2 = paramString2.toCharArray();
    }
    return openDatabase(paramString1, paramString2, paramCursorFactory, paramInt, paramSQLiteDatabaseHook, paramDatabaseErrorHandler);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, int paramInt)
  {
    return openDatabase(paramString, paramArrayOfChar, paramCursorFactory, paramInt, null, null);
  }
  
  public static SQLiteDatabase openDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openDatabase(paramString, paramArrayOfChar, paramCursorFactory, paramInt, paramSQLiteDatabaseHook, null);
  }
  
  public static SQLiteDatabase openDatabase(String arg0, char[] paramArrayOfChar, CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramDatabaseErrorHandler == null) {
      paramDatabaseErrorHandler = new DefaultDatabaseErrorHandler();
    }
    try
    {
      localSQLiteDatabase = new SQLiteDatabase(???, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
      try
      {
        localSQLiteDatabase.openDatabaseInternal(paramArrayOfChar, paramSQLiteDatabaseHook);
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException2)
    {
      localSQLiteDatabase = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("Calling error handler for corrupt database ");
    localStringBuilder.append(???);
    Log.e("Database", localStringBuilder.toString(), localSQLiteDatabaseCorruptException2);
    paramDatabaseErrorHandler.onCorruption(localSQLiteDatabase);
    SQLiteDatabase localSQLiteDatabase = new SQLiteDatabase(???, paramCursorFactory, paramInt, paramDatabaseErrorHandler);
    localSQLiteDatabase.openDatabaseInternal(paramArrayOfChar, paramSQLiteDatabaseHook);
    if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
      localSQLiteDatabase.enableSqlTracing(???);
    }
    if (SQLiteDebug.DEBUG_SQL_TIME) {
      localSQLiteDatabase.enableSqlProfiling(???);
    }
    synchronized (sActiveDatabases)
    {
      sActiveDatabases.put(localSQLiteDatabase, null);
      return localSQLiteDatabase;
    }
  }
  
  /* Error */
  private void openDatabaseInternal(char[] arg1, SQLiteDatabaseHook arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, String paramString, CursorFactory paramCursorFactory)
  {
    return openOrCreateDatabase(paramFile, paramString, paramCursorFactory, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, String paramString, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openOrCreateDatabase(paramFile, paramString, paramCursorFactory, paramSQLiteDatabaseHook, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(File paramFile, String paramString, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramFile == null) {
      paramFile = null;
    } else {
      paramFile = paramFile.getPath();
    }
    return openOrCreateDatabase(paramFile, paramString, paramCursorFactory, paramSQLiteDatabaseHook, paramDatabaseErrorHandler);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString1, paramString2, paramCursorFactory, 268435456, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openDatabase(paramString1, paramString2, paramCursorFactory, 268435456, paramSQLiteDatabaseHook);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString1, String paramString2, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    if (paramString2 == null) {
      paramString2 = null;
    } else {
      paramString2 = paramString2.toCharArray();
    }
    return openDatabase(paramString1, paramString2, paramCursorFactory, 268435456, paramSQLiteDatabaseHook, paramDatabaseErrorHandler);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory)
  {
    return openDatabase(paramString, paramArrayOfChar, paramCursorFactory, 268435456, null);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook)
  {
    return openDatabase(paramString, paramArrayOfChar, paramCursorFactory, 268435456, paramSQLiteDatabaseHook);
  }
  
  public static SQLiteDatabase openOrCreateDatabase(String paramString, char[] paramArrayOfChar, CursorFactory paramCursorFactory, SQLiteDatabaseHook paramSQLiteDatabaseHook, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return openDatabase(paramString, paramArrayOfChar, paramCursorFactory, 268435456, paramSQLiteDatabaseHook, paramDatabaseErrorHandler);
  }
  
  private native void rekey(byte[] paramArrayOfByte)
    throws SQLException;
  
  public static native int releaseMemory();
  
  public static native void setICURoot(String paramString);
  
  /* Error */
  private void unlockForced()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean yieldIfContendedHelper(boolean paramBoolean, long paramLong)
  {
    return false;
  }
  
  /* Error */
  void addSQLiteClosable(SQLiteClosable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void addToCompiledQueries(String arg1, SQLiteCompiledSql arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void beginTransaction()
  {
    beginTransactionWithListener(null);
  }
  
  /* Error */
  public void beginTransactionWithListener(SQLiteTransactionListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void changePassword(String arg1)
    throws SQLiteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void changePassword(char[] arg1)
    throws SQLiteException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public SQLiteStatement compileStatement(String paramString)
    throws SQLException
  {
    return null;
  }
  
  public int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return 0;
  }
  
  /* Error */
  public void endTransaction()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void execSQL(String arg1)
    throws SQLException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void execSQL(String arg1, Object[] arg2)
    throws SQLException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  SQLiteCompiledSql getCompiledStatementForSql(String paramString)
  {
    return null;
  }
  
  public int getMaxSqlCacheSize()
  {
    try
    {
      int i = this.mMaxSqlCacheSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long getMaximumSize()
  {
    return 277864658L;
  }
  
  public long getPageSize()
  {
    return 277864674L;
  }
  
  public final String getPath()
  {
    return this.mPath;
  }
  
  public Map<String, String> getSyncedTables()
  {
    return null;
  }
  
  public int getVersion()
  {
    return 0;
  }
  
  public boolean inTransaction()
  {
    return false;
  }
  
  public long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return 277864728L;
  }
  
  public long insertOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
    throws SQLException
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 0);
  }
  
  public long insertWithOnConflict(String paramString1, String paramString2, ContentValues paramContentValues, int paramInt)
  {
    return 277864745L;
  }
  
  public boolean isDbLockedByCurrentThread()
  {
    return this.mLock.isHeldByCurrentThread();
  }
  
  public boolean isDbLockedByOtherThreads()
  {
    return false;
  }
  
  public boolean isInCompiledSqlCache(String paramString)
  {
    return false;
  }
  
  public boolean isOpen()
  {
    return false;
  }
  
  public boolean isReadOnly()
  {
    return false;
  }
  
  native int lastChangeCount();
  
  native long lastInsertRow();
  
  /* Error */
  void lock()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void markTableSyncable(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void markTableSyncable(String arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  native void native_execSQL(String paramString)
    throws SQLException;
  
  native void native_setLocale(String paramString, int paramInt);
  
  public boolean needUpgrade(int paramInt)
  {
    return false;
  }
  
  /* Error */
  protected void onAllReferencesReleased()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void onCorruption()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void purgeFromCompiledSqlCache(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    return null;
  }
  
  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return null;
  }
  
  public Cursor query(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return null;
  }
  
  public Cursor queryWithFactory(CursorFactory paramCursorFactory, boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return null;
  }
  
  /* Error */
  public void rawExecSQL(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Cursor rawQuery(String paramString, Object[] paramArrayOfObject)
  {
    return null;
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    return rawQueryWithFactory(null, paramString, paramArrayOfString, null);
  }
  
  public Cursor rawQuery(String paramString, String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public Cursor rawQueryWithFactory(CursorFactory paramCursorFactory, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return null;
  }
  
  /* Error */
  void removeSQLiteClosable(SQLiteClosable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    return 277865074L;
  }
  
  public long replaceOrThrow(String paramString1, String paramString2, ContentValues paramContentValues)
    throws SQLException
  {
    return insertWithOnConflict(paramString1, paramString2, paramContentValues, 5);
  }
  
  /* Error */
  public void resetCompiledSqlCache()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  void rowUpdated(String arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void setLocale(java.util.Locale arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setLockingEnabled(boolean paramBoolean)
  {
    this.mLockingEnabled = paramBoolean;
  }
  
  /* Error */
  public void setMaxSqlCacheSize(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public long setMaximumSize(long paramLong)
  {
    return 277865135L;
  }
  
  /* Error */
  public void setPageSize(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setTransactionSuccessful()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setVersion(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public int status(int paramInt, boolean paramBoolean)
  {
    return native_status(paramInt, paramBoolean);
  }
  
  /* Error */
  void unlock()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public int updateWithOnConflict(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString, int paramInt)
  {
    return 0;
  }
  
  @Deprecated
  public boolean yieldIfContended()
  {
    return false;
  }
  
  public boolean yieldIfContendedSafely()
  {
    return false;
  }
  
  public boolean yieldIfContendedSafely(long paramLong)
  {
    return false;
  }
  
  public static abstract interface CursorFactory
  {
    public abstract Cursor newCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery);
  }
  
  public static abstract interface LibraryLoader
  {
    public abstract void loadLibraries(String... paramVarArgs);
  }
  
  private static class SyncUpdateInfo
  {
    String deletedTable;
    String foreignKey;
    String masterTable;
    
    SyncUpdateInfo(String paramString1, String paramString2, String paramString3)
    {
      this.masterTable = paramString1;
      this.deletedTable = paramString2;
      this.foreignKey = paramString3;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\SQLiteDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */