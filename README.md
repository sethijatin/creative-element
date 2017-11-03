# Project For Facilitating Page Layout Testing For Websites
The project aims to provide a simple light weight object (Creative Element) to compare the layout of one Web Element with respect to the Other.

The relation between web elements (two web elements) is expressed in the following terms:
* On
* Near
* Inside
* Aligned

The project is inspired by Galen Framework and has been produced so that relevant functions can be utilized by other frameworks.

### Usage

#### Creating a Creative Element:

Creative Element is created using a WebElement. 
```java
CreativeElment element = new CreativeElement(driver.findElement(By.cssSelector(...)));
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

#### On:

On is used to evaluate if a WebElement overlaps the other WebElement. If the respective edges or even points of 2 WebElements will overlap each other they are considered overlapping.

```java
//Overlaps
//Returns true in case the WebElement overlaps the other WebElement
elementOne.on().overlaps(elementTwo);

//Get Distance
//Returns the distance (integer) between Top edge of ElementOne and Top Edge of ElementTwo
elementOne.on().getDistance(elementTwo, Direction.TOP); 
```

#### Inside

Inside is used to evaluate if a WebElement is inside other WebElement. Completely inside no edges or points overlap.

```java
//Is Inside

//Returns true in case the WebElement is inside other WebElement
elementOne.isInside().isInside(elementTwo); //Simple check

//Returns true in case the WebElement is inside other WebElement, and the distance between the Top Edge of Element 1, and Top Edge of
//Element 2 is exactly 16 pixels (calculated using integers)
elementOne.isInside().isInside(elementTwo, Direction.Top, 16); 

//Returns true in case the WebElement is inside other WebElement, and the distance between the Top Edge of Element 1, and Top Edge of
//Element 2 is between 16 - 20 pixels (calculated using integers)
elementOne.isInside().isInside(elementTwo, Direction.Top, 16, 20); 

```

#### Near

Near is used to evaluate that a WebElement is not on, or inside another WebElement. Relevant functions for near are:
* On Top Of => isNear().onTopOf(...)
* On Bottom Of => isNear().onBottomOf(...)
* Is Near => isNear().isNear(...) 
* On Right Of => isNear().onRightOf(...)
* On Left Of => isNear().onLeftOf(...)

```java
//Is Near
//Returns true in case the WebElement is neither inside other WebElement, nor on the other WebElement
elementOne.isNear().isNear(elementTwo);

//On Top Of
//Returns true in case the WebElement is near and on right of other WebElement
elementOne.isNear().onRightOf(elementTwo);

//On Top Of
//Returns true in case the WebElement is near other WebElement, and the distance between the Top Edge of Element 1, and Top Edge of
//Element 2 is exactly 16 pixels (calculated using integers)
elementOne.isInside().isInside(elementTwo, Direction.Top, 16); 

//On Top Of
//Returns true in case the WebElement is near other WebElement, and the distance between the Top Edge of Element 1, and Top Edge of
//Element 2 is between 16 - 20 pixels (calculated using integers)
elementOne.isInside().isInside(elementTwo, Direction.Top, 16, 20);
```

#### Aligned

Aligned evaluates if the two WebElemnts are aligned. Aligned is validated on the edges, or inside another Web Element. Functions:
* Top => isAligned().top(...); 
* Bottom => isAligned().bottom(...); 
* Left => isAligned().left(...); 
* Right => isAligned().right(...); 
* Inside Centrally => isAligned().insideCentrally(...); 
* Inside Horizontally => isAligned().insideHorizontally(...); 
* Inside Vertically => isAligned().insideVertically(...); 

```java
//Inside Centrally
//Returns true in case the WebElement 1 is top aligned with WebElement 2
elementOne.isAligned().top(elementTwo);
```
