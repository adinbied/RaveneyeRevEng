package io.reactivex.exceptions;

public final class UndeliverableException
  extends IllegalStateException
{
  private static final long serialVersionUID = 1644750035281290266L;
  
  public UndeliverableException(Throwable paramThrowable)
  {
    super(localStringBuilder.toString(), paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\exceptions\UndeliverableException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */