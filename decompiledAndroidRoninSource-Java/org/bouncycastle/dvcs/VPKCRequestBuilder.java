package org.bouncycastle.dvcs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bouncycastle.asn1.dvcs.CertEtcToken;
import org.bouncycastle.asn1.dvcs.DVCSRequestInformationBuilder;
import org.bouncycastle.asn1.dvcs.DVCSTime;
import org.bouncycastle.asn1.dvcs.Data;
import org.bouncycastle.asn1.dvcs.ServiceType;
import org.bouncycastle.asn1.dvcs.TargetEtcChain;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.cert.X509CertificateHolder;

public class VPKCRequestBuilder
  extends DVCSRequestBuilder
{
  private List chains = new ArrayList();
  
  public VPKCRequestBuilder()
  {
    super(new DVCSRequestInformationBuilder(ServiceType.VPKC));
  }
  
  public void addTargetChain(Extension paramExtension)
  {
    this.chains.add(new TargetEtcChain(new CertEtcToken(paramExtension)));
  }
  
  public void addTargetChain(X509CertificateHolder paramX509CertificateHolder)
  {
    this.chains.add(new TargetEtcChain(new CertEtcToken(0, paramX509CertificateHolder.toASN1Structure())));
  }
  
  public void addTargetChain(TargetChain paramTargetChain)
  {
    this.chains.add(paramTargetChain.toASN1Structure());
  }
  
  public DVCSRequest build()
    throws DVCSException
  {
    List localList = this.chains;
    return createDVCRequest(new Data((TargetEtcChain[])localList.toArray(new TargetEtcChain[localList.size()])));
  }
  
  public void setRequestTime(Date paramDate)
  {
    this.requestInformationBuilder.setRequestTime(new DVCSTime(paramDate));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\VPKCRequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */