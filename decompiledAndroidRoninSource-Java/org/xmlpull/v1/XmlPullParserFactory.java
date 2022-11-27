package org.xmlpull.v1;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class XmlPullParserFactory
{
  public static final String PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
  private static final String RESOURCE_NAME = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory";
  static final Class referenceContextClass = new XmlPullParserFactory().getClass();
  protected String classNamesLocation;
  protected Hashtable features = new Hashtable();
  protected Vector parserClasses;
  protected Vector serializerClasses;
  
  public static XmlPullParserFactory newInstance()
    throws XmlPullParserException
  {
    return newInstance(null, null);
  }
  
  public static XmlPullParserFactory newInstance(String paramString, Class paramClass)
    throws XmlPullParserException
  {
    Object localObject1 = paramClass;
    if (paramClass == null) {
      localObject1 = referenceContextClass;
    }
    String str1;
    if ((paramString != null) && (paramString.length() != 0) && (!"DEFAULT".equals(paramString)))
    {
      paramClass = new StringBuffer();
      paramClass.append("parameter classNames to newInstance() that contained '");
      paramClass.append(paramString);
      paramClass.append("'");
      localObject1 = paramClass.toString();
      str1 = paramString;
    }
    for (;;)
    {
      try
      {
        paramString = ((Class)localObject1).getResourceAsStream("/META-INF/services/org.xmlpull.v1.XmlPullParserFactory");
        if (paramString != null)
        {
          paramClass = new StringBuffer();
          i = paramString.read();
          if (i < 0)
          {
            paramString.close();
            str1 = paramClass.toString();
            paramString = new StringBuffer();
            paramString.append("resource /META-INF/services/org.xmlpull.v1.XmlPullParserFactory that contained '");
            paramString.append(str1);
            paramString.append("'");
            localObject1 = paramString.toString();
            localVector1 = new Vector();
            localVector2 = new Vector();
            paramString = null;
            i = 0;
            if (i >= str1.length())
            {
              paramClass = paramString;
              if (paramString == null) {
                paramClass = new XmlPullParserFactory();
              }
              paramClass.parserClasses = localVector1;
              paramClass.serializerClasses = localVector2;
              paramClass.classNamesLocation = ((String)localObject1);
              return paramClass;
            }
            k = str1.indexOf(',', i);
            j = k;
            if (k == -1) {
              j = str1.length();
            }
            str2 = str1.substring(i, j);
          }
        }
      }
      catch (Exception paramString)
      {
        int i;
        Vector localVector1;
        Vector localVector2;
        int k;
        int j;
        String str2;
        Object localObject2;
        Object localObject3;
        boolean bool;
        char c;
        throw new XmlPullParserException(null, null, paramString);
      }
      try
      {
        paramClass = Class.forName(str2);
      }
      catch (Exception paramClass)
      {
        continue;
      }
      try
      {
        localObject2 = paramClass.newInstance();
      }
      catch (Exception localException)
      {
        continue;
      }
      paramClass = null;
      localObject2 = null;
      localObject3 = paramString;
      if (paramClass != null)
      {
        bool = localObject2 instanceof XmlPullParser;
        k = 1;
        if (bool)
        {
          localVector1.addElement(paramClass);
          i = 1;
        }
        else
        {
          i = 0;
        }
        if ((localObject2 instanceof XmlSerializer))
        {
          localVector2.addElement(paramClass);
          i = 1;
        }
        if ((localObject2 instanceof XmlPullParserFactory))
        {
          paramClass = paramString;
          i = k;
          if (paramString == null)
          {
            paramClass = (XmlPullParserFactory)localObject2;
            i = k;
          }
        }
        else
        {
          paramClass = paramString;
        }
        if (i != 0)
        {
          localObject3 = paramClass;
        }
        else
        {
          paramString = new StringBuffer();
          paramString.append("incompatible class: ");
          paramString.append(str2);
          throw new XmlPullParserException(paramString.toString());
        }
      }
      i = j + 1;
      paramString = (String)localObject3;
      continue;
      if (i > 32)
      {
        c = (char)i;
        paramClass.append(c);
      }
    }
    throw new XmlPullParserException("resource not found: /META-INF/services/org.xmlpull.v1.XmlPullParserFactory make sure that parser implementing XmlPull API is available");
  }
  
  public boolean getFeature(String paramString)
  {
    paramString = (Boolean)this.features.get(paramString);
    if (paramString != null) {
      return paramString.booleanValue();
    }
    return false;
  }
  
  public boolean isNamespaceAware()
  {
    return getFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces");
  }
  
  public boolean isValidating()
  {
    return getFeature("http://xmlpull.org/v1/doc/features.html#validation");
  }
  
  public XmlPullParser newPullParser()
    throws XmlPullParserException
  {
    Object localObject1 = this.parserClasses;
    if (localObject1 != null)
    {
      if (((Vector)localObject1).size() != 0)
      {
        localObject1 = new StringBuffer();
        int i = 0;
        for (;;)
        {
          if (i < this.parserClasses.size())
          {
            localObject2 = (Class)this.parserClasses.elementAt(i);
            try
            {
              XmlPullParser localXmlPullParser = (XmlPullParser)((Class)localObject2).newInstance();
              localObject3 = this.features.keys();
              for (;;)
              {
                if (!((Enumeration)localObject3).hasMoreElements()) {
                  return localXmlPullParser;
                }
                String str = (String)((Enumeration)localObject3).nextElement();
                Boolean localBoolean = (Boolean)this.features.get(str);
                if ((localBoolean != null) && (localBoolean.booleanValue())) {
                  localXmlPullParser.setFeature(str, true);
                }
              }
            }
            catch (Exception localException)
            {
              Object localObject3 = new StringBuffer();
              ((StringBuffer)localObject3).append(((Class)localObject2).getName());
              ((StringBuffer)localObject3).append(": ");
              ((StringBuffer)localObject3).append(localException.toString());
              ((StringBuffer)localObject3).append("; ");
              ((StringBuffer)localObject1).append(((StringBuffer)localObject3).toString());
              i += 1;
            }
          }
        }
        Object localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("could not create parser: ");
        ((StringBuffer)localObject2).append(localObject1);
        throw new XmlPullParserException(((StringBuffer)localObject2).toString());
      }
      localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append("No valid parser classes found in ");
      ((StringBuffer)localObject1).append(this.classNamesLocation);
      throw new XmlPullParserException(((StringBuffer)localObject1).toString());
    }
    localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append("Factory initialization was incomplete - has not tried ");
    ((StringBuffer)localObject1).append(this.classNamesLocation);
    throw new XmlPullParserException(((StringBuffer)localObject1).toString());
  }
  
  public XmlSerializer newSerializer()
    throws XmlPullParserException
  {
    Object localObject1 = this.serializerClasses;
    if (localObject1 != null)
    {
      if (((Vector)localObject1).size() != 0)
      {
        localObject1 = new StringBuffer();
        int i = 0;
        while (i < this.serializerClasses.size())
        {
          localObject2 = (Class)this.serializerClasses.elementAt(i);
          try
          {
            XmlSerializer localXmlSerializer = (XmlSerializer)((Class)localObject2).newInstance();
            return localXmlSerializer;
          }
          catch (Exception localException)
          {
            StringBuffer localStringBuffer = new StringBuffer();
            localStringBuffer.append(((Class)localObject2).getName());
            localStringBuffer.append(": ");
            localStringBuffer.append(localException.toString());
            localStringBuffer.append("; ");
            ((StringBuffer)localObject1).append(localStringBuffer.toString());
            i += 1;
          }
        }
        Object localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("could not create serializer: ");
        ((StringBuffer)localObject2).append(localObject1);
        throw new XmlPullParserException(((StringBuffer)localObject2).toString());
      }
      localObject1 = new StringBuffer();
      ((StringBuffer)localObject1).append("No valid serializer classes found in ");
      ((StringBuffer)localObject1).append(this.classNamesLocation);
      throw new XmlPullParserException(((StringBuffer)localObject1).toString());
    }
    localObject1 = new StringBuffer();
    ((StringBuffer)localObject1).append("Factory initialization incomplete - has not tried ");
    ((StringBuffer)localObject1).append(this.classNamesLocation);
    throw new XmlPullParserException(((StringBuffer)localObject1).toString());
  }
  
  public void setFeature(String paramString, boolean paramBoolean)
    throws XmlPullParserException
  {
    this.features.put(paramString, new Boolean(paramBoolean));
  }
  
  public void setNamespaceAware(boolean paramBoolean)
  {
    this.features.put("http://xmlpull.org/v1/doc/features.html#process-namespaces", new Boolean(paramBoolean));
  }
  
  public void setValidating(boolean paramBoolean)
  {
    this.features.put("http://xmlpull.org/v1/doc/features.html#validation", new Boolean(paramBoolean));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\xmlpull\v1\XmlPullParserFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */