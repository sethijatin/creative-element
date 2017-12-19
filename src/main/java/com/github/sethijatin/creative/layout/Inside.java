package com.github.sethijatin.creative.layout;

public class Inside {

    private CyclicQuad quad;

    protected Inside(CreativeElement e){
        this.quad = e.getCyclicQuad();
    }

    private int distanceBetweenTopEdges(CreativeElement e){
        int topEdgeFirstElement = this.quad.getPoint_A().getY();
        int topEdgeSecondElement = e.getCyclicQuad().getPoint_A().getY();
        return topEdgeFirstElement - topEdgeSecondElement;
    }

    private int distanceBetweenBottomEdges(CreativeElement e){
        int bottomEdgeFirstElement = this.quad.getPoint_C().getY();
        int bottomEdgeSecondElement = e.getCyclicQuad().getPoint_C().getY();
        //return bottomEdgeFirstElement - bottomEdgeSecondElement;
        return bottomEdgeSecondElement - bottomEdgeFirstElement;
    }

    private int distanceBetweenLeftEdges(CreativeElement e){
        int leftEdgeFirstElement = this.quad.getPoint_A().getX();
        int leftEdgeSecondElement = e.getCyclicQuad().getPoint_A().getX();
        return leftEdgeFirstElement - leftEdgeSecondElement;
    }

    private int distanceBetweenRightEdges(CreativeElement e){
        int rightEdgeFirstElement = this.quad.getPoint_C().getX();
        int rightEdgeSecondElement = e.getCyclicQuad().getPoint_C().getX();
        //return rightEdgeFirstElement - rightEdgeSecondElement;
        return rightEdgeSecondElement - rightEdgeFirstElement;
    }

    public boolean isInside(CreativeElement e){
        return e.getCyclicQuad().getRectangle().contains(quad.getRectangle());
    }

    public boolean isInside(CreativeElement e, Direction direction, int expectedDistance) {
        return isInside(e) && getDistance(e,direction) == expectedDistance;
    }

    public boolean isInside(CreativeElement e, Direction direction, int minDistanceInPixels, int maxDistanceInPixels) {
        int distance = getDistance(e,direction);
        return isInside(e) && distance >= minDistanceInPixels && distance <= maxDistanceInPixels;
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
                return -32000;
        }
    }
}
