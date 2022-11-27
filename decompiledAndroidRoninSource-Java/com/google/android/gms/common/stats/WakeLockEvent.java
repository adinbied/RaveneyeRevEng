package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public final class WakeLockEvent
  extends StatsEvent
{
  public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
  private long durationMillis;
  private final int versionCode;
  private final long zzfo;
  private int zzfp;
  private final String zzfq;
  private final String zzfr;
  private final String zzfs;
  private final int zzft;
  private final List<String> zzfu;
  private final String zzfv;
  private final long zzfw;
  private int zzfx;
  private final String zzfy;
  private final float zzfz;
  private final long zzga;
  private final boolean zzgb;
  
  WakeLockEvent(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, List<String> paramList, String paramString2, long paramLong2, int paramInt4, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.zzfo = paramLong1;
    this.zzfp = paramInt2;
    this.zzfq = paramString1;
    this.zzfr = paramString3;
    this.zzfs = paramString5;
    this.zzft = paramInt3;
    this.durationMillis = -1L;
    this.zzfu = paramList;
    this.zzfv = paramString2;
    this.zzfw = paramLong2;
    this.zzfx = paramInt4;
    this.zzfy = paramString4;
    this.zzfz = paramFloat;
    this.zzga = paramLong3;
    this.zzgb = paramBoolean;
  }
  
  public WakeLockEvent(long paramLong1, int paramInt1, String paramString1, int paramInt2, List<String> paramList, String paramString2, long paramLong2, int paramInt3, String paramString3, String paramString4, float paramFloat, long paramLong3, String paramString5, boolean paramBoolean)
  {
    this(2, paramLong1, paramInt1, paramString1, paramInt2, paramList, paramString2, paramLong2, paramInt3, paramString3, paramString4, paramFloat, paramLong3, paramString5, paramBoolean);
  }
  
  public final int getEventType()
  {
    return this.zzfp;
  }
  
  public final long getTimeMillis()
  {
    return this.zzfo;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeLong(paramParcel, 2, getTimeMillis());
    SafeParcelWriter.writeString(paramParcel, 4, this.zzfq, false);
    SafeParcelWriter.writeInt(paramParcel, 5, this.zzft);
    SafeParcelWriter.writeStringList(paramParcel, 6, this.zzfu, false);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zzfw);
    SafeParcelWriter.writeString(paramParcel, 10, this.zzfr, false);
    SafeParcelWriter.writeInt(paramParcel, 11, getEventType());
    SafeParcelWriter.writeString(paramParcel, 12, this.zzfv, false);
    SafeParcelWriter.writeString(paramParcel, 13, this.zzfy, false);
    SafeParcelWriter.writeInt(paramParcel, 14, this.zzfx);
    SafeParcelWriter.writeFloat(paramParcel, 15, this.zzfz);
    SafeParcelWriter.writeLong(paramParcel, 16, this.zzga);
    SafeParcelWriter.writeString(paramParcel, 17, this.zzfs, false);
    SafeParcelWriter.writeBoolean(paramParcel, 18, this.zzgb);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final long zzu()
  {
    return this.durationMillis;
  }
  
  public final String zzv()
  {
    String str = this.zzfq;
    int i = this.zzft;
    Object localObject1 = this.zzfu;
    Object localObject4 = "";
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = TextUtils.join(",", (Iterable)localObject1);
    }
    int j = this.zzfx;
    Object localObject3 = this.zzfr;
    Object localObject2 = localObject3;
    if (localObject3 == null) {
      localObject2 = "";
    }
    Object localObject5 = this.zzfy;
    localObject3 = localObject5;
    if (localObject5 == null) {
      localObject3 = "";
    }
    float f = this.zzfz;
    localObject5 = this.zzfs;
    if (localObject5 != null) {
      localObject4 = localObject5;
    }
    boolean bool = this.zzgb;
    localObject5 = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(localObject1).length() + String.valueOf(localObject2).length() + String.valueOf(localObject3).length() + String.valueOf(localObject4).length());
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(str);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(i);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject1);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(j);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject2);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject3);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(f);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append((String)localObject4);
    ((StringBuilder)localObject5).append("\t");
    ((StringBuilder)localObject5).append(bool);
    return ((StringBuilder)localObject5).toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\stats\WakeLockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */