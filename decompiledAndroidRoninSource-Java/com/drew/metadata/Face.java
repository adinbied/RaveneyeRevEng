package com.drew.metadata;

public class Face
{
  private final Age _age;
  private final int _height;
  private final String _name;
  private final int _width;
  private final int _x;
  private final int _y;
  
  public Face(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, Age paramAge)
  {
    this._x = paramInt1;
    this._y = paramInt2;
    this._width = paramInt3;
    this._height = paramInt4;
    this._name = paramString;
    this._age = paramAge;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public Age getAge()
  {
    return this._age;
  }
  
  public int getHeight()
  {
    return this._height;
  }
  
  public String getName()
  {
    return this._name;
  }
  
  public int getWidth()
  {
    return this._width;
  }
  
  public int getX()
  {
    return this._x;
  }
  
  public int getY()
  {
    return this._y;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\Face.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */