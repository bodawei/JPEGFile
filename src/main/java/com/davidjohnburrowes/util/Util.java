/*
 *  Copyright 2014,2017 柏大衛
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.davidjohnburrowes.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Misc utility routines.
 */
public class Util {

	/**
	 * @param stream an input stream
	 * @return A DataInputStream that wraps the provided stream
	 */
	public static DataInputStream wrapAsDataInput(InputStream stream) {
		if (stream instanceof DataInputStream) {
			return (DataInputStream) stream;
		} else {
			return new DataInputStream(stream);
		}
	}

	/**
	 * @param stream an output stream
	 * @return A DataOutputStream that wraps the provided stream
	 */
	public static DataOutputStream wrapAsDataOutput(OutputStream stream) {
		if (stream instanceof DataOutputStream) {
			return (DataOutputStream) stream;
		} else {
			return new DataOutputStream(stream);
		}
	}
}
