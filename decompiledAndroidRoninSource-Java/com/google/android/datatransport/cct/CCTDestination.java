package com.google.android.datatransport.cct;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedDestination;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class CCTDestination
  implements EncodedDestination
{
  public static final CCTDestination INSTANCE = new CCTDestination(zza, null);
  public static final CCTDestination LEGACY_INSTANCE = new CCTDestination(zzb, zzc);
  static final String zza = zzd.zza("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
  static final String zzb = zzd.zza("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
  private static final String zzc = zzd.zza("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
  private static final Set<Encoding> zzd = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Encoding[] { Encoding.of("proto"), Encoding.of("json") })));
  private final String zze;
  private final String zzf;
  
  public CCTDestination(String paramString1, String paramString2)
  {
    this.zze = paramString1;
    this.zzf = paramString2;
  }
  
  public static CCTDestination fromByteArray(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new String(paramArrayOfByte, Charset.forName("UTF-8"));
    if (paramArrayOfByte.startsWith("1$"))
    {
      paramArrayOfByte = paramArrayOfByte.substring(2).split(Pattern.quote("\\"), 2);
      if (paramArrayOfByte.length == 2)
      {
        byte b2 = paramArrayOfByte[0];
        if (!b2.isEmpty())
        {
          byte b1 = paramArrayOfByte[1];
          paramArrayOfByte = b1;
          if (b1.isEmpty()) {
            paramArrayOfByte = null;
          }
          return new CCTDestination(b2, paramArrayOfByte);
        }
        throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
      }
      throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
    }
    throw new IllegalArgumentException("Version marker missing from extras");
  }
  
  public byte[] asByteArray()
  {
    if ((this.zzf == null) && (this.zze == null)) {
      return null;
    }
    String str3 = this.zze;
    String str2 = this.zzf;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return String.format("%s%s%s%s", new Object[] { "1$", str3, "\\", str1 }).getBytes(Charset.forName("UTF-8"));
  }
  
  public String getAPIKey()
  {
    return this.zzf;
  }
  
  public String getEndPoint()
  {
    return this.zze;
  }
  
  public byte[] getExtras()
  {
    return asByteArray();
  }
  
  public String getName()
  {
    return "cct";
  }
  
  public Set<Encoding> getSupportedEncodings()
  {
    return zzd;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\cct\CCTDestination.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */