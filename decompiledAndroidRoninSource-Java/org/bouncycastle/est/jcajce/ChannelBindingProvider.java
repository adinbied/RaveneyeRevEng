package org.bouncycastle.est.jcajce;

import java.net.Socket;

public abstract interface ChannelBindingProvider
{
  public abstract boolean canAccessChannelBinding(Socket paramSocket);
  
  public abstract byte[] getChannelBinding(Socket paramSocket, String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\jcajce\ChannelBindingProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */