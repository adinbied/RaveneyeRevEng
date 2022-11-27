package dji.thirdparty.plogger;

final class LoggerPrinter
  implements Printer
{
  private static final int ASSERT = 7;
  private static final String BOTTOM_BORDER = "╚════════════════════════════════════════════════════════════════════════════════════════";
  private static final char BOTTOM_LEFT_CORNER = '╚';
  private static final int CHUNK_SIZE = 4000;
  private static final int DEBUG = 3;
  private static final String DEFAULT_TAG = "PRETTYLOGGER";
  private static final String DOUBLE_DIVIDER = "════════════════════════════════════════════";
  private static final int ERROR = 6;
  private static final char HORIZONTAL_DOUBLE_LINE = '║';
  private static final int INFO = 4;
  private static final int JSON_INDENT = 2;
  private static final String MIDDLE_BORDER = "╟────────────────────────────────────────────────────────────────────────────────────────";
  private static final char MIDDLE_CORNER = '╟';
  private static final int MIN_STACK_OFFSET = 3;
  private static final String SINGLE_DIVIDER = "────────────────────────────────────────────";
  private static final String TOP_BORDER = "╔════════════════════════════════════════════════════════════════════════════════════════";
  private static final char TOP_LEFT_CORNER = '╔';
  private static final int VERBOSE = 2;
  private static final int WARN = 5;
  private final ThreadLocal<Integer> localMethodCount = new ThreadLocal();
  private final ThreadLocal<String> localTag = new ThreadLocal();
  private final Settings settings = new Settings();
  private String tag;
  
  public LoggerPrinter()
  {
    init("PRETTYLOGGER");
  }
  
  private String createMessage(String paramString, Object... paramVarArgs)
  {
    return null;
  }
  
  private String formatTag(String paramString)
  {
    return null;
  }
  
  private int getMethodCount()
  {
    return 0;
  }
  
  private String getSimpleClassName(String paramString)
  {
    return null;
  }
  
  private int getStackOffset(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    return 0;
  }
  
  private String getTag()
  {
    return null;
  }
  
  /* Error */
  private void log(int arg1, Throwable arg2, String arg3, Object... arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  private void logBottomBorder(int paramInt, String paramString)
  {
    logChunk(paramInt, paramString, "╚════════════════════════════════════════════════════════════════════════════════════════");
  }
  
  /* Error */
  private void logChunk(int arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void logContent(int arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private void logDivider(int paramInt, String paramString)
  {
    logChunk(paramInt, paramString, "╟────────────────────────────────────────────────────────────────────────────────────────");
  }
  
  /* Error */
  private void logHeaderContent(int arg1, String arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private void logTopBorder(int paramInt, String paramString)
  {
    logChunk(paramInt, paramString, "╔════════════════════════════════════════════════════════════════════════════════════════");
  }
  
  /* Error */
  public void d(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    log(3, null, paramString, paramVarArgs);
  }
  
  public void e(String paramString, Object... paramVarArgs)
  {
    e(null, paramString, paramVarArgs);
  }
  
  public void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log(6, paramThrowable, paramString, paramVarArgs);
  }
  
  public Settings getSettings()
  {
    return this.settings;
  }
  
  public void i(String paramString, Object... paramVarArgs)
  {
    log(4, null, paramString, paramVarArgs);
  }
  
  public Settings init(String paramString)
  {
    return null;
  }
  
  /* Error */
  public void json(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void log(int arg1, String arg2, String arg3, Throwable arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: return
  }
  
  public void resetSettings()
  {
    this.settings.reset();
  }
  
  public Printer t(String paramString, int paramInt)
  {
    return null;
  }
  
  public void v(String paramString, Object... paramVarArgs)
  {
    log(2, null, paramString, paramVarArgs);
  }
  
  public void w(String paramString, Object... paramVarArgs)
  {
    log(5, null, paramString, paramVarArgs);
  }
  
  public void wtf(String paramString, Object... paramVarArgs)
  {
    log(7, null, paramString, paramVarArgs);
  }
  
  /* Error */
  public void xml(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\plogger\LoggerPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */