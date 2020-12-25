import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hangar<T extends ITransport, K extends IRocketsForm> {
    private final int _maxCount;

    private final Stack<T> _places;

    private final int pictureWidth;

    private final int pictureHeight;

    private final int _placeSizeWidth = 430;

    private final int _placeSizeHeight = 160;


    public Hangar(int picWidth, int picHeight) {
        int width = picWidth / _placeSizeWidth;
        int height = picHeight / _placeSizeHeight;
        _maxCount = width * height;
        _places = new Stack<>();
        pictureWidth = picWidth;
        pictureHeight = picHeight;
    }

    public boolean plus(T plane) {
        if (_places.size() < _maxCount)
        {
            _places.add(plane);
            return true;
        }
        return false;
    }

    public T minus(int index) {
        if (index >= 0 && index < _maxCount && _places.get(index) != null)
        {
            T plane = _places.get(index);
            _places.remove(index);
            return plane;
        }
        return null;
    }

    public boolean bolshe(Hangar hangar1, Hangar hangar2) {
        if (hangar1.pictureWidth > hangar2.pictureWidth) {
            return true;
        }
        return false;
    }

    public boolean menshe (Hangar hangar1, Hangar hangar2) {
        if (hangar1.pictureWidth < hangar2.pictureWidth) {
            return true;
        }
        return false;
    }

    public T getVehicle(int index) {
        if (index >= 0 && index < _places.size()) {
            return _places.get(index);
        }
        return null;
    }

    public void Draw(Graphics g) {
        DrawMarking(g);
        for (int i = 0; i < _places.size(); i++) {
            _places.get(i).SetPosition(10 + _placeSizeWidth * (i / 3), 30 + _placeSizeHeight * (i % 3), pictureWidth, pictureHeight);
            _places.get(i).DrawPlane(g);
        }
    }

    private void DrawMarking(Graphics g) {
        for (int i = 0; i < pictureWidth / _placeSizeWidth; i++)
        {
            for (int j = 0; j < pictureHeight / _placeSizeHeight + 1; ++j)
            {
                g.drawLine(i * _placeSizeWidth, j * _placeSizeHeight, i *
                        _placeSizeWidth + _placeSizeWidth / 2, j * _placeSizeHeight);
            }
            g.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth,
                    (pictureHeight / _placeSizeHeight) * _placeSizeHeight);
        }
    }
}
