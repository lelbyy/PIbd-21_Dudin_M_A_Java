import java.awt.*;

public class Hangar<T extends ITransport, K extends IRocketsForm> {
    private final Object[] _places;

    private final int pictureWidth;

    private final int pictureHeight;

    private final int _placeSizeWidth = 430;

    private final int _placeSizeHeight = 160;


    public Hangar(int picWidth, int picHeight) {
        int width = picWidth / _placeSizeWidth;
        int height = picHeight / _placeSizeHeight;
        _places = new Object[width * height];
        pictureWidth = picWidth;
        pictureHeight = picHeight;
    }

    public boolean plus(T plane) {
        for (int i = 0; i < _places.length; i++) {
            if (_places[i] == null) {
                plane.SetPosition(10 + i / 3 * _placeSizeWidth, 20 + i % 3 * _placeSizeHeight + 4, pictureWidth, pictureHeight);
                _places[i] = plane;
                return true;
            }
        }
        return false;
    }

    public boolean bolshe(Hangar hangar1, Hangar hangar2) {
        if (hangar1.pictureWidth*hangar1.pictureHeight > hangar2.pictureWidth*hangar2.pictureHeight) {
            return true;
        }
        return false;
    }

    public boolean menshe (Hangar hangar1, Hangar hangar2) {
        if (hangar1.pictureWidth*hangar1.pictureHeight < hangar2.pictureWidth*hangar2.pictureHeight) {
            return true;
        }
        return false;
    }

    public T minus(int index) {
        if (_places[index] != null && index >= 0 && index < _places.length) {
            Object temp = _places[index];
            _places[index] = null;
            return (T) (temp);
        } else {
            return null;
        }
    }

    public void Draw(Graphics g) {
        DrawMarking(g);
        for (int i = 0; i < _places.length; i++) {
            while (_places[i] == null) {
                i++;
                if (i == _places.length) {
                    return;
                }
            }
            ((T) _places[i]).DrawPlane(g);
        }
    }

    private void DrawMarking(Graphics g) {
        for (int i = 0; i < pictureWidth / _placeSizeWidth; i++)
        {
            for (int j = 0; j < pictureHeight / _placeSizeHeight + 1; ++j)
            {//линия рамзетки места
                g.drawLine(i * _placeSizeWidth, j * _placeSizeHeight, i *
                        _placeSizeWidth + _placeSizeWidth / 2, j * _placeSizeHeight);
            }
            g.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth,
                    (pictureHeight / _placeSizeHeight) * _placeSizeHeight);
        }
    }
}
