package tests;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.DragAndDropPage;

public class DragAndDropTest extends  TestBase {
    DragAndDropPage dragAndDropPage;
    String url = "https://demoqa.com/droppable";

    @BeforeMethod
    public void openUrl(){
        driver.get(url);
    }
    @Test
    public void DragAndDropTest(){
        dragAndDropPage = new DragAndDropPage(driver);
        Point startLoc = dragAndDropPage.getLoc(dragAndDropPage.draggable);
        dragAndDropPage.dragAndDrop(dragAndDropPage.draggable, dragAndDropPage.droppable);
        String actualText = dragAndDropPage.getElementText(dragAndDropPage.droppable);
        Point finishLoc = dragAndDropPage.getLoc(dragAndDropPage.draggable);
        Point droppableLoc = dragAndDropPage.getLoc(dragAndDropPage.droppable);
        Assert.assertEquals(actualText, "Dropped!");
        Assert.assertNotEquals(startLoc, finishLoc);
    }
@Test
    public void reverDDTest(){
    dragAndDropPage = new DragAndDropPage(driver);
    dragAndDropPage.clickTo(dragAndDropPage.revertDraggableTab);
    Point startLoc = dragAndDropPage.getLoc(dragAndDropPage.revertable);
    dragAndDropPage.dragAndDrop(dragAndDropPage.revertable,
            dragAndDropPage.revertableDropContainer);
    dragAndDropPage.waitRevert();
    Point finishLoc = dragAndDropPage.getLoc(dragAndDropPage.revertable);
    Assert.assertEquals(startLoc, finishLoc);
        }
        @Test
    public void notRevertDDTest(){
    dragAndDropPage = new DragAndDropPage(driver);
    dragAndDropPage.click(dragAndDropPage.revertDraggableTab);
    Point startLoc = dragAndDropPage.getLoc(dragAndDropPage.notReverttable);
    dragAndDropPage.dragAndDrop(dragAndDropPage.notReverttable, dragAndDropPage.revertableDropContainer);
    Point finishLoc = dragAndDropPage.getLoc(dragAndDropPage.notReverttable);
    String attr = dragAndDropPage.getAttr();
   // dragAndDropPage.dragAndDropLoc(dragAndDropPage.notReverttable, startLoc.getX(),startLoc.getY());
     dragAndDropPage.dragAndDrop(dragAndDropPage.notReverttable, dragAndDropPage.revertable);
    dragAndDropPage.waitNotRevert(attr);
    Point secondFinishLoc = dragAndDropPage.getLoc(dragAndDropPage.notReverttable);
    Assert.assertEquals(finishLoc, secondFinishLoc);
        }
}
