package io.reactivex.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class CompositeException
  extends RuntimeException
{
  private static final long serialVersionUID = 3026362227162912146L;
  private Throwable cause;
  private final List<Throwable> exceptions;
  private final String message;
  
  public CompositeException(Iterable<? extends Throwable> paramIterable)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    ArrayList localArrayList = new ArrayList();
    if (paramIterable != null)
    {
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Throwable localThrowable = (Throwable)paramIterable.next();
        if ((localThrowable instanceof CompositeException)) {
          localLinkedHashSet.addAll(((CompositeException)localThrowable).getExceptions());
        } else if (localThrowable != null) {
          localLinkedHashSet.add(localThrowable);
        } else {
          localLinkedHashSet.add(new NullPointerException("Throwable was null!"));
        }
      }
    }
    localLinkedHashSet.add(new NullPointerException("errors was null"));
    if (!localLinkedHashSet.isEmpty())
    {
      localArrayList.addAll(localLinkedHashSet);
      this.exceptions = Collections.unmodifiableList(localArrayList);
      paramIterable = new StringBuilder();
      paramIterable.append(this.exceptions.size());
      paramIterable.append(" exceptions occurred. ");
      this.message = paramIterable.toString();
      return;
    }
    throw new IllegalArgumentException("errors is empty");
  }
  
  public CompositeException(Throwable... paramVarArgs)
  {
    this(paramVarArgs);
  }
  
  /* Error */
  private void appendStackTrace(StringBuilder arg1, Throwable arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private List<Throwable> getListOfCauses(Throwable paramThrowable)
  {
    return null;
  }
  
  /* Error */
  private void printStackTrace(PrintStreamOrWriter arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Throwable getCause()
  {
    return null;
  }
  
  public List<Throwable> getExceptions()
  {
    return this.exceptions;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  Throwable getRootCause(Throwable paramThrowable)
  {
    return null;
  }
  
  public void printStackTrace()
  {
    printStackTrace(System.err);
  }
  
  /* Error */
  public void printStackTrace(PrintStream arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void printStackTrace(PrintWriter arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int size()
  {
    return this.exceptions.size();
  }
  
  static final class CompositeExceptionCausalChain
    extends RuntimeException
  {
    static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
    private static final long serialVersionUID = 3875212506787802066L;
    
    public String getMessage()
    {
      return "Chain of Causes for CompositeException In Order Received =>";
    }
  }
  
  static abstract class PrintStreamOrWriter
  {
    abstract void println(Object paramObject);
  }
  
  static final class WrappedPrintStream
    extends CompositeException.PrintStreamOrWriter
  {
    private final PrintStream printStream;
    
    WrappedPrintStream(PrintStream paramPrintStream)
    {
      this.printStream = paramPrintStream;
    }
    
    void println(Object paramObject)
    {
      this.printStream.println(paramObject);
    }
  }
  
  static final class WrappedPrintWriter
    extends CompositeException.PrintStreamOrWriter
  {
    private final PrintWriter printWriter;
    
    WrappedPrintWriter(PrintWriter paramPrintWriter)
    {
      this.printWriter = paramPrintWriter;
    }
    
    void println(Object paramObject)
    {
      this.printWriter.println(paramObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\exceptions\CompositeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */