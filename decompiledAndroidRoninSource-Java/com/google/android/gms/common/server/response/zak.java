package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zak
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zak> CREATOR = new zan();
  private final int zalf;
  private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zaqv;
  private final ArrayList<zal> zaqw;
  private final String zaqx;
  
  zak(int paramInt, ArrayList<zal> paramArrayList, String paramString)
  {
    this.zalf = paramInt;
    this.zaqw = null;
    HashMap localHashMap1 = new HashMap();
    int j = paramArrayList.size();
    paramInt = 0;
    while (paramInt < j)
    {
      zal localzal = (zal)paramArrayList.get(paramInt);
      String str = localzal.className;
      HashMap localHashMap2 = new HashMap();
      int k = localzal.zaqy.size();
      int i = 0;
      while (i < k)
      {
        zam localzam = (zam)localzal.zaqy.get(i);
        localHashMap2.put(localzam.zaqz, localzam.zara);
        i += 1;
      }
      localHashMap1.put(str, localHashMap2);
      paramInt += 1;
    }
    this.zaqv = localHashMap1;
    this.zaqx = ((String)Preconditions.checkNotNull(paramString));
    zacr();
  }
  
  public zak(Class<? extends FastJsonResponse> paramClass)
  {
    this.zalf = 1;
    this.zaqw = null;
    this.zaqv = new HashMap();
    this.zaqx = paramClass.getCanonicalName();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.zaqv.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(":\n");
      localObject = (Map)this.zaqv.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localStringBuilder.append("  ");
        localStringBuilder.append(str);
        localStringBuilder.append(": ");
        localStringBuilder.append(((Map)localObject).get(str));
      }
    }
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zaqv.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new zal(str, (Map)this.zaqv.get(str)));
    }
    SafeParcelWriter.writeTypedList(paramParcel, 2, localArrayList, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zaqx, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final void zaa(Class<? extends FastJsonResponse> paramClass, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    this.zaqv.put(paramClass.getCanonicalName(), paramMap);
  }
  
  public final boolean zaa(Class<? extends FastJsonResponse> paramClass)
  {
    return this.zaqv.containsKey(paramClass.getCanonicalName());
  }
  
  public final void zacr()
  {
    Iterator localIterator1 = this.zaqv.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (Map)this.zaqv.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((FastJsonResponse.Field)((Map)localObject).get((String)localIterator2.next())).zaa(this);
      }
    }
  }
  
  public final void zacs()
  {
    Iterator localIterator1 = this.zaqv.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      Map localMap = (Map)this.zaqv.get(str1);
      HashMap localHashMap = new HashMap();
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap.put(str2, ((FastJsonResponse.Field)localMap.get(str2)).zacl());
      }
      this.zaqv.put(str1, localHashMap);
    }
  }
  
  public final String zact()
  {
    return this.zaqx;
  }
  
  public final Map<String, FastJsonResponse.Field<?, ?>> zai(String paramString)
  {
    return (Map)this.zaqv.get(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\server\response\zak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */