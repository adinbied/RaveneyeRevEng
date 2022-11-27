package com.google.firebase.installations.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class IidStore
{
  private static final String[] ALLOWABLE_SCOPES = { "*", "FCM", "GCM", "" };
  private static final String IID_SHARED_PREFS_NAME = "com.google.android.gms.appid";
  private static final String JSON_ENCODED_PREFIX = "{";
  private static final String JSON_TOKEN_KEY = "token";
  private static final String STORE_KEY_ID = "|S|id";
  private static final String STORE_KEY_PUB = "|S||P|";
  private static final String STORE_KEY_SEPARATOR = "|";
  private static final String STORE_KEY_TOKEN = "|T|";
  private final String defaultSenderId;
  private final SharedPreferences iidPrefs;
  
  public IidStore(SharedPreferences paramSharedPreferences, String paramString)
  {
    this.iidPrefs = paramSharedPreferences;
    this.defaultSenderId = paramString;
  }
  
  public IidStore(FirebaseApp paramFirebaseApp)
  {
    this.iidPrefs = paramFirebaseApp.getApplicationContext().getSharedPreferences("com.google.android.gms.appid", 0);
    this.defaultSenderId = getDefaultSenderId(paramFirebaseApp);
  }
  
  private String createTokenKey(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|T|");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("|");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private static String getDefaultSenderId(FirebaseApp paramFirebaseApp)
  {
    String str = paramFirebaseApp.getOptions().getGcmSenderId();
    if (str != null) {
      return str;
    }
    paramFirebaseApp = paramFirebaseApp.getOptions().getApplicationId();
    if ((!paramFirebaseApp.startsWith("1:")) && (!paramFirebaseApp.startsWith("2:"))) {
      return paramFirebaseApp;
    }
    paramFirebaseApp = paramFirebaseApp.split(":");
    if (paramFirebaseApp.length != 4) {
      return null;
    }
    paramFirebaseApp = paramFirebaseApp[1];
    if (paramFirebaseApp.isEmpty()) {
      return null;
    }
    return paramFirebaseApp;
  }
  
  private static String getIdFromPublicKey(PublicKey paramPublicKey)
  {
    paramPublicKey = paramPublicKey.getEncoded();
    try
    {
      paramPublicKey = MessageDigest.getInstance("SHA1").digest(paramPublicKey);
      paramPublicKey[0] = ((byte)((paramPublicKey[0] & 0xF) + 112 & 0xFF));
      paramPublicKey = Base64.encodeToString(paramPublicKey, 0, 8, 11);
      return paramPublicKey;
    }
    catch (NoSuchAlgorithmException paramPublicKey)
    {
      for (;;) {}
    }
    Log.w("ContentValues", "Unexpected error, device missing required algorithms");
    return null;
  }
  
  private String parseIidTokenFromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("token");
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  private PublicKey parseKey(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 8);
      paramString = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(paramString));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}catch (InvalidKeySpecException paramString) {}catch (IllegalArgumentException paramString) {}
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid key stored ");
    localStringBuilder.append(paramString);
    Log.w("ContentValues", localStringBuilder.toString());
    return null;
  }
  
  private String readInstanceIdFromLocalStorage()
  {
    synchronized (this.iidPrefs)
    {
      String str = this.iidPrefs.getString("|S|id", null);
      return str;
    }
  }
  
  private String readPublicKeyFromLocalStorageAndCalculateInstanceId()
  {
    synchronized (this.iidPrefs)
    {
      Object localObject1 = this.iidPrefs.getString("|S||P|", null);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = parseKey((String)localObject1);
      if (localObject1 == null) {
        return null;
      }
      localObject1 = getIdFromPublicKey((PublicKey)localObject1);
      return (String)localObject1;
    }
  }
  
  public String readIid()
  {
    synchronized (this.iidPrefs)
    {
      String str = readInstanceIdFromLocalStorage();
      if (str != null) {
        return str;
      }
      str = readPublicKeyFromLocalStorageAndCalculateInstanceId();
      return str;
    }
  }
  
  public String readToken()
  {
    for (;;)
    {
      int i;
      synchronized (this.iidPrefs)
      {
        Object localObject1 = ALLOWABLE_SCOPES;
        int j = localObject1.length;
        i = 0;
        if (i < j)
        {
          String str = localObject1[i];
          str = createTokenKey(this.defaultSenderId, str);
          str = this.iidPrefs.getString(str, null);
          if ((str != null) && (!str.isEmpty()))
          {
            localObject1 = str;
            if (str.startsWith("{")) {
              localObject1 = parseIidTokenFromJson(str);
            }
            return (String)localObject1;
          }
        }
        else
        {
          return null;
        }
      }
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\local\IidStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */