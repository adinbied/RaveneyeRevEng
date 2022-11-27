package org.bouncycastle.jcajce.provider.asymmetric.dstu;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.GOST3411Digest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.DSTU4145Signer;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jce.interfaces.ECKey;

public class SignatureSpi
  extends java.security.SignatureSpi
  implements PKCSObjectIdentifiers, X509ObjectIdentifiers
{
  private static byte[] DEFAULT_SBOX = { 10, 9, 13, 6, 14, 11, 4, 5, 15, 1, 3, 12, 7, 0, 8, 2, 8, 0, 12, 4, 9, 6, 7, 11, 2, 3, 1, 15, 5, 14, 10, 13, 15, 6, 5, 8, 14, 11, 10, 4, 12, 0, 3, 7, 2, 9, 1, 13, 3, 8, 13, 9, 6, 11, 15, 0, 2, 5, 12, 10, 4, 14, 1, 7, 15, 8, 14, 9, 7, 2, 0, 13, 12, 6, 1, 5, 11, 4, 3, 10, 2, 8, 9, 7, 5, 15, 0, 11, 12, 1, 13, 14, 10, 3, 6, 4, 3, 8, 11, 5, 6, 4, 14, 10, 2, 12, 1, 7, 9, 15, 13, 0, 1, 2, 3, 14, 6, 13, 11, 8, 15, 10, 12, 5, 7, 9, 0, 4 };
  private Digest digest;
  private DSA signer = new DSTU4145Signer();
  
  protected Object engineGetParameter(String paramString)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected void engineInitSign(PrivateKey paramPrivateKey)
    throws InvalidKeyException
  {
    if ((paramPrivateKey instanceof ECKey)) {
      paramPrivateKey = ECUtil.generatePrivateKeyParameter(paramPrivateKey);
    } else {
      paramPrivateKey = null;
    }
    this.digest = new GOST3411Digest(DEFAULT_SBOX);
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
    Object localObject;
    if ((paramPublicKey instanceof BCDSTU4145PublicKey)) {
      localObject = ((BCDSTU4145PublicKey)paramPublicKey).engineGetKeyParameters();
    } else {
      localObject = ECUtil.generatePublicKeyParameter(paramPublicKey);
    }
    this.digest = new GOST3411Digest(expandSbox(((BCDSTU4145PublicKey)paramPublicKey).getSbox()));
    this.signer.init(false, (CipherParameters)localObject);
  }
  
  protected void engineSetParameter(String paramString, Object paramObject)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected void engineSetParameter(AlgorithmParameterSpec paramAlgorithmParameterSpec)
  {
    throw new UnsupportedOperationException("engineSetParameter unsupported");
  }
  
  protected byte[] engineSign()
    throws SignatureException
  {
    byte[] arrayOfByte1 = new byte[this.digest.getDigestSize()];
    this.digest.doFinal(arrayOfByte1, 0);
    for (;;)
    {
      int i;
      try
      {
        localObject = this.signer.generateSignature(arrayOfByte1);
        arrayOfByte1 = localObject[0].toByteArray();
        localObject = localObject[1].toByteArray();
        if (arrayOfByte1.length > localObject.length) {
          i = arrayOfByte1.length;
        } else {
          i = localObject.length;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        byte[] arrayOfByte2;
        throw new SignatureException(localException.toString());
      }
      arrayOfByte2 = new byte[i];
      System.arraycopy(localObject, 0, arrayOfByte2, i / 2 - localObject.length, localObject.length);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i - arrayOfByte1.length, arrayOfByte1.length);
      arrayOfByte1 = new DEROctetString(arrayOfByte2).getEncoded();
      return arrayOfByte1;
      i *= 2;
    }
  }
  
  protected void engineUpdate(byte paramByte)
    throws SignatureException
  {
    this.digest.update(paramByte);
  }
  
  protected void engineUpdate(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws SignatureException
  {
    this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  protected boolean engineVerify(byte[] paramArrayOfByte)
    throws SignatureException
  {
    byte[] arrayOfByte1 = new byte[this.digest.getDigestSize()];
    this.digest.doFinal(arrayOfByte1, 0);
    try
    {
      Object localObject = ((ASN1OctetString)ASN1OctetString.fromByteArray(paramArrayOfByte)).getOctets();
      paramArrayOfByte = new byte[localObject.length / 2];
      byte[] arrayOfByte2 = new byte[localObject.length / 2];
      System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length / 2);
      System.arraycopy(localObject, localObject.length / 2, paramArrayOfByte, 0, localObject.length / 2);
      localObject = new BigInteger[2];
      localObject[0] = new BigInteger(1, paramArrayOfByte);
      localObject[1] = new BigInteger(1, arrayOfByte2);
      return this.signer.verifySignature(arrayOfByte1, localObject[0], localObject[1]);
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new SignatureException("error decoding signature bytes.");
  }
  
  byte[] expandSbox(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[''];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = i * 2;
      arrayOfByte[j] = ((byte)(paramArrayOfByte[i] >> 4 & 0xF));
      arrayOfByte[(j + 1)] = ((byte)(paramArrayOfByte[i] & 0xF));
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\dstu\SignatureSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */