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
package com.davidjohnburrowes.formats.jpeg.mocks;

import com.davidjohnburrowes.format.jpeg.data.Marker;
import com.davidjohnburrowes.format.jpeg.support.MarkerId;
import com.davidjohnburrowes.util.Util;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;

@MarkerId(0xB1)
public class GoodB1 extends Marker {
	public int value;

	public GoodB1() {
		super(0xB1);
	}

	@Override
	public void read(InputStream stream) throws IOException {
		DataInput input = Util.wrapAsDataInput(stream);
		int contentLength = input.readUnsignedShort();
		value = input.readByte();
	}
}