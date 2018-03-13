package com.github.sethijatin.creative.layout;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

public class CreativeElement {

    private CyclicQuad quad;
    private WebElement webElement;
    private MobileElement mobileElement;

    public CreativeElement(WebElement e){
        this.webElement = e;
        this.quad = new CyclicQuad(e.getLocation(), e.getSize().getHeight(), e.getSize().getWidth());
    }

    public CreativeElement(MobileElement m){
        this.mobileElement = m;
        this.quad = new CyclicQuad(m.getLocation(), m.getSize().getHeight(), m.getSize().getWidth());
    }

    public CyclicQuad getCyclicQuad(){
        return this.quad;
    }

    public WebElement getElement(){
        return this.webElement;
    }

    public MobileElement getMobileElement(){
        return this.mobileElement;
    }

    public int getHeight(){

        if (this.webElement != null){
            return this.webElement.getSize().getHeight();
        }
        else {
            return this.mobileElement.getSize().getHeight();
        }

    }

    public int getWidth(){
        if (this.webElement != null) {
            return this.webElement.getSize().getWidth();
        }
        else {
            return this.mobileElement.getSize().getWidth();
        }
    }

    public boolean isVisible(){
        if (this.webElement != null) {
            return this.webElement.isDisplayed();
        }
        else {
            return this.mobileElement.isDisplayed();
        }
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