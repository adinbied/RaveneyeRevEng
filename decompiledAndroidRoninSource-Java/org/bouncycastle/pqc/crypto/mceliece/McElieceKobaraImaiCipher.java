package org.bouncycastle.pqc.crypto.mceliece;

import java.math.BigInteger;
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
import org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions;

public class McElieceKobaraImaiCipher
  implements MessageEncryptor
{
  private static final String DEFAULT_PRNG_NAME = "SHA1PRNG";
  public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.2.3";
  public static final byte[] PUBLIC_CONSTANT = "a predetermined public constant".getBytes();
  private boolean forEncryption;
  private int k;
  McElieceCCA2KeyParameters key;
  private Digest messDigest;
  private int n;
  private SecureRandom sr;
  private int t;
  
  private void initCipherEncrypt(McElieceCCA2PublicKeyParameters paramMcElieceCCA2PublicKeyParameters)
  {
    this.messDigest = Utils.getDigest(paramMcElieceCCA2PublicKeyParameters.getDigest());
    this.n = paramMcElieceCCA2PublicKeyParameters.getN();
    this.k = paramMcElieceCCA2PublicKeyParameters.getK();
    this.t = paramMcElieceCCA2PublicKeyParameters.getT();
  }
  
  public int getKeySize(McElieceCCA2KeyParameters paramMcElieceCCA2KeyParameters)
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
  
  public byte[] messageDecrypt(byte[] paramArrayOfByte)
    throws InvalidCipherTextException
  {
    if (!this.forEncryption)
    {
      int m = this.n >> 3;
      if (paramArrayOfByte.length >= m)
      {
        int i = this.messDigest.getDigestSize();
        int j = this.k >> 3;
        m = paramArrayOfByte.length - m;
        if (m > 0)
        {
          localObject = ByteUtils.split(paramArrayOfByte, m);
          paramArrayOfByte = localObject[0];
          localObject = localObject[1];
        }
        else
        {
          arrayOfByte = new byte[0];
          localObject = paramArrayOfByte;
          paramArrayOfByte = arrayOfByte;
        }
        Object localObject = GF2Vector.OS2VP(this.n, (byte[])localObject);
        localObject = McElieceCCA2Primitives.decryptionPrimitive((McElieceCCA2PrivateKeyParameters)this.key, (GF2Vector)localObject);
        byte[] arrayOfByte = localObject[0].getEncoded();
        GF2Vector localGF2Vector = localObject[1];
        localObject = arrayOfByte;
        if (arrayOfByte.length > j) {
          localObject = ByteUtils.subArray(arrayOfByte, 0, j);
        }
        paramArrayOfByte = ByteUtils.concatenate(ByteUtils.concatenate(paramArrayOfByte, Conversions.decode(this.n, this.t, localGF2Vector)), (byte[])localObject);
        j = paramArrayOfByte.length - i;
        paramArrayOfByte = ByteUtils.split(paramArrayOfByte, i);
        localObject = paramArrayOfByte[0];
        paramArrayOfByte = paramArrayOfByte[1];
        arrayOfByte = new byte[this.messDigest.getDigestSize()];
        this.messDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
        this.messDigest.doFinal(arrayOfByte, 0);
        i -= 1;
        while (i >= 0)
        {
          arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ localObject[i]));
          i -= 1;
        }
        localObject = new DigestRandomGenerator(new SHA1Digest());
        ((DigestRandomGenerator)localObject).addSeedMaterial(arrayOfByte);
        arrayOfByte = new byte[j];
        ((DigestRandomGenerator)localObject).nextBytes(arrayOfByte);
        i = j - 1;
        while (i >= 0)
        {
          arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte[i]));
          i -= 1;
        }
        paramArrayOfByte = ByteUtils.split(arrayOfByte, j - PUBLIC_CONSTANT.length);
        localObject = paramArrayOfByte[0];
        if (ByteUtils.equals(paramArrayOfByte[1], PUBLIC_CONSTANT)) {
          return (byte[])localObject;
        }
        throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
      }
      throw new InvalidCipherTextException("Bad Padding: Ciphertext too short.");
    }
    throw new IllegalStateException("cipher initialised for decryption");
  }
  
  public byte[] messageEncrypt(byte[] paramArrayOfByte)
  {
    if (this.forEncryption)
    {
      int i2 = this.messDigest.getDigestSize();
      int m = this.k >> 3;
      int i1 = IntegerFunctions.binomial(this.n, this.t).bitLength() - 1 >> 3;
      int j = m + i1 - i2 - PUBLIC_CONSTANT.length;
      int i = j;
      if (paramArrayOfByte.length > j) {
        i = paramArrayOfByte.length;
      }
      int i3 = PUBLIC_CONSTANT.length + i;
      j = i3 + i2 - m - i1;
      Object localObject1 = new byte[i3];
      System.arraycopy(paramArrayOfByte, 0, localObject1, 0, paramArrayOfByte.length);
      paramArrayOfByte = PUBLIC_CONSTANT;
      System.arraycopy(paramArrayOfByte, 0, localObject1, i, paramArrayOfByte.length);
      paramArrayOfByte = new byte[i2];
      this.sr.nextBytes(paramArrayOfByte);
      Object localObject3 = new DigestRandomGenerator(new SHA1Digest());
      ((DigestRandomGenerator)localObject3).addSeedMaterial(paramArrayOfByte);
      Object localObject2 = new byte[i3];
      ((DigestRandomGenerator)localObject3).nextBytes((byte[])localObject2);
      i = i3 - 1;
      while (i >= 0)
      {
        localObject2[i] = ((byte)(localObject2[i] ^ localObject1[i]));
        i -= 1;
      }
      localObject1 = new byte[this.messDigest.getDigestSize()];
      this.messDigest.update((byte[])localObject2, 0, i3);
      this.messDigest.doFinal((byte[])localObject1, 0);
      i = i2 - 1;
      while (i >= 0)
      {
        localObject1[i] = ((byte)(localObject1[i] ^ paramArrayOfByte[i]));
        i -= 1;
      }
      localObject1 = ByteUtils.concatenate((byte[])localObject1, (byte[])localObject2);
      paramArrayOfByte = new byte[0];
      if (j > 0)
      {
        paramArrayOfByte = new byte[j];
        System.arraycopy(localObject1, 0, paramArrayOfByte, 0, j);
      }
      localObject2 = new byte[i1];
      System.arraycopy(localObject1, j, localObject2, 0, i1);
      localObject3 = new byte[m];
      System.arraycopy(localObject1, i1 + j, localObject3, 0, m);
      localObject1 = GF2Vector.OS2VP(this.k, (byte[])localObject3);
      localObject2 = Conversions.encode(this.n, this.t, (byte[])localObject2);
      localObject2 = McElieceCCA2Primitives.encryptionPrimitive((McElieceCCA2PublicKeyParameters)this.key, (GF2Vector)localObject1, (GF2Vector)localObject2).getEncoded();
      localObject1 = localObject2;
      if (j > 0) {
        localObject1 = ByteUtils.concatenate(paramArrayOfByte, (byte[])localObject2);
      }
      return (byte[])localObject1;
    }
    throw new IllegalStateException("cipher initialised for decryption");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McElieceKobaraImaiCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */