package org.bouncycastle.eac;

import java.io.OutputStream;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.eac.CVCertificate;
import org.bouncycastle.asn1.eac.CertificateBody;
import org.bouncycastle.asn1.eac.CertificateHolderAuthorization;
import org.bouncycastle.asn1.eac.CertificateHolderReference;
import org.bouncycastle.asn1.eac.CertificationAuthorityReference;
import org.bouncycastle.asn1.eac.PackedDate;
import org.bouncycastle.asn1.eac.PublicKeyDataObject;
import org.bouncycastle.eac.operator.EACSigner;

public class EACCertificateBuilder
{
  private static final byte[] ZeroArray = { 0 };
  private PackedDate certificateEffectiveDate;
  private PackedDate certificateExpirationDate;
  private CertificateHolderAuthorization certificateHolderAuthorization;
  private CertificateHolderReference certificateHolderReference;
  private CertificationAuthorityReference certificationAuthorityReference;
  private PublicKeyDataObject publicKey;
  
  public EACCertificateBuilder(CertificationAuthorityReference paramCertificationAuthorityReference, PublicKeyDataObject paramPublicKeyDataObject, CertificateHolderReference paramCertificateHolderReference, CertificateHolderAuthorization paramCertificateHolderAuthorization, PackedDate paramPackedDate1, PackedDate paramPackedDate2)
  {
    this.certificationAuthorityReference = paramCertificationAuthorityReference;
    this.publicKey = paramPublicKeyDataObject;
    this.certificateHolderReference = paramCertificateHolderReference;
    this.certificateHolderAuthorization = paramCertificateHolderAuthorization;
    this.certificateEffectiveDate = paramPackedDate1;
    this.certificateExpirationDate = paramPackedDate2;
  }
  
  private CertificateBody buildBody()
  {
    return new CertificateBody(new DERApplicationSpecific(41, ZeroArray), this.certificationAuthorityReference, this.publicKey, this.certificateHolderReference, this.certificateHolderAuthorization, this.certificateEffectiveDate, this.certificateExpirationDate);
  }
  
  public EACCertificateHolder build(EACSigner paramEACSigner)
    throws EACException
  {
    try
    {
      localObject = buildBody();
      OutputStream localOutputStream = paramEACSigner.getOutputStream();
      localOutputStream.write(((CertificateBody)localObject).getEncoded("DER"));
      localOutputStream.close();
      paramEACSigner = new EACCertificateHolder(new CVCertificate((CertificateBody)localObject, paramEACSigner.getSignature()));
      return paramEACSigner;
    }
    catch (Exception paramEACSigner)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to process signature: ");
      ((StringBuilder)localObject).append(paramEACSigner.getMessage());
      throw new EACException(((StringBuilder)localObject).toString(), paramEACSigner);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\eac\EACCertificateBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */