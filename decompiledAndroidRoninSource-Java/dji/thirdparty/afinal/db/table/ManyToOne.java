package dji.thirdparty.afinal.db.table;

public class ManyToOne
  extends Property
{
  private Class<?> manyClass;
  
  public Class<?> getManyClass()
  {
    return this.manyClass;
  }
  
  public void setManyClass(Class<?> paramClass)
  {
    this.manyClass = paramClass;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\db\table\ManyToOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */