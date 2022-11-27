package org.junit.runner.notification;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import org.junit.runner.Description;

public class Failure
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final Description fDescription;
  private final Throwable fThrownException;
  
  public Failure(Description paramDescription, Throwable paramThrowable)
  {
    this.fThrownException = paramThrowable;
    this.fDescription = paramDescription;
  }
  
  public Description getDescription()
  {
    return this.fDescription;
  }
  
  public Throwable getException()
  {
    return this.fThrownException;
  }
  
  public String getMessage()
  {
    return getException().getMessage();
  }
  
  public String getTestHeader()
  {
    return this.fDescription.getDisplayName();
  }
  
  public String getTrace()
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    getException().printStackTrace(localPrintWriter);
    return localStringWriter.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getTestHeader());
    localStringBuilder.append(": ");
    localStringBuilder.append(this.fThrownException.getMessage());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runner\notification\Failure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */