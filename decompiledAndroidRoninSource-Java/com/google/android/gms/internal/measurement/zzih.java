package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class zzih
  extends IOException
{
  private zzjh zza = null;
  
  public zzih(String paramString)
  {
    super(paramString);
  }
  
  static zzih zza()
  {
    return new zzih("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
  }
  
  static zzih zzb()
  {
    return new zzih("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static zzih zzc()
  {
    return new zzih("CodedInputStream encountered a malformed varint.");
  }
  
  static zzih zzd()
  {
    return new zzih("Protocol message contained an invalid tag (zero).");
  }
  
  static zzih zze()
  {
    return new zzih("Protocol message end-group tag did not match expected tag.");
  }
  
  static zzik zzf()
  {
    return new zzik("Protocol message tag had invalid wire type.");
  }
  
  static zzih zzg()
  {
    return new zzih("Failed to parse the message.");
  }
  
  static zzih zzh()
  {
    return new zzih("Protocol message had invalid UTF-8.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */