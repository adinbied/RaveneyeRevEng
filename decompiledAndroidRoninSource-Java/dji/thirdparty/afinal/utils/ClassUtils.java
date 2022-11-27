package dji.thirdparty.afinal.utils;

import dji.thirdparty.afinal.annotation.sqlite.Id;
import dji.thirdparty.afinal.annotation.sqlite.InheritProperty;
import dji.thirdparty.afinal.annotation.sqlite.Table;
import dji.thirdparty.afinal.db.sqlite.ManyToOneLazyLoader;
import dji.thirdparty.afinal.db.table.ManyToOne;
import dji.thirdparty.afinal.db.table.OneToMany;
import dji.thirdparty.afinal.db.table.Property;
import dji.thirdparty.afinal.exception.DbException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ClassUtils
{
  public static List<Field> customGetFields(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    boolean bool = isInheritPropertyFromParents(paramClass);
    while ((paramClass != null) && (!paramClass.equals(Object.class)))
    {
      localArrayList.addAll(Arrays.asList(paramClass.getDeclaredFields()));
      if (!bool) {
        break;
      }
      paramClass = paramClass.getSuperclass();
    }
    return localArrayList;
  }
  
  public static List<ManyToOne> getManyToOneList(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = customGetFields(paramClass).iterator();
      while (localIterator.hasNext())
      {
        Field localField = (Field)localIterator.next();
        if ((!FieldUtils.isTransient(localField)) && (FieldUtils.isManyToOne(localField)))
        {
          ManyToOne localManyToOne = new ManyToOne();
          if (localField.getType() == ManyToOneLazyLoader.class)
          {
            Class localClass = (Class)((ParameterizedType)localField.getGenericType()).getActualTypeArguments()[1];
            if (localClass != null) {
              localManyToOne.setManyClass(localClass);
            }
          }
          else
          {
            localManyToOne.setManyClass(localField.getType());
          }
          localManyToOne.setColumn(FieldUtils.getColumnByField(localField));
          localManyToOne.setFieldName(localField.getName());
          localManyToOne.setDataType(localField.getType());
          localManyToOne.setSet(FieldUtils.getFieldSetMethod(paramClass, localField));
          localManyToOne.setGet(FieldUtils.getFieldGetMethod(paramClass, localField));
          localArrayList.add(localManyToOne);
        }
      }
      return localArrayList;
    }
    catch (Exception paramClass)
    {
      throw new RuntimeException(paramClass.getMessage(), paramClass);
    }
  }
  
  public static List<OneToMany> getOneToManyList(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = customGetFields(paramClass).iterator();
      while (localIterator.hasNext())
      {
        Field localField = (Field)localIterator.next();
        if ((!FieldUtils.isTransient(localField)) && (FieldUtils.isOneToMany(localField)))
        {
          OneToMany localOneToMany = new OneToMany();
          localOneToMany.setColumn(FieldUtils.getColumnByField(localField));
          localOneToMany.setFieldName(localField.getName());
          if ((localField.getGenericType() instanceof ParameterizedType))
          {
            Object localObject = (ParameterizedType)localField.getGenericType();
            if (((ParameterizedType)localObject).getActualTypeArguments().length == 1)
            {
              localObject = (Class)localObject.getActualTypeArguments()[0];
              if (localObject != null) {
                localOneToMany.setOneClass((Class)localObject);
              }
            }
            else
            {
              localObject = (Class)localObject.getActualTypeArguments()[1];
              if (localObject != null) {
                localOneToMany.setOneClass((Class)localObject);
              }
            }
            localOneToMany.setDataType(localField.getType());
            localOneToMany.setSet(FieldUtils.getFieldSetMethod(paramClass, localField));
            localOneToMany.setGet(FieldUtils.getFieldGetMethod(paramClass, localField));
            localArrayList.add(localOneToMany);
          }
          else
          {
            paramClass = new StringBuilder();
            paramClass.append("getOneToManyList Exception:");
            paramClass.append(localField.getName());
            paramClass.append("'s type is null");
            throw new DbException(paramClass.toString());
          }
        }
      }
      return localArrayList;
    }
    catch (Exception paramClass)
    {
      throw new RuntimeException(paramClass.getMessage(), paramClass);
    }
  }
  
  public static String getPrimaryKeyColumn(Class<?> paramClass)
  {
    List localList = customGetFields(paramClass);
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      String str = null;
      paramClass = null;
      while (localIterator.hasNext())
      {
        localObject = (Field)localIterator.next();
        paramClass = (Id)((Field)localObject).getAnnotation(Id.class);
        if (paramClass != null) {
          break label64;
        }
      }
      localObject = null;
      label64:
      if (paramClass != null)
      {
        str = paramClass.column();
        if (str != null)
        {
          paramClass = str;
          if (str.trim().length() != 0) {}
        }
        else
        {
          return ((Field)localObject).getName();
        }
      }
      else
      {
        paramClass = localList.iterator();
        while (paramClass.hasNext()) {
          if ("_id".equals(((Field)paramClass.next()).getName())) {
            return "_id";
          }
        }
        localObject = localList.iterator();
        do
        {
          paramClass = str;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!"id".equals(((Field)((Iterator)localObject).next()).getName()));
        return "id";
      }
      return paramClass;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("this model[");
    ((StringBuilder)localObject).append(paramClass);
    ((StringBuilder)localObject).append("] has no field");
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  public static Field getPrimaryKeyField(Class<?> paramClass)
  {
    Object localObject2 = customGetFields(paramClass);
    if (localObject2 != null)
    {
      paramClass = ((List)localObject2).iterator();
      while (paramClass.hasNext())
      {
        localObject1 = (Field)paramClass.next();
        if (((Field)localObject1).getAnnotation(Id.class) != null) {
          break label49;
        }
      }
      localObject1 = null;
      label49:
      paramClass = (Class<?>)localObject1;
      if (localObject1 == null)
      {
        Iterator localIterator = ((List)localObject2).iterator();
        do
        {
          paramClass = (Class<?>)localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          paramClass = (Field)localIterator.next();
        } while (!"_id".equals(paramClass.getName()));
      }
      localObject1 = paramClass;
      if (paramClass == null)
      {
        localObject2 = ((List)localObject2).iterator();
        do
        {
          localObject1 = paramClass;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (Field)((Iterator)localObject2).next();
        } while (!"id".equals(((Field)localObject1).getName()));
      }
      return (Field)localObject1;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("this model[");
    ((StringBuilder)localObject1).append(paramClass);
    ((StringBuilder)localObject1).append("] has no field");
    throw new RuntimeException(((StringBuilder)localObject1).toString());
  }
  
  public static String getPrimaryKeyFieldName(Class<?> paramClass)
  {
    paramClass = getPrimaryKeyField(paramClass);
    if (paramClass == null) {
      return null;
    }
    return paramClass.getName();
  }
  
  public static Object getPrimaryKeyValue(Object paramObject)
  {
    return FieldUtils.getFieldValue(paramObject, getPrimaryKeyField(paramObject.getClass()));
  }
  
  public static List<Property> getPropertyList(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = customGetFields(paramClass);
      String str = getPrimaryKeyFieldName(paramClass);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Field localField = (Field)((Iterator)localObject).next();
        if ((!FieldUtils.isTransient(localField)) && (FieldUtils.isBaseDateType(localField)) && (!localField.getName().equals(str)) && (!localField.getName().equals("serialVersionUID")))
        {
          Property localProperty = new Property();
          localProperty.setColumn(FieldUtils.getColumnByField(localField));
          localProperty.setFieldName(localField.getName());
          localProperty.setDataType(localField.getType());
          localProperty.setDefaultValue(FieldUtils.getPropertyDefaultValue(localField));
          localProperty.setSet(FieldUtils.getFieldSetMethod(paramClass, localField));
          localProperty.setGet(FieldUtils.getFieldGetMethod(paramClass, localField));
          localProperty.setField(localField);
          localArrayList.add(localProperty);
        }
      }
      return localArrayList;
    }
    catch (Exception paramClass)
    {
      throw new RuntimeException(paramClass.getMessage(), paramClass);
    }
  }
  
  public static String getTableName(Class<?> paramClass)
  {
    Table localTable = (Table)paramClass.getAnnotation(Table.class);
    if ((localTable != null) && (localTable.name().trim().length() != 0)) {
      return localTable.name();
    }
    return paramClass.getName().replace('.', '_');
  }
  
  public static boolean isInheritPropertyFromParents(Class<?> paramClass)
  {
    paramClass = (InheritProperty)paramClass.getAnnotation(InheritProperty.class);
    return (paramClass == null) || (paramClass.inherit());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afina\\utils\ClassUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */