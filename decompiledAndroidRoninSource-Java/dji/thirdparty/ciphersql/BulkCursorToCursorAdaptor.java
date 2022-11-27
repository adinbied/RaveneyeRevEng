package dji.thirdparty.ciphersql;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import java.util.Map;

public final class BulkCursorToCursorAdaptor
  extends AbstractWindowedCursor
{
  private static final String TAG = "BulkCursor";
  private IBulkCursor mBulkCursor;
  private String[] mColumns;
  private int mCount;
  private AbstractCursor.SelfContentObserver mObserverBridge;
  private boolean mWantsAllOnMoveCalls;
  
  public static int findRowIdColumnIndex(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfString[i].equals("_id")) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> paramMap)
  {
    for (;;)
    {
      return false;
    }
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  /* Error */
  public void deactivate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean deleteRow()
  {
    return false;
  }
  
  public String[] getColumnNames()
  {
    return null;
  }
  
  public int getCount()
  {
    return this.mCount;
  }
  
  public Bundle getExtras()
  {
    return null;
  }
  
  public IContentObserver getObserver()
  {
    return null;
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public boolean requery()
  {
    return false;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    return null;
  }
  
  /* Error */
  public void set(IBulkCursor arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void set(IBulkCursor paramIBulkCursor, int paramInt1, int paramInt2)
  {
    this.mBulkCursor = paramIBulkCursor;
    this.mColumns = null;
    this.mCount = paramInt1;
    this.mRowIdColumnIndex = paramInt2;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\BulkCursorToCursorAdaptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */