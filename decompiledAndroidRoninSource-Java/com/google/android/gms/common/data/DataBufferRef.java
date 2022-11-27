package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

public class DataBufferRef
{
  protected final DataHolder mDataHolder;
  protected int mDataRow;
  private int zaln;
  
  public DataBufferRef(DataHolder paramDataHolder, int paramInt)
  {
    this.mDataHolder = ((DataHolder)Preconditions.checkNotNull(paramDataHolder));
    zag(paramInt);
  }
  
  protected void copyToBuffer(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.mDataHolder.zaa(paramString, this.mDataRow, this.zaln, paramCharArrayBuffer);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof DataBufferRef))
    {
      paramObject = (DataBufferRef)paramObject;
      if ((Objects.equal(Integer.valueOf(((DataBufferRef)paramObject).mDataRow), Integer.valueOf(this.mDataRow))) && (Objects.equal(Integer.valueOf(((DataBufferRef)paramObject).zaln), Integer.valueOf(this.zaln))) && (((DataBufferRef)paramObject).mDataHolder == this.mDataHolder)) {
        return true;
      }
    }
    return false;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.mDataHolder.getBoolean(paramString, this.mDataRow, this.zaln);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.mDataHolder.getByteArray(paramString, this.mDataRow, this.zaln);
  }
  
  protected int getDataRow()
  {
    return this.mDataRow;
  }
  
  protected double getDouble(String paramString)
  {
    return this.mDataHolder.zab(paramString, this.mDataRow, this.zaln);
  }
  
  protected float getFloat(String paramString)
  {
    return this.mDataHolder.zaa(paramString, this.mDataRow, this.zaln);
  }
  
  protected int getInteger(String paramString)
  {
    return this.mDataHolder.getInteger(paramString, this.mDataRow, this.zaln);
  }
  
  protected long getLong(String paramString)
  {
    return this.mDataHolder.getLong(paramString, this.mDataRow, this.zaln);
  }
  
  protected String getString(String paramString)
  {
    return this.mDataHolder.getString(paramString, this.mDataRow, this.zaln);
  }
  
  public boolean hasColumn(String paramString)
  {
    return this.mDataHolder.hasColumn(paramString);
  }
  
  protected boolean hasNull(String paramString)
  {
    return this.mDataHolder.hasNull(paramString, this.mDataRow, this.zaln);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.mDataRow), Integer.valueOf(this.zaln), this.mDataHolder });
  }
  
  public boolean isDataValid()
  {
    return !this.mDataHolder.isClosed();
  }
  
  protected Uri parseUri(String paramString)
  {
    paramString = this.mDataHolder.getString(paramString, this.mDataRow, this.zaln);
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString);
  }
  
  protected final void zag(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.mDataHolder.getCount())) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    this.mDataRow = paramInt;
    this.zaln = this.mDataHolder.getWindowIndex(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\data\DataBufferRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */