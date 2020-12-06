import java.awt.*;

public class Fighter {

    private int _startPosX;
    private int _startPosY;

    private int _frameWidth=900;
    private int _frameHeight=500;

    private final int planeWidth = 180;
    private final int planeHeight = 80;

    private int MaxSpeed;
    private float Weight;
    private Color MainColor;
    private Color DopColor;
    private boolean guns;
    private boolean nose;
    private PlaneRockets bombs;
    public Fighter(int maxSpeed, float weight, Color mainColor, Color dopColor,
                   boolean guns, boolean nose,int digit) {
        this.MaxSpeed = 100;
        this.Weight = 1500;
        this.MainColor = mainColor;
        this.DopColor = dopColor;
        this.guns = guns;
        this.nose = nose;
        this.bombs = new PlaneRockets(digit);
    }

    public int getMaxSpeed() {
        return MaxSpeed;
    }

    private void MaxSpeed(int maxSpeed) {
        this.MaxSpeed = maxSpeed;
    }

    public float getWeight() {
        return Weight;
    }

    private void setWeight(float weight) {
        this.Weight = weight;
    }

    public Color getMainColor() {
        return MainColor;
    }

    private void setMainColor(Color mainColor) {
        this.MainColor = mainColor;
    }

    public Color getDopColor() {
        return DopColor;
    }

    private void setDopColor(Color dopColor) {
        this.DopColor = dopColor;
    }


    public boolean isGuns() {
        return guns;
    }

    private void setGuns(boolean guns) {
        this.guns = guns;
    }

    public boolean isNose() {
        return nose;
    }

    private void setNose(boolean nose) {
        this.nose = nose;
    }

    public void setPosition(int posX, int posY, int frameWidth, int frameHeight) {
        this._frameHeight = frameHeight;
        this._frameWidth = frameWidth;
        if (posX >= 0 && posX + planeWidth < frameWidth &&
                posY >= 0 && posY + planeHeight < frameHeight) {
            this._startPosX = posX;
            this._startPosY = posY;
        }
    }

    public void movePlane(Direction direction) {
        int boarderNumber = 10;
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

    public void draw(Graphics g) {
        if (nose)
        {
            g.setColor(DopColor);
            g.drawLine(_startPosX, _startPosY + 50, _startPosX -30, _startPosY + 50);
        }

        if (guns)
        {
            bombs.draw(g, DopColor, _startPosX, _startPosY);
        }

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
