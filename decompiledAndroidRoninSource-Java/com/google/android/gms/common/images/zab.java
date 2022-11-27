package com.google.android.gms.common.images;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;

final class zab
{
  public final Uri uri;
  
  public zab(Uri paramUri)
  {
    this.uri = paramUri;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zab)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    return Objects.equal(((zab)paramObject).uri, this.uri);
  }
  
  public final int hashCode()
  {
    return Objects.hashCode(new Object[] { this.uri });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\images\zab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */