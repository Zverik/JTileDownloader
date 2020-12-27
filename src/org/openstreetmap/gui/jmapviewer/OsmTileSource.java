package org.openstreetmap.gui.jmapviewer;

import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;

public class OsmTileSource {

    public static final String MAP_MAPNIK = "https://tile.openstreetmap.org";

    protected static abstract class AbstractOsmTileSource implements TileSource {

        public int getMaxZoom() {
            return 18;
        }

        public int getMinZoom() {
            return 0;
        }

        public String getTileUrl(int zoom, int tilex, int tiley) {
            return "/" + zoom + "/" + tilex + "/" + tiley + ".png";
        }

        @Override
        public String toString() {
            return getName();
        }

        public String getTileType() {
            return "png";
        }

    }

    public static class Mapnik extends AbstractOsmTileSource {

        public static String NAME = "Mapnik";

        public String getName() {
            return NAME;
        }

        @Override
        public String getTileUrl(int zoom, int tilex, int tiley) {
            return MAP_MAPNIK + super.getTileUrl(zoom, tilex, tiley);
        }

        public TileUpdate getTileUpdate() {
            return TileUpdate.IfNoneMatch;
        }

    }
}
