package dji.midware.util.save;

import android.content.Context;
import android.os.SystemClock;
import com.dji.video.framing.utils.stream.StreamSaver;
import dji.midware.media.MediaLogger;
import dji.midware.util.BytesUtil;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class TestUtil
{
  public static String GPIOTAG = "GPIO_TAG";
  public static boolean LOAD_STREAM_FROM_FILE = false;
  public static String TAG = "TestUtil";
  public static boolean TEST_GPIO_DJIVideoDataRecver;
  public static final boolean TEST_GPIO_UsbAccessoryService = false;
  private static int gpio_frame_count;
  private static DataInputStream gpio_in;
  private static DataOutputStream gpio_out;
  private static int test_gpio_w;
  
  public static void checkDebugSwitch(Context paramContext) {}
  
  public static void closeStreamingDebug() {}
  
  public static void openDelayMeasure()
  {
    openStatistics();
    com.dji.video.framing.utils.stream.StreamDelaySaver.IS_SAVE_PACKET_DELAY = true;
  }
  
  public static void openStatistics()
  {
    dji.midware.stat.StatService.OPEN = true;
  }
  
  public static void openStreamingDebug() {}
  
  public static void outputTestStream(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    StreamSaver.getInstance(paramString).write(paramArrayOfByte, 0, paramInt);
  }
  
  public static void writeGPIO(byte[] paramArrayOfByte)
  {
    if (gpio_frame_count == 0) {
      MediaLogger.i(GPIOTAG, "testing GPIO");
    }
    int i = gpio_frame_count + 1;
    gpio_frame_count = i;
    if (i % 100 == 0) {
      test_gpio_w = 1;
    } else {
      test_gpio_w = 0;
    }
    long l = SystemClock.uptimeMillis();
    try
    {
      DataOutputStream localDataOutputStream = new DataOutputStream(new FileOutputStream("/sys/dwc3_test/test_gpio"));
      gpio_out = localDataOutputStream;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(test_gpio_w);
      localStringBuilder.append("");
      localDataOutputStream.writeBytes(localStringBuilder.toString());
      gpio_out.close();
    }
    catch (Exception localException1)
    {
      MediaLogger.e(GPIOTAG, localException1);
    }
    i = -1;
    int j = i;
    try
    {
      DataInputStream localDataInputStream = new DataInputStream(new FileInputStream("/sys/dwc3_test/test_gpio"));
      j = i;
      gpio_in = localDataInputStream;
      try
      {
        j = Integer.parseInt(localDataInputStream.readLine());
        i = j;
      }
      catch (Exception localException2)
      {
        j = i;
        MediaLogger.e(GPIOTAG, localException2);
      }
      j = i;
      gpio_in.close();
    }
    catch (Exception localException3)
    {
      MediaLogger.e(GPIOTAG, localException3);
      i = j;
    }
    if (i != test_gpio_w)
    {
      MediaLogger.e(GPIOTAG, String.format("test_gpio_r %d !=test_gpio_w %d. frame_count=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(test_gpio_w), Integer.valueOf(gpio_frame_count) }));
      return;
    }
    String str = GPIOTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("test_gpio=");
    localStringBuilder.append(i);
    localStringBuilder.append(" frame_count = ");
    localStringBuilder.append(gpio_frame_count);
    localStringBuilder.append(" content=");
    localStringBuilder.append(BytesUtil.byte2hex(Arrays.copyOf(paramArrayOfByte, 18)));
    localStringBuilder.append(" duration=");
    localStringBuilder.append(SystemClock.uptimeMillis() - l);
    MediaLogger.i(str, localStringBuilder.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\save\TestUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */