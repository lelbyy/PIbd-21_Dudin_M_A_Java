import java.awt.*;

public class PlaneRockets {

    private EnumerationOfRockets guns;

    public PlaneRockets(int number) {
        setDigit(number);
    }

    public void setDigit(int number) {
        this.guns = EnumerationOfRockets.getChosenNumber(number);
    }

    public void draw(Graphics g, Color DopColor, int _startPosX, int _startPosY) {
        g.setColor(DopColor);


        g.drawLine(_startPosX + 112, _startPosY + 15, _startPosX + 130, _startPosY + 15);
        g.drawLine(_startPosX + 112, _startPosY + 85, _startPosX + 130, _startPosY + 85);

        if(guns == EnumerationOfRockets.Four || guns == EnumerationOfRockets.Six){
            g.drawLine(_startPosX + 105, _startPosY + 20, _startPosX + 125, _startPosY + 20);
            g.drawLine(_startPosX + 105, _startPosY + 80, _startPosX + 125, _startPosY + 80);

            if(guns == EnumerationOfRockets.Six){
                g.drawLine(_startPosX + 119, _startPosY + 10, _startPosX + 138, _startPosY + 10);
                g.drawLine(_startPosX + 119, _startPosY + 90, _startPosX + 138, _startPosY + 90);
            }
        }
    }
}
