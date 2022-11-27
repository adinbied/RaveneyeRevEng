package dji.thirdparty.rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class CompositeException
  extends RuntimeException
{
  private static final long serialVersionUID = 3026362227162912146L;
  private Throwable cause = null;
  private final List<Throwable> exceptions;
  private final String message;
  
  public CompositeException(String paramString, Collection<? extends Throwable> paramCollection)
  {
    paramString = new LinkedHashSet();
    ArrayList localArrayList = new ArrayList();
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Throwable localThrowable = (Throwable)paramCollection.next();
        if ((localThrowable instanceof CompositeException)) {
          paramString.addAll(((CompositeException)localThrowable).getExceptions());
        } else if (localThrowable != null) {
          paramString.add(localThrowable);
        } else {
          paramString.add(new NullPointerException());
        }
      }
    }
    paramString.add(new NullPointerException());
    localArrayList.addAll(paramString);
    this.exceptions = Collections.unmodifiableList(localArrayList);
    paramString = new StringBuilder();
    paramString.append(this.exceptions.size());
    paramString.append(" exceptions occurred. ");
    this.message = paramString.toString();
  }
  
  public CompositeException(Collection<? extends Throwable> paramCollection)
  {
    this(null, paramCollection);
  }
  
  public CompositeException(Throwable... paramVarArgs)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    ArrayList localArrayList = new ArrayList();
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        Throwable localThrowable = paramVarArgs[i];
        if ((localThrowable instanceof CompositeException)) {
          localLinkedHashSet.addAll(((CompositeException)localThrowable).getExceptions());
        } else if (localThrowable != null) {
          localLinkedHashSet.add(localThrowable);
        } else {
          localLinkedHashSet.add(new NullPointerException());
        }
        i += 1;
      }
    }
    localLinkedHashSet.add(new NullPointerException());
    localArrayList.addAll(localLinkedHashSet);
    this.exceptions = Collections.unmodifiableList(localArrayList);
    paramVarArgs = new StringBuilder();
    paramVarArgs.append(this.exceptions.size());
    paramVarArgs.append(" exceptions occurred. ");
    this.message = paramVarArgs.toString();
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
    //   2: return
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
  
  static final class CompositeExceptionCausalChain
    extends RuntimeException
  {
    static String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
    private static final long serialVersionUID = 3875212506787802066L;
    
    public String getMessage()
    {
      return MESSAGE;
    }
  }
  
  private static abstract class PrintStreamOrWriter
  {
    abstract Object lock();
    
    abstract void println(Object paramObject);
  }
  
  private static class WrappedPrintStream
    extends CompositeException.PrintStreamOrWriter
  {
    private final PrintStream printStream;
    
    WrappedPrintStream(PrintStream paramPrintStream)
    {
      super();
      this.printStream = paramPrintStream;
    }
    
    Object lock()
    {
      return this.printStream;
    }
    
    void println(Object paramObject)
    {
      this.printStream.println(paramObject);
    }
  }
  
  private static class WrappedPrintWriter
    extends CompositeException.PrintStreamOrWriter
  {
    private final PrintWriter printWriter;
    
    WrappedPrintWriter(PrintWriter paramPrintWriter)
    {
      super();
      this.printWriter = paramPrintWriter;
    }
    
    Object lock()
    {
      return this.printWriter;
    }
    
    void println(Object paramObject)
    {
      this.printWriter.println(paramObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\exceptions\CompositeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */