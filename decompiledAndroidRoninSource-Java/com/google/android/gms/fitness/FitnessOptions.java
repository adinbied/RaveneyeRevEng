package com.google.android.gms.fitness;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FitnessOptions
  implements GoogleSignInOptionsExtension, Api.ApiOptions.HasGoogleSignInAccountOptions
{
  public static final int ACCESS_READ = 0;
  public static final int ACCESS_WRITE = 1;
  private final SparseArray<List<DataType>> zzk;
  private final Set<Scope> zzl;
  private final GoogleSignInAccount zzm;
  
  private FitnessOptions(SparseArray<List<DataType>> paramSparseArray, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this.zzk = paramSparseArray;
    this.zzm = paramGoogleSignInAccount;
    paramGoogleSignInAccount = new ArrayList();
    int i = 0;
    while (i < paramSparseArray.size())
    {
      int j = paramSparseArray.keyAt(i);
      Iterator localIterator = ((List)paramSparseArray.valueAt(i)).iterator();
      while (localIterator.hasNext())
      {
        DataType localDataType = (DataType)localIterator.next();
        if ((j == 0) && (localDataType.zzk() != null)) {
          paramGoogleSignInAccount.add(new Scope(localDataType.zzk()));
        } else if ((j == 1) && (localDataType.zzl() != null)) {
          paramGoogleSignInAccount.add(new Scope(localDataType.zzl()));
        }
      }
      i += 1;
    }
    this.zzl = zzg.zza(paramGoogleSignInAccount);
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static Builder zza(GoogleSignInAccount paramGoogleSignInAccount)
  {
    if (paramGoogleSignInAccount != null) {
      return Builder.zza(new Builder(null), paramGoogleSignInAccount);
    }
    return new Builder(null);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (FitnessOptions)paramObject;
      if ((Objects.equal(this.zzk, ((FitnessOptions)paramObject).zzk)) && (Objects.equal(this.zzm, ((FitnessOptions)paramObject).zzm))) {
        return true;
      }
    }
    return false;
  }
  
  public int getExtensionType()
  {
    return 3;
  }
  
  public GoogleSignInAccount getGoogleSignInAccount()
  {
    return this.zzm;
  }
  
  public List<Scope> getImpliedScopes()
  {
    return new ArrayList(this.zzl);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzk, this.zzm });
  }
  
  public Bundle toBundle()
  {
    return new Bundle();
  }
  
  public static final class Builder
  {
    private GoogleSignInAccount zzm;
    private final SparseArray<List<DataType>> zzn = new SparseArray();
    
    private final Builder zzb(GoogleSignInAccount paramGoogleSignInAccount)
    {
      this.zzm = paramGoogleSignInAccount;
      return this;
    }
    
    public final Builder addDataType(DataType paramDataType)
    {
      return addDataType(paramDataType, 0);
    }
    
    public final Builder addDataType(DataType paramDataType, int paramInt)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (paramInt != 0) {
        if (paramInt == 1) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      Preconditions.checkArgument(bool1, "valid access types are FitnessOptions.ACCESS_READ or FitnessOptions.ACCESS_WRITE");
      List localList = (List)this.zzn.get(paramInt);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList();
        this.zzn.put(paramInt, localObject);
      }
      ((List)localObject).add(paramDataType);
      return this;
    }
    
    public final FitnessOptions build()
    {
      return new FitnessOptions(this.zzn, this.zzm, null);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\FitnessOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */