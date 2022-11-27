package org.bouncycastle.crypto.tls;

class DTLSEpoch
{
  private final TlsCipher cipher;
  private final int epoch;
  private final DTLSReplayWindow replayWindow = new DTLSReplayWindow();
  private long sequenceNumber = 0L;
  
  DTLSEpoch(int paramInt, TlsCipher paramTlsCipher)
  {
    if (paramInt >= 0)
    {
      if (paramTlsCipher != null)
      {
        this.epoch = paramInt;
        this.cipher = paramTlsCipher;
        return;
      }
      throw new IllegalArgumentException("'cipher' cannot be null");
    }
    throw new IllegalArgumentException("'epoch' must be >= 0");
  }
  
  long allocateSequenceNumber()
  {
    long l = this.sequenceNumber;
    this.sequenceNumber = (1L + l);
    return l;
  }
  
  TlsCipher getCipher()
  {
    return this.cipher;
  }
  
  int getEpoch()
  {
    return this.epoch;
  }
  
  DTLSReplayWindow getReplayWindow()
  {
    return this.replayWindow;
  }
  
  long getSequenceNumber()
  {
    return this.sequenceNumber;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DTLSEpoch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */