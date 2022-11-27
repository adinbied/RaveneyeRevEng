package org.bouncycastle.pkcs;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.ContentInfo;
import org.bouncycastle.asn1.pkcs.MacData;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.pkcs.Pfx;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.util.Arrays;

public class PKCS12PfxPdu
{
  private Pfx pfx;
  
  public PKCS12PfxPdu(Pfx paramPfx)
  {
    this.pfx = paramPfx;
  }
  
  public PKCS12PfxPdu(byte[] paramArrayOfByte)
    throws IOException
  {
    this(parseBytes(paramArrayOfByte));
  }
  
  private static Pfx parseBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = Pfx.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new PKCSIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
    catch (ClassCastException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new PKCSIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  public ContentInfo[] getContentInfos()
  {
    ASN1Sequence localASN1Sequence = ASN1Sequence.getInstance(ASN1OctetString.getInstance(this.pfx.getAuthSafe().getContent()).getOctets());
    ContentInfo[] arrayOfContentInfo = new ContentInfo[localASN1Sequence.size()];
    int i = 0;
    while (i != localASN1Sequence.size())
    {
      arrayOfContentInfo[i] = ContentInfo.getInstance(localASN1Sequence.getObjectAt(i));
      i += 1;
    }
    return arrayOfContentInfo;
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return toASN1Structure().getEncoded();
  }
  
  public byte[] getEncoded(String paramString)
    throws IOException
  {
    return toASN1Structure().getEncoded(paramString);
  }
  
  public AlgorithmIdentifier getMacAlgorithmID()
  {
    MacData localMacData = this.pfx.getMacData();
    if (localMacData != null) {
      return localMacData.getMac().getAlgorithmId();
    }
    return null;
  }
  
  public boolean hasMac()
  {
    return this.pfx.getMacData() != null;
  }
  
  public boolean isMacValid(PKCS12MacCalculatorBuilderProvider paramPKCS12MacCalculatorBuilderProvider, char[] paramArrayOfChar)
    throws PKCSException
  {
    if (hasMac())
    {
      MacData localMacData = this.pfx.getMacData();
      paramPKCS12MacCalculatorBuilderProvider = new MacDataGenerator(paramPKCS12MacCalculatorBuilderProvider.get(new AlgorithmIdentifier(localMacData.getMac().getAlgorithmId().getAlgorithm(), new PKCS12PBEParams(localMacData.getSalt(), localMacData.getIterationCount().intValue()))));
      try
      {
        boolean bool = Arrays.constantTimeAreEqual(paramPKCS12MacCalculatorBuilderProvider.build(paramArrayOfChar, ASN1OctetString.getInstance(this.pfx.getAuthSafe().getContent()).getOctets()).getEncoded(), this.pfx.getMacData().getEncoded());
        return bool;
      }
      catch (IOException paramPKCS12MacCalculatorBuilderProvider)
      {
        paramArrayOfChar = new StringBuilder();
        paramArrayOfChar.append("unable to process AuthSafe: ");
        paramArrayOfChar.append(paramPKCS12MacCalculatorBuilderProvider.getMessage());
        throw new PKCSException(paramArrayOfChar.toString());
      }
    }
    throw new IllegalStateException("no MAC present on PFX");
  }
  
  public Pfx toASN1Structure()
  {
    return this.pfx;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\PKCS12PfxPdu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */