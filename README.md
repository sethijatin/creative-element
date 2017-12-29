# Project For Facilitating Page Layout Testing For Websites
The project aims to provide a simple light weight object (Creative Element) to compare the layout of one Web Element with respect to the Other.

The relation between web elements (two web elements) is expressed in the following terms:
* creative.layout.On
* creative.layout.Near
* creative.layout.Inside
* creative.layout.Aligned

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
CreativeElment elementOne = new creative.layout.CreativeElement(driver.findElement(By.cssSelector(...)));
CreativeElment elementTwo = new creative.layout.CreativeElement(driver.findElement(By.cssSelector(...)));
Assert.assertTrue(elementOne.isInside().isInside(elementTwo));
```

#### creative.layout.On:

creative.layout.On is used to evaluate if a WebElement overlaps the other WebElement. If the respective edges or even points of 2 WebElements will overlap each other they are considered overlapping.

```java
//Overlaps
//Returns true in case the WebElement overlaps the other WebElement
elementOne.on().overlaps(elementTwo);

//Get Distance
//Returns the distance (integer) between Top edge of ElementOne and Top Edge of ElementTwo
elementOne.on().getDistance(elementTwo, creative.layout.Direction.TOP);
```

#### creative.layout.Inside

creative.layout.Inside is used to evaluate if a WebElement is inside other WebElement. Completely inside no edges or points overlap.

```java
//Is creative.layout.Inside

//Returns true in case the WebElement is inside other WebElement
elementOne.isInside().isInside(elementTwo); //Simple check

//Returns true in case the WebElement is inside other WebElement, and the distance between the Top Edge of Element 1, and Top Edge of
//Element 2 is exactly 16 pixels (calculated using integers)
elementOne.isInside().isInside(elementTwo, creative.layout.Direction.Top, 16);

//Returns true in case the WebElement is inside other WebElement, and the distance between the Top Edge of Element 1, and Top Edge of
//Element 2 is between 16 - 20 pixels (calculated using integers)
elementOne.isInside().isInside(elementTwo, creative.layout.Direction.Top, 16, 20);

```

#### creative.layout.Near

creative.layout.Near is used to evaluate that a WebElement is not on, or inside another WebElement. Relevant functions for near are:
* creative.layout.On Top Of => isNear().onTopOf(...)
* creative.layout.On Bottom Of => isNear().onBottomOf(...)
* Is creative.layout.Near => isNear().isNear(...)
* creative.layout.On Right Of => isNear().onRightOf(...)
* creative.layout.On Left Of => isNear().onLeftOf(...)

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

#### creative.layout.Aligned

creative.layout.Aligned evaluates if the two WebElemnts are aligned. creative.layout.Aligned is validated on the edges, or inside another Web Element. Functions:
* Top => isAligned().top(...); 
* Bottom => isAligned().bottom(...); 
* Left => isAligned().left(...); 
* Right => isAligned().right(...); 
* creative.layout.Inside Centrally => isAligned().insideCentrally(...);
* creative.layout.Inside Horizontally => isAligned().insideHorizontally(...);
* creative.layout.Inside Vertically => isAligned().insideVertically(...);

```java
//creative.layout.Inside Top
//Returns true in case the WebElement 1 is top aligned with WebElement 2
elementOne.isAligned().top(elementTwo);
```
