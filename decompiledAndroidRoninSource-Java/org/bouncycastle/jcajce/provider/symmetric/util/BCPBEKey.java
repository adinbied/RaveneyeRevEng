package org.bouncycastle.jcajce.provider.symmetric.util;

import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class BCPBEKey
  implements PBEKey
{
  String algorithm;
  int digest;
  int ivSize;
  int keySize;
  ASN1ObjectIdentifier oid;
  CipherParameters param;
  PBEKeySpec pbeKeySpec;
  boolean tryWrong = false;
  int type;
  
  public BCPBEKey(String paramString, ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt1, int paramInt2, int paramInt3, int paramInt4, PBEKeySpec paramPBEKeySpec, CipherParameters paramCipherParameters)
  {
    this.algorithm = paramString;
    this.oid = paramASN1ObjectIdentifier;
    this.type = paramInt1;
    this.digest = paramInt2;
    this.keySize = paramInt3;
    this.ivSize = paramInt4;
    this.pbeKeySpec = paramPBEKeySpec;
    this.param = paramCipherParameters;
  }
  
  public String getAlgorithm()
  {
    return this.algorithm;
  }
  
  int getDigest()
  {
    return this.digest;
  }
  
  public byte[] getEncoded()
  {
    CipherParameters localCipherParameters2 = this.param;
    if (localCipherParameters2 != null)
    {
      CipherParameters localCipherParameters1 = localCipherParameters2;
      if ((localCipherParameters2 instanceof ParametersWithIV)) {
        localCipherParameters1 = ((ParametersWithIV)localCipherParameters2).getParameters();
      }
      return ((KeyParameter)localCipherParameters1).getKey();
    }
    int i = this.type;
    if (i == 2) {
      return PBEParametersGenerator.PKCS12PasswordToBytes(this.pbeKeySpec.getPassword());
    }
    if (i == 5) {
      return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(this.pbeKeySpec.getPassword());
    }
    return PBEParametersGenerator.PKCS5PasswordToBytes(this.pbeKeySpec.getPassword());
  }
  
  public String getFormat()
  {
    return "RAW";
  }
  
  public int getIterationCount()
  {
    return this.pbeKeySpec.getIterationCount();
  }
  
  public int getIvSize()
  {
    return this.ivSize;
  }
  
  int getKeySize()
  {
    return this.keySize;
  }
  
  public ASN1ObjectIdentifier getOID()
  {
    return this.oid;
  }
  
  public CipherParameters getParam()
  {
    return this.param;
  }
  
  public char[] getPassword()
  {
    return this.pbeKeySpec.getPassword();
  }
  
  public byte[] getSalt()
  {
    return this.pbeKeySpec.getSalt();
  }
  
  int getType()
  {
    return this.type;
  }
  
  public void setTryWrongPKCS12Zero(boolean paramBoolean)
  {
    this.tryWrong = paramBoolean;
  }
  
  boolean shouldTryWrongPKCS12()
  {
    return this.tryWrong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\symmetri\\util\BCPBEKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */