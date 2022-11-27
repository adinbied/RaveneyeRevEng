package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbv.zzb;
import com.google.android.gms.internal.measurement.zzbv.zzc;
import com.google.android.gms.internal.measurement.zzbv.zzd;
import com.google.android.gms.internal.measurement.zzbv.zzd.zza;
import com.google.android.gms.internal.measurement.zzbv.zze;
import com.google.android.gms.internal.measurement.zzbv.zzf;
import com.google.android.gms.internal.measurement.zzbv.zzf.zzb;
import com.google.android.gms.internal.measurement.zzcd.zza;
import com.google.android.gms.internal.measurement.zzcd.zzb;
import com.google.android.gms.internal.measurement.zzcd.zzc;
import com.google.android.gms.internal.measurement.zzcd.zzc.zza;
import com.google.android.gms.internal.measurement.zzcd.zze;
import com.google.android.gms.internal.measurement.zzcd.zze.zza;
import com.google.android.gms.internal.measurement.zzcd.zzf;
import com.google.android.gms.internal.measurement.zzcd.zzg;
import com.google.android.gms.internal.measurement.zzcd.zzg.zza;
import com.google.android.gms.internal.measurement.zzcd.zzi;
import com.google.android.gms.internal.measurement.zzcd.zzj;
import com.google.android.gms.internal.measurement.zzcd.zzk;
import com.google.android.gms.internal.measurement.zzcd.zzk.zza;
import com.google.android.gms.internal.measurement.zzhm;
import com.google.android.gms.internal.measurement.zzhz.zza;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzjk;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class zzks
  extends zzkj
{
  zzks(zzki paramzzki)
  {
    super(paramzzki);
  }
  
  static int zza(zzcd.zzg.zza paramzza, String paramString)
  {
    if (paramzza == null) {
      return -1;
    }
    int i = 0;
    while (i < paramzza.zze())
    {
      if (paramString.equals(paramzza.zzd(i).zzc())) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  static zzcd.zze zza(zzcd.zzc paramzzc, String paramString)
  {
    paramzzc = paramzzc.zza().iterator();
    while (paramzzc.hasNext())
    {
      zzcd.zze localzze = (zzcd.zze)paramzzc.next();
      if (localzze.zzb().equals(paramString)) {
        return localzze;
      }
    }
    return null;
  }
  
  static <Builder extends zzjk> Builder zza(Builder paramBuilder, byte[] paramArrayOfByte)
    throws zzih
  {
    zzhm localzzhm = zzhm.zzb();
    if (localzzhm != null) {
      return paramBuilder.zza(paramArrayOfByte, localzzhm);
    }
    return paramBuilder.zza(paramArrayOfByte);
  }
  
  private static String zza(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean1) {
      localStringBuilder.append("Dynamic ");
    }
    if (paramBoolean2) {
      localStringBuilder.append("Sequence ");
    }
    if (paramBoolean3) {
      localStringBuilder.append("Session-Scoped ");
    }
    return localStringBuilder.toString();
  }
  
  static List<Long> zza(BitSet paramBitSet)
  {
    int k = (paramBitSet.length() + 63) / 64;
    ArrayList localArrayList = new ArrayList(k);
    int i = 0;
    while (i < k)
    {
      long l1 = 0L;
      int j = 0;
      while (j < 64)
      {
        int m = (i << 6) + j;
        if (m >= paramBitSet.length()) {
          break;
        }
        long l2 = l1;
        if (paramBitSet.get(m)) {
          l2 = l1 | 1L << j;
        }
        j += 1;
        l1 = l2;
      }
      localArrayList.add(Long.valueOf(l1));
      i += 1;
    }
    return localArrayList;
  }
  
  private static List<zzcd.zze> zza(Bundle[] paramArrayOfBundle)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfBundle.length;
    int i = 0;
    while (i < j)
    {
      Bundle localBundle = paramArrayOfBundle[i];
      if (localBundle != null)
      {
        zzcd.zze.zza localzza1 = zzcd.zze.zzm();
        Iterator localIterator = localBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          zzcd.zze.zza localzza2 = zzcd.zze.zzm().zza((String)localObject);
          localObject = localBundle.get((String)localObject);
          if ((localObject instanceof Long))
          {
            localzza2.zza(((Long)localObject).longValue());
          }
          else if ((localObject instanceof String))
          {
            localzza2.zzb((String)localObject);
          }
          else
          {
            if (!(localObject instanceof Double)) {
              continue;
            }
            localzza2.zza(((Double)localObject).doubleValue());
          }
          localzza1.zza(localzza2);
        }
        if (localzza1.zzd() > 0) {
          localArrayList.add((zzcd.zze)localzza1.zzz());
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  static void zza(zzcd.zzc.zza paramzza, String paramString, Object paramObject)
  {
    List localList = paramzza.zza();
    int i = 0;
    while (i < localList.size())
    {
      if (paramString.equals(((zzcd.zze)localList.get(i)).zzb())) {
        break label52;
      }
      i += 1;
    }
    i = -1;
    label52:
    paramString = zzcd.zze.zzm().zza(paramString);
    if ((paramObject instanceof Long)) {
      paramString.zza(((Long)paramObject).longValue());
    } else if ((paramObject instanceof String)) {
      paramString.zzb((String)paramObject);
    } else if ((paramObject instanceof Double)) {
      paramString.zza(((Double)paramObject).doubleValue());
    } else if ((paramObject instanceof Bundle[])) {
      paramString.zza(zza((Bundle[])paramObject));
    }
    if (i >= 0)
    {
      paramzza.zza(i, paramString);
      return;
    }
    paramzza.zza(paramString);
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append("  ");
      i += 1;
    }
  }
  
  private final void zza(StringBuilder paramStringBuilder, int paramInt, zzbv.zzc paramzzc)
  {
    if (paramzzc == null) {
      return;
    }
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("filter {\n");
    if (paramzzc.zze()) {
      zza(paramStringBuilder, paramInt, "complement", Boolean.valueOf(paramzzc.zzf()));
    }
    if (paramzzc.zzg()) {
      zza(paramStringBuilder, paramInt, "param_name", zzn().zzb(paramzzc.zzh()));
    }
    if (paramzzc.zza())
    {
      int i = paramInt + 1;
      Object localObject = paramzzc.zzb();
      if (localObject != null)
      {
        zza(paramStringBuilder, i);
        paramStringBuilder.append("string_filter");
        paramStringBuilder.append(" {\n");
        if (((zzbv.zzf)localObject).zza()) {
          zza(paramStringBuilder, i, "match_type", ((zzbv.zzf)localObject).zzb().name());
        }
        if (((zzbv.zzf)localObject).zzc()) {
          zza(paramStringBuilder, i, "expression", ((zzbv.zzf)localObject).zzd());
        }
        if (((zzbv.zzf)localObject).zze()) {
          zza(paramStringBuilder, i, "case_sensitive", Boolean.valueOf(((zzbv.zzf)localObject).zzf()));
        }
        if (((zzbv.zzf)localObject).zzh() > 0)
        {
          zza(paramStringBuilder, i + 1);
          paramStringBuilder.append("expression_list {\n");
          localObject = ((zzbv.zzf)localObject).zzg().iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            zza(paramStringBuilder, i + 2);
            paramStringBuilder.append(str);
            paramStringBuilder.append("\n");
          }
          paramStringBuilder.append("}\n");
        }
        zza(paramStringBuilder, i);
        paramStringBuilder.append("}\n");
      }
    }
    if (paramzzc.zzc()) {
      zza(paramStringBuilder, paramInt + 1, "number_filter", paramzzc.zzd());
    }
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, zzbv.zzd paramzzd)
  {
    if (paramzzd == null) {
      return;
    }
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(" {\n");
    if (paramzzd.zza()) {
      zza(paramStringBuilder, paramInt, "comparison_type", paramzzd.zzb().name());
    }
    if (paramzzd.zzc()) {
      zza(paramStringBuilder, paramInt, "match_as_float", Boolean.valueOf(paramzzd.zzd()));
    }
    if (paramzzd.zze()) {
      zza(paramStringBuilder, paramInt, "comparison_value", paramzzd.zzf());
    }
    if (paramzzd.zzg()) {
      zza(paramStringBuilder, paramInt, "min_comparison_value", paramzzd.zzh());
    }
    if (paramzzd.zzi()) {
      zza(paramStringBuilder, paramInt, "max_comparison_value", paramzzd.zzj());
    }
    zza(paramStringBuilder, paramInt);
    paramStringBuilder.append("}\n");
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, String paramString1, zzcd.zzi paramzzi, String paramString2)
  {
    if (paramzzi == null) {
      return;
    }
    zza(paramStringBuilder, 3);
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(" {\n");
    if (paramzzi.zzd() != 0)
    {
      zza(paramStringBuilder, 4);
      paramStringBuilder.append("results: ");
      paramString1 = paramzzi.zzc().iterator();
      paramInt = 0;
      while (paramString1.hasNext())
      {
        paramString2 = (Long)paramString1.next();
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(paramString2);
        paramInt += 1;
      }
      paramStringBuilder.append('\n');
    }
    if (paramzzi.zzb() != 0)
    {
      zza(paramStringBuilder, 4);
      paramStringBuilder.append("status: ");
      paramString1 = paramzzi.zza().iterator();
      paramInt = 0;
      while (paramString1.hasNext())
      {
        paramString2 = (Long)paramString1.next();
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(paramString2);
        paramInt += 1;
      }
      paramStringBuilder.append('\n');
    }
    if (paramzzi.zzf() != 0)
    {
      zza(paramStringBuilder, 4);
      paramStringBuilder.append("dynamic_filter_timestamps: {");
      paramString2 = paramzzi.zze().iterator();
      paramInt = 0;
      while (paramString2.hasNext())
      {
        zzcd.zzb localzzb = (zzcd.zzb)paramString2.next();
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        if (localzzb.zza()) {
          paramString1 = Integer.valueOf(localzzb.zzb());
        } else {
          paramString1 = null;
        }
        paramStringBuilder.append(paramString1);
        paramStringBuilder.append(":");
        if (localzzb.zzc()) {
          paramString1 = Long.valueOf(localzzb.zzd());
        } else {
          paramString1 = null;
        }
        paramStringBuilder.append(paramString1);
        paramInt += 1;
      }
      paramStringBuilder.append("}\n");
    }
    if (paramzzi.zzh() != 0)
    {
      zza(paramStringBuilder, 4);
      paramStringBuilder.append("sequence_filter_timestamps: {");
      paramzzi = paramzzi.zzg().iterator();
      paramInt = 0;
      while (paramzzi.hasNext())
      {
        paramString2 = (zzcd.zzj)paramzzi.next();
        if (paramInt != 0) {
          paramStringBuilder.append(", ");
        }
        if (paramString2.zza()) {
          paramString1 = Integer.valueOf(paramString2.zzb());
        } else {
          paramString1 = null;
        }
        paramStringBuilder.append(paramString1);
        paramStringBuilder.append(": [");
        paramString1 = paramString2.zzc().iterator();
        int i = 0;
        while (paramString1.hasNext())
        {
          long l = ((Long)paramString1.next()).longValue();
          if (i != 0) {
            paramStringBuilder.append(", ");
          }
          paramStringBuilder.append(l);
          i += 1;
        }
        paramStringBuilder.append("]");
        paramInt += 1;
      }
      paramStringBuilder.append("}\n");
    }
    zza(paramStringBuilder, 3);
    paramStringBuilder.append("}\n");
  }
  
  private static void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    zza(paramStringBuilder, paramInt + 1);
    paramStringBuilder.append(paramString);
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append('\n');
  }
  
  private final void zza(StringBuilder paramStringBuilder, int paramInt, List<zzcd.zze> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramInt += 1;
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      zzcd.zze localzze = (zzcd.zze)localIterator.next();
      if (localzze != null)
      {
        zza(paramStringBuilder, paramInt);
        paramStringBuilder.append("param {\n");
        boolean bool = localzze.zza();
        Object localObject = null;
        if (bool) {
          paramList = zzn().zzb(localzze.zzb());
        } else {
          paramList = null;
        }
        zza(paramStringBuilder, paramInt, "name", paramList);
        if (localzze.zzc()) {
          paramList = localzze.zzd();
        } else {
          paramList = null;
        }
        zza(paramStringBuilder, paramInt, "string_value", paramList);
        if (localzze.zze()) {
          paramList = Long.valueOf(localzze.zzf());
        } else {
          paramList = null;
        }
        zza(paramStringBuilder, paramInt, "int_value", paramList);
        paramList = (List<zzcd.zze>)localObject;
        if (localzze.zzi()) {
          paramList = Double.valueOf(localzze.zzj());
        }
        zza(paramStringBuilder, paramInt, "double_value", paramList);
        if (localzze.zzl() > 0) {
          zza(paramStringBuilder, paramInt, localzze.zzk());
        }
        zza(paramStringBuilder, paramInt);
        paramStringBuilder.append("}\n");
      }
    }
  }
  
  static boolean zza(zzar paramzzar, zzn paramzzn)
  {
    Preconditions.checkNotNull(paramzzar);
    Preconditions.checkNotNull(paramzzn);
    return (!TextUtils.isEmpty(paramzzn.zzb)) || (!TextUtils.isEmpty(paramzzn.zzr));
  }
  
  static boolean zza(String paramString)
  {
    return (paramString != null) && (paramString.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)")) && (paramString.length() <= 310);
  }
  
  static boolean zza(List<Long> paramList, int paramInt)
  {
    return (paramInt < paramList.size() << 6) && ((1L << paramInt % 64 & ((Long)paramList.get(paramInt / 64)).longValue()) != 0L);
  }
  
  static Object zzb(zzcd.zzc paramzzc, String paramString)
  {
    paramzzc = zza(paramzzc, paramString);
    if (paramzzc != null)
    {
      if (paramzzc.zzc()) {
        return paramzzc.zzd();
      }
      if (paramzzc.zze()) {
        return Long.valueOf(paramzzc.zzf());
      }
      if (paramzzc.zzi()) {
        return Double.valueOf(paramzzc.zzj());
      }
      if (paramzzc.zzl() > 0)
      {
        paramString = paramzzc.zzk();
        paramzzc = new ArrayList();
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          Object localObject = (zzcd.zze)paramString.next();
          if (localObject != null)
          {
            Bundle localBundle = new Bundle();
            localObject = ((zzcd.zze)localObject).zzk().iterator();
            while (((Iterator)localObject).hasNext())
            {
              zzcd.zze localzze = (zzcd.zze)((Iterator)localObject).next();
              if (localzze.zzc()) {
                localBundle.putString(localzze.zzb(), localzze.zzd());
              } else if (localzze.zze()) {
                localBundle.putLong(localzze.zzb(), localzze.zzf());
              } else if (localzze.zzi()) {
                localBundle.putDouble(localzze.zzb(), localzze.zzj());
              }
            }
            if (!localBundle.isEmpty()) {
              paramzzc.add(localBundle);
            }
          }
        }
        return (Bundle[])paramzzc.toArray(new Bundle[paramzzc.size()]);
      }
    }
    return null;
  }
  
  final long zza(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    zzo().zzc();
    MessageDigest localMessageDigest = zzkw.zzh();
    if (localMessageDigest == null)
    {
      zzq().zze().zza("Failed to get MD5");
      return 0L;
    }
    return zzkw.zza(localMessageDigest.digest(paramArrayOfByte));
  }
  
  /* Error */
  final <T extends android.os.Parcelable> T zza(byte[] paramArrayOfByte, android.os.Parcelable.Creator<T> paramCreator)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: invokestatic 521	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   9: astore_3
    //   10: aload_3
    //   11: aload_1
    //   12: iconst_0
    //   13: aload_1
    //   14: arraylength
    //   15: invokevirtual 525	android/os/Parcel:unmarshall	([BII)V
    //   18: aload_3
    //   19: iconst_0
    //   20: invokevirtual 528	android/os/Parcel:setDataPosition	(I)V
    //   23: aload_2
    //   24: aload_3
    //   25: invokeinterface 534 2 0
    //   30: checkcast 536	android/os/Parcelable
    //   33: astore_1
    //   34: aload_3
    //   35: invokevirtual 539	android/os/Parcel:recycle	()V
    //   38: aload_1
    //   39: areturn
    //   40: astore_1
    //   41: goto +22 -> 63
    //   44: aload_0
    //   45: invokevirtual 492	com/google/android/gms/measurement/internal/zzgo:zzq	()Lcom/google/android/gms/measurement/internal/zzer;
    //   48: invokevirtual 497	com/google/android/gms/measurement/internal/zzer:zze	()Lcom/google/android/gms/measurement/internal/zzet;
    //   51: ldc_w 541
    //   54: invokevirtual 504	com/google/android/gms/measurement/internal/zzet:zza	(Ljava/lang/String;)V
    //   57: aload_3
    //   58: invokevirtual 539	android/os/Parcel:recycle	()V
    //   61: aconst_null
    //   62: areturn
    //   63: aload_3
    //   64: invokevirtual 539	android/os/Parcel:recycle	()V
    //   67: aload_1
    //   68: athrow
    //   69: astore_1
    //   70: goto -26 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	zzks
    //   0	73	1	paramArrayOfByte	byte[]
    //   0	73	2	paramCreator	android.os.Parcelable.Creator<T>
    //   9	55	3	localParcel	android.os.Parcel
    // Exception table:
    //   from	to	target	type
    //   10	34	40	finally
    //   44	57	40	finally
    //   10	34	69	com/google/android/gms/common/internal/safeparcel/SafeParcelReader$ParseException
  }
  
  final zzcd.zzc zza(zzak paramzzak)
  {
    zzcd.zzc.zza localzza = zzcd.zzc.zzj().zzb(paramzzak.zzd);
    Iterator localIterator = paramzzak.zze.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      zzcd.zze.zza localzza1 = zzcd.zze.zzm().zza(str);
      zza(localzza1, paramzzak.zze.zza(str));
      localzza.zza(localzza1);
    }
    return (zzcd.zzc)localzza.zzz();
  }
  
  final String zza(zzbv.zzb paramzzb)
  {
    if (paramzzb == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nevent_filter {\n");
    if (paramzzb.zza()) {
      zza(localStringBuilder, 0, "filter_id", Integer.valueOf(paramzzb.zzb()));
    }
    zza(localStringBuilder, 0, "event_name", zzn().zza(paramzzb.zzc()));
    String str = zza(paramzzb.zzh(), paramzzb.zzi(), paramzzb.zzk());
    if (!str.isEmpty()) {
      zza(localStringBuilder, 0, "filter_type", str);
    }
    if (paramzzb.zzf()) {
      zza(localStringBuilder, 1, "event_count_filter", paramzzb.zzg());
    }
    if (paramzzb.zze() > 0)
    {
      localStringBuilder.append("  filters {\n");
      paramzzb = paramzzb.zzd().iterator();
      while (paramzzb.hasNext()) {
        zza(localStringBuilder, 2, (zzbv.zzc)paramzzb.next());
      }
    }
    zza(localStringBuilder, 1);
    localStringBuilder.append("}\n}\n");
    return localStringBuilder.toString();
  }
  
  final String zza(zzbv.zze paramzze)
  {
    if (paramzze == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nproperty_filter {\n");
    if (paramzze.zza()) {
      zza(localStringBuilder, 0, "filter_id", Integer.valueOf(paramzze.zzb()));
    }
    zza(localStringBuilder, 0, "property_name", zzn().zzc(paramzze.zzc()));
    String str = zza(paramzze.zze(), paramzze.zzf(), paramzze.zzh());
    if (!str.isEmpty()) {
      zza(localStringBuilder, 0, "filter_type", str);
    }
    zza(localStringBuilder, 1, paramzze.zzd());
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
  
  final String zza(zzcd.zzf paramzzf)
  {
    if (paramzzf == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nbatch {\n");
    Iterator localIterator = paramzzf.zza().iterator();
    while (localIterator.hasNext())
    {
      zzcd.zzg localzzg = (zzcd.zzg)localIterator.next();
      if (localzzg != null)
      {
        zza(localStringBuilder, 1);
        localStringBuilder.append("bundle {\n");
        if (localzzg.zza()) {
          zza(localStringBuilder, 1, "protocol_version", Integer.valueOf(localzzg.zzb()));
        }
        zza(localStringBuilder, 1, "platform", localzzg.zzq());
        if (localzzg.zzz()) {
          zza(localStringBuilder, 1, "gmp_version", Long.valueOf(localzzg.h_()));
        }
        if (localzzg.zzab()) {
          zza(localStringBuilder, 1, "uploading_gmp_version", Long.valueOf(localzzg.zzac()));
        }
        if (localzzg.zzbc()) {
          zza(localStringBuilder, 1, "dynamite_version", Long.valueOf(localzzg.zzbd()));
        }
        if (localzzg.zzau()) {
          zza(localStringBuilder, 1, "config_version", Long.valueOf(localzzg.zzav()));
        }
        zza(localStringBuilder, 1, "gmp_app_id", localzzg.zzam());
        zza(localStringBuilder, 1, "admob_app_id", localzzg.zzbb());
        zza(localStringBuilder, 1, "app_id", localzzg.zzx());
        zza(localStringBuilder, 1, "app_version", localzzg.zzy());
        if (localzzg.zzar()) {
          zza(localStringBuilder, 1, "app_version_major", Integer.valueOf(localzzg.zzas()));
        }
        zza(localStringBuilder, 1, "firebase_instance_id", localzzg.zzaq());
        if (localzzg.zzah()) {
          zza(localStringBuilder, 1, "dev_cert_hash", Long.valueOf(localzzg.zzai()));
        }
        zza(localStringBuilder, 1, "app_store", localzzg.zzw());
        if (localzzg.zzg()) {
          zza(localStringBuilder, 1, "upload_timestamp_millis", Long.valueOf(localzzg.zzh()));
        }
        if (localzzg.zzi()) {
          zza(localStringBuilder, 1, "start_timestamp_millis", Long.valueOf(localzzg.zzj()));
        }
        if (localzzg.zzk()) {
          zza(localStringBuilder, 1, "end_timestamp_millis", Long.valueOf(localzzg.zzl()));
        }
        if (localzzg.zzm()) {
          zza(localStringBuilder, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(localzzg.zzn()));
        }
        if (localzzg.zzo()) {
          zza(localStringBuilder, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(localzzg.zzp()));
        }
        zza(localStringBuilder, 1, "app_instance_id", localzzg.zzag());
        zza(localStringBuilder, 1, "resettable_device_id", localzzg.zzad());
        zza(localStringBuilder, 1, "device_id", localzzg.zzat());
        zza(localStringBuilder, 1, "ds_id", localzzg.zzay());
        if (localzzg.zzae()) {
          zza(localStringBuilder, 1, "limited_ad_tracking", Boolean.valueOf(localzzg.zzaf()));
        }
        zza(localStringBuilder, 1, "os_version", localzzg.zzr());
        zza(localStringBuilder, 1, "device_model", localzzg.zzs());
        zza(localStringBuilder, 1, "user_default_language", localzzg.zzt());
        if (localzzg.zzu()) {
          zza(localStringBuilder, 1, "time_zone_offset_minutes", Integer.valueOf(localzzg.zzv()));
        }
        if (localzzg.zzaj()) {
          zza(localStringBuilder, 1, "bundle_sequential_index", Integer.valueOf(localzzg.zzak()));
        }
        if (localzzg.zzan()) {
          zza(localStringBuilder, 1, "service_upload", Boolean.valueOf(localzzg.zzao()));
        }
        zza(localStringBuilder, 1, "health_monitor", localzzg.zzal());
        if ((!zzs().zza(zzat.zzbx)) && (localzzg.zzaw()) && (localzzg.zzax() != 0L)) {
          zza(localStringBuilder, 1, "android_id", Long.valueOf(localzzg.zzax()));
        }
        if (localzzg.zzaz()) {
          zza(localStringBuilder, 1, "retry_counter", Integer.valueOf(localzzg.zzba()));
        }
        if (localzzg.zzbf()) {
          zza(localStringBuilder, 1, "consent_signals", localzzg.zzbg());
        }
        paramzzf = localzzg.zze();
        Object localObject2;
        if (paramzzf != null)
        {
          localObject2 = paramzzf.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            zzcd.zzk localzzk = (zzcd.zzk)((Iterator)localObject2).next();
            if (localzzk != null)
            {
              zza(localStringBuilder, 2);
              localStringBuilder.append("user_property {\n");
              boolean bool = localzzk.zza();
              localObject1 = null;
              if (bool) {
                paramzzf = Long.valueOf(localzzk.zzb());
              } else {
                paramzzf = null;
              }
              zza(localStringBuilder, 2, "set_timestamp_millis", paramzzf);
              zza(localStringBuilder, 2, "name", zzn().zzc(localzzk.zzc()));
              zza(localStringBuilder, 2, "string_value", localzzk.zze());
              if (localzzk.zzf()) {
                paramzzf = Long.valueOf(localzzk.zzg());
              } else {
                paramzzf = null;
              }
              zza(localStringBuilder, 2, "int_value", paramzzf);
              paramzzf = (zzcd.zzf)localObject1;
              if (localzzk.zzh()) {
                paramzzf = Double.valueOf(localzzk.zzi());
              }
              zza(localStringBuilder, 2, "double_value", paramzzf);
              zza(localStringBuilder, 2);
              localStringBuilder.append("}\n");
            }
          }
        }
        Object localObject1 = localzzg.zzap();
        paramzzf = localzzg.zzx();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (zzcd.zza)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              zza(localStringBuilder, 2);
              localStringBuilder.append("audience_membership {\n");
              if (((zzcd.zza)localObject2).zza()) {
                zza(localStringBuilder, 2, "audience_id", Integer.valueOf(((zzcd.zza)localObject2).zzb()));
              }
              if (((zzcd.zza)localObject2).zzf()) {
                zza(localStringBuilder, 2, "new_audience", Boolean.valueOf(((zzcd.zza)localObject2).zzg()));
              }
              zza(localStringBuilder, 2, "current_data", ((zzcd.zza)localObject2).zzc(), paramzzf);
              if (((zzcd.zza)localObject2).zzd()) {
                zza(localStringBuilder, 2, "previous_data", ((zzcd.zza)localObject2).zze(), paramzzf);
              }
              zza(localStringBuilder, 2);
              localStringBuilder.append("}\n");
            }
          }
        }
        paramzzf = localzzg.zzc();
        if (paramzzf != null)
        {
          paramzzf = paramzzf.iterator();
          while (paramzzf.hasNext())
          {
            localObject1 = (zzcd.zzc)paramzzf.next();
            if (localObject1 != null)
            {
              zza(localStringBuilder, 2);
              localStringBuilder.append("event {\n");
              zza(localStringBuilder, 2, "name", zzn().zza(((zzcd.zzc)localObject1).zzc()));
              if (((zzcd.zzc)localObject1).zzd()) {
                zza(localStringBuilder, 2, "timestamp_millis", Long.valueOf(((zzcd.zzc)localObject1).zze()));
              }
              if (((zzcd.zzc)localObject1).zzf()) {
                zza(localStringBuilder, 2, "previous_timestamp_millis", Long.valueOf(((zzcd.zzc)localObject1).zzg()));
              }
              if (((zzcd.zzc)localObject1).zzh()) {
                zza(localStringBuilder, 2, "count", Integer.valueOf(((zzcd.zzc)localObject1).zzi()));
              }
              if (((zzcd.zzc)localObject1).zzb() != 0) {
                zza(localStringBuilder, 2, ((zzcd.zzc)localObject1).zza());
              }
              zza(localStringBuilder, 2);
              localStringBuilder.append("}\n");
            }
          }
        }
        zza(localStringBuilder, 1);
        localStringBuilder.append("}\n");
      }
    }
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
  
  final List<Long> zza(List<Long> paramList, List<Integer> paramList1)
  {
    paramList = new ArrayList(paramList);
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      Integer localInteger = (Integer)paramList1.next();
      if (localInteger.intValue() < 0)
      {
        zzq().zzh().zza("Ignoring negative bit index to be cleared", localInteger);
      }
      else
      {
        i = localInteger.intValue() / 64;
        if (i >= paramList.size()) {
          zzq().zzh().zza("Ignoring bit index greater than bitSet size", localInteger, Integer.valueOf(paramList.size()));
        } else {
          paramList.set(i, Long.valueOf(((Long)paramList.get(i)).longValue() & 1L << localInteger.intValue() % 64));
        }
      }
    }
    int j = paramList.size();
    int k;
    for (int i = paramList.size() - 1; (i >= 0) && (((Long)paramList.get(i)).longValue() == 0L); i = k)
    {
      k = i - 1;
      j = i;
    }
    return paramList.subList(0, j);
  }
  
  final void zza(zzcd.zze.zza paramzza, Object paramObject)
  {
    Preconditions.checkNotNull(paramObject);
    paramzza.zza().zzb().zzc().zze();
    if ((paramObject instanceof String))
    {
      paramzza.zzb((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramzza.zza(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramzza.zza(((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Bundle[]))
    {
      paramzza.zza(zza((Bundle[])paramObject));
      return;
    }
    zzq().zze().zza("Ignoring invalid (type) event param value", paramObject);
  }
  
  final void zza(zzcd.zzk.zza paramzza, Object paramObject)
  {
    Preconditions.checkNotNull(paramObject);
    paramzza.zza().zzb().zzc();
    if ((paramObject instanceof String))
    {
      paramzza.zzb((String)paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramzza.zzb(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramzza.zza(((Double)paramObject).doubleValue());
      return;
    }
    zzq().zze().zza("Ignoring invalid (type) user attribute value", paramObject);
  }
  
  final boolean zza(long paramLong1, long paramLong2)
  {
    return (paramLong1 == 0L) || (paramLong2 <= 0L) || (Math.abs(zzl().currentTimeMillis() - paramLong1) > paramLong2);
  }
  
  final byte[] zzb(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
      GZIPInputStream localGZIPInputStream = new GZIPInputStream(paramArrayOfByte);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = localGZIPInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localGZIPInputStream.close();
      paramArrayOfByte.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      zzq().zze().zza("Failed to ungzip content", paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  final byte[] zzc(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      localByteArrayOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      zzq().zze().zza("Failed to gzip content", paramArrayOfByte);
      throw paramArrayOfByte;
    }
  }
  
  protected final boolean zzd()
  {
    return false;
  }
  
  final List<Integer> zze()
  {
    Object localObject = zzat.zza(this.zza.zzm());
    if (localObject != null)
    {
      if (((Map)localObject).size() == 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = ((Integer)zzat.zzao.zza(null)).intValue();
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((String)localEntry.getKey()).startsWith("measurement.id.")) {
          try
          {
            int j = Integer.parseInt((String)localEntry.getValue());
            if (j != 0)
            {
              localArrayList.add(Integer.valueOf(j));
              if (localArrayList.size() >= i) {
                zzq().zzh().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(localArrayList.size()));
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            zzq().zzh().zza("Experiment ID NumberFormatException", localNumberFormatException);
          }
        }
      }
      if (localArrayList.size() == 0) {
        return null;
      }
      return localArrayList;
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */