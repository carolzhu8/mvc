import javax.swing.*;

import controller.Controller;
import controller.IController;
import model.IModel;
import model.Model;
import view.IView;
import view.factory.IViewFactory;
import view.factory.ViewBuildingFactory;

/**
 * this is entry point.
 */
public class PhotoAlbumMain {

  /**
   * entry point.
   * @param args command.
   */
  public static void main(String[] args) {
    IViewFactory viewFactory = new ViewBuildingFactory();
    IView view = viewFactory.create(args);
    IModel model = new Model();
    IController controller = new Controller(view, model);
    controller.run(args);
  }
}
