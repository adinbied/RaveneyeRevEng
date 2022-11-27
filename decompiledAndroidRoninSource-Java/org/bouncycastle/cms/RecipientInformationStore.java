package org.bouncycastle.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.util.Iterable;

public class RecipientInformationStore
  implements Iterable<RecipientInformation>
{
  private final List all;
  private final Map table = new HashMap();
  
  public RecipientInformationStore(Collection<RecipientInformation> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      RecipientInformation localRecipientInformation = (RecipientInformation)localIterator.next();
      RecipientId localRecipientId = localRecipientInformation.getRID();
      ArrayList localArrayList2 = (ArrayList)this.table.get(localRecipientId);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList(1);
        this.table.put(localRecipientId, localArrayList1);
      }
      localArrayList1.add(localRecipientInformation);
    }
    this.all = new ArrayList(paramCollection);
  }
  
  public RecipientInformationStore(RecipientInformation paramRecipientInformation)
  {
    ArrayList localArrayList = new ArrayList(1);
    this.all = localArrayList;
    localArrayList.add(paramRecipientInformation);
    paramRecipientInformation = paramRecipientInformation.getRID();
    this.table.put(paramRecipientInformation, this.all);
  }
  
  public RecipientInformation get(RecipientId paramRecipientId)
  {
    paramRecipientId = getRecipients(paramRecipientId);
    if (paramRecipientId.size() == 0) {
      return null;
    }
    return (RecipientInformation)paramRecipientId.iterator().next();
  }
  
  public Collection<RecipientInformation> getRecipients()
  {
    return new ArrayList(this.all);
  }
  
  public Collection<Recipient> getRecipients(RecipientId paramRecipientId)
  {
    if ((paramRecipientId instanceof KeyTransRecipientId))
    {
      Object localObject2 = (KeyTransRecipientId)paramRecipientId;
      X500Name localX500Name = ((KeyTransRecipientId)localObject2).getIssuer();
      Object localObject1 = ((KeyTransRecipientId)localObject2).getSubjectKeyIdentifier();
      if ((localX500Name != null) && (localObject1 != null))
      {
        paramRecipientId = new ArrayList();
        localObject2 = getRecipients(new KeyTransRecipientId(localX500Name, ((KeyTransRecipientId)localObject2).getSerialNumber()));
        if (localObject2 != null) {
          paramRecipientId.addAll((Collection)localObject2);
        }
        localObject1 = getRecipients(new KeyTransRecipientId((byte[])localObject1));
        if (localObject1 != null) {
          paramRecipientId.addAll((Collection)localObject1);
        }
        return paramRecipientId;
      }
    }
    paramRecipientId = (ArrayList)this.table.get(paramRecipientId);
    if (paramRecipientId == null) {
      return new ArrayList();
    }
    return new ArrayList(paramRecipientId);
  }
  
  public Iterator<RecipientInformation> iterator()
  {
    return getRecipients().iterator();
  }
  
  public int size()
  {
    return this.all.size();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\RecipientInformationStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */