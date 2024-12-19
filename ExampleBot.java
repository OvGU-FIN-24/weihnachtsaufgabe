import page.codeberg.terratactician_expandoria.bots.*;
import page.codeberg.terratactician_expandoria.world.CubeCoordinate;

public class ExampleBot extends ChallengeBot {

  @Override
  public int getMatrikel() {
    // Bitte gebe deine Matrikelnummer an.
    return 133742;
  }

  @Override
  public String getStudentName() {
    // Bitte gebe deinen Namen an.
    return "Obelix Gallier";
  }

  @Override
  public String getName() {
    // Hier kannst du deinem Bot einen Namen geben.
    return "Hinkelstein Crusher";
  }

  @Override
  public void executeTurn(World world, Controller controller) {
    // Beispiel code, der das erste Tile wiederholt platziert und wieder aufsammelt.
    if (world.getHand().len() < 5) {
      // wenn platz ist wird das erste gefundene Tile aufgesammelt, wenn das noch
      // geht.
      for (var tile : world.getMap()) {
	if (tile.reclaimable()) {
	  controller.takeTile(tile.getCoordinate());
	  System.out.println("take");
	  return;
	}
      }
    } else {
      // Platziert das erste Tile in der Hand an (0,0,0) ohne zu prüfen, ob das eine
      // valide coordinate ist oder die Hand überhaupt Karten beinhaltet.
      // siehe `world.getHand().len()`, `world.getBuildArea().contains(coord)` und
      // `world.getMap().at(coord)` um zu prüfen ob das Feld noch frei ist.
      controller.placeTile(world.getHand().get(0), new CubeCoordinate());
    }
  }
}
