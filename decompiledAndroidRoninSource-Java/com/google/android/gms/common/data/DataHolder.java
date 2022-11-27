package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.sqlite.CursorWrapper;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class DataHolder
  extends AbstractSafeParcelable
  implements Closeable
{
  public static final Parcelable.Creator<DataHolder> CREATOR = new zac();
  private static final Builder zaly = new zab(new String[0], null);
  private boolean mClosed = false;
  private final int zalf;
  private final String[] zalq;
  private Bundle zalr;
  private final CursorWindow[] zals;
  private final int zalt;
  private final Bundle zalu;
  private int[] zalv;
  private int zalw;
  private boolean zalx = true;
  
  DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle)
  {
    this.zalf = paramInt1;
    this.zalq = paramArrayOfString;
    this.zals = paramArrayOfCursorWindow;
    this.zalt = paramInt2;
    this.zalu = paramBundle;
  }
  
  public DataHolder(Cursor paramCursor, int paramInt, Bundle paramBundle)
  {
    this(new CursorWrapper(paramCursor), paramInt, paramBundle);
  }
  
  private DataHolder(Builder paramBuilder, int paramInt, Bundle paramBundle)
  {
    this(Builder.zaa(paramBuilder), zaa(paramBuilder, -1), paramInt, null);
  }
  
  private DataHolder(Builder paramBuilder, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this(Builder.zaa(paramBuilder), zaa(paramBuilder, -1), paramInt1, paramBundle);
  }
  
  private DataHolder(CursorWrapper paramCursorWrapper, int paramInt, Bundle paramBundle)
  {
    this(paramCursorWrapper.getColumnNames(), zaa(paramCursorWrapper), paramInt, paramBundle);
  }
  
  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle)
  {
    this.zalf = 1;
    this.zalq = ((String[])Preconditions.checkNotNull(paramArrayOfString));
    this.zals = ((CursorWindow[])Preconditions.checkNotNull(paramArrayOfCursorWindow));
    this.zalt = paramInt;
    this.zalu = paramBundle;
    zaca();
  }
  
  public static Builder builder(String[] paramArrayOfString)
  {
    return new Builder(paramArrayOfString, null, null);
  }
  
  public static DataHolder empty(int paramInt)
  {
    return new DataHolder(zaly, paramInt, null);
  }
  
  private final void zaa(String paramString, int paramInt)
  {
    Bundle localBundle = this.zalr;
    if ((localBundle != null) && (localBundle.containsKey(paramString)))
    {
      if (!isClosed())
      {
        if ((paramInt >= 0) && (paramInt < this.zalw)) {
          return;
        }
        throw new CursorIndexOutOfBoundsException(paramInt, this.zalw);
      }
      throw new IllegalArgumentException("Buffer is closed.");
    }
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "No such column: ".concat(paramString);
    } else {
      paramString = new String("No such column: ");
    }
    throw new IllegalArgumentException(paramString);
  }
  
  private static CursorWindow[] zaa(Builder paramBuilder, int paramInt)
  {
    int i = Builder.zaa(paramBuilder).length;
    int k = 0;
    if (i == 0) {
      return new CursorWindow[0];
    }
    Object localObject2;
    if ((paramInt >= 0) && (paramInt < Builder.zab(paramBuilder).size())) {
      localObject2 = Builder.zab(paramBuilder).subList(0, paramInt);
    } else {
      localObject2 = Builder.zab(paramBuilder);
    }
    int m = ((List)localObject2).size();
    Object localObject1 = new CursorWindow(false);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    ((CursorWindow)localObject1).setNumColumns(Builder.zaa(paramBuilder).length);
    paramInt = 0;
    i = 0;
    if (paramInt < m) {}
    for (;;)
    {
      int j;
      try
      {
        boolean bool = ((CursorWindow)localObject1).allocRow();
        Object localObject3;
        if (!bool)
        {
          localObject1 = new StringBuilder(72);
          ((StringBuilder)localObject1).append("Allocating additional cursor window for large data set (row ");
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append(")");
          Log.d("DataHolder", ((StringBuilder)localObject1).toString());
          localObject3 = new CursorWindow(false);
          ((CursorWindow)localObject3).setStartPosition(paramInt);
          ((CursorWindow)localObject3).setNumColumns(Builder.zaa(paramBuilder).length);
          localArrayList.add(localObject3);
          localObject1 = localObject3;
          if (!((CursorWindow)localObject3).allocRow())
          {
            Log.e("DataHolder", "Unable to allocate row to hold data.");
            localArrayList.remove(localObject3);
            return (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
          }
        }
        Map localMap = (Map)((List)localObject2).get(paramInt);
        j = 0;
        bool = true;
        if ((j < Builder.zaa(paramBuilder).length) && (bool))
        {
          localObject3 = Builder.zaa(paramBuilder)[j];
          Object localObject4 = localMap.get(localObject3);
          if (localObject4 == null)
          {
            bool = ((CursorWindow)localObject1).putNull(paramInt, j);
            break label785;
          }
          if ((localObject4 instanceof String))
          {
            bool = ((CursorWindow)localObject1).putString((String)localObject4, paramInt, j);
            break label785;
          }
          if ((localObject4 instanceof Long))
          {
            bool = ((CursorWindow)localObject1).putLong(((Long)localObject4).longValue(), paramInt, j);
            break label785;
          }
          if ((localObject4 instanceof Integer))
          {
            bool = ((CursorWindow)localObject1).putLong(((Integer)localObject4).intValue(), paramInt, j);
            break label785;
          }
          if ((localObject4 instanceof Boolean))
          {
            if (!((Boolean)localObject4).booleanValue()) {
              break label779;
            }
            l = 1L;
            bool = ((CursorWindow)localObject1).putLong(l, paramInt, j);
            break label785;
          }
          if ((localObject4 instanceof byte[]))
          {
            bool = ((CursorWindow)localObject1).putBlob((byte[])localObject4, paramInt, j);
            break label785;
          }
          if ((localObject4 instanceof Double))
          {
            bool = ((CursorWindow)localObject1).putDouble(((Double)localObject4).doubleValue(), paramInt, j);
            break label785;
          }
          if ((localObject4 instanceof Float))
          {
            bool = ((CursorWindow)localObject1).putDouble(((Float)localObject4).floatValue(), paramInt, j);
            break label785;
          }
          paramBuilder = String.valueOf(localObject4);
          localObject1 = new StringBuilder(String.valueOf(localObject3).length() + 32 + String.valueOf(paramBuilder).length());
          ((StringBuilder)localObject1).append("Unsupported object for column ");
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append(": ");
          ((StringBuilder)localObject1).append(paramBuilder);
          throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
        }
        if (!bool)
        {
          if (i == 0)
          {
            localObject3 = new StringBuilder(74);
            ((StringBuilder)localObject3).append("Couldn't populate window data for row ");
            ((StringBuilder)localObject3).append(paramInt);
            ((StringBuilder)localObject3).append(" - allocating new window.");
            Log.d("DataHolder", ((StringBuilder)localObject3).toString());
            ((CursorWindow)localObject1).freeLastRow();
            localObject1 = new CursorWindow(false);
            ((CursorWindow)localObject1).setStartPosition(paramInt);
            ((CursorWindow)localObject1).setNumColumns(Builder.zaa(paramBuilder).length);
            localArrayList.add(localObject1);
            paramInt -= 1;
            i = 1;
          }
          else
          {
            throw new zaa("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
          }
        }
        else {
          i = 0;
        }
        paramInt += 1;
      }
      catch (RuntimeException paramBuilder)
      {
        i = localArrayList.size();
        paramInt = k;
        if (paramInt < i)
        {
          ((CursorWindow)localArrayList.get(paramInt)).close();
          paramInt += 1;
          continue;
        }
        throw paramBuilder;
      }
      return (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
      label779:
      long l = 0L;
      continue;
      label785:
      j += 1;
    }
  }
  
  private static CursorWindow[] zaa(CursorWrapper paramCursorWrapper)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        int j = paramCursorWrapper.getCount();
        CursorWindow localCursorWindow = paramCursorWrapper.getWindow();
        if ((localCursorWindow != null) && (localCursorWindow.getStartPosition() == 0))
        {
          localCursorWindow.acquireReference();
          paramCursorWrapper.setWindow(null);
          localArrayList.add(localCursorWindow);
          i = localCursorWindow.getNumRows();
          if ((i < j) && (paramCursorWrapper.moveToPosition(i)))
          {
            localCursorWindow = paramCursorWrapper.getWindow();
            if (localCursorWindow != null)
            {
              localCursorWindow.acquireReference();
              paramCursorWrapper.setWindow(null);
            }
            else
            {
              localCursorWindow = new CursorWindow(false);
              localCursorWindow.setStartPosition(i);
              paramCursorWrapper.fillWindow(i, localCursorWindow);
            }
            if (localCursorWindow.getNumRows() != 0)
            {
              localArrayList.add(localCursorWindow);
              i = localCursorWindow.getStartPosition();
              int k = localCursorWindow.getNumRows();
              i += k;
              continue;
            }
          }
          return (CursorWindow[])localArrayList.toArray(new CursorWindow[localArrayList.size()]);
        }
      }
      finally
      {
        paramCursorWrapper.close();
      }
      int i = 0;
    }
  }
  
  public final void close()
  {
    try
    {
      if (!this.mClosed)
      {
        this.mClosed = true;
        int i = 0;
        while (i < this.zals.length)
        {
          this.zals[i].close();
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
  
  protected final void finalize()
    throws Throwable
  {
    try
    {
      if ((this.zalx) && (this.zals.length > 0) && (!isClosed()))
      {
        close();
        String str = toString();
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 178);
        localStringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
        localStringBuilder.append(str);
        localStringBuilder.append(")");
        Log.e("DataBuffer", localStringBuilder.toString());
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public final boolean getBoolean(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return Long.valueOf(this.zals[paramInt2].getLong(paramInt1, this.zalr.getInt(paramString))).longValue() == 1L;
  }
  
  public final byte[] getByteArray(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].getBlob(paramInt1, this.zalr.getInt(paramString));
  }
  
  public final int getCount()
  {
    return this.zalw;
  }
  
  public final int getInteger(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].getInt(paramInt1, this.zalr.getInt(paramString));
  }
  
  public final long getLong(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].getLong(paramInt1, this.zalr.getInt(paramString));
  }
  
  public final Bundle getMetadata()
  {
    return this.zalu;
  }
  
  public final int getStatusCode()
  {
    return this.zalt;
  }
  
  public final String getString(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].getString(paramInt1, this.zalr.getInt(paramString));
  }
  
  public final int getWindowIndex(int paramInt)
  {
    int j = 0;
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.zalw)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    int i;
    for (;;)
    {
      int[] arrayOfInt = this.zalv;
      i = j;
      if (j >= arrayOfInt.length) {
        break;
      }
      if (paramInt < arrayOfInt[j])
      {
        i = j - 1;
        break;
      }
      j += 1;
    }
    paramInt = i;
    if (i == this.zalv.length) {
      paramInt = i - 1;
    }
    return paramInt;
  }
  
  public final boolean hasColumn(String paramString)
  {
    return this.zalr.containsKey(paramString);
  }
  
  public final boolean hasNull(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].isNull(paramInt1, this.zalr.getInt(paramString));
  }
  
  public final boolean isClosed()
  {
    try
    {
      boolean bool = this.mClosed;
      return bool;
    }
    finally {}
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringArray(paramParcel, 1, this.zalq, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, this.zals, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getStatusCode());
    SafeParcelWriter.writeBundle(paramParcel, 4, getMetadata(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zalf);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    if ((paramInt & 0x1) != 0) {
      close();
    }
  }
  
  public final float zaa(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].getFloat(paramInt1, this.zalr.getInt(paramString));
  }
  
  public final void zaa(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    zaa(paramString, paramInt1);
    this.zals[paramInt2].copyStringToBuffer(paramInt1, this.zalr.getInt(paramString), paramCharArrayBuffer);
  }
  
  public final double zab(String paramString, int paramInt1, int paramInt2)
  {
    zaa(paramString, paramInt1);
    return this.zals[paramInt2].getDouble(paramInt1, this.zalr.getInt(paramString));
  }
  
  public final void zaca()
  {
    this.zalr = new Bundle();
    int k = 0;
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = this.zalq;
      if (i >= localObject.length) {
        break;
      }
      this.zalr.putInt(localObject[i], i);
      i += 1;
    }
    this.zalv = new int[this.zals.length];
    int j = 0;
    i = k;
    for (;;)
    {
      localObject = this.zals;
      if (i >= localObject.length) {
        break;
      }
      this.zalv[i] = j;
      k = localObject[i].getStartPosition();
      j += this.zals[i].getNumRows() - (j - k);
      i += 1;
    }
    this.zalw = j;
  }
  
  public static class Builder
  {
    private final String[] zalq;
    private final ArrayList<HashMap<String, Object>> zalz;
    private final String zama;
    private final HashMap<Object, Integer> zamb;
    private boolean zamc;
    private String zamd;
    
    private Builder(String[] paramArrayOfString, String paramString)
    {
      this.zalq = ((String[])Preconditions.checkNotNull(paramArrayOfString));
      this.zalz = new ArrayList();
      this.zama = paramString;
      this.zamb = new HashMap();
      this.zamc = false;
      this.zamd = null;
    }
    
    public DataHolder build(int paramInt)
    {
      return new DataHolder(this, paramInt, null, null);
    }
    
    public DataHolder build(int paramInt, Bundle paramBundle)
    {
      return new DataHolder(this, paramInt, paramBundle, -1, null);
    }
    
    public Builder withRow(ContentValues paramContentValues)
    {
      Asserts.checkNotNull(paramContentValues);
      HashMap localHashMap = new HashMap(paramContentValues.size());
      paramContentValues = paramContentValues.valueSet().iterator();
      while (paramContentValues.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramContentValues.next();
        localHashMap.put((String)localEntry.getKey(), localEntry.getValue());
      }
      return zaa(localHashMap);
    }
    
    public Builder zaa(HashMap<String, Object> paramHashMap)
    {
      Asserts.checkNotNull(paramHashMap);
      Object localObject = this.zama;
      if (localObject == null) {}
      Integer localInteger;
      for (;;)
      {
        i = -1;
        break label77;
        localObject = paramHashMap.get(localObject);
        if (localObject != null)
        {
          localInteger = (Integer)this.zamb.get(localObject);
          if (localInteger != null) {
            break;
          }
          this.zamb.put(localObject, Integer.valueOf(this.zalz.size()));
        }
      }
      int i = localInteger.intValue();
      label77:
      if (i == -1)
      {
        this.zalz.add(paramHashMap);
      }
      else
      {
        this.zalz.remove(i);
        this.zalz.add(i, paramHashMap);
      }
      this.zamc = false;
      return this;
    }
  }
  
  public static final class zaa
    extends RuntimeException
  {
    public zaa(String paramString)
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\data\DataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */