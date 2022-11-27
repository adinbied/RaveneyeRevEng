package org.msgpack.core;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import org.msgpack.core.buffer.ArrayBufferInput;
import org.msgpack.core.buffer.ChannelBufferInput;
import org.msgpack.core.buffer.ChannelBufferOutput;
import org.msgpack.core.buffer.InputStreamBufferInput;
import org.msgpack.core.buffer.MessageBufferInput;
import org.msgpack.core.buffer.MessageBufferOutput;
import org.msgpack.core.buffer.OutputStreamBufferOutput;

public class MessagePack
{
  public static final PackerConfig DEFAULT_PACKER_CONFIG = new PackerConfig();
  public static final UnpackerConfig DEFAULT_UNPACKER_CONFIG = new UnpackerConfig();
  public static final Charset UTF8 = Charset.forName("UTF-8");
  
  public static MessageBufferPacker newDefaultBufferPacker()
  {
    return DEFAULT_PACKER_CONFIG.newBufferPacker();
  }
  
  public static MessagePacker newDefaultPacker(OutputStream paramOutputStream)
  {
    return DEFAULT_PACKER_CONFIG.newPacker(paramOutputStream);
  }
  
  public static MessagePacker newDefaultPacker(WritableByteChannel paramWritableByteChannel)
  {
    return DEFAULT_PACKER_CONFIG.newPacker(paramWritableByteChannel);
  }
  
  public static MessagePacker newDefaultPacker(MessageBufferOutput paramMessageBufferOutput)
  {
    return DEFAULT_PACKER_CONFIG.newPacker(paramMessageBufferOutput);
  }
  
  public static MessageUnpacker newDefaultUnpacker(InputStream paramInputStream)
  {
    return DEFAULT_UNPACKER_CONFIG.newUnpacker(paramInputStream);
  }
  
  public static MessageUnpacker newDefaultUnpacker(ReadableByteChannel paramReadableByteChannel)
  {
    return DEFAULT_UNPACKER_CONFIG.newUnpacker(paramReadableByteChannel);
  }
  
  public static MessageUnpacker newDefaultUnpacker(MessageBufferInput paramMessageBufferInput)
  {
    return DEFAULT_UNPACKER_CONFIG.newUnpacker(paramMessageBufferInput);
  }
  
  public static MessageUnpacker newDefaultUnpacker(byte[] paramArrayOfByte)
  {
    return DEFAULT_UNPACKER_CONFIG.newUnpacker(paramArrayOfByte);
  }
  
  public static MessageUnpacker newDefaultUnpacker(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return DEFAULT_UNPACKER_CONFIG.newUnpacker(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static final class Code
  {
    public static final byte ARRAY16 = -36;
    public static final byte ARRAY32 = -35;
    public static final byte BIN16 = -59;
    public static final byte BIN32 = -58;
    public static final byte BIN8 = -60;
    public static final byte EXT16 = -56;
    public static final byte EXT32 = -55;
    public static final byte EXT8 = -57;
    public static final byte FALSE = -62;
    public static final byte FIXARRAY_PREFIX = -112;
    public static final byte FIXEXT1 = -44;
    public static final byte FIXEXT16 = -40;
    public static final byte FIXEXT2 = -43;
    public static final byte FIXEXT4 = -42;
    public static final byte FIXEXT8 = -41;
    public static final byte FIXMAP_PREFIX = -128;
    public static final byte FIXSTR_PREFIX = -96;
    public static final byte FLOAT32 = -54;
    public static final byte FLOAT64 = -53;
    public static final byte INT16 = -47;
    public static final byte INT32 = -46;
    public static final byte INT64 = -45;
    public static final byte INT8 = -48;
    public static final byte MAP16 = -34;
    public static final byte MAP32 = -33;
    public static final byte NEGFIXINT_PREFIX = -32;
    public static final byte NEVER_USED = -63;
    public static final byte NIL = -64;
    public static final byte POSFIXINT_MASK = -128;
    public static final byte STR16 = -38;
    public static final byte STR32 = -37;
    public static final byte STR8 = -39;
    public static final byte TRUE = -61;
    public static final byte UINT16 = -51;
    public static final byte UINT32 = -50;
    public static final byte UINT64 = -49;
    public static final byte UINT8 = -52;
    
    public static final boolean isFixInt(byte paramByte)
    {
      paramByte &= 0xFF;
      return (paramByte <= Byte.MAX_VALUE) || (paramByte >= 224);
    }
    
    public static final boolean isFixStr(byte paramByte)
    {
      return (paramByte & 0xFFFFFFE0) == -96;
    }
    
    public static final boolean isFixedArray(byte paramByte)
    {
      return (paramByte & 0xFFFFFFF0) == -112;
    }
    
    public static final boolean isFixedMap(byte paramByte)
    {
      return (paramByte & 0xFFFFFFF0) == Byte.MIN_VALUE;
    }
    
    public static final boolean isFixedRaw(byte paramByte)
    {
      return (paramByte & 0xFFFFFFE0) == -96;
    }
    
    public static final boolean isNegFixInt(byte paramByte)
    {
      return (paramByte & 0xFFFFFFE0) == -32;
    }
    
    public static final boolean isPosFixInt(byte paramByte)
    {
      return (paramByte & 0xFFFFFF80) == 0;
    }
  }
  
  public static class PackerConfig
    implements Cloneable
  {
    private int bufferFlushThreshold = 8192;
    private int bufferSize = 8192;
    private int smallStringOptimizationThreshold = 512;
    private boolean str8FormatSupport = true;
    
    public PackerConfig() {}
    
    private PackerConfig(PackerConfig paramPackerConfig)
    {
      this.smallStringOptimizationThreshold = paramPackerConfig.smallStringOptimizationThreshold;
      this.bufferFlushThreshold = paramPackerConfig.bufferFlushThreshold;
      this.bufferSize = paramPackerConfig.bufferSize;
      this.str8FormatSupport = paramPackerConfig.str8FormatSupport;
    }
    
    public PackerConfig clone()
    {
      return new PackerConfig(this);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof PackerConfig;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramObject = (PackerConfig)paramObject;
      bool1 = bool2;
      if (this.smallStringOptimizationThreshold == ((PackerConfig)paramObject).smallStringOptimizationThreshold)
      {
        bool1 = bool2;
        if (this.bufferFlushThreshold == ((PackerConfig)paramObject).bufferFlushThreshold)
        {
          bool1 = bool2;
          if (this.bufferSize == ((PackerConfig)paramObject).bufferSize)
          {
            bool1 = bool2;
            if (this.str8FormatSupport == ((PackerConfig)paramObject).str8FormatSupport) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    public int getBufferFlushThreshold()
    {
      return this.bufferFlushThreshold;
    }
    
    public int getBufferSize()
    {
      return this.bufferSize;
    }
    
    public int getSmallStringOptimizationThreshold()
    {
      return this.smallStringOptimizationThreshold;
    }
    
    public int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public boolean isStr8FormatSupport()
    {
      return this.str8FormatSupport;
    }
    
    public MessageBufferPacker newBufferPacker()
    {
      return new MessageBufferPacker(this);
    }
    
    public MessagePacker newPacker(OutputStream paramOutputStream)
    {
      return newPacker(new OutputStreamBufferOutput(paramOutputStream, this.bufferSize));
    }
    
    public MessagePacker newPacker(WritableByteChannel paramWritableByteChannel)
    {
      return newPacker(new ChannelBufferOutput(paramWritableByteChannel, this.bufferSize));
    }
    
    public MessagePacker newPacker(MessageBufferOutput paramMessageBufferOutput)
    {
      return new MessagePacker(paramMessageBufferOutput, this);
    }
    
    public PackerConfig withBufferFlushThreshold(int paramInt)
    {
      PackerConfig localPackerConfig = clone();
      localPackerConfig.bufferFlushThreshold = paramInt;
      return localPackerConfig;
    }
    
    public PackerConfig withBufferSize(int paramInt)
    {
      PackerConfig localPackerConfig = clone();
      localPackerConfig.bufferSize = paramInt;
      return localPackerConfig;
    }
    
    public PackerConfig withSmallStringOptimizationThreshold(int paramInt)
    {
      PackerConfig localPackerConfig = clone();
      localPackerConfig.smallStringOptimizationThreshold = paramInt;
      return localPackerConfig;
    }
    
    public PackerConfig withStr8FormatSupport(boolean paramBoolean)
    {
      PackerConfig localPackerConfig = clone();
      localPackerConfig.str8FormatSupport = paramBoolean;
      return localPackerConfig;
    }
  }
  
  public static class UnpackerConfig
    implements Cloneable
  {
    private CodingErrorAction actionOnMalformedString = CodingErrorAction.REPLACE;
    private CodingErrorAction actionOnUnmappableString = CodingErrorAction.REPLACE;
    private boolean allowReadingBinaryAsString = true;
    private boolean allowReadingStringAsBinary = true;
    private int bufferSize = 8192;
    private int stringDecoderBufferSize = 8192;
    private int stringSizeLimit = Integer.MAX_VALUE;
    
    public UnpackerConfig() {}
    
    private UnpackerConfig(UnpackerConfig paramUnpackerConfig)
    {
      this.allowReadingStringAsBinary = paramUnpackerConfig.allowReadingStringAsBinary;
      this.allowReadingBinaryAsString = paramUnpackerConfig.allowReadingBinaryAsString;
      this.actionOnMalformedString = paramUnpackerConfig.actionOnMalformedString;
      this.actionOnUnmappableString = paramUnpackerConfig.actionOnUnmappableString;
      this.stringSizeLimit = paramUnpackerConfig.stringSizeLimit;
      this.bufferSize = paramUnpackerConfig.bufferSize;
    }
    
    public UnpackerConfig clone()
    {
      return new UnpackerConfig(this);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof UnpackerConfig;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      paramObject = (UnpackerConfig)paramObject;
      bool1 = bool2;
      if (this.allowReadingStringAsBinary == ((UnpackerConfig)paramObject).allowReadingStringAsBinary)
      {
        bool1 = bool2;
        if (this.allowReadingBinaryAsString == ((UnpackerConfig)paramObject).allowReadingBinaryAsString)
        {
          bool1 = bool2;
          if (this.actionOnMalformedString == ((UnpackerConfig)paramObject).actionOnMalformedString)
          {
            bool1 = bool2;
            if (this.actionOnUnmappableString == ((UnpackerConfig)paramObject).actionOnUnmappableString)
            {
              bool1 = bool2;
              if (this.stringSizeLimit == ((UnpackerConfig)paramObject).stringSizeLimit)
              {
                bool1 = bool2;
                if (this.stringDecoderBufferSize == ((UnpackerConfig)paramObject).stringDecoderBufferSize)
                {
                  bool1 = bool2;
                  if (this.bufferSize == ((UnpackerConfig)paramObject).bufferSize) {
                    bool1 = true;
                  }
                }
              }
            }
          }
        }
      }
      return bool1;
    }
    
    public CodingErrorAction getActionOnMalformedString()
    {
      return this.actionOnMalformedString;
    }
    
    public CodingErrorAction getActionOnUnmappableString()
    {
      return this.actionOnUnmappableString;
    }
    
    public boolean getAllowReadingBinaryAsString()
    {
      return this.allowReadingBinaryAsString;
    }
    
    public boolean getAllowReadingStringAsBinary()
    {
      return this.allowReadingStringAsBinary;
    }
    
    public int getBufferSize()
    {
      return this.bufferSize;
    }
    
    public int getStringDecoderBufferSize()
    {
      return this.stringDecoderBufferSize;
    }
    
    public int getStringSizeLimit()
    {
      return this.stringSizeLimit;
    }
    
    public int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public MessageUnpacker newUnpacker(InputStream paramInputStream)
    {
      return newUnpacker(new InputStreamBufferInput(paramInputStream, this.bufferSize));
    }
    
    public MessageUnpacker newUnpacker(ReadableByteChannel paramReadableByteChannel)
    {
      return newUnpacker(new ChannelBufferInput(paramReadableByteChannel, this.bufferSize));
    }
    
    public MessageUnpacker newUnpacker(MessageBufferInput paramMessageBufferInput)
    {
      return new MessageUnpacker(paramMessageBufferInput, this);
    }
    
    public MessageUnpacker newUnpacker(byte[] paramArrayOfByte)
    {
      return newUnpacker(new ArrayBufferInput(paramArrayOfByte));
    }
    
    public MessageUnpacker newUnpacker(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      return newUnpacker(new ArrayBufferInput(paramArrayOfByte, paramInt1, paramInt2));
    }
    
    public UnpackerConfig withActionOnMalformedString(CodingErrorAction paramCodingErrorAction)
    {
      UnpackerConfig localUnpackerConfig = clone();
      localUnpackerConfig.actionOnMalformedString = paramCodingErrorAction;
      return localUnpackerConfig;
    }
    
    public UnpackerConfig withActionOnUnmappableString(CodingErrorAction paramCodingErrorAction)
    {
      UnpackerConfig localUnpackerConfig = clone();
      localUnpackerConfig.actionOnUnmappableString = paramCodingErrorAction;
      return localUnpackerConfig;
    }
    
    public UnpackerConfig withAllowReadingBinaryAsString(boolean paramBoolean)
    {
      UnpackerConfig localUnpackerConfig = clone();
      localUnpackerConfig.allowReadingBinaryAsString = paramBoolean;
      return localUnpackerConfig;
    }
    
    public UnpackerConfig withAllowReadingStringAsBinary(boolean paramBoolean)
    {
      UnpackerConfig localUnpackerConfig = clone();
      localUnpackerConfig.allowReadingStringAsBinary = paramBoolean;
      return localUnpackerConfig;
    }
    
    public UnpackerConfig withBufferSize(int paramInt)
    {
      UnpackerConfig localUnpackerConfig = clone();
      localUnpackerConfig.bufferSize = paramInt;
      return localUnpackerConfig;
    }
    
    public UnpackerConfig withStringDecoderBufferSize(int paramInt)
    {
      UnpackerConfig localUnpackerConfig = clone();
      localUnpackerConfig.stringDecoderBufferSize = paramInt;
      return localUnpackerConfig;
    }
    
    public UnpackerConfig withStringSizeLimit(int paramInt)
    {
      UnpackerConfig localUnpackerConfig = clone();
      localUnpackerConfig.stringSizeLimit = paramInt;
      return localUnpackerConfig;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\MessagePack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */