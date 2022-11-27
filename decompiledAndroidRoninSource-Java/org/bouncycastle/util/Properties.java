package org.bouncycastle.util;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Properties
{
  public static Set<String> asKeySet(String paramString)
  {
    HashSet localHashSet = new HashSet();
    paramString = System.getProperty(paramString);
    if (paramString != null)
    {
      paramString = new StringTokenizer(paramString, ",");
      while (paramString.hasMoreElements()) {
        localHashSet.add(Strings.toLowerCase(paramString.nextToken()).trim());
      }
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public static boolean isOverrideSet(String paramString)
  {
    try
    {
      boolean bool = "true".equals(AccessController.doPrivileged(new PrivilegedAction()
      {
        public Object run()
        {
          String str = System.getProperty(this.val$propertyName);
          if (str == null) {
            return null;
          }
          return Strings.toLowerCase(str);
        }
      }));
      return bool;
    }
    catch (AccessControlException paramString)
    {
      for (;;) {}
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\Properties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */