package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

final class zzkx
  extends SSLSocket
{
  private final SSLSocket zza;
  
  zzkx(zzky paramzzky, SSLSocket paramSSLSocket)
  {
    this.zza = paramSSLSocket;
  }
  
  public final void addHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    this.zza.addHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public final void bind(SocketAddress paramSocketAddress)
    throws IOException
  {
    this.zza.bind(paramSocketAddress);
  }
  
  public final void close()
    throws IOException
  {
    try
    {
      this.zza.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void connect(SocketAddress paramSocketAddress)
    throws IOException
  {
    this.zza.connect(paramSocketAddress);
  }
  
  public final void connect(SocketAddress paramSocketAddress, int paramInt)
    throws IOException
  {
    this.zza.connect(paramSocketAddress, paramInt);
  }
  
  public final boolean equals(Object paramObject)
  {
    return this.zza.equals(paramObject);
  }
  
  public final SocketChannel getChannel()
  {
    return this.zza.getChannel();
  }
  
  public final boolean getEnableSessionCreation()
  {
    return this.zza.getEnableSessionCreation();
  }
  
  public final String[] getEnabledCipherSuites()
  {
    return this.zza.getEnabledCipherSuites();
  }
  
  public final String[] getEnabledProtocols()
  {
    return this.zza.getEnabledProtocols();
  }
  
  public final InetAddress getInetAddress()
  {
    return this.zza.getInetAddress();
  }
  
  public final InputStream getInputStream()
    throws IOException
  {
    return this.zza.getInputStream();
  }
  
  public final boolean getKeepAlive()
    throws SocketException
  {
    return this.zza.getKeepAlive();
  }
  
  public final InetAddress getLocalAddress()
  {
    return this.zza.getLocalAddress();
  }
  
  public final int getLocalPort()
  {
    return this.zza.getLocalPort();
  }
  
  public final SocketAddress getLocalSocketAddress()
  {
    return this.zza.getLocalSocketAddress();
  }
  
  public final boolean getNeedClientAuth()
  {
    return this.zza.getNeedClientAuth();
  }
  
  public final boolean getOOBInline()
    throws SocketException
  {
    return this.zza.getOOBInline();
  }
  
  public final OutputStream getOutputStream()
    throws IOException
  {
    return this.zza.getOutputStream();
  }
  
  public final int getPort()
  {
    return this.zza.getPort();
  }
  
  public final int getReceiveBufferSize()
    throws SocketException
  {
    try
    {
      int i = this.zza.getReceiveBufferSize();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final SocketAddress getRemoteSocketAddress()
  {
    return this.zza.getRemoteSocketAddress();
  }
  
  public final boolean getReuseAddress()
    throws SocketException
  {
    return this.zza.getReuseAddress();
  }
  
  public final int getSendBufferSize()
    throws SocketException
  {
    try
    {
      int i = this.zza.getSendBufferSize();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final SSLSession getSession()
  {
    return this.zza.getSession();
  }
  
  public final int getSoLinger()
    throws SocketException
  {
    return this.zza.getSoLinger();
  }
  
  public final int getSoTimeout()
    throws SocketException
  {
    try
    {
      int i = this.zza.getSoTimeout();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String[] getSupportedCipherSuites()
  {
    return this.zza.getSupportedCipherSuites();
  }
  
  public final String[] getSupportedProtocols()
  {
    return this.zza.getSupportedProtocols();
  }
  
  public final boolean getTcpNoDelay()
    throws SocketException
  {
    return this.zza.getTcpNoDelay();
  }
  
  public final int getTrafficClass()
    throws SocketException
  {
    return this.zza.getTrafficClass();
  }
  
  public final boolean getUseClientMode()
  {
    return this.zza.getUseClientMode();
  }
  
  public final boolean getWantClientAuth()
  {
    return this.zza.getWantClientAuth();
  }
  
  public final boolean isBound()
  {
    return this.zza.isBound();
  }
  
  public final boolean isClosed()
  {
    return this.zza.isClosed();
  }
  
  public final boolean isConnected()
  {
    return this.zza.isConnected();
  }
  
  public final boolean isInputShutdown()
  {
    return this.zza.isInputShutdown();
  }
  
  public final boolean isOutputShutdown()
  {
    return this.zza.isOutputShutdown();
  }
  
  public final void removeHandshakeCompletedListener(HandshakeCompletedListener paramHandshakeCompletedListener)
  {
    this.zza.removeHandshakeCompletedListener(paramHandshakeCompletedListener);
  }
  
  public final void sendUrgentData(int paramInt)
    throws IOException
  {
    this.zza.sendUrgentData(paramInt);
  }
  
  public final void setEnableSessionCreation(boolean paramBoolean)
  {
    this.zza.setEnableSessionCreation(paramBoolean);
  }
  
  public final void setEnabledCipherSuites(String[] paramArrayOfString)
  {
    this.zza.setEnabledCipherSuites(paramArrayOfString);
  }
  
  public final void setEnabledProtocols(String[] paramArrayOfString)
  {
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString != null)
    {
      arrayOfString = paramArrayOfString;
      if (Arrays.asList(paramArrayOfString).contains("SSLv3"))
      {
        paramArrayOfString = new ArrayList(Arrays.asList(this.zza.getEnabledProtocols()));
        if (paramArrayOfString.size() > 1) {
          paramArrayOfString.remove("SSLv3");
        }
        arrayOfString = (String[])paramArrayOfString.toArray(new String[paramArrayOfString.size()]);
      }
    }
    this.zza.setEnabledProtocols(arrayOfString);
  }
  
  public final void setKeepAlive(boolean paramBoolean)
    throws SocketException
  {
    this.zza.setKeepAlive(paramBoolean);
  }
  
  public final void setNeedClientAuth(boolean paramBoolean)
  {
    this.zza.setNeedClientAuth(paramBoolean);
  }
  
  public final void setOOBInline(boolean paramBoolean)
    throws SocketException
  {
    this.zza.setOOBInline(paramBoolean);
  }
  
  public final void setPerformancePreferences(int paramInt1, int paramInt2, int paramInt3)
  {
    this.zza.setPerformancePreferences(paramInt1, paramInt2, paramInt3);
  }
  
  public final void setReceiveBufferSize(int paramInt)
    throws SocketException
  {
    try
    {
      this.zza.setReceiveBufferSize(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void setReuseAddress(boolean paramBoolean)
    throws SocketException
  {
    this.zza.setReuseAddress(paramBoolean);
  }
  
  public final void setSendBufferSize(int paramInt)
    throws SocketException
  {
    try
    {
      this.zza.setSendBufferSize(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void setSoLinger(boolean paramBoolean, int paramInt)
    throws SocketException
  {
    this.zza.setSoLinger(paramBoolean, paramInt);
  }
  
  public final void setSoTimeout(int paramInt)
    throws SocketException
  {
    try
    {
      this.zza.setSoTimeout(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void setTcpNoDelay(boolean paramBoolean)
    throws SocketException
  {
    this.zza.setTcpNoDelay(paramBoolean);
  }
  
  public final void setTrafficClass(int paramInt)
    throws SocketException
  {
    this.zza.setTrafficClass(paramInt);
  }
  
  public final void setUseClientMode(boolean paramBoolean)
  {
    this.zza.setUseClientMode(paramBoolean);
  }
  
  public final void setWantClientAuth(boolean paramBoolean)
  {
    this.zza.setWantClientAuth(paramBoolean);
  }
  
  public final void shutdownInput()
    throws IOException
  {
    this.zza.shutdownInput();
  }
  
  public final void shutdownOutput()
    throws IOException
  {
    this.zza.shutdownOutput();
  }
  
  public final void startHandshake()
    throws IOException
  {
    this.zza.startHandshake();
  }
  
  public final String toString()
  {
    return this.zza.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzkx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */