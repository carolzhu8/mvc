package model;

import java.util.List;

/**
 * this is IModel interface.
 */
public interface IModel {
  /**
   * this is to see if shape is created successfully and control will be able to see.
   * @param type String.
   * @param name String.
   * @param x double.
   * @param y double.
   * @param firstDimension double.
   * @param secondDimension double.
   * @param red double.
   * @param green double.
   * @param blue double.
   * @return true or false.
   */
  public boolean create(String type, String name, double x, double y, double firstDimension,
                     double secondDimension, double red, double green, double blue);

  /**
   * this is to see if it got moved successfully.
   * @param name String.
   * @param x double.
   * @param y double.
   * @return true or false.
   */
  public boolean move(String name, double x, double y);

  /**
   * this is to see if it got resized successfully.
   * @param name String.
   * @param firstDimension double.
   * @param secondDimension double.
   * @return true or false.
   */
  public boolean resize(String name, double firstDimension, double secondDimension);

  /**
   * this is to check if it contains or not.
   * @param name String.
   * @return true or false.
   */
  public boolean ifContains(String name);

  /**
   * this is to see if it got successfully deleted or not.
   * @param name String.
   * @return true or false.
   */
  public boolean delete(String name);

  /**
   * this is to make snapshot.
   * @param description String.
   */
  public void makeSnapshot(String description);

  /**
   * this is to get all the snapshots.
   * @return String.
   */
  public String getAllSnapshots();

  /**
   * this is to get snapshot ID list,
   * @return String,
   */
  public List<String> getSnapshotsIDList();

  /**
   * this is to get log.
   * @return String.
   */
  public String getLog();

  /**
   * this is to see if color got set successfully.
   * @param name String.
   * @param red double.
   * @param green double.
   * @param blue double.
   * @return true or false.
   */
  public boolean setColor(String name, double red, double green, double blue);
}
