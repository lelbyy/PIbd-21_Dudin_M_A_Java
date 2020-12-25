import java.awt.*;

public class Plane extends Vehicle {

    protected int planeWidth = 200;

    protected int planeHeight = 140;

    public Plane(int maxSpeed, float weight, Color mainColor) {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
    }

    protected Plane(int maxSpeed, float weight, Color mainColor, int planeWidth, int planeHeight) {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        this.planeWidth = planeWidth;
        this.planeHeight = planeHeight;
    }

    @Override
    public void MovePlane(Direction direction) {
        int boarderNumber = 10;
        int boarderUp =20;
        int step = (int) (MaxSpeed * 1000 / Weight);
        switch (direction) {
            case Up:
                if (_startPosY - step > boarderNumber) {
                    _startPosY -= step;
                }
                break;
            case Right:
                if (_startPosX + step < _frameWidth - planeWidth - boarderNumber) {
                    _startPosX += step;
                }
                break;
            case Down:
                if (_startPosY + step < _frameHeight - planeHeight - boarderNumber) {
                    _startPosY += step;
                }
                break;
            case Left:
                if (_startPosX - step > boarderNumber) {
                    _startPosX -= step;
                }
                break;
        }
    }

    @Override
    public void DrawPlane(Graphics g) {
        g.setColor(MainColor);

        //нос самолета
        g.drawLine(_startPosX, _startPosY+50, _startPosX+70, _startPosY+30) ;
        g.drawLine(_startPosX, _startPosY + 50, _startPosX + 70, _startPosY+70);
        g.drawLine(_startPosX+70, _startPosY + 30, _startPosX + 70, _startPosY+70);

        //korpus
        g.drawLine(_startPosX + 70, _startPosY + 30, _startPosX + 210, _startPosY + 30);
        g.drawLine(_startPosX + 70, _startPosY + 70, _startPosX + 210, _startPosY + 70);





        int[] xp = new int[] {_startPosX, _startPosX+30,_startPosX + 120 ,_startPosX + 150,_startPosX + 170,_startPosX + 150,_startPosX+200,_startPosX + 210,_startPosX + 210, _startPosX+200, _startPosX + 120, _startPosX + 150, _startPosX + 170, _startPosX + 150,   _startPosX+30, _startPosX };
        int[] yp = new int[] { _startPosY + 50, _startPosY + 30, _startPosY + 30,_startPosY - 20,_startPosY - 20,_startPosY + 30,_startPosY + 30,_startPosY + 5,_startPosY + 95, _startPosY + 70, _startPosY + 70 ,_startPosY + 120, _startPosY + 120, _startPosY + 70,   _startPosY + 70, _startPosY + 50 };
        g.fillPolygon(xp, yp, 16);

    }
}
