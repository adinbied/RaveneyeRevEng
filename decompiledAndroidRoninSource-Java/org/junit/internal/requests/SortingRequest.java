package org.junit.internal.requests;

import java.util.Comparator;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Sorter;

public class SortingRequest
  extends Request
{
  private final Comparator<Description> comparator;
  private final Request request;
  
  public SortingRequest(Request paramRequest, Comparator<Description> paramComparator)
  {
    this.request = paramRequest;
    this.comparator = paramComparator;
  }
  
  public Runner getRunner()
  {
    Runner localRunner = this.request.getRunner();
    new Sorter(this.comparator).apply(localRunner);
    return localRunner;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\requests\SortingRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */