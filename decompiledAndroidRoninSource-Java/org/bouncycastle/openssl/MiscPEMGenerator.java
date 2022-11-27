package org.bouncycastle.openssl;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.io.pem.PemGenerationException;
import org.bouncycastle.util.io.pem.PemHeader;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemObjectGenerator;

public class MiscPEMGenerator
  implements PemObjectGenerator
{
  private static final ASN1ObjectIdentifier[] dsaOids = { X9ObjectIdentifiers.id_dsa, OIWObjectIdentifiers.dsaWithSHA1 };
  private static final byte[] hexEncodingTable = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final PEMEncryptor encryptor;
  private final Object obj;
  
  public MiscPEMGenerator(Object paramObject)
  {
    this.obj = paramObject;
    this.encryptor = null;
  }
  
  public MiscPEMGenerator(Object paramObject, PEMEncryptor paramPEMEncryptor)
  {
    this.obj = paramObject;
    this.encryptor = paramPEMEncryptor;
  }
  
  private PemObject createPemObject(Object paramObject)
    throws IOException
  {
    if ((paramObject instanceof PemObject)) {
      return (PemObject)paramObject;
    }
    if ((paramObject instanceof PemObjectGenerator)) {
      return ((PemObjectGenerator)paramObject).generate();
    }
    Object localObject1;
    if ((paramObject instanceof X509CertificateHolder))
    {
      localObject1 = ((X509CertificateHolder)paramObject).getEncoded();
      paramObject = "CERTIFICATE";
    }
    else if ((paramObject instanceof X509CRLHolder))
    {
      localObject1 = ((X509CRLHolder)paramObject).getEncoded();
      paramObject = "X509 CRL";
    }
    else if ((paramObject instanceof X509TrustedCertificateBlock))
    {
      localObject1 = ((X509TrustedCertificateBlock)paramObject).getEncoded();
      paramObject = "TRUSTED CERTIFICATE";
    }
    else if ((paramObject instanceof PrivateKeyInfo))
    {
      paramObject = (PrivateKeyInfo)paramObject;
      localObject1 = ((PrivateKeyInfo)paramObject).getPrivateKeyAlgorithm().getAlgorithm();
      if (((ASN1ObjectIdentifier)localObject1).equals(PKCSObjectIdentifiers.rsaEncryption))
      {
        localObject1 = ((PrivateKeyInfo)paramObject).parsePrivateKey().toASN1Primitive().getEncoded();
        paramObject = "RSA PRIVATE KEY";
      }
      else if ((!((ASN1ObjectIdentifier)localObject1).equals(dsaOids[0])) && (!((ASN1ObjectIdentifier)localObject1).equals(dsaOids[1])))
      {
        if (((ASN1ObjectIdentifier)localObject1).equals(X9ObjectIdentifiers.id_ecPublicKey))
        {
          localObject1 = ((PrivateKeyInfo)paramObject).parsePrivateKey().toASN1Primitive().getEncoded();
          paramObject = "EC PRIVATE KEY";
        }
        else
        {
          throw new IOException("Cannot identify private key");
        }
      }
      else
      {
        localObject1 = DSAParameter.getInstance(((PrivateKeyInfo)paramObject).getPrivateKeyAlgorithm().getParameters());
        localObject2 = new ASN1EncodableVector();
        ((ASN1EncodableVector)localObject2).add(new ASN1Integer(0L));
        ((ASN1EncodableVector)localObject2).add(new ASN1Integer(((DSAParameter)localObject1).getP()));
        ((ASN1EncodableVector)localObject2).add(new ASN1Integer(((DSAParameter)localObject1).getQ()));
        ((ASN1EncodableVector)localObject2).add(new ASN1Integer(((DSAParameter)localObject1).getG()));
        paramObject = ASN1Integer.getInstance(((PrivateKeyInfo)paramObject).parsePrivateKey()).getValue();
        ((ASN1EncodableVector)localObject2).add(new ASN1Integer(((DSAParameter)localObject1).getG().modPow((BigInteger)paramObject, ((DSAParameter)localObject1).getP())));
        ((ASN1EncodableVector)localObject2).add(new ASN1Integer((BigInteger)paramObject));
        localObject1 = new DERSequence((ASN1EncodableVector)localObject2).getEncoded();
        paramObject = "DSA PRIVATE KEY";
      }
    }
    else if ((paramObject instanceof SubjectPublicKeyInfo))
    {
      localObject1 = ((SubjectPublicKeyInfo)paramObject).getEncoded();
      paramObject = "PUBLIC KEY";
    }
    else if ((paramObject instanceof X509AttributeCertificateHolder))
    {
      localObject1 = ((X509AttributeCertificateHolder)paramObject).getEncoded();
      paramObject = "ATTRIBUTE CERTIFICATE";
    }
    else if ((paramObject instanceof PKCS10CertificationRequest))
    {
      localObject1 = ((PKCS10CertificationRequest)paramObject).getEncoded();
      paramObject = "CERTIFICATE REQUEST";
    }
    else if ((paramObject instanceof PKCS8EncryptedPrivateKeyInfo))
    {
      localObject1 = ((PKCS8EncryptedPrivateKeyInfo)paramObject).getEncoded();
      paramObject = "ENCRYPTED PRIVATE KEY";
    }
    else
    {
      if (!(paramObject instanceof ContentInfo)) {
        break label618;
      }
      localObject1 = ((ContentInfo)paramObject).getEncoded();
      paramObject = "PKCS7";
    }
    Object localObject2 = this.encryptor;
    if (localObject2 != null)
    {
      Object localObject3 = Strings.toUpperCase(((PEMEncryptor)localObject2).getAlgorithm());
      localObject2 = localObject3;
      if (((String)localObject3).equals("DESEDE")) {
        localObject2 = "DES-EDE3-CBC";
      }
      localObject3 = this.encryptor.getIV();
      localObject1 = this.encryptor.encrypt((byte[])localObject1);
      ArrayList localArrayList = new ArrayList(2);
      localArrayList.add(new PemHeader("Proc-Type", "4,ENCRYPTED"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(",");
      localStringBuilder.append(getHexEncoded((byte[])localObject3));
      localArrayList.add(new PemHeader("DEK-Info", localStringBuilder.toString()));
      return new PemObject((String)paramObject, localArrayList, (byte[])localObject1);
    }
    return new PemObject((String)paramObject, (byte[])localObject1);
    label618:
    throw new PemGenerationException("unknown object passed - can't encode.");
  }
  
  private String getHexEncoded(byte[] paramArrayOfByte)
    throws IOException
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i != paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      byte[] arrayOfByte = hexEncodingTable;
      arrayOfChar[k] = ((char)arrayOfByte[(j >>> 4)]);
      arrayOfChar[(k + 1)] = ((char)arrayOfByte[(j & 0xF)]);
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public PemObject generate()
    throws PemGenerationException
  {
    try
    {
      PemObject localPemObject = createPemObject(this.obj);
      return localPemObject;
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("encoding exception: ");
      localStringBuilder.append(localIOException.getMessage());
      throw new PemGenerationException(localStringBuilder.toString(), localIOException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\MiscPEMGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */