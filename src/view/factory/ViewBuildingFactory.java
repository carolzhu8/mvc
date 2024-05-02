package view.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import view.IView;
import view.graphical.GraphicalView;
import view.web.Web;


/**
 * this is a factory to build view.
 */
public class ViewBuildingFactory implements IViewFactory{
  private Map<String, Supplier> views;

  /**
   * this is default constructor.
   */
  public ViewBuildingFactory() {
    views = new HashMap<>();
    views.put("GRAPHICAL", GraphicalView::new);
    views.put("WEB", Web::new);
  }

  /**
   * this is create function.
   * @param args command.
   * @return view.
   */
  @Override
  public IView create(String[] args) {
    String viewName = getViewName(args);
    if (viewName == null){
      return null;
    }
    Supplier constructor = views.get(viewName.toUpperCase());
    return (IView) constructor.get();
  }

  /**
   * this is to get view name from args.
   * @param args command.
   * @return view name.
   */
  private String getViewName(String[] args){
    for (int i = 0; i < args.length; i++) {
      if (args[i].equalsIgnoreCase("-v")
              || args[i].equalsIgnoreCase("-view")) {
        return args[i + 1];
      }
    }
    return null;
  }
}
