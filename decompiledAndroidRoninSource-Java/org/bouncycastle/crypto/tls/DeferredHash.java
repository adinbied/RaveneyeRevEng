package org.bouncycastle.crypto.tls;

import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Shorts;

class DeferredHash
  implements TlsHandshakeHash
{
  protected static final int BUFFERING_HASH_LIMIT = 4;
  private DigestInputBuffer buf;
  protected TlsContext context;
  private Hashtable hashes;
  private Short prfHashAlgorithm;
  
  DeferredHash()
  {
    this.buf = new DigestInputBuffer();
    this.hashes = new Hashtable();
    this.prfHashAlgorithm = null;
  }
  
  private DeferredHash(Short paramShort, Digest paramDigest)
  {
    this.buf = null;
    Hashtable localHashtable = new Hashtable();
    this.hashes = localHashtable;
    this.prfHashAlgorithm = paramShort;
    localHashtable.put(paramShort, paramDigest);
  }
  
  protected void checkStopBuffering()
  {
    if ((this.buf != null) && (this.hashes.size() <= 4))
    {
      Enumeration localEnumeration = this.hashes.elements();
      while (localEnumeration.hasMoreElements())
      {
        Digest localDigest = (Digest)localEnumeration.nextElement();
        this.buf.updateDigest(localDigest);
      }
      this.buf = null;
    }
  }
  
  protected void checkTrackingHash(Short paramShort)
  {
    if (!this.hashes.containsKey(paramShort))
    {
      Digest localDigest = TlsUtils.createHash(paramShort.shortValue());
      this.hashes.put(paramShort, localDigest);
    }
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    throw new IllegalStateException("Use fork() to get a definite Digest");
  }
  
  public Digest forkPRFHash()
  {
    checkStopBuffering();
    if (this.buf != null)
    {
      Digest localDigest = TlsUtils.createHash(this.prfHashAlgorithm.shortValue());
      this.buf.updateDigest(localDigest);
      return localDigest;
    }
    return TlsUtils.cloneHash(this.prfHashAlgorithm.shortValue(), (Digest)this.hashes.get(this.prfHashAlgorithm));
  }
  
  public String getAlgorithmName()
  {
    throw new IllegalStateException("Use fork() to get a definite Digest");
  }
  
  public int getDigestSize()
  {
    throw new IllegalStateException("Use fork() to get a definite Digest");
  }
  
  public byte[] getFinalHash(short paramShort)
  {
    Object localObject1 = (Digest)this.hashes.get(Shorts.valueOf(paramShort));
    if (localObject1 != null)
    {
      localObject1 = TlsUtils.cloneHash(paramShort, (Digest)localObject1);
      Object localObject2 = this.buf;
      if (localObject2 != null) {
        ((DigestInputBuffer)localObject2).updateDigest((Digest)localObject1);
      }
      localObject2 = new byte[((Digest)localObject1).getDigestSize()];
      ((Digest)localObject1).doFinal((byte[])localObject2, 0);
      return (byte[])localObject2;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("HashAlgorithm.");
    ((StringBuilder)localObject1).append(HashAlgorithm.getText(paramShort));
    ((StringBuilder)localObject1).append(" is not being tracked");
    throw new IllegalStateException(((StringBuilder)localObject1).toString());
  }
  
  public void init(TlsContext paramTlsContext)
  {
    this.context = paramTlsContext;
  }
  
  public TlsHandshakeHash notifyPRFDetermined()
  {
    int i = this.context.getSecurityParameters().getPrfAlgorithm();
    if (i == 0)
    {
      localObject = new CombinedHash();
      ((CombinedHash)localObject).init(this.context);
      this.buf.updateDigest((Digest)localObject);
      return ((CombinedHash)localObject).notifyPRFDetermined();
    }
    Object localObject = Shorts.valueOf(TlsUtils.getHashAlgorithmForPRFAlgorithm(i));
    this.prfHashAlgorithm = ((Short)localObject);
    checkTrackingHash((Short)localObject);
    return this;
  }
  
  public void reset()
  {
    Object localObject = this.buf;
    if (localObject != null)
    {
      ((DigestInputBuffer)localObject).reset();
      return;
    }
    localObject = this.hashes.elements();
    while (((Enumeration)localObject).hasMoreElements()) {
      ((Digest)((Enumeration)localObject).nextElement()).reset();
    }
  }
  
  public void sealHashAlgorithms()
  {
    checkStopBuffering();
  }
  
  public TlsHandshakeHash stopTracking()
  {
    Object localObject = TlsUtils.cloneHash(this.prfHashAlgorithm.shortValue(), (Digest)this.hashes.get(this.prfHashAlgorithm));
    DigestInputBuffer localDigestInputBuffer = this.buf;
    if (localDigestInputBuffer != null) {
      localDigestInputBuffer.updateDigest((Digest)localObject);
    }
    localObject = new DeferredHash(this.prfHashAlgorithm, (Digest)localObject);
    ((DeferredHash)localObject).init(this.context);
    return (TlsHandshakeHash)localObject;
  }
  
  public void trackHashAlgorithm(short paramShort)
  {
    if (this.buf != null)
    {
      checkTrackingHash(Shorts.valueOf(paramShort));
      return;
    }
    throw new IllegalStateException("Too late to track more hash algorithms");
  }
  
  public void update(byte paramByte)
  {
    Object localObject = this.buf;
    if (localObject != null)
    {
      ((DigestInputBuffer)localObject).write(paramByte);
      return;
    }
    localObject = this.hashes.elements();
    while (((Enumeration)localObject).hasMoreElements()) {
      ((Digest)((Enumeration)localObject).nextElement()).update(paramByte);
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = this.buf;
    if (localObject != null)
    {
      ((DigestInputBuffer)localObject).write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    localObject = this.hashes.elements();
    while (((Enumeration)localObject).hasMoreElements()) {
      ((Digest)((Enumeration)localObject).nextElement()).update(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\DeferredHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */