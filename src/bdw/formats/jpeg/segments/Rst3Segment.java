/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bdw.formats.jpeg.segments;

/**
 * Restart Marker 2
 * @author dburrowes
 */
public class Rst3Segment extends RstSegment {
    // use static initializer to let jpegfile know about this?
    private static final int MARKER = 0xd3;

    public static int getMarkerCode() {
        return MARKER;
    }
	
    public Rst3Segment() {
    }
}