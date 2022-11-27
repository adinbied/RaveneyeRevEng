package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.fitness.zzbn;
import com.google.android.gms.internal.fitness.zzbo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new zzr();
  private final String name;
  private final List<Field> zzbs;
  private final zzbn zzhh;
  
  private DataTypeCreateRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), null);
  }
  
  public DataTypeCreateRequest(DataTypeCreateRequest paramDataTypeCreateRequest, zzbn paramzzbn)
  {
    this(paramDataTypeCreateRequest.name, paramDataTypeCreateRequest.zzbs, paramzzbn);
  }
  
  DataTypeCreateRequest(String paramString, List<Field> paramList, IBinder paramIBinder)
  {
    this.name = paramString;
    this.zzbs = Collections.unmodifiableList(paramList);
    this.zzhh = zzbo.zze(paramIBinder);
  }
  
  private DataTypeCreateRequest(String paramString, List<Field> paramList, zzbn paramzzbn)
  {
    this.name = paramString;
    this.zzbs = Collections.unmodifiableList(paramList);
    this.zzhh = paramzzbn;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != this)
    {
      if ((paramObject instanceof DataTypeCreateRequest))
      {
        paramObject = (DataTypeCreateRequest)paramObject;
        int i;
        if ((Objects.equal(this.name, ((DataTypeCreateRequest)paramObject).name)) && (Objects.equal(this.zzbs, ((DataTypeCreateRequest)paramObject).zzbs))) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public List<Field> getFields()
  {
    return this.zzbs;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.name, this.zzbs });
  }
  
  public String toString()
  {
    return Objects.toStringHelper(this).add("name", this.name).add("fields", this.zzbs).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getFields(), false);
    Object localObject = this.zzhh;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((zzbn)localObject).asBinder();
    }
    SafeParcelWriter.writeIBinder(paramParcel, 3, (IBinder)localObject, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private String name;
    private List<Field> zzbs = new ArrayList();
    
    public Builder addField(Field paramField)
    {
      if (!this.zzbs.contains(paramField)) {
        this.zzbs.add(paramField);
      }
      return this;
    }
    
    public Builder addField(String paramString, int paramInt)
    {
      boolean bool;
      if ((paramString != null) && (!paramString.isEmpty())) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "Invalid name specified");
      return addField(Field.zza(paramString, paramInt));
    }
    
    public DataTypeCreateRequest build()
    {
      boolean bool;
      if (this.name != null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Must set the name");
      Preconditions.checkState(this.zzbs.isEmpty() ^ true, "Must specify the data fields");
      return new DataTypeCreateRequest(this, null);
    }
    
    public Builder setName(String paramString)
    {
      this.name = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\DataTypeCreateRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */