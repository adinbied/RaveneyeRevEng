package org.bouncycastle.operator.jcajce;

import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OperatorStreamException;
import org.bouncycastle.operator.RawContentVerifier;
import org.bouncycastle.operator.RuntimeOperatorException;

public class JcaContentVerifierProviderBuilder
{
  private OperatorHelper helper = new OperatorHelper(new DefaultJcaJceHelper());
  
  private Signature createRawSig(AlgorithmIdentifier paramAlgorithmIdentifier, PublicKey paramPublicKey)
  {
    try
    {
      Signature localSignature = this.helper.createRawSignature(paramAlgorithmIdentifier);
      paramAlgorithmIdentifier = localSignature;
      if (localSignature == null) {
        break label24;
      }
      localSignature.initVerify(paramPublicKey);
      return localSignature;
    }
    catch (Exception paramAlgorithmIdentifier)
    {
      label24:
      for (;;) {}
    }
    paramAlgorithmIdentifier = null;
    return paramAlgorithmIdentifier;
  }
  
  private SignatureOutputStream createSignatureStream(AlgorithmIdentifier paramAlgorithmIdentifier, PublicKey paramPublicKey)
    throws OperatorCreationException
  {
    try
    {
      paramAlgorithmIdentifier = this.helper.createSignature(paramAlgorithmIdentifier);
      paramAlgorithmIdentifier.initVerify(paramPublicKey);
      paramAlgorithmIdentifier = new SignatureOutputStream(paramAlgorithmIdentifier);
      return paramAlgorithmIdentifier;
    }
    catch (GeneralSecurityException paramAlgorithmIdentifier)
    {
      paramPublicKey = new StringBuilder();
      paramPublicKey.append("exception on setup: ");
      paramPublicKey.append(paramAlgorithmIdentifier);
      throw new OperatorCreationException(paramPublicKey.toString(), paramAlgorithmIdentifier);
    }
  }
  
  public ContentVerifierProvider build(final PublicKey paramPublicKey)
    throws OperatorCreationException
  {
    new ContentVerifierProvider()
    {
      public ContentVerifier get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
        throws OperatorCreationException
      {
        JcaContentVerifierProviderBuilder.SignatureOutputStream localSignatureOutputStream = JcaContentVerifierProviderBuilder.this.createSignatureStream(paramAnonymousAlgorithmIdentifier, paramPublicKey);
        Signature localSignature = JcaContentVerifierProviderBuilder.this.createRawSig(paramAnonymousAlgorithmIdentifier, paramPublicKey);
        if (localSignature != null) {
          return new JcaContentVerifierProviderBuilder.RawSigVerifier(JcaContentVerifierProviderBuilder.this, paramAnonymousAlgorithmIdentifier, localSignatureOutputStream, localSignature);
        }
        return new JcaContentVerifierProviderBuilder.SigVerifier(JcaContentVerifierProviderBuilder.this, paramAnonymousAlgorithmIdentifier, localSignatureOutputStream);
      }
      
      public X509CertificateHolder getAssociatedCertificate()
      {
        return null;
      }
      
      public boolean hasAssociatedCertificate()
      {
        return false;
      }
    };
  }
  
  public ContentVerifierProvider build(final X509Certificate paramX509Certificate)
    throws OperatorCreationException
  {
    try
    {
      localObject = new JcaX509CertificateHolder(paramX509Certificate);
      new ContentVerifierProvider()
      {
        private JcaContentVerifierProviderBuilder.SignatureOutputStream stream;
        
        public ContentVerifier get(AlgorithmIdentifier paramAnonymousAlgorithmIdentifier)
          throws OperatorCreationException
        {
          try
          {
            localObject = JcaContentVerifierProviderBuilder.this.helper.createSignature(paramAnonymousAlgorithmIdentifier);
            ((Signature)localObject).initVerify(paramX509Certificate.getPublicKey());
            this.stream = new JcaContentVerifierProviderBuilder.SignatureOutputStream(JcaContentVerifierProviderBuilder.this, (Signature)localObject);
            localObject = JcaContentVerifierProviderBuilder.this.createRawSig(paramAnonymousAlgorithmIdentifier, paramX509Certificate.getPublicKey());
            if (localObject != null) {
              return new JcaContentVerifierProviderBuilder.RawSigVerifier(JcaContentVerifierProviderBuilder.this, paramAnonymousAlgorithmIdentifier, this.stream, (Signature)localObject);
            }
            return new JcaContentVerifierProviderBuilder.SigVerifier(JcaContentVerifierProviderBuilder.this, paramAnonymousAlgorithmIdentifier, this.stream);
          }
          catch (GeneralSecurityException paramAnonymousAlgorithmIdentifier)
          {
            Object localObject = new StringBuilder();
            ((StringBuilder)localObject).append("exception on setup: ");
            ((StringBuilder)localObject).append(paramAnonymousAlgorithmIdentifier);
            throw new OperatorCreationException(((StringBuilder)localObject).toString(), paramAnonymousAlgorithmIdentifier);
          }
        }
        
        public X509CertificateHolder getAssociatedCertificate()
        {
          return localObject;
        }
        
        public boolean hasAssociatedCertificate()
        {
          return true;
        }
      };
    }
    catch (CertificateEncodingException paramX509Certificate)
    {
      final Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot process certificate: ");
      ((StringBuilder)localObject).append(paramX509Certificate.getMessage());
      throw new OperatorCreationException(((StringBuilder)localObject).toString(), paramX509Certificate);
    }
  }
  
  public ContentVerifierProvider build(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws OperatorCreationException
  {
    return build(this.helper.convertPublicKey(paramSubjectPublicKeyInfo));
  }
  
  public ContentVerifierProvider build(X509CertificateHolder paramX509CertificateHolder)
    throws OperatorCreationException, CertificateException
  {
    return build(this.helper.convertCertificate(paramX509CertificateHolder));
  }
  
  public JcaContentVerifierProviderBuilder setProvider(String paramString)
  {
    this.helper = new OperatorHelper(new NamedJcaJceHelper(paramString));
    return this;
  }
  
  public JcaContentVerifierProviderBuilder setProvider(Provider paramProvider)
  {
    this.helper = new OperatorHelper(new ProviderJcaJceHelper(paramProvider));
    return this;
  }
  
  private class RawSigVerifier
    extends JcaContentVerifierProviderBuilder.SigVerifier
    implements RawContentVerifier
  {
    private Signature rawSignature;
    
    RawSigVerifier(AlgorithmIdentifier paramAlgorithmIdentifier, JcaContentVerifierProviderBuilder.SignatureOutputStream paramSignatureOutputStream, Signature paramSignature)
    {
      super(paramAlgorithmIdentifier, paramSignatureOutputStream);
      this.rawSignature = paramSignature;
    }
    
    /* Error */
    public boolean verify(byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: invokespecial 29	org/bouncycastle/operator/jcajce/JcaContentVerifierProviderBuilder$SigVerifier:verify	([B)Z
      //   5: istore_2
      //   6: aload_0
      //   7: getfield 22	org/bouncycastle/operator/jcajce/JcaContentVerifierProviderBuilder$RawSigVerifier:rawSignature	Ljava/security/Signature;
      //   10: aload_1
      //   11: invokevirtual 32	java/security/Signature:verify	([B)Z
      //   14: pop
      //   15: iload_2
      //   16: ireturn
      //   17: astore_3
      //   18: aload_0
      //   19: getfield 22	org/bouncycastle/operator/jcajce/JcaContentVerifierProviderBuilder$RawSigVerifier:rawSignature	Ljava/security/Signature;
      //   22: aload_1
      //   23: invokevirtual 32	java/security/Signature:verify	([B)Z
      //   26: pop
      //   27: aload_3
      //   28: athrow
      //   29: astore_1
      //   30: iload_2
      //   31: ireturn
      //   32: astore_1
      //   33: goto -6 -> 27
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	36	0	this	RawSigVerifier
      //   0	36	1	paramArrayOfByte	byte[]
      //   5	26	2	bool	boolean
      //   17	11	3	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   0	6	17	finally
      //   6	15	29	java/lang/Exception
      //   18	27	32	java/lang/Exception
    }
    
    /* Error */
    public boolean verify(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 22	org/bouncycastle/operator/jcajce/JcaContentVerifierProviderBuilder$RawSigVerifier:rawSignature	Ljava/security/Signature;
      //   4: aload_1
      //   5: invokevirtual 39	java/security/Signature:update	([B)V
      //   8: aload_0
      //   9: getfield 22	org/bouncycastle/operator/jcajce/JcaContentVerifierProviderBuilder$RawSigVerifier:rawSignature	Ljava/security/Signature;
      //   12: aload_2
      //   13: invokevirtual 32	java/security/Signature:verify	([B)Z
      //   16: istore_3
      //   17: aload_0
      //   18: getfield 43	org/bouncycastle/operator/jcajce/JcaContentVerifierProviderBuilder$RawSigVerifier:stream	Lorg/bouncycastle/operator/jcajce/JcaContentVerifierProviderBuilder$SignatureOutputStream;
      //   21: aload_2
      //   22: invokevirtual 46	org/bouncycastle/operator/jcajce/JcaContentVerifierProviderBuilder$SignatureOutputStream:verify	([B)Z
      //   25: pop
      //   26: iload_3
      //   27: ireturn
      //   28: astore_1
      //   29: goto +45 -> 74
      //   32: astore_1
      //   33: new 48	java/lang/StringBuilder
      //   36: dup
      //   37: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   40: astore 4
      //   42: aload 4
      //   44: ldc 53
      //   46: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   49: pop
      //   50: aload 4
      //   52: aload_1
      //   53: invokevirtual 61	java/security/SignatureException:getMessage	()Ljava/lang/String;
      //   56: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   59: pop
      //   60: new 63	org/bouncycastle/operator/RuntimeOperatorException
      //   63: dup
      //   64: aload 4
      //   66: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   69: aload_1
      //   70: invokespecial 69	org/bouncycastle/operator/RuntimeOperatorException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   73: athrow
      //   74: aload_0
      //   75: getfield 43	org/bouncycastle/operator/jcajce/JcaContentVerifierProviderBuilder$RawSigVerifier:stream	Lorg/bouncycastle/operator/jcajce/JcaContentVerifierProviderBuilder$SignatureOutputStream;
      //   78: aload_2
      //   79: invokevirtual 46	org/bouncycastle/operator/jcajce/JcaContentVerifierProviderBuilder$SignatureOutputStream:verify	([B)Z
      //   82: pop
      //   83: aload_1
      //   84: athrow
      //   85: astore_1
      //   86: iload_3
      //   87: ireturn
      //   88: astore_2
      //   89: goto -6 -> 83
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	92	0	this	RawSigVerifier
      //   0	92	1	paramArrayOfByte1	byte[]
      //   0	92	2	paramArrayOfByte2	byte[]
      //   16	71	3	bool	boolean
      //   40	25	4	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   0	17	28	finally
      //   33	74	28	finally
      //   0	17	32	java/security/SignatureException
      //   17	26	85	java/lang/Exception
      //   74	83	88	java/lang/Exception
    }
  }
  
  private class SigVerifier
    implements ContentVerifier
  {
    private AlgorithmIdentifier algorithm;
    protected JcaContentVerifierProviderBuilder.SignatureOutputStream stream;
    
    SigVerifier(AlgorithmIdentifier paramAlgorithmIdentifier, JcaContentVerifierProviderBuilder.SignatureOutputStream paramSignatureOutputStream)
    {
      this.algorithm = paramAlgorithmIdentifier;
      this.stream = paramSignatureOutputStream;
    }
    
    public AlgorithmIdentifier getAlgorithmIdentifier()
    {
      return this.algorithm;
    }
    
    public OutputStream getOutputStream()
    {
      JcaContentVerifierProviderBuilder.SignatureOutputStream localSignatureOutputStream = this.stream;
      if (localSignatureOutputStream != null) {
        return localSignatureOutputStream;
      }
      throw new IllegalStateException("verifier not initialised");
    }
    
    public boolean verify(byte[] paramArrayOfByte)
    {
      try
      {
        boolean bool = this.stream.verify(paramArrayOfByte);
        return bool;
      }
      catch (SignatureException paramArrayOfByte)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exception obtaining signature: ");
        localStringBuilder.append(paramArrayOfByte.getMessage());
        throw new RuntimeOperatorException(localStringBuilder.toString(), paramArrayOfByte);
      }
    }
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\JcaContentVerifierProviderBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */