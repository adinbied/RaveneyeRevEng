package it.sauronsoftware.ftp4j;

import java.util.Date;

public class FTPFile
{
  public static final int TYPE_DIRECTORY = 1;
  public static final int TYPE_FILE = 0;
  public static final int TYPE_LINK = 2;
  private String link = null;
  private Date modifiedDate = null;
  private String name = null;
  private long size = -1L;
  private int type;
  
  public String getLink()
  {
    return this.link;
  }
  
  public Date getModifiedDate()
  {
    return this.modifiedDate;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setLink(String paramString)
  {
    this.link = paramString;
  }
  
  public void setModifiedDate(Date paramDate)
  {
    this.modifiedDate = paramDate;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\FTPFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */