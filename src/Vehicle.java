import java.awt.*;

public abstract class Vehicle implements ITransport {

    protected int _startPosX;

    protected int _startPosY;

    protected int _frameWidth;

    protected int _frameHeight;

    public int MaxSpeed;

    protected void setMaxSpeed(int MaxSpeed) {
        this.MaxSpeed = MaxSpeed;
    }

    public int getMaxSpeed() {
        return MaxSpeed;
    }

    public float Weight;

    protected void setWeight(float Weight) {
        this.Weight = Weight;
    }

    public float getWeight() {
        return Weight;
    }

    public Color MainColor;

    protected void setMainColor(Color MainColor) {
        this.MainColor = MainColor;
    }

    public Color getMainColor() {
        return MainColor;
    }

    public void setPosition(int x, int y, int width, int height) {
        _startPosX = x;
        _startPosY = y;
        _frameWidth = width;
        _frameHeight = height;
    }

    public abstract void DrawPlane(Graphics g);

    public abstract void MovePlane(Direction direction);
}
