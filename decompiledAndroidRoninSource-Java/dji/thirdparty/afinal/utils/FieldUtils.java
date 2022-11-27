package dji.thirdparty.afinal.utils;

import dji.thirdparty.afinal.annotation.sqlite.Id;
import dji.thirdparty.afinal.annotation.sqlite.ManyToOne;
import dji.thirdparty.afinal.annotation.sqlite.OneToMany;
import dji.thirdparty.afinal.annotation.sqlite.Property;
import dji.thirdparty.afinal.annotation.sqlite.Transient;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

public class FieldUtils
{
  public static final ThreadLocal<SimpleDateFormat> SDF = new ThreadLocal() {};
  
  public static Method getBooleanFieldGetMethod(Class<?> paramClass, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("is");
    ((StringBuilder)localObject).append(paramString.substring(0, 1).toUpperCase());
    ((StringBuilder)localObject).append(paramString.substring(1));
    localObject = ((StringBuilder)localObject).toString();
    if (!isISStart(paramString)) {
      paramString = (String)localObject;
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, new Class[0]);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Method getBooleanFieldSetMethod(Class<?> paramClass, Field paramField)
  {
    String str = paramField.getName();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("set");
    ((StringBuilder)localObject).append(str.substring(0, 1).toUpperCase());
    ((StringBuilder)localObject).append(str.substring(1));
    localObject = ((StringBuilder)localObject).toString();
    if (isISStart(paramField.getName()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("set");
      ((StringBuilder)localObject).append(str.substring(2, 3).toUpperCase());
      ((StringBuilder)localObject).append(str.substring(3));
      localObject = ((StringBuilder)localObject).toString();
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod((String)localObject, new Class[] { paramField.getType() });
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static String getColumnByField(Field paramField)
  {
    Object localObject = (Property)paramField.getAnnotation(Property.class);
    if ((localObject != null) && (((Property)localObject).column().trim().length() != 0)) {
      return ((Property)localObject).column();
    }
    localObject = (ManyToOne)paramField.getAnnotation(ManyToOne.class);
    if ((localObject != null) && (((ManyToOne)localObject).column().trim().length() != 0)) {
      return ((ManyToOne)localObject).column();
    }
    localObject = (OneToMany)paramField.getAnnotation(OneToMany.class);
    if ((localObject != null) && (((OneToMany)localObject).manyColumn() != null) && (((OneToMany)localObject).manyColumn().trim().length() != 0)) {
      return ((OneToMany)localObject).manyColumn();
    }
    localObject = (Id)paramField.getAnnotation(Id.class);
    if ((localObject != null) && (((Id)localObject).column().trim().length() != 0)) {
      return ((Id)localObject).column();
    }
    return paramField.getName();
  }
  
  public static Field getFieldByColumnName(Class<?> paramClass, String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramString != null)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      localObject1 = localObject3;
      if (arrayOfField != null)
      {
        localObject1 = localObject3;
        if (arrayOfField.length > 0)
        {
          localObject1 = localObject2;
          if (paramString.equals(ClassUtils.getPrimaryKeyColumn(paramClass))) {
            localObject1 = ClassUtils.getPrimaryKeyField(paramClass);
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            int j = arrayOfField.length;
            int i = 0;
            for (;;)
            {
              localObject2 = localObject1;
              if (i >= j) {
                break;
              }
              localObject2 = arrayOfField[i];
              localObject3 = (Property)((Field)localObject2).getAnnotation(Property.class);
              if ((localObject3 == null) || (!paramString.equals(((Property)localObject3).column())))
              {
                localObject3 = (ManyToOne)((Field)localObject2).getAnnotation(ManyToOne.class);
                if ((localObject3 != null) && (((ManyToOne)localObject3).column().trim().length() != 0)) {
                  break;
                }
              }
              i += 1;
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = getFieldByName(paramClass, paramString);
          }
        }
      }
    }
    return (Field)localObject1;
  }
  
  public static Field getFieldByName(Class<?> paramClass, String paramString)
  {
    if (paramString != null) {
      try
      {
        paramClass = paramClass.getDeclaredField(paramString);
        return paramClass;
      }
      catch (NoSuchFieldException paramClass)
      {
        paramClass.printStackTrace();
      }
      catch (SecurityException paramClass)
      {
        paramClass.printStackTrace();
      }
    }
    return null;
  }
  
  public static Method getFieldGetMethod(Class<?> paramClass, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get");
    localStringBuilder.append(paramString.substring(0, 1).toUpperCase());
    localStringBuilder.append(paramString.substring(1));
    paramString = localStringBuilder.toString();
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, new Class[0]);
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static Method getFieldGetMethod(Class<?> paramClass, Field paramField)
  {
    String str = paramField.getName();
    if (paramField.getType() == Boolean.TYPE) {
      paramField = getBooleanFieldGetMethod(paramClass, str);
    } else {
      paramField = null;
    }
    Object localObject = paramField;
    if (paramField == null) {
      localObject = getFieldGetMethod(paramClass, str);
    }
    return (Method)localObject;
  }
  
  public static Method getFieldSetMethod(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = getFieldSetMethod(paramClass, paramClass.getDeclaredField(paramString));
      return paramClass;
    }
    catch (NoSuchFieldException paramClass)
    {
      paramClass.printStackTrace();
    }
    catch (SecurityException paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static Method getFieldSetMethod(Class<?> paramClass, Field paramField)
  {
    Object localObject = paramField.getName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set");
    localStringBuilder.append(((String)localObject).substring(0, 1).toUpperCase());
    localStringBuilder.append(((String)localObject).substring(1));
    localObject = localStringBuilder.toString();
    try
    {
      localObject = paramClass.getDeclaredMethod((String)localObject, new Class[] { paramField.getType() });
      return (Method)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    if (paramField.getType() == Boolean.TYPE) {
      return getBooleanFieldSetMethod(paramClass, paramField);
    }
    return null;
  }
  
  public static Object getFieldValue(Object paramObject, String paramString)
  {
    return invoke(paramObject, getFieldGetMethod(paramObject.getClass(), paramString));
  }
  
  public static Object getFieldValue(Object paramObject, Field paramField)
  {
    return invoke(paramObject, getFieldGetMethod(paramObject.getClass(), paramField));
  }
  
  public static String getPropertyDefaultValue(Field paramField)
  {
    paramField = (Property)paramField.getAnnotation(Property.class);
    if ((paramField != null) && (paramField.defaultValue().trim().length() != 0)) {
      return paramField.defaultValue();
    }
    return null;
  }
  
  private static Object invoke(Object paramObject, Method paramMethod)
  {
    if (paramObject != null)
    {
      if (paramMethod == null) {
        return null;
      }
      try
      {
        paramObject = paramMethod.invoke(paramObject, new Object[0]);
        return paramObject;
      }
      catch (InvocationTargetException paramObject)
      {
        ((InvocationTargetException)paramObject).printStackTrace();
        return null;
      }
      catch (IllegalAccessException paramObject)
      {
        ((IllegalAccessException)paramObject).printStackTrace();
        return null;
      }
      catch (IllegalArgumentException paramObject)
      {
        ((IllegalArgumentException)paramObject).printStackTrace();
      }
    }
    return null;
  }
  
  public static boolean isBaseDateType(Field paramField)
  {
    paramField = paramField.getType();
    return (paramField.equals(String.class)) || (paramField.equals(Integer.class)) || (paramField.equals(Byte.class)) || (paramField.equals(Long.class)) || (paramField.equals(Double.class)) || (paramField.equals(Float.class)) || (paramField.equals(Character.class)) || (paramField.equals(Short.class)) || (paramField.equals(Boolean.class)) || (paramField.equals(java.util.Date.class)) || (paramField.equals(java.util.Date.class)) || (paramField.equals(java.sql.Date.class)) || (paramField.equals(byte[].class)) || (paramField.isPrimitive());
  }
  
  private static boolean isISStart(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        return false;
      }
      bool1 = bool2;
      if (paramString.startsWith("is"))
      {
        bool1 = bool2;
        if (!Character.isLowerCase(paramString.charAt(2))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isManyToOne(Field paramField)
  {
    return paramField.getAnnotation(ManyToOne.class) != null;
  }
  
  public static boolean isManyToOneOrOneToMany(Field paramField)
  {
    return (isManyToOne(paramField)) || (isOneToMany(paramField));
  }
  
  public static boolean isOneToMany(Field paramField)
  {
    return paramField.getAnnotation(OneToMany.class) != null;
  }
  
  public static boolean isTransient(Field paramField)
  {
    return paramField.getAnnotation(Transient.class) != null;
  }
  
  public static void setFieldValue(Object paramObject1, Field paramField, Object paramObject2)
  {
    try
    {
      Method localMethod = getFieldSetMethod(paramObject1.getClass(), paramField);
      if (localMethod != null)
      {
        localMethod.setAccessible(true);
        paramField = paramField.getType();
        if (paramField == String.class)
        {
          localMethod.invoke(paramObject1, new Object[] { paramObject2.toString() });
          return;
        }
        if ((paramField != Integer.TYPE) && (paramField != Integer.class))
        {
          if ((paramField != Float.TYPE) && (paramField != Float.class))
          {
            if ((paramField != Long.TYPE) && (paramField != Long.class))
            {
              if (paramField == java.util.Date.class)
              {
                if (paramObject2 == null) {
                  paramField = (java.util.Date)null;
                } else {
                  paramField = stringToDateTime(paramObject2.toString());
                }
                localMethod.invoke(paramObject1, new Object[] { paramField });
                return;
              }
              localMethod.invoke(paramObject1, new Object[] { paramObject2 });
              return;
            }
            long l;
            if (paramObject2 == null) {
              l = ((Long)null).longValue();
            } else {
              l = Long.parseLong(paramObject2.toString());
            }
            localMethod.invoke(paramObject1, new Object[] { Long.valueOf(l) });
            return;
          }
          float f;
          if (paramObject2 == null) {
            f = ((Float)null).floatValue();
          } else {
            f = Float.parseFloat(paramObject2.toString());
          }
          localMethod.invoke(paramObject1, new Object[] { Float.valueOf(f) });
          return;
        }
        int i;
        if (paramObject2 == null) {
          i = ((Integer)null).intValue();
        } else {
          i = Integer.parseInt(paramObject2.toString());
        }
        localMethod.invoke(paramObject1, new Object[] { Integer.valueOf(i) });
        return;
      }
    }
    catch (Exception paramObject1)
    {
      ((Exception)paramObject1).printStackTrace();
    }
  }
  
  /* Error */
  public static java.util.Date stringToDateTime(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +39 -> 43
    //   7: getstatic 16	dji/thirdparty/afinal/utils/FieldUtils:SDF	Ljava/lang/ThreadLocal;
    //   10: invokevirtual 291	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   13: checkcast 293	java/text/SimpleDateFormat
    //   16: aload_0
    //   17: invokevirtual 296	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   20: astore_0
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload_0
    //   25: areturn
    //   26: astore_0
    //   27: goto +11 -> 38
    //   30: astore_0
    //   31: aload_0
    //   32: invokevirtual 297	java/text/ParseException:printStackTrace	()V
    //   35: goto +8 -> 43
    //   38: ldc 2
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    //   43: ldc 2
    //   45: monitorexit
    //   46: aconst_null
    //   47: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	paramString	String
    // Exception table:
    //   from	to	target	type
    //   7	21	26	finally
    //   31	35	26	finally
    //   7	21	30	java/text/ParseException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afina\\utils\FieldUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */