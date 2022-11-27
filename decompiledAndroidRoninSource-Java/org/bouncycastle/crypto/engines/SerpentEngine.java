package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Pack;

public final class SerpentEngine
  extends SerpentEngineBase
{
  protected void decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    this.X0 = (this.wKey[''] ^ Pack.littleEndianToInt(paramArrayOfByte1, paramInt1));
    this.X1 = (this.wKey[''] ^ Pack.littleEndianToInt(paramArrayOfByte1, paramInt1 + 4));
    this.X2 = (this.wKey[''] ^ Pack.littleEndianToInt(paramArrayOfByte1, paramInt1 + 8));
    int i = this.wKey[''];
    this.X3 = (Pack.littleEndianToInt(paramArrayOfByte1, paramInt1 + 12) ^ i);
    ib7(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[124];
    this.X1 ^= this.wKey[125];
    this.X2 ^= this.wKey[126];
    this.X3 ^= this.wKey[127];
    inverseLT();
    ib6(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[120];
    this.X1 ^= this.wKey[121];
    this.X2 ^= this.wKey[122];
    this.X3 ^= this.wKey[123];
    inverseLT();
    ib5(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[116];
    this.X1 ^= this.wKey[117];
    this.X2 ^= this.wKey[118];
    this.X3 ^= this.wKey[119];
    inverseLT();
    ib4(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[112];
    this.X1 ^= this.wKey[113];
    this.X2 ^= this.wKey[114];
    this.X3 ^= this.wKey[115];
    inverseLT();
    ib3(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[108];
    this.X1 ^= this.wKey[109];
    this.X2 ^= this.wKey[110];
    this.X3 ^= this.wKey[111];
    inverseLT();
    ib2(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[104];
    this.X1 ^= this.wKey[105];
    this.X2 ^= this.wKey[106];
    this.X3 ^= this.wKey[107];
    inverseLT();
    ib1(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[100];
    this.X1 ^= this.wKey[101];
    this.X2 ^= this.wKey[102];
    this.X3 ^= this.wKey[103];
    inverseLT();
    ib0(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[96];
    this.X1 ^= this.wKey[97];
    this.X2 ^= this.wKey[98];
    this.X3 ^= this.wKey[99];
    inverseLT();
    ib7(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[92];
    this.X1 ^= this.wKey[93];
    this.X2 ^= this.wKey[94];
    this.X3 ^= this.wKey[95];
    inverseLT();
    ib6(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[88];
    this.X1 ^= this.wKey[89];
    this.X2 ^= this.wKey[90];
    this.X3 ^= this.wKey[91];
    inverseLT();
    ib5(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[84];
    this.X1 ^= this.wKey[85];
    this.X2 ^= this.wKey[86];
    this.X3 ^= this.wKey[87];
    inverseLT();
    ib4(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[80];
    this.X1 ^= this.wKey[81];
    this.X2 ^= this.wKey[82];
    this.X3 ^= this.wKey[83];
    inverseLT();
    ib3(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[76];
    this.X1 ^= this.wKey[77];
    this.X2 ^= this.wKey[78];
    this.X3 ^= this.wKey[79];
    inverseLT();
    ib2(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[72];
    this.X1 ^= this.wKey[73];
    this.X2 ^= this.wKey[74];
    this.X3 ^= this.wKey[75];
    inverseLT();
    ib1(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[68];
    this.X1 ^= this.wKey[69];
    this.X2 ^= this.wKey[70];
    this.X3 ^= this.wKey[71];
    inverseLT();
    ib0(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[64];
    this.X1 ^= this.wKey[65];
    this.X2 ^= this.wKey[66];
    this.X3 ^= this.wKey[67];
    inverseLT();
    ib7(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[60];
    this.X1 ^= this.wKey[61];
    this.X2 ^= this.wKey[62];
    this.X3 ^= this.wKey[63];
    inverseLT();
    ib6(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[56];
    this.X1 ^= this.wKey[57];
    this.X2 ^= this.wKey[58];
    this.X3 ^= this.wKey[59];
    inverseLT();
    ib5(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[52];
    this.X1 ^= this.wKey[53];
    this.X2 ^= this.wKey[54];
    this.X3 ^= this.wKey[55];
    inverseLT();
    ib4(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[48];
    this.X1 ^= this.wKey[49];
    this.X2 ^= this.wKey[50];
    this.X3 ^= this.wKey[51];
    inverseLT();
    ib3(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[44];
    this.X1 ^= this.wKey[45];
    this.X2 ^= this.wKey[46];
    this.X3 ^= this.wKey[47];
    inverseLT();
    ib2(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[40];
    this.X1 ^= this.wKey[41];
    this.X2 ^= this.wKey[42];
    this.X3 ^= this.wKey[43];
    inverseLT();
    ib1(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[36];
    this.X1 ^= this.wKey[37];
    this.X2 ^= this.wKey[38];
    this.X3 ^= this.wKey[39];
    inverseLT();
    ib0(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[32];
    this.X1 ^= this.wKey[33];
    this.X2 ^= this.wKey[34];
    this.X3 ^= this.wKey[35];
    inverseLT();
    ib7(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[28];
    this.X1 ^= this.wKey[29];
    this.X2 ^= this.wKey[30];
    this.X3 ^= this.wKey[31];
    inverseLT();
    ib6(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[24];
    this.X1 ^= this.wKey[25];
    this.X2 ^= this.wKey[26];
    this.X3 ^= this.wKey[27];
    inverseLT();
    ib5(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[20];
    this.X1 ^= this.wKey[21];
    this.X2 ^= this.wKey[22];
    this.X3 ^= this.wKey[23];
    inverseLT();
    ib4(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[16];
    this.X1 ^= this.wKey[17];
    this.X2 ^= this.wKey[18];
    this.X3 ^= this.wKey[19];
    inverseLT();
    ib3(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[12];
    this.X1 ^= this.wKey[13];
    this.X2 ^= this.wKey[14];
    this.X3 ^= this.wKey[15];
    inverseLT();
    ib2(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[8];
    this.X1 ^= this.wKey[9];
    this.X2 ^= this.wKey[10];
    this.X3 ^= this.wKey[11];
    inverseLT();
    ib1(this.X0, this.X1, this.X2, this.X3);
    this.X0 ^= this.wKey[4];
    this.X1 ^= this.wKey[5];
    this.X2 ^= this.wKey[6];
    this.X3 ^= this.wKey[7];
    inverseLT();
    ib0(this.X0, this.X1, this.X2, this.X3);
    Pack.intToLittleEndian(this.X0 ^ this.wKey[0], paramArrayOfByte2, paramInt2);
    Pack.intToLittleEndian(this.X1 ^ this.wKey[1], paramArrayOfByte2, paramInt2 + 4);
    Pack.intToLittleEndian(this.X2 ^ this.wKey[2], paramArrayOfByte2, paramInt2 + 8);
    Pack.intToLittleEndian(this.X3 ^ this.wKey[3], paramArrayOfByte2, paramInt2 + 12);
  }
  
  protected void encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    this.X0 = Pack.littleEndianToInt(paramArrayOfByte1, paramInt1);
    this.X1 = Pack.littleEndianToInt(paramArrayOfByte1, paramInt1 + 4);
    this.X2 = Pack.littleEndianToInt(paramArrayOfByte1, paramInt1 + 8);
    this.X3 = Pack.littleEndianToInt(paramArrayOfByte1, paramInt1 + 12);
    sb0(this.wKey[0] ^ this.X0, this.wKey[1] ^ this.X1, this.wKey[2] ^ this.X2, this.wKey[3] ^ this.X3);
    LT();
    sb1(this.wKey[4] ^ this.X0, this.wKey[5] ^ this.X1, this.wKey[6] ^ this.X2, this.wKey[7] ^ this.X3);
    LT();
    sb2(this.wKey[8] ^ this.X0, this.wKey[9] ^ this.X1, this.wKey[10] ^ this.X2, this.wKey[11] ^ this.X3);
    LT();
    sb3(this.wKey[12] ^ this.X0, this.wKey[13] ^ this.X1, this.wKey[14] ^ this.X2, this.wKey[15] ^ this.X3);
    LT();
    sb4(this.wKey[16] ^ this.X0, this.wKey[17] ^ this.X1, this.wKey[18] ^ this.X2, this.wKey[19] ^ this.X3);
    LT();
    sb5(this.wKey[20] ^ this.X0, this.wKey[21] ^ this.X1, this.wKey[22] ^ this.X2, this.wKey[23] ^ this.X3);
    LT();
    sb6(this.wKey[24] ^ this.X0, this.wKey[25] ^ this.X1, this.wKey[26] ^ this.X2, this.wKey[27] ^ this.X3);
    LT();
    sb7(this.wKey[28] ^ this.X0, this.wKey[29] ^ this.X1, this.wKey[30] ^ this.X2, this.wKey[31] ^ this.X3);
    LT();
    sb0(this.wKey[32] ^ this.X0, this.wKey[33] ^ this.X1, this.wKey[34] ^ this.X2, this.wKey[35] ^ this.X3);
    LT();
    sb1(this.wKey[36] ^ this.X0, this.wKey[37] ^ this.X1, this.wKey[38] ^ this.X2, this.wKey[39] ^ this.X3);
    LT();
    sb2(this.wKey[40] ^ this.X0, this.wKey[41] ^ this.X1, this.wKey[42] ^ this.X2, this.wKey[43] ^ this.X3);
    LT();
    sb3(this.wKey[44] ^ this.X0, this.wKey[45] ^ this.X1, this.wKey[46] ^ this.X2, this.wKey[47] ^ this.X3);
    LT();
    sb4(this.wKey[48] ^ this.X0, this.wKey[49] ^ this.X1, this.wKey[50] ^ this.X2, this.wKey[51] ^ this.X3);
    LT();
    sb5(this.wKey[52] ^ this.X0, this.wKey[53] ^ this.X1, this.wKey[54] ^ this.X2, this.wKey[55] ^ this.X3);
    LT();
    sb6(this.wKey[56] ^ this.X0, this.wKey[57] ^ this.X1, this.wKey[58] ^ this.X2, this.wKey[59] ^ this.X3);
    LT();
    sb7(this.wKey[60] ^ this.X0, this.wKey[61] ^ this.X1, this.wKey[62] ^ this.X2, this.wKey[63] ^ this.X3);
    LT();
    sb0(this.wKey[64] ^ this.X0, this.wKey[65] ^ this.X1, this.wKey[66] ^ this.X2, this.wKey[67] ^ this.X3);
    LT();
    sb1(this.wKey[68] ^ this.X0, this.wKey[69] ^ this.X1, this.wKey[70] ^ this.X2, this.wKey[71] ^ this.X3);
    LT();
    sb2(this.wKey[72] ^ this.X0, this.wKey[73] ^ this.X1, this.wKey[74] ^ this.X2, this.wKey[75] ^ this.X3);
    LT();
    sb3(this.wKey[76] ^ this.X0, this.wKey[77] ^ this.X1, this.wKey[78] ^ this.X2, this.wKey[79] ^ this.X3);
    LT();
    sb4(this.wKey[80] ^ this.X0, this.wKey[81] ^ this.X1, this.wKey[82] ^ this.X2, this.wKey[83] ^ this.X3);
    LT();
    sb5(this.wKey[84] ^ this.X0, this.wKey[85] ^ this.X1, this.wKey[86] ^ this.X2, this.wKey[87] ^ this.X3);
    LT();
    sb6(this.wKey[88] ^ this.X0, this.wKey[89] ^ this.X1, this.wKey[90] ^ this.X2, this.wKey[91] ^ this.X3);
    LT();
    sb7(this.wKey[92] ^ this.X0, this.wKey[93] ^ this.X1, this.wKey[94] ^ this.X2, this.wKey[95] ^ this.X3);
    LT();
    sb0(this.wKey[96] ^ this.X0, this.wKey[97] ^ this.X1, this.wKey[98] ^ this.X2, this.wKey[99] ^ this.X3);
    LT();
    sb1(this.wKey[100] ^ this.X0, this.wKey[101] ^ this.X1, this.wKey[102] ^ this.X2, this.wKey[103] ^ this.X3);
    LT();
    sb2(this.wKey[104] ^ this.X0, this.wKey[105] ^ this.X1, this.wKey[106] ^ this.X2, this.wKey[107] ^ this.X3);
    LT();
    sb3(this.wKey[108] ^ this.X0, this.wKey[109] ^ this.X1, this.wKey[110] ^ this.X2, this.wKey[111] ^ this.X3);
    LT();
    sb4(this.wKey[112] ^ this.X0, this.wKey[113] ^ this.X1, this.wKey[114] ^ this.X2, this.wKey[115] ^ this.X3);
    LT();
    sb5(this.wKey[116] ^ this.X0, this.wKey[117] ^ this.X1, this.wKey[118] ^ this.X2, this.wKey[119] ^ this.X3);
    LT();
    sb6(this.wKey[120] ^ this.X0, this.wKey[121] ^ this.X1, this.wKey[122] ^ this.X2, this.wKey[123] ^ this.X3);
    LT();
    sb7(this.wKey[124] ^ this.X0, this.wKey[125] ^ this.X1, this.wKey[126] ^ this.X2, this.wKey[127] ^ this.X3);
    Pack.intToLittleEndian(this.wKey[''] ^ this.X0, paramArrayOfByte2, paramInt2);
    Pack.intToLittleEndian(this.wKey[''] ^ this.X1, paramArrayOfByte2, paramInt2 + 4);
    Pack.intToLittleEndian(this.wKey[''] ^ this.X2, paramArrayOfByte2, paramInt2 + 8);
    Pack.intToLittleEndian(this.wKey[''] ^ this.X3, paramArrayOfByte2, paramInt2 + 12);
  }
  
  protected int[] makeWorkingKey(byte[] paramArrayOfByte)
    throws IllegalArgumentException
  {
    int[] arrayOfInt = new int[16];
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = j + 4;
      if (k >= paramArrayOfByte.length) {
        break;
      }
      arrayOfInt[i] = Pack.littleEndianToInt(paramArrayOfByte, j);
      j = k;
      i += 1;
    }
    if (j % 4 == 0)
    {
      k = i + 1;
      arrayOfInt[i] = Pack.littleEndianToInt(paramArrayOfByte, j);
      if (k < 8) {
        arrayOfInt[k] = 1;
      }
      paramArrayOfByte = new int[''];
      i = 8;
      while (i < 16)
      {
        j = i - 8;
        arrayOfInt[i] = rotateLeft(0x9E3779B9 ^ arrayOfInt[j] ^ arrayOfInt[(i - 5)] ^ arrayOfInt[(i - 3)] ^ arrayOfInt[(i - 1)] ^ j, 11);
        i += 1;
      }
      System.arraycopy(arrayOfInt, 8, paramArrayOfByte, 0, 8);
      i = 8;
      while (i < 132)
      {
        paramArrayOfByte[i] = rotateLeft(paramArrayOfByte[(i - 8)] ^ paramArrayOfByte[(i - 5)] ^ paramArrayOfByte[(i - 3)] ^ paramArrayOfByte[(i - 1)] ^ 0x9E3779B9 ^ i, 11);
        i += 1;
      }
      sb3(paramArrayOfByte[0], paramArrayOfByte[1], paramArrayOfByte[2], paramArrayOfByte[3]);
      paramArrayOfByte[0] = this.X0;
      paramArrayOfByte[1] = this.X1;
      paramArrayOfByte[2] = this.X2;
      paramArrayOfByte[3] = this.X3;
      sb2(paramArrayOfByte[4], paramArrayOfByte[5], paramArrayOfByte[6], paramArrayOfByte[7]);
      paramArrayOfByte[4] = this.X0;
      paramArrayOfByte[5] = this.X1;
      paramArrayOfByte[6] = this.X2;
      paramArrayOfByte[7] = this.X3;
      sb1(paramArrayOfByte[8], paramArrayOfByte[9], paramArrayOfByte[10], paramArrayOfByte[11]);
      paramArrayOfByte[8] = this.X0;
      paramArrayOfByte[9] = this.X1;
      paramArrayOfByte[10] = this.X2;
      paramArrayOfByte[11] = this.X3;
      sb0(paramArrayOfByte[12], paramArrayOfByte[13], paramArrayOfByte[14], paramArrayOfByte[15]);
      paramArrayOfByte[12] = this.X0;
      paramArrayOfByte[13] = this.X1;
      paramArrayOfByte[14] = this.X2;
      paramArrayOfByte[15] = this.X3;
      sb7(paramArrayOfByte[16], paramArrayOfByte[17], paramArrayOfByte[18], paramArrayOfByte[19]);
      paramArrayOfByte[16] = this.X0;
      paramArrayOfByte[17] = this.X1;
      paramArrayOfByte[18] = this.X2;
      paramArrayOfByte[19] = this.X3;
      sb6(paramArrayOfByte[20], paramArrayOfByte[21], paramArrayOfByte[22], paramArrayOfByte[23]);
      paramArrayOfByte[20] = this.X0;
      paramArrayOfByte[21] = this.X1;
      paramArrayOfByte[22] = this.X2;
      paramArrayOfByte[23] = this.X3;
      sb5(paramArrayOfByte[24], paramArrayOfByte[25], paramArrayOfByte[26], paramArrayOfByte[27]);
      paramArrayOfByte[24] = this.X0;
      paramArrayOfByte[25] = this.X1;
      paramArrayOfByte[26] = this.X2;
      paramArrayOfByte[27] = this.X3;
      sb4(paramArrayOfByte[28], paramArrayOfByte[29], paramArrayOfByte[30], paramArrayOfByte[31]);
      paramArrayOfByte[28] = this.X0;
      paramArrayOfByte[29] = this.X1;
      paramArrayOfByte[30] = this.X2;
      paramArrayOfByte[31] = this.X3;
      sb3(paramArrayOfByte[32], paramArrayOfByte[33], paramArrayOfByte[34], paramArrayOfByte[35]);
      paramArrayOfByte[32] = this.X0;
      paramArrayOfByte[33] = this.X1;
      paramArrayOfByte[34] = this.X2;
      paramArrayOfByte[35] = this.X3;
      sb2(paramArrayOfByte[36], paramArrayOfByte[37], paramArrayOfByte[38], paramArrayOfByte[39]);
      paramArrayOfByte[36] = this.X0;
      paramArrayOfByte[37] = this.X1;
      paramArrayOfByte[38] = this.X2;
      paramArrayOfByte[39] = this.X3;
      sb1(paramArrayOfByte[40], paramArrayOfByte[41], paramArrayOfByte[42], paramArrayOfByte[43]);
      paramArrayOfByte[40] = this.X0;
      paramArrayOfByte[41] = this.X1;
      paramArrayOfByte[42] = this.X2;
      paramArrayOfByte[43] = this.X3;
      sb0(paramArrayOfByte[44], paramArrayOfByte[45], paramArrayOfByte[46], paramArrayOfByte[47]);
      paramArrayOfByte[44] = this.X0;
      paramArrayOfByte[45] = this.X1;
      paramArrayOfByte[46] = this.X2;
      paramArrayOfByte[47] = this.X3;
      sb7(paramArrayOfByte[48], paramArrayOfByte[49], paramArrayOfByte[50], paramArrayOfByte[51]);
      paramArrayOfByte[48] = this.X0;
      paramArrayOfByte[49] = this.X1;
      paramArrayOfByte[50] = this.X2;
      paramArrayOfByte[51] = this.X3;
      sb6(paramArrayOfByte[52], paramArrayOfByte[53], paramArrayOfByte[54], paramArrayOfByte[55]);
      paramArrayOfByte[52] = this.X0;
      paramArrayOfByte[53] = this.X1;
      paramArrayOfByte[54] = this.X2;
      paramArrayOfByte[55] = this.X3;
      sb5(paramArrayOfByte[56], paramArrayOfByte[57], paramArrayOfByte[58], paramArrayOfByte[59]);
      paramArrayOfByte[56] = this.X0;
      paramArrayOfByte[57] = this.X1;
      paramArrayOfByte[58] = this.X2;
      paramArrayOfByte[59] = this.X3;
      sb4(paramArrayOfByte[60], paramArrayOfByte[61], paramArrayOfByte[62], paramArrayOfByte[63]);
      paramArrayOfByte[60] = this.X0;
      paramArrayOfByte[61] = this.X1;
      paramArrayOfByte[62] = this.X2;
      paramArrayOfByte[63] = this.X3;
      sb3(paramArrayOfByte[64], paramArrayOfByte[65], paramArrayOfByte[66], paramArrayOfByte[67]);
      paramArrayOfByte[64] = this.X0;
      paramArrayOfByte[65] = this.X1;
      paramArrayOfByte[66] = this.X2;
      paramArrayOfByte[67] = this.X3;
      sb2(paramArrayOfByte[68], paramArrayOfByte[69], paramArrayOfByte[70], paramArrayOfByte[71]);
      paramArrayOfByte[68] = this.X0;
      paramArrayOfByte[69] = this.X1;
      paramArrayOfByte[70] = this.X2;
      paramArrayOfByte[71] = this.X3;
      sb1(paramArrayOfByte[72], paramArrayOfByte[73], paramArrayOfByte[74], paramArrayOfByte[75]);
      paramArrayOfByte[72] = this.X0;
      paramArrayOfByte[73] = this.X1;
      paramArrayOfByte[74] = this.X2;
      paramArrayOfByte[75] = this.X3;
      sb0(paramArrayOfByte[76], paramArrayOfByte[77], paramArrayOfByte[78], paramArrayOfByte[79]);
      paramArrayOfByte[76] = this.X0;
      paramArrayOfByte[77] = this.X1;
      paramArrayOfByte[78] = this.X2;
      paramArrayOfByte[79] = this.X3;
      sb7(paramArrayOfByte[80], paramArrayOfByte[81], paramArrayOfByte[82], paramArrayOfByte[83]);
      paramArrayOfByte[80] = this.X0;
      paramArrayOfByte[81] = this.X1;
      paramArrayOfByte[82] = this.X2;
      paramArrayOfByte[83] = this.X3;
      sb6(paramArrayOfByte[84], paramArrayOfByte[85], paramArrayOfByte[86], paramArrayOfByte[87]);
      paramArrayOfByte[84] = this.X0;
      paramArrayOfByte[85] = this.X1;
      paramArrayOfByte[86] = this.X2;
      paramArrayOfByte[87] = this.X3;
      sb5(paramArrayOfByte[88], paramArrayOfByte[89], paramArrayOfByte[90], paramArrayOfByte[91]);
      paramArrayOfByte[88] = this.X0;
      paramArrayOfByte[89] = this.X1;
      paramArrayOfByte[90] = this.X2;
      paramArrayOfByte[91] = this.X3;
      sb4(paramArrayOfByte[92], paramArrayOfByte[93], paramArrayOfByte[94], paramArrayOfByte[95]);
      paramArrayOfByte[92] = this.X0;
      paramArrayOfByte[93] = this.X1;
      paramArrayOfByte[94] = this.X2;
      paramArrayOfByte[95] = this.X3;
      sb3(paramArrayOfByte[96], paramArrayOfByte[97], paramArrayOfByte[98], paramArrayOfByte[99]);
      paramArrayOfByte[96] = this.X0;
      paramArrayOfByte[97] = this.X1;
      paramArrayOfByte[98] = this.X2;
      paramArrayOfByte[99] = this.X3;
      sb2(paramArrayOfByte[100], paramArrayOfByte[101], paramArrayOfByte[102], paramArrayOfByte[103]);
      paramArrayOfByte[100] = this.X0;
      paramArrayOfByte[101] = this.X1;
      paramArrayOfByte[102] = this.X2;
      paramArrayOfByte[103] = this.X3;
      sb1(paramArrayOfByte[104], paramArrayOfByte[105], paramArrayOfByte[106], paramArrayOfByte[107]);
      paramArrayOfByte[104] = this.X0;
      paramArrayOfByte[105] = this.X1;
      paramArrayOfByte[106] = this.X2;
      paramArrayOfByte[107] = this.X3;
      sb0(paramArrayOfByte[108], paramArrayOfByte[109], paramArrayOfByte[110], paramArrayOfByte[111]);
      paramArrayOfByte[108] = this.X0;
      paramArrayOfByte[109] = this.X1;
      paramArrayOfByte[110] = this.X2;
      paramArrayOfByte[111] = this.X3;
      sb7(paramArrayOfByte[112], paramArrayOfByte[113], paramArrayOfByte[114], paramArrayOfByte[115]);
      paramArrayOfByte[112] = this.X0;
      paramArrayOfByte[113] = this.X1;
      paramArrayOfByte[114] = this.X2;
      paramArrayOfByte[115] = this.X3;
      sb6(paramArrayOfByte[116], paramArrayOfByte[117], paramArrayOfByte[118], paramArrayOfByte[119]);
      paramArrayOfByte[116] = this.X0;
      paramArrayOfByte[117] = this.X1;
      paramArrayOfByte[118] = this.X2;
      paramArrayOfByte[119] = this.X3;
      sb5(paramArrayOfByte[120], paramArrayOfByte[121], paramArrayOfByte[122], paramArrayOfByte[123]);
      paramArrayOfByte[120] = this.X0;
      paramArrayOfByte[121] = this.X1;
      paramArrayOfByte[122] = this.X2;
      paramArrayOfByte[123] = this.X3;
      sb4(paramArrayOfByte[124], paramArrayOfByte[125], paramArrayOfByte[126], paramArrayOfByte[127]);
      paramArrayOfByte[124] = this.X0;
      paramArrayOfByte[125] = this.X1;
      paramArrayOfByte[126] = this.X2;
      paramArrayOfByte[127] = this.X3;
      sb3(paramArrayOfByte[''], paramArrayOfByte[''], paramArrayOfByte[''], paramArrayOfByte['']);
      paramArrayOfByte[''] = this.X0;
      paramArrayOfByte[''] = this.X1;
      paramArrayOfByte[''] = this.X2;
      paramArrayOfByte[''] = this.X3;
      return paramArrayOfByte;
    }
    throw new IllegalArgumentException("key must be a multiple of 4 bytes");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\SerpentEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */