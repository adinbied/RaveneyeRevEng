package org.bouncycastle.pqc.asn1;

import java.math.BigInteger;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.crypto.gmss.GMSSLeaf;
import org.bouncycastle.pqc.crypto.gmss.GMSSParameters;
import org.bouncycastle.pqc.crypto.gmss.GMSSRootCalc;
import org.bouncycastle.pqc.crypto.gmss.GMSSRootSig;
import org.bouncycastle.pqc.crypto.gmss.Treehash;

public class GMSSPrivateKey
  extends ASN1Object
{
  private ASN1Primitive primitive;
  
  private GMSSPrivateKey(ASN1Sequence paramASN1Sequence)
  {
    ASN1Sequence localASN1Sequence1 = (ASN1Sequence)paramASN1Sequence.getObjectAt(0);
    Object localObject = new int[localASN1Sequence1.size()];
    int i = 0;
    while (i < localASN1Sequence1.size())
    {
      localObject[i] = checkBigIntegerInIntRange(localASN1Sequence1.getObjectAt(i));
      i += 1;
    }
    localASN1Sequence1 = (ASN1Sequence)paramASN1Sequence.getObjectAt(1);
    int j = localASN1Sequence1.size();
    localObject = new byte[j][];
    i = 0;
    while (i < j)
    {
      localObject[i] = ((DEROctetString)localASN1Sequence1.getObjectAt(i)).getOctets();
      i += 1;
    }
    localASN1Sequence1 = (ASN1Sequence)paramASN1Sequence.getObjectAt(2);
    j = localASN1Sequence1.size();
    localObject = new byte[j][];
    i = 0;
    while (i < j)
    {
      localObject[i] = ((DEROctetString)localASN1Sequence1.getObjectAt(i)).getOctets();
      i += 1;
    }
    localASN1Sequence1 = (ASN1Sequence)paramASN1Sequence.getObjectAt(3);
    int k = localASN1Sequence1.size();
    localObject = new byte[k][][];
    i = 0;
    ASN1Sequence localASN1Sequence2;
    while (i < k)
    {
      localASN1Sequence2 = (ASN1Sequence)localASN1Sequence1.getObjectAt(i);
      localObject[i] = new byte[localASN1Sequence2.size()][];
      j = 0;
      while (j < localObject[i].length)
      {
        localObject[i][j] = ((DEROctetString)localASN1Sequence2.getObjectAt(j)).getOctets();
        j += 1;
      }
      i += 1;
    }
    localASN1Sequence1 = (ASN1Sequence)paramASN1Sequence.getObjectAt(4);
    k = localASN1Sequence1.size();
    localObject = new byte[k][][];
    i = 0;
    while (i < k)
    {
      localASN1Sequence2 = (ASN1Sequence)localASN1Sequence1.getObjectAt(i);
      localObject[i] = new byte[localASN1Sequence2.size()][];
      j = 0;
      while (j < localObject[i].length)
      {
        localObject[i][j] = ((DEROctetString)localASN1Sequence2.getObjectAt(j)).getOctets();
        j += 1;
      }
      i += 1;
    }
    paramASN1Sequence = new Treehash[((ASN1Sequence)paramASN1Sequence.getObjectAt(5)).size()][];
  }
  
  public GMSSPrivateKey(int[] paramArrayOfInt1, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, byte[][][] paramArrayOfByte3, byte[][][] paramArrayOfByte4, Treehash[][] paramArrayOfTreehash1, Treehash[][] paramArrayOfTreehash2, Vector[] paramArrayOfVector1, Vector[] paramArrayOfVector2, Vector[][] paramArrayOfVector3, Vector[][] paramArrayOfVector4, byte[][][] paramArrayOfByte5, GMSSLeaf[] paramArrayOfGMSSLeaf1, GMSSLeaf[] paramArrayOfGMSSLeaf2, GMSSLeaf[] paramArrayOfGMSSLeaf3, int[] paramArrayOfInt2, byte[][] paramArrayOfByte6, GMSSRootCalc[] paramArrayOfGMSSRootCalc, byte[][] paramArrayOfByte7, GMSSRootSig[] paramArrayOfGMSSRootSig, GMSSParameters paramGMSSParameters, AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.primitive = encode(paramArrayOfInt1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4, paramArrayOfByte5, paramArrayOfTreehash1, paramArrayOfTreehash2, paramArrayOfVector1, paramArrayOfVector2, paramArrayOfVector3, paramArrayOfVector4, paramArrayOfGMSSLeaf1, paramArrayOfGMSSLeaf2, paramArrayOfGMSSLeaf3, paramArrayOfInt2, paramArrayOfByte6, paramArrayOfGMSSRootCalc, paramArrayOfByte7, paramArrayOfGMSSRootSig, paramGMSSParameters, new AlgorithmIdentifier[] { paramAlgorithmIdentifier });
  }
  
  private static int checkBigIntegerInIntRange(ASN1Encodable paramASN1Encodable)
  {
    paramASN1Encodable = ((ASN1Integer)paramASN1Encodable).getValue();
    if ((paramASN1Encodable.compareTo(BigInteger.valueOf(2147483647L)) <= 0) && (paramASN1Encodable.compareTo(BigInteger.valueOf(-2147483648L)) >= 0)) {
      return paramASN1Encodable.intValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BigInteger not in Range: ");
    localStringBuilder.append(paramASN1Encodable.toString());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private ASN1Primitive encode(int[] paramArrayOfInt1, byte[][] paramArrayOfByte1, byte[][] paramArrayOfByte2, byte[][][] paramArrayOfByte3, byte[][][] paramArrayOfByte4, byte[][][] paramArrayOfByte5, Treehash[][] paramArrayOfTreehash1, Treehash[][] paramArrayOfTreehash2, Vector[] paramArrayOfVector1, Vector[] paramArrayOfVector2, Vector[][] paramArrayOfVector3, Vector[][] paramArrayOfVector4, GMSSLeaf[] paramArrayOfGMSSLeaf1, GMSSLeaf[] paramArrayOfGMSSLeaf2, GMSSLeaf[] paramArrayOfGMSSLeaf3, int[] paramArrayOfInt2, byte[][] paramArrayOfByte6, GMSSRootCalc[] paramArrayOfGMSSRootCalc, byte[][] paramArrayOfByte7, GMSSRootSig[] paramArrayOfGMSSRootSig, GMSSParameters paramGMSSParameters, AlgorithmIdentifier[] paramArrayOfAlgorithmIdentifier)
  {
    ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
    ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
    int i = 0;
    while (i < paramArrayOfInt1.length)
    {
      localASN1EncodableVector2.add(new ASN1Integer(paramArrayOfInt1[i]));
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(localASN1EncodableVector2));
    paramArrayOfInt1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfByte1.length)
    {
      paramArrayOfInt1.add(new DEROctetString(paramArrayOfByte1[i]));
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(paramArrayOfInt1));
    paramArrayOfInt1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfByte2.length)
    {
      paramArrayOfInt1.add(new DEROctetString(paramArrayOfByte2[i]));
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(paramArrayOfInt1));
    paramArrayOfInt1 = new ASN1EncodableVector();
    paramArrayOfByte1 = new ASN1EncodableVector();
    i = 0;
    int j;
    while (i < paramArrayOfByte3.length)
    {
      j = 0;
      while (j < paramArrayOfByte3[i].length)
      {
        paramArrayOfInt1.add(new DEROctetString(paramArrayOfByte3[i][j]));
        j += 1;
      }
      paramArrayOfByte1.add(new DERSequence(paramArrayOfInt1));
      paramArrayOfInt1 = new ASN1EncodableVector();
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(paramArrayOfByte1));
    paramArrayOfInt1 = new ASN1EncodableVector();
    paramArrayOfByte1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfByte4.length)
    {
      j = 0;
      while (j < paramArrayOfByte4[i].length)
      {
        paramArrayOfInt1.add(new DEROctetString(paramArrayOfByte4[i][j]));
        j += 1;
      }
      paramArrayOfByte1.add(new DERSequence(paramArrayOfInt1));
      paramArrayOfInt1 = new ASN1EncodableVector();
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(paramArrayOfByte1));
    localASN1EncodableVector2 = new ASN1EncodableVector();
    paramArrayOfInt1 = new ASN1EncodableVector();
    paramArrayOfByte2 = new ASN1EncodableVector();
    paramArrayOfByte3 = new ASN1EncodableVector();
    paramArrayOfByte1 = new ASN1EncodableVector();
    i = 0;
    int m;
    int k;
    while (i < paramArrayOfTreehash1.length)
    {
      j = 0;
      for (;;)
      {
        paramArrayOfByte4 = paramArrayOfTreehash1;
        if (j >= paramArrayOfByte4[i].length) {
          break;
        }
        paramArrayOfByte2.add(new DERSequence(paramArrayOfAlgorithmIdentifier[0]));
        m = paramArrayOfByte4[i][j].getStatInt()[1];
        paramArrayOfByte3.add(new DEROctetString(paramArrayOfByte4[i][j].getStatByte()[0]));
        paramArrayOfByte3.add(new DEROctetString(paramArrayOfByte4[i][j].getStatByte()[1]));
        paramArrayOfByte3.add(new DEROctetString(paramArrayOfByte4[i][j].getStatByte()[2]));
        k = 0;
        while (k < m)
        {
          paramArrayOfByte3.add(new DEROctetString(paramArrayOfByte4[i][j].getStatByte()[(k + 3)]));
          k += 1;
        }
        paramArrayOfByte2.add(new DERSequence(paramArrayOfByte3));
        paramArrayOfByte3 = new ASN1EncodableVector();
        paramArrayOfByte1.add(new ASN1Integer(paramArrayOfByte4[i][j].getStatInt()[0]));
        paramArrayOfByte1.add(new ASN1Integer(m));
        paramArrayOfByte1.add(new ASN1Integer(paramArrayOfByte4[i][j].getStatInt()[2]));
        paramArrayOfByte1.add(new ASN1Integer(paramArrayOfByte4[i][j].getStatInt()[3]));
        paramArrayOfByte1.add(new ASN1Integer(paramArrayOfByte4[i][j].getStatInt()[4]));
        paramArrayOfByte1.add(new ASN1Integer(paramArrayOfByte4[i][j].getStatInt()[5]));
        k = 0;
        while (k < m)
        {
          paramArrayOfByte1.add(new ASN1Integer(paramArrayOfTreehash1[i][j].getStatInt()[(k + 6)]));
          k += 1;
        }
        paramArrayOfByte2.add(new DERSequence(paramArrayOfByte1));
        paramArrayOfByte1 = new ASN1EncodableVector();
        paramArrayOfInt1.add(new DERSequence(paramArrayOfByte2));
        paramArrayOfByte2 = new ASN1EncodableVector();
        j += 1;
      }
      localASN1EncodableVector2.add(new DERSequence(paramArrayOfInt1));
      paramArrayOfInt1 = new ASN1EncodableVector();
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(localASN1EncodableVector2));
    paramArrayOfByte4 = new ASN1EncodableVector();
    paramArrayOfInt1 = new ASN1EncodableVector();
    paramArrayOfByte2 = new ASN1EncodableVector();
    paramArrayOfByte3 = new ASN1EncodableVector();
    paramArrayOfByte1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfTreehash2.length)
    {
      j = 0;
      while (j < paramArrayOfTreehash2[i].length)
      {
        paramArrayOfByte2.add(new DERSequence(paramArrayOfAlgorithmIdentifier[0]));
        m = paramArrayOfTreehash2[i][j].getStatInt()[1];
        paramArrayOfByte3.add(new DEROctetString(paramArrayOfTreehash2[i][j].getStatByte()[0]));
        paramArrayOfByte3.add(new DEROctetString(paramArrayOfTreehash2[i][j].getStatByte()[1]));
        paramArrayOfByte3.add(new DEROctetString(paramArrayOfTreehash2[i][j].getStatByte()[2]));
        k = 0;
        while (k < m)
        {
          paramArrayOfByte3.add(new DEROctetString(paramArrayOfTreehash2[i][j].getStatByte()[(k + 3)]));
          k += 1;
        }
        paramArrayOfByte2.add(new DERSequence(paramArrayOfByte3));
        paramArrayOfByte3 = new ASN1EncodableVector();
        paramArrayOfByte1.add(new ASN1Integer(paramArrayOfTreehash2[i][j].getStatInt()[0]));
        paramArrayOfByte1.add(new ASN1Integer(m));
        paramArrayOfByte1.add(new ASN1Integer(paramArrayOfTreehash2[i][j].getStatInt()[2]));
        paramArrayOfByte1.add(new ASN1Integer(paramArrayOfTreehash2[i][j].getStatInt()[3]));
        paramArrayOfByte1.add(new ASN1Integer(paramArrayOfTreehash2[i][j].getStatInt()[4]));
        paramArrayOfByte1.add(new ASN1Integer(paramArrayOfTreehash2[i][j].getStatInt()[5]));
        k = 0;
        while (k < m)
        {
          paramArrayOfByte1.add(new ASN1Integer(paramArrayOfTreehash2[i][j].getStatInt()[(k + 6)]));
          k += 1;
        }
        paramArrayOfByte2.add(new DERSequence(paramArrayOfByte1));
        paramArrayOfByte1 = new ASN1EncodableVector();
        paramArrayOfInt1.add(new DERSequence(paramArrayOfByte2));
        paramArrayOfByte2 = new ASN1EncodableVector();
        j += 1;
      }
      paramArrayOfByte4.add(new DERSequence(new DERSequence(paramArrayOfInt1)));
      paramArrayOfInt1 = new ASN1EncodableVector();
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(paramArrayOfByte4));
    paramArrayOfInt1 = new ASN1EncodableVector();
    paramArrayOfByte1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfByte5.length)
    {
      j = 0;
      while (j < paramArrayOfByte5[i].length)
      {
        paramArrayOfInt1.add(new DEROctetString(paramArrayOfByte5[i][j]));
        j += 1;
      }
      paramArrayOfByte1.add(new DERSequence(paramArrayOfInt1));
      paramArrayOfInt1 = new ASN1EncodableVector();
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(paramArrayOfByte1));
    paramArrayOfInt1 = new ASN1EncodableVector();
    paramArrayOfByte1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfVector1.length)
    {
      j = 0;
      while (j < paramArrayOfVector1[i].size())
      {
        paramArrayOfInt1.add(new DEROctetString((byte[])paramArrayOfVector1[i].elementAt(j)));
        j += 1;
      }
      paramArrayOfByte1.add(new DERSequence(paramArrayOfInt1));
      paramArrayOfInt1 = new ASN1EncodableVector();
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(paramArrayOfByte1));
    paramArrayOfInt1 = new ASN1EncodableVector();
    paramArrayOfByte1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfVector2.length)
    {
      j = 0;
      while (j < paramArrayOfVector2[i].size())
      {
        paramArrayOfInt1.add(new DEROctetString((byte[])paramArrayOfVector2[i].elementAt(j)));
        j += 1;
      }
      paramArrayOfByte1.add(new DERSequence(paramArrayOfInt1));
      paramArrayOfInt1 = new ASN1EncodableVector();
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(paramArrayOfByte1));
    paramArrayOfByte1 = new ASN1EncodableVector();
    paramArrayOfInt1 = new ASN1EncodableVector();
    paramArrayOfByte2 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfVector3.length)
    {
      j = 0;
      while (j < paramArrayOfVector3[i].length)
      {
        k = 0;
        while (k < paramArrayOfVector3[i][j].size())
        {
          paramArrayOfByte1.add(new DEROctetString((byte[])paramArrayOfVector3[i][j].elementAt(k)));
          k += 1;
        }
        paramArrayOfInt1.add(new DERSequence(paramArrayOfByte1));
        paramArrayOfByte1 = new ASN1EncodableVector();
        j += 1;
      }
      paramArrayOfByte2.add(new DERSequence(paramArrayOfInt1));
      paramArrayOfInt1 = new ASN1EncodableVector();
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(paramArrayOfByte2));
    paramArrayOfByte1 = new ASN1EncodableVector();
    paramArrayOfInt1 = new ASN1EncodableVector();
    paramArrayOfByte2 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfVector4.length)
    {
      j = 0;
      while (j < paramArrayOfVector4[i].length)
      {
        k = 0;
        while (k < paramArrayOfVector4[i][j].size())
        {
          paramArrayOfByte1.add(new DEROctetString((byte[])paramArrayOfVector4[i][j].elementAt(k)));
          k += 1;
        }
        paramArrayOfInt1.add(new DERSequence(paramArrayOfByte1));
        paramArrayOfByte1 = new ASN1EncodableVector();
        j += 1;
      }
      paramArrayOfByte2.add(new DERSequence(paramArrayOfInt1));
      paramArrayOfInt1 = new ASN1EncodableVector();
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(paramArrayOfByte2));
    paramArrayOfByte3 = new ASN1EncodableVector();
    paramArrayOfByte1 = new ASN1EncodableVector();
    paramArrayOfByte2 = new ASN1EncodableVector();
    paramArrayOfInt1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfGMSSLeaf1.length)
    {
      paramArrayOfByte1.add(new DERSequence(paramArrayOfAlgorithmIdentifier[0]));
      paramArrayOfByte4 = paramArrayOfGMSSLeaf1[i].getStatByte();
      paramArrayOfByte2.add(new DEROctetString(paramArrayOfByte4[0]));
      paramArrayOfByte2.add(new DEROctetString(paramArrayOfByte4[1]));
      paramArrayOfByte2.add(new DEROctetString(paramArrayOfByte4[2]));
      paramArrayOfByte2.add(new DEROctetString(paramArrayOfByte4[3]));
      paramArrayOfByte1.add(new DERSequence(paramArrayOfByte2));
      paramArrayOfByte2 = new ASN1EncodableVector();
      paramArrayOfByte4 = paramArrayOfGMSSLeaf1[i].getStatInt();
      paramArrayOfInt1.add(new ASN1Integer(paramArrayOfByte4[0]));
      paramArrayOfInt1.add(new ASN1Integer(paramArrayOfByte4[1]));
      paramArrayOfInt1.add(new ASN1Integer(paramArrayOfByte4[2]));
      paramArrayOfInt1.add(new ASN1Integer(paramArrayOfByte4[3]));
      paramArrayOfByte1.add(new DERSequence(paramArrayOfInt1));
      paramArrayOfInt1 = new ASN1EncodableVector();
      paramArrayOfByte3.add(new DERSequence(paramArrayOfByte1));
      paramArrayOfByte1 = new ASN1EncodableVector();
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(paramArrayOfByte3));
    paramArrayOfByte3 = new ASN1EncodableVector();
    paramArrayOfByte1 = new ASN1EncodableVector();
    paramArrayOfByte2 = new ASN1EncodableVector();
    paramArrayOfInt1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfGMSSLeaf2.length)
    {
      paramArrayOfByte1.add(new DERSequence(paramArrayOfAlgorithmIdentifier[0]));
      paramArrayOfByte4 = paramArrayOfGMSSLeaf2[i].getStatByte();
      paramArrayOfByte2.add(new DEROctetString(paramArrayOfByte4[0]));
      paramArrayOfByte2.add(new DEROctetString(paramArrayOfByte4[1]));
      paramArrayOfByte2.add(new DEROctetString(paramArrayOfByte4[2]));
      paramArrayOfByte2.add(new DEROctetString(paramArrayOfByte4[3]));
      paramArrayOfByte1.add(new DERSequence(paramArrayOfByte2));
      paramArrayOfByte2 = new ASN1EncodableVector();
      paramArrayOfByte4 = paramArrayOfGMSSLeaf2[i].getStatInt();
      paramArrayOfInt1.add(new ASN1Integer(paramArrayOfByte4[0]));
      paramArrayOfInt1.add(new ASN1Integer(paramArrayOfByte4[1]));
      paramArrayOfInt1.add(new ASN1Integer(paramArrayOfByte4[2]));
      paramArrayOfInt1.add(new ASN1Integer(paramArrayOfByte4[3]));
      paramArrayOfByte1.add(new DERSequence(paramArrayOfInt1));
      paramArrayOfInt1 = new ASN1EncodableVector();
      paramArrayOfByte3.add(new DERSequence(paramArrayOfByte1));
      paramArrayOfByte1 = new ASN1EncodableVector();
      i += 1;
    }
    localASN1EncodableVector1.add(new DERSequence(paramArrayOfByte3));
    paramArrayOfByte4 = new ASN1EncodableVector();
    paramArrayOfByte2 = new ASN1EncodableVector();
    paramArrayOfByte3 = new ASN1EncodableVector();
    paramArrayOfByte1 = new ASN1EncodableVector();
    paramArrayOfInt1 = localASN1EncodableVector1;
    i = 0;
    while (i < paramArrayOfGMSSLeaf3.length)
    {
      paramArrayOfByte2.add(new DERSequence(paramArrayOfAlgorithmIdentifier[0]));
      paramArrayOfByte5 = paramArrayOfGMSSLeaf3[i].getStatByte();
      paramArrayOfByte3.add(new DEROctetString(paramArrayOfByte5[0]));
      paramArrayOfByte3.add(new DEROctetString(paramArrayOfByte5[1]));
      paramArrayOfByte3.add(new DEROctetString(paramArrayOfByte5[2]));
      paramArrayOfByte3.add(new DEROctetString(paramArrayOfByte5[3]));
      paramArrayOfByte2.add(new DERSequence(paramArrayOfByte3));
      paramArrayOfByte3 = new ASN1EncodableVector();
      paramArrayOfByte5 = paramArrayOfGMSSLeaf3[i].getStatInt();
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfByte5[0]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfByte5[1]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfByte5[2]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfByte5[3]));
      paramArrayOfByte2.add(new DERSequence(paramArrayOfByte1));
      paramArrayOfByte1 = new ASN1EncodableVector();
      paramArrayOfByte4.add(new DERSequence(paramArrayOfByte2));
      paramArrayOfByte2 = new ASN1EncodableVector();
      i += 1;
    }
    paramArrayOfInt1.add(new DERSequence(paramArrayOfByte4));
    paramArrayOfByte1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfInt2.length)
    {
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfInt2[i]));
      i += 1;
    }
    paramArrayOfInt1.add(new DERSequence(paramArrayOfByte1));
    paramArrayOfByte1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfByte6.length)
    {
      paramArrayOfByte1.add(new DEROctetString(paramArrayOfByte6[i]));
      i += 1;
    }
    paramArrayOfInt1.add(new DERSequence(paramArrayOfByte1));
    paramArrayOfGMSSLeaf1 = new ASN1EncodableVector();
    paramArrayOfTreehash2 = new ASN1EncodableVector();
    new ASN1EncodableVector();
    paramArrayOfByte2 = new ASN1EncodableVector();
    paramArrayOfByte1 = new ASN1EncodableVector();
    paramArrayOfVector1 = new ASN1EncodableVector();
    paramArrayOfTreehash1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfGMSSRootCalc.length)
    {
      paramArrayOfTreehash2.add(new DERSequence(paramArrayOfAlgorithmIdentifier[0]));
      new ASN1EncodableVector();
      k = paramArrayOfGMSSRootCalc[i].getStatInt()[0];
      m = paramArrayOfGMSSRootCalc[i].getStatInt()[7];
      paramArrayOfByte2.add(new DEROctetString(paramArrayOfGMSSRootCalc[i].getStatByte()[0]));
      j = 0;
      while (j < k)
      {
        paramArrayOfByte3 = paramArrayOfGMSSRootCalc[i].getStatByte();
        j += 1;
        paramArrayOfByte2.add(new DEROctetString(paramArrayOfByte3[j]));
      }
      j = 0;
      while (j < m)
      {
        paramArrayOfByte2.add(new DEROctetString(paramArrayOfGMSSRootCalc[i].getStatByte()[(k + 1 + j)]));
        j += 1;
      }
      paramArrayOfTreehash2.add(new DERSequence(paramArrayOfByte2));
      paramArrayOfByte5 = new ASN1EncodableVector();
      paramArrayOfByte1.add(new ASN1Integer(k));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getStatInt()[1]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getStatInt()[2]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getStatInt()[3]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getStatInt()[4]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getStatInt()[5]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getStatInt()[6]));
      paramArrayOfByte1.add(new ASN1Integer(m));
      j = 0;
      while (j < k)
      {
        paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getStatInt()[(j + 8)]));
        j += 1;
      }
      j = 0;
      while (j < m)
      {
        paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getStatInt()[(k + 8 + j)]));
        j += 1;
      }
      paramArrayOfTreehash2.add(new DERSequence(paramArrayOfByte1));
      paramArrayOfByte1 = new ASN1EncodableVector();
      paramArrayOfVector3 = new ASN1EncodableVector();
      paramArrayOfVector4 = new ASN1EncodableVector();
      paramArrayOfVector2 = new ASN1EncodableVector();
      paramArrayOfByte4 = paramArrayOfByte5;
      paramArrayOfByte3 = paramArrayOfByte1;
      paramArrayOfByte2 = paramArrayOfInt1;
      if (paramArrayOfGMSSRootCalc[i].getTreehash() != null)
      {
        j = 0;
        for (;;)
        {
          paramArrayOfByte4 = paramArrayOfByte5;
          paramArrayOfByte3 = paramArrayOfByte1;
          paramArrayOfByte2 = paramArrayOfInt1;
          if (j >= paramArrayOfGMSSRootCalc[i].getTreehash().length) {
            break;
          }
          paramArrayOfVector3.add(new DERSequence(paramArrayOfAlgorithmIdentifier[0]));
          m = paramArrayOfGMSSRootCalc[i].getTreehash()[j].getStatInt()[1];
          paramArrayOfVector4.add(new DEROctetString(paramArrayOfGMSSRootCalc[i].getTreehash()[j].getStatByte()[0]));
          paramArrayOfVector4.add(new DEROctetString(paramArrayOfGMSSRootCalc[i].getTreehash()[j].getStatByte()[1]));
          paramArrayOfVector4.add(new DEROctetString(paramArrayOfGMSSRootCalc[i].getTreehash()[j].getStatByte()[2]));
          k = 0;
          while (k < m)
          {
            paramArrayOfVector4.add(new DEROctetString(paramArrayOfGMSSRootCalc[i].getTreehash()[j].getStatByte()[(k + 3)]));
            k += 1;
          }
          paramArrayOfVector3.add(new DERSequence(paramArrayOfVector4));
          paramArrayOfVector4 = new ASN1EncodableVector();
          k = paramArrayOfGMSSRootCalc[i].getTreehash()[j].getStatInt()[0];
          paramArrayOfVector2.add(new ASN1Integer(k));
          paramArrayOfVector2.add(new ASN1Integer(m));
          paramArrayOfVector2.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getTreehash()[j].getStatInt()[2]));
          paramArrayOfVector2.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getTreehash()[j].getStatInt()[3]));
          paramArrayOfVector2.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getTreehash()[j].getStatInt()[4]));
          paramArrayOfVector2.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getTreehash()[j].getStatInt()[5]));
          int n = 0;
          k = m;
          m = n;
          while (m < k)
          {
            paramArrayOfVector2.add(new ASN1Integer(paramArrayOfGMSSRootCalc[i].getTreehash()[j].getStatInt()[(m + 6)]));
            m += 1;
          }
          paramArrayOfVector3.add(new DERSequence(paramArrayOfVector2));
          paramArrayOfVector2 = new ASN1EncodableVector();
          paramArrayOfVector1.add(new DERSequence(paramArrayOfVector3));
          paramArrayOfVector3 = new ASN1EncodableVector();
          j += 1;
        }
      }
      paramArrayOfTreehash2.add(new DERSequence(paramArrayOfVector1));
      paramArrayOfVector1 = new ASN1EncodableVector();
      paramArrayOfInt1 = new ASN1EncodableVector();
      if (paramArrayOfGMSSRootCalc[i].getRetain() != null)
      {
        j = 0;
        while (j < paramArrayOfGMSSRootCalc[i].getRetain().length)
        {
          k = 0;
          while (k < paramArrayOfGMSSRootCalc[i].getRetain()[j].size())
          {
            paramArrayOfInt1.add(new DEROctetString((byte[])paramArrayOfGMSSRootCalc[i].getRetain()[j].elementAt(k)));
            k += 1;
          }
          paramArrayOfTreehash1.add(new DERSequence(paramArrayOfInt1));
          paramArrayOfInt1 = new ASN1EncodableVector();
          j += 1;
        }
      }
      paramArrayOfTreehash2.add(new DERSequence(paramArrayOfTreehash1));
      paramArrayOfTreehash1 = new ASN1EncodableVector();
      paramArrayOfGMSSLeaf1.add(new DERSequence(paramArrayOfTreehash2));
      paramArrayOfTreehash2 = new ASN1EncodableVector();
      i += 1;
      paramArrayOfByte1 = paramArrayOfByte3;
      paramArrayOfInt1 = paramArrayOfByte2;
      paramArrayOfByte2 = paramArrayOfByte4;
    }
    paramArrayOfInt1.add(new DERSequence(paramArrayOfGMSSLeaf1));
    paramArrayOfByte1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfByte7.length)
    {
      paramArrayOfByte1.add(new DEROctetString(paramArrayOfByte7[i]));
      i += 1;
    }
    paramArrayOfInt1.add(new DERSequence(paramArrayOfByte1));
    paramArrayOfByte4 = new ASN1EncodableVector();
    paramArrayOfByte2 = new ASN1EncodableVector();
    new ASN1EncodableVector();
    paramArrayOfByte3 = new ASN1EncodableVector();
    paramArrayOfByte1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfGMSSRootSig.length)
    {
      paramArrayOfByte2.add(new DERSequence(paramArrayOfAlgorithmIdentifier[0]));
      new ASN1EncodableVector();
      paramArrayOfByte3.add(new DEROctetString(paramArrayOfGMSSRootSig[i].getStatByte()[0]));
      paramArrayOfByte3.add(new DEROctetString(paramArrayOfGMSSRootSig[i].getStatByte()[1]));
      paramArrayOfByte3.add(new DEROctetString(paramArrayOfGMSSRootSig[i].getStatByte()[2]));
      paramArrayOfByte3.add(new DEROctetString(paramArrayOfGMSSRootSig[i].getStatByte()[3]));
      paramArrayOfByte3.add(new DEROctetString(paramArrayOfGMSSRootSig[i].getStatByte()[4]));
      paramArrayOfByte2.add(new DERSequence(paramArrayOfByte3));
      paramArrayOfByte3 = new ASN1EncodableVector();
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootSig[i].getStatInt()[0]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootSig[i].getStatInt()[1]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootSig[i].getStatInt()[2]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootSig[i].getStatInt()[3]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootSig[i].getStatInt()[4]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootSig[i].getStatInt()[5]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootSig[i].getStatInt()[6]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootSig[i].getStatInt()[7]));
      paramArrayOfByte1.add(new ASN1Integer(paramArrayOfGMSSRootSig[i].getStatInt()[8]));
      paramArrayOfByte2.add(new DERSequence(paramArrayOfByte1));
      paramArrayOfByte1 = new ASN1EncodableVector();
      paramArrayOfByte4.add(new DERSequence(paramArrayOfByte2));
      paramArrayOfByte2 = new ASN1EncodableVector();
      i += 1;
    }
    paramArrayOfInt1.add(new DERSequence(paramArrayOfByte4));
    paramArrayOfByte1 = new ASN1EncodableVector();
    paramArrayOfByte2 = new ASN1EncodableVector();
    paramArrayOfByte3 = new ASN1EncodableVector();
    paramArrayOfByte4 = new ASN1EncodableVector();
    i = 0;
    while (i < paramGMSSParameters.getHeightOfTrees().length)
    {
      paramArrayOfByte2.add(new ASN1Integer(paramGMSSParameters.getHeightOfTrees()[i]));
      paramArrayOfByte3.add(new ASN1Integer(paramGMSSParameters.getWinternitzParameter()[i]));
      paramArrayOfByte4.add(new ASN1Integer(paramGMSSParameters.getK()[i]));
      i += 1;
    }
    paramArrayOfByte1.add(new ASN1Integer(paramGMSSParameters.getNumOfLayers()));
    paramArrayOfByte1.add(new DERSequence(paramArrayOfByte2));
    paramArrayOfByte1.add(new DERSequence(paramArrayOfByte3));
    paramArrayOfByte1.add(new DERSequence(paramArrayOfByte4));
    paramArrayOfInt1.add(new DERSequence(paramArrayOfByte1));
    paramArrayOfByte1 = new ASN1EncodableVector();
    i = 0;
    while (i < paramArrayOfAlgorithmIdentifier.length)
    {
      paramArrayOfByte1.add(paramArrayOfAlgorithmIdentifier[i]);
      i += 1;
    }
    paramArrayOfInt1.add(new DERSequence(paramArrayOfByte1));
    return new DERSequence(paramArrayOfInt1);
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.primitive;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\asn1\GMSSPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */