/*
 *  Copyright 2013 柏大衛
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
package bdw.format.jpeg.segment;

import bdw.format.jpeg.data.Segment;
import bdw.format.jpeg.support.Marker;

/**
 * The End Of Image segment
 * This contains no content
 */
@Marker(EoiSegment.MARKER)
public class EoiSegment extends Segment {
	/**
	 * The end of image marker
	 */
	public static final int MARKER = 0xD9;

	/**
	 * @inheritdoc
	 */
	@Override
	public int getMarker() {
		return MARKER;
	}

	/**
	 * All EoiSegments are equal.
	 * @param other The other object to test
	 * @return If other and this are equal
	 */
	@Override
	public boolean equals(Object other) {
		return ((other == null) || !(other instanceof EoiSegment)) ? false : true;
	}

	/**
	 * @inheritdoc
	 */
	@Override
	public int hashCode() {
		int hash = 3;
		return hash;
	}
}
