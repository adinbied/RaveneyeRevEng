package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.util.Strings;

public final class ProtocolVersion
{
  public static final ProtocolVersion DTLSv10 = new ProtocolVersion(65279, "DTLS 1.0");
  public static final ProtocolVersion DTLSv12 = new ProtocolVersion(65277, "DTLS 1.2");
  public static final ProtocolVersion SSLv3 = new ProtocolVersion(768, "SSL 3.0");
  public static final ProtocolVersion TLSv10 = new ProtocolVersion(769, "TLS 1.0");
  public static final ProtocolVersion TLSv11 = new ProtocolVersion(770, "TLS 1.1");
  public static final ProtocolVersion TLSv12 = new ProtocolVersion(771, "TLS 1.2");
  private String name;
  private int version;
  
  private ProtocolVersion(int paramInt, String paramString)
  {
    this.version = (paramInt & 0xFFFF);
    this.name = paramString;
  }
  
  public static ProtocolVersion get(int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt1 != 3) {
      if (paramInt1 == 254) {
        switch (paramInt2)
        {
        }
      }
    }
    for (String str = "DTLS";; str = "TLS")
    {
      return getUnknownVersion(paramInt1, paramInt2, str);
      return DTLSv10;
      throw new TlsFatalAlert((short)47);
      return DTLSv12;
      throw new TlsFatalAlert((short)47);
      if (paramInt2 == 0) {
        break label115;
      }
      if (paramInt2 == 1) {
        break label111;
      }
      if (paramInt2 == 2) {
        break label107;
      }
      if (paramInt2 == 3) {
        break;
      }
    }
    return TLSv12;
    label107:
    return TLSv11;
    label111:
    return TLSv10;
    label115:
    return SSLv3;
  }
  
  private static ProtocolVersion getUnknownVersion(int paramInt1, int paramInt2, String paramString)
    throws IOException
  {
    TlsUtils.checkUint8(paramInt1);
    TlsUtils.checkUint8(paramInt2);
    paramInt1 = paramInt1 << 8 | paramInt2;
    String str = Strings.toUpperCase(Integer.toHexString(0x10000 | paramInt1).substring(1));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" 0x");
    localStringBuilder.append(str);
    return new ProtocolVersion(paramInt1, localStringBuilder.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof ProtocolVersion)) && (equals((ProtocolVersion)paramObject)));
  }
  
  public boolean equals(ProtocolVersion paramProtocolVersion)
  {
    return (paramProtocolVersion != null) && (this.version == paramProtocolVersion.version);
  }
  
  public ProtocolVersion getEquivalentTLSVersion()
  {
    if (!isDTLS()) {
      return this;
    }
    if (this == DTLSv10) {
      return TLSv11;
    }
    return TLSv12;
  }
  
  public int getFullVersion()
  {
    return this.version;
  }
  
  public int getMajorVersion()
  {
    return this.version >> 8;
  }
  
  public int getMinorVersion()
  {
    return this.version & 0xFF;
  }
  
  public int hashCode()
  {
    return this.version;
  }
  
  public boolean isDTLS()
  {
    return getMajorVersion() == 254;
  }
  
  public boolean isEqualOrEarlierVersionOf(ProtocolVersion paramProtocolVersion)
  {
    int i = getMajorVersion();
    int j = paramProtocolVersion.getMajorVersion();
    boolean bool = false;
    if (i != j) {
      return false;
    }
    i = paramProtocolVersion.getMinorVersion() - getMinorVersion();
    if (isDTLS() ? i <= 0 : i >= 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isLaterVersionOf(ProtocolVersion paramProtocolVersion)
  {
    int i = getMajorVersion();
    int j = paramProtocolVersion.getMajorVersion();
    boolean bool = false;
    if (i != j) {
      return false;
    }
    i = paramProtocolVersion.getMinorVersion() - getMinorVersion();
    if (isDTLS() ? i > 0 : i < 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isSSL()
  {
    return this == SSLv3;
  }
  
  public boolean isTLS()
  {
    return getMajorVersion() == 3;
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\ProtocolVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */