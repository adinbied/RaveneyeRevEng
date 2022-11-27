package org.bouncycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.MessageEncryptor;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;
import org.bouncycastle.pqc.math.linearalgebra.GF2Vector;
import org.bouncycastle.pqc.math.linearalgebra.GF2mField;
import org.bouncycastle.pqc.math.linearalgebra.GoppaCode;
import org.bouncycastle.pqc.math.linearalgebra.Permutation;
import org.bouncycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;
import org.bouncycastle.pqc.math.linearalgebra.Vector;

public class McElieceCipher
  implements MessageEncryptor
{
  public static final String OID = "1.3.6.1.4.1.8301.3.1.3.4.1";
  public int cipherTextSize;
  private boolean forEncryption;
  private int k;
  private McElieceKeyParameters key;
  public int maxPlainTextSize;
  private int n;
  private SecureRandom sr;
  private int t;
  
  private byte[] computeMessage(GF2Vector paramGF2Vector)
    throws InvalidCipherTextException
  {
    paramGF2Vector = paramGF2Vector.getEncoded();
    int i = paramGF2Vector.length - 1;
    while ((i >= 0) && (paramGF2Vector[i] == 0)) {
      i -= 1;
    }
    if ((i >= 0) && (paramGF2Vector[i] == 1))
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramGF2Vector, 0, arrayOfByte, 0, i);
      return arrayOfByte;
    }
    throw new InvalidCipherTextException("Bad Padding: invalid ciphertext");
  }
  
  private GF2Vector computeMessageRepresentative(byte[] paramArrayOfByte)
  {
    int j = this.maxPlainTextSize;
    int i;
    if ((this.k & 0x7) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    byte[] arrayOfByte = new byte[j + i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    arrayOfByte[paramArrayOfByte.length] = 1;
    return GF2Vector.OS2VP(this.k, arrayOfByte);
  }
  
  public int getKeySize(McElieceKeyParameters paramMcElieceKeyParameters)
  {
    if ((paramMcElieceKeyParameters instanceof McEliecePublicKeyParameters)) {
      return ((McEliecePublicKeyParameters)paramMcElieceKeyParameters).getN();
    }
    if ((paramMcElieceKeyParameters instanceof McEliecePrivateKeyParameters)) {
      return ((McEliecePrivateKeyParameters)paramMcElieceKeyParameters).getN();
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
        paramCipherParameters = (McEliecePublicKeyParameters)paramCipherParameters.getParameters();
        this.key = paramCipherParameters;
        initCipherEncrypt((McEliecePublicKeyParameters)paramCipherParameters);
        return;
      }
      this.sr = new SecureRandom();
      paramCipherParameters = (McEliecePublicKeyParameters)paramCipherParameters;
      this.key = paramCipherParameters;
      initCipherEncrypt((McEliecePublicKeyParameters)paramCipherParameters);
      return;
    }
    paramCipherParameters = (McEliecePrivateKeyParameters)paramCipherParameters;
    this.key = paramCipherParameters;
    initCipherDecrypt((McEliecePrivateKeyParameters)paramCipherParameters);
  }
  
  public void initCipherDecrypt(McEliecePrivateKeyParameters paramMcEliecePrivateKeyParameters)
  {
    this.n = paramMcEliecePrivateKeyParameters.getN();
    int i = paramMcEliecePrivateKeyParameters.getK();
    this.k = i;
    this.maxPlainTextSize = (i >> 3);
    this.cipherTextSize = (this.n >> 3);
  }
  
  public void initCipherEncrypt(McEliecePublicKeyParameters paramMcEliecePublicKeyParameters)
  {
    SecureRandom localSecureRandom = this.sr;
    if (localSecureRandom == null) {
      localSecureRandom = new SecureRandom();
    }
    this.sr = localSecureRandom;
    this.n = paramMcEliecePublicKeyParameters.getN();
    this.k = paramMcEliecePublicKeyParameters.getK();
    this.t = paramMcEliecePublicKeyParameters.getT();
    this.cipherTextSize = (this.n >> 3);
    this.maxPlainTextSize = (this.k >> 3);
  }
  
  public byte[] messageDecrypt(byte[] paramArrayOfByte)
    throws InvalidCipherTextException
  {
    if (!this.forEncryption)
    {
      GF2Vector localGF2Vector = GF2Vector.OS2VP(this.n, paramArrayOfByte);
      Object localObject3 = (McEliecePrivateKeyParameters)this.key;
      Object localObject2 = ((McEliecePrivateKeyParameters)localObject3).getField();
      PolynomialGF2mSmallM localPolynomialGF2mSmallM = ((McEliecePrivateKeyParameters)localObject3).getGoppaPoly();
      paramArrayOfByte = ((McEliecePrivateKeyParameters)localObject3).getSInv();
      Object localObject1 = ((McEliecePrivateKeyParameters)localObject3).getP1();
      Permutation localPermutation = ((McEliecePrivateKeyParameters)localObject3).getP2();
      GF2Matrix localGF2Matrix = ((McEliecePrivateKeyParameters)localObject3).getH();
      localObject3 = ((McEliecePrivateKeyParameters)localObject3).getQInv();
      localPermutation = ((Permutation)localObject1).rightMultiply(localPermutation);
      localGF2Vector = (GF2Vector)localGF2Vector.multiply(localPermutation.computeInverse());
      localObject2 = GoppaCode.syndromeDecode((GF2Vector)localGF2Matrix.rightMultiply(localGF2Vector), (GF2mField)localObject2, localPolynomialGF2mSmallM, (PolynomialGF2mSmallM[])localObject3);
      localObject1 = (GF2Vector)((GF2Vector)localGF2Vector.add((Vector)localObject2)).multiply((Permutation)localObject1);
      localObject2 = (GF2Vector)((GF2Vector)localObject2).multiply(localPermutation);
      return computeMessage((GF2Vector)paramArrayOfByte.leftMultiply(((GF2Vector)localObject1).extractRightVector(this.k)));
    }
    throw new IllegalStateException("cipher initialised for decryption");
  }
  
  public byte[] messageEncrypt(byte[] paramArrayOfByte)
  {
    if (this.forEncryption)
    {
      paramArrayOfByte = computeMessageRepresentative(paramArrayOfByte);
      GF2Vector localGF2Vector = new GF2Vector(this.n, this.t, this.sr);
      return ((GF2Vector)((McEliecePublicKeyParameters)this.key).getG().leftMultiply(paramArrayOfByte).add(localGF2Vector)).getEncoded();
    }
    throw new IllegalStateException("cipher initialised for decryption");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McElieceCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */