package org.bouncycastle.cms.jcajce;

import java.security.PrivateKey;
import javax.crypto.SecretKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.operator.SymmetricKeyUnwrapper;
import org.bouncycastle.operator.jcajce.JceAsymmetricKeyUnwrapper;
import org.bouncycastle.operator.jcajce.JceKTSKeyUnwrapper;
import org.bouncycastle.operator.jcajce.JceSymmetricKeyUnwrapper;

class NamedJcaJceExtHelper
  extends NamedJcaJceHelper
  implements JcaJceExtHelper
{
  public NamedJcaJceExtHelper(String paramString)
  {
    super(paramString);
  }
  
  public JceAsymmetricKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier paramAlgorithmIdentifier, PrivateKey paramPrivateKey)
  {
    return new JceAsymmetricKeyUnwrapper(paramAlgorithmIdentifier, paramPrivateKey).setProvider(this.providerName);
  }
  
  public JceKTSKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier paramAlgorithmIdentifier, PrivateKey paramPrivateKey, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new JceKTSKeyUnwrapper(paramAlgorithmIdentifier, paramPrivateKey, paramArrayOfByte1, paramArrayOfByte2).setProvider(this.providerName);
  }
  
  public SymmetricKeyUnwrapper createSymmetricUnwrapper(AlgorithmIdentifier paramAlgorithmIdentifier, SecretKey paramSecretKey)
  {
    return new JceSymmetricKeyUnwrapper(paramAlgorithmIdentifier, paramSecretKey).setProvider(this.providerName);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\NamedJcaJceExtHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */