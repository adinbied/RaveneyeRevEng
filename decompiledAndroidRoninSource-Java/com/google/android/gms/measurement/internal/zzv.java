package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbv.zzd;
import com.google.android.gms.internal.measurement.zzbv.zzf;
import com.google.android.gms.internal.measurement.zzbv.zzf.zzb;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

abstract class zzv
{
  String zza;
  int zzb;
  Boolean zzc;
  Boolean zzd;
  Long zze;
  Long zzf;
  
  zzv(String paramString, int paramInt)
  {
    this.zza = paramString;
    this.zzb = paramInt;
  }
  
  static Boolean zza(double paramDouble, zzbv.zzd paramzzd)
  {
    try
    {
      paramzzd = zza(new BigDecimal(paramDouble), paramzzd, Math.ulp(paramDouble));
      return paramzzd;
    }
    catch (NumberFormatException paramzzd)
    {
      for (;;) {}
    }
    return null;
  }
  
  static Boolean zza(long paramLong, zzbv.zzd paramzzd)
  {
    try
    {
      paramzzd = zza(new BigDecimal(paramLong), paramzzd, 0.0D);
      return paramzzd;
    }
    catch (NumberFormatException paramzzd)
    {
      for (;;) {}
    }
    return null;
  }
  
  static Boolean zza(Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean == null) {
      return null;
    }
    if (paramBoolean.booleanValue() != paramBoolean1) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    return Boolean.valueOf(paramBoolean1);
  }
  
  static Boolean zza(String paramString, zzbv.zzd paramzzd)
  {
    if (!zzks.zza(paramString)) {
      return null;
    }
    try
    {
      paramString = zza(new BigDecimal(paramString), paramzzd, 0.0D);
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  private static Boolean zza(String paramString1, zzbv.zzf.zzb paramzzb, boolean paramBoolean, String paramString2, List<String> paramList, String paramString3, zzer paramzzer)
  {
    if (paramString1 == null) {
      return null;
    }
    if (paramzzb == zzbv.zzf.zzb.zzg)
    {
      if ((paramList == null) || (paramList.size() == 0)) {
        return null;
      }
    }
    else if (paramString2 == null) {
      return null;
    }
    String str = paramString1;
    if (!paramBoolean) {
      if (paramzzb == zzbv.zzf.zzb.zzb) {
        str = paramString1;
      } else {
        str = paramString1.toUpperCase(Locale.ENGLISH);
      }
    }
    switch (zzr.zza[paramzzb.ordinal()])
    {
    default: 
      return null;
    case 6: 
      return Boolean.valueOf(paramList.contains(str));
    case 5: 
      return Boolean.valueOf(str.equals(paramString2));
    case 4: 
      return Boolean.valueOf(str.contains(paramString2));
    case 3: 
      return Boolean.valueOf(str.endsWith(paramString2));
    case 2: 
      return Boolean.valueOf(str.startsWith(paramString2));
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 66;
    }
    try
    {
      paramBoolean = Pattern.compile(paramString3, i).matcher(str).matches();
      return Boolean.valueOf(paramBoolean);
    }
    catch (PatternSyntaxException paramString1)
    {
      for (;;) {}
    }
    if (paramzzer != null) {
      paramzzer.zzh().zza("Invalid regular expression in REGEXP audience filter. expression", paramString3);
    }
    return null;
  }
  
  static Boolean zza(String paramString, zzbv.zzf paramzzf, zzer paramzzer)
  {
    Preconditions.checkNotNull(paramzzf);
    if (paramString == null) {
      return null;
    }
    if (paramzzf.zza())
    {
      if (paramzzf.zzb() == zzbv.zzf.zzb.zza) {
        return null;
      }
      if (paramzzf.zzb() == zzbv.zzf.zzb.zzg)
      {
        if (paramzzf.zzh() == 0) {
          return null;
        }
      }
      else if (!paramzzf.zzc()) {
        return null;
      }
      zzbv.zzf.zzb localzzb = paramzzf.zzb();
      boolean bool = paramzzf.zzf();
      String str;
      if ((!bool) && (localzzb != zzbv.zzf.zzb.zzb) && (localzzb != zzbv.zzf.zzb.zzg)) {
        str = paramzzf.zzd().toUpperCase(Locale.ENGLISH);
      } else {
        str = paramzzf.zzd();
      }
      Object localObject;
      if (paramzzf.zzh() == 0)
      {
        paramzzf = null;
      }
      else
      {
        paramzzf = paramzzf.zzg();
        if (!bool) {
          for (;;)
          {
            localObject = new ArrayList(paramzzf.size());
            paramzzf = paramzzf.iterator();
            while (paramzzf.hasNext()) {
              ((List)localObject).add(((String)paramzzf.next()).toUpperCase(Locale.ENGLISH));
            }
            paramzzf = Collections.unmodifiableList((List)localObject);
          }
        }
      }
      if (localzzb == zzbv.zzf.zzb.zzb) {
        localObject = str;
      } else {
        localObject = null;
      }
      return zza(paramString, localzzb, bool, str, paramzzf, (String)localObject, paramzzer);
    }
    return null;
  }
  
  /* Error */
  private static Boolean zza(BigDecimal paramBigDecimal, zzbv.zzd paramzzd, double paramDouble)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 155	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_1
    //   6: invokevirtual 208	com/google/android/gms/internal/measurement/zzbv$zzd:zza	()Z
    //   9: ifeq +413 -> 422
    //   12: aload_1
    //   13: invokevirtual 211	com/google/android/gms/internal/measurement/zzbv$zzd:zzb	()Lcom/google/android/gms/internal/measurement/zzbv$zzd$zza;
    //   16: getstatic 216	com/google/android/gms/internal/measurement/zzbv$zzd$zza:zza	Lcom/google/android/gms/internal/measurement/zzbv$zzd$zza;
    //   19: if_acmpne +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: aload_1
    //   25: invokevirtual 211	com/google/android/gms/internal/measurement/zzbv$zzd:zzb	()Lcom/google/android/gms/internal/measurement/zzbv$zzd$zza;
    //   28: getstatic 218	com/google/android/gms/internal/measurement/zzbv$zzd$zza:zze	Lcom/google/android/gms/internal/measurement/zzbv$zzd$zza;
    //   31: if_acmpne +19 -> 50
    //   34: aload_1
    //   35: invokevirtual 220	com/google/android/gms/internal/measurement/zzbv$zzd:zzg	()Z
    //   38: ifeq +10 -> 48
    //   41: aload_1
    //   42: invokevirtual 223	com/google/android/gms/internal/measurement/zzbv$zzd:zzi	()Z
    //   45: ifne +14 -> 59
    //   48: aconst_null
    //   49: areturn
    //   50: aload_1
    //   51: invokevirtual 225	com/google/android/gms/internal/measurement/zzbv$zzd:zze	()Z
    //   54: ifne +5 -> 59
    //   57: aconst_null
    //   58: areturn
    //   59: aload_1
    //   60: invokevirtual 211	com/google/android/gms/internal/measurement/zzbv$zzd:zzb	()Lcom/google/android/gms/internal/measurement/zzbv$zzd$zza;
    //   63: astore 12
    //   65: aload_1
    //   66: invokevirtual 211	com/google/android/gms/internal/measurement/zzbv$zzd:zzb	()Lcom/google/android/gms/internal/measurement/zzbv$zzd$zza;
    //   69: getstatic 218	com/google/android/gms/internal/measurement/zzbv$zzd$zza:zze	Lcom/google/android/gms/internal/measurement/zzbv$zzd$zza;
    //   72: if_acmpne +62 -> 134
    //   75: aload_1
    //   76: invokevirtual 227	com/google/android/gms/internal/measurement/zzbv$zzd:zzh	()Ljava/lang/String;
    //   79: invokestatic 62	com/google/android/gms/measurement/internal/zzks:zza	(Ljava/lang/String;)Z
    //   82: ifeq +50 -> 132
    //   85: aload_1
    //   86: invokevirtual 230	com/google/android/gms/internal/measurement/zzbv$zzd:zzj	()Ljava/lang/String;
    //   89: invokestatic 62	com/google/android/gms/measurement/internal/zzks:zza	(Ljava/lang/String;)Z
    //   92: ifne +5 -> 97
    //   95: aconst_null
    //   96: areturn
    //   97: new 29	java/math/BigDecimal
    //   100: dup
    //   101: aload_1
    //   102: invokevirtual 227	com/google/android/gms/internal/measurement/zzbv$zzd:zzh	()Ljava/lang/String;
    //   105: invokespecial 65	java/math/BigDecimal:<init>	(Ljava/lang/String;)V
    //   108: astore 10
    //   110: new 29	java/math/BigDecimal
    //   113: dup
    //   114: aload_1
    //   115: invokevirtual 230	com/google/android/gms/internal/measurement/zzbv$zzd:zzj	()Ljava/lang/String;
    //   118: invokespecial 65	java/math/BigDecimal:<init>	(Ljava/lang/String;)V
    //   121: astore 11
    //   123: aload 10
    //   125: astore_1
    //   126: aconst_null
    //   127: astore 10
    //   129: goto +35 -> 164
    //   132: aconst_null
    //   133: areturn
    //   134: aload_1
    //   135: invokevirtual 232	com/google/android/gms/internal/measurement/zzbv$zzd:zzf	()Ljava/lang/String;
    //   138: invokestatic 62	com/google/android/gms/measurement/internal/zzks:zza	(Ljava/lang/String;)Z
    //   141: ifne +5 -> 146
    //   144: aconst_null
    //   145: areturn
    //   146: new 29	java/math/BigDecimal
    //   149: dup
    //   150: aload_1
    //   151: invokevirtual 232	com/google/android/gms/internal/measurement/zzbv$zzd:zzf	()Ljava/lang/String;
    //   154: invokespecial 65	java/math/BigDecimal:<init>	(Ljava/lang/String;)V
    //   157: astore 10
    //   159: aconst_null
    //   160: astore_1
    //   161: aload_1
    //   162: astore 11
    //   164: aload 12
    //   166: getstatic 218	com/google/android/gms/internal/measurement/zzbv$zzd$zza:zze	Lcom/google/android/gms/internal/measurement/zzbv$zzd$zza;
    //   169: if_acmpne +9 -> 178
    //   172: aload_1
    //   173: ifnonnull +10 -> 183
    //   176: aconst_null
    //   177: areturn
    //   178: aload 10
    //   180: ifnull +242 -> 422
    //   183: getstatic 234	com/google/android/gms/measurement/internal/zzr:zzb	[I
    //   186: aload 12
    //   188: invokevirtual 235	com/google/android/gms/internal/measurement/zzbv$zzd$zza:ordinal	()I
    //   191: iaload
    //   192: istore 4
    //   194: iconst_0
    //   195: istore 7
    //   197: iconst_0
    //   198: istore 5
    //   200: iconst_0
    //   201: istore 8
    //   203: iconst_0
    //   204: istore 9
    //   206: iconst_0
    //   207: istore 6
    //   209: iload 4
    //   211: iconst_1
    //   212: if_icmpeq +187 -> 399
    //   215: iload 4
    //   217: iconst_2
    //   218: if_icmpeq +158 -> 376
    //   221: iload 4
    //   223: iconst_3
    //   224: if_icmpeq +47 -> 271
    //   227: iload 4
    //   229: iconst_4
    //   230: if_icmpeq +5 -> 235
    //   233: aconst_null
    //   234: areturn
    //   235: iload 6
    //   237: istore 5
    //   239: aload_0
    //   240: aload_1
    //   241: invokevirtual 239	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   244: iconst_m1
    //   245: if_icmpeq +20 -> 265
    //   248: iload 6
    //   250: istore 5
    //   252: aload_0
    //   253: aload 11
    //   255: invokevirtual 239	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   258: iconst_1
    //   259: if_icmpeq +6 -> 265
    //   262: iconst_1
    //   263: istore 5
    //   265: iload 5
    //   267: invokestatic 56	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   270: areturn
    //   271: dload_2
    //   272: dconst_0
    //   273: dcmpl
    //   274: ifeq +84 -> 358
    //   277: iload 7
    //   279: istore 5
    //   281: aload_0
    //   282: aload 10
    //   284: new 29	java/math/BigDecimal
    //   287: dup
    //   288: dload_2
    //   289: invokespecial 32	java/math/BigDecimal:<init>	(D)V
    //   292: new 29	java/math/BigDecimal
    //   295: dup
    //   296: iconst_2
    //   297: invokespecial 240	java/math/BigDecimal:<init>	(I)V
    //   300: invokevirtual 244	java/math/BigDecimal:multiply	(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    //   303: invokevirtual 247	java/math/BigDecimal:subtract	(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    //   306: invokevirtual 239	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   309: iconst_1
    //   310: if_icmpne +42 -> 352
    //   313: iload 7
    //   315: istore 5
    //   317: aload_0
    //   318: aload 10
    //   320: new 29	java/math/BigDecimal
    //   323: dup
    //   324: dload_2
    //   325: invokespecial 32	java/math/BigDecimal:<init>	(D)V
    //   328: new 29	java/math/BigDecimal
    //   331: dup
    //   332: iconst_2
    //   333: invokespecial 240	java/math/BigDecimal:<init>	(I)V
    //   336: invokevirtual 244	java/math/BigDecimal:multiply	(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    //   339: invokevirtual 249	java/math/BigDecimal:add	(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    //   342: invokevirtual 239	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   345: iconst_m1
    //   346: if_icmpne +6 -> 352
    //   349: iconst_1
    //   350: istore 5
    //   352: iload 5
    //   354: invokestatic 56	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   357: areturn
    //   358: aload_0
    //   359: aload 10
    //   361: invokevirtual 239	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   364: ifne +6 -> 370
    //   367: iconst_1
    //   368: istore 5
    //   370: iload 5
    //   372: invokestatic 56	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   375: areturn
    //   376: iload 8
    //   378: istore 5
    //   380: aload_0
    //   381: aload 10
    //   383: invokevirtual 239	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   386: iconst_1
    //   387: if_icmpne +6 -> 393
    //   390: iconst_1
    //   391: istore 5
    //   393: iload 5
    //   395: invokestatic 56	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   398: areturn
    //   399: iload 9
    //   401: istore 5
    //   403: aload_0
    //   404: aload 10
    //   406: invokevirtual 239	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   409: iconst_m1
    //   410: if_icmpne +6 -> 416
    //   413: iconst_1
    //   414: istore 5
    //   416: iload 5
    //   418: invokestatic 56	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   421: areturn
    //   422: aconst_null
    //   423: areturn
    //   424: astore_0
    //   425: aconst_null
    //   426: areturn
    //   427: astore_0
    //   428: aconst_null
    //   429: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	paramBigDecimal	BigDecimal
    //   0	430	1	paramzzd	zzbv.zzd
    //   0	430	2	paramDouble	double
    //   192	39	4	i	int
    //   198	219	5	bool1	boolean
    //   207	42	6	bool2	boolean
    //   195	119	7	bool3	boolean
    //   201	176	8	bool4	boolean
    //   204	196	9	bool5	boolean
    //   108	297	10	localBigDecimal	BigDecimal
    //   121	133	11	localObject	Object
    //   63	124	12	localzza	com.google.android.gms.internal.measurement.zzbv.zzd.zza
    // Exception table:
    //   from	to	target	type
    //   97	123	424	java/lang/NumberFormatException
    //   146	159	427	java/lang/NumberFormatException
  }
  
  abstract int zza();
  
  abstract boolean zzb();
  
  abstract boolean zzc();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */