package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzlx;
import com.google.android.gms.internal.measurement.zznt;
import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

public final class zzkw
  extends zzgr
{
  private static final String[] zza = { "firebase_", "google_", "ga_" };
  private static final String[] zzb = { "_err" };
  private SecureRandom zzc;
  private final AtomicLong zzd = new AtomicLong(0L);
  private int zze;
  private Integer zzf = null;
  
  zzkw(zzfv paramzzfv)
  {
    super(paramzzfv);
  }
  
  private final int zza(String paramString1, String paramString2, String paramString3, Object paramObject, Bundle paramBundle, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    zzc();
    boolean bool = zza(paramObject);
    int k = 0;
    if (bool) {
      if (paramBoolean2)
      {
        if (!zza(paramString3, zzgv.zzc)) {
          return 20;
        }
        if (!this.zzy.zzv().zzah()) {
          return 25;
        }
        bool = paramObject instanceof Parcelable[];
        if (bool)
        {
          i = ((Parcelable[])paramObject).length;
        }
        else
        {
          if (!(paramObject instanceof ArrayList)) {
            break label128;
          }
          i = ((ArrayList)paramObject).size();
        }
        if (i > 200)
        {
          zzq().zzj().zza("Parameter array is too long; discarded. Value kind, name, array length", "param", paramString3, Integer.valueOf(i));
          i = 0;
        }
        else
        {
          label128:
          i = 1;
        }
        if (i == 0)
        {
          Object localObject;
          if (bool)
          {
            localObject = (Parcelable[])paramObject;
            if (localObject.length > 200) {
              paramBundle.putParcelableArray(paramString3, (Parcelable[])Arrays.copyOf((Object[])localObject, 200));
            }
          }
          else if ((paramObject instanceof ArrayList))
          {
            localObject = (ArrayList)paramObject;
            if (((ArrayList)localObject).size() > 200) {
              paramBundle.putParcelableArrayList(paramString3, new ArrayList(((ArrayList)localObject).subList(0, 200)));
            }
          }
          i = 17;
          break label238;
        }
      }
      else
      {
        return 21;
      }
    }
    int i = 0;
    label238:
    int j;
    if (((zzs().zze(paramString1, zzat.zzaq)) && (zzd(paramString2))) || (zzd(paramString3))) {
      j = 256;
    } else {
      j = 100;
    }
    if (zza("param", paramString3, j, paramObject)) {
      return i;
    }
    if (paramBoolean2)
    {
      if ((paramObject instanceof Bundle)) {
        zza(paramString1, paramString2, paramString3, (Bundle)paramObject, paramList, paramBoolean1);
      }
      for (;;)
      {
        j = 1;
        break;
        int m;
        if ((paramObject instanceof Parcelable[]))
        {
          paramObject = (Parcelable[])paramObject;
          m = paramObject.length;
          j = 0;
          while (j < m)
          {
            paramBundle = paramObject[j];
            if (!(paramBundle instanceof Bundle))
            {
              zzq().zzj().zza("All Parcelable[] elements must be of type Bundle. Value type, name", paramBundle.getClass(), paramString3);
              j = k;
              break label528;
            }
            zza(paramString1, paramString2, paramString3, (Bundle)paramBundle, paramList, paramBoolean1);
            j += 1;
          }
        }
        else
        {
          j = k;
          if (!(paramObject instanceof ArrayList)) {
            break;
          }
          paramObject = (ArrayList)paramObject;
          m = ((ArrayList)paramObject).size();
          j = 0;
          while (j < m)
          {
            paramBundle = ((ArrayList)paramObject).get(j);
            if (!(paramBundle instanceof Bundle))
            {
              zzq().zzj().zza("All ArrayList elements must be of type Bundle. Value type, name", paramBundle.getClass(), paramString3);
              j = k;
              break label528;
            }
            zza(paramString1, paramString2, paramString3, (Bundle)paramBundle, paramList, paramBoolean1);
            j += 1;
          }
        }
      }
      label528:
      if (j != 0) {
        return i;
      }
    }
    return 4;
  }
  
  public static long zza(long paramLong1, long paramLong2)
  {
    return (paramLong1 + paramLong2 * 60000L) / 86400000L;
  }
  
  public static long zza(zzam paramzzam)
  {
    long l = 0L;
    if (paramzzam == null) {
      return 0L;
    }
    Iterator localIterator = paramzzam.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = paramzzam.zza((String)localIterator.next());
      if ((localObject instanceof Parcelable[])) {
        l += ((Parcelable[])localObject).length;
      }
    }
    return l;
  }
  
  static long zza(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    int i = paramArrayOfByte.length;
    int j = 0;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    long l = 0L;
    i = paramArrayOfByte.length - 1;
    while ((i >= 0) && (i >= paramArrayOfByte.length - 8))
    {
      l += ((paramArrayOfByte[i] & 0xFF) << j);
      j += 8;
      i -= 1;
    }
    return l;
  }
  
  public static Bundle zza(List<zzkr> paramList)
  {
    Bundle localBundle = new Bundle();
    if (paramList == null) {
      return localBundle;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      zzkr localzzkr = (zzkr)paramList.next();
      if (localzzkr.zzd != null) {
        localBundle.putString(localzzkr.zza, localzzkr.zzd);
      } else if (localzzkr.zzc != null) {
        localBundle.putLong(localzzkr.zza, localzzkr.zzc.longValue());
      } else if (localzzkr.zzf != null) {
        localBundle.putDouble(localzzkr.zza, localzzkr.zzf.doubleValue());
      }
    }
    return localBundle;
  }
  
  private final Object zza(int paramInt, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramObject == null) {
      return null;
    }
    if (!(paramObject instanceof Long))
    {
      if ((paramObject instanceof Double)) {
        return paramObject;
      }
      if ((paramObject instanceof Integer)) {
        return Long.valueOf(((Integer)paramObject).intValue());
      }
      if ((paramObject instanceof Byte)) {
        return Long.valueOf(((Byte)paramObject).byteValue());
      }
      if ((paramObject instanceof Short)) {
        return Long.valueOf(((Short)paramObject).shortValue());
      }
      if ((paramObject instanceof Boolean))
      {
        long l;
        if (((Boolean)paramObject).booleanValue()) {
          l = 1L;
        } else {
          l = 0L;
        }
        return Long.valueOf(l);
      }
      if ((paramObject instanceof Float)) {
        return Double.valueOf(((Float)paramObject).doubleValue());
      }
      if ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence)))
      {
        if ((paramBoolean2) && (((paramObject instanceof Bundle[])) || ((paramObject instanceof Parcelable[]))))
        {
          ArrayList localArrayList = new ArrayList();
          paramObject = (Parcelable[])paramObject;
          int i = paramObject.length;
          paramInt = 0;
          while (paramInt < i)
          {
            Bundle localBundle = paramObject[paramInt];
            if ((localBundle instanceof Bundle))
            {
              localBundle = zza((Bundle)localBundle);
              if ((localBundle != null) && (!localBundle.isEmpty())) {
                localArrayList.add(localBundle);
              }
            }
            paramInt += 1;
          }
          return localArrayList.toArray(new Bundle[localArrayList.size()]);
        }
        return null;
      }
      return zza(String.valueOf(paramObject), paramInt, paramBoolean1);
    }
    return paramObject;
  }
  
  public static String zza(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.codePointCount(0, paramString.length()) > paramInt)
    {
      if (paramBoolean) {
        return String.valueOf(paramString.substring(0, paramString.offsetByCodePoints(0, paramInt))).concat("...");
      }
      return null;
    }
    return paramString;
  }
  
  private static void zza(Bundle paramBundle, int paramInt, String paramString1, String paramString2, Object paramObject)
  {
    if (zzb(paramBundle, paramInt))
    {
      paramBundle.putString("_ev", zza(paramString1, 40, true));
      if (paramObject != null)
      {
        Preconditions.checkNotNull(paramBundle);
        if ((paramObject != null) && (((paramObject instanceof String)) || ((paramObject instanceof CharSequence)))) {
          paramBundle.putLong("_el", String.valueOf(paramObject).length());
        }
      }
    }
  }
  
  private final void zza(String paramString1, String paramString2, String paramString3, Bundle paramBundle, List<String> paramList, boolean paramBoolean)
  {
    if (paramBundle == null) {
      return;
    }
    Iterator localIterator = new TreeSet(paramBundle.keySet()).iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      int j;
      int i;
      if ((paramList != null) && (paramList.contains(str1)))
      {
        j = 0;
      }
      else
      {
        if (paramBoolean) {
          i = zzg(str1);
        } else {
          i = 0;
        }
        j = i;
        if (i == 0) {
          j = zzh(str1);
        }
      }
      if (j != 0)
      {
        String str2;
        if (j == 3) {
          str2 = str1;
        } else {
          str2 = null;
        }
        zza(paramBundle, j, str1, str1, str2);
        paramBundle.remove(str1);
      }
      else
      {
        if (zza(paramBundle.get(str1)))
        {
          zzq().zzj().zza("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", paramString2, paramString3, str1);
          i = 22;
        }
        else
        {
          i = zza(paramString1, paramString2, str1, paramBundle.get(str1), paramBundle, paramList, paramBoolean, false);
        }
        if ((i != 0) && (!"_ev".equals(str1)))
        {
          zza(paramBundle, i, str1, str1, paramBundle.get(str1));
          paramBundle.remove(str1);
        }
        else if ((zza(str1)) && (!zza(str1, zzgv.zzd)))
        {
          i = k + 1;
          k = i;
          if (i > 0)
          {
            zzq().zzg().zza("Item cannot contain custom parameters", zzn().zza(paramString2), zzn().zza(paramBundle));
            zzb(paramBundle, 23);
            paramBundle.remove(str1);
            k = i;
          }
        }
      }
    }
  }
  
  static boolean zza(Context paramContext, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramContext);
    if (Build.VERSION.SDK_INT >= 24) {
      return zzb(paramContext, "com.google.android.gms.measurement.AppMeasurementJobService");
    }
    return zzb(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
  }
  
  static boolean zza(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("android.intent.extra.REFERRER_NAME");
    return ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(paramIntent)) || ("https://www.google.com".equals(paramIntent)) || ("android-app://com.google.appcrawler".equals(paramIntent));
  }
  
  static boolean zza(Bundle paramBundle, int paramInt)
  {
    int j = paramBundle.size();
    int i = 0;
    if (j <= paramInt) {
      return false;
    }
    Iterator localIterator = new TreeSet(paramBundle.keySet()).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      j = i + 1;
      i = j;
      if (j > paramInt)
      {
        paramBundle.remove(str);
        i = j;
      }
    }
    return true;
  }
  
  static boolean zza(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    if ((paramBoolean1 == null) && (paramBoolean2 == null)) {
      return true;
    }
    if (paramBoolean1 == null) {
      return false;
    }
    return paramBoolean1.equals(paramBoolean2);
  }
  
  static boolean zza(Object paramObject)
  {
    return ((paramObject instanceof Parcelable[])) || ((paramObject instanceof ArrayList)) || ((paramObject instanceof Bundle));
  }
  
  static boolean zza(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    return (paramString.charAt(0) != '_') || (paramString.equals("_ep"));
  }
  
  static boolean zza(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    if ((!bool1) && (!bool2)) {
      return !paramString1.equals(paramString2);
    }
    if ((bool1) && (bool2))
    {
      if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
        return !paramString3.equals(paramString4);
      }
      return !TextUtils.isEmpty(paramString4);
    }
    if ((!bool1) && (bool2))
    {
      if (TextUtils.isEmpty(paramString4)) {
        return false;
      }
      if (!TextUtils.isEmpty(paramString3)) {
        return !paramString3.equals(paramString4);
      }
      return true;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      return !paramString3.equals(paramString4);
    }
    return true;
  }
  
  private static boolean zza(String paramString, String[] paramArrayOfString)
  {
    Preconditions.checkNotNull(paramArrayOfString);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (zzc(paramString, paramArrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  static boolean zza(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {
      return true;
    }
    if (paramList1 == null) {
      return false;
    }
    return paramList1.equals(paramList2);
  }
  
  static byte[] zza(Parcelable paramParcelable)
  {
    if (paramParcelable == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      paramParcelable.writeToParcel(localParcel, 0);
      paramParcelable = localParcel.marshall();
      return paramParcelable;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public static Bundle zzb(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new Bundle();
    }
    paramBundle = new Bundle(paramBundle);
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramBundle.get((String)localObject1);
      if ((localObject2 instanceof Bundle))
      {
        paramBundle.putBundle((String)localObject1, new Bundle((Bundle)localObject2));
      }
      else
      {
        boolean bool = localObject2 instanceof Parcelable[];
        int j = 0;
        int i = 0;
        if (bool)
        {
          localObject1 = (Parcelable[])localObject2;
          while (i < localObject1.length)
          {
            if ((localObject1[i] instanceof Bundle)) {
              localObject1[i] = new Bundle((Bundle)localObject1[i]);
            }
            i += 1;
          }
        }
        else if ((localObject2 instanceof List))
        {
          localObject1 = (List)localObject2;
          i = j;
          while (i < ((List)localObject1).size())
          {
            localObject2 = ((List)localObject1).get(i);
            if ((localObject2 instanceof Bundle)) {
              ((List)localObject1).set(i, new Bundle((Bundle)localObject2));
            }
            i += 1;
          }
        }
      }
    }
    return paramBundle;
  }
  
  public static ArrayList<Bundle> zzb(List<zzw> paramList)
  {
    if (paramList == null) {
      return new ArrayList(0);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      zzw localzzw = (zzw)paramList.next();
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", localzzw.zza);
      localBundle.putString("origin", localzzw.zzb);
      localBundle.putLong("creation_timestamp", localzzw.zzd);
      localBundle.putString("name", localzzw.zzc.zza);
      zzgt.zza(localBundle, localzzw.zzc.zza());
      localBundle.putBoolean("active", localzzw.zze);
      if (localzzw.zzf != null) {
        localBundle.putString("trigger_event_name", localzzw.zzf);
      }
      if (localzzw.zzg != null)
      {
        localBundle.putString("timed_out_event_name", localzzw.zzg.zza);
        if (localzzw.zzg.zzb != null) {
          localBundle.putBundle("timed_out_event_params", localzzw.zzg.zzb.zzb());
        }
      }
      localBundle.putLong("trigger_timeout", localzzw.zzh);
      if (localzzw.zzi != null)
      {
        localBundle.putString("triggered_event_name", localzzw.zzi.zza);
        if (localzzw.zzi.zzb != null) {
          localBundle.putBundle("triggered_event_params", localzzw.zzi.zzb.zzb());
        }
      }
      localBundle.putLong("triggered_timestamp", localzzw.zzc.zzb);
      localBundle.putLong("time_to_live", localzzw.zzj);
      if (localzzw.zzk != null)
      {
        localBundle.putString("expired_event_name", localzzw.zzk.zza);
        if (localzzw.zzk.zzb != null) {
          localBundle.putBundle("expired_event_params", localzzw.zzk.zzb.zzb());
        }
      }
      localArrayList.add(localBundle);
    }
    return localArrayList;
  }
  
  private static boolean zzb(Context paramContext, String paramString)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return false;
      }
      paramContext = localPackageManager.getServiceInfo(new ComponentName(paramContext, paramString), 0);
      if (paramContext != null)
      {
        boolean bool = paramContext.enabled;
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  private static boolean zzb(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null) {
      return false;
    }
    if (paramBundle.getLong("_err") == 0L)
    {
      paramBundle.putLong("_err", paramInt);
      return true;
    }
    return false;
  }
  
  static Bundle[] zzb(Object paramObject)
  {
    if ((paramObject instanceof Bundle)) {
      return new Bundle[] { (Bundle)paramObject };
    }
    if ((paramObject instanceof Parcelable[]))
    {
      paramObject = (Parcelable[])paramObject;
      return (Bundle[])Arrays.copyOf((Object[])paramObject, paramObject.length, Bundle[].class);
    }
    if ((paramObject instanceof ArrayList))
    {
      paramObject = (ArrayList)paramObject;
      return (Bundle[])((ArrayList)paramObject).toArray(new Bundle[((ArrayList)paramObject).size()]);
    }
    return null;
  }
  
  private final boolean zzc(Context paramContext, String paramString)
  {
    X500Principal localX500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 64);
      if ((paramContext != null) && (paramContext.signatures != null) && (paramContext.signatures.length > 0))
      {
        paramContext = paramContext.signatures[0];
        boolean bool = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramContext.toByteArray()))).getSubjectX500Principal().equals(localX500Principal);
        return bool;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      zzq().zze().zza("Package name not found", paramContext);
    }
    catch (CertificateException paramContext)
    {
      zzq().zze().zza("Error obtaining certificate", paramContext);
    }
    return true;
  }
  
  static boolean zzc(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {
      return true;
    }
    if (paramString1 == null) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
  
  static boolean zzd(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("_"));
  }
  
  public static boolean zzf(String paramString)
  {
    String[] arrayOfString = zzb;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private final int zzg(String paramString)
  {
    if (!zza("event param", paramString)) {
      return 3;
    }
    if (!zza("event param", null, paramString)) {
      return 14;
    }
    if (!zza("event param", 40, paramString)) {
      return 3;
    }
    return 0;
  }
  
  private final int zzh(String paramString)
  {
    if (!zzb("event param", paramString)) {
      return 3;
    }
    if (!zza("event param", null, paramString)) {
      return 14;
    }
    if (!zza("event param", 40, paramString)) {
      return 3;
    }
    return 0;
  }
  
  static MessageDigest zzh()
  {
    int i = 0;
    while (i < 2)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        if (localMessageDigest != null) {
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return null;
  }
  
  private static boolean zzi(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return paramString.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
  }
  
  private final int zzj(String paramString)
  {
    if ("_ldl".equals(paramString)) {
      return 2048;
    }
    if ("_id".equals(paramString)) {
      return 256;
    }
    if ((zzs().zza(zzat.zzbg)) && ("_lgclid".equals(paramString))) {
      return 100;
    }
    return 36;
  }
  
  protected final void g_()
  {
    zzc();
    SecureRandom localSecureRandom = new SecureRandom();
    long l2 = localSecureRandom.nextLong();
    long l1 = l2;
    if (l2 == 0L)
    {
      l2 = localSecureRandom.nextLong();
      l1 = l2;
      if (l2 == 0L)
      {
        zzq().zzh().zza("Utils falling back to Random for random id");
        l1 = l2;
      }
    }
    this.zzd.set(l1);
  }
  
  public final int zza(int paramInt)
  {
    return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzm(), 12451000);
  }
  
  final int zza(String paramString, boolean paramBoolean)
  {
    if (!zzb("event", paramString)) {
      return 2;
    }
    if (paramBoolean)
    {
      if (!zza("event", zzgs.zza, zzgs.zzb, paramString)) {
        return 13;
      }
    }
    else if (!zza("event", zzgs.zza, paramString)) {
      return 13;
    }
    if (!zza("event", 40, paramString)) {
      return 2;
    }
    return 0;
  }
  
  final long zza(Context paramContext, String paramString)
  {
    zzc();
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotEmpty(paramString);
    PackageManager localPackageManager = paramContext.getPackageManager();
    MessageDigest localMessageDigest = zzh();
    if (localMessageDigest == null)
    {
      zzq().zze().zza("Could not get MD5 instance");
      return -1L;
    }
    if (localPackageManager != null) {
      try
      {
        if (!zzc(paramContext, paramString))
        {
          paramContext = Wrappers.packageManager(paramContext).getPackageInfo(zzm().getPackageName(), 64);
          if ((paramContext.signatures != null) && (paramContext.signatures.length > 0)) {
            return zza(localMessageDigest.digest(paramContext.signatures[0].toByteArray()));
          }
          zzq().zzh().zza("Could not get signatures");
          return -1L;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        zzq().zze().zza("Package name not found", paramContext);
      }
    }
    return 0L;
  }
  
  final Bundle zza(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    try
    {
      boolean bool = paramUri.isHierarchical();
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (bool)
      {
        localObject1 = paramUri.getQueryParameter("utm_campaign");
        localObject2 = paramUri.getQueryParameter("utm_source");
        localObject3 = paramUri.getQueryParameter("utm_medium");
        localObject4 = paramUri.getQueryParameter("gclid");
      }
      else
      {
        localBundle = null;
        localObject1 = localBundle;
        localObject2 = localObject1;
        localObject4 = localObject2;
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localBundle;
      }
      if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2)) && (TextUtils.isEmpty((CharSequence)localObject3)) && (TextUtils.isEmpty((CharSequence)localObject4))) {
        return null;
      }
      Bundle localBundle = new Bundle();
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localBundle.putString("campaign", (String)localObject1);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localBundle.putString("source", (String)localObject2);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localBundle.putString("medium", (String)localObject3);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        localBundle.putString("gclid", (String)localObject4);
      }
      Object localObject1 = paramUri.getQueryParameter("utm_term");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localBundle.putString("term", (String)localObject1);
      }
      localObject1 = paramUri.getQueryParameter("utm_content");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localBundle.putString("content", (String)localObject1);
      }
      localObject1 = paramUri.getQueryParameter("aclid");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localBundle.putString("aclid", (String)localObject1);
      }
      localObject1 = paramUri.getQueryParameter("cp1");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localBundle.putString("cp1", (String)localObject1);
      }
      paramUri = paramUri.getQueryParameter("anid");
      if (!TextUtils.isEmpty(paramUri)) {
        localBundle.putString("anid", paramUri);
      }
      return localBundle;
    }
    catch (UnsupportedOperationException paramUri)
    {
      zzq().zzh().zza("Install referrer url isn't a hierarchical URI", paramUri);
    }
    return null;
  }
  
  final Bundle zza(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = zza(str, paramBundle.get(str));
        if (localObject == null) {
          zzq().zzj().zza("Param value can't be null", zzn().zzb(str));
        } else {
          zza(localBundle, str, localObject);
        }
      }
    }
    return localBundle;
  }
  
  final Bundle zza(String paramString1, String paramString2, Bundle paramBundle, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean2 = zza(paramString2, zzgs.zzd);
    if (paramBundle != null)
    {
      Bundle localBundle = new Bundle(paramBundle);
      int i = zzs().zzd();
      Object localObject1;
      if (zzs().zze(paramString1, zzat.zzay)) {
        localObject1 = new TreeSet(paramBundle.keySet());
      } else {
        localObject1 = paramBundle.keySet();
      }
      Iterator localIterator = ((Set)localObject1).iterator();
      int j = 0;
      Object localObject2 = this;
      if (localIterator.hasNext())
      {
        localObject1 = (String)localIterator.next();
        int m;
        int k;
        if ((paramList != null) && (paramList.contains(localObject1)))
        {
          m = 0;
        }
        else
        {
          if (paramBoolean1) {
            k = ((zzkw)localObject2).zzg((String)localObject1);
          } else {
            k = 0;
          }
          m = k;
          if (k == 0) {
            m = ((zzkw)localObject2).zzh((String)localObject1);
          }
        }
        if (m != 0)
        {
          if (m == 3) {
            localObject2 = localObject1;
          } else {
            localObject2 = null;
          }
          zza(localBundle, m, (String)localObject1, (String)localObject1, localObject2);
          localBundle.remove((String)localObject1);
          k = j;
        }
        else
        {
          localObject2 = paramBundle.get((String)localObject1);
          m = i;
          k = zza(paramString1, paramString2, (String)localObject1, localObject2, localBundle, paramList, paramBoolean1, paramBoolean2);
          if (k == 17)
          {
            zza(localBundle, k, (String)localObject1, (String)localObject1, Boolean.valueOf(false));
            break label342;
          }
          if ((k == 0) || ("_ev".equals(localObject1))) {
            break label342;
          }
          if (k == 21) {
            localObject2 = paramString2;
          } else {
            localObject2 = localObject1;
          }
          zza(localBundle, k, (String)localObject2, (String)localObject1, paramBundle.get((String)localObject1));
          localBundle.remove((String)localObject1);
          k = j;
        }
        for (;;)
        {
          label335:
          j = k;
          for (;;)
          {
            break;
            label342:
            k = j;
            if (!zza((String)localObject1)) {
              break label335;
            }
            j += 1;
            if (j <= m) {
              break label456;
            }
            localObject2 = new StringBuilder(48);
            ((StringBuilder)localObject2).append("Event can't contain more than ");
            ((StringBuilder)localObject2).append(m);
            ((StringBuilder)localObject2).append(" params");
            localObject2 = ((StringBuilder)localObject2).toString();
            zzq().zzg().zza((String)localObject2, zzn().zza(paramString2), zzn().zza(paramBundle));
            zzb(localBundle, 5);
            localBundle.remove((String)localObject1);
          }
          label456:
          k = j;
        }
      }
      return localBundle;
    }
    return null;
  }
  
  final zzar zza(String paramString1, String paramString2, Bundle paramBundle, String paramString3, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    if (zza(paramString2, paramBoolean3) == 0)
    {
      if (paramBundle != null) {
        paramBundle = new Bundle(paramBundle);
      } else {
        paramBundle = new Bundle();
      }
      paramBundle.putString("_o", paramString3);
      paramBundle = zza(paramString1, paramString2, paramBundle, CollectionUtils.listOf("_o"), false, false);
      paramString1 = paramBundle;
      if (paramBoolean1) {
        paramString1 = zza(paramBundle);
      }
      return new zzar(paramString2, new zzam(paramString1), paramString3, paramLong);
    }
    zzq().zze().zza("Invalid conditional property event name", zzn().zzc(paramString2));
    throw new IllegalArgumentException();
  }
  
  final Object zza(String paramString, Object paramObject)
  {
    boolean bool = "_ev".equals(paramString);
    int i = 256;
    if (bool) {
      return zza(256, paramObject, true, true);
    }
    if (!zzd(paramString)) {
      i = 100;
    }
    return zza(i, paramObject, false, true);
  }
  
  public final URL zza(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    try
    {
      Preconditions.checkNotEmpty(paramString2);
      Preconditions.checkNotEmpty(paramString1);
      String str = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[] { String.format("v%s.%s", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(zzi()) }), paramString2, paramString1, Long.valueOf(paramLong2) });
      paramString2 = str;
      if (paramString1.equals(zzs().zzv())) {
        paramString2 = str.concat("&ddl_test=1");
      }
      paramString1 = new URL(paramString2);
      return paramString1;
    }
    catch (IllegalArgumentException paramString1) {}catch (MalformedURLException paramString1) {}
    zzq().zze().zza("Failed to create BOW URL for Deferred Deep Link. exception", paramString1.getMessage());
    return null;
  }
  
  final void zza(Bundle paramBundle, long paramLong)
  {
    long l = paramBundle.getLong("_et");
    if (l != 0L) {
      zzq().zzh().zza("Params already contained engagement", Long.valueOf(l));
    }
    paramBundle.putLong("_et", paramLong + l);
  }
  
  final void zza(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle2 == null) {
      return;
    }
    Iterator localIterator = paramBundle2.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramBundle1.containsKey(str)) {
        zzo().zza(paramBundle1, str, paramBundle2.get(str));
      }
    }
  }
  
  final void zza(Bundle paramBundle, String paramString, Object paramObject)
  {
    if (paramBundle == null) {
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramBundle.putString(paramString, String.valueOf(paramObject));
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Bundle[]))
    {
      paramBundle.putParcelableArray(paramString, (Bundle[])paramObject);
      return;
    }
    if (paramString != null)
    {
      if (paramObject != null) {
        paramBundle = paramObject.getClass().getSimpleName();
      } else {
        paramBundle = null;
      }
      zzq().zzj().zza("Not putting event parameter. Invalid value type. name, type", zzn().zzb(paramString), paramBundle);
    }
  }
  
  public final void zza(com.google.android.gms.internal.measurement.zzw paramzzw, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("r", paramInt);
    try
    {
      paramzzw.zza(localBundle);
      return;
    }
    catch (RemoteException paramzzw)
    {
      this.zzy.zzq().zzh().zza("Error returning int value to wrapper", paramzzw);
    }
  }
  
  public final void zza(com.google.android.gms.internal.measurement.zzw paramzzw, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("r", paramLong);
    try
    {
      paramzzw.zza(localBundle);
      return;
    }
    catch (RemoteException paramzzw)
    {
      this.zzy.zzq().zzh().zza("Error returning long value to wrapper", paramzzw);
    }
  }
  
  public final void zza(com.google.android.gms.internal.measurement.zzw paramzzw, Bundle paramBundle)
  {
    try
    {
      paramzzw.zza(paramBundle);
      return;
    }
    catch (RemoteException paramzzw)
    {
      this.zzy.zzq().zzh().zza("Error returning bundle value to wrapper", paramzzw);
    }
  }
  
  public final void zza(com.google.android.gms.internal.measurement.zzw paramzzw, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("r", paramString);
    try
    {
      paramzzw.zza(localBundle);
      return;
    }
    catch (RemoteException paramzzw)
    {
      this.zzy.zzq().zzh().zza("Error returning string value to wrapper", paramzzw);
    }
  }
  
  public final void zza(com.google.android.gms.internal.measurement.zzw paramzzw, ArrayList<Bundle> paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("r", paramArrayList);
    try
    {
      paramzzw.zza(localBundle);
      return;
    }
    catch (RemoteException paramzzw)
    {
      this.zzy.zzq().zzh().zza("Error returning bundle list to wrapper", paramzzw);
    }
  }
  
  public final void zza(com.google.android.gms.internal.measurement.zzw paramzzw, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("r", paramBoolean);
    try
    {
      paramzzw.zza(localBundle);
      return;
    }
    catch (RemoteException paramzzw)
    {
      this.zzy.zzq().zzh().zza("Error returning boolean value to wrapper", paramzzw);
    }
  }
  
  public final void zza(com.google.android.gms.internal.measurement.zzw paramzzw, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("r", paramArrayOfByte);
    try
    {
      paramzzw.zza(localBundle);
      return;
    }
    catch (RemoteException paramzzw)
    {
      this.zzy.zzq().zzh().zza("Error returning byte array to wrapper", paramzzw);
    }
  }
  
  final void zza(zzev paramzzev, int paramInt)
  {
    Iterator localIterator = new TreeSet(paramzzev.zzb.keySet()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (zza(str))
      {
        int j = i + 1;
        i = j;
        if (j > paramInt)
        {
          Object localObject = new StringBuilder(48);
          ((StringBuilder)localObject).append("Event can't contain more than ");
          ((StringBuilder)localObject).append(paramInt);
          ((StringBuilder)localObject).append(" params");
          localObject = ((StringBuilder)localObject).toString();
          zzq().zzg().zza((String)localObject, zzn().zza(paramzzev.zza), zzn().zza(paramzzev.zzb));
          zzb(paramzzev.zzb, 5);
          paramzzev.zzb.remove(str);
          i = j;
        }
      }
    }
  }
  
  public final void zza(zzkv paramzzkv, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    zza(paramzzkv, null, paramInt1, paramString1, paramString2, paramInt2);
  }
  
  final void zza(zzkv paramzzkv, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    zzb(localBundle, paramInt1);
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3))) {
      localBundle.putString(paramString2, paramString3);
    }
    if ((paramInt1 == 6) || (paramInt1 == 7) || (paramInt1 == 2)) {
      localBundle.putLong("_el", paramInt2);
    }
    if ((zzlx.zzb()) && (zzs().zza(zzat.zzcn)))
    {
      paramzzkv.zza(paramString1, localBundle);
      return;
    }
    this.zzy.zzg().zza("auto", "_err", localBundle);
  }
  
  final boolean zza(String paramString, double paramDouble)
  {
    try
    {
      SharedPreferences.Editor localEditor = zzm().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
      localEditor.putString("deeplink", paramString);
      localEditor.putLong("timestamp", Double.doubleToRawLongBits(paramDouble));
      boolean bool = localEditor.commit();
      return bool;
    }
    catch (Exception paramString)
    {
      zzq().zze().zza("Failed to persist Deferred Deep Link. exception", paramString);
    }
    return false;
  }
  
  final boolean zza(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null)
    {
      zzq().zzg().zza("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.codePointCount(0, paramString2.length()) > paramInt)
    {
      zzq().zzg().zza("Name is too long. Type, maximum supported length, name", paramString1, Integer.valueOf(paramInt), paramString2);
      return false;
    }
    return true;
  }
  
  final boolean zza(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      zzq().zzg().zza("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.length() == 0)
    {
      zzq().zzg().zza("Name is required and can't be empty. Type", paramString1);
      return false;
    }
    int i = paramString2.codePointAt(0);
    if (!Character.isLetter(i))
    {
      zzq().zzg().zza("Name must start with a letter. Type, name", paramString1, paramString2);
      return false;
    }
    int j = paramString2.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString2.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k)))
      {
        zzq().zzg().zza("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      }
      i += Character.charCount(k);
    }
    return true;
  }
  
  final boolean zza(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return true;
    }
    if ((!(paramObject instanceof Long)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Byte)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Boolean)))
    {
      if ((paramObject instanceof Double)) {
        return true;
      }
      if ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence))) {
        return false;
      }
      paramObject = String.valueOf(paramObject);
      if (((String)paramObject).codePointCount(0, ((String)paramObject).length()) > paramInt)
      {
        zzq().zzj().zza("Value is too long; discarded. Value kind, name, value length", paramString1, paramString2, Integer.valueOf(((String)paramObject).length()));
        return false;
      }
    }
    return true;
  }
  
  final boolean zza(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!zzi(paramString1))
      {
        if (this.zzy.zzk()) {
          zzq().zzg().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzer.zza(paramString1));
        }
        return false;
      }
    }
    else if ((!zznt.zzb()) || (!zzs().zza(zzat.zzbi)) || (TextUtils.isEmpty(paramString3)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        break label104;
      }
      if (!zzi(paramString2))
      {
        zzq().zzg().zza("Invalid admob_app_id. Analytics disabled.", zzer.zza(paramString2));
        return false;
      }
    }
    return true;
    label104:
    if (this.zzy.zzk()) {
      zzq().zzg().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
    }
    return false;
  }
  
  final boolean zza(String paramString1, String[] paramArrayOfString, String paramString2)
  {
    return zza(paramString1, paramArrayOfString, null, paramString2);
  }
  
  final boolean zza(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString2)
  {
    if (paramString2 == null)
    {
      zzq().zzg().zza("Name is required and can't be null. Type", paramString1);
      return false;
    }
    Preconditions.checkNotNull(paramString2);
    String[] arrayOfString = zza;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString2.startsWith(arrayOfString[i]))
      {
        i = 1;
        break label78;
      }
      i += 1;
    }
    i = 0;
    label78:
    if (i != 0)
    {
      zzq().zzg().zza("Name starts with reserved prefix. Type, name", paramString1, paramString2);
      return false;
    }
    if ((paramArrayOfString1 != null) && (zza(paramString2, paramArrayOfString1)) && ((paramArrayOfString2 == null) || (!zza(paramString2, paramArrayOfString2))))
    {
      zzq().zzg().zza("Name is reserved. Type, name", paramString1, paramString2);
      return false;
    }
    return true;
  }
  
  final int zzb(String paramString)
  {
    if (!zzb("user property", paramString)) {
      return 6;
    }
    if (!zza("user property", zzgu.zza, paramString)) {
      return 15;
    }
    if (!zza("user property", 24, paramString)) {
      return 6;
    }
    return 0;
  }
  
  final int zzb(String paramString, Object paramObject)
  {
    boolean bool;
    if ("_ldl".equals(paramString)) {
      bool = zza("user property referrer", paramString, zzj(paramString), paramObject);
    } else {
      bool = zza("user property", paramString, zzj(paramString), paramObject);
    }
    if (bool) {
      return 0;
    }
    return 7;
  }
  
  final boolean zzb(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      zzq().zzg().zza("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.length() == 0)
    {
      zzq().zzg().zza("Name is required and can't be empty. Type", paramString1);
      return false;
    }
    int i = paramString2.codePointAt(0);
    if ((!Character.isLetter(i)) && (i != 95))
    {
      zzq().zzg().zza("Name must start with a letter or _ (underscore). Type, name", paramString1, paramString2);
      return false;
    }
    int j = paramString2.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString2.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k)))
      {
        zzq().zzg().zza("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      }
      i += Character.charCount(k);
    }
    return true;
  }
  
  final Object zzc(String paramString, Object paramObject)
  {
    if ("_ldl".equals(paramString)) {
      return zza(zzj(paramString), paramObject, true, false);
    }
    return zza(zzj(paramString), paramObject, false, false);
  }
  
  final boolean zzc(String paramString)
  {
    zzc();
    if (Wrappers.packageManager(zzm()).checkCallingOrSelfPermission(paramString) == 0) {
      return true;
    }
    zzq().zzv().zza("Permission not granted", paramString);
    return false;
  }
  
  protected final boolean zzd()
  {
    return true;
  }
  
  final boolean zze(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return zzs().zzu().equals(paramString);
  }
  
  public final long zzf()
  {
    long l1;
    if (this.zzd.get() == 0L) {
      synchronized (this.zzd)
      {
        l1 = new Random(System.nanoTime() ^ zzl().currentTimeMillis()).nextLong();
        int i = this.zze + 1;
        this.zze = i;
        long l2 = i;
        return l1 + l2;
      }
    }
    synchronized (this.zzd)
    {
      this.zzd.compareAndSet(-1L, 1L);
      l1 = this.zzd.getAndIncrement();
      return l1;
    }
  }
  
  final SecureRandom zzg()
  {
    zzc();
    if (this.zzc == null) {
      this.zzc = new SecureRandom();
    }
    return this.zzc;
  }
  
  public final int zzi()
  {
    if (this.zzf == null) {
      this.zzf = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(zzm()) / 1000);
    }
    return this.zzf.intValue();
  }
  
  public final boolean zzj()
  {
    try
    {
      zzm().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzkw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */