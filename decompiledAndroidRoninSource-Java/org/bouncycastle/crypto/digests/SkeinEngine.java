package org.bouncycastle.crypto.digests;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.engines.ThreefishEngine;
import org.bouncycastle.crypto.params.SkeinParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;

public class SkeinEngine
  implements Memoable
{
  private static final Hashtable INITIAL_STATES = new Hashtable();
  private static final int PARAM_TYPE_CONFIG = 4;
  private static final int PARAM_TYPE_KEY = 0;
  private static final int PARAM_TYPE_MESSAGE = 48;
  private static final int PARAM_TYPE_OUTPUT = 63;
  public static final int SKEIN_1024 = 1024;
  public static final int SKEIN_256 = 256;
  public static final int SKEIN_512 = 512;
  long[] chain;
  private long[] initialState;
  private byte[] key;
  private final int outputSizeBytes;
  private Parameter[] postMessageParameters;
  private Parameter[] preMessageParameters;
  private final byte[] singleByte = new byte[1];
  final ThreefishEngine threefish;
  private final UBI ubi;
  
  static
  {
    initialState(256, 128, new long[] { -2228972824489528736L, -8629553674646093540L, 1155188648486244218L, -3677226592081559102L });
    initialState(256, 160, new long[] { 1450197650740764312L, 3081844928540042640L, -3136097061834271170L, 3301952811952417661L });
    initialState(256, 224, new long[] { -4176654842910610933L, -8688192972455077604L, -7364642305011795836L, 4056579644589979102L });
    initialState(256, 256, new long[] { -243853671043386295L, 3443677322885453875L, -5531612722399640561L, 7662005193972177513L });
    initialState(512, 128, new long[] { -6288014694233956526L, 2204638249859346602L, 3502419045458743507L, -4829063503441264548L, 983504137758028059L, 1880512238245786339L, -6715892782214108542L, 7602827311880509485L });
    initialState(512, 160, new long[] { 2934123928682216849L, -4399710721982728305L, 1684584802963255058L, 5744138295201861711L, 2444857010922934358L, -2807833639722848072L, -5121587834665610502L, 118355523173251694L });
    initialState(512, 224, new long[] { -3688341020067007964L, -3772225436291745297L, -8300862168937575580L, 4146387520469897396L, 1106145742801415120L, 7455425944880474941L, -7351063101234211863L, -7048981346965512457L });
    initialState(512, 384, new long[] { -6631894876634615969L, -5692838220127733084L, -7099962856338682626L, -2911352911530754598L, 2000907093792408677L, 9140007292425499655L, 6093301768906360022L, 2769176472213098488L });
    initialState(512, 512, new long[] { 5261240102383538638L, 978932832955457283L, -8083517948103779378L, -7339365279355032399L, 6752626034097301424L, -1531723821829733388L, -7417126464950782685L, -5901786942805128141L });
  }
  
  public SkeinEngine(int paramInt1, int paramInt2)
  {
    if (paramInt2 % 8 == 0)
    {
      this.outputSizeBytes = (paramInt2 / 8);
      localObject = new ThreefishEngine(paramInt1);
      this.threefish = ((ThreefishEngine)localObject);
      this.ubi = new UBI(((ThreefishEngine)localObject).getBlockSize());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Output size must be a multiple of 8 bits. :");
    ((StringBuilder)localObject).append(paramInt2);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public SkeinEngine(SkeinEngine paramSkeinEngine)
  {
    this(paramSkeinEngine.getBlockSize() * 8, paramSkeinEngine.getOutputSize() * 8);
    copyIn(paramSkeinEngine);
  }
  
  private void checkInitialised()
  {
    if (this.ubi != null) {
      return;
    }
    throw new IllegalArgumentException("Skein engine is not initialised.");
  }
  
  private static Parameter[] clone(Parameter[] paramArrayOfParameter1, Parameter[] paramArrayOfParameter2)
  {
    if (paramArrayOfParameter1 == null) {
      return null;
    }
    Parameter[] arrayOfParameter;
    if (paramArrayOfParameter2 != null)
    {
      arrayOfParameter = paramArrayOfParameter2;
      if (paramArrayOfParameter2.length == paramArrayOfParameter1.length) {}
    }
    else
    {
      arrayOfParameter = new Parameter[paramArrayOfParameter1.length];
    }
    System.arraycopy(paramArrayOfParameter1, 0, arrayOfParameter, 0, arrayOfParameter.length);
    return arrayOfParameter;
  }
  
  private void copyIn(SkeinEngine paramSkeinEngine)
  {
    this.ubi.reset(paramSkeinEngine.ubi);
    this.chain = Arrays.clone(paramSkeinEngine.chain, this.chain);
    this.initialState = Arrays.clone(paramSkeinEngine.initialState, this.initialState);
    this.key = Arrays.clone(paramSkeinEngine.key, this.key);
    this.preMessageParameters = clone(paramSkeinEngine.preMessageParameters, this.preMessageParameters);
    this.postMessageParameters = clone(paramSkeinEngine.postMessageParameters, this.postMessageParameters);
  }
  
  private void createInitialState()
  {
    Object localObject = (long[])INITIAL_STATES.get(variantIdentifier(getBlockSize(), getOutputSize()));
    byte[] arrayOfByte = this.key;
    int i = 0;
    if ((arrayOfByte == null) && (localObject != null))
    {
      this.chain = Arrays.clone((long[])localObject);
    }
    else
    {
      this.chain = new long[getBlockSize() / 8];
      localObject = this.key;
      if (localObject != null) {
        ubiComplete(0, (byte[])localObject);
      }
      ubiComplete(4, new Configuration(this.outputSizeBytes * 8).getBytes());
    }
    if (this.preMessageParameters != null) {
      for (;;)
      {
        localObject = this.preMessageParameters;
        if (i >= localObject.length) {
          break;
        }
        localObject = localObject[i];
        ubiComplete(((Parameter)localObject).getType(), ((Parameter)localObject).getValue());
        i += 1;
      }
    }
    this.initialState = Arrays.clone(this.chain);
  }
  
  private void initParams(Hashtable paramHashtable)
  {
    Enumeration localEnumeration = paramHashtable.keys();
    Vector localVector2 = new Vector();
    Vector localVector1 = new Vector();
    while (localEnumeration.hasMoreElements())
    {
      Integer localInteger = (Integer)localEnumeration.nextElement();
      byte[] arrayOfByte = (byte[])paramHashtable.get(localInteger);
      if (localInteger.intValue() == 0) {
        this.key = arrayOfByte;
      } else if (localInteger.intValue() < 48) {
        localVector2.addElement(new Parameter(localInteger.intValue(), arrayOfByte));
      } else {
        localVector1.addElement(new Parameter(localInteger.intValue(), arrayOfByte));
      }
    }
    paramHashtable = new Parameter[localVector2.size()];
    this.preMessageParameters = paramHashtable;
    localVector2.copyInto(paramHashtable);
    sort(this.preMessageParameters);
    paramHashtable = new Parameter[localVector1.size()];
    this.postMessageParameters = paramHashtable;
    localVector1.copyInto(paramHashtable);
    sort(this.postMessageParameters);
  }
  
  private static void initialState(int paramInt1, int paramInt2, long[] paramArrayOfLong)
  {
    INITIAL_STATES.put(variantIdentifier(paramInt1 / 8, paramInt2 / 8), paramArrayOfLong);
  }
  
  private void output(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[8];
    ThreefishEngine.wordToBytes(paramLong, arrayOfByte, 0);
    long[] arrayOfLong = new long[this.chain.length];
    ubiInit(63);
    this.ubi.update(arrayOfByte, 0, 8, arrayOfLong);
    this.ubi.doFinal(arrayOfLong);
    int j = (paramInt2 + 8 - 1) / 8;
    int i = 0;
    while (i < j)
    {
      int k = i * 8;
      int m = Math.min(8, paramInt2 - k);
      if (m == 8)
      {
        ThreefishEngine.wordToBytes(arrayOfLong[i], paramArrayOfByte, k + paramInt1);
      }
      else
      {
        ThreefishEngine.wordToBytes(arrayOfLong[i], arrayOfByte, 0);
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte, k + paramInt1, m);
      }
      i += 1;
    }
  }
  
  private static void sort(Parameter[] paramArrayOfParameter)
  {
    if (paramArrayOfParameter == null) {
      return;
    }
    int i = 1;
    while (i < paramArrayOfParameter.length)
    {
      Parameter localParameter = paramArrayOfParameter[i];
      int k;
      for (int j = i; j > 0; j = k)
      {
        int m = localParameter.getType();
        k = j - 1;
        if (m >= paramArrayOfParameter[k].getType()) {
          break;
        }
        paramArrayOfParameter[j] = paramArrayOfParameter[k];
      }
      paramArrayOfParameter[j] = localParameter;
      i += 1;
    }
  }
  
  private void ubiComplete(int paramInt, byte[] paramArrayOfByte)
  {
    ubiInit(paramInt);
    this.ubi.update(paramArrayOfByte, 0, paramArrayOfByte.length, this.chain);
    ubiFinal();
  }
  
  private void ubiFinal()
  {
    this.ubi.doFinal(this.chain);
  }
  
  private void ubiInit(int paramInt)
  {
    this.ubi.reset(paramInt);
  }
  
  private static Integer variantIdentifier(int paramInt1, int paramInt2)
  {
    return new Integer(paramInt1 | paramInt2 << 16);
  }
  
  public Memoable copy()
  {
    return new SkeinEngine(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    checkInitialised();
    if (paramArrayOfByte.length >= this.outputSizeBytes + paramInt)
    {
      ubiFinal();
      Object localObject = this.postMessageParameters;
      int j = 0;
      if (localObject != null)
      {
        i = 0;
        for (;;)
        {
          localObject = this.postMessageParameters;
          if (i >= localObject.length) {
            break;
          }
          localObject = localObject[i];
          ubiComplete(((Parameter)localObject).getType(), ((Parameter)localObject).getValue());
          i += 1;
        }
      }
      int k = getBlockSize();
      int m = (this.outputSizeBytes + k - 1) / k;
      int i = j;
      while (i < m)
      {
        int n = this.outputSizeBytes;
        j = i * k;
        n = Math.min(k, n - j);
        output(i, paramArrayOfByte, paramInt + j, n);
        i += 1;
      }
      reset();
      return this.outputSizeBytes;
    }
    throw new DataLengthException("Output buffer is too short to hold output");
  }
  
  public int getBlockSize()
  {
    return this.threefish.getBlockSize();
  }
  
  public int getOutputSize()
  {
    return this.outputSizeBytes;
  }
  
  public void init(SkeinParameters paramSkeinParameters)
  {
    this.chain = null;
    this.key = null;
    this.preMessageParameters = null;
    this.postMessageParameters = null;
    if (paramSkeinParameters != null) {
      if (paramSkeinParameters.getKey().length >= 16) {
        initParams(paramSkeinParameters.getParameters());
      } else {
        throw new IllegalArgumentException("Skein key must be at least 128 bits.");
      }
    }
    createInitialState();
    ubiInit(48);
  }
  
  public void reset()
  {
    long[] arrayOfLong1 = this.initialState;
    long[] arrayOfLong2 = this.chain;
    System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, arrayOfLong2.length);
    ubiInit(48);
  }
  
  public void reset(Memoable paramMemoable)
  {
    paramMemoable = (SkeinEngine)paramMemoable;
    if ((getBlockSize() == paramMemoable.getBlockSize()) && (this.outputSizeBytes == paramMemoable.outputSizeBytes))
    {
      copyIn(paramMemoable);
      return;
    }
    throw new IllegalArgumentException("Incompatible parameters in provided SkeinEngine.");
  }
  
  public void update(byte paramByte)
  {
    byte[] arrayOfByte = this.singleByte;
    arrayOfByte[0] = paramByte;
    update(arrayOfByte, 0, 1);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    checkInitialised();
    this.ubi.update(paramArrayOfByte, paramInt1, paramInt2, this.chain);
  }
  
  private static class Configuration
  {
    private byte[] bytes;
    
    public Configuration(long paramLong)
    {
      byte[] arrayOfByte = new byte[32];
      this.bytes = arrayOfByte;
      arrayOfByte[0] = 83;
      arrayOfByte[1] = 72;
      arrayOfByte[2] = 65;
      arrayOfByte[3] = 51;
      arrayOfByte[4] = 1;
      arrayOfByte[5] = 0;
      ThreefishEngine.wordToBytes(paramLong, arrayOfByte, 8);
    }
    
    public byte[] getBytes()
    {
      return this.bytes;
    }
  }
  
  public static class Parameter
  {
    private int type;
    private byte[] value;
    
    public Parameter(int paramInt, byte[] paramArrayOfByte)
    {
      this.type = paramInt;
      this.value = paramArrayOfByte;
    }
    
    public int getType()
    {
      return this.type;
    }
    
    public byte[] getValue()
    {
      return this.value;
    }
  }
  
  private class UBI
  {
    private byte[] currentBlock;
    private int currentOffset;
    private long[] message;
    private final SkeinEngine.UbiTweak tweak = new SkeinEngine.UbiTweak();
    
    public UBI(int paramInt)
    {
      this$1 = new byte[paramInt];
      this.currentBlock = SkeinEngine.this;
      this.message = new long[SkeinEngine.this.length / 8];
    }
    
    private void processBlock(long[] paramArrayOfLong)
    {
      SkeinEngine.this.threefish.init(true, SkeinEngine.this.chain, this.tweak.getWords());
      int j = 0;
      int i = 0;
      for (;;)
      {
        long[] arrayOfLong = this.message;
        if (i >= arrayOfLong.length) {
          break;
        }
        arrayOfLong[i] = ThreefishEngine.bytesToWord(this.currentBlock, i * 8);
        i += 1;
      }
      SkeinEngine.this.threefish.processBlock(this.message, paramArrayOfLong);
      i = j;
      while (i < paramArrayOfLong.length)
      {
        paramArrayOfLong[i] ^= this.message[i];
        i += 1;
      }
    }
    
    public void doFinal(long[] paramArrayOfLong)
    {
      int i = this.currentOffset;
      for (;;)
      {
        byte[] arrayOfByte = this.currentBlock;
        if (i >= arrayOfByte.length) {
          break;
        }
        arrayOfByte[i] = 0;
        i += 1;
      }
      this.tweak.setFinal(true);
      processBlock(paramArrayOfLong);
    }
    
    public void reset(int paramInt)
    {
      this.tweak.reset();
      this.tweak.setType(paramInt);
      this.currentOffset = 0;
    }
    
    public void reset(UBI paramUBI)
    {
      this.currentBlock = Arrays.clone(paramUBI.currentBlock, this.currentBlock);
      this.currentOffset = paramUBI.currentOffset;
      this.message = Arrays.clone(paramUBI.message, this.message);
      this.tweak.reset(paramUBI.tweak);
    }
    
    public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2, long[] paramArrayOfLong)
    {
      int i = 0;
      while (paramInt2 > i)
      {
        if (this.currentOffset == this.currentBlock.length)
        {
          processBlock(paramArrayOfLong);
          this.tweak.setFirst(false);
          this.currentOffset = 0;
        }
        int j = Math.min(paramInt2 - i, this.currentBlock.length - this.currentOffset);
        System.arraycopy(paramArrayOfByte, paramInt1 + i, this.currentBlock, this.currentOffset, j);
        i += j;
        this.currentOffset += j;
        this.tweak.advancePosition(j);
      }
    }
  }
  
  private static class UbiTweak
  {
    private static final long LOW_RANGE = 9223372034707292160L;
    private static final long T1_FINAL = Long.MIN_VALUE;
    private static final long T1_FIRST = 4611686018427387904L;
    private boolean extendedPosition;
    private long[] tweak = new long[2];
    
    public UbiTweak()
    {
      reset();
    }
    
    public void advancePosition(int paramInt)
    {
      if (this.extendedPosition)
      {
        arrayOfLong1 = new long[3];
        long[] arrayOfLong2 = this.tweak;
        arrayOfLong2[0] &= 0xFFFFFFFF;
        arrayOfLong1[1] = (arrayOfLong2[0] >>> 32 & 0xFFFFFFFF);
        arrayOfLong1[2] = (arrayOfLong2[1] & 0xFFFFFFFF);
        l = paramInt;
        paramInt = 0;
        while (paramInt < 3)
        {
          l += arrayOfLong1[paramInt];
          arrayOfLong1[paramInt] = l;
          l >>>= 32;
          paramInt += 1;
        }
        arrayOfLong2 = this.tweak;
        arrayOfLong2[0] = ((arrayOfLong1[1] & 0xFFFFFFFF) << 32 | arrayOfLong1[0] & 0xFFFFFFFF);
        l = arrayOfLong2[1];
        arrayOfLong2[1] = (arrayOfLong1[2] & 0xFFFFFFFF | l & 0xFFFFFFFF00000000);
        return;
      }
      long[] arrayOfLong1 = this.tweak;
      long l = arrayOfLong1[0] + paramInt;
      arrayOfLong1[0] = l;
      if (l > 9223372034707292160L) {
        this.extendedPosition = true;
      }
    }
    
    public int getType()
    {
      return (int)(this.tweak[1] >>> 56 & 0x3F);
    }
    
    public long[] getWords()
    {
      return this.tweak;
    }
    
    public boolean isFinal()
    {
      return (this.tweak[1] & 0x8000000000000000) != 0L;
    }
    
    public boolean isFirst()
    {
      return (this.tweak[1] & 0x4000000000000000) != 0L;
    }
    
    public void reset()
    {
      long[] arrayOfLong = this.tweak;
      arrayOfLong[0] = 0L;
      arrayOfLong[1] = 0L;
      this.extendedPosition = false;
      setFirst(true);
    }
    
    public void reset(UbiTweak paramUbiTweak)
    {
      this.tweak = Arrays.clone(paramUbiTweak.tweak, this.tweak);
      this.extendedPosition = paramUbiTweak.extendedPosition;
    }
    
    public void setFinal(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        arrayOfLong = this.tweak;
        arrayOfLong[1] |= 0x8000000000000000;
        return;
      }
      long[] arrayOfLong = this.tweak;
      arrayOfLong[1] &= 0x7FFFFFFFFFFFFFFF;
    }
    
    public void setFirst(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        arrayOfLong = this.tweak;
        arrayOfLong[1] |= 0x4000000000000000;
        return;
      }
      long[] arrayOfLong = this.tweak;
      arrayOfLong[1] &= 0xBFFFFFFFFFFFFFFF;
    }
    
    public void setType(int paramInt)
    {
      long[] arrayOfLong = this.tweak;
      arrayOfLong[1] = (arrayOfLong[1] & 0xFFFFFFC000000000 | (paramInt & 0x3F) << 56);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getType());
      localStringBuilder.append(" first: ");
      localStringBuilder.append(isFirst());
      localStringBuilder.append(", final: ");
      localStringBuilder.append(isFinal());
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\SkeinEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */