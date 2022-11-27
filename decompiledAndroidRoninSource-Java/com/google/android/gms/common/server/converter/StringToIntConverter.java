package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class StringToIntConverter
  extends AbstractSafeParcelable
  implements FastJsonResponse.FieldConverter<String, Integer>
{
  public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zac();
  private final int zalf;
  private final HashMap<String, Integer> zapm;
  private final SparseArray<String> zapn;
  private final ArrayList<zaa> zapo;
  
  public StringToIntConverter()
  {
    this.zalf = 1;
    this.zapm = new HashMap();
    this.zapn = new SparseArray();
    this.zapo = null;
  }
  
  StringToIntConverter(int paramInt, ArrayList<zaa> paramArrayList)
  {
    this.zalf = paramInt;
    this.zapm = new HashMap();
    this.zapn = new SparseArray();
    this.zapo = null;
    paramArrayList = (ArrayList)paramArrayList;
    int i = paramArrayList.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = paramArrayList.get(paramInt);
      paramInt += 1;
      localObject = (zaa)localObject;
      add(((zaa)localObject).zapp, ((zaa)localObject).zapq);
    }
  }
  
  public final StringToIntConverter add(String paramString, int paramInt)
  {
    this.zapm.put(paramString, Integer.valueOf(paramInt));
    this.zapn.put(paramInt, paramString);
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zapm.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new zaa(str, ((Integer)this.zapm.get(str)).intValue()));
    }
    SafeParcelWriter.writeTypedList(paramParcel, 2, localArrayList, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final int zacj()
  {
    return 7;
  }
  
  public final int zack()
  {
    return 0;
  }
  
  public static final class zaa
    extends AbstractSafeParcelable
  {
    public static final Parcelable.Creator<zaa> CREATOR = new zad();
    private final int versionCode;
    final String zapp;
    final int zapq;
    
    zaa(int paramInt1, String paramString, int paramInt2)
    {
      this.versionCode = paramInt1;
      this.zapp = paramString;
      this.zapq = paramInt2;
    }
    
    zaa(String paramString, int paramInt)
    {
      this.versionCode = 1;
      this.zapp = paramString;
      this.zapq = paramInt;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
      SafeParcelWriter.writeString(paramParcel, 2, this.zapp, false);
      SafeParcelWriter.writeInt(paramParcel, 3, this.zapq);
      SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\server\converter\StringToIntConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */