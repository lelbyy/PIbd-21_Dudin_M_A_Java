import java.awt.*;

public interface ITransport {
    void setPosition(int x, int y, int width, int height);

    void MovePlane(Direction direction);

    void DrawPlane(Graphics g);
}
