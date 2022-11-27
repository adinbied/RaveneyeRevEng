package org.junit.runner.manipulation;

import java.util.Comparator;
import org.junit.runner.Description;

public class Sorter
  implements Comparator<Description>
{
  public static final Sorter NULL = new Sorter(new Comparator()
  {
    public int compare(Description paramAnonymousDescription1, Description paramAnonymousDescription2)
    {
      return 0;
    }
  });
  private final Comparator<Description> comparator;
  
  public Sorter(Comparator<Description> paramComparator)
  {
    this.comparator = paramComparator;
  }
  
  public void apply(Object paramObject)
  {
    if ((paramObject instanceof Sortable)) {
      ((Sortable)paramObject).sort(this);
    }
  }
  
  public int compare(Description paramDescription1, Description paramDescription2)
  {
    return this.comparator.compare(paramDescription1, paramDescription2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runner\manipulation\Sorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */