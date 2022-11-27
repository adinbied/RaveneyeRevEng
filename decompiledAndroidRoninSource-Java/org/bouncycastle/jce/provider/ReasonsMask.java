package org.bouncycastle.jce.provider;

import org.bouncycastle.asn1.x509.ReasonFlags;

class ReasonsMask
{
  static final ReasonsMask allReasons = new ReasonsMask(33023);
  private int _reasons;
  
  ReasonsMask()
  {
    this(0);
  }
  
  private ReasonsMask(int paramInt)
  {
    this._reasons = paramInt;
  }
  
  ReasonsMask(ReasonFlags paramReasonFlags)
  {
    this._reasons = paramReasonFlags.intValue();
  }
  
  void addReasons(ReasonsMask paramReasonsMask)
  {
    int i = this._reasons;
    this._reasons = (paramReasonsMask.getReasons() | i);
  }
  
  int getReasons()
  {
    return this._reasons;
  }
  
  boolean hasNewReasons(ReasonsMask paramReasonsMask)
  {
    int i = this._reasons;
    return (paramReasonsMask.getReasons() ^ this._reasons | i) != 0;
  }
  
  ReasonsMask intersect(ReasonsMask paramReasonsMask)
  {
    ReasonsMask localReasonsMask = new ReasonsMask();
    int i = this._reasons;
    localReasonsMask.addReasons(new ReasonsMask(paramReasonsMask.getReasons() & i));
    return localReasonsMask;
  }
  
  boolean isAllReasons()
  {
    return this._reasons == allReasons._reasons;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\ReasonsMask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */