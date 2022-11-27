package org.msgpack.core.buffer;

import java.lang.reflect.Constructor;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import org.msgpack.core.Preconditions;
import sun.misc.Unsafe;

public class MessageBuffer
{
  static final int ARRAY_BYTE_BASE_OFFSET;
  private static final String BIGENDIAN_MESSAGE_BUFFER = "org.msgpack.core.buffer.MessageBufferBE";
  private static final String DEFAULT_MESSAGE_BUFFER = "org.msgpack.core.buffer.MessageBuffer";
  private static final String UNIVERSAL_MESSAGE_BUFFER = "org.msgpack.core.buffer.MessageBufferU";
  static final boolean isUniversalBuffer;
  private static final Constructor<?> mbArrConstructor;
  static final Unsafe unsafe;
  protected final long address;
  protected final Object base;
  protected final int size;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 16
    //   2: astore 6
    //   4: ldc 19
    //   6: astore 7
    //   8: bipush 16
    //   10: istore_0
    //   11: aconst_null
    //   12: astore 10
    //   14: aconst_null
    //   15: astore 9
    //   17: aconst_null
    //   18: astore 11
    //   20: aconst_null
    //   21: astore 8
    //   23: ldc 38
    //   25: ldc 40
    //   27: invokestatic 46	java/lang/System:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 12
    //   32: aload 12
    //   34: bipush 46
    //   36: invokevirtual 52	java/lang/String:indexOf	(I)I
    //   39: istore_2
    //   40: iload_2
    //   41: iconst_m1
    //   42: if_icmpeq +45 -> 87
    //   45: aload 12
    //   47: iconst_0
    //   48: iload_2
    //   49: invokevirtual 56	java/lang/String:substring	(II)Ljava/lang/String;
    //   52: invokestatic 62	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   55: istore_1
    //   56: aload 12
    //   58: iload_2
    //   59: iconst_1
    //   60: iadd
    //   61: invokevirtual 65	java/lang/String:substring	(I)Ljava/lang/String;
    //   64: invokestatic 62	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   67: istore_2
    //   68: iload_1
    //   69: iconst_1
    //   70: if_icmpgt +22 -> 92
    //   73: iload_1
    //   74: iconst_1
    //   75: if_icmpne +12 -> 87
    //   78: iload_2
    //   79: bipush 7
    //   81: if_icmplt +6 -> 87
    //   84: goto +8 -> 92
    //   87: iconst_0
    //   88: istore_1
    //   89: goto +21 -> 110
    //   92: iconst_1
    //   93: istore_1
    //   94: goto +16 -> 110
    //   97: astore 12
    //   99: aload 12
    //   101: getstatic 69	java/lang/System:err	Ljava/io/PrintStream;
    //   104: invokevirtual 73	java/lang/NumberFormatException:printStackTrace	(Ljava/io/PrintStream;)V
    //   107: goto -20 -> 87
    //   110: ldc 75
    //   112: invokestatic 81	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   115: astore 12
    //   117: aload 12
    //   119: ifnull +8 -> 127
    //   122: iconst_1
    //   123: istore_2
    //   124: goto +5 -> 129
    //   127: iconst_0
    //   128: istore_2
    //   129: ldc 83
    //   131: ldc 40
    //   133: invokestatic 46	java/lang/System:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   136: invokevirtual 87	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   139: ldc 89
    //   141: invokevirtual 93	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   144: istore 4
    //   146: ldc 95
    //   148: invokestatic 98	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   151: ifnull +655 -> 806
    //   154: iconst_1
    //   155: istore_3
    //   156: goto +3 -> 159
    //   159: ldc 100
    //   161: ldc 102
    //   163: invokestatic 46	java/lang/System:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   166: invokestatic 108	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   169: istore 5
    //   171: iload 5
    //   173: ifne +29 -> 202
    //   176: iload 4
    //   178: ifne +24 -> 202
    //   181: iload_3
    //   182: ifne +20 -> 202
    //   185: iload_1
    //   186: ifeq +16 -> 202
    //   189: iload_2
    //   190: ifne +6 -> 196
    //   193: goto +9 -> 202
    //   196: iconst_0
    //   197: istore 4
    //   199: goto +6 -> 205
    //   202: iconst_1
    //   203: istore 4
    //   205: iload_0
    //   206: istore_1
    //   207: iload 4
    //   209: ifne +196 -> 405
    //   212: iload 4
    //   214: istore 5
    //   216: iload_0
    //   217: istore_1
    //   218: aload 9
    //   220: astore 8
    //   222: ldc 110
    //   224: ldc 112
    //   226: invokevirtual 116	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   229: astore 11
    //   231: iload 4
    //   233: istore 5
    //   235: iload_0
    //   236: istore_1
    //   237: aload 9
    //   239: astore 8
    //   241: aload 11
    //   243: iconst_1
    //   244: invokevirtual 122	java/lang/reflect/Field:setAccessible	(Z)V
    //   247: iload 4
    //   249: istore 5
    //   251: iload_0
    //   252: istore_1
    //   253: aload 9
    //   255: astore 8
    //   257: aload 11
    //   259: aconst_null
    //   260: invokevirtual 126	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   263: checkcast 110	sun/misc/Unsafe
    //   266: astore 9
    //   268: aload 9
    //   270: ifnull +94 -> 364
    //   273: iload_0
    //   274: istore_1
    //   275: iload_0
    //   276: istore_2
    //   277: aload 9
    //   279: ldc -128
    //   281: invokevirtual 132	sun/misc/Unsafe:arrayBaseOffset	(Ljava/lang/Class;)I
    //   284: istore_0
    //   285: iload_0
    //   286: istore_1
    //   287: iload_0
    //   288: istore_2
    //   289: aload 9
    //   291: ldc -128
    //   293: invokevirtual 135	sun/misc/Unsafe:arrayIndexScale	(Ljava/lang/Class;)I
    //   296: istore_3
    //   297: iload_3
    //   298: iconst_1
    //   299: if_icmpne +12 -> 311
    //   302: aload 9
    //   304: astore 8
    //   306: iload_0
    //   307: istore_1
    //   308: goto +97 -> 405
    //   311: iload_0
    //   312: istore_1
    //   313: iload_0
    //   314: istore_2
    //   315: new 137	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   322: astore 8
    //   324: iload_0
    //   325: istore_1
    //   326: iload_0
    //   327: istore_2
    //   328: aload 8
    //   330: ldc -114
    //   332: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: iload_0
    //   337: istore_1
    //   338: iload_0
    //   339: istore_2
    //   340: aload 8
    //   342: iload_3
    //   343: invokevirtual 149	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: iload_0
    //   348: istore_1
    //   349: iload_0
    //   350: istore_2
    //   351: new 151	java/lang/IllegalStateException
    //   354: dup
    //   355: aload 8
    //   357: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokespecial 157	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   363: athrow
    //   364: iload_0
    //   365: istore_1
    //   366: iload_0
    //   367: istore_2
    //   368: new 159	java/lang/RuntimeException
    //   371: dup
    //   372: ldc -95
    //   374: invokespecial 162	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   377: athrow
    //   378: astore 8
    //   380: iload_1
    //   381: istore_0
    //   382: goto +304 -> 686
    //   385: astore 8
    //   387: aload 9
    //   389: astore 10
    //   391: aload 8
    //   393: astore 9
    //   395: iload_2
    //   396: istore_0
    //   397: goto +141 -> 538
    //   400: astore 9
    //   402: goto +136 -> 538
    //   405: aload 8
    //   407: putstatic 164	org/msgpack/core/buffer/MessageBuffer:unsafe	Lsun/misc/Unsafe;
    //   410: iload_1
    //   411: putstatic 166	org/msgpack/core/buffer/MessageBuffer:ARRAY_BYTE_BASE_OFFSET	I
    //   414: iload 4
    //   416: putstatic 168	org/msgpack/core/buffer/MessageBuffer:isUniversalBuffer	Z
    //   419: iload 4
    //   421: ifeq +10 -> 431
    //   424: aload 7
    //   426: astore 6
    //   428: goto +30 -> 458
    //   431: invokestatic 174	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   434: getstatic 178	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   437: if_acmpne +8 -> 445
    //   440: iconst_1
    //   441: istore_0
    //   442: goto +5 -> 447
    //   445: iconst_0
    //   446: istore_0
    //   447: iload_0
    //   448: ifeq +6 -> 454
    //   451: goto +7 -> 458
    //   454: ldc 13
    //   456: astore 6
    //   458: aload 6
    //   460: invokestatic 81	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   463: iconst_3
    //   464: anewarray 77	java/lang/Class
    //   467: dup
    //   468: iconst_0
    //   469: ldc -128
    //   471: aastore
    //   472: dup
    //   473: iconst_1
    //   474: getstatic 182	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   477: aastore
    //   478: dup
    //   479: iconst_2
    //   480: getstatic 182	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   483: aastore
    //   484: invokevirtual 186	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   487: astore 6
    //   489: aload 6
    //   491: iconst_1
    //   492: invokevirtual 189	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   495: aload 6
    //   497: putstatic 191	org/msgpack/core/buffer/MessageBuffer:mbArrConstructor	Ljava/lang/reflect/Constructor;
    //   500: return
    //   501: astore 6
    //   503: aload 6
    //   505: getstatic 69	java/lang/System:err	Ljava/io/PrintStream;
    //   508: invokevirtual 192	java/lang/Exception:printStackTrace	(Ljava/io/PrintStream;)V
    //   511: new 159	java/lang/RuntimeException
    //   514: dup
    //   515: aload 6
    //   517: invokespecial 195	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   520: athrow
    //   521: astore 8
    //   523: iconst_0
    //   524: istore 4
    //   526: aload 11
    //   528: astore 9
    //   530: goto +156 -> 686
    //   533: astore 9
    //   535: iconst_0
    //   536: istore 4
    //   538: iload 4
    //   540: istore 5
    //   542: iload_0
    //   543: istore_1
    //   544: aload 10
    //   546: astore 8
    //   548: aload 9
    //   550: getstatic 69	java/lang/System:err	Ljava/io/PrintStream;
    //   553: invokevirtual 192	java/lang/Exception:printStackTrace	(Ljava/io/PrintStream;)V
    //   556: aload 10
    //   558: putstatic 164	org/msgpack/core/buffer/MessageBuffer:unsafe	Lsun/misc/Unsafe;
    //   561: iload_0
    //   562: putstatic 166	org/msgpack/core/buffer/MessageBuffer:ARRAY_BYTE_BASE_OFFSET	I
    //   565: iconst_1
    //   566: putstatic 168	org/msgpack/core/buffer/MessageBuffer:isUniversalBuffer	Z
    //   569: iconst_1
    //   570: ifeq +10 -> 580
    //   573: aload 7
    //   575: astore 6
    //   577: goto +30 -> 607
    //   580: invokestatic 174	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   583: getstatic 178	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   586: if_acmpne +8 -> 594
    //   589: iconst_1
    //   590: istore_0
    //   591: goto +5 -> 596
    //   594: iconst_0
    //   595: istore_0
    //   596: iload_0
    //   597: ifeq +6 -> 603
    //   600: goto +7 -> 607
    //   603: ldc 13
    //   605: astore 6
    //   607: aload 6
    //   609: invokestatic 81	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   612: iconst_3
    //   613: anewarray 77	java/lang/Class
    //   616: dup
    //   617: iconst_0
    //   618: ldc -128
    //   620: aastore
    //   621: dup
    //   622: iconst_1
    //   623: getstatic 182	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   626: aastore
    //   627: dup
    //   628: iconst_2
    //   629: getstatic 182	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   632: aastore
    //   633: invokevirtual 186	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   636: astore 6
    //   638: aload 6
    //   640: iconst_1
    //   641: invokevirtual 189	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   644: aload 6
    //   646: putstatic 191	org/msgpack/core/buffer/MessageBuffer:mbArrConstructor	Ljava/lang/reflect/Constructor;
    //   649: return
    //   650: astore 6
    //   652: aload 6
    //   654: getstatic 69	java/lang/System:err	Ljava/io/PrintStream;
    //   657: invokevirtual 192	java/lang/Exception:printStackTrace	(Ljava/io/PrintStream;)V
    //   660: new 159	java/lang/RuntimeException
    //   663: dup
    //   664: aload 6
    //   666: invokespecial 195	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   669: athrow
    //   670: astore 10
    //   672: aload 8
    //   674: astore 9
    //   676: iload_1
    //   677: istore_0
    //   678: iload 5
    //   680: istore 4
    //   682: aload 10
    //   684: astore 8
    //   686: aload 9
    //   688: putstatic 164	org/msgpack/core/buffer/MessageBuffer:unsafe	Lsun/misc/Unsafe;
    //   691: iload_0
    //   692: putstatic 166	org/msgpack/core/buffer/MessageBuffer:ARRAY_BYTE_BASE_OFFSET	I
    //   695: iload 4
    //   697: putstatic 168	org/msgpack/core/buffer/MessageBuffer:isUniversalBuffer	Z
    //   700: iload 4
    //   702: ifne +34 -> 736
    //   705: invokestatic 174	java/nio/ByteOrder:nativeOrder	()Ljava/nio/ByteOrder;
    //   708: getstatic 178	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   711: if_acmpne +8 -> 719
    //   714: iconst_1
    //   715: istore_0
    //   716: goto +5 -> 721
    //   719: iconst_0
    //   720: istore_0
    //   721: iload_0
    //   722: ifeq +6 -> 728
    //   725: goto +7 -> 732
    //   728: ldc 13
    //   730: astore 6
    //   732: aload 6
    //   734: astore 7
    //   736: aload 7
    //   738: invokestatic 81	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   741: iconst_3
    //   742: anewarray 77	java/lang/Class
    //   745: dup
    //   746: iconst_0
    //   747: ldc -128
    //   749: aastore
    //   750: dup
    //   751: iconst_1
    //   752: getstatic 182	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   755: aastore
    //   756: dup
    //   757: iconst_2
    //   758: getstatic 182	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   761: aastore
    //   762: invokevirtual 186	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   765: astore 6
    //   767: aload 6
    //   769: iconst_1
    //   770: invokevirtual 189	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   773: aload 6
    //   775: putstatic 191	org/msgpack/core/buffer/MessageBuffer:mbArrConstructor	Ljava/lang/reflect/Constructor;
    //   778: aload 8
    //   780: athrow
    //   781: astore 6
    //   783: aload 6
    //   785: getstatic 69	java/lang/System:err	Ljava/io/PrintStream;
    //   788: invokevirtual 192	java/lang/Exception:printStackTrace	(Ljava/io/PrintStream;)V
    //   791: new 159	java/lang/RuntimeException
    //   794: dup
    //   795: aload 6
    //   797: invokespecial 195	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   800: athrow
    //   801: astore 12
    //   803: goto -676 -> 127
    //   806: iconst_0
    //   807: istore_3
    //   808: goto -649 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	712	0	i	int
    //   55	622	1	j	int
    //   39	357	2	k	int
    //   155	653	3	m	int
    //   144	557	4	bool1	boolean
    //   169	510	5	bool2	boolean
    //   2	494	6	localObject1	Object
    //   501	15	6	localException1	Exception
    //   575	70	6	localObject2	Object
    //   650	15	6	localException2	Exception
    //   730	44	6	localObject3	Object
    //   781	15	6	localException3	Exception
    //   6	731	7	localObject4	Object
    //   21	335	8	localObject5	Object
    //   378	1	8	localObject6	Object
    //   385	21	8	localException4	Exception
    //   521	1	8	localObject7	Object
    //   546	233	8	localObject8	Object
    //   15	379	9	localObject9	Object
    //   400	1	9	localException5	Exception
    //   528	1	9	localObject10	Object
    //   533	16	9	localException6	Exception
    //   674	13	9	localObject11	Object
    //   12	545	10	localObject12	Object
    //   670	13	10	localObject13	Object
    //   18	509	11	localField	java.lang.reflect.Field
    //   30	27	12	str	String
    //   97	3	12	localNumberFormatException	NumberFormatException
    //   115	3	12	localClass	Class
    //   801	1	12	localException7	Exception
    // Exception table:
    //   from	to	target	type
    //   45	68	97	java/lang/NumberFormatException
    //   277	285	378	finally
    //   289	297	378	finally
    //   315	324	378	finally
    //   328	336	378	finally
    //   340	347	378	finally
    //   351	364	378	finally
    //   368	378	378	finally
    //   277	285	385	java/lang/Exception
    //   289	297	385	java/lang/Exception
    //   315	324	385	java/lang/Exception
    //   328	336	385	java/lang/Exception
    //   340	347	385	java/lang/Exception
    //   351	364	385	java/lang/Exception
    //   368	378	385	java/lang/Exception
    //   222	231	400	java/lang/Exception
    //   241	247	400	java/lang/Exception
    //   257	268	400	java/lang/Exception
    //   458	500	501	java/lang/Exception
    //   23	40	521	finally
    //   45	68	521	finally
    //   99	107	521	finally
    //   110	117	521	finally
    //   129	154	521	finally
    //   159	171	521	finally
    //   23	40	533	java/lang/Exception
    //   45	68	533	java/lang/Exception
    //   99	107	533	java/lang/Exception
    //   129	154	533	java/lang/Exception
    //   159	171	533	java/lang/Exception
    //   607	649	650	java/lang/Exception
    //   222	231	670	finally
    //   241	247	670	finally
    //   257	268	670	finally
    //   548	556	670	finally
    //   736	778	781	java/lang/Exception
    //   110	117	801	java/lang/Exception
  }
  
  protected MessageBuffer(Object paramObject, long paramLong, int paramInt)
  {
    this.base = paramObject;
    this.address = paramLong;
    this.size = paramInt;
  }
  
  MessageBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.base = paramArrayOfByte;
    this.address = (ARRAY_BYTE_BASE_OFFSET + paramInt1);
    this.size = paramInt2;
  }
  
  public static MessageBuffer allocate(int paramInt)
  {
    return wrap(new byte[paramInt]);
  }
  
  private static MessageBuffer newMessageBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    try
    {
      paramArrayOfByte = (MessageBuffer)mbArrConstructor.newInstance(new Object[] { paramArrayOfByte, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return paramArrayOfByte;
    }
    finally {}
  }
  
  public static void releaseBuffer(MessageBuffer paramMessageBuffer)
  {
    if (!isUniversalBuffer)
    {
      if ((paramMessageBuffer.base instanceof byte[])) {
        return;
      }
      unsafe.freeMemory(paramMessageBuffer.address);
    }
  }
  
  public static MessageBuffer wrap(byte[] paramArrayOfByte)
  {
    return newMessageBuffer(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static MessageBuffer wrap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return newMessageBuffer(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public byte[] array()
  {
    return (byte[])this.base;
  }
  
  public int arrayOffset()
  {
    return (int)this.address - ARRAY_BYTE_BASE_OFFSET;
  }
  
  public void copyTo(int paramInt1, MessageBuffer paramMessageBuffer, int paramInt2, int paramInt3)
  {
    Unsafe localUnsafe = unsafe;
    Object localObject1 = this.base;
    long l1 = this.address;
    long l2 = paramInt1;
    Object localObject2 = paramMessageBuffer.base;
    long l3 = paramMessageBuffer.address;
    localUnsafe.copyMemory(localObject1, l1 + l2, localObject2, paramInt2 + l3, paramInt3);
  }
  
  public boolean getBoolean(int paramInt)
  {
    return unsafe.getBoolean(this.base, this.address + paramInt);
  }
  
  public byte getByte(int paramInt)
  {
    return unsafe.getByte(this.base, this.address + paramInt);
  }
  
  public void getBytes(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.remaining() >= paramInt2)
    {
      paramByteBuffer.put(sliceAsByteBuffer(paramInt1, paramInt2));
      return;
    }
    throw new BufferOverflowException();
  }
  
  public void getBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    unsafe.copyMemory(this.base, this.address + paramInt1, paramArrayOfByte, ARRAY_BYTE_BASE_OFFSET + paramInt2, paramInt3);
  }
  
  public double getDouble(int paramInt)
  {
    return Double.longBitsToDouble(getLong(paramInt));
  }
  
  public float getFloat(int paramInt)
  {
    return Float.intBitsToFloat(getInt(paramInt));
  }
  
  public int getInt(int paramInt)
  {
    return Integer.reverseBytes(unsafe.getInt(this.base, this.address + paramInt));
  }
  
  public long getLong(int paramInt)
  {
    return Long.reverseBytes(unsafe.getLong(this.base, this.address + paramInt));
  }
  
  public short getShort(int paramInt)
  {
    return Short.reverseBytes(unsafe.getShort(this.base, this.address + paramInt));
  }
  
  public void putBoolean(int paramInt, boolean paramBoolean)
  {
    unsafe.putBoolean(this.base, this.address + paramInt, paramBoolean);
  }
  
  public void putByte(int paramInt, byte paramByte)
  {
    unsafe.putByte(this.base, this.address + paramInt, paramByte);
  }
  
  public void putByteBuffer(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2)
  {
    if (paramByteBuffer.isDirect())
    {
      unsafe.copyMemory(null, DirectBufferAccess.getAddress(paramByteBuffer) + paramByteBuffer.position(), this.base, this.address + paramInt1, paramInt2);
      paramByteBuffer.position(paramByteBuffer.position() + paramInt2);
      return;
    }
    if (paramByteBuffer.hasArray())
    {
      localObject = paramByteBuffer.array();
      unsafe.copyMemory(localObject, ARRAY_BYTE_BASE_OFFSET + paramByteBuffer.position(), this.base, this.address + paramInt1, paramInt2);
      paramByteBuffer.position(paramByteBuffer.position() + paramInt2);
      return;
    }
    Object localObject = this.base;
    if (localObject != null)
    {
      paramByteBuffer.get((byte[])localObject, paramInt1, paramInt2);
      return;
    }
    int i = 0;
    while (i < paramInt2)
    {
      unsafe.putByte(this.base, this.address + paramInt1, paramByteBuffer.get());
      i += 1;
    }
  }
  
  public void putBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    unsafe.copyMemory(paramArrayOfByte, ARRAY_BYTE_BASE_OFFSET + paramInt2, this.base, this.address + paramInt1, paramInt3);
  }
  
  public void putDouble(int paramInt, double paramDouble)
  {
    putLong(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public void putFloat(int paramInt, float paramFloat)
  {
    putInt(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public void putInt(int paramInt1, int paramInt2)
  {
    paramInt2 = Integer.reverseBytes(paramInt2);
    unsafe.putInt(this.base, this.address + paramInt1, paramInt2);
  }
  
  public void putLong(int paramInt, long paramLong)
  {
    paramLong = Long.reverseBytes(paramLong);
    Unsafe localUnsafe = unsafe;
    Object localObject = this.base;
    long l = this.address;
    localUnsafe.putLong(localObject, paramInt + l, paramLong);
  }
  
  public void putShort(int paramInt, short paramShort)
  {
    paramShort = Short.reverseBytes(paramShort);
    unsafe.putShort(this.base, this.address + paramInt, paramShort);
  }
  
  public int size()
  {
    return this.size;
  }
  
  public MessageBuffer slice(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == size())) {
      return this;
    }
    boolean bool;
    if (paramInt1 + paramInt2 <= size()) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    return new MessageBuffer(this.base, this.address + paramInt1, paramInt2);
  }
  
  public ByteBuffer sliceAsByteBuffer()
  {
    return sliceAsByteBuffer(0, size());
  }
  
  public ByteBuffer sliceAsByteBuffer(int paramInt1, int paramInt2)
  {
    return ByteBuffer.wrap((byte[])this.base, (int)(this.address - ARRAY_BYTE_BASE_OFFSET + paramInt1), paramInt2);
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[size()];
    unsafe.copyMemory(this.base, this.address, arrayOfByte, ARRAY_BYTE_BASE_OFFSET, size());
    return arrayOfByte;
  }
  
  public String toHexString(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramInt1;
    while (i < paramInt2)
    {
      if (i != paramInt1) {
        localStringBuilder.append(" ");
      }
      localStringBuilder.append(String.format("%02x", new Object[] { Byte.valueOf(getByte(i)) }));
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\buffer\MessageBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */