package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.fitness.zzcq;
import com.google.android.gms.internal.fitness.zzcr;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new zzbg();
  private final List<DataType> zzah;
  private final zzcq zzgj;
  private final zzae zzik;
  private final int zzil;
  private final BleScanCallback zzim;
  
  StartBleScanRequest(List<DataType> paramList, IBinder paramIBinder1, int paramInt, IBinder paramIBinder2)
  {
    this.zzah = paramList;
    if (paramIBinder1 == null)
    {
      paramList = null;
    }
    else
    {
      paramList = paramIBinder1.queryLocalInterface("com.google.android.gms.fitness.request.IBleScanCallback");
      if ((paramList instanceof zzae)) {
        paramList = (zzae)paramList;
      } else {
        paramList = new zzag(paramIBinder1);
      }
    }
    this.zzik = paramList;
    this.zzil = paramInt;
    this.zzgj = zzcr.zzj(paramIBinder2);
    this.zzim = null;
  }
  
  private StartBleScanRequest(List<DataType> paramList, BleScanCallback paramBleScanCallback, int paramInt)
  {
    this.zzah = paramList;
    this.zzik = null;
    this.zzil = paramInt;
    this.zzgj = null;
    this.zzim = paramBleScanCallback;
  }
  
  public StartBleScanRequest(List<DataType> paramList, zzae paramzzae, int paramInt, zzcq paramzzcq)
  {
    this.zzah = paramList;
    this.zzik = paramzzae;
    this.zzil = paramInt;
    this.zzgj = paramzzcq;
    this.zzim = null;
  }
  
  public List<DataType> getDataTypes()
  {
    return Collections.unmodifiableList(this.zzah);
  }
  
  public int getTimeoutSecs()
  {
    return this.zzil;
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("dataTypes", this.zzah).add("timeoutSecs", Integer.valueOf(this.zzil)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, getDataTypes(), false);
    Object localObject1 = this.zzik;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((zzae)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 2, (IBinder)localObject1, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getTimeoutSecs());
    localObject1 = this.zzgj;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((zzcq)localObject1).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 4, (IBinder)localObject1, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final BleScanCallback zzz()
  {
    return this.zzim;
  }
  
  public static class Builder
  {
    private DataType[] zzhf = new DataType[0];
    private int zzil = 10;
    private BleScanCallback zzin;
    
    public StartBleScanRequest build()
    {
      boolean bool;
      if (this.zzin != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Must set BleScanCallback");
      return new StartBleScanRequest(ArrayUtils.toArrayList(this.zzhf), this.zzin, this.zzil, null);
    }
    
    public Builder setBleScanCallback(BleScanCallback paramBleScanCallback)
    {
      this.zzin = paramBleScanCallback;
      return this;
    }
    
    public Builder setDataTypes(DataType... paramVarArgs)
    {
      this.zzhf = paramVarArgs;
      return this;
    }
    
    public Builder setTimeoutSecs(int paramInt)
    {
      boolean bool2 = true;
      boolean bool1;
      if (paramInt > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Stop time must be greater than zero");
      if (paramInt <= 60) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Preconditions.checkArgument(bool1, "Stop time must be less than 1 minute");
      this.zzil = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\StartBleScanRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */