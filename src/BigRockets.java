import javax.management.relation.InvalidRoleInfoException;
import java.awt.*;

public class BigRockets implements IRocketsForm {


    private EnumerationOfRockets rockets;
    private Color dopColor;

    public BigRockets(int number, Color dopColor) {
        setDigit(number);
        this.dopColor = dopColor;
    }

    public void setDigit(int number) {
        this.rockets = EnumerationOfRockets.getChosenNumber(number);
    }

    public void draw(Graphics g, int _startPosX, int _startPosY) {
        g.setColor(dopColor);

        g.fillRect(_startPosX + 112, _startPosY + 10, 30, 5);
        g.fillRect(_startPosX + 112, _startPosY + 90, 30, 5);


        if(rockets == EnumerationOfRockets.Four || rockets == EnumerationOfRockets.Six){
            g.fillRect(_startPosX + 105, _startPosY + 20, 30, 5);
            g.fillRect(_startPosX + 105, _startPosY + 80, 30, 5);

            if(rockets == EnumerationOfRockets.Six){
                g.fillRect(_startPosX + 119, _startPosY , 30, 5);
                g.fillRect(_startPosX + 119, _startPosY + 100, 30, 5);
            }
        }
    }
}
