[![](https://jitpack.io/v/sethijatin/creative-element.svg)](https://jitpack.io/#sethijatin/creative-element) [![BrowserStack Status](https://www.browserstack.com/automate/badge.svg?badge_key=<badge_key>)](https://www.browserstack.com/automate/public-build/<badge_key>)

# Project For Facilitating Page Layout Testing For Websites
The project aims to provide a simple light weight object (Creative Element) to compare the layout of one Web Element with respect to the Other.

The relation between web elements (two web elements) is expressed in the following terms:
* On
* Near
* Inside
* Aligned

The project is inspired by Galen Framework and has been produced so that relevant functions can be utilized by other frameworks.

### Usage

#### Including It In Your Project POM:

```java
<repositories>
     <repository>
	<id>jitpack.io</id>
	<url>https://jitpack.io</url>
     </repository>
</repositories>

<dependency>
    <groupId>com.github.sethijatin</groupId>
    <artifactId>creative-element</artifactId>
    <version>1.1</version>
    <scope>test</scope>
</dependency>
```

#### Creating a Creative Element:

Creative Element is created using a WebElement. 
```java
CreativeElment element = new creative.layout.CreativeElement(driver.findElement(By.cssSelector(...)));
```

Creative Element also returns back the Selenium WebElement so as the tester can continue with their regular selenium operations

```java
WebElement element = creativeElement.getElement();
```

Relation between one Creative Element with respect to other can be asserted in the following way:
```java
CreativeElment elementOne = new CreativeElement(driver.findElement(By.cssSelector(...)));
CreativeElment elementTwo = new CreativeElement(driver.findElement(By.cssSelector(...)));
Assert.assertTrue(elementOne.isInside().isInside(elementTwo));
```

#### Near

Near is used to evaluate that a WebElement is not on, or inside another WebElement. Relevant functions for near are:

* On Top Of => isNear().onTopOf(...)
* On Bottom Of => isNear().onBottomOf(...)
* Is Near => isNear().isNear(...)
* On Right Of => isNear().onRightOf(...)
* On Left Of => isNear().onLeftOf(...)

```java
//Is creative.layout.Near
//Returns true in case the WebElement is neither inside other WebElement, nor on the other WebElement
elementOne.isNear().isNear(elementTwo);

//creative.layout.On Top Of
//Returns true in case the WebElement is near and on right of other WebElement
elementOne.isNear().onRightOf(elementTwo);

//creative.layout.On Top Of
//Returns true in case the WebElement is near other WebElement, and the distance between the Top Edge of Element 1, and Top Edge of
//Element 2 is exactly 16 pixels (calculated using integers)
elementOne.isInside().isInside(elementTwo, creative.layout.Direction.Top, 16);

//creative.layout.On Top Of
//Returns true in case the WebElement is near other WebElement, and the distance between the Top Edge of Element 1, and Top Edge of
//Element 2 is between 16 - 20 pixels (calculated using integers)
elementOne.isInside().isInside(elementTwo, creative.layout.Direction.Top, 16, 20);
```

#### On:

On is used to evaluate if a WebElement overlaps the other WebElement. If the respective edges or even points of 2 WebElements will overlap each other they are considered overlapping.

```java
//Overlaps
//Returns true in case the WebElement overlaps the other WebElement
elementOne.on().overlaps(elementTwo);

//Get Distance
//Returns the distance (integer) between Top edge of ElementOne and Top Edge of ElementTwo
elementOne.on().getDistance(elementTwo, creative.layout.Direction.TOP);
```

#### Inside

Inside is used to evaluate if a WebElement is inside other WebElement. Completely inside no edges or points overlap.


```java
//Is Inside

//Returns true in case the WebElement is inside other WebElement
elementOne.isInside().isInside(elementTwo); //Simple check

//Returns true in case the WebElement is inside other WebElement, and the distance between the Top Edge of Element 1, and Top Edge of
//Element 2 is exactly 16 pixels (calculated using integers)
elementOne.isInside().isInside(elementTwo, creative.layout.Direction.Top, 16);

//Returns true in case the WebElement is inside other WebElement, and the distance between the Top Edge of Element 1, and Top Edge of
//Element 2 is between 16 - 20 pixels (calculated using integers)
elementOne.isInside().isInside(elementTwo, creative.layout.Direction.Top, 16, 20);

```

#### Aligned

Aligned evaluates if the two WebElemnts are aligned. creative.layout.Aligned is validated on the edges, or inside another Web Element. Functions:

* Top => isAligned().top(...); 
* Bottom => isAligned().bottom(...); 
* Left => isAligned().left(...); 
* Right => isAligned().right(...); 

```java
//creative.layout.Inside Top
//Returns true in case the WebElement 1 is top aligned with WebElement 2
elementOne.isAligned().top(elementTwo);
```


#### Aligned & Inside

It is possible for the WebElements to be inside another webaligned and still be aligned. The following functions can be used to validate the same:

* Inside Centrally => isAligned().insideCentrally(...);
* Inside Horizontally => isAligned().insideHorizontally(...);
* Inside Vertically => isAligned().insideVertically(...);


```java
//Returns true if element one is inside element two and are aligned right in the center (vertically & horizontally).
elementOne.isAligned().insideCentrally(elementTwo);
```

# Browserstack is helping us getting better: 

![BrowserStack](https://p14.zdusercontent.com/attachment/1015988/hxDtNi8gxI27nLO5m43ndVg9N?token=eyJhbGciOiJkaXIiLCJlbmMiOiJBMTI4Q0JDLUhTMjU2In0..ot6K_8FSCBR-oYA2iznsqQ.VStaRsy4BeXxR5LrcUDVZFCQN0226yJK_bkaevuOBLhi78I8jN9FcVRtip7yLpHucBKIlzeChpm9cYpRn5MBRhRunqrzUIu_uh5tfxAcZhIm5eP334OLdqm_H1oqa4V59r284kj0o5rMrRrK_ECz689ovD0HDqM5ms-Z8OgehavA7nh3rAirhbv0lM4AuHdJytyvYTZXN9D0grOb-BtFnMi7Ksm0T8_vKOcokYfBrMafL1N_hyu22Zzoq9Uj2Plfhw3fXyxKVaq7F7nB3NANPQwxh3p3Ntcn7uSqAeRfgBw.5CsEbEljNlc1SmVVlV3r0A)

Browser Stack is helping me extend the API by providing their state of the art infrastructure to test this API across platforms! Together we shall make the layout testing easy!
