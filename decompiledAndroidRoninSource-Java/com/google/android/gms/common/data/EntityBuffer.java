package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class EntityBuffer<T>
  extends AbstractDataBuffer<T>
{
  private boolean zame = false;
  private ArrayList<Integer> zamf;
  
  protected EntityBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private final void zacb()
  {
    for (;;)
    {
      int i;
      Object localObject4;
      try
      {
        if (!this.zame)
        {
          int j = this.mDataHolder.getCount();
          Object localObject1 = new ArrayList();
          this.zamf = ((ArrayList)localObject1);
          if (j > 0)
          {
            ((ArrayList)localObject1).add(Integer.valueOf(0));
            String str2 = getPrimaryDataMarkerColumn();
            i = this.mDataHolder.getWindowIndex(0);
            localObject1 = this.mDataHolder.getString(str2, 0, i);
            i = 1;
            if (i < j)
            {
              int k = this.mDataHolder.getWindowIndex(i);
              String str1 = this.mDataHolder.getString(str2, i, k);
              if (str1 != null)
              {
                localObject4 = localObject1;
                if (str1.equals(localObject1)) {
                  break label235;
                }
                this.zamf.add(Integer.valueOf(i));
                localObject4 = str1;
                break label235;
              }
              localObject1 = new StringBuilder(String.valueOf(str2).length() + 78);
              ((StringBuilder)localObject1).append("Missing value for markerColumn: ");
              ((StringBuilder)localObject1).append(str2);
              ((StringBuilder)localObject1).append(", at row: ");
              ((StringBuilder)localObject1).append(i);
              ((StringBuilder)localObject1).append(", for window: ");
              ((StringBuilder)localObject1).append(k);
              throw new NullPointerException(((StringBuilder)localObject1).toString());
            }
          }
          this.zame = true;
        }
        else
        {
          return;
        }
      }
      finally {}
      label235:
      i += 1;
      Object localObject3 = localObject4;
    }
  }
  
  private final int zah(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zamf.size())) {
      return ((Integer)this.zamf.get(paramInt)).intValue();
    }
    StringBuilder localStringBuilder = new StringBuilder(53);
    localStringBuilder.append("Position ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is out of bounds for this buffer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public final T get(int paramInt)
  {
    zacb();
    int m = zah(paramInt);
    int k = 0;
    int i = k;
    if (paramInt >= 0) {
      if (paramInt == this.zamf.size())
      {
        i = k;
      }
      else
      {
        int j;
        if (paramInt == this.zamf.size() - 1)
        {
          i = this.mDataHolder.getCount();
          j = ((Integer)this.zamf.get(paramInt)).intValue();
        }
        else
        {
          i = ((Integer)this.zamf.get(paramInt + 1)).intValue();
          j = ((Integer)this.zamf.get(paramInt)).intValue();
        }
        i -= j;
        if (i == 1)
        {
          paramInt = zah(paramInt);
          j = this.mDataHolder.getWindowIndex(paramInt);
          String str = getChildDataMarkerColumn();
          if ((str != null) && (this.mDataHolder.getString(str, paramInt, j) == null)) {
            i = k;
          }
        }
      }
    }
    return (T)getEntry(m, i);
  }
  
  protected String getChildDataMarkerColumn()
  {
    return null;
  }
  
  public int getCount()
  {
    zacb();
    return this.zamf.size();
  }
  
  protected abstract T getEntry(int paramInt1, int paramInt2);
  
  protected abstract String getPrimaryDataMarkerColumn();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\data\EntityBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */