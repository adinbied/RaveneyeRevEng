package org.junit.internal.requests;

import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;

public final class FilterRequest
  extends Request
{
  private final Filter fFilter;
  private final Request request;
  
  public FilterRequest(Request paramRequest, Filter paramFilter)
  {
    this.request = paramRequest;
    this.fFilter = paramFilter;
  }
  
  public Runner getRunner()
  {
    try
    {
      Runner localRunner = this.request.getRunner();
      this.fFilter.apply(localRunner);
      return localRunner;
    }
    catch (NoTestsRemainException localNoTestsRemainException)
    {
      for (;;) {}
    }
    return new ErrorReportingRunner(Filter.class, new Exception(String.format("No tests found matching %s from %s", new Object[] { this.fFilter.describe(), this.request.toString() })));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\requests\FilterRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */