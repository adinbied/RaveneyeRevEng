package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Utils
{
  private static final Pattern API_KEY_FORMAT = Pattern.compile("\\AA[\\w-]{38}\\z");
  private static final String APP_ID_IDENTIFICATION_SUBSTRING = ":";
  public static final long AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS = TimeUnit.HOURS.toSeconds(1L);
  
  static boolean isValidApiKeyFormat(String paramString)
  {
    return API_KEY_FORMAT.matcher(paramString).matches();
  }
  
  static boolean isValidAppIdFormat(String paramString)
  {
    return paramString.contains(":");
  }
  
  public long currentTimeInSecs()
  {
    return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
  }
  
  public boolean isAuthTokenExpired(PersistedInstallationEntry paramPersistedInstallationEntry)
  {
    if (TextUtils.isEmpty(paramPersistedInstallationEntry.getAuthToken())) {
      return true;
    }
    return paramPersistedInstallationEntry.getTokenCreationEpochInSecs() + paramPersistedInstallationEntry.getExpiresInSecs() < currentTimeInSecs() + AUTH_TOKEN_EXPIRATION_BUFFER_IN_SECS;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */