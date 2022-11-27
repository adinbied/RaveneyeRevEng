package io.flutter.embedding.engine;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlutterShellArgs
{
  public static final String ARG_CACHE_SKSL = "--cache-sksl";
  public static final String ARG_DART_FLAGS = "--dart-flags";
  public static final String ARG_DISABLE_SERVICE_AUTH_CODES = "--disable-service-auth-codes";
  public static final String ARG_DUMP_SHADER_SKP_ON_SHADER_COMPILATION = "--dump-skp-on-shader-compilation";
  public static final String ARG_ENABLE_DART_PROFILING = "--enable-dart-profiling";
  public static final String ARG_ENABLE_SOFTWARE_RENDERING = "--enable-software-rendering";
  public static final String ARG_ENDLESS_TRACE_BUFFER = "--endless-trace-buffer";
  public static final String ARG_KEY_CACHE_SKSL = "cache-sksl";
  public static final String ARG_KEY_DART_FLAGS = "dart-flags";
  public static final String ARG_KEY_DISABLE_SERVICE_AUTH_CODES = "disable-service-auth-codes";
  public static final String ARG_KEY_DUMP_SHADER_SKP_ON_SHADER_COMPILATION = "dump-skp-on-shader-compilation";
  public static final String ARG_KEY_ENABLE_DART_PROFILING = "enable-dart-profiling";
  public static final String ARG_KEY_ENABLE_SOFTWARE_RENDERING = "enable-software-rendering";
  public static final String ARG_KEY_ENDLESS_TRACE_BUFFER = "endless-trace-buffer";
  public static final String ARG_KEY_OBSERVATORY_PORT = "observatory-port";
  public static final String ARG_KEY_SKIA_DETERMINISTIC_RENDERING = "skia-deterministic-rendering";
  public static final String ARG_KEY_START_PAUSED = "start-paused";
  public static final String ARG_KEY_TRACE_SKIA = "trace-skia";
  public static final String ARG_KEY_TRACE_STARTUP = "trace-startup";
  public static final String ARG_KEY_USE_TEST_FONTS = "use-test-fonts";
  public static final String ARG_KEY_VERBOSE_LOGGING = "verbose-logging";
  public static final String ARG_OBSERVATORY_PORT = "--observatory-port=";
  public static final String ARG_SKIA_DETERMINISTIC_RENDERING = "--skia-deterministic-rendering";
  public static final String ARG_START_PAUSED = "--start-paused";
  public static final String ARG_TRACE_SKIA = "--trace-skia";
  public static final String ARG_TRACE_STARTUP = "--trace-startup";
  public static final String ARG_USE_TEST_FONTS = "--use-test-fonts";
  public static final String ARG_VERBOSE_LOGGING = "--verbose-logging";
  private Set<String> args;
  
  public FlutterShellArgs(List<String> paramList)
  {
    this.args = new HashSet(paramList);
  }
  
  public FlutterShellArgs(Set<String> paramSet)
  {
    this.args = new HashSet(paramSet);
  }
  
  public FlutterShellArgs(String[] paramArrayOfString)
  {
    this.args = new HashSet(Arrays.asList(paramArrayOfString));
  }
  
  public static FlutterShellArgs fromIntent(Intent paramIntent)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramIntent.getBooleanExtra("trace-startup", false)) {
      localArrayList.add("--trace-startup");
    }
    if (paramIntent.getBooleanExtra("start-paused", false)) {
      localArrayList.add("--start-paused");
    }
    int i = paramIntent.getIntExtra("observatory-port", 0);
    StringBuilder localStringBuilder;
    if (i > 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("--observatory-port=");
      localStringBuilder.append(Integer.toString(i));
      localArrayList.add(localStringBuilder.toString());
    }
    if (paramIntent.getBooleanExtra("disable-service-auth-codes", false)) {
      localArrayList.add("--disable-service-auth-codes");
    }
    if (paramIntent.getBooleanExtra("endless-trace-buffer", false)) {
      localArrayList.add("--endless-trace-buffer");
    }
    if (paramIntent.getBooleanExtra("use-test-fonts", false)) {
      localArrayList.add("--use-test-fonts");
    }
    if (paramIntent.getBooleanExtra("enable-dart-profiling", false)) {
      localArrayList.add("--enable-dart-profiling");
    }
    if (paramIntent.getBooleanExtra("enable-software-rendering", false)) {
      localArrayList.add("--enable-software-rendering");
    }
    if (paramIntent.getBooleanExtra("skia-deterministic-rendering", false)) {
      localArrayList.add("--skia-deterministic-rendering");
    }
    if (paramIntent.getBooleanExtra("trace-skia", false)) {
      localArrayList.add("--trace-skia");
    }
    if (paramIntent.getBooleanExtra("dump-skp-on-shader-compilation", false)) {
      localArrayList.add("--dump-skp-on-shader-compilation");
    }
    if (paramIntent.getBooleanExtra("cache-sksl", false)) {
      localArrayList.add("--cache-sksl");
    }
    if (paramIntent.getBooleanExtra("verbose-logging", false)) {
      localArrayList.add("--verbose-logging");
    }
    if (paramIntent.hasExtra("dart-flags"))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("--dart-flags=");
      localStringBuilder.append(paramIntent.getStringExtra("dart-flags"));
      localArrayList.add(localStringBuilder.toString());
    }
    return new FlutterShellArgs(localArrayList);
  }
  
  public void add(String paramString)
  {
    this.args.add(paramString);
  }
  
  public void remove(String paramString)
  {
    this.args.remove(paramString);
  }
  
  public String[] toArray()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\FlutterShellArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */