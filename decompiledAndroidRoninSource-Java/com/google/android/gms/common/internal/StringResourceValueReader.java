package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.common.R.string;
import javax.annotation.Nullable;

public class StringResourceValueReader
{
  private final Resources zzeu;
  private final String zzev;
  
  public StringResourceValueReader(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    paramContext = paramContext.getResources();
    this.zzeu = paramContext;
    this.zzev = paramContext.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
  }
  
  @Nullable
  public String getString(String paramString)
  {
    int i = this.zzeu.getIdentifier(paramString, "string", this.zzev);
    if (i == 0) {
      return null;
    }
    return this.zzeu.getString(i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\StringResourceValueReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */