package com.github.sethijatin.creative.layout;

public class Aligned {


    private CreativeElement parent;
    private CyclicQuad quad;

    protected Aligned(CreativeElement e){
        this.parent = e;
        this.quad = e.getCyclicQuad();
    }

    public boolean insideVertically(CreativeElement e){
        Inside inside = new Inside(this.parent);
        if (inside.isInside(e)){
            int spaceTopAndBottom = inside.getDistance(e, Direction.TOP) - inside.getDistance(e, Direction.BOTTOM);
            return spaceTopAndBottom == 0;
        }
        else
        {
            return false;
        }
    }

    public boolean insideHorizontally(CreativeElement e){
        Inside inside = new Inside(this.parent);
        if (inside.isInside(e)){
            int spaceLeftAndRight = inside.getDistance(e, Direction.LEFT) - inside.getDistance(e, Direction.RIGHT);
            return spaceLeftAndRight == 0;
        }
        else
        {
            return false;
        }
    }

    public boolean insideCentrally(CreativeElement e){
        return insideVertically(e) && insideHorizontally(e);
    }

    public boolean top (CreativeElement e){
        return this.quad.getPoint_A().getY() == e.getCyclicQuad().getPoint_A().getY();
    }

    public boolean bottom (CreativeElement e){
        return this.quad.getPoint_C().getY() == e.getCyclicQuad().getPoint_C().getY();
    }

    public boolean left (CreativeElement e){
        return this.quad.getPoint_A().getX() == e.getCyclicQuad().getPoint_A().getX();
    }

    public boolean right (CreativeElement e){
        return this.quad.getPoint_C().getX() == e.getCyclicQuad().getPoint_C().getX();
    }

    protected String getAlignmentDetails (CreativeElement e){

        String aligned = "Top Aligned : " + this.top(e) + "\n"
                       + "Bottom Aligned : " + this.bottom(e) + "\n"
                       + "Left Aligned : " + this.left(e) + "\n"
                       + "Right Aligned : " + this.right(e) + "\n"
                       + "Aligned Inside Horizontally : " + this.insideHorizontally(e) + "\n"
                       + "Aligned Inside Vertically : " + this.insideVertically(e) + "\n"
                       + "Aligned Inside Centrally : " + this.insideCentrally(e);

        return aligned;
    }

}
