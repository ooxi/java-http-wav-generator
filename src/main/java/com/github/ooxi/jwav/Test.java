/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ooxi.jwav;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 *
 * @author ooxi
 */
public class Test {
	
	public static void main(String[] args) {
		DataOutputStream outFile  = new DataOutputStream(new FileOutputStream(myPath));

		// write the wav file per the wav file format
		outFile.writeBytes("RIFF");					// 00 - RIFF
		outFile.write(intToByteArray((int)myChunkSize), 0, 4);		// 04 - how big is the rest of this file?
		outFile.writeBytes("WAVE");					// 08 - WAVE
		outFile.writeBytes("fmt ");					// 12 - fmt 
		outFile.write(intToByteArray((int)mySubChunk1Size), 0, 4);	// 16 - size of this chunk
		outFile.write(shortToByteArray((short)myFormat), 0, 2);		// 20 - what is the audio format? 1 for PCM = Pulse Code Modulation
		outFile.write(shortToByteArray((short)myChannels), 0, 2);	// 22 - mono or stereo? 1 or 2?  (or 5 or ???)
		outFile.write(intToByteArray((int)mySampleRate), 0, 4);		// 24 - samples per second (numbers per second)
		outFile.write(intToByteArray((int)myByteRate), 0, 4);		// 28 - bytes per second
		outFile.write(shortToByteArray((short)myBlockAlign), 0, 2);	// 32 - # of bytes in one sample, for all channels
		outFile.write(shortToByteArray((short)myBitsPerSample), 0, 2);	// 34 - how many bits in a sample(number)?  usually 16 or 24
		outFile.writeBytes("data");					// 36 - data
		outFile.write(intToByteArray((int)myDataSize), 0, 4);		// 40 - how big is this data chunk
		outFile.write(myData);						// 44 - the actual data itself - just a long string of numbers
	}
	
	
		// returns a byte array of length 4
	private static byte[] intToByteArray(int i)
	{
		byte[] b = new byte[4];
		b[0] = (byte) (i & 0x00FF);
		b[1] = (byte) ((i >> 8) & 0x000000FF);
		b[2] = (byte) ((i >> 16) & 0x000000FF);
		b[3] = (byte) ((i >> 24) & 0x000000FF);
		return b;
	}

	// convert a short to a byte array
	public static byte[] shortToByteArray(short data)
	{
		return new byte[]{(byte)(data & 0xff),(byte)((data >>> 8) & 0xff)};
	}
			
}
