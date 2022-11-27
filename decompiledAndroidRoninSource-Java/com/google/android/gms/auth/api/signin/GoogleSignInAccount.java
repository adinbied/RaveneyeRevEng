package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();
  private static Clock zae = DefaultClock.getInstance();
  private String mId;
  private final int versionCode;
  private String zaf;
  private String zag;
  private String zah;
  private Uri zai;
  private String zaj;
  private long zak;
  private String zal;
  private List<Scope> zam;
  private String zan;
  private String zao;
  private Set<Scope> zap = new HashSet();
  
  GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List<Scope> paramList, String paramString7, String paramString8)
  {
    this.versionCode = paramInt;
    this.mId = paramString1;
    this.zaf = paramString2;
    this.zag = paramString3;
    this.zah = paramString4;
    this.zai = paramUri;
    this.zaj = paramString5;
    this.zak = paramLong;
    this.zal = paramString6;
    this.zam = paramList;
    this.zan = paramString7;
    this.zao = paramString8;
  }
  
  public static GoogleSignInAccount createDefault()
  {
    Account localAccount = new Account("<<default account>>", "com.google");
    HashSet localHashSet = new HashSet();
    return zaa(null, null, localAccount.name, null, null, null, null, Long.valueOf(0L), localAccount.name, localHashSet);
  }
  
  public static GoogleSignInAccount zaa(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    paramString = localJSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(paramString)) {
      paramString = Uri.parse(paramString);
    } else {
      paramString = null;
    }
    long l = Long.parseLong(localJSONObject.getString("expirationTime"));
    HashSet localHashSet = new HashSet();
    JSONArray localJSONArray = localJSONObject.getJSONArray("grantedScopes");
    int j = localJSONArray.length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new Scope(localJSONArray.getString(i)));
      i += 1;
    }
    paramString = zaa(localJSONObject.optString("id"), localJSONObject.optString("tokenId", null), localJSONObject.optString("email", null), localJSONObject.optString("displayName", null), localJSONObject.optString("givenName", null), localJSONObject.optString("familyName", null), paramString, Long.valueOf(l), localJSONObject.getString("obfuscatedIdentifier"), localHashSet);
    paramString.zaj = localJSONObject.optString("serverAuthCode", null);
    return paramString;
  }
  
  private static GoogleSignInAccount zaa(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri, Long paramLong, String paramString7, Set<Scope> paramSet)
  {
    if (paramLong == null) {
      paramLong = Long.valueOf(zae.currentTimeMillis() / 1000L);
    }
    return new GoogleSignInAccount(3, paramString1, paramString2, paramString3, paramString4, paramUri, null, paramLong.longValue(), Preconditions.checkNotEmpty(paramString7), new ArrayList((Collection)Preconditions.checkNotNull(paramSet)), paramString5, paramString6);
  }
  
  private final JSONObject zad()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (getId() != null) {
        localJSONObject.put("id", getId());
      }
      if (getIdToken() != null) {
        localJSONObject.put("tokenId", getIdToken());
      }
      if (getEmail() != null) {
        localJSONObject.put("email", getEmail());
      }
      if (getDisplayName() != null) {
        localJSONObject.put("displayName", getDisplayName());
      }
      if (getGivenName() != null) {
        localJSONObject.put("givenName", getGivenName());
      }
      if (getFamilyName() != null) {
        localJSONObject.put("familyName", getFamilyName());
      }
      if (getPhotoUrl() != null) {
        localJSONObject.put("photoUrl", getPhotoUrl().toString());
      }
      if (getServerAuthCode() != null) {
        localJSONObject.put("serverAuthCode", getServerAuthCode());
      }
      localJSONObject.put("expirationTime", this.zak);
      localJSONObject.put("obfuscatedIdentifier", this.zal);
      JSONArray localJSONArray = new JSONArray();
      Scope[] arrayOfScope = (Scope[])this.zam.toArray(new Scope[this.zam.size()]);
      Arrays.sort(arrayOfScope, zaa.zaq);
      int j = arrayOfScope.length;
      int i = 0;
      while (i < j)
      {
        localJSONArray.put(arrayOfScope[i].getScopeUri());
        i += 1;
      }
      localJSONObject.put("grantedScopes", localJSONArray);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof GoogleSignInAccount)) {
      return false;
    }
    paramObject = (GoogleSignInAccount)paramObject;
    return (((GoogleSignInAccount)paramObject).zal.equals(this.zal)) && (((GoogleSignInAccount)paramObject).getRequestedScopes().equals(getRequestedScopes()));
  }
  
  public Account getAccount()
  {
    if (this.zag == null) {
      return null;
    }
    return new Account(this.zag, "com.google");
  }
  
  public String getDisplayName()
  {
    return this.zah;
  }
  
  public String getEmail()
  {
    return this.zag;
  }
  
  public String getFamilyName()
  {
    return this.zao;
  }
  
  public String getGivenName()
  {
    return this.zan;
  }
  
  public Set<Scope> getGrantedScopes()
  {
    return new HashSet(this.zam);
  }
  
  public String getId()
  {
    return this.mId;
  }
  
  public String getIdToken()
  {
    return this.zaf;
  }
  
  public Uri getPhotoUrl()
  {
    return this.zai;
  }
  
  public Set<Scope> getRequestedScopes()
  {
    HashSet localHashSet = new HashSet(this.zam);
    localHashSet.addAll(this.zap);
    return localHashSet;
  }
  
  public String getServerAuthCode()
  {
    return this.zaj;
  }
  
  public int hashCode()
  {
    return (this.zal.hashCode() + 527) * 31 + getRequestedScopes().hashCode();
  }
  
  public boolean isExpired()
  {
    return zae.currentTimeMillis() / 1000L >= this.zak - 300L;
  }
  
  public GoogleSignInAccount requestExtraScopes(Scope... paramVarArgs)
  {
    if (paramVarArgs != null) {
      Collections.addAll(this.zap, paramVarArgs);
    }
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, getId(), false);
    SafeParcelWriter.writeString(paramParcel, 3, getIdToken(), false);
    SafeParcelWriter.writeString(paramParcel, 4, getEmail(), false);
    SafeParcelWriter.writeString(paramParcel, 5, getDisplayName(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 6, getPhotoUrl(), paramInt, false);
    SafeParcelWriter.writeString(paramParcel, 7, getServerAuthCode(), false);
    SafeParcelWriter.writeLong(paramParcel, 8, this.zak);
    SafeParcelWriter.writeString(paramParcel, 9, this.zal, false);
    SafeParcelWriter.writeTypedList(paramParcel, 10, this.zam, false);
    SafeParcelWriter.writeString(paramParcel, 11, getGivenName(), false);
    SafeParcelWriter.writeString(paramParcel, 12, getFamilyName(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final String zab()
  {
    return this.zal;
  }
  
  public final String zac()
  {
    JSONObject localJSONObject = zad();
    localJSONObject.remove("serverAuthCode");
    return localJSONObject.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\auth\api\signin\GoogleSignInAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */