package dji.thirdparty.afinal.db.table;

public class OneToMany
  extends Property
{
  private Class<?> oneClass;
  
  public Class<?> getOneClass()
  {
    return this.oneClass;
  }
  
  public void setOneClass(Class<?> paramClass)
  {
    this.oneClass = paramClass;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\db\table\OneToMany.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */