package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource.PSpecified;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSAESOAEPparams;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jcajce.provider.util.DigestFactory;
import org.bouncycastle.jcajce.util.MessageDigestUtils;

public abstract class AlgorithmParametersSpi
  extends java.security.AlgorithmParametersSpi
{
  protected AlgorithmParameterSpec engineGetParameterSpec(Class paramClass)
    throws InvalidParameterSpecException
  {
    if (paramClass != null) {
      return localEngineGetParameterSpec(paramClass);
    }
    throw new NullPointerException("argument to getParameterSpec must not be null");
  }
  
  protected boolean isASN1FormatString(String paramString)
  {
    return (paramString == null) || (paramString.equals("ASN.1"));
  }
  
  protected abstract AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
    throws InvalidParameterSpecException;
  
  public static class OAEP
    extends AlgorithmParametersSpi
  {
    OAEPParameterSpec currentSpec;
    
    protected byte[] engineGetEncoded()
    {
      Object localObject1 = new AlgorithmIdentifier(DigestFactory.getOID(this.currentSpec.getDigestAlgorithm()), DERNull.INSTANCE);
      Object localObject2 = (MGF1ParameterSpec)this.currentSpec.getMGFParameters();
      localObject2 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, new AlgorithmIdentifier(DigestFactory.getOID(((MGF1ParameterSpec)localObject2).getDigestAlgorithm()), DERNull.INSTANCE));
      PSource.PSpecified localPSpecified = (PSource.PSpecified)this.currentSpec.getPSource();
      localObject1 = new RSAESOAEPparams((AlgorithmIdentifier)localObject1, (AlgorithmIdentifier)localObject2, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_pSpecified, new DEROctetString(localPSpecified.getValue())));
      try
      {
        localObject1 = ((RSAESOAEPparams)localObject1).getEncoded("DER");
        return (byte[])localObject1;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      throw new RuntimeException("Error encoding OAEPParameters");
    }
    
    protected byte[] engineGetEncoded(String paramString)
    {
      if ((!isASN1FormatString(paramString)) && (!paramString.equalsIgnoreCase("X.509"))) {
        return null;
      }
      return engineGetEncoded();
    }
    
    protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec)
      throws InvalidParameterSpecException
    {
      if ((paramAlgorithmParameterSpec instanceof OAEPParameterSpec))
      {
        this.currentSpec = ((OAEPParameterSpec)paramAlgorithmParameterSpec);
        return;
      }
      throw new InvalidParameterSpecException("OAEPParameterSpec required to initialise an OAEP algorithm parameters object");
    }
    
    protected void engineInit(byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        paramArrayOfByte = RSAESOAEPparams.getInstance(paramArrayOfByte);
        if (paramArrayOfByte.getMaskGenAlgorithm().getAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1))
        {
          this.currentSpec = new OAEPParameterSpec(MessageDigestUtils.getDigestName(paramArrayOfByte.getHashAlgorithm().getAlgorithm()), OAEPParameterSpec.DEFAULT.getMGFAlgorithm(), new MGF1ParameterSpec(MessageDigestUtils.getDigestName(AlgorithmIdentifier.getInstance(paramArrayOfByte.getMaskGenAlgorithm().getParameters()).getAlgorithm())), new PSource.PSpecified(ASN1OctetString.getInstance(paramArrayOfByte.getPSourceAlgorithm().getParameters()).getOctets()));
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unknown mask generation function: ");
        localStringBuilder.append(paramArrayOfByte.getMaskGenAlgorithm().getAlgorithm());
        throw new IOException(localStringBuilder.toString());
      }
      catch (ClassCastException paramArrayOfByte)
      {
        for (;;) {}
      }
      catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
      {
        for (;;) {}
      }
      throw new IOException("Not a valid OAEP Parameter encoding.");
      throw new IOException("Not a valid OAEP Parameter encoding.");
    }
    
    protected void engineInit(byte[] paramArrayOfByte, String paramString)
      throws IOException
    {
      if ((!paramString.equalsIgnoreCase("X.509")) && (!paramString.equalsIgnoreCase("ASN.1")))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("Unknown parameter format ");
        paramArrayOfByte.append(paramString);
        throw new IOException(paramArrayOfByte.toString());
      }
      engineInit(paramArrayOfByte);
    }
    
    protected String engineToString()
    {
      return "OAEP Parameters";
    }
    
    protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
      throws InvalidParameterSpecException
    {
      if ((paramClass != OAEPParameterSpec.class) && (paramClass != AlgorithmParameterSpec.class)) {
        throw new InvalidParameterSpecException("unknown parameter spec passed to OAEP parameters object.");
      }
      return this.currentSpec;
    }
  }
  
  public static class PSS
    extends AlgorithmParametersSpi
  {
    PSSParameterSpec currentSpec;
    
    protected byte[] engineGetEncoded()
      throws IOException
    {
      PSSParameterSpec localPSSParameterSpec = this.currentSpec;
      AlgorithmIdentifier localAlgorithmIdentifier = new AlgorithmIdentifier(DigestFactory.getOID(localPSSParameterSpec.getDigestAlgorithm()), DERNull.INSTANCE);
      MGF1ParameterSpec localMGF1ParameterSpec = (MGF1ParameterSpec)localPSSParameterSpec.getMGFParameters();
      return new RSASSAPSSparams(localAlgorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, new AlgorithmIdentifier(DigestFactory.getOID(localMGF1ParameterSpec.getDigestAlgorithm()), DERNull.INSTANCE)), new ASN1Integer(localPSSParameterSpec.getSaltLength()), new ASN1Integer(localPSSParameterSpec.getTrailerField())).getEncoded("DER");
    }
    
    protected byte[] engineGetEncoded(String paramString)
      throws IOException
    {
      if ((!paramString.equalsIgnoreCase("X.509")) && (!paramString.equalsIgnoreCase("ASN.1"))) {
        return null;
      }
      return engineGetEncoded();
    }
    
    protected void engineInit(AlgorithmParameterSpec paramAlgorithmParameterSpec)
      throws InvalidParameterSpecException
    {
      if ((paramAlgorithmParameterSpec instanceof PSSParameterSpec))
      {
        this.currentSpec = ((PSSParameterSpec)paramAlgorithmParameterSpec);
        return;
      }
      throw new InvalidParameterSpecException("PSSParameterSpec required to initialise an PSS algorithm parameters object");
    }
    
    protected void engineInit(byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        paramArrayOfByte = RSASSAPSSparams.getInstance(paramArrayOfByte);
        if (paramArrayOfByte.getMaskGenAlgorithm().getAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1))
        {
          this.currentSpec = new PSSParameterSpec(MessageDigestUtils.getDigestName(paramArrayOfByte.getHashAlgorithm().getAlgorithm()), PSSParameterSpec.DEFAULT.getMGFAlgorithm(), new MGF1ParameterSpec(MessageDigestUtils.getDigestName(AlgorithmIdentifier.getInstance(paramArrayOfByte.getMaskGenAlgorithm().getParameters()).getAlgorithm())), paramArrayOfByte.getSaltLength().intValue(), paramArrayOfByte.getTrailerField().intValue());
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unknown mask generation function: ");
        localStringBuilder.append(paramArrayOfByte.getMaskGenAlgorithm().getAlgorithm());
        throw new IOException(localStringBuilder.toString());
      }
      catch (ClassCastException paramArrayOfByte)
      {
        for (;;) {}
      }
      catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
      {
        for (;;) {}
      }
      throw new IOException("Not a valid PSS Parameter encoding.");
      throw new IOException("Not a valid PSS Parameter encoding.");
    }
    
    protected void engineInit(byte[] paramArrayOfByte, String paramString)
      throws IOException
    {
      if ((!isASN1FormatString(paramString)) && (!paramString.equalsIgnoreCase("X.509")))
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("Unknown parameter format ");
        paramArrayOfByte.append(paramString);
        throw new IOException(paramArrayOfByte.toString());
      }
      engineInit(paramArrayOfByte);
    }
    
    protected String engineToString()
    {
      return "PSS Parameters";
    }
    
    protected AlgorithmParameterSpec localEngineGetParameterSpec(Class paramClass)
      throws InvalidParameterSpecException
    {
      if (paramClass == PSSParameterSpec.class)
      {
        paramClass = this.currentSpec;
        if (paramClass != null) {
          return paramClass;
        }
      }
      throw new InvalidParameterSpecException("unknown parameter spec passed to PSS parameters object.");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\rsa\AlgorithmParametersSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */