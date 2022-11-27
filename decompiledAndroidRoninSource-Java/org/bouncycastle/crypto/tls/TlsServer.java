package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

public abstract interface TlsServer
  extends TlsPeer
{
  public abstract CertificateRequest getCertificateRequest()
    throws IOException;
  
  public abstract CertificateStatus getCertificateStatus()
    throws IOException;
  
  public abstract TlsCredentials getCredentials()
    throws IOException;
  
  public abstract TlsKeyExchange getKeyExchange()
    throws IOException;
  
  public abstract NewSessionTicket getNewSessionTicket()
    throws IOException;
  
  public abstract int getSelectedCipherSuite()
    throws IOException;
  
  public abstract short getSelectedCompressionMethod()
    throws IOException;
  
  public abstract Hashtable getServerExtensions()
    throws IOException;
  
  public abstract Vector getServerSupplementalData()
    throws IOException;
  
  public abstract ProtocolVersion getServerVersion()
    throws IOException;
  
  public abstract void init(TlsServerContext paramTlsServerContext);
  
  public abstract void notifyClientCertificate(Certificate paramCertificate)
    throws IOException;
  
  public abstract void notifyClientVersion(ProtocolVersion paramProtocolVersion)
    throws IOException;
  
  public abstract void notifyFallback(boolean paramBoolean)
    throws IOException;
  
  public abstract void notifyOfferedCipherSuites(int[] paramArrayOfInt)
    throws IOException;
  
  public abstract void notifyOfferedCompressionMethods(short[] paramArrayOfShort)
    throws IOException;
  
  public abstract void processClientExtensions(Hashtable paramHashtable)
    throws IOException;
  
  public abstract void processClientSupplementalData(Vector paramVector)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */