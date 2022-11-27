package org.bouncycastle.pqc.jcajce.provider.sphincs;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHA512tDigest;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCS256KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCS256KeyPairGenerator;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPublicKeyParameters;
import org.bouncycastle.pqc.jcajce.spec.SPHINCS256KeyGenParameterSpec;

public class Sphincs256KeyPairGeneratorSpi
  extends KeyPairGenerator
{
  SPHINCS256KeyPairGenerator engine = new SPHINCS256KeyPairGenerator();
  boolean initialised = false;
  SPHINCS256KeyGenerationParameters param;
  SecureRandom random = new SecureRandom();
  ASN1ObjectIdentifier treeDigest = NISTObjectIdentifiers.id_sha512_256;
  
  public Sphincs256KeyPairGeneratorSpi()
  {
    super("SPHINCS256");
  }
  
  public KeyPair generateKeyPair()
  {
    if (!this.initialised)
    {
      localObject1 = new SPHINCS256KeyGenerationParameters(this.random, new SHA512tDigest(256));
      this.param = ((SPHINCS256KeyGenerationParameters)localObject1);
      this.engine.init((KeyGenerationParameters)localObject1);
      this.initialised = true;
    }
    Object localObject2 = this.engine.generateKeyPair();
    Object localObject1 = (SPHINCSPublicKeyParameters)((AsymmetricCipherKeyPair)localObject2).getPublic();
    localObject2 = (SPHINCSPrivateKeyParameters)((AsymmetricCipherKeyPair)localObject2).getPrivate();
    return new KeyPair(new BCSphincs256PublicKey(this.treeDigest, (SPHINCSPublicKeyParameters)localObject1), new BCSphincs256PrivateKey(this.treeDigest, (SPHINCSPrivateKeyParameters)localObject2));
  }
  
  public void initialize(int paramInt, SecureRandom paramSecureRandom)
  {
    throw new IllegalArgumentException("use AlgorithmParameterSpec");
  }
  
  public void initialize(AlgorithmParameterSpec paramAlgorithmParameterSpec, SecureRandom paramSecureRandom)
    throws InvalidAlgorithmParameterException
  {
    if ((paramAlgorithmParameterSpec instanceof SPHINCS256KeyGenParameterSpec))
    {
      paramAlgorithmParameterSpec = (SPHINCS256KeyGenParameterSpec)paramAlgorithmParameterSpec;
      if (paramAlgorithmParameterSpec.getTreeDigest().equals("SHA512-256")) {
        this.treeDigest = NISTObjectIdentifiers.id_sha512_256;
      }
      for (paramAlgorithmParameterSpec = new SPHINCS256KeyGenerationParameters(paramSecureRandom, new SHA512tDigest(256));; paramAlgorithmParameterSpec = new SPHINCS256KeyGenerationParameters(paramSecureRandom, new SHA3Digest(256)))
      {
        this.param = paramAlgorithmParameterSpec;
        break;
        if (!paramAlgorithmParameterSpec.getTreeDigest().equals("SHA3-256")) {
          break;
        }
        this.treeDigest = NISTObjectIdentifiers.id_sha3_256;
      }
      this.engine.init(this.param);
      this.initialised = true;
      return;
    }
    throw new InvalidAlgorithmParameterException("parameter object not a SPHINCS256KeyGenParameterSpec");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\provider\sphincs\Sphincs256KeyPairGeneratorSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */