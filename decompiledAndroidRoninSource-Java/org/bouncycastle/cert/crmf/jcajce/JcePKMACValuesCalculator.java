package org.bouncycastle.cert.crmf.jcajce;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.cert.crmf.PKMACValuesCalculator;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;

public class JcePKMACValuesCalculator
  implements PKMACValuesCalculator
{
  private MessageDigest digest;
  private CRMFHelper helper = new CRMFHelper(new DefaultJcaJceHelper());
  private Mac mac;
  
  public byte[] calculateDigest(byte[] paramArrayOfByte)
  {
    return this.digest.digest(paramArrayOfByte);
  }
  
  public byte[] calculateMac(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws CRMFException
  {
    try
    {
      this.mac.init(new SecretKeySpec(paramArrayOfByte1, this.mac.getAlgorithm()));
      paramArrayOfByte1 = this.mac.doFinal(paramArrayOfByte2);
      return paramArrayOfByte1;
    }
    catch (GeneralSecurityException paramArrayOfByte1)
    {
      paramArrayOfByte2 = new StringBuilder();
      paramArrayOfByte2.append("failure in setup: ");
      paramArrayOfByte2.append(paramArrayOfByte1.getMessage());
      throw new CRMFException(paramArrayOfByte2.toString(), paramArrayOfByte1);
    }
  }
  
  public JcePKMACValuesCalculator setProvider(String paramString)
  {
    this.helper = new CRMFHelper(new NamedJcaJceHelper(paramString));
    return this;
  }
  
  public JcePKMACValuesCalculator setProvider(Provider paramProvider)
  {
    this.helper = new CRMFHelper(new ProviderJcaJceHelper(paramProvider));
    return this;
  }
  
  public void setup(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2)
    throws CRMFException
  {
    this.digest = this.helper.createDigest(paramAlgorithmIdentifier1.getAlgorithm());
    this.mac = this.helper.createMac(paramAlgorithmIdentifier2.getAlgorithm());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\jcajce\JcePKMACValuesCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */