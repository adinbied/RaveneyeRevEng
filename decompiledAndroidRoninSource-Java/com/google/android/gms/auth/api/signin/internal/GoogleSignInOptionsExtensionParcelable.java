package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class GoogleSignInOptionsExtensionParcelable
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new zaa();
  private Bundle mBundle;
  private int mType;
  private final int versionCode;
  
  GoogleSignInOptionsExtensionParcelable(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.versionCode = paramInt1;
    this.mType = paramInt2;
    this.mBundle = paramBundle;
  }
  
  public GoogleSignInOptionsExtensionParcelable(GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
  {
    this(1, paramGoogleSignInOptionsExtension.getExtensionType(), paramGoogleSignInOptionsExtension.toBundle());
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeInt(paramParcel, 2, getType());
    SafeParcelWriter.writeBundle(paramParcel, 3, this.mBundle, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\auth\api\signin\internal\GoogleSignInOptionsExtensionParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */