package org.bouncycastle.tsp;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.tsp.MessageImprint;
import org.bouncycastle.asn1.tsp.TimeStampReq;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;

public class TimeStampRequestGenerator
{
  private ASN1Boolean certReq;
  private ExtensionsGenerator extGenerator = new ExtensionsGenerator();
  private ASN1ObjectIdentifier reqPolicy;
  
  public void addExtension(String paramString, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    addExtension(paramString, paramBoolean, paramASN1Encodable.toASN1Primitive().getEncoded());
  }
  
  public void addExtension(String paramString, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this.extGenerator.addExtension(new ASN1ObjectIdentifier(paramString), paramBoolean, paramArrayOfByte);
  }
  
  public void addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
    throws TSPIOException
  {
    TSPUtil.addExtension(this.extGenerator, paramASN1ObjectIdentifier, paramBoolean, paramASN1Encodable);
  }
  
  public void addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this.extGenerator.addExtension(paramASN1ObjectIdentifier, paramBoolean, paramArrayOfByte);
  }
  
  public TimeStampRequest generate(String paramString, byte[] paramArrayOfByte)
  {
    return generate(paramString, paramArrayOfByte, null);
  }
  
  public TimeStampRequest generate(String paramString, byte[] paramArrayOfByte, BigInteger paramBigInteger)
  {
    if (paramString != null)
    {
      paramArrayOfByte = new MessageImprint(new AlgorithmIdentifier(new ASN1ObjectIdentifier(paramString), DERNull.INSTANCE), paramArrayOfByte);
      paramString = null;
      if (!this.extGenerator.isEmpty()) {
        paramString = this.extGenerator.generate();
      }
      ASN1ObjectIdentifier localASN1ObjectIdentifier = this.reqPolicy;
      if (paramBigInteger != null)
      {
        paramString = new TimeStampReq(paramArrayOfByte, localASN1ObjectIdentifier, new ASN1Integer(paramBigInteger), this.certReq, paramString);
        paramString = new TimeStampRequest(paramString);
        return paramString;
      }
      paramString = new TimeStampReq(paramArrayOfByte, localASN1ObjectIdentifier, null, this.certReq, paramString);
      paramString = new TimeStampRequest(paramString);
      return paramString;
    }
    throw new IllegalArgumentException("No digest algorithm specified");
  }
  
  public TimeStampRequest generate(ASN1ObjectIdentifier paramASN1ObjectIdentifier, byte[] paramArrayOfByte)
  {
    return generate(paramASN1ObjectIdentifier.getId(), paramArrayOfByte);
  }
  
  public TimeStampRequest generate(ASN1ObjectIdentifier paramASN1ObjectIdentifier, byte[] paramArrayOfByte, BigInteger paramBigInteger)
  {
    return generate(paramASN1ObjectIdentifier.getId(), paramArrayOfByte, paramBigInteger);
  }
  
  public void setCertReq(boolean paramBoolean)
  {
    this.certReq = ASN1Boolean.getInstance(paramBoolean);
  }
  
  public void setReqPolicy(String paramString)
  {
    this.reqPolicy = new ASN1ObjectIdentifier(paramString);
  }
  
  public void setReqPolicy(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    this.reqPolicy = paramASN1ObjectIdentifier;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\TimeStampRequestGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */