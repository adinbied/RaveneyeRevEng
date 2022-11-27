package org.bouncycastle.jce.provider;

import java.util.Date;

class CertStatus
{
  public static final int UNDETERMINED = 12;
  public static final int UNREVOKED = 11;
  int certStatus = 11;
  Date revocationDate = null;
  
  public int getCertStatus()
  {
    return this.certStatus;
  }
  
  public Date getRevocationDate()
  {
    return this.revocationDate;
  }
  
  public void setCertStatus(int paramInt)
  {
    this.certStatus = paramInt;
  }
  
  public void setRevocationDate(Date paramDate)
  {
    this.revocationDate = paramDate;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\CertStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */