package org.bouncycastle.operator.jcajce;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource.PSpecified;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSAESOAEPparams;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;

public class JcaAlgorithmParametersConverter
{
  public AlgorithmIdentifier getAlgorithmIdentifier(ASN1ObjectIdentifier paramASN1ObjectIdentifier, AlgorithmParameters paramAlgorithmParameters)
    throws InvalidAlgorithmParameterException
  {
    try
    {
      paramASN1ObjectIdentifier = new AlgorithmIdentifier(paramASN1ObjectIdentifier, ASN1Primitive.fromByteArray(paramAlgorithmParameters.getEncoded()));
      return paramASN1ObjectIdentifier;
    }
    catch (IOException paramASN1ObjectIdentifier)
    {
      paramAlgorithmParameters = new StringBuilder();
      paramAlgorithmParameters.append("unable to encode parameters object: ");
      paramAlgorithmParameters.append(paramASN1ObjectIdentifier.getMessage());
      throw new InvalidAlgorithmParameterException(paramAlgorithmParameters.toString());
    }
  }
  
  public AlgorithmIdentifier getAlgorithmIdentifier(ASN1ObjectIdentifier paramASN1ObjectIdentifier, AlgorithmParameterSpec paramAlgorithmParameterSpec)
    throws InvalidAlgorithmParameterException
  {
    if ((paramAlgorithmParameterSpec instanceof OAEPParameterSpec))
    {
      if (paramAlgorithmParameterSpec.equals(OAEPParameterSpec.DEFAULT)) {
        return new AlgorithmIdentifier(paramASN1ObjectIdentifier, new RSAESOAEPparams(RSAESOAEPparams.DEFAULT_HASH_ALGORITHM, RSAESOAEPparams.DEFAULT_MASK_GEN_FUNCTION, RSAESOAEPparams.DEFAULT_P_SOURCE_ALGORITHM));
      }
      Object localObject = (OAEPParameterSpec)paramAlgorithmParameterSpec;
      paramAlgorithmParameterSpec = ((OAEPParameterSpec)localObject).getPSource();
      if (((OAEPParameterSpec)localObject).getMGFAlgorithm().equals(OAEPParameterSpec.DEFAULT.getMGFAlgorithm()))
      {
        AlgorithmIdentifier localAlgorithmIdentifier = new DefaultDigestAlgorithmIdentifierFinder().find(((OAEPParameterSpec)localObject).getDigestAlgorithm());
        localObject = new DefaultDigestAlgorithmIdentifierFinder().find(((MGF1ParameterSpec)((OAEPParameterSpec)localObject).getMGFParameters()).getDigestAlgorithm());
        return new AlgorithmIdentifier(paramASN1ObjectIdentifier, new RSAESOAEPparams(localAlgorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, (ASN1Encodable)localObject), new AlgorithmIdentifier(PKCSObjectIdentifiers.id_pSpecified, new DEROctetString(((PSource.PSpecified)paramAlgorithmParameterSpec).getValue()))));
      }
      paramASN1ObjectIdentifier = new StringBuilder();
      paramASN1ObjectIdentifier.append("only ");
      paramASN1ObjectIdentifier.append(OAEPParameterSpec.DEFAULT.getMGFAlgorithm());
      paramASN1ObjectIdentifier.append(" mask generator supported.");
      throw new InvalidAlgorithmParameterException(paramASN1ObjectIdentifier.toString());
    }
    throw new InvalidAlgorithmParameterException("unknown parameter spec passed.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\jcajce\JcaAlgorithmParametersConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */