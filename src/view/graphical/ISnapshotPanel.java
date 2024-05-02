package view.graphical;

import view.snapshot.ISnapshot;

/**
 * this is snapshot panel interface.
 */
public interface ISnapshotPanel {
  /**
   * this is to set the panel content.
   * @param snapshot ISnapshot.
   */
  public void setPanelContent(ISnapshot snapshot);
}
