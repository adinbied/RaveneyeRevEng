package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationSettingsRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzag();
  private final List<LocationRequest> zzbg;
  private final boolean zzbh;
  private final boolean zzbi;
  private zzae zzbj;
  
  LocationSettingsRequest(List<LocationRequest> paramList, boolean paramBoolean1, boolean paramBoolean2, zzae paramzzae)
  {
    this.zzbg = paramList;
    this.zzbh = paramBoolean1;
    this.zzbi = paramBoolean2;
    this.zzbj = paramzzae;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, Collections.unmodifiableList(this.zzbg), false);
    SafeParcelWriter.writeBoolean(paramParcel, 2, this.zzbh);
    SafeParcelWriter.writeBoolean(paramParcel, 3, this.zzbi);
    SafeParcelWriter.writeParcelable(paramParcel, 5, this.zzbj, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public static final class Builder
  {
    private boolean zzbh = false;
    private boolean zzbi = false;
    private zzae zzbj = null;
    private final ArrayList<LocationRequest> zzbk = new ArrayList();
    
    public final Builder addAllLocationRequests(Collection<LocationRequest> paramCollection)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        LocationRequest localLocationRequest = (LocationRequest)paramCollection.next();
        if (localLocationRequest != null) {
          this.zzbk.add(localLocationRequest);
        }
      }
      return this;
    }
    
    public final Builder addLocationRequest(LocationRequest paramLocationRequest)
    {
      if (paramLocationRequest != null) {
        this.zzbk.add(paramLocationRequest);
      }
      return this;
    }
    
    public final LocationSettingsRequest build()
    {
      return new LocationSettingsRequest(this.zzbk, this.zzbh, this.zzbi, null);
    }
    
    public final Builder setAlwaysShow(boolean paramBoolean)
    {
      this.zzbh = paramBoolean;
      return this;
    }
    
    public final Builder setNeedBle(boolean paramBoolean)
    {
      this.zzbi = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\LocationSettingsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */