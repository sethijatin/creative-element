package com.github.sethijatin.creative.layout;

/**
 * Created by jatsethi on 3/30/2018.
 */
public class Describe {

    private CreativeElement parent;
    private CyclicQuad quad;

    protected Describe(CreativeElement e){
        this.quad = e.getCyclicQuad();
        this.parent = e;
    }

    private String describeNear(CreativeElement e){

        Near near = new Near(this.parent);
        String nearBy = "on";

        if (near.onBottomOf(e)){
            nearBy = nearBy + " bottom";
        }

        if (near.onTopOf(e)) {
            nearBy = nearBy + " top";
        }

        if (near.onLeftOf(e)){
            nearBy = nearBy + " left";
        }

        if (near.onRightOf(e)){
            nearBy = nearBy + " right";
        }

        return nearBy + " of";

    }

    public String describeRelationTo(CreativeElement e){

        String relation = null;

        Inside inside =  new Inside(this.parent);
        Near near = new Near(this.parent);
        On on = new On(this.parent);
        Aligned aligned = new Aligned(this.parent);

        if (inside.isInside(e)){
            relation = "Element is 'inside' the other element to which it is compared to.\n";
            relation = relation + "\nSpace Between Element Edges In Pixels\n" + inside.distanceBetweenEdges(e);
            relation = relation + "\nAlignment Between Elements\n" + aligned.getAlignmentDetails(e);
        }
        else if (near.isNear(e)){
            relation = "Element is 'near' (" + describeNear(e) + ") the other element to which it is compared to.\n";
            relation = relation + "\nSpace Between Element Edges In Pixels\n" + near.distanceBetweenEdges(e);
            relation = relation + "\nAlignment Between Elements\n" + aligned.getAlignmentDetails(e);
        }
        else {
            relation = "Element 'overlaps' the other element to which it is compared to.\n";
            relation = relation + "\nSpace Between Element Edges In Pixels\n" + on.distanceBetweenEdges(e);
            relation = relation + "\nAlignment Between Elements\n" + aligned.getAlignmentDetails(e);
        }

        return relation;
    }
}
