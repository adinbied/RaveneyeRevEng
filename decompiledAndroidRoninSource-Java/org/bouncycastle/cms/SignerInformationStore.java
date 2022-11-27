package org.bouncycastle.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.util.Iterable;

public class SignerInformationStore
  implements Iterable<SignerInformation>
{
  private List all = new ArrayList();
  private Map table = new HashMap();
  
  public SignerInformationStore(Collection<SignerInformation> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      SignerInformation localSignerInformation = (SignerInformation)localIterator.next();
      SignerId localSignerId = localSignerInformation.getSID();
      ArrayList localArrayList2 = (ArrayList)this.table.get(localSignerId);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList(1);
        this.table.put(localSignerId, localArrayList1);
      }
      localArrayList1.add(localSignerInformation);
    }
    this.all = new ArrayList(paramCollection);
  }
  
  public SignerInformationStore(SignerInformation paramSignerInformation)
  {
    ArrayList localArrayList = new ArrayList(1);
    this.all = localArrayList;
    localArrayList.add(paramSignerInformation);
    paramSignerInformation = paramSignerInformation.getSID();
    this.table.put(paramSignerInformation, this.all);
  }
  
  public SignerInformation get(SignerId paramSignerId)
  {
    paramSignerId = getSigners(paramSignerId);
    if (paramSignerId.size() == 0) {
      return null;
    }
    return (SignerInformation)paramSignerId.iterator().next();
  }
  
  public Collection<SignerInformation> getSigners()
  {
    return new ArrayList(this.all);
  }
  
  public Collection<SignerInformation> getSigners(SignerId paramSignerId)
  {
    if ((paramSignerId.getIssuer() != null) && (paramSignerId.getSubjectKeyIdentifier() != null))
    {
      ArrayList localArrayList = new ArrayList();
      Collection localCollection = getSigners(new SignerId(paramSignerId.getIssuer(), paramSignerId.getSerialNumber()));
      if (localCollection != null) {
        localArrayList.addAll(localCollection);
      }
      paramSignerId = getSigners(new SignerId(paramSignerId.getSubjectKeyIdentifier()));
      if (paramSignerId != null) {
        localArrayList.addAll(paramSignerId);
      }
      return localArrayList;
    }
    paramSignerId = (ArrayList)this.table.get(paramSignerId);
    if (paramSignerId == null) {
      return new ArrayList();
    }
    return new ArrayList(paramSignerId);
  }
  
  public Iterator<SignerInformation> iterator()
  {
    return getSigners().iterator();
  }
  
  public int size()
  {
    return this.all.size();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\SignerInformationStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */