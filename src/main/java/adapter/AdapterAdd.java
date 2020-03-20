package adapter;

public class AdapterAdd {
    public static void main(String[] args) {
        VectorGraphicInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();
        VectorGraphicInterface g2 = new VectorAdapterFromRaster2(new RasterGraphic());
        g2.drawLine();
        g2.drawSquare();
    }
}
interface VectorGraphicInterface{
    void drawLine();
    void drawSquare();
}
class RasterGraphic{
    void drawRasterLine(){
        System.out.println("drawing line");
    }
    void drawRasterSquare(){
        System.out.println("drawing square");
    }
}
class VectorAdapterFromRaster extends RasterGraphic implements VectorGraphicInterface{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}
class VectorAdapterFromRaster2 implements VectorGraphicInterface{
   // RasterGraphic graphic = new RasterGraphic();
    RasterGraphic graphic;

    public VectorAdapterFromRaster2(RasterGraphic graphic) {
        this.graphic = graphic;
    }

    @Override
    public void drawLine() {
        graphic.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        graphic.drawRasterSquare();
    }
}