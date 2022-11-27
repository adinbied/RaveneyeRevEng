package org.bouncycastle.cms.bc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.PasswordRecipientInfoGenerator;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.operator.GenericKey;

public class BcPasswordRecipientInfoGenerator
  extends PasswordRecipientInfoGenerator
{
  public BcPasswordRecipientInfoGenerator(ASN1ObjectIdentifier paramASN1ObjectIdentifier, char[] paramArrayOfChar)
  {
    super(paramASN1ObjectIdentifier, paramArrayOfChar);
  }
  
  protected byte[] calculateDerivedKey(int paramInt1, AlgorithmIdentifier paramAlgorithmIdentifier, int paramInt2)
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
  
  public byte[] generateEncryptedBytes(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte, GenericKey paramGenericKey)
    throws CMSException
  {
    paramGenericKey = ((KeyParameter)CMSUtils.getBcKey(paramGenericKey)).getKey();
    Wrapper localWrapper = EnvelopedDataHelper.createRFC3211Wrapper(paramAlgorithmIdentifier.getAlgorithm());
    localWrapper.init(true, new ParametersWithIV(new KeyParameter(paramArrayOfByte), ASN1OctetString.getInstance(paramAlgorithmIdentifier.getParameters()).getOctets()));
    return localWrapper.wrap(paramGenericKey, 0, paramGenericKey.length);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\bc\BcPasswordRecipientInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */