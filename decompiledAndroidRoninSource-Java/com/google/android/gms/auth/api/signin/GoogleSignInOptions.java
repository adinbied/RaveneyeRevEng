package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions
  extends AbstractSafeParcelable
  implements Api.ApiOptions.Optional, ReflectedParcelable
{
  public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zad();
  public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  private static Comparator<Scope> zaaf = new zac();
  public static final Scope zar = new Scope("profile");
  public static final Scope zas = new Scope("email");
  public static final Scope zat = new Scope("openid");
  public static final Scope zau = new Scope("https://www.googleapis.com/auth/games_lite");
  public static final Scope zav = new Scope("https://www.googleapis.com/auth/games");
  private final int versionCode;
  private final boolean zaaa;
  private String zaab;
  private String zaac;
  private ArrayList<GoogleSignInOptionsExtensionParcelable> zaad;
  private Map<Integer, GoogleSignInOptionsExtensionParcelable> zaae;
  private final ArrayList<Scope> zaw;
  private Account zax;
  private boolean zay;
  private final boolean zaz;
  
  static
  {
    DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(zau, new Scope[0]).build();
  }
  
  GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, ArrayList<GoogleSignInOptionsExtensionParcelable> paramArrayList1)
  {
    this(paramInt, paramArrayList, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2, zaa(paramArrayList1));
  }
  
  private GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, Map<Integer, GoogleSignInOptionsExtensionParcelable> paramMap)
  {
    this.versionCode = paramInt;
    this.zaw = paramArrayList;
    this.zax = paramAccount;
    this.zay = paramBoolean1;
    this.zaz = paramBoolean2;
    this.zaaa = paramBoolean3;
    this.zaab = paramString1;
    this.zaac = paramString2;
    this.zaad = new ArrayList(paramMap.values());
    this.zaae = paramMap;
  }
  
  private static Map<Integer, GoogleSignInOptionsExtensionParcelable> zaa(List<GoogleSignInOptionsExtensionParcelable> paramList)
  {
    HashMap localHashMap = new HashMap();
    if (paramList == null) {
      return localHashMap;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GoogleSignInOptionsExtensionParcelable localGoogleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable)paramList.next();
      localHashMap.put(Integer.valueOf(localGoogleSignInOptionsExtensionParcelable.getType()), localGoogleSignInOptionsExtensionParcelable);
    }
    return localHashMap;
  }
  
  public static GoogleSignInOptions zab(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    HashSet localHashSet = new HashSet();
    paramString = localJSONObject.getJSONArray("scopes");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new Scope(paramString.getString(i)));
      i += 1;
    }
    paramString = localJSONObject.optString("accountName", null);
    if (!TextUtils.isEmpty(paramString)) {
      paramString = new Account(paramString, "com.google");
    } else {
      paramString = null;
    }
    return new GoogleSignInOptions(3, new ArrayList(localHashSet), paramString, localJSONObject.getBoolean("idTokenRequested"), localJSONObject.getBoolean("serverAuthRequested"), localJSONObject.getBoolean("forceCodeForRefreshToken"), localJSONObject.optString("serverClientId", null), localJSONObject.optString("hostedDomain", null), new HashMap());
  }
  
  private final JSONObject zad()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Collections.sort(this.zaw, zaaf);
      ArrayList localArrayList = (ArrayList)this.zaw;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = localArrayList.get(i);
        i += 1;
        localJSONArray.put(((Scope)localObject).getScopeUri());
      }
      localJSONObject.put("scopes", localJSONArray);
      if (this.zax != null) {
        localJSONObject.put("accountName", this.zax.name);
      }
      localJSONObject.put("idTokenRequested", this.zay);
      localJSONObject.put("forceCodeForRefreshToken", this.zaaa);
      localJSONObject.put("serverAuthRequested", this.zaz);
      if (!TextUtils.isEmpty(this.zaab)) {
        localJSONObject.put("serverClientId", this.zaab);
      }
      if (!TextUtils.isEmpty(this.zaac)) {
        localJSONObject.put("hostedDomain", this.zaac);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      paramObject = (GoogleSignInOptions)paramObject;
      if (this.zaad.size() <= 0)
      {
        if (((GoogleSignInOptions)paramObject).zaad.size() > 0) {
          return false;
        }
        if (this.zaw.size() == ((GoogleSignInOptions)paramObject).getScopes().size())
        {
          if (!this.zaw.containsAll(((GoogleSignInOptions)paramObject).getScopes())) {
            return false;
          }
          if ((this.zax == null ? ((GoogleSignInOptions)paramObject).getAccount() == null : this.zax.equals(((GoogleSignInOptions)paramObject).getAccount())) && (TextUtils.isEmpty(this.zaab) ? TextUtils.isEmpty(((GoogleSignInOptions)paramObject).getServerClientId()) : this.zaab.equals(((GoogleSignInOptions)paramObject).getServerClientId())) && (this.zaaa == ((GoogleSignInOptions)paramObject).isForceCodeForRefreshToken()) && (this.zay == ((GoogleSignInOptions)paramObject).isIdTokenRequested()))
          {
            boolean bool1 = this.zaz;
            boolean bool2 = ((GoogleSignInOptions)paramObject).isServerAuthCodeRequested();
            if (bool1 == bool2) {
              return true;
            }
          }
        }
      }
      return false;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public Account getAccount()
  {
    return this.zax;
  }
  
  public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions()
  {
    return this.zaad;
  }
  
  public Scope[] getScopeArray()
  {
    ArrayList localArrayList = this.zaw;
    return (Scope[])localArrayList.toArray(new Scope[localArrayList.size()]);
  }
  
  public ArrayList<Scope> getScopes()
  {
    return new ArrayList(this.zaw);
  }
  
  public String getServerClientId()
  {
    return this.zaab;
  }
  
  public int hashCode()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = (ArrayList)this.zaw;
    int j = localArrayList2.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = localArrayList2.get(i);
      i += 1;
      localArrayList1.add(((Scope)localObject).getScopeUri());
    }
    Collections.sort(localArrayList1);
    return new HashAccumulator().addObject(localArrayList1).addObject(this.zax).addObject(this.zaab).zaa(this.zaaa).zaa(this.zay).zaa(this.zaz).hash();
  }
  
  public boolean isForceCodeForRefreshToken()
  {
    return this.zaaa;
  }
  
  public boolean isIdTokenRequested()
  {
    return this.zay;
  }
  
  public boolean isServerAuthCodeRequested()
  {
    return this.zaz;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getScopes(), false);
    SafeParcelWriter.writeParcelable(paramParcel, 3, getAccount(), paramInt, false);
    SafeParcelWriter.writeBoolean(paramParcel, 4, isIdTokenRequested());
    SafeParcelWriter.writeBoolean(paramParcel, 5, isServerAuthCodeRequested());
    SafeParcelWriter.writeBoolean(paramParcel, 6, isForceCodeForRefreshToken());
    SafeParcelWriter.writeString(paramParcel, 7, getServerClientId(), false);
    SafeParcelWriter.writeString(paramParcel, 8, this.zaac, false);
    SafeParcelWriter.writeTypedList(paramParcel, 9, getExtensions(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  public final String zae()
  {
    return zad().toString();
  }
  
  public static final class Builder
  {
    private Set<Scope> mScopes = new HashSet();
    private boolean zaaa;
    private String zaab;
    private String zaac;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> zaag = new HashMap();
    private Account zax;
    private boolean zay;
    private boolean zaz;
    
    public Builder() {}
    
    public Builder(GoogleSignInOptions paramGoogleSignInOptions)
    {
      Preconditions.checkNotNull(paramGoogleSignInOptions);
      this.mScopes = new HashSet(GoogleSignInOptions.zaa(paramGoogleSignInOptions));
      this.zaz = GoogleSignInOptions.zab(paramGoogleSignInOptions);
      this.zaaa = GoogleSignInOptions.zac(paramGoogleSignInOptions);
      this.zay = GoogleSignInOptions.zad(paramGoogleSignInOptions);
      this.zaab = GoogleSignInOptions.zae(paramGoogleSignInOptions);
      this.zax = GoogleSignInOptions.zaf(paramGoogleSignInOptions);
      this.zaac = GoogleSignInOptions.zag(paramGoogleSignInOptions);
      this.zaag = GoogleSignInOptions.zab(GoogleSignInOptions.zah(paramGoogleSignInOptions));
    }
    
    private final String zac(String paramString)
    {
      Preconditions.checkNotEmpty(paramString);
      String str = this.zaab;
      boolean bool;
      if ((str != null) && (!str.equals(paramString))) {
        bool = false;
      } else {
        bool = true;
      }
      Preconditions.checkArgument(bool, "two different server client ids provided");
      return paramString;
    }
    
    public final Builder addExtension(GoogleSignInOptionsExtension paramGoogleSignInOptionsExtension)
    {
      if (!this.zaag.containsKey(Integer.valueOf(paramGoogleSignInOptionsExtension.getExtensionType())))
      {
        if (paramGoogleSignInOptionsExtension.getImpliedScopes() != null) {
          this.mScopes.addAll(paramGoogleSignInOptionsExtension.getImpliedScopes());
        }
        this.zaag.put(Integer.valueOf(paramGoogleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(paramGoogleSignInOptionsExtension));
        return this;
      }
      throw new IllegalStateException("Only one extension per type may be added");
    }
    
    public final GoogleSignInOptions build()
    {
      if ((this.mScopes.contains(GoogleSignInOptions.zav)) && (this.mScopes.contains(GoogleSignInOptions.zau))) {
        this.mScopes.remove(GoogleSignInOptions.zau);
      }
      if ((this.zay) && ((this.zax == null) || (!this.mScopes.isEmpty()))) {
        requestId();
      }
      return new GoogleSignInOptions(3, new ArrayList(this.mScopes), this.zax, this.zay, this.zaz, this.zaaa, this.zaab, this.zaac, this.zaag, null);
    }
    
    public final Builder requestEmail()
    {
      this.mScopes.add(GoogleSignInOptions.zas);
      return this;
    }
    
    public final Builder requestId()
    {
      this.mScopes.add(GoogleSignInOptions.zat);
      return this;
    }
    
    public final Builder requestIdToken(String paramString)
    {
      this.zay = true;
      this.zaab = zac(paramString);
      return this;
    }
    
    public final Builder requestProfile()
    {
      this.mScopes.add(GoogleSignInOptions.zar);
      return this;
    }
    
    public final Builder requestScopes(Scope paramScope, Scope... paramVarArgs)
    {
      this.mScopes.add(paramScope);
      this.mScopes.addAll(Arrays.asList(paramVarArgs));
      return this;
    }
    
    public final Builder requestServerAuthCode(String paramString)
    {
      return requestServerAuthCode(paramString, false);
    }
    
    public final Builder requestServerAuthCode(String paramString, boolean paramBoolean)
    {
      this.zaz = true;
      this.zaab = zac(paramString);
      this.zaaa = paramBoolean;
      return this;
    }
    
    public final Builder setAccountName(String paramString)
    {
      this.zax = new Account(Preconditions.checkNotEmpty(paramString), "com.google");
      return this;
    }
    
    public final Builder setHostedDomain(String paramString)
    {
      this.zaac = Preconditions.checkNotEmpty(paramString);
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\auth\api\signin\GoogleSignInOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */