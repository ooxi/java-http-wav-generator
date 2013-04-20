/**
 * Copyright (c) 2012 ooxi/ java-http-wav-generator
 *     https://github.com/ooxi/ java-http-wav-generator
 *
 * This software is provided 'as-is', without any express or implied warranty.
 * In no event will the authors be held liable for any damages arising from the
 * use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 *
 *  1. The origin of this software must not be misrepresented; you must not
 *     claim that you wrote the original software. If you use this software in a
 *     product, an acknowledgment in the product documentation would be
 *     appreciated but is not required.
 *
 *  2. Altered source versions must be plainly marked as such, and must not be
 *     misrepresented as being the original software.
 *
 *  3. This notice may not be removed or altered from any source distribution.
 */
package com.github.ooxi.jwav;

import java.util.EnumMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Main application generating a wave file on the fly
 * 
 * @author ooxi
 */
public class JWave {
	
	private final EnumMap<Channel, AtomicInteger> channels = new EnumMap<Channel, AtomicInteger>(Channel.class) {{
		for (Channel channel : Channel.values()) {
			put(channel, new AtomicInteger(440));
		}
	}};
	
//	public void setFrequency
	
}
