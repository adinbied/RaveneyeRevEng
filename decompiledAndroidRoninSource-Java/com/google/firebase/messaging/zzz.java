package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzz
{
  private static final Pattern zza = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");
  private final String zzb;
  private final String zzc;
  private final String zzd;
  
  private zzz(String paramString1, String paramString2)
  {
    Object localObject;
    if ((paramString2 != null) && (paramString2.startsWith("/topics/")))
    {
      Log.w("FirebaseMessaging", String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", new Object[] { paramString1 }));
      localObject = paramString2.substring(8);
    }
    else
    {
      localObject = paramString2;
    }
    if ((localObject != null) && (zza.matcher((CharSequence)localObject).matches()))
    {
      this.zzb = ((String)localObject);
      this.zzc = paramString1;
      localObject = new StringBuilder(String.valueOf(paramString1).length() + 1 + String.valueOf(paramString2).length());
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("!");
      ((StringBuilder)localObject).append(paramString2);
      this.zzd = ((StringBuilder)localObject).toString();
      return;
    }
    throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", new Object[] { localObject, "[a-zA-Z0-9-_.~%]{1,900}" }));
  }
  
  public static zzz zza(String paramString)
  {
    return new zzz("S", paramString);
  }
  
  public static zzz zzb(String paramString)
  {
    return new zzz("U", paramString);
  }
  
  static zzz zzc(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("!", -1);
    if (paramString.length != 2) {
      return null;
    }
    return new zzz(paramString[0], paramString[1]);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzz)) {
      return false;
    }
    paramObject = (zzz)paramObject;
    return (this.zzb.equals(((zzz)paramObject).zzb)) && (this.zzc.equals(((zzz)paramObject).zzc));
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.zzc, this.zzb });
  }
  
  public final String zza()
  {
    return this.zzb;
  }
  
  public final String zzb()
  {
    return this.zzc;
  }
  
  public final String zzc()
  {
    return this.zzd;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */