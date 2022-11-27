package com.google.firebase.crashlytics.internal.ndk;

class ProcMapEntry
{
  public final long address;
  public final String path;
  public final String perms;
  public final long size;
  
  public ProcMapEntry(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    this.address = paramLong1;
    this.size = paramLong2;
    this.perms = paramString1;
    this.path = paramString2;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\ndk\ProcMapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */