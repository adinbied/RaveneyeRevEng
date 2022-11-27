package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzcd.zzc;
import com.google.android.gms.internal.measurement.zzcd.zzc.zza;
import com.google.android.gms.internal.measurement.zzcd.zze;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzhz.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class zzt
{
  private zzcd.zzc zza;
  private Long zzb;
  private long zzc;
  
  private zzt(zzo paramzzo) {}
  
  final zzcd.zzc zza(String paramString, zzcd.zzc paramzzc)
  {
    Object localObject3 = paramzzc.zzc();
    List localList = paramzzc.zza();
    this.zzd.f_();
    Long localLong = (Long)zzks.zzb(paramzzc, "_eid");
    int i;
    if (localLong != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((i != 0) && (((String)localObject3).equals("_ep"))) {
      j = 1;
    } else {
      j = 0;
    }
    Object localObject1;
    Object localObject2;
    long l;
    if (j != 0)
    {
      this.zzd.f_();
      localObject1 = (String)zzks.zzb(paramzzc, "_en");
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.zzd.zzq().zzf().zza("Extra parameter without an event name. eventId", localLong);
        return null;
      }
      if ((this.zza == null) || (this.zzb == null) || (localLong.longValue() != this.zzb.longValue()))
      {
        localObject2 = this.zzd.zzi().zza(paramString, localLong);
        if ((localObject2 != null) && (((Pair)localObject2).first != null))
        {
          this.zza = ((zzcd.zzc)((Pair)localObject2).first);
          this.zzc = ((Long)((Pair)localObject2).second).longValue();
          this.zzd.f_();
          this.zzb = ((Long)zzks.zzb(this.zza, "_eid"));
        }
      }
      else
      {
        l = this.zzc - 1L;
        this.zzc = l;
        if (l <= 0L)
        {
          localObject2 = this.zzd.zzi();
          ((zzgo)localObject2).zzc();
          ((zzgo)localObject2).zzq().zzw().zza("Clearing complex main event info. appId", paramString);
          try
          {
            ((zzac)localObject2).c_().execSQL("delete from main_event_params where app_id=?", new String[] { paramString });
          }
          catch (SQLiteException paramString)
          {
            ((zzgo)localObject2).zzq().zze().zza("Error clearing complex main event", paramString);
          }
        }
        else
        {
          this.zzd.zzi().zza(paramString, localLong, this.zzc, this.zza);
        }
        localObject2 = new ArrayList();
        paramString = this.zza.zza().iterator();
        while (paramString.hasNext())
        {
          localObject3 = (zzcd.zze)paramString.next();
          this.zzd.f_();
          if (zzks.zza(paramzzc, ((zzcd.zze)localObject3).zzb()) == null) {
            ((List)localObject2).add(localObject3);
          }
        }
        if (!((List)localObject2).isEmpty())
        {
          ((List)localObject2).addAll(localList);
          break label617;
        }
        this.zzd.zzq().zzf().zza("No unique parameters in main event. eventName", localObject1);
        localObject2 = localList;
        break label617;
      }
      this.zzd.zzq().zzf().zza("Extra parameter without existing main event. eventName, eventId", localObject1, localLong);
      return null;
    }
    else
    {
      localObject1 = localObject3;
      localObject2 = localList;
      if (i != 0)
      {
        this.zzb = localLong;
        this.zza = paramzzc;
        this.zzd.f_();
        localObject1 = Long.valueOf(0L);
        localObject2 = zzks.zzb(paramzzc, "_epc");
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        l = ((Long)localObject1).longValue();
        this.zzc = l;
        if (l <= 0L)
        {
          this.zzd.zzq().zzf().zza("Complex event with zero extra param count. eventName", localObject3);
          localObject1 = localObject3;
          localObject2 = localList;
        }
        else
        {
          this.zzd.zzi().zza(paramString, localLong, this.zzc, paramzzc);
          localObject2 = localList;
          localObject1 = localObject3;
        }
      }
    }
    label617:
    return (zzcd.zzc)((zzcd.zzc.zza)paramzzc.zzbn()).zza((String)localObject1).zzc().zza((Iterable)localObject2).zzz();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */