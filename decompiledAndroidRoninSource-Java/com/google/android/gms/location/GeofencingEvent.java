package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.location.zzbh;
import java.util.ArrayList;
import java.util.List;

public class GeofencingEvent
{
  private final int errorCode;
  private final int zzam;
  private final List<Geofence> zzan;
  private final Location zzao;
  
  private GeofencingEvent(int paramInt1, int paramInt2, List<Geofence> paramList, Location paramLocation)
  {
    this.errorCode = paramInt1;
    this.zzam = paramInt2;
    this.zzan = paramList;
    this.zzao = paramLocation;
  }
  
  public static GeofencingEvent fromIntent(Intent paramIntent)
  {
    Object localObject = null;
    if (paramIntent == null) {
      return null;
    }
    int j = -1;
    int m = paramIntent.getIntExtra("gms_error_code", -1);
    int k = paramIntent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
    int i = j;
    if (k != -1) {
      if ((k != 1) && (k != 2))
      {
        i = j;
        if (k != 4) {}
      }
      else
      {
        i = k;
      }
    }
    ArrayList localArrayList2 = (ArrayList)paramIntent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
    if (localArrayList2 != null)
    {
      ArrayList localArrayList1 = new ArrayList(localArrayList2.size());
      localArrayList2 = (ArrayList)localArrayList2;
      k = localArrayList2.size();
      j = 0;
      for (;;)
      {
        localObject = localArrayList1;
        if (j >= k) {
          break;
        }
        localObject = localArrayList2.get(j);
        j += 1;
        localArrayList1.add(zzbh.zza((byte[])localObject));
      }
    }
    return new GeofencingEvent(m, i, (List)localObject, (Location)paramIntent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public int getGeofenceTransition()
  {
    return this.zzam;
  }
  
  public List<Geofence> getTriggeringGeofences()
  {
    return this.zzan;
  }
  
  public Location getTriggeringLocation()
  {
    return this.zzao;
  }
  
  public boolean hasError()
  {
    return this.errorCode != -1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\GeofencingEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */