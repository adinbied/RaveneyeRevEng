package org.bouncycastle.pqc.jcajce.provider.util;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class KeyUtil
{
  public static byte[] getEncodedPrivateKeyInfo(PrivateKeyInfo paramPrivateKeyInfo)
  {
    try
    {
      paramPrivateKeyInfo = paramPrivateKeyInfo.getEncoded("DER");
      return paramPrivateKeyInfo;
    }
    catch (Exception paramPrivateKeyInfo)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static byte[] getEncodedPrivateKeyInfo(AlgorithmIdentifier paramAlgorithmIdentifier, ASN1Encodable paramASN1Encodable)
  {
    try
    {
      paramAlgorithmIdentifier = getEncodedPrivateKeyInfo(new PrivateKeyInfo(paramAlgorithmIdentifier, paramASN1Encodable.toASN1Primitive()));
      return paramAlgorithmIdentifier;
    }
    catch (Exception paramAlgorithmIdentifier)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static byte[] getEncodedSubjectPublicKeyInfo(AlgorithmIdentifier paramAlgorithmIdentifier, ASN1Encodable paramASN1Encodable)
  {
    try
    {
      paramAlgorithmIdentifier = getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(paramAlgorithmIdentifier, paramASN1Encodable));
      return paramAlgorithmIdentifier;
    }
    catch (Exception paramAlgorithmIdentifier)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static byte[] getEncodedSubjectPublicKeyInfo(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    try
    {
      paramAlgorithmIdentifier = getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(paramAlgorithmIdentifier, paramArrayOfByte));
      return paramAlgorithmIdentifier;
    }
    catch (Exception paramAlgorithmIdentifier)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static byte[] getEncodedSubjectPublicKeyInfo(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    try
    {
      paramSubjectPublicKeyInfo = paramSubjectPublicKeyInfo.getEncoded("DER");
      return paramSubjectPublicKeyInfo;
    }
    catch (Exception paramSubjectPublicKeyInfo)
    {
      for (;;) {}
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provide\\util\KeyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */