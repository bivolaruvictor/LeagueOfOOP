package terrain;

abstract class Terrain {
    private TerrainType terrainType;

    public void setTerrainType(TerrainType terrainType) {
        this.terrainType = terrainType;
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }
}
