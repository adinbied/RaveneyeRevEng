package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.location.zzbh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zzq();
  public static final int INITIAL_TRIGGER_DWELL = 4;
  public static final int INITIAL_TRIGGER_ENTER = 1;
  public static final int INITIAL_TRIGGER_EXIT = 2;
  private final String tag;
  private final List<zzbh> zzap;
  private final int zzaq;
  
  GeofencingRequest(List<zzbh> paramList, int paramInt, String paramString)
  {
    this.zzap = paramList;
    this.zzaq = paramInt;
    this.tag = paramString;
  }
  
  public List<Geofence> getGeofences()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.zzap);
    return localArrayList;
  }
  
  public int getInitialTrigger()
  {
    return this.zzaq;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GeofencingRequest[");
    localStringBuilder.append("geofences=");
    localStringBuilder.append(this.zzap);
    int i = this.zzaq;
    Object localObject = new StringBuilder(30);
    ((StringBuilder)localObject).append(", initialTrigger=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", ");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    localObject = String.valueOf(this.tag);
    if (((String)localObject).length() != 0) {
      localObject = "tag=".concat((String)localObject);
    } else {
      localObject = new String("tag=");
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, this.zzap, false);
    SafeParcelWriter.writeInt(paramParcel, 2, getInitialTrigger());
    SafeParcelWriter.writeString(paramParcel, 3, this.tag, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private String tag = "";
    private final List<zzbh> zzap = new ArrayList();
    private int zzaq = 5;
    
    public final Builder addGeofence(Geofence paramGeofence)
    {
      Preconditions.checkNotNull(paramGeofence, "geofence can't be null.");
      Preconditions.checkArgument(paramGeofence instanceof zzbh, "Geofence must be created using Geofence.Builder.");
      this.zzap.add((zzbh)paramGeofence);
      return this;
    }
    
    public final Builder addGeofences(List<Geofence> paramList)
    {
      if (paramList != null)
      {
        if (paramList.isEmpty()) {
          return this;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Geofence localGeofence = (Geofence)paramList.next();
          if (localGeofence != null) {
            addGeofence(localGeofence);
          }
        }
      }
      return this;
    }
    
    public final GeofencingRequest build()
    {
      Preconditions.checkArgument(this.zzap.isEmpty() ^ true, "No geofence has been added to this request.");
      return new GeofencingRequest(this.zzap, this.zzaq, this.tag);
    }
    
    public final Builder setInitialTrigger(int paramInt)
    {
      this.zzaq = (paramInt & 0x7);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\GeofencingRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */