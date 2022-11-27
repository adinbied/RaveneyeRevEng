package dji.thirdparty.afinal.db.sqlite;

import dji.thirdparty.afinal.FinalDb;

public class ManyToOneLazyLoader<M, O>
{
  FinalDb db;
  private Object fieldValue;
  boolean hasLoaded = false;
  Class<M> manyClazz;
  M manyEntity;
  Class<O> oneClazz;
  O oneEntity;
  
  public ManyToOneLazyLoader(M paramM, Class<M> paramClass, Class<O> paramClass1, FinalDb paramFinalDb)
  {
    this.manyEntity = paramM;
    this.manyClazz = paramClass;
    this.oneClazz = paramClass1;
    this.db = paramFinalDb;
  }
  
  public O get()
  {
    return null;
  }
  
  public Object getFieldValue()
  {
    return this.fieldValue;
  }
  
  public void set(O paramO)
  {
    this.oneEntity = paramO;
  }
  
  public void setFieldValue(Object paramObject)
  {
    this.fieldValue = paramObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\db\sqlite\ManyToOneLazyLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */