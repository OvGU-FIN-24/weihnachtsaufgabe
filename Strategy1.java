import page.codeberg.terratactician_expandoria.bots.*;
import page.codeberg.terratactician_expandoria.world.*;
import page.codeberg.terratactician_expandoria.world.CubeCoordinate;

public class Strategy1 extends ChallengeBot {

  @Override
  public int getMatrikel() {
    // Bitte gebe deine Matrikelnummer an.
    return 250191;
  }

  @Override
  public String getStudentName() {
    // Bitte gebe deinen Namen an.
    return "Marcel Borbus";
  }

  @Override
  public String getName() {
    // Hier kannst du deinem Bot einen Namen geben.
    return "Hinkelstein Crusher";
  }

  @Override
  public void executeTurn(World world, Controller controller) {
    // Beispiel code, der das erste Tile wiederholt platziert und wieder aufsammelt.
    //   if (world.getHand().len() < 5) {
    //     // wenn platz ist wird das erste gefundene Tile aufgesammelt, wenn das noch
    //     // geht.
    //     for (var tile : world.getMap()) {
    //if (tile.reclaimable()) {
    //  controller.takeTile(tile.getCoordinate());
    //  System.out.println("take");
    //  return;
    //}
    //     }
    //   } else {
    //     // Platziert das erste Tile in der Hand an (0,0,0) ohne zu prüfen, ob das eine
    //     // valide coordinate ist oder die Hand überhaupt Karten beinhaltet.
    //     // siehe `world.getHand().len()`, `world.getBuildArea().contains(coord)` und
    //     // `world.getMap().at(coord)` um zu prüfen ob das Feld noch frei ist.
    //     controller.placeTile(world.getHand().get(0), new CubeCoordinate());
    //   }
    
    // Das wird ein Debug-Bot
    int actionCount = world.getActionCount(); // always 1? 60 actions per round
    BuildArea buildArea = world.getBuildArea();
    Hand hand = world.getHand();
    Map map = world.getMap();
    Metrics redrawCosts = world.getRedrawCosts();
    double redrawTime = world.getRedrawTime(); // first redraw 20s
    Metrics resources = world.getResources();
    Metrics resourceRate = world.getResourcesRate();
    Rewards rewards = world.getRewards();
    int round = world.getRound();
    double roundTime = world.getRoundTime(); // 1 round is always 60s
    Metrics targetResources = world.getTargetResources();

    System.out.printf(""" 
	---------------------------------
	actionCount = %d
	buildArea = %s
	hand = %s
	map = %s
	redrawCosts = %s
	redrawTime = %f
	resources = %s
	resourceRate = %s
	rewards = %s
	round = %d
	roundTime = %f
	targetResources = %s
	---------------------------------
	""",
	actionCount, buildArea, hand, map, redrawCosts,
	redrawTime, resources, resourceRate, rewards, round,
	roundTime, targetResources
	);

    assert actionCount == 1;
  }
}
