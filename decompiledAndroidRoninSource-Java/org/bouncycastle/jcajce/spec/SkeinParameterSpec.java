package org.bouncycastle.jcajce.spec;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.spec.AlgorithmParameterSpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;

public class SkeinParameterSpec
  implements AlgorithmParameterSpec
{
  public static final int PARAM_TYPE_CONFIG = 4;
  public static final int PARAM_TYPE_KEY = 0;
  public static final int PARAM_TYPE_KEY_IDENTIFIER = 16;
  public static final int PARAM_TYPE_MESSAGE = 48;
  public static final int PARAM_TYPE_NONCE = 20;
  public static final int PARAM_TYPE_OUTPUT = 63;
  public static final int PARAM_TYPE_PERSONALISATION = 8;
  public static final int PARAM_TYPE_PUBLIC_KEY = 12;
  private Map parameters;
  
  public SkeinParameterSpec()
  {
    this(new HashMap());
  }
  
  private SkeinParameterSpec(Map paramMap)
  {
    this.parameters = Collections.unmodifiableMap(paramMap);
  }
  
  public byte[] getKey()
  {
    return Arrays.clone((byte[])this.parameters.get(Integers.valueOf(0)));
  }
  
  public byte[] getKeyIdentifier()
  {
    return Arrays.clone((byte[])this.parameters.get(Integers.valueOf(16)));
  }
  
  public byte[] getNonce()
  {
    return Arrays.clone((byte[])this.parameters.get(Integers.valueOf(20)));
  }
  
  public Map getParameters()
  {
    return this.parameters;
  }
  
  public byte[] getPersonalisation()
  {
    return Arrays.clone((byte[])this.parameters.get(Integers.valueOf(8)));
  }
  
  public byte[] getPublicKey()
  {
    return Arrays.clone((byte[])this.parameters.get(Integers.valueOf(12)));
  }
  
  public static class Builder
  {
    private Map parameters = new HashMap();
    
    public Builder() {}
    
    public Builder(SkeinParameterSpec paramSkeinParameterSpec)
    {
      Iterator localIterator = paramSkeinParameterSpec.parameters.keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        this.parameters.put(localInteger, paramSkeinParameterSpec.parameters.get(localInteger));
      }
    }
    
    public SkeinParameterSpec build()
    {
      return new SkeinParameterSpec(this.parameters, null);
    }
    
    public Builder set(int paramInt, byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null)
      {
        if ((paramInt != 0) && ((paramInt <= 4) || (paramInt >= 63) || (paramInt == 48))) {
          throw new IllegalArgumentException("Parameter types must be in the range 0,5..47,49..62.");
        }
        if (paramInt != 4)
        {
          this.parameters.put(Integers.valueOf(paramInt), paramArrayOfByte);
          return this;
        }
        throw new IllegalArgumentException("Parameter type 4 is reserved for internal use.");
      }
      throw new IllegalArgumentException("Parameter value must not be null.");
    }
    
    public Builder setKey(byte[] paramArrayOfByte)
    {
      return set(0, paramArrayOfByte);
    }
    
    public Builder setKeyIdentifier(byte[] paramArrayOfByte)
    {
      return set(16, paramArrayOfByte);
    }
    
    public Builder setNonce(byte[] paramArrayOfByte)
    {
      return set(20, paramArrayOfByte);
    }
    
    public Builder setPersonalisation(Date paramDate, String paramString1, String paramString2)
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localByteArrayOutputStream, "UTF-8");
        localOutputStreamWriter.write(new SimpleDateFormat("YYYYMMDD").format(paramDate));
        localOutputStreamWriter.write(" ");
        localOutputStreamWriter.write(paramString1);
        localOutputStreamWriter.write(" ");
        localOutputStreamWriter.write(paramString2);
        localOutputStreamWriter.close();
        paramDate = set(8, localByteArrayOutputStream.toByteArray());
        return paramDate;
      }
      catch (IOException paramDate)
      {
        paramString1 = new StringBuilder();
        paramString1.append("Byte I/O failed: ");
        paramString1.append(paramDate);
        throw new IllegalStateException(paramString1.toString());
      }
    }
    
    public Builder setPersonalisation(Date paramDate, Locale paramLocale, String paramString1, String paramString2)
    {
      try
      {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localByteArrayOutputStream, "UTF-8");
        localOutputStreamWriter.write(new SimpleDateFormat("YYYYMMDD", paramLocale).format(paramDate));
        localOutputStreamWriter.write(" ");
        localOutputStreamWriter.write(paramString1);
        localOutputStreamWriter.write(" ");
        localOutputStreamWriter.write(paramString2);
        localOutputStreamWriter.close();
        paramDate = set(8, localByteArrayOutputStream.toByteArray());
        return paramDate;
      }
      catch (IOException paramDate)
      {
        paramLocale = new StringBuilder();
        paramLocale.append("Byte I/O failed: ");
        paramLocale.append(paramDate);
        throw new IllegalStateException(paramLocale.toString());
      }
    }
    
    public Builder setPersonalisation(byte[] paramArrayOfByte)
    {
      return set(8, paramArrayOfByte);
    }
    
    public Builder setPublicKey(byte[] paramArrayOfByte)
    {
      return set(12, paramArrayOfByte);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\spec\SkeinParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */