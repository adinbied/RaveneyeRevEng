package dji.thirdparty.afinal.db.table;

import dji.thirdparty.afinal.exception.DbException;
import dji.thirdparty.afinal.utils.ClassUtils;
import dji.thirdparty.afinal.utils.FieldUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TableInfo
{
  private static final HashMap<String, TableInfo> tableInfoMap = new HashMap();
  private boolean checkDatabese;
  private String className;
  private Id id;
  public final HashMap<String, ManyToOne> manyToOneMap = new HashMap();
  public final HashMap<String, OneToMany> oneToManyMap = new HashMap();
  public final HashMap<String, Property> propertyMap = new HashMap();
  private String tableName;
  
  public static TableInfo get(Class<?> paramClass)
  {
    if (paramClass != null)
    {
      Object localObject2 = (TableInfo)tableInfoMap.get(paramClass.getName());
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TableInfo();
        ((TableInfo)localObject1).setTableName(ClassUtils.getTableName(paramClass));
        ((TableInfo)localObject1).setClassName(paramClass.getName());
        localObject2 = ClassUtils.getPrimaryKeyField(paramClass);
        if (localObject2 != null)
        {
          Object localObject3 = new Id();
          ((Id)localObject3).setColumn(FieldUtils.getColumnByField((Field)localObject2));
          ((Id)localObject3).setFieldName(((Field)localObject2).getName());
          ((Id)localObject3).setSet(FieldUtils.getFieldSetMethod(paramClass, (Field)localObject2));
          ((Id)localObject3).setGet(FieldUtils.getFieldGetMethod(paramClass, (Field)localObject2));
          ((Id)localObject3).setDataType(((Field)localObject2).getType());
          ((Id)localObject3).setField((Field)localObject2);
          ((TableInfo)localObject1).setId((Id)localObject3);
          localObject2 = ClassUtils.getPropertyList(paramClass);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Property)((Iterator)localObject2).next();
              if (localObject3 != null) {
                ((TableInfo)localObject1).propertyMap.put(((Property)localObject3).getColumn(), localObject3);
              }
            }
          }
          localObject2 = ClassUtils.getManyToOneList(paramClass);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (ManyToOne)((Iterator)localObject2).next();
              if (localObject3 != null) {
                ((TableInfo)localObject1).manyToOneMap.put(((ManyToOne)localObject3).getColumn(), localObject3);
              }
            }
          }
          localObject2 = ClassUtils.getOneToManyList(paramClass);
          if (localObject2 != null)
          {
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (OneToMany)((Iterator)localObject2).next();
              if (localObject3 != null) {
                ((TableInfo)localObject1).oneToManyMap.put(((OneToMany)localObject3).getColumn(), localObject3);
              }
            }
          }
          tableInfoMap.put(paramClass.getName(), localObject1);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("the class[");
          ((StringBuilder)localObject1).append(paramClass);
          ((StringBuilder)localObject1).append("]'s idField is null , \n you can define _id,id property or use annotation @id to solution this exception");
          throw new DbException(((StringBuilder)localObject1).toString());
        }
      }
      if (localObject1 != null) {
        return (TableInfo)localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("the class[");
      ((StringBuilder)localObject1).append(paramClass);
      ((StringBuilder)localObject1).append("]'s table is null");
      throw new DbException(((StringBuilder)localObject1).toString());
    }
    throw new DbException("table info get error,because the clazz is null");
  }
  
  public static TableInfo get(String paramString)
  {
    try
    {
      paramString = get(Class.forName(paramString));
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static HashMap<String, TableInfo> getTableInfoMap()
  {
    return tableInfoMap;
  }
  
  public static void resetCheckState(Class<?> paramClass)
  {
    paramClass = (TableInfo)getTableInfoMap().get(paramClass.getName());
    if (paramClass != null) {
      paramClass.setCheckDatabese(false);
    }
  }
  
  public String getClassName()
  {
    return this.className;
  }
  
  public Id getId()
  {
    return this.id;
  }
  
  public String getTableName()
  {
    return this.tableName;
  }
  
  public boolean isCheckDatabese()
  {
    return this.checkDatabese;
  }
  
  public void setCheckDatabese(boolean paramBoolean)
  {
    this.checkDatabese = paramBoolean;
  }
  
  public void setClassName(String paramString)
  {
    this.className = paramString;
  }
  
  public void setId(Id paramId)
  {
    this.id = paramId;
  }
  
  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\db\table\TableInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */