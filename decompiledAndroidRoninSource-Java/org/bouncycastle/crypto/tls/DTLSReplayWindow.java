package org.bouncycastle.crypto.tls;

class DTLSReplayWindow
{
  private static final long VALID_SEQ_MASK = 281474976710655L;
  private static final long WINDOW_SIZE = 64L;
  private long bitmap = 0L;
  private long latestConfirmedSeq = -1L;
  
  void reportAuthenticated(long paramLong)
  {
    if ((0xFFFFFFFFFFFF & paramLong) == paramLong)
    {
      long l = this.latestConfirmedSeq;
      if (paramLong <= l)
      {
        paramLong = l - paramLong;
        if (paramLong < 64L) {
          this.bitmap |= 1L << (int)paramLong;
        }
      }
      else
      {
        l = paramLong - l;
        if (l >= 64L)
        {
          this.bitmap = 1L;
        }
        else
        {
          l = this.bitmap << (int)l;
          this.bitmap = l;
          this.bitmap = (l | 1L);
        }
        this.latestConfirmedSeq = paramLong;
      }
      return;
    }
    throw new IllegalArgumentException("'seq' out of range");
  }
  
  void reset()
  {
    this.latestConfirmedSeq = -1L;
    this.bitmap = 0L;
  }
  
  boolean shouldDiscard(long paramLong)
  {
    if ((0xFFFFFFFFFFFF & paramLong) != paramLong) {
      return true;
    }
    long l = this.latestConfirmedSeq;
    if (paramLong <= l)
    {
      paramLong = l - paramLong;
      if (paramLong >= 64L) {
        return true;
      }
      if ((this.bitmap & 1L << (int)paramLong) != 0L) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DTLSReplayWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */