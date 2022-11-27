package org.bouncycastle.pqc.crypto.sphincs;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class SPHINCS256KeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  private SecureRandom random;
  private Digest treeDigest;
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    Tree.leafaddr localleafaddr = new Tree.leafaddr();
    byte[] arrayOfByte1 = new byte['р'];
    this.random.nextBytes(arrayOfByte1);
    byte[] arrayOfByte2 = new byte['Р'];
    System.arraycopy(arrayOfByte1, 32, arrayOfByte2, 0, 1024);
    localleafaddr.level = 11;
    localleafaddr.subtree = 0L;
    localleafaddr.subleaf = 0L;
    Tree.treehash(new HashFunctions(this.treeDigest), arrayOfByte2, 1024, 5, arrayOfByte1, localleafaddr, arrayOfByte2, 0);
    return new AsymmetricCipherKeyPair(new SPHINCSPublicKeyParameters(arrayOfByte2), new SPHINCSPrivateKeyParameters(arrayOfByte1));
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.random = paramKeyGenerationParameters.getRandom();
    this.treeDigest = ((SPHINCS256KeyGenerationParameters)paramKeyGenerationParameters).getTreeDigest();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\sphincs\SPHINCS256KeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */