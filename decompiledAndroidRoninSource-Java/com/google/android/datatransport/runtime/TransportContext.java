package com.google.android.datatransport.runtime;

import android.util.Base64;
import com.google.android.datatransport.Priority;

public abstract class TransportContext
{
  public static Builder builder()
  {
    return new AutoValue_TransportContext.Builder().setPriority(Priority.DEFAULT);
  }
  
  public abstract String getBackendName();
  
  public abstract byte[] getExtras();
  
  public abstract Priority getPriority();
  
  public final String toString()
  {
    String str2 = getBackendName();
    Priority localPriority = getPriority();
    String str1;
    if (getExtras() == null) {
      str1 = "";
    } else {
      str1 = Base64.encodeToString(getExtras(), 2);
    }
    return String.format("TransportContext(%s, %s, %s)", new Object[] { str2, localPriority, str1 });
  }
  
  public TransportContext withPriority(Priority paramPriority)
  {
    return builder().setBackendName(getBackendName()).setPriority(paramPriority).setExtras(getExtras()).build();
  }
  
  public static abstract class Builder
  {
    public abstract TransportContext build();
    
    public abstract Builder setBackendName(String paramString);
    
    public abstract Builder setExtras(byte[] paramArrayOfByte);
    
    public abstract Builder setPriority(Priority paramPriority);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\TransportContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */