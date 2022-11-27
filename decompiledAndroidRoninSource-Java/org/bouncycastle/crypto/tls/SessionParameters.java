package org.bouncycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import org.bouncycastle.util.Arrays;

public final class SessionParameters
{
  private int cipherSuite;
  private short compressionAlgorithm;
  private byte[] encodedServerExtensions;
  private byte[] masterSecret;
  private Certificate peerCertificate;
  private byte[] pskIdentity = null;
  private byte[] srpIdentity = null;
  
  private SessionParameters(int paramInt, short paramShort, byte[] paramArrayOfByte1, Certificate paramCertificate, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.cipherSuite = paramInt;
    this.compressionAlgorithm = paramShort;
    this.masterSecret = Arrays.clone(paramArrayOfByte1);
    this.peerCertificate = paramCertificate;
    this.pskIdentity = Arrays.clone(paramArrayOfByte2);
    this.srpIdentity = Arrays.clone(paramArrayOfByte3);
    this.encodedServerExtensions = paramArrayOfByte4;
  }
  
  public void clear()
  {
    byte[] arrayOfByte = this.masterSecret;
    if (arrayOfByte != null) {
      Arrays.fill(arrayOfByte, (byte)0);
    }
  }
  
  public SessionParameters copy()
  {
    return new SessionParameters(this.cipherSuite, this.compressionAlgorithm, this.masterSecret, this.peerCertificate, this.pskIdentity, this.srpIdentity, this.encodedServerExtensions);
  }
  
  public int getCipherSuite()
  {
    return this.cipherSuite;
  }
  
  public short getCompressionAlgorithm()
  {
    return this.compressionAlgorithm;
  }
  
  public byte[] getMasterSecret()
  {
    return this.masterSecret;
  }
  
  public byte[] getPSKIdentity()
  {
    return this.pskIdentity;
  }
  
  public Certificate getPeerCertificate()
  {
    return this.peerCertificate;
  }
  
  public byte[] getPskIdentity()
  {
    return this.pskIdentity;
  }
  
  public byte[] getSRPIdentity()
  {
    return this.srpIdentity;
  }
  
  public Hashtable readServerExtensions()
    throws IOException
  {
    if (this.encodedServerExtensions == null) {
      return null;
    }
    return TlsProtocol.readExtensions(new ByteArrayInputStream(this.encodedServerExtensions));
  }
  
  public static final class Builder
  {
    private int cipherSuite = -1;
    private short compressionAlgorithm = -1;
    private byte[] encodedServerExtensions = null;
    private byte[] masterSecret = null;
    private Certificate peerCertificate = null;
    private byte[] pskIdentity = null;
    private byte[] srpIdentity = null;
    
    private void validate(boolean paramBoolean, String paramString)
    {
      if (paramBoolean) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Required session parameter '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' not configured");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    public SessionParameters build()
    {
      int i = this.cipherSuite;
      boolean bool2 = true;
      boolean bool1;
      if (i >= 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      validate(bool1, "cipherSuite");
      if (this.compressionAlgorithm >= 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      validate(bool1, "compressionAlgorithm");
      if (this.masterSecret != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      validate(bool1, "masterSecret");
      return new SessionParameters(this.cipherSuite, this.compressionAlgorithm, this.masterSecret, this.peerCertificate, this.pskIdentity, this.srpIdentity, this.encodedServerExtensions, null);
    }
    
    public Builder setCipherSuite(int paramInt)
    {
      this.cipherSuite = paramInt;
      return this;
    }
    
    public Builder setCompressionAlgorithm(short paramShort)
    {
      this.compressionAlgorithm = paramShort;
      return this;
    }
    
    public Builder setMasterSecret(byte[] paramArrayOfByte)
    {
      this.masterSecret = paramArrayOfByte;
      return this;
    }
    
    public Builder setPSKIdentity(byte[] paramArrayOfByte)
    {
      this.pskIdentity = paramArrayOfByte;
      return this;
    }
    
    public Builder setPeerCertificate(Certificate paramCertificate)
    {
      this.peerCertificate = paramCertificate;
      return this;
    }
    
    public Builder setPskIdentity(byte[] paramArrayOfByte)
    {
      this.pskIdentity = paramArrayOfByte;
      return this;
    }
    
    public Builder setSRPIdentity(byte[] paramArrayOfByte)
    {
      this.srpIdentity = paramArrayOfByte;
      return this;
    }
    
    public Builder setServerExtensions(Hashtable paramHashtable)
      throws IOException
    {
      if (paramHashtable == null)
      {
        this.encodedServerExtensions = null;
        return this;
      }
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      TlsProtocol.writeExtensions(localByteArrayOutputStream, paramHashtable);
      this.encodedServerExtensions = localByteArrayOutputStream.toByteArray();
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\SessionParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */