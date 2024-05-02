package view.graphical;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import view.Reader.Reader;
import view.snapshot.ISnapshot;

/**
 * this is graphical view class.
 */
public class GraphicalView extends JFrame implements IGraphicalView{
  private IConsolePanel consolePanel;
  private ISnapshotPanel snapshotPanel;

  private List<ISnapshot> snapshotList;
  private int currSnapshot;

  private int frameWidth;
  private int frameHeight;
  private static final int DEFAULT_WIDTH = 1000;
  private static final int DEFAULT_HEIGHT = 1000;

  /**
   * this is a default constructor.
   */
  public GraphicalView() {
    super("Photo Album");

    this.frameWidth = DEFAULT_WIDTH;
    this.frameHeight = DEFAULT_HEIGHT;

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    consolePanel = new ConsolePanel();
    snapshotPanel = new SnapshotPanel();
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setViewportView((JPanel) snapshotPanel);

    this.setLayout(new BorderLayout());
    this.add((JPanel) consolePanel, BorderLayout.SOUTH);
    this.add(scrollPane, BorderLayout.CENTER);
  }

  /**
   * this is to set the frame size.
   * @param width
   * @param height
   */
  @Override
  public void setFrameSize(int width, int height) {
    this.frameWidth = width;
    this.frameHeight = height;
  }

  /**
   * this is to set action listener.
   * @param listener Actionlistener.
   */
  @Override
  public void setActionListener(ActionListener listener) {
    this.consolePanel.setActionListener(listener);
  }

  /**
   * this is pre button.
   */
  @Override
  public void pre() {
    if(currSnapshot == 0){
      showMessage("Can not move previous");
      return;
    }
    currSnapshot--;
    updateSnapshot();
  }

  /**
   * this is next button.
   */
  @Override
  public void next() {
    if(currSnapshot == snapshotList.size()-1){
      showMessage("Can not move next");
      return;
    }
    currSnapshot++;
    updateSnapshot();
  }

  /**
   * this is select button.
   */
  @Override
  public void select() {
    String[] names = new String[snapshotList.size()];
    for (int i = 0; i < snapshotList.size(); i++) {
      names[i] = snapshotList.get(i).getId();
    }


    Object o = JOptionPane.showInputDialog(null, "Select a snapshot", "Selection", JOptionPane.QUESTION_MESSAGE, null, names, names[0]);
    String name = (String) o;
    if (name == null){
      return;
    }
    moveTo(name);
  }

  /**
   * this is to quit.
   */
  @Override
  public void quit() {
    System.exit(0);
  }

  /**
   * this is to load the snapshot.
   * @param dataFromModel String.
   */
  @Override
  public void load(String dataFromModel) {
    Reader reader = new Reader();
    this.snapshotList = reader.read(dataFromModel);
    currSnapshot = 0;
  }

  /**
   * this is to display snapshot.
   */
  @Override
  public void display() {
    this.setSize(this.frameWidth,this.frameHeight);
    updateSnapshot();
    this.setVisible(true);
  }

  /**
   * this is to update snapshot.
   */
  private void updateSnapshot(){
    this.snapshotPanel.setPanelContent(snapshotList.get(currSnapshot));
    this.consolePanel.setId(snapshotList.get(currSnapshot).getId());
    this.consolePanel.setDescription(snapshotList.get(currSnapshot).getDescription());
    repaint();
  }

  /**
   * this is to show the message.
   * @param message String.
   */
  private void showMessage(String message){
    JOptionPane.showMessageDialog(this, message);
  }

  /**
   * this is move to function.
   * @param snapshotId String.
   */
  private void moveTo(String snapshotId){
    for (int i = 0; i < snapshotList.size(); i++) {
      if(snapshotList.get(i).getId().equals(snapshotId)){
        this.currSnapshot = i;
        updateSnapshot();
        return;
      }
    }
  }
}
