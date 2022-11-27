package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

public class AuthAccountRequest
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zaa();
  private final int zalf;
  @Deprecated
  private final IBinder zanx;
  private final Scope[] zany;
  private Integer zanz;
  private Integer zaoa;
  private Account zax;
  
  AuthAccountRequest(int paramInt, IBinder paramIBinder, Scope[] paramArrayOfScope, Integer paramInteger1, Integer paramInteger2, Account paramAccount)
  {
    this.zalf = paramInt;
    this.zanx = paramIBinder;
    this.zany = paramArrayOfScope;
    this.zanz = paramInteger1;
    this.zaoa = paramInteger2;
    this.zax = paramAccount;
  }
  
  public AuthAccountRequest(Account paramAccount, Set<Scope> paramSet)
  {
    this(3, null, (Scope[])paramSet.toArray(new Scope[paramSet.size()]), null, null, (Account)Preconditions.checkNotNull(paramAccount));
  }
  
  @Deprecated
  public AuthAccountRequest(IAccountAccessor paramIAccountAccessor, Set<Scope> paramSet)
  {
    this(3, paramIAccountAccessor.asBinder(), (Scope[])paramSet.toArray(new Scope[paramSet.size()]), null, null, null);
  }
  
  public Account getAccount()
  {
    Object localObject = this.zax;
    if (localObject != null) {
      return (Account)localObject;
    }
    localObject = this.zanx;
    if (localObject != null) {
      return AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface((IBinder)localObject));
    }
    return null;
  }
  
  @Nullable
  public Integer getOauthPolicy()
  {
    return this.zanz;
  }
  
  @Nullable
  public Integer getPolicyAction()
  {
    return this.zaoa;
  }
  
  public Set<Scope> getScopes()
  {
    return new HashSet(Arrays.asList(this.zany));
  }
  
  public AuthAccountRequest setOauthPolicy(@Nullable Integer paramInteger)
  {
    this.zanz = paramInteger;
    return this;
  }
  
  public AuthAccountRequest setPolicyAction(@Nullable Integer paramInteger)
  {
    this.zaoa = paramInteger;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeIBinder(paramParcel, 2, this.zanx, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 3, this.zany, paramInt, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 4, this.zanz, false);
    SafeParcelWriter.writeIntegerObject(paramParcel, 5, this.zaoa, false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, this.zax, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\AuthAccountRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */