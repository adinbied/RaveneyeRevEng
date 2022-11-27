package org.bouncycastle.cms.bc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.PasswordRecipient;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public abstract class BcPasswordRecipient
  implements PasswordRecipient
{
  private final char[] password;
  private int schemeID = 1;
  
  BcPasswordRecipient(char[] paramArrayOfChar)
  {
    this.password = paramArrayOfChar;
  }
  
  public byte[] calculateDerivedKey(int paramInt1, AlgorithmIdentifier paramAlgorithmIdentifier, int paramInt2)
    throws CMSException
  {
    Object localObject = PBKDF2Params.getInstance(paramAlgorithmIdentifier.getParameters());
    if (paramInt1 == 0) {
      paramAlgorithmIdentifier = PBEParametersGenerator.PKCS5PasswordToBytes(this.password);
    } else {
      paramAlgorithmIdentifier = PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(this.password);
    }
    try
    {
      PKCS5S2ParametersGenerator localPKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(EnvelopedDataHelper.getPRF(((PBKDF2Params)localObject).getPrf()));
      localPKCS5S2ParametersGenerator.init(paramAlgorithmIdentifier, ((PBKDF2Params)localObject).getSalt(), ((PBKDF2Params)localObject).getIterationCount().intValue());
      paramAlgorithmIdentifier = ((KeyParameter)localPKCS5S2ParametersGenerator.generateDerivedParameters(paramInt2)).getKey();
      return paramAlgorithmIdentifier;
    }
    catch (Exception paramAlgorithmIdentifier)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exception creating derived key: ");
      ((StringBuilder)localObject).append(paramAlgorithmIdentifier.getMessage());
      throw new CMSException(((StringBuilder)localObject).toString(), paramAlgorithmIdentifier);
    }
  }
  
  protected KeyParameter extractSecretKey(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws CMSException
  {
    paramAlgorithmIdentifier2 = EnvelopedDataHelper.createRFC3211Wrapper(paramAlgorithmIdentifier1.getAlgorithm());
    paramAlgorithmIdentifier2.init(false, new ParametersWithIV(new KeyParameter(paramArrayOfByte1), ASN1OctetString.getInstance(paramAlgorithmIdentifier1.getParameters()).getOctets()));
    try
    {
      paramAlgorithmIdentifier1 = new KeyParameter(paramAlgorithmIdentifier2.unwrap(paramArrayOfByte2, 0, paramArrayOfByte2.length));
      return paramAlgorithmIdentifier1;
    }
    catch (InvalidCipherTextException paramAlgorithmIdentifier1)
    {
      paramAlgorithmIdentifier2 = new StringBuilder();
      paramAlgorithmIdentifier2.append("unable to unwrap key: ");
      paramAlgorithmIdentifier2.append(paramAlgorithmIdentifier1.getMessage());
      throw new CMSException(paramAlgorithmIdentifier2.toString(), paramAlgorithmIdentifier1);
    }
  }
  
  public char[] getPassword()
  {
    return this.password;
  }
  
  public int getPasswordConversionScheme()
  {
    return this.schemeID;
  }
  
  public BcPasswordRecipient setPasswordConversionScheme(int paramInt)
  {
    this.schemeID = paramInt;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\bc\BcPasswordRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */