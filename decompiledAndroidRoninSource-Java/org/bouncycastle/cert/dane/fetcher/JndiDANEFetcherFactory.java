package org.bouncycastle.cert.dane.fetcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.naming.Binding;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import org.bouncycastle.cert.dane.DANEEntry;
import org.bouncycastle.cert.dane.DANEEntryFetcher;
import org.bouncycastle.cert.dane.DANEEntryFetcherFactory;
import org.bouncycastle.cert.dane.DANEException;

public class JndiDANEFetcherFactory
  implements DANEEntryFetcherFactory
{
  private static final String DANE_TYPE = "53";
  private List dnsServerList = new ArrayList();
  private boolean isAuthoritative;
  
  private void addEntries(List paramList, String paramString, Attribute paramAttribute)
    throws NamingException, DANEException
  {
    int i = 0;
    while (i != paramAttribute.size())
    {
      byte[] arrayOfByte = (byte[])paramAttribute.get(i);
      if (DANEEntry.isValidCertificate(arrayOfByte)) {
        try
        {
          paramList.add(new DANEEntry(paramString, arrayOfByte));
        }
        catch (IOException paramList)
        {
          paramString = new StringBuilder();
          paramString.append("Exception parsing entry: ");
          paramString.append(paramList.getMessage());
          throw new DANEException(paramString.toString(), paramList);
        }
      }
      i += 1;
    }
  }
  
  public DANEEntryFetcher build(final String paramString)
  {
    final Hashtable localHashtable = new Hashtable();
    localHashtable.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
    Object localObject;
    if (this.isAuthoritative) {
      localObject = "true";
    } else {
      localObject = "false";
    }
    localHashtable.put("java.naming.authoritative", localObject);
    if (this.dnsServerList.size() > 0)
    {
      localObject = new StringBuffer();
      Iterator localIterator = this.dnsServerList.iterator();
      while (localIterator.hasNext())
      {
        if (((StringBuffer)localObject).length() > 0) {
          ((StringBuffer)localObject).append(" ");
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dns://");
        localStringBuilder.append(localIterator.next());
        ((StringBuffer)localObject).append(localStringBuilder.toString());
      }
      localHashtable.put("java.naming.provider.url", ((StringBuffer)localObject).toString());
    }
    new DANEEntryFetcher()
    {
      public List getEntries()
        throws DANEException
      {
        ArrayList localArrayList = new ArrayList();
        try
        {
          localObject1 = new InitialDirContext(localHashtable);
          int i = paramString.indexOf("_smimecert.");
          if (i > 0)
          {
            localObject1 = ((DirContext)localObject1).getAttributes(paramString, new String[] { "53" }).get("53");
            if (localObject1 != null)
            {
              JndiDANEFetcherFactory.this.addEntries(localArrayList, paramString, (Attribute)localObject1);
              return localArrayList;
            }
          }
          else
          {
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("_smimecert.");
            ((StringBuilder)localObject2).append(paramString);
            localObject2 = ((DirContext)localObject1).listBindings(((StringBuilder)localObject2).toString());
            while (((NamingEnumeration)localObject2).hasMore())
            {
              Object localObject3 = (DirContext)((Binding)((NamingEnumeration)localObject2).next()).getObject();
              Attribute localAttribute = ((DirContext)localObject1).getAttributes(((DirContext)localObject3).getNameInNamespace().substring(1, ((DirContext)localObject3).getNameInNamespace().length() - 1), new String[] { "53" }).get("53");
              if (localAttribute != null)
              {
                localObject3 = ((DirContext)localObject3).getNameInNamespace();
                localObject3 = ((String)localObject3).substring(1, ((String)localObject3).length() - 1);
                JndiDANEFetcherFactory.this.addEntries(localArrayList, (String)localObject3, localAttribute);
              }
            }
          }
          return localArrayList;
        }
        catch (NamingException localNamingException)
        {
          Object localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Exception dealing with DNS: ");
          ((StringBuilder)localObject1).append(localNamingException.getMessage());
          throw new DANEException(((StringBuilder)localObject1).toString(), localNamingException);
        }
      }
    };
  }
  
  public JndiDANEFetcherFactory setAuthoritative(boolean paramBoolean)
  {
    this.isAuthoritative = paramBoolean;
    return this;
  }
  
  public JndiDANEFetcherFactory usingDNSServer(String paramString)
  {
    this.dnsServerList.add(paramString);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\dane\fetcher\JndiDANEFetcherFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */