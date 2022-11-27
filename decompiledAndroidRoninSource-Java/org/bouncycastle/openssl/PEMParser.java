package org.bouncycastle.openssl;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.bouncycastle.asn1.pkcs.RSAPublicKey;
import org.bouncycastle.asn1.sec.ECPrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.bouncycastle.util.encoders.Hex;
import org.bouncycastle.util.io.pem.PemHeader;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemObjectParser;
import org.bouncycastle.util.io.pem.PemReader;

public class PEMParser
  extends PemReader
{
  private final Map parsers;
  
  public PEMParser(Reader paramReader)
  {
    super(paramReader);
    paramReader = new HashMap();
    this.parsers = paramReader;
    paramReader.put("CERTIFICATE REQUEST", new PKCS10CertificationRequestParser(null));
    this.parsers.put("NEW CERTIFICATE REQUEST", new PKCS10CertificationRequestParser(null));
    this.parsers.put("CERTIFICATE", new X509CertificateParser(null));
    this.parsers.put("TRUSTED CERTIFICATE", new X509TrustedCertificateParser(null));
    this.parsers.put("X509 CERTIFICATE", new X509CertificateParser(null));
    this.parsers.put("X509 CRL", new X509CRLParser(null));
    this.parsers.put("PKCS7", new PKCS7Parser(null));
    this.parsers.put("CMS", new PKCS7Parser(null));
    this.parsers.put("ATTRIBUTE CERTIFICATE", new X509AttributeCertificateParser(null));
    this.parsers.put("EC PARAMETERS", new ECCurveParamsParser(null));
    this.parsers.put("PUBLIC KEY", new PublicKeyParser());
    this.parsers.put("RSA PUBLIC KEY", new RSAPublicKeyParser());
    this.parsers.put("RSA PRIVATE KEY", new KeyPairParser(new RSAKeyPairParser(null)));
    this.parsers.put("DSA PRIVATE KEY", new KeyPairParser(new DSAKeyPairParser(null)));
    this.parsers.put("EC PRIVATE KEY", new KeyPairParser(new ECDSAKeyPairParser(null)));
    this.parsers.put("ENCRYPTED PRIVATE KEY", new EncryptedPrivateKeyParser());
    this.parsers.put("PRIVATE KEY", new PrivateKeyParser());
  }
  
  public Object readObject()
    throws IOException
  {
    Object localObject = readPemObject();
    if (localObject != null)
    {
      String str = ((PemObject)localObject).getType();
      if (this.parsers.containsKey(str)) {
        return ((PemObjectParser)this.parsers.get(str)).parseObject((PemObject)localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unrecognised object: ");
      ((StringBuilder)localObject).append(str);
      throw new IOException(((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  private class DSAKeyPairParser
    implements PEMKeyPairParser
  {
    private DSAKeyPairParser() {}
    
    public PEMKeyPair parse(byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        Object localObject2 = ASN1Sequence.getInstance(paramArrayOfByte);
        if (((ASN1Sequence)localObject2).size() == 6)
        {
          paramArrayOfByte = ASN1Integer.getInstance(((ASN1Sequence)localObject2).getObjectAt(1));
          localObject1 = ASN1Integer.getInstance(((ASN1Sequence)localObject2).getObjectAt(2));
          ASN1Integer localASN1Integer1 = ASN1Integer.getInstance(((ASN1Sequence)localObject2).getObjectAt(3));
          ASN1Integer localASN1Integer2 = ASN1Integer.getInstance(((ASN1Sequence)localObject2).getObjectAt(4));
          localObject2 = ASN1Integer.getInstance(((ASN1Sequence)localObject2).getObjectAt(5));
          return new PEMKeyPair(new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(paramArrayOfByte.getValue(), ((ASN1Integer)localObject1).getValue(), localASN1Integer1.getValue())), localASN1Integer2), new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(paramArrayOfByte.getValue(), ((ASN1Integer)localObject1).getValue(), localASN1Integer1.getValue())), (ASN1Encodable)localObject2));
        }
        throw new PEMException("malformed sequence in DSA private key");
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("problem creating DSA private key: ");
        ((StringBuilder)localObject1).append(paramArrayOfByte.toString());
        throw new PEMException(((StringBuilder)localObject1).toString(), paramArrayOfByte);
      }
      catch (IOException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
  }
  
  private class ECCurveParamsParser
    implements PemObjectParser
  {
    private ECCurveParamsParser() {}
    
    public Object parseObject(PemObject paramPemObject)
      throws IOException
    {
      try
      {
        localObject = ASN1Primitive.fromByteArray(paramPemObject.getContent());
        if ((localObject instanceof ASN1ObjectIdentifier)) {
          return ASN1Primitive.fromByteArray(paramPemObject.getContent());
        }
        if ((localObject instanceof ASN1Sequence))
        {
          paramPemObject = X9ECParameters.getInstance(localObject);
          return paramPemObject;
        }
        return null;
      }
      catch (Exception paramPemObject)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("exception extracting EC named curve: ");
        ((StringBuilder)localObject).append(paramPemObject.toString());
        throw new PEMException(((StringBuilder)localObject).toString());
      }
      catch (IOException paramPemObject)
      {
        throw paramPemObject;
      }
    }
  }
  
  private class ECDSAKeyPairParser
    implements PEMKeyPairParser
  {
    private ECDSAKeyPairParser() {}
    
    public PEMKeyPair parse(byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        paramArrayOfByte = ECPrivateKey.getInstance(ASN1Sequence.getInstance(paramArrayOfByte));
        localObject = new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, paramArrayOfByte.getParameters());
        PrivateKeyInfo localPrivateKeyInfo = new PrivateKeyInfo((AlgorithmIdentifier)localObject, paramArrayOfByte);
        paramArrayOfByte = new PEMKeyPair(new SubjectPublicKeyInfo((AlgorithmIdentifier)localObject, paramArrayOfByte.getPublicKey().getBytes()), localPrivateKeyInfo);
        return paramArrayOfByte;
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("problem creating EC private key: ");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        throw new PEMException(((StringBuilder)localObject).toString(), paramArrayOfByte);
      }
      catch (IOException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
  }
  
  private class EncryptedPrivateKeyParser
    implements PemObjectParser
  {
    public EncryptedPrivateKeyParser() {}
    
    public Object parseObject(PemObject paramPemObject)
      throws IOException
    {
      try
      {
        paramPemObject = new PKCS8EncryptedPrivateKeyInfo(EncryptedPrivateKeyInfo.getInstance(paramPemObject.getContent()));
        return paramPemObject;
      }
      catch (Exception paramPemObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem parsing ENCRYPTED PRIVATE KEY: ");
        localStringBuilder.append(paramPemObject.toString());
        throw new PEMException(localStringBuilder.toString(), paramPemObject);
      }
    }
  }
  
  private class KeyPairParser
    implements PemObjectParser
  {
    private final PEMKeyPairParser pemKeyPairParser;
    
    public KeyPairParser(PEMKeyPairParser paramPEMKeyPairParser)
    {
      this.pemKeyPairParser = paramPEMKeyPairParser;
    }
    
    public Object parseObject(PemObject paramPemObject)
      throws IOException
    {
      Iterator localIterator = paramPemObject.getHeaders().iterator();
      i = 0;
      Object localObject = null;
      while (localIterator.hasNext())
      {
        PemHeader localPemHeader = (PemHeader)localIterator.next();
        if ((localPemHeader.getName().equals("Proc-Type")) && (localPemHeader.getValue().equals("4,ENCRYPTED"))) {
          i = 1;
        } else if (localPemHeader.getName().equals("DEK-Info")) {
          localObject = localPemHeader.getValue();
        }
      }
      paramPemObject = paramPemObject.getContent();
      if (i != 0) {}
      try
      {
        localObject = new StringTokenizer((String)localObject, ",");
        return new PEMEncryptedKeyPair(((StringTokenizer)localObject).nextToken(), Hex.decode(((StringTokenizer)localObject).nextToken()), paramPemObject, this.pemKeyPairParser);
      }
      catch (IllegalArgumentException paramPemObject)
      {
        if (i == 0) {
          break label163;
        }
        throw new PEMException("exception decoding - please check password and data.", paramPemObject);
        throw new PEMException(paramPemObject.getMessage(), paramPemObject);
      }
      catch (IOException paramPemObject)
      {
        if (i == 0) {
          break label192;
        }
        throw new PEMException("exception decoding - please check password and data.", paramPemObject);
        throw new PEMException(paramPemObject.getMessage(), paramPemObject);
      }
      paramPemObject = this.pemKeyPairParser.parse(paramPemObject);
      return paramPemObject;
    }
  }
  
  private class PKCS10CertificationRequestParser
    implements PemObjectParser
  {
    private PKCS10CertificationRequestParser() {}
    
    public Object parseObject(PemObject paramPemObject)
      throws IOException
    {
      try
      {
        paramPemObject = new PKCS10CertificationRequest(paramPemObject.getContent());
        return paramPemObject;
      }
      catch (Exception paramPemObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem parsing certrequest: ");
        localStringBuilder.append(paramPemObject.toString());
        throw new PEMException(localStringBuilder.toString(), paramPemObject);
      }
    }
  }
  
  private class PKCS7Parser
    implements PemObjectParser
  {
    private PKCS7Parser() {}
    
    public Object parseObject(PemObject paramPemObject)
      throws IOException
    {
      try
      {
        paramPemObject = ContentInfo.getInstance(new ASN1InputStream(paramPemObject.getContent()).readObject());
        return paramPemObject;
      }
      catch (Exception paramPemObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem parsing PKCS7 object: ");
        localStringBuilder.append(paramPemObject.toString());
        throw new PEMException(localStringBuilder.toString(), paramPemObject);
      }
    }
  }
  
  private class PrivateKeyParser
    implements PemObjectParser
  {
    public PrivateKeyParser() {}
    
    public Object parseObject(PemObject paramPemObject)
      throws IOException
    {
      try
      {
        paramPemObject = PrivateKeyInfo.getInstance(paramPemObject.getContent());
        return paramPemObject;
      }
      catch (Exception paramPemObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem parsing PRIVATE KEY: ");
        localStringBuilder.append(paramPemObject.toString());
        throw new PEMException(localStringBuilder.toString(), paramPemObject);
      }
    }
  }
  
  private class PublicKeyParser
    implements PemObjectParser
  {
    public PublicKeyParser() {}
    
    public Object parseObject(PemObject paramPemObject)
      throws IOException
    {
      return SubjectPublicKeyInfo.getInstance(paramPemObject.getContent());
    }
  }
  
  private class RSAKeyPairParser
    implements PEMKeyPairParser
  {
    private RSAKeyPairParser() {}
    
    public PEMKeyPair parse(byte[] paramArrayOfByte)
      throws IOException
    {
      try
      {
        paramArrayOfByte = ASN1Sequence.getInstance(paramArrayOfByte);
        if (paramArrayOfByte.size() == 9)
        {
          paramArrayOfByte = RSAPrivateKey.getInstance(paramArrayOfByte);
          localObject = new RSAPublicKey(paramArrayOfByte.getModulus(), paramArrayOfByte.getPublicExponent());
          AlgorithmIdentifier localAlgorithmIdentifier = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE);
          return new PEMKeyPair(new SubjectPublicKeyInfo(localAlgorithmIdentifier, (ASN1Encodable)localObject), new PrivateKeyInfo(localAlgorithmIdentifier, paramArrayOfByte));
        }
        throw new PEMException("malformed sequence in RSA private key");
      }
      catch (Exception paramArrayOfByte)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("problem creating RSA private key: ");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        throw new PEMException(((StringBuilder)localObject).toString(), paramArrayOfByte);
      }
      catch (IOException paramArrayOfByte)
      {
        throw paramArrayOfByte;
      }
    }
  }
  
  private class RSAPublicKeyParser
    implements PemObjectParser
  {
    public RSAPublicKeyParser() {}
    
    public Object parseObject(PemObject paramPemObject)
      throws IOException
    {
      try
      {
        paramPemObject = RSAPublicKey.getInstance(paramPemObject.getContent());
        paramPemObject = new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), paramPemObject);
        return paramPemObject;
      }
      catch (Exception paramPemObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem extracting key: ");
        localStringBuilder.append(paramPemObject.toString());
        throw new PEMException(localStringBuilder.toString(), paramPemObject);
      }
      catch (IOException paramPemObject)
      {
        throw paramPemObject;
      }
    }
  }
  
  private class X509AttributeCertificateParser
    implements PemObjectParser
  {
    private X509AttributeCertificateParser() {}
    
    public Object parseObject(PemObject paramPemObject)
      throws IOException
    {
      return new X509AttributeCertificateHolder(paramPemObject.getContent());
    }
  }
  
  private class X509CRLParser
    implements PemObjectParser
  {
    private X509CRLParser() {}
    
    public Object parseObject(PemObject paramPemObject)
      throws IOException
    {
      try
      {
        paramPemObject = new X509CRLHolder(paramPemObject.getContent());
        return paramPemObject;
      }
      catch (Exception paramPemObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem parsing cert: ");
        localStringBuilder.append(paramPemObject.toString());
        throw new PEMException(localStringBuilder.toString(), paramPemObject);
      }
    }
  }
  
  private class X509CertificateParser
    implements PemObjectParser
  {
    private X509CertificateParser() {}
    
    public Object parseObject(PemObject paramPemObject)
      throws IOException
    {
      try
      {
        paramPemObject = new X509CertificateHolder(paramPemObject.getContent());
        return paramPemObject;
      }
      catch (Exception paramPemObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem parsing cert: ");
        localStringBuilder.append(paramPemObject.toString());
        throw new PEMException(localStringBuilder.toString(), paramPemObject);
      }
    }
  }
  
  private class X509TrustedCertificateParser
    implements PemObjectParser
  {
    private X509TrustedCertificateParser() {}
    
    public Object parseObject(PemObject paramPemObject)
      throws IOException
    {
      try
      {
        paramPemObject = new X509TrustedCertificateBlock(paramPemObject.getContent());
        return paramPemObject;
      }
      catch (Exception paramPemObject)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("problem parsing cert: ");
        localStringBuilder.append(paramPemObject.toString());
        throw new PEMException(localStringBuilder.toString(), paramPemObject);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\PEMParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */