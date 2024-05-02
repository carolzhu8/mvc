package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import model.IModel;
import view.IView;
import view.graphical.GraphicalView;
import view.graphical.IGraphicalView;
import view.web.IWeb;

/**
 * this is a controller class.
 */
public class Controller implements ActionListener, IController {
  private IView view;
  private IModel model;

  /**
   * this is a controller class.
   * @param view this is view.
   * @param model this is model.
   */
  public Controller(IView view, IModel model) {
    this.view = view;
    this.model = model;
  }

  /**
   * this is when you perform an action.
   * @param e the event to be processed.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    IGraphicalView graphicalView = (GraphicalView) view;
    String command = e.getActionCommand();
    if (command.equals("Pre")) {
      graphicalView.pre();
    } else if (command.equals("Select")) {
      graphicalView.select();
    } else if (command.equals("Next")) {
      graphicalView.next();
    } else if (command.equals("Quit")) {
      graphicalView.quit();
    }
  }

  /**
   * this is run function.
   * @param args command.
   */
  @Override
  public void run(String[] args) {
    if (this.model == null || this.view == null) {
      return;
    }

    // init data in model based on input file
    String inputFileName = getInputFileName(args);
    if (inputFileName == null) {
      return;
    }
    processInputFile(inputFileName);


    // get view mode
    String viewMode = getViewMode(args);
    if (viewMode == null) {
      return;
    }

    // run controller based on view mode
    if (viewMode.equalsIgnoreCase("Graphical")) {
      runInGraphicalMode(args);
    }
    if (viewMode.equalsIgnoreCase("Web")) {
      runInWebMode(args);
    }
  }


  /**
   * this is to run graphical mode.
   * @param args command.
   */
  private void runInGraphicalMode(String[] args){
    IGraphicalView graphicalView = (IGraphicalView) view;
    graphicalView.load(model.getAllSnapshots());

    // get size parameter
    int[] size = getGraphicalViewSize(args);
    if (size[0] != -1 && size[1] != -1) {
      graphicalView.setFrameSize(size[0], size[1]);
    }

    graphicalView.setActionListener(this);
    graphicalView.display();
  }


  /**
   * this is to run web mode.
   * @param args command.
   */
  private void runInWebMode(String[] args){
    IWeb webView = (IWeb) view;
    webView.load(model.getAllSnapshots());

    // get output file name
    String outputFile = getOutputFileName(args);
    if (outputFile == null){
      return;
    }

    webView.outputTo(outputFile);
    webView.display();
  }

  /**
   * this is to get the input file name from command.
   * @param args command.
   * @return  file name.
   */
  private String getInputFileName(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-in")) {
        return args[i + 1];
      }
    }
    return null;
  }

  /**
   * this is to get view mode name from args.
   * @param args command.
   * @return view mode name. whether it is graphical or it is web.
   */
  private String getViewMode(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-v")
              || args[i].equalsIgnoreCase("-view")) {
        return args[i + 1];
      }
    }
    return null;
  }

  /**
   * this is to get graphical view size parameter.
   * @param args command.
   * @return graphical view size.
   */
  private int[] getGraphicalViewSize(String[] args) {
    int[] result = {-1, -1};
    for (int i = 0; i < args.length; i++) {
      try {
        result[0] = Integer.parseInt(args[i]);
        result[1] = Integer.parseInt(args[i + 1]);
        return result;
      } catch (NumberFormatException e) {
        continue;
      }
    }
    return result;
  }

  /**
   * this is to get output file name from command.
   * @param args command.
   * @return output file name.
   */
  private String getOutputFileName(String[] args){
    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-out")) {
        return args[i + 1];
      }
    }
    return null;
  }

  /**
   * this is to process input file.
   * @param inputFileName string.
   */
  private void processInputFile(String inputFileName) {
    Scanner scanner = null;
    try {
      scanner = new Scanner(new File(inputFileName));
    } catch (FileNotFoundException e) {
      return;
    }

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      processSingleLine(line);
    }
  }

  /**
   * this is to process single line in the file.
   * @param line  String.
   */
  private void processSingleLine(String line) {
    if (line.isEmpty()) {
      return;
    }
    String[] words = line.trim().split(" ");
    String command = words[0].toUpperCase();
    switch (command) {
      case "#":
        break;
      case "SHAPE":
        createShape(words);
        break;
      case "MOVE":
        moveShape(words);
        break;
      case "RESIZE":
        resizeShape(words);
        break;
      case "COLOR":
        recolorShape(words);
        break;
      case "REMOVE":
        removeShape(words);
        break;
      case "SNAPSHOT":
        makeSnapshot(words);
        break;
    }
  }

  /**
   * this is to create shape from the command.
   * @param commandWords command from the txt.
   */
  private void createShape(String[] commandWords) {
    String typeName = commandWords[2];
    String name = commandWords[1];
    double x = Double.parseDouble(commandWords[3]);
    double y = Double.parseDouble(commandWords[4]);
    double firstDimension = Double.parseDouble(commandWords[5]);
    double secondDimension = Double.parseDouble(commandWords[6]);
    double red = Double.parseDouble(commandWords[7]);
    double green = Double.parseDouble(commandWords[8]);
    double blue = Double.parseDouble(commandWords[9]);
    model.create(typeName, name, x, y, firstDimension, secondDimension, red, green, blue);
  }

  /**
   * this is to move the shape.
   * @param commandWords command word.
   */
  private void moveShape(String[] commandWords) {
    String name = commandWords[1];
    double x = Double.parseDouble(commandWords[2]);
    double y = Double.parseDouble(commandWords[3]);
    model.move(name, x, y);
  }

  /**
   * this is to resize the shape.
   * @param commandWords command word.
   */
  private void resizeShape(String[] commandWords) {
    String name = commandWords[1];
    double firstDimension = Double.parseDouble(commandWords[2]);
    double secondDimension = Double.parseDouble(commandWords[3]);
    model.resize(name, firstDimension, secondDimension);
  }

  /**
   * this is to recolor the shape.
   * @param commandWords command word.
   */
  private void recolorShape(String[] commandWords) {
    String name = commandWords[1];
    double red = Double.parseDouble(commandWords[2]);
    double green = Double.parseDouble(commandWords[3]);
    double blue = Double.parseDouble(commandWords[4]);
    model.setColor(name, red, green, blue);
  }

  /**
   * this is to remove the shape.
   * @param commandWords command word.
   */
  private void removeShape(String[] commandWords) {
    String name = commandWords[1];
    model.delete(name);
  }

  /**
   * this is to make snapshot.
   * @param commandWords command word.
   */
  private void makeSnapshot(String[] commandWords) {
    String description = null;
    if (commandWords.length == 1) {
      description = "";
    } else {
      String[] descriptionArray = Arrays.copyOfRange(commandWords,1,commandWords.length);
      description = String.join(" ", descriptionArray);
    }
    model.makeSnapshot(description);
  }
}
