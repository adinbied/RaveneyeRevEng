package org.bouncycastle.eac.operator.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.eac.EACObjectIdentifiers;
import org.bouncycastle.eac.operator.EACSignatureVerifier;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OperatorStreamException;
import org.bouncycastle.operator.RuntimeOperatorException;

public class JcaEACSignatureVerifierBuilder
{
  private EACHelper helper = new DefaultEACHelper();
  
  private static byte[] derEncode(byte[] paramArrayOfByte)
    throws IOException
  {
    int i = paramArrayOfByte.length / 2;
    byte[] arrayOfByte1 = new byte[i];
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, i);
    System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, i);
    paramArrayOfByte = new ASN1EncodableVector();
    paramArrayOfByte.add(new ASN1Integer(new BigInteger(1, arrayOfByte1)));
    paramArrayOfByte.add(new ASN1Integer(new BigInteger(1, arrayOfByte2)));
    return new DERSequence(paramArrayOfByte).getEncoded();
  }
  
  public EACSignatureVerifier build(final ASN1ObjectIdentifier paramASN1ObjectIdentifier, PublicKey paramPublicKey)
    throws OperatorCreationException
  {
    try
    {
      Signature localSignature = this.helper.getSignature(paramASN1ObjectIdentifier);
      localSignature.initVerify(paramPublicKey);
      new EACSignatureVerifier()
      {
        public OutputStream getOutputStream()
        {
          return this.val$sigStream;
        }
        
        public ASN1ObjectIdentifier getUsageIdentifier()
        {
          return paramASN1ObjectIdentifier;
        }
        
        public boolean verify(byte[] paramAnonymousArrayOfByte)
        {
          try
          {
            bool = paramASN1ObjectIdentifier.on(EACObjectIdentifiers.id_TA_ECDSA);
            if (!bool) {}
          }
          catch (SignatureException paramAnonymousArrayOfByte)
          {
            boolean bool;
            label31:
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("exception obtaining signature: ");
            localStringBuilder.append(paramAnonymousArrayOfByte.getMessage());
            throw new RuntimeOperatorException(localStringBuilder.toString(), paramAnonymousArrayOfByte);
          }
          try
          {
            paramAnonymousArrayOfByte = JcaEACSignatureVerifierBuilder.derEncode(paramAnonymousArrayOfByte);
            bool = this.val$sigStream.verify(paramAnonymousArrayOfByte);
            return bool;
          }
          catch (Exception paramAnonymousArrayOfByte)
          {
            break label31;
          }
          return false;
          bool = this.val$sigStream.verify(paramAnonymousArrayOfByte);
          return bool;
        }
      };
    }
    catch (InvalidKeyException paramASN1ObjectIdentifier)
    {
      paramPublicKey = new StringBuilder();
      paramPublicKey.append("invalid key: ");
      paramPublicKey.append(paramASN1ObjectIdentifier.getMessage());
      throw new OperatorCreationException(paramPublicKey.toString(), paramASN1ObjectIdentifier);
    }
    catch (NoSuchProviderException paramASN1ObjectIdentifier)
    {
      paramPublicKey = new StringBuilder();
      paramPublicKey.append("unable to find provider: ");
      paramPublicKey.append(paramASN1ObjectIdentifier.getMessage());
      throw new OperatorCreationException(paramPublicKey.toString(), paramASN1ObjectIdentifier);
    }
    catch (NoSuchAlgorithmException paramASN1ObjectIdentifier)
    {
      paramPublicKey = new StringBuilder();
      paramPublicKey.append("unable to find algorithm: ");
      paramPublicKey.append(paramASN1ObjectIdentifier.getMessage());
      throw new OperatorCreationException(paramPublicKey.toString(), paramASN1ObjectIdentifier);
    }
  }
  
  public JcaEACSignatureVerifierBuilder setProvider(String paramString)
  {
    this.helper = new NamedEACHelper(paramString);
    return this;
  }
  
  public JcaEACSignatureVerifierBuilder setProvider(Provider paramProvider)
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
    
    boolean verify(byte[] paramArrayOfByte)
      throws SignatureException
    {
      return this.sig.verify(paramArrayOfByte);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\eac\operator\jcajce\JcaEACSignatureVerifierBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */