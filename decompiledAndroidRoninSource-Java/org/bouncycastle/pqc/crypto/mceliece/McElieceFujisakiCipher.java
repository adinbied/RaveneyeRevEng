package org.bouncycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.prng.DigestRandomGenerator;
import org.bouncycastle.pqc.crypto.MessageEncryptor;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;

public class McElieceFujisakiCipher
  implements MessageEncryptor
{
  private static final String DEFAULT_PRNG_NAME = "SHA1PRNG";
  public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.2.1";
  private boolean forEncryption;
  private int k;
  McElieceCCA2KeyParameters key;
  private Digest messDigest;
  private int n;
  private SecureRandom sr;
  private int t;
  
  private void initCipherEncrypt(McElieceCCA2PublicKeyParameters paramMcElieceCCA2PublicKeyParameters)
  {
    SecureRandom localSecureRandom = this.sr;
    if (localSecureRandom == null) {
      localSecureRandom = new SecureRandom();
    }
    this.sr = localSecureRandom;
    this.messDigest = Utils.getDigest(paramMcElieceCCA2PublicKeyParameters.getDigest());
    this.n = paramMcElieceCCA2PublicKeyParameters.getN();
    this.k = paramMcElieceCCA2PublicKeyParameters.getK();
    this.t = paramMcElieceCCA2PublicKeyParameters.getT();
  }
  
  public int getKeySize(McElieceCCA2KeyParameters paramMcElieceCCA2KeyParameters)
    throws IllegalArgumentException
  {
    if ((paramMcElieceCCA2KeyParameters instanceof McElieceCCA2PublicKeyParameters)) {
      return ((McElieceCCA2PublicKeyParameters)paramMcElieceCCA2KeyParameters).getN();
    }
    if ((paramMcElieceCCA2KeyParameters instanceof McElieceCCA2PrivateKeyParameters)) {
      return ((McElieceCCA2PrivateKeyParameters)paramMcElieceCCA2KeyParameters).getN();
    }
    throw new IllegalArgumentException("unsupported type");
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.forEncryption = paramBoolean;
    if (paramBoolean)
    {
      if ((paramCipherParameters instanceof ParametersWithRandom))
      {
        paramCipherParameters = (ParametersWithRandom)paramCipherParameters;
        this.sr = paramCipherParameters.getRandom();
        paramCipherParameters = (McElieceCCA2PublicKeyParameters)paramCipherParameters.getParameters();
        this.key = paramCipherParameters;
        initCipherEncrypt((McElieceCCA2PublicKeyParameters)paramCipherParameters);
        return;
      }
      this.sr = new SecureRandom();
      paramCipherParameters = (McElieceCCA2PublicKeyParameters)paramCipherParameters;
      this.key = paramCipherParameters;
      initCipherEncrypt((McElieceCCA2PublicKeyParameters)paramCipherParameters);
      return;
    }
    paramCipherParameters = (McElieceCCA2PrivateKeyParameters)paramCipherParameters;
    this.key = paramCipherParameters;
    initCipherDecrypt((McElieceCCA2PrivateKeyParameters)paramCipherParameters);
  }
  
  public void initCipherDecrypt(McElieceCCA2PrivateKeyParameters paramMcElieceCCA2PrivateKeyParameters)
  {
    this.messDigest = Utils.getDigest(paramMcElieceCCA2PrivateKeyParameters.getDigest());
    this.n = paramMcElieceCCA2PrivateKeyParameters.getN();
    this.t = paramMcElieceCCA2PrivateKeyParameters.getT();
  }
  
  public byte[] messageDecrypt(byte[] paramArrayOfByte)
    throws InvalidCipherTextException
  {
    if (!this.forEncryption)
    {
      int i = this.n + 7 >> 3;
      int j = paramArrayOfByte.length - i;
      paramArrayOfByte = ByteUtils.split(paramArrayOfByte, i);
      byte b = paramArrayOfByte[0];
      paramArrayOfByte = paramArrayOfByte[1];
      Object localObject = GF2Vector.OS2VP(this.n, b);
      localObject = McElieceCCA2Primitives.decryptionPrimitive((McElieceCCA2PrivateKeyParameters)this.key, (GF2Vector)localObject);
      byte[] arrayOfByte2 = localObject[0].getEncoded();
      localObject = localObject[1];
      DigestRandomGenerator localDigestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
      localDigestRandomGenerator.addSeedMaterial(arrayOfByte2);
      byte[] arrayOfByte1 = new byte[j];
      localDigestRandomGenerator.nextBytes(arrayOfByte1);
      i = 0;
      while (i < j)
      {
        arrayOfByte1[i] = ((byte)(arrayOfByte1[i] ^ paramArrayOfByte[i]));
        i += 1;
      }
      paramArrayOfByte = ByteUtils.concatenate(arrayOfByte2, arrayOfByte1);
      arrayOfByte2 = new byte[this.messDigest.getDigestSize()];
      this.messDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      this.messDigest.doFinal(arrayOfByte2, 0);
      if (Conversions.encode(this.n, this.t, arrayOfByte2).equals(localObject)) {
        return arrayOfByte1;
      }
      throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
    }
    throw new IllegalStateException("cipher initialised for decryption");
  }
  
  public byte[] messageEncrypt(byte[] paramArrayOfByte)
  {
    if (this.forEncryption)
    {
      Object localObject1 = new GF2Vector(this.k, this.sr);
      byte[] arrayOfByte = ((GF2Vector)localObject1).getEncoded();
      Object localObject2 = ByteUtils.concatenate(arrayOfByte, paramArrayOfByte);
      Digest localDigest = this.messDigest;
      int j = localObject2.length;
      int i = 0;
      localDigest.update((byte[])localObject2, 0, j);
      localObject2 = new byte[this.messDigest.getDigestSize()];
      this.messDigest.doFinal((byte[])localObject2, 0);
      localObject2 = Conversions.encode(this.n, this.t, (byte[])localObject2);
      localObject1 = McElieceCCA2Primitives.encryptionPrimitive((McElieceCCA2PublicKeyParameters)this.key, (GF2Vector)localObject1, (GF2Vector)localObject2).getEncoded();
      localObject2 = new DigestRandomGenerator(new SHA1Digest());
      ((DigestRandomGenerator)localObject2).addSeedMaterial(arrayOfByte);
      arrayOfByte = new byte[paramArrayOfByte.length];
      ((DigestRandomGenerator)localObject2).nextBytes(arrayOfByte);
      while (i < paramArrayOfByte.length)
      {
        arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte[i]));
        i += 1;
      }
      return ByteUtils.concatenate((byte[])localObject1, arrayOfByte);
    }
    throw new IllegalStateException("cipher initialised for decryption");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McElieceFujisakiCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */