package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zal
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zal> CREATOR = new zao();
  final String className;
  private final int versionCode;
  final ArrayList<zam> zaqy;
  
  zal(int paramInt, String paramString, ArrayList<zam> paramArrayList)
  {
    this.versionCode = paramInt;
    this.className = paramString;
    this.zaqy = paramArrayList;
  }
  
  zal(String paramString, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    this.versionCode = 1;
    this.className = paramString;
    if (paramMap == null)
    {
      paramString = null;
    }
    else
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      for (;;)
      {
        paramString = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = (String)localIterator.next();
        localArrayList.add(new zam(paramString, (FastJsonResponse.Field)paramMap.get(paramString)));
      }
    }
    this.zaqy = paramString;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.className, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zaqy, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\server\response\zal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */