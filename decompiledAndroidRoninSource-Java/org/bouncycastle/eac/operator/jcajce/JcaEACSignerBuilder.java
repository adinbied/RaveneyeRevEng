package org.bouncycastle.eac.operator.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
import org.bouncycastle.eac.operator.EACSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OperatorStreamException;
import org.bouncycastle.operator.RuntimeOperatorException;

public class JcaEACSignerBuilder
{
  private static final Hashtable sigNames;
  private EACHelper helper = new DefaultEACHelper();
  
  static
  {
    Hashtable localHashtable = new Hashtable();
    sigNames = localHashtable;
    localHashtable.put("SHA1withRSA", EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_1);
    sigNames.put("SHA256withRSA", EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_256);
    sigNames.put("SHA1withRSAandMGF1", EACObjectIdentifiers.id_TA_RSA_PSS_SHA_1);
    sigNames.put("SHA256withRSAandMGF1", EACObjectIdentifiers.id_TA_RSA_PSS_SHA_256);
    sigNames.put("SHA512withRSA", EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_512);
    sigNames.put("SHA512withRSAandMGF1", EACObjectIdentifiers.id_TA_RSA_PSS_SHA_512);
    sigNames.put("SHA1withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_1);
    sigNames.put("SHA224withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_224);
    sigNames.put("SHA256withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_256);
    sigNames.put("SHA384withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_384);
    sigNames.put("SHA512withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_512);
  }
  
  private static void copyUnsignedInt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    int k = paramArrayOfByte1.length;
    int j = 0;
    int i = k;
    if (paramArrayOfByte1[0] == 0)
    {
      i = k - 1;
      j = 1;
    }
    System.arraycopy(paramArrayOfByte1, j, paramArrayOfByte2, paramInt, i);
  }
  
  public static int max(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  private static byte[] reencode(byte[] paramArrayOfByte)
  {
    Object localObject = ASN1Sequence.getInstance(paramArrayOfByte);
    paramArrayOfByte = ASN1Integer.getInstance(((ASN1Sequence)localObject).getObjectAt(0)).getValue();
    localObject = ASN1Integer.getInstance(((ASN1Sequence)localObject).getObjectAt(1)).getValue();
    paramArrayOfByte = paramArrayOfByte.toByteArray();
    localObject = ((BigInteger)localObject).toByteArray();
    int i = unsignedIntLength(paramArrayOfByte);
    int j = unsignedIntLength((byte[])localObject);
    int k = max(i, j);
    int m = k * 2;
    byte[] arrayOfByte = new byte[m];
    Arrays.fill(arrayOfByte, (byte)0);
    copyUnsignedInt(paramArrayOfByte, arrayOfByte, k - i);
    copyUnsignedInt((byte[])localObject, arrayOfByte, m - j);
    return arrayOfByte;
  }
  
  private static int unsignedIntLength(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    int i = j;
    if (paramArrayOfByte[0] == 0) {
      i = j - 1;
    }
    return i;
  }
  
  public EACSigner build(String paramString, PrivateKey paramPrivateKey)
    throws OperatorCreationException
  {
    return build((ASN1ObjectIdentifier)sigNames.get(paramString), paramPrivateKey);
  }
  
  public EACSigner build(final ASN1ObjectIdentifier paramASN1ObjectIdentifier, PrivateKey paramPrivateKey)
    throws OperatorCreationException
  {
    try
    {
      Signature localSignature = this.helper.getSignature(paramASN1ObjectIdentifier);
      localSignature.initSign(paramPrivateKey);
      new EACSigner()
      {
        public OutputStream getOutputStream()
        {
          return this.val$sigStream;
        }
        
        public byte[] getSignature()
        {
          try
          {
            localObject2 = this.val$sigStream.getSignature();
            Object localObject1 = localObject2;
            if (paramASN1ObjectIdentifier.on(EACObjectIdentifiers.id_TA_ECDSA)) {
              localObject1 = JcaEACSignerBuilder.reencode((byte[])localObject2);
            }
            return (byte[])localObject1;
          }
          catch (SignatureException localSignatureException)
          {
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("exception obtaining signature: ");
            ((StringBuilder)localObject2).append(localSignatureException.getMessage());
            throw new RuntimeOperatorException(((StringBuilder)localObject2).toString(), localSignatureException);
          }
        }
        
        public ASN1ObjectIdentifier getUsageIdentifier()
        {
          return paramASN1ObjectIdentifier;
        }
      };
    }
    catch (InvalidKeyException paramASN1ObjectIdentifier)
    {
      paramPrivateKey = new StringBuilder();
      paramPrivateKey.append("invalid key: ");
      paramPrivateKey.append(paramASN1ObjectIdentifier.getMessage());
      throw new OperatorCreationException(paramPrivateKey.toString(), paramASN1ObjectIdentifier);
    }
    catch (NoSuchProviderException paramASN1ObjectIdentifier)
    {
      paramPrivateKey = new StringBuilder();
      paramPrivateKey.append("unable to find provider: ");
      paramPrivateKey.append(paramASN1ObjectIdentifier.getMessage());
      throw new OperatorCreationException(paramPrivateKey.toString(), paramASN1ObjectIdentifier);
    }
    catch (NoSuchAlgorithmException paramASN1ObjectIdentifier)
    {
      paramPrivateKey = new StringBuilder();
      paramPrivateKey.append("unable to find algorithm: ");
      paramPrivateKey.append(paramASN1ObjectIdentifier.getMessage());
      throw new OperatorCreationException(paramPrivateKey.toString(), paramASN1ObjectIdentifier);
    }
  }
  
  public JcaEACSignerBuilder setProvider(String paramString)
  {
    this.helper = new NamedEACHelper(paramString);
    return this;
  }
  
  public JcaEACSignerBuilder setProvider(Provider paramProvider)
  {
    this.helper = new ProviderEACHelper(paramProvider);
    return this;
  }
  
  private class SignatureOutputStream
    extends OutputStream
  {
    private Signature sig;
    
    SignatureOutputStream(Signature paramSignature)
    {
      this.sig = paramSignature;
    }
    
    byte[] getSignature()
      throws SignatureException
    {
      return this.sig.sign();
    }
    
    public void write(int paramInt)
      throws IOException
    {
      try
      {
        this.sig.update((byte)paramInt);
        return;
      }
      catch (SignatureException localSignatureException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception in content signer: ");
        localStringBuilder.append(localSignatureException.getMessage());
        throw new OperatorStreamException(localStringBuilder.toString(), localSignatureException);
      }
    }
    
    public void write(byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        this.sig.update(paramArrayOfByte);
        return;
      }
      catch (SignatureException paramArrayOfByte)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception in content signer: ");
        localStringBuilder.append(paramArrayOfByte.getMessage());
        throw new OperatorStreamException(localStringBuilder.toString(), paramArrayOfByte);
      }
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      try
      {
        this.sig.update(paramArrayOfByte, paramInt1, paramInt2);
        return;
      }
      catch (SignatureException paramArrayOfByte)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception in content signer: ");
        localStringBuilder.append(paramArrayOfByte.getMessage());
        throw new OperatorStreamException(localStringBuilder.toString(), paramArrayOfByte);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\eac\operator\jcajce\JcaEACSignerBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */