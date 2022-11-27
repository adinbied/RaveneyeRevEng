package org.bouncycastle.cert.ocsp;

import java.io.OutputStream;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.ocsp.ResponderID;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.DigestCalculator;

public class RespID
{
  public static final AlgorithmIdentifier HASH_SHA1 = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
  ResponderID id;
  
  public RespID(ResponderID paramResponderID)
  {
    this.id = paramResponderID;
  }
  
  public RespID(X500Name paramX500Name)
  {
    this.id = new ResponderID(paramX500Name);
  }
  
  public RespID(SubjectPublicKeyInfo paramSubjectPublicKeyInfo, DigestCalculator paramDigestCalculator)
    throws OCSPException
  {
    try
    {
      if (paramDigestCalculator.getAlgorithmIdentifier().equals(HASH_SHA1))
      {
        OutputStream localOutputStream = paramDigestCalculator.getOutputStream();
        localOutputStream.write(paramSubjectPublicKeyInfo.getPublicKeyData().getBytes());
        localOutputStream.close();
        this.id = new ResponderID(new DEROctetString(paramDigestCalculator.getDigest()));
        return;
      }
      paramSubjectPublicKeyInfo = new StringBuilder();
      paramSubjectPublicKeyInfo.append("only SHA-1 can be used with RespID - found: ");
      paramSubjectPublicKeyInfo.append(paramDigestCalculator.getAlgorithmIdentifier().getAlgorithm());
      throw new IllegalArgumentException(paramSubjectPublicKeyInfo.toString());
    }
    catch (Exception paramSubjectPublicKeyInfo)
    {
      paramDigestCalculator = new StringBuilder();
      paramDigestCalculator.append("problem creating ID: ");
      paramDigestCalculator.append(paramSubjectPublicKeyInfo);
      throw new OCSPException(paramDigestCalculator.toString(), paramSubjectPublicKeyInfo);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof RespID)) {
      return false;
    }
    paramObject = (RespID)paramObject;
    return this.id.equals(((RespID)paramObject).id);
  }
  
  public int hashCode()
  {
    return this.id.hashCode();
  }
  
  public ResponderID toASN1Primitive()
  {
    return this.id;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\RespID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */