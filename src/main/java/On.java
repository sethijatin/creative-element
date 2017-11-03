public class On {

    private CyclicQuad quad;

    protected On(CreativeElement e){
        this.quad = e.getCyclicQuad();
    }

    public boolean overlaps(CreativeElement e){
        return quad.getRectangle().intersects(e.getCyclicQuad().getRectangle());
    }

    private int distanceBetweenTopEdges(CreativeElement e){
        int topEdgeFirstElement = this.quad.getPoint_A().getY();
        int topEdgeSecondElement = e.getCyclicQuad().getPoint_A().getY();
        return topEdgeFirstElement - topEdgeSecondElement;
    }

    private int distanceBetweenBottomEdges(CreativeElement e){
        int bottomEdgeFirstElement = this.quad.getPoint_C().getY();
        int bottomEdgeSecondElement = e.getCyclicQuad().getPoint_C().getY();
        return bottomEdgeFirstElement - bottomEdgeSecondElement;
    }

    private int distanceBetweenLeftEdges(CreativeElement e){
        int leftEdgeFirstElement = this.quad.getPoint_A().getX();
        int leftEdgeSecondElement = e.getCyclicQuad().getPoint_A().getX();
        return leftEdgeFirstElement - leftEdgeSecondElement;
    }

    private int distanceBetweenRightEdges(CreativeElement e){
        int rightEdgeFirstElement = this.quad.getPoint_C().getX();
        int rightEdgeSecondElement = e.getCyclicQuad().getPoint_C().getX();
        return rightEdgeFirstElement - rightEdgeSecondElement;
    }

    public int getDistance(CreativeElement e, Direction direction){

        switch (direction) {
            case TOP:
                int spaceTop = distanceBetweenTopEdges(e);
                return spaceTop < 0 ? spaceTop * -1 : spaceTop;
            case BOTTOM:
                int spaceBottom = distanceBetweenBottomEdges(e);
                return spaceBottom < 0 ? spaceBottom * -1 : spaceBottom;
            case LEFT:
                int spaceLeft = distanceBetweenLeftEdges(e);
                return spaceLeft < 0 ? spaceLeft * -1 : spaceLeft;
            case RIGHT:
                int spaceRight = distanceBetweenRightEdges(e);
                return spaceRight < 0 ? spaceRight * -1 : spaceRight;
            default:
                return -1;
        }
    }

}
