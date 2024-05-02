package view.Reader;

import java.util.List;

import view.snapshot.ISnapshot;

/**
 * this is IReader interface.
 */
public interface IReader {
  /**
   * this is read function.
   * @param content String.
   * @return a list.
   */
  public List<ISnapshot> read(String content);
}
