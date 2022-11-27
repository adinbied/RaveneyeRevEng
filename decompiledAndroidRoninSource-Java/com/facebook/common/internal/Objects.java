package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class Objects
{
  @CheckReturnValue
  public static boolean equal(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static <T> T firstNonNull(@Nullable T paramT1, @Nullable T paramT2)
  {
    if (paramT1 != null) {
      return paramT1;
    }
    return (T)Preconditions.checkNotNull(paramT2);
  }
  
  public static int hashCode(@Nullable Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static ToStringHelper toStringHelper(Class<?> paramClass)
  {
    return new ToStringHelper(paramClass.getSimpleName(), null);
  }
  
  public static ToStringHelper toStringHelper(Object paramObject)
  {
    return new ToStringHelper(paramObject.getClass().getSimpleName(), null);
  }
  
  public static ToStringHelper toStringHelper(String paramString)
  {
    return new ToStringHelper(paramString, null);
  }
  
  public static final class ToStringHelper
  {
    private final String className;
    private final ValueHolder holderHead;
    private ValueHolder holderTail;
    private boolean omitNullValues;
    
    private ToStringHelper(String paramString)
    {
      ValueHolder localValueHolder = new ValueHolder(null);
      this.holderHead = localValueHolder;
      this.holderTail = localValueHolder;
      this.omitNullValues = false;
      this.className = ((String)Preconditions.checkNotNull(paramString));
    }
    
    private ValueHolder addHolder()
    {
      ValueHolder localValueHolder = new ValueHolder(null);
      this.holderTail.next = localValueHolder;
      this.holderTail = localValueHolder;
      return localValueHolder;
    }
    
    private ToStringHelper addHolder(@Nullable Object paramObject)
    {
      addHolder().value = paramObject;
      return this;
    }
    
    private ToStringHelper addHolder(String paramString, @Nullable Object paramObject)
    {
      ValueHolder localValueHolder = addHolder();
      localValueHolder.value = paramObject;
      localValueHolder.name = ((String)Preconditions.checkNotNull(paramString));
      return this;
    }
    
    public ToStringHelper add(String paramString, char paramChar)
    {
      return addHolder(paramString, String.valueOf(paramChar));
    }
    
    public ToStringHelper add(String paramString, double paramDouble)
    {
      return addHolder(paramString, String.valueOf(paramDouble));
    }
    
    public ToStringHelper add(String paramString, float paramFloat)
    {
      return addHolder(paramString, String.valueOf(paramFloat));
    }
    
    public ToStringHelper add(String paramString, int paramInt)
    {
      return addHolder(paramString, String.valueOf(paramInt));
    }
    
    public ToStringHelper add(String paramString, long paramLong)
    {
      return addHolder(paramString, String.valueOf(paramLong));
    }
    
    public ToStringHelper add(String paramString, @Nullable Object paramObject)
    {
      return addHolder(paramString, paramObject);
    }
    
    public ToStringHelper add(String paramString, boolean paramBoolean)
    {
      return addHolder(paramString, String.valueOf(paramBoolean));
    }
    
    public ToStringHelper addValue(char paramChar)
    {
      return addHolder(String.valueOf(paramChar));
    }
    
    public ToStringHelper addValue(double paramDouble)
    {
      return addHolder(String.valueOf(paramDouble));
    }
    
    public ToStringHelper addValue(float paramFloat)
    {
      return addHolder(String.valueOf(paramFloat));
    }
    
    public ToStringHelper addValue(int paramInt)
    {
      return addHolder(String.valueOf(paramInt));
    }
    
    public ToStringHelper addValue(long paramLong)
    {
      return addHolder(String.valueOf(paramLong));
    }
    
    public ToStringHelper addValue(@Nullable Object paramObject)
    {
      return addHolder(paramObject);
    }
    
    public ToStringHelper addValue(boolean paramBoolean)
    {
      return addHolder(String.valueOf(paramBoolean));
    }
    
    public ToStringHelper omitNullValues()
    {
      this.omitNullValues = true;
      return this;
    }
    
    public String toString()
    {
      boolean bool = this.omitNullValues;
      StringBuilder localStringBuilder = new StringBuilder(32);
      localStringBuilder.append(this.className);
      localStringBuilder.append('{');
      ValueHolder localValueHolder = this.holderHead.next;
      Object localObject2;
      for (Object localObject1 = ""; localValueHolder != null; localObject1 = localObject2)
      {
        Object localObject3 = localValueHolder.value;
        if (bool)
        {
          localObject2 = localObject1;
          if (localObject3 == null) {}
        }
        else
        {
          localStringBuilder.append((String)localObject1);
          if (localValueHolder.name != null)
          {
            localStringBuilder.append(localValueHolder.name);
            localStringBuilder.append('=');
          }
          if ((localObject3 != null) && (localObject3.getClass().isArray()))
          {
            localObject1 = Arrays.deepToString(new Object[] { localObject3 });
            localStringBuilder.append((CharSequence)localObject1, 1, ((String)localObject1).length() - 1);
          }
          else
          {
            localStringBuilder.append(localObject3);
          }
          localObject2 = ", ";
        }
        localValueHolder = localValueHolder.next;
      }
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    private static final class ValueHolder
    {
      @Nullable
      String name;
      @Nullable
      ValueHolder next;
      @Nullable
      Object value;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\internal\Objects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */