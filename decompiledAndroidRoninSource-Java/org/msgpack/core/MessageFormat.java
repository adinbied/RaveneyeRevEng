package org.msgpack.core;

import org.msgpack.value.ValueType;

public enum MessageFormat
{
  private static final MessageFormat[] formatTable;
  private final ValueType valueType;
  
  static
  {
    Object localObject = ValueType.INTEGER;
    int i = 0;
    POSFIXINT = new MessageFormat("POSFIXINT", 0, (ValueType)localObject);
    FIXMAP = new MessageFormat("FIXMAP", 1, ValueType.MAP);
    FIXARRAY = new MessageFormat("FIXARRAY", 2, ValueType.ARRAY);
    FIXSTR = new MessageFormat("FIXSTR", 3, ValueType.STRING);
    NIL = new MessageFormat("NIL", 4, ValueType.NIL);
    NEVER_USED = new MessageFormat("NEVER_USED", 5, null);
    BOOLEAN = new MessageFormat("BOOLEAN", 6, ValueType.BOOLEAN);
    BIN8 = new MessageFormat("BIN8", 7, ValueType.BINARY);
    BIN16 = new MessageFormat("BIN16", 8, ValueType.BINARY);
    BIN32 = new MessageFormat("BIN32", 9, ValueType.BINARY);
    EXT8 = new MessageFormat("EXT8", 10, ValueType.EXTENSION);
    EXT16 = new MessageFormat("EXT16", 11, ValueType.EXTENSION);
    EXT32 = new MessageFormat("EXT32", 12, ValueType.EXTENSION);
    FLOAT32 = new MessageFormat("FLOAT32", 13, ValueType.FLOAT);
    FLOAT64 = new MessageFormat("FLOAT64", 14, ValueType.FLOAT);
    UINT8 = new MessageFormat("UINT8", 15, ValueType.INTEGER);
    UINT16 = new MessageFormat("UINT16", 16, ValueType.INTEGER);
    UINT32 = new MessageFormat("UINT32", 17, ValueType.INTEGER);
    UINT64 = new MessageFormat("UINT64", 18, ValueType.INTEGER);
    INT8 = new MessageFormat("INT8", 19, ValueType.INTEGER);
    INT16 = new MessageFormat("INT16", 20, ValueType.INTEGER);
    INT32 = new MessageFormat("INT32", 21, ValueType.INTEGER);
    INT64 = new MessageFormat("INT64", 22, ValueType.INTEGER);
    FIXEXT1 = new MessageFormat("FIXEXT1", 23, ValueType.EXTENSION);
    FIXEXT2 = new MessageFormat("FIXEXT2", 24, ValueType.EXTENSION);
    FIXEXT4 = new MessageFormat("FIXEXT4", 25, ValueType.EXTENSION);
    FIXEXT8 = new MessageFormat("FIXEXT8", 26, ValueType.EXTENSION);
    FIXEXT16 = new MessageFormat("FIXEXT16", 27, ValueType.EXTENSION);
    STR8 = new MessageFormat("STR8", 28, ValueType.STRING);
    STR16 = new MessageFormat("STR16", 29, ValueType.STRING);
    STR32 = new MessageFormat("STR32", 30, ValueType.STRING);
    ARRAY16 = new MessageFormat("ARRAY16", 31, ValueType.ARRAY);
    ARRAY32 = new MessageFormat("ARRAY32", 32, ValueType.ARRAY);
    MAP16 = new MessageFormat("MAP16", 33, ValueType.MAP);
    MAP32 = new MessageFormat("MAP32", 34, ValueType.MAP);
    localObject = new MessageFormat("NEGFIXINT", 35, ValueType.INTEGER);
    NEGFIXINT = (MessageFormat)localObject;
    $VALUES = new MessageFormat[] { POSFIXINT, FIXMAP, FIXARRAY, FIXSTR, NIL, NEVER_USED, BOOLEAN, BIN8, BIN16, BIN32, EXT8, EXT16, EXT32, FLOAT32, FLOAT64, UINT8, UINT16, UINT32, UINT64, INT8, INT16, INT32, INT64, FIXEXT1, FIXEXT2, FIXEXT4, FIXEXT8, FIXEXT16, STR8, STR16, STR32, ARRAY16, ARRAY32, MAP16, MAP32, localObject };
    formatTable = new MessageFormat['Ā'];
    while (i <= 255)
    {
      localObject = toMessageFormat((byte)i);
      formatTable[i] = localObject;
      i += 1;
    }
  }
  
  private MessageFormat(ValueType paramValueType)
  {
    this.valueType = paramValueType;
  }
  
  static MessageFormat toMessageFormat(byte paramByte)
  {
    if (MessagePack.Code.isPosFixInt(paramByte)) {
      return POSFIXINT;
    }
    if (MessagePack.Code.isNegFixInt(paramByte)) {
      return NEGFIXINT;
    }
    if (MessagePack.Code.isFixStr(paramByte)) {
      return FIXSTR;
    }
    if (MessagePack.Code.isFixedArray(paramByte)) {
      return FIXARRAY;
    }
    if (MessagePack.Code.isFixedMap(paramByte)) {
      return FIXMAP;
    }
    switch (paramByte)
    {
    case -63: 
    default: 
      return NEVER_USED;
    case -33: 
      return MAP32;
    case -34: 
      return MAP16;
    case -35: 
      return ARRAY32;
    case -36: 
      return ARRAY16;
    case -37: 
      return STR32;
    case -38: 
      return STR16;
    case -39: 
      return STR8;
    case -40: 
      return FIXEXT16;
    case -41: 
      return FIXEXT8;
    case -42: 
      return FIXEXT4;
    case -43: 
      return FIXEXT2;
    case -44: 
      return FIXEXT1;
    case -45: 
      return INT64;
    case -46: 
      return INT32;
    case -47: 
      return INT16;
    case -48: 
      return INT8;
    case -49: 
      return UINT64;
    case -50: 
      return UINT32;
    case -51: 
      return UINT16;
    case -52: 
      return UINT8;
    case -53: 
      return FLOAT64;
    case -54: 
      return FLOAT32;
    case -55: 
      return EXT32;
    case -56: 
      return EXT16;
    case -57: 
      return EXT8;
    case -58: 
      return BIN32;
    case -59: 
      return BIN16;
    case -60: 
      return BIN8;
    case -62: 
    case -61: 
      return BOOLEAN;
    }
    return NIL;
  }
  
  public static MessageFormat valueOf(byte paramByte)
  {
    return formatTable[(paramByte & 0xFF)];
  }
  
  public ValueType getValueType()
    throws MessageFormatException
  {
    if (this != NEVER_USED) {
      return this.valueType;
    }
    throw new MessageFormatException("Cannot convert NEVER_USED to ValueType");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\MessageFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */