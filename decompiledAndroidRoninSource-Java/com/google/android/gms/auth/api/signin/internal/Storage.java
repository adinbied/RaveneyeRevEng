package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import org.json.JSONException;

public class Storage
{
  private static final Lock zaaj = new ReentrantLock();
  private static Storage zaak;
  private final Lock zaal = new ReentrantLock();
  private final SharedPreferences zaam;
  
  private Storage(Context paramContext)
  {
    this.zaam = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  public static Storage getInstance(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    zaaj.lock();
    try
    {
      if (zaak == null) {
        zaak = new Storage(paramContext.getApplicationContext());
      }
      paramContext = zaak;
      return paramContext;
    }
    finally
    {
      zaaj.unlock();
    }
  }
  
  private final void zaa(String paramString1, String paramString2)
  {
    this.zaal.lock();
    try
    {
      this.zaam.edit().putString(paramString1, paramString2).apply();
      return;
    }
    finally
    {
      this.zaal.unlock();
    }
  }
  
  private static String zab(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(":");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  @Nullable
  private final GoogleSignInAccount zad(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = zaf(zab("googleSignInAccount", paramString));
    if (paramString != null) {}
    try
    {
      paramString = GoogleSignInAccount.zaa(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
    return null;
  }
  
  @Nullable
  private final GoogleSignInOptions zae(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = zaf(zab("googleSignInOptions", paramString));
    if (paramString != null) {}
    try
    {
      paramString = GoogleSignInOptions.zab(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
    return null;
  }
  
  @Nullable
  private final String zaf(String paramString)
  {
    this.zaal.lock();
    try
    {
      paramString = this.zaam.getString(paramString, null);
      return paramString;
    }
    finally
    {
      this.zaal.unlock();
    }
  }
  
  private final void zag(String paramString)
  {
    this.zaal.lock();
    try
    {
      this.zaam.edit().remove(paramString).apply();
      return;
    }
    finally
    {
      this.zaal.unlock();
    }
  }
  
  public void clear()
  {
    this.zaal.lock();
    try
    {
      this.zaam.edit().clear().apply();
      return;
    }
    finally
    {
      this.zaal.unlock();
    }
  }
  
  @Nullable
  public GoogleSignInAccount getSavedDefaultGoogleSignInAccount()
  {
    return zad(zaf("defaultGoogleSignInAccount"));
  }
  
  @Nullable
  public GoogleSignInOptions getSavedDefaultGoogleSignInOptions()
  {
    return zae(zaf("defaultGoogleSignInAccount"));
  }
  
  @Nullable
  public String getSavedRefreshToken()
  {
    return zaf("refreshToken");
  }
  
  public void saveDefaultGoogleSignInAccount(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    zaa("defaultGoogleSignInAccount", paramGoogleSignInAccount.zab());
    Preconditions.checkNotNull(paramGoogleSignInAccount);
    Preconditions.checkNotNull(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.zab();
    zaa(zab("googleSignInAccount", str), paramGoogleSignInAccount.zac());
    zaa(zab("googleSignInOptions", str), paramGoogleSignInOptions.zae());
  }
  
  public final void zaf()
  {
    String str = zaf("defaultGoogleSignInAccount");
    zag("defaultGoogleSignInAccount");
    if (!TextUtils.isEmpty(str))
    {
      zag(zab("googleSignInAccount", str));
      zag(zab("googleSignInOptions", str));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\auth\api\signin\internal\Storage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */