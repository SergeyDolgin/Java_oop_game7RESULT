package units;

public class Point2D {
    protected int posX;
    protected int posY;

    public Point2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }


// *нахождение расстояния между персонажами */
    protected double getDistance(Point2D opponent){
        return Math.sqrt(Math.pow(posX - opponent.posX,2) + Math.pow(posY - opponent.posY,2));
    }

// *поиск пути до ближайшего */
    protected Point2D chooseWay(Point2D opponent) {

        return new Point2D(posX - opponent.posX, posY - opponent.posY);
    }
  

}
