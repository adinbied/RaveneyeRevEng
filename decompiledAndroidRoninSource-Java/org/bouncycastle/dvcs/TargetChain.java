package org.bouncycastle.dvcs;

import org.bouncycastle.asn1.dvcs.TargetEtcChain;

public class TargetChain
{
  private final TargetEtcChain certs;
  
  public TargetChain(TargetEtcChain paramTargetEtcChain)
  {
    this.certs = paramTargetEtcChain;
  }
  
  public TargetEtcChain toASN1Structure()
  {
    return this.certs;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\TargetChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */