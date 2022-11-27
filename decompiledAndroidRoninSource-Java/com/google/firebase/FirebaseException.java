package com.google.firebase;

import com.google.android.gms.common.internal.Preconditions;

public class FirebaseException
  extends Exception
{
  @Deprecated
  protected FirebaseException() {}
  
  public FirebaseException(String paramString)
  {
    super(Preconditions.checkNotEmpty(paramString, "Detail message must not be empty"));
  }
  
  public FirebaseException(String paramString, Throwable paramThrowable)
  {
    super(Preconditions.checkNotEmpty(paramString, "Detail message must not be empty"), paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\FirebaseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */