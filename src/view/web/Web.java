package view.web;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import view.Reader.Reader;
import view.snapshot.ISnapshot;

/**
 * this is web class.
 */
public class Web implements IWeb {

  private List<ISnapshot> snapshotList;
  private String outputFileName;

  /**
   * this is constructor.
   */
  public Web() {
    this.snapshotList = new ArrayList<>();
  }

  /**
   * this is load function.
   * @param dataFromModel String.
   */
  @Override
  public void load(String dataFromModel) {
    Reader reader = new Reader();
    this.snapshotList = reader.read(dataFromModel);
  }

  /**
   * this is display function.
   */
  @Override
  public void display() {
    if (outputFileName == null) {
      return;
    }
    try {
      FileWriter fw = new FileWriter(new File(this.outputFileName));
      fw.write("<!DOCTYPE html>\n"
              + "<html lang=\"en\">\n"
              + "<head>\n"
              + "<meta charset=\"UTF-8\">\n"
              + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
              + "<title>Photo Album Web View</title>\n"
              + "</head>\n"
              + "<body>");

      for (ISnapshot snapshot : snapshotList) {
        snapshot.webDisplay(fw);
      }

      fw.write("</body>\n"
              + "</html>");
      fw.close();
    } catch (IOException e) {
      return;
    }
  }

  /**
   * this is to name output file function.
   * @param fileName String.
   */
  @Override
  public void outputTo(String fileName) {
    this.outputFileName = fileName;
  }
}
