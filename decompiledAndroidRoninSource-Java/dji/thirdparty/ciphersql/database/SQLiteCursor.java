package dji.thirdparty.ciphersql.database;

import android.os.Handler;
import android.os.Message;
import dji.thirdparty.ciphersql.AbstractWindowedCursor;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class SQLiteCursor
  extends AbstractWindowedCursor
{
  static final int NO_COUNT = -1;
  static final String TAG = "Cursor";
  private Map<String, Integer> mColumnNameMap;
  private String[] mColumns;
  private int mCount = -1;
  private int mCursorState;
  private SQLiteDatabase mDatabase;
  private SQLiteCursorDriver mDriver;
  private String mEditTable;
  private int mInitialRead = Integer.MAX_VALUE;
  private ReentrantLock mLock;
  private int mMaxRead = Integer.MAX_VALUE;
  protected MainThreadNotificationHandler mNotificationHandler;
  private boolean mPendingData;
  private SQLiteQuery mQuery;
  private Throwable mStackTrace;
  
  public SQLiteCursor(SQLiteDatabase paramSQLiteDatabase, SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    int i = 0;
    this.mCursorState = 0;
    this.mLock = null;
    this.mPendingData = false;
    this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
    this.mDatabase = paramSQLiteDatabase;
    this.mDriver = paramSQLiteCursorDriver;
    this.mEditTable = paramString;
    this.mColumnNameMap = null;
    this.mQuery = paramSQLiteQuery;
    try
    {
      paramSQLiteDatabase.lock();
      int j = this.mQuery.columnCountLocked();
      this.mColumns = new String[j];
      while (i < j)
      {
        paramSQLiteCursorDriver = this.mQuery.columnNameLocked(i);
        this.mColumns[i] = paramSQLiteCursorDriver;
        if ("_id".equals(paramSQLiteCursorDriver)) {
          this.mRowIdColumnIndex = i;
        }
        i += 1;
      }
      return;
    }
    finally
    {
      paramSQLiteDatabase.unlock();
    }
  }
  
  /* Error */
  private void deactivateCommon()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void fillWindow(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  private void queryThreadLock()
  {
    ReentrantLock localReentrantLock = this.mLock;
    if (localReentrantLock != null) {
      localReentrantLock.lock();
    }
  }
  
  private void queryThreadUnlock()
  {
    ReentrantLock localReentrantLock = this.mLock;
    if (localReentrantLock != null) {
      localReentrantLock.unlock();
    }
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> paramMap)
  {
    return false;
  }
  
  /* Error */
  public void deactivate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean deleteRow()
  {
    return false;
  }
  
  /* Error */
  public void fillWindow(int arg1, android.database.CursorWindow arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public int getColumnIndex(String paramString)
  {
    return 0;
  }
  
  public String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public SQLiteDatabase getDatabase()
  {
    return this.mDatabase;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  /* Error */
  public void registerDataSetObserver(android.database.DataSetObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean requery()
  {
    return false;
  }
  
  public void setLoadStyle(int paramInt1, int paramInt2)
  {
    this.mMaxRead = paramInt2;
    this.mInitialRead = paramInt1;
    this.mLock = new ReentrantLock(true);
  }
  
  public void setSelectionArguments(String[] paramArrayOfString)
  {
    this.mDriver.setBindArguments(paramArrayOfString);
  }
  
  /* Error */
  public void setWindow(dji.thirdparty.ciphersql.CursorWindow arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean supportsUpdates()
  {
    return false;
  }
  
  protected static class MainThreadNotificationHandler
    extends Handler
  {
    private final WeakReference<SQLiteCursor> wrappedCursor;
    
    MainThreadNotificationHandler(SQLiteCursor paramSQLiteCursor)
    {
      this.wrappedCursor = new WeakReference(paramSQLiteCursor);
    }
    
    public void handleMessage(Message paramMessage)
    {
      paramMessage = (SQLiteCursor)this.wrappedCursor.get();
      if (paramMessage != null) {
        paramMessage.notifyDataSetChange();
      }
    }
  }
  
  private final class QueryThread
    implements Runnable
  {
    private final int mThreadState;
    
    QueryThread(int paramInt)
    {
      this.mThreadState = paramInt;
    }
    
    /* Error */
    private void sendMessage()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\database\SQLiteCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */