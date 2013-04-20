/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ooxi.jwav;

import java.io.File;
import java.io.IOException;
import uk.co.labbookpages.audio.wavfile.WavFile;
import uk.co.labbookpages.audio.wavfile.WavFileException;

/**
 *
 * @author ooxi
 */
public class Test {
	
	public static void main(String[] args) throws IOException, WavFileException {
		int sampleRate = 44100;    // Samples per second
		double duration = 5.0;     // Seconds

		// Calculate the number of frames required for specified duration
		long numFrames = (long) (duration * sampleRate);

		// Create a wav file with the name specified as the first argument
		WavFile wavFile = WavFile.newWavFile(new File("test.wav"), 2, numFrames, 16, sampleRate);

		// Create a buffer of 100 frames
		double[][] buffer = new double[2][100];

		// Initialise a local frame counter
		long frameCounter = 0;
		
		// Frequency
		int frequency = 440;

		// Loop until all frames written
		while (frameCounter < numFrames) {
			// Determine how many frames to write, up to a maximum of the buffer size
			long remaining = wavFile.getFramesRemaining();
			int toWrite = (remaining > 100) ? 100 : (int) remaining;

			// Fill the buffer, one tone per channel
			for (int s = 0; s < toWrite; s++, frameCounter++) {
				buffer[0][s] = Math.sin(2.0 * Math.PI * frequency * frameCounter / sampleRate);
				buffer[1][s] = Math.sin(2.0 * Math.PI * frequency * frameCounter / sampleRate);
			}

			// Write the buffer
			wavFile.writeFrames(buffer, toWrite);
		}
	}

}
