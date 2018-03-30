package com.github.sethijatin.creative.layout;

public class Near {

    private CyclicQuad quad;
    private CreativeElement parent;

    protected Near(CreativeElement e){
        this.parent = e;
        this.quad = e.getCyclicQuad();
    }

    private int distanceBetweenMyBottomAndOtherTop(CreativeElement e){
       int bottomEdgeFirstElement = this.quad.getPoint_C().getY();
       int topEdgeSecondElement = e.getCyclicQuad().getPoint_A().getY();
       return (topEdgeSecondElement - bottomEdgeFirstElement);
    }

    private int distanceBetweenMyTopAndOtherBottom(CreativeElement e){
        int topEdgeFirstElement = this.quad.getPoint_A().getY();
        int bottomEdgeSecondElement = e.getCyclicQuad().getPoint_C().getY();
        return (topEdgeFirstElement - bottomEdgeSecondElement);
    }

    private int distanceBetweenMyRightAndOtherLeft(CreativeElement e){
      int rightEdgeFirstElement = this.quad.getPoint_C().getX();
      int leftEdgeSecondElement = e.getCyclicQuad().getPoint_A().getX();
      return (leftEdgeSecondElement - rightEdgeFirstElement);
    }

    private int distanceBetweenMyLeftAndOtherRight(CreativeElement e){
        int lefttEdgeFirstElement = this.quad.getPoint_A().getX();
        int rightEdgeSecondElement = e.getCyclicQuad().getPoint_C().getX();
        return (lefttEdgeFirstElement - rightEdgeSecondElement);
    }

    public boolean isNear(CreativeElement e){
        On on = new On(parent);
        Inside inside = new Inside(parent);
        return !inside.isInside(e) && !on.overlaps(e);
    }

    public boolean onTopOf(CreativeElement e){
        return isNear(e) && distanceBetweenMyBottomAndOtherTop(e) > 0;
    }

    public boolean onTopOf(CreativeElement e, int expectedDistance) {
        return isNear(e) && expectedDistance == distanceBetweenMyBottomAndOtherTop(e);
    }

    public boolean onTopOf(CreativeElement e, int pxMin, int pxMax) {
        return isNear(e) && pxMin <= distanceBetweenMyBottomAndOtherTop(e) && distanceBetweenMyBottomAndOtherTop(e) <= pxMax;
    }

    public boolean onBottomOf(CreativeElement e){
        return isNear(e) && distanceBetweenMyTopAndOtherBottom(e) > 0;
    }

    public boolean onBottomOf(CreativeElement e, int expectedDistance) {
        return isNear(e) && expectedDistance == distanceBetweenMyTopAndOtherBottom(e);
    }

    public boolean onBottomOf(CreativeElement e, int pxMin, int pxMax) {
        return isNear(e) && pxMin <= distanceBetweenMyTopAndOtherBottom(e) && distanceBetweenMyTopAndOtherBottom(e) <= pxMax;
    }

    public boolean onLeftOf(CreativeElement e){
        return isNear(e) && distanceBetweenMyRightAndOtherLeft(e) > 0;
    }

    public boolean onLeftOf(CreativeElement e, int expectedDistance) {
        return isNear(e) && expectedDistance == distanceBetweenMyRightAndOtherLeft(e);
    }

    public boolean onLeftOf(CreativeElement e, int pxMin, int pxMax) {
        return isNear(e) && pxMin <= distanceBetweenMyRightAndOtherLeft(e) && distanceBetweenMyRightAndOtherLeft(e) <= pxMax;
    }

    public boolean onRightOf(CreativeElement e){
        return isNear(e) && distanceBetweenMyLeftAndOtherRight(e) > 0;
    }

    public boolean onRightOf(CreativeElement e, int expectedDistance) {
        return isNear(e) && expectedDistance == distanceBetweenMyLeftAndOtherRight(e);
    }

    public boolean onRightOf(CreativeElement e, int pxMin, int pxMax) {
        return isNear(e) && pxMin <= distanceBetweenMyLeftAndOtherRight(e) && distanceBetweenMyLeftAndOtherRight(e) <= pxMax;
    }

    protected String distanceBetweenEdges(CreativeElement e){

        String distance = "My Top & Other's Bottom : " + Math.abs(distanceBetweenMyTopAndOtherBottom(e)) + "\n"
                        + "My Bottom & Other's Top : " + Math.abs(distanceBetweenMyBottomAndOtherTop(e)) + "\n"
                        + "My Left & Other's Right : " + Math.abs(distanceBetweenMyLeftAndOtherRight(e)) + "\n"
                        + "My Right & Other's Left : " + Math.abs(distanceBetweenMyRightAndOtherLeft(e)) + "\n";
        return distance;
    }

}
