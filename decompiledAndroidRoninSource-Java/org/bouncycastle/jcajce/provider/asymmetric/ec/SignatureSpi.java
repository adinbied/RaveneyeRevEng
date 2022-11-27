package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.ECDSASigner;
import org.bouncycastle.crypto.signers.ECNRSigner;
import org.bouncycastle.crypto.signers.HMacDSAKCalculator;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.jcajce.provider.asymmetric.util.DSABase;
import org.bouncycastle.jcajce.provider.asymmetric.util.DSAEncoder;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.util.Arrays;

public class SignatureSpi
  extends DSABase
{
  SignatureSpi(Digest paramDigest, DSA paramDSA, DSAEncoder paramDSAEncoder)
  {
    super(paramDigest, paramDSA, paramDSAEncoder);
  }
  
  protected void engineInitSign(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    paramPrivateKey = ECUtil.generatePrivateKeyParameter(paramPrivateKey);
    this.digest.reset();
    if (this.appRandom != null)
    {
      this.signer.init(true, new ParametersWithRandom(paramPrivateKey, this.appRandom));
      return;
    }
    this.signer.init(true, paramPrivateKey);
  }
  
  protected void engineInitVerify(PublicKey paramPublicKey)
    throws InvalidKeyException
  {
    paramPublicKey = ECUtils.generatePublicKeyParameter(paramPublicKey);
    this.digest.reset();
    this.signer.init(false, paramPublicKey);
  }
  
  private static class PlainDSAEncoder
    implements DSAEncoder
  {
    private byte[] makeUnsigned(BigInteger paramBigInteger)
    {
      paramBigInteger = paramBigInteger.toByteArray();
      if (paramBigInteger[0] == 0)
      {
        int i = paramBigInteger.length - 1;
        byte[] arrayOfByte = new byte[i];
        System.arraycopy(paramBigInteger, 1, arrayOfByte, 0, i);
        return arrayOfByte;
      }
      return paramBigInteger;
    }
    
    public BigInteger[] decode(byte[] paramArrayOfByte)
      throws IOException
    {
      int i = paramArrayOfByte.length / 2;
      byte[] arrayOfByte1 = new byte[i];
      int j = paramArrayOfByte.length / 2;
      byte[] arrayOfByte2 = new byte[j];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, i);
      System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, j);
      return new BigInteger[] { new BigInteger(1, arrayOfByte1), new BigInteger(1, arrayOfByte2) };
    }
    
    public byte[] encode(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
      throws IOException
    {
      paramBigInteger1 = makeUnsigned(paramBigInteger1);
      paramBigInteger2 = makeUnsigned(paramBigInteger2);
      int i;
      if (paramBigInteger1.length > paramBigInteger2.length) {
        i = paramBigInteger1.length;
      } else {
        i = paramBigInteger2.length;
      }
      byte[] arrayOfByte = new byte[i * 2];
      System.arraycopy(paramBigInteger1, 0, arrayOfByte, arrayOfByte.length / 2 - paramBigInteger1.length, paramBigInteger1.length);
      System.arraycopy(paramBigInteger2, 0, arrayOfByte, arrayOfByte.length - paramBigInteger2.length, paramBigInteger2.length);
      return arrayOfByte;
    }
  }
  
  private static class StdDSAEncoder
    implements DSAEncoder
  {
    public BigInteger[] decode(byte[] paramArrayOfByte)
      throws IOException
    {
      ASN1Sequence localASN1Sequence = (ASN1Sequence)ASN1Primitive.fromByteArray(paramArrayOfByte);
      if (localASN1Sequence.size() == 2)
      {
        if (Arrays.areEqual(paramArrayOfByte, localASN1Sequence.getEncoded("DER"))) {
          return new BigInteger[] { ASN1Integer.getInstance(localASN1Sequence.getObjectAt(0)).getValue(), ASN1Integer.getInstance(localASN1Sequence.getObjectAt(1)).getValue() };
        }
        throw new IOException("malformed signature");
      }
      throw new IOException("malformed signature");
    }
    
    public byte[] encode(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
      throws IOException
    {
      ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
      localASN1EncodableVector.add(new ASN1Integer(paramBigInteger1));
      localASN1EncodableVector.add(new ASN1Integer(paramBigInteger2));
      return new DERSequence(localASN1EncodableVector).getEncoded("DER");
    }
  }
  
  public static class ecCVCDSA
    extends SignatureSpi
  {
    public ecCVCDSA()
    {
      super(new ECDSASigner(), new SignatureSpi.PlainDSAEncoder(null));
    }
  }
  
  public static class ecCVCDSA224
    extends SignatureSpi
  {
    public ecCVCDSA224()
    {
      super(new ECDSASigner(), new SignatureSpi.PlainDSAEncoder(null));
    }
  }
  
  public static class ecCVCDSA256
    extends SignatureSpi
  {
    public ecCVCDSA256()
    {
      super(new ECDSASigner(), new SignatureSpi.PlainDSAEncoder(null));
    }
  }
  
  public static class ecCVCDSA384
    extends SignatureSpi
  {
    public ecCVCDSA384()
    {
      super(new ECDSASigner(), new SignatureSpi.PlainDSAEncoder(null));
    }
  }
  
  public static class ecCVCDSA512
    extends SignatureSpi
  {
    public ecCVCDSA512()
    {
      super(new ECDSASigner(), new SignatureSpi.PlainDSAEncoder(null));
    }
  }
  
  public static class ecDSA
    extends SignatureSpi
  {
    public ecDSA()
    {
      super(new ECDSASigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDSA224
    extends SignatureSpi
  {
    public ecDSA224()
    {
      super(new ECDSASigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDSA256
    extends SignatureSpi
  {
    public ecDSA256()
    {
      super(new ECDSASigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDSA384
    extends SignatureSpi
  {
    public ecDSA384()
    {
      super(new ECDSASigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDSA512
    extends SignatureSpi
  {
    public ecDSA512()
    {
      super(new ECDSASigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDSARipeMD160
    extends SignatureSpi
  {
    public ecDSARipeMD160()
    {
      super(new ECDSASigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDSASha3_224
    extends SignatureSpi
  {
    public ecDSASha3_224()
    {
      super(new ECDSASigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDSASha3_256
    extends SignatureSpi
  {
    public ecDSASha3_256()
    {
      super(new ECDSASigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDSASha3_384
    extends SignatureSpi
  {
    public ecDSASha3_384()
    {
      super(new ECDSASigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDSASha3_512
    extends SignatureSpi
  {
    public ecDSASha3_512()
    {
      super(new ECDSASigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDSAnone
    extends SignatureSpi
  {
    public ecDSAnone()
    {
      super(new ECDSASigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDetDSA
    extends SignatureSpi
  {
    public ecDetDSA()
    {
      super(new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA1())), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDetDSA224
    extends SignatureSpi
  {
    public ecDetDSA224()
    {
      super(new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA224())), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDetDSA256
    extends SignatureSpi
  {
    public ecDetDSA256()
    {
      super(new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA256())), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDetDSA384
    extends SignatureSpi
  {
    public ecDetDSA384()
    {
      super(new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA384())), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDetDSA512
    extends SignatureSpi
  {
    public ecDetDSA512()
    {
      super(new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA512())), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDetDSASha3_224
    extends SignatureSpi
  {
    public ecDetDSASha3_224()
    {
      super(new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_224())), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDetDSASha3_256
    extends SignatureSpi
  {
    public ecDetDSASha3_256()
    {
      super(new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_256())), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDetDSASha3_384
    extends SignatureSpi
  {
    public ecDetDSASha3_384()
    {
      super(new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_384())), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecDetDSASha3_512
    extends SignatureSpi
  {
    public ecDetDSASha3_512()
    {
      super(new ECDSASigner(new HMacDSAKCalculator(DigestFactory.createSHA3_512())), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecNR
    extends SignatureSpi
  {
    public ecNR()
    {
      super(new ECNRSigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecNR224
    extends SignatureSpi
  {
    public ecNR224()
    {
      super(new ECNRSigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecNR256
    extends SignatureSpi
  {
    public ecNR256()
    {
      super(new ECNRSigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecNR384
    extends SignatureSpi
  {
    public ecNR384()
    {
      super(new ECNRSigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecNR512
    extends SignatureSpi
  {
    public ecNR512()
    {
      super(new ECNRSigner(), new SignatureSpi.StdDSAEncoder(null));
    }
  }
  
  public static class ecPlainDSARP160
    extends SignatureSpi
  {
    public ecPlainDSARP160()
    {
      super(new ECDSASigner(), new SignatureSpi.PlainDSAEncoder(null));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ec\SignatureSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */