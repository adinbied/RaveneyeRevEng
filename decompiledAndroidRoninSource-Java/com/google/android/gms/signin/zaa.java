package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.internal.SignInClientImpl;

public final class zaa
{
  public static final Api<SignInOptions> API = new Api("SignIn.API", zaph, CLIENT_KEY);
  private static final Api.ClientKey<SignInClientImpl> CLIENT_KEY = new Api.ClientKey();
  public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zaph;
  private static final Scope zar;
  private static final Api.ClientKey<SignInClientImpl> zars = new Api.ClientKey();
  private static final Api.AbstractClientBuilder<SignInClientImpl, Object> zart;
  private static final Api<Object> zaru = new Api("SignIn.INTERNAL_API", zart, zars);
  private static final Scope zas;
  
  static
  {
    zaph = new zab();
    zart = new zac();
    zar = new Scope("profile");
    zas = new Scope("email");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\signin\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */