package com.xiaomi.push;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

class fo
{
  private fq jdField_a_of_type_ComXiaomiPushFq;
  private fs jdField_a_of_type_ComXiaomiPushFs;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(2048);
  private Adler32 jdField_a_of_type_JavaUtilZipAdler32 = new Adler32();
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private ByteBuffer b = ByteBuffer.allocate(4);
  
  fo(InputStream paramInputStream, fs paramfs)
  {
    this.jdField_a_of_type_JavaIoInputStream = new BufferedInputStream(paramInputStream);
    this.jdField_a_of_type_ComXiaomiPushFs = paramfs;
    this.jdField_a_of_type_ComXiaomiPushFq = new fq();
  }
  
  private ByteBuffer a()
  {
    return null;
  }
  
  /* Error */
  private void a(ByteBuffer arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  fn a()
  {
    return null;
  }
  
  /* Error */
  void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */