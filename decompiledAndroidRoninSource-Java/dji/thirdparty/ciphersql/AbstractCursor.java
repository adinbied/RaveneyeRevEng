package dji.thirdparty.ciphersql;

import android.content.ContentResolver;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.CrossProcessCursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor
  implements CrossProcessCursor, Cursor
{
  private static final String TAG = "Cursor";
  protected boolean mClosed = false;
  ContentObservable mContentObservable = new ContentObservable();
  protected ContentResolver mContentResolver;
  protected Long mCurrentRowID = null;
  DataSetObservable mDataSetObservable = new DataSetObservable();
  private Bundle mExtras = Bundle.EMPTY;
  private Uri mNotifyUri;
  protected int mPos = -1;
  protected int mRowIdColumnIndex = -1;
  private ContentObserver mSelfObserver;
  private final Object mSelfObserverLock = new Object();
  private boolean mSelfObserverRegistered;
  protected HashMap<Long, Map<String, Object>> mUpdatedRows = new HashMap();
  
  /* Error */
  public void abortUpdates()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void checkPosition()
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
    //   2: goto -2 -> 0
  }
  
  public boolean commitUpdates()
  {
    return commitUpdates(null);
  }
  
  public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> paramMap)
  {
    return false;
  }
  
  /* Error */
  public void copyStringToBuffer(int arg1, android.database.CharArrayBuffer arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void deactivate()
  {
    deactivateInternal();
  }
  
  /* Error */
  public void deactivateInternal()
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
  
  public void fillWindow(int paramInt, android.database.CursorWindow paramCursorWindow)
  {
    DatabaseUtils.cursorFillWindow(this, paramInt, paramCursorWindow);
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public byte[] getBlob(int paramInt)
  {
    throw new UnsupportedOperationException("getBlob is not supported");
  }
  
  public int getColumnCount()
  {
    return getColumnNames().length;
  }
  
  public int getColumnIndex(String paramString)
  {
    return 0;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    return 0;
  }
  
  public String getColumnName(int paramInt)
  {
    return getColumnNames()[paramInt];
  }
  
  public abstract String[] getColumnNames();
  
  public abstract int getCount();
  
  protected DataSetObservable getDataSetObservable()
  {
    return this.mDataSetObservable;
  }
  
  public abstract double getDouble(int paramInt);
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public abstract float getFloat(int paramInt);
  
  public abstract int getInt(int paramInt);
  
  public abstract long getLong(int paramInt);
  
  public Uri getNotificationUri()
  {
    return this.mNotifyUri;
  }
  
  public final int getPosition()
  {
    return this.mPos;
  }
  
  public abstract short getShort(int paramInt);
  
  public abstract String getString(int paramInt);
  
  public abstract int getType(int paramInt);
  
  protected Object getUpdatedField(int paramInt)
  {
    return null;
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    return false;
  }
  
  public CursorWindow getWindow()
  {
    return null;
  }
  
  public boolean hasUpdates()
  {
    return false;
  }
  
  public final boolean isAfterLast()
  {
    return false;
  }
  
  public final boolean isBeforeFirst()
  {
    return false;
  }
  
  public boolean isClosed()
  {
    return this.mClosed;
  }
  
  protected boolean isFieldUpdated(int paramInt)
  {
    return false;
  }
  
  public final boolean isFirst()
  {
    return false;
  }
  
  public final boolean isLast()
  {
    return false;
  }
  
  public abstract boolean isNull(int paramInt);
  
  public final boolean move(int paramInt)
  {
    return moveToPosition(this.mPos + paramInt);
  }
  
  public final boolean moveToFirst()
  {
    return moveToPosition(0);
  }
  
  public final boolean moveToLast()
  {
    return false;
  }
  
  public final boolean moveToNext()
  {
    return false;
  }
  
  public final boolean moveToPosition(int paramInt)
  {
    return false;
  }
  
  public final boolean moveToPrevious()
  {
    return false;
  }
  
  protected void notifyDataSetChange()
  {
    this.mDataSetObservable.notifyChanged();
  }
  
  /* Error */
  protected void onChange(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    this.mContentObservable.registerObserver(paramContentObserver);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDataSetObservable.registerObserver(paramDataSetObserver);
  }
  
  public boolean requery()
  {
    return false;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    return Bundle.EMPTY;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = Bundle.EMPTY;
    }
    this.mExtras = localBundle;
  }
  
  /* Error */
  public void setNotificationUri(ContentResolver arg1, Uri arg2)
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
  
  /* Error */
  public void unregisterContentObserver(ContentObserver arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDataSetObservable.unregisterObserver(paramDataSetObserver);
  }
  
  public boolean update(int paramInt, Object paramObject)
  {
    return false;
  }
  
  public boolean updateBlob(int paramInt, byte[] paramArrayOfByte)
  {
    return update(paramInt, paramArrayOfByte);
  }
  
  public boolean updateDouble(int paramInt, double paramDouble)
  {
    return update(paramInt, Double.valueOf(paramDouble));
  }
  
  public boolean updateFloat(int paramInt, float paramFloat)
  {
    return update(paramInt, Float.valueOf(paramFloat));
  }
  
  public boolean updateInt(int paramInt1, int paramInt2)
  {
    return update(paramInt1, Integer.valueOf(paramInt2));
  }
  
  public boolean updateLong(int paramInt, long paramLong)
  {
    return update(paramInt, Long.valueOf(paramLong));
  }
  
  public boolean updateShort(int paramInt, short paramShort)
  {
    return update(paramInt, Short.valueOf(paramShort));
  }
  
  public boolean updateString(int paramInt, String paramString)
  {
    return update(paramInt, paramString);
  }
  
  public boolean updateToNull(int paramInt)
  {
    return update(paramInt, null);
  }
  
  protected static class SelfContentObserver
    extends ContentObserver
  {
    WeakReference<AbstractCursor> mCursor;
    
    public SelfContentObserver(AbstractCursor paramAbstractCursor)
    {
      super();
      this.mCursor = new WeakReference(paramAbstractCursor);
    }
    
    public boolean deliverSelfNotifications()
    {
      return false;
    }
    
    /* Error */
    public void onChange(boolean arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\AbstractCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */