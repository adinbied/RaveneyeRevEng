package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

public abstract interface TlsClient
  extends TlsPeer
{
  public abstract TlsAuthentication getAuthentication()
    throws IOException;
  
  public abstract int[] getCipherSuites();
  
  public abstract Hashtable getClientExtensions()
    throws IOException;
  
  public abstract ProtocolVersion getClientHelloRecordLayerVersion();
  
  public abstract Vector getClientSupplementalData()
    throws IOException;
  
  public abstract ProtocolVersion getClientVersion();
  
  public abstract short[] getCompressionMethods();
  
  public abstract TlsKeyExchange getKeyExchange()
    throws IOException;
  
  public abstract TlsSession getSessionToResume();
  
  public abstract void init(TlsClientContext paramTlsClientContext);
  
  public abstract boolean isFallback();
  
  public abstract void notifyNewSessionTicket(NewSessionTicket paramNewSessionTicket)
    throws IOException;
  
  public abstract void notifySelectedCipherSuite(int paramInt);
  
  public abstract void notifySelectedCompressionMethod(short paramShort);
  
  public abstract void notifyServerVersion(ProtocolVersion paramProtocolVersion)
    throws IOException;
  
  public abstract void notifySessionID(byte[] paramArrayOfByte);
  
  public abstract void processServerExtensions(Hashtable paramHashtable)
    throws IOException;
  
  public abstract void processServerSupplementalData(Vector paramVector)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */