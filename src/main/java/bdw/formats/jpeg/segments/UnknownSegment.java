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

import bdw.formats.jpeg.InvalidJpegFormat;
import bdw.formats.jpeg.ParseMode;
import bdw.formats.jpeg.segments.base.BlobSegmentBase;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * Pseudo-segment that is used to represent data that doesn't match any known jpg
 * segments.
 * "Pseudo-segment" means a segment that isn't part of the Jpeg standard.  This is
 * just a part of this implementation.  This reads in all data until it finds
 * a 0xFF 0xXX pair (where 0xXX where XX is any value other than 00). However,
 * if the initial byte of the data this is reading is 0xFF, this ignores that.
 * The reason is that if this is being asked to consume unknown data, it will be
 * being called after trying to read an 0xFF that failed.
 */
public class UnknownSegment extends BlobSegmentBase {

	/**
	 * Marker for this type.
	 */
	public static int MARKER = 0xFFFF;

	/**
	 * Construct
	 */
	public UnknownSegment() {
		super();
	}

	/**
	 * Construct an instance from a stream, parsing it strictly.
	 *
	 * @param stream The stream to read from
	 * @throws IOException If an error occurs while parsing (most likely EOFException)
	 * @throws InvalidJpegFormat If the data is overtly malformed (at this time, can't happen with a comment)
	 */
    public UnknownSegment(InputStream stream) throws IOException, InvalidJpegFormat {
		this(stream, ParseMode.STRICT);
    }

	/**
	 * Construct an instance from a stream.
	 *
	 * @param stream The stream to read from
	 * @param mode The mode to parse this in. At this time, no distinction is made between modes.
	 * @throws IOException If an error occurs while parsing (most likely EOFException)
	 * @throws InvalidJpegFormat If the data is overtly malformed (at this time, can't happen with a comment)
	 */
	public UnknownSegment(InputStream stream, ParseMode mode) throws IOException, InvalidJpegFormat {
		this();
		super.readFromStream(stream, mode);
    }

	/**
	 * Construct an instance from a stream. Parses it strictly
	 *
	 * @param file The file to read from
	 * @throws IOException If an error occurs while parsing (most likely EOFException)
	 * @throws InvalidJpegFormat If the data is overtly malformed (at this time, can't happen with a comment)
	 */
    public UnknownSegment(RandomAccessFile file) throws IOException, InvalidJpegFormat {
		this(file, ParseMode.STRICT);
    }

	/**
	 * Construct an instance from a stream.
	 *
	 * @param file The file to read from
	 * @param mode The mode to parse this in. At this time, no distinction is made between modes.
	 * @throws IOException If an error occurs while parsing (most likely EOFException)
	 * @throws InvalidJpegFormat If the data is overtly malformed (at this time, can't happen with a comment)
	 */
	public UnknownSegment(RandomAccessFile file, ParseMode mode) throws IOException, InvalidJpegFormat {
		this();
		super.readFromFile(file, mode);
    }

	/**
	 * Checks whether instances of this class should be constructed
	 * with the specified marker.
	 *
	 * @param marker The marker to check.
	 * @return true if this conventionally can be associated with that marker.
	 */
	public static boolean canHandleMarker(int marker) {
		if (marker == UnknownSegment.MARKER) {
			return true;
		}
		return false;
	}

	/**
	 * Contrary to the contract of SegmentBase, the JunkSegment always
	 * has a marker of 0xFFFF.
	 * @return
	 */
	@Override
	public int getMarker() {
		return UnknownSegment.MARKER;
	}
	

	@Override
	public boolean equals(Object other) {
		if ((other == null) || !(other instanceof UnknownSegment)) {
			return false;
		} else {
			UnknownSegment segment = (UnknownSegment) other;
			try {
				if (segment.getDataLength() != getDataLength()) {
					return false;
				}
				for (int index = 0; index < getDataLength(); index++) {
					if (getDataAt(index) != segment.getDataAt(index)) {
						return false;
					}
				}
			} catch (IOException e) {
				return false;
			}
		}
		return true;
	}


}
