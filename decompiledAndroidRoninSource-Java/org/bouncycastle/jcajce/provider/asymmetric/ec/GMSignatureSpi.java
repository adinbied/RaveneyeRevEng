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
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.SM2Signer;
import org.bouncycastle.jcajce.provider.asymmetric.util.DSABase;
import org.bouncycastle.jcajce.provider.asymmetric.util.DSAEncoder;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.util.Arrays;

public class GMSignatureSpi
  extends DSABase
{
  GMSignatureSpi(Digest paramDigest, DSA paramDSA, DSAEncoder paramDSAEncoder)
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
  
  public static class sm3WithSM2
    extends GMSignatureSpi
  {
    public sm3WithSM2()
    {
      super(new SM2Signer(), new GMSignatureSpi.StdDSAEncoder(null));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\ec\GMSignatureSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */