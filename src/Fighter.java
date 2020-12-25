import java.awt.*;

public class Fighter extends Plane{

    private IRocketsForm rocketsForm;
    private Color dopColor;
    private boolean planeRockets;
    private boolean nose;
    public Fighter(int maxSpeed, float weight, Color mainColor, Color dopColor,
                   boolean planeRockets, boolean nose,int rockets, String rocketsForm) {
        super(maxSpeed, weight, mainColor, 200, 140);
        this.dopColor = dopColor;
        this.planeRockets = planeRockets;
        this.nose = nose;
        switch (rocketsForm) {
            case "Большие":
                this.rocketsForm = new BigRockets(rockets, dopColor);
                break;
            case "Маленькие":
                this.rocketsForm = new LittleRockets(rockets, dopColor);
                break;
            case "Длинные":
                this.rocketsForm = new LongRockets(rockets, dopColor);
                break;
        }
    }


    public Color getDopColor() {
        return dopColor;
    }

    private void setDopColor(Color dopColor) {
        this.dopColor = dopColor;
    }

    public boolean isPlaneRockets() {
        return planeRockets;
    }

    private void setPlaneRockets(boolean planeRockets) {
        this.planeRockets = planeRockets;
    }

    public boolean isNose() {
        return nose;
    }

    private void setNose(boolean nose) {
        this.nose = nose;
    }



    @Override
    public void DrawPlane(Graphics g) {

        if (planeRockets)
        {
            rocketsForm.draw(g, _startPosX, _startPosY);
        }

        if (nose)
        {
            g.setColor(dopColor);
            g.drawLine(_startPosX, _startPosY + 50, _startPosX -10, _startPosY + 50);
        }

        super.DrawPlane(g);
    }

}
