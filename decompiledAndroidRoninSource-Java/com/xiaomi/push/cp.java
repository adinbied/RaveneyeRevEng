package com.xiaomi.push;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class cp
{
  private File jdField_a_of_type_JavaIoFile;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  
  public void a()
  {
    try
    {
      FileWriter localFileWriter = new FileWriter(this.jdField_a_of_type_JavaIoFile, true);
      localFileWriter.write(this.jdField_a_of_type_JavaLangStringBuilder.toString());
      localFileWriter.flush();
      localFileWriter.close();
      this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public void a(co paramco)
  {
    StringBuilder localStringBuilder1 = this.jdField_a_of_type_JavaLangStringBuilder;
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramco.jdField_a_of_type_Int);
    localStringBuilder2.append("\t");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1 = this.jdField_a_of_type_JavaLangStringBuilder;
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramco.jdField_a_of_type_JavaLangString);
    localStringBuilder2.append("\t");
    localStringBuilder2.append(paramco.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    this.jdField_a_of_type_JavaLangStringBuilder.append("\r\n");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */