package seminar8;

public interface HasHealthPoint {
    
    int getCurrentHealthPoint();
    
}

class HealthPointViewer {

    public int viewHealthPoint(HasHealthPoint hasHealthPoint) {
        return hasHealthPoint.getCurrentHealthPoint();
    }

}
