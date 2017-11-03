import org.openqa.selenium.WebElement;

public class CreativeElement {

    private CyclicQuad quad;
    private WebElement element;

    public CreativeElement(WebElement e){
        this.element = e;
        this.quad = new CyclicQuad(e.getLocation(), e.getSize().getHeight(), e.getSize().getWidth());
    }

    public CyclicQuad getCyclicQuad(){
        return this.quad;
    }

    public WebElement getElement(){
        return this.element;
    }

    public int getHeight(){
        return this.element.getSize().getHeight();
    }

    public int getWidth(){
        return this.element.getSize().getWidth();
    }

    public boolean isVisible(){
        return this.element.isDisplayed();
    }
        
    public Near isNear(){

        return new Near(this);
    }

    public Aligned isAlgined(){
        return new Aligned(this);
    }

    public On on(){
        return new On(this);
    }

    public Inside isInside(){
        return new Inside(this);
    }
}