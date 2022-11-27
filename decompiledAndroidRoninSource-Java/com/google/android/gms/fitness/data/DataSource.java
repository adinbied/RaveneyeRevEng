package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

public class DataSource
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DataSource> CREATOR = new zzk();
  public static final int DATA_QUALITY_BLOOD_GLUCOSE_ISO151972003 = 8;
  public static final int DATA_QUALITY_BLOOD_GLUCOSE_ISO151972013 = 9;
  public static final int DATA_QUALITY_BLOOD_PRESSURE_AAMI = 3;
  public static final int DATA_QUALITY_BLOOD_PRESSURE_BHS_A_A = 4;
  public static final int DATA_QUALITY_BLOOD_PRESSURE_BHS_A_B = 5;
  public static final int DATA_QUALITY_BLOOD_PRESSURE_BHS_B_A = 6;
  public static final int DATA_QUALITY_BLOOD_PRESSURE_BHS_B_B = 7;
  public static final int DATA_QUALITY_BLOOD_PRESSURE_ESH2002 = 1;
  public static final int DATA_QUALITY_BLOOD_PRESSURE_ESH2010 = 2;
  public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
  public static final int TYPE_DERIVED = 1;
  public static final int TYPE_RAW = 0;
  private static final int[] zzaw = new int[0];
  private final String name;
  private final int type;
  private final Device zzax;
  private final zzb zzay;
  private final String zzaz;
  private final int[] zzba;
  private final String zzbb;
  private final DataType zzq;
  
  private DataSource(Builder paramBuilder)
  {
    this.zzq = Builder.zza(paramBuilder);
    this.type = Builder.zzb(paramBuilder);
    this.name = Builder.zzc(paramBuilder);
    this.zzax = Builder.zzd(paramBuilder);
    this.zzay = Builder.zze(paramBuilder);
    this.zzaz = Builder.zzf(paramBuilder);
    this.zzbb = zzj();
    this.zzba = Builder.zzg(paramBuilder);
  }
  
  public DataSource(DataType paramDataType, String paramString1, int paramInt, Device paramDevice, zzb paramzzb, String paramString2, int[] paramArrayOfInt)
  {
    this.zzq = paramDataType;
    this.type = paramInt;
    this.name = paramString1;
    this.zzax = paramDevice;
    this.zzay = paramzzb;
    this.zzaz = paramString2;
    this.zzbb = zzj();
    if (paramArrayOfInt == null) {
      paramArrayOfInt = zzaw;
    }
    this.zzba = paramArrayOfInt;
  }
  
  public static DataSource extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (DataSource)SafeParcelableSerializer.deserializeFromIntentExtra(paramIntent, "vnd.google.fitness.data_source", CREATOR);
  }
  
  private final String getTypeString()
  {
    int i = this.type;
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 3) {
          return "derived";
        }
        return "converted";
      }
      return "cleaned";
    }
    return "raw";
  }
  
  public static String zzd(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 9: 
      return "blood_glucose_iso151972013";
    case 8: 
      return "blood_glucose_iso151972003";
    case 7: 
      return "blood_pressure_bhs_b_b";
    case 6: 
      return "blood_pressure_bhs_b_a";
    case 5: 
      return "blood_pressure_bhs_a_b";
    case 4: 
      return "blood_pressure_bhs_a_a";
    case 3: 
      return "blood_pressure_aami";
    case 2: 
      return "blood_pressure_esh2010";
    }
    return "blood_pressure_esh2002";
  }
  
  private final String zzj()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getTypeString());
    localStringBuilder.append(":");
    localStringBuilder.append(this.zzq.getName());
    if (this.zzay != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(this.zzay.getPackageName());
    }
    if (this.zzax != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(this.zzax.getStreamIdentifier());
    }
    if (this.zzaz != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(this.zzaz);
    }
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DataSource)) {
      return false;
    }
    paramObject = (DataSource)paramObject;
    return this.zzbb.equals(((DataSource)paramObject).zzbb);
  }
  
  public String getAppPackageName()
  {
    zzb localzzb = this.zzay;
    if (localzzb == null) {
      return null;
    }
    return localzzb.getPackageName();
  }
  
  public int[] getDataQualityStandards()
  {
    return this.zzba;
  }
  
  public DataType getDataType()
  {
    return this.zzq;
  }
  
  public Device getDevice()
  {
    return this.zzax;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getStreamIdentifier()
  {
    return this.zzbb;
  }
  
  public String getStreamName()
  {
    return this.zzaz;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return this.zzbb.hashCode();
  }
  
  public final String toDebugString()
  {
    int i = this.type;
    String str1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            str1 = "?";
          } else {
            str1 = "v";
          }
        }
        else {
          str1 = "c";
        }
      }
      else {
        str1 = "d";
      }
    }
    else {
      str1 = "r";
    }
    String str3 = this.zzq.zzm();
    Object localObject1 = this.zzay;
    String str2 = "";
    if (localObject1 == null)
    {
      localObject1 = "";
    }
    else if (((zzb)localObject1).equals(zzb.zzad))
    {
      localObject1 = ":gms";
    }
    else
    {
      localObject1 = String.valueOf(this.zzay.getPackageName());
      if (((String)localObject1).length() != 0) {
        localObject1 = ":".concat((String)localObject1);
      } else {
        localObject1 = new String(":");
      }
    }
    Object localObject2 = this.zzax;
    if (localObject2 != null)
    {
      localObject2 = ((Device)localObject2).getModel();
      localObject3 = this.zzax.getUid();
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(localObject2).length() + 2 + String.valueOf(localObject3).length());
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(":");
      localStringBuilder.append((String)localObject3);
      localObject2 = localStringBuilder.toString();
    }
    else
    {
      localObject2 = "";
    }
    Object localObject3 = this.zzaz;
    if (localObject3 != null)
    {
      str2 = String.valueOf(localObject3);
      if (str2.length() != 0) {
        str2 = ":".concat(str2);
      } else {
        str2 = new String(":");
      }
    }
    localObject3 = new StringBuilder(str1.length() + 1 + String.valueOf(str3).length() + String.valueOf(localObject1).length() + String.valueOf(localObject2).length() + String.valueOf(str2).length());
    ((StringBuilder)localObject3).append(str1);
    ((StringBuilder)localObject3).append(":");
    ((StringBuilder)localObject3).append(str3);
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(str2);
    return ((StringBuilder)localObject3).toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DataSource{");
    localStringBuilder.append(getTypeString());
    if (this.name != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(this.name);
    }
    if (this.zzay != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(this.zzay);
    }
    if (this.zzax != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(this.zzax);
    }
    if (this.zzaz != null)
    {
      localStringBuilder.append(":");
      localStringBuilder.append(this.zzaz);
    }
    localStringBuilder.append(":");
    localStringBuilder.append(this.zzq);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getDataType(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 2, getName(), false);
    SafeParcelWriter.writeInt(paramParcel, 3, getType());
    SafeParcelWriter.writeParcelable(paramParcel, 4, getDevice(), paramInt, false);
    SafeParcelWriter.writeParcelable(paramParcel, 5, this.zzay, paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 6, getStreamName(), false);
    SafeParcelWriter.writeIntArray(paramParcel, 8, getDataQualityStandards(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final zzb zzi()
  {
    return this.zzay;
  }
  
  public static final class Builder
  {
    private String name;
    private int type = -1;
    private Device zzax;
    private zzb zzay;
    private String zzaz = "";
    private int[] zzba;
    private DataType zzq;
    
    public final DataSource build()
    {
      DataType localDataType = this.zzq;
      boolean bool2 = true;
      boolean bool1;
      if (localDataType != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Must set data type");
      if (this.type >= 0) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkState(bool1, "Must set data source type");
      return new DataSource(this, null);
    }
    
    public final Builder setAppPackageName(Context paramContext)
    {
      return setAppPackageName(paramContext.getPackageName());
    }
    
    public final Builder setAppPackageName(String paramString)
    {
      this.zzay = zzb.zza(paramString);
      return this;
    }
    
    public final Builder setDataQualityStandards(int... paramVarArgs)
    {
      this.zzba = paramVarArgs;
      return this;
    }
    
    public final Builder setDataType(DataType paramDataType)
    {
      this.zzq = paramDataType;
      return this;
    }
    
    public final Builder setDevice(Device paramDevice)
    {
      this.zzax = paramDevice;
      return this;
    }
    
    public final Builder setName(String paramString)
    {
      this.name = paramString;
      return this;
    }
    
    public final Builder setStreamName(String paramString)
    {
      boolean bool;
      if (paramString != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Must specify a valid stream name");
      this.zzaz = paramString;
      return this;
    }
    
    public final Builder setType(int paramInt)
    {
      this.type = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\DataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */