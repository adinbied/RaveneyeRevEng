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

public class McEliecePointchevalCipher
  implements MessageEncryptor
{
  public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.2.2";
  private boolean forEncryption;
  private int k;
  McElieceCCA2KeyParameters key;
  private Digest messDigest;
  private int n;
  private SecureRandom sr;
  private int t;
  
  protected int decryptOutputSize(int paramInt)
  {
    return 0;
  }
  
  protected int encryptOutputSize(int paramInt)
  {
    return 0;
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
    this.k = paramMcElieceCCA2PrivateKeyParameters.getK();
    this.t = paramMcElieceCCA2PrivateKeyParameters.getT();
  }
  
  public void initCipherEncrypt(McElieceCCA2PublicKeyParameters paramMcElieceCCA2PublicKeyParameters)
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
      byte[] arrayOfByte = localObject[0].getEncoded();
      localObject = localObject[1];
      DigestRandomGenerator localDigestRandomGenerator = new DigestRandomGenerator(new SHA1Digest());
      localDigestRandomGenerator.addSeedMaterial(arrayOfByte);
      arrayOfByte = new byte[j];
      localDigestRandomGenerator.nextBytes(arrayOfByte);
      i = 0;
      while (i < j)
      {
        arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte[i]));
        i += 1;
      }
      this.messDigest.update(arrayOfByte, 0, j);
      paramArrayOfByte = new byte[this.messDigest.getDigestSize()];
      this.messDigest.doFinal(paramArrayOfByte, 0);
      if (Conversions.encode(this.n, this.t, paramArrayOfByte).equals(localObject)) {
        return ByteUtils.split(arrayOfByte, j - (this.k >> 3))[0];
      }
      throw new InvalidCipherTextException("Bad Padding: Invalid ciphertext.");
    }
    throw new IllegalStateException("cipher initialised for decryption");
  }
  
  public byte[] messageEncrypt(byte[] paramArrayOfByte)
  {
    if (this.forEncryption)
    {
      int i1 = this.k >> 3;
      byte[] arrayOfByte1 = new byte[i1];
      this.sr.nextBytes(arrayOfByte1);
      Object localObject1 = new GF2Vector(this.k, this.sr);
      byte[] arrayOfByte2 = ((GF2Vector)localObject1).getEncoded();
      Object localObject2 = ByteUtils.concatenate(paramArrayOfByte, arrayOfByte1);
      Digest localDigest = this.messDigest;
      int i = localObject2.length;
      int m = 0;
      localDigest.update((byte[])localObject2, 0, i);
      localObject2 = new byte[this.messDigest.getDigestSize()];
      this.messDigest.doFinal((byte[])localObject2, 0);
      localObject2 = Conversions.encode(this.n, this.t, (byte[])localObject2);
      localObject1 = McElieceCCA2Primitives.encryptionPrimitive((McElieceCCA2PublicKeyParameters)this.key, (GF2Vector)localObject1, (GF2Vector)localObject2).getEncoded();
      localObject2 = new DigestRandomGenerator(new SHA1Digest());
      ((DigestRandomGenerator)localObject2).addSeedMaterial(arrayOfByte2);
      arrayOfByte2 = new byte[paramArrayOfByte.length + i1];
      ((DigestRandomGenerator)localObject2).nextBytes(arrayOfByte2);
      int j = 0;
      for (;;)
      {
        i = m;
        if (j >= paramArrayOfByte.length) {
          break;
        }
        arrayOfByte2[j] = ((byte)(arrayOfByte2[j] ^ paramArrayOfByte[j]));
        j += 1;
      }
      while (i < i1)
      {
        j = paramArrayOfByte.length + i;
        arrayOfByte2[j] = ((byte)(arrayOfByte2[j] ^ arrayOfByte1[i]));
        i += 1;
      }
      return ByteUtils.concatenate((byte[])localObject1, arrayOfByte2);
    }
    throw new IllegalStateException("cipher initialised for decryption");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McEliecePointchevalCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */