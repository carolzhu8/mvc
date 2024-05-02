import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.IModel;
import model.Model;

/**
 * this is a test class.
 */
public class ModelTest {
    IModel model;

    /**
     * this is to set up before test.
     */
    @BeforeEach
    public void before() {
        model = new Model();
    }

    /**
     * this is to test if shape was created successfully.
     */
    @Test
    public void testCreate() {
        assertTrue(model.create("Rectangle", "first", 100, 0, 90, 90, 0,125,80));
        assertTrue(model.ifContains("first"));

        assertTrue(model.create("Oval", "second", 0, 50, 80, 50, 70,60,50));
        assertTrue(model.ifContains("second"));
    }

    /**
     * this is to test if shape was deleted successfully.
     */
    @Test
    public void testDelete() {
        assertTrue(model.create("Oval", "third", 99, 50, 80, 50, 70,60,50));
        assertTrue(model.delete("third"));
        assertFalse(model.ifContains("third"));
    }

    /**
     * this is to test move function.
     */
    @Test
    public void testMove() {
        assertTrue(model.create("Oval", "move", 65, 50, 80, 50, 70,60,50));
        assertTrue(model.move("move", 100, 200));
    }

    /**
     * this is to test resize function.
     */
    @Test
    public void testResize() {
        assertTrue(model.create("Oval", "resize", 49, 50, 80, 50, 70,60,50));
        assertTrue(model.resize("resize", 150, 100));
    }
    /**
     * this is to test if the shape is contained.
     */
    @Test
    public void testIfContains() {
        assertTrue(model.create("Oval", "contain", 90, 50, 80, 50, 70,60,50));
        assertTrue(model.ifContains("contain"));
        assertFalse(model.ifContains("wrong"));
    }

    /**
     * this is to test if snapshot was made successfully.
     */
    @Test
    public void testMakeSnapshot() {
        model.makeSnapshot("firstSnap");
    }
    /**
     * this is to test if color was set.
     */
    @Test
    public void testSetColor() {
        assertTrue(model.create("Oval", "setColor", 95, 50, 80, 50, 70,60,50));
        assertTrue(model.setColor("setColor", 0, 0, 0));
    }
    /**
     * this is to test get all snapshots.
     */
    @Test
    public void testGetAllSnapshotsAndLog() {
        model.create("oval", "my oval", 5,5,5,5,0,0,0);
        model.makeSnapshot("My first snapshot");
        model.create("rectangle", "my rect", 5,5,5,5,0,0,0);
        model.makeSnapshot("My second snapshot");
        System.out.println(model.getAllSnapshots());
        System.out.println(model.getLog());
    }

}
