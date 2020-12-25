import java.awt.*;

public class LittleRockets implements IRocketsForm {

    private EnumerationOfRockets rockets;
    private Color dopColor;
    public LittleRockets(int number, Color dopColor) {
        setDigit(number);
        this.dopColor = dopColor;
    }

    public void setDigit(int number) {
        this.rockets = EnumerationOfRockets.getChosenNumber(number);
    }

    public void draw(Graphics g, int _startPosX, int _startPosY) {
        g.setColor(dopColor);


        g.drawLine(_startPosX + 112, _startPosY + 15, _startPosX + 130, _startPosY + 15);
        g.drawLine(_startPosX + 112, _startPosY + 85, _startPosX + 130, _startPosY + 85);

        if(rockets == EnumerationOfRockets.Four || rockets == EnumerationOfRockets.Six){
            g.drawLine(_startPosX + 105, _startPosY + 20, _startPosX + 125, _startPosY + 20);
            g.drawLine(_startPosX + 105, _startPosY + 80, _startPosX + 125, _startPosY + 80);

            if(rockets == EnumerationOfRockets.Six){
                g.drawLine(_startPosX + 119, _startPosY + 10, _startPosX + 138, _startPosY + 10);
                g.drawLine(_startPosX + 119, _startPosY + 90, _startPosX + 138, _startPosY + 90);
            }
        }
    }
}
