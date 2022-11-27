package org.bouncycastle.crypto.tls;

import org.bouncycastle.util.Arrays;

class TlsSessionImpl
  implements TlsSession
{
  final byte[] sessionID;
  SessionParameters sessionParameters;
  
  TlsSessionImpl(byte[] paramArrayOfByte, SessionParameters paramSessionParameters)
  {
    if (paramArrayOfByte != null)
    {
      if ((paramArrayOfByte.length >= 1) && (paramArrayOfByte.length <= 32))
      {
        this.sessionID = Arrays.clone(paramArrayOfByte);
        this.sessionParameters = paramSessionParameters;
        return;
      }
      throw new IllegalArgumentException("'sessionID' must have length between 1 and 32 bytes, inclusive");
    }
    throw new IllegalArgumentException("'sessionID' cannot be null");
  }
  
  public SessionParameters exportSessionParameters()
  {
    try
    {
      SessionParameters localSessionParameters;
      if (this.sessionParameters == null) {
        localSessionParameters = null;
      } else {
        localSessionParameters = this.sessionParameters.copy();
      }
      return localSessionParameters;
    }
    finally {}
  }
  
  public byte[] getSessionID()
  {
    try
    {
      byte[] arrayOfByte = this.sessionID;
      return arrayOfByte;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void invalidate()
  {
    try
    {
      if (this.sessionParameters != null)
      {
        this.sessionParameters.clear();
        this.sessionParameters = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean isResumable()
  {
    try
    {
      SessionParameters localSessionParameters = this.sessionParameters;
      boolean bool;
      if (localSessionParameters != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsSessionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */