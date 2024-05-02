import java.sql.SQLOutput;
import java.util.List;

import model.Model;
import view.Reader.Reader;
import view.graphical.GraphicalView;
import view.snapshot.ISnapshot;

public class test {
    public static void main(String[] args) {
        Model model = new Model();
        model.create("Oval", "my oval", 100,100,50,50,255,0,0);
        model.makeSnapshot("first snapshot");
        model.create("Rectangle", "my rect", 100,100,50,50,0,0,0);
        model.makeSnapshot("second snapshot");
        String allSnapshots = model.getAllSnapshots();
        String[] split = allSnapshots.split("(Snapshot ID:)");
        System.out.println(allSnapshots);
//    Reader reader = new Reader();
//    List<ISnapshot> read = reader.read(allSnapshots);
//    for (ISnapshot snapshot : read) {
//      System.out.println(snapshot.getId());
//      System.out.println(snapshot.getDescription());
//    }

        GraphicalView graphicalView = new GraphicalView();
        graphicalView.load(allSnapshots);
        graphicalView.display();

    }
}
