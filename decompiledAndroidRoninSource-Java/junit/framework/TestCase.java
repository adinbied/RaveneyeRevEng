package junit.framework;

public abstract class TestCase
  extends Assert
  implements Test
{
  private String fName;
  
  public TestCase()
  {
    this.fName = null;
  }
  
  public TestCase(String paramString)
  {
    this.fName = paramString;
  }
  
  public static void assertEquals(byte paramByte1, byte paramByte2)
  {
    Assert.assertEquals(paramByte1, paramByte2);
  }
  
  public static void assertEquals(char paramChar1, char paramChar2)
  {
    Assert.assertEquals(paramChar1, paramChar2);
  }
  
  public static void assertEquals(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    Assert.assertEquals(paramDouble1, paramDouble2, paramDouble3);
  }
  
  public static void assertEquals(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Assert.assertEquals(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static void assertEquals(int paramInt1, int paramInt2)
  {
    Assert.assertEquals(paramInt1, paramInt2);
  }
  
  public static void assertEquals(long paramLong1, long paramLong2)
  {
    Assert.assertEquals(paramLong1, paramLong2);
  }
  
  public static void assertEquals(Object paramObject1, Object paramObject2)
  {
    Assert.assertEquals(paramObject1, paramObject2);
  }
  
  public static void assertEquals(String paramString, byte paramByte1, byte paramByte2)
  {
    Assert.assertEquals(paramString, paramByte1, paramByte2);
  }
  
  public static void assertEquals(String paramString, char paramChar1, char paramChar2)
  {
    Assert.assertEquals(paramString, paramChar1, paramChar2);
  }
  
  public static void assertEquals(String paramString, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    Assert.assertEquals(paramString, paramDouble1, paramDouble2, paramDouble3);
  }
  
  public static void assertEquals(String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Assert.assertEquals(paramString, paramFloat1, paramFloat2, paramFloat3);
  }
  
  public static void assertEquals(String paramString, int paramInt1, int paramInt2)
  {
    Assert.assertEquals(paramString, paramInt1, paramInt2);
  }
  
  public static void assertEquals(String paramString, long paramLong1, long paramLong2)
  {
    Assert.assertEquals(paramString, paramLong1, paramLong2);
  }
  
  public static void assertEquals(String paramString, Object paramObject1, Object paramObject2)
  {
    Assert.assertEquals(paramString, paramObject1, paramObject2);
  }
  
  public static void assertEquals(String paramString1, String paramString2)
  {
    Assert.assertEquals(paramString1, paramString2);
  }
  
  public static void assertEquals(String paramString1, String paramString2, String paramString3)
  {
    Assert.assertEquals(paramString1, paramString2, paramString3);
  }
  
  public static void assertEquals(String paramString, short paramShort1, short paramShort2)
  {
    Assert.assertEquals(paramString, paramShort1, paramShort2);
  }
  
  public static void assertEquals(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Assert.assertEquals(paramString, paramBoolean1, paramBoolean2);
  }
  
  public static void assertEquals(short paramShort1, short paramShort2)
  {
    Assert.assertEquals(paramShort1, paramShort2);
  }
  
  public static void assertEquals(boolean paramBoolean1, boolean paramBoolean2)
  {
    Assert.assertEquals(paramBoolean1, paramBoolean2);
  }
  
  public static void assertFalse(String paramString, boolean paramBoolean)
  {
    Assert.assertFalse(paramString, paramBoolean);
  }
  
  public static void assertFalse(boolean paramBoolean)
  {
    Assert.assertFalse(paramBoolean);
  }
  
  public static void assertNotNull(Object paramObject)
  {
    Assert.assertNotNull(paramObject);
  }
  
  public static void assertNotNull(String paramString, Object paramObject)
  {
    Assert.assertNotNull(paramString, paramObject);
  }
  
  public static void assertNotSame(Object paramObject1, Object paramObject2)
  {
    Assert.assertNotSame(paramObject1, paramObject2);
  }
  
  public static void assertNotSame(String paramString, Object paramObject1, Object paramObject2)
  {
    Assert.assertNotSame(paramString, paramObject1, paramObject2);
  }
  
  public static void assertNull(Object paramObject)
  {
    Assert.assertNull(paramObject);
  }
  
  public static void assertNull(String paramString, Object paramObject)
  {
    Assert.assertNull(paramString, paramObject);
  }
  
  public static void assertSame(Object paramObject1, Object paramObject2)
  {
    Assert.assertSame(paramObject1, paramObject2);
  }
  
  public static void assertSame(String paramString, Object paramObject1, Object paramObject2)
  {
    Assert.assertSame(paramString, paramObject1, paramObject2);
  }
  
  public static void assertTrue(String paramString, boolean paramBoolean)
  {
    Assert.assertTrue(paramString, paramBoolean);
  }
  
  public static void assertTrue(boolean paramBoolean)
  {
    Assert.assertTrue(paramBoolean);
  }
  
  public static void fail() {}
  
  public static void fail(String paramString)
  {
    Assert.fail(paramString);
  }
  
  public static void failNotEquals(String paramString, Object paramObject1, Object paramObject2)
  {
    Assert.failNotEquals(paramString, paramObject1, paramObject2);
  }
  
  public static void failNotSame(String paramString, Object paramObject1, Object paramObject2)
  {
    Assert.failNotSame(paramString, paramObject1, paramObject2);
  }
  
  public static void failSame(String paramString)
  {
    Assert.failSame(paramString);
  }
  
  public static String format(String paramString, Object paramObject1, Object paramObject2)
  {
    return Assert.format(paramString, paramObject1, paramObject2);
  }
  
  public int countTestCases()
  {
    return 1;
  }
  
  protected TestResult createResult()
  {
    return new TestResult();
  }
  
  public String getName()
  {
    return this.fName;
  }
  
  public TestResult run()
  {
    TestResult localTestResult = createResult();
    run(localTestResult);
    return localTestResult;
  }
  
  public void run(TestResult paramTestResult)
  {
    paramTestResult.run(this);
  }
  
  /* Error */
  public void runBare()
    throws java.lang.Throwable
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  protected void runTest()
    throws java.lang.Throwable
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setName(String paramString)
  {
    this.fName = paramString;
  }
  
  protected void setUp()
    throws Exception
  {}
  
  protected void tearDown()
    throws Exception
  {}
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\framework\TestCase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */