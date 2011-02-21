/*
 *  Copyright 2011 柏大衛
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

package bdw.formats.jpeg.segments;

/**
 * The Start Of Image segment
 * This segment has no content data.
 */
public class SoiSegment extends SegmentBase {
	/**
	 * The marker code corresponding to this type of segment
	 */
	public static final int MARKER = 0xD8;

	/**
	 * Construct
	 */
    public SoiSegment() {
    }

	/**
	 * @inheritdoc
	 */
	@Override
	public int getMarker() {
		return SoiSegment.MARKER;
	}
}